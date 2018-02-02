package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

class NoteEditorUI$23$2$1 implements OnClickListener {
    final /* synthetic */ 2 tXm;

    NoteEditorUI$23$2$1(2 2) {
        this.tXm = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        r a = h.a(this.tXm.tXl.tXd.mController.xIM, this.tXm.tXl.tXd.getString(R.l.dEx), false, null);
        this.tXm.tXl.tXd.tWs.bXb();
        b fvVar = new fv();
        fvVar.fvq.type = 12;
        fvVar.fvq.fqk = this.tXm.tXl.tXd.hzP;
        fvVar.fvq.fvv = new 1(this, a);
        a.xef.m(fvVar);
    }
}
