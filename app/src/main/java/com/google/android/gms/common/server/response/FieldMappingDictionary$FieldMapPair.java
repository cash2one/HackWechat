package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class FieldMappingDictionary$FieldMapPair implements SafeParcelable {
    public static final b CREATOR = new b();
    final String aAM;
    final Field<?, ?> aPk;
    final int versionCode;

    FieldMappingDictionary$FieldMapPair(int i, String str, Field<?, ?> field) {
        this.versionCode = i;
        this.aAM = str;
        this.aPk = field;
    }

    FieldMappingDictionary$FieldMapPair(String str, Field<?, ?> field) {
        this.versionCode = 1;
        this.aAM = str;
        this.aPk = field;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
