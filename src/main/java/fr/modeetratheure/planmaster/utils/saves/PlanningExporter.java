package fr.modeetratheure.planmaster.utils.saves;

import fr.modeetratheure.planmaster.display.componentsdata.components.PlanningPreview;
import fr.modeetratheure.planmaster.utils.PMLogger;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;

public class PlanningExporter {

    File image;
    PMLogger logger;

    public PlanningExporter(String imagePath){
        image = new File(imagePath);
        logger = new PMLogger(PlanningExporter.class);
    }

    public void exports(PlanningPreview planning, String type, String imagePath){
        WritableImage wimage = planning.snapshot(new SnapshotParameters(), null);
        int width = (int) wimage.getWidth();
        int height = (int) wimage.getHeight();
        int[] pixels = new int[width * height];

        wimage.getPixelReader().getPixels(
                0, 0, width, height,
                (WritablePixelFormat<IntBuffer>) wimage.getPixelReader().getPixelFormat(),
                pixels, 0, width
        );

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < height; y ++){
            for(int x = 0; x < width; x ++){
                int pixel = pixels[y * width + x];
                int r = (pixel & 0xFF0000) >> 16;
                int g = (pixel & 0xFF00) >> 8;
                int b = pixel & 0xFF;
                bufferedImage.getRaster().setPixel(x, y, new int[]{r, g, b});
            }
        }

        try {
            ImageIO.write(bufferedImage, type, new File(imagePath));
        } catch (IOException e) {
            logger.error("Failed to export planning as image (imageName)");
        }
    }

}
