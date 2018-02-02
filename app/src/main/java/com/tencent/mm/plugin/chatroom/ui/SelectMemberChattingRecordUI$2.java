package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class SelectMemberChattingRecordUI$2 implements a {
    final /* synthetic */ SelectMemberChattingRecordUI ldF;

    SelectMemberChattingRecordUI$2(SelectMemberChattingRecordUI selectMemberChattingRecordUI) {
        this.ldF = selectMemberChattingRecordUI;
    }

    public final void axW() {
        if (SelectMemberChattingRecordUI.a(this.ldF) != null) {
            SelectMemberChattingRecordUI$a a = SelectMemberChattingRecordUI.a(this.ldF);
            a.ldH -= 16;
            if (!bh.ov(SelectMemberChattingRecordUI.c(a.ldF)) && q.gr(SelectMemberChattingRecordUI.c(a.ldF))) {
                ar.Hg();
                a.setCursor(c.Fa().bE(a.jRw, a.hKb - a.ldH));
            } else if (!q.gr(SelectMemberChattingRecordUI.c(a.ldF))) {
                ar.Hg();
                a.setCursor(c.Fa().B(a.jRw, a.ldG, a.hKb - a.ldH));
            }
            SelectMemberChattingRecordUI.a(this.ldF).notifyDataSetChanged();
        }
    }
}
