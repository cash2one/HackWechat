package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public class RedirectToQrCodeStubUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
        String stringExtra = getIntent().getStringExtra("K_STR");
        int intExtra = getIntent().getIntExtra("K_TYPE", -1);
        int intExtra2 = getIntent().getIntExtra("K_VERSION", -1);
        b bzVar = new bz();
        bzVar.fqa.activity = this;
        bzVar.fqa.fov = stringExtra;
        bzVar.fqa.fqb = intExtra;
        bzVar.fqa.fqc = intExtra2;
        bzVar.fqa.scene = 47;
        a.xef.m(bzVar);
        finish();
    }
}
