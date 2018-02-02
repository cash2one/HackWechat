package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask.ResumeDownloadTask;

class JsApiResumeDownloadTask$ResumeDownloadTask$1 implements Creator<ResumeDownloadTask> {
    JsApiResumeDownloadTask$ResumeDownloadTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ResumeDownloadTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ResumeDownloadTask[i];
    }
}
