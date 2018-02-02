package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import org.json.JSONException;
import org.json.JSONObject;

class c$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ c jhg;
    final /* synthetic */ c jhk;

    c$1(c cVar, p pVar, c cVar2, int i, JSONObject jSONObject) {
        this.jhk = cVar;
        this.jdJ = pVar;
        this.jhg = cVar2;
        this.gOK = i;
        this.jel = jSONObject;
    }

    public final void run() {
        int i = 0;
        if (this.jdJ == null) {
            x.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
            this.jhg.E(this.gOK, this.jhk.e("fail:page is null", null));
            return;
        }
        try {
            int i2 = this.jhk.i(this.jel);
            View lo = this.jdJ.aeF().lo(i2);
            if (lo == null) {
                x.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", Integer.valueOf(i2));
                this.jhg.E(this.gOK, this.jhk.e("fail:got 'null' when get view by the given viewId", null));
                return;
            }
            boolean a;
            c cVar = this.jhk;
            p pVar = this.jdJ;
            JSONObject jSONObject = this.jel;
            if (cVar.afL()) {
                try {
                    b y = pVar.aeF().y(i2, false);
                    if (y != null) {
                        jSONObject.getBoolean("disableScroll");
                        if (!y.hA("isTouching")) {
                            y.u("disableScroll", true);
                        } else if (!y.getBoolean("disableScroll", false)) {
                            y.u("disableScroll-nextState", true);
                        }
                    }
                } catch (JSONException e) {
                }
            }
            try {
                a = this.jdJ.aeF().a(i2, c.j(this.jel), c.k(this.jel), c.l(this.jel));
                String str = "MicroMsg.BaseUpdateViewJsApi";
                String str2 = "update view(parentId : %s, viewId : %d), ret : %b";
                Object[] objArr = new Object[4];
                u.b lm = this.jdJ.aeF().lm(i2);
                if (lm != null) {
                    i = lm.jFB;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Integer.valueOf(lo.hashCode());
                objArr[3] = Boolean.valueOf(a);
                x.i(str, str2, objArr);
            } catch (JSONException e2) {
                a = true;
            }
            boolean afN = this.jhk.afN();
            if (a) {
                if (afN) {
                    a = this.jhk.a(this.jdJ, i2, lo, this.jel, new f(this.jhg, this.gOK));
                } else {
                    a = this.jhk.c(this.jdJ, i2, lo, this.jel);
                }
            }
            if (!afN) {
                String str3;
                c cVar2 = this.jhg;
                i2 = this.gOK;
                e eVar = this.jhk;
                if (a) {
                    str3 = "ok";
                } else {
                    str3 = "fail";
                }
                cVar2.E(i2, eVar.e(str3, null));
            }
        } catch (JSONException e3) {
            this.jhg.E(this.gOK, this.jhk.e("fail:view id do not exist", null));
        }
    }
}
