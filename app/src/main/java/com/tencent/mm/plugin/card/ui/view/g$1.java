package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.ui.base.h;

class g$1 implements OnLongClickListener {
    final /* synthetic */ g kWv;

    g$1(g gVar) {
        this.kWv = gVar;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == R.h.bWC) {
            p.I(this.kWv.kaY, this.kWv.kIK.atC().code);
            h.bu(this.kWv.kaY, this.kWv.getString(R.l.dEt));
        }
        return false;
    }
}
