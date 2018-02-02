package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.ui.base.h;

class a$2 implements OnLongClickListener {
    final /* synthetic */ a kNR;

    a$2(a aVar) {
        this.kNR = aVar;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == R.h.bWC) {
            p.I(this.kNR.kaY, this.kNR.kIK.atC().code);
            h.bu(this.kNR.kaY, this.kNR.kaY.getString(R.l.dEt));
        }
        return false;
    }
}
