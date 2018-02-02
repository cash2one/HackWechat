package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;

class e$6 implements OnMenuItemClickListener {
    final /* synthetic */ e jvd;
    final /* synthetic */ String jvk;
    final /* synthetic */ String jvl;

    e$6(e eVar, String str, String str2) {
        this.jvd = eVar;
        this.jvk = str;
        this.jvl = str2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e eVar = this.jvd;
        String str = this.jvk;
        String i = e.i(this.jvd);
        String str2 = this.jvl;
        int i2 = this.jvd.juU;
        int i3 = this.jvd.juV;
        if (str != null) {
            Intent intent = new Intent();
            intent.setClass(eVar.juN.getContext(), WebviewScanImageActivity.class);
            intent.putExtra("key_string_for_scan", str);
            intent.putExtra("key_string_for_url", i);
            intent.putExtra("key_string_for_image_url", str2);
            intent.putExtra("key_codetype_for_scan", i2);
            intent.putExtra("key_codeversion_for_scan", i3);
            eVar.juN.getContext().startActivity(intent);
        }
        return false;
    }
}
