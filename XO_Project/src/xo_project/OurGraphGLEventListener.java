package xo_project;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

public class OurGraphGLEventListener implements GLEventListener, MouseMotionListener, MouseListener {

    private int x, y;
    char xo[][]=new char[3][3];
    int MouseX = 0, MouseY = 0, MouseXStart = 0, MouseYStart = 0;
    boolean bl=false;
    GLCanvas glc;
    boolean drawn1=false,drawn2=false,drawn3=false,drawn4=false,drawn5=false,drawn6=false,drawn7=false,drawn8=false,drawn9=false;
    boolean drawnwt1=false,drawnwt2=false,drawnwt3=false,drawnwt4=false,drawnwt5=false,drawnwt6=false,drawnwt7=false,drawnwt8=false,drawnwt9=false;
    char o1='e',o2='e',o3='e',o4='e',o5='e',o6='e',o7='e',o8='e',o9='e';

    public OurGraphGLEventListener(int x, int y) {
        super();
        this.x = x / 2;
        this.y = y / 2;
    }

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
       
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glLineWidth(2.0f);
        gl.glViewport(0, 0, x, y);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0, x * 2, 0, y * 2, -1, 1);
        gl.glEnable(gl.GL_BLEND);
        gl.glBlendFunc(gl.GL_SRC_ALPHA, gl.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        
        
        GL gl = glAutoDrawable.getGL();
        glAutoDrawable.getGL().glClear(GL.GL_COLOR_BUFFER_BIT);
        
        //the big one
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(175,510);
        gl.glVertex2d(175,84);
        gl.glVertex2d(771,84);
        gl.glVertex2d(771,510);
        gl.glEnd();
        
        ////////////////////////right////////////////////////////
        // top right
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(760,497);
        gl.glVertex2d(576,497);
        gl.glVertex2d(576,372);
        gl.glVertex2d(760,372);
        gl.glEnd();
        
        
        //middle right
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(760,360);
        gl.glVertex2d(576,360);
        gl.glVertex2d(576,234);
        gl.glVertex2d(760,234);
        gl.glEnd();
        
 
        //bottom right
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(760,222);
        gl.glVertex2d(576,222);
        gl.glVertex2d(576,97);
        gl.glVertex2d(760,97);
        gl.glEnd();
        
        
        ////////////////////////middle////////////////////////////        
        // top  
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(565,497);
        gl.glVertex2d(381,497);
        gl.glVertex2d(381,372);
        gl.glVertex2d(565,372);
        gl.glEnd();
        
        

        //middle 
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(565,360);
        gl.glVertex2d(381,360);
        gl.glVertex2d(381,234);
        gl.glVertex2d(565,234);
        gl.glEnd();
        
 
        //bottom 
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(565,222);
        gl.glVertex2d(381,222);
        gl.glVertex2d(381,97);
        gl.glVertex2d(565,97);
        gl.glEnd();
        
        
        
        
        
        ////////////////////////left////////////////////////////        
        // top 
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(370,497);
        gl.glVertex2d(186,497);
        gl.glVertex2d(186,372);
        gl.glVertex2d(370,372);
        gl.glEnd();
        
        

        //middle 
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(370,360);
        gl.glVertex2d(186,360);
        gl.glVertex2d(186,234);
        gl.glVertex2d(370,234);
        gl.glEnd();
        
 
        //bottom 
        gl.glColor3f(1, 0, 1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(370,222);
        gl.glVertex2d(186,222);
        gl.glVertex2d(186,97);
        gl.glVertex2d(370,97);
        gl.glEnd();
        
        
       

        
            
        //middle middle
        if(MouseXStart<=565 && MouseXStart>=381 && MouseYStart<=360 && MouseYStart>=234 && drawn1==false ){
            if(bl==true){
                drawnwt1=true;
                o1='o';
                bl=false;
            }
            else {
                drawnwt1=false;
                o1='x';
                bl=true;
            }   
            xo[1][1]=o1;
            drawn1=true;
        }


        //middle left
        if(MouseXStart<=370 && MouseXStart>=186 && MouseYStart<=360 && MouseYStart>=234 && drawn2==false ){
            if(bl==true){
                drawnwt2=true;
                o2='o';
                bl=false;
            }
            else {
                drawnwt2=false;
                o2='x';
                bl=true;
            }
            xo[1][0]=o2;
            drawn2=true;
        }
        
        
        //middle right
        if(MouseXStart<=760 && MouseXStart>=567 && MouseYStart<=360 && MouseYStart>=234 && drawn3==false ){
            if(bl==true){
                drawnwt3=true;
                o3='o';
                bl=false;
            }
            else {
                drawnwt3=false;
                o3='x';
                bl=true;
            }
            xo[1][2]=o3;
            drawn3=true;
        }


         //top middle
        if(MouseXStart<=565 && MouseXStart>=381 && MouseYStart<=497 && MouseYStart>=372 && drawn4==false ){
            if(bl==true){
                drawnwt4=true;
                o4='o';                
                bl=false;
            }
            else {
                drawnwt4=false;
                o4='x';
                bl=true;
            }
            xo[0][1]=o4;
            drawn4=true;
        }
        
        //top right
        if(MouseXStart<=760 && MouseXStart>=576 && MouseYStart<=497 && MouseYStart>=372 && drawn5==false ){
            if(bl==true){
                drawnwt5=true;
                o5='o';                
                bl=false;
            }
            else {
                drawnwt5=false;
                o5='x';
                bl=true;
            }
            
            xo[0][2]=o5;
            drawn5=true;
        }
        
        
        
        //top left
        if(MouseXStart<=370 && MouseXStart>=186 && MouseYStart<=497 && MouseYStart>=372 && drawn6==false ){
            if(bl==true){
                drawnwt6=true;
                o6='o';
                bl=false;
            }
            else {
                drawnwt6=false;
                o6='x';
                bl=true;
            }
            xo[0][0]=o6;
            drawn6=true;
        }
        
        
        //bottom right    
        if(MouseXStart<=760 && MouseXStart>=576 && MouseYStart<=222 && MouseYStart>=97 && drawn7==false ){
            if(bl==true){
                drawnwt7=true;
                o7='o';                
                bl=false;
            }
            else {
                drawnwt7=false;
                o7='x';
                bl=true;
            }
            xo[2][2]=o7;
            drawn7=true;
        }
        
        
        //bottom right    
        if(MouseXStart<=565 && MouseXStart>=381 && MouseYStart<=222 && MouseYStart>=97 && drawn8==false ){
            if(bl==true){
                drawnwt8=true;
                o8='o';
                bl=false;
            }
            else {
                drawnwt8=false;
                o8='x';
                bl=true;
            }
            xo[2][1]=o8;
            drawn8=true;
        }

        
        //bottom right    
        if(MouseXStart<=370 && MouseXStart>=186 && MouseYStart<=222 && MouseYStart>=97 && drawn9==false ){
            if(bl==true){
                drawnwt9=true;
                o9='o';                
                bl=false;
            }
            else {
                drawnwt9=false;
                o9='x';
                bl=true;
            }
            xo[0][1]=o8;
            drawn9=true;
        }
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        

        if(drawn1==true){
            if(drawnwt1==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(565,360);
            gl.glVertex2d(381,234);     
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(565,234);
            gl.glVertex2d(381,360);     
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 477, 302);
            }
        }
        
        
        
       if(drawn2==true){
            if(drawnwt2==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(370,360);
            gl.glVertex2d(186,234);     
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(186,360);
            gl.glVertex2d(370,234);     
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 278,302);
            }
        }
       

       
        if(drawn3==true){
            if(drawnwt3==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(760,360);
            gl.glVertex2d(576,234);
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(576,360);
            gl.glVertex2d(760,234);    
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 668,302);
            }
        }




        if(drawn4==true){
            if(drawnwt4==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(565,497);
            gl.glVertex2d(381,372);     
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(381,497);
            gl.glVertex2d(565,372);     
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 473,434);
            }
        }
         
        
        
        if(drawn5==true){
            if(drawnwt5==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);   
            gl.glVertex2d(760,497);
            gl.glVertex2d(576,372);
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(576,497);
            gl.glVertex2d(760,372);
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 668,434);
            }
        }
        
        
        if(drawn6==true){
            if(drawnwt6==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(370,497);
            gl.glVertex2d(186,372);
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(186,497);
            gl.glVertex2d(370,372);
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 278,434);
            }
        }

        if(drawn7==true){
            if(drawnwt7==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(760,222);
            gl.glVertex2d(576,97);
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(576,222);
            gl.glVertex2d(760,97);
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 668,159);
            }
        }
        
        if(drawn8==true){
            if(drawnwt8==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(565,222);
            gl.glVertex2d(381,97);
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(381,222);
            gl.glVertex2d(565,97);
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 473 ,159);
            }
        }
 

        if(drawn9==true){
            if(drawnwt9==false){
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(370,222);
            gl.glVertex2d(186,97);
            gl.glEnd();
            gl.glColor3f(0, 1, 0);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(186,222);
            gl.glVertex2d(370,97);
            gl.glEnd();
            }
            else {
                gl.glColor3f(0, 1, 0);
                drawCircle(gl, 50, false, 278 ,159);
            }
        }
        xoWinner();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

