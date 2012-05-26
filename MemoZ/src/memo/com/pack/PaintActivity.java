package memo.com.pack;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PaintActivity extends Activity implements Constants{
	  
	  {
	    private static final String LOG_TAG = "PaintActivity";
	    private ImageView PaintDlgBG;
	    private FrameLayout PaintLayout;
	    private ImageButton btnHand;
	    private Button btnOK;
	    private ImageButton btnPen;
	    private EditText etNote;
	    private ImageView iconPen;
	    HTC_IMEReceiver mIMEStateRecv = null;
	    private String mText = null;
	    private float mTextSizeLand = 0.0F;
	    private float mTextSizePort = 0.0F;
	    private int nSipHeight = 0;
	    private PaintView paintView;

	    private void changeInput(boolean paramBoolean)
	    {
	      if (paramBoolean)
	      {
	        this.iconPen.setVisibility(4);
	        this.btnPen.setVisibility(4);
	        this.btnHand.setImageResource(2130837524);
	        this.etNote.setCursorVisible(true);
	        this.etNote.setVisibility(0);
	        this.paintView.setActive(false);
	        showSoftInput();
	      }
	      while (true)
	      {
	        return;
	        setPen(true);
	        this.iconPen.setVisibility(0);
	        this.btnPen.setVisibility(0);
	        this.btnHand.setImageResource(2130837526);
	        this.etNote.setCursorVisible(false);
	        if (this.etNote.getEditableText().length() == 0)
	          this.etNote.setVisibility(4);
	        this.paintView.setActive(true);
	        hideSoftInput(this.etNote);
	      }
	    }

	    private void hideSoftInput(View paramView)
	    {
	      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
	    }

	    private void sendPaint(String paramString)
	    {
	      Intent localIntent = new Intent("com.htc.rosiewidgets.note.PAINT_POST");
	      localIntent.putExtra("com.htc.rosiewidgets.note.PAINT_FILENAME", paramString);
	      sendBroadcast(localIntent);
	      finish();
	    }

	    private void setPen(boolean paramBoolean)
	    {
	      if (!paramBoolean)
	      {
	        this.iconPen.setImageResource(2130837519);
	        this.btnPen.setImageResource(2130837533);
	        this.paintView.setEraser(true);
	      }
	      while (true)
	      {
	        return;
	        this.iconPen.setImageResource(2130837531);
	        this.btnPen.setImageResource(2130837521);
	        this.paintView.setEraser(false);
	      }
	    }

	    private void showSoftInput()
	    {
	      ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(2, 1);
	    }

	    public void onConfigurationChanged(Configuration paramConfiguration)
	    {
	      super.onConfigurationChanged(paramConfiguration);
	      onResize(paramConfiguration);
	    }

	    protected void onCreate(Bundle paramBundle)
	    {
	      super.onCreate(paramBundle);
	      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
	      localLayoutParams.flags = 2;
	      localLayoutParams.dimAmount = 0.75F;
	      localLayoutParams.windowAnimations = 17432581;
	      getWindow().setAttributes(localLayoutParams);
	      setContentView(2130903040);
	      this.PaintDlgBG = ((ImageView)findViewById(2131165185));
	      this.PaintLayout = ((FrameLayout)getWindow().findViewById(2131165193));
	      this.iconPen = ((ImageView)findViewById(2131165187));
	      this.etNote = ((EditText)findViewById(2131165189));
	      if (getResources().getConfiguration().orientation == 2)
	      {
	        FrameLayout localFrameLayout = (FrameLayout)findViewById(2131165184);
	        if (localFrameLayout != null)
	        {
	          int k = (int)getWindow().getContext().getResources().getDimension(2130968611);
	          ((FrameLayout.LayoutParams)localFrameLayout.getLayoutParams()).leftMargin = k;
	        }
	        if (this.PaintDlgBG != null)
	          this.PaintDlgBG.setVisibility(0);
	        ImageView localImageView = (ImageView)findViewById(2131165191);
	        if (localImageView != null)
	        {
	          FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
	          localImageView.setBackgroundResource(2130837507);
	          int i = (int)getWindow().getContext().getResources().getDimension(2130968608);
	          int j = (int)getWindow().getContext().getResources().getDimension(2130968610);
	          localLayoutParams1.width = i;
	          localLayoutParams1.height = j;
	          localImageView.setVisibility(0);
	        }
	      }
	      this.etNote.addTextChangedListener(new NoteTextChangedListener(null));
	      this.btnPen = ((ImageButton)findViewById(2131165195));
	      this.btnPen.setOnClickListener(new View.OnClickListener()
	      {
	        public void onClick(View paramView)
	        {
	          boolean bool = PaintActivity.this.paintView.isEraser();
	          PaintActivity.this.setPen(bool);
	        }
	      });
	      this.btnHand = ((ImageButton)findViewById(2131165194));
	      this.btnHand.setOnClickListener(new View.OnClickListener()
	      {
	        public void onClick(View paramView)
	        {
	          boolean bool = PaintActivity.this.paintView.isActive();
	          PaintActivity.this.changeInput(bool);
	        }
	      });
	      this.btnOK = ((Button)findViewById(2131165196));
	      this.btnOK.setOnClickListener(new View.OnClickListener()
	      {
	        public void onClick(View paramView)
	        {
	          PaintActivity.this.hideSoftInput(PaintActivity.this.etNote);
	          Calendar localCalendar = Calendar.getInstance();
	          String str1 = StorageUtil.getStorageDirectory() + "/paint/";
	          String str2 = str1 + localCalendar.get(1);
	          StringBuilder localStringBuilder1 = new StringBuilder().append(str2);
	          Object[] arrayOfObject1 = new Object[1];
	          arrayOfObject1[0] = Integer.valueOf(1 + localCalendar.get(2));
	          String str3 = String.format("%02d", arrayOfObject1);
	          StringBuilder localStringBuilder2 = new StringBuilder().append(str3);
	          Object[] arrayOfObject2 = new Object[1];
	          arrayOfObject2[0] = Integer.valueOf(localCalendar.get(5));
	          String str4 = String.format("%02d", arrayOfObject2);
	          StringBuilder localStringBuilder3 = new StringBuilder().append(str4);
	          Object[] arrayOfObject3 = new Object[1];
	          arrayOfObject3[0] = Integer.valueOf(localCalendar.get(11));
	          String str5 = String.format("%02d", arrayOfObject3);
	          StringBuilder localStringBuilder4 = new StringBuilder().append(str5);
	          Object[] arrayOfObject4 = new Object[1];
	          arrayOfObject4[0] = Integer.valueOf(localCalendar.get(12));
	          String str6 = String.format("%02d", arrayOfObject4);
	          StringBuilder localStringBuilder5 = new StringBuilder().append(str6);
	          Object[] arrayOfObject5 = new Object[1];
	          arrayOfObject5[0] = Integer.valueOf(localCalendar.get(13));
	          String str7 = String.format("%02d", arrayOfObject5);
	          String str8 = str7 + ".pnt";
	          Canvas localCanvas = PaintActivity.this.paintView.getCanvas();
	          PaintActivity.this.etNote.setHintTextColor(0);
	          PaintActivity.this.etNote.setCursorVisible(false);
	          PaintActivity.this.etNote.draw(localCanvas);
	          PaintActivity.this.paintView.save(str8);
	          PaintActivity.this.sendPaint(str8);
	        }
	      });
	      String str = getIntent().getStringExtra("com.htc.rosiewidgets.note.PAINT_FILENAME");
	      this.paintView = ((PaintView)findViewById(2131165190));
	      if (!str.equals(""))
	        this.paintView.setImage(str);
	    }

	    protected void onDestroy()
	    {
	      super.onDestroy();
	    }

	    protected void onPause()
	    {
	      this.paintView.saveCurrentPostState();
	      hideSoftInput(this.etNote);
	      super.onPause();
	      if (this.mIMEStateRecv != null)
	      {
	        unregisterReceiver(this.mIMEStateRecv);
	        this.mIMEStateRecv = null;
	      }
	    }

	    public void onResize(Configuration paramConfiguration)
	    {
	      ImageView localImageView1 = (ImageView)findViewById(2131165186);
	      if (localImageView1 != null)
	      {
	        localImageView1.setImageResource(0);
	        localImageView1.setImageResource(2130837530);
	        int i25 = (int)getWindow().getContext().getResources().getDimension(2130968587);
	        FrameLayout.LayoutParams localLayoutParams9 = (FrameLayout.LayoutParams)localImageView1.getLayoutParams();
	        localLayoutParams9.topMargin = i25;
	        localImageView1.setLayoutParams(localLayoutParams9);
	      }
	      if (this.iconPen != null)
	      {
	        int i24 = (int)getWindow().getContext().getResources().getDimension(2130968588);
	        FrameLayout.LayoutParams localLayoutParams8 = (FrameLayout.LayoutParams)this.iconPen.getLayoutParams();
	        localLayoutParams8.topMargin = i24;
	        this.iconPen.setLayoutParams(localLayoutParams8);
	      }
	      FrameLayout localFrameLayout1 = (FrameLayout)findViewById(2131165188);
	      if (localFrameLayout1 != null)
	      {
	        int i21 = (int)getWindow().getContext().getResources().getDimension(2130968591);
	        int i22 = (int)getWindow().getContext().getResources().getDimension(2130968589);
	        int i23 = (int)getWindow().getContext().getResources().getDimension(2130968590);
	        FrameLayout.LayoutParams localLayoutParams7 = (FrameLayout.LayoutParams)localFrameLayout1.getLayoutParams();
	        localLayoutParams7.topMargin = i21;
	        localLayoutParams7.width = i22;
	        localLayoutParams7.height = i23;
	        localFrameLayout1.setLayoutParams(localLayoutParams7);
	      }
	      float f;
	      int i16;
	      int i17;
	      String str;
	      label414: ImageView localImageView2;
	      label640: FrameLayout.LayoutParams localLayoutParams4;
	      if (this.etNote != null)
	      {
	        int i13 = (int)getWindow().getContext().getResources().getDimension(2130968592);
	        int i14 = (int)getWindow().getContext().getResources().getDimension(2130968593);
	        int i15 = (int)getWindow().getContext().getResources().getDimension(2130968594);
	        f = getWindow().getContext().getResources().getDimension(2130968595);
	        i16 = this.etNote.getLineCount();
	        i17 = getWindow().getContext().getResources().getInteger(2131034130);
	        str = this.etNote.getText().toString();
	        if (paramConfiguration.orientation != 2)
	          break label1341;
	        if (i16 >= i17)
	        {
	          if (this.mTextSizeLand == 0.0F)
	            this.mTextSizeLand = f;
	          if (this.mText == null)
	            str.length();
	        }
	        else
	        {
	          this.mText = this.etNote.getText().toString();
	          f = this.mTextSizeLand;
	          this.etNote.setPadding(i13, i15, i14, 0);
	          this.etNote.setTextSize(0, f);
	        }
	      }
	      else
	      {
	        Configuration localConfiguration = getResources().getConfiguration();
	        FrameLayout localFrameLayout2 = (FrameLayout)findViewById(2131165184);
	        if (localFrameLayout2 != null)
	        {
	          int i12 = 0;
	          if (localConfiguration.orientation == 2)
	            i12 = (int)getWindow().getContext().getResources().getDimension(2130968611);
	          ((FrameLayout.LayoutParams)localFrameLayout2.getLayoutParams()).leftMargin = i12;
	        }
	        if (this.PaintDlgBG != null)
	        {
	          if (localConfiguration.orientation != 2)
	            break label1592;
	          FrameLayout.LayoutParams localLayoutParams6 = (FrameLayout.LayoutParams)this.PaintDlgBG.getLayoutParams();
	          this.PaintDlgBG.setBackgroundResource(2130837508);
	          int i9 = (int)getWindow().getContext().getResources().getDimension(2130968607);
	          int i10 = (int)getWindow().getContext().getResources().getDimension(2130968608);
	          int i11 = (int)getWindow().getContext().getResources().getDimension(2130968609);
	          localLayoutParams6.width = i10;
	          localLayoutParams6.height = i11;
	          localLayoutParams6.topMargin = i9;
	          this.PaintDlgBG.setLayoutParams(localLayoutParams6);
	          this.PaintDlgBG.setVisibility(0);
	        }
	        if (this.PaintLayout != null)
	        {
	          this.PaintLayout.setBackgroundResource(0);
	          FrameLayout.LayoutParams localLayoutParams5 = (FrameLayout.LayoutParams)this.PaintLayout.getLayoutParams();
	          int i7 = (int)getWindow().getContext().getResources().getDimension(2130968596);
	          int i8 = (int)getWindow().getContext().getResources().getDimension(2130968612);
	          localLayoutParams5.topMargin = i7;
	          localLayoutParams5.leftMargin = i8;
	          this.PaintLayout.setBackgroundResource(2130837510);
	          localLayoutParams5.width = -2;
	          localLayoutParams5.height = -2;
	          this.PaintLayout.setLayoutParams(localLayoutParams5);
	        }
	        localImageView2 = (ImageView)findViewById(2131165191);
	        if (localImageView2 != null)
	        {
	          localImageView2.setBackgroundResource(0);
	          localLayoutParams4 = (FrameLayout.LayoutParams)localImageView2.getLayoutParams();
	          if (localConfiguration.orientation != 2)
	            break label1603;
	          localImageView2.setBackgroundResource(2130837507);
	          int i5 = (int)getWindow().getContext().getResources().getDimension(2130968608);
	          int i6 = (int)getWindow().getContext().getResources().getDimension(2130968610);
	          localLayoutParams4.topMargin = (int)getWindow().getContext().getResources().getDimension(2130968596);
	          localLayoutParams4.width = i5;
	          localLayoutParams4.height = i6;
	          localImageView2.setVisibility(0);
	        }
	      }
	      while (true)
	      {
	        if (this.btnHand != null)
	        {
	          int i2 = (int)getWindow().getContext().getResources().getDimension(2130968600);
	          int i3 = (int)getWindow().getContext().getResources().getDimension(2130968598);
	          int i4 = (int)getWindow().getContext().getResources().getDimension(2130968599);
	          FrameLayout.LayoutParams localLayoutParams3 = (FrameLayout.LayoutParams)this.btnHand.getLayoutParams();
	          localLayoutParams3.width = i3;
	          localLayoutParams3.height = i4;
	          localLayoutParams3.leftMargin = i2;
	          this.btnHand.setLayoutParams(localLayoutParams3);
	        }
	        if (this.btnPen != null)
	        {
	          int m = (int)getWindow().getContext().getResources().getDimension(2130968603);
	          int n = (int)getWindow().getContext().getResources().getDimension(2130968601);
	          int i1 = (int)getWindow().getContext().getResources().getDimension(2130968602);
	          FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.btnPen.getLayoutParams();
	          localLayoutParams2.width = n;
	          localLayoutParams2.height = i1;
	          localLayoutParams2.leftMargin = m;
	          this.btnPen.setLayoutParams(localLayoutParams2);
	        }
	        if (this.btnOK != null)
	        {
	          int i = (int)getWindow().getContext().getResources().getDimension(2130968606);
	          int j = (int)getWindow().getContext().getResources().getDimension(2130968604);
	          int k = (int)getWindow().getContext().getResources().getDimension(2130968605);
	          FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.btnOK.getLayoutParams();
	          localLayoutParams1.width = j;
	          localLayoutParams1.height = k;
	          localLayoutParams1.leftMargin = i;
	          this.btnOK.setLayoutParams(localLayoutParams1);
	        }
	        this.paintView.onResize();
	        return;
	        if (this.mText.length() >= str.length())
	          break;
	        int i20 = str.length() - this.mText.length();
	        if (i20 == 1)
	          f = this.mTextSizeLand - 2.0F;
	        if ((i20 <= 4) && (i20 > 1))
	          f = this.mTextSizeLand - 3.0F;
	        if (i20 > 4)
	        {
	          f = this.mTextSizeLand - 5.0F;
	          if (str.length() <= 200)
	            break label1320;
	          f = this.mTextSizeLand - 4.0F;
	        }
	        while (true)
	        {
	          this.mTextSizeLand = f;
	          break;
	          label1320: if (str.length() <= 100)
	            continue;
	          f = this.mTextSizeLand - 2.0F;
	        }
	        label1341: if (paramConfiguration.orientation != 1)
	          break label414;
	        int i19;
	        if (i16 >= i17)
	        {
	          if (this.mTextSizePort == 0.0F)
	            this.mTextSizePort = f;
	          if (this.mText != null)
	            break label1459;
	          i19 = str.length();
	          (this.mTextSizePort - 4.0F);
	          if (i19 <= 200)
	            break label1437;
	          this.mTextSizePort -= 6.0F;
	        }
	        label1437: label1459: 
	        do
	          while (true)
	          {
	            this.mText = this.etNote.getText().toString();
	            f = this.mTextSizePort;
	            break;
	            if (i19 <= 100)
	              continue;
	            this.mTextSizePort -= 3.0F;
	          }
	        while (this.mText.length() >= str.length());
	        int i18 = str.length() - this.mText.length();
	        if (i18 == 1)
	          f = this.mTextSizePort - 2.0F;
	        if ((i18 <= 4) && (i18 > 1))
	          f = this.mTextSizePort - 3.0F;
	        if (i18 > 4)
	        {
	          f = this.mTextSizePort - 5.0F;
	          if (str.length() <= 200)
	            break label1571;
	          f = this.mTextSizePort - 4.0F;
	        }
	        while (true)
	        {
	          this.mTextSizePort = f;
	          break;
	          label1571: if (str.length() <= 100)
	            continue;
	          f = this.mTextSizePort - 2.0F;
	        }
	        label1592: this.PaintDlgBG.setVisibility(4);
	        break label640;
	        label1603: localLayoutParams4.width = 0;
	        localLayoutParams4.height = 0;
	        localImageView2.setVisibility(4);
	      }
	    }

	    protected void onResume()
	    {
	      super.onResume();
	      this.nSipHeight = 0;
	      IntentFilter localIntentFilter = new IntentFilter("HTC_IME_CURRENT_STATE");
	      this.mIMEStateRecv = new HTC_IMEReceiver();
	      registerReceiver(this.mIMEStateRecv, localIntentFilter);
	    }

	    private class NoteTextChangedListener
	      implements TextWatcher
	    {
	      String mPreStr = null;
	      int nSelection = 0;

	      private NoteTextChangedListener()
	      {
	      }

	      public void afterTextChanged(Editable paramEditable)
	      {
	        String str = null;
	        try
	        {
	          int i = PaintActivity.this.getWindow().getContext().getResources().getInteger(2131034130);
	          str = paramEditable.toString();
	          if (PaintActivity.this.etNote.getLineCount() > i)
	          {
	            PaintActivity.this.etNote.setText(this.mPreStr);
	            PaintActivity.this.etNote.setSelection(this.nSelection);
	          }
	          return;
	        }
	        catch (Exception localException)
	        {
	          while (true)
	            Log.d("notes", "afterTextChanged exception,str=" + str);
	        }
	      }

	      public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
	      {
	        int i = PaintActivity.this.getWindow().getContext().getResources().getInteger(2131034130);
	        if (PaintActivity.this.etNote.getLineCount() == i)
	        {
	          this.nSelection = PaintActivity.this.etNote.getSelectionEnd();
	          this.mPreStr = PaintActivity.this.etNote.getText().toString();
	        }
	      }

	      public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
	      {
	      }
	    }

	    public class HTC_IMEReceiver extends BroadcastReceiver
	    {
	      public HTC_IMEReceiver()
	      {
	      }

	      public void onReceive(Context paramContext, Intent paramIntent)
	      {
	        String str1 = paramIntent.getStringExtra("SIP");
	        String str2 = paramIntent.getStringExtra("ENG_MODE");
	        int i = paramIntent.getIntExtra("SIP_HEIGHT", 0);
	        if ((PaintActivity.this.nSipHeight != 0) && (i == 0))
	          PaintActivity.this.changeInput(false);
	        PaintActivity.access$002(PaintActivity.this, i);
	        Log.e("PaintActivity", "SIP=" + str1 + ", Height=" + i + " MODE=" + str2);
	      }
	    }
	  }
}