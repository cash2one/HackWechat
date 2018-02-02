package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class JsApiRemoveStorageTask$1 implements Creator<JsApiRemoveStorageTask> {
    JsApiRemoveStorageTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.f(parcel);
        return jsApiRemoveStorageTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new JsApiRemoveStorageTask[i];
    }
}
