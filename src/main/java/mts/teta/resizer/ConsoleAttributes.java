package mts.teta.resizer;

import mts.teta.resizer.imageprocessor.AttributesValidator;
import picocli.CommandLine;

import java.io.File;

public class ConsoleAttributes {
  @CommandLine.Parameters(index = "0", description = "input-file")
  private File inputFile;

  @CommandLine.Parameters(index = "1", description = "output-file")
  private File outputfile;

  @CommandLine.Option(names = {"--resize", "-r"}, arity = "2", description = "resize the image format type")
  private int[] resizeParams = new int[2];

  @CommandLine.Option(names = {"--quality", "-q"}, description = "JPEG/PNG compression level")
  private int quality = AttributesValidator.MAX_QUALITY;

  @CommandLine.Option(names = {"--crop", "-c"}, arity = "4", description = "resize the image")
  private int[] cropParams = null;

  @CommandLine.Option(names = {"--blur", "-b"}, description = "reduce image noise detail levels ")
  private int blurRadius = AttributesValidator.MIN_BLUR_RADIUS;

  @CommandLine.Option(names = {"--format", "-f"}, description = "The image format type")
  private String format = AttributesValidator.DEFAULT_FORMAT;

  public void setInputFile(final File file) {
    this.inputFile = file;
  }

  public void setOutputFile(final File file) {
    this.outputfile = file;
  }

  public void setResizeWidth(int width) {
    this.resizeParams[0] = width;
  }

  public void setResizeHeight(int height) {
    this.resizeParams[1] = height;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }

  public File getInputFile() {
    return this.inputFile;
  }


  public File getOutputFile() {
    return this.outputfile;
  }

  public int getQuality() {
    return quality;
  }

  public int getBlurRadius() {
    return blurRadius;
  }

  public String getFormat() {
    return this.format;
  }

  public int[] getCropParams() {
    return cropParams;
  }

  public int getWidth() {
    return this.resizeParams[0];
  }

  public int getHeight() {
    return this.resizeParams[1];
  }

}
