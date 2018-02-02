package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenRequest;

class JsApiOpenDocument$OpenRequest$1 implements Creator<OpenRequest> {
    JsApiOpenDocument$OpenRequest$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OpenRequest(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OpenRequest[i];
    }
}
