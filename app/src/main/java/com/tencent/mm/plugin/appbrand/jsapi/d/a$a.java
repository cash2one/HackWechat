package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a$a {
    volatile boolean fAs = false;
    BluetoothAdapter jjJ;
    Map<String, JSONObject> jjK = new HashMap();
    UUID[] jjL = null;
    a jjM;
    LeScanCallback jjN = new LeScanCallback(this) {
        final /* synthetic */ a$a jjO;

        {
            this.jjO = r1;
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bh.bw(bArr)) {
                x.e("MicroMsg.BeaconManager", "valueByte is null or nil");
                return;
            }
            Object obj = null;
            int i2 = 2;
            while (i2 <= 5) {
                if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                    obj = 1;
                    break;
                }
                i2++;
            }
            if (obj != null) {
                int i3;
                Object obj2 = new byte[16];
                System.arraycopy(bArr, i2 + 4, obj2, 0, 16);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i4 = 0; i4 < 16; i4++) {
                    i3 = obj2[i4] & 255;
                    if (i3 < 16) {
                        stringBuilder.append("0");
                    }
                    stringBuilder.append(Integer.toHexString(i3));
                }
                String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
                if (bh.ov(toUpperCase)) {
                    x.e("MicroMsg.BeaconManager", "hexString is null, err");
                    return;
                }
                int i5;
                UUID fromString = UUID.fromString(toUpperCase.substring(0, 8) + "-" + toUpperCase.substring(8, 12) + "-" + toUpperCase.substring(12, 16) + "-" + toUpperCase.substring(16, 20) + "-" + toUpperCase.substring(20, 32));
                obj = null;
                for (UUID equals : this.jjO.jjL) {
                    if (equals.equals(fromString)) {
                        obj = 1;
                        break;
                    }
                }
                if (obj != null) {
                    double d;
                    i3 = ((bArr[i2 + 20] & 255) * 256) + (bArr[i2 + 21] & 255);
                    i5 = ((bArr[i2 + 22] & 255) * 256) + (bArr[i2 + 23] & 255);
                    byte b = bArr[i2 + 24];
                    double d2 = (double) i;
                    if (d2 == 0.0d) {
                        d = -1.0d;
                    } else {
                        d = (d2 * 1.0d) / ((double) b);
                        d = d < 1.0d ? Math.pow(d, 10.0d) : (Math.pow(d, 9.9476d) * 0.92093d) + 0.54992d;
                    }
                    String address = bluetoothDevice.getAddress();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uuid", fromString);
                        jSONObject.put("major", i3);
                        jSONObject.put("minor", i5);
                        jSONObject.put("proximity", 0);
                        jSONObject.put("accuracy", d);
                        jSONObject.put("rssi", i);
                        this.jjO.jjK.put(address, jSONObject);
                        x.d("MicroMsg.BeaconManager", "found device ibeacon %s", new Object[]{jSONObject});
                    } catch (JSONException e) {
                        x.e("MicroMsg.BeaconManager", "put JSON data error : %s", new Object[]{e});
                    }
                    if (this.jjO.jjM != null) {
                        this.jjO.jjM.x(this.jjO.jjK);
                    }
                }
            }
        }
    };

    public a$a() {
        BluetoothManager bluetoothManager = (BluetoothManager) ac.getContext().getSystemService("bluetooth");
        if (bluetoothManager == null) {
            x.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
            return;
        }
        this.jjJ = bluetoothManager.getAdapter();
        if (this.jjJ == null) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        } else {
            a.jjI = this.jjJ.isEnabled();
        }
    }

    final synchronized boolean agj() {
        return this.fAs;
    }

    public final boolean vo() {
        x.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[]{Integer.valueOf(hashCode())});
        if (agj()) {
            this.jjK.clear();
            this.jjJ.stopLeScan(this.jjN);
            this.fAs = false;
            return true;
        }
        x.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[]{Integer.valueOf(hashCode())});
        return false;
    }
}
