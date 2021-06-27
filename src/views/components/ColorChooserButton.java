package views.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ColorChooserButton extends JButton {
    private Color current;
    private List<ColorChangedListener> listeners = new ArrayList<>();
    private Component openRelativeTo = null;

    public ColorChooserButton(Color c) {
        setSelectedColor(c);
        addActionListener(actionEvent -> {
            Color newColor = JColorChooser.showDialog(openRelativeTo, "Choose a color", current);
            setSelectedColor(newColor);
        });
    }

    public static ImageIcon createIcon(Color main, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width - 1, height - 1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }

    public Color getSelectedColor() {
        return current;
    }

    public void setSelectedColor(Color newColor) {
        setSelectedColor(newColor, true);
    }

    public void setSelectedColor(Color newColor, boolean notify) {
        if (newColor == null) return;

        current = newColor;
        setIcon(createIcon(current, 16, 16));
        repaint();

        if (notify) {
            // Notify everybody that may be interested.
            for (ColorChangedListener l : listeners) {
                l.colorChanged(newColor);
            }
        }
    }

    public void setOpenRelativeTo(Component component) {
        this.openRelativeTo = openRelativeTo;
    }

    public void addColorChangedListener(ColorChangedListener toAdd) {
        listeners.add(toAdd);
    }

    public interface ColorChangedListener {
        void colorChanged(Color newColor);
    }
}