package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class c$14 implements OnItemClickListener {
    final /* synthetic */ c nXi;

    c$14(c cVar) {
        this.nXi = cVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", Integer.valueOf(i));
        if (!c.q(this.nXi)) {
            if (i >= c.o(this.nXi).getCount()) {
                x.i("MicroMsg.MMPoiMapUI", "wrong position");
                return;
            }
            f rS = c.o(this.nXi).rS(i);
            if (rS.type == 0) {
                View r = c.r(this.nXi);
                double d = rS.bhC;
                double d2 = rS.bhD;
                if (r.nSW) {
                    r.nTp.updateViewLayout(r, d, d2);
                } else {
                    r.nSW = true;
                    r.nTp.addView(r, d, d2);
                }
                c.l(this.nXi).setBackgroundResource(R.g.bDu);
            } else {
                c.r(this.nXi).remove();
                c.l(this.nXi).setEnabled(true);
            }
            this.nXi.nTp.getIController().animateTo(rS.bhC, rS.bhD);
            c.o(this.nXi).nXs = i;
            c.o(this.nXi).notifyDataSetChanged();
        }
        c.n(this.nXi);
    }
}
