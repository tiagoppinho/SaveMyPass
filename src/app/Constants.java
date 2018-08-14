package pck;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Class responsable for holding important constants to reduce the amount of repeated code.
 * The porpuse of each constant is to change their value only in one place to avoid conflicts.
 * @author Tiago Pinho
 */
public class Constants {
    
    /* ------------------------- Virtual keyboard and size handlers. ----------------------------- */
    public static final Dimension LOGIN_DEFAULT_SIZE = new Dimension(317, 320);
    public static final Dimension LOGIN_SIZE_WITH_KEYBOARD = new Dimension(557, 320);
    public static final Dimension NEW_PIN_DEFAULT_SIZE = new Dimension(377, 385);
    public static final Dimension NEW_PIN_SIZE_WITH_KEYBOARD = new Dimension(617, 385);
    public static final Dimension NEW_PIN_DEFAULT_SIZE_FIRST_TIME = new Dimension(377, 370);
    public static final Dimension NEW_PIN_SIZE_WITH_KEYBOARD_FIRST_TIME = new Dimension(617, 370);
    /* ------------------------------------------------------------------------------------------- */

    /* ---------------------------------- Color handlers. -------------------------------------- */
    public static final Color KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_CLOSE = new Color(255, 255, 255);
    public static final Color KEYBOARD_SEPARATOR_COLOR_ON_KEYBOARD_OPEN = new Color(0,153,255);
    public static final Color BUTTONS_DEFAULT_COLOR = new Color(51,153,255);
    public static final Color BUTTONS_COLOR_ON_MOUSE_HOVER = new Color(0,39,255);
    public static final Color SIDE_PANEL_BUTTONS_DEFAULT_COLOR = new Color(0,39,255);
    public static final Color SIDE_PANEL_BUTTONS_COLOR_ON_MOUSE_HOVER = new Color(51,99,255);
    public static final Color SIDE_PANEL_BUTTONS_COLOR_ON_MOUSE_CLICK = new Color(51,144,255);
    public static final Color TITLE_BUTTONS_DEFAULT_COLOR = new Color(255, 255, 255);
    public static final Color TITLE_BUTTONS_COLOR_ON_MOUSE_HOVER = new Color(230, 230, 230);
    /* ----------------------------------------------------------------------------------------- */
    
}
