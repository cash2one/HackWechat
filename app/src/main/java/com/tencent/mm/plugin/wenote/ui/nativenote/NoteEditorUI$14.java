package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class NoteEditorUI$14 implements a {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$14(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void a(String str, j jVar) {
        x.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
        if (!bh.ov(str) && FileOp.bO(str) && jVar != null) {
            jVar.fvC = str;
        }
    }

    public final void b(String str, j jVar) {
        x.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
        if (NoteEditorUI.Z(this.tXd) != null) {
            NoteEditorUI.Z(this.tXd).dismiss();
            NoteEditorUI.aa(this.tXd);
        }
        if (bh.ov(str) || !e.bO(str) || jVar == null || jVar.tRG) {
            x.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
        } else if (new File(str).length() < NoteEditorUI.bXK()) {
            jVar.fCa = str;
            c.bWp().a((b) jVar, NoteEditorUI.f(this.tXd).bXc(), false, true, false);
        } else {
            Toast.makeText(this.tXd.mController.xIM, this.tXd.getString(R.l.egO), 1).show();
        }
        this.tXd.f(true, 100);
        this.tXd.P(1, 0);
    }
}
