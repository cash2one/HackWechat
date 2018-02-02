package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask;

class JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask$1 implements Creator<SetBackgroundAudioStateTask> {
    JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SetBackgroundAudioStateTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SetBackgroundAudioStateTask[i];
    }
}
