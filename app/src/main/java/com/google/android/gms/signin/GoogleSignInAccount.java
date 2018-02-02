package com.google.android.gms.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new a();
    String aEO;
    String aIS;
    String baG;
    String baH;
    Uri baI;
    final int versionCode;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri) {
        this.versionCode = i;
        this.aEO = w.aM(str);
        this.aIS = str2;
        this.baG = str3;
        this.baH = str4;
        this.baI = uri;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
