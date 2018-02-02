package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import com.tencent.mm.plugin.clean.ui.fileindexui.b.a;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;

class b$3 implements c {
    final /* synthetic */ b lgr;

    b$3(b bVar) {
        this.lgr = bVar;
    }

    public final void cl(View view) {
        b.a(this.lgr, (a) view.getTag());
        this.lgr.notifyDataSetChanged();
    }
}
