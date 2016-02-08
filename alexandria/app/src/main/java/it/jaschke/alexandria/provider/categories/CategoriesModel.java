/*
 *  Created by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package it.jaschke.alexandria.provider.categories;

import android.support.annotation.NonNull;

import it.jaschke.alexandria.provider.base.BaseModel;

/**
 * Table containing categories. Each entry is an category, book pairing.
 */
public interface CategoriesModel extends BaseModel {

    /**
     * Category name. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();

    /**
     * The volume corresponding to the category. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    String getCategoryvolumeid();
}
