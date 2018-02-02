package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult;

final class JsApiPrivateAddContact$AddContactResult extends AppBrandProxyUIProcessTask$ProcessResult {
    public static final Creator<JsApiPrivateAddContact$AddContactResult> CREATOR = new 1();
    private int bjW;

    JsApiPrivateAddContact$AddContactResult() {
    }

    JsApiPrivateAddContact$AddContactResult(Parcel parcel) {
        h(parcel);
    }

    protected final void h(Parcel parcel) {
        this.bjW = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bjW);
    }
}
