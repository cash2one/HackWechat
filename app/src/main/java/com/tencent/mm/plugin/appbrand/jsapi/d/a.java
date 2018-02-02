package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static BroadcastReceiver jjH;
    public static boolean jjI;
    public static Map<String, a> map = new ConcurrentHashMap();

    public static void a(String str, a aVar) {
        map.put(str, aVar);
        if (jjH == null) {
            x.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
            jjH = new 1();
            ac.getContext().registerReceiver(jjH, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public static a sp(String str) {
        return (a) map.get(str);
    }

    public static void remove(String str) {
        map.remove(str);
        x.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[]{str});
        if (map.size() == 0 && jjH != null) {
            x.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
            ac.getContext().unregisterReceiver(jjH);
            jjH = null;
        }
    }
}
