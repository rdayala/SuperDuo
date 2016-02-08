package barqsoft.footballscores.widget;

/**
 * Created by ashbey on 11/16/2015.
 */

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import barqsoft.footballscores.sync.FootballSyncAdapter;

/**
 * Provider for a widget showing today's weather.
 */
public class TodayWidgetProvider extends AppWidgetProvider {
    public final String LOG_TAG = TodayWidgetProvider.class.getSimpleName();

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {


        Log.v(LOG_TAG, "Updating daily widget");
        context.startService(new Intent(context, TodayWidgetIntentService.class));

    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager,
                                          int appWidgetId, Bundle newOptions) {
        context.startService(new Intent(context, TodayWidgetIntentService.class));
    }


    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        super.onReceive(context, intent);
        Log.v(LOG_TAG, "Receive today widget");
        if (FootballSyncAdapter.ACTION_DATA_UPDATED.equals(intent.getAction())) {
            context.startService(new Intent(context, TodayWidgetIntentService.class));
        }
    }
}