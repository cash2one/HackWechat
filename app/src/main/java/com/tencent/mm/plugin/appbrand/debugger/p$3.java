package com.tencent.mm.plugin.appbrand.debugger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.2;
import com.tencent.mm.plugin.appbrand.q$g;

class p$3 implements OnClickListener {
    final /* synthetic */ p iRt;

    p$3(p pVar) {
        this.iRt = pVar;
    }

    public final void onClick(View view) {
        p pVar = this.iRt;
        if (view.getId() == q$g.iuM) {
            pVar.iRq = true;
            pVar.show();
            RemoteDebugMoveView remoteDebugMoveView = pVar.iRe;
            remoteDebugMoveView.postDelayed(new 2(remoteDebugMoveView), 50);
        } else if (view.getId() == q$g.iuH) {
            pVar.iRq = false;
            pVar.show();
        } else if (view.getId() == q$g.iuO) {
            pVar.acz();
        }
    }
}
