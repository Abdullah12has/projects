/*********
   CTIS164 - Template Source Program
----------
STUDENT : Syed Abdullah Hassan
SECTION : 03
HOMEWORK: 03
----------
PROBLEMS: Some positions make it impossible for the computer to hit the ufo. it misses by a few numbers.
----------
ADDITIONAL FEATURES: 3 different background states by pressing d and s. 5 operations are used in the quiz instead of just one. 
Even if you click on the wrong option first,you can click on the other options and it'll tell you if they're right or wrong so
you can still know the right answer, but you do not get the points if you click on the wrong option once.
The laser light aims at the ufo and if you want to kill the ufo with you own hands, you can do that by pressing
spacebar. Even though the computer kills the ufo, you can choose to do it by hand as well. The laser also has a ever-changing colour.

*********/

#ifdef _MSC_VER
#define _CRT_SECURE_NO_WARNINGS
#endif
#include <GL/glut.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <stdarg.h>
#include <time.h>

#define WINDOW_WIDTH  900
#define WINDOW_HEIGHT 600

#define TIMER_PERIOD  10 // Period for the timer.
#define TIMER_ON         1 // 0:disable timer, 1:enable timer
#define DURATION 40
#define D2R 0.0174532

enum color {yellow, blue, red, green};
enum state {normal, hover, click};
typedef struct
{
	int ux;
	int uy;
	bool active;
	int points;
	int r = 255, g = 255, b = 0;
} ufo_t; 

typedef struct
{
	color col = yellow;
	int cx;
	state pointer = normal;
	int num;
	bool tru = false; // the right answer
	int r, g, b;

}ans_t;

typedef struct
{
	int symnum;
	char symch;

}symbol_t;

/* Global Variables for Template File */
bool up = false, down = false, right = false, left = false, animation = false;
int  winWidth, winHeight; // current Window width and height
int unocount = 9;
int ax = -390, ay = -15;
int lx = ax + 101, ly = ay + 10;
int timeCounter = DURATION, clickcount = 0,
gameover = 0, score = 0, pscore = 0,
c = 0, si = 120;
ufo_t ufo;
float angle = 0;
int stateb = 0;

bool stopped = false;

int num1 = 0, num2 = 0;
symbol_t symbol;

//if F10 is pressed
void dispGlobals() {
	printf("Debug mode:\n");
	printf("  LaserX=%d, LaserY=%d\n", lx, ly);
	
		if (ufo.active)
			printf(" Ufo at(%d, %d)\n", ufo.ux, ufo.uy);
	
	printf("End of Debug mode:\n");
}


// to draw circle, center at (x,y)
// radius r
//
void circle(int x, int y, int r)
{
#define PI 3.1415
	float angle;
	glBegin(GL_POLYGON);
	for (int i = 0; i < 100; i++)
	{
		angle = 2 * PI*i / 100;
		glVertex2f(x + r * cos(angle), y + r * sin(angle));
	}
	glEnd();
}

void circle_wire(int x, int y, int r)
{
#define PI 3.1415
	float angle;

	glBegin(GL_LINE_LOOP);
	for (int i = 0; i < 100; i++)
	{
		angle = 2 * PI*i / 100;
		glVertex2f(x + r * cos(angle), y + r * sin(angle));
	}
	glEnd();
}

void print(int x, int y, const char *string, void *font)
{
	int len, i;

	glRasterPos2f(x, y);
	len = (int)strlen(string);
	for (i = 0; i < len; i++)
	{
		glutBitmapCharacter(font, string[i]);
	}
}

// display text with variables.
// vprint(-winWidth / 2 + 10, winHeight / 2 - 20, GLUT_BITMAP_8_BY_13, "ERROR: %d", numClicks);
void vprint(int x, int y, void *font, const char *string, ...)
{
	va_list ap;
	va_start(ap, string);
	char str[1024];
	vsprintf_s(str, string, ap);
	va_end(ap);

	int len, i;
	glRasterPos2f(x, y);
	len = (int)strlen(str);
	for (i = 0; i < len; i++)
	{
		glutBitmapCharacter(font, str[i]);
	}
}

