package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessRequest;

final class JsApiOpenDocument$OpenRequest extends AppBrandProxyUIProcessTask$ProcessRequest {
    public static final Creator<JsApiOpenDocument$OpenRequest> CREATOR = new 1();
    public String filePath;
    public String iHF;

    protected final Class<? extends AppBrandProxyUIProcessTask> afn() {
        return JsApiOpenDocument$a.class;
    }

    protected final String afm() {
        return "QbDocumentReader";
    }

    protected final void h(Parcel parcel) {
        super.h(parcel);
        this.filePath = parcel.readString();
        this.iHF = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.filePath);
        parcel.writeString(this.iHF);
    }

    JsApiOpenDocument$OpenRequest() {
    }

    JsApiOpenDocument$OpenRequest(Parcel parcel) {
        super(parcel);
    }
}
