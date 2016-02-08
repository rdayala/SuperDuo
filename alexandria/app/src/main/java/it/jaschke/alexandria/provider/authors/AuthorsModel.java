/*
 *  Created by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package it.jaschke.alexandria.provider.authors;

import android.support.annotation.NonNull;

import it.jaschke.alexandria.provider.base.BaseModel;

/**
 * Table containing authors. Each entry is an author, book pairing.
 */
public interface AuthorsModel extends BaseModel {

    /**
     * Author's name. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();

    /**
     * The volume corresponding to the author. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    String getAuthorvolumeid();
}
