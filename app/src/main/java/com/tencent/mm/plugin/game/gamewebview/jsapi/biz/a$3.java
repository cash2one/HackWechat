package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class a$3 implements Runnable {
    final /* synthetic */ d mWr;
    final /* synthetic */ a mWs;

    a$3(a aVar, d dVar) {
        this.mWs = aVar;
        this.mWr = dVar;
    }

    public final void run() {
        Toast.makeText(this.mWr.getContext(), this.mWr.getContext().getString(R.l.emi), 0).show();
    }
}
