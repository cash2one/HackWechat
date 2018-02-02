package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.game.c.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class ah extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "logInJava";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(j jVar, JSONObject jSONObject, int i) {
        try {
            int i2 = jSONObject.getInt("level");
            String string = jSONObject.getString("logs");
            switch (i2) {
                case 0:
                    x.d("MicroMsg.JsApiLogInJava", string);
                    break;
                case 1:
                    x.i("MicroMsg.JsApiLogInJava", string);
                    break;
                case 2:
                    x.w("MicroMsg.JsApiLogInJava", string);
                    break;
                case 3:
                    x.e("MicroMsg.JsApiLogInJava", string);
                    break;
                default:
                    x.d("MicroMsg.JsApiLogInJava", string);
                    break;
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiLogInJava", e.toString());
        }
        d.aee().rN(jSONObject.toString());
    }
}
