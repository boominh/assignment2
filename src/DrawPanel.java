import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    ArrayList<IPanelDrawable> drawables = new ArrayList<>();
    ArrayList<BufferedImage> images = new ArrayList<>();

    public void addDrawable(IPanelDrawable drawable){
        try {
            BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(drawable.getImagePath()));    
            images.add(image);
            drawables.add(drawable);
        } 
        catch (IOException ex) {
                ex.printStackTrace();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < drawables.size(); i++) {
            g.drawImage(
                images.get(i),
                (int) Math.round(drawables.get(i).getPosition().x), 
                (int) Math.round(drawables.get(i).getPosition().y), 
                null
            ); // see javadoc for more info on the parameters
        }
    }
}
