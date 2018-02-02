package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d;

class NoteEditorUI$15 implements OnCancelListener {
    final /* synthetic */ NoteEditorUI tXd;
    final /* synthetic */ d tXh;
    final /* synthetic */ j tXi;

    NoteEditorUI$15(NoteEditorUI noteEditorUI, d dVar, j jVar) {
        this.tXd = noteEditorUI;
        this.tXh = dVar;
        this.tXi = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d dVar = this.tXh;
        dVar.isStop = true;
        dVar.interrupt();
        this.tXi.tRG = true;
        this.tXd.f(true, 100);
        this.tXd.P(1, 0);
    }
}
