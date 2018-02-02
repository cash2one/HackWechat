package com.tencent.mm.plugin.webview.fts;

import android.view.MenuItem;
import com.tencent.mm.plugin.webview.fts.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class a$3 implements d {
    final /* synthetic */ a tlq;
    final /* synthetic */ a tlr;
    final /* synthetic */ int val$id;

    public a$3(a aVar, a aVar2, int i) {
        this.tlq = aVar;
        this.tlr = aVar2;
        this.val$id = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(i));
        if (this.tlr != null) {
            this.tlr.ef(i, this.val$id);
        }
        a.b(this.tlq).remove(Integer.valueOf(this.val$id));
    }
}
