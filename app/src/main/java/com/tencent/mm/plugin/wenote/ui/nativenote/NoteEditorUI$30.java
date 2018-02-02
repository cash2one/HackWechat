package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NoteEditorUI$30 implements OnMenuItemClickListener {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$30(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (NoteEditorUI.H(this.tXd)) {
            NoteEditorUI.I(this.tXd);
            this.tXd.finish();
        }
        return true;
    }
}
