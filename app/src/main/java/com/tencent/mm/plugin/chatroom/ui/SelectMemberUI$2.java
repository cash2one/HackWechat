package com.tencent.mm.plugin.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.z.ar;

class SelectMemberUI$2 implements TextWatcher {
    final /* synthetic */ SelectMemberUI ldP;
    private ak ldQ = new ak(ar.Dm().oAt.getLooper(), new 1(this), false);

    SelectMemberUI$2(SelectMemberUI selectMemberUI) {
        this.ldP = selectMemberUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.ldQ.TG();
        this.ldQ.J(500, 500);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
