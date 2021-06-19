package mts.teta.resizer.imageprocessor;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ImageProcessor {

  public void crop(File file, CropParams params) {
    MarvinImage image = MarvinImageIO.loadImage(file.getAbsolutePath());

    MarvinPluginCollection.crop(
            image.clone(),
            image, params.getX(),
            params.getY(),
            params.getWidth(),
            params.getHeight()
    );
    MarvinImageIO.saveImage(image, file.getAbsolutePath());
  }

  public void blur(File file, int blurRadius) {
    MarvinImage image = MarvinImageIO.loadImage(file.getAbsolutePath());
    MarvinPluginCollection.gaussianBlur(image.clone(), image, blurRadius);
    MarvinImageIO.saveImage(image, file.getAbsolutePath());
  }


  public void processImage(BufferedImage image, ResizerApp app) throws BadAttributesException {
    if (!AttributesValidator.areValidAttributes(app)) {
      throw new BadAttributesException("Please check params!");
    }

    File outputFile = app.getOutputFile();
    double quality = (double) app.getQuality() / 100;
    int width = app.getWidth() != 0 ? app.getWidth() : image.getWidth();
    int height = app.getHeight() != 0 ? app.getHeight() : image.getHeight();

    CropParams cropParams = app.getCropParams() != null
            ? new CropParams.Builder()
              .width(app.getCropParams()[0])
              .height(app.getCropParams()[1])
              .x(app.getCropParams()[2])
              .y(app.getCropParams()[3])
              .build()
            : new CropParams.Builder()
              .x(0)
              .y(0)
              .width(width)
              .height(height)
              .build();

    try {
      Thumbnails
              .of(app.getInputFile())
              .size(width, height)
              .keepAspectRatio(false)
              .outputQuality(quality)
              .outputFormat(app.getFormat().toLowerCase(Locale.ROOT))
              .toFile(outputFile);

      this.blur(outputFile, app.getBlurRadius());
      this.crop(outputFile, cropParams);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
