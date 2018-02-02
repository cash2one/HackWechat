package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.e.a;
import android.support.v4.view.z;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.Reference;
import java.util.Map;

public class i implements e {
    private static final i jXo = new 1();
    private static final a<p, i> jXt = new a();
    public final Map<a, i> jXn;
    private final int jXp;
    private final int jXq;
    private int jXr;
    private boolean jXs;
    private final Runnable jXu;
    private final Runnable jXv;
    private final p jgr;

    static /* synthetic */ View b(i iVar) {
        return !iVar.jgr.isRunning() ? null : iVar.jgr.aeM();
    }

    static /* synthetic */ void c(i iVar) {
        if (iVar.jXn.size() > 0) {
            for (a amG : (a[]) iVar.jXn.keySet().toArray(new a[iVar.jXn.size()])) {
                amG.amG();
            }
        }
    }

    static /* synthetic */ int e(i iVar) {
        int i = iVar.jXr + 1;
        iVar.jXr = i;
        return i;
    }

    static /* synthetic */ int h(i iVar) {
        Display defaultDisplay = ((WindowManager) iVar.jgr.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    static /* synthetic */ void j(i iVar) {
        if (iVar.jXn.size() > 0) {
            for (a amF : (a[]) iVar.jXn.keySet().toArray(new a[iVar.jXn.size()])) {
                amF.amF();
            }
        }
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.jXn.remove(aVar);
        }
    }

    private i() {
        this.jXn = new a();
        this.jXq = 5;
        this.jXr = 0;
        this.jXs = false;
        this.jXu = new Runnable(this) {
            final /* synthetic */ i jXw;

            {
                this.jXw = r1;
            }

            public final void run() {
                if (this.jXw.jgr.isRunning()) {
                    View b = i.b(this.jXw);
                    if (b != null) {
                        b.scrollTo(0, 0);
                        i.c(this.jXw);
                    }
                }
            }
        };
        this.jXv = new 3(this);
        this.jgr = null;
        this.jXp = 0;
    }

    private i(p pVar) {
        int i = 0;
        this.jXn = new a();
        this.jXq = 5;
        this.jXr = 0;
        this.jXs = false;
        this.jXu = /* anonymous class already generated */;
        this.jXv = new 3(this);
        this.jgr = pVar;
        this.jgr.a(this);
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(pVar.mContext, 10);
        if (VERSION.SDK_INT >= 21) {
            i = j.akM();
        }
        this.jXp = i + fromDPToPix;
    }

    public static i a(Reference<p> reference) {
        return l(reference == null ? null : (p) reference.get());
    }

    public static i l(p pVar) {
        if (pVar == null || !pVar.isRunning()) {
            x.j("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page " + pVar, new Object[0]);
            return jXo;
        }
        i iVar = (i) jXt.get(pVar);
        if (iVar != null) {
            return iVar;
        }
        iVar = new i(pVar);
        jXt.put(pVar, iVar);
        return iVar;
    }

    private void dt(boolean z) {
        if (z) {
            this.jXr = 0;
            this.jXs = false;
        }
        if (!this.jgr.isRunning() || this.jXs) {
            return;
        }
        if (this.jXr == 0) {
            x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", new Object[]{Boolean.valueOf(z.ak(this.jgr.getContentView()))});
            this.jgr.getContentView().post(this.jXv);
            return;
        }
        x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", new Object[]{Boolean.valueOf(z.ak(this.jgr.getContentView()))});
        this.jgr.getContentView().postOnAnimation(this.jXv);
    }

    public void amC() {
        dt(true);
    }

    public void amD() {
        if (this.jgr.isRunning()) {
            this.jXs = true;
            this.jgr.getContentView().post(this.jXu);
        }
    }

    public void onDestroy() {
        this.jgr.b(this);
        jXt.remove(this.jgr);
    }
}
