# react-native-preloader

React Native Pre-loader for Android.

During development of React Native on Android hybrid app, we can find that even in a release package with js bundle in assets, the first startup of the entry React Native Activity can still cost over 1 second, which severely effects user experience. What's more, if we exit the React Activity, and enter again, it still costs that much time. Holy shit!

This library is to solve the problem, and let you load the React Native Activity in milliseconds, painlessly.

Support React Native versions:
- 0.30
- 0.31
- 0.32

May also run on other versions, but I have not checked that.

![screenshot](screenshot.gif "screenshot")

# Run demo

In order to run demo, your should have react-native installed, then

```bash
# install dependencies according to package.json
npm install

# package js files into bundle, which will be under assets directory.
sh package.sh
```

# Usage

```groovy
dependencies {
    compile "com.github.moduth:react-native-preloader:0.31.0"
}
```

In the activity which you want to pre-load ReactActivity:

```java
ReactPreLoader.init(this, DemoReactActivity.reactInfo);
```

Make your ReactActivity extends the one in the library:

```java
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
```

# How it works

See `ReactPreLoader` and `MrReactActivity`'s `onCreate`.

# License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
