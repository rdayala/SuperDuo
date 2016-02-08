/*
 *  Created by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package it.jaschke.alexandria.provider.authors;

import android.database.Cursor;
import android.support.annotation.NonNull;

import it.jaschke.alexandria.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code authors} table.
 */
public class AuthorsCursor extends AbstractCursor implements AuthorsModel {
    public AuthorsCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(AuthorsColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Author's name. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    public String getName() {
        String res = getStringOrNull(AuthorsColumns.NAME);
        if (res == null)
            throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The volume corresponding to the author. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    public String getAuthorvolumeid() {
        String res = getStringOrNull(AuthorsColumns.AUTHORVOLUMEID);
        if (res == null)
            throw new NullPointerException("The value of 'authorvolumeid' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
