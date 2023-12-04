package xo_project;

import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OurGraphApp extends JFrame {

    private int x = 900, y = 600;
    static GLCanvas glcanvas = null;
    static FPSAnimator animator = null;

    public static void main(String[] args) {
        final OurGraphApp app = new OurGraphApp();
        animator.start();

        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                app.setVisible(true);
                glcanvas.requestFocusInWindow();
            }
        }
        );
    }

    public OurGraphApp() {

        super("Our Graph Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OurGraphGLEventListener listener = new OurGraphGLEventListener(x, y);
        OurGraphGLEventListener mmd = new OurGraphGLEventListener(x, y);
        animator = new FPSAnimator(glcanvas, 60);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(mmd);
        glcanvas.addMouseMotionListener(mmd);
        glcanvas.addMouseListener(mmd);

        mmd.setGLCanvas(glcanvas);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(x, y);
        centerWindow(this);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}