// vprint2(-50, 0, 0.35, "00:%02d", timeCounter);
void vprint2(int x, int y, float size, const char *string, ...) {
	va_list ap;
	va_start(ap, string);
	char str[1024];
	vsprintf_s(str, string, ap);
	va_end(ap);
	glPushMatrix();
	glTranslatef(x, y, 0);
	glScalef(size, size, 1);

	int len, i;
	len = (int)strlen(str);
	for (i = 0; i < len; i++)
	{
		glutStrokeCharacter(GLUT_STROKE_ROMAN, str[i]);
	}
	glPopMatrix();
}

void dstar(int sx, int sy, int siz)
{
	glColor3ub(255, 255, 245);

	glBegin(GL_POLYGON);
	glVertex2f(sx, sy);
	glVertex2f(sx - 5 * siz, sy);
	glVertex2f(sx, sy + 1 * siz);
	glVertex2f(sx - 2.5 * siz, sy + 5 * siz);
	glVertex2f(sx + 1 * siz, sy + 1 * siz);
	glVertex2f(sx + 1 * siz, sy + 5 * siz);
	glVertex2f(sx + 1.5 * siz, sy);
	glVertex2f(sx + 4 * siz, sy + 4 * siz);
	glVertex2f(sx + 1.5 * siz, sy);
	glVertex2f(sx + 5 * siz, sy);
	glVertex2f(sx + 1 * siz, sy - 1 * siz);
	glVertex2f(sx + 2.5 * siz, sy - 2.5 * siz);
	glVertex2f(sx + 1 * siz, sy - 1 * siz);
	glVertex2f(sx + 0.5 * siz, sy - 4 * siz);
	glVertex2f(sx + 0.5 * siz, sy - 0.5 * 3);
	glEnd();
}


void dispUfo(int ux, int uy, int r, int g, int b, int score) //UFO object
{

	glColor3f(0.970, 0.95, 0.89);
	//circle 
	circle(ux + 45, uy + 34, 35);
	//Body
	glColor3ub(r, g, b);
	glBegin(GL_POLYGON);
	glVertex2f(ux, uy); // 1st left bottom
	glVertex2f(ux - 15, uy + 15); // side left bottom
	glVertex2f(ux, uy + 40); // one upper side  2nd vertex
	glVertex2f(ux + 20, uy + 30); // upper down 3rd


	glVertex2f(ux + 80, uy + 30); //5th new
	glVertex2f(ux + 90, uy + 40); //6th indent
	glVertex2f(ux + 105, uy + 15); // side left bottom
	glVertex2f(ux + 90, uy); // 7th bottom
	glEnd();



	//lower thrushters
	glColor3ub(0, 255, 0);
	circle(ux + 11, uy, 10);
	circle(ux + 32, uy, 10);
	circle(ux + 53, uy, 10);
	circle(ux + 75, uy, 10);

	glColor3ub(0, 0, 0);
	circle(ux + 11, uy, 5);
	circle(ux + 32, uy, 5);
	circle(ux + 53, uy, 5);
	circle(ux + 75, uy, 5);


	//Partitions
	glColor3ub(0, 0, 0);
	glBegin(GL_LINES);


	//sides
	glVertex2f(ux + 20, uy + 28);
	glVertex2f(ux + 20, uy + 11);
	glVertex2f(ux + 70, uy + 28);
	glVertex2f(ux + 70, uy + 11);
	glEnd();

	//nmbering
	glColor3ub(0, 0, 0);
	vprint(ux + 43, uy + 12, GLUT_BITMAP_9_BY_15, "%2d", score);

}

