package com.tencent.mm.plugin.appbrand.ui;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;

class AppBrandUI$6 implements Runnable {
    final /* synthetic */ AppBrandUI jMR;
    final /* synthetic */ Runnable jMT;

    AppBrandUI$6(AppBrandUI appBrandUI, Runnable runnable) {
        this.jMR = appBrandUI;
        this.jMT = runnable;
    }

    public final void run() {
        this.jMT.run();
        x.i("MicroMsg.AppBrandUI", "tryRestartProcess, %s", u.GK().toString());
        x.cfl();
        if (((Boolean) new 1(this).b(new af(Looper.getMainLooper()))).booleanValue()) {
            MainProcessTask appBrandUI$ProcessRestartTask = new AppBrandUI$ProcessRestartTask();
            appBrandUI$ProcessRestartTask.gOs = ac.Br();
            appBrandUI$ProcessRestartTask.jJE = this.jMR.getClass().getName();
            AppBrandMainProcessService.b(appBrandUI$ProcessRestartTask);
            System.exit(0);
        }
    }
}
