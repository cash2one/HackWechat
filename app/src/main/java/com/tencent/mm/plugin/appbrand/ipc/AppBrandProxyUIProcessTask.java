package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask implements a {
    public b jbq;

    public interface b<R extends ProcessResult> {
        void c(R r);
    }

    public abstract void a(ProcessRequest processRequest);

    public final MMActivity afe() {
        return this.jbq.afe();
    }

    public final void a(ProcessResult processResult) {
        Runnable 1 = new 1(this, processResult);
        if (this.jbq != null) {
            this.jbq.runOnUiThread(1);
        }
    }

    public void b(int i, int i2, Intent intent) {
    }

    public void afk() {
    }
}
