package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.record.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;

class FavRecordDetailUI$1 implements a {
    final /* synthetic */ FavRecordDetailUI pFP;

    FavRecordDetailUI$1(FavRecordDetailUI favRecordDetailUI) {
        this.pFP = favRecordDetailUI;
    }

    public final void a(String str, l lVar) {
        if (lVar != null && lVar.obj != null) {
            long longValue = ((Long) lVar.obj).longValue();
            if (longValue >= 0 && FavRecordDetailUI.a(this.pFP) == longValue) {
                f ea = b.ea(FavRecordDetailUI.a(this.pFP));
                b bVar = new b();
                bVar.pFG = ea;
                if (ea != null && ea.field_favProto != null) {
                    bVar.pFF = ea.field_favProto.weU;
                    ag.y(new 1(this, bVar));
                }
            }
        }
    }
}
