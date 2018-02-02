package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.z.ar;

class ContactSearchUI$5 implements OnCancelListener {
    final /* synthetic */ ac kBB;
    final /* synthetic */ ContactSearchUI rYw;

    ContactSearchUI$5(ContactSearchUI contactSearchUI, ac acVar) {
        this.rYw = contactSearchUI;
        this.kBB = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kBB);
    }
}
