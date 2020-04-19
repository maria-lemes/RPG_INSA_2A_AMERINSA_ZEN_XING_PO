import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

    public class ImagePanel extends JPanel {
        private Image image;

        public ImagePanel(FlowLayout var1) {
            super(var1);
        }

        public void setBackground(Image var1) {
            this.image = var1;
        }

        public void paintComponent(Graphics var1) {
            super.paintComponent(var1);
            var1.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), (ImageObserver)null);
        }
    }


