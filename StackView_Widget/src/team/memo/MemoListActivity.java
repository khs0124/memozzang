package team.memo;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MemoListActivity extends ListActivity{

	// String[] items = { "lorem", "ipsum", "wallet", "pen", "cellPhone", "key",
	// "gum", "mp3", "face", "clock" };

	DataBaseHelper mHelper;
	Cursor mcursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// ListView listview = (ListView)findViewById(R.id.memo_list_view);
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_expandable_list_item_1, items);
		// listview.setAdapter(adapter);

		mHelper = new DataBaseHelper(this, "memo.db", null, 1);
		mcursor = mHelper.getWritableDatabase().rawQuery(
				"SELECT * FROM memo;", null);
		mcursor.moveToFirst();
		ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.memo_list,
				mcursor, new String[] { DataBaseHelper.CONTENT },
				new int[] { R.id.memo_list_view });
		setListAdapter(adapter);
		registerForContextMenu(getListView());
	}
}
