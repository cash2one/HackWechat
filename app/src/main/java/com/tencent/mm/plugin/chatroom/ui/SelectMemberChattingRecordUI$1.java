package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.storage.au;

class SelectMemberChattingRecordUI$1 implements OnItemClickListener {
    final /* synthetic */ SelectMemberChattingRecordUI ldF;

    SelectMemberChattingRecordUI$1(SelectMemberChattingRecordUI selectMemberChattingRecordUI) {
        this.ldF = selectMemberChattingRecordUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        au auVar = (au) SelectMemberChattingRecordUI.a(this.ldF).getItem(i);
        if (auVar != null) {
            SelectMemberChattingRecordUI.a(this.ldF, auVar.field_msgId);
        }
    }
}
