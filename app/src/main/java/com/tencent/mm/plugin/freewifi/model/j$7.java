package com.tencent.mm.plugin.freewifi.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class j$7 extends a {
    private byte[] gym = new byte[0];
    final /* synthetic */ j mEM;

    j$7(j jVar) {
        this.mEM = jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eq(int i) {
        synchronized (this.gym) {
            if (ar.Hj()) {
                x.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + i + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
                ConnectivityManager connectivityManager = (ConnectivityManager) ac.getContext().getSystemService("connectivity");
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null) {
                    x.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:" + networkInfo);
                    x.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", new Object[]{Boolean.valueOf(networkInfo.isAvailable()), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting())});
                }
                if (connectivityManager.getNetworkInfo(0) != null) {
                    x.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", new Object[]{connectivityManager.getNetworkInfo(0)});
                    x.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", new Object[]{Boolean.valueOf(r0.isAvailable()), Boolean.valueOf(r0.isConnected()), Boolean.valueOf(r0.isConnectedOrConnecting())});
                }
                if (6 == i || 4 == i || i == 0 || -1 == i || -9 == i) {
                    if (networkInfo.isConnected()) {
                        x.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[]{Boolean.valueOf(f.a.aLK().a(d.aLE()))});
                        if (f.a.aLK().a(d.aLE())) {
                            j.aLT().aLw();
                        }
                    } else {
                        f.a.aLK().aLH();
                        return;
                    }
                }
            }
            x.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
        }
    }
}
