import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Snowflake extends JPanel {
    public int order = 2; 
    public double x1 = 120;
    public double y1 = 320;
    public double x2 = 440;
    public double y2 = 320;
    public double x3 = 280;
    public double y3 = 40;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSide(g, order, x1, y1, x2, y2);
        drawSide(g, order, x2, y2, x3, y3);
        drawSide(g, order, x3, y3, x1, y1);
    }

    public double getx1(){
        return x1;
    }
    public double getx2(){
        return x2;
    }
    public double getx3(){
        return x3;
    }
    public double gety1(){
        return y1;
    }
    public double gety2(){
        return y2;
    }
    public double gety3(){
        return y3;
    }
    public void setOrder(int ord){
        order = ord;
    }
    public int getOrder(){
        return order;
    }

    public void drawSide(Graphics g, int ord, double xA, double yA, double xE, double yE){
        double xLength, yLength, xB, yB, xC, yC, xD, yD;
        
        if(ord == 0){
            Graphics2D g2d = (Graphics2D) g;
            AffineTransform oldAT = g2d.getTransform();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.scale((JFrame.WIDTH), (JFrame.HEIGHT/2));
            Shape line = new Line2D.Double(xA, yA, xE, yE);
            g2d.draw(line);
            g2d.setTransform(oldAT);
        } else{
            xLength = xE - xA;
            yLength = yE - yA;
            xB = xA + (xLength / 3);
            yB = yA + (yLength / 3);
            xD = xA + 2 * xLength / 3;
            yD = yA + 2 * yLength / 3;
            xC = (0.5 * (xA + xE) + Math.sqrt(3) * (yA - yE)/6);
            yC = (0.5 * (yA + yE) + Math.sqrt(3) * (xE - xA)/6);
            drawSide(g, ord-1, xA, yA, xB, yB);
            drawSide(g, ord-1, xB, yB, xC, yC);
            drawSide(g, ord-1, xC, yC, xD, yD);
            drawSide(g, ord-1, xD, yD, xE, yE);
        }

    }

}