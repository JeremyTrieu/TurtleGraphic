package TurtleGraphic;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import tools.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TurtlePanel extends JPanel implements ActionListener {

	    private Turtle turtle;
	    private TurtleView view;
	    private JFrame frame;
	    private JButton northButton;
	    private JButton southButton;
	    private JButton westButton;
	    private JButton eastButton;
	    private JButton clearButton;
	    private JButton penButton;
	    private JButton colorButton;

	    public static int FRAME_WIDTH = 500;
	    public static int FRAME_HEIGHT = 300;

	    public TurtlePanel() {

	        turtle = new Turtle();
	        view = new TurtleView(turtle);
	        frame = new JFrame();
	        setLayout((new GridLayout(1, 2)));
	        JPanel controlPanel = new JPanel();
	        add(controlPanel);
	        add(view);
	        
	        controlPanel.setBackground(Color.PINK);
	        view.setBackground(Color.WHITE);


	        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));

	        northButton = new JButton("North");
	        northButton.addActionListener((ActionListener) this);
	        controlPanel.add(northButton);

	        southButton = new JButton("South");
	        southButton.addActionListener((ActionListener) this);
	        controlPanel.add(southButton);

	        westButton = new JButton("West");
	        westButton.addActionListener((ActionListener) this);
	        controlPanel.add(westButton);

	        eastButton = new JButton("East");
	        eastButton.addActionListener((ActionListener) this);
	        controlPanel.add(eastButton);

	        clearButton = new JButton("Clear");
	        clearButton.addActionListener((ActionListener) this);
	        controlPanel.add(clearButton);

	        penButton = new JButton("Pen");
	        penButton.addActionListener((ActionListener) this);
	        controlPanel.add(penButton);

	        colorButton = new JButton("Color");
	        colorButton.addActionListener((ActionListener) this);
	        controlPanel.add(colorButton);

	        Container container = frame.getContentPane();
	        container.add(this);

	        frame.setJMenuBar(createMenuBar());

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setTitle("Turtle Graphic");
	        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	        frame.setVisible(true);
	    }

	    protected JMenuBar createMenuBar() {
	        JMenuBar menuBar = new JMenuBar();
	        JMenu menu = Utilities.makeMenu("File", new String[] {"New", "Save As", "Open", "Quit"}, this);
	        menuBar.add(menu);

	        JMenu editMenu = Utilities.makeMenu("Edit", new String[] {"North", "South", "East", "West", "Pen", "Color"}, this);
	        menuBar.add(editMenu);

	        JMenu helpMenu = Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
	        menuBar.add(helpMenu);

	        return menuBar;
	    }

	    public void actionPerformed(ActionEvent ae) {
	        String cmnd = ae.getActionCommand();
	        if(cmnd == "About"){
	            Utilities.inform("Cyberdellic Designs Stoplight Simulator 1.1, 2020. All rights reserved.");
	        }
	        else if(cmnd == "Help" ){
	            Utilities.inform("Click or select direction buttons to draw at the desired direction");
	        }
	        else if(cmnd == "Pen"){
	          turtle.setPenFlag();
	          System.out.println(turtle.getColor());
	        } 
	        else if(cmnd == "Clear"){
	            turtle.clearPath();
	        }
	        else if(cmnd == "Color"){
	            Color newColor = JColorChooser.showDialog(null, "Choose a color", turtle.getLocation().getColor());
	            turtle.getLocation().setColor(newColor);
	        }
	        else if (cmnd == "Save") {
	            try {
	                //String fName = Utilities.ask("File Name?");
	                String fName = Utilities.getFileName(null, false);
	                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
	                os.writeObject(turtle);
	                os.close();
	            } catch (Exception err) {
	                Utilities.error("Invalid file");
	            }
	        }
	        else if (cmnd == "Open") {
	            try {
	                String fName = Utilities.getFileName(null, true);
	                ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
	                turtle = (Turtle) is.readObject();
	                view.setModel(turtle);
	                is.close();
	            } catch (Exception err) {
	                Utilities.error(err.getMessage());
	            }
	        } 
	        else if (cmnd == "New") {
	            turtle = new Turtle();
	            view.setModel(turtle);
	        } 
	        else if (cmnd == "Quit") {
	            System.exit(1);
	        }
	        else if(cmnd == "North"){
	            int steps = Integer.parseInt(Utilities.ask("How many steps:"));
	            turtle.turn(Heading.NORTH);
	            turtle.move(steps);
	            System.out.println("Test");
	        }
	        else if(cmnd == "South"){
	            int steps = Integer.parseInt(Utilities.ask("How many steps:"));
	            turtle.turn(Heading.SOUTH);
	            turtle.move(steps);
	        }
	        else if(cmnd == "East"){
	            int steps = Integer.parseInt(Utilities.ask("How many steps:"));
	            turtle.turn(Heading.EAST);
	            turtle.move(steps);
	        }
	        else if(cmnd == "West"){
	            int steps = Integer.parseInt(Utilities.ask("How many steps:"));
	            turtle.turn(Heading.WEST);
	            turtle.move(steps);
	        }
	        else  {
	            Utilities.error("Wrong order: " + cmnd);
	        }
	    }
	    public static void main(String[] args) {
	            TurtlePanel turtleApp = new TurtlePanel();
	        }
	    
	}
