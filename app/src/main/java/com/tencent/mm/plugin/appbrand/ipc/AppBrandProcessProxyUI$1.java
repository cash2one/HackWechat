package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;

class AppBrandProcessProxyUI$1 extends ResultReceiver {
    final /* synthetic */ b jba;

    AppBrandProcessProxyUI$1(Handler handler, b bVar) {
        this.jba = bVar;
        super(handler);
    }

    protected final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            this.jba.c(null);
            return;
        }
        bundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
        this.jba.c((ProcessResult) bundle.getParcelable("key_result_parcel"));
    }
}
