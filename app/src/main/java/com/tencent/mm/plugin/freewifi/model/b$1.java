package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends BroadcastReceiver {
    final /* synthetic */ b mDX;

    b$1(b bVar) {
        this.mDX = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            try {
                x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                    return;
                }
                x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[]{Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable())});
                if (!networkInfo.isConnected()) {
                    x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                    x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                } else if (context == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                } else if (networkInfo.getType() == 1) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManager is null.");
                        return;
                    }
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiInfo is null.");
                        return;
                    }
                    String AB = m.AB(connectionInfo.getSSID());
                    String toLowerCase = m.AC(connectionInfo.getBSSID()).toLowerCase();
                    x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[]{m.AB(m.AC(networkInfo.getExtraInfo())), AB, toLowerCase});
                    if (!m.AC(m.AB(m.AC(networkInfo.getExtraInfo()))).equals(AB)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                    } else if (this.mDX.mDV.type == 1 && m.AC(this.mDX.mDV.ssid).equals(AB) && m.AC(this.mDX.mDV.bssid).equals(toLowerCase)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                    } else {
                        a aVar = new a((byte) 0);
                        aVar.mDY = System.currentTimeMillis();
                        aVar.type = 1;
                        aVar.ssid = AB;
                        aVar.bssid = toLowerCase;
                        aVar.mDZ = "";
                        b.b(this.mDX.mDV.aLx(), aVar);
                        this.mDX.mDV = aVar;
                    }
                } else if (networkInfo.getType() != 0) {
                } else {
                    if (this.mDX.mDV.type == 0 && m.AC(this.mDX.mDV.mDZ).equals(m.AC(networkInfo.getExtraInfo()))) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                        return;
                    }
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                        return;
                    }
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                    if (networkInfo2 == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                        return;
                    }
                    x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[]{networkInfo2.getState(), networkInfo2.getDetailedState()});
                    if (networkInfo2.getDetailedState() != DetailedState.DISCONNECTED) {
                        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                        return;
                    }
                    a aVar2 = new a((byte) 0);
                    aVar2.mDY = System.currentTimeMillis();
                    aVar2.type = 0;
                    aVar2.ssid = "";
                    aVar2.bssid = "";
                    aVar2.mDZ = m.AC(networkInfo.getExtraInfo());
                    b.a(this.mDX.mDV.aLx(), aVar2);
                    this.mDX.mDV = aVar2;
                }
            } catch (Exception e) {
                k.a aLe = k.aLe();
                aLe.fpz = "UnExpectedException";
                aLe.result = -1;
                aLe.kZo = m.e(e);
                aLe.aLg().aLf();
                x.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(e));
            }
        }
    }
}
