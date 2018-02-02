package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.i;
import android.support.v4.app.m;
import com.google.android.gms.common.internal.w;

public final class f extends i {
    private OnCancelListener aJF = null;
    private Dialog qb = null;

    public static f b(Dialog dialog, OnCancelListener onCancelListener) {
        f fVar = new f();
        Dialog dialog2 = (Dialog) w.i(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        fVar.qb = dialog2;
        if (onCancelListener != null) {
            fVar.aJF = onCancelListener;
        }
        return fVar;
    }

    public final void a(m mVar, String str) {
        super.a(mVar, str);
    }

    public final Dialog aO() {
        if (this.qb == null) {
            this.pZ = false;
        }
        return this.qb;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.aJF != null) {
            this.aJF.onCancel(dialogInterface);
        }
    }
}
