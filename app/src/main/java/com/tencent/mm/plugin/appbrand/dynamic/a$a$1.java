package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.f.f;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.c.e;
import java.util.Map;
import junit.framework.Assert;

class a$a$1 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ c iRB;
    final /* synthetic */ a iRC;
    final /* synthetic */ Bundle iRz;
    final /* synthetic */ String uR;

    a$a$1(a aVar, c cVar, String str, String str2, Bundle bundle) {
        this.iRC = aVar;
        this.iRB = cVar;
        this.uR = str;
        this.fgU = str2;
        this.iRz = bundle;
    }

    public final void run() {
        c cVar = this.iRB;
        String str = this.uR;
        String str2 = this.fgU;
        Bundle bundle = this.iRz;
        Assert.assertNotNull(str);
        if (!(str.equals(cVar.gOP) || cVar.gOM == null)) {
            cVar.cleanup();
            cVar.Vx = false;
            cVar.gOM = null;
        }
        cVar.gOP = str;
        cVar.appId = str2;
        String str3 = "";
        long j = 0;
        if (bundle != null) {
            String string = bundle.getString("cache_key", "");
            cVar.iRL = bundle.getString("query");
            cVar.mUrl = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            cVar.iRK = bundle.getInt("widget_type");
            cVar.iRN = bundle.getString("search_id");
            cVar.iKB = bundle.getString("__session_id");
            long j2 = bundle.getLong("__on_bind_nano_time");
            if (!bh.ov(cVar.iKB)) {
                c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
            }
            long j3 = j2;
            str3 = string;
            j = j3;
        }
        x.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s, %s)", str, str2, str3);
        Object obj = 1;
        cVar.iRM = b.rC(str);
        if (cVar.iRM == null) {
            cVar.iRM = new g();
            obj = null;
        }
        Object obj2 = cVar.iRK == 1 ? null : obj;
        cVar.iRM.field_id = str;
        cVar.iRM.field_cacheKey = str3;
        cVar.iRM.field_appId = str2;
        if (cVar.gOM == null) {
            e eVar;
            c.aR(cVar.iKB, "before_init_js_engine");
            Context context = cVar.mContext;
            String str4 = cVar.gOP;
            WxaWidgetContext ro = i.ro(str4);
            if (ro == null || bundle == null) {
                x.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", str4);
                eVar = null;
            } else {
                x.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", str4);
                eVar = com.tencent.mm.plugin.appbrand.dynamic.h.e.a(context, ro, new com.tencent.mm.plugin.appbrand.dynamic.d.b.a(str4, ro.acL()), bundle);
            }
            cVar.gOM = eVar;
            c.aR(cVar.iKB, "after_init_js_engine");
            cVar.gOM.gOP = cVar.gOP;
            if (bundle != null) {
                cVar.o(bundle.getBundle("__env_args"));
            }
            cVar.gOM.onStart();
            if (cVar.iRO) {
                cVar.gOM.b(new f());
            } else {
                cVar.gOM.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
            }
            e eVar2 = cVar.gOM;
            str4 = "";
            str3 = "";
            String str5 = "";
            Map map = null;
            int i = 0;
            int i2 = 0;
            if (bundle != null) {
                i = bundle.getInt("view_init_width");
                i2 = bundle.getInt("view_init_height");
                str4 = bundle.getString("cache_key", "");
                str3 = bundle.getString("msg_title", "");
                String string2 = bundle.getString("msg_path", "");
                str5 = l.uB(string2);
                map = l.uC(string2);
            }
            com.tencent.mm.u.b.c bVar = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
            bVar.iUc = str4;
            bVar.title = str3;
            bVar.path = str5;
            bVar.iUb = map;
            bVar.iUd = i;
            bVar.iUe = i2;
            eVar2.a(bVar);
            if (j > 0) {
                j2 = (System.nanoTime() - j) / 1000000;
                int i3 = 7;
                if (j2 <= 50) {
                    i3 = 0;
                } else if (j2 <= 100) {
                    i3 = 1;
                } else if (j2 <= 200) {
                    i3 = 2;
                } else if (j2 <= 300) {
                    i3 = 3;
                } else if (j2 <= 400) {
                    i3 = 4;
                } else if (j2 <= 500) {
                    i3 = 5;
                } else if (j2 <= 600) {
                    i3 = 6;
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(677, (long) i3, 1, false);
            }
            c.aR(cVar.iKB, "init_finish");
            c.print(cVar.iKB);
        } else {
            c.qn(cVar.iKB);
            if (bundle != null) {
                cVar.o(bundle.getBundle("__env_args"));
            }
            cVar.gOM.onStart();
            if (cVar.iRO) {
                cVar.gOM.b(new f());
            } else {
                cVar.gOM.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
            }
        }
        cVar.Vx = true;
        if (obj2 != null) {
            c.a(cVar.gOM, cVar.iRM);
        }
        cVar.acD();
    }
}
