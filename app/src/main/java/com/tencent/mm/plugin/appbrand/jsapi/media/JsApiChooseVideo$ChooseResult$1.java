package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult;

class JsApiChooseVideo$ChooseResult$1 implements Creator<ChooseResult> {
    JsApiChooseVideo$ChooseResult$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ChooseResult(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ChooseResult[i];
    }
}
