package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

public final class e {
    public static void bo(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        intent.putExtra("KFromLoginHistory", false);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
