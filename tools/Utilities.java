package tools;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;

public class Utilities {
    public static boolean confirm(String query){
        //Prompting Yes/No questions
        int result = JOptionPane.showConfirmDialog(null, query, "Choose one",
                JOptionPane.YES_NO_OPTION);
        return result == 1;
    }

    public static String ask(String query) {
        //Prompting for input
        return JOptionPane.showInputDialog(null, query);
    }

    public static void inform(String info) {
        //Display small size of information
        JOptionPane.showMessageDialog(null,info);
    }

    public static void inform(String[] items) {
        //Display a large size of information
        String helpString = "";
        for(String item : items){
            helpString += "\n" + item;
        }
//        for(int i = 0; i < items.length; i++) {
//            helpString = helpString + "\n" + items[i];
//        }
        inform(helpString);
    }

    public static void error(String gripe) {
        //Show error message
        JOptionPane.showMessageDialog(null,
                gripe,
                "OOPS!",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void error(Exception gripe) {
        //Show exception message
        gripe.printStackTrace();
        JOptionPane.showMessageDialog(null,
                gripe.getMessage(),
                "OOPS!",
                JOptionPane.ERROR_MESSAGE);
    }

    public static JMenu makeMenu(String name, String[] items, ActionListener handler) {
        //Create a menu
        JMenu result = new JMenu(name);
        for(String item : items){
            JMenuItem newItem = new JMenuItem(item);
            newItem.addActionListener(handler);
            result.add(newItem);
        }
//        for(int i = 0; i < items.length; i++) {
//            JMenuItem item = new JMenuItem(items[i]);
//            item.addActionListener(handler);
//            result.add(item);
//        }
        return result;
    }

    public static String getFileName(String fName, Boolean open) {
        //Prompting for file's name
        JFileChooser chooser = new JFileChooser();
        String result = null;
        if (fName != null) {
            // open chooser in directory of fName
            chooser.setCurrentDirectory(new File(fName));
        }
        if (open) {
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                result= chooser.getSelectedFile().getPath();
            }
        } else {
            int returnVal = chooser.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                result= chooser.getSelectedFile().getPath();
            }
        }
        return result;
    }
}
