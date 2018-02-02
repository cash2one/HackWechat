package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VoiceInputUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ VoiceInputUI vmw;

    VoiceInputUI$3(VoiceInputUI voiceInputUI) {
        this.vmw = voiceInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        VoiceInputUI.c(this.vmw).setText("");
        VoiceInputUI.d(this.vmw);
        this.vmw.BU(6);
        return true;
    }
}
