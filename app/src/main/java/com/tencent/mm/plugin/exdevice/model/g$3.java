package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class g$3 implements a {
    final /* synthetic */ g lMw;

    g$3(g gVar) {
        this.lMw = gVar;
    }

    public final void e(int i, Object... objArr) {
        int i2;
        Object obj;
        if (i == 15 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
            int intValue = ((Integer) objArr[0]).intValue();
            try {
                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", new String((byte[]) objArr[1]));
                int i3 = new JSONObject(r1).getInt("progress");
                try {
                    g.a(this.lMw, (String) this.lMw.lMv.get(Integer.valueOf(intValue)), i3);
                    if (i3 >= 100) {
                        this.lMw.lMv.remove(Integer.valueOf(intValue));
                    }
                    i2 = i3;
                } catch (JSONException e) {
                    JSONException jSONException = e;
                    i2 = i3;
                    JSONException jSONException2 = jSONException;
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", obj);
                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                }
            } catch (JSONException e2) {
                obj = e2;
                i2 = 0;
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", obj);
                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
            }
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
        }
    }
}
