package memo.com.pack;


import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class StackView extends View
{
  private static final String LOG_TAG = "StackView";
  private static final int MAX_DEGREE = 7;
  private static final Paint paintAA;
  private static int[] resDrawNote;
  private int HEIGHT = 0;
  private int WIDTH = 0;
  Context activity;
  int index;
  private Bitmap mBitmap = null;
  private AnimateDrawable mDrawable = null;
  public View mLauncherView = null;
  private boolean mbOut;
  LinkedList<Post> plist = new LinkedList();
  Post postBk;
  Random rng = new Random();
  WidgetView1 wView;

  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 2130837512;
    arrayOfInt[1] = 2130837511;
    resDrawNote = arrayOfInt;
    paintAA = new Paint();
    paintAA.setFlags(2);
    paintAA.setAntiAlias(true);
    paintAA.setDither(true);
  }

  public StackView(Context paramContext)
  {
    super(paramContext);
    initView();
  }

  public StackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }

  public StackView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }

  private void clearAllCachedBmp()
  {
    Iterator localIterator = this.plist.iterator();
    while (localIterator.hasNext())
    {
      Post localPost = (Post)localIterator.next();
      localPost.recycleBmp(this.plist.indexOf(localPost));
      localPost.x = this.activity.getResources().getInteger(2131034122);
      localPost.y = this.activity.getResources().getInteger(2131034123);
      localPost.ClearRenderer();
    }
    invalidate();
  }

  private void clearCachedBmp()
  {
    Iterator localIterator = this.plist.iterator();
    while ((this.index >= 0) && (localIterator.hasNext()))
    {
      Post localPost = (Post)localIterator.next();
      int i = this.plist.indexOf(localPost);
      if (i < this.index - 1)
      {
        localPost.recycleBmp(i);
        continue;
      }
      if (i <= 1 + this.index)
        continue;
      localPost.recycleBmp(i);
    }
    invalidate();
  }

  private void initView()
  {
  }

  public void addPost(String paramString)
  {
    if (paramString.equals(""));
    while (true)
    {
      return;
      Post localPost = new Post(paramString, 0);
      if (localPost == null)
        continue;
      this.plist.add(localPost);
      localPost.x = this.activity.getResources().getInteger(2131034122);
      localPost.y = this.activity.getResources().getInteger(2131034123);
      localPost.invalidate();
      this.index = this.plist.indexOf(localPost);
      clearCachedBmp();
    }
  }

  protected void clearAnim()
  {
    if (this.mDrawable != null)
    {
      this.mDrawable = null;
      this.wView.enableScroll(true);
    }
  }

  public String getCurrentIndex()
  {
    int i = this.plist.size();
    if ((i == 0) || (this.index < 0) || (this.index >= i));
    for (String str = null; ; str = ((Post)this.plist.get(this.index)).getImage())
      return str;
  }

  protected void initAnim(Context paramContext, boolean paramBoolean, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    clearCachedBmp();
    if (paramBitmap1 == null);
    BitmapDrawable localBitmapDrawable1;
    BitmapDrawable localBitmapDrawable2;
    while (true)
    {
      return;
      this.mbOut = paramBoolean;
      localBitmapDrawable1 = null;
      localBitmapDrawable2 = null;
      if (paramBitmap1 != null)
      {
        Resources localResources2 = this.activity.getResources();
        localBitmapDrawable1 = new BitmapDrawable(localResources2, paramBitmap1);
        if (localBitmapDrawable1 == null)
          continue;
        int i7 = this.activity.getResources().getInteger(2131034122) - localBitmapDrawable1.getIntrinsicWidth() / 2;
        int i8 = this.activity.getResources().getInteger(2131034122) + localBitmapDrawable1.getIntrinsicWidth() / 2;
        int i9 = localBitmapDrawable1.getIntrinsicHeight();
        localBitmapDrawable1.setBounds(i7, 0, i8, i9);
      }
      if (paramBitmap2 == null)
        break;
      Resources localResources1 = this.activity.getResources();
      localBitmapDrawable2 = new BitmapDrawable(localResources1, paramBitmap2);
      if (localBitmapDrawable2 == null)
        continue;
      if (getResources().getConfiguration().orientation != 2)
        break label528;
      int i3 = this.activity.getResources().getInteger(2131034122) - localBitmapDrawable2.getIntrinsicWidth() / 2;
      int i4 = this.activity.getResources().getInteger(2131034123) - this.activity.getResources().getInteger(2131034126) - localBitmapDrawable2.getIntrinsicHeight() / 2;
      int i5 = this.activity.getResources().getInteger(2131034122) + localBitmapDrawable2.getIntrinsicWidth() / 2;
      int i6 = this.activity.getResources().getInteger(2131034123) - this.activity.getResources().getInteger(2131034126) + localBitmapDrawable2.getIntrinsicHeight() / 2;
      localBitmapDrawable2.setBounds(i3, i4, i5, i6);
    }
    label286: int i;
    int j;
    int k;
    int m;
    float f1;
    float f2;
    if (paramBoolean)
    {
      i = this.activity.getResources().getInteger(2131034126);
      j = this.activity.getResources().getInteger(2131034127);
      k = 255;
      m = 0;
      f1 = 8.0F;
      f2 = 0.0F;
    }
    while (true)
    {
      float f3 = this.activity.getResources().getInteger(2131034122);
      float f4 = this.activity.getResources().getInteger(2131034123) - this.activity.getResources().getInteger(2131034126);
      RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, f3, f4);
      if (localRotateAnimation == null)
        break;
      localRotateAnimation.setDuration(500L);
      localRotateAnimation.setRepeatCount(0);
      localRotateAnimation.initialize(10, 10, 10, 10);
      AnimateDrawable localAnimateDrawable = new AnimateDrawable(localBitmapDrawable2, localRotateAnimation);
      this.mDrawable = localAnimateDrawable;
      if (this.mDrawable == null)
        break;
      this.mDrawable.setOffRot(0, this.activity.getResources().getInteger(2131034126));
      this.mDrawable.setAlpha(k, m);
      this.mDrawable.setFlying(localBitmapDrawable1, i, j);
      1 local1 = new DisplayView()
      {
      };
      localRotateAnimation.setAnimationListener(local1);
      this.wView.enableScroll(false);
      localRotateAnimation.startNow();
      break;
      label528: int n = this.activity.getResources().getInteger(2131034122) - localBitmapDrawable2.getIntrinsicWidth() / 2;
      int i1 = this.activity.getResources().getInteger(2131034122) + localBitmapDrawable2.getIntrinsicWidth() / 2;
      int i2 = localBitmapDrawable2.getIntrinsicHeight();
      localBitmapDrawable2.setBounds(n, 0, i1, i2);
      break label286;
      i = this.activity.getResources().getInteger(2131034127);
      j = this.activity.getResources().getInteger(2131034126);
      k = 0;
      m = 255;
      f1 = 0.0F;
      f2 = 8.0F;
    }
  }

  public boolean isFirst()
  {
    int i;
    if (this.plist.size() == 0)
      i = 1;
    while (true)
    {
      return i;
      if (-1 == this.index)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public boolean isLast()
  {
    int i = this.plist.size();
    int j;
    if (i == 0)
      j = 1;
    while (true)
    {
      return j;
      if (i - 1 == this.index)
      {
        j = 1;
        continue;
      }
      j = 0;
    }
  }

  protected Bitmap loadBmp(int paramInt)
  {
    int i = this.plist.size();
    int j = paramInt + this.index;
    if ((i == 0) || (j < 0) || (j >= i));
    for (Bitmap localBitmap = null; ; localBitmap = ((Post)this.plist.get(j)).getBitmap())
      return localBitmap;
  }

  public void moveNext()
  {
    int i = this.plist.size();
    if (i == 0);
    while (true)
    {
      return;
      if (this.index != i - 1)
      {
        this.index = (1 + this.index);
        invalidate();
        continue;
      }
    }
  }

  public void movePrev()
  {
    if (this.plist.size() == 0);
    while (true)
    {
      return;
      if (-1 != this.index)
      {
        this.index -= 1;
        invalidate();
        continue;
      }
    }
  }

  public void onCreate(WidgetView1 paramWidgetView1, Context paramContext, View paramView)
  {
    this.wView = paramWidgetView1;
    this.activity = paramContext;
    this.mLauncherView = paramView;
    onSize();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = 0.0F;
    if (this.mBitmap == null);
    while (true)
    {
      try
      {
        this.mBitmap = Bitmap.createBitmap(this.activity.getResources().getInteger(2131034124), this.activity.getResources().getInteger(2131034125), Bitmap.Config.ARGB_8888);
        if (this.mBitmap != null)
          break label85;
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("StackView", "Error in onDraw ", localThrowable);
        continue;
      }
      this.mBitmap.eraseColor(0);
      continue;
      label85: Canvas localCanvas = new Canvas(this.mBitmap);
      if (localCanvas == null)
        continue;
      Paint localPaint = new Paint(4);
      if (localPaint == null)
        continue;
      if (this.postBk == null)
      {
        this.postBk = new Post("", 1);
        if (this.postBk == null)
          continue;
        this.postBk.x = this.activity.getResources().getInteger(2131034122);
        this.postBk.y = this.activity.getResources().getInteger(2131034123);
      }
      this.postBk.draw(localCanvas);
      Iterator localIterator = this.plist.iterator();
      while ((this.mDrawable == null) && (this.index >= 0) && (localIterator.hasNext()))
      {
        Post localPost = (Post)localIterator.next();
        if (this.plist.indexOf(localPost) < this.index)
          continue;
        localPost.draw(localCanvas);
      }
      if (this.mDrawable != null)
      {
        f1 = this.mDrawable.getPercent();
        this.mDrawable.draw(localCanvas);
      }
      paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, localPaint);
      if (this.mDrawable == null)
        continue;
      float f2 = this.mDrawable.getPercent();
      if ((f1 >= 1.0F) && (f2 >= 1.0F))
        clearAnim();
      invalidate();
    }
  }

  public void onSize()
  {
    this.WIDTH = this.activity.getResources().getInteger(2131034114);
    this.HEIGHT = this.activity.getResources().getInteger(2131034115);
    resDrawNote[0] = 2130837512;
    resDrawNote[1] = 2130837511;
    this.mBitmap = null;
    this.postBk = null;
    clearAllCachedBmp();
    ImageView localImageView = (ImageView)this.mLauncherView.findViewById(2131165197);
    if (localImageView != null)
    {
      if (getResources().getConfiguration().orientation != 2)
        break label157;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      int i = (int)this.activity.getResources().getDimension(2130968583);
      int j = (int)this.activity.getResources().getDimension(2130968584);
      localLayoutParams.topMargin = i;
      localLayoutParams.leftMargin = j;
      localImageView.setVisibility(0);
      localImageView.setImageResource(2130837513);
    }
    while (true)
    {
      return;
      label157: localImageView.setVisibility(8);
      localImageView.setImageResource(0);
    }
  }

  public void releaseAllPosts()
  {
    this.plist.clear();
    invalidate();
  }

  public void removeCurrentPost()
  {
    int i = this.plist.size();
    if ((i == 0) || (this.index < 0) || (this.index >= i));
    while (true)
    {
      return;
      Post localPost = (Post)this.plist.get(this.index);
      if (!new File(localPost.image).delete())
        Log.v("StackView", "removeCurrentPost error: cannot delete old file.");
      removePost(localPost);
      movePrev();
      invalidate();
    }
  }

  public void removePost(Post paramPost)
  {
    if (this.plist.remove(paramPost))
    {
      Log.v("StackView", "Successfully remove post.");
      paramPost.invalidate();
    }
    while (true)
    {
      return;
      Log.v("StackView", "Fail to remove post.");
    }
  }

  public void setIndex(String paramString)
  {
    int i = 0;
    if (paramString == null)
    {
      i = -1;
      this.index = i;
      invalidate();
      return;
    }
    int j = this.plist.size();
    Iterator localIterator = this.plist.iterator();
    while (true)
    {
      if ((!localIterator.hasNext()) || (paramString.equals(((Post)localIterator.next()).getImage())))
      {
        if ((j != 0) && (i >= 0) && (i < j))
          break;
        i = j - 1;
        break;
      }
      i++;
    }
  }

  private class DisplayView
    implements Animation.AnimationListener
  {
    private DisplayView()
    {
    }

    public void onAnimationEnd(Animation paramAnimation)
    {
      Log.v("StackView", "end");
      StackView.this.clearAnim();
      StackView.this.clearCachedBmp();
    }

    public void onAnimationRepeat(Animation paramAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnimation)
    {
      Log.v("StackView", "start");
    }
  }

  class Post
  {
    Bitmap bmp;
    int degree;
    String image;
    Renderer renderer;
    int x;
    int y;

    Post(String paramInt, int arg3)
    {
      this.image = paramInt;
      int i;
      this.degree = i;
      this.renderer = new NotePostRenderer();
      if (this.renderer == null);
    }

    private void ClearRenderer()
    {
      this.renderer = null;
    }

    private Bitmap copyResBitmap(int paramInt)
    {
      Object localObject = null;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(StackView.this.activity.getResources(), paramInt).copy(Bitmap.Config.ARGB_8888, true);
        localObject = localBitmap;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
          localOutOfMemoryError.printStackTrace();
      }
    }

    void draw(Canvas paramCanvas)
    {
      if (this.renderer == null)
        this.renderer = new NotePostRenderer();
      if (this.renderer == null);
      while (true)
      {
        return;
        if (this.bmp == null)
          this.renderer.createNormalPost();
        if (this.bmp == null)
          continue;
        this.renderer.draw(paramCanvas, this.x, this.y);
      }
    }

    Bitmap getBitmap()
    {
      if (this.renderer == null)
        this.renderer = new NotePostRenderer();
      if (this.renderer == null);
      for (Bitmap localBitmap = null; ; localBitmap = this.bmp)
      {
        return localBitmap;
        if (this.bmp != null)
          continue;
        this.renderer.createNormalPost();
      }
    }

    String getImage()
    {
      return this.image;
    }

    public int getOffsetX()
    {
      return this.x;
    }

    public int getOffsetY()
    {
      return this.y;
    }

    void invalidate()
    {
      if (this.renderer == null);
      while (true)
      {
        return;
        this.renderer.invalidate(this.x, this.y);
      }
    }

    public void recycleBmp(int paramInt)
    {
      if (this.bmp != null)
      {
        Log.d("StackView", "recycleBmp " + paramInt);
        this.bmp.recycle();
      }
      this.bmp = null;
    }

    void setOffset(int paramInt1, int paramInt2)
    {
      this.x = paramInt1;
      this.y = paramInt2;
    }

    class NotePostRenderer extends StackView.Post.Renderer
    {
      NotePostRenderer()
      {
        super(StackView.this.WIDTH, StackView.this.HEIGHT);
      }

      private Bitmap createScaledBmp()
      {
        Log.d("StackView", StackView.Post.this.image);
        Object localObject3;
        if (StackView.Post.this.image.equals(""))
          localObject3 = null;
        while (true)
        {
          return localObject3;
          Object localObject1 = null;
          int i;
          int j;
          Object localObject2;
          try
          {
            Bitmap localBitmap2 = BitmapFactory.decodeFile(StackView.Post.this.image);
            localObject1 = localBitmap2;
            if (localObject1 == null)
              localObject3 = null;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            while (true)
              localOutOfMemoryError1.printStackTrace();
            i = StackView.this.activity.getResources().getInteger(2131034116);
            j = StackView.this.activity.getResources().getInteger(2131034117);
            if ((i == localObject1.getWidth()) && (j == localObject1.getHeight()))
            {
              localObject3 = localObject1;
              continue;
            }
            localObject2 = null;
          }
          try
          {
            Bitmap localBitmap1 = Bitmap.createScaledBitmap(localObject1, i, j, true);
            localObject2 = localBitmap1;
            localObject1.recycle();
            localObject3 = localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            while (true)
              localOutOfMemoryError2.printStackTrace();
          }
        }
      }

      void createBasePost(int paramInt)
      {
        try
        {
          StackView.Post.this.bmp = Bitmap.createBitmap(StackView.this.WIDTH, StackView.this.HEIGHT, Bitmap.Config.ARGB_8888);
          if (StackView.Post.this.bmp == null)
            return;
        }
        catch (Throwable localThrowable)
        {
          while (true)
          {
            Log.e("StackView", "Error in createBasePost ", localThrowable);
            continue;
            Canvas localCanvas = new Canvas(StackView.Post.this.bmp);
            if (localCanvas == null)
            {
              StackView.Post.this.bmp.recycle();
              StackView.Post.this.bmp = null;
              continue;
            }
            Bitmap localBitmap = StackView.Post.this.copyResBitmap(StackView.resDrawNote[0]);
            if (localBitmap != null)
            {
              float f1 = localBitmap.getWidth();
              float f2 = localBitmap.getHeight();
              Matrix localMatrix = new Matrix();
              if (localMatrix == null)
              {
                StackView.Post.this.bmp.recycle();
                StackView.Post.this.bmp = null;
                continue;
              }
              localMatrix.postTranslate(-f1 / 2.0F, -f2 / 2.0F);
              localMatrix.postRotate(paramInt);
              localMatrix.postTranslate(StackView.this.WIDTH / 2 + StackView.this.activity.getResources().getInteger(2131034118), StackView.this.HEIGHT / 2 + StackView.this.activity.getResources().getInteger(2131034119));
              localCanvas.drawBitmap(localBitmap, localMatrix, StackView.paintAA);
              localBitmap.recycle();
              continue;
            }
            StackView.Post.this.bmp.recycle();
            StackView.Post.this.bmp = null;
          }
        }
      }

      void createNormalPost()
      {
        if (StackView.Post.this.bmp != null)
          StackView.Post.this.bmp.recycle();
        if (StackView.Post.this.degree != 0)
          createBasePost(StackView.this.activity.getResources().getInteger(2131034131));
        while (true)
        {
          return;
          createBasePost(0);
          if (StackView.Post.this.bmp == null)
            continue;
          Canvas localCanvas = new Canvas(StackView.Post.this.bmp);
          if (localCanvas == null)
            continue;
          Bitmap localBitmap = createScaledBmp();
          if (localBitmap == null)
            continue;
          float f1 = localBitmap.getWidth();
          float f2 = localBitmap.getHeight();
          Matrix localMatrix = new Matrix();
          if (localMatrix == null)
            continue;
          localMatrix.postTranslate(-f1 / 2.0F, -f2 / 2.0F);
          localMatrix.postRotate(0.0F);
          localMatrix.postTranslate(StackView.this.WIDTH / 2 + StackView.this.activity.getResources().getInteger(2131034120), StackView.this.HEIGHT / 2 + StackView.this.activity.getResources().getInteger(2131034121));
          localCanvas.drawBitmap(localBitmap, localMatrix, StackView.paintAA);
          localBitmap.recycle();
        }
      }
    }

    abstract class Renderer
    {
      final int height;
      final int width;

      Renderer(int paramInt1, int arg3)
      {
        this.width = paramInt1;
        int i;
        this.height = i;
      }

      abstract void createNormalPost();

      void draw(Canvas paramCanvas, int paramInt1, int paramInt2)
      {
        paramCanvas.drawBitmap(StackView.Post.this.bmp, paramInt1 - this.width / 2, paramInt2 - this.height / 2, StackView.paintAA);
      }

      void invalidate(int paramInt1, int paramInt2)
      {
        StackView.this.invalidate(paramInt1 - this.width / 2, paramInt2 - this.height / 2, paramInt1 + this.width / 2, paramInt2 + this.height / 2);
      }
    }
  }
}