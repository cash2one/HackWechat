package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new v();
    private static final Random bds = new SecureRandom();
    public final Uri aMK;
    public byte[] bdg;
    final Bundle bdt;
    final int mVersionCode;

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.mVersionCode = i;
        this.aMK = uri;
        this.bdt = bundle;
        this.bdt.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.bdg = bArr;
    }

    private PutDataRequest(Uri uri) {
        this(1, uri, new Bundle(), null);
    }

    public static PutDataRequest bl(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return f(new Builder().scheme("wear").path(str).build());
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest f(Uri uri) {
        return new PutDataRequest(uri);
    }

    public final PutDataRequest b(String str, Asset asset) {
        w.ag(str);
        w.ag(asset);
        this.bdt.putParcelable(str, asset);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public final Map<String, Asset> rq() {
        Map hashMap = new HashMap();
        for (String str : this.bdt.keySet()) {
            hashMap.put(str, (Asset) this.bdt.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String toString() {
        boolean isLoggable = Log.isLoggable("DataMap", 3);
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        stringBuilder.append("dataSz=" + (this.bdg == null ? "null" : Integer.valueOf(this.bdg.length)));
        stringBuilder.append(", numAssets=" + this.bdt.size());
        stringBuilder.append(", uri=" + this.aMK);
        if (isLoggable) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.bdt.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.bdt.getParcelable(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        v.a(this, parcel, i);
    }
}
