package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PermissionWarningDialog$1 implements OnClickListener {
    final /* synthetic */ PermissionWarningDialog ibU;

    PermissionWarningDialog$1(PermissionWarningDialog permissionWarningDialog) {
        this.ibU = permissionWarningDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ibU.finish();
    }
}
