package com.tencent.mm.plugin.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;

class RoomCardUI$a implements TextWatcher {
    final /* synthetic */ RoomCardUI lbL;
    private int lbN;
    private String lbO;
    private boolean lbP;

    private RoomCardUI$a(RoomCardUI roomCardUI) {
        this.lbL = roomCardUI;
        this.lbN = 280;
        this.lbO = "";
        this.lbP = false;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        RoomCardUI.d(this.lbL);
    }

    public final void afterTextChanged(Editable editable) {
    }
}
