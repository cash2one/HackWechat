package com.tencent.mm.plugin.sns.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static boolean a(cf cfVar, m mVar) {
        if (mVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            cfVar.fqp.fqv = j.efh;
            return false;
        }
        ve veVar = new ve();
        vk vkVar = new vk();
        bnp bxV = mVar.bxV();
        aqr com_tencent_mm_protocal_c_aqr = (aqr) bxV.wQo.vYd.get(0);
        if (mVar.xl(32) && bxV.wQo.vYc == 15) {
            bxV.wQt.hdu = mVar.bxT().qZM;
            bxV.wQt.hdv = bxV.nGJ;
        }
        String eq = i.eq(mVar.field_snsId);
        eq = String.format("%s#%s", new Object[]{eq, com_tencent_mm_protocal_c_aqr.nGJ});
        vkVar.Ui(mVar.field_userName);
        vkVar.Uj(q.FS());
        vkVar.CS(2);
        vkVar.fC(bh.Wp());
        vkVar.Un(mVar.bxW());
        vkVar.Uk(eq);
        veVar.a(vkVar);
        uq uqVar = new uq();
        uqVar.TI(eq);
        String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
        String j = i.j(com_tencent_mm_protocal_c_aqr);
        String e = i.e(com_tencent_mm_protocal_c_aqr);
        if (bh.ov(ap.a(mVar.byq(), com_tencent_mm_protocal_c_aqr))) {
            x.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            cfVar.fqp.fqv = j.qJw;
            return false;
        } else if (FileOp.bO(r + j)) {
            int i;
            int i2;
            if (!FileOp.bO(r + e)) {
                int i3 = 320;
                i = 240;
                if (com_tencent_mm_protocal_c_aqr.wxH != null && com_tencent_mm_protocal_c_aqr.wxH.wyv > 0.0f && com_tencent_mm_protocal_c_aqr.wxH.wyu > 0.0f) {
                    i3 = (int) com_tencent_mm_protocal_c_aqr.wxH.wyu;
                    i = (int) com_tencent_mm_protocal_c_aqr.wxH.wyv;
                }
                Bitmap R = d.R(r + j, i3, i);
                if (R == null) {
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + FileOp.bO(r + e));
                    cfVar.fqp.fqv = j.qJw;
                    return false;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(R, 60, CompressFormat.JPEG, r + e, true);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", e2, "save bmp error %s", new Object[]{e2.getMessage()});
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + FileOp.bO(r + e));
                    cfVar.fqp.fqv = j.qJw;
                    return false;
                }
            }
            uqVar.TE(r + j);
            uqVar.TF(r + e);
            uqVar.Tq(bh.ov(com_tencent_mm_protocal_c_aqr.wxP) ? bxV.wQl : com_tencent_mm_protocal_c_aqr.wxP);
            uqVar.TP(bxV.rLO);
            if (!bh.ov(bxV.rLO)) {
                Map y = bi.y(bxV.rLO, "adxml");
                if (y.size() > 0) {
                    uqVar.Tq(bh.az((String) y.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    uqVar.Tr(bh.az((String) y.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            if (mVar.xl(32)) {
                b bxR = mVar.bxR();
                ut utVar = new ut();
                utVar.hdq = bh.ov(com_tencent_mm_protocal_c_aqr.wxP) ? bxV.wQl : com_tencent_mm_protocal_c_aqr.wxP;
                utVar.weC = com_tencent_mm_protocal_c_aqr.rNe;
                utVar.hdo = com_tencent_mm_protocal_c_aqr.wxL;
                utVar.hdu = bxV.wQt.hdu;
                utVar.hdv = bxV.wQt.hdv;
                if (bh.ov(utVar.hdv)) {
                    utVar.hdv = bxV.nGJ;
                }
                utVar.hdt = bh.ov(com_tencent_mm_protocal_c_aqr.wxO) ? com_tencent_mm_protocal_c_aqr.wxE : com_tencent_mm_protocal_c_aqr.wxO;
                if (bxR != null && bxR.reD == 0) {
                    utVar.hds = bxR.reF;
                    utVar.hdr = bxR.reE;
                }
                uqVar.a(utVar);
                i = 15;
                i2 = 16;
            } else {
                i2 = 4;
                i = 4;
            }
            uqVar.CJ(i);
            com.tencent.mm.plugin.sight.base.a Js = d.Js(uqVar.wdh);
            if (Js != null) {
                uqVar.CI(Js.bsA());
            } else {
                uqVar.CI(1);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(uqVar);
            veVar.av(linkedList);
            cfVar.fqp.fqr = veVar;
            cfVar.fqp.type = i2;
            a(uqVar, mVar);
            x.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return true;
        } else {
            x.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + FileOp.bO(r + j) + " thumb:" + FileOp.bO(r + e));
            cfVar.fqp.fqv = j.qJw;
            return false;
        }
    }

    public static boolean a(cf cfVar, String str, String str2) {
        if (cfVar == null || !u.LH(str2) || str == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (cfVar != null) {
                cfVar.fqp.fqv = j.efh;
            }
            return false;
        } else if (ae.bve()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cfVar.fqp.fqv = j.qJx;
            return false;
        } else {
            m Lm = h.Lm(str2);
            if (Lm == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cfVar.fqp.fqv = j.efi;
                return false;
            } else if (Lm.bxV().wQo != null && Lm.bxV().wQo.vYc == 26) {
                return a(cfVar, str2);
            } else {
                vt vtVar;
                String str3 = "0";
                aqr a = ai.a(Lm, 0);
                if (a != null) {
                    str3 = a.nGJ;
                }
                String eq = i.eq(Lm.field_snsId);
                str3 = String.format("%s#%s", new Object[]{eq, str3});
                ve veVar = new ve();
                vk vkVar = new vk();
                x.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[]{Lm.field_userName});
                vkVar.Ui(Lm.field_userName);
                vkVar.Uj(q.FS());
                vkVar.CS(2);
                vkVar.fC(((long) Lm.field_createTime) * 1000);
                vkVar.Un(Lm.bxW());
                vkVar.Uk(str3);
                vkVar.Up(str);
                uq uqVar = new uq();
                uqVar.TI(str3);
                if (a != null) {
                    str3 = am.r(ae.getAccSnsPath(), a.nGJ) + i.e(a);
                    if (FileOp.bO(str3)) {
                        uqVar.TF(str3);
                    } else {
                        uqVar.lt(true);
                        uqVar.Tz(a.wxE);
                        vtVar = new vt();
                        vtVar.Uy(a.wxE);
                        veVar.b(vtVar);
                    }
                } else {
                    uqVar.lt(true);
                }
                uqVar.CJ(5);
                bnp bxV = Lm.bxV();
                uqVar.Tq(bxV.wQo.fon);
                uqVar.Tr(bxV.wQo.nfe);
                uqVar.TP(bxV.rLO);
                if (!bh.ov(bxV.rLO)) {
                    Map y = bi.y(bxV.rLO, "adxml");
                    if (y.size() > 0) {
                        uqVar.Tq(bh.az((String) y.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        uqVar.Tr(bh.az((String) y.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
                a(uqVar, bxV);
                uqVar.ls(true);
                veVar.weU.add(uqVar);
                vtVar = new vt();
                vtVar.CU(bxV.hbg);
                veVar.b(vtVar);
                veVar.a(vkVar);
                cfVar.fqp.fqr = veVar;
                cfVar.fqp.desc = bxV.wQo.fon;
                cfVar.fqp.type = 5;
                return true;
            }
        }
    }

    public static boolean a(cf cfVar, String str, CharSequence charSequence) {
        if (u.LI(str) || charSequence == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            cfVar.fqp.fqv = j.efh;
            return false;
        } else if (ae.bve()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cfVar.fqp.fqv = j.qJx;
            return false;
        } else {
            m Lm = ae.bvv().Lm(str);
            if (Lm == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cfVar.fqp.fqv = j.efi;
                return false;
            } else if (0 == Lm.field_snsId) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                cfVar.fqp.fqv = j.efg;
                return false;
            } else {
                String eq = i.eq(Lm.field_snsId);
                eq = String.format("%s#0", new Object[]{eq});
                ve veVar = new ve();
                vk vkVar = new vk();
                x.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[]{Lm.field_userName});
                vkVar.Ui(Lm.field_userName);
                vkVar.Uj(q.FS());
                vkVar.CS(2);
                vkVar.fC(((long) Lm.field_createTime) * 1000);
                vkVar.Un(Lm.bxW());
                vkVar.Uk(eq);
                veVar.a(vkVar);
                cfVar.fqp.fqr = veVar;
                cfVar.fqp.desc = charSequence.toString();
                cfVar.fqp.type = 1;
                return true;
            }
        }
    }

    public static boolean a(cf cfVar, m mVar, String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            cfVar.fqp.fqv = j.efh;
            return false;
        } else if (mVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            cfVar.fqp.fqv = j.efi;
            return false;
        } else {
            aqr a = ai.a(mVar, str);
            if (a == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                cfVar.fqp.fqv = j.efi;
                return false;
            }
            String eq = i.eq(mVar.field_snsId);
            eq = String.format("%s#%s", new Object[]{eq, str});
            ve veVar = new ve();
            vk vkVar = new vk();
            uq uqVar = new uq();
            x.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[]{mVar.field_userName});
            vkVar.Ui(mVar.field_userName);
            vkVar.Uj(q.FS());
            vkVar.CS(2);
            vkVar.fC(((long) mVar.field_createTime) * 1000);
            vkVar.Un(mVar.bxW());
            vkVar.Uk(eq);
            uqVar.TI(eq);
            uqVar.TE(am.r(ae.getAccSnsPath(), str) + i.l(a));
            if (mVar.bxV() != null) {
                uqVar.TP(mVar.bxV().rLO);
                if (!bh.ov(mVar.bxV().rLO)) {
                    Map y = bi.y(mVar.bxV().rLO, "adxml");
                    if (y.size() > 0) {
                        uqVar.Tq(bh.az((String) y.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        uqVar.Tr(bh.az((String) y.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            a(uqVar, mVar);
            eq = am.r(ae.getAccSnsPath(), a.nGJ) + i.e(a);
            if (FileOp.bO(uqVar.wdh) || !mVar.field_userName.endsWith(ae.bvb())) {
                if (FileOp.bO(eq)) {
                    uqVar.TF(eq);
                } else {
                    uqVar.lt(true);
                    uqVar.Tz(a.wxE);
                    vt vtVar = new vt();
                    vtVar.Uy(a.wxE);
                    veVar.b(vtVar);
                }
                uqVar.CJ(2);
                veVar.weU.add(uqVar);
                veVar.a(vkVar);
                cfVar.fqp.fqr = veVar;
                cfVar.fqp.type = 2;
                return true;
            }
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            cfVar.fqp.fqv = j.efi;
            return false;
        }
    }

    private static void a(uq uqVar, bnp com_tencent_mm_protocal_c_bnp) {
        if (uqVar != null && com_tencent_mm_protocal_c_bnp != null && !bh.ov(com_tencent_mm_protocal_c_bnp.rtA)) {
            uqVar.TO(com_tencent_mm_protocal_c_bnp.rtA);
        }
    }

    public static void a(uq uqVar, m mVar) {
        if (mVar != null) {
            a(uqVar, mVar.bxV());
        }
    }

    public static boolean a(cf cfVar, String str) {
        int i = 0;
        if (cfVar == null || !u.LH(str)) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (cfVar == null) {
                return false;
            }
            cfVar.fqp.fqv = j.efh;
            return false;
        } else if (ae.bve()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cfVar.fqp.fqv = j.qJx;
            return false;
        } else {
            m Lm = h.Lm(str);
            if (Lm == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cfVar.fqp.fqv = j.efi;
                return false;
            }
            String str2 = "0";
            aqr a = ai.a(Lm, 0);
            if (a != null) {
                str2 = a.nGJ;
            }
            str2 = String.format("%s#%s", new Object[]{i.eq(Lm.field_snsId), str2});
            vk vkVar = new vk();
            bnp bxV = Lm.bxV();
            if (bxV == null) {
                x.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
                return false;
            }
            x.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[]{Lm.field_userName});
            vkVar.Ui(Lm.field_userName);
            vkVar.Uj(q.FS());
            vkVar.CS(2);
            vkVar.fC(((long) Lm.field_createTime) * 1000);
            vkVar.Un(Lm.bxW());
            vkVar.Uk(str2);
            com.tencent.mm.sdk.b.b fvVar = new fv();
            fvVar.fvq.type = 30;
            fvVar.fvq.fvx = 4;
            fvVar.fvq.desc = bxV.wQo.vYf;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
            fvVar.fvq.fqr.a(vkVar);
            cfVar.fqp.fqr = fvVar.fvq.fqr;
            if (cfVar.fqp.fqr != null) {
                LinkedList linkedList = cfVar.fqp.fqr.weU;
                if (linkedList != null) {
                    while (i < linkedList.size()) {
                        uq uqVar = (uq) linkedList.get(i);
                        if (uqVar != null) {
                            uqVar.ls(true);
                            uqVar.lt(true);
                        }
                        i++;
                    }
                }
            }
            cfVar.fqp.desc = bxV.wQo.fon;
            cfVar.fqp.type = 18;
            return true;
        }
    }
}
