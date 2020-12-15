

/*********
   CTIS164 - Template Source Program
----------
STUDENT : Syed Abdullah Hassan
SECTION : 02
HOMEWORK: 04
----------
PROBLEMS: NONE
----------
ADDITIONAL FEATURES: 3 different backgrounds
1. the Light source changes into 2 colours, the light source changes the colour of the light shadow on the ground 
as well.
2. The stars in the star background keep on changing the size using a random function
3. The ufo changes colour a split second before it is disappeared 
4. pressing the esc button ends the game. 
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
#include"vec.h"


#define WINDOW_WIDTH  1000
#define WINDOW_HEIGHT 500

#define TIMER_PERIOD  10 // Period for the timer.
#define TIMER_ON         1 // 0:disable timer, 1:enable timer
#define DURATION 20
#define D2R 0.0174532


typedef struct {  //structure for the colour 
	float r, g, b;
} color_t;

typedef struct {  //structure for light 
	vec_t   pos;
	color_t color;
	vec_t   vel;
} light_t;

typedef struct {  //vertex
	vec_t pos;
	vec_t N;
} vertex_t;

typedef struct
{
	int ux;
	int uy;
	int r, g, b;
	vec_t pos;
	vec_t vel;
} ufo_t;  //ufo structure 


/* Global Variables for Template File */
bool up = false, down = false, right = false, left = false, animation = false;
int  winWidth, winHeight; // current Window width and height

int timeCounter = DURATION,
uxx, uyy,
c = 0, si = 80;
ufo_t ufo;
int stateb = 0;
int upc = 1;
bool isufo = 0; //check ufo flag
light_t light = { {-460, 300}, { 0.00, 0.4, 0.99 }, {30, 40} }; //light 



double magV(vec_t v) {
	return sqrt(v.x * v.x + v.y * v.y);  //vector functions
}

double angleV(vec_t v) {
	double angle = atan2(v.y, v.x) * V_R2D;
	return angle < 0 ? angle + 360 : angle;
}

vec_t addV(vec_t v1, vec_t v2) {
	return{ v1.x + v2.x, v1.y + v2.y };
}

vec_t subV(vec_t v1, vec_t v2) {
	return{ v1.x - v2.x, v1.y - v2.y };
}

vec_t mulV(double k, vec_t v) {
	return{ k * v.x, k * v.y };
}

double dotP(vec_t v1, vec_t v2) {
	return v1.x * v2.x + v1.y * v2.y;
}

vec_t unitV(vec_t v) {
	return mulV(1.0 / magV(v), v);
}

// convert from polar representation to rectangular representation
vec_t pol2rec(polar_t p) {
	return{ p.magnitude * cos(p.angle * V_D2R),  p.magnitude * sin(p.angle * V_D2R) };
}

polar_t rec2pol(vec_t v) {
	return{ magV(v), angleV(v) };
}

color_t mulColor(float k, color_t c) {
	color_t tmp = { k * c.r, k * c.g, k * c.b };
	return tmp;
}

color_t addColor(color_t c1, color_t c2) {
	color_t tmp = { c1.r + c2.r, c1.g + c2.g, c1.b + c2.b };
	return tmp;
}

double distanceImpact(double d) {
	return (-1.0 / 350.0) * d + 1.0;
}

	color_t calculateColor(light_t source, vertex_t v)  //calculate colour 
	{
		vec_t L = subV(source.pos, v.pos);
		vec_t uL = unitV(L);
		float factor = dotP(uL, v.N) * distanceImpact(magV(L));
		return mulColor(factor, source.color);

	}


double angleBetween2V(vec_t v1, vec_t v2) {
	double magV1 = magV(v1);
	double magV2 = magV(v2);
	double dot = dotP(v1, v2);
	double angle = acos(dot / (magV1 * magV2)) * V_R2D; // in degree
	return angle;
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


void dispUfo(int ux, int uy, int r, int g, int b) //UFO object
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
}



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

	glLineWidth(2);
	glColor3f(0, 0, 0);
	glBegin(GL_LINE_STRIP);
	
	glEnd();
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

