package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.h.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.w;

class t$a$1 implements OnClickListener {
    final /* synthetic */ a icC;
    final /* synthetic */ Context val$context;

    t$a$1(a aVar, Context context) {
        this.icC = aVar;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        StringBuilder stringBuilder = new StringBuilder(this.icC.url);
        stringBuilder.append("&wechat_real_lang=" + w.cfi());
        intent.putExtra("rawUrl", stringBuilder.toString());
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        d.b(this.val$context, "webview", ".ui.tools.WebViewUI", intent);
    }
}
