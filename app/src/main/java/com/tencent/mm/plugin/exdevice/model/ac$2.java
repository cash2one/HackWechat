package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.sdk.platformtools.ag;

class ac$2 implements g {
    final /* synthetic */ ac lNC;
    final /* synthetic */ a lND;

    ac$2(ac acVar, a aVar) {
        this.lNC = acVar;
        this.lND = aVar;
    }

    public final void lC(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (this.lNC.hnr) {
            this.lNC.lNA = false;
            return;
        }
        ag.y(new Runnable(this) {
            final /* synthetic */ ac$2 lNE;

            {
                this.lNE = r1;
            }

            public final void run() {
                if (this.lNE.lNC.lNB.isShowing()) {
                    this.lNE.lNC.lNB.dismiss();
                }
            }
        });
        this.lND.yU(this.lNC.v(bVar.bitmap));
        this.lNC.lNA = false;
    }
}
