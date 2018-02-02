package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.bq.b;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.cbe;
import com.tencent.mm.protocal.c.cbf;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.i;
import java.util.Iterator;
import java.util.List;

public final class r {

    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ List iPc;

        public AnonymousClass2(List list) {
            this.iPc = list;
        }

        public final void run() {
            for (String O : this.iPc) {
                r.O(O, true);
            }
        }
    }

    interface a<T> {
        String aZ(T t);

        String getUsername();

        l ra(String str);

        T rb(String str);
    }

    static boolean qV(String str) {
        if (f.Zh() == null) {
            x.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
            return false;
        }
        long Wo = bh.Wo();
        WxaAttributes e = f.Zh().e(str, "syncTimeSecond");
        x.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[]{str, Long.valueOf(Wo), Long.valueOf(e == null ? 0 : e.field_syncTimeSecond), Integer.valueOf(g.zY().getInt("MMBizAttrSyncFreq", 3600))});
        if (Wo - (e == null ? 0 : e.field_syncTimeSecond) >= ((long) g.zY().getInt("MMBizAttrSyncFreq", 3600))) {
            return true;
        }
        return false;
    }

    private static boolean qW(String str) {
        if (bh.ov(str) || i.fV(str)) {
            return false;
        }
        x.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[]{str, ai.i(new Throwable())});
        d.pPH.a(648, 1, 1, false);
        return true;
    }

    static b qX(String str) {
        WxaAttributes e = f.Zh().e(str, "syncVersion");
        return new b(e == null ? new byte[0] : bh.VD(bh.ou(e.field_syncVersion)));
    }

    public static void qY(final String str) {
        if (!qW(str)) {
            e.post(new Runnable() {
                public final void run() {
                    r.qZ(str);
                }
            }, "WxaAttrSync");
        }
    }

    public static Pair<WxaAttributes, com.tencent.mm.ae.a.a> O(final String str, boolean z) {
        return a(str, z, new a<WxaAttributes>() {
            public final /* bridge */ /* synthetic */ String aZ(Object obj) {
                return ((WxaAttributes) obj).field_syncVersion;
            }

            public final /* synthetic */ Object rb(String str) {
                return f.Zh().f(str, new String[0]);
            }

            public final String getUsername() {
                return q.qS(str);
            }

            public final l ra(String str) {
                return new l(null, str);
            }
        });
    }

    static <T> Pair<T, com.tencent.mm.ae.a.a> a(String str, boolean z, a<T> aVar) {
        int i = -1;
        Object obj = null;
        if (bh.ov(str)) {
            return Pair.create(null, null);
        }
        Object obj2;
        if (z) {
            obj2 = null;
        } else {
            obj2 = aVar.rb(str);
            if (!(obj2 == null || bh.ov(aVar.aZ(obj2)))) {
                x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", new Object[]{Boolean.valueOf(z), obj2});
                return Pair.create(obj2, obj);
            }
        }
        com.tencent.mm.ae.a.a c = c.c(aVar.ra(str).gJQ);
        if (c == null || (c instanceof com.tencent.mm.plugin.appbrand.i.c.a) || c.errType != 0 || c.errCode != 0) {
            String str2 = "MicroMsg.WxaAttrSyncHelper";
            String str3 = "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(c == null ? -1 : c.errType);
            if (c != null) {
                i = c.errCode;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = c == null ? "null resp" : c.fnL;
            x.e(str2, str3, objArr);
            if (obj2 == null) {
                obj2 = aVar.rb(str);
                if (obj2 == null) {
                    return Pair.create(null, c);
                }
            }
            return Pair.create(obj2, c);
        }
        String str4;
        String str5;
        Iterator it = ((cbf) c.fJJ).vNi.iterator();
        while (it.hasNext()) {
            cbe com_tencent_mm_protocal_c_cbe = (cbe) it.next();
            if ("UserName".equalsIgnoreCase(com_tencent_mm_protocal_c_cbe.vNj)) {
                str4 = com_tencent_mm_protocal_c_cbe.pQt;
                if (!str4.endsWith("@app")) {
                    str4 = str4 + "@app";
                }
                if (bh.ov(str4)) {
                    str4 = aVar.getUsername();
                    if (bh.ov(str4)) {
                        x.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[]{Boolean.valueOf(z), str});
                        return Pair.create(null, null);
                    }
                }
                str5 = str4;
                if (f.Zh().a(str5, ((cbf) c.fJJ).vNh, ((cbf) c.fJJ).vNi)) {
                    q.abY().b("single", 3, str5);
                }
                obj2 = aVar.rb(str);
                x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[]{Boolean.valueOf(z), obj2});
                obj = c;
                return Pair.create(obj2, obj);
            }
        }
        str4 = null;
        if (bh.ov(str4)) {
            str4 = aVar.getUsername();
            if (bh.ov(str4)) {
                x.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[]{Boolean.valueOf(z), str});
                return Pair.create(null, null);
            }
        }
        str5 = str4;
        if (f.Zh().a(str5, ((cbf) c.fJJ).vNh, ((cbf) c.fJJ).vNi)) {
            q.abY().b("single", 3, str5);
        }
        obj2 = aVar.rb(str);
        x.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[]{Boolean.valueOf(z), obj2});
        obj = c;
        return Pair.create(obj2, obj);
    }

    public static Pair<WxaAttributes, com.tencent.mm.ae.a.a> P(final String str, boolean z) {
        if (qW(str)) {
            return new Pair(null, null);
        }
        return a(str, z, new a<WxaAttributes>() {
            public final /* bridge */ /* synthetic */ String aZ(Object obj) {
                return ((WxaAttributes) obj).field_syncVersion;
            }

            public final /* synthetic */ Object rb(String str) {
                return f.Zh().e(str, new String[0]);
            }

            public final String getUsername() {
                return str;
            }

            public final l ra(String str) {
                return new l(str, null);
            }
        });
    }

    public static void a(String str, b<WxaAttributes> bVar) {
        if (!qW(str)) {
            Looper looper;
            boolean z;
            if (ag.isMainThread() || Looper.myLooper() == null) {
                looper = new ag().oAt.getLooper();
                z = true;
            } else {
                looper = Looper.myLooper();
                z = false;
            }
            new af(looper).post(new 5(str, bVar, z));
        }
    }

    public static void qZ(String str) {
        if (!qW(str) && qV(str)) {
            P(str, true);
        }
    }

    public static void a(List<String> list, k$a com_tencent_mm_plugin_appbrand_config_k_a) {
        int i = 0;
        if (!bh.cA(list)) {
            if (ag.isMainThread()) {
                com.tencent.mm.plugin.appbrand.q.c.Dm().F(new 6(list));
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!qV((String) it.next())) {
                    it.remove();
                }
            }
            if (!bh.cA(list)) {
                x.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[]{Integer.valueOf(list.size()), com_tencent_mm_plugin_appbrand_config_k_a.name(), Integer.valueOf(com_tencent_mm_plugin_appbrand_config_k_a.ordinal())});
                for (int i2 = 0; i2 < list.size() / 20; i2++) {
                    int i3 = i2 * 20;
                    i = i3 + 20;
                    b(list.subList(i3, i), com_tencent_mm_plugin_appbrand_config_k_a);
                }
                if (i < list.size()) {
                    b(list.subList(i, list.size()), com_tencent_mm_plugin_appbrand_config_k_a);
                }
            }
        }
    }

    private static void b(List<String> list, k$a com_tencent_mm_plugin_appbrand_config_k_a) {
        if (!bh.cA(list)) {
            new k(list, com_tencent_mm_plugin_appbrand_config_k_a).JV().g(new 7());
        }
    }
}
