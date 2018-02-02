package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;

public class SampleTask1 extends MainProcessTask {
    public static final Creator<SampleTask1> CREATOR = new 1();
    public String jbD;
    public String jbE;

    public SampleTask1(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.e("SampleTask", this.jbD);
        this.jbE = "String from Main Process";
        afp();
    }

    public final void Ys() {
        x.e("SampleTask", this.jbE);
    }

    public final void f(Parcel parcel) {
        this.jbD = parcel.readString();
        this.jbE = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jbD);
        parcel.writeString(this.jbE);
    }
}
