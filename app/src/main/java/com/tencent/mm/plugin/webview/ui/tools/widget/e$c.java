package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;

protected class e$c implements ServiceConnection {
    final /* synthetic */ e tKp;

    public e$c(e eVar) {
        this.tKp = eVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.MMWebViewClient", "onServiceConnected");
        if (this.tKp.juE == null) {
            x.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
            return;
        }
        try {
            this.tKp.tFi = a.X(iBinder);
            this.tKp.tFi.a(this.tKp.tKo, this.tKp.juE.hashCode());
            this.tKp.a(this.tKp.tFi, this.tKp.tGR);
            this.tKp.bUP();
            this.tKp.bUf();
        } catch (Exception e) {
            x.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
        if (this.tKp.iQz.isFinishing()) {
            this.tKp.tFi = null;
            return;
        }
        x.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
        e.a(this.tKp);
    }
}
