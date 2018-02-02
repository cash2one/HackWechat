package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask;

class JsApiAuthorize$AuthorizeTask$3 implements Creator<AuthorizeTask> {
    JsApiAuthorize$AuthorizeTask$3() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AuthorizeTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AuthorizeTask[i];
    }
}
