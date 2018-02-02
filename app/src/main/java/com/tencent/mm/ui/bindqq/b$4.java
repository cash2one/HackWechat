package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class b$4 implements OnClickListener {
    final /* synthetic */ b ymM;

    b$4(b bVar) {
        this.ymM = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ymM.pyk = null;
        this.ymM.onDetach();
        this.ymM.cqF();
    }
}
