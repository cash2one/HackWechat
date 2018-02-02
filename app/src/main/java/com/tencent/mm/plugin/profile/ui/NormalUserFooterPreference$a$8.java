package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.report.service.g;

class NormalUserFooterPreference$a$8 implements OnClickListener {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ a pkC;
    final /* synthetic */ String pkG;

    NormalUserFooterPreference$a$8(a aVar, ProgressDialog progressDialog, String str) {
        this.pkC = aVar;
        this.lao = progressDialog;
        this.pkG = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14553, new Object[]{Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(this.pkC.pkA).field_username});
        this.lao.show();
        this.pkC.isDeleteCancel = false;
        this.pkC.qU(this.pkG);
    }
}
