package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenResult;

class JsApiOpenDocument$OpenResult$1 implements Creator<OpenResult> {
    JsApiOpenDocument$OpenResult$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OpenResult(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OpenResult[i];
    }
}
