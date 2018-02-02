package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class JsapiPermissionWrapper$1 implements Creator<JsapiPermissionWrapper> {
    JsapiPermissionWrapper$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new JsapiPermissionWrapper(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new JsapiPermissionWrapper[i];
    }
}
