package com.tencent.mm.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PermissionWarningDialog$3 implements OnClickListener {
    final /* synthetic */ PermissionWarningDialog ibU;
    final /* synthetic */ boolean ibV;
    final /* synthetic */ boolean ibW;

    PermissionWarningDialog$3(PermissionWarningDialog permissionWarningDialog, boolean z, boolean z2) {
        this.ibU = permissionWarningDialog;
        this.ibW = z;
        this.ibV = z2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.j(this.ibW, this.ibV);
        this.ibU.finish();
    }
}
