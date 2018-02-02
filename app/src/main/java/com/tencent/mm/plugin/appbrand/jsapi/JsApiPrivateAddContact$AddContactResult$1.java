package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult;

class JsApiPrivateAddContact$AddContactResult$1 implements Creator<AddContactResult> {
    JsApiPrivateAddContact$AddContactResult$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AddContactResult(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AddContactResult[i];
    }
}
