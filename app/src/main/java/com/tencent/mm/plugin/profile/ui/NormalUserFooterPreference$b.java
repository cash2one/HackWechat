package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.l.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class NormalUserFooterPreference$b extends c {
    final /* synthetic */ NormalUserFooterPreference pkA;

    public NormalUserFooterPreference$b(NormalUserFooterPreference normalUserFooterPreference) {
        this.pkA = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void bjF() {
        if (NormalUserFooterPreference.a(this.pkA) == null) {
            x.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        } else if (a.fZ(NormalUserFooterPreference.a(this.pkA).field_type) && (!a.fZ(NormalUserFooterPreference.a(this.pkA).field_type) || !com.tencent.mm.storage.x.gy(NormalUserFooterPreference.a(this.pkA).field_username))) {
            bjE();
        } else if (com.tencent.mm.storage.x.gy(NormalUserFooterPreference.a(this.pkA).field_username)) {
            v(true, true);
        } else {
            v(false, true);
        }
    }

    protected final void bjD() {
        NormalUserFooterPreference.q(this.pkA).setVisibility(8);
        if (!a.fZ(NormalUserFooterPreference.a(this.pkA).field_type) || (a.fZ(NormalUserFooterPreference.a(this.pkA).field_type) && com.tencent.mm.storage.x.gy(NormalUserFooterPreference.a(this.pkA).field_username))) {
            NormalUserFooterPreference.r(this.pkA).setVisibility(0);
            NormalUserFooterPreference.f(this.pkA).setVisibility(8);
            NormalUserFooterPreference.g(this.pkA).setVisibility(8);
        } else {
            NormalUserFooterPreference.r(this.pkA).setVisibility(8);
            NormalUserFooterPreference.f(this.pkA).setVisibility(0);
            if (!(this.pkA.bjA() || NormalUserFooterPreference.a(this.pkA).field_username.equals(q.FS()))) {
                NormalUserFooterPreference.h(this.pkA).setVisibility(0);
                NormalUserFooterPreference.s(this.pkA).setVisibility(8);
                NormalUserFooterPreference.k(this.pkA).setVisibility(8);
                NormalUserFooterPreference.p(this.pkA).setVisibility(8);
                if (NormalUserFooterPreference.A(this.pkA)) {
                    NormalUserFooterPreference.r(this.pkA).setVisibility(8);
                    NormalUserFooterPreference.s(this.pkA).setVisibility(0);
                    NormalUserFooterPreference.s(this.pkA).setOnClickListener(new 1(this));
                }
                NormalUserFooterPreference.z(this.pkA).setOnClickListener(new 2(this));
            }
        }
        NormalUserFooterPreference.h(this.pkA).setVisibility(8);
        NormalUserFooterPreference.s(this.pkA).setVisibility(8);
        NormalUserFooterPreference.k(this.pkA).setVisibility(8);
        NormalUserFooterPreference.p(this.pkA).setVisibility(8);
        if (NormalUserFooterPreference.A(this.pkA)) {
            NormalUserFooterPreference.r(this.pkA).setVisibility(8);
            NormalUserFooterPreference.s(this.pkA).setVisibility(0);
            NormalUserFooterPreference.s(this.pkA).setOnClickListener(new 1(this));
        }
        NormalUserFooterPreference.z(this.pkA).setOnClickListener(new 2(this));
    }
}
