/*
 * Copyright (C) 2016 MarkZhai (http://zhaiyifan.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.markzhai.react.preloader;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.ViewGroup;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactRootView;

import java.util.Map;

/**
 * React Native Bundle Pre-loader.
 *
 * @author markzhai on 16/8/20
 * @version 0.31.0
 */
public class ReactPreLoader {

    private static final String TAG = "ReactPreLoader";

    private static final Map<String, ReactRootView> CACHE_VIEW_MAP =
            new ArrayMap<>();

    /**
     * Get {@link ReactRootView} with corresponding {@link ReactInfo}.
     */
    public static ReactRootView getRootView(ReactInfo reactInfo) {
        return CACHE_VIEW_MAP.get(reactInfo.getMainComponentName());
    }

    /**
     * Pre-load {@link ReactRootView} to local {@link Map}, you may want to
     * load it in previous activity.
     */
    public static void init(Activity activity, ReactInfo reactInfo) {
        if (CACHE_VIEW_MAP.get(reactInfo.getMainComponentName()) != null) {
            return;
        }
        ReactRootView rootView = new ReactRootView(new MutableContextWrapper(activity));
        rootView.startReactApplication(
                ((ReactApplication) activity.getApplication()).getReactNativeHost().getReactInstanceManager(),
                reactInfo.getMainComponentName(),
                reactInfo.getLaunchOptions());
        CACHE_VIEW_MAP.put(reactInfo.getMainComponentName(), rootView);
    }

    /**
     * Remove {@link ReactRootView} from parent.
     */
    public static void onDestroy(ReactInfo reactInfo) {
        try {
            ReactRootView rootView = getRootView(reactInfo);
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
