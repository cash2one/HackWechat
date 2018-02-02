package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;

class NoteEditorUI$5 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$5(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void run() {
        int i = -1;
        try {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) NoteEditorUI.K(this.tXd).TV;
            View a = linearLayoutManager.a(linearLayoutManager.getChildCount() - 1, -1, true, false);
            if (a != null) {
                i = LinearLayoutManager.bd(a);
            }
            b Bt = c.bWp().Bt(i);
            if (Bt != null && Bt.getType() == 4 && !((k) Bt).tRQ) {
                this.tXd.Bm(i);
            }
        } catch (NullPointerException e) {
        }
    }
}
