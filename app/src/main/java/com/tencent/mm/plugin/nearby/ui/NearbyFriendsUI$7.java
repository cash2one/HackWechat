package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class NearbyFriendsUI$7 implements OnCancelListener {
    final /* synthetic */ NearbyFriendsUI oOS;

    NearbyFriendsUI$7(NearbyFriendsUI nearbyFriendsUI) {
        this.oOS = nearbyFriendsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.oOS.hnr = true;
        f.vB(11);
        if (NearbyFriendsUI.b(this.oOS) != null) {
            ar.CG().c(NearbyFriendsUI.b(this.oOS));
        }
        x.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
        if (!NearbyFriendsUI.c(this.oOS)) {
            this.oOS.finish();
            x.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
        }
    }
}
