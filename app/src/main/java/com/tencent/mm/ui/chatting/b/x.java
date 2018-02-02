package com.tencent.mm.ui.chatting.b;

import android.util.Base64;
import com.tencent.mm.ag.f;
import com.tencent.mm.booter.z;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.c;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashSet;

public final class x {
    private static String yBC = "100134";
    public p fhr;
    public long kvt = 0;
    private int yBA = 0;
    private boolean yBB = false;
    public long yBD = 0;
    public boolean yBE = false;
    public String yBF = null;
    public long yBG = 0;
    public int yBH = 0;
    private HashSet<Long> yBx = new HashSet();
    private HashSet<Long> yBy = new HashSet();
    private HashSet<Long> yBz = new HashSet();

    static /* synthetic */ void a(x xVar, au auVar) {
        xVar.yBz.add(Long.valueOf(auVar.field_msgSvrId));
        d dVar = new d();
        dVar.q("20MessageID", auVar.field_msgSvrId + ",");
        dVar.q("21MessageInnerType", auVar.getType() + ",");
        dVar.q("22currChatName", auVar.field_talker + ",");
        String str = "";
        if (auVar.field_isSend == 1) {
            str = q.FS();
        } else if (!xVar.fhr.cse()) {
            str = auVar.field_talker;
        } else if (auVar.field_content != null) {
            int hO = ba.hO(auVar.field_content);
            if (hO != -1) {
                str = auVar.field_content.substring(0, hO).trim();
            }
        }
        dVar.q("23msgPostUserName", str + ",");
        a fT = a.fT(auVar.field_content);
        if (fT != null) {
            dVar.q("24AppId", fT.appId + ",");
            if (fT.fGG != null) {
                blt com_tencent_mm_protocal_c_blt = new blt();
                try {
                    com_tencent_mm_protocal_c_blt.aF(Base64.decode(fT.fGG, 0));
                } catch (Exception e) {
                }
                if (com_tencent_mm_protocal_c_blt.wPn != null) {
                    dVar.q("25SourceAppId", com_tencent_mm_protocal_c_blt.wPn.nbS + ",");
                }
            }
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingUI.StatisticImp", "appExposeReport report logbuffer(13634): " + dVar.Sz());
            g.pQN.h(13634, new Object[]{dVar});
        }
    }

    public x(p pVar) {
        this.fhr = pVar;
    }

    public final void aR(au auVar) {
        if (!this.yBx.contains(Long.valueOf(auVar.field_msgSvrId))) {
            this.yBx.add(Long.valueOf(auVar.field_msgSvrId));
            e.post(new 1(this, auVar, false), "ChattingUI.adVideoExposeReport");
        }
    }

    public final void aS(au auVar) {
        if (!this.yBy.contains(Long.valueOf(auVar.field_msgSvrId))) {
            this.yBy.add(Long.valueOf(auVar.field_msgSvrId));
            e.post(new 2(this, auVar), "ChattingUI.expExposeReport");
        }
    }

    public final void aT(au auVar) {
        if (!this.yBB) {
            this.yBB = true;
            c fn = com.tencent.mm.z.c.c.IF().fn(yBC);
            if (fn.isValid()) {
                this.yBA = t.getInt((String) fn.chI().get("needUploadData"), 0);
            }
        }
        if (this.yBA != 0 && !this.yBz.contains(Long.valueOf(auVar.field_msgSvrId))) {
            e.post(new 3(this, auVar), "ChattingUI.appExposeReport");
        }
    }

    public final void ctW() {
        z.gyU.el(this.fhr.csi().field_username);
        b.hPA.wW();
        com.tencent.mm.sdk.b.b arVar = new ar();
        arVar.foP.foQ = false;
        com.tencent.mm.sdk.b.a.xef.m(arVar);
    }

