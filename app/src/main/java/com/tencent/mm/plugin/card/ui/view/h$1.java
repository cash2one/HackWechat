package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.ui.base.h;

class h$1 implements OnLongClickListener {
    final /* synthetic */ b kWx;
    final /* synthetic */ h kWy;

    h$1(h hVar, b bVar) {
        this.kWy = hVar;
        this.kWx = bVar;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == R.h.bWC) {
            p.I(this.kWy.kaY, this.kWx.atC().code);
            h.bu(this.kWy.kaY, o.getString(R.l.dEt));
        }
        return false;
    }
}
