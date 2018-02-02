package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class j extends a {
    private static final int CTRL_INDEX = 179;
    private static final String NAME = "getConnectedBluetoothDevices";

    public final void a(com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject, int i) {
        a.ks(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j.CTRL_BYTE);
        x.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(JsApiChooseMedia.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(JsApiChooseMedia.CTRL_INDEX, 196);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(JsApiChooseMedia.CTRL_INDEX, 197);
                return;
            }
            List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
            if (connectedDevices == null) {
                x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
                jVar.E(i, e("fail", null));
                a.bG(JsApiChooseMedia.CTRL_INDEX, bc.CTRL_INDEX);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (BluetoothDevice bluetoothDevice : connectedDevices) {
                String address = bluetoothDevice.getAddress();
                String name = bluetoothDevice.getName();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("deviceId", address);
                    jSONObject2.put("name", name);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", new Object[]{e});
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("devices", jSONArray);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", e2, "", new Object[0]);
            }
            x.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", new Object[]{jSONObject3.toString()});
            jVar.E(i, jSONObject3.toString());
            a.kt(ar.CTRL_INDEX);
        } else {
            x.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(JsApiChooseMedia.CTRL_INDEX, JsApiChooseWeChatContact.CTRL_INDEX);
        }
    }
}
