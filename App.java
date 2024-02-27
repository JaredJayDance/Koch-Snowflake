import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App {

    public App(){
        JFrame frame = new JFrame();
        Snowflake snowy = new Snowflake();
        JSlider slider = new JSlider(0, 11, snowy.getOrder());

        slider.setPreferredSize(new Dimension(200, 80));
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);       

        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(600, 600));
        frame.add(snowy);
        frame.add(slider,BorderLayout.SOUTH);

        slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                snowy.setOrder(slider.getValue());
                frame.getContentPane().validate();
                snowy.repaint();
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                double frameWidth = frame.getWidth();
                double frameHeight = frame.getHeight();
                double xPercent = frameWidth/600;
                double yPercent = frameHeight/600;
                double smaller = 0;

                if(xPercent < yPercent){
                    smaller = xPercent;
                } else {
                    smaller = yPercent;
                }
                snowy.x1 = (120 * smaller);
                snowy.y1 = (320 * smaller);
                snowy.x2 = (440 * smaller);
                snowy.y2 = (320 * smaller);
                snowy.x3 = (280 * smaller);
                snowy.y3 = (40 * smaller);
                snowy.repaint();
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Interactive Koch Snowflake");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new App();
    }
}

