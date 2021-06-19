package mts.teta.resizer.imageprocessor;

import mts.teta.resizer.ResizerApp;

import java.util.Arrays;
import java.util.Locale;

public class AttributesValidator {
  public static int MIN_QUALITY = 1;
  public static int MAX_QUALITY = 100;
  public static int MIN_HEIGHT = 0;
  public static int MIN_WIDTH = 0;
  public static int MIN_BLUR_RADIUS = 0;
  public static int MAX_BLUR_RADIUS = 10;
  public static String DEFAULT_FORMAT = "jpeg";
  private static String[] ALLOWED_FORMATS = new String[]{"jpeg", "png"};

  private static boolean areCropParamsValid(int[] cropParams) {
    if (cropParams == null) {
      return true;
    }
    for (int param : cropParams) {
      if (param < 0) {
        return false;
      }
    }

    return true;
  }

  public static boolean areValidAttributes(ResizerApp app) {
    return AttributesValidator.areCropParamsValid(app.getCropParams())
            && app.getQuality() >= AttributesValidator.MIN_QUALITY
            && app.getQuality() <= AttributesValidator.MAX_QUALITY
            && app.getBlurRadius() >= AttributesValidator.MIN_BLUR_RADIUS
            && app.getBlurRadius() <= AttributesValidator.MAX_BLUR_RADIUS
            && app.getHeight() >= AttributesValidator.MIN_HEIGHT
            && app.getWidth() >= AttributesValidator.MIN_WIDTH
            && Arrays.asList(ALLOWED_FORMATS).contains(app.getFormat().toLowerCase(Locale.ROOT));
  }
}
