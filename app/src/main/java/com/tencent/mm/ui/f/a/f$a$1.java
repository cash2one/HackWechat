package com.tencent.mm.ui.f.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.f.a.f.a;

class f$a$1 implements OnDismissListener {
    final /* synthetic */ a zck;

    f$a$1(a aVar) {
        this.zck = aVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.zck.zcj && this.zck.zci != null) {
            f.a(this.zck.zci).onCancel();
            this.zck.zci.dismiss();
        }
    }
}
