package Homework1;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class CloudsApp extends JFrame {

  private GLCanvas glcanvas;
  private CloudsGLEventListener listener = new CloudsGLEventListener();

  public static void main(String[] args) {
    new CloudsApp();
  }

  public CloudsApp() {

    super("A cloud");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
