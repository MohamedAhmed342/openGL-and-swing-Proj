package Templates;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class FirstTaskApp extends JFrame {

  private GLCanvas glcanvas;
  private FirstTask listener = new FirstTask();

  public static void main(String[] args) {
    new FirstTaskApp();
  }

  public FirstTaskApp() {

    super("Our Graph Application");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(1200, 700);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
