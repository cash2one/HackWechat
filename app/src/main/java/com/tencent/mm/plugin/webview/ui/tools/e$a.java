package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

class e$a {
    public JsapiPermissionWrapper txO;
    public GeneralControlWrapper txP;

    public e$a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        this.txO = jsapiPermissionWrapper;
        this.txP = generalControlWrapper;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Permission: jsPerm = ");
        stringBuilder.append(this.txO);
        stringBuilder.append(", genCtrl = ");
        stringBuilder.append(this.txP);
        return stringBuilder.toString();
    }
}
