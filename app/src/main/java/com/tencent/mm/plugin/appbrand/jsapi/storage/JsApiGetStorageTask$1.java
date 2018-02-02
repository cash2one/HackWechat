package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class JsApiGetStorageTask$1 implements Creator<JsApiGetStorageTask> {
    JsApiGetStorageTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.f(parcel);
        return jsApiGetStorageTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new JsApiGetStorageTask[i];
    }
}
