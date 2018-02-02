package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.e;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.d;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class k {
    public static void a(f fVar, int i) {
        if (fVar == null) {
            x.w("MicroMsg.Fav.ModFavItemLogic", "modeTag, item info is null");
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        aru com_tencent_mm_protocal_c_aru = new aru();
        com_tencent_mm_protocal_c_aru.wzz = 4;
        com_tencent_mm_protocal_c_aru.wzA = 0;
        linkedList.add(com_tencent_mm_protocal_c_aru);
        LinkedList linkedList2 = new LinkedList();
        arx com_tencent_mm_protocal_c_arx = new arx();
        com_tencent_mm_protocal_c_arx.niX = "favitem.taglist";
        com_tencent_mm_protocal_c_arx.ktN = 1;
        StringBuffer stringBuffer = new StringBuffer();
        int size = fVar.field_tagProto.wfj.size();
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bh.VG((String) fVar.field_tagProto.wfj.get(i2))).append("</tag>");
        }
        com_tencent_mm_protocal_c_arx.pQt = stringBuffer.toString();
        x.v("MicroMsg.Fav.ModFavItemLogic", "do net scene mod tag, id=%d, tag=%s", new Object[]{Integer.valueOf(fVar.field_id), com_tencent_mm_protocal_c_arx.pQt});
        linkedList2.add(com_tencent_mm_protocal_c_arx);
        if (fVar.field_id > 0) {
            ar.CG().a(new r(fVar.field_id, linkedList, linkedList2), 0);
            g.pQN.h(11122, new Object[]{Integer.valueOf(fVar.field_id), Integer.valueOf(size), Integer.valueOf(h.aIq().aIx()), Integer.valueOf(i)});
            return;
        }
        d aIu = h.aIu();
        long j = fVar.field_localId;
        x.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[]{Long.valueOf(j)});
        e da = h.aIt().da(j);
        if (da == null) {
            da = new e();
            i2 = 1;
        } else {
            i2 = 0;
        }
        da.field_localId = j;
        uu uuVar = new uu();
        uuVar.mqQ = linkedList;
        uuVar.weD = linkedList2;
        da.field_modItem = uuVar;
        da.field_time = bh.Wp();
        da.field_type = 0;
        da.field_scene = i;
        if (i2 != 0) {
            h.aIt().a(da);
        } else {
            h.aIt().a(da, "localId");
        }
        aIu.run();
    }

    public static void a(long j, LinkedList<aru> linkedList, LinkedList<arx> linkedList2) {
        aru com_tencent_mm_protocal_c_aru = new aru();
        com_tencent_mm_protocal_c_aru.wzz = 4;
        com_tencent_mm_protocal_c_aru.wzA = 0;
        linkedList.add(com_tencent_mm_protocal_c_aru);
        x.i("MicroMsg.Fav.ModFavItemLogic", "setModAfterClientUpload %d modcdnlistsize %d", new Object[]{Long.valueOf(j), Integer.valueOf(h.aIs().cX(j).size())});
        for (c cVar : r0) {
            boolean Ad = j.Ad(cVar.field_dataId);
            if (bh.ov(cVar.field_cdnUrl) || Ad) {
                x.e("MicroMsg.Fav.ModFavItemLogic", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[]{cVar.field_cdnUrl, Boolean.valueOf(Ad), Long.valueOf(j)});
            } else {
                arx com_tencent_mm_protocal_c_arx = new arx();
                com_tencent_mm_protocal_c_arx.niX = "dataitem." + cVar.field_dataId + ".cdn_dataurl";
                com_tencent_mm_protocal_c_arx.pQt = cVar.field_cdnUrl;
                linkedList2.add(com_tencent_mm_protocal_c_arx);
                com_tencent_mm_protocal_c_arx = new arx();
                com_tencent_mm_protocal_c_arx.niX = "dataitem." + cVar.field_dataId + ".cdn_datakey";
                com_tencent_mm_protocal_c_arx.pQt = cVar.field_cdnKey;
                linkedList2.add(com_tencent_mm_protocal_c_arx);
                com_tencent_mm_protocal_c_arx = new arx();
                com_tencent_mm_protocal_c_arx.niX = "dataitem." + cVar.field_dataId;
                com_tencent_mm_protocal_c_arx.wzF = "datastatus";
                com_tencent_mm_protocal_c_arx.pQt = "0";
                linkedList2.add(com_tencent_mm_protocal_c_arx);
                f db = h.getFavItemInfoStorage().db(cVar.field_favLocalId);
                if (db != null) {
                    if ((db.field_type == 4 ? 1 : 0) != 0) {
                        uq a = j.a(db, cVar.field_dataId);
                        arx com_tencent_mm_protocal_c_arx2 = new arx();
                        com_tencent_mm_protocal_c_arx2.niX = "dataitem." + cVar.field_dataId + ".stream_videoid";
                        com_tencent_mm_protocal_c_arx2.pQt = a.wdt;
                        linkedList2.add(com_tencent_mm_protocal_c_arx2);
                    }
                }
            }
        }
    }
}
