package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.bq.b;
import com.tencent.mm.protocal.c.nc;

public final class AppRuntimeApiPermissionBundle implements Parcelable {
    public static final Creator<AppRuntimeApiPermissionBundle> CREATOR = new 1();
    final byte[] jGC;
    final byte[] jGD;
    final byte[] jGE;

    public AppRuntimeApiPermissionBundle(nc ncVar) {
        this.jGC = ncVar.vVV.toByteArray();
        this.jGD = ((b) ncVar.vVW.get(0)).toByteArray();
        this.jGE = ((b) ncVar.vVW.get(1)).toByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.jGC);
        parcel.writeByteArray(this.jGD);
        parcel.writeByteArray(this.jGE);
    }

    private AppRuntimeApiPermissionBundle(Parcel parcel) {
        this.jGC = parcel.createByteArray();
        this.jGD = parcel.createByteArray();
        this.jGE = parcel.createByteArray();
    }
}
