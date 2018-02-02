package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;

class a$1 implements OnClickListener {
    final /* synthetic */ b sXe;
    final /* synthetic */ EditText sXf;
    final /* synthetic */ Context val$context;

    a$1(b bVar, EditText editText, Context context) {
        this.sXe = bVar;
        this.sXf = editText;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        if (this.sXe != null) {
            z = this.sXe.v(this.sXf.getText().toString().trim());
        }
        if (z) {
            dialogInterface.dismiss();
            if (this.val$context instanceof MMActivity) {
                ag.y(new 1(this));
            }
        }
    }
}
