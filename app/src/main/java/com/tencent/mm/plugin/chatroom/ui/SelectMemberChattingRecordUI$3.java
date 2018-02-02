package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelectMemberChattingRecordUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SelectMemberChattingRecordUI ldF;

    SelectMemberChattingRecordUI$3(SelectMemberChattingRecordUI selectMemberChattingRecordUI) {
        this.ldF = selectMemberChattingRecordUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ldF.setResult(0);
        this.ldF.finish();
        return true;
    }
}
