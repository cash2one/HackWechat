package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.14;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.rtmp.TXLiveConstants;

class NearbyFriendsUI$14$1 implements d {
    final /* synthetic */ 14 oOU;

    NearbyFriendsUI$14$1(14 14) {
        this.oOU = 14;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (i) {
            case 0:
                NearbyFriendsUI.a(this.oOU.oOS, 4);
                NearbyFriendsUI.t(this.oOU.oOS);
                ar.Hg();
                c.CU().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.oOU.oOS)));
                NearbyFriendsUI.u(this.oOU.oOS);
                return;
            case 1:
                NearbyFriendsUI.a(this.oOU.oOS, 3);
                NearbyFriendsUI.t(this.oOU.oOS);
                ar.Hg();
                c.CU().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.oOU.oOS)));
                NearbyFriendsUI.u(this.oOU.oOS);
                return;
            case 2:
                NearbyFriendsUI.a(this.oOU.oOS, 1);
                NearbyFriendsUI.t(this.oOU.oOS);
                ar.Hg();
                c.CU().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.oOU.oOS)));
                NearbyFriendsUI.u(this.oOU.oOS);
                return;
            case 3:
                Intent intent = new Intent(this.oOU.oOS, NearbySayHiListUI.class);
                intent.putExtra("k_say_hi_type", 2);
                this.oOU.oOS.startActivityForResult(intent, TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION);
                return;
            case 4:
                NearbyFriendsUI.b(this.oOU.oOS, new com.tencent.mm.plugin.nearby.a.c(2, 0.0f, 0.0f, 0, 0, "", ""));
                ar.CG().a(NearbyFriendsUI.v(this.oOU.oOS), 0);
                NearbyFriendsUI nearbyFriendsUI = this.oOU.oOS;
                Context context = this.oOU.oOS.mController.xIM;
                this.oOU.oOS.getString(R.l.dGO);
                NearbyFriendsUI.a(nearbyFriendsUI, h.a(context, this.oOU.oOS.getString(R.l.exc), true, new 1(this)));
                return;
            default:
                return;
        }
    }
}
