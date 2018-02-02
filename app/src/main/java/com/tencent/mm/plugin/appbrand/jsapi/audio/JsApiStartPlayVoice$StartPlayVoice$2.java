package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice;

class JsApiStartPlayVoice$StartPlayVoice$2 implements Creator<StartPlayVoice> {
    JsApiStartPlayVoice$StartPlayVoice$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new StartPlayVoice(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new StartPlayVoice[i];
    }
}
