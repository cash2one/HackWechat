package com.tencent.mm.plugin.brandservice.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a;

class EnterpriseBizContactListView$a$1 implements OnCreateContextMenuListener {
    final /* synthetic */ a kGv;
    final /* synthetic */ int kI;

    EnterpriseBizContactListView$a$1(a aVar, int i) {
        this.kGv = aVar;
        this.kI = i;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(this.kI, 1, 0, R.l.ebU);
    }
}
