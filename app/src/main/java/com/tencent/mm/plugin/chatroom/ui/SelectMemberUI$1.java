package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

class SelectMemberUI$1 implements a {
    final /* synthetic */ SelectMemberUI ldP;

    SelectMemberUI$1(SelectMemberUI selectMemberUI) {
        this.ldP = selectMemberUI;
    }

    public final void xh(String str) {
        if ("↑".equals(str)) {
            SelectMemberUI.a(this.ldP).setSelection(0);
            return;
        }
        int intValue;
        b b = SelectMemberUI.b(this.ldP);
        if (b.ldT.containsKey(str)) {
            intValue = ((Integer) b.ldT.get(str)).intValue();
        } else {
            intValue = -1;
        }
        if (intValue != -1) {
            SelectMemberUI.a(this.ldP).setSelection(intValue);
        }
    }
}
