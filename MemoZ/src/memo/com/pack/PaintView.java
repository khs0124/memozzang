package memo.com.pack;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PaintView extends View
{
  private static final String LOG_TAG = "PaintView";
  private static final float TOUCH_TOLERANCE = 4.0F;
  private boolean isActive = true;
  private Bitmap mBitmap;
  private Paint mBitmapPaint;
  private Canvas mCanvas;
  private int mMode;
  private Paint mPaint;
  private Path mPath;
  private float mX;
  private float mY;

  public PaintView(Context paramContext)
  {
    super(paramContext);
    initView();
  }

  public PaintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }

  public PaintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }

  private static Paint createPaint(int paramInt)
  {
    Paint localPaint1 = new Paint();
    if (localPaint1 == null);
    for (Paint localPaint2 = null; ; localPaint2 = localPaint1)
    {
      return localPaint2;
      localPaint1.setAntiAlias(true);
      localPaint1.setDither(true);
      localPaint1.setColor(paramInt);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint1.setStrokeJoin(Paint.Join.ROUND);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
    }
  }

  private void initView()
  {
    Resources localResources = getResources();
    int i = localResources.getInteger(2131034112);
    int j = localResources.getInteger(2131034113);
    this.mPaint = createPaint(-16777216);
    if (this.mPaint != null)
      SetColorMode(0);
    try
    {
      this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (this.mBitmap == null)
        return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        Log.e("PaintView", "Error in initView ", localThrowable);
        continue;
        this.mCanvas = new Canvas(this.mBitmap);
        this.mPath = new Path();
        this.mBitmapPaint = new Paint(4);
        this.mMode = 0;
      }
    }
  }

  private void touch_move(float paramFloat1, float paramFloat2)
  {
    if (this.mPath == null);
    while (true)
    {
      return;
      float f1 = Math.abs(paramFloat1 - this.mX);
      float f2 = Math.abs(paramFloat2 - this.mY);
      if ((f1 < 4.0F) && (f2 < 4.0F))
        continue;
      this.mPath.quadTo(this.mX, this.mY, (paramFloat1 + this.mX) / 2.0F, (paramFloat2 + this.mY) / 2.0F);
      this.mX = paramFloat1;
      this.mY = paramFloat2;
    }
  }

  private void touch_start(float paramFloat1, float paramFloat2)
  {
    if (this.mPath == null);
    while (true)
    {
      return;
      this.mPath.reset();
      this.mPath.moveTo(paramFloat1, paramFloat2);
      this.mX = paramFloat1;
      this.mY = paramFloat2;
    }
  }

  private void touch_up()
  {
    if (this.mPaint == null);
    while (true)
    {
      return;
      if ((this.mCanvas != null) && (this.mPath != null))
      {
        this.mPath.lineTo(this.mX, this.mY);
        if (this.mMode == 0)
          this.mCanvas.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        continue;
      }
    }
  }

  public void SetColorMode(int paramInt)
  {
    if (this.mPaint == null);
    while (true)
    {
      return;
      Resources localResources = getResources();
      float f1 = 0.1F * localResources.getInteger(2131034128);
      float f2 = 0.1F * localResources.getInteger(2131034129);
      this.mMode = paramInt;
      this.mPaint.setXfermode(null);
      this.mPaint.setAlpha(255);
      switch (paramInt)
      {
      default:
        break;
      case 0:
        this.mPaint.setStrokeWidth(f1);
        break;
      case 1:
        this.mPaint.setStrokeWidth(f2);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
    }
  }

  public Canvas getCanvas()
  {
    return this.mCanvas;
  }

  public boolean isActive()
  {
    return this.isActive;
  }

  public boolean isEraser()
  {
    if (1 == this.mMode);
    for (int i = 1; ; i = 0)
      return i;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mPaint == null);
    while (true)
    {
      return;
      if ((this.mBitmap != null) && (this.mCanvas != null) && (this.mPath != null) && (this.mBitmapPaint != null))
      {
        if (this.mMode == 0)
        {
          paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, this.mBitmapPaint);
          if ((this.mPath == null) || (this.mPath.isEmpty()))
            continue;
          paramCanvas.drawPath(this.mPath, this.mPaint);
          continue;
        }
        this.mCanvas.drawPath(this.mPath, this.mPaint);
        paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, this.mBitmapPaint);
        continue;
      }
    }
  }

  public void onResize()
  {
    Object localObject = null;
    Resources localResources = getResources();
    int i = localResources.getInteger(2131034112);
    int j = localResources.getInteger(2131034113);
    try
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(this.mBitmap, i, j, true);
      localObject = localBitmap;
      if (localObject == null)
        return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        Log.e("PaintView", "Error in initView ", localThrowable);
        continue;
        this.mBitmap.recycle();
        this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.mCanvas = null;
        this.mCanvas = new Canvas(this.mBitmap);
        this.mCanvas.drawBitmap(localObject, 0.0F, 0.0F, this.mBitmapPaint);
      }
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (!this.isActive)
    {
      i = 0;
      return i;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      i = 1;
      break;
      touch_start(f1, f2);
      continue;
      touch_move(f1, f2);
      invalidate();
      continue;
      touch_up();
      invalidate();
    }
  }

  // ERROR //
  public boolean save(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	com/htc/rosiewidgets/note/PaintView:mBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +9 -> 13
    //   7: iconst_0
    //   8: istore 6
    //   10: iload 6
    //   12: ireturn
    //   13: new 261	java/io/BufferedOutputStream
    //   16: dup
    //   17: new 263	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 269	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 124	com/htc/rosiewidgets/note/PaintView:mBitmap	Landroid/graphics/Bitmap;
    //   33: getstatic 275	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: bipush 100
    //   38: aload_2
    //   39: invokevirtual 279	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   42: pop
    //   43: aload_2
    //   44: invokevirtual 284	java/io/OutputStream:flush	()V
    //   47: iconst_1
    //   48: istore 6
    //   50: goto -40 -> 10
    //   53: astore 8
    //   55: aload 8
    //   57: astore 4
    //   59: ldc 8
    //   61: new 286	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 289
    //   71: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 4
    //   76: invokevirtual 297	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload 4
    //   87: invokestatic 132	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   90: pop
    //   91: iconst_0
    //   92: istore 6
    //   94: goto -84 -> 10
    //   97: astore_3
    //   98: aload_3
    //   99: astore 4
    //   101: goto -42 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   13	29	53	java/lang/Exception
    //   29	47	97	java/lang/Exception
  }

  public void saveCurrentPostState()
  {
    if (this.mPaint == null);
    while (true)
    {
      return;
      if ((this.mCanvas != null) && (this.mPath != null))
      {
        if (this.mMode == 0)
          this.mCanvas.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        touch_start(this.mX, this.mY);
        continue;
      }
    }
  }

  public void setActive(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }

  public void setEraser(boolean paramBoolean)
  {
    if (paramBoolean);
    for (this.mMode = 1; ; this.mMode = 0)
    {
      SetColorMode(this.mMode);
      return;
    }
  }

  public void setImage(String paramString)
  {
    Object localObject = null;
    Log.d("PaintView", paramString);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString);
      localObject = localBitmap;
      if (localObject == null)
        return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        Log.e("PaintView", "Error in setImage ", localThrowable);
        continue;
        if ((this.mCanvas == null) || (this.mBitmapPaint == null))
          continue;
        this.mCanvas.drawBitmap(localObject, 0.0F, 0.0F, this.mBitmapPaint);
      }
    }
  }
}