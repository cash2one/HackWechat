package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiOpenDocument$OpenResult extends ProcessResult {
    public static final Creator<JsApiOpenDocument$OpenResult> CREATOR = new 1();
    public int ret;

    protected final void h(Parcel parcel) {
        this.ret = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ret);
    }

    JsApiOpenDocument$OpenResult() {
    }

    JsApiOpenDocument$OpenResult(Parcel parcel) {
        super(parcel);
    }
}
