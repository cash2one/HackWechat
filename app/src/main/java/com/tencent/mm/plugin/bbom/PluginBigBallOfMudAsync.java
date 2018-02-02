package com.tencent.mm.plugin.bbom;

import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.bbom.a.a;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.h.e;
import com.tencent.mm.plugin.welab.b.b;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.n;

public class PluginBigBallOfMudAsync extends f implements a {
    public String toString() {
        return "plugin-big-ball-of-mud-async";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(PluginBigBallOfMud.class);
        dependsOn(com.tencent.mm.plugin.notification.b.a.class);
    }

    public void configure(g gVar) {
        if (gVar.DS() && ((h) gVar).mProfileCompat != null) {
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile) ((h) gVar).mProfileCompat).getNotification());
        }
        r.a.voy = new 1(this);
        n.a.a(new 2(this));
        c.a.vup = new 3(this);
        com.tencent.mm.plugin.webview.ui.tools.widget.c.a.tKa = new 4(this);
        com.tencent.mm.plugin.webview.ui.tools.widget.a.a.tJZ = new 5(this);
        com.tencent.mm.kernel.g.a(q.class, new com.tencent.mm.pluginsdk.model.g());
        com.tencent.mm.kernel.g.a(m.class, new d());
        if (((h) gVar).mProfileCompat != null && gVar.DS()) {
            WorkerProfile workerProfile = (WorkerProfile) ((h) gVar).mProfileCompat;
            com.tencent.mm.pluginsdk.n nVar = workerProfile.fgx;
            com.tencent.mm.pluginsdk.m mVar = workerProfile.fgy;
            com.tencent.mm.bm.c.vzM = nVar;
            com.tencent.mm.bm.c.vzN = mVar;
            new e(workerProfile).before(this).after(com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class));
        }
        if (gVar.DS()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).setIDataTransferFactoryDelegate(new 6(this));
        }
    }

    public void execute(g gVar) {
        if (((h) gVar).mProfileCompat != null && gVar.DS()) {
            x.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
            ((h) gVar).mProfileCompat.onCreate();
        }
        if (gVar.DS()) {
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new b());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.d.a());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.b.a());
        }
    }
}
