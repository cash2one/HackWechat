package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactRequest;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.sdk.platformtools.x;

final class JsApiPrivateAddContact$a extends AppBrandProxyUIProcessTask {
    private JsApiPrivateAddContact$a() {
    }

    protected final void a(ProcessRequest processRequest) {
        boolean z = true;
        ProcessResult addContactResult = new AddContactResult();
        if (processRequest instanceof AddContactRequest) {
            AddContactRequest addContactRequest = (AddContactRequest) processRequest;
            g gVar = (g) com.tencent.mm.kernel.g.h(g.class);
            Context afe = afe();
            String str = addContactRequest.userName;
            int i = addContactRequest.scene;
            l 1 = new 1(this, addContactResult);
            if (addContactRequest.jdL != 1) {
                z = false;
            }
            gVar.a(afe, str, i, 1, z, "").show();
            return;
        }
        x.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
        AddContactResult.b(addContactResult);
        a(addContactResult);
    }
}