void dispattacker(int ux, int uy) //The killer UFO
{

	//laser shooter
	glColor3ub(169, 169, 169);
	glBegin(GL_POLYGON);
	glVertex2f(ux + 90, uy + 15);
	glVertex2f(ux + 125, uy + 15);
	glVertex2f(ux + 125, uy + 5);
	glVertex2f(ux + 90, uy + 5);
	glEnd();

	//circle 
	glColor3f(0.970, 0.95, 0.89);
	circle(ux + 45, uy + 34, 35);
	// scanner
	glColor3f(0.970, 0.95, 0.89);
	circle(ux + 95, uy + 23, 10);


	//Body
	glColor3ub(47, 79, 79);
	glBegin(GL_POLYGON);
	glVertex2f(ux, uy); // 1st left bottom
	glVertex2f(ux - 15, uy + 15); // side left bottom
	glVertex2f(ux, uy + 40); // one upper side  2nd vertex
	glVertex2f(ux + 20, uy + 30); // upper down 3rd


	glVertex2f(ux + 80, uy + 30); //5th new
	glVertex2f(ux + 90, uy + 40); //6th indent
	glVertex2f(ux + 105, uy + 15); // side left bottom
	glVertex2f(ux + 90, uy); // 7th bottom
	glEnd();




	//lower thrushters
	glColor3ub(212, 175, 55);
	circle(ux + 11, uy, 10);
	circle(ux + 32, uy, 10);
	circle(ux + 53, uy, 10);
	circle(ux + 75, uy, 10);

	glColor3ub(0, 0, 0);
	circle(ux + 11, uy, 5);
	circle(ux + 32, uy, 5);
	circle(ux + 53, uy, 5);
	circle(ux + 75, uy, 5);


	//Partitions
	glColor3ub(0, 0, 0);
	glBegin(GL_LINES);


	//sides
	glVertex2f(ux + 20, uy + 28);
	glVertex2f(ux + 20, uy + 11);
	glVertex2f(ux + 70, uy + 28);
	glVertex2f(ux + 70, uy + 11);

	glVertex2f(ux + 120, uy + 15);
	glVertex2f(ux + 120, uy + 5);

	glVertex2f(ux + 115, uy + 15);
	glVertex2f(ux + 115, uy + 5);
	glEnd();




}

void dispLaser(int lx, int ly) //Laser object
{
	int r, g, b;
	srand(time(NULL));
	r = 90 + rand() % 200;
	g = 90 + rand() % 200;
	b = 90 + rand() % 200;

	glColor3ub(r, g, b);

	glBegin(GL_POLYGON);
	glVertex2f(lx - 5, ly);
	glVertex2f(lx + 18, ly);
	glVertex2f(lx + 25, ly + 3);
	glVertex2f(lx + 3, ly + 3);
	glEnd();

}

bool checkIntercept(int x, int y) //check the intercept between laser and ufo
{
	if ((lx >= x && lx <= x + si) && (ly >= y && ly <= y + si)) 
	{
		return true; //if intercept return true 
	}
	else
		return false;
}
double angl = 0;
bool checkaim(int x, int y, int dirX, int dirY)
{
	double qx = -287, qy = 8, C, m;

	m = (dirY - qy) / (dirX - qx);
	C = qy - qx * m;
	
	if ((y <= m * x + C + 30) && (y >= m * x + C - 20) && ( dirX > x-100 ))
	{

		
		return true; //if intercept return true 
	}
	else 
		return false;

}

void resetLaser() {  //reset laser function
	animation = false;
	lx = ax + 101; //initial coordinates of the laser 
	ly = ay + 10;
}

void fillvalues() //fill initial values of all the UFOs
{
	srand(time(NULL));
	for (int i = 0; i < 5; i++)
	{
		ufo.points = 1 + rand() % 10;
		ufo.b = 140 + rand() % 254;
		ufo.r = 150 + rand() % 254;
		ufo.g = 150 + rand() % 254;
		ufo.active = 1;
		ufo.ux = +rand() % WINDOW_WIDTH / 2 - 100;
		ufo.uy = +rand() % 200;
	}
}

