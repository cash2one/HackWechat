package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new 1();
    private final long aQJ;
    private final long aQK;

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.aQJ = parcel.readLong();
        this.aQK = parcel.readLong();
    }

    public String toString() {
        return super.toString() + " windowStart=" + this.aQJ + " windowEnd=" + this.aQK;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.aQJ);
        parcel.writeLong(this.aQK);
    }
}
