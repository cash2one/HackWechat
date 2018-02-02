package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateAudio.OperateAudioTask;

class JsApiOperateAudio$OperateAudioTask$1 implements Creator<OperateAudioTask> {
    JsApiOperateAudio$OperateAudioTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OperateAudioTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OperateAudioTask[i];
    }
}
