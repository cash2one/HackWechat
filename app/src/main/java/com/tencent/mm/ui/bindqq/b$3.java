package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class b$3 implements OnCancelListener {
    final /* synthetic */ b ymM;

    b$3(b bVar) {
        this.ymM = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.ymM.onDetach();
    }
}
