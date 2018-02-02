package com.tencent.mm.plugin.g.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static boolean co(Context context) {
        x.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", new Object[]{Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))});
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean art() {
        boolean z;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static boolean arv() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return false;
        }
        x.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", new Object[]{Boolean.valueOf(defaultAdapter.isEnabled())});
        return defaultAdapter.isEnabled();
    }

    @Deprecated
    public static String bM(long j) {
        return b.cK(j);
    }
}
