package memo.com.pack;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WidgetView1 extends AbstractWidgetView
  implements Constants
{
  private static final int HANDLE_CHECK_DATABASE = 7;
  private static final String LOG_TAG = "WidgetView1";
  private static final int MOVE_TO_CURRENT = 2;
  private static final int MOVE_TO_CURSOR_POSITION = 3;
  private static final int MOVE_TO_FIRST = 1;
  private static final int MSG_NO_STORAGE = 100;
  private static final int MSG_NO_STORAGE_SHARED = 102;
  private static final int MSG_STORAGE = 101;
  private static final int MSG_UnMount_Storage = 103;
  private static final int NO_FOOTPRINTS;
  private StorageUtil.OnChangeStorageListener mChangeStorageListener;
  private boolean mHasStorage;
  private View mLauncherView;
  private TextView mNoSDCardText;
  private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramView)
    {
      return WidgetView1.this.launcherLongClick();
    }
  };
  private PaintReceiver mReceiver = null;
  private StorageUtil mStorageUtil;
  private StackView stackView;
  private ActionBar taskbar;

  private void handleIntents(Intent paramIntent)
  {
    if ((!"com.htc.rosiewidgets.note.PAINT_POST".equals(paramIntent.getAction())) || (!this.mHasStorage));
    while (true)
    {
      return;
      String str = paramIntent.getStringExtra("com.htc.rosiewidgets.note.PAINT_FILENAME");
      this.stackView.addPost(str);
    }
  }

  // ERROR //
  private boolean readNotesData()
  {
    // Byte code:
    //   0: new 151	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 154	com/htc/rosiewidgets/note/WidgetView1:mStorageUtil	Lcom/htc/rosiewidgets/note/StorageUtil;
    //   12: pop
    //   13: aload_1
    //   14: invokestatic 159	com/htc/rosiewidgets/note/StorageUtil:getStorageDirectory	()Ljava/lang/String;
    //   17: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 165
    //   22: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 7
    //   30: ldc 27
    //   32: new 151	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   39: ldc 170
    //   41: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 7
    //   46: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 176	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: new 178	java/io/File
    //   59: dup
    //   60: aload 7
    //   62: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 9
    //   67: aload 9
    //   69: ifnonnull +9 -> 78
    //   72: iconst_0
    //   73: istore 5
    //   75: iload 5
    //   77: ireturn
    //   78: aload 9
    //   80: invokevirtual 183	java/io/File:exists	()Z
    //   83: ifne +9 -> 92
    //   86: aload 9
    //   88: invokevirtual 186	java/io/File:mkdirs	()Z
    //   91: pop
    //   92: aload 9
    //   94: invokestatic 192	com/htc/rosiewidgets/note/ArrayInOb:fill	(Ljava/io/File;)V
    //   97: new 188	com/htc/rosiewidgets/note/ArrayInOb
    //   100: dup
    //   101: invokespecial 193	com/htc/rosiewidgets/note/ArrayInOb:<init>	()V
    //   104: astore 11
    //   106: aload 11
    //   108: ifnonnull +46 -> 154
    //   111: iconst_0
    //   112: istore 5
    //   114: goto -39 -> 75
    //   117: astore_2
    //   118: aload_2
    //   119: astore_3
    //   120: ldc 27
    //   122: new 151	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   129: ldc 195
    //   131: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 198	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   138: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 176	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: iconst_0
    //   149: istore 5
    //   151: goto -76 -> 75
    //   154: aload 11
    //   156: ldc 200
    //   158: invokevirtual 203	com/htc/rosiewidgets/note/ArrayInOb:make	(Ljava/lang/String;)V
    //   161: iconst_0
    //   162: istore 12
    //   164: iload 12
    //   166: aload 11
    //   168: invokevirtual 207	com/htc/rosiewidgets/note/ArrayInOb:length	()I
    //   171: if_icmpge +27 -> 198
    //   174: aload 11
    //   176: iload 12
    //   178: invokevirtual 211	com/htc/rosiewidgets/note/ArrayInOb:getPath	(I)Ljava/lang/String;
    //   181: astore 13
    //   183: aload_0
    //   184: getfield 75	com/htc/rosiewidgets/note/WidgetView1:stackView	Lcom/htc/rosiewidgets/note/StackView;
    //   187: aload 13
    //   189: invokevirtual 145	com/htc/rosiewidgets/note/StackView:addPost	(Ljava/lang/String;)V
    //   192: iinc 12 1
    //   195: goto -31 -> 164
    //   198: iconst_1
    //   199: istore 5
    //   201: goto -126 -> 75
    //   204: astore 10
    //   206: aload 10
    //   208: astore_3
    //   209: goto -89 -> 120
    //
    // Exception table:
    //   from	to	target	type
    //   0	67	117	java/lang/Throwable
    //   78	92	204	java/lang/Throwable
  }

  private void startPaintActivity(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    if (localIntent == null);
    while (true)
    {
      return;
      localIntent.setClassName("com.htc.rosiewidgets.note", "com.htc.rosiewidgets.note.PaintActivity");
      localIntent.putExtra("com.htc.rosiewidgets.note.PAINT_FILENAME", paramString);
      this.mHostActivity.startActivity(localIntent);
    }
  }

  private void syncNotesDate()
  {
    String str = this.stackView.getCurrentIndex();
    this.stackView.releaseAllPosts();
    readNotesData();
    this.stackView.setIndex(str);
  }

  private void updateUIForStorage()
  {
    if (!this.mHasStorage)
    {
      this.stackView.releaseAllPosts();
      this.mNoSDCardText.setVisibility(0);
    }
    while (true)
    {
      return;
      this.mNoSDCardText.setVisibility(8);
    }
  }

  public void enableScroll(boolean paramBoolean)
  {
    this.mHostActivity.enableScroll(paramBoolean);
  }

  public int getLayoutResource()
  {
    return 2130903041;
  }

  public int getNotifyType()
  {
    return 20;
  }

  public int getSpanX()
  {
    return 4;
  }

  public int getSpanY()
  {
    return 4;
  }

  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == 2)
      this.mUiHandler.removeMessages(7);
    while (true)
    {
      return;
      if ((i == 1) && (20 == paramMessage.arg1))
      {
        this.mUiHandler.sendEmptyMessageDelayed(7, 100L);
        continue;
      }
    }
  }

  public void handleUiMessage(Message paramMessage)
  {
    super.handleUiMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 0:
    case 1:
    case 2:
    case 3:
    default:
    case 102:
    case 100:
    case 103:
    case 101:
    case 7:
    }
    while (true)
    {
      return;
      Log.d("", "handleUiMessage: MSG_NO_STORAGE_SHARED");
      this.mHasStorage = false;
      if (StorageUtil.mbSupportPhoneStorage)
        this.mNoSDCardText.setText(2131099654);
      while (true)
      {
        updateUIForStorage();
        break;
        this.mNoSDCardText.setText(2131099650);
      }
      Log.d("", "handleUiMessage: MSG_NO_STORAGE");
      this.mHasStorage = false;
      this.mNoSDCardText.setText(2131099649);
      updateUIForStorage();
      continue;
      Log.d("", "handleUiMessage: MSG_UnMount_Storage");
      this.mHasStorage = false;
      this.mNoSDCardText.setText(2131099651);
      updateUIForStorage();
      continue;
      Log.d("", "handleUiMessage: MSG_STORAGE");
      this.mHasStorage = true;
      updateUIForStorage();
      readNotesData();
      continue;
      if (!this.mHasStorage)
        continue;
      syncNotesDate();
    }
  }

  public boolean launcherLongClick()
  {
    if ((this.mLauncherView != null) && (this.mHostActivity != null))
      this.mHostActivity.onLongClick(this.mLauncherView);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  protected void onLandscape()
  {
    onSize();
  }

  public void onLayoutInflated(View paramView, int paramInt, Intent paramIntent)
  {
    super.onLayoutInflated(paramView, paramInt, paramIntent);
    this.mStorageUtil = new StorageUtil(this.mHostActivity);
    this.mChangeStorageListener = new StorageUtil.OnChangeStorageListener()
    {
      public void onStorageChanged(int paramInt)
      {
        Log.d("", "onStorageChanged: state = " + paramInt);
        switch (paramInt)
        {
        case 4:
        case 5:
        default:
        case 1:
        case 6:
        case 3:
        case 2:
        }
        while (true)
        {
          return;
          WidgetView1.this.mUiHandler.sendEmptyMessageDelayed(101, 500L);
          continue;
          WidgetView1.this.mUiHandler.sendEmptyMessage(102);
          continue;
          WidgetView1.this.mUiHandler.sendEmptyMessage(100);
          continue;
          WidgetView1.this.mUiHandler.sendEmptyMessage(103);
        }
      }
    };
    this.mStorageUtil.setOnChangeStorageListerner(this.mChangeStorageListener);
    this.mStorageUtil.startStorageUtil();
    this.mHasStorage = StorageUtil.hasStorage();
    this.mLauncherView = paramView;
    this.taskbar = ((ActionBar)paramView.findViewById(2131165200));
    Resources localResources = this.mResContext.getResources();
    this.taskbar.setIcon(localResources.getDrawable(2130837516), 0);
    this.taskbar.setIcon(localResources.getDrawable(2130837504), 1);
    this.taskbar.setCountIndicatorVisibility(4);
    this.taskbar.setOnClickListener(new ActionBar.OnPanelClickListener()
    {
      public void onLeftClick()
      {
        if (WidgetView1.this.mHasStorage)
          WidgetView1.this.stackView.removeCurrentPost();
      }

      public void onRightClick()
      {
        if (WidgetView1.this.mHasStorage)
          WidgetView1.this.startPaintActivity("");
      }
    });
    this.taskbar.setOnLongClickListener(new ActionBar.OnPanelLongClickListener()
    {
      public boolean onLeftLongClick()
      {
        return WidgetView1.this.mHostActivity.onLongClick(WidgetView1.this.mHostView);
      }

      public boolean onRightLongClick()
      {
        return WidgetView1.this.mHostActivity.onLongClick(WidgetView1.this.mHostView);
      }
    });
    this.stackView = ((StackView)paramView.findViewById(2131165198));
    this.stackView.onCreate(this, this.mResContext, this.mLauncherView);
    this.stackView.setOnTouchListener(new myOnTouchListener(this.mApplication));
    this.stackView.setOnLongClickListener(this.mOnLongClickListener);
    this.mNoSDCardText = ((TextView)paramView.findViewById(2131165199));
    if (this.mHasStorage)
      readNotesData();
    if (isFirstInflated())
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.htc.rosiewidgets.note.PAINT_POST");
      this.mReceiver = new PaintReceiver();
      this.mApplication.registerReceiver(this.mReceiver, localIntentFilter);
      Log.d("WidgetView1", "register PaintReceiver in onLayoutInflated");
    }
    updateUIForStorage();
    Log.i("VersionWidget", "Version code: mainline_eclair1.5 2010-09-09 18:00:00");
  }

  public void onLayoutRemoved()
  {
    try
    {
      if (this.mReceiver != null)
      {
        this.mApplication.unregisterReceiver(this.mReceiver);
        this.mReceiver = null;
      }
      Log.d("WidgetView1", "onLayoutRemoved");
      super.onLayoutRemoved();
      if (this.mStorageUtil != null)
      {
        this.mStorageUtil.closeStorgaeUtil();
        this.mChangeStorageListener = null;
        this.mStorageUtil = null;
      }
      if (this.mUiHandler != null)
      {
        this.mUiHandler.removeMessages(2);
        this.mUiHandler.removeMessages(1);
        this.mUiHandler.removeMessages(0);
        this.mUiHandler.removeMessages(100);
        this.mUiHandler.removeMessages(102);
        this.mUiHandler.removeMessages(101);
      }
      if (this.mHandler != null)
        this.mHandler.removeMessages(7);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        Log.e("WidgetView1", "Error in unregister widget", localThrowable);
    }
  }

  protected void onPortrait()
  {
    onSize();
  }

  void onSize()
  {
    Resources localResources = this.mResContext.getResources();
    this.stackView.onSize();
    ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.mNoSDCardText.getLayoutParams();
    localMarginLayoutParams1.leftMargin = localResources.getDimensionPixelSize(2130968577);
    localMarginLayoutParams1.topMargin = localResources.getDimensionPixelSize(2130968576);
    localMarginLayoutParams1.width = localResources.getDimensionPixelSize(2130968579);
    localMarginLayoutParams1.height = localResources.getDimensionPixelSize(2130968578);
    this.mNoSDCardText.setLayoutParams(localMarginLayoutParams1);
    ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.taskbar.getLayoutParams();
    localMarginLayoutParams2.leftMargin = localResources.getDimensionPixelSize(2130968580);
    localMarginLayoutParams2.topMargin = localResources.getDimensionPixelSize(2130968581);
    localMarginLayoutParams2.height = localResources.getDimensionPixelSize(2130968582);
    this.taskbar.setLayoutParams(localMarginLayoutParams2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams3 = (ViewGroup.MarginLayoutParams)this.stackView.getLayoutParams();
    localMarginLayoutParams3.leftMargin = localResources.getDimensionPixelSize(2130968586);
    localMarginLayoutParams3.topMargin = localResources.getDimensionPixelSize(2130968585);
    this.stackView.setLayoutParams(localMarginLayoutParams3);
  }

  class PaintReceiver extends BroadcastReceiver
  {
    PaintReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      WidgetView1.this.handleIntents(paramIntent);
    }
  }

  private class myOnTouchListener
    implements View.OnTouchListener
  {
    private GestureDetector mGestureDector;
    private GestureDetector.OnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
      {
        if (1 == paramMotionEvent2.getAction())
        {
          if (paramFloat2 >= 0.0F)
            break label115;
          if (!WidgetView1.this.stackView.isFirst())
          {
            Bitmap localBitmap3 = WidgetView1.this.stackView.loadBmp(0);
            Bitmap localBitmap4 = WidgetView1.this.stackView.loadBmp(-1);
            WidgetView1.this.stackView.initAnim(WidgetView1.this.mResContext, true, localBitmap3, localBitmap4);
            WidgetView1.this.stackView.movePrev();
          }
        }
        while (true)
        {
          return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
          label115: if (WidgetView1.this.stackView.isLast())
            continue;
          Bitmap localBitmap1 = WidgetView1.this.stackView.loadBmp(1);
          Bitmap localBitmap2 = WidgetView1.this.stackView.loadBmp(0);
          WidgetView1.this.stackView.initAnim(WidgetView1.this.mResContext, false, localBitmap1, localBitmap2);
          WidgetView1.this.stackView.moveNext();
        }
      }
    };

    public myOnTouchListener(Context arg2)
    {
      Context localContext;
      this.mGestureDector = new GestureDetector(localContext, this.mGestureListener);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return this.mGestureDector.onTouchEvent(paramMotionEvent);
    }
  }
}