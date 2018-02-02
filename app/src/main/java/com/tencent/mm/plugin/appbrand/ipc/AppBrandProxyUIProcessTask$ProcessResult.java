package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AppBrandProxyUIProcessTask$ProcessResult implements Parcelable {
    public abstract void h(Parcel parcel);

    public AppBrandProxyUIProcessTask$ProcessResult(Parcel parcel) {
        h(parcel);
    }
}
