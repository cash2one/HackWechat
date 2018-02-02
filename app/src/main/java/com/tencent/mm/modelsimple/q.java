package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.adw;
import com.tencent.mm.protocal.c.adx;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.z;
import java.util.Iterator;
import java.util.Map;

public final class q extends k implements com.tencent.mm.network.k {
    public static String hNg;
    public static String hNh;
    public static String hNi;
    public static String hNj;
    public static String hNk;
    public static String hNl;
    public static String hNm;
    public static String hNn;
    public static String hNo;
    public static String hNp;
    private static int hNq;
    private static int hNr = 0;
    private static int hNs = 22;
    private static int hNt = 0;
    private static boolean hNu = false;
    private e gJT;

    public static boolean ir(int i) {
        if (hNq == i) {
            return false;
        }
        return true;
    }

    public static int RQ() {
        return hNr;
    }

    public static boolean RR() {
        return (hNt & 2) != 0;
    }

    public static boolean RS() {
        return (hNs & 4) != 0;
    }

    public static void bT(boolean z) {
        if (z) {
            hNs |= 4;
        } else {
            hNs &= -5;
        }
    }

    public static int RT() {
        return hNq;
    }

    public static boolean RU() {
        return (hNt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0;
    }

    public static boolean RV() {
        return (hNt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    public q(int i) {
        hNq = i;
    }

    public final int getType() {
        return 526;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_adw = new adw();
        com_tencent_mm_protocal_c_adw.lOo = w.cfi();
        x.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", com_tencent_mm_protocal_c_adw.lOo);
        aVar.hmj = com_tencent_mm_protocal_c_adw;
        aVar.hmk = new adx();
        aVar.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        aVar.hmi = 526;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJT = eVar2;
        return a(eVar, aVar.JZ(), this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            adx com_tencent_mm_protocal_c_adx = (adx) ((b) qVar).hmh.hmo;
            hNr = com_tencent_mm_protocal_c_adx.wms;
            x.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", Integer.valueOf(hNr), Integer.valueOf(com_tencent_mm_protocal_c_adx.vGN));
            Map y = bi.y(com_tencent_mm_protocal_c_adx.wmr, "summary");
            int i4 = hNs;
            if (y != null) {
                int i5;
                int i6;
                hNg = (String) y.get(".summary.banner");
                x.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", Integer.valueOf(com_tencent_mm_protocal_c_adx.wmp), com_tencent_mm_protocal_c_adx.wmr);
                adw com_tencent_mm_protocal_c_adw = (adw) ((b) qVar).hmg.hmo;
                Iterator it = com_tencent_mm_protocal_c_adx.wmq.iterator();
                while (it.hasNext()) {
                    aub com_tencent_mm_protocal_c_aub = (aub) it.next();
                    if (com_tencent_mm_protocal_c_aub.vKZ.cdp().hashCode() != com_tencent_mm_protocal_c_adw.wIV.vKZ.cdp().hashCode()) {
                        Map y2 = bi.y(com_tencent_mm_protocal_c_aub.wBY, "wording");
                        x.d("MicroMsg.NetSceneGetOnlineInfo", com_tencent_mm_protocal_c_aub.wBY);
                        if (y2 != null) {
                            hNh = (String) y2.get(".wording.title");
                            hNi = (String) y2.get(".wording.notify");
                            hNj = (String) y2.get(".wording.mute_title");
                            hNk = (String) y2.get(".wording.mute_tips");
                            hNl = (String) y2.get(".wording.exit");
                            hNm = (String) y2.get(".wording.exit_confirm");
                            hNn = (String) y2.get(".wording.lock_title");
                            hNo = (String) y2.get(".wording.mute_lock_title");
                            hNp = (String) y2.get(".wording.exit");
                        }
                        i5 = com_tencent_mm_protocal_c_aub.wCa;
                        i6 = com_tencent_mm_protocal_c_adx.vGN;
                        hNt = i6;
                        if ((i6 & 2) != 0) {
                            hNu = true;
                        } else {
                            hNu = false;
                        }
                        if (i5 != hNs) {
                            hNs = i5;
                            ar.Hg();
                            c.Cu();
                        }
                    }
                }
                i5 = i4;
                i6 = com_tencent_mm_protocal_c_adx.vGN;
                hNt = i6;
                if ((i6 & 2) != 0) {
                    hNu = false;
                } else {
                    hNu = true;
                }
                if (i5 != hNs) {
                    hNs = i5;
                    ar.Hg();
                    c.Cu();
                }
            }
            if ((com_tencent_mm_protocal_c_adx.vGN & 64) != 0) {
                ar.Hg();
                af WO = c.EY().WO("filehelper");
                if (WO == null || bh.ov(WO.field_username)) {
                    z.w(WO);
                    ar.Hg();
                    WO = c.EY().WO("filehelper");
                }
                if (!(WO == null || com.tencent.mm.l.a.fZ(WO.field_type))) {
                    WO.Ag();
                    ar.Hg();
                    c.EY().a(WO.field_username, WO);
                }
                ar.Hg();
                ae WY = c.Fd().WY("filehelper");
                if (WY == null) {
                    WY = new ae("filehelper");
                    WY.aj(bh.Wp());
                    ar.Hg();
                    c.Fd().d(WY);
                } else {
                    WY.aj(bh.Wp());
                    ar.Hg();
                    c.Fd().a(WY, "filehelper");
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
