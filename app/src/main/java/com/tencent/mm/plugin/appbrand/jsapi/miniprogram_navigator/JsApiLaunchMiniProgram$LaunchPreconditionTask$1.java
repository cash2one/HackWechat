package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.LaunchPreconditionTask;

class JsApiLaunchMiniProgram$LaunchPreconditionTask$1 implements Creator<LaunchPreconditionTask> {
    JsApiLaunchMiniProgram$LaunchPreconditionTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LaunchPreconditionTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LaunchPreconditionTask[i];
    }
}
