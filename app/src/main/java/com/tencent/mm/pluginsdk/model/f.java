package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.k.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.b.a.c;
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
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f {
    public static boolean a(cf cfVar, Intent intent) {
        if (cfVar == null) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
            return false;
        }
        double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
        int intExtra = intent.getIntExtra("kwebmap_scale", 0);
        String az = bh.az(intent.getStringExtra("Kwebmap_locaion"), "");
        String stringExtra = intent.getStringExtra("kPoiName");
        intent.getCharSequenceExtra("kRemark");
        intent.getStringArrayListExtra("kTags");
        ux uxVar = new ux();
        uxVar.TZ(az);
        uxVar.s(doubleExtra);
        uxVar.r(doubleExtra2);
        uxVar.CO(intExtra);
        uxVar.Ua(stringExtra);
        ve veVar = new ve();
        vk vkVar = new vk();
        String FS = q.FS();
        vkVar.Ui(FS);
        vkVar.Uj(FS);
        vkVar.CS(6);
        vkVar.fC(bh.Wp());
        veVar.b(uxVar);
        veVar.a(vkVar);
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 6;
        return true;
    }

    public static boolean a(cf cfVar, int i, String str, String str2, String str3) {
        if (bh.ov(str)) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            cfVar.fqp.fqv = R.l.efh;
            return false;
        }
        x.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[]{str2, str3, str, Integer.valueOf(i)});
        if (new File(str).length() > ((long) b.zG())) {
            cfVar.fqp.fqv = R.l.egO;
            return false;
        }
        ve veVar = new ve();
        vk vkVar = new vk();
        uq uqVar = new uq();
        uqVar.TE(str);
        uqVar.CJ(8);
        uqVar.TA(e.bQ(str));
        uqVar.lt(true);
        uqVar.Tq(str2);
        uqVar.Tr(str3);
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(i);
        vkVar.fC(bh.Wp());
        veVar.a(vkVar);
        veVar.weU.add(uqVar);
        cfVar.fqp.title = uqVar.title;
        cfVar.fqp.desc = uqVar.title;
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 8;
        return true;
    }

    public static boolean a(cf cfVar, String str, int i) {
        if (bh.ov(str)) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            cfVar.fqp.fqv = R.l.efh;
            return false;
        }
        x.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[]{str, Integer.valueOf(i)});
        ve veVar = new ve();
        vk vkVar = new vk();
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(i);
        vkVar.fC(bh.Wp());
        veVar.a(vkVar);
        cfVar.fqp.desc = str;
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 1;
        return true;
    }

    public static boolean a(cf cfVar, int i, String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            cfVar.fqp.fqv = R.l.efh;
            return false;
        }
        x.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[]{str, Integer.valueOf(i)});
        ve veVar = new ve();
        vk vkVar = new vk();
        uq uqVar = new uq();
        uqVar.CJ(2);
        uqVar.TE(str);
        uqVar.TD(g.s((uqVar.toString() + 2 + System.currentTimeMillis()).getBytes()));
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 27;
        fvVar.fvq.fvs = uqVar;
        a.xef.m(fvVar);
        String str2 = fvVar.fvr.fvC;
        d.b(str, 150, 150, CompressFormat.JPEG, 90, str2);
        uqVar.TF(str2);
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(i);
        vkVar.fC(bh.Wp());
        veVar.a(vkVar);
        veVar.weU.add(uqVar);
        cfVar.fqp.title = uqVar.title;
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 2;
        return true;
    }

    public static boolean a(cf cfVar, long j) {
        return a(cfVar, ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH(j));
    }

    public static boolean a(cf cfVar, au auVar) {
        boolean z = false;
        boolean z2 = true;
        if (cfVar == null || auVar == null) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
            if (cfVar != null) {
                cfVar.fqp.fqv = R.l.efh;
            }
        } else {
            au ae = au.ae(auVar);
            ve veVar;
            if (ae.cjg()) {
                veVar = new ve();
                veVar.a(X(ae));
                cfVar.fqp.fqr = veVar;
                if (ae.cjw()) {
                    cfVar.fqp.desc = ae.field_content + "\n\n" + ae.field_transContent;
                } else {
                    cfVar.fqp.desc = ae.field_content;
                }
                cfVar.fqp.type = 1;
                if (com.tencent.mm.ui.tools.h.ZY(cfVar.fqp.desc) > b.zC()) {
                    cfVar.fqp.fqv = R.l.egM;
                } else {
                    z = true;
                }
            } else if (ae.ciW()) {
                ve veVar2 = new ve();
                veVar2.a(X(ae));
                r5 = new uq();
                a(r5, ae);
                if (s.ha(ae.field_talker)) {
                    String a = i.a(com.tencent.mm.plugin.record.b.Fn(), "recbiz_", ae.field_imgPath, ".rec", 2);
                    if (bh.ov(a)) {
                        a = null;
                    } else {
                        new File(a).exists();
                    }
                    r5.TE(a);
                } else {
                    r5.TE(com.tencent.mm.modelvoice.q.getFullPath(ae.field_imgPath));
                }
                r5.CJ(3);
                r5.lt(true);
                com.tencent.mm.modelvoice.b nT = com.tencent.mm.modelvoice.q.nT(ae.field_imgPath);
                if (nT != null) {
                    r5.TA(BA(nT.getFormat()));
                    r5.CI((int) new n(ae.field_content).time);
                    r0 = new LinkedList();
                    r0.add(r5);
                    veVar2.av(r0);
                    cfVar.fqp.fqr = veVar2;
                    cfVar.fqp.type = 3;
                    z = true;
                }
            } else if (ae.aNe()) {
                z = b(cfVar, ae);
            } else if (ae.cje()) {
                com.tencent.mm.aq.e eVar = null;
                if (ae.field_msgId > 0) {
                    eVar = o.Pw().bi(ae.field_msgId);
                }
                if ((eVar == null || eVar.hzP <= 0) && ae.field_msgSvrId > 0) {
                    eVar = o.Pw().bh(ae.field_msgSvrId);
                }
                if (eVar == null) {
                    x.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
                    cfVar.fqp.fqv = R.l.efn;
                } else {
                    ve veVar3 = new ve();
                    veVar3.a(X(ae));
                    r4 = new uq();
                    a(r4, ae);
                    r4.CJ(2);
                    r4.TE(o.Pw().m(com.tencent.mm.aq.f.c(eVar), "", ""));
                    if (eVar.Pe()) {
                        eVar = o.Pw().hQ(eVar.hzZ);
                        if (eVar.hlp > eVar.offset) {
                            r4.TE(o.Pw().m("SERVERID://" + ae.field_msgSvrId, "", ""));
                        }
                    }
                    r4.TF(o.Pw().B(ae.field_imgPath, true));
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(r4);
                    veVar3.av(linkedList);
                    cfVar.fqp.fqr = veVar3;
                    cfVar.fqp.type = 2;
                    z = true;
                }
            } else if (ae.cjh() || ae.cji()) {
                veVar = new ve();
                veVar.a(X(ae));
                r4 = new uq();
                a(r4, ae);
                com.tencent.mm.modelvideo.o.TU();
                r4.TF(com.tencent.mm.modelvideo.s.nu(ae.field_imgPath));
                r4.TA(e.bQ(r4.wdh));
                r nF = t.nF(ae.field_imgPath);
                x.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[]{Integer.valueOf(nF.hlp)});
                if (nF.hlp > b.zG()) {
                    cfVar.fqp.fqv = R.l.egO;
                } else if (ae.cji() && t.nH(nF.getFileName())) {
                    cfVar.fqp.fqv = R.l.efg;
                } else {
                    if (nF.Uj()) {
                        com.tencent.mm.modelvideo.o.TU();
                        x.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[]{com.tencent.mm.modelvideo.s.nt(ae.field_imgPath)});
                        r4.TE(r6);
                    } else {
                        x.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
                        r4.TE("");
                    }
                    r4.CI(nF.hVH);
                    r0 = new LinkedList();
                    r0.add(r4);
                    veVar.av(r0);
                    cfVar.fqp.fqr = veVar;
                    if (ae.cji()) {
                        cfVar.fqp.type = 16;
                        r4.CJ(15);
                    } else {
                        cfVar.fqp.type = 4;
                        r4.CJ(4);
                    }
                    r nF2 = t.nF(ae.field_imgPath);
                    r4.TO(nF2.fGG);
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
                        r4.a(utVar);
                    }
                    z = true;
                }
            } else if (ae.ciV()) {
                z = c(cfVar, ae);
            } else if (ae.cjf() || !ae.aNc() || ae.cjk()) {
                cfVar.fqp.fqv = R.l.efp;
            } else {
                veVar = new ve();
                veVar.a(X(ae));
                String str = ae.field_content;
                if (str != null) {
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str);
                    if (fT != null) {
                        cfVar.fqp.fqr = veVar;
                        vk vkVar = veVar.weS;
                        vkVar.Uo(fT.appId);
                        vkVar.Uq(fT.fGz);
                        com.tencent.mm.pluginsdk.model.app.b Rz;
                        String B;
                        uq a2;
                        vd vdVar;
                        switch (fT.type) {
                            case 1:
                                cfVar.fqp.fqr = veVar;
                                cfVar.fqp.desc = fT.title;
                                cfVar.fqp.type = 1;
                                break;
                            case 2:
                                if (!com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
                                    cfVar.fqp.fqv = R.l.efw;
                                    z2 = false;
                                    break;
                                }
                                Rz = com.tencent.mm.plugin.y.a.aqd().Rz(fT.fny);
                                r5 = new uq();
                                a(r5, ae);
                                if (Rz != null) {
                                    r5.TE(Rz.field_fileFullPath);
                                }
                                B = o.Pw().B(ae.field_imgPath, true);
                                if (e.bO(B)) {
                                    r5.TF(B);
                                }
                                r5.CJ(2);
                                r5.Tq(fT.title);
                                r5.Tr(fT.description);
                                veVar.weU.add(r5);
                                cfVar.fqp.type = 2;
                                break;
                            case 3:
                                veVar.weU.add(a(ae, fT, 7));
                                cfVar.fqp.type = 7;
                                break;
                            case 4:
                                a2 = a(ae, fT, 4);
                                veVar.Ug(a2.title);
                                veVar.Uh(a2.desc);
                                veVar.weU.add(a2);
                                cfVar.fqp.type = 4;
                                break;
                            case 5:
                                if (fT.url != null && !fT.url.equals("")) {
                                    veVar.weS.Up(fT.url);
                                    a2 = a(ae, fT, 5);
                                    veVar.weU.add(a2);
                                    veVar.Ug(a2.title);
                                    veVar.Uh(a2.desc);
                                    cfVar.fqp.type = 5;
                                    break;
                                }
                                cfVar.fqp.fqv = R.l.efl;
                                z2 = false;
                                break;
                                break;
                            case 6:
                                if (!com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
                                    cfVar.fqp.fqv = R.l.efw;
                                    z2 = false;
                                    break;
                                }
                                Rz = com.tencent.mm.plugin.y.a.aqd().Rz(fT.fny);
                                r5 = new uq();
                                if (Rz != null) {
                                    r5.TE(Rz.field_fileFullPath);
                                }
                                a(r5, ae);
                                r5.CJ(8);
                                r5.TA(fT.hbc);
                                B = o.Pw().B(ae.field_imgPath, true);
                                if (bh.ov(B)) {
                                    r5.lt(true);
                                }
                                if (e.bO(B)) {
                                    r5.TF(B);
                                }
                                r5.Tq(fT.title);
                                r5.Tr(fT.description);
                                veVar.weU.add(r5);
                                cfVar.fqp.desc = fT.title;
                                cfVar.fqp.type = 8;
                                break;
                            case 7:
                                if (fT.fny != null && fT.fny.length() != 0) {
                                    if (!com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
                                        cfVar.fqp.fqv = R.l.efw;
                                        z2 = false;
                                        break;
                                    }
                                }
                                cfVar.fqp.fqv = R.l.efi;
                                cfVar.fqp.fqv = R.l.efp;
                                z2 = false;
                                break;
                            case 10:
                                vdVar = new vd();
                                vdVar.Ub(fT.title);
                                vdVar.Uc(fT.description);
                                vdVar.CP(fT.hbw);
                                vdVar.Ue(fT.hbx);
                                vdVar.Ud(fT.thumburl);
                                cfVar.fqp.title = fT.title;
                                cfVar.fqp.desc = fT.description;
                                cfVar.fqp.type = 10;
                                veVar.b(vdVar);
                                break;
                            case 13:
                                vdVar = new vd();
                                vdVar.Ub(fT.title);
                                vdVar.Uc(fT.description);
                                vdVar.CP(fT.hbC);
                                vdVar.Ue(fT.hbD);
                                vdVar.Ud(fT.thumburl);
                                cfVar.fqp.title = fT.title;
                                cfVar.fqp.desc = fT.description;
                                cfVar.fqp.type = 11;
                                veVar.b(vdVar);
                                break;
                            case 19:
                            case 24:
                                cfVar.fqp.fqs = new vs();
                                z2 = a(cfVar, fT, veVar, ae);
                                break;
                            case 20:
                                vn vnVar = new vn();
                                vnVar.Ur(fT.title);
                                vnVar.Us(fT.description);
                                vnVar.Uu(fT.hbA);
                                vnVar.Ut(fT.thumburl);
                                cfVar.fqp.title = fT.title;
                                cfVar.fqp.desc = fT.description;
                                cfVar.fqp.type = 15;
                                veVar.b(vnVar);
                                break;
                            default:
                                cfVar.fqp.fqv = R.l.efp;
                                z2 = false;
                                break;
                        }
                    }
                    cfVar.fqp.fqv = R.l.efq;
                    z2 = false;
                } else {
                    cfVar.fqp.fqv = R.l.efq;
                    z2 = false;
                }
                z = z2;
            }
            cfVar.fqp.fqf = ae.field_content;
            if (z || cfVar.fqp.fqv == 0) {
                c.a(ae, cfVar, z);
            }
        }
        return z;
    }

    private static vk X(au auVar) {
        vk vkVar = new vk();
        if (auVar.field_isSend == 1) {
            vkVar.Ui(q.FS());
            vkVar.Uj(auVar.field_talker);
            if (s.eV(auVar.field_talker)) {
                vkVar.Ul(vkVar.fzO);
            }
        } else {
            vkVar.Ui(auVar.field_talker);
            vkVar.Uj(q.FS());
            if (s.eV(auVar.field_talker)) {
                vkVar.Ul(auVar.field_content != null ? auVar.field_content.substring(0, Math.max(0, auVar.field_content.indexOf(58))) : "");
                if (!(bh.ov(vkVar.wet) || auVar.ciW())) {
                    auVar.setContent(auVar.field_content.substring(vkVar.wet.length() + 1));
                    if (auVar.field_content.length() > 0 && '\n' == auVar.field_content.charAt(0)) {
                        auVar.setContent(auVar.field_content.substring(1));
                    }
                    if (auVar.cjr()) {
                        auVar.dV(auVar.field_transContent.substring(vkVar.wet.length() + 1));
                        if (auVar.field_transContent.length() > 0 && '\n' == auVar.field_transContent.charAt(0)) {
                            auVar.dV(auVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        vkVar.CS(1);
        vkVar.fC(auVar.field_createTime);
        vkVar.Um(auVar.field_msgSvrId);
        if (auVar.field_msgSvrId > 0) {
            vkVar.Uk(auVar.field_msgSvrId);
        }
        return vkVar;
    }

    private static boolean b(cf cfVar, au auVar) {
        ve veVar = new ve();
        veVar.a(X(auVar));
        Map y = bi.y(auVar.field_content, "msg");
        if (y != null) {
            try {
                ux uxVar = new ux();
                uxVar.TZ((String) y.get(".msg.location.$label"));
                uxVar.s(Double.parseDouble((String) y.get(".msg.location.$x")));
                uxVar.r(Double.parseDouble((String) y.get(".msg.location.$y")));
                uxVar.CO(Integer.valueOf((String) y.get(".msg.location.$scale")).intValue());
                uxVar.Ua((String) y.get(".msg.location.$poiname"));
                veVar.b(uxVar);
                cfVar.fqp.type = 6;
                cfVar.fqp.fqr = veVar;
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[]{e.getStackTrace().toString()});
            }
        }
        cfVar.fqp.fqv = R.l.efq;
        return false;
    }

    private static void a(uq uqVar, au auVar) {
        if (auVar.field_isSend != 1) {
            uqVar.TI(String.valueOf(auVar.field_msgSvrId));
        } else if (s.eV(auVar.field_talker) || auVar.field_talker.equals("filehelper")) {
            uqVar.TI(String.valueOf(auVar.field_msgSvrId));
        } else {
            uqVar.TI(auVar.field_talker + "#" + String.valueOf(auVar.field_msgSvrId));
        }
    }

    public static String BA(int i) {
        if (i == 1) {
            return "speex";
        }
        if (i == 4) {
            return "silk";
        }
        return "amr";
    }

    private static uq a(au auVar, com.tencent.mm.y.g.a aVar, int i) {
        uq uqVar = new uq();
        a(uqVar, auVar);
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
        uqVar.TP(aVar.canvasPageXml);
        uqVar.CJ(i);
        uqVar.TO(aVar.fGG);
        return uqVar;
    }

    private static boolean c(cf cfVar, au auVar) {
        ve veVar = new ve();
        vk X = X(auVar);
        veVar.a(X);
        try {
            l vL = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
            List list = vL.hdX;
            X.Uq(vL.fGz);
            if (list != null && list.size() > cfVar.fqp.fqt) {
                x.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[]{Integer.valueOf(cfVar.fqp.fqt)});
                m mVar = (m) list.get(cfVar.fqp.fqt);
                if (com.tencent.mm.y.i.fV(mVar.hei)) {
                    cfVar.fqp.fqv = R.l.efp;
                    return false;
                }
                String JG;
                vt vtVar;
                X.Up(mVar.url);
                if (cfVar.fqp.fqt > 0) {
                    X.Uk("");
                }
                uq uqVar = new uq();
                uqVar.Tq(mVar.title);
                uqVar.Tr(mVar.hef);
                a(uqVar, auVar);
                String str = mVar.hed;
                if (bh.ov(str)) {
                    com.tencent.mm.ad.h jm = com.tencent.mm.ad.n.JQ().jm(auVar.field_talker);
                    if (jm != null) {
                        JG = jm.JG();
                        if (bh.ov(JG)) {
                            uqVar.TF(t.v(JG, auVar.getType(), cfVar.fqp.fqt <= 0 ? "@S" : "@T"));
                            uqVar.lt(false);
                            if (bh.ov(uqVar.wdj) || !FileOp.bO(uqVar.wdj)) {
                                uqVar.Tz(JG);
                                uqVar.lt(true);
                                vtVar = new vt();
                                vtVar.Uy(JG);
                                veVar.b(vtVar);
                            }
                        } else {
                            uqVar.lt(true);
                        }
                        uqVar.ls(true);
                        uqVar.CJ(5);
                        veVar.weU.add(uqVar);
                        cfVar.fqp.fqr = veVar;
                        cfVar.fqp.desc = mVar.title;
                        cfVar.fqp.type = 5;
                        return true;
                    }
                }
                JG = str;
                if (bh.ov(JG)) {
                    uqVar.lt(true);
                } else {
                    if (cfVar.fqp.fqt <= 0) {
                    }
                    uqVar.TF(t.v(JG, auVar.getType(), cfVar.fqp.fqt <= 0 ? "@S" : "@T"));
                    uqVar.lt(false);
                    uqVar.Tz(JG);
                    uqVar.lt(true);
                    vtVar = new vt();
                    vtVar.Uy(JG);
                    veVar.b(vtVar);
                }
                uqVar.ls(true);
                uqVar.CJ(5);
                veVar.weU.add(uqVar);
                cfVar.fqp.fqr = veVar;
                cfVar.fqp.desc = mVar.title;
                cfVar.fqp.type = 5;
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetFavDataSource", e, "", new Object[0]);
            x.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
        cfVar.fqp.fqv = R.l.efq;
        return false;
    }

    private static boolean a(cf cfVar, com.tencent.mm.y.g.a aVar, ve veVar, au auVar) {
        com.tencent.mm.sdk.b.b mtVar = new mt();
        mtVar.fEE.type = 0;
        mtVar.fEE.fEG = aVar.hbB;
        a.xef.m(mtVar);
        c cVar = mtVar.fEF.fEO;
        if (cVar == null) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
            cfVar.fqp.fqv = R.l.efq;
            return false;
        }
        veVar.Ug(cVar.title);
        Iterator it = cVar.hdX.iterator();
        int i = 0;
        while (it.hasNext()) {
            uq uqVar;
            int i2;
            uq uqVar2 = (uq) it.next();
            uq p;
            vs vsVar;
            long j;
            com.tencent.mm.sdk.b.b mtVar2;
            vs vsVar2;
            switch (uqVar2.bjS) {
                case 1:
                    p = p(uqVar2);
                    p.CJ(1);
                    p.Tr(uqVar2.desc);
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfk++;
                    uqVar = p;
                    break;
                case 2:
                    j = auVar.field_msgId;
                    p = p(uqVar2);
                    p.CJ(2);
                    mtVar2 = new mt();
                    mtVar2.fEE.type = 1;
                    mtVar2.fEE.fve = uqVar2;
                    mtVar2.fEE.fqm = j;
                    a.xef.m(mtVar2);
                    if (bh.ov(mtVar2.fEF.fEP) && bh.ov(mtVar2.fEF.fvC)) {
                        x.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                    }
                    p.TE(mtVar2.fEF.fEP);
                    p.TF(mtVar2.fEF.fvC);
                    p.lt(false);
                    p.ls(false);
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfl++;
                    uqVar = p;
                    break;
                case 3:
                    j = auVar.field_msgId;
                    p = p(uqVar2);
                    p.CJ(3);
                    if (!bh.ov(uqVar2.wdL)) {
                        mtVar2 = new mt();
                        mtVar2.fEE.type = 1;
                        mtVar2.fEE.fve = uqVar2;
                        mtVar2.fEE.fqm = j;
                        a.xef.m(mtVar2);
                        if (bh.ov(mtVar2.fEF.fEP) && bh.ov(mtVar2.fEF.fvC)) {
                            x.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                        }
                        p.TE(mtVar2.fEF.fEP);
                        p.CI(uqVar2.duration);
                        p.lt(true);
                        p.ls(false);
                        p.TA(uqVar2.wcY);
                    }
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfm++;
                    uqVar = p;
                    break;
                case 4:
                case 15:
                    j = auVar.field_msgId;
                    p = p(uqVar2);
                    a(p, uqVar2);
                    if (uqVar2.bjS == 15) {
                        p.CJ(15);
                    } else {
                        p.CJ(4);
                    }
                    mtVar2 = new mt();
                    mtVar2.fEE.type = 1;
                    mtVar2.fEE.fve = uqVar2;
                    mtVar2.fEE.fqm = j;
                    a.xef.m(mtVar2);
                    if (bh.ov(mtVar2.fEF.fEP) && bh.ov(mtVar2.fEF.fvC)) {
                        x.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
                    }
                    p.ls(false);
                    p.TE(mtVar2.fEF.fEP);
                    p.lt(false);
                    p.TF(mtVar2.fEF.fvC);
                    p.CI(uqVar2.duration);
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfn++;
                    uqVar = p;
                    break;
                case 5:
                    j = auVar.field_msgId;
                    p = p(uqVar2);
                    a(p, uqVar2);
                    p.CJ(5);
                    mtVar2 = new mt();
                    mtVar2.fEE.type = 1;
                    mtVar2.fEE.fve = uqVar2;
                    mtVar2.fEE.fqm = j;
                    a.xef.m(mtVar2);
                    if (bh.ov(mtVar2.fEF.fEP) && bh.ov(mtVar2.fEF.fvC)) {
                        x.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
                    }
                    p.TF(mtVar2.fEF.fvC);
                    p.lt(false);
                    if (!(uqVar2.wdD == null || uqVar2.wdD.web == null)) {
                        vt vtVar = new vt();
                        vtVar.Uv(uqVar2.wdD.web.title);
                        vtVar.Uw(uqVar2.wdD.web.desc);
                        vtVar.Uy(uqVar2.wdD.web.thumbUrl);
                        vtVar.CT(uqVar2.wdD.web.wfB);
                        vtVar.Ux(uqVar2.wdD.web.wfz);
                        p.wdD.a(vtVar);
                    }
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfo++;
                    uqVar = p;
                    break;
                case 6:
                    p = p(uqVar2);
                    p.CJ(6);
                    if (!(uqVar2.wdD == null || uqVar2.wdD.wdZ == null)) {
                        ux uxVar = new ux();
                        uxVar.TZ(uqVar2.wdD.wdZ.label);
                        uxVar.s(uqVar2.wdD.wdZ.lat);
                        uxVar.r(uqVar2.wdD.wdZ.lng);
                        uxVar.CO(uqVar2.wdD.wdZ.fzv);
                        uxVar.Ua(uqVar2.wdD.wdZ.fDu);
                        p.wdD.a(uxVar);
                    }
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfp++;
                    uqVar = p;
                    break;
                case 7:
                    j = auVar.field_msgId;
                    p = p(uqVar2);
                    a(p, uqVar2);
                    p.CJ(7);
                    mtVar2 = new mt();
                    mtVar2.fEE.type = 1;
                    mtVar2.fEE.fve = uqVar2;
                    mtVar2.fEE.fqm = j;
                    a.xef.m(mtVar2);
                    if (bh.ov(mtVar2.fEF.fEP) && bh.ov(mtVar2.fEF.fvC)) {
                        x.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
                    }
                    p.TF(mtVar2.fEF.fvC);
                    p.lt(false);
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfq++;
                    uqVar = p;
                    break;
                case 8:
                    j = auVar.field_msgId;
                    p = p(uqVar2);
                    a(p, uqVar2);
                    p.CJ(8);
                    mtVar2 = new mt();
                    mtVar2.fEE.type = 1;
                    mtVar2.fEE.fve = uqVar2;
                    mtVar2.fEE.fqm = j;
                    a.xef.m(mtVar2);
                    if (bh.ov(mtVar2.fEF.fEP) && bh.ov(mtVar2.fEF.fvC)) {
                        x.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
                    }
                    p.TE(mtVar2.fEF.fEP);
                    p.TF(mtVar2.fEF.fvC);
                    p.ls(false);
                    p.TA(uqVar2.wcY);
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfr++;
                    uqVar = p;
                    break;
                case 10:
                    uqVar2 = c(uqVar2, uqVar2.bjS);
                    vsVar2 = cfVar.fqp.fqs;
                    vsVar2.wft++;
                    uqVar = uqVar2;
                    break;
                case 11:
                    uqVar2 = c(uqVar2, uqVar2.bjS);
                    vsVar2 = cfVar.fqp.fqs;
                    vsVar2.wfu++;
                    uqVar = uqVar2;
                    break;
                case 12:
                case 14:
                    p = p(uqVar2);
                    p.CJ(14);
                    if (!(uqVar2.wdD == null || uqVar2.wdD.wef == null)) {
                        vn vnVar = new vn();
                        vnVar.Ur(uqVar2.wdD.wef.title);
                        vnVar.Us(uqVar2.wdD.wef.desc);
                        vnVar.Uu(uqVar2.wdD.wef.info);
                        vnVar.Ut(uqVar2.wdD.wef.thumbUrl);
                        p.wdD.a(vnVar);
                    }
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfx++;
                    uqVar = p;
                    break;
                case 16:
                    p = p(uqVar2);
                    p.CJ(16);
                    p.Tr(uqVar2.desc);
                    vsVar = cfVar.fqp.fqs;
                    vsVar.wfy++;
                    uqVar = p;
                    break;
                case 17:
                    p = p(uqVar2);
                    p.Tq(uqVar2.title);
                    p.Tr(uqVar2.desc);
                    p.CJ(17);
                    p.TQ(uqVar2.wdT);
                    uqVar = p;
                    break;
                default:
                    uqVar = null;
                    break;
            }
            if (uqVar != null) {
                String format;
                int i3 = i + 1;
                if (auVar.field_isSend != 1) {
                    format = String.format("%d$%d", new Object[]{Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i)});
                } else if (s.eV(auVar.field_talker) || auVar.field_talker.equals("filehelper")) {
                    format = String.format("%d$%d", new Object[]{Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i)});
                } else {
                    format = String.format("%s#%d$%d", new Object[]{auVar.field_talker, Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i)});
                }
                uqVar.TI(format);
                veVar.weU.add(uqVar);
                i2 = i3;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (bh.ov(((uq) cVar.hdX.get(0)).wcY) || !((uq) cVar.hdX.get(0)).wcY.equals(".htm")) {
            cfVar.fqp.type = 14;
        } else {
            cfVar.fqp.type = 18;
        }
        return true;
    }

    private static uq p(uq uqVar) {
        uq uqVar2 = new uq();
        ur urVar = new ur();
        us usVar = new us();
        us usVar2 = uqVar.wdD.wdX;
        if (usVar2.wep) {
            usVar.TR(usVar2.fzO);
        }
        if (usVar2.weq) {
            usVar.TS(usVar2.toUser);
        }
        if (usVar2.weu) {
            usVar.TU(usVar2.wet);
        }
        usVar.CN(1);
        usVar.fz(bh.Wp());
        urVar.c(usVar);
        uqVar2.a(urVar);
        uqVar2.TL(uqVar.wdF);
        uqVar2.TM(uqVar.wdH);
        uqVar2.lt(true);
        uqVar2.ls(true);
        uqVar2.TN(uqVar.wdL);
        uqVar2.CL(uqVar.wdR);
        uqVar2.TB(uqVar.wda);
        uqVar2.TC(uqVar.wdc);
        uqVar2.fw(uqVar.wde);
        uqVar2.TG(uqVar.wdl);
        uqVar2.TH(uqVar.wdn);
        uqVar2.fx(uqVar.wdp);
        return uqVar2;
    }

    private static void a(uq uqVar, uq uqVar2) {
        uqVar.Tx(uqVar2.wcS);
        uqVar.Ty(uqVar2.wcU);
        uqVar.Tw(uqVar2.wcQ);
        uqVar.Tq(uqVar2.title);
        uqVar.Tr(uqVar2.desc);
    }

    private static uq c(uq uqVar, int i) {
        uq p = p(uqVar);
        p.CJ(i);
        if (!(uqVar.wdD == null || uqVar.wdD.wed == null)) {
            vd vdVar = new vd();
            vdVar.Ub(uqVar.wdD.wed.title);
            vdVar.Uc(uqVar.wdD.wed.desc);
            vdVar.CP(uqVar.wdD.wed.type);
            vdVar.Ue(uqVar.wdD.wed.info);
            vdVar.Ud(uqVar.wdD.wed.thumbUrl);
            p.wdD.a(vdVar);
        }
        return p;
    }
}
