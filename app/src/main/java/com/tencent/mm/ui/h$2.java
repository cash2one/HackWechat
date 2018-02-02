package com.tencent.mm.ui;

import android.graphics.Color;
import com.tencent.mm.bc.k.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;

class h$2 implements Runnable {
    final /* synthetic */ h xFs;
    final /* synthetic */ IconPreference xFt;
    final /* synthetic */ a xFu;

    h$2(h hVar, IconPreference iconPreference, a aVar) {
        this.xFs = hVar;
        this.xFt = iconPreference;
        this.xFu = aVar;
    }

    public final void run() {
        if (this.xFt != null) {
            if (this.xFu == null) {
                this.xFt.EZ(8);
                return;
            }
            if (this.xFu.isValid()) {
                x.i("MicroMsg.FindMoreFriendsUI", "show red %s", new Object[]{this.xFt.getTitle()});
                switch (this.xFu.type) {
                    case 1:
                        this.xFt.EZ(0);
                        this.xFt.EY(8);
                        break;
                    case 2:
                        this.xFt.EZ(8);
                        this.xFt.EY(0);
                        this.xFt.ac(this.xFu.text, -1, Color.parseColor("#8c8c8c"));
                        this.xFt.mw(true);
                        this.xFt.Fc(8);
                        break;
                    default:
                        x.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[]{Integer.valueOf(this.xFu.type)});
                        break;
                }
            }
            x.i("MicroMsg.FindMoreFriendsUI", "hide red %s", new Object[]{this.xFt.getTitle()});
            this.xFt.EZ(8);
            this.xFt.EY(8);
            h.a(this.xFs).notifyDataSetChanged();
        }
    }
}
