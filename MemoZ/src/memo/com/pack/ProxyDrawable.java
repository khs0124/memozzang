package memo.com.pack;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class ProxyDrawable extends Drawable
{
  private boolean mMutated;
  private Drawable mProxy;

  public ProxyDrawable(Drawable paramDrawable)
  {
    this.mProxy = paramDrawable;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.mProxy != null)
      this.mProxy.draw(paramCanvas);
  }

  public int getIntrinsicHeight()
  {
    if (this.mProxy != null);
    for (int i = this.mProxy.getIntrinsicHeight(); ; i = -1)
      return i;
  }

  public int getIntrinsicWidth()
  {
    if (this.mProxy != null);
    for (int i = this.mProxy.getIntrinsicWidth(); ; i = -1)
      return i;
  }

  public int getOpacity()
  {
    if (this.mProxy != null);
    for (int i = this.mProxy.getOpacity(); ; i = -2)
      return i;
  }

  public Drawable getProxy()
  {
    return this.mProxy;
  }

  public Drawable mutate()
  {
    if ((this.mProxy != null) && (!this.mMutated) && (super.mutate() == this))
    {
      this.mProxy.mutate();
      this.mMutated = true;
    }
    return this;
  }

  public void setAlpha(int paramInt)
  {
    if (this.mProxy != null)
      this.mProxy.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mProxy != null)
      this.mProxy.setColorFilter(paramColorFilter);
  }

  public void setDither(boolean paramBoolean)
  {
    if (this.mProxy != null)
      this.mProxy.setDither(paramBoolean);
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.mProxy != null)
      this.mProxy.setFilterBitmap(paramBoolean);
  }

  public void setProxy(Drawable paramDrawable)
  {
    if (paramDrawable != this)
      this.mProxy = paramDrawable;
  }
}