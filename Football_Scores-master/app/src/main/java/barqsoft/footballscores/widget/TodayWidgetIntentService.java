package barqsoft.footballscores.widget;

/**
 * Created by ashbey on 11/16/2015.
 */

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

import barqsoft.footballscores.MainActivity;
import barqsoft.footballscores.R;
import barqsoft.footballscores.Utilies;
import barqsoft.footballscores.data.DatabaseContract;

/**
 * IntentService which handles updating all Today widgets with the latest data
 */
public class TodayWidgetIntentService extends IntentService {
    public final String LOG_TAG = TodayWidgetIntentService.class.getSimpleName();
    private static final String[] FORECAST_COLUMNS = {
        DatabaseContract.scores_table.MATCH_ID,
        DatabaseContract.scores_table.HOME_COL,
            DatabaseContract.scores_table.AWAY_COL,
        DatabaseContract.scores_table.AWAY_GOALS_COL,
        DatabaseContract.scores_table.HOME_GOALS_COL,
        DatabaseContract.scores_table.TIME_COL

    };
    // these indices must match the projection
    private static final int INDEX_MATCH_ID = 0;
    private static final int INDEX_HOME = 1;
    private static final int INDEX_AWAY = 2;
    private static final int INDEX_AWAY_GOALS = 3;
    private static final int INDEX_HOME_GOALS = 4;
    private static final int INDEX_TIME = 5;

    public TodayWidgetIntentService() {
        super("TodayWidgetIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Retrieve all of the Today widget ids: these are the widgets we need to update
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this,
                TodayWidgetProvider.class));

        //cursorLoader(getActivity(), DatabaseContract.scores_table.buildScoreWithDate(),
         //       null,null,fragmentdate,null);


        Cursor data = getContentResolver().query(DatabaseContract.scores_table.buildScoreWithDate(), FORECAST_COLUMNS, DatabaseContract.scores_table.DATE_COL + " = ",
                new String[] {new SimpleDateFormat("yyyy-MM-dd").format(new Date())}, DatabaseContract.scores_table.TIME_COL );
        if (data == null) {
            return;
        }
        if (!data.moveToFirst()) {
            data.close();
            return;
        }

        String homeName = data.getString(INDEX_HOME);
        String awayName = data.getString(INDEX_AWAY);
        int homeCrest = Utilies.getTeamCrestByTeamName(homeName, getApplicationContext());
        int awayCrest = Utilies.getTeamCrestByTeamName(awayName, getApplicationContext());
        String matchScore = Utilies.getScores(data.getInt(INDEX_HOME_GOALS), data.getInt(INDEX_AWAY_GOALS));
        String matchTime= data.getString(INDEX_TIME);

        data.close();

        // Perform this loop procedure for each Today widget
        for (int appWidgetId : appWidgetIds) {
            // Find the correct layout based on the widget's width
            int widgetWidth = getWidgetWidth(appWidgetManager, appWidgetId);
            int defaultWidth = getResources().getDimensionPixelSize(R.dimen.widget_today_default_width);
            int largeWidth = getResources().getDimensionPixelSize(R.dimen.widget_today_large_width);
            int layoutId;
            if (widgetWidth >= largeWidth) {
                layoutId = R.layout.widget_today_large;
            } else if (widgetWidth >= defaultWidth) {
                layoutId = R.layout.widget_today;
            } else {
                layoutId = R.layout.widget_today_small;
            }
            RemoteViews views = new RemoteViews(getPackageName(), layoutId);

            // Add the data to the RemoteViews

            views.setTextViewText(R.id.home_name, homeName);
            views.setTextViewText(R.id.away_name, awayName);
            views.setImageViewResource(R.id.home_crest, homeCrest);
            //views.setContentDescription(R.id.home_crest, homeName);
            views.setImageViewResource(R.id.away_crest, awayCrest);
            //views.setContentDescription(R.id.away_crest, awayName);
            views.setTextViewText(R.id.widget_score_textview, matchScore);
            views.setTextViewText(R.id.widget_data_textview, matchTime);


            // Create an Intent to launch MainActivity
            Intent launchIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchIntent, 0);
            views.setOnClickPendingIntent(R.id.widget, pendingIntent);
            Log.v(LOG_TAG, "Today called widget update");
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    private int getWidgetWidth(AppWidgetManager appWidgetManager, int appWidgetId) {
        // Prior to Jelly Bean, widgets were always their default size
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            return getResources().getDimensionPixelSize(R.dimen.widget_today_default_width);
        }
        // For Jelly Bean and higher devices, widgets can be resized - the current size can be
        // retrieved from the newly added App Widget Options
        return getWidgetWidthFromOptions(appWidgetManager, appWidgetId);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private int getWidgetWidthFromOptions(AppWidgetManager appWidgetManager, int appWidgetId) {
        Bundle options = appWidgetManager.getAppWidgetOptions(appWidgetId);
        if (options.containsKey(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)) {
            int minWidthDp = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
            // The width returned is in dp, but we'll convert it to pixels to match the other widths
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, minWidthDp,
                    displayMetrics);
        }
        return  getResources().getDimensionPixelSize(R.dimen.widget_today_default_width);
    }


}