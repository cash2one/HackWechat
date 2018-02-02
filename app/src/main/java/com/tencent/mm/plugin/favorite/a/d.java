package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.a.e;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;

public final class d implements n {
    public boolean mpz = true;

    public final boolean e(f fVar) {
        if (fVar == null) {
            return true;
        }
        if (j.w(fVar)) {
            return true;
        }
        f db = h.getFavItemInfoStorage().db(fVar.field_localId);
        uq p;
        vd vdVar;
        switch (fVar.field_type) {
            case 1:
                return bh.ov(fVar.field_favProto.desc);
            case 2:
            case 8:
                return !new File(j.h(j.p(fVar))).exists();
            case 3:
                if (this.mpz) {
                    return true;
                }
                return false;
            case 4:
                p = j.p(fVar);
                if (new File(j.h(p)).exists()) {
                    return false;
                }
                return bh.ov(p.wcQ);
            case 5:
                vk vkVar = fVar.field_favProto.weS;
                vt vtVar = fVar.field_favProto.web;
                String str = null;
                if (vtVar != null) {
                    str = vtVar.wfz;
                }
                if (vkVar != null && bh.ov(r0)) {
                    str = vkVar.hOf;
                }
                return bh.ov(str);
            case 6:
                return fVar.field_favProto.wdZ == null;
            case 7:
                p = j.p(fVar);
                return bh.ov(p.wcQ) && bh.ov(p.wcS) && bh.ov(p.wcU) && bh.ov(p.wcU);
            case 10:
                vdVar = fVar.field_favProto.wed;
                return vdVar == null || bh.ov(vdVar.info);
            case 11:
                vdVar = fVar.field_favProto.wed;
                return vdVar == null || bh.ov(vdVar.info);
            case 14:
            case 18:
                if (fVar.field_id <= 0 && db != null) {
                    return true;
                }
                if (fVar.field_type == 18 && (fVar.field_favProto == null || fVar.field_favProto.weU.size() <= 1)) {
                    return true;
                }
                if (fVar.field_type == 18 && (bh.ov(((uq) fVar.field_favProto.weU.get(0)).wcJ) || bh.ov(((uq) fVar.field_favProto.weU.get(0)).wcL))) {
                    return true;
                }
                Iterator it = fVar.field_favProto.weU.iterator();
                while (it.hasNext()) {
                    p = (uq) it.next();
                    if ((p.bjS == 2 || p.bjS == 8 || p.bjS == 15 || p.bjS == 4) && !e.bO(j.h(p))) {
                        return true;
                    }
                }
                return false;
            case 15:
                vn vnVar = fVar.field_favProto.wef;
                return vnVar == null || bh.ov(vnVar.info);
            case 16:
                if (bh.VI(g.zY().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                }
                p = j.p(fVar);
                File file = new File(j.h(p));
                x.v("MicroMsg.FavSendFilter", "type size, favid %d, localid %d, path %s, exist %B", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), file.getAbsolutePath(), Boolean.valueOf(file.exists())});
                if (!file.exists()) {
                    return true;
                }
                if (Math.abs(p.wde - file.length()) <= 16) {
                    return false;
                }
                String i = com.tencent.mm.a.g.i(file);
                x.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", new Object[]{Long.valueOf(r2), i, Long.valueOf(r4), p.wda});
                return true;
            default:
                return false;
        }
    }

    public static boolean c(uq uqVar) {
        if (uqVar == null) {
            return true;
        }
        switch (uqVar.bjS) {
            case 2:
            case 8:
                if (new File(j.h(uqVar)).exists()) {
                    return false;
                }
                return true;
            case 3:
                return true;
            case 4:
                if (new File(j.h(uqVar)).exists()) {
                    return false;
                }
                return bh.ov(uqVar.wcQ);
            case 7:
                if (bh.ov(uqVar.wcQ) && bh.ov(uqVar.wcS) && bh.ov(uqVar.wcU) && bh.ov(uqVar.wcU)) {
                    return true;
                }
                return false;
            case 15:
                if (bh.VI(g.zY().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                } else if (new File(j.h(uqVar)).exists()) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    public static boolean k(f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar.field_itemStatus > 0 && !j.u(fVar)) {
            return false;
        }
        f db = h.getFavItemInfoStorage().db(fVar.field_localId);
        File file = new File(j.h(j.p(fVar)));
        switch (fVar.field_type) {
            case 2:
            case 8:
                if (!file.exists()) {
                    return true;
                }
                break;
            case 4:
                if (bh.ov(j.p(fVar).wcQ) && !file.exists()) {
                    return true;
                }
            case 14:
            case 18:
                if (fVar.field_id > 0 || db == null) {
                    if (fVar.field_favProto != null && fVar.field_favProto.weU.size() > 1) {
                        Iterator it = fVar.field_favProto.weU.iterator();
                        while (it.hasNext()) {
                            uq uqVar = (uq) it.next();
                            if (!bh.ov(uqVar.wcJ) && !bh.ov(uqVar.wcL) && !e.bO(j.h(uqVar))) {
                                return true;
                            }
                        }
                        break;
                    }
                    return false;
                }
                return false;
                break;
            case 16:
                if (bh.VI(g.zY().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return false;
                } else if (!file.exists()) {
                    return true;
                }
                break;
        }
        return false;
    }
}
