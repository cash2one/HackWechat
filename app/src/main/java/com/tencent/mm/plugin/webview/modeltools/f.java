package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.webview.b.e;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.plugin.webview.fts.l;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.af;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.modelcache.h;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class f implements ap {
    private static final HashMap<Integer, d> gwY;
    c bannerOnInitListener = new 5(this);
    private a kur = new 18(this);
    private n mEF = new 10(this);
    private ac tuF;
    private ad tuG;
    private ab tuH;
    private i tuI;
    private com.tencent.mm.plugin.webview.model.d tuJ;
    private af tuK;
    private e tuL;
    private com.tencent.mm.plugin.webview.fts.c tuM;
    private com.tencent.mm.plugin.webview.fts.d tuN;
    private com.tencent.mm.plugin.webview.fts.e tuO;
    private com.tencent.mm.plugin.webview.c.a tuP;
    private final com.tencent.mm.plugin.webview.modelcache.n tuQ = new com.tencent.mm.plugin.webview.modelcache.n();
    private com.tencent.mm.plugin.webview.wepkg.utils.c tuR = new com.tencent.mm.plugin.webview.wepkg.utils.c();
    c tuS = new 2(this);
    final c<tt> tuT = new 3(this);
    c tuU = new 4(this);
    c tuV = new 6(this);
    c tuW = new 7(this);
    c tuX = new 8(this);
    private c tuY = new 9(this);

    public static f bRv() {
        ar.Ha();
        f fVar = (f) bp.hY("plugin.webview");
        if (fVar != null) {
            return fVar;
        }
        Object fVar2 = new f();
        x.e("MicroMsg.SubCoreTools", "new SubCoreTools add to subCore:%d", new Object[]{Integer.valueOf(fVar2.hashCode())});
        ar.Ha().a("plugin.webview", fVar2);
        return fVar2;
    }

    public static com.tencent.mm.plugin.webview.c.a bRw() {
        if (bRv().tuP == null) {
            bRv().tuP = new com.tencent.mm.plugin.webview.c.a();
        }
        return bRv().tuP;
    }

    public static com.tencent.mm.plugin.webview.fts.d bRx() {
        if (bRv().tuN == null) {
            bRv().tuN = new com.tencent.mm.plugin.webview.fts.d();
        }
        return bRv().tuN;
    }

    public static com.tencent.mm.plugin.webview.fts.e bRy() {
        if (bRv().tuO == null) {
            bRv().tuO = new com.tencent.mm.plugin.webview.fts.e();
        }
        return bRv().tuO;
    }

    public static com.tencent.mm.plugin.webview.fts.c bRz() {
        if (bRv().tuM == null) {
            bRv().tuM = new com.tencent.mm.plugin.webview.fts.c();
        }
        return bRv().tuM;
    }

    public static ac bRA() {
        if (bRv().tuF == null) {
            bRv().tuF = new ac();
        }
        return bRv().tuF;
    }

    public static ad bRB() {
        if (bRv().tuG == null) {
            bRv().tuG = ad.bQP();
        }
        return bRv().tuG;
    }

    public static i bRC() {
        if (bRv().tuI == null) {
            f bRv = bRv();
            ar.Hg();
            bRv.tuI = new i(com.tencent.mm.z.c.EV());
        }
        return bRv().tuI;
    }

    public static com.tencent.mm.plugin.webview.model.d bRD() {
        if (bRv().tuJ == null) {
            f bRv = bRv();
            ar.Hg();
            bRv.tuJ = new com.tencent.mm.plugin.webview.model.d(com.tencent.mm.z.c.EV());
        }
        return bRv().tuJ;
    }

    public static af bRE() {
        if (bRv().tuK == null) {
            f bRv = bRv();
            ar.Hg();
            bRv.tuK = new af(com.tencent.mm.z.c.EV());
        }
        return bRv().tuK;
    }

    public static e bRF() {
        if (bRv().tuL == null) {
            f bRv = bRv();
            g.Dk();
            bRv.tuL = new e(g.Dj().gQj);
        }
        return bRv().tuL;
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", new Object[]{Integer.valueOf(hashCode())});
        com.tencent.mm.sdk.b.a.xef.c(this.tuU);
        com.tencent.mm.sdk.b.a.xef.c(this.tuV);
        com.tencent.mm.sdk.b.a.xef.c(this.tuW);
        com.tencent.mm.sdk.b.a.xef.c(this.tuX);
        com.tencent.mm.sdk.b.a.xef.c(this.tuS);
        com.tencent.mm.sdk.b.a.xef.c(this.bannerOnInitListener);
        com.tencent.mm.sdk.b.a.xef.c(this.tuY);
        ar.b(this.mEF);
        if (this.tuH != null) {
            ab abVar = this.tuH;
            if (abVar.tsr != null) {
                com.tencent.mm.plugin.downloader.model.f.aAd();
                com.tencent.mm.plugin.downloader.model.c.b(abVar.tsr);
            }
            if (abVar.tss != null && abVar.tss.size() > 0) {
                for (Long l : abVar.tss) {
                    x.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", new Object[]{l});
                    com.tencent.mm.plugin.downloader.model.f.aAd().bX(l.longValue());
                }
            }
        }
        if (this.tuO != null) {
            com.tencent.mm.plugin.webview.fts.e eVar = this.tuO;
            com.tencent.mm.sdk.b.a.xef.c(eVar.jeX);
            if (eVar.tmm != null) {
                ar.CG().b(1048, eVar);
                ar.CG().c(eVar.tmm);
                eVar.tmm = null;
            }
            this.tuO = null;
        }
        if (this.tuM != null) {
            com.tencent.mm.plugin.webview.fts.c cVar = this.tuM;
            com.tencent.mm.plugin.webview.fts.c.a aVar = cVar.tlQ;
            if (aVar.tlV != null) {
                ar.CG().c(aVar.tlV);
            }
            if (aVar.tlX != null) {
                aVar.tlX.kpn = true;
            }
            b bVar = cVar.tlR;
            if (bVar.tlZ != null) {
                ar.CG().b(bVar.tlZ.getType(), bVar.tlU);
            }
            if (cVar.mMa != null) {
                ((m) g.k(m.class)).cancelSearchTask(cVar.mMa);
                cVar.mMa = null;
            }
            this.tuM = null;
        }
        if (this.tuN != null) {
            j.a aVar2 = this.tuN;
            aVar2.qRk.dead();
            aVar2.tmg.dead();
            com.tencent.mm.ad.n.JQ().j(aVar2);
            this.tuN = null;
        }
        ar.getSysCmdMsgExtension().b("hijackconfig", this.kur, true);
        if (this.tuJ != null) {
            this.tuJ.bQz();
        }
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.tuQ;
        ar.getSysCmdMsgExtension().b("webcache", nVar.ttH, true);
        com.tencent.mm.sdk.b.a.xef.c(nVar.ttI);
        com.tencent.mm.sdk.b.a.xef.c(nVar.ttJ);
        q bRp = q.a.bRp();
        com.tencent.mm.sdk.b.a.xef.c(bRp.ttP);
        com.tencent.mm.sdk.b.a.xef.c(bRp.ttQ);
        bRp.release(true);
        com.tencent.mm.plugin.webview.wepkg.utils.c cVar2 = this.tuR;
        x.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
        com.tencent.mm.sdk.b.a.xef.c(cVar2.tNY);
        com.tencent.mm.sdk.b.a.xef.c(cVar2.tNZ);
        com.tencent.mm.plugin.webview.wepkg.b.a.aPV();
        com.tencent.mm.plugin.webview.wepkg.utils.d.alJ();
        this.tuT.dead();
        l bPk = l.bPk();
        l$a com_tencent_mm_plugin_webview_fts_l_a = bPk.tmQ;
        if (com_tencent_mm_plugin_webview_fts_l_a.tlV != null) {
            ar.CG().c(com_tencent_mm_plugin_webview_fts_l_a.tlV);
        }
        if (com_tencent_mm_plugin_webview_fts_l_a.tnd != null) {
            com_tencent_mm_plugin_webview_fts_l_a.tnd.kpn = true;
        }
        bPk.tmY.dead();
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new 1());
        List<com.tencent.mm.plugin.webview.modelcache.d.a> linkedList = new LinkedList();
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.a.bRi());
        linkedList.addAll(k.bRl());
        linkedList.add(h.bRi());
        for (com.tencent.mm.plugin.webview.modelcache.d.a aVar : linkedList) {
            gwY.put(Integer.valueOf(aVar.id), aVar);
        }
        gwY.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new 11());
        gwY.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new 12());
        gwY.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new 13());
        gwY.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new 14());
        gwY.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new 15());
        gwY.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new 16());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", new Object[]{Integer.valueOf(hashCode())});
        ar.Ha();
        if (((f) bp.hY("plugin.webview")) == null) {
            ar.Ha().a("plugin.webview", new f());
            x.e("MicroMsg.SubCoreTools", "getCore, should not be here:%d", new Object[]{Integer.valueOf(r0.hashCode())});
        }
        com.tencent.mm.sdk.b.a.xef.b(this.tuU);
        com.tencent.mm.sdk.b.a.xef.b(this.tuV);
        com.tencent.mm.sdk.b.a.xef.b(this.tuW);
        com.tencent.mm.sdk.b.a.xef.b(this.tuX);
        com.tencent.mm.sdk.b.a.xef.b(this.tuS);
        com.tencent.mm.sdk.b.a.xef.b(this.bannerOnInitListener);
        com.tencent.mm.sdk.b.a.xef.b(this.tuY);
        ar.getSysCmdMsgExtension().a("hijackconfig", this.kur, true);
        ar.a(this.mEF);
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.tuQ;
        com.tencent.mm.plugin.webview.modelcache.n.bRn();
        q bRp = q.a.bRp();
        com.tencent.mm.sdk.b.a.xef.b(bRp.ttP);
        com.tencent.mm.sdk.b.a.xef.b(bRp.ttQ);
        ar.getSysCmdMsgExtension().a("webcache", nVar.ttH, true);
        com.tencent.mm.sdk.b.a.xef.b(nVar.ttI);
        com.tencent.mm.sdk.b.a.xef.b(nVar.ttJ);
        com.tencent.mm.plugin.webview.wepkg.utils.c cVar = this.tuR;
        x.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        com.tencent.mm.sdk.b.a.xef.b(cVar.tNY);
        com.tencent.mm.sdk.b.a.xef.b(cVar.tNZ);
        com.tencent.mm.plugin.webview.wepkg.b.a.aPU();
        Context context = com.tencent.mm.sdk.platformtools.ac.getContext();
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("we_pkg_sp", 4);
                if (sharedPreferences == null) {
                    x.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
                } else {
                    if (sharedPreferences.getBoolean("disable_we_pkg", false)) {
                        x.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
                        sharedPreferences.edit().putBoolean("disable_we_pkg", false).commit();
                    }
                    sharedPreferences.edit().putInt("white_screen_times", 0).commit();
                }
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.WepkgListener", e.getMessage());
            }
        }
        com.tencent.mm.plugin.ae.c.qsQ.a(new al());
        this.tuT.ceO();
        com.tencent.mm.y.g.b.a(new 17(this));
        XWalkEnvironment.init(com.tencent.mm.sdk.platformtools.ac.getContext());
        g.Dh();
        XWalkEnvironment.setGrayValueByUserId(com.tencent.mm.kernel.a.Cg());
        l.bPk();
        l.start();
    }

    public final void br(boolean z) {
        com.tencent.mm.plugin.webview.modelcache.n.bRn();
    }
}
