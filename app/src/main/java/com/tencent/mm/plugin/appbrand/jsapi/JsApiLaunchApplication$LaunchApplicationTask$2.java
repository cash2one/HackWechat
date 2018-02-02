package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask;

class JsApiLaunchApplication$LaunchApplicationTask$2 implements Creator<LaunchApplicationTask> {
    JsApiLaunchApplication$LaunchApplicationTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LaunchApplicationTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LaunchApplicationTask[i];
    }
}
