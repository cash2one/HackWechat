package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.b.d;
import com.tencent.mm.plugin.appbrand.dynamic.h.a;
import com.tencent.mm.plugin.appbrand.dynamic.h.a$a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class c implements OnAttachStateChangeListener, e, a$a, com.tencent.mm.sdk.platformtools.aj.c {
    private String hzj;
    private volatile b iSE;
    private volatile d iSF;
    private volatile com.tencent.mm.modelappbrand.c iSx;

    public final void initialize() {
        if (!(this.hzj == null || this.hzj.length() == 0)) {
            shutdown();
        }
        this.hzj = "Token#" + System.nanoTime();
        aj.a(this);
        p.a(new d());
    }

    public final void shutdown() {
        Map IV = acQ().IV();
        if (IV != null && !IV.isEmpty()) {
            for (Object next : new LinkedHashSet(IV.keySet())) {
                if (next != null && (next instanceof String)) {
                    ix((String) next);
                }
            }
        }
    }

    public final View be(Context context) {
        return new IPCDynamicPageView(context);
    }

    public final boolean a(String str, View view, Bundle bundle, q qVar) {
        f fVar = null;
        if (!(view instanceof IPCDynamicPageView)) {
            return false;
        }
        String string;
        String string2;
        String bG = k.bG(System.nanoTime());
        com.tencent.mm.plugin.appbrand.collector.c.b("widget_launch", bG, "on_bind_view", true);
        com.tencent.mm.plugin.appbrand.collector.c.aS(bG, "init_finish");
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        if (bundle != null) {
            string = bundle.getString("app_id");
            string2 = bundle.getString("msg_id");
            bundle.putString("__session_id", str);
            bundle.putLong("__on_bind_nano_time", System.nanoTime());
            bundle.putString("__session_id", bG);
            bundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.qm(bG));
        } else {
            string2 = null;
            string = null;
        }
        bG = WxaWidgetInitializer.aZ(string, string2);
        iPCDynamicPageView.removeOnAttachStateChangeListener(this);
        iPCDynamicPageView.addOnAttachStateChangeListener(this);
        Assert.assertNotNull(bG);
        iPCDynamicPageView.iVp = System.currentTimeMillis();
        if (qVar != null) {
            fVar = qVar.Jg();
        }
        if (!(iPCDynamicPageView.gOP == null || bG.equals(iPCDynamicPageView.gOP))) {
            iPCDynamicPageView.cleanup();
        }
        if (!(fVar == null || (bG.equals(iPCDynamicPageView.gOP) && iPCDynamicPageView.iVo))) {
            fVar.q(iPCDynamicPageView, 0);
        }
        iPCDynamicPageView.iVo = false;
        IPCDynamicPageView.iRH.post(new AnonymousClass3(iPCDynamicPageView, bG, bundle, qVar, string));
        x.v("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[]{bG});
        a ade = a.ade();
        if (!(this == null || str == null || str.length() == 0)) {
            ade.iUC.put(str, this);
        }
        a.ade().c(str, iPCDynamicPageView);
        acQ().g(str, iPCDynamicPageView);
        return true;
    }

    public final void a(String str, View view) {
        if (view instanceof IPCDynamicPageView) {
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            x.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", new Object[]{iPCDynamicPageView.gOP});
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            acQ().h(str, iPCDynamicPageView);
            a.ade().b(str, iPCDynamicPageView);
            iPCDynamicPageView.detach();
        }
    }

    public final void bA(View view) {
        if (view instanceof IPCDynamicPageView) {
            ((IPCDynamicPageView) view).jZ(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
        }
    }

    public final void ix(String str) {
        a.ade().iUB.remove(str);
        a ade = a.ade();
        if (!(str == null || str.length() == 0)) {
            ade.iUC.remove(str);
        }
        Set<View> aT = acQ().aT(str);
        if (aT != null && !aT.isEmpty()) {
            for (View view : aT) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
                    x.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", new Object[]{iPCDynamicPageView.gOP});
                    iPCDynamicPageView.removeOnAttachStateChangeListener(this);
                    iPCDynamicPageView.detach();
                }
            }
            if (!acQ().IV().isEmpty()) {
                return;
            }
            if (g.fk("com.tencent.mm:support")) {
                com.tencent.mm.bz.a.post(new 1());
            } else {
                x.i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
            }
        }
    }

    public final j bB(View view) {
        if (view instanceof IPCDynamicPageView) {
            return (j) view;
        }
        return null;
    }

    private com.tencent.mm.modelappbrand.c acQ() {
        if (this.iSx == null) {
            synchronized (this) {
                if (this.iSx == null) {
                    this.iSx = new a();
                }
            }
        }
        return this.iSx;
    }

    public final com.tencent.mm.modelappbrand.d IW() {
        if (this.iSE == null) {
            synchronized (this) {
                if (this.iSE == null) {
                    this.iSE = new b(acQ());
                }
            }
        }
        return this.iSE;
    }

    public final h IX() {
        if (this.iSF == null) {
            synchronized (this) {
                if (this.iSF == null) {
                    this.iSF = new d();
                }
            }
        }
        return this.iSF;
    }

    public final void a(String str, Throwable th) {
        x.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", new Object[]{Log.getStackTraceString(th)});
        shutdown();
    }

    public final void onViewAttachedToWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            x.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", new Object[]{((IPCDynamicPageView) view).gOP});
            r6.onResume();
        }
    }

    public final void onViewDetachedFromWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            x.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", new Object[]{((IPCDynamicPageView) view).gOP});
            r6.onPause();
        }
    }

    public final void a(String str, IPCDynamicPageView iPCDynamicPageView) {
        x.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", new Object[]{str, iPCDynamicPageView.gOP});
        a(str, (View) iPCDynamicPageView);
    }
}
