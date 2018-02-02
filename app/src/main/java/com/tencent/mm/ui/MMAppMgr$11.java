package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.sdk.platformtools.ae;

class MMAppMgr$11 implements OnDismissListener {
    final /* synthetic */ OnClickListener tvO;

    MMAppMgr$11(OnClickListener onClickListener) {
        this.tvO = onClickListener;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ae.Vd("show_wap_adviser");
        if (this.tvO != null) {
            this.tvO.onClick(dialogInterface, 0);
        }
    }
}
