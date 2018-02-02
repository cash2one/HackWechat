package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.OperateBackgroundAudioTask;

class JsApiOperateBackgroundAudio$OperateBackgroundAudioTask$1 implements Creator<OperateBackgroundAudioTask> {
    JsApiOperateBackgroundAudio$OperateBackgroundAudioTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OperateBackgroundAudioTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OperateBackgroundAudioTask[i];
    }
}
