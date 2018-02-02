package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a;
import com.tencent.mm.ui.tools.l;

class ReaderItemListView$a$1 implements OnLongClickListener {
    final /* synthetic */ a pBA;

    ReaderItemListView$a$1(a aVar) {
        this.pBA = aVar;
    }

    public final boolean onLongClick(View view) {
        new l(this.pBA.pBz.getContext()).b(view, ReaderItemListView.c(this.pBA.pBz), ReaderItemListView.e(this.pBA.pBz));
        return true;
    }
}
