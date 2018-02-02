package com.tencent.mm.plugin.webview.fts;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.ui.base.p.a;
import java.util.List;

class a$1 implements a {
    final /* synthetic */ List msj;
    final /* synthetic */ a tlq;

    public a$1(a aVar, List list) {
        this.tlq = aVar;
        this.msj = list;
    }

    public final void a(ImageView imageView, MenuItem menuItem) {
        com.tencent.mm.aq.a.a.PH().a(((z) this.msj.get(menuItem.getItemId())).iconUrl, imageView, a.a(this.tlq));
    }
}
