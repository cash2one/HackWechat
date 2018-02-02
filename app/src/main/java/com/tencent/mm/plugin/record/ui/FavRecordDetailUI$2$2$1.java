package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

class FavRecordDetailUI$2$2$1 implements OnClickListener {
    final /* synthetic */ 2 pFT;

    FavRecordDetailUI$2$2$1(2 2) {
        this.pFT = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        final r a = h.a(this.pFT.pFS.pFP.mController.xIM, this.pFT.pFS.pFP.getString(R.l.dEx), false, null);
        b fvVar = new fv();
        fvVar.fvq.type = 12;
        fvVar.fvq.fqk = this.pFT.pFS.pFP.pFM;
        fvVar.fvq.fvv = new Runnable(this) {
            final /* synthetic */ FavRecordDetailUI$2$2$1 pFU;

            public final void run() {
                a.dismiss();
                x.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.pFU.pFT.pFS.pFP.pFM)});
                this.pFU.pFT.pFS.pFP.finish();
            }
        };
        a.xef.m(fvVar);
    }
}
