package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;

public class SampleTask2 extends MainProcessTask {
    public static final Creator<SampleTask2> CREATOR = new 1();

    public final void Yr() {
        x.e("SampleTask2", "Run in Main Process");
    }
}
