package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.s.5;
import com.tencent.wework.api.WWAPIFactory;

class s$5$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 5 ytW;

    s$5$1(5 5) {
        this.ytW = 5;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, R.l.evQ);
        contextMenu.add(0, 1, 1, R.l.evR);
        if (WWAPIFactory.iN(s.b(this.ytW.ytT).getContext()).cIg()) {
            contextMenu.add(0, 2, 2, s.b(this.ytW.ytT).getContext().getString(R.l.evS, new Object[]{WWAPIFactory.iN(s.b(this.ytW.ytT).getContext()).cIh()}));
        }
    }
}
