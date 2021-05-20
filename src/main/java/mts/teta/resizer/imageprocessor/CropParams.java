package mts.teta.resizer.imageprocessor;

public record CropParams(int x, int y, int width, int height) {
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
