package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vs;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class h {
    private static final SimpleDateFormat pIX = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean a(Context context, cf cfVar, String str, List<au> list, boolean z, boolean z2) {
        if (list == null || list.isEmpty() || context == null) {
            x.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            cfVar.fqp.fqv = R.l.efh;
            return false;
        }
        boolean eE = f.eE(str);
        au auVar;
        if (list.size() != 1 || z2) {
            cfVar.fqp.fqr = new ve();
            cfVar.fqp.fqs = new vs();
            if (context != null) {
                if (eE) {
                    if (e.kn(e.ba(((au) list.get(0)).field_bizChatId))) {
                        cfVar.fqp.fqr.Ug(context.getString(R.l.eCA));
                    } else {
                        if (e.kq(str) != null) {
                            cfVar.fqp.fqr.Ug(context.getString(R.l.egi, new Object[]{r1.field_userName, e.ko(r0)}));
                        }
                    }
                } else if (s.eV(str)) {
                    cfVar.fqp.fqr.Ug(context.getString(R.l.eCA));
                } else {
                    if (q.FU().equals(r.gt(str))) {
                        cfVar.fqp.fqr.Ug(context.getString(R.l.egj, new Object[]{r0}));
                    } else {
                        cfVar.fqp.fqr.Ug(context.getString(R.l.egi, new Object[]{q.FU(), r.gt(str)}));
                    }
                }
                x.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[]{cfVar.fqp.fqr.title});
            }
            cfVar.fqp.fqr.a(Rt(str));
            cfVar.fqp.type = 14;
            int i = 0;
            boolean z3 = true;
            for (au auVar2 : list) {
                if (a(context, cfVar, auVar2, z)) {
                    i = 1;
                } else {
                    z3 = false;
                }
            }
            if (i == 0 || cfVar.fqp.fqv <= 0) {
                return z3;
            }
            cfVar.fqp.fqv = 0;
            return z3;
        }
        auVar2 = (au) list.get(0);
        if (!auVar2.ciV()) {
            return f.a(cfVar, auVar2);
        }
        l vL = ((a) g.h(a.class)).vL(auVar2.field_content);
        if (vL.hdX != null && vL.hdX.size() == 1) {
            return f.a(cfVar, auVar2);
        }
        cfVar.fqp.fqr = new ve();
        cfVar.fqp.fqs = new vs();
        cfVar.fqp.fqr.a(Rt(str));
        cfVar.fqp.type = 14;
        return a(context, cfVar, auVar2, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(Context context, cf cfVar, au auVar, boolean z) {
        boolean z2 = false;
        boolean z3 = true;
        if (cfVar == null || auVar == null) {
            x.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
            if (cfVar == null) {
                return false;
            }
            cfVar.fqp.fqv = R.l.efh;
            return false;
        }
        au ae = au.ae(auVar);
        uq uqVar;
        vs vsVar;
        if (ae.cjg()) {
            ur urVar = new ur();
            urVar.c(Y(ae));
            uqVar = new uq();
            uqVar.TI(Z(ae));
            uqVar.CJ(1);
            if (ae.cjw()) {
                uqVar.Tr(ae.field_content + "\n\n" + ae.field_transContent);
            } else {
                uqVar.Tr(ae.field_content);
            }
            uqVar.lt(true);
            uqVar.ls(true);
            uqVar.a(urVar);
            uqVar.TL(a(urVar.wdX));
            uqVar.TM(b(urVar.wdX));
            cfVar.fqp.fqr.weU.add(uqVar);
            vsVar = cfVar.fqp.fqs;
            vsVar.wfk++;
            z2 = true;
        } else if (ae.ciW()) {
            r3 = new ur();
            r3.c(Y(ae));
            r5 = new uq();
            r5.TI(Z(ae));
            r5.CJ(3);
            if (z) {
                r5.lt(true);
                r5.ls(true);
            } else {
                if (s.ha(ae.field_talker)) {
                    r0 = ae.field_imgPath;
                    ar.Hg();
                    r0 = i.a(c.Fn(), "recbiz_", r0, ".rec", 2);
                    if (bh.ov(r0)) {
                        r0 = null;
                    } else {
                        new File(r0).exists();
                    }
                    r5.TE(r0);
                } else {
                    r5.TE(com.tencent.mm.modelvoice.q.getFullPath(ae.field_imgPath));
                }
                r5.lt(true);
                b nT = com.tencent.mm.modelvoice.q.nT(ae.field_imgPath);
                if (nT == null) {
                    r0 = false;
                    z2 = r0;
                } else {
                    r5.TA(f.BA(nT.getFormat()));
                    r5.CI((int) new n(ae.field_content).time);
                }
            }
            r5.a(r3);
            r5.TL(a(r3.wdX));
            r5.TM(b(r3.wdX));
            cfVar.fqp.fqr.weU.add(r5);
            vsVar = cfVar.fqp.fqs;
            vsVar.wfm++;
            r0 = true;
            z2 = r0;
        } else if (ae.aNe()) {
            z2 = b(cfVar, ae);
        } else if (ae.cje()) {
            com.tencent.mm.aq.e eVar = null;
            if (ae.field_msgId > 0) {
                eVar = o.Pw().bi((long) ((int) ae.field_msgId));
            }
            if ((eVar == null || eVar.hzP <= 0) && ae.field_msgSvrId > 0) {
                eVar = o.Pw().bh(ae.field_msgSvrId);
            }
            if (eVar == null) {
                x.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
                cfVar.fqp.fqv = R.l.efn;
            } else {
                r3 = new ur();
                r3.c(Y(ae));
                r5 = new uq();
                r5.TI(Z(ae));
                r5.CJ(2);
                r5.TE(o.Pw().m(com.tencent.mm.aq.f.c(eVar), "", ""));
                if (eVar.Pe()) {
                    com.tencent.mm.aq.e hQ = o.Pw().hQ(eVar.hzZ);
                    if (hQ.hlp > hQ.offset) {
                        r5.TE(o.Pw().m("SERVERID://" + ae.field_msgSvrId, "", ""));
                    }
                }
                r5.TF(o.Pw().B(ae.field_imgPath, true));
                r5.a(r3);
                r5.TL(a(r3.wdX));
                r5.TM(b(r3.wdX));
                r5.fy(ae.field_msgId);
                if (z) {
                    boolean z4;
                    if (eVar.Pe() && eVar.hlp == 0) {
                        eVar = o.Pw().hQ(eVar.hzZ);
                    }
                    if (ae.field_isSend == 1) {
                        z4 = eVar.Pe();
                    } else if (eVar.Pe()) {
                        z4 = com.tencent.mm.a.e.bO(o.Pw().m(com.tencent.mm.aq.f.a(eVar).hzQ, "", ""));
                    } else {
                        z4 = false;
                    }
                    Map y = bi.y(eVar.hAa, "msg");
                    if (y == null) {
                        x.i("MicroMsg.GetFavRecordDataSource", "parse cdnInfo failed. [%s]", new Object[]{eVar.hAa});
                    } else if (z4) {
                        r5.Tu((String) y.get(".msg.img.$cdnbigimgurl"));
                        r5.fw((long) bh.getInt((String) y.get(".msg.img.$length"), 0));
                        r5.Tv((String) y.get(".msg.img.$aeskey"));
                    }
                }
                cfVar.fqp.fqr.weU.add(r5);
                vsVar = cfVar.fqp.fqs;
                vsVar.wfl++;
                z2 = true;
            }
        } else if (ae.cjh()) {
            z2 = a(cfVar, ae, z);
        } else if (ae.cji()) {
            z2 = a(cfVar, ae, z);
        } else if (z && ae.getType() == 318767153) {
            return a(context, cfVar, ae, 3);
        } else {
            if (ae.ciV()) {
                z2 = c(cfVar, ae);
            } else if (z && (ae.cjj() || ae.cjk())) {
                z2 = a(context, cfVar, ae, 1);
            } else if (z && ae.getType() == 419430449) {
                z2 = a(context, cfVar, ae, 2);
            } else if (ae.cjf()) {
                Object a;
                ar.Hg();
                au.a EK = c.Fa().EK(ae.field_content);
                ur urVar2 = new ur();
                urVar2.c(Y(ae));
                if (EK == null || !s.gM(EK.tmE)) {
                    a = a(ae, context.getString(R.l.dFp), urVar2);
                } else {
                    a = new uq();
                    a.TI(Z(ae));
                    a.CJ(16);
                    a.Tr(ae.field_content);
                    a.lt(true);
                    a.ls(true);
                    a.a(urVar2);
                    a.TL(a(urVar2.wdX));
                    a.TM(b(urVar2.wdX));
                }
                cfVar.fqp.fqr.weU.add(a);
                vsVar = cfVar.fqp.fqs;
                vsVar.wfy++;
                z2 = true;
            } else if (!ae.aNc()) {
                cfVar.fqp.fqv = R.l.efp;
                if (z) {
                    z2 = a(context, cfVar, ae, 3);
                }
            } else if (ae.cjk()) {
                cfVar.fqp.fqv = R.l.efp;
            } else {
                r3 = new ur();
                r3.c(Y(ae));
                r0 = ae.field_content;
                if (r0 == null) {
                    cfVar.fqp.fqv = R.l.efq;
                    z3 = false;
                } else {
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(r0);
                    if (fT == null) {
                        cfVar.fqp.fqv = R.l.efq;
                        z3 = false;
                    } else {
                        r3.wdX.TW(fT.appId);
                        r3.wdX.TY(fT.fGz);
                        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, true);
                        if (aZ == null || !aZ.Yz() || !z) {
                            uq uqVar2;
                            com.tencent.mm.pluginsdk.model.app.b Rz;
                            vd vdVar;
                            switch (fT.type) {
                                case 1:
                                    uqVar2 = new uq();
                                    uqVar2.TI(Z(ae));
                                    uqVar2.CJ(1);
                                    uqVar2.Tr(fT.title);
                                    uqVar2.lt(true);
                                    uqVar2.ls(true);
                                    uqVar2.a(r3);
                                    uqVar2.TL(a(r3.wdX));
                                    uqVar2.TM(b(r3.wdX));
                                    cfVar.fqp.fqr.weU.add(uqVar2);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wfk++;
                                    break;
                                case 2:
                                    ar.Hg();
                                    if (!c.isSDCardAvailable()) {
                                        cfVar.fqp.fqv = R.l.efw;
                                        z3 = false;
                                        break;
                                    }
                                    Rz = an.aqd().Rz(fT.fny);
                                    uqVar = new uq();
                                    uqVar.TI(Z(ae));
                                    if (Rz != null) {
                                        uqVar.TE(Rz.field_fileFullPath);
                                    }
                                    r0 = o.Pw().B(ae.field_imgPath, true);
                                    if (com.tencent.mm.a.e.bO(r0)) {
                                        uqVar.TF(r0);
                                    }
                                    uqVar.CJ(2);
                                    uqVar.Tq(fT.title);
                                    uqVar.Tr(fT.description);
                                    uqVar.a(r3);
                                    uqVar.TL(a(r3.wdX));
                                    uqVar.TM(b(r3.wdX));
                                    uqVar.fy(ae.field_msgId);
                                    cfVar.fqp.fqr.weU.add(uqVar);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wfl++;
                                    break;
                                case 3:
                                    uqVar2 = a(ae, fT, 7);
                                    uqVar2.a(r3);
                                    uqVar2.TL(a(r3.wdX));
                                    uqVar2.TM(b(r3.wdX));
                                    cfVar.fqp.fqr.weU.add(uqVar2);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wfq++;
                                    break;
                                case 4:
                                    uqVar2 = a(ae, fT, 4);
                                    uqVar2.a(r3);
                                    uqVar2.TL(a(r3.wdX));
                                    uqVar2.TM(b(r3.wdX));
                                    uqVar2.fy(ae.field_msgId);
                                    cfVar.fqp.fqr.weU.add(uqVar2);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wfn++;
                                    break;
                                case 5:
                                    if (fT.url != null && !fT.url.equals("")) {
                                        r3.wdX.TX(fT.url);
                                        uqVar2 = a(ae, fT, 5);
                                        uqVar2.a(r3);
                                        uqVar2.TL(a(r3.wdX));
                                        uqVar2.TM(b(r3.wdX));
                                        vt vtVar = new vt();
                                        if (!bh.ov(fT.title)) {
                                            vtVar.Uv(fT.title);
                                        }
                                        if (!bh.ov(fT.description)) {
                                            vtVar.Uw(fT.description);
                                        }
                                        if (!bh.ov(fT.thumburl)) {
                                            vtVar.Uy(fT.thumburl);
                                        }
                                        if (!bh.ov(fT.canvasPageXml)) {
                                            vtVar.Uz(fT.canvasPageXml);
                                        }
                                        if (vtVar.bke() > 0) {
                                            vtVar.CT(1);
                                            r3.a(vtVar);
                                        }
                                        cfVar.fqp.fqr.weU.add(uqVar2);
                                        vsVar = cfVar.fqp.fqs;
                                        vsVar.wfo++;
                                        break;
                                    }
                                    cfVar.fqp.fqv = R.l.efl;
                                    if (!z) {
                                        z3 = false;
                                        break;
                                    }
                                    cfVar.fqp.fqr.weU.add(a(ae, context.getString(R.l.dGJ), r3));
                                    break;
                                case 6:
                                    ar.Hg();
                                    if (!c.isSDCardAvailable()) {
                                        cfVar.fqp.fqv = R.l.efw;
                                        z3 = false;
                                        break;
                                    }
                                    Rz = an.aqd().Rz(fT.fny);
                                    uqVar = new uq();
                                    if (Rz != null) {
                                        uqVar.TE(Rz.field_fileFullPath);
                                    }
                                    uqVar.TI(Z(ae));
                                    uqVar.CJ(8);
                                    uqVar.TA(fT.hbc);
                                    r0 = o.Pw().B(ae.field_imgPath, true);
                                    if (bh.ov(r0)) {
                                        uqVar.lt(true);
                                    }
                                    if (com.tencent.mm.a.e.bO(r0)) {
                                        uqVar.TF(r0);
                                    }
                                    uqVar.Tq(fT.title);
                                    uqVar.Tr(fT.description);
                                    uqVar.a(r3);
                                    uqVar.TL(a(r3.wdX));
                                    uqVar.TM(b(r3.wdX));
                                    uqVar.fy(ae.field_msgId);
                                    if (z) {
                                        uqVar.Tu(fT.hbi);
                                        uqVar.Tv(fT.hbp);
                                    }
                                    cfVar.fqp.fqr.weU.add(uqVar);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wfr++;
                                    break;
                                case 7:
                                    if (fT.fny != null && fT.fny.length() != 0) {
                                        ar.Hg();
                                        if (!c.isSDCardAvailable()) {
                                            cfVar.fqp.fqv = R.l.efw;
                                            z3 = false;
                                            break;
                                        }
                                    }
                                    cfVar.fqp.fqv = R.l.efi;
                                    cfVar.fqp.fqv = R.l.efp;
                                    z3 = false;
                                    break;
                                case 10:
                                    vdVar = new vd();
                                    vdVar.Ub(fT.title);
                                    vdVar.Uc(fT.description);
                                    vdVar.CP(fT.hbw);
                                    vdVar.Ue(fT.hbx);
                                    vdVar.Ud(fT.thumburl);
                                    r3.a(vdVar);
                                    uqVar2 = new uq();
                                    uqVar2.TI(Z(ae));
                                    uqVar2.CJ(10);
                                    uqVar2.lt(true);
                                    uqVar2.ls(true);
                                    uqVar2.a(r3);
                                    uqVar2.TL(a(r3.wdX));
                                    uqVar2.TM(b(r3.wdX));
                                    cfVar.fqp.fqr.weU.add(uqVar2);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wft++;
                                    break;
                                case 13:
                                    vdVar = new vd();
                                    vdVar.Ub(fT.title);
                                    vdVar.Uc(fT.description);
                                    vdVar.CP(fT.hbC);
                                    vdVar.Ue(fT.hbD);
                                    vdVar.Ud(fT.thumburl);
                                    r3.a(vdVar);
                                    uqVar2 = new uq();
                                    uqVar2.TI(Z(ae));
                                    uqVar2.CJ(11);
                                    uqVar2.lt(true);
                                    uqVar2.ls(true);
                                    uqVar2.a(r3);
                                    uqVar2.TL(a(r3.wdX));
                                    uqVar2.TM(b(r3.wdX));
                                    cfVar.fqp.fqr.weU.add(uqVar2);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wfu++;
                                    break;
                                case 16:
                                    if (z) {
                                        cfVar.fqp.fqr.weU.add(a(ae, context.getString(R.l.dGn), r3));
                                        break;
                                    }
                                case 19:
                                    r0 = fT.hbB != null && fT.hbB.contains("<recordxml>");
                                    if (!r0) {
                                        uq uqVar3 = new uq();
                                        uqVar3.TI(Z(ae));
                                        uqVar3.CJ(17);
                                        uqVar3.lt(true);
                                        uqVar3.Tq(fT.title);
                                        uqVar3.TQ(fT.hbB);
                                        r0 = fT.description;
                                        com.tencent.mm.sdk.b.b mtVar = new mt();
                                        mtVar.fEE.type = 0;
                                        mtVar.fEE.fEG = fT.hbB;
                                        com.tencent.mm.sdk.b.a.xef.m(mtVar);
                                        com.tencent.mm.protocal.b.a.c cVar = mtVar.fEF.fEO;
                                        if (cVar != null) {
                                            r0 = cVar.desc;
                                        }
                                        uqVar3.Tr(r0);
                                        uqVar3.a(r3);
                                        uqVar3.TL(a(r3.wdX));
                                        uqVar3.TM(b(r3.wdX));
                                        uqVar3.fy(ae.field_msgId);
                                        cfVar.fqp.fqr.weU.add(uqVar3);
                                        break;
                                    }
                                    break;
                                case 20:
                                    vn vnVar = new vn();
                                    vnVar.Ur(fT.title);
                                    vnVar.Us(fT.description);
                                    vnVar.Uu(fT.hbA);
                                    vnVar.Ut(fT.thumburl);
                                    r3.a(vnVar);
                                    uqVar2 = new uq();
                                    uqVar2.TI(Z(ae));
                                    uqVar2.CJ(14);
                                    uqVar2.lt(true);
                                    uqVar2.ls(true);
                                    uqVar2.a(r3);
                                    uqVar2.TL(a(r3.wdX));
                                    uqVar2.TM(b(r3.wdX));
                                    cfVar.fqp.fqr.weU.add(uqVar2);
                                    vsVar = cfVar.fqp.fqs;
                                    vsVar.wfx++;
                                    break;
                                case 24:
                                    if (z) {
                                        cfVar.fqp.fqr.weU.add(a(ae, context.getString(R.l.egY), r3));
                                        break;
                                    }
                                default:
                                    if (!z) {
                                        cfVar.fqp.fqv = R.l.efp;
                                        z3 = false;
                                        break;
                                    }
                                    cfVar.fqp.fqr.weU.add(a(ae, context.getString(R.l.dGJ), r3));
                                    break;
                            }
                        }
                        cfVar.fqp.fqr.weU.add(a(ae, context.getString(R.l.dFq), r3));
                    }
                }
                z2 = z3;
            }
        }
        if (z) {
            return z2;
        }
        c.a(ae, cfVar, z2);
        return z2;
    }

    private static boolean a(Context context, cf cfVar, au auVar, int i) {
        ur urVar = new ur();
        urVar.c(Y(auVar));
        String str = null;
        if (i == 1) {
            str = context.getString(R.l.dEG);
        } else if (i == 2) {
            str = context.getString(R.l.dFW);
        } else if (i == 3) {
            str = context.getString(R.l.dGJ);
        }
        cfVar.fqp.fqr.weU.add(a(auVar, str, urVar));
        return true;
    }

    private static vk Rt(String str) {
        vk vkVar = new vk();
        vkVar.Ui(str);
        vkVar.CS(1);
        vkVar.fC(bh.Wp());
        vkVar.Uk("");
        return vkVar;
    }

    private static us Y(au auVar) {
        us usVar = new us();
        if (auVar == null) {
            return usVar;
        }
        if (auVar.field_isSend == 1 || auVar.field_content.startsWith("<msg>")) {
            usVar.TR(q.FS());
            usVar.TS(auVar.field_talker);
            if (s.eV(auVar.field_talker)) {
                usVar.TU(usVar.fzO);
            }
        } else {
            usVar.TR(auVar.field_talker);
            usVar.TS(q.FS());
            if (s.eV(auVar.field_talker)) {
                usVar.TU(auVar.field_content != null ? auVar.field_content.substring(0, Math.max(0, auVar.field_content.indexOf(58))) : "");
                if (!(bh.ov(usVar.wet) || auVar.ciW())) {
                    auVar.setContent(auVar.field_content.substring(usVar.wet.length() + 1));
                    if (auVar.field_content.length() > 0 && '\n' == auVar.field_content.charAt(0)) {
                        auVar.setContent(auVar.field_content.substring(1));
                    }
                    if (auVar.cjr()) {
                        auVar.dV(auVar.field_transContent.substring(usVar.wet.length() + 1));
                        if (auVar.field_transContent.length() > 0 && '\n' == auVar.field_transContent.charAt(0)) {
                            auVar.dV(auVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        if (f.eE(auVar.field_talker)) {
            String str = auVar.field_bizChatUserId;
            if (str == null) {
                str = ba.hT(auVar.gjF).userId;
            }
            usVar.TU(str);
        }
        usVar.CN(1);
        usVar.fz(auVar.field_createTime);
        usVar.TV(auVar.field_msgSvrId);
        if (auVar.field_msgSvrId > 0) {
            usVar.TT(auVar.field_msgSvrId);
        }
        return usVar;
    }

    private static String a(us usVar) {
        String str = usVar.wet;
        if (bh.ov(str)) {
            str = usVar.fzO;
        }
        if (e.km(str)) {
            return e.ko(str);
        }
        return r.gt(str);
    }

    private static String b(us usVar) {
        return pIX.format(new Date(usVar.hVE));
    }

    private static String Z(au auVar) {
        if (auVar.field_isSend != 1) {
            return String.valueOf(auVar.field_msgSvrId);
        }
        if (s.eV(auVar.field_talker) || auVar.field_talker.equals("filehelper")) {
            return String.format("%d", new Object[]{Long.valueOf(auVar.field_msgSvrId)});
        }
        return String.format("%s#%d", new Object[]{auVar.field_talker, Long.valueOf(auVar.field_msgSvrId)});
    }

    private static boolean b(cf cfVar, au auVar) {
        ur urVar = new ur();
        urVar.c(Y(auVar));
        Map y = bi.y(auVar.field_content, "msg");
        if (y != null) {
            try {
                ux uxVar = new ux();
                uxVar.TZ((String) y.get(".msg.location.$label"));
                uxVar.s(Double.parseDouble((String) y.get(".msg.location.$x")));
                uxVar.r(Double.parseDouble((String) y.get(".msg.location.$y")));
                uxVar.CO(Integer.valueOf((String) y.get(".msg.location.$scale")).intValue());
                uxVar.Ua((String) y.get(".msg.location.$poiname"));
                urVar.a(uxVar);
                uq uqVar = new uq();
                uqVar.TI(Z(auVar));
                uqVar.CJ(6);
                uqVar.lt(true);
                uqVar.ls(true);
                uqVar.a(urVar);
                uqVar.TL(a(urVar.wdX));
                uqVar.TM(b(urVar.wdX));
                cfVar.fqp.fqr.weU.add(uqVar);
                vs vsVar = cfVar.fqp.fqs;
                vsVar.wfp++;
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[]{e.getStackTrace().toString()});
            }
        }
        cfVar.fqp.fqv = R.l.efq;
        return false;
    }

    private static boolean a(cf cfVar, au auVar, boolean z) {
        ur urVar = new ur();
        urVar.c(Y(auVar));
        uq uqVar = new uq();
        uqVar.TI(Z(auVar));
        com.tencent.mm.modelvideo.o.TU();
        uqVar.TE(com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath));
        com.tencent.mm.modelvideo.o.TU();
        uqVar.TF(com.tencent.mm.modelvideo.s.nu(auVar.field_imgPath));
        uqVar.TA(com.tencent.mm.a.e.bQ(uqVar.wdh));
        if (auVar.cji()) {
            uqVar.CJ(15);
        } else {
            uqVar.CJ(4);
        }
        com.tencent.mm.modelvideo.r nF = t.nF(auVar.field_imgPath);
        x.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[]{Integer.valueOf(nF.hlp)});
        if (nF.hlp > com.tencent.mm.k.b.zG()) {
            cfVar.fqp.fqv = R.l.egO;
            return false;
        } else if (auVar.cji() && t.nH(nF.getFileName())) {
            cfVar.fqp.fqv = R.l.efg;
            return false;
        } else {
            uqVar.CI(nF.hVH);
            uqVar.a(urVar);
            uqVar.TL(a(urVar.wdX));
            uqVar.TM(b(urVar.wdX));
            uqVar.fy(auVar.field_msgId);
            uqVar.fw((long) nF.hlp);
            if (z) {
                Map y = bi.y(nF.Ug(), "msg");
                if (y != null) {
                    uqVar.Tu((String) y.get(".msg.videomsg.$cdnvideourl"));
                    uqVar.Tv((String) y.get(".msg.videomsg.$aeskey"));
                } else {
                    x.i("MicroMsg.GetFavRecordDataSource", "cdntra parse video recv xml failed");
                }
            }
            cfVar.fqp.fqr.weU.add(uqVar);
            vs vsVar = cfVar.fqp.fqs;
            vsVar.wfn++;
            com.tencent.mm.modelvideo.r nF2 = t.nF(auVar.field_imgPath);
            uqVar.TO(nF2.fGG);
            bmf com_tencent_mm_protocal_c_bmf = nF2.hVQ;
            if (!(com_tencent_mm_protocal_c_bmf == null || bh.ov(com_tencent_mm_protocal_c_bmf.hdu))) {
                ut utVar = new ut();
                utVar.hdo = com_tencent_mm_protocal_c_bmf.hdo;
                utVar.weC = com_tencent_mm_protocal_c_bmf.weC;
                utVar.hdr = com_tencent_mm_protocal_c_bmf.hdr;
                utVar.hds = com_tencent_mm_protocal_c_bmf.hds;
                utVar.hdq = com_tencent_mm_protocal_c_bmf.hdq;
                utVar.hdt = com_tencent_mm_protocal_c_bmf.hdt;
                utVar.hdu = com_tencent_mm_protocal_c_bmf.hdu;
                utVar.hdv = com_tencent_mm_protocal_c_bmf.hdv;
                uqVar.a(utVar);
            }
            return true;
        }
    }

    private static uq a(au auVar, com.tencent.mm.y.g.a aVar, int i) {
        uq uqVar = new uq();
        uqVar.TI(Z(auVar));
        uqVar.Tx(aVar.hbs);
        uqVar.Ty(aVar.hbt);
        uqVar.Tw(aVar.url);
        uqVar.ls(true);
        File file = new File(bh.az(o.Pw().B(auVar.field_imgPath, true), ""));
        if (file.exists()) {
            uqVar.TF(file.getAbsolutePath());
        } else {
            uqVar.lt(true);
        }
        uqVar.Tq(aVar.title);
        uqVar.Tr(aVar.description);
        uqVar.CJ(i);
        uqVar.TP(aVar.canvasPageXml);
        return uqVar;
    }

    private static uq a(au auVar, String str, ur urVar) {
        uq uqVar = new uq();
        uqVar.TI(Z(auVar));
        uqVar.CJ(1);
        uqVar.Tr(str);
        uqVar.lt(true);
        uqVar.ls(true);
        uqVar.a(urVar);
        uqVar.TL(a(urVar.wdX));
        uqVar.TM(b(urVar.wdX));
        return uqVar;
    }

    private static boolean c(cf cfVar, au auVar) {
        try {
            l vL = ((a) g.h(a.class)).vL(auVar.field_content);
            List<m> list = vL.hdX;
            if (list != null) {
                int i = 0;
                for (m mVar : list) {
                    if (!com.tencent.mm.y.i.fV(mVar.hei)) {
                        ur urVar = new ur();
                        urVar.c(Y(auVar));
                        urVar.wdX.TY(vL.fGz);
                        urVar.wdX.TX(mVar.url);
                        uq uqVar = new uq();
                        uqVar.Tq(mVar.title);
                        uqVar.Tr(mVar.hef);
                        uqVar.TI(Z(auVar));
                        if (bh.ov(mVar.hed)) {
                            uqVar.lt(true);
                        } else {
                            uqVar.TF(t.v(mVar.hed, auVar.getType(), i == 0 ? "@T" : "@S"));
                        }
                        uqVar.ls(true);
                        vt vtVar = new vt();
                        if (!bh.ov(mVar.title)) {
                            vtVar.Uv(mVar.title);
                        }
                        if (!bh.ov(mVar.hef)) {
                            vtVar.Uw(mVar.hef);
                        }
                        if (!bh.ov(mVar.hed)) {
                            vtVar.Uy(mVar.hed);
                        }
                        if (vtVar.bke() > 0) {
                            vtVar.CT(1);
                            urVar.a(vtVar);
                        }
                        uqVar.CJ(5);
                        uqVar.a(urVar);
                        uqVar.TL(a(urVar.wdX));
                        uqVar.TM(b(urVar.wdX));
                        cfVar.fqp.fqr.weU.add(uqVar);
                        vs vsVar = cfVar.fqp.fqs;
                        vsVar.wfo++;
                        i++;
                    }
                }
                if (i != 0) {
                    return true;
                }
                cfVar.fqp.fqv = R.l.efp;
                return false;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetFavRecordDataSource", e, "", new Object[0]);
            x.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
        cfVar.fqp.fqv = R.l.efq;
        return false;
    }
}
