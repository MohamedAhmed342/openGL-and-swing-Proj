package Templates;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class FirstTask implements GLEventListener {

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
//    drawGraph(glAutoDrawable.getGL());
    
    
    //    drawGraph(gl);

        /////////////////////////////////////////////////////////////
        
    GL gl = glAutoDrawable.getGL();
    

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    drawGraph(gl);
    
    gl.glBegin(GL.GL_POLYGON);
    
    gl.glColor3f(0.98f, 0.87f, 0.0f);

    gl.glVertex2i(85, 30); 
    gl.glColor3f(0.98f, 0.77f, 0.011f);

    gl.glVertex2i(40, -65);
    gl.glColor3f(1.0f, 0.85f, 0.0001f);
    gl.glVertex2i(130, -65);
    gl.glEnd();
    
        
    /////////////////////////////////////////////////////////////
    
    gl.glBegin(GL.GL_POLYGON);
    
    gl.glColor3f(0.98f, 0.87f, 0.0f);
    gl.glVertex2i(0, 40);
    gl.glColor3f(0.98f, 0.77f, 0.011f);

    gl.glVertex2i(-60, -70);
    gl.glColor3f(1.0f, 0.85f, 0.0001f);
    gl.glVertex2i(60, -70);
    gl.glEnd();

    /////////////////////////////////////////////////////////////
    gl.glBegin(GL.GL_POLYGON);
    gl.glColor3f(0.98f, 0.87f, 0.0f);
    gl.glVertex2i(-105, 50);
    
    gl.glColor3f(0.98f, 0.77f, 0.011f);
    gl.glVertex2i(-180, -75);
    
    
    gl.glColor3f(1.0f, 0.85f, 0.0001f);
    gl.glVertex2i(-30, -75);
    gl.glEnd();

    
    
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }

  private void drawGraph(GL gl) {
    float red;
    float green;
    float blue;
//    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
////////////////////
//drawing the grid
    red = 0.2f;
    green = 0.2f;
    blue = 0.2f;
    gl.glColor3f(red, green, blue);
//You may notice I'm using GL_LINES here.
//Details of glBegin() will be discussed latter.
    gl.glBegin(GL.GL_LINES);
//draw the vertical lines
    for (int x = -250; x <= 250; x += 10) {
      gl.glVertex2d(x, -150);
      gl.glVertex2d(x, 150);
    }
//draw the horizontal lines
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
//line for y-axis
    gl.glVertex2d(0, 140);
    gl.glVertex2d(0, -140);
//line for x-axis
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
