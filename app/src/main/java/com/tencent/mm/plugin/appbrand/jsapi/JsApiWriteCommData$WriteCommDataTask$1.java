package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData.WriteCommDataTask;

class JsApiWriteCommData$WriteCommDataTask$1 implements Creator<WriteCommDataTask> {
    JsApiWriteCommData$WriteCommDataTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WriteCommDataTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WriteCommDataTask[i];
    }
}
