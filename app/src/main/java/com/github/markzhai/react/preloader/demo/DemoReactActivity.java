package com.github.markzhai.react.preloader.demo;

import com.github.markzhai.react.preloader.MrReactActivity;
import com.github.markzhai.react.preloader.ReactInfo;

/**
 * @author markzhai on 16/8/22
 * @version 1.3.0
 */
public class DemoReactActivity extends MrReactActivity {

    public static final ReactInfo reactInfo = new ReactInfo("HelloWorld", null);

    @Override
    protected String getMainComponentName() {
        return reactInfo.getMainComponentName();
    }

    @Override
    public ReactInfo getReactInfo() {
        return reactInfo;
    }
}
