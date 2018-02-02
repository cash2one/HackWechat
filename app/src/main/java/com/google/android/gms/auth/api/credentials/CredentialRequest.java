package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new c();
    final boolean aIO;
    final String[] aIP;
    final CredentialPickerConfig aIQ;
    final CredentialPickerConfig aIR;
    final int mVersionCode;

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.mVersionCode = i;
        this.aIO = z;
        this.aIP = (String[]) w.ag(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new a().nM();
        }
        this.aIQ = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new a().nM();
        }
        this.aIR = credentialPickerConfig2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
