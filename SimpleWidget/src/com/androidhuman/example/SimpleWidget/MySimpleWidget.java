package com.androidhuman.example.SimpleWidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;

public class MySimpleWidget extends AppWidgetProvider {

	static DataBaseHelper mHelper;
	static Cursor mCursor;
	static int coloumNumber = 0;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {

		Test(context, AppWidgetManager.getInstance(context));
		updateWidgetContent(context, appWidgetManager, appWidgetIds);

	}

	// 위젯 클릭했을 경우
	private static void setOnClickIntent(Context context, RemoteViews views,
			int viewId) {

		Class<?> ClassName = null;
		if (viewId == R.id.new_memo) {
			ClassName = EditMemoActivity.class;
		} else if (viewId == R.id.memo_list_button) {
			ClassName = MemoListActivity.class;
		}
		Intent intent = new Intent();
		intent = new Intent(context, ClassName);

		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
				intent, 0);
		views.setOnClickPendingIntent(viewId, pendingIntent);

	}

	public void Test(Context context, AppWidgetManager appWidgetManager) {

		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.simple_widget_layout);
		ComponentName mainWidget = new ComponentName(context,
				MySimpleWidget.class);
		// views.setOnClickPendingIntent(R.id.memo_list_button, pendngIntent);

		setOnClickIntent(context, views, R.id.memo_list_button);
		setOnClickIntent(context, views, R.id.new_memo);
		appWidgetManager.updateAppWidget(mainWidget, views);
	}

	public static void updateWidgetContent(Context context,
			AppWidgetManager appWidgetManager, int[] appWidgetIds) {

		mHelper = new DataBaseHelper(null, "memo.db", null, 1);
		mCursor = mHelper.getReadableDatabase().rawQuery("SELECT * FROM memo;",
				null);
		mCursor.moveToFirst();

		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.simple_widget_layout);
		views.setTextViewText(R.id.memo_text, mCursor.getString(coloumNumber));
	}

	@Override
	public void onReceive(Context context, Intent intent) {

		Test(context, AppWidgetManager.getInstance(context));

	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {

	}

	@Override
	public void onDisabled(Context context) {

	}

	@Override
	public void onEnabled(Context context) {

	}
}

/*
 * private PendingIntent MemoListActivityIntent(Context context) { Intent intent
 * = new Intent(Intent.ACTION_VIEW); PendingIntent memolistintent =
 * PendingIntent.getActivity(context, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
 * return memolistintent; }
 */

