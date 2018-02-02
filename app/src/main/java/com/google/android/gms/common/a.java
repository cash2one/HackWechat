package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.w;

public final class a extends DialogFragment {
    private OnCancelListener aJF = null;
    private Dialog qb = null;

    public static a a(Dialog dialog, OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) w.i(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        aVar.qb = dialog2;
        if (onCancelListener != null) {
            aVar.aJF = onCancelListener;
        }
        return aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.aJF != null) {
            this.aJF.onCancel(dialogInterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        if (this.qb == null) {
            setShowsDialog(false);
        }
        return this.qb;
    }

    public final void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
