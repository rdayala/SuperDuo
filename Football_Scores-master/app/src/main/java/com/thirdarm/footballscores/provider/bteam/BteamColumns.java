/*
 *  Created by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package com.thirdarm.footballscores.provider.bteam;

import android.net.Uri;
import android.provider.BaseColumns;

import com.thirdarm.footballscores.provider.ScoresProvider;

/**
 * A team. Primarily used as a reference for away teams.
 */
public class BteamColumns implements BaseColumns {
    public static final String TABLE_NAME = "bteam";
    public static final Uri CONTENT_URI = Uri.parse(ScoresProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * The name of the team. (String, Not nullable)
     */
    public static final String NAME = "bteam__name";

    /**
     * The short name of the team. (String, Nullable)
     */
    public static final String SHORTNAME = "bteam__shortname";

    /**
     * The code name of the team. (String, Nullable)
     */
    public static final String CODE = "bteam__code";

    /**
     * The squad market value of the team. (String, Nullable)
     */
    public static final String VALUE = "bteam__value";

    /**
     * The team's crest url. (String, Nullable)
     */
    public static final String CRESTURL = "bteam__cresturl";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            SHORTNAME,
            CODE,
            VALUE,
            CRESTURL
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(SHORTNAME) || c.contains("." + SHORTNAME)) return true;
            if (c.equals(CODE) || c.contains("." + CODE)) return true;
            if (c.equals(VALUE) || c.contains("." + VALUE)) return true;
            if (c.equals(CRESTURL) || c.contains("." + CRESTURL)) return true;
        }
        return false;
    }

}
