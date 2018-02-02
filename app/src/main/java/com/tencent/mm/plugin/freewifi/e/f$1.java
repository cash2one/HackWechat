package com.tencent.mm.plugin.freewifi.e;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.c$a;
import com.tencent.mm.plugin.freewifi.c.1;
import com.tencent.mm.plugin.freewifi.e;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

class f$1 implements Runnable {
    final /* synthetic */ c mFd;
    final /* synthetic */ f mFe;

    f$1(f fVar, c cVar) {
        this.mFe = fVar;
        this.mFd = cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        c cVar = this.mFd;
        c$a 1 = new 1(cVar, new 1(this));
        if (((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && cVar.ssid.equals(d.aLG())) {
            1.onSuccess();
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        } else {
            cVar.mBS = new ConnectSsidPasswordHelper$2(cVar);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
            try {
                int aKU;
                cVar.mBP.lock();
                cVar.activity.registerReceiver(cVar.mBS, intentFilter);
                if (!cVar.bni.isWifiEnabled()) {
                    aKU = new e(cVar.activity).aKU();
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = " + aKU);
                    if (aKU != 0) {
                        1.pQ(aKU);
                        cVar.aKS();
                        cVar.mBP.unlock();
                        return;
                    }
                }
                aKU = d.d(cVar.ssid, cVar.mBX, 3, false);
                if (aKU != 0) {
                    cVar.aKS();
                    1.pQ(aKU);
                    cVar.aKS();
                    cVar.mBP.unlock();
                    return;
                }
                boolean await = (cVar.connected || cVar.mBW) ? false : cVar.fcE.await(cVar.hnk, TimeUnit.MILLISECONDS);
                if (!await) {
                    1.pQ(-16);
                } else if (cVar.connected) {
                    1.onSuccess();
                } else if (cVar.mBW) {
                    1.pQ(-18);
                }
                cVar.aKS();
                cVar.mBP.unlock();
            } catch (InterruptedException e) {
                x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", m.D(cVar.activity.getIntent()), Integer.valueOf(m.E(cVar.activity.getIntent())), e.getMessage());
                1.pQ(-17);
            } catch (Throwable th) {
                cVar.aKS();
                cVar.mBP.unlock();
            }
        }
    }
}
