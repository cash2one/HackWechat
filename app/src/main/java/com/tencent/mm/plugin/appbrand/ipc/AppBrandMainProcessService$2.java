package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMainProcessService$2 extends c$a {
    final /* synthetic */ AppBrandMainProcessService jaQ;

    AppBrandMainProcessService$2(AppBrandMainProcessService appBrandMainProcessService) {
        this.jaQ = appBrandMainProcessService;
    }

    public final void s(Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        AppBrandMainProcessService.a(this.jaQ).send(obtain);
    }

    public final void t(Bundle bundle) {
        AppBrandMainProcessService.b(bundle, false).Yr();
    }

    public final void a(IBinder iBinder, String str) {
        DeathRecipient 1 = new 1(this, iBinder, str);
        try {
            iBinder.linkToDeath(1, 0);
            AppBrandMainProcessService.b(this.jaQ).put(str, 1);
            AppBrandMainProcessService.rW(str);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[]{e});
        }
    }
}
