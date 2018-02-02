package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MMAppMgr$9 implements OnClickListener {
    final /* synthetic */ int hHK;

    MMAppMgr$9(int i) {
        this.hHK = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        c.CU().set(65, Integer.valueOf(this.hHK + 1));
    }
}
