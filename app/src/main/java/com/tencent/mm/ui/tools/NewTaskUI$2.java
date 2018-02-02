package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class NewTaskUI$2 implements OnCancelListener {
    final /* synthetic */ NewTaskUI zmc;
    final /* synthetic */ v zmd;

    NewTaskUI$2(NewTaskUI newTaskUI, v vVar) {
        this.zmc = newTaskUI;
        this.zmd = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.zmd);
    }
}
