package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPauseDownloadTask.PauseDownloadTask;

class JsApiPauseDownloadTask$PauseDownloadTask$1 implements Creator<PauseDownloadTask> {
    JsApiPauseDownloadTask$PauseDownloadTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PauseDownloadTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PauseDownloadTask[i];
    }
}
