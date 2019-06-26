/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;

/**
 * Component for drawing
 *
 * @author Nipuna
 */
public class DrawArea extends JComponent {
    //Image is which we're going to draw

    private Image image;
    //Graphics2D object ==> used to draw on
    private Graphics2D g2=null;
    //Mouse coordinates
    private int currentX, currentY, oldX, oldY;

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //save coordinates x,y when mouse is pressed
                oldX = e.getX();
                oldY = getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            //coordinates of x,y when drag mouse
            public void mouseDragged(MouseEvent e) {
                //draw line ar g2 context not null
                currentX = e.getX();
                currentY = e.getY();
                if (g2 != null) {
                    g2.drawLine(oldX, oldY, currentX, currentX);
                    //refresh draw area to repaint
                    repaint();
                    //store current coordinates as old coordinates
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image != null) {
            //image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            //enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //clear draw area
            clear();

            g.drawImage(image, 0, 0, null);
        }

    }

    //now we create exposed methods
    public void clear() {
        g2.setPaint(Color.white);
        //draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void red() {
        //apply red color on g2 context
        g2.setPaint(Color.red);
    }

    public void black() {
        //apply black color on g2 context
        g2.setPaint(Color.black);
    }

    public void magenta() {
        //apply magenta color on g2 context
        g2.setPaint(Color.magenta);
    }

    public void green() {
        //apply green color on g2 context
        g2.setPaint(Color.green);
    }

    public void blue() {
        //apply blue color on g2 context
        g2.setPaint(Color.blue);
    }
}
