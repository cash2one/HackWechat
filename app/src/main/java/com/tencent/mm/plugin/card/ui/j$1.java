package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class j$1 implements OnClickListener {
    final /* synthetic */ j kVh;

    j$1(j jVar) {
        this.kVh = jVar;
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cDg || view.getId() == R.h.cDe) {
            if (this.kVh.inJ != null && this.kVh.inJ.isShowing()) {
                this.kVh.inJ.dismiss();
            }
            if (!this.kVh.kIK.atk()) {
                this.kVh.awh();
            }
        }
    }
}
