package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken implements SafeParcelable {
    public static final Creator<IdToken> CREATOR = new d();
    final String aIJ;
    final String aIS;
    final int mVersionCode;

    IdToken(int i, String str, String str2) {
        this.mVersionCode = i;
        this.aIJ = str;
        this.aIS = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel);
    }
}
