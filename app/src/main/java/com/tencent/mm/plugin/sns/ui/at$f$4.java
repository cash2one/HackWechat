package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.at.f;
import com.tencent.mm.plugin.sns.ui.at.f.a;
import com.tencent.mm.sdk.platformtools.x;

class at$f$4 implements OnClickListener {
    final /* synthetic */ f rFP;

    at$f$4(f fVar) {
        this.rFP = fVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            x.d("MicroMsg.SnsphotoAdapter", "sign click");
            this.rFP.rFO = (a) view.getTag();
            this.rFP.dG(this.rFP.rFO.qQY, this.rFP.rFO.position + 2);
        }
    }
}
