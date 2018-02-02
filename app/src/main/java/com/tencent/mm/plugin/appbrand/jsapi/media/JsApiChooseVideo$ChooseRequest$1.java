package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseRequest;

class JsApiChooseVideo$ChooseRequest$1 implements Creator<ChooseRequest> {
    JsApiChooseVideo$ChooseRequest$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ChooseRequest(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ChooseRequest[i];
    }
}
