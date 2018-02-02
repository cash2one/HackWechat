package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.q.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static long jqy = 200;
    private static long jqz = 20;
    private final List<f> jqA;
    private Runnable jqB;
    private com.tencent.mm.plugin.appbrand.q.f jqp;

    public static c agI() {
        return a.jqD;
    }

    private static boolean agJ() {
        if (MMWebView.getCurWebType() == com.tencent.xweb.WebView.c.AqC) {
            if (MMWebView.getTbsCoreVersion(ac.getContext()) >= 36867) {
                return true;
            }
            return false;
        } else if (MMWebView.getCurWebType() != com.tencent.xweb.WebView.c.AqB) {
            return false;
        } else {
            return true;
        }
    }

    public static int agK() {
        return agJ() ? 5 : 20;
    }

    private c() {
        this.jqA = new LinkedList();
        jqy = (long) (agJ() ? 20 : 200);
        this.jqB = new 1(this);
        this.jqp = new com.tencent.mm.plugin.appbrand.q.f(jqy, new a(this) {
            final /* synthetic */ c jqC;

            {
                this.jqC = r1;
            }

            public final boolean g(Object... objArr) {
                synchronized (this.jqC.jqA) {
                    if (this.jqC.jqA.isEmpty()) {
                        return false;
                    }
                    this.jqC.jqB.run();
                    return true;
                }
            }
        });
    }

    public final boolean a(f fVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        if (fVar == null) {
            return false;
        }
        if (!fVar.b(cVar)) {
            return false;
        }
        synchronized (this.jqA) {
            boolean isEmpty = this.jqA.isEmpty();
            if (this.jqA.isEmpty()) {
                this.jqA.add(fVar);
            } else if (((f) this.jqA.get(0)).equals(fVar)) {
                this.jqA.add(0, fVar);
                this.jqA.remove(1);
            } else {
                this.jqA.remove(fVar);
                this.jqA.add(fVar);
            }
        }
        if (isEmpty && !this.jqp.i(new Object[0])) {
            x.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[]{fVar.getName()});
            com.tencent.mm.plugin.appbrand.q.c.Dm().g(this.jqB, jqy);
        }
        return true;
    }
}
