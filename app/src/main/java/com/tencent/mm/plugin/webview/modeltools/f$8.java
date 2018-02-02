package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class f$8 extends c<bv> {
    final /* synthetic */ f tuZ;

    f$8(f fVar) {
        this.tuZ = fVar;
        this.xen = bv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bv bvVar = (bv) bVar;
        if (bvVar instanceof bv) {
            Intent intent = new Intent();
            if (bvVar.fpY == null || bvVar.fpY.bjW != -1) {
                h.bUM().b(29, 0, intent);
            } else {
                h.bUM().b(29, -1, intent);
            }
        }
        return false;
    }
}
