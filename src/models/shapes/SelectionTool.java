package models;

import java.awt.*;

public class SelectionTool extends Rectangle {
    public SelectionTool(Point topCorner) {
        super(topCorner);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int px = Math.min(topCorner.x, bottomCorner.x);
        int py = Math.min(topCorner.y, bottomCorner.y);
        int pw = Math.abs(topCorner.x - bottomCorner.x);
        int ph = Math.abs(topCorner.y - bottomCorner.y);
        setLocation(px, py);
        setSize(pw, ph);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(0, 120, 215, 255));
        g2d.draw(this);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(new Color(0, 120, 204, 80));
        g2d.fill(this);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.BLACK);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    }
}