    public final void cqW() {
        if (this.fhr.csi() != null && this.fhr.csi().field_username != null) {
            int i;
            int i2;
            int i3;
            int i4;
            b.hPA.ch(this.fhr.crz());
            if (!q.FS().equals(this.fhr.crz())) {
                com.tencent.mm.sdk.b.b arVar = new ar();
                arVar.foP.foQ = true;
                com.tencent.mm.sdk.b.a.xef.m(arVar);
            }
            if ("notification_messages".equals(this.fhr.csi().field_username)) {
                i = 1;
                i2 = 8;
                i3 = 0;
            } else {
                boolean z;
                if (s.gF(this.fhr.csi().field_username)) {
                    if (this.fhr.csf()) {
                        if (this.fhr.AI()) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (this.fhr.csg()) {
                            i3 = this.fhr.cso().Ms().size();
                            i2 = 5;
                        } else {
                            i3 = 0;
                            i2 = 4;
                        }
                    } else if (f.jW(this.fhr.csi().field_username)) {
                        i = this.fhr.AI() ? 0 : 1;
                        i3 = 0;
                        i2 = 3;
                    } else if (f.jX(this.fhr.csi().field_username)) {
                        i = 1;
                        i3 = 0;
                        i2 = 0;
                    } else if (f.jT(this.fhr.csi().field_username)) {
                        z = true;
                        i = 0;
                    } else {
                        z = true;
                        i = 0;
                    }
                } else if (this.fhr.csd()) {
                    i3 = m.gl(this.fhr.csi().field_username);
                    i = this.fhr.AI() ? 0 : 1;
                    i2 = 2;
                } else if (this.fhr.AI()) {
                    i = 0;
                    z = true;
                } else {
                    i = 1;
                    z = true;
                }
                boolean z2 = z;
                i3 = 0;
            }
            if (this.fhr.csh()) {
                i4 = 0;
            } else {
                for (String equals : s.hfr) {
                    if (equals.equals(this.fhr.csi().field_username)) {
                        i2 = 0;
                    }
                }
                i4 = i2;
            }
            if (i4 != 0) {
                com.tencent.mm.z.ar.Hg();
                aj WY = com.tencent.mm.z.c.Fd().WY(this.fhr.csi().field_username);
                i2 = WY == null ? 0 : WY.field_unReadCount;
                z zVar = z.gyU;
                String str = this.fhr.csi().field_username;
                if (zVar.gze == null) {
                    zVar.gze = q.FS();
                }
                if (!zVar.gze.equals(str)) {
                    if (zVar.gyY != null) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[]{zVar.gyY.gzl});
                        zVar.el(zVar.gyY.gzl);
                    }
                    if (zVar.gyV.Dl(6) == 0) {
                        zVar.gyV.setLong(4, t.Wo());
                    }
                    com.tencent.mm.sdk.b.a.xef.a(zVar.gyW);
                    com.tencent.mm.sdk.b.a.xef.a(zVar.gyX);
                    zVar.gyY = new a(zVar);
                    zVar.gyY.gzq = zVar.gyZ;
                    zVar.gyZ = 0;
                    zVar.gyY.gzl = str;
                    zVar.gzc = t.Wq();
                    zVar.gyY.type = i4;
                    zVar.gyY.gzm = i;
                    zVar.gyY.fnm = i2;
                    zVar.gyY.gzn = i3;
                    zVar.gyY.gzo = t.Wo();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[]{str, Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        }
    }

    public final void ctX() {
        int i = 0;
        if (this.yBE) {
            long currentTimeMillis = System.currentTimeMillis() - this.yBD;
            this.yBD = 0;
            this.yBE = false;
            g gVar = g.pQN;
            long[] jArr = new long[]{0, 200, 400, 600, 800, 1000, 1500, 2000};
            while (i < 8) {
                if (currentTimeMillis < jArr[i]) {
                    break;
                } else if (i == 7) {
                    i = 8;
                    break;
                } else {
                    i++;
                }
            }
            i = -1;
            gVar.a(109, (long) i, 1, true);
        }
    }
}
