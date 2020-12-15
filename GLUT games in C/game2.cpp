/*********
   CTIS164 - Template Source Program
----------
STUDENT : Syed Abdullah Hassan
SECTION :164-02
HOMEWORK: 1
----------
PROBLEMS: Coordinates are different from where i click, make adjusments according to the problem.
----------
ADDITIONAL FEATURES:  2D movement instead of just 1D
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

#define WINDOW_WIDTH  900
#define WINDOW_HEIGHT 500

#define TIMER_PERIOD 10 // Period for the timer.
#define TIMER_ON 1 // 0:disable timer, 1:enable timer

#define D2R 0.0174532

typedef struct
{
	int xx, yy;
} obj_t;

/* Global Variables for Template File */
bool up = false, down = false, right = false, left = false;
int  winWidth, winHeight,  // current Window width and height
px, py; //for pointer location display
obj_t g[10];
int ufocount = 0;
bool timera = false, makestate = false;



// to draw circle, center at (x,y, r)
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

void onMove(int x, int y) {
	

	
	
	px = x; //axis to global variable for pointer 
	py = y;
	// to refresh the window it calls display() function
	glutPostRedisplay();
}

//
//UFO

void dispUfo(int ux, int uy)
{
	
	glColor3f(0.970, 0.95, 0.89);
	//circle 
	circle(ux + 45, uy + 34, 35);
	//Body
	glColor3ub(255, 120, 20);
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
	vprint(ux + 43, uy + 12, GLUT_BITMAP_9_BY_15, "%2d", ufocount);

}


// To display onto window using OpenGL commands
//

void display() {
	//
	// clear window to black
	//
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
	//Name and ID
	
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
		

	//coordinates of pointer 
		glColor3f(1,1,1);
		vprint(330, -230, GLUT_BITMAP_9_BY_15, "(%4d,%4d)", px - 450, 250 - py); // to show 0,0 in the center
		//name and ID
		glColor3ub(75, 0, 130);
		glBegin(GL_POLYGON);
		glVertex2f(-450, 220); // window
		glVertex2f(-300, 220);
		glVertex2f(-300, 180);
		glVertex2f(-450, 180);
		glEnd();
		glColor3ub(255, 255, 240);
		vprint(-420, 210, GLUT_BITMAP_TIMES_ROMAN_10, "Syed Abdullah Hassan");
		vprint(-420, 200, GLUT_BITMAP_TIMES_ROMAN_10, "21801072");

		//display UFO
			
			
		for (int a = 0; a < ufocount; a++)
		{
			dispUfo(g[a].xx, g[a].yy);

		}
		
			
		

		
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
	case GLUT_KEY_UP: up = true; break;
	case GLUT_KEY_DOWN: down = true; break;
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
void onClick(int button, int state, int x, int y)
{

	if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN) {
		bool nmake = false; //not make if true means it's within another object 

		for (int r = 0; r < ufocount; r++)
		{
			if ((x <= g[r].xx + 60 || x >= g[r].xx - 60) && (y <= g[r].yy + 45 || y >= g[r].yy - 45))
				nmake = true;


		}

		if (!nmake && ufocount < 10)
		{
			g[ufocount].xx = x - WINDOW_WIDTH + 400;
			g[ufocount].yy = WINDOW_HEIGHT / 2 - y - 30;   
			makestate = true;
			ufocount++;
		}
		

	}
	if (button == GLUT_RIGHT_BUTTON && state == GLUT_DOWN && (((x - WINDOW_WIDTH + 400) < g[ufocount].xx + 40) && ((x - WINDOW_WIDTH + 400) > g[ufocount].xx - 40 ) && ((WINDOW_HEIGHT / 2 - y - 30) < g[ufocount].yy + 40) && ((WINDOW_HEIGHT / 2 - y - 30) > g[ufocount].yy - 40)))
		timera = !timera;

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


#if TIMER_ON == 1
void onTimer(int v) {

	glutTimerFunc(TIMER_PERIOD, onTimer, 0);
	// Write your codes here.
	if (timera)
	{
		if (g[ufocount].xx < WINDOW_WIDTH)
			g[ufocount].xx++;   //moving the object forward
		g[ufocount].xx++;

		if (g[ufocount].xx > WINDOW_WIDTH/2)   // bring object back to left side
		{
			g[ufocount].xx = -WINDOW_WIDTH / 2;
			g[ufocount].xx++;
		}

		if (g[ufocount].yy > WINDOW_HEIGHT / 2)   // bring object back down
		{
			g[ufocount].yy = -WINDOW_HEIGHT / 2;
			g[ufocount].yy++;
		}
	}



	// to refresh the window it calls display() function
	glutPostRedisplay(); // display()

}
#endif

void Init() {

	// Smoothing shapes
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

}



void eventHandler(int button, int state, int x, int y) {


	
}





void main(int argc, char *argv[]) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
	glutInitWindowSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	//glutInitWindowPosition(100, 100);
	glutCreateWindow("Future City");
	glutMouseFunc(onClick);
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
	//glutSetCursor(GLUT_CURSOR_NONE);
	glutMouseFunc(onClick);
	glutMotionFunc(onMove);
	glutMotionFunc(onMoveDown);
	glutPassiveMotionFunc(onMove);
	
#if  TIMER_ON == 1
	// timer event
	glutTimerFunc(TIMER_PERIOD, onTimer, 0);
#endif

	Init();

	glutMainLoop();
}