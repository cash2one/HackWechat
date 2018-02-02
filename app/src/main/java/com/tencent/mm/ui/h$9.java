package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.preference.IconPreference;

class h$9 implements g {
    final /* synthetic */ String fgU;
    final /* synthetic */ String heX;
    final /* synthetic */ String iGk;
    final /* synthetic */ gs nxd;
    final /* synthetic */ int sPD;
    final /* synthetic */ String xFA;
    final /* synthetic */ h xFs;
    final /* synthetic */ IconPreference xFy;
    final /* synthetic */ int xFz;

    h$9(h hVar, gs gsVar, IconPreference iconPreference, int i, String str, int i2, String str2, String str3, String str4) {
        this.xFs = hVar;
        this.nxd = gsVar;
        this.xFy = iconPreference;
        this.xFz = i;
        this.fgU = str;
        this.sPD = i2;
        this.xFA = str2;
        this.heX = str3;
        this.iGk = str4;
    }

    public final void lC(String str) {
        ag.y(new 1(this));
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        this.nxd.fwO.pK = 2;
        this.nxd.fwO.url = str;
        a.xef.m(this.nxd);
        if (bVar.status != 0 || bVar.bitmap == null) {
            ag.y(new Runnable(this) {
                final /* synthetic */ h$9 xFB;

                {
                    this.xFB = r1;
                }

                public final void run() {
                    h.a(this.xFB.xFs, true);
                    IconPreference iconPreference = (IconPreference) h.a(this.xFB.xFs).YN("more_tab_game_recommend");
                    if (this.xFB.xFz == 3) {
                        iconPreference.dh(this.xFB.xFs.getString(R.l.dFP), R.g.bEf);
                        h.a(iconPreference, 0, 8, false, 8, 8, 8);
                        h.c(this.xFB.fgU, this.xFB.sPD, this.xFB.xFA, this.xFB.heX, 1);
                    } else if (this.xFB.xFz == 4) {
                        iconPreference.ac(this.xFB.iGk, -1, Color.parseColor("#8c8c8c"));
                        h.a(iconPreference, 8, 0, true, 8, 8, 8);
                        h.c(this.xFB.fgU, this.xFB.sPD, this.xFB.xFA, this.xFB.heX, 2);
                    }
                }
            });
        } else {
            ag.y(new 2(this, bVar.bitmap));
        }
    }
}
