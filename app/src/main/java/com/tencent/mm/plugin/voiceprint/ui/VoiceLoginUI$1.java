package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VoiceLoginUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ VoiceLoginUI shW;

    VoiceLoginUI$1(VoiceLoginUI voiceLoginUI) {
        this.shW = voiceLoginUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        VoiceLoginUI.a(this.shW);
        return true;
    }
}
