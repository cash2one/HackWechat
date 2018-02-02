package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.a;

final class JsApiPrivateAddContact$AddContactRequest extends ProcessRequest {
    public static final Creator<JsApiPrivateAddContact$AddContactRequest> CREATOR = new 1();
    int jdL;
    int scene;
    String userName;

    JsApiPrivateAddContact$AddContactRequest() {
    }

    JsApiPrivateAddContact$AddContactRequest(Parcel parcel) {
        h(parcel);
    }

    protected final Class<? extends AppBrandProxyUIProcessTask> afn() {
        return a.class;
    }

    public final void h(Parcel parcel) {
        this.userName = parcel.readString();
        this.scene = parcel.readInt();
        this.jdL = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userName);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.jdL);
    }
}
