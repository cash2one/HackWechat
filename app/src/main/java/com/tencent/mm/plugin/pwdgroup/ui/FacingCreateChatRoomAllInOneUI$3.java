package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView$a;

class FacingCreateChatRoomAllInOneUI$3 implements MMCallBackScrollView$a {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

    FacingCreateChatRoomAllInOneUI$3(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.pmn = facingCreateChatRoomAllInOneUI;
    }

    public final void bp(int i) {
        if (FacingCreateChatRoomAllInOneUI.j(this.pmn) == null) {
            return;
        }
        if (i == 0) {
            FacingCreateChatRoomAllInOneUI.j(this.pmn).setVisibility(4);
        } else {
            FacingCreateChatRoomAllInOneUI.j(this.pmn).setVisibility(0);
        }
    }
}
