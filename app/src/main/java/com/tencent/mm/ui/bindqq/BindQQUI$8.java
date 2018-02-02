package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class BindQQUI$8 implements OnClickListener {
    final /* synthetic */ BindQQUI ymH;

    BindQQUI$8(BindQQUI bindQQUI) {
        this.ymH = bindQQUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", this.ymH.getString(R.l.eNG));
        intent.putExtra("from_unbind", true);
        d.b(this.ymH, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
    }
}
