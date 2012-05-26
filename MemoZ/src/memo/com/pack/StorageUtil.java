package memo.com.pack;

import java.io.File;
import java.text.DecimalFormat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;



public class StorageUtil
{
  public static final int ACTION_DEVICE_STORAGE_LOW = 7;
  public static final int ACTION_DEVICE_STORAGE_OK = 8;
  public static final int ACTION_MEDIA_BAD_REMOVAL = 5;
  public static final int ACTION_MEDIA_EJECT = 4;
  public static final int ACTION_MEDIA_MOUNTED = 1;
  public static final int ACTION_MEDIA_SHARED = 6;
  public static final int ACTION_MEDIA_UNMOUNTABLE = 3;
  public static final int ACTION_MEDIA_UNMOUNTED = 2;
  private static final int CANNOT_STAT_ERROR = -2;
  public static final long EXTERNAL_MEMORY_THRESHOLD = 2097152L;
  public static final long INTERNAL_MEMORY_THRESOLD = 5242880L;
  private static final int NO_STORAGE_ERROR = -1;
  private static final String PATH;
  public static int StorageCounter = 0;
  public static final int Storage_State_SD_Card_Mounted = 1;
  public static final int Storage_State_SD_Card_Removal = 3;
  public static final int Storage_State_SD_Card_Shared = 6;
  public static final int Storage_State_SD_Card_unMounted = 2;
  private static String TAG = "StorageUtil";
  private static boolean mInternalStorageFull;
  private static long mRemainingStroage;
  public static final boolean mbSupportPhoneStorage;
  public boolean isReg = false;
  private Context mContext;
  private int mCurrentState = 0;
  private OnChangeStorageListener mOnChangeStorageListener = null;
  private BroadcastReceiver mReceiver;
  private int mStorageState = 0;
  private int mTempStorageState = 0;

  static
  {
    PATH = Environment.getDataDirectory().getPath();
    StorageCounter = 0;
    mInternalStorageFull = false;
    if ((0x2 & Environment.getSupportedStorages()) != 0);
    for (boolean bool = true; ; bool = false)
    {
      mbSupportPhoneStorage = bool;
      return;
    }
  }

