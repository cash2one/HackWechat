package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.w.a;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new ab();
    public final w bdU;
    public final IntentFilter[] bdV;
    public final String bdW;
    public final String bdX;
    final int mVersionCode;

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.bdU = a.s(iBinder);
        } else {
            this.bdU = null;
        }
        this.bdV = intentFilterArr;
        this.bdW = str;
        this.bdX = str2;
    }

    public AddListenerRequest(ap apVar) {
        this.mVersionCode = 1;
        this.bdU = apVar;
        this.bdV = apVar.bfq;
        this.bdW = apVar.bfr;
        this.bdX = apVar.bfs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ab.a(this, parcel, i);
    }
}
