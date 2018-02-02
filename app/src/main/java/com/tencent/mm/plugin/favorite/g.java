package com.tencent.mm.plugin.favorite;

import com.tencent.mm.av.a.a;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.fv.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.a.i;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.a.t;
import com.tencent.mm.plugin.favorite.ui.b.e;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends c<fv> {
    public g() {
        this.xen = fv.class.getName().hashCode();
    }

    private static boolean a(fv fvVar) {
        f db;
        String[] a;
        List arrayList;
        b bVar;
        int intValue;
        f dc;
        switch (fvVar.fvq.type) {
            case 2:
                if (fvVar.fvq.fvs != null) {
                    File file = new File(j.h(fvVar.fvq.fvs));
                    if (file.exists()) {
                        fvVar.fvr.path = file.getAbsolutePath();
                    }
                    file = new File(j.i(fvVar.fvq.fvs));
                    if (file.exists()) {
                        fvVar.fvr.fvC = file.getAbsolutePath();
                        break;
                    }
                }
                break;
            case 4:
                db = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                if (!(db == null || db.field_tagProto.wfj == null)) {
                    fvVar.fvr.auX = new ArrayList();
                    fvVar.fvr.auX.addAll(db.field_tagProto.wfj);
                    break;
                }
            case 6:
                h.getFavItemInfoStorage().c(fvVar.fvq.fvu);
                fvVar.fvr.ret = 0;
                break;
            case 7:
                h.getFavItemInfoStorage().j(fvVar.fvq.fvu);
                fvVar.fvr.ret = 0;
                break;
            case 8:
                fvVar.fvr.fvE = h.getFavItemInfoStorage().aHY();
                fvVar.fvr.ret = 0;
                break;
            case 9:
                db = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                fvVar.fvr.fvD = com.tencent.mm.pluginsdk.model.c.a(db.field_type, db.field_favProto, db.field_tagProto);
                fvVar.fvr.ret = 0;
                break;
            case 10:
                e.a(fvVar.fvq.context, h.getFavItemInfoStorage().db(fvVar.fvq.fqk), fvVar.fvq.fvB);
                fvVar.fvr.ret = 0;
                break;
            case 11:
                a = e.a(h.getFavItemInfoStorage().db(fvVar.fvq.fqk), fvVar.fvq.handler);
                fvVar.fvr.fvC = a[0];
                fvVar.fvr.thumbUrl = a[1];
                fvVar.fvr.ret = 0;
                break;
            case 12:
                j.a(fvVar.fvq.fqk, fvVar.fvq.fvv);
                break;
            case 13:
                db = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                j.y(db);
                if (db == null && fvVar.fvq.fqr != null) {
                    db = j.a(fvVar.fvq.fqr);
                }
                com.tencent.mm.plugin.favorite.a.e.a(fvVar.fvq.context, fvVar.fvq.toUser, fvVar.fvq.fvw, db, fvVar.fvq.fvv);
                break;
            case 14:
                if (!j.e(fvVar.fvq.fvs)) {
                    fvVar.fvr.ret = 0;
                    break;
                }
                fvVar.fvr.ret = 1;
                break;
            case 15:
                j.n(h.getFavItemInfoStorage().db(fvVar.fvq.fqk));
                break;
            case 16:
                j.o(h.getFavItemInfoStorage().db(fvVar.fvq.fqk));
                break;
            case 17:
                fvVar.fvr.ret = j.Ae(fvVar.fvq.fvs.wcY);
                break;
            case 18:
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(7));
                List<f> a2 = j.a(null, null, arrayList, null, null, null);
                List arrayList2 = new ArrayList();
                for (f db2 : a2) {
                    vk vkVar = db2.field_favProto.weS;
                    uq p;
                    if (db2.field_type == 7) {
                        p = j.p(db2);
                        arrayList2.add(((a) com.tencent.mm.kernel.g.h(a.class)).a(6, null, p.title, p.desc, p.wcQ, p.wcU, p.wcS, p.mvG, j.aIG(), b(p), "", vkVar.appId));
                    } else if (db2.field_type == 14 && db2.field_favProto.weU != null) {
                        Iterator it = db2.field_favProto.weU.iterator();
                        while (it.hasNext()) {
                            p = (uq) it.next();
                            if (p.bjS == 7) {
                                arrayList2.add(((a) com.tencent.mm.kernel.g.h(a.class)).a(6, null, p.title, p.desc, p.wcQ, p.wcU, p.wcS, p.mvG, j.aIG(), b(p), "", vkVar.appId));
                            }
                        }
                    }
                }
                fvVar.fvr.fvF = arrayList2;
                break;
            case 19:
                if (fvVar.fvq.fqk != -1) {
                    j.b(fvVar);
                    break;
                }
                com.tencent.mm.plugin.favorite.a.c.a(fvVar.fvq.title, fvVar.fvq.fqr.weU, -1);
                break;
            case 20:
                i.a aIX = t.aIX();
                i aIY = t.aIY();
                t.mqV = aIY;
                aIY.a(aIX);
                t.mqV.mqm = true;
                i iVar = t.mqV;
                if (i.kCP == null) {
                    i.kCP = new SensorController(ac.getContext());
                }
                if (iVar.kCT == null) {
                    iVar.kCT = new ay(ac.getContext());
                }
                t aIX2 = t.aIX();
                String str = fvVar.fvq.title;
                int i = fvVar.fvq.fvx;
                int i2 = fvVar.fvq.fvy;
                aIX2.path = bh.az(str, "");
                aIX2.fvx = i;
                aIX2.duration = i2;
                break;
            case 21:
                fvVar.fvr.path = com.tencent.mm.plugin.favorite.a.g.v(fvVar.fvq.context, fvVar.fvq.fvy).toString();
                break;
            case 22:
                t.aIX();
                t.aIZ().destroy();
                break;
            case 23:
                t.aIX();
                t.aIZ().aIC();
                break;
            case 24:
                bVar = fvVar.fvr;
                t.aIX();
                bVar.fvG = t.aIZ().G(fvVar.fvq.path, fvVar.fvq.fvx, fvVar.fvq.fvy);
                break;
            case 25:
                t.aIX();
                t.aIZ().stopPlay();
                break;
            case 26:
                bVar = fvVar.fvr;
                t.aIX();
                bVar.path = t.aIZ().path;
                bVar = fvVar.fvr;
                t.aIX();
                bVar.fvG = t.aIZ().aIA();
                bVar = fvVar.fvr;
                t.aIX();
                bVar.fvH = t.aIZ().aIB();
                bVar = fvVar.fvr;
                t.aIX();
                bVar.fvI = t.aIZ().vg();
                bVar = fvVar.fvr;
                t.aIX();
                bVar.fvJ = t.aIZ().vf();
                break;
            case 27:
                if (fvVar.fvq.fvs != null) {
                    fvVar.fvr.path = new File(j.h(fvVar.fvq.fvs)).getAbsolutePath();
                    fvVar.fvr.fvC = new File(j.i(fvVar.fvq.fvs)).getAbsolutePath();
                    break;
                }
                break;
            case 28:
                db2 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                if (db2 != null) {
                    if (!bh.ov(fvVar.fvq.path)) {
                        j.b(db2, fvVar.fvq.fvs, true);
                        break;
                    }
                    j.a(db2, fvVar.fvq.fvs, true);
                    break;
                }
                j.a(fvVar.fvq.fvs, fvVar.fvq.fvx);
                j.b(fvVar.fvq.fvs, fvVar.fvq.fvx);
                break;
            case 30:
                j.d(fvVar);
                break;
            case 31:
                r rVar = (r) fvVar.fvq.frb;
                fvVar.fvr.path = rVar.mqR;
                j.a(rVar);
                break;
            case 32:
                db2 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                if (db2 == null && fvVar.fvq.fqr != null) {
                    db2 = j.a(fvVar.fvq.fqr);
                }
                fvVar.fvr.ret = new d().e(db2) ? 1 : 0;
                fvVar.fvr.fvI = d.k(db2);
                fvVar.fvr.path = "";
                if (db2 == null) {
                    fvVar.fvr.fvI = true;
                    fvVar.fvr.path = null;
                    break;
                }
                break;
            case 33:
                db2 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                if (db2 != null) {
                    db2.field_favProto.av(fvVar.fvq.fqr.weU);
                    h.getFavItemInfoStorage().b(db2, new String[]{"localId"});
                    break;
                }
                break;
            case 34:
                db2 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                if (db2 != null && db2.field_type == 18) {
                    fvVar.fvq.fqr = db2.field_favProto;
                    break;
                }
            case 35:
                j.aIP();
                break;
            case 36:
                fvVar.fvr.ret = j.aIN() ? 1 : 0;
                break;
            case 37:
                j.d(fvVar.fvq.context, fvVar.fvq.desc, fvVar.fvq.title, fvVar.fvq.path);
                break;
            case 38:
                x.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[]{fvVar.fvq.fvz});
                if (!bh.ov(fvVar.fvq.fvz)) {
                    a = fvVar.fvq.fvz.split(";");
                    List<String> linkedList = new LinkedList();
                    linkedList.addAll(Arrays.asList(a));
                    if (linkedList.size() > 0) {
                        arrayList = new ArrayList();
                        for (String valueOf : linkedList) {
                            try {
                                intValue = Integer.valueOf(valueOf).intValue();
                                if (intValue > 0) {
                                    dc = h.getFavItemInfoStorage().dc((long) intValue);
                                    uw uwVar = new uw();
                                    uwVar.vGM = intValue;
                                    if (!(dc == null || bh.ov(dc.field_xml))) {
                                        uwVar.vGT = dc.field_xml;
                                    }
                                    arrayList.add(uwVar);
                                }
                            } catch (Exception e) {
                            }
                        }
                        ((com.tencent.mm.plugin.fav.a.r) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fav.a.r.class)).checkFavItem(arrayList);
                        x.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                        break;
                    }
                }
                break;
            case 39:
                try {
                    x.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[]{fvVar.fvq.fvz, fvVar.fvq.fvA});
                    intValue = bh.getInt(fvVar.fvq.fvz, -1);
                    Collection F = bh.F(fvVar.fvq.fvA.split(";"));
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(F);
                    dc = h.getFavItemInfoStorage().dc((long) intValue);
                    if (dc != null) {
                        vh vhVar = new vh();
                        vhVar.vGM = intValue;
                        Object obj = null;
                        for (uq uqVar : dc.field_favProto.weU) {
                            vx vxVar;
                            if (hashSet.remove(uqVar.mvG + "#0")) {
                                if (bh.ov(uqVar.wcL)) {
                                    com.tencent.mm.modelcdntran.g.MK();
                                    uqVar.Tv(com.tencent.mm.modelcdntran.b.MC());
                                    com.tencent.mm.plugin.fav.a.g.pE(2);
                                }
                                if (FileOp.bO(j.h(uqVar))) {
                                    uqVar.CM(1);
                                    j.a(uqVar, dc, 0, false);
                                    com.tencent.mm.plugin.fav.a.g.pE(3);
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.fav.a.g.pE(5);
                                    vxVar = new vx();
                                    vxVar.vVg = uqVar.mvG;
                                    vxVar.vVm = 0;
                                    vxVar.ktm = 4;
                                    vhVar.weX.add(vxVar);
                                }
                            }
                            if (hashSet.remove(uqVar.mvG + "#1")) {
                                if (bh.ov(uqVar.wcL)) {
                                    com.tencent.mm.modelcdntran.g.MK();
                                    uqVar.Tv(com.tencent.mm.modelcdntran.b.MC());
                                    com.tencent.mm.plugin.fav.a.g.pE(2);
                                }
                                if (FileOp.bO(j.i(uqVar))) {
                                    uqVar.CM(-1);
                                    j.a(uqVar, dc, 0);
                                    com.tencent.mm.plugin.fav.a.g.pE(3);
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.fav.a.g.pE(5);
                                    vxVar = new vx();
                                    vxVar.vVg = uqVar.mvG;
                                    vxVar.vVm = 1;
                                    vxVar.ktm = 4;
                                    vhVar.weX.add(vxVar);
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            x.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[]{hashSet.toString()});
                            com.tencent.mm.plugin.fav.a.g.pF(hashSet.size());
                            Iterator it2 = hashSet.iterator();
                            while (it2.hasNext()) {
                                try {
                                    a = ((String) it2.next()).split("#");
                                    vx vxVar2 = new vx();
                                    vxVar2.vVg = a[0];
                                    vxVar2.vVm = Integer.valueOf(a[1]).intValue();
                                    vxVar2.ktm = 3;
                                    vhVar.weX.add(vxVar2);
                                } catch (Exception e2) {
                                }
                            }
                        }
                        if (vhVar.weX.size() > 0) {
                            ((com.tencent.mm.plugin.fav.a.r) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fav.a.r.class)).checkFavItem(vhVar);
                        }
                        if (obj == null) {
                            com.tencent.mm.plugin.fav.a.g.pE(7);
                            x.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                            break;
                        }
                        if (dc.field_type == 18) {
                            dc.field_favProto.CR(dc.field_favProto.version + 1);
                        }
                        dc.field_itemStatus = 15;
                        h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                        h.aIr().run();
                        com.tencent.mm.plugin.fav.a.g.pE(6);
                        break;
                    }
                    x.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[]{Integer.valueOf(intValue)});
                    com.tencent.mm.plugin.fav.a.g.pE(8);
                    break;
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", e3, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                    break;
                }
        }
        return false;
    }

    private static String b(uq uqVar) {
        File file = new File(j.i(uqVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        if (uqVar.fqf == null) {
            return "";
        }
        file = new File(j.aIE() + com.tencent.mm.a.g.s(uqVar.fqf.getBytes()));
        return file.exists() ? file.getAbsolutePath() : "";
    }
}