void resetufo() //reset ufo if it intercepts  function
{

	ufo.points = 1 + rand() % 10;
	ufo.b = 140 + rand() % 254;
	ufo.r = 150 + rand() % 254;
	ufo.g = 150 + rand() % 254;
	ufo.active = 0;
	ufo.ux = +rand() % WINDOW_WIDTH / 2;
	ufo.uy = +rand() % WINDOW_HEIGHT / 2;

}
// To display onto window using OpenGL commands
//

void background() // background with stars
{
	glClearColor(0, 0, 0, 0);

	glClear(GL_COLOR_BUFFER_BIT);
	int size = 100;
	int distance;
	for (int u = -WINDOW_WIDTH; u < WINDOW_WIDTH; u++)
	{
		srand(time(NULL));
		size = 1 + rand() % 3;
		distance = 10 + rand() % 30;
		dstar(100 + u * 150, 100, size);
		size = 1 + rand() % 3;
		dstar(100 + u * 150 + 50, 200, size);
		size = 1 + rand() % 3;
		dstar(100 + u * 200 + 70, -200, size);
		size = 1 + rand() % 3;
		dstar(100 + u * 200 + 120, -50, size);
	}
}


void drawCloud(int x, int y) {
	glColor3f(1, 1, 1); //white
	circle(0 + x, 0 + y, 30);
	circle(-25 + x, y, 20);
	circle(25 + x, -2 + y, 20);
	circle(21 + x, -19 + y, 10);
}

void daybackground() { //background of day

	glClearColor(0.2, 0.4, 0.6, 0);
	glClear(GL_COLOR_BUFFER_BIT);
	
	//draw 3 clouds
	drawCloud(-250, 180);
	drawCloud(250, 100);
	drawCloud(0, 200);
	glColor3f(0, 0, 0);
	vprint2(-200, -250, 0.1, " press d or s to change background");
}
void citybackground() //the city background 
{
	glClearColor(0.14, 0.083, 0.207, 0);
	glClear(GL_COLOR_BUFFER_BIT);

	// moon
	glColor3f(0.9607, 0.9529, 0.808);
	circle(320, 135, 80);


	glColor3f(0.663, 0.663, 0.663);
	circle(320, 145, 9);
	glColor3f(0.663, 0.663, 0.663);
	circle(360, 160, 7);
	glColor3f(0.663, 0.663, 0.663);
	circle(340, 120, 5);
	// Building
	glColor3f(0.2, 0.278, 0.349);
	glRectf(120, 60, -60, -500);
	glPointSize(20.0);
	int j, i;

	glColor3f(0.9607, 0.9529, 0.808);

	glBegin(GL_POINTS);
	for (i = 15; i > -240; i -= 40)
		for (j = -30; j < 100; j += 40)
			glVertex2f(j, i);

	glEnd();
}

void dispboxes()
{
	glColor3f(0.09, 0.247, 0.373);
	glRectf(-700, 230 , 700, 900);
	glRectf(-700, -250, 700, -900);
}



ans_t box[4];
void fillanswers()
{

	srand(time(NULL));


	num1 = rand() % 10; //random numbers for the question
	num2 = rand() % 10;

	symbol.symnum = rand() % 5;   // random operation
	int ran = rand() % 4; // random box
	for (int i = 0; i < 4; i++) // filling dummy values into all
	{
		box[i].num = rand() % 10; 
		
	}
	box[ran].tru = true;
	if (symbol.symnum == 0)
	{
		symbol.symch = '+';
		box[ran].num = num1 + num2;
	}
	else if (symbol.symnum == 1)
	{
		symbol.symch = '-';
		box[ran].num = num1 - num2;
	}
	else if (symbol.symnum == 2)
	{
		symbol.symch = '*';
		box[ran].num = num1 * num2;
	}
	else if (symbol.symnum == 3)
	{
		symbol.symch = '/';
		box[ran].num = num1 / num2;
	}
	else if (symbol.symnum == 4)
	{
		symbol.symch = '%';
		box[ran].num = num1 % num2;
	}
	for (int i = 0; i < 4; i++) // to check if any random number == to answer
		if (i != ran)
			while(box[i].num == box[ran].num)
				box[i].num = rand() % 10; // change it into another number
	
}

