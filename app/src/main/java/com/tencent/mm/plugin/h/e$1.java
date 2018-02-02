package com.tencent.mm.plugin.h;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.ad.m;
import com.tencent.mm.ae.n;
import com.tencent.mm.ae.n.a;
import com.tencent.mm.booter.NotifyReceiver$NotifyService;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;

class e$1 implements a {
    final /* synthetic */ e kAy;

    e$1(e eVar) {
        this.kAy = eVar;
    }

    public final void a(n nVar, boolean z) {
        if (z && !nVar.foreground) {
            if (e.arw()) {
                MMAppMgr.cnc();
                x.appenderClose();
                BaseEvent.onSingalCrash(0);
                x.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
                if (com.tencent.mm.modelfriend.a.Nn()) {
                    x.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
                    return;
                }
                Context context = ac.getContext();
                context.stopService(new Intent(context, NotifyReceiver$NotifyService.class));
                m.j(new 1(this));
                return;
            }
            x.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
        }
    }

    public final void a(n nVar) {
    }
}
