package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;

class ChatroomContactUI$12 implements OnItemLongClickListener {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$12(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
        if (i < ChatroomContactUI.b(this.yRt).getHeaderViewsCount()) {
            x.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
            return true;
        } else if (ChatroomContactUI.d(this.yRt) != null && ChatroomContactUI.d(this.yRt).zqC) {
            return true;
        } else {
            String str = ((com.tencent.mm.storage.x) ChatroomContactUI.f(this.yRt).getItem(i - ChatroomContactUI.b(this.yRt).getHeaderViewsCount())).field_username;
            if (s.hd(str) || s.he(str)) {
                return true;
            }
            ChatroomContactUI.c(this.yRt, str);
            ChatroomContactUI.j(this.yRt).a(view, i, j, this.yRt, ChatroomContactUI.g(this.yRt), ChatroomContactUI.h(this.yRt), ChatroomContactUI.i(this.yRt));
            return true;
        }
    }
}
