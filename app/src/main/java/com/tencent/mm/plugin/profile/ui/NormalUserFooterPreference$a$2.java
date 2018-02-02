package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.sdk.b.b;

class NormalUserFooterPreference$a$2 implements OnClickListener {
    final /* synthetic */ a pkC;

    NormalUserFooterPreference$a$2(a aVar) {
        this.pkC = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b riVar = new ri();
        riVar.fJc.fJf = true;
        com.tencent.mm.sdk.b.a.xef.m(riVar);
        this.pkC.bjG();
        dialogInterface.dismiss();
    }
}
