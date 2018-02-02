package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ag;

class JsApiPausePlayVoice$PausePlayVoice extends MainProcessTask {
    public static final Creator<JsApiPausePlayVoice$PausePlayVoice> CREATOR = new Creator<JsApiPausePlayVoice$PausePlayVoice>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiPausePlayVoice$PausePlayVoice jsApiPausePlayVoice$PausePlayVoice = new JsApiPausePlayVoice$PausePlayVoice();
            jsApiPausePlayVoice$PausePlayVoice.f(parcel);
            return jsApiPausePlayVoice$PausePlayVoice;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiPausePlayVoice$PausePlayVoice[i];
        }
    };

    private JsApiPausePlayVoice$PausePlayVoice() {
    }

    public final void Yr() {
        ag.y(new 1(this));
    }
}
