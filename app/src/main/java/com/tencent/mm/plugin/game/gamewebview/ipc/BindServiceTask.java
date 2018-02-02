package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BindServiceTask extends GWMainProcessTask {
    public static final Creator<BindServiceTask> CREATOR = new 1();
    public Runnable jcI;

    public final void Yr() {
        afp();
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public final void f(Parcel parcel) {
    }

    public BindServiceTask(Parcel parcel) {
    }
}
