package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice;

class JsApiStartRecordVoice$StartRecordVoice$2 implements Creator<StartRecordVoice> {
    JsApiStartRecordVoice$StartRecordVoice$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new StartRecordVoice(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new StartRecordVoice[i];
    }
}
