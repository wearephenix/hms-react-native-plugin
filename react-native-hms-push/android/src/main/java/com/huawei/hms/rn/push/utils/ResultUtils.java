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

package com.huawei.hms.rn.push.utils;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

import com.huawei.hms.rn.push.constants.Core;
import com.huawei.hms.rn.push.constants.ResultCode;

public class ResultUtils {

    private ResultUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void handleResult(boolean isSuccess, Object result, Promise promise) {
        handleResult(isSuccess, result, promise, ResultCode.SUCCESS);
    }

    public static void handleResult(boolean isSuccess, Object result, Promise promise, String resultCode) {

        WritableMap wm = new WritableNativeMap();
        MapUtils.put(wm, Core.Event.Result.RESULT_CODE, resultCode);
        MapUtils.put(wm, Core.Event.Result.RESULT, result);

        if (isSuccess) {
            promise.resolve(wm);
        } else {
            promise.reject(ResultCode.RESULT_FAILURE, (String) result);
        }
    }
}
