package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.l.a;

class NormalUserFooterPreference$f extends NormalUserFooterPreference$a {
    final /* synthetic */ NormalUserFooterPreference pkA;

    public NormalUserFooterPreference$f(NormalUserFooterPreference normalUserFooterPreference) {
        this.pkA = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void bjF() {
        if (NormalUserFooterPreference.a(this.pkA) == null || !a.fZ(NormalUserFooterPreference.a(this.pkA).field_type)) {
            v(false, true);
        } else {
            bjE();
        }
    }

    protected final void bjD() {
        NormalUserFooterPreference.q(this.pkA).setVisibility(8);
        NormalUserFooterPreference.r(this.pkA).setVisibility(0);
        NormalUserFooterPreference.s(this.pkA).setVisibility(8);
        NormalUserFooterPreference.f(this.pkA).setVisibility(8);
        NormalUserFooterPreference.g(this.pkA).setVisibility(8);
        NormalUserFooterPreference.h(this.pkA).setVisibility(8);
        NormalUserFooterPreference.k(this.pkA).setVisibility(8);
        NormalUserFooterPreference.p(this.pkA).setVisibility(8);
        NormalUserFooterPreference.z(this.pkA).setOnClickListener(new 1(this));
    }
}
