package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.at.f;
import com.tencent.mm.plugin.sns.ui.at.f.a;

class at$f$3 implements OnClickListener {
    final /* synthetic */ f rFP;

    at$f$3(f fVar) {
        this.rFP = fVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            this.rFP.rFO = (a) view.getTag();
            this.rFP.dF(this.rFP.rFO.qQY, this.rFP.rFO.position + 2);
        }
    }
}
