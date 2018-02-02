package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class a$2 implements Runnable {
    final /* synthetic */ d mWr;
    final /* synthetic */ a mWs;

    a$2(a aVar, d dVar) {
        this.mWs = aVar;
        this.mWr = dVar;
    }

    public final void run() {
        Toast.makeText(this.mWr.getContext(), this.mWr.getContext().getString(R.l.emj), 0).show();
    }
}
