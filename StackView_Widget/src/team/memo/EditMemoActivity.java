package team.memo;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMemoActivity extends Activity {

	EditText memoedit;

	DataBaseHelper dbHelper;
	
	final static String dbName = "memo.db";
	final static int dbVersion = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
		
		memoedit = (EditText)findViewById(R.id.editTest);
		
		dbHelper = new DataBaseHelper(this, dbName, null, dbVersion);
		
		Button finish = (Button)findViewById(R.id.button1);
		finish.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				SQLiteDatabase db;
				String sql;
				
				if(v.getId() == R.id.button1)
				{
					String content = memoedit.getText().toString();
					
					db = dbHelper.getWritableDatabase();
					sql = String.format("INSERT INTO memo VALUES(NULL, '%s');", content);
					db.execSQL(sql);
					
					Toast toast = Toast.makeText(getApplicationContext(), "ภ๚ภๅตส", Toast.LENGTH_LONG);
					toast.show();
				}
				
				dbHelper.close();
				
			}
			
		
		});	 
	}
}
