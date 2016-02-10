package com.thirdarm.footballscores.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by rdayala
 *
 * This service allows the factory to be bound to the collection service.
 */
public class ScoresWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ScoresRemoteViewsFactory(this.getApplicationContext(), intent);
    }
}