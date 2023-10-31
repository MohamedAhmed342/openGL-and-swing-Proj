package Templates;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class ThirdTaskApp extends JFrame {

  private GLCanvas glcanvas;
  private ThirdTask listener = new ThirdTask();

  public static void main(String[] args) {
    new ThirdTaskApp();
  }

  public ThirdTaskApp() {
//set the JFrame title
    super("First Circle Using Sine and Cosine");
    //kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
//add the GLCanvas just like we would any Component
    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(1200, 700);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
