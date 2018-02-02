package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class CleanChattingDetailUI$3 implements OnClickListener {
    final /* synthetic */ CleanChattingDetailUI lgF;

    CleanChattingDetailUI$3(CleanChattingDetailUI cleanChattingDetailUI) {
        this.lgF = cleanChattingDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.lgF, this.lgF.getString(R.l.dTX), "", this.lgF.getString(R.l.caK), this.lgF.getString(R.l.cancel), new 1(this), new 2(this));
    }
}
