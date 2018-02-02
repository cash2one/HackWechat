package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new b();
    final Uri aMP;
    final int aMQ;
    final int aMR;
    final int mVersionCode;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.aMP = uri;
        this.aMQ = i2;
        this.aMR = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return v.b(this.aMP, webImage.aMP) && this.aMQ == webImage.aMQ && this.aMR == webImage.aMR;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.aMP, Integer.valueOf(this.aMQ), Integer.valueOf(this.aMR)});
    }

    public final String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.aMQ), Integer.valueOf(this.aMR), this.aMP.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
