package memo.com.pack;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

public class AnimateDrawable {


	  private int mAlphaFrom;
	  private int mAlphaTo;
	  private Animation mAnimation;
	  private int mOffXRot = 0;
	  private int mOffYRot = 0;
	  private Transformation mTransformation = new Transformation();
	  private int mYFrom;
	  private int mYTo;
	  private Drawable mdrFly;
	  private float mfPercent = 0.0F;

	  public AnimateDrawable(Drawable paramDrawable)
	  {
	    super(paramDrawable);
	  }

	  public AnimateDrawable(Drawable paramDrawable, Animation paramAnimation)
	  {
	    super(paramDrawable);
	    this.mAnimation = paramAnimation;
	  }

	  public void draw(Canvas paramCanvas)
	  {
	    Drawable localDrawable = getProxy();
	    int i = 255;
	    float f = 0.0F;
	    Animation localAnimation = this.mAnimation;
	    if (localAnimation != null)
	    {
	      long l1 = localAnimation.getDuration();
	      long l2 = AnimationUtils.currentAnimationTimeMillis() - localAnimation.getStartTime();
	      if (l2 > l1)
	        l2 = l1;
	      f = 1.0F * (float)l2 / (float)l1;
	      i = this.mAlphaFrom + (int)(f * (this.mAlphaTo - this.mAlphaFrom));
	    }
	    int k;
	    if (localDrawable != null)
	    {
	      k = paramCanvas.save();
	      if (localAnimation != null)
	      {
	        i = this.mAlphaFrom + (int)(f * (this.mAlphaTo - this.mAlphaFrom));
	        int m = 255 - i;
	        if (m > 128)
	          m = 255;
	        localDrawable.setAlpha(m);
	        localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.mTransformation);
	        paramCanvas.translate(this.mOffXRot, this.mOffYRot);
	        paramCanvas.concat(this.mTransformation.getMatrix());
	        paramCanvas.translate(0.0F, 0.0F);
	      }
	    }
	    try
	    {
	      localDrawable.draw(paramCanvas);
	      paramCanvas.restoreToCount(k);
	      if (this.mdrFly != null)
	      {
	        j = paramCanvas.save();
	        paramCanvas.translate(0.0F, this.mYFrom + (int)(f * (this.mYTo - this.mYFrom)));
	        if (i > 128)
	          i = 255;
	        this.mdrFly.setAlpha(i);
	      }
	    }
	    catch (Exception localException2)
	    {
	      try
	      {
	        int j;
	        this.mdrFly.draw(paramCanvas);
	        paramCanvas.restoreToCount(j);
	        this.mfPercent = f;
	        return;
	        localException2 = localException2;
	        localException2.printStackTrace();
	      }
	      catch (Exception localException1)
	      {
	        while (true)
	          localException1.printStackTrace();
	      }
	    }
	  }

	  public Animation getAnimation()
	  {
	    return this.mAnimation;
	  }

	  public float getPercent()
	  {
	    return this.mfPercent;
	  }

	  public boolean hasEnded()
	  {
	    if ((this.mAnimation == null) || (this.mAnimation.hasEnded()));
	    for (int i = 1; ; i = 0)
	      return i;
	  }

	  public boolean hasStarted()
	  {
	    if ((this.mAnimation != null) && (this.mAnimation.hasStarted()));
	    for (int i = 1; ; i = 0)
	      return i;
	  }

	  public void setAlpha(int paramInt1, int paramInt2)
	  {
	    this.mAlphaFrom = paramInt1;
	    this.mAlphaTo = paramInt2;
	  }

	  public void setAnimation(Animation paramAnimation)
	  {
	    this.mAnimation = paramAnimation;
	  }

	  public void setFlying(Drawable paramDrawable, int paramInt1, int paramInt2)
	  {
	    this.mdrFly = paramDrawable;
	    this.mYFrom = paramInt1;
	    this.mYTo = paramInt2;
	  }

	  public void setOffRot(int paramInt1, int paramInt2)
	  {
	    this.mOffXRot = paramInt1;
	    this.mOffYRot = paramInt2;
	  }
	}
}
