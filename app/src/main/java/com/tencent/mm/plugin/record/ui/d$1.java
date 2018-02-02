package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements i {
    final /* synthetic */ d pFJ;

    d$1(d dVar) {
        this.pFJ = dVar;
    }

    public final void a(c cVar) {
        if (cVar.field_favLocalId != ((b) this.pFJ.pGa).pFG.field_localId) {
            x.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", new Object[]{Long.valueOf(cVar.field_favLocalId), Long.valueOf(((b) this.pFJ.pGa).pFG.field_localId)});
            return;
        }
        x.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[]{Long.valueOf(cVar.field_favLocalId), cVar.field_dataId, Integer.valueOf(cVar.field_status)});
        if (4 == cVar.field_status) {
            d.bmW().put(bh.az(cVar.field_dataId, "null"), Boolean.valueOf(true));
        }
        if (cVar.isFinished()) {
            this.pFJ.pFW.post(new 1(this, cVar));
        }
        this.pFJ.bne();
    }
}
