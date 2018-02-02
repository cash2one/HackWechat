package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class k extends a {
    private static final int CTRL_INDEX = 186;
    private static final String NAME = "notifyBLECharacteristicValueChanged";
    protected static final UUID jhK = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static String jhL = "notification";
    public static String jhM = "indication";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(71);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
            jVar.E(i, e("fail:data is null", null));
            a.bG(73, 74);
            return;
        }
        x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "notifyBLECharacteristicValueChanged!");
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(73, 75);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(73, 77);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(73, 79);
                return;
            }
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            String optString4 = jSONObject.optString(DownloadSettingTable$Columns.TYPE, jhM);
            boolean optBoolean = jSONObject.optBoolean("state");
            x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", " notifyBLECharacteristicValueChanged deviceID : " + optString + ",serviceId : " + optString2 + ", characteristicId : " + optString3 + ",state : " + optBoolean);
            b g = b.g(jVar);
            BluetoothGatt bluetoothGatt = (BluetoothGatt) g.get("key_bluetooth_gatt" + optString, null);
            if (bluetoothGatt == null) {
                x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(73, 80);
                return;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) g.get(optString + optString2 + optString3, null);
            if (bluetoothGattCharacteristic == null) {
                x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "get characteristics failed !");
                hashMap.put("errCode", Integer.valueOf(10005));
                jVar.E(i, e("fail", hashMap));
                a.bG(73, 81);
                return;
            }
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 16) == 0 && (properties & 32) == 0) {
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
                hashMap.put("errCode", Integer.valueOf(CdnLogic.kMediaTypeFavoriteBigFile));
                jVar.E(i, e("fail", hashMap));
                a.bG(73, 82);
                return;
            }
            boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, optBoolean);
            x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "setCharacteristicNotification，state: " + optBoolean + ",suc?" + characteristicNotification);
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(jhK);
            if (descriptor == null) {
                x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "Can not get configure descriptor");
                jVar.E(i, e("fail", hashMap));
                a.bG(73, 83);
                return;
            }
            x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "Configure descriptor permissions: " + descriptor.getPermissions());
            if ((properties & 16) != 0 && (properties & 32) == 0) {
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "support notify. not support indicate...");
                descriptor.setValue(optBoolean ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "writeDescriptor isWriteDescriptorSuc:" + bluetoothGatt.writeDescriptor(descriptor));
            } else if ((properties & 16) != 0 || (properties & 32) == 0) {
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "support both notify and indicate...");
                if (optString4.toLowerCase().equals(jhL)) {
                    descriptor.setValue(optBoolean ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                } else {
                    descriptor.setValue(optBoolean ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                }
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "writeDescriptor isWriteDescriptorSuc:" + bluetoothGatt.writeDescriptor(descriptor));
            } else {
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify .support indicate...");
                descriptor.setValue(optBoolean ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                x.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "writeDescriptor isWriteDescriptorSuc:" + bluetoothGatt.writeDescriptor(descriptor));
            }
            if (characteristicNotification) {
                hashMap.put("errCode", Integer.valueOf(0));
                jVar.E(i, e("ok", hashMap));
                a.kt(72);
                return;
            }
            x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "setCharacteristicNotification failed!");
            hashMap.put("errCode", Integer.valueOf(10008));
            jVar.E(i, e("fail", hashMap));
            a.bG(73, 84);
        } else {
            x.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(73, 76);
        }
    }
}
