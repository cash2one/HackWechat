package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

class h$12 implements OnClickListener {
    final /* synthetic */ h$b sXe;
    final /* synthetic */ Context val$context;
    final /* synthetic */ MMEditText xYR;

    h$12(h$b com_tencent_mm_ui_base_h_b, MMEditText mMEditText, Context context) {
        this.sXe = com_tencent_mm_ui_base_h_b;
        this.xYR = mMEditText;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        if (this.sXe != null) {
            z = this.sXe.v(this.xYR.getText().toString().trim());
        }
        if (z) {
            dialogInterface.dismiss();
            if (this.val$context instanceof MMActivity) {
                ag.y(new 1(this));
            }
        }
    }
}
