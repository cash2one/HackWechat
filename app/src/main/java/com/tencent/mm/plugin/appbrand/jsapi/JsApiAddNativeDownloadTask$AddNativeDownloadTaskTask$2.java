package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask;

class JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$2 implements Creator<AddNativeDownloadTaskTask> {
    JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AddNativeDownloadTaskTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
        addNativeDownloadTaskTask.f(parcel);
        return addNativeDownloadTaskTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AddNativeDownloadTaskTask[i];
    }
}
