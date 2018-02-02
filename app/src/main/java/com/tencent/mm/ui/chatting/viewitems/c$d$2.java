package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.ui.chatting.viewitems.c.d;

class c$d$2 implements h {
    final /* synthetic */ c$c yJE;
    final /* synthetic */ d yJF;

    c$d$2(d dVar, c$c com_tencent_mm_ui_chatting_viewitems_c_c) {
        this.yJF = dVar;
        this.yJE = com_tencent_mm_ui_chatting_viewitems_c_c;
    }

    public final void Jm() {
    }

    public final void j(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.yJE.yJt.setVisibility(4);
            this.yJE.yJu.setVisibility(0);
            return;
        }
        this.yJE.yJt.setImageBitmap(bitmap);
        this.yJE.yJt.setVisibility(0);
        this.yJE.yJu.setVisibility(4);
    }

    public final void Jn() {
    }

    public final String Jo() {
        return "CHAT#" + k.bi(this);
    }
}
