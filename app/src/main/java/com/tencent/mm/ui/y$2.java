package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.preference.IconPreference;

class y$2 implements g {
    final /* synthetic */ y xKX;
    final /* synthetic */ IconPreference xKY;

    y$2(y yVar, IconPreference iconPreference) {
        this.xKX = yVar;
        this.xKY = iconPreference;
    }

    public final void lC(String str) {
        ag.y(new Runnable(this) {
            final /* synthetic */ y$2 xKZ;

            {
                this.xKZ = r1;
            }

            public final void run() {
                this.xKZ.xKY.Fb(0);
                this.xKZ.xKY.Fa(R.g.bDT);
            }
        });
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (bVar.bitmap != null) {
            final Bitmap bitmap = bVar.bitmap;
            ag.y(new Runnable(this) {
                final /* synthetic */ y$2 xKZ;

                public final void run() {
                    this.xKZ.xKY.V(bitmap);
                    this.xKZ.xKY.Fb(0);
                }
            });
            return;
        }
        ag.y(new 3(this));
    }
}
