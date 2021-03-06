package TurtleGraphic;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class TurtleView extends JPanel implements PropertyChangeListener {
    private Turtle turtle;
    private final int diameter;
    public TurtleView(Turtle turtle){
        this.turtle = turtle;
        turtle.addPropertyChangeListener(this);
        this.diameter = 5;

    }
    
    public void paintComponent(Graphics gc) {
        
        super.paintComponent(gc);
        Point prev = turtle.getPath().get(0);
        if (turtle.getPenFlag()) gc.fillOval(turtle.getLocation().getXCoor(), turtle.getLocation().getYCoor(), diameter, diameter);
        else gc.drawOval(turtle.getLocation().getXCoor(), turtle.getLocation().getYCoor(), diameter, diameter); 
        for (Point cur : turtle.getPath()){
        	if(!cur.getEndPoint() && !prev.getEndPoint()){
                gc.setColor(cur.getColor());
                if(prev.getYCoor() == -1 || prev.getYCoor() == Turtle.WORLD_SIZE +1){
                    prev = new Point(cur.getXCoor(), cur.getYCoor(), Color.BLACK);
                    continue;
                }
                if(prev.getXCoor() == -1 || prev.getXCoor() == Turtle.WORLD_SIZE +1){
                    prev = new Point(cur.getXCoor(), cur.getYCoor(), Color.BLACK);
                    continue;
                }
                gc.drawLine(prev.getXCoor(), prev.getYCoor(), cur.getXCoor(), cur.getYCoor());
        	}
        	prev = new Point(cur.getXCoor(), cur.getYCoor(), Color.BLACK);
        }

    }
    
    public void setModel(Turtle turtle) {
        this.turtle.initSupport();
        this.turtle.addPropertyChangeListener(this);
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0){
        repaint();
    }
}