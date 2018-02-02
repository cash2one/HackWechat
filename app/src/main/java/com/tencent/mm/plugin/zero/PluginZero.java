package com.tencent.mm.plugin.zero;

import android.os.Build.VERSION;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.cd.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import java.io.File;

public class PluginZero extends f implements d {
    private a vaC = new a();
    private b vaD = new b();
    private final com.tencent.mm.app.d vaE = new com.tencent.mm.app.d();
    public b vaF;
    public b vaG = new b();
    public a vaH = new a();

    public String toString() {
        return "plugin-zero";
    }

    public void installed() {
        alias(d.class);
    }

    public void dependency() {
        dependsOnRoot();
    }

    public void configure(final g gVar) {
        try {
            initSDRoot();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PluginZero", e, "what happened?", new Object[0]);
        }
        ac.Va(gVar.gOs);
        a.a("configure [%s], setup broken library handler...", new Object[]{this});
        k.setupBrokenLibraryHandler();
        setupVendingLog();
        if (gVar.DS()) {
            a.a("configure [%s], for process[%s]...", new Object[]{this, gVar.gOs});
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.d(this.vaC));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.d(this.vaD));
            a.a("configure [%s], make worker core...", new Object[]{this});
            com.tencent.mm.kernel.g Dk = com.tencent.mm.kernel.g.Dk();
            if (!Dk.gQN) {
                Dk.gQN = true;
                Dk.gQH = new e(c.Dt());
                Dk.gQI = new com.tencent.mm.kernel.a(c.Dt());
                Dk.gQJ = new com.tencent.mm.kernel.b(Dk.gQK, Dk.gPI);
            }
            com.tencent.mm.kernel.g.Dk().a(new com.tencent.mm.kernel.api.g(this) {
                final /* synthetic */ PluginZero vaI;

                public final void ul() {
                    a.a("onStartupDone", new Object[0]);
                }

                public final void aG(boolean z) {
                    if (z) {
                        com.tencent.mm.kernel.k.e(gVar.gSI, true);
                        com.tencent.mm.kernel.k.f(gVar.gSI, true);
                    }
                    x.cfk();
                }
            });
            com.tencent.mm.kernel.g.Dk();
            h.zJU = new com.tencent.mm.vending.h.h(com.tencent.mm.cd.d.c(com.tencent.mm.kernel.g.Dm().cfF()), "WeChat.WORKER");
            com.tencent.mm.vending.h.g.a("WeChat.WORKER", h.zJU);
            new com.tencent.mm.plugin.zero.tasks.a().before(this);
        }
        if (gVar.DS() || gVar.fR(":push")) {
            new LoadProtocolJNITask().before(this);
        }
        com.tencent.mm.kernel.b.h hVar = (com.tencent.mm.kernel.b.h) gVar;
        x.i("MicroMsg.PluginZero", "oldversion:%s, newversion:%s, gettime:%d, settime:%d", new Object[]{hVar.gSK.mOldVersionCode, hVar.gSK.mNewVersionCode, Long.valueOf(hVar.gSK.mGetRevTime), Long.valueOf(hVar.gSK.mSetRevTime)});
    }

    private void initSDRoot() {
        if (new File(w.gZK + "SdcardInfo.cfg").exists()) {
            String str;
            String str2 = com.tencent.mm.compatible.util.e.bnD;
            s sVar = new s(w.gZK + "SdcardInfo.cfg");
            String str3 = (String) sVar.get(1, "");
            int intValue = ((Integer) sVar.get(2, Integer.valueOf(0))).intValue();
            int i = VERSION.SDK_INT;
            if (bh.ov(str3)) {
                sVar.set(1, str2);
                sVar.set(2, Integer.valueOf(i));
                str = str2;
            } else {
                str = str3;
            }
            x.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[]{str3, str, str2, Integer.valueOf(intValue), Integer.valueOf(i)});
            com.tencent.mm.compatible.util.e.eK(str);
            if (intValue != i && !com.tencent.mm.compatible.util.f.ze()) {
                if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted") && new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    sVar.set(1, str2);
                    sVar.set(2, Integer.valueOf(i));
                    com.tencent.mm.compatible.util.e.eK(str2);
                    x.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[]{com.tencent.mm.compatible.util.e.bnD, Boolean.valueOf(com.tencent.mm.compatible.util.f.ze())});
                    return;
                }
                x.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[]{com.tencent.mm.compatible.util.e.bnD, Boolean.valueOf(com.tencent.mm.compatible.util.f.ze()), str2});
                return;
            }
            return;
        }
        com.tencent.mm.compatible.util.e.eK(com.tencent.mm.compatible.util.e.bnD);
        x.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[]{com.tencent.mm.compatible.util.e.bnD});
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            com.tencent.mm.kernel.g.Dk().gQK.aE(new 2(this, gVar));
            NotifyReceiver.wG();
        }
    }

    private void setupVendingLog() {
        com.tencent.mm.vending.f.a.a(new 3(this));
    }

    public void setILightPushDelegate(b bVar) {
        this.vaF = bVar;
    }

    public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c cVar) {
        x.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[]{this, cVar});
        return this.vaG.aE(cVar);
    }

    public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a aVar) {
        return this.vaH.aE(aVar);
    }
}
