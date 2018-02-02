package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.widget.Toast;
import com.tencent.mm.R;

class NoteEditorUI$11 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$11(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void run() {
        Toast.makeText(this.tXd, this.tXd.getString(R.l.ePi), 0).show();
    }
}
