package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;

class NoteEditorUI$1 implements OnClickListener {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$1(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void onClick(View view) {
        if (NoteEditorUI.a(this.tXd) != null) {
            NoteEditorUI.a(this.tXd).tTh.dismiss();
        }
        NoteEditorUI.b(this.tXd).setVisibility(8);
    }
}
