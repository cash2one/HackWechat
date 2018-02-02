package com.tencent.mm.plugin.profile.ui;

import android.text.TextUtils;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import junit.framework.Assert;

class NormalUserFooterPreference$c extends a {
    final /* synthetic */ NormalUserFooterPreference pkA;

    static /* synthetic */ void a(NormalUserFooterPreference$c normalUserFooterPreference$c) {
        int i = 0;
        if (((int) NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).gJd) == 0) {
            ar.Hg();
            c.EY().S(NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA));
            ar.Hg();
            c.EY().WO(NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).field_username);
        }
        if (((int) NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).gJd) <= 0) {
            x.e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
            return;
        }
        if (!com.tencent.mm.l.a.fZ(NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).field_type) && NormalUserFooterPreference.l(normalUserFooterPreference$c.pkA) == 15) {
            b kR = af.OD().kR(NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).field_username);
            if (kR != null) {
                g gVar = g.pQN;
                Object[] objArr = new Object[4];
                objArr[0] = NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).field_username;
                objArr[1] = Integer.valueOf(3);
                if (!bh.ov(kR.Nr())) {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).fWE.toString().split(",").length >= 5 ? 5 : NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).fWE.toString().split(",").length);
                gVar.h(12040, objArr);
            }
        }
        s.p(NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA));
        NormalUserFooterPreference normalUserFooterPreference = normalUserFooterPreference$c.pkA;
        ar.Hg();
        NormalUserFooterPreference.a(normalUserFooterPreference, c.EY().WO(NormalUserFooterPreference.a(normalUserFooterPreference$c.pkA).field_username));
        normalUserFooterPreference$c.bjD();
    }

    public NormalUserFooterPreference$c(NormalUserFooterPreference normalUserFooterPreference) {
        this.pkA = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void EI() {
        super.EI();
    }

    protected void onDetach() {
        super.onDetach();
    }

    protected void bjD() {
        Assert.assertTrue(!s.hn(NormalUserFooterPreference.a(this.pkA).field_username));
        NormalUserFooterPreference.q(this.pkA).setVisibility(8);
        NormalUserFooterPreference.r(this.pkA).setVisibility(8);
        if (NormalUserFooterPreference.d(this.pkA)) {
            NormalUserFooterPreference.C(this.pkA).setOnClickListener(new 1(this));
            if (com.tencent.mm.l.a.fZ(NormalUserFooterPreference.a(this.pkA).field_type)) {
                NormalUserFooterPreference.C(this.pkA).setVisibility(0);
            } else {
                NormalUserFooterPreference.C(this.pkA).setVisibility(8);
            }
            NormalUserFooterPreference.s(this.pkA).setVisibility(8);
            NormalUserFooterPreference.f(this.pkA).setVisibility(8);
            NormalUserFooterPreference.g(this.pkA).setVisibility(8);
            NormalUserFooterPreference.h(this.pkA).setVisibility(8);
            NormalUserFooterPreference.p(this.pkA).setVisibility(8);
            return;
        }
        NormalUserFooterPreference.s(this.pkA).setOnClickListener(new 2(this));
        if (com.tencent.mm.l.a.fZ(NormalUserFooterPreference.a(this.pkA).field_type)) {
            NormalUserFooterPreference.s(this.pkA).setVisibility(8);
            NormalUserFooterPreference.f(this.pkA).setVisibility(0);
            if (this.pkA.bjA() || NormalUserFooterPreference.a(this.pkA).field_username.equals(q.FS()) || s.hn(NormalUserFooterPreference.a(this.pkA).field_username) || s.hg(NormalUserFooterPreference.a(this.pkA).field_username)) {
                NormalUserFooterPreference.h(this.pkA).setVisibility(8);
            } else {
                NormalUserFooterPreference.h(this.pkA).setVisibility(0);
            }
            ar.Hg();
            if (c.EY().WR(NormalUserFooterPreference.a(this.pkA).field_username)) {
                NormalUserFooterPreference.k(this.pkA).setVisibility(0);
                NormalUserFooterPreference.a(this.pkA, NormalUserFooterPreference.a(this.pkA).getSource());
            }
        } else {
            NormalUserFooterPreference.s(this.pkA).setVisibility(0);
            NormalUserFooterPreference.f(this.pkA).setVisibility(8);
            NormalUserFooterPreference.g(this.pkA).setVisibility(8);
            NormalUserFooterPreference.h(this.pkA).setVisibility(8);
        }
        if (NormalUserFooterPreference.a(this.pkA).AF()) {
            NormalUserFooterPreference.p(this.pkA).setVisibility(0);
        } else {
            NormalUserFooterPreference.p(this.pkA).setVisibility(8);
        }
    }

    protected final void bjI() {
        if (((int) NormalUserFooterPreference.a(this.pkA).gJd) == 0) {
            ar.Hg();
            if (c.EY().S(NormalUserFooterPreference.a(this.pkA)) != -1) {
                NormalUserFooterPreference normalUserFooterPreference = this.pkA;
                ar.Hg();
                NormalUserFooterPreference.a(normalUserFooterPreference, c.EY().WO(NormalUserFooterPreference.a(this.pkA).field_username));
            }
        }
        if (NormalUserFooterPreference.E(this.pkA) || NormalUserFooterPreference.l(this.pkA) == 12) {
            x.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.F(this.pkA) + " qqReamrk " + NormalUserFooterPreference.G(this.pkA));
            if (!(NormalUserFooterPreference.F(this.pkA) == 0 || NormalUserFooterPreference.G(this.pkA) == null || NormalUserFooterPreference.G(this.pkA).equals(""))) {
                ad be = af.OI().be(NormalUserFooterPreference.F(this.pkA));
                if (be == null) {
                    be = new ad();
                    be.fpL = "";
                    be.hwR = NormalUserFooterPreference.F(this.pkA);
                    be.hwZ = NormalUserFooterPreference.G(this.pkA);
                    be.username = NormalUserFooterPreference.a(this.pkA).field_username;
                    be.OB();
                    af.OI().a(be);
                } else {
                    be.hwR = NormalUserFooterPreference.F(this.pkA);
                    be.hwZ = NormalUserFooterPreference.G(this.pkA);
                    be.username = NormalUserFooterPreference.a(this.pkA).field_username;
                    be.OB();
                    af.OI().a(NormalUserFooterPreference.F(this.pkA), be);
                }
            }
        } else if (NormalUserFooterPreference.l(this.pkA) == 58 || NormalUserFooterPreference.l(this.pkA) == 59 || NormalUserFooterPreference.l(this.pkA) == 60) {
            af.OL().N(NormalUserFooterPreference.a(this.pkA).field_username, 1);
        }
        String stringExtra = NormalUserFooterPreference.b(this.pkA).getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = NormalUserFooterPreference.b(this.pkA).getIntent().getStringExtra("Contact_full_Mobile_MD5");
        String ou = bh.ou(stringExtra);
        stringExtra2 = bh.ou(stringExtra2);
        if (!(ou.equals("") && stringExtra2.equals(""))) {
            b kS = af.OD().kS(ou);
            if (kS == null) {
                kS = af.OD().kS(stringExtra2);
            } else {
                stringExtra2 = ou;
            }
            if (kS != null) {
                af.OD().a(stringExtra2, kS);
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.pkA.mContext, new 3(this));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(NormalUserFooterPreference.l(this.pkA)));
        stringExtra = NormalUserFooterPreference.b(this.pkA).getIntent().getStringExtra("source_from_user_name");
        String stringExtra3 = NormalUserFooterPreference.b(this.pkA).getIntent().getStringExtra("source_from_nick_name");
        aVar.vmS = stringExtra;
        aVar.vmT = stringExtra3;
        aVar.vmO = new 4(this, stringExtra, stringExtra3);
        stringExtra3 = NormalUserFooterPreference.b(this.pkA).getIntent().getStringExtra("room_name");
        Object stringExtra4 = NormalUserFooterPreference.b(this.pkA).getIntent().getStringExtra(e.a.xEi);
        if (!TextUtils.isEmpty(stringExtra4)) {
            aVar.Sk(stringExtra4);
            aVar.b(NormalUserFooterPreference.a(this.pkA).field_username, "", linkedList);
        } else if (TextUtils.isEmpty(stringExtra3)) {
            aVar.c(NormalUserFooterPreference.a(this.pkA).field_username, linkedList);
        } else if (TextUtils.isEmpty(aVar.mOi)) {
            ar.Hg();
            com.tencent.mm.g.b.af WO = c.EY().WO(NormalUserFooterPreference.a(this.pkA).field_username);
            stringExtra4 = WO != null ? bh.az(WO.fWF, "") : "";
            x.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[]{NormalUserFooterPreference.a(this.pkA).field_username, stringExtra3, stringExtra4});
            if (TextUtils.isEmpty(stringExtra4)) {
                ak.a.hfL.a(NormalUserFooterPreference.a(this.pkA).field_username, stringExtra3, new 5(this, aVar, stringExtra3, linkedList));
                return;
            }
            aVar.Sk(stringExtra4);
            aVar.b(NormalUserFooterPreference.a(this.pkA).field_username, stringExtra3, linkedList);
        } else {
            aVar.b(NormalUserFooterPreference.a(this.pkA).field_username, stringExtra3, linkedList);
        }
    }
}
