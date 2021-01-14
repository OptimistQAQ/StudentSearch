package util;

import javax.swing.*;

/**
 * @author Optimist
 */
public class DialogUtil {

    public static void showWarning(String title,String message){
        JOptionPane.showMessageDialog(null,
                message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void showMessage(String title,String message){
        JOptionPane.showMessageDialog(null,
                message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
