 package android.widget;
 
 import java.util.HashMap;
 
 import android.app.Service;
 import android.content.Intent;
 import android.os.IBinder;
 
 import com.android.internal.widget.IRemoteViewsFactory;


31 
32 public abstract class RemoteViewsService extends Service {
33 
34     private static final String LOG_TAG = "RemoteViewsService";
35 
36     // Used for reference counting of RemoteViewsFactories
37     // Because we are now unbinding when we are not using the Service (to allow them to be
38     // reclaimed), the references to the factories that are created need to be stored and used when
39     // the service is restarted (in response to user input for example).  When the process is
40     // destroyed, so is this static cache of RemoteViewsFactories.
41     private static final HashMap<Intent.FilterComparison, RemoteViewsFactory> sRemoteViewFactories =
42             new HashMap<Intent.FilterComparison, RemoteViewsFactory>();
43     private static final Object sLock = new Object();

    
An interface for an adapter between a remote collection view (ListView, GridView, etc) and the underlying data for that view. The implementor is responsible for making a RemoteView for each item in the data set. This interface is a thin wrapper around Adapter.
See also:
Adapter
android.appwidget.AppWidgetManager
52 
53     public interface RemoteViewsFactory {
        
Called when your factory is first constructed. The same factory may be shared across multiple RemoteViewAdapters depending on the intent passed.
57 
58         public void onCreate();

        
Called when notifyDataSetChanged() is triggered on the remote adapter. This allows a RemoteViewsFactory to respond to data changes by updating any internal references. Note: expensive tasks can be safely performed synchronously within this method. In the interim, the old data will be displayed within the widget.
See also:
android.appwidget.AppWidgetManager.notifyAppWidgetViewDataChanged(int[],int)
68 
69         public void onDataSetChanged();

        
Called when the last RemoteViewsAdapter that is associated with this factory is unbound.
74 
75         public void onDestroy();

        
See Adapter.getCount()
Returns:
Count of items.
81 
82         public int getCount();

        
See Adapter.getView(int,android.view.View,android.view.ViewGroup). Note: expensive tasks can be safely performed synchronously within this method, and a loading view will be displayed in the interim. See getLoadingView().
Parameters:
position The position of the item within the Factory's data set of the item whose view we want.
Returns:
A RemoteViews object corresponding to the data at the specified position.
93 
94         public RemoteViews getViewAt(int position);

        
This allows for the use of a custom loading view which appears between the time that getViewAt(int) is called and returns. If null is returned, a default loading view will be used.
Returns:
The RemoteViews representing the desired loading view.
102
103        public RemoteViews getLoadingView();

        
See Adapter.getViewTypeCount().
Returns:
The number of types of Views that will be returned by this factory.
109
110        public int getViewTypeCount();

        
See Adapter.getItemId(int).
Parameters:
position The position of the item within the data set whose row id we want.
Returns:
The id of the item at the specified position.
117
118        public long getItemId(int position);

        
See Adapter.hasStableIds().
Returns:
True if the same id always refers to the same object.
124
125        public boolean hasStableIds();
126    }

    
A private proxy class for the private IRemoteViewsFactory interface through the public RemoteViewsFactory interface.
131
132    private static class RemoteViewsFactoryAdapter extends IRemoteViewsFactory.Stub {
133        public RemoteViewsFactoryAdapter(RemoteViewsFactory factory, boolean isCreated) {
134            mFactory = factory;
135            mIsCreated = isCreated;
136        }
137        public synchronized boolean isCreated() {
138            return mIsCreated;
139        }
140        public synchronized void onDataSetChanged() {
141            try {
142                mFactory.onDataSetChanged();
143            } catch (Exception ex) {
144                Thread t = Thread.currentThread();
145                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
146            }
147        }
148        public synchronized int getCount() {
149            int count = 0;
150            try {
151                count = mFactory.getCount();
152            } catch (Exception ex) {
153                Thread t = Thread.currentThread();
154                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
155            }
156            return count;
157        }
158        public synchronized RemoteViews getViewAt(int position) {
159            RemoteViews rv = null;
160            try {
161                rv = mFactory.getViewAt(position);
162                if (rv != null) {
163                    rv.setIsWidgetCollectionChild(true);
164                }
165            } catch (Exception ex) {
166                Thread t = Thread.currentThread();
167                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
168            }
169            return rv;
170        }
171        public synchronized RemoteViews getLoadingView() {
172            RemoteViews rv = null;
173            try {
174                rv = mFactory.getLoadingView();
175            } catch (Exception ex) {
176                Thread t = Thread.currentThread();
177                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
178            }
179            return rv;
180        }
181        public synchronized int getViewTypeCount() {
182            int count = 0;
183            try {
184                count = mFactory.getViewTypeCount();
185            } catch (Exception ex) {
186                Thread t = Thread.currentThread();
187                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
188            }
189            return count;
190        }
191        public synchronized long getItemId(int position) {
192            long id = 0;
193            try {
194                id = mFactory.getItemId(position);
195            } catch (Exception ex) {
196                Thread t = Thread.currentThread();
197                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
198            }
199            return id;
200        }
201        public synchronized boolean hasStableIds() {
202            boolean hasStableIds = false;
203            try {
204                hasStableIds = mFactory.hasStableIds();
205            } catch (Exception ex) {
206                Thread t = Thread.currentThread();
207                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
208            }
209            return hasStableIds;
210        }
211        public void onDestroy(Intent intent) {
212            synchronized (sLock) {
213                Intent.FilterComparison fc = new Intent.FilterComparison(intent);
214                if (RemoteViewsService.sRemoteViewFactories.containsKey(fc)) {
215                    RemoteViewsFactory factory = RemoteViewsService.sRemoteViewFactories.get(fc);
216                    try {
217                        factory.onDestroy();
218                    } catch (Exception ex) {
219                        Thread t = Thread.currentThread();
220                        Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, ex);
221                    }
222                    RemoteViewsService.sRemoteViewFactories.remove(fc);
223                }
224            }
225        }
226
227        private RemoteViewsFactory mFactory;
228        private boolean mIsCreated;
229    }
230
231    @Override
232    public IBinder onBind(Intent intent) {
233        synchronized (sLock) {
234            Intent.FilterComparison fc = new Intent.FilterComparison(intent);
235            RemoteViewsFactory factory = null;
236            boolean isCreated = false;
237            if (!sRemoteViewFactories.containsKey(fc)) {
238                factory = onGetViewFactory(intent);
239                sRemoteViewFactories.put(fc, factory);
240                factory.onCreate();
241                isCreated = false;
242            } else {
243                factory = sRemoteViewFactories.get(fc);
244                isCreated = true;
245            }
246            return new RemoteViewsFactoryAdapter(factory, isCreated);
247        }
    }

    


    public abstract RemoteViewsFactory onGetViewFactory(Intent intent);
}