package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.bh;

class ContactSearchUI$2 implements OnEditorActionListener {
    final /* synthetic */ ContactSearchUI rYw;

    ContactSearchUI$2(ContactSearchUI contactSearchUI) {
        this.rYw = contactSearchUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (!(keyEvent == null || keyEvent.getKeyCode() != 66 || bh.ov(ContactSearchUI.a(this.rYw).getText().toString().trim()))) {
            ContactSearchUI.b(this.rYw);
        }
        return false;
    }
}
