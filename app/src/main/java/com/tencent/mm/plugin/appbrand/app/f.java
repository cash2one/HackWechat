package com.tencent.mm.plugin.appbrand.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.media.d;
import com.tencent.mm.plugin.appbrand.media.f$a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.h;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.as;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bs;
import com.tencent.xweb.WebView;
import com.tencent.xweb.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public final class f implements ap {
    private static volatile c iCW;
    private static volatile com.tencent.mm.plugin.appbrand.config.c iCX;
    private static volatile ai iCY;
    private static volatile n iCZ;
    private static volatile j iDa;
    private static volatile p iDb;
    private static volatile t iDc;
    private static volatile h iDd;
    private static volatile i iDe;
    private static volatile a iDf;
    private static volatile m iDg;
    private static volatile com.tencent.mm.plugin.appbrand.o.a iDh;
    private static volatile r iDi;
    private static volatile com.tencent.mm.plugin.appbrand.game.a.a.c iDj;
    private static com.tencent.mm.plugin.appbrand.c.c iDk;
    private static b iDl;
    private static com.tencent.mm.plugin.appbrand.media.f iDm;
    private com.tencent.mm.sdk.e.j.a hiB = new 28(this);
    private com.tencent.mm.network.n hsr = new 22(this);
    private final com.tencent.mm.sdk.b.c<bq> iDA = new 20(this);
    private final com.tencent.mm.sdk.b.c<ir> iDB = new 21(this);
    private final bs.a iDC = new ag();
    private com.tencent.mm.sdk.b.c iDD = new 24(this);
    private com.tencent.mm.sdk.b.c iDE = new com.tencent.mm.sdk.b.c<fw>(this) {
        final /* synthetic */ f iDI;

        {
            this.iDI = r2;
            this.xen = fw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fw fwVar = (fw) bVar;
            x.i("MicroMsg.SubCoreAppBrand", "FetchAppBrandInfoForMusicEvent callback");
            fwVar.fvK.appId = d.a.aio().jzA;
            fwVar.fvK.fvL = d.a.aio().fvL;
            fwVar.fvK.frn = d.a.aio().frn;
            fwVar.fvK.fvM = d.a.aio().fvM;
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c iDF = new 26(this);
    private com.tencent.mm.sdk.b.c<ic> iDG = new com.tencent.mm.sdk.b.c<ic>(this) {
        final /* synthetic */ f iDI;

        {
            this.iDI = r2;
            this.xen = ic.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ic icVar = (ic) bVar;
            HCEEventLogic.b(icVar.fyA.appId, icVar.fyA.type, icVar.fyA.extras);
            return false;
        }
    };
    private final AppBrandGuideUI.a iDH = new AppBrandGuideUI.a();
    private as.a iDn = new com.tencent.mm.plugin.appbrand.n.a();
    private com.tencent.mm.vending.b.b iDo = null;
    private final com.tencent.mm.plugin.auth.a.a iDp = new 9(this);
    private final Set<com.tencent.mm.sdk.b.c> iDq = new HashSet();
    private final com.tencent.mm.sdk.b.c<iz> iDr = new 10(this);
    private final com.tencent.mm.sdk.b.c<sg> iDs = new 11(this);
    private final com.tencent.mm.sdk.b.c<jn> iDt = new com.tencent.mm.sdk.b.c<jn>(this) {
        final /* synthetic */ f iDI;

        {
            this.iDI = r2;
            this.xen = jn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            af afVar = ((jn) bVar).fAg.fAh;
            if (com.tencent.mm.storage.x.fV(afVar.field_username)) {
                afVar.setType(0);
                com.tencent.mm.plugin.appbrand.config.r.qY(afVar.field_username);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<ml> iDu = new com.tencent.mm.sdk.b.c<ml>(this) {
        final /* synthetic */ f iDI;

        {
            this.iDI = r2;
            this.xen = ml.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cf cfVar = ((ml) bVar).fEq.fnB;
            if (cfVar != null) {
                String str = cfVar.field_talker;
                if (com.tencent.mm.storage.x.fV(str)) {
                    f.Zl().aV(str + "_unreadCount", String.valueOf(bh.getInt(f.Zl().get(str + "_unreadCount", "0"), 0) + 1));
                    aj WY = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().WY(str);
                    com.tencent.mm.plugin.appbrand.ipc.d.ay(q.qQ(str), WY != null ? WY.field_unReadCount : 0);
                }
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.m> iDv = new 15(this);
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p> iDw = new 16(this);
    private final com.tencent.mm.sdk.b.c<o> iDx = new 17(this);
    private final com.tencent.mm.sdk.b.c<l> iDy = new 18(this);
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n> iDz = new 19(this);

    static /* synthetic */ void Zw() {
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100249");
        ac.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("appbrand_video_player", fn.isValid() ? bh.getInt((String) fn.chI().get("appbrand_player"), -1) : -1).commit();
        x.i("MicroMsg.SubCoreAppBrand", "check appbrand video ab test[%d]", new Object[]{Integer.valueOf(r0)});
    }

    static /* synthetic */ void Zx() {
        try {
            k.iQ(ac.getContext());
            com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100367");
            x.i("MicroMsg.SubCoreAppBrand", "get abtest of webview core");
            if (fn.isValid()) {
                x.i("MicroMsg.SubCoreAppBrand", "abtest of webview core is on");
                Map chI = fn.chI();
                if (bh.getInt((String) chI.get("WebCoreTestFlag"), 0) == 1) {
                    int i = bh.getInt((String) chI.get("ModuleToolsType"), 2);
                    int i2 = bh.getInt((String) chI.get("ModuleAppbrandType"), 2);
                    int i3 = bh.getInt((String) chI.get("ModuleSupportType"), 2);
                    x.i("MicroMsg.SubCoreAppBrand", "moduleToolsType:" + i + ";moduleAppbrandType:" + i2 + ";moduleSupportType" + i3 + ":jsRuntimeType" + bh.getInt((String) chI.get("JsRuntimeType"), 0));
                    Editor edit = ac.getContext().getSharedPreferences("wcwebview", 4).edit();
                    edit.putString("ABTestWebViewtools", WebView.c.values()[i].toString());
                    edit.putString("ABTestWebViewappbrand", WebView.c.values()[i2].toString());
                    edit.putString("ABTestWebViewsupport", WebView.c.values()[i3].toString());
                    edit.commit();
                    if (i == 1 || i2 == 1 || i3 == 1) {
                        XWalkEnvironment.setGrayValueForTest(1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void Zy() {
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100371");
        x.i("MicroMsg.SubCoreAppBrand", "get abtest of XWebLocalDebug");
        if (fn.isValid()) {
            x.i("MicroMsg.SubCoreAppBrand", "abtest of XWebLocalDebug is on");
            int i = bh.getInt((String) fn.chI().get("bEnableLocalDebug"), 0);
            Editor edit = ac.getContext().getSharedPreferences("wcwebview", 4).edit();
            if (i == 1) {
                edit.putBoolean("m_bEnableLocalDebug", true).commit();
            } else {
                edit.putBoolean("m_bEnableLocalDebug", false).commit();
            }
        }
    }

    private HashMap<Integer, com.tencent.mm.by.h.d> Zc() {
        HashMap<Integer, com.tencent.mm.by.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new 1(this));
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new 12(this));
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new com.tencent.mm.by.h.d(this) {
            final /* synthetic */ f iDI;

            {
                this.iDI = r1;
            }

            public final String[] wg() {
                return com.tencent.mm.plugin.appbrand.config.c.iEK;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new 29(this));
        hashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new 30(this));
        hashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new 31(this));
        hashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new 32(this));
        hashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new com.tencent.mm.by.h.d(this) {
            final /* synthetic */ f iDI;

            {
                this.iDI = r1;
            }

            public final String[] wg() {
                return h.iEK;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new 34(this));
        hashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new 2(this));
        hashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new 3(this));
        hashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new 4(this));
        hashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new 5(this));
        for (Entry entry : a.iCR.entrySet()) {
            hashMap.put(Integer.valueOf(((a.a) entry.getKey()).hashCode()), new 6(this, (String[]) entry.getValue()));
        }
        return hashMap;
    }

    public static f Zd() {
        com.tencent.mm.plugin.appbrand.a.c cVar = (com.tencent.mm.plugin.appbrand.a.c) g.k(com.tencent.mm.plugin.appbrand.a.c.class);
        if (cVar != null) {
            return ((PluginAppBrand) cVar).getCore();
        }
        return null;
    }

    public final a Ze() {
        String str = g.Dj().cachePath + "AppBrandComm.db";
        if (iDf != null && str.equals(iDf.getPath())) {
            return iDf;
        }
        a a = com.tencent.mm.platformtools.g.a(hashCode(), str, Zc(), true);
        iDf = a;
        return a;
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[]{Boolean.valueOf(z)});
        this.iDo = ((com.tencent.mm.plugin.auth.a.b) g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.iDp);
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences != null) {
            Set stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet != null) {
                StringBuilder stringBuilder = new StringBuilder();
                g.Dh();
                if (stringSet.add(stringBuilder.append(com.tencent.mm.kernel.a.Cg()).toString())) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove("uin_set");
                    edit.commit();
                    edit.putStringSet("uin_set", stringSet);
                    edit.commit();
                }
            }
        }
        for (com.tencent.mm.sdk.b.c ceO : this.iDq) {
            ceO.ceO();
        }
        for (String a : ag.iGe.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a(a, this.iDC, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.h.b.aaZ();
        com.tencent.mm.plugin.appbrand.appusage.m.a.aaZ();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().b(this.iDn);
        Ze();
        iCW = new c(iDf);
        iCX = new com.tencent.mm.plugin.appbrand.config.c(iDf);
        iCY = new ai(iDf);
        iCZ = new n(iDf);
        iDa = new j(iDf);
        iDc = new t(iDf);
        iDd = new h(iDf);
        iDe = new i(iDf);
        iDg = new m(iDf);
        iDh = new com.tencent.mm.plugin.appbrand.o.a(iDf);
        iDi = new r(iDf);
        iDj = new com.tencent.mm.plugin.appbrand.game.a.a.c(iDf);
        Zh();
        a.a(iDf);
        com.tencent.mm.plugin.appbrand.d.setup();
        q.abY();
        com.tencent.mm.plugin.appbrand.l.c.a.jJe.prepare();
        ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon().a(-86016, new 7(this));
        ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon().a(-86016, new 8(this));
        g.Di().a(this.hsr);
        com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
        com.tencent.mm.z.c.c.IF().c(this.hiB);
        com.tencent.mm.plugin.appbrand.config.f.init();
        AppBrandGuideUI.a aVar = this.iDH;
        AppBrandGuideUI.a.akB().registerActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.d(aVar);
        aVar.jKH = false;
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
        if (this.iDo != null) {
            this.iDo.dead();
            this.iDo = null;
        }
        for (com.tencent.mm.sdk.b.c dead : this.iDq) {
            dead.dead();
        }
        com.tencent.mm.plugin.appbrand.d.release();
        for (String b : ag.iGe.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b(b, this.iDC, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.h.b.unregister();
        com.tencent.mm.plugin.appbrand.appusage.m.a.unregister();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().c(this.iDn);
        com.tencent.mm.plugin.appbrand.appcache.aj.shutdown();
        iCW = null;
        iDb = null;
        iCX = null;
        iCY = null;
        iCZ = null;
        iDa = null;
        iDc = null;
        iDd = null;
        iDe = null;
        iDg = null;
        iDh = null;
        iDi = null;
        iDj = null;
        a.YX();
        if (iDl != null) {
            b bVar = iDl;
            bVar.iLA.clear();
            bVar.iLB.clear();
            iDl = null;
        }
        iDk = null;
        if (iDm != null) {
            com.tencent.mm.plugin.appbrand.media.f fVar = iDm;
            x.i("MicroMsg.AudioRecordMgr", "destroy");
            if (fVar.jzH == f$a.jzT || fVar.jzH == f$a.jzU || fVar.jzH == f$a.jzX) {
                fVar.vi();
            }
            iDm = null;
        }
        com.tencent.mm.plugin.appbrand.media.c.ail();
        com.tencent.mm.plugin.appbrand.media.c.ain();
        if (iDf != null) {
            iDf.iV(hashCode());
            iDf = null;
        }
        com.tencent.mm.plugin.appbrand.appusage.b.release();
        q.release();
        com.tencent.mm.plugin.appbrand.l.c cVar = com.tencent.mm.plugin.appbrand.l.c.a.jJe;
        x.d("MicroMsg.WxaFTSSearchCore", "reset");
        com.tencent.mm.sdk.b.a.xef.c(cVar.jJa);
        com.tencent.mm.sdk.b.a.xef.c(cVar.jJb);
        cVar.jJc.dead();
        com.tencent.mm.plugin.appbrand.q.c.alJ();
        ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterIndexStorage(WXMediaMessage.TITLE_LENGTH_LIMIT);
        ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterNativeLogic(7);
        com.tencent.mm.plugin.fts.d.h.qh(e.CTRL_INDEX);
        com.tencent.mm.plugin.fts.d.h.qh(4208);
        ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterIndexStorage(8);
        ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterNativeLogic(10);
        com.tencent.mm.plugin.fts.d.h.qh(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX);
        com.tencent.mm.plugin.fts.d.h.qh(4224);
        g.Di().b(this.hsr);
        com.tencent.mm.plugin.appbrand.dynamic.g.release();
        com.tencent.mm.z.c.c.IF().j(this.hiB);
        com.tencent.mm.plugin.appbrand.config.f.release();
        AppBrandGuideUI.a aVar = this.iDH;
        AppBrandGuideUI.a.akB().unregisterActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.c(aVar);
        aVar.jKH = false;
    }

    public f() {
        this.iDq.add(this.iDy);
        this.iDq.add(new com.tencent.mm.plugin.appbrand.launching.a());
        this.iDq.add(this.iDz);
        this.iDq.add(this.iDt);
        this.iDq.add(this.iDu);
        this.iDq.add(this.iDs);
        this.iDq.add(new com.tencent.mm.plugin.appbrand.config.e());
        this.iDq.add(this.iDr);
        this.iDq.add(com.tencent.mm.plugin.appbrand.appusage.a.iIJ);
        this.iDq.add(this.iDv);
        this.iDq.add(this.iDw);
        this.iDq.add(this.iDx);
        this.iDq.add(this.iDD);
        this.iDq.add(this.iDA);
        this.iDq.add(this.iDB);
        this.iDq.add(this.iDE);
        this.iDq.add(this.iDF);
        this.iDq.add(this.iDG);
    }

    public static AppBrandGuideUI.a Zf() {
        return Zd() == null ? null : Zd().iDH;
    }

    public static c Zg() {
        return iCW;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p Zh() {
        synchronized (f.class) {
            if (iDb != null) {
                p pVar = iDb;
                Object obj = (pVar.hhp == null || pVar.hhp.cgM()) ? null : 1;
            }
            if (!(iDf == null || iDf.cgM())) {
                iDb = new p(iDf);
            }
        }
        return iDb;
    }

    public static t Zi() {
        return iDc;
    }

    public static i Zj() {
        return iDe;
    }

    public static m Zk() {
        return iDg;
    }

    public static com.tencent.mm.plugin.appbrand.config.c Zl() {
        if (!(iCX != null || iDf == null || iDf.cgM())) {
            iCX = new com.tencent.mm.plugin.appbrand.config.c(iDf);
        }
        return iCX;
    }

    public static n Zm() {
        return iCZ;
    }

    public static j Zn() {
        return iDa;
    }

    public static ai Zo() {
        return iCY;
    }

    public static h Zp() {
        return iDd;
    }

    public static com.tencent.mm.plugin.appbrand.c.c Zq() {
        if (iDk == null) {
            iDk = new com.tencent.mm.plugin.appbrand.c.c();
        }
        return iDk;
    }

    public static b Zr() {
        if (iDl == null) {
            iDl = new b();
        }
        return iDl;
    }

    public static com.tencent.mm.plugin.appbrand.media.f Zs() {
        if (iDm == null) {
            iDm = new com.tencent.mm.plugin.appbrand.media.f();
        }
        return iDm;
    }

    public static com.tencent.mm.plugin.appbrand.o.a Zt() {
        return iDh;
    }

    public static r Zu() {
        return iDi;
    }

    public static com.tencent.mm.plugin.appbrand.game.a.a.c Zv() {
        return iDj;
    }

    public static <T> T u(Class<T> cls) {
        return a.u(cls);
    }
}
