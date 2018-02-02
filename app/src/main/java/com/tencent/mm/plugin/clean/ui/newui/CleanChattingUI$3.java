package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class CleanChattingUI$3 implements OnClickListener {
    final /* synthetic */ CleanChattingUI lhQ;

    CleanChattingUI$3(CleanChattingUI cleanChattingUI) {
        this.lhQ = cleanChattingUI;
    }

    public final void onClick(View view) {
        h.a(this.lhQ, this.lhQ.getString(R.l.dTW), "", this.lhQ.getString(R.l.caK), this.lhQ.getString(R.l.cancel), new 1(this), new 2(this));
    }
}
