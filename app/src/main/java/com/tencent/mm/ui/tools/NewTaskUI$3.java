package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class NewTaskUI$3 implements OnClickListener {
    final /* synthetic */ NewTaskUI zmc;

    NewTaskUI$3(NewTaskUI newTaskUI) {
        this.zmc = newTaskUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(this.zmc).xPq + " img len" + NewTaskUI.a(this.zmc).xPs.length + " " + g.zh());
        if (NewTaskUI.b(this.zmc) == null) {
            x.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            return;
        }
        final k vVar = new v(NewTaskUI.a(this.zmc).xPt, NewTaskUI.b(this.zmc).coF(), NewTaskUI.b(this.zmc).xPq, NewTaskUI.b(this.zmc).xPr);
        ar.CG().a(vVar, 0);
        NewTaskUI newTaskUI = this.zmc;
        Context context = this.zmc;
        this.zmc.getString(R.l.dGO);
        NewTaskUI.a(newTaskUI, h.a(context, this.zmc.getString(R.l.etF), true, new OnCancelListener(this) {
            final /* synthetic */ NewTaskUI$3 zme;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(vVar);
            }
        }));
    }
}
