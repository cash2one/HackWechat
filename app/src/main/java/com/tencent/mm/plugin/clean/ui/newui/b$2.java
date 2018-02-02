package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import com.tencent.mm.plugin.clean.ui.newui.b.a;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;

class b$2 implements c {
    final /* synthetic */ b lhJ;

    b$2(b bVar) {
        this.lhJ = bVar;
    }

    public final void cl(View view) {
        b.a(this.lhJ, (a) view.getTag());
        this.lhJ.notifyDataSetChanged();
    }
}