//    private void drawCricle(GL gl, int radiusForX, int radiusForY, int xasis, int yasis, float red, float green, float blue) {
//        double x, y;
//        gl.glColor3f(red, green, blue);
//        gl.glEnable(gl.GL_LINE_SMOOTH);
//        gl.glHint(gl.GL_LINE_SMOOTH_HINT, gl.GL_NICEST);
//        gl.glBegin(GL.GL_LINE_STRIP);
//
//        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
//            x = radiusForX * (Math.cos(a));
//            y = radiusForY * (Math.sin(a));
//            gl.glVertex2d(x + xasis, y + yasis);
//        }
//
//        gl.glEnd();
//    }



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
    
    
    
    void xoWinner() {
        for (int i = 0; i < 3; i++) {
             if(xo[i][0]=='x' && xo[i][1]=='x' && xo[i][2]=='x' )
             {
                 System.out.println("X IS The Winner");
             }
        }
        
        for (int i = 0; i < 3; i++) {
             if(xo[0][i]=='x' && xo[1][i]=='x' && xo[2][i]=='x' )
             {
                 System.out.println("X IS The Winner");
             }
        }
        if(xo[0][0]=='x' && xo[1][1]=='x' && xo[2][2]=='x'){
            System.out.println("X IS The Winner");
        }
        if(xo[0][2]=='x' && xo[1][1]=='x' && xo[2][0]=='x'){
            System.out.println("X IS The Winner");
        }
        
        
        
        
        for (int i = 0; i < 3; i++) {
             if(xo[i][0]=='o' && xo[i][1]=='o' && xo[i][2]=='o' )
             {
                 System.out.println("O IS The Winner");
             }
        }
        
        for (int i = 0; i < 3; i++) {
             if(xo[0][i]=='o' && xo[1][i]=='o' && xo[2][i]=='o' )
             {
                 System.out.println("O IS The Winner");
             }
        }
        if(xo[0][0]=='o' && xo[1][1]=='o' && xo[2][2]=='o'){
            System.out.println("O IS The Winner");
        }
        if(xo[0][2]=='o' && xo[1][1]=='o' && xo[2][0]=='o'){
            System.out.println("O IS The Winner");
        }  
        
        
    }
        
    

    @Override
    public void mouseDragged(MouseEvent e) {
//        Component c = e.getComponent();
//        double width = c.getWidth();
//        double height = c.getHeight();
//        double X = e.getX();
//        double Y = e.getY();
//        MouseX = (int) ((X / width) * (x * 2));
//        MouseY = (int) ((Y / height) * (y * 2));
//        MouseY = y * 2 - MouseY;
//        System.out.println(MouseX + "," + MouseY + "  ........Dragged");
//        glc.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println(e.getX() + "," + e.getY());
//

//        glc.repaint();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        double X = e.getX();
        double Y = e.getY();
        MouseXStart = (int) ((X / width) * (x * 2));
        MouseYStart = (int) ((Y / height) * (y * 2));
        MouseYStart = y * 2 - MouseYStart;
        System.out.println(MouseXStart + "," + MouseYStart + "  ........Pressed");
        glc.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        Component c = e.getComponent();
//        double width = c.getWidth();
//        double height = c.getHeight();
//        double X = e.getX();
//        double Y = e.getY();
//        MouseX = (int) ((X / width) * (x * 2));
//        MouseY = (int) ((Y / height) * (y * 2));
//        MouseY = y * 2 - MouseY;
//        System.out.println(MouseX + "," + MouseY + "  ........Released");
//        glc.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
