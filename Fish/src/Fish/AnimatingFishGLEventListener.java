/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fish;

import Fish.fishListener;
import Texture.TextureReader;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.BitSet;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;


public class AnimatingFishGLEventListener extends fishListener {
    boolean ashraf = false , filp=false , eating = false;
    int animationIndex = 0;
    int maxWidth = 100;
    int maxHeight = 100;
    int x = maxWidth/2, y = maxHeight/2;
    double z = 1.0;
    
    String textureNames[] = {"Idle (1).png","Idle (2).png","Idle (3).png","Idle (4).png","Idle (5).png","Idle (6).png"
            ,"Turn (1).png","Turn (2).png","Turn (3).png","Turn (4).png","Turn (5).png",
            "Eat (1).png","Eat (2).png","Eat (3).png","Eat (4).png","Eat (5).png","Eat (6).png"
            ,"Back.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];

    /*
     5 means gun in array pos
     x and y coordinate for gun 
     */
    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black
        
        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);	
        gl.glGenTextures(textureNames.length, textures, 0);
        
        for(int i = 0; i < textureNames.length; i++){
            try {
                texture[i] = TextureReader.readTexture(assetsFolderNamename + "//" + textureNames[i] , true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                new GLU().gluBuild2DMipmaps(
                    GL.GL_TEXTURE_2D,
                    GL.GL_RGBA, // Internal Texel Format,
                    texture[i].getWidth(), texture[i].getHeight(),
                    GL.GL_RGBA, // External format from image,
                    GL.GL_UNSIGNED_BYTE,
                    texture[i].getPixels() // Imagedata
                    );
            } catch( IOException e ) {
              System.out.println(e);
              e.printStackTrace();
            }
        }
    }
    
    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity(); 
        
        DrawBackground(gl);
        handleKeyPress();
        
        
//        DrawGraph(gl);
        
        
        if(eating==true){   
            if(animationIndex<11){
                animationIndex=11;
            }
            if(animationIndex<=15){
                animationIndex ++;
            }            
            else {
                animationIndex=0;
                eating=false;

            }

        }
        else{
            if(filp==true){
                animationIndex++;
                if(animationIndex==10){
                    filp=false;
                }
            }
            else{
                animationIndex = animationIndex % 6;
            }
        }
        
        
        if(ashraf){
            if(filp==false)
            x++;
            if(x>=90){
                ashraf=false;
                filp=true;
                animationIndex=6;
            }
        }
    
        else{
            if(filp==false)
            x--;
            if(x<=0){
                ashraf=true;
                filp=true;
                animationIndex=6;
            }
        }
                DrawSprite(gl, x, y, animationIndex, z);

        
        

        System.out.println(x+" ");
                
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    
    public void DrawSprite(GL gl,int x, int y, int index, double scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On
        
        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
            if(index>=0 && index<=5){
            if(ashraf){
                gl.glRotated(180, 0, 1, 0); // Flip horizontally
            }
            else{
                gl.glRotated(0, 0, 0, 0); 
            }
            }
           else if(index>=11 && index<=15){
            if(ashraf){
                gl.glRotated(180, 0, 1, 0); // Flip horizontally
            }
            else{
                gl.glRotated(0, 0, 0, 0); 
            }
           }            
           else if(index>=6 && index<=10){
                if(!ashraf){
                gl.glRotated(180, 0, 1, 0); // Flip horizontally
            }
            else{
                gl.glRotated(0, 0, 0, 0); 
                }
            }
            
            gl.glScaled(0.1*scale, 0.1*scale, 1);
            //System.out.println(x +" " + y);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
                gl.glTexCoord2f(0.0f, 0.0f);
                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 0.0f);
                gl.glVertex3f(1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 1.0f);
                gl.glVertex3f(1.0f, 1.0f, -1.0f);
                gl.glTexCoord2f(0.0f, 1.0f);
                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
        gl.glPopMatrix();
        
        gl.glDisable(GL.GL_BLEND);
    }
    
    public void DrawBackground(GL gl){
        gl.glEnable(GL.GL_BLEND);	
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[textureNames.length-1]);	// Turn Blending On

        gl.glPushMatrix();
            gl.glBegin(GL.GL_QUADS);
            // Front Face
                gl.glTexCoord2f(0.0f, 0.0f);
                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 0.0f);
                gl.glVertex3f(1.0f, -1.0f, -1.0f);
                gl.glTexCoord2f(1.0f, 1.0f);
                gl.glVertex3f(1.0f, 1.0f, -1.0f);
                gl.glTexCoord2f(0.0f, 1.0f);
                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
            gl.glEnd();
        gl.glPopMatrix();
        
        gl.glDisable(GL.GL_BLEND);
    }
    
    /*
     * KeyListener
     */    

    public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (x > 0) {
                x--;
            }
//            animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (x < maxWidth-10) {
                x++;
            }
//            animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (y > 0) {
                y--;
            }
//            animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (y < maxHeight-10) {
                y++;
            }
//            animationIndex++;
        }
        
        if (isKeyPressed(KeyEvent.VK_Z)) {
            eating=true;
            z+=0.1;
        }        
        
        
    }

    
    
    public BitSet keyBits = new BitSet(256);
 
    @Override 
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    } 
 
    @Override 
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    } 
 
    @Override 
    public void keyTyped(final KeyEvent event) {
        // don't care 
    } 
 
    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
}
