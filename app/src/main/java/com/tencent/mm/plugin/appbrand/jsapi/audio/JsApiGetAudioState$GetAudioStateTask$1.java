package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState.GetAudioStateTask;

class JsApiGetAudioState$GetAudioStateTask$1 implements Creator<GetAudioStateTask> {
    JsApiGetAudioState$GetAudioStateTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetAudioStateTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetAudioStateTask[i];
    }
}
