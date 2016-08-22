package com.github.markzhai.react.preloader;

import android.os.Bundle;

/**
 * {@link ReactInfo} describes a ReactActivity's necessary information.
 *
 * @author markzhai on 16/8/21
 * @version 1.3.0
 */
public class ReactInfo {

    private String mMainComponentName;
    private Bundle mLaunchOptions;

    public ReactInfo(String mainComponentName) {
        mMainComponentName = mainComponentName;
    }

    public ReactInfo(String mainComponentName, Bundle launchOptions) {
        mMainComponentName = mainComponentName;
        mLaunchOptions = launchOptions;
    }

    public Bundle getLaunchOptions() {
        return mLaunchOptions;
    }

    public String getMainComponentName() {
        return mMainComponentName;
    }
}
