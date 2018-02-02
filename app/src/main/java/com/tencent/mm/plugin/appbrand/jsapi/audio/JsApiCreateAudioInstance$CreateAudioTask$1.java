package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance.CreateAudioTask;

class JsApiCreateAudioInstance$CreateAudioTask$1 implements Creator<CreateAudioTask> {
    JsApiCreateAudioInstance$CreateAudioTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CreateAudioTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CreateAudioTask[i];
    }
}