void disp_ans()
{
	box[0].cx = -160; // locations of the answer boxes 
	box[1].cx = -100;
	box[2].cx = -40;
	box[3].cx = 20;

	glPointSize(40.0); // using pixels instead of a shape 
	
	
	
	glBegin(GL_POINTS);
	//1st box
	if (box[0].col == blue) //check colour of each pixel
		glColor3f(0,0,255);
	else if (box[0].col == yellow)
		glColor3f(255, 255, 0);
	else if (box[0].col == green)
		glColor3f(0, 128, 0);
	else if (box[0].col == red)
		glColor3f(128, 0, 0);
	glVertex2f(box[0].cx, 250);
	//2nd box
	if (box[1].col == blue)
		glColor3f(0, 0, 255);
	else if (box[1].col == yellow)
		glColor3f(255, 255, 0);
	else if (box[1].col == green)
		glColor3f(0, 128, 0);
	else if (box[1].col == red)
		glColor3f(128, 0, 0);
	glVertex2f(box[1].cx, 250);
	//3rd box
	if (box[2].col == blue)
		glColor3f(0, 0, 255);
	else if (box[2].col == yellow)
		glColor3f(255, 255, 0);
	else if (box[2].col == green)
		glColor3f(0, 128, 0);
	else if (box[2].col == red)
		glColor3f(128, 0, 0);
	glVertex2f(box[2].cx, 250); 
	//4th box
	if (box[3].col == blue)
		glColor3f(0, 0, 255);
	else if (box[3].col == yellow)
		glColor3f(255, 255, 0);
	else if (box[3].col == green)
		glColor3f(0, 128, 0);
	else if (box[3].col == red)
		glColor3f(128, 0, 0);
	glVertex2f(box[3].cx, 250);

	glEnd();

	glColor3f(1,1,1);
	vprint2(-400, 235, 0.3, "%d %c %d = ", num1, symbol.symch, num2); //question
	glColor3f(0, 0, 0);
	vprint2(box[0].cx-10, 240, 0.15, "%2d ", box[0].num);  // 4 options 
	vprint2(box[1].cx - 10, 240, 0.15, "%2d ", box[1].num);
	vprint2(box[2].cx - 10, 240, 0.15, "%2d ", box[2].num);
	vprint2(box[3].cx - 10, 240, 0.15, "%2d ", box[3].num);
}
void reset() // to reset the ufo and the boxes 
{
	ufo.active = 0;
	resetLaser(); // reset laser
	fillvalues(); // fill values again

	for (int i = 0; i < 4; i++) // change colour back to yellow 
	{
		box[i].tru = false;
		box[i].col = yellow;
		clickcount = 0;
		fillanswers();
		disp_ans();
	}
	 
}

float A = 100,
fq = 1,  //frequency
C = 0,   //horizontal phase shift
B = 0;   //vertical phase shift

float f(float x) {
	return A * sin((fq * x + C) * D2R) + B;
}
int tarx, tary; //target x and target y
int dx, dy; // direction x and y for the guidance of the laser
void drawAngle() {

	glColor3f(1, 0, 0);
	tarx = 900 * cos(angle * D2R) -287;
	tary = 900 * sin(angle * D2R) + 8;
	
	//target laser to locate target 
	glLineWidth(0.2);
	glBegin(GL_LINE_STRIP);
	glVertex2f(-287, 8);
	glVertex2f(tarx, tary);
	glEnd();


}
void laserMovement()
{
	
	
	lx +=  dx * 0.03;
	ly += dy * 0.03;


}

