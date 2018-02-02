package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import com.tencent.mm.by.h.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs;
import java.util.HashMap;
import java.util.Map;

public final class i implements ap {
    private static i nCV = null;
    private static HashMap<Integer, d> nDo;
    private g nCW = new g();
    private a nCX = new a();
    private b nCY = new b();
    private com.tencent.mm.plugin.ipcall.a.b.b nCZ = new com.tencent.mm.plugin.ipcall.a.b.b();
    private f nDa = new f();
    private c nDb = new c();
    private com.tencent.mm.plugin.ipcall.a.g.d nDc;
    private l nDd;
    private j nDe;
    private h nDf;
    private com.tencent.mm.plugin.voip.video.h nDg;
    private com.tencent.mm.plugin.voip.video.d nDh;
    private Context nDi;
    private long nDj;
    private com.tencent.mm.sdk.b.c nDk = new 1(this);
    private com.tencent.mm.sdk.b.c nDl = new 4(this);
    private com.tencent.mm.sdk.b.c nDm = new 5(this);
    private com.tencent.mm.sdk.b.c nDn = new 6(this);
    private bs.a nDp = new 11(this);
    private bs.a nDq = new bs.a(this) {
        final /* synthetic */ i nDs;

        {
            this.nDs = r1;
        }

        public final void a(com.tencent.mm.ae.d.a aVar) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
            bw bwVar = aVar.hmq;
            String a = n.a(aVar.hmq.vGZ);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            if (y == null) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
                return;
            }
            int i;
            h aTG = i.aTG();
            long j = (long) bwVar.vGW;
            if (y != null) {
                com.tencent.mm.sdk.e.c gVar = new g();
                gVar.field_svrId = j;
                gVar.field_title = (String) y.get(".sysmsg.WeChatOutMsg.Title");
                if (gVar.field_title == null) {
                    gVar.field_title = "";
                }
                gVar.field_content = (String) y.get(".sysmsg.WeChatOutMsg.Content");
                if (gVar.field_content == null) {
                    gVar.field_content = "";
                }
                int i2 = bh.getInt((String) y.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                gVar.field_msgType = i2;
                gVar.field_pushTime = bh.getLong((String) y.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                gVar.field_descUrl = (String) y.get(".sysmsg.WeChatOutMsg.DescUrl");
                if (gVar.field_descUrl == null) {
                    gVar.field_descUrl = "";
                }
                x.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[]{gVar.field_svrId, gVar.field_title, gVar.field_content, gVar.field_msgType, gVar.field_pushTime, gVar.field_descUrl});
                aTG.b(gVar);
                i = i2;
            } else {
                i = -1;
            }
            if (i != -1) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xpx, Integer.valueOf(i));
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xpw, Boolean.valueOf(true));
            com.tencent.mm.plugin.report.service.g.pQN.h(13254, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1)});
        }
    };
    private bs.a nDr = new 3(this);

    static {
        HashMap hashMap = new HashMap();
        nDo = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new 7());
        nDo.put(Integer.valueOf("IPCallRecord".hashCode()), new 8());
        nDo.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new d() {
            public final String[] wg() {
                return j.gJN;
            }
        });
        nDo.put(Integer.valueOf("IPCallMsg".hashCode()), new 10());
    }

    public static i aTw() {
        if (nCV == null) {
            nCV = new i();
            ar.Ha().a("plugin.ipcall", nCV);
        }
        return nCV;
    }

    public static g aTx() {
        return aTw().nCW;
    }

    public static a aTy() {
        return aTw().nCX;
    }

    public static b aTz() {
        return aTw().nCY;
    }

    public static com.tencent.mm.plugin.ipcall.a.b.b aTA() {
        return aTw().nCZ;
    }

    public static f aTB() {
        return aTw().nDa;
    }

    public static c aTC() {
        return aTw().nDb;
    }

    public static com.tencent.mm.plugin.ipcall.a.g.d aTD() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aTw().nDc == null) {
            i aTw = aTw();
            ar.Hg();
            aTw.nDc = new com.tencent.mm.plugin.ipcall.a.g.d(com.tencent.mm.z.c.EV());
        }
        return aTw().nDc;
    }

    public static l aTE() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aTw().nDd == null) {
            i aTw = aTw();
            ar.Hg();
            aTw.nDd = new l(com.tencent.mm.z.c.EV());
        }
        return aTw().nDd;
    }

    public static j aTF() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aTw().nDe == null) {
            i aTw = aTw();
            ar.Hg();
            aTw.nDe = new j(com.tencent.mm.z.c.EV());
        }
        return aTw().nDe;
    }

    public static h aTG() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aTw().nDf == null) {
            i aTw = aTw();
            ar.Hg();
            aTw.nDf = new h(com.tencent.mm.z.c.EV());
        }
        return aTw().nDf;
    }

    public static com.tencent.mm.plugin.voip.video.h aTH() {
        if (aTw().nDg == null) {
            aTw().nDg = new com.tencent.mm.plugin.voip.video.h(ac.getContext());
        }
        return aTw().nDg;
    }

    public static com.tencent.mm.plugin.voip.video.d aTI() {
        if (aTw().nDh == null) {
            aTw().nDh = new com.tencent.mm.plugin.voip.video.d(ac.getContext());
        }
        return aTw().nDh;
    }

    public final HashMap<Integer, d> Bn() {
        return nDo;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        Object obj = this.nCW;
        obj.nCH.init();
        obj.nCI.init();
        obj.nCJ.init();
        obj.nCK.init();
        obj.nCL.init();
        obj.nCM.init();
        obj.nCN.init();
        obj.nCO.init();
        obj.nCH.nDt = obj;
        obj.nCJ.nDt = obj;
        obj.nCK.nDt = obj;
        obj.nCM.nDt = obj;
        obj.nCO.nDt = obj;
        obj.nCI.nDv = obj;
        obj.nCL.nDv = obj;
        ar.a(obj.nCS);
        b.init();
        com.tencent.mm.sdk.b.a.xef.b(d.aTn().nCu);
        com.tencent.mm.sdk.b.a.xef.b(e.aTq().ikK);
        ar.getSysCmdMsgExtension().a("WeChatOut", this.nDp, true);
        ar.getSysCmdMsgExtension().a("WeChatOutMsg", this.nDq, true);
        ar.getSysCmdMsgExtension().a("WCONotify", this.nDr, true);
        com.tencent.mm.sdk.b.a.xef.b(this.nDk);
        com.tencent.mm.sdk.b.a.xef.b(this.nDl);
        com.tencent.mm.sdk.b.a.xef.b(this.nDm);
        com.tencent.mm.sdk.b.a.xef.b(this.nDn);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.nDa.aTr()) {
            this.nDb.cI(0, 0);
        }
        g gVar = this.nCW;
        gVar.nCH.destroy();
        gVar.nCI.destroy();
        gVar.nCJ.destroy();
        gVar.nCK.destroy();
        gVar.nCL.destroy();
        gVar.nCN.destroy();
        ar.b(gVar.nCS);
        b.release();
        Object aTn = d.aTn();
        ar.CG().b(JsApiGetBackgroundAudioState.CTRL_INDEX, aTn);
        ar.CG().b(JsApiSetBackgroundAudioState.CTRL_INDEX, aTn);
        com.tencent.mm.sdk.b.a.xef.c(aTn.nCu);
        com.tencent.mm.sdk.b.a.xef.c(e.aTq().ikK);
        ar.getSysCmdMsgExtension().b("WeChatOut", this.nDp, true);
        ar.getSysCmdMsgExtension().b("WeChatOutMsg", this.nDq, true);
        ar.getSysCmdMsgExtension().b("WCONotify", this.nDr, true);
        com.tencent.mm.sdk.b.a.xef.c(this.nDk);
        com.tencent.mm.sdk.b.a.xef.c(this.nDl);
        com.tencent.mm.sdk.b.a.xef.c(this.nDm);
        com.tencent.mm.sdk.b.a.xef.c(this.nDn);
    }
}
