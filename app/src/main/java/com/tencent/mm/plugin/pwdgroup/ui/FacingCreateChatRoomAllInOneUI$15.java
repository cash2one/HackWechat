package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;

class FacingCreateChatRoomAllInOneUI$15 implements a {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

    FacingCreateChatRoomAllInOneUI$15(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.pmn = facingCreateChatRoomAllInOneUI;
    }

    public final void input(String str) {
        if (FacingCreateChatRoomAllInOneUI.g(this.pmn) == null) {
            return;
        }
        if (FacingCreateChatRoomAllInOneUI.h(this.pmn) || FacingCreateChatRoomAllInOneUI.i(this.pmn)) {
            MMPwdInputView g = FacingCreateChatRoomAllInOneUI.g(this.pmn);
            g.Tt();
            g.input(str);
            FacingCreateChatRoomAllInOneUI.a(this.pmn, FacingCreateChatRoomAllInOneUI.a.pmr);
            return;
        }
        FacingCreateChatRoomAllInOneUI.g(this.pmn).input(str);
    }

    public final void Tt() {
        if (FacingCreateChatRoomAllInOneUI.g(this.pmn) != null) {
            FacingCreateChatRoomAllInOneUI.g(this.pmn).Tt();
        }
    }

    public final void delete() {
        if (FacingCreateChatRoomAllInOneUI.g(this.pmn) == null) {
            return;
        }
        if (FacingCreateChatRoomAllInOneUI.h(this.pmn) || FacingCreateChatRoomAllInOneUI.i(this.pmn)) {
            FacingCreateChatRoomAllInOneUI.g(this.pmn).Tt();
            FacingCreateChatRoomAllInOneUI.a(this.pmn, FacingCreateChatRoomAllInOneUI.a.pmr);
            return;
        }
        MMPwdInputView g = FacingCreateChatRoomAllInOneUI.g(this.pmn);
        if (g.mna > 0) {
            g.let.deleteCharAt(g.mna - 1);
        }
        g.bjV();
        g.bjU();
    }
}
