package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class CleanChattingUI$3 implements OnClickListener {
    final /* synthetic */ CleanChattingUI lgN;

    CleanChattingUI$3(CleanChattingUI cleanChattingUI) {
        this.lgN = cleanChattingUI;
    }

    public final void onClick(View view) {
        h.a(this.lgN, this.lgN.getString(R.l.dTW), "", this.lgN.getString(R.l.caK), this.lgN.getString(R.l.cancel), new 1(this), new 2(this));
    }
}
