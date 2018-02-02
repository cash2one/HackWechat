package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask;

class JsApiOperateWXData$OperateWXDataTask$3 implements Creator<OperateWXDataTask> {
    JsApiOperateWXData$OperateWXDataTask$3() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OperateWXDataTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OperateWXDataTask[i];
    }
}
