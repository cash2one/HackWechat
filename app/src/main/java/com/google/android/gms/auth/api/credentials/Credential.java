package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR = new a();
    final String aEO;
    final String aIE;
    final String aIF;
    final Uri aIG;
    final List<IdToken> aIH;
    final String aII;
    final String aIJ;
    final String aIK;
    final String aIL;
    final String mName;
    final int mVersionCode;

    Credential(int i, String str, String str2, String str3, String str4, Uri uri, List<IdToken> list, String str5, String str6, String str7, String str8) {
        this.mVersionCode = i;
        this.aIE = str;
        this.aIF = str2;
        this.aEO = (String) w.ag(str3);
        this.mName = str4;
        this.aIG = uri;
        this.aIH = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.aII = str5;
        this.aIJ = str6;
        this.aIK = str7;
        this.aIL = str8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.aEO, credential.aEO) && TextUtils.equals(this.mName, credential.mName) && v.b(this.aIG, credential.aIG) && TextUtils.equals(this.aII, credential.aII) && TextUtils.equals(this.aIJ, credential.aIJ) && TextUtils.equals(this.aIK, credential.aIK);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.aEO, this.mName, this.aIG, this.aII, this.aIJ, this.aIK});
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
