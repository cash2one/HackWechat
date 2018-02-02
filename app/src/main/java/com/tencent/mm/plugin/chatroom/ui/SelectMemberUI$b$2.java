package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;

class SelectMemberUI$b$2 implements Runnable {
    final /* synthetic */ b ldU;

    SelectMemberUI$b$2(b bVar) {
        this.ldU = bVar;
    }

    public final void run() {
        this.ldU.notifyDataSetChanged();
        if (b.c(this.ldU) == null || b.c(this.ldU).size() != 0) {
            SelectMemberUI.a(this.ldU.ldP).setVisibility(0);
            SelectMemberUI.g(this.ldU.ldP).setVisibility(8);
            return;
        }
        SelectMemberUI.a(this.ldU.ldP).setVisibility(8);
        SelectMemberUI.g(this.ldU.ldP).setVisibility(0);
    }
}
