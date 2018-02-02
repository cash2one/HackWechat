package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class JsApiSetStorageTask$1 implements Creator<JsApiSetStorageTask> {
    JsApiSetStorageTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.f(parcel);
        return jsApiSetStorageTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new JsApiSetStorageTask[i];
    }
}
