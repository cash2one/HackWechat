package com.tencent.mm.plugin.appbrand;

import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class AppBrandMainProcessPrepareTask extends MainProcessTask {
    public static final Creator<AppBrandMainProcessPrepareTask> CREATOR = new 1();
    private Runnable iqr;

    AppBrandMainProcessPrepareTask(Runnable runnable) {
        this.iqr = runnable;
        afi();
    }

    public final void Yr() {
        afp();
    }

    public final void Ys() {
        this.iqr.run();
        afj();
    }
}
