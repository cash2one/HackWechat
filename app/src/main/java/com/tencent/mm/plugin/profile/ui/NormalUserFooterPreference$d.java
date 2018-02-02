package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.z.s;
import junit.framework.Assert;

class NormalUserFooterPreference$d extends a {
    final /* synthetic */ NormalUserFooterPreference pkA;

    public NormalUserFooterPreference$d(NormalUserFooterPreference normalUserFooterPreference) {
        this.pkA = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void bjF() {
    }

    protected final void bjD() {
        Assert.assertTrue(s.gR(NormalUserFooterPreference.a(this.pkA).field_username));
        NormalUserFooterPreference.q(this.pkA).setVisibility(8);
        NormalUserFooterPreference.r(this.pkA).setVisibility(8);
        NormalUserFooterPreference.s(this.pkA).setVisibility(8);
        NormalUserFooterPreference.f(this.pkA).setVisibility(0);
        NormalUserFooterPreference.g(this.pkA).setVisibility(8);
        NormalUserFooterPreference.h(this.pkA).setVisibility(8);
        NormalUserFooterPreference.k(this.pkA).setVisibility(8);
        NormalUserFooterPreference.p(this.pkA).setVisibility(8);
    }
}
