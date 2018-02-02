package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.mm.plugin.freewifi.c.2;
import com.tencent.mm.sdk.platformtools.x;

class ConnectSsidPasswordHelper$2 extends BroadcastReceiver {
    final /* synthetic */ c mBZ;

    public ConnectSsidPasswordHelper$2(c cVar) {
        this.mBZ = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", this.mBZ.ssid, m.AD("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.mBZ.ssid.equals(m.AB(networkInfo.getExtraInfo()))) {
                try {
                    this.mBZ.mBP.lock();
                    this.mBZ.connected = true;
                    this.mBZ.mBW = false;
                    this.mBZ.fcE.signalAll();
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
                } finally {
                    this.mBZ.aKS();
                    this.mBZ.mBP.unlock();
                }
            }
        } else if ("android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction())) {
            switch (2.mCa[((SupplicantState) intent.getParcelableExtra("newState")).ordinal()]) {
                case 1:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
                    break;
                case 2:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
                    break;
                case 3:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
                    break;
                case 4:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
                    break;
                case 5:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
                    break;
                case 6:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
                    break;
                case 7:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
                    break;
                case 8:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
                    break;
                case 9:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
                    break;
                case 10:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
                    break;
                case 11:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
                    break;
                case 12:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
                    break;
                case 13:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
                    break;
                default:
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
                    break;
            }
            if (intent.getIntExtra("supplicantError", -1) == 1) {
                try {
                    this.mBZ.mBP.lock();
                    this.mBZ.connected = false;
                    this.mBZ.mBW = true;
                    this.mBZ.fcE.signalAll();
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "ERROR_AUTHENTICATING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                } finally {
                    this.mBZ.aKS();
                    this.mBZ.mBP.unlock();
                }
            }
        }
    }
}
