package com.tencent.mm.plugin.appbrand.collector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TimePoint implements Parcelable {
    public static final Creator<TimePoint> CREATOR = new 1();
    final AtomicInteger iLR;
    final AtomicLong iLS;
    final AtomicReference<TimePoint> iLT;
    String name;

    TimePoint() {
        this.iLR = new AtomicInteger();
        this.iLS = new AtomicLong();
        this.iLT = new AtomicReference();
        this.name = "";
    }

    public TimePoint(String str, long j) {
        this.iLR = new AtomicInteger();
        this.iLS = new AtomicLong();
        this.iLT = new AtomicReference();
        this.name = str;
        this.iLS.set(j);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.iLS.get());
        parcel.writeInt(this.iLR.get());
        parcel.writeParcelable((Parcelable) this.iLT.get(), i);
    }
}
