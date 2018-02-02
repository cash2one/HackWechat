package com.tencent.mm.plugin.appbrand.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMainProcessService$4 implements ServiceConnection {
    AppBrandMainProcessService$4() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppBrandMainProcessService.a(c$a.G(iBinder));
        AppBrandMainProcessService.afc();
        AppBrandMainProcessService.rW(ac.getPackageName());
        try {
            AppBrandMainProcessService.afd().a(new Binder(), ac.Br());
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[]{e});
        }
        x.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[]{ac.Br()});
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppBrandMainProcessService.a(null);
        AppBrandMainProcessService.pK(ac.getPackageName());
        AppBrandMainProcessService.afb();
        x.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[]{ac.Br()});
    }
}
