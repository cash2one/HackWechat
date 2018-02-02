package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.ui.j.6;

class j$6$1 implements OnClickListener {
    final /* synthetic */ String jha;
    final /* synthetic */ 6 xFP;

    j$6$1(6 6, String str) {
        this.xFP = 6;
        this.jha = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setClassName(this.xFP.xFL.xFE, "com.tencent.mm.ui.account.bind.BindMobileUI");
        intent.putExtra("kstyle_bind_wording", new BindWordingContent(this.jha, ""));
        MMWizardActivity.A(this.xFP.xFL.xFE, intent);
        dialogInterface.dismiss();
    }
}
