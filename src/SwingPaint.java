/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nipuna
 */
public class SwingPaint {

    JButton clearBtn = new JButton("Clear");
    JButton blackBtn = new JButton("Black");
    JButton blueBtn = new JButton("Blue");
    JButton greenBtn = new JButton("Green");
    JButton redBtn = new JButton("Red");
    JButton magentaBtn = new JButton("Magenta");
    DrawArea drawArea;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
            } else if (e.getSource() == redBtn) {
                drawArea.red();
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
            } else if (e.getSource() == magentaBtn) {
                drawArea.magenta();
            }
        }
    };

    public static void main(String args[]) {
        new SwingPaint().show();
    }

    public void show() {
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        //set layout on ccontent pane
        content.setLayout(new BorderLayout());
        //create draw area
        drawArea=new DrawArea();
        
        //create controls to apply and call clear feature
        JPanel controls = new JPanel();

        clearBtn.addActionListener(actionListener);

        blackBtn.addActionListener(actionListener);

        blueBtn.addActionListener(actionListener);

        greenBtn.addActionListener(actionListener);

        redBtn.addActionListener(actionListener);

        magentaBtn.addActionListener(actionListener);

        //add to panel
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magentaBtn);
        controls.add(clearBtn);

        //add to content pane
        content.add(controls, BorderLayout.NORTH);
        
        //add to content pane
        content.add(drawArea, BorderLayout.CENTER);

        frame.setSize(600, 600);
        //can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set location
        frame.setLocationRelativeTo(null);
        //show the swing paint result
        frame.setVisible(true);

    }
}
