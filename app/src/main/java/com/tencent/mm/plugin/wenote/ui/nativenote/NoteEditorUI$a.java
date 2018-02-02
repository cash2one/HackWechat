package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.b;

class NoteEditorUI$a extends b {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$a(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void bXL() {
        NoteEditorUI.X(this.tXd);
    }

    public final void bXM() {
        NoteEditorUI.X(this.tXd);
    }

    public final void bXN() {
        NoteEditorUI.Y(this.tXd).moi = true;
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (recyclerView.TV != null) {
            View childAt = ((LinearLayoutManager) NoteEditorUI.K(this.tXd).TV).getChildAt(0);
            if (childAt != null) {
                NoteEditorUI.b(this.tXd, childAt.getTop());
                NoteEditorUI.a(this.tXd, LinearLayoutManager.bd(childAt));
            }
        }
    }
}
