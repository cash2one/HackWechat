package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class NoteEditorUI$27 implements OnClickListener {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$27(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.tXd.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