void display() { // main display function 

	daybackground(); //we cannot go back to day! 

	if (stateb == 's') // key preses changes background 
		background();

	else if (stateb == 'd') //other background
		citybackground();

	dispboxes(); 
	glColor3f(1,1,1);
	vprint2(-300, -280, 0.15, "time:  %d", timeCounter); //timer display
	vprint2(-120, -280, 0.15, " player:  %d", pscore); // player score display 
	
	vprint2(120, -280, 0.15, " computer:  %d", score); // computer score display 
	

	disp_ans(); //upper box
	drawAngle();

	
    dispUfo(ufo.ux, ufo.uy , ufo.r, ufo.g, ufo.b, ufo.points); 
	
	dispLaser(lx, ly);
	drawAngle();
	dispattacker(ax, ay);
	vprint(-350, 0, GLUT_BITMAP_8_BY_13, "%0.f", angle); //white angle
	
	

	if (gameover == 1)
		vprint2(-920, 300, 0.9, "GAME OVER"); //print on screen when game is over

	glutSwapBuffers();
}

//
// key function for ASCII charachters like ESC, a,b,c..,A,B,..Z
//
void onKeyDown(unsigned char key, int x, int y)
{
	// exit when ESC is pressed.
	if (key == 27)
		exit(0);

	if (key == ' ') {
		

		dx = tarx + 238;
		dy = tary + 8;
		animation = true;
	}

	if (key == 's') //check keys
		stateb = 's';
	else if (key == 'd')
		stateb = 'd';



	// to refresh the window it calls display() function
	glutPostRedisplay();
}

void onKeyUp(unsigned char key, int x, int y)
{
	// exit when ESC is pressed.
	if (key == 27)
		exit(0);

	// to refresh the window it calls display() function
	glutPostRedisplay();
}

//
// Special Key like GLUT_KEY_F1, F2, F3,...
// Arrow Keys, GLUT_KEY_UP, GLUT_KEY_DOWN, GLUT_KEY_RIGHT, GLUT_KEY_RIGHT
//
void onSpecialKeyDown(int key, int x, int y)
{
	// Write your codes here.
	switch (key) {
	case GLUT_KEY_UP: up = true;
		break;
	case GLUT_KEY_DOWN: down = true;
		break;
	case GLUT_KEY_LEFT: left = true; break;
	case GLUT_KEY_RIGHT: right = true; break;

	case GLUT_KEY_F10:
		stopped = !stopped;
		dispGlobals();
		break;
	}

	// to refresh the window it calls display() function
	glutPostRedisplay();
}

//
// Special Key like GLUT_KEY_F1, F2, F3,...
// Arrow Keys, GLUT_KEY_UP, GLUT_KEY_DOWN, GLUT_KEY_RIGHT, GLUT_KEY_RIGHT
//
void onSpecialKeyUp(int key, int x, int y)
{
	// Write your codes here.
	switch (key) {
	case GLUT_KEY_UP: up = false; break;
	case GLUT_KEY_DOWN: down = false; break;
	case GLUT_KEY_LEFT: left = false; break;
	case GLUT_KEY_RIGHT: right = false; break;
	}

	// to refresh the window it calls display() function
	glutPostRedisplay();
}

//
// When a click occurs in the window,
// It provides which button
// buttons : GLUT_LEFT_BUTTON , GLUT_RIGHT_BUTTON
// states  : GLUT_UP , GLUT_DOWN
// x, y is the coordinate of the point that mouse clicked.
//
int rx, ry;
void onClick(int button, int stat, int x, int y)
{
	
	if (button == GLUT_LEFT_BUTTON && stat == GLUT_DOWN)
	{
		rx = x - WINDOW_WIDTH / 2;
		ry =  WINDOW_HEIGHT / 2 - y;

		
		for (int i = 0; i < 4; i++) // loop to check all four boxes for click
		{
			
			if ((rx >= box[i].cx-24 && rx <= box[i].cx + 19) && (ry >= 255 && ry <= 300) ) // check each box
			{
				
				if (box[i].tru == true) //change colour 
				{
					box[i].col = green;
					clickcount++;
					
				}
				else if (box[i].tru == false)
				{
					box[i].col = red; 
					clickcount++;
				}
			}
		}

	}


	// to refresh the window it calls display() function
	glutPostRedisplay();
}

