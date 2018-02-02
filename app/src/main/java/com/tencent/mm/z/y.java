package com.tencent.mm.z;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aq;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;

public final class y {
    public static void a(bpb com_tencent_mm_protocal_c_bpb, boolean z) {
        int i = com_tencent_mm_protocal_c_bpb.wRp;
        String str = "MicroMsg.HandleAuthResponse";
        String str2 = "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_bpb.wRq == null ? -1 : com_tencent_mm_protocal_c_bpb.wRq.vJn);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = com_tencent_mm_protocal_c_bpb.wRq;
        objArr[3] = com_tencent_mm_protocal_c_bpb.wRr;
        objArr[4] = com_tencent_mm_protocal_c_bpb.wRs;
        objArr[5] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        int i2 = 0;
        if ((i & 1) == 0 || com_tencent_mm_protocal_c_bpb.wRq == null) {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
        } else {
            i2 = com_tencent_mm_protocal_c_bpb.wRq.lOd;
        }
        g.Dk();
        g.gC(i2);
        t CU = g.Dj().CU();
        CU.set(256, Boolean.valueOf(false));
        if ((i & 1) != 0) {
            if (com_tencent_mm_protocal_c_bpb.wRq.vJn > 0) {
                CU.a(a.xmL, Long.valueOf((long) com_tencent_mm_protocal_c_bpb.wRq.vJn));
                CU.a(a.xmN, Long.valueOf(bh.Wo()));
                CU.a(a.xmM, Long.valueOf((long) d.vAz));
                x.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bpb.wRq.vJn), Boolean.valueOf(z)});
                if (z) {
                    long j;
                    com.tencent.mm.plugin.report.d dVar = com.tencent.mm.plugin.report.d.pPH;
                    if (com_tencent_mm_protocal_c_bpb.wRq.vJn == 2) {
                        j = 19;
                    } else {
                        j = 41;
                    }
                    dVar.a(148, j, 1, true);
                } else {
                    com.tencent.mm.plugin.report.d.pPH.a(148, com_tencent_mm_protocal_c_bpb.wRq.vJn == 2 ? 10 : 11, 1, true);
                }
            } else {
                CU.a(a.xmL, Long.valueOf((long) com_tencent_mm_protocal_c_bpb.wRq.vJn));
                CU.a(a.xmN, Long.valueOf(bh.Wo()));
                CU.a(a.xmM, Long.valueOf(0));
            }
        }
        if ((i & 2) != 0) {
            aq aqVar = com_tencent_mm_protocal_c_bpb.wRr;
            x.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[]{o.getString(aqVar.vFr), Integer.valueOf(aqVar.ktm), aqVar.ksU, aqVar.kub, aqVar.vFs, aqVar.vFt, aqVar.hvy, Integer.valueOf(aqVar.vFu), Integer.valueOf(aqVar.vFv), aqVar.vFw, Integer.valueOf(aqVar.vFx), aqVar.vFy, aqVar.vFy, Integer.valueOf(aqVar.vFA), aqVar.vFB});
            if (!z) {
                CU.set(52, Integer.valueOf(aqVar.vFv));
            }
            CU.set(9, Integer.valueOf(aqVar.vFr));
            CU.set(7, Integer.valueOf(aqVar.ktm));
            CU.set(2, aqVar.ksU);
            CU.set(4, aqVar.kub);
            CU.set(5, aqVar.vFs);
            CU.set(6, aqVar.vFt);
            CU.set(42, aqVar.hvy);
            CU.set(34, Integer.valueOf(aqVar.vFu));
            g.Dj().CV().XJ(aqVar.vFw);
            CU.set(64, Integer.valueOf(aqVar.vFx));
            CU.set(21, aqVar.vFy);
            CU.set(22, aqVar.vFy);
            CU.set(17, Integer.valueOf(aqVar.vFA));
            aq.hfP.S("login_weixin_username", aqVar.ksU);
            aq.hfP.S("last_login_nick_name", aqVar.kub);
            aq.hfP.c(aqVar.vFt, aqVar.vFr, aqVar.vFs);
        } else {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
        }
        boolean z2 = false;
        if ((i & 1) != 0) {
            boolean a;
            dv dvVar = com_tencent_mm_protocal_c_bpb.wRq;
            String str3 = dvVar.vJh;
            String by = bh.by(n.a(dvVar.vJi));
            x.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[]{dvVar.vJl, Integer.valueOf(dvVar.vJm), Integer.valueOf(dvVar.vJn), Integer.valueOf(dvVar.vJo), bh.VT(str3), bh.VT(by), dvVar.vFB});
            int i3 = dvVar.vJb;
            o oVar = new o(bh.e((Integer) CU.get(9, Integer.valueOf(0))));
            str = "MicroMsg.HandleAuthResponse";
            str2 = "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = oVar;
            if (dvVar.vJc == null) {
                i2 = -1;
            } else {
                i2 = dvVar.vJc.wJB;
            }
            objArr[2] = Integer.valueOf(i2);
            x.i(str, str2, objArr);
            if (i3 != 0) {
                if (i3 == 1) {
                    com.tencent.mm.plugin.report.d.pPH.a(148, 20, 1, false);
                    a = g.Dh().Cq().a(oVar.longValue(), n.a(dvVar.vJc));
                    x.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[]{Integer.valueOf(r3.length)});
                    str = bh.by(g.Dh().Cq().aQ(oVar.longValue()));
                    CU.set(-1535680990, str3);
                    CU.set(46, by);
                    CU.set(72, str);
                    CU.set(29, dvVar.vFB);
                } else if (i3 == 2) {
                    com.tencent.mm.plugin.report.d.pPH.a(148, 21, 1, false);
                    g.Dh().Cq().aR(oVar.longValue());
                    String by2 = bh.by(g.Dh().Cq().aQ(oVar.longValue()));
                    CU.set(-1535680990, str3);
                    CU.set(46, by);
                    CU.set(72, by2);
                    CU.set(29, dvVar.vFB);
                    a = false;
                } else {
                    x.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[]{Integer.valueOf(i3)});
                }
                x.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[]{Integer.valueOf(i3)});
                if (dvVar.vJd != null) {
                    str = bh.by(n.a(dvVar.vJd.vMG));
                    if (str != null && str.length() > 0) {
                        CU.set(47, str);
                        g.Dj().gQd.set(18, str);
                    }
                    x.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[]{bh.VT(str)});
                }
                z2 = a;
            }
            a = false;
            x.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[]{Integer.valueOf(i3)});
            if (dvVar.vJd != null) {
                str = bh.by(n.a(dvVar.vJd.vMG));
                CU.set(47, str);
                g.Dj().gQd.set(18, str);
                x.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[]{bh.VT(str)});
            }
            z2 = a;
        } else {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
            com.tencent.mm.plugin.report.d.pPH.a(148, 22, 1, false);
        }
        if ((i & 4) != 0) {
            com.tencent.mm.plugin.report.d.pPH.a(148, 23, 1, false);
            asy com_tencent_mm_protocal_c_asy = com_tencent_mm_protocal_c_bpb.wRs;
            as.a(false, com_tencent_mm_protocal_c_asy.vMr, com_tencent_mm_protocal_c_asy.vMs, com_tencent_mm_protocal_c_asy.vMq);
        } else {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
        }
        if (z) {
            int i4 = 4;
            by2 = q.FS();
            if (z2) {
                i4 = 1;
                by2 = q.FR();
            }
            x.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[]{Integer.valueOf(i4)});
            com.tencent.mm.plugin.report.b.d.n(1, i4, by2);
        }
        CU.set(3, "");
        CU.set(19, "");
        CU.lH(true);
        g.Dj().gQd.setInt(46, 0);
        a.EQ();
    }
}
