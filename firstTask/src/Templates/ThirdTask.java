package Templates;


import java.awt.Color;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class ThirdTask implements GLEventListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
      
    GL gl = glAutoDrawable.getGL();
    
    
    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
      
        GL gl = glAutoDrawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        drawGraph(gl);

//        drawCircle(gl, 300, Color.YELLOW, true, 0, 0);
//        drawCircle(gl, 100, Color.WHITE, true, 150, 65);
//        drawCircle(gl, 100, Color.WHITE, true, -150, 65);
//
//
//        
//        drawCircle(gl, 100, Color.BLACK, true, 0, -150);
        gl.glColor3f(0.807f, 0.784f, 0.070f);
        drawCircle(gl, 70, true, 0, 60);
        drawCircle(gl, 70, true, 60, 0);
        drawCircle(gl, 70, true, -60, 0);
        
        
        
        
        gl.glColor3f(0.662f, 0.686f, 0.254f);
        drawCircle(gl, 50, true, 0, 20);
        drawCircle(gl, 50, true, 48, -15);
        drawCircle(gl, 50, true, -48, -15);
        
        
//        gl.glColor3f(0.807f, 0.784f, 0.070f);
//        drawCircle(gl, 70, true, -60, 0);
//        
        


        gl.glColor3f(0.470f, 0.313f, 0.074f);
        triangle(gl , 0 , 30 , -10 , -125 , 10 , -125 );
        triangle(gl , 40 , -5 , 0 , -40 , 0 , -25 );
        triangle(gl , -40 , -5 , 0 , -40 , 0 , -25 );

        
  }
  
  
    void triangle(GL gl, int x, int y , int x1 , int y1 , int x2, int y2 ) {
        
    gl.glBegin(GL.GL_POLYGON);       
   
    gl.glVertex2i(x, y); 
    gl.glVertex2i(x1, y1);
    gl.glVertex2i(x2, y2);
    gl.glEnd();
    
    }
  

  void drawCircle(GL gl, int r, boolean filled, double x, double y) {
        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        drawPolyLines(gl, r, 360, 0, 1, filled);
        gl.glPopMatrix();
    }


    void drawPolyLines(GL gl, int r, double sides, double startAngle, int step, boolean filled) {
        if (filled) {
            gl.glBegin(GL.GL_POLYGON);
        } else {
            gl.glBegin(GL.GL_LINE_LOOP);
        }

        for (double i = startAngle; i < 360 * step + startAngle; i += step * 360.0 / sides) {
            gl.glVertex2d(r * Math.cos(Math.toRadians(i)), r * Math.sin(Math.toRadians(i)));
        }
        gl.glEnd();
    }

    void drawEllipse(GL gl, double a, double b, Color c, double sides, double startAngle, int step) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (double i = startAngle; i < 360 * step + startAngle; i += step * 360.0 / sides) {
            double r = a * b / (Math.sqrt(Math.pow(b * Math.cos(Math.toRadians(i)), 2) + Math.pow(a * Math.sin(Math.toRadians(i)), 2)));
            gl.glVertex2d(r * Math.cos(Math.toRadians(i)), r * Math.sin(Math.toRadians(i)));
        }
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
