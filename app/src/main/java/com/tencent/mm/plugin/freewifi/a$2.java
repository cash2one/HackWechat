package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends BroadcastReceiver {
    final /* synthetic */ a mBU;

    a$2(a aVar) {
        this.mBU = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
            networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.mBU.ssid, m.AD("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.mBU.ssid.equals(m.AB(networkInfo.getExtraInfo()))) {
                try {
                    this.mBU.mBP.lock();
                    this.mBU.mBQ = true;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                    this.mBU.fcE.signalAll();
                } finally {
                    this.mBU.mBP.unlock();
                }
            }
        } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.mBU.ssid, m.AD("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.mBU.ssid.equals(m.AB(networkInfo.getExtraInfo()))) {
                try {
                    this.mBU.mBP.lock();
                    this.mBU.mBR = true;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                    this.mBU.fcE.signalAll();
                } finally {
                    this.mBU.mBP.unlock();
                }
            }
        }
    }
}
