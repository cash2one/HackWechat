package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new d();
    final IBinder aMW;
    final Scope[] aMX;
    final int aNm;
    final Bundle aNn;
    final String aNo;
    final int mVersionCode;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.aNm = i2;
        this.aMW = iBinder;
        this.aMX = scopeArr;
        this.aNn = bundle;
        this.aNo = str;
    }

    public ValidateAccountRequest(p pVar, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, b.aJG, pVar == null ? null : pVar.asBinder(), scopeArr, null, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
