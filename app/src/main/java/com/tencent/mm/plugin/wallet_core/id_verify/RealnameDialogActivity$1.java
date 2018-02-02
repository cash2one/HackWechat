package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RealnameDialogActivity$1 implements OnClickListener {
    final /* synthetic */ RealnameDialogActivity sJj;

    RealnameDialogActivity$1(RealnameDialogActivity realnameDialogActivity) {
        this.sJj = realnameDialogActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.sJj.finish();
    }
}
