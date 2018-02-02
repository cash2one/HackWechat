package com.tencent.mm.plugin.appbrand.app;

import android.support.annotation.Keep;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.n.b;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.plugin.appbrand.config.g.1;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.precondition.j;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.af;
import com.tencent.mm.z.ag;
import com.tencent.mm.z.p;
import java.util.LinkedList;
import java.util.List;

@Keep
public final class PluginAppBrand extends f implements c, com.tencent.mm.plugin.appbrand.a.c, ag {
    public static final String TAG = "MicroMsg.PluginAppBrand";

    static {
        k.b("appbrandcommon", PluginAppBrand.class.getClassLoader());
    }

    public final List<af> getDataTransferList() {
        List linkedList = new LinkedList();
        linkedList.add(new 1(new g()));
        return linkedList;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
    }

    final f getCore() {
        return (f) p.s(f.class);
    }

    public final void installed() {
        alias(com.tencent.mm.plugin.appbrand.a.c.class);
    }

    public final void dependency() {
        dependsOn(a.class);
        dependsOn(com.tencent.mm.plugin.appbrand.compat.a.e.class);
    }

    public final void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        x.d(TAG, "current process name = %s, isMainThread %b", new Object[]{((h) com.tencent.mm.kernel.g.Dg().CN()).gOs, Boolean.valueOf(com.tencent.mm.sdk.platformtools.ag.isMainThread())});
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.m.c.class, new d(new com.tencent.mm.plugin.appbrand.launching.af()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.e.class, new d(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.m.d.class, new d(new com.tencent.mm.plugin.appbrand.launching.a.f()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, gVar.DS() ? b.iIH : n.a.iIF);
        com.tencent.mm.plugin.appbrand.game.b.c.aaZ();
        if (gVar.DS()) {
            com.tencent.mm.plugin.ae.c.qsQ.a(new t());
            com.tencent.mm.kernel.g.a(a.class, new d(new a()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.modelappbrand.g.class, new d(new com.tencent.mm.plugin.appbrand.share.a.a()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new d(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.m.a.class, new d(new e()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.m.b.class, new d(new o()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.m.e.class, new d(new d()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.a.a.class, new d(new c()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new d(new g()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.m.f.class, new d(new com.tencent.mm.plugin.appbrand.appusage.t()));
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), new String[]{"//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//localwxalibrary"});
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[]{"//widget"});
            com.tencent.mm.kernel.g.Dk().a(new com.tencent.mm.kernel.api.g(this) {
                final /* synthetic */ PluginAppBrand iCV;

                {
                    this.iCV = r1;
                }

                public final void ul() {
                    ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).initialize();
                }

                public final void aG(boolean z) {
                    ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).shutdown();
                    ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).IW().exit();
                }
            });
            if (DebuggerShell.ach()) {
                com.tencent.mm.kernel.g.a(DebuggerShell.class, new DebuggerShell());
            }
            com.tencent.mm.plugin.appbrand.appcache.p.a(new i());
            return;
        }
        if (ac.cfy() || isAppBrandProcess()) {
            b.YY();
            com.tencent.mm.plugin.appbrand.report.a.f.ajV();
            com.tencent.mm.kernel.g.a(r.class, new d(new com.tencent.mm.plugin.appbrand.appusage.f()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new d(new com.tencent.mm.plugin.appbrand.widget.d()));
            j.cb(ac.getContext());
        }
        if (ac.cfy()) {
            com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
            aj.a(new aj.c(this) {
                final /* synthetic */ PluginAppBrand iCV;

                {
                    this.iCV = r1;
                }

                public final void a(String str, Throwable th) {
                    if (bh.ou(str).contains(".plugin.appbrand")) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(365, 3, 1, false);
                        KVCommCrossProcessReceiver.boi();
                    }
                }
            });
        } else if (isSupportProcess(gVar.gOs)) {
            com.tencent.mm.plugin.appbrand.dynamic.e.c.initialize();
            com.tencent.mm.plugin.appbrand.dynamic.e.c.a(new com.tencent.mm.plugin.appbrand.dynamic.e.c.a(this) {
                final /* synthetic */ PluginAppBrand iCV;

                {
                    this.iCV = r1;
                }

                public final void Za() {
                    com.tencent.mm.plugin.appbrand.dynamic.h.e.bR(ac.getContext());
                }
            });
            com.tencent.mm.v.g.initialize();
        }
    }

    public final String name() {
        return "plugin-appbrand";
    }

    private static boolean isAppBrandProcess() {
        try {
            return ((h) com.tencent.mm.kernel.g.Dg().CN()).gOs.startsWith(ac.getPackageName() + ":appbrand");
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isSupportProcess(String str) {
        try {
            return "com.tencent.mm:support".equals(str);
        } catch (Exception e) {
            return false;
        }
    }
}
