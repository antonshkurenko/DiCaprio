package oscar.dicaprio.mechanics.physics.enemies;

import oscar.dicaprio.utils.Constants;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/9/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Enemy {
  protected float mWidth;
  protected float mHeight;
  protected float mX;
  protected float mY;
  protected float mDensity;

  protected Enemy(float mWidth, float mHeight, float mX, float mY, float mDensity) {
    this.mWidth = mWidth;
    this.mHeight = mHeight;
    this.mX = mX;
    this.mY = mY;
    this.mDensity = mDensity;
  }

  //region Getters and setters
  public float getWidth() {
    return mWidth;
  }

  public float getHeight() {
    return mHeight;
  }

  public float getX() {
    return mX;
  }

  public float getY() {
    return mY;
  }

  public float getDensity() {
    return mDensity;
  }
  //endregion

  public static class Builder {
    private float mWidth = 1f;
    private float mHeight = 1f;
    private float mX = Constants.ENEMY_X;
    private float mY = Constants.RUNNING_SHORT_ENEMY_Y;
    private float mDensity = Constants.ENEMY_DENSITY;

    public Builder setWidth(float width) {
      this.mWidth = width;
      return this;
    }

    public Builder setHeight(float height) {
      this.mHeight = height;
      return this;
    }

    public Builder setX(float x) {
      this.mX = x;
      return this;
    }

    public Builder setY(float y) {
      this.mY = y;
      return this;
    }

    public Builder setDensity(float density) {
      this.mDensity = density;
      return this;
    }

    public Enemy createEnemy() {
      return new Enemy(mWidth, mHeight, mX, mY, mDensity);
    }
  }
}