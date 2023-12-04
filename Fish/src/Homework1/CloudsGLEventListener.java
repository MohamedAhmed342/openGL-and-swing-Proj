package Homework1;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class CloudsGLEventListener implements GLEventListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    gl.glLineWidth(2.0f);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    drawGraph(gl);
    drawCloud(gl);
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }

  public static void drawCloud(GL gl){
    
    gl.glColor3f(0.9f, 0.9f, 0.9f);
    drawCircle(gl, 100, 0, 60);
    drawCircle(gl, 0, 0, 80);
    drawCircle(gl, -100, 0, 60);

    drawCircle(gl, 140, -40, 50);
    drawCircle(gl, 90, -40, 60);
    drawCircle(gl, 40, -40, 60);
    drawCircle(gl, -40, -40, 60);
    drawCircle(gl, -90, -40, 60);
    drawCircle(gl, -140, -40, 50);

    // gl.glColor3f(0.1f, 0.1f, 0.1f);
    // drawCircleBoundary(gl, 100, 0, 60);
    // drawCircleBoundary(gl, 0, 0, 80);
    // drawCircleBoundary(gl, -100, 0, 60);

    // drawCircleBoundary(gl, 140, -40, 50);
    // drawCircleBoundary(gl, 90, -40, 60);
    // drawCircleBoundary(gl, 40, -40, 60);
    // drawCircleBoundary(gl, -40, -40, 60);
    // drawCircleBoundary(gl, -90, -40, 60);
    // drawCircleBoundary(gl, -140, -40, 50);
  }

  private void drawCircleBoundary(GL gl, int x, int y, int radius) {
    gl.glBegin(GL.GL_LINE_LOOP);
    for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
      double x1 = radius * (Math.cos(a)) + x;
      double y1 = radius * (Math.sin(a)) + y;
      gl.glVertex2d(x1, y1);
    }
    gl.glEnd();
  }

  public static void drawCircle(GL gl, int x, int y, int radius) {
    gl.glBegin(GL.GL_POLYGON);
    for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
      double x1 = radius * (Math.cos(a)) + x;
      double y1 = radius * (Math.sin(a)) + y;
      gl.glVertex2d(x1, y1);
    }
    gl.glEnd();
  }

  private void drawGraph(GL gl) {
    float red;
    float green;
    float blue;
    ////////////////////
    // drawing the grid
    red = 0.2f;
    green = 0.2f;
    blue = 0.2f;
    gl.glColor3f(red, green, blue);
    // You may notice I'm using GL_LINES here.
    // Details of glBegin() will be discussed latter.
    gl.glBegin(GL.GL_LINES);
    // draw the vertical lines
    for (int x = -250; x <= 250; x += 10) {
      gl.glVertex2d(x, -150);
      gl.glVertex2d(x, 150);
    }
    // draw the horizontal lines
    for (int y = -150; y <= 150; y += 10) {
      gl.glVertex2d(-250, y);
      gl.glVertex2d(250, y);
    }
    gl.glEnd();
    //////////////////////////////
    // draw the x-axis and y-axis
    red = 0.0f;
    green = 0.2f;
    blue = 0.4f;
    gl.glColor3f(red, green, blue);
    gl.glBegin(GL.GL_LINES);
    // line for y-axis
    gl.glVertex2d(0, 140);
    gl.glVertex2d(0, -140);
    // line for x-axis
    gl.glVertex2d(240, 0);
    gl.glVertex2d(-240, 0);
    gl.glEnd();
    /////////////////////
    // draw arrow heads
    gl.glBegin(GL.GL_TRIANGLES);
    gl.glVertex2d(0, 150);
    gl.glVertex2d(-5, 140);
    gl.glVertex2d(5, 140);
    gl.glVertex2d(0, -150);
    gl.glVertex2d(-5, -140);
    gl.glVertex2d(5, -140);
    gl.glVertex2d(250, 0);
    gl.glVertex2d(240, -5);
    gl.glVertex2d(240, 5);
    gl.glVertex2d(-250, 0);
    gl.glVertex2d(-240, -5);
    gl.glVertex2d(-240, 5);
    gl.glEnd();
  }
}
