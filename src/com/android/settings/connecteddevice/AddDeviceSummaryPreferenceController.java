/*
 * Copyright (C) 2021 The Android Open Source Project
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
package com.android.settings.connecteddevice;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Controller to maintain the {@link androidx.preference.Preference} for add
 * device with summary at beginning. It monitor Bluetooth's status(on/off) and decide if need
 * to show summary or not.
 */
public class AddDeviceSummaryPreferenceController extends AddDevicePreferenceController {

    public AddDeviceSummaryPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return mContext.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)
                && !isBluetoothEnabled()
                ? AVAILABLE
                : UNSUPPORTED_ON_DEVICE;
    }
}