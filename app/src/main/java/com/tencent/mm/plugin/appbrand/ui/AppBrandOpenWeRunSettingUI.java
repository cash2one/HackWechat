package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.s;

public class AppBrandOpenWeRunSettingUI extends MMActivity implements e {
    private ImageView ihQ;
    private TextView ihS;
    private TextView ihV;
    private TextView jLc;
    private TextView jLd;
    private x jLe = null;
    r jLf;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(j.iAk));
        this.ihQ = (ImageView) findViewById(g.iwa);
        this.jLc = (TextView) findViewById(g.iwb);
        this.ihV = (TextView) findViewById(g.iwd);
        this.ihS = (TextView) findViewById(g.iwe);
        this.jLd = (TextView) findViewById(g.iwc);
        this.jLd.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
        String ou = bh.ou(getIntent().getStringExtra("OpenWeRunSettingName"));
        this.jLe = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO("gh_43f2581f6fd6");
        if (this.jLe == null || ((int) this.jLe.gJd) == 0) {
            getString(j.dGO);
            this.jLf = com.tencent.mm.ui.base.h.a((Context) this, getString(j.dHc), true, null);
            this.jLf.show();
            a.hfL.a("gh_43f2581f6fd6", "", new 3(this));
        }
        this.ihS.setText(getString(j.iAl, new Object[]{ou}));
        akJ();
    }

    protected final int getLayoutId() {
        return q.h.ixc;
    }

    private void akJ() {
        b.a(this.ihQ, this.jLe.field_username);
        this.jLc.setText(this.jLe.AQ());
        if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            this.ihV.setTextColor(com.tencent.mm.ui.tools.r.gb(this.mController.xIM));
            this.ihV.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).bN(this));
            this.ihV.setCompoundDrawablesWithIntrinsicBounds(f.bGx, 0, 0, 0);
            this.jLd.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).bN(this));
            this.jLd.setClickable(false);
            return;
        }
        this.ihV.setTextColor(com.tencent.mm.ui.tools.r.gc(this.mController.xIM));
        this.ihV.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).bO(this));
        this.ihV.setCompoundDrawablesWithIntrinsicBounds(f.bGw, 0, 0, 0);
        this.jLd.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).bM(this));
        this.jLd.setClickable(true);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            com.tencent.mm.kernel.g.Di().gPJ.b(30, this);
            if (i == 0 && i2 == 0) {
                String bYs = ((o) kVar).bYs();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[]{bYs});
                this.jLe = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO("gh_43f2581f6fd6");
                af afVar = this.jLe;
                if (afVar == null || bh.ov(bYs)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + bYs + ", contact = " + afVar);
                } else {
                    d dVar;
                    if (s.gD(afVar.field_username)) {
                        String ou = bh.ou(afVar.field_username);
                        d jS = com.tencent.mm.ag.f.jS(ou);
                        if (jS != null) {
                            jS.field_username = bYs;
                        }
                        y.Mf().jL(ou);
                        afVar.di(ou);
                        dVar = jS;
                    } else {
                        dVar = null;
                    }
                    afVar.setUsername(bYs);
                    if (((int) afVar.gJd) == 0) {
                        ((h) com.tencent.mm.kernel.g.h(h.class)).EY().S(afVar);
                    }
                    if (((int) afVar.gJd) <= 0) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
                    } else {
                        s.p(afVar);
                        af WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(afVar.field_username);
                        if (dVar != null) {
                            y.Mf().d(dVar);
                        } else {
                            dVar = com.tencent.mm.ag.f.jS(WO.field_username);
                            if (dVar == null || dVar.KY()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
                                a.hfL.Q(WO.field_username, "");
                                com.tencent.mm.ad.b.iX(WO.field_username);
                            } else if (WO.cid()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[]{Integer.valueOf(WO.fWw)});
                                a.hfL.Q(WO.field_username, "");
                                com.tencent.mm.ad.b.iX(WO.field_username);
                            }
                        }
                    }
                }
                y.Mf().e(y.Mf().jK(this.jLe.field_username));
                com.tencent.mm.kernel.g.Dj().CU().set(327825, Boolean.valueOf(true));
                setResult(-1);
                ag.h(new 4(this), 1500);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 4 && i2 == -24 && !bh.ov(str)) {
                    Toast.makeText(ac.getContext(), str, 1).show();
                }
                setResult(1);
            }
            if (this.jLf != null) {
                this.jLf.dismiss();
            }
            akJ();
        }
    }
}
