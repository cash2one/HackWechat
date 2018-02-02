package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task implements Parcelable {
    private final String aQN;
    private final boolean aQO;
    private final boolean aQP;
    private final int aQQ;
    private final boolean aQR;
    private final Bundle mExtras;
    private final String mTag;

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        this.aQN = parcel.readString();
        this.mTag = parcel.readString();
        this.aQO = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.aQP = z;
        this.aQQ = 2;
        this.aQR = false;
        this.mExtras = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.aQN);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.aQO ? 1 : 0);
        if (!this.aQP) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
