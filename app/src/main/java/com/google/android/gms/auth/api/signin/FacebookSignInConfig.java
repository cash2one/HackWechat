package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public class FacebookSignInConfig implements SafeParcelable {
    public static final Creator<FacebookSignInConfig> CREATOR = new b();
    Intent Ks;
    final ArrayList<String> aJv;
    final int versionCode;

    public FacebookSignInConfig() {
        this(1, null, new ArrayList());
    }

    FacebookSignInConfig(int i, Intent intent, ArrayList<String> arrayList) {
        this.versionCode = i;
        this.Ks = intent;
        this.aJv = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
