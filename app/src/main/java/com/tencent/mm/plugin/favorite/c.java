package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.b.a.1;
import com.tencent.mm.plugin.favorite.ui.FavTipsUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class c extends com.tencent.mm.sdk.b.c<cf> {
    public c() {
        this.xen = cf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = -2;
        cf cfVar = (cf) bVar;
        if (-2 == cfVar.fqp.type) {
            long j = bh.getLong(cfVar.fqp.fqf, -1);
            if (0 >= j) {
                x.w("MicroMsg.Fav.FavAddItemListener", "error fav info local id");
            } else {
                f db = h.getFavItemInfoStorage().db(j);
                if (bh.ov(db.field_favProto.iIj)) {
                    g.pQN.h(10873, new Object[]{Integer.valueOf(6)});
                } else {
                    g.pQN.h(10874, new Object[]{Integer.valueOf(6)});
                }
                db.field_favProto.Uf(cfVar.fqp.desc);
                h.getFavItemInfoStorage().a(db, new String[]{"rowid"});
                String str = cfVar.fqp.desc;
                if (db == null) {
                    x.w("MicroMsg.Fav.ModFavItemLogic", "modRemark, item info is null");
                } else if (db.field_id <= 0) {
                    x.w("MicroMsg.Fav.ModFavItemLogic", "modRemark favid:%d", new Object[]{Integer.valueOf(db.field_id)});
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    LinkedList linkedList = new LinkedList();
                    aru com_tencent_mm_protocal_c_aru = new aru();
                    com_tencent_mm_protocal_c_aru.wzz = 4;
                    com_tencent_mm_protocal_c_aru.wzA = 0;
                    linkedList.add(com_tencent_mm_protocal_c_aru);
                    LinkedList linkedList2 = new LinkedList();
                    arx com_tencent_mm_protocal_c_arx = new arx();
                    com_tencent_mm_protocal_c_arx.niX = "favitem.remark";
                    com_tencent_mm_protocal_c_arx.pQt = str;
                    linkedList2.add(com_tencent_mm_protocal_c_arx);
                    arx com_tencent_mm_protocal_c_arx2 = new arx();
                    com_tencent_mm_protocal_c_arx2.niX = "favitem.remark";
                    com_tencent_mm_protocal_c_arx2.wzF = "time";
                    com_tencent_mm_protocal_c_arx2.pQt = String.valueOf(currentTimeMillis);
                    linkedList2.add(com_tencent_mm_protocal_c_arx2);
                    ar.CG().a(new r(db.field_id, linkedList, linkedList2), 0);
                }
            }
        } else {
            cf.b bVar2 = cfVar.fqq;
            if (cfVar == null || cfVar.fqp == null) {
                i = -1;
            } else {
                int i2;
                if (cfVar.fqp.fqr == null) {
                    x.w("MicroMsg.Fav.FavAddService", "handleEvent error, event is null");
                    if (cfVar.fqp.fqv == 0) {
                        cfVar.fqp.fqv = R.l.efh;
                    }
                    i2 = cfVar.fqp.fqv;
                } else {
                    i2 = 0;
                }
                if (cfVar.fqp.activity == null && cfVar.fqp.pL == null) {
                    x.i("MicroMsg.Fav.FavAddService", "handleEvent context = null && frament = null");
                }
                if (cfVar.fqp.fqv > 0) {
                    i = cfVar.fqp.fqv;
                } else if (j.pJ(cfVar.fqp.type)) {
                    b fvVar = new fv();
                    fvVar.fvq.type = 36;
                    a.xef.m(fvVar);
                    if (fvVar.fvr.ret != 1) {
                        i = cfVar.fqp.fqv;
                        cfVar.fqp.fqx = new 1(cfVar);
                    }
                } else {
                    i = i2;
                }
                ar.Hg();
                if (((Integer) com.tencent.mm.z.c.CU().get(225281, Integer.valueOf(0))).intValue() != 1) {
                    x.i("MicroMsg.Fav.FavAddService", "try show intro ui");
                    Context context = cfVar.fqp.activity;
                    if (context instanceof Activity) {
                        Intent intent = new Intent(context, FavTipsUI.class);
                        if (!(context instanceof Activity)) {
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        }
                        context.startActivity(intent);
                    }
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(225281, Integer.valueOf(1));
                }
                com.tencent.mm.pluginsdk.model.c.a(cfVar.fqp.type, i, cfVar.fqp.fqw, cfVar.fqp.activity, cfVar.fqp.pL, cfVar.fqp.fqy, cfVar.fqp.fqx, null);
                x.i("MicroMsg.Fav.FavAddService", "err Type = %d", new Object[]{Integer.valueOf(i)});
                if (i == -9 || i == 0) {
                    i = com.tencent.mm.plugin.favorite.b.a.a(cfVar);
                }
            }
            bVar2.ret = i;
        }
        return false;
    }
}
