package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState.AudioPlayerEventListenerTask;

class JsApiSetAudioState$AudioPlayerEventListenerTask$1 implements Creator<AudioPlayerEventListenerTask> {
    JsApiSetAudioState$AudioPlayerEventListenerTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AudioPlayerEventListenerTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AudioPlayerEventListenerTask[i];
    }
}
