package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;

class JsApiOperateMusicPlayer$OperateMusicPlayer$7 implements Creator<OperateMusicPlayer> {
    JsApiOperateMusicPlayer$OperateMusicPlayer$7() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OperateMusicPlayer(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OperateMusicPlayer[i];
    }
}
