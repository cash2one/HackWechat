package com.tencent.mm.ui.chatting.e;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.e.a.a;
import com.tencent.mm.ui.tools.l;

class a$2 implements e {
    final /* synthetic */ a yHc;

    a$2(a aVar) {
        this.yHc = aVar;
    }

    public final void a(int i, b bVar) {
        x.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
        a.a(this.yHc, (a) bVar);
    }

    public final void a(View view, int i, b bVar) {
        x.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
        new l(view.getContext()).b(view, new 1(this), new 2(this, bVar));
    }
}
