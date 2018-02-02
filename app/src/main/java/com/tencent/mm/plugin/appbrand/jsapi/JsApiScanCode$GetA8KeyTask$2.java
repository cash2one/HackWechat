package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask;

class JsApiScanCode$GetA8KeyTask$2 implements Creator<GetA8KeyTask> {
    JsApiScanCode$GetA8KeyTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
        getA8KeyTask.f(parcel);
        return getA8KeyTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetA8KeyTask[i];
    }
}
