package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class FavRecordDetailUI$2$1 implements c {
    final /* synthetic */ 2 pFS;

    FavRecordDetailUI$2$1(2 2) {
        this.pFS = 2;
    }

    public final void a(n nVar) {
        x.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[]{Integer.valueOf(FavRecordDetailUI.b(this.pFS.pFP).field_id), Integer.valueOf(FavRecordDetailUI.b(this.pFS.pFP).field_itemStatus)});
        if (FavRecordDetailUI.b(this.pFS.pFP).field_id > 0 && !FavRecordDetailUI.b(this.pFS.pFP).aHL() && !FavRecordDetailUI.b(this.pFS.pFP).aHM() && FavRecordDetailUI.c(this.pFS.pFP)) {
            nVar.f(0, this.pFS.pFP.getString(R.l.egz));
        }
        nVar.f(3, this.pFS.pFP.getString(R.l.eeY));
        nVar.f(2, this.pFS.pFP.getString(R.l.dEw));
    }
}
