package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class JsApiGetStorageInfoTask$1 implements Creator<JsApiGetStorageInfoTask> {
    JsApiGetStorageInfoTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.f(parcel);
        return jsApiGetStorageInfoTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new JsApiGetStorageInfoTask[i];
    }
}
