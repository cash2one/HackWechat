package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new 1();
    private IBinder aMY;

    public BinderWrapper() {
        this.aMY = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.aMY = null;
        this.aMY = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.aMY = null;
        this.aMY = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.aMY);
    }
}
