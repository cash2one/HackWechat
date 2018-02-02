package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactRequest;

class JsApiPrivateAddContact$AddContactRequest$1 implements Creator<AddContactRequest> {
    JsApiPrivateAddContact$AddContactRequest$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AddContactRequest(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AddContactRequest[i];
    }
}
