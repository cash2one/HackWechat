package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wenote.model.h;

class NoteEditorUI$29 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;
    final /* synthetic */ Bitmap tXp;

    NoteEditorUI$29(NoteEditorUI noteEditorUI, Bitmap bitmap) {
        this.tXd = noteEditorUI;
        this.tXp = bitmap;
    }

    public final void run() {
        h.a(this.tXd.mController.xIM, this.tXp, NoteEditorUI.z(this.tXd));
    }
}