  public StorageUtil(Context paramContext)
  {
    this.mContext = paramContext;
    this.mReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramContext, Intent paramIntent)
      {
        String str = paramIntent.getAction();
        Log.d(StorageUtil.TAG, "action = " + str);
        if (str.equals("android.intent.action.MEDIA_MOUNTED"))
          if ((!StorageUtil.mbSupportPhoneStorage) || ((StorageUtil.mbSupportPhoneStorage) && (StorageUtil.hasStorage())))
            StorageUtil.this.setState(1);
        while (true)
        {
          return;
          if (str.equals("android.intent.action.MEDIA_UNMOUNTED"))
          {
            StorageUtil.this.setState(2);
            continue;
          }
          if (str.equals("android.intent.action.MEDIA_UNMOUNTABLE"))
          {
            StorageUtil.this.setState(3);
            continue;
          }
          if (str.equals("android.intent.action.MEDIA_EJECT"))
          {
            StorageUtil.this.setState(4);
            continue;
          }
          if (str.equals("android.intent.action.MEDIA_BAD_REMOVAL"))
          {
            StorageUtil.this.setState(5);
            continue;
          }
          if (str.equals("android.intent.action.MEDIA_SHARED"))
          {
            if ((StorageUtil.mbSupportPhoneStorage) && ((!StorageUtil.mbSupportPhoneStorage) || (!StorageUtil.isMediaShared())))
              continue;
            StorageUtil.this.setState(6);
            continue;
          }
          if (str.equals("android.intent.action.DEVICE_STORAGE_LOW"))
          {
            StorageUtil.access$202(true);
            continue;
          }
          if (!str.equals("android.intent.action.DEVICE_STORAGE_OK"))
            continue;
          StorageUtil.access$202(false);
        }
      }
    };
  }

  private int StateHandler(int paramInt)
  {
    int i = this.mStorageState;
    Log.d(TAG, "StateHandler: state = " + paramInt);
    switch (paramInt)
    {
    case 3:
    case 5:
    default:
    case 4:
    case 2:
    case 1:
    case 6:
    }
    while (true)
    {
      return i;
      if (this.mCurrentState != 5)
        continue;
      i = 3;
      continue;
      if (this.mCurrentState == 4)
      {
        i = 2;
        continue;
      }
      if (this.mStorageState != 2)
        continue;
      i = 3;
      continue;
      i = 1;
      continue;
      i = 6;
    }
  }

  /** @deprecated */
  public static long availableStorage()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (hasStorage())
          continue;
        mRemainingStroage = -1L;
        long l = mRemainingStroage;
        return l;
        if (mbSupportPhoneStorage)
        {
          localObject2 = Environment.getPhoneStorageDirectory();
          StatFs localStatFs = new StatFs(((File)localObject2).getPath());
          mRemainingStroage = localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
          continue;
        }
      }
      catch (Exception localException)
      {
        mRemainingStroage = -2L;
        continue;
      }
      finally
      {
        monitorexit;
      }
      File localFile = Environment.getExternalStorageDirectory();
      Object localObject2 = localFile;
    }
  }

  /** @deprecated */
  public static long checkIternalMemory()
  {
    monitorenter;
    try
    {
      StatFs localStatFs = new StatFs(PATH);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      Log.i(TAG, "internal memory: " + l);
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static String formatSize(long paramLong)
  {
    String str1 = null;
    if (paramLong >= 1024L)
    {
      str1 = " KB";
      paramLong /= 1024L;
      if (paramLong >= 1024L)
      {
        str1 = " MB";
        paramLong /= 1024L;
      }
    }
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.setGroupingSize(3);
    String str2 = localDecimalFormat.format(paramLong);
    if (str1 != null)
      str2 = str2 + str1;
    return str2;
  }

  private static long getFileSize(File paramFile)
  {
    long l1 = 0L;
    long l2;
    if (paramFile == null)
      l2 = 0L;
    while (true)
    {
      return l2;
      if (paramFile.isFile())
      {
        l2 = paramFile.length();
        continue;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++)
          l1 += getFileSize(arrayOfFile[j]);
      }
      l2 = l1;
    }
  }

  public static String getStorageDirectory()
  {
    String str1;
    if (mbSupportPhoneStorage)
    {
      String str2 = Environment.getPhoneStorageDirectory().toString();
      Log.e(TAG, "getStorageDirectory string = " + str2);
      str1 = Environment.getPhoneStorageDirectory().getAbsolutePath();
      Log.e(TAG, "getStorageDirectory = " + str1);
    }
    while (true)
    {
      return str1;
      str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      Log.e(TAG, "getStorageDirectory = " + str1);
    }
  }

  /** @deprecated */
  public static boolean hasStorage()
  {
    monitorenter;
    try
    {
      if (mbSupportPhoneStorage);
      String str;
      for (Object localObject2 = Environment.getPhoneStorageState(); ; localObject2 = str)
      {
        boolean bool = ((String)localObject2).equals("mounted");
        return bool;
        str = Environment.getExternalStorageState();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  private IntentFilter initFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_SHARED");
    if (!mbSupportPhoneStorage)
    {
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
      localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
      localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
    }
    localIntentFilter.addDataScheme("file");
    return localIntentFilter;
  }

  /** @deprecated */
  public static boolean isExternalStorageEnough()
  {
    monitorenter;
    try
    {
      long l = availableStorage();
      if (l > 2097152L)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  /** @deprecated */
  public static boolean isExternalStorageEnough(long paramLong)
  {
    monitorenter;
    try
    {
      long l = availableStorage();
      if (l > paramLong)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  /** @deprecated */
  public static boolean isInternalStorageEnough()
  {
    monitorenter;
    try
    {
      long l = checkIternalMemory();
      if (l <= 5242880L)
      {
        i = 0;
        return i;
      }
      int i = 1;
    }
    finally
    {
      monitorexit;
    }
  }

  /** @deprecated */
  public static boolean isInternalStorageEnough(int paramInt)
  {
    monitorenter;
    try
    {
      long l = checkIternalMemory();
      if (l <= paramInt)
      {
        i = 0;
        return i;
      }
      int i = 1;
    }
    finally
    {
      monitorexit;
    }
  }

  /** @deprecated */
  public static boolean isInternalStorageEnough(Context paramContext)
  {
    monitorenter;
    try
    {
      long l1 = checkIternalMemory();
      int i;
      if (l1 > 5242880L)
        i = 1;
      while (true)
      {
        return i;
        long l2 = getFileSize(paramContext.getCacheDir());
        if (l2 + l1 > 5242880L)
        {
          i = 1;
          continue;
        }
        i = 0;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static boolean isMediaShared()
  {
    if (mbSupportPhoneStorage);
    for (String str = Environment.getPhoneStorageState(); ; str = Environment.getExternalStorageState())
      return str.equals("shared");
  }

  /** @deprecated */
  public static boolean isStorageEnough(Context paramContext)
  {
    monitorenter;
    try
    {
      if (isInternalStorageEnough())
      {
        boolean bool = isExternalStorageEnough();
        if (bool)
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  private void setState(int paramInt)
  {
    this.mTempStorageState = StateHandler(paramInt);
    if (this.mTempStorageState != this.mStorageState)
    {
      this.mStorageState = this.mTempStorageState;
      Log.d(TAG, "setState: mStorageState = " + this.mStorageState);
      this.mOnChangeStorageListener.onStorageChanged(this.mStorageState);
    }
    this.mCurrentState = paramInt;
  }

  public void closeStorgaeUtil()
  {
    if ((this.mReceiver != null) && (this.isReg == true))
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      this.isReg = false;
      StorageCounter -= 1;
      this.mReceiver = null;
    }
  }

  public void setOnChangeStorageListerner(OnChangeStorageListener paramOnChangeStorageListener)
  {
    this.mOnChangeStorageListener = paramOnChangeStorageListener;
  }

  public void startStorageUtil()
  {
    if (!this.isReg)
    {
      this.mContext.registerReceiver(this.mReceiver, initFilter());
      this.isReg = true;
      StorageCounter = 1 + StorageCounter;
      if (!mbSupportPhoneStorage)
        break label63;
    }
    label63: for (String str = Environment.getPhoneStorageState(); ; str = Environment.getExternalStorageState())
    {
      if (str.equals("shared"))
        setState(6);
      return;
    }
  }

  public static abstract interface OnChangeStorageListener
  {
    public abstract void onStorageChanged(int paramInt);
  }
}