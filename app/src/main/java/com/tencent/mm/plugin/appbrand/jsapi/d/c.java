package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.annotation.TargetApi;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends a {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";
    b jhH = null;
    private a.a.a jjM;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", jSONObject);
        UUID[] p = p(jSONObject);
        if (p == null || p.length <= 0) {
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS));
            jVar.E(i, e("fail", hashMap));
            return;
        }
        int i2;
        String str = jVar.mAppId;
        a.a sp = a.sp(jVar.mAppId);
        if (sp == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
            sp = new a.a();
            a.a(str, sp);
        }
        if (this.jjM == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
            this.jjM = new 1(this, jVar);
        }
        if (this.jhH == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
            this.jhH = new 2(this, jVar);
            com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, this.jhH);
        }
        sp.jjL = p;
        sp.jjM = this.jjM;
        x.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", Integer.valueOf(sp.hashCode()));
        if (sp.agj()) {
            x.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", Integer.valueOf(sp.hashCode()));
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY;
        } else if (f.fN(18)) {
            x.e("MicroMsg.BeaconManager", "API version is below 18!");
            i2 = CdnLogic.kMediaTypeExposeImage;
        } else if (sp.jjJ == null) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS;
        } else if (!sp.jjJ.isEnabled()) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS;
        } else if (sp.jjJ.isDiscovering()) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY;
        } else {
            sp.jjK.clear();
            x.i("MicroMsg.BeaconManager", "startLeScan:%b", Boolean.valueOf(sp.jjJ.startLeScan(sp.jjN)));
            if (sp.jjJ.startLeScan(sp.jjN)) {
                sp.fAs = true;
                i2 = 0;
            } else {
                i2 = TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL;
            }
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("errCode", Integer.valueOf(i2));
        jVar.E(i, e(i2 == 0 ? "ok" : "fail", hashMap2));
    }

    private static UUID[] p(JSONObject jSONObject) {
        UUID[] uuidArr = null;
        if (jSONObject.has("uuids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("uuids"));
                uuidArr = new UUID[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    x.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", jSONArray.getString(i));
                    uuidArr[i] = UUID.fromString(r3);
                }
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
            }
        }
        return uuidArr;
    }
}
