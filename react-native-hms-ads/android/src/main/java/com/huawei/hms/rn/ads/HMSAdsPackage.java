/*
    Copyright 2020-2022. Huawei Technologies Co., Ltd. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License")
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.huawei.hms.rn.ads;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

public class HMSAdsPackage implements ReactPackage {
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        return Arrays.asList(
                new HMSAdsModule(reactContext),
                new HMSAdsInstallReferrerModule(reactContext),
                new HMSAdsOaidModule(reactContext),
                new HMSAdsInterstitialAdModule(reactContext),
                new HMSAdsSplashAdModule(reactContext),
                new HMSAdsRewardAdModule(reactContext),
                new HMSAdsVastModule(reactContext));
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        return Arrays.asList(
                new HMSAdsBannerView.Manager(reactContext),
                new HMSAdsInstreamView.Manager(reactContext),
                new HMSAdsNativeView.Manager(reactContext),
                new HMSAdsVastView.Manager(reactContext));
    }
}
