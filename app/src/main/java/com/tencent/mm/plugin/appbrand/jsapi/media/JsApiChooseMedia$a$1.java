package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.plugin.appbrand.q.j;

class JsApiChooseMedia$a$1 implements OnCreateContextMenuListener {
    final /* synthetic */ a jnj;

    JsApiChooseMedia$a$1(a aVar) {
        this.jnj = aVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, a.a(this.jnj).getString(j.dEW));
        contextMenu.add(0, 2, 1, a.b(this.jnj).getString(j.dFa));
    }
}
