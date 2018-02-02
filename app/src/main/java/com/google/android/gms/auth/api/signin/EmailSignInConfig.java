package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public class EmailSignInConfig implements SafeParcelable {
    public static final Creator<EmailSignInConfig> CREATOR = new a();
    final Uri aJs;
    String aJt;
    Uri aJu;
    final int versionCode;

    EmailSignInConfig(int i, Uri uri, String str, Uri uri2) {
        w.i(uri, "Server widget url cannot be null in order to use email/password sign in.");
        w.h(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        w.e(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.versionCode = i;
        this.aJs = uri;
        this.aJt = str;
        this.aJu = uri2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
