package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.at.f;

class at$f$1 implements OnClickListener {
    final /* synthetic */ f rFP;

    at$f$1(f fVar) {
        this.rFP = fVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            this.rFP.rFO = (at$f$a) view.getTag();
            this.rFP.dF(this.rFP.rFO.qQY, this.rFP.rFO.position);
        }
    }
}
