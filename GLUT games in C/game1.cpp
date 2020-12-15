/*********
   CTIS164 - Template Source Program
----------
STUDENT : Syed Abdullah Hassan
SECTION : 02
HOMEWORK: 02
----------
PROBLEMS: Some UFO's don't die. Some die late. Somtimes lasers pass over the UFO's
----------
ADDITIONAL FEATURES: Background stars keep on changing size. Tried stimulating movies. Speed of laser changes randomly
so makes the game more challenging. The laser changes colour constantly like they should have done in star wars. Some ufo's die after
multiple hits: difficulty level high of the game. Some UFO's have the feature to dodge the laser attack. But you sometimes get the 
points even if you're not able to kill the god strength UFO.
The game has three different locations. Bright Day, City Night, And deep into space and stars stars. 
press d to go to stars, s to go to city. You can't go back to day, because all star wars games are at night. 

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
#define DURATION 20
#define D2R 0.0174532


 typedef struct
{
	int ux;
	int uy;
	bool active;
	int points;
	int r, g, b;
 } ufo_t;

/* Global Variables for Template File */
bool up = false, down = false, right = false, left = false, animation = false;
int  winWidth, winHeight; // current Window width and height
int unocount = 9;
int ax = -390, ay = -15;
int lx = ax + 101, ly = ay + 10;
int timeCounter = DURATION,
gameover = 0, score = 0,
 c = 0, si = 80;
ufo_t ufo[5];
int stateb = 0;



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
	glVertex2f(sx , sy + 1 * siz);
	glVertex2f(sx -2.5 * siz, sy + 5 * siz);
	glVertex2f(sx + 1 * siz, sy + 1 * siz);
	glVertex2f(sx + 1 * siz, sy + 5 * siz);
	glVertex2f(sx + 1.5 * siz, sy);
	glVertex2f(sx + 4 * siz, sy + 4 * siz);
	glVertex2f(sx + 1.5 * siz, sy);
	glVertex2f(sx + 5 * siz, sy);
	glVertex2f(sx + 1 * siz, sy -1 * siz);
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
	glColor3ub(212,175, 55);
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
	if ((lx >= x && lx <= x + si) && (ly  >= y && ly <= y + 20)) //problem in here
	{
		return true; //if intercept return true 
	}
	else
		return false;
}

void resetLaser() {  //reset laser function
	animation = 0;
	lx = ax + 101; //initial coordinates of the laser 
	ly = ay + 10;
}

void fillvalues() //fill initial values of all the UFOs
{
	srand(time(NULL));
	for (int i = 0; i < 5; i++)
	{
		ufo[i].points = 1 + rand() % 10;
		ufo[i].b = 140 + rand() % 254;
		ufo[i].r = 150 + rand() % 254;
		ufo[i].g = 150 +rand() % 254;
		ufo[i].active = 1;
		ufo[i].ux =  + rand() % 340;
		ufo[i].uy = 500;
	}
}

void resetufo(int i) //reset ufo if it intercepts  function
{
	
	ufo[i].ux = rand() % 340;
	ufo[i].uy = 600;
	ufo[i].points = 1 + rand() % 10;
	ufo[i].b = 140 + rand() % 254;
	ufo[i].r = 150 + rand() % 254;
	ufo[i].g = 150 + rand() % 254;
	ufo[i].active = 1;
	
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
	vprint(150, 230, GLUT_BITMAP_8_BY_13, "Press d or s to change background");
	//draw 3 clouds
	drawCloud(-250, 180);
	drawCloud(250, 100);
	drawCloud(0, 200);
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

void display() { // main display function 
	
	daybackground(); //we cannot go back to day! 

		if (stateb == 's') // key preses changes background 
			background();

		else if (stateb == 'd') //other background
			citybackground();



		vprint2(40, -280, 0.15, "time:%d", timeCounter); //timer display
		vprint2(-120, -280, 0.15, " score: %d", score); //score display 
		if (gameover == 1)
			vprint2(-320, 0, 0.9, "GAME OVER"); //print on screen when game is over
		for (int j = 4; j >= 0; j--) // loop to display all the ufos
		{
			if (ufo[j].active == 1)
			{
				dispUfo(ufo[j].ux, ufo[j].uy - j * 90, ufo[j].r, ufo[j].g, ufo[j].b, ufo[j].points);
			}

		}
		dispLaser(lx, ly);
		dispattacker(ax, ay);

	
	
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
		if (ay < WINDOW_HEIGHT/2 - 100) //animation
			ay += 15;
		
		ly = ay + 10;
		break;
	case GLUT_KEY_DOWN: down = true;
		if (ay > -WINDOW_HEIGHT/2 + 16)
		 ay -= 15;
		
	      ly = ay + 10;
		break;
	case GLUT_KEY_LEFT: left = true; break;
	case GLUT_KEY_RIGHT: right = true; break;  
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
void onClick(int button, int stat, int x, int y)
{
	// Write your codes here.



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

	




	// to refresh the window it calls display() function
	glutPostRedisplay();
}


#if TIMER_ON == 1
void onTimer(int v) {
	if (gameover == 0 )
	{
		glutTimerFunc(TIMER_PERIOD, onTimer, 0);

		c += 10; // time counter 
		lx += 8 + rand() % 10; //random speed of the laser 
		

		for (int k = 4; k >= 0; k--)
		{
			
			if (ufo[k].uy < -WINDOW_HEIGHT / 2) //check if ufos are out of screen, reset them 
			{
				resetufo(k);
			}
			ufo[k].uy--; //incrementation of the ufo y coordinate 
		}




		if (c >= 1000) {
			timeCounter--;

			if (timeCounter == 0)
				gameover = 1;

			c = 0;
		}
		if (animation) // check if animation is true 
		{
			

			//check if the laser hits the end of the screen
			if (lx > (WINDOW_WIDTH / 2 - 10)) 
				resetLaser();
			for (int k = 4; k >= 0; k--)
			{
				if (checkIntercept(ufo[k].ux, ufo[k].uy) == true) //check intercept 
				{
					ufo[k].active = 0; 
					score += ufo[k].points;
					resetLaser();

				}
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

}

void main(int argc, char *argv[]) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
	glutInitWindowSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	//glutInitWindowPosition(100, 100);
	glutCreateWindow("Syed Abdullah Hassan");

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