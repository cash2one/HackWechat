package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.z.ar;

class FacebookFriendUI$10 implements OnCancelListener {
    final /* synthetic */ v ils;
    final /* synthetic */ ak ilt;
    final /* synthetic */ FacebookFriendUI xNZ;

    FacebookFriendUI$10(FacebookFriendUI facebookFriendUI, ak akVar, v vVar) {
        this.xNZ = facebookFriendUI;
        this.ilt = akVar;
        this.ils = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.ilt.TG();
        ar.CG().c(this.ils);
    }
}
