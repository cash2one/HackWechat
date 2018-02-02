package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import junit.framework.Assert;

class NormalUserFooterPreference$g extends NormalUserFooterPreference$a {
    final /* synthetic */ NormalUserFooterPreference pkA;

    public NormalUserFooterPreference$g(NormalUserFooterPreference normalUserFooterPreference) {
        this.pkA = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    public final void bjF() {
    }

    protected final void bjD() {
        boolean z = true;
        Assert.assertTrue(!q.gr(NormalUserFooterPreference.a(this.pkA).field_username));
        if (s.hn(NormalUserFooterPreference.a(this.pkA).field_username)) {
            z = false;
        }
        Assert.assertTrue(z);
        NormalUserFooterPreference.q(this.pkA).setVisibility(8);
        NormalUserFooterPreference.r(this.pkA).setVisibility(8);
        NormalUserFooterPreference.f(this.pkA).setText(R.l.dWr);
        NormalUserFooterPreference.f(this.pkA).setVisibility(0);
        NormalUserFooterPreference.h(this.pkA).setVisibility(8);
        NormalUserFooterPreference.s(this.pkA).setVisibility(8);
        NormalUserFooterPreference.p(this.pkA).setVisibility(8);
    }
}
