package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class a$1 implements OnClickListener {
    final /* synthetic */ a kNR;

    a$1(a aVar) {
        this.kNR = aVar;
    }

    public final void onClick(View view) {
        if (view.getId() != R.h.cBo) {
            return;
        }
        if (this.kNR.kNK.isChecked()) {
            if (this.kNR.kNO != null) {
                this.kNR.kNO.nN(1);
            }
        } else if (this.kNR.kNO != null) {
            this.kNR.kNO.nN(0);
        }
    }
}
