package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.x;

class FacingCreateChatRoomAllInOneUI$16 implements a {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

    FacingCreateChatRoomAllInOneUI$16(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.pmn = facingCreateChatRoomAllInOneUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
        if (z) {
            Location location = new Location(f2, f, (int) d2, i, "", "");
            if (!location.bYW()) {
                FacingCreateChatRoomAllInOneUI.a(this.pmn, location);
                FacingCreateChatRoomAllInOneUI.b(this.pmn, true);
                FacingCreateChatRoomAllInOneUI.e(this.pmn);
            }
        } else {
            FacingCreateChatRoomAllInOneUI.b(this.pmn, false);
        }
        return false;
    }
}
