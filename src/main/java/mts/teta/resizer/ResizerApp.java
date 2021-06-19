package mts.teta.resizer;

import mts.teta.resizer.imageprocessor.ImageProcessor;
import picocli.CommandLine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "resizer", description = "convert input-file", mixinStandardHelpOptions = true, version = "resizer 0.0.1")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {
  public static void main(String... args) {
    int exitCode = runConsole(args);
    System.exit(exitCode);
  }

  protected static int runConsole(String[] args) {
    return new CommandLine(new ResizerApp()).execute(args);
  }

  @Override
  public Integer call() throws Exception {
    BufferedImage image = ImageIO.read(this.getInputFile());
    ImageProcessor imageProcessor = new ImageProcessor();
    imageProcessor.processImage(image, this);
    return 0;
  }
}
