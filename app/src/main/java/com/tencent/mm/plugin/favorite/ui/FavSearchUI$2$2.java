package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavSearchUI.2;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class FavSearchUI$2$2 implements Runnable {
    final /* synthetic */ int kI;
    final /* synthetic */ b mti;
    final /* synthetic */ 2 mtj;

    FavSearchUI$2$2(2 2, b bVar, int i) {
        this.mtj = 2;
        this.mti = bVar;
        this.kI = i;
    }

    public final void run() {
        int i;
        x.d("MicroMsg.FavSearchUI", "type %s", new Object[]{Integer.valueOf(this.mti.mqC.field_type)});
        long j = this.mti.mqC.field_localId;
        if (this.mtj.mth.msZ.size() == 0) {
            this.mtj.mth.msZ = h.getFavItemInfoStorage().aIi();
        }
        if (this.mtj.mth.msZ.size() != 0) {
            Iterator it = this.mtj.mth.msZ.iterator();
            i = 1;
            while (it.hasNext() && ((Long) it.next()).longValue() != j) {
                i++;
            }
        } else {
            i = 1;
        }
        g gVar = g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.mti.mqC.field_type);
        objArr[1] = Integer.valueOf(FavSearchUI.i(this.mtj.mth));
        if (this.mtj.mth.msZ.size() == 0) {
            i = this.kI;
        }
        objArr[2] = Integer.valueOf(i);
        gVar.h(12746, objArr);
    }
}
