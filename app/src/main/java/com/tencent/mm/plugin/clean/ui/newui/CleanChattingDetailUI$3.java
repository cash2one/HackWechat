package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class CleanChattingDetailUI$3 implements OnClickListener {
    final /* synthetic */ CleanChattingDetailUI lhN;

    CleanChattingDetailUI$3(CleanChattingDetailUI cleanChattingDetailUI) {
        this.lhN = cleanChattingDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.lhN, this.lhN.getString(R.l.dTX), "", this.lhN.getString(R.l.caK), this.lhN.getString(R.l.cancel), new 1(this), new 2(this));
    }
}
