package Homework1;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class TreeApp extends JFrame {

  private GLCanvas glcanvas;
  private TreeGLEventListener listener = new TreeGLEventListener();

  public static void main(String[] args) {
    new TreeApp();
  }

  public TreeApp() {

    super("A Tree");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
