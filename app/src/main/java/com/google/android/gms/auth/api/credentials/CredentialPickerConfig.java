package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new b();
    final boolean aIM;
    final boolean aIN;
    final int mVersionCode;

    CredentialPickerConfig(int i, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.aIM = z;
        this.aIN = z2;
    }

    private CredentialPickerConfig(a aVar) {
        this(1, aVar.aIM, aVar.aIN);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
