package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2;

class NoteEditorUI$23$2$4 implements Runnable {
    final /* synthetic */ 2 tXm;

    NoteEditorUI$23$2$4(2 2) {
        this.tXm = 2;
    }

    public final void run() {
        NoteEditorUI.f(this.tXm.tXl.tXd).bXb();
        b aVar = new a();
        aVar.tRt = false;
        aVar.tRz = false;
        c.bWp().a(aVar);
        int i = NoteEditorUI.f(this.tXm.tXl.tXd).tUp;
        NoteEditorUI.f(this.tXm.tXl.tXd).tUp = 3;
        h.Bl(i);
    }
}
