package com.tencent.mm.plugin.nearby.ui;

import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.z.ar;

class NearbyFriendsUI$8 implements a$a {
    final /* synthetic */ NearbyFriendsUI oOS;

    NearbyFriendsUI$8(NearbyFriendsUI nearbyFriendsUI) {
        this.oOS = nearbyFriendsUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (NearbyFriendsUI.d(this.oOS)) {
            return false;
        }
        NearbyFriendsUI.e(this.oOS);
        if (this.oOS.hnr) {
            if (NearbyFriendsUI.f(this.oOS) != null) {
                NearbyFriendsUI.f(this.oOS).dismiss();
                NearbyFriendsUI.a(this.oOS, null);
            }
            f.vB(11);
            return false;
        }
        if (z) {
            if (NearbyFriendsUI.f(this.oOS) != null) {
                NearbyFriendsUI.f(this.oOS).setMessage(this.oOS.getString(R.l.exe));
            }
            NearbyFriendsUI.a(this.oOS, new NearbyFriendsUI$a(this.oOS, f2, f, (int) d2));
            e.SS().a(2001, i != 0, NearbyFriendsUI.g(this.oOS) == null ? false : NearbyFriendsUI.g(this.oOS).hxP, f, f2, (int) d2);
            NearbyFriendsUI.a(this.oOS, new c(NearbyFriendsUI.h(this.oOS), NearbyFriendsUI.i(this.oOS).hxG, NearbyFriendsUI.i(this.oOS).hxF, NearbyFriendsUI.i(this.oOS).accuracy, i, "", ""));
            ar.CG().a(NearbyFriendsUI.b(this.oOS), 0);
        } else {
            f.vB(11);
            if (NearbyFriendsUI.f(this.oOS) != null) {
                NearbyFriendsUI.f(this.oOS).dismiss();
                NearbyFriendsUI.a(this.oOS, null);
            }
            NearbyFriendsUI.j(this.oOS);
            this.oOS.findViewById(R.h.cyV).setVisibility(0);
            NearbyFriendsUI.k(this.oOS).setVisibility(8);
            NearbyFriendsUI.l(this.oOS);
        }
        return false;
    }
}
