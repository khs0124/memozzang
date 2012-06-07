package team.memo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

public class StackWidgetProvider extends AppWidgetProvider {
	public static final String TOAST_ACTION = "com.example.android.stackwidget.TOAST_ACTION";
	public static final String EXTRA_ITEM = "com.example.android.stackwidget.EXTRA_ITEM";

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onDisabled(Context context) {
		super.onDisabled(context);
	}

	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		AppWidgetManager mgr = AppWidgetManager.getInstance(context);
		if (intent.getAction().equals(TOAST_ACTION)) {
			int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);
			int viewIndex = intent.getIntExtra(EXTRA_ITEM, 0);
			Toast.makeText(context, "Touched view " + viewIndex, Toast.LENGTH_SHORT).show();
		}
		super.onReceive(context, intent);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		// update each of the widgets with the remote adapter

		Test(context, AppWidgetManager.getInstance(context));
		updateWidgetContent(context, appWidgetManager, appWidgetIds);

		// 위젯 버튼 클릭했을 경우
		private static void setOnClickIntent(Context context, RemoteViews views, int viewId) {

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


		for (int i = 0; i < appWidgetIds.length; ++i) {

			// Here we setup the intent which points to the StackViewService which will
			// provide the views for this collection.
			Intent intent = new Intent(context, StackWidgetService.class);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
			// When intents are compared, the extras are ignored, so we need to embed the extras
			// into the data so that the extras will not be ignored.

			intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
			RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			rv.setRemoteAdapter(appWidgetIds[i], R.id.stack_view, intent);

			// The empty view is displayed when the collection has no items. It should be a sibling
			// of the collection view.
			rv.setEmptyView(R.id.stack_view, R.id.empty_view);

			// Here we setup the a pending intent template. Individuals items of a collection
			// cannot setup their own pending intents, instead, the collection as a whole can
			// setup a pending intent template, and the individual items can set a fillInIntent
			// to create unique before on an item to item basis.
			Intent toastIntent = new Intent(context, StackWidgetProvider.class);

			toastIntent.setAction(StackWidgetProvider.TOAST_ACTION);
			toastIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);

			intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

			PendingIntent toastPendingIntent = PendingIntent.getBroadcast(context, 0, toastIntent,
					PendingIntent.FLAG_UPDATE_CURRENT);

			rv.setPendingIntentTemplate(R.id.stack_view, toastPendingIntent);

			appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
		}
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
}