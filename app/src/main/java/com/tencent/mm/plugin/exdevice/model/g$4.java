package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

class g$4 implements a {
    final /* synthetic */ g lMw;

    g$4(g gVar) {
        this.lMw = gVar;
    }

    public final void e(int i, Object... objArr) {
        JSONObject jSONObject;
        String string;
        Exception e;
        Object obj;
        Object obj2;
        int size;
        int i2;
        String str = null;
        if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
            JSONObject jSONObject2;
            try {
                JSONObject jSONObject3 = new JSONObject(new String((byte[]) objArr[0]));
                jSONObject = jSONObject3.getJSONObject("deviceInfo");
                try {
                    string = jSONObject.getString("deviceType");
                } catch (Exception e2) {
                    e = e2;
                    string = null;
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", e);
                    obj = string;
                    obj2 = str;
                    jSONObject2 = jSONObject;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", obj, obj2);
                    size = this.lMw.lMh.size();
                    i2 = 0;
                    while (i2 < size) {
                        this.lMw.lMj.put(obj2, jSONObject2.toString());
                        this.lMw.lMi.add(this.lMw.lMh.get(i2));
                        g.a(this.lMw, this.lMw.lMi);
                        i2++;
                    }
                }
                try {
                    str = jSONObject.getString("deviceId");
                    if (jSONObject3.isNull("profile")) {
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
                        return;
                    }
                    JSONArray jSONArray = jSONObject3.getJSONArray("profile");
                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", jSONArray.toString());
                    String str2 = string;
                    string = str;
                    jSONObject2 = jSONObject;
                    if (!(obj == null || obj2 == null)) {
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", obj, obj2);
                    }
                    size = this.lMw.lMh.size();
                    i2 = 0;
                    while (i2 < size) {
                        if (((b) this.lMw.lMh.get(i2)).field_deviceID.equals(obj2) && ((b) this.lMw.lMh.get(i2)).field_deviceType.equals(obj) && ((b) this.lMw.lMh.get(i2)).gfT.contains("wechat_to_device") && !this.lMw.lMi.contains(this.lMw.lMh.get(i2))) {
                            this.lMw.lMj.put(obj2, jSONObject2.toString());
                            this.lMw.lMi.add(this.lMw.lMh.get(i2));
                            g.a(this.lMw, this.lMw.lMi);
                        }
                        i2++;
                    }
                } catch (Exception e3) {
                    e = e3;
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", e);
                    obj = string;
                    obj2 = str;
                    jSONObject2 = jSONObject;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", obj, obj2);
                    size = this.lMw.lMh.size();
                    i2 = 0;
                    while (i2 < size) {
                        this.lMw.lMj.put(obj2, jSONObject2.toString());
                        this.lMw.lMi.add(this.lMw.lMh.get(i2));
                        g.a(this.lMw, this.lMw.lMi);
                        i2++;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = null;
                string = null;
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", e);
                obj = string;
                obj2 = str;
                jSONObject2 = jSONObject;
                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", obj, obj2);
                size = this.lMw.lMh.size();
                i2 = 0;
                while (i2 < size) {
                    this.lMw.lMj.put(obj2, jSONObject2.toString());
                    this.lMw.lMi.add(this.lMw.lMh.get(i2));
                    g.a(this.lMw, this.lMw.lMi);
                    i2++;
                }
            }
        }
    }
}
