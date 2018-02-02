package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState.GetMusicPlayerState;

class JsApiGetMusicPlayerState$GetMusicPlayerState$1 implements Creator<GetMusicPlayerState> {
    JsApiGetMusicPlayerState$GetMusicPlayerState$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetMusicPlayerState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetMusicPlayerState[i];
    }
}
