package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.lang.ref.WeakReference;

class h$15 implements OnCancelListener {
    final /* synthetic */ WeakReference xYW;

    h$15(WeakReference weakReference) {
        this.xYW = weakReference;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        OnCancelListener onCancelListener = (OnCancelListener) this.xYW.get();
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
        ac.a(false, null);
    }
}
