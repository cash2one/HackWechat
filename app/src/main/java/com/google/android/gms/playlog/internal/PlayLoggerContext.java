package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class PlayLoggerContext implements SafeParcelable {
    public static final b CREATOR = new b();
    public final String baA;
    public final String baB;
    public final boolean baC;
    public final String baD;
    public final boolean baE;
    public final int baF;
    public final int bay;
    public final int baz;
    public final String packageName;
    public final int versionCode;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.bay = i2;
        this.baz = i3;
        this.baA = str2;
        this.baB = str3;
        this.baC = z;
        this.baD = str4;
        this.baE = z2;
        this.baF = i4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.bay == playLoggerContext.bay && this.baz == playLoggerContext.baz && v.b(this.baD, playLoggerContext.baD) && v.b(this.baA, playLoggerContext.baA) && v.b(this.baB, playLoggerContext.baB) && this.baC == playLoggerContext.baC && this.baE == playLoggerContext.baE && this.baF == playLoggerContext.baF;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.bay), Integer.valueOf(this.baz), this.baD, this.baA, this.baB, Boolean.valueOf(this.baC), Boolean.valueOf(this.baE), Integer.valueOf(this.baF)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.bay).append(',');
        stringBuilder.append("logSource=").append(this.baz).append(',');
        stringBuilder.append("logSourceName=").append(this.baD).append(',');
        stringBuilder.append("uploadAccount=").append(this.baA).append(',');
        stringBuilder.append("loggingId=").append(this.baB).append(',');
        stringBuilder.append("logAndroidId=").append(this.baC).append(',');
        stringBuilder.append("isAnonymous=").append(this.baE).append(',');
        stringBuilder.append("qosTier=").append(this.baF);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
