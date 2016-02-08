/*
 *  Created by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package it.jaschke.alexandria.provider.books;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import it.jaschke.alexandria.provider.base.BaseModel;

/**
 * Table containing volumes. Each entry in table is complete information about a single volume (book).
 */
public interface BooksModel extends BaseModel {

    /**
     * The id of the volume. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    String getBookid();

    /**
     * The title of the volume. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * The subtitle of the volume. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getSubtitle();

    /**
     * The authors. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getAuthors();

    /**
     * Publishers. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getPublisher();

    /**
     * The date of publishing. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getPublisheddate();

    /**
     * The description. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getDescription();

    /**
     * ISBN 10. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getIsbn10();

    /**
     * ISBN 13. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getIsbn13();

    /**
     * Number of pages. (Integer, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    Integer getPagecount();

    /**
     * The volume's categories. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getCategories();

    /**
     * Average rating. (Double, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    Double getAveragerating();

    /**
     * Number of ratings. (Integer, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    Integer getRatingscount();

    /**
     * Small thumbnail url. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getSmallthumbnailurl();

    /**
     * Large thumbnail url. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getThumbnailurl();

    /**
     * Language. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getLanguage();

    /**
     * Google Books info page. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getInfolink();

    /**
     * Shortened description of volume. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getDescriptionsnippet();
}
