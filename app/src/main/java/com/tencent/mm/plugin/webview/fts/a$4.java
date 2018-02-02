package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.g.a;

class a$4 implements a {
    final /* synthetic */ a tlq;
    final /* synthetic */ a$a tlr;
    final /* synthetic */ int val$id;

    public a$4(a aVar, a$a com_tencent_mm_plugin_webview_fts_a_a, int i) {
        this.tlq = aVar;
        this.tlr = com_tencent_mm_plugin_webview_fts_a_a;
        this.val$id = i;
    }

    public final void onDismiss() {
        x.v("FTSSearchActionSheetMgr", "selected pos %d", new Object[]{Integer.valueOf(-1)});
        if (this.tlr != null) {
            this.tlr.ef(-1, this.val$id);
        }
        a.b(this.tlq).remove(Integer.valueOf(this.val$id));
    }
}
