package com.tencent.mm.ui.chatting.e;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b$e;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.tools.l;

class d$2 implements b$e {
    final /* synthetic */ d yHr;

    d$2(d dVar) {
        this.yHr = dVar;
    }

    public final void a(int i, b bVar) {
        x.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
        d.a(this.yHr, bVar);
    }

    public final void a(View view, int i, b bVar) {
        x.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
        new l(view.getContext()).b(view, new 1(this), new 2(this, bVar));
    }
}
