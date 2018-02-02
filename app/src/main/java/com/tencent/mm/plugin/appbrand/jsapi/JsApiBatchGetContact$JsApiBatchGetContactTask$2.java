package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask;

class JsApiBatchGetContact$JsApiBatchGetContactTask$2 implements Creator<JsApiBatchGetContactTask> {
    JsApiBatchGetContact$JsApiBatchGetContactTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new JsApiBatchGetContactTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new JsApiBatchGetContactTask[i];
    }
}
