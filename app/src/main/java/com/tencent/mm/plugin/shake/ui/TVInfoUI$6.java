package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

class TVInfoUI$6 implements d {
    final /* synthetic */ TVInfoUI qsE;

    TVInfoUI$6(TVInfoUI tVInfoUI) {
        this.qsE = tVInfoUI;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case -1:
                h.a(this.qsE.mController.xIM, this.qsE.mController.xIM.getString(R.l.dEx), null, null, this.qsE.mController.xIM.getString(R.l.dEw), new d(this) {
                    final /* synthetic */ TVInfoUI$6 qsF;

                    {
                        this.qsF = r1;
                    }

                    public final void cn(int i, int i2) {
                        switch (i2) {
                            case -1:
                                b caVar = new ca();
                                caVar.fqi.fqk = this.qsF.qsE.getIntent().getLongExtra("key_favorite_local_id", -1);
                                a.xef.m(caVar);
                                x.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[]{Long.valueOf(caVar.fqi.fqk), Boolean.valueOf(caVar.fqj.fpW)});
                                if (caVar.fqj.fpW) {
                                    this.qsF.qsE.finish();
                                    return;
                                }
                                return;
                            default:
                                x.d("MicroMsg.TVInfoUI", "do del cancel");
                                return;
                        }
                    }
                });
                return;
            case 0:
                TVInfoUI.b(this.qsE);
                return;
            case 1:
                TVInfoUI.c(this.qsE);
                return;
            case 2:
                TVInfoUI.d(this.qsE);
                return;
            default:
                return;
        }
    }
}
