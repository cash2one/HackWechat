package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.c;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.a;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

class FavoriteIndexUI$8 implements Runnable {
    final /* synthetic */ FavoriteIndexUI mtS;
    final /* synthetic */ double mtY;
    final /* synthetic */ double mtZ;
    final /* synthetic */ int mua;
    final /* synthetic */ String mub;
    final /* synthetic */ CharSequence muc;
    final /* synthetic */ String mud;
    final /* synthetic */ ArrayList mue;

    FavoriteIndexUI$8(FavoriteIndexUI favoriteIndexUI, double d, double d2, int i, String str, CharSequence charSequence, String str2, ArrayList arrayList) {
        this.mtS = favoriteIndexUI;
        this.mtY = d;
        this.mtZ = d2;
        this.mua = i;
        this.mub = str;
        this.muc = charSequence;
        this.mud = str2;
        this.mue = arrayList;
    }

    public final void run() {
        this.mtS.mrF = true;
        double d = this.mtY;
        double d2 = this.mtZ;
        int i = this.mua;
        String str = this.mub;
        CharSequence charSequence = this.muc;
        String str2 = this.mud;
        List<String> list = this.mue;
        ux uxVar = new ux();
        uxVar.TZ(str);
        uxVar.s(d);
        uxVar.r(d2);
        uxVar.CO(i);
        uxVar.Ua(str2);
        f fVar = new f();
        fVar.field_type = 6;
        fVar.field_sourceType = 6;
        fVar.field_favProto.b(uxVar);
        if (!(charSequence == null || bh.ov(charSequence.toString()))) {
            fVar.field_favProto.Uf(charSequence.toString());
            fVar.field_favProto.fA(bh.Wp());
            g.pQN.h(10873, Integer.valueOf(6));
        }
        c.j(fVar);
        if (!(list == null || list.isEmpty())) {
            for (String zS : list) {
                fVar.zS(zS);
            }
        }
        a.B(fVar);
        g.pQN.h(10648, Integer.valueOf(3), Integer.valueOf(0));
        j.dn(fVar.field_localId);
        long j = fVar.field_localId;
        f db = h.getFavItemInfoStorage().db(j);
        if (db != null && db.field_favProto.wdZ != null) {
            d.a(j, db.field_favProto.wdZ, "", "", new ArrayList(), this.mtS.mController.xIM);
        }
    }
}
