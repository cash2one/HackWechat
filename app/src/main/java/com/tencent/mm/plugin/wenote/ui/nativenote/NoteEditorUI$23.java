package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.ui.widget.g;

class NoteEditorUI$23 implements OnMenuItemClickListener {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$23(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.tXd.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        if (NoteEditorUI.d(this.tXd) == 2) {
            c bWp = c.bWp();
            boolean z;
            if (bWp.tSI > 0 || bWp.tSH > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (NoteEditorUI.d(this.tXd) == 2) {
            this.tXd.bWe();
            if (NoteEditorUI.a(this.tXd) != null) {
                NoteEditorUI.a(this.tXd).tTh.dismiss();
            }
            NoteEditorUI.b(this.tXd).setVisibility(8);
            if (NoteEditorUI.G(this.tXd)) {
                e.bXf().bXj();
            }
        }
        NoteEditorUI.w(this.tXd).postDelayed(new 3(this, gVar), 100);
        return false;
    }
}
