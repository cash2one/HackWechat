package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiPrivateAddContact extends a {
    public static final int CTRL_INDEX = 407;
    public static final String NAME = "private_addContact";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        int afw = afw();
        try {
            int i2 = jSONObject.getInt("scene");
            String string = jSONObject.getString("username");
            if (bh.ov(string)) {
                x.i("MicroMsg.JsApiPrivateAddContact", "username nil");
                pVar.E(i, e("fail", null));
            }
            ProcessRequest addContactRequest = new AddContactRequest();
            addContactRequest.userName = string;
            addContactRequest.scene = i2;
            addContactRequest.jdL = afw;
            a.a(pVar.mContext, addContactRequest, new 1(this, pVar, i));
        } catch (JSONException e) {
            x.w("MicroMsg.JsApiPrivateAddContact", "parse exp:%s", e);
            pVar.E(i, e("fail", null));
        }
    }

    protected int afw() {
        return 1;
    }
}
