package com.tencent.mm.permission;

import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.j.a;

class PermissionWarningDialog$4 implements a {
    final /* synthetic */ PermissionWarningDialog ibU;

    PermissionWarningDialog$4(PermissionWarningDialog permissionWarningDialog) {
        this.ibU = permissionWarningDialog;
    }

    public final void ch(boolean z) {
        if (z) {
            x.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
            ((AudioManager) ac.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMicrophoneMute(false);
        }
        this.ibU.finish();
    }
}
