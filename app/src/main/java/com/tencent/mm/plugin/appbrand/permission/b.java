package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.c.h;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class b {
    private static final LinkedList<Runnable> jGo = new LinkedList();
    private static final a jGp = new a();
    private static boolean jGq = false;
    private final b jGm;
    private final String jGn;
    private final String mAppId;

    private static final class a {
        final HashMap<String, HashSet<String>> jGy;

        private a() {
            this.jGy = new HashMap();
        }

        final boolean by(String str, String str2) {
            if (bh.ov(str) || bh.ov(str2)) {
                return false;
            }
            boolean z;
            synchronized (this) {
                HashSet hashSet = (HashSet) this.jGy.get(str);
                if (hashSet == null || !hashSet.contains(str2)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            return z;
        }

        final void put(String str, String str2) {
            if (!bh.ov(str) && !bh.ov(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.jGy.get(str);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        this.jGy.put(str, hashSet);
                    }
                    hashSet.add(str2);
                }
            }
        }

        final void E(String str, String str2) {
            if (!bh.ov(str) && !bh.ov(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.jGy.get(str);
                    if (hashSet != null) {
                        hashSet.remove(str2);
                    }
                }
            }
        }
    }

    private static final class c implements b {
        private final b jGz;

        private c(b bVar) {
            this.jGz = bVar;
        }

        public final void ajx() {
            if (this.jGz != null) {
                this.jGz.ajx();
            }
            ajz();
        }

        public final void ajy() {
            if (this.jGz != null) {
                this.jGz.ajy();
            }
            ajz();
        }

        public final void onCancel() {
            if (this.jGz != null) {
                this.jGz.onCancel();
            }
            ajz();
        }

        private void ajz() {
            com.tencent.mm.plugin.appbrand.q.c.Dm().F(new 1(this));
        }
    }

    static /* synthetic */ void a(b bVar, amu com_tencent_mm_protocal_c_amu) {
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, appId %s, api %s, checkAuth Response.errcode %d", new Object[]{bVar.mAppId, bVar.jGn, Integer.valueOf(com_tencent_mm_protocal_c_amu.wte.fts)});
        if (com_tencent_mm_protocal_c_amu.wte.fts == 0) {
            jGp.put(bVar.mAppId, bVar.jGn);
            bVar.jGm.ajx();
        } else if (com_tencent_mm_protocal_c_amu.wte.fts != -12000) {
            bVar.jGm.ajy();
        } else {
            final String str = com_tencent_mm_protocal_c_amu.vOn;
            final String str2 = com_tencent_mm_protocal_c_amu.wtq;
            final e oQ = com.tencent.mm.plugin.appbrand.a.oQ(bVar.mAppId);
            ag.y(new Runnable(bVar) {
                final /* synthetic */ b jGs;

                public final void run() {
                    if (oQ != null && oQ.iqC != null) {
                        h bVar = new com.tencent.mm.plugin.appbrand.widget.c.b(oQ.iqC.getContext());
                        bVar.setMessage(str);
                        bVar.a(j.izW, new 1(this));
                        bVar.b(j.izX, new 2(this));
                        bVar.setOnCancelListener(new 3(this));
                        oQ.a(bVar);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(b bVar, String str, int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmi = 1027;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-usersetauth";
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_amv = new amv();
        com_tencent_mm_protocal_c_amv.ngo = bVar.mAppId;
        com_tencent_mm_protocal_c_amv.vOl = str;
        com_tencent_mm_protocal_c_amv.wtb = i;
        aVar.hmj = com_tencent_mm_protocal_c_amv;
        aVar.hmk = new amw();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.JZ(), new 1(bVar, i));
    }

    static /* synthetic */ void b(String str, String str2, b bVar) {
        if (jGp.by(str, str2)) {
            x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", new Object[]{str, str2});
            bVar.ajx();
            return;
        }
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", new Object[]{str, str2});
        b bVar2 = new b(bVar, str, str2);
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmi = 1116;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-userauth";
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_amt = new amt();
        com_tencent_mm_protocal_c_amt.ngo = bVar2.mAppId;
        com_tencent_mm_protocal_c_amt.wtp = bVar2.jGn;
        aVar.hmj = com_tencent_mm_protocal_c_amt;
        aVar.hmk = new amu();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.JZ(), new 2(bVar2));
    }

    private b(b bVar, String str, String str2) {
        this.jGm = bVar;
        this.mAppId = str;
        this.jGn = str2;
    }

    public static boolean bx(String str, String str2) {
        return jGp.by(str, str2);
    }

    public static void a(final String str, final String str2, final b bVar) {
        if (!bh.ov(str) && !bh.ov(str2)) {
            final Runnable anonymousClass4 = new Runnable() {
                public final void run() {
                    b.b(str, str2, new c(bVar));
                }
            };
            com.tencent.mm.plugin.appbrand.q.c.Dm().F(new Runnable() {
                public final void run() {
                    if (b.jGq) {
                        b.jGo.add(anonymousClass4);
                        x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[]{str, str2});
                        return;
                    }
                    b.jGq = true;
                    anonymousClass4.run();
                }
            });
        }
    }
}
