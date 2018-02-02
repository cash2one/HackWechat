package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

class NoteEditorUI$23$2$1$1 implements Runnable {
    final /* synthetic */ r mwx;
    final /* synthetic */ 1 tXn;

    NoteEditorUI$23$2$1$1(1 1, r rVar) {
        this.tXn = 1;
        this.mwx = rVar;
    }

    public final void run() {
        NoteEditorUI.j(this.tXn.tXm.tXl.tXd).moh = true;
        this.mwx.dismiss();
        x.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[]{Long.valueOf(NoteEditorUI.g(this.tXn.tXm.tXl.tXd))});
        this.tXn.tXm.tXl.tXd.finish();
    }
}
