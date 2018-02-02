package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.bx.f;
import com.tencent.mm.by.h.d;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.e.a;
import com.tencent.mm.plugin.emoji.e.b;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.j.1;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.w;
import com.tencent.mm.view.SmileyPanelImpl;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public class i implements ap {
    private static HashMap<Integer, d> gwY;
    private d lxW;
    private a lxX;
    private g lxY;
    private j lxZ;
    private g lya;
    private e lyb;
    private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> lyc;
    private volatile h lyd;
    private volatile b lye;
    private volatile l lyf;
    private volatile j lyg;
    private com.tencent.mm.aq.a.a lyh;
    private c lyi;

    private static i aBx() {
        ar.Ha();
        i iVar = (i) bp.hY("plugin.emoji");
        if (iVar == null) {
            synchronized (i.class) {
                if (iVar == null) {
                    iVar = new i();
                    ar.Ha().a("plugin.emoji", iVar);
                }
            }
        }
        return iVar;
    }

    public static com.tencent.mm.aq.a.a aBe() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lyh == null) {
            com.tencent.mm.aq.a.a.b.a aVar = new com.tencent.mm.aq.a.a.b.a(ac.getContext());
            aVar.hDq = new com.tencent.mm.plugin.emoji.d.a();
            aVar.hDo = new com.tencent.mm.view.d.a();
            com.tencent.mm.aq.a.a.b PJ = aVar.PJ();
            aBx().lyh = new com.tencent.mm.aq.a.a(PJ);
        }
        return aBx().lyh;
    }

    public static d aBy() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lxW == null) {
            aBx().lxW = new d();
        }
        return aBx().lxW;
    }

    public static a aBz() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lxX == null) {
            aBx().lxX = new a();
        }
        return aBx().lxX;
    }

    public static g aBA() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lxY == null) {
            aBx().lxY = new g();
        }
        return aBx().lxY;
    }

    public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> aBB() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lyc == null) {
            aBx().lyc = new com.tencent.mm.plugin.emoji.sync.a();
        }
        return aBx().lyc;
    }

    private static synchronized h aBC() {
        h hVar;
        synchronized (i.class) {
            com.tencent.mm.kernel.g.Dh().Ct();
            if (aBx().lyd == null) {
                aBx().lyd = new h();
            }
            hVar = aBx().lyd;
        }
        return hVar;
    }

    private static b aBD() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lye == null) {
            aBx().lye = new b();
        }
        return aBx().lye;
    }

    public static l aBE() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lyf == null) {
            aBx().lyf = new l();
        }
        return aBx().lyf;
    }

    public static j aBF() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lyg == null) {
            aBx().lyg = new j();
        }
        return aBx().lyg;
    }

    public final void onAccountRelease() {
        h aBC = aBC();
        ar.getSysCmdMsgExtension().b("emotionstore", aBC.lvJ, true);
        ar.getSysCmdMsgExtension().b("NewRecommendEmotion", aBC.lvK, true);
        ar.getSysCmdMsgExtension().b("EmojiBackup", aBC.lvL, true);
        ar.getSysCmdMsgExtension().b("EmotionBackup", aBC.lvL, true);
        b aBD = aBD();
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvh);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvl);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvm);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvn);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvo);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvp);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvq);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvr);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvs);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvi);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvj);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvt);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvu);
        com.tencent.mm.sdk.b.a.xef.c(aBD.lvk);
        l aBE = aBE();
        aBE.lwL.j(aBE.lxe);
        aBE.lwM.j(aBE.lxc);
        aBE.lwN.j(aBE.lxd);
        com.tencent.mm.sdk.b.a.xef.c(aBE.lxf);
        if (l.lxa != null) {
            l.lxa.clear();
            l.lxa = null;
        }
        if (l.lxb != null) {
            l.lxb.clear();
            l.lxb = null;
        }
        aBz().clear();
        ((c) com.tencent.mm.kernel.g.k(c.class)).removeEmojiMgr();
        d aBy = aBy();
        ar.CG().b(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE, aBy);
        aBy.lxu.clear();
        aBy.lxs.clear();
        aBy.lxx.clear();
        j aBF = aBF();
        aBF.lwt = null;
        if (aBF.lwu != null) {
            aBF.lwu.clear();
        }
        BKGLoaderManager bKGLoaderManager = aBB().lzq;
        x.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
        if (bKGLoaderManager.lzN != null) {
            bKGLoaderManager.lzN.clear();
        }
        if (bKGLoaderManager.lzO != null) {
            bKGLoaderManager.lzO.clear();
        }
        if (bKGLoaderManager.lzP != null) {
            bKGLoaderManager.lzP.clear();
        }
        bKGLoaderManager.lzD = false;
        com.tencent.mm.sdk.b.a.xef.c(bKGLoaderManager.lzV);
        com.tencent.mm.sdk.b.a.xef.c(bKGLoaderManager.lzW);
        if (bKGLoaderManager.lzR != null) {
            ac.getContext().unregisterReceiver(bKGLoaderManager.lzR);
            bKGLoaderManager.lzR = null;
        }
        if (this.lxZ != null) {
            j jVar = this.lxZ;
            com.tencent.mm.sdk.b.a.xef.c(jVar.lyn);
            com.tencent.mm.sdk.b.a.xef.c(jVar.lyo);
        }
        if (this.lya != null) {
            g gVar = this.lya;
            gVar.lxH.clear();
            aBy().lxw = null;
            gVar.lxI.dead();
        }
        if (this.lyh != null) {
            this.lyh.detach();
        }
        ar.CG().b(697, aBH());
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new 7());
        gwY.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new 8());
        gwY.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new 9());
        gwY.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new 10());
        gwY.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new 11());
        gwY.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new 12());
        gwY.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return n.gJN;
            }
        });
        gwY.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new 14());
        gwY.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new 2());
        gwY.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new 3());
        gwY.put(Integer.valueOf("DELETE".hashCode()), new 4());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        e.vro = new e.b(this) {
            final /* synthetic */ i lyj;

            {
                this.lyj = r1;
            }

            public final ChatFooterPanel cv(Context context) {
                return new SmileyPanelImpl(context);
            }
        };
        e.vrp = new 6(this);
        ((c) com.tencent.mm.kernel.g.k(c.class)).setEmojiMgr();
        h aBC = aBC();
        ar.getSysCmdMsgExtension().a("emotionstore", aBC.lvJ, true);
        ar.getSysCmdMsgExtension().a("NewRecommendEmotion", aBC.lvK, true);
        ar.getSysCmdMsgExtension().a("EmojiBackup", aBC.lvL, true);
        ar.getSysCmdMsgExtension().a("EmotionBackup", aBC.lvL, true);
        b aBD = aBD();
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvh);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvl);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvm);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvn);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvo);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvp);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvq);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvr);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvs);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvi);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvj);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvt);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvu);
        com.tencent.mm.sdk.b.a.xef.b(aBD.lvk);
        l aBE = aBE();
        aBE.lwL.c(aBE.lxe);
        aBE.lwM.c(aBE.lxc);
        aBE.lwN.c(aBE.lxd);
        com.tencent.mm.sdk.b.a.xef.b(aBE.lxf);
        aBz();
        j aBF = aBF();
        String value = com.tencent.mm.k.g.zY().getValue("EmotionRewardTipsLimit");
        if (!bh.ov(value)) {
            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[]{value});
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                aBF.lwr = bh.getInt(split[0], 0) == 0 ? 863913600000L : ((long) bh.getInt(split[0], 0)) * 86400000;
                aBF.lws = bh.getInt(split[1], 20) - 1;
                aBF.kFr = bh.getInt(split[2], 80) - 1;
            }
        }
        boolean aBl = com.tencent.mm.plugin.emoji.e.n.aBl();
        ar.Hg();
        boolean z2 = aBl && ((Boolean) com.tencent.mm.z.c.CU().get(w.a.xnv, Boolean.valueOf(true))).booleanValue();
        aBF.lwq = z2;
        x.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[]{Boolean.valueOf(aBF.lwq), Boolean.valueOf(aBl), Boolean.valueOf(r4)});
        ar.Dm().F(new 1(aBF));
        BKGLoaderManager bKGLoaderManager = aBB().lzq;
        x.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
        com.tencent.mm.sdk.b.a.xef.b(bKGLoaderManager.lzV);
        com.tencent.mm.sdk.b.a.xef.b(bKGLoaderManager.lzW);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        bKGLoaderManager.lzR = new ConnectivityReceiver(bKGLoaderManager);
        ac.getContext().registerReceiver(bKGLoaderManager.lzR, intentFilter);
        x.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
        aBE().aBj();
        this.lxZ = new j();
        this.lya = new g();
        com.tencent.mm.ak.a.bL(z);
        ar.CG().a(697, aBH());
        int chf = f.chd().chf();
        int anl = com.tencent.mm.bx.e.chc().anl();
        if (chf < 0) {
            ar.Hg();
            if (((Integer) com.tencent.mm.z.c.CU().get(w.a.xny, Integer.valueOf(0))).intValue() > 0) {
                com.tencent.mm.pluginsdk.i.a.b.b.c.bZm().e(37, 1, -1, false);
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xny, Integer.valueOf(0));
                ar.CG().a(new m(37), 0);
                com.tencent.mm.plugin.report.service.g.pQN.a(165, 10, 1, false);
            }
        }
        if (anl < 0) {
            ar.Hg();
            if (((Integer) com.tencent.mm.z.c.CU().get(w.a.xnz, Integer.valueOf(0))).intValue() > 0) {
                com.tencent.mm.pluginsdk.i.a.b.b.c.bZm().e(37, 2, -1, false);
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xnz, Integer.valueOf(0));
                ar.CG().a(new m(37), 0);
                com.tencent.mm.plugin.report.service.g.pQN.a(165, 11, 1, false);
            }
        }
    }

    public final void br(boolean z) {
    }

    public static e aBG() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lyb == null) {
            aBx().lyb = new e();
        }
        return aBx().lyb;
    }

    public static c aBH() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aBx().lyi == null) {
            aBx().lyi = new c();
        }
        return aBx().lyi;
    }
}
