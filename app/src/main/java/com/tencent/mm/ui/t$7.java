package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.y;
import com.tencent.mm.h.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.z.ar;

class t$7 implements OnClickListener {
    final /* synthetic */ a icC;
    final /* synthetic */ Activity icz;
    final /* synthetic */ Intent xKb;

    t$7(Intent intent, Activity activity, a aVar) {
        this.xKb = intent;
        this.icz = activity;
        this.icC = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.xKb != null) {
            if (!(this.icz instanceof LauncherUI)) {
                this.icz.finish();
            }
            ar.hold();
            if (bh.ov(this.icC.url)) {
                this.icz.startActivity(this.xKb);
                b.B(this.icz, this.xKb);
            } else {
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
                d.b(this.icz, "webview", ".ui.tools.WebViewUI", intent);
            }
            com.tencent.mm.modelsimple.d.br(this.icz);
            com.tencent.mm.sdk.b.b yVar = new y();
            yVar.fnQ.fnR = true;
            com.tencent.mm.sdk.b.a.xef.m(yVar);
        }
    }
}
