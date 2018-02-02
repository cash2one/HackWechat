package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiManager;
import java.util.TimerTask;

class n$6 extends TimerTask {
    final /* synthetic */ n sny;

    n$6(n nVar) {
        this.sny = nVar;
    }

    public final void run() {
        int i = 10;
        if (n.g(this.sny) != null) {
            n.a(this.sny, n.g(this.sny).getConnectionInfo());
        }
        if (n.h(this.sny) == null || n.h(this.sny).getBSSID() == null || n.g(this.sny) == null) {
            n.os(-1);
        } else {
            n.os(WifiManager.calculateSignalLevel(n.h(this.sny).getRssi(), 10));
            if (n.Uz() <= 10) {
                i = n.Uz();
            }
            n.os(i);
            n.os(n.Uz() < 0 ? 0 : n.Uz());
            n.os(n.Uz() * 10);
        }
        if (n.Uz() == -1) {
            if (n.i(this.sny) <= 1) {
                n.yK(-1);
            }
            this.sny.setNetSignalValue(1, n.apD());
            return;
        }
        this.sny.setNetSignalValue(2, n.Uz());
    }
}
