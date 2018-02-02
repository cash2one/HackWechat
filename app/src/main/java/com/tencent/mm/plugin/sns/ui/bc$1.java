package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;

class bc$1 implements OnDismissListener {
    bc$1() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        g.Dk();
        int a = bh.a((Integer) g.Dj().CU().get(68385, null), 0) + 1;
        g.Dk();
        g.Dj().CU().set(68385, Integer.valueOf(a));
    }
}
