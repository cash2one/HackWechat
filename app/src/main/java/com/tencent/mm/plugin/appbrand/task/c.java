package com.tencent.mm.plugin.appbrand.task;

import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.plugin.appbrand.g.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class c {
    private static boolean jJA = false;
    private static boolean jJB = false;
    private static boolean jJr = false;
    private static boolean jJs = false;
    private static HashSet<a> jJt = new HashSet();
    private static List<p> jJu = new LinkedList();
    private static List<j> jJv = new LinkedList();
    private static j jJw;
    private static String jJx = null;
    private static String jJy = null;
    private static com.tencent.mm.sdk.b.c jJz = new com.tencent.mm.sdk.b.c<ts>() {
        {
            this.xen = ts.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (ac.cfy()) {
                ag.h(new 1(this), 1000);
                a.xef.c(this);
            }
            return false;
        }
    };

    static /* synthetic */ void ub() {
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.gNk;
        com.tencent.mm.storage.c fn = com.tencent.mm.ipcinvoker.wx_extension.a.a.fn("100308");
        if (fn == null) {
            x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest item is null");
            return;
        }
        boolean z = fn.isValid() && "1".equals(fn.chI().get("closeClientPreload"));
        jJA = z;
        z = fn.isValid() && "1".equals(fn.chI().get("openDevelopControlPreload"));
        jJB = z;
        x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest close:%b, openDevelopCrt:%b", new Object[]{Boolean.valueOf(jJA), Boolean.valueOf(jJB)});
    }

    private static synchronized void reset() {
        synchronized (c.class) {
            jJr = false;
            jJs = false;
            jJt.clear();
            jJu.clear();
            jJv.clear();
            jJw = null;
            jJx = null;
            jJy = null;
        }
    }

    public static synchronized void uf(String str) {
        synchronized (c.class) {
            jJx = str;
            jJy = str;
        }
    }

    public static synchronized void a(a aVar, boolean z) {
        synchronized (c.class) {
            if (z) {
                reset();
            }
            if (jJr) {
                if (aVar != null) {
                    jJt.add(aVar);
                }
            } else if (!jJs) {
                jJr = true;
                if (aVar != null) {
                    jJt.add(aVar);
                }
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "TRACE_ORDER:AppBrandProcessPreloader.java");
                com.tencent.mm.plugin.appbrand.q.c.Dm().F(new 1());
            } else if (aVar != null) {
                aVar.onReady();
            }
        }
    }

    private static synchronized void aki() {
        synchronized (c.class) {
            if (jJv.size() <= 0) {
                j jVar = new j();
                jVar.irU = true;
                x.d("MicroMsg.AppBrandService", "preInjectConfig");
                JSONObject jSONObject = new JSONObject();
                j.a(jSONObject, "preload", Boolean.valueOf(true));
                jVar.e(jSONObject);
                jVar.irR.evaluateJavascript(String.format("var __wxConfig = %s;", new Object[]{jSONObject.toString()}), null);
                jVar.YP();
                if (jVar.irR.v(e.class) != null) {
                    ((e) jVar.irR.v(e.class)).sX("https://servicewechat.com/preload/js-engine");
                }
                jJv.add(jVar);
                jJw = jVar;
            }
        }
    }

    private static synchronized void akj() {
        synchronized (c.class) {
            if (jJu.size() <= 0) {
                p pVar = new p();
                pVar.irU = true;
                pVar.jDS = new t(new MutableContextWrapper(ac.getContext()));
                pVar.jDS.jFb = true;
                pVar.aiW();
                pVar.jDS.init();
                jJu.add(pVar);
            }
        }
    }

    public static synchronized j ug(String str) {
        j jVar;
        synchronized (c.class) {
            if (bh.ov(str) || !str.equals(jJy)) {
                jJy = str;
                if (jJv.size() <= 0) {
                    jVar = null;
                } else {
                    jVar = (j) jJv.get(0);
                    if (jVar == null) {
                        jVar = null;
                    } else {
                        jJv.remove(jVar);
                    }
                }
            } else {
                jVar = null;
            }
        }
        return jVar;
    }

    public static synchronized j akk() {
        j jVar;
        synchronized (c.class) {
            jVar = jJw;
        }
        return jVar;
    }

    public static synchronized p uh(String str) {
        p pVar;
        synchronized (c.class) {
            if (bh.ov(str) || !str.equals(jJx)) {
                jJx = str;
                if (jJu.size() <= 0) {
                    pVar = null;
                } else {
                    pVar = (p) jJu.get(0);
                    if (pVar == null) {
                        pVar = null;
                    } else {
                        jJu.remove(pVar);
                    }
                }
            } else {
                pVar = null;
            }
        }
        return pVar;
    }

    public static synchronized void akl() {
        boolean z = true;
        synchronized (c.class) {
            if (WebView.getTbsCoreVersion(ac.getContext()) == 0) {
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeClientPreload without x5");
            } else if (d.canOpenWebPlus(ac.getContext())) {
                z = jJA;
            } else {
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeClientPreload can not OpenWebPlus");
            }
            if (z) {
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preLoadNextRuntime disable preload");
            } else {
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preLoadNextRuntime");
                try {
                    aki();
                    akj();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", e, "preLoadNextRuntime exception.", new Object[0]);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", e2, "preLoadNextRuntime Error.", new Object[0]);
                }
            }
        }
    }

    public static synchronized void akm() {
        synchronized (c.class) {
            Runnable 3 = new 3();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                3.run();
            } else {
                ag.y(3);
            }
        }
    }

    private static synchronized void done() {
        synchronized (c.class) {
            x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit finished");
            jJs = true;
            jJr = false;
            Iterator it = jJt.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            jJt.clear();
        }
    }

    public static boolean akn() {
        return jJs;
    }

    public static boolean ako() {
        return jJB;
    }
}
