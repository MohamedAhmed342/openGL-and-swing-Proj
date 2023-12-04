package Homework1;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class PyramidsApp extends JFrame {

  private GLCanvas glcanvas;
  private PyramidsGLEventListener listener = new PyramidsGLEventListener();

  public static void main(String[] args) {
    new PyramidsApp();
  }

  public PyramidsApp() {

    super("3 Pyramids");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
