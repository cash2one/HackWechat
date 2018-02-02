package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.mm.R;

class b$8 implements Runnable {
    final /* synthetic */ b rTf;

    b$8(b bVar) {
        this.rTf = bVar;
    }

    public final void run() {
        this.rTf.jCB.setTextColor(this.rTf.jCB.getResources().getColor(R.e.bsM));
        this.rTf.jCB.setText(this.rTf.jCB.getResources().getString(R.l.eQa));
        this.rTf.rSY.setImageResource(R.k.cib);
    }
}
