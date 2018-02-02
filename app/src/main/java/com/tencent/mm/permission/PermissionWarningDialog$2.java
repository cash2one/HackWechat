package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PermissionWarningDialog$2 implements OnClickListener {
    final /* synthetic */ PermissionWarningDialog ibU;
    final /* synthetic */ boolean ibV;

    PermissionWarningDialog$2(PermissionWarningDialog permissionWarningDialog, boolean z) {
        this.ibU = permissionWarningDialog;
        this.ibV = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.cg(this.ibV);
        this.ibU.finish();
    }
}
