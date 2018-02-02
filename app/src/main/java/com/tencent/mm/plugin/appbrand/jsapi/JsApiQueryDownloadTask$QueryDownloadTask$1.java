package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiQueryDownloadTask.QueryDownloadTask;

class JsApiQueryDownloadTask$QueryDownloadTask$1 implements Creator<QueryDownloadTask> {
    JsApiQueryDownloadTask$QueryDownloadTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new QueryDownloadTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new QueryDownloadTask[i];
    }
}
