package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new s();
    public byte[] bdg;
    public String bdh;
    public ParcelFileDescriptor bdi;
    final int mVersionCode;
    public Uri uri;

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.mVersionCode = i;
        this.bdg = bArr;
        this.bdh = str;
        this.bdi = parcelFileDescriptor;
        this.uri = uri;
    }

    public static Asset a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(1, null, null, parcelFileDescriptor, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset bj(String str) {
        if (str != null) {
            return new Asset(1, null, str, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset n(byte[] bArr) {
        if (bArr != null) {
            return new Asset(1, bArr, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return v.b(this.bdg, asset.bdg) && v.b(this.bdh, asset.bdh) && v.b(this.bdi, asset.bdi) && v.b(this.uri, asset.uri);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.bdg, this.bdh, this.bdi, this.uri});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.bdh == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.bdh);
        }
        if (this.bdg != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.bdg.length);
        }
        if (this.bdi != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.bdi);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        s.a(this, parcel, i | 1);
    }
}
