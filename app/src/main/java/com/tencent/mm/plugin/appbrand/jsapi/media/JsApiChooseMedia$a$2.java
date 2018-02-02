package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.ui.base.p$d;

class JsApiChooseMedia$a$2 implements p$d {
    final /* synthetic */ a jnj;

    JsApiChooseMedia$a$2(a aVar) {
        this.jnj = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.c(this.jnj);
                return;
            case 2:
                a.d(this.jnj);
                return;
            default:
                return;
        }
    }
}
