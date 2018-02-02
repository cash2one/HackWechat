package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class BindMContactIntroUI$2 implements OnClickListener {
    final /* synthetic */ BindMContactIntroUI ylI;

    BindMContactIntroUI$2(BindMContactIntroUI bindMContactIntroUI) {
        this.ylI = bindMContactIntroUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", this.ylI.getString(R.l.eNG));
        intent.putExtra("from_unbind", true);
        d.b(this.ylI, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
    }
}
