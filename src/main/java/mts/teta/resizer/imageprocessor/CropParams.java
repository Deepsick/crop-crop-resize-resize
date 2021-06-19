package mts.teta.resizer.imageprocessor;

public class CropParams {
  private final int x;
  private final int y;
  private final int width;
  private final int height;

  public CropParams(final int x, final int y, final int width, final int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public static class Builder {
    private int x;
    private int y;
    private int width;
    private int height;

    public Builder x(int x) {
      this.x = x;
      return this;
    }

    public Builder y(int y) {
      this.y = y;
      return this;
    }

    public Builder width(int width) {
      this.width = width;
      return this;
    }

    public Builder height(int height) {
      this.height = height;
      return this;
    }

    public CropParams build() {
      return new CropParams(this.x, this.y, this.width, this.height);
    }
  }
}
