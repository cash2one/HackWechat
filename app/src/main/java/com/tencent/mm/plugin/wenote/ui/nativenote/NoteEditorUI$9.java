package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class NoteEditorUI$9 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;
    final /* synthetic */ ArrayList tXg;

    NoteEditorUI$9(NoteEditorUI noteEditorUI, ArrayList arrayList) {
        this.tXd = noteEditorUI;
        this.tXg = arrayList;
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.tXg.size(); i++) {
            String str = (String) this.tXg.get(i);
            e eVar = new e();
            eVar.tRQ = true;
            eVar.type = 2;
            eVar.tRP = c.bWp().bWv();
            eVar.mvG = f.QI(eVar.toString());
            NoteEditorUI.a(this.tXd, new uq());
            NoteEditorUI.ab(this.tXd).TD(eVar.mvG);
            eVar.tRR = com.tencent.mm.plugin.wenote.b.c.fa(str, f.o(NoteEditorUI.ab(this.tXd)));
            eVar.fCa = com.tencent.mm.plugin.wenote.b.c.fb(eVar.tRR, f.i(NoteEditorUI.ab(this.tXd)));
            arrayList.add(eVar);
        }
        if (NoteEditorUI.Z(this.tXd) == null || !NoteEditorUI.Z(this.tXd).isShowing()) {
            x.i("MicroMsg.Note.NoteEditorUI", "user canceled");
            return;
        }
        c.bWp().a(arrayList, NoteEditorUI.f(this.tXd).bXc(), true, true, false, true, false);
        this.tXd.f(true, 100);
        this.tXd.P(1, 0);
    }
}
