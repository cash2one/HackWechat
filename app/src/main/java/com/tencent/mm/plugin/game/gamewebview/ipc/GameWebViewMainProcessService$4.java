package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class GameWebViewMainProcessService$4 implements ServiceConnection {
    GameWebViewMainProcessService$4() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        GameWebViewMainProcessService.a(a.R(iBinder));
        GameWebViewMainProcessService.aOF();
        GameWebViewMainProcessService.aOG();
        x.i("MicroMsg.GameWebViewMainProcessService", "onServiceConnected(%s)", new Object[]{ac.Br()});
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        GameWebViewMainProcessService.a(null);
        GameWebViewMainProcessService.aOH();
        GameWebViewMainProcessService.afc();
        x.i("MicroMsg.GameWebViewMainProcessService", "onServiceDisconnected(%s)", new Object[]{ac.Br()});
    }
}
