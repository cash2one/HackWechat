package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.util.Base64;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends a {
    private static final int CTRL_INDEX = 184;
    private static final String NAME = "writeBLECharacteristicValue";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(56);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
            jVar.E(i, e("fail:data is null", null));
            a.bG(58, 59);
            return;
        }
        x.i("MicroMsg.JsApiWriteBLECharacteristicValue", "writeBLECharacteristicValue data %s", new Object[]{jSONObject});
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(58, 60);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(58, 62);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bluetoothAdapter is null or not enable!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(58, 63);
                return;
            }
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            String optString4 = jSONObject.optString(DownloadSettingTable$Columns.VALUE);
            b g = b.g(jVar);
            BluetoothGatt bluetoothGatt = (BluetoothGatt) g.get("key_bluetooth_gatt" + optString, null);
            if (bluetoothGatt == null) {
                x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(58, 64);
                return;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) g.get(optString + optString2 + optString3, null);
            if (bluetoothGattCharacteristic == null) {
                x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "get characteristics failed !");
                hashMap.put("errCode", Integer.valueOf(10005));
                jVar.E(i, e("fail", hashMap));
                a.bG(58, 65);
                return;
            }
            bluetoothGattCharacteristic.setValue(V(Base64.decode(optString4, 2)));
            b.e(jVar);
            b.ku(i);
            boolean writeCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            x.i("MicroMsg.JsApiWriteBLECharacteristicValue", "start write retWrite: " + writeCharacteristic);
            if (writeCharacteristic) {
                int properties = bluetoothGattCharacteristic.getProperties();
                if ((properties & 4) != 0 && (properties & 8) == 0) {
                    hashMap.put("errCode", Integer.valueOf(0));
                    jVar.E(i, e("ok", hashMap));
                    a.kt(57);
                    return;
                }
                return;
            }
            x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "start write fail..");
            hashMap.put("errCode", Integer.valueOf(10008));
            jVar.E(i, e("fail", hashMap));
            a.bG(58, 66);
        } else {
            x.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(58, 61);
        }
    }

    private static byte[] V(byte[] bArr) {
        int i = 0;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2;
        int length = bArr.length;
        if (bArr.length < length) {
            x.w("MicroMsg.JsApiWriteBLECharacteristicValue", "data length is shorter then print command length");
            length = bArr.length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2] & 255;
            if (i3 < 16) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(i3));
        }
        String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
        x.d("MicroMsg.JsApiWriteBLECharacteristicValue", "write data = %s", new Object[]{toUpperCase});
        if (toUpperCase == null || toUpperCase.equals("")) {
            return new byte[0];
        }
        i2 = toUpperCase.toUpperCase().length() / 2;
        char[] toCharArray = toUpperCase.toCharArray();
        byte[] bArr2 = new byte[i2];
        while (i < i2) {
            i3 = i * 2;
            bArr2[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3])) << 4));
            i++;
        }
        return bArr2;
    }
}
