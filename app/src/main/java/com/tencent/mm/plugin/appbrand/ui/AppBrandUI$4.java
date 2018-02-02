package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;

class AppBrandUI$4 implements OnClickListener {
    final /* synthetic */ AppBrandUI jMR;
    final /* synthetic */ AppBrandRemoteTaskController jMS;

    AppBrandUI$4(AppBrandUI appBrandUI, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        this.jMR = appBrandUI;
        this.jMS = appBrandRemoteTaskController;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.jMR.mController.xIM.finish();
        MainProcessTask mainProcessTask = this.jMS;
        mainProcessTask.jJF = a.jJP;
        mainProcessTask.jJG = 0;
        AppBrandMainProcessService.a(mainProcessTask);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        d.a(this.jMR.mController.xIM, ".ui.LauncherUI", intent);
    }
}
