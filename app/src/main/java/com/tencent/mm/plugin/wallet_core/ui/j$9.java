package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;

class j$9 implements OnClickListener {
    final /* synthetic */ Dialog qSc;
    final /* synthetic */ ECardInfo sTP;
    final /* synthetic */ Context val$context;

    public j$9(ECardInfo eCardInfo, Context context, Dialog dialog) {
        this.sTP = eCardInfo;
        this.val$context = context;
        this.qSc = dialog;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletIdCardTip", "go to: %s", new Object[]{Integer.valueOf(this.sTP.sMk)});
        if (this.sTP.sMk == 1) {
            e.l(this.val$context, this.sTP.fKT, false);
        } else {
            b ldVar = new ld();
            ldVar.fCu.fqH = new WeakReference(this.val$context);
            a.xef.m(ldVar);
        }
        if (this.qSc != null && this.qSc.isShowing()) {
            this.qSc.dismiss();
        }
    }
}
