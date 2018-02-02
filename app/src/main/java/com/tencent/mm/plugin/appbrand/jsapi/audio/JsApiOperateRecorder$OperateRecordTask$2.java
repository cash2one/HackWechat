package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateRecorder.OperateRecordTask;

class JsApiOperateRecorder$OperateRecordTask$2 implements Creator<OperateRecordTask> {
    JsApiOperateRecorder$OperateRecordTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OperateRecordTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OperateRecordTask[i];
    }
}