int sx = -550, sy = -250, sr = 155, sg = 200, sb = 0; //some other variables

void dobject(int radius, int x, int y) //the glowing object 
{
	glColor3ub(sr, sg, sb);

	circle(x, y, radius);
}


void trackcoor()  // function to change colours and ufo tracking fuctions 
{
	ufo.r = sr;
	ufo.b = sb;
	ufo.g = sg;
	light.pos.x = sx;
	light.pos.y = sy;

	//ufo will chase the light source
	ufo.vel = mulV(3.8, unitV(subV(light.pos, ufo.pos)));
	ufo.pos = addV(ufo.pos, ufo.vel);


	//change colour
	if (ufo.pos.x >= sx - 15 && ufo.pos.x <= sx + 15 && ufo.pos.y >= sy - 15 && ufo.pos.y <= sy + 15)
	{
		ufo.r = 255;
		ufo.b = 20;
		ufo.g = 20;
	}
	//if ufo reaches center of light source, it will disappear
	if (ufo.pos.x >= sx - 2 && ufo.pos.x <= sx + 2 && ufo.pos.y >= sy - 2 && ufo.pos.y <= sy + 2)
		isufo = 0;

}

void display() { // main display function 

	daybackground(); //we cannot go back to day! 

	if (stateb == 's') // key preses changes background 
		background();

	else if (stateb == 'd') //other background
		citybackground();

	glColor3f(light.color.r, light.color.g, light.color.b);
	
	for (int x = 0; x <= 1000; x++)  //loop 
	{

		
		vertex_t P = { { x, -100}, { 0, 1 } };

		color_t res = { 0, 0, 0 };

		res = addColor(res, calculateColor(light, P));

		glBegin(GL_LINES);
		glColor3f(res.r, res.g, res.b);
		
		//glVertex2f(x, y + 300);
		glVertex2f(-600, -200-x);
		glVertex2f(600,  + -100-x);
		glColor3f(0.009, 0.962, 0.950);  //shade to the ground 
		//glVertex2f(x, y);
		glEnd();
	}
	dobject(60, sx, sy); //light source 

	if (isufo == 1) 
		dispUfo(ufo.pos.x, ufo.pos.y, ufo.r, ufo.g, ufo.b);

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
		
		break;
	case GLUT_KEY_DOWN: down = true;
		
		break;
	case GLUT_KEY_LEFT: left = true; break;
	case GLUT_KEY_RIGHT: right = true; break;

	case GLUT_KEY_F10:
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
void onClick(int button, int stat, int x, int y)
{
	if (button == GLUT_LEFT_BUTTON && stat == GLUT_DOWN)
	{
		ufo.pos.x= x - WINDOW_WIDTH / 2;
		ufo.pos.y = WINDOW_HEIGHT / 2 - y;

		isufo = 1;
	}
	

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
		glutTimerFunc(TIMER_PERIOD, onTimer, 0);



		sx += 2;  //movement of light source
		if (sx > WINDOW_WIDTH / 2)
			sx = -550;

		if (sy > 200)  // the 2D movement  of the light source 
			upc = 0;

		else if (sy < -20)
			upc = 1;

		if (upc == 1)
		{
			sr = 50, sg = 170, sb = 255;
			light.color.r = 0;
			light.color.b = 0.99;
			light.color.g = 0.2;

			sy += 2;

		}
		else
		{
			sr = 155, sg = 200, sb = 125;
			light.color.r = 0;
			light.color.b = 0.2;
			light.color.g = 0.99;
			sy -= 2;
		}
	
		trackcoor(); // the ufo tracking & colour changing function 


	//to refresh the window it calls display() function
	glutPostRedisplay();

}
#endif

void Init() {

	// Smoothing shapes
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

}

void main(int argc, char *argv[]) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
	glutInitWindowSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	//glutInitWindowPosition(100, 100);
	glutCreateWindow("Syed Abdullah Hassan -Bounce Chaser");

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