package utils;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Class responsible for extra functionalities. Re-use code!
 * @author Tiago Pinho
 */
public class Customization {
    
    //Variables to handle the draggability of the window.
    private static int xx = 0, xy = 0;
    
    /**
     * Applies underlined text font to a JLabel.
     * @param jLabel JLabel where the underlined text font will be applied.
     */
    public static void underlineText(JLabel jLabel) {
        Font font = jLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel.setFont(font.deriveFont(attributes));
    }
    
    /**
     * Applies draggability events to an undecorated Frame.
     * @param jPanel Panel responsible for the events needed to move the Frame.
     * @param jFrame The Frame that's going to be moved.
     */
    public static void applyDraggability(JPanel jPanel, JFrame jFrame) {
        jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                draggablePanelMousePressed(evt);
            }
        });
        jPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                draggablePanelMouseDragged(evt, jFrame);
            }
        });
    }
    
    private static void draggablePanelMousePressed(java.awt.event.MouseEvent evt) {
        xx = evt.getX();
        xy = evt.getY();
    }
    
    private static void draggablePanelMouseDragged(java.awt.event.MouseEvent evt, JFrame jFrame) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        jFrame.setLocation(x - xx, y - xy);
    }
    
    /**
     * Displays a warning message to the user.
     * @param message Message to be displayed.
     * @param title Title of the message dialog.
     */
    public static void displayWarningMessage(String message, String title){
        JOptionPane.showMessageDialog(null, 
                                    message, 
                                    title, 
                                    JOptionPane.WARNING_MESSAGE);
    }
}
