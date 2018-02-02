package com.tencent.mm.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.AllRemindMsgUI.c.3;

class AllRemindMsgUI$c$3$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 3 xDL;

    AllRemindMsgUI$c$3$1(3 3) {
        this.xDL = 3;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, this.xDL.xDK.xDG.mController.xIM.getString(R.l.dRH));
    }
}
