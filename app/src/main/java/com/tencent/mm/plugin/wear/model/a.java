package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.c;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.wear.model.e.e;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.g;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g.b;
import com.tencent.mm.pluginsdk.q.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public final class a implements ap {
    q thF;
    public r thG;
    public d thH;
    private e thI;
    public g thJ;
    public b thK;
    private WearMessageLogic thL;
    private i thM;
    public j thN;
    public com.tencent.mm.plugin.wear.model.g.a thO;
    private d thP;

    public a() {
        x.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[]{getClass().getClassLoader()});
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public static a bOt() {
        ar.Ha();
        a aVar = (a) bp.hY("plugin.wear");
        if (aVar != null) {
            return aVar;
        }
        Object aVar2 = new a();
        ar.Ha().a("plugin.wear", aVar2);
        return aVar2;
    }

    public final void gd(int i) {
        x.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[]{Integer.valueOf(i)});
    }

    public final void bq(boolean z) {
        aa.vcE = new c();
        x.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[]{Boolean.valueOf(z)});
        this.thF = new q();
        this.thG = new r();
        this.thN = new j();
        this.thI = new e();
        this.thJ = new g();
        this.thK = new b();
        this.thH = new d();
        this.thL = new WearMessageLogic();
        this.thM = new i();
        this.thO = new com.tencent.mm.plugin.wear.model.g.a();
        this.thP = new b();
        c.a(Integer.valueOf(63), this.thP);
        this.thF.a(this.thH.thX);
        this.thF.a(this.thH.thY);
        this.thF.a(this.thH.thZ);
        this.thF.a(new com.tencent.mm.plugin.wear.model.e.h());
        this.thF.a(new g());
        this.thF.a(new com.tencent.mm.plugin.wear.model.e.d());
        this.thF.a(new com.tencent.mm.plugin.wear.model.e.c());
        this.thF.a(new e());
        this.thF.a(new f());
        this.thF.a(new k());
        this.thF.a(new m());
        this.thF.a(new o());
        this.thF.a(new n());
        this.thF.a(new l());
        this.thN.a(new 1(this));
        j jVar = this.thN;
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.wear.model.f.c(this) {
            final /* synthetic */ a thQ;

            {
                this.thQ = r1;
            }

            protected final void send() {
                if (this.thQ.thH.bOz() != null) {
                    this.thQ.thH.bOz().bOF();
                }
                r.a(20009, null, false);
                r.a(20017, null, false);
            }

            public final String getName() {
                return "SyncFileTask";
            }
        };
        if (jVar.jzN != null) {
            jVar.jzN.sendMessageDelayed(jVar.jzN.obtainMessage(0, anonymousClass2), 5000);
        }
    }

    public final void br(boolean z) {
        x.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[]{Boolean.valueOf(z)});
    }

    public final void onAccountRelease() {
        c.b(Integer.valueOf(63), this.thP);
        this.thP = null;
        x.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.thF.tjb.clear();
        this.thF = null;
        this.thG = null;
        e eVar = this.thI;
        eVar.ikI.TG();
        eVar.rIj.dead();
        eVar.tie.dead();
        eVar.tif.dead();
        eVar.tig.dead();
        eVar.tih.dead();
        eVar.tii.dead();
        eVar.tij.dead();
        eVar.gzG.dead();
        eVar.odL.dead();
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(eVar.lZv);
        this.thI = null;
        this.thJ = null;
        b bVar = this.thK;
        com.tencent.mm.sdk.b.a.xef.c(bVar.thS);
        ar.Hg();
        com.tencent.mm.z.c.EY().b(bVar.mMK);
        bVar.thT.TG();
        this.thK = null;
        d dVar = this.thH;
        dVar.thW.finish();
        dVar.tia.reset();
        this.thH = null;
        ac.getContext().unregisterReceiver(this.thL);
        this.thL = null;
        j jVar = this.thN;
        if (jVar.handlerThread != null) {
            jVar.handlerThread.quit();
        }
        this.thN = null;
        i iVar = this.thM;
        iVar.gCe = null;
        iVar.bOA();
        ac.getContext().unregisterReceiver(iVar.tiC);
        this.thM = null;
    }
}
