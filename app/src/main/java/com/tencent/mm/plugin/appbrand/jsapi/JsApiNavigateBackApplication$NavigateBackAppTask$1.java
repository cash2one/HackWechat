package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;

class JsApiNavigateBackApplication$NavigateBackAppTask$1 implements Creator<NavigateBackAppTask> {
    JsApiNavigateBackApplication$NavigateBackAppTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        NavigateBackAppTask navigateBackAppTask = new NavigateBackAppTask();
        navigateBackAppTask.f(parcel);
        return navigateBackAppTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new NavigateBackAppTask[i];
    }
}
