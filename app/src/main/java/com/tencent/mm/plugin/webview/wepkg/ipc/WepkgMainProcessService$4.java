package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class WepkgMainProcessService$4 implements ServiceConnection {
    WepkgMainProcessService$4() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        WepkgMainProcessService.a(a$a.Z(iBinder));
        WepkgMainProcessService.aOF();
        x.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceConnected(%s)", new Object[]{ac.Br()});
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        WepkgMainProcessService.a(null);
        WepkgMainProcessService.aOG();
        x.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceDisconnected(%s)", new Object[]{ac.Br()});
    }
}
