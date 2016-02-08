/*
 *  Created by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package it.jaschke.alexandria.provider.authors;

import android.net.Uri;
import android.provider.BaseColumns;

import it.jaschke.alexandria.provider.BooksProvider;

/**
 * Table containing authors. Each entry is an author, book pairing.
 */
public class AuthorsColumns implements BaseColumns {
    public static final String TABLE_NAME = "authors";
    public static final Uri CONTENT_URI = Uri.parse(BooksProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Author's name. (String, Not nullable)
     */
    public static final String NAME = "name";

    /**
     * The volume corresponding to the author. (String, Not nullable)
     */
    public static final String AUTHORVOLUMEID = "authorVolumeId";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            AUTHORVOLUMEID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(AUTHORVOLUMEID) || c.contains("." + AUTHORVOLUMEID)) return true;
        }
        return false;
    }

}
