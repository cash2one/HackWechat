package com.tencent.mm.plugin.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SeeRoomMemberUI$6 implements TextWatcher {
    final /* synthetic */ SeeRoomMemberUI lde;

    SeeRoomMemberUI$6(SeeRoomMemberUI seeRoomMemberUI) {
        this.lde = seeRoomMemberUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SeeRoomMemberUI.c(this.lde).xg(charSequence.toString());
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
