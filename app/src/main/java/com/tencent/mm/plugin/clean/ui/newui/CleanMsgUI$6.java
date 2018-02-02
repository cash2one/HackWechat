package com.tencent.mm.plugin.clean.ui.newui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

class CleanMsgUI$6 implements d {
    final /* synthetic */ CleanMsgUI lhT;

    CleanMsgUI$6(CleanMsgUI cleanMsgUI) {
        this.lhT = cleanMsgUI;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case 0:
                if (CleanMsgUI.ayC() > 0) {
                    h.a(this.lhT, this.lhT.getString(R.l.dTN, new Object[]{bh.bx(r2)}), "", this.lhT.getString(R.l.caK), this.lhT.getString(R.l.cancel), new 1(this), null);
                    return;
                }
                Toast.makeText(this.lhT, R.l.eyd, 0).show();
                return;
            default:
                return;
        }
    }
}
