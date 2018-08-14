package app;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

/**
 * Class responsible for handling some features of the virtual keyboard used on Login and on New PIN creation.
 * @author Tiago Pinho
 */
public class KeyboardHandler {
    
    /**
     * Applies properties to the virtual keyboard buttons received.
     * @param keyboardButtons Array of keyboard buttons to apply properties.
     */
    public static void applyVirtualKeyboardButtonsProperties(JLabel[] keyboardButtons) {
        for(JLabel keyboardButton : keyboardButtons) {
            keyboardButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    keyboardButtonMouseEntered(evt);
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    keyboardButtonMouseExited(evt);
                }
            });
        }
    }
    
    private static void keyboardButtonMouseEntered(java.awt.event.MouseEvent evt) {
        Component button = evt.getComponent();
        button.setBackground(Constants.BUTTONS_COLOR_ON_MOUSE_HOVER);
    }
    
    private static void keyboardButtonMouseExited(java.awt.event.MouseEvent evt) {
        Component button = evt.getComponent();
        button.setBackground(Constants.BUTTONS_DEFAULT_COLOR);
    }
    
    /**
     * Generates new random numbers between 0 and 9 to the virtual keyboard buttons.
     * @param keyboardButtons Array of keyboard buttons to receive new numbers.
     */
    public static void generateNewNumbersForKeyboard(JLabel[] keyboardButtons) {
        ArrayList<Integer> numbers = new ArrayList<>();   
        Random randomGenerator = new Random();
        while(numbers.size() < keyboardButtons.length - 1){
            int random = randomGenerator.nextInt(10);
            if (!numbers.contains(random))
                numbers.add(random);
        }
        
        for(int i = 1; i < keyboardButtons.length; i++)
            keyboardButtons[i].setText(String.valueOf(numbers.get(i - 1)));
        
    }
}
