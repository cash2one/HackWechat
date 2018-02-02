package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import com.tencent.mm.g.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;

class f$7 extends c<b> {
    final /* synthetic */ f tuZ;

    f$7(f fVar) {
        this.tuZ = fVar;
        this.xen = b.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        b bVar2 = (b) bVar;
        if (bVar2 instanceof b) {
            Intent intent = new Intent();
            if (bVar2.fmJ != null) {
                intent.putExtra("card_list", bVar2.fmJ.fmK);
                intent.putExtra("result_code", bVar2.fmJ.bjW);
            }
            if (bVar2.fmJ == null || bVar2.fmJ.bjW != -1) {
                h.bUM().b(16, 0, intent);
            } else {
                h.bUM().b(16, -1, intent);
            }
        }
        return false;
    }
}
