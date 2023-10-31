package Templates;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class SecondTaskApp extends JFrame {

  private GLCanvas glcanvas;
  private SecondTask listener = new SecondTask();

  public static void main(String[] args) {
    new SecondTaskApp();
  }

  public SecondTaskApp() {

    super("Second JOGL Application");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(1200, 700);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
