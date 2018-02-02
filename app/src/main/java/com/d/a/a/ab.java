package com.d.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.d.a.a.d.a;

final class ab extends c {
    private static ab bnb;
    WifiManager bgP;
    private final BroadcastReceiver bnc = new 1(this);
    private final IntentFilter bnd = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private ac bne;
    private long bnf = 10000;

    private ab() {
    }

    static ab sz() {
        if (bnb == null) {
            bnb = new ab();
        }
        return bnb;
    }

    private boolean isAvailable() {
        return this.bgP != null;
    }

    final synchronized void a(Handler handler, a aVar) {
        if (aVar == null) {
            aVar = new a(10000);
        }
        super.a(handler, aVar);
    }

    final void U(Context context) {
        this.bgP = (WifiManager) context.getSystemService("wifi");
    }

    final void a(Context context, Handler handler, a aVar) {
        if (isAvailable()) {
            context.registerReceiver(this.bnc, this.bnd, null, handler);
            this.bnf = aVar.bgK;
            WifiManager wifiManager = this.bgP;
            if (handler == null) {
                handler = new Handler(context.getMainLooper());
            }
            this.bne = new ac(wifiManager, handler);
            this.bne.f(this.bnf, 0);
        }
    }

    final void V(Context context) {
        if (isAvailable()) {
            context.unregisterReceiver(this.bnc);
            this.bne.stop();
        }
    }

    final void rR() {
    }

    final void rS() {
        if (isAvailable() && this.bgH && this.bnf < 90000) {
            this.bne.f(90000, 0);
        }
    }

    final void rT() {
        if (isAvailable() && this.bgH && this.bnf < 90000) {
            this.bne.f(this.bnf, 0);
        }
    }
}
