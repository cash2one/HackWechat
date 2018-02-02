package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetInstallState.GetInstallStateTask;

class JsApiGetInstallState$GetInstallStateTask$1 implements Creator<GetInstallStateTask> {
    JsApiGetInstallState$GetInstallStateTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetInstallStateTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetInstallStateTask[i];
    }
}
