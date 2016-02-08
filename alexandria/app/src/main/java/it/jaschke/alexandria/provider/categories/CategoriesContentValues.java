/*
 *  Crated by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package it.jaschke.alexandria.provider.categories;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import it.jaschke.alexandria.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code categories} table.
 */
public class CategoriesContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return CategoriesColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable CategoriesSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable CategoriesSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Category name. (String, Not nullable)
     */
    public CategoriesContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(CategoriesColumns.NAME, value);
        return this;
    }


    /**
     * The volume corresponding to the category. (String, Not nullable)
     */
    public CategoriesContentValues putCategoryvolumeid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("categoryvolumeid must not be null");
        mContentValues.put(CategoriesColumns.CATEGORYVOLUMEID, value);
        return this;
    }

}
