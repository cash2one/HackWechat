package com.tencent.mm.ui.widget.celltextview.e;

import com.tencent.mm.sdk.platformtools.x;

class a$a implements Runnable {
    final /* synthetic */ a zxT;

    a$a(a aVar) {
        this.zxT = aVar;
    }

    public final void run() {
        if (a.a(this.zxT) != null && a.a(this.zxT).isPressed()) {
            x.d("MicroMsg.CellTouchListener", "long pressed timeout");
            a.b(this.zxT);
            a.a(this.zxT).czg().a(null);
            a.a(this.zxT).invalidate();
        }
    }
}
