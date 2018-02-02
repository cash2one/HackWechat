package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.z.ar;

class t$1 implements OnClickListener {
    final /* synthetic */ Activity oZ;
    final /* synthetic */ String val$url;
    final /* synthetic */ Intent xKb;

    t$1(String str, Activity activity, Intent intent) {
        this.val$url = str;
        this.oZ = activity;
        this.xKb = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.a(322, 23, 1, true);
        g gVar = g.pQN;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(4023);
        objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bh.ov(this.val$url)), this.val$url});
        gVar.h(11098, objArr);
        ar.hold();
        if (bh.ov(this.val$url)) {
            this.oZ.startActivity(this.xKb);
            b.B(this.oZ, this.xKb);
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.val$url);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
            d.b(this.oZ, "webview", ".ui.tools.WebViewUI", intent);
        }
        com.tencent.mm.modelsimple.d.br(this.oZ);
    }
}
