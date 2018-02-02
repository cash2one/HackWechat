package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FavRecordDetailUI$4 implements Runnable {
    final /* synthetic */ FavRecordDetailUI pFP;
    final /* synthetic */ List pFV;

    FavRecordDetailUI$4(FavRecordDetailUI favRecordDetailUI, List list) {
        this.pFP = favRecordDetailUI;
        this.pFV = list;
    }

    public final void run() {
        if (this.pFV != null) {
            x.i("MicroMsg.FavRecordDetailUI", "start calc");
            long j = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (uq uqVar : this.pFV) {
                if (!(uqVar == null || FavRecordDetailUI.d(this.pFP))) {
                    switch (uqVar.bjS) {
                        case 1:
                            j = ((long) uqVar.desc.getBytes().length) + j;
                            i4++;
                            break;
                        case 2:
                            i3++;
                            break;
                        case 4:
                        case 15:
                            i2++;
                            break;
                        default:
                            i++;
                            break;
                    }
                }
            }
            FavRecordDetailUI.a(this.pFP, String.format("%s:%s:%s:%s:%s", new Object[]{Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)}));
            x.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", new Object[]{r0});
        }
    }
}
