/*
 *  Created by rdayala
 *
 *  Content provider files generated using Benoit Lubek's (BoD)
 *    Android ContentProvider Generator.
 *    (url: https://github.com/BoD/android-contentprovider-generator)
 */
package com.thirdarm.footballscores.provider.ateam;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.thirdarm.footballscores.provider.base.BaseModel;

/**
 * A team. Primarily used as a reference for home teams.
 */
public interface AteamModel extends BaseModel {

    /**
     * The name of the team. (String, Not nullable)
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();

    /**
     * The short name of the team. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getShortname();

    /**
     * The code name of the team. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getCode();

    /**
     * The squad market value of the team. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getValue();

    /**
     * The team's crest url. (String, Nullable)
     * Can be {@code null}.
     */
    @Nullable
    String getCresturl();
}