//
// This function is called when the window size changes.
// w : is the new width of the window in pixels.
// h : is the new height of the window in pixels.
//
void onResize(int w, int h)
{
	winWidth = w;
	winHeight = h;
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(-w / 2, w / 2, -h / 2, h / 2, -1, 1);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	display(); // refresh window.
}

void onMoveDown(int x, int y) {
	// Write your codes here.

	

	// to refresh the window it calls display() function   
	glutPostRedisplay();
}

// GLUT to OpenGL coordinate conversion:
//   x2 = x1 - winWidth / 2
//   y2 = winHeight / 2 - y1
void onMove(int x, int y) {

	rx = x - WINDOW_WIDTH / 2;
	ry = WINDOW_HEIGHT / 2 - y;


	for (int i = 0; i < 4; i++) // loop to check all four boxes for click
	{

		if ((rx >= box[i].cx - 24 && rx <= box[i].cx + 19) && (ry >= 255 && ry <= 300)) // check each box
		{

			if (box[i].col == yellow) //change colour 
			{
				box[i].col = blue;
			}

		}
		else if(box[i].col == blue)
			box[i].col = yellow;
	}




	// to refresh the window it calls display() function
	glutPostRedisplay();
}


#if TIMER_ON == 1
void onTimer(int v) {
	if (stopped) {
		glutTimerFunc(TIMER_PERIOD, onTimer, 0);
		return;
	}
	

	if (checkaim(ufo.ux, ufo.uy, tarx +280, tary-8) == true)
	{
		
		dx = tarx + 287;
		dy = tary - 8;
		animation = true;

	}

	if (gameover == 0)
	{
		glutTimerFunc(TIMER_PERIOD, onTimer, 0);

		c += 10; // time counter 

		angle += 1;
		if (angle > 360)
			angle -= 360;

		if (c >= 1000) {
			timeCounter--;
			if (timeCounter == 0)
				gameover = 1;
			c = 0;
		}
		for (int i = 0; i < 4; i++)
		{
			if (box[i].tru == true && box[i].col == green && clickcount == 1)
			{
				ufo.uy += 3;
				
			}
			if (ufo.uy > WINDOW_HEIGHT / 2)
			{
				pscore += ufo.points;
				reset();

			}
		}
		

		if (animation) // check if animation is true 
		{
			laserMovement();
			//check if the laser hits the end of the screen
			if (lx > (WINDOW_WIDTH / 2 - 10)|| lx < (-WINDOW_WIDTH / 2 + 10)|| ly < (-WINDOW_HEIGHT / 2 + 10) || ly >(WINDOW_HEIGHT / 2 - 10))
				resetLaser();
			
			
				if (checkIntercept(ufo.ux, ufo.uy) == true) //check intercept 
				{
					score += ufo.points;
					reset();
				}
			
		}
	}


	//to refresh the window it calls display() function
	glutPostRedisplay();

}
#endif

void Init() {

	// Smoothing shapes
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	fillvalues(); // fill values outside timer to keep them constant every time after being filled
	fillanswers();

}

void main(int argc, char *argv[]) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
	glutInitWindowSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	//glutInitWindowPosition(100, 100);
	glutCreateWindow("Syed Abdullah Hassan -Can you beat this computer?");

	glutDisplayFunc(display);
	glutReshapeFunc(onResize);

	//
	// keyboard registration
	//
	glutKeyboardFunc(onKeyDown);
	glutSpecialFunc(onSpecialKeyDown);

	glutKeyboardUpFunc(onKeyUp);
	glutSpecialUpFunc(onSpecialKeyUp);

	//
	// mouse registration
	//
	glutMouseFunc(onClick);
	glutMotionFunc(onMoveDown);
	glutPassiveMotionFunc(onMove);

#if  TIMER_ON == 1
	// timer event
	glutTimerFunc(TIMER_PERIOD, onTimer, 0);

#endif

	Init();

	glutMainLoop();
}