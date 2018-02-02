package com.tencent.mm.booter;

import android.os.Process;
import com.tencent.mm.booter.NotifyReceiver.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.x;

class NotifyReceiver$a$2 implements Runnable {
    final /* synthetic */ a gyr;

    NotifyReceiver$a$2(a aVar) {
        this.gyr = aVar;
    }

    public final void run() {
        x.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", new Object[]{Boolean.valueOf(NotifyReceiver.tx())});
        synchronized (NotifyReceiver.wH()) {
            if (NotifyReceiver.wI() != null) {
                NotifyReceiver.wI().unLock();
            }
            NotifyReceiver.a(null);
        }
        if (NotifyReceiver.tx()) {
            PluginZero pluginZero = (PluginZero) g.k(PluginZero.class);
            if (pluginZero.vaF != null) {
                pluginZero.vaF.arc();
            }
            x.cfl();
            Process.killProcess(Process.myPid());
        }
    }
}
