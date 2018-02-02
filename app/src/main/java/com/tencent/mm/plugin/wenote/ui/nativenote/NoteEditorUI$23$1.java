package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class NoteEditorUI$23$1 implements c {
    final /* synthetic */ 23 tXl;

    NoteEditorUI$23$1(23 23) {
        this.tXl = 23;
    }

    public final void a(n nVar) {
        if (NoteEditorUI.d(this.tXl.tXd) == 1) {
            nVar.f(4, this.tXl.tXd.getString(R.l.egz));
            NoteEditorUI.a(this.tXl.tXd, nVar);
            nVar.f(3, this.tXl.tXd.getString(R.l.eAd));
        } else if (NoteEditorUI.d(this.tXl.tXd) == 2) {
            int i;
            nVar.f(0, this.tXl.tXd.getString(R.l.egz));
            if (a.bXD()) {
                nVar.f(7, this.tXl.tXd.mController.xIM.getString(R.l.egb));
            }
            String str = (String) com.tencent.mm.z.c.c.IF().fn("100353").chI().get("Close");
            if (bh.ov(str)) {
                i = 0;
            } else {
                i = bh.getInt(str, 0);
            }
            if ((i == 0 ? 1 : 0) != 0) {
                nVar.f(8, this.tXl.tXd.mController.xIM.getString(R.l.eyq));
            }
            NoteEditorUI.a(this.tXl.tXd, nVar);
            nVar.f(1, this.tXl.tXd.getString(R.l.eeY));
            nVar.f(2, this.tXl.tXd.mController.xIM.getString(R.l.dEw));
        } else if (NoteEditorUI.d(this.tXl.tXd) == 4) {
            nVar.f(9, this.tXl.tXd.getString(R.l.egz));
            if (a.bXD()) {
                nVar.f(12, this.tXl.tXd.mController.xIM.getString(R.l.egb));
            }
            nVar.f(10, this.tXl.tXd.getString(R.l.eAd));
        }
    }
}
