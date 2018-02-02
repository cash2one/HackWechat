package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

public final class a {
    private String fIG;
    private String hNv = "";
    private String username = "";
    boolean xPI = false;
    private String xTJ = "";
    private a xTK;

    public a(a aVar, String str, String str2, String str3) {
        this.username = str;
        this.hNv = str3;
        this.xTJ = str2;
        this.xTK = aVar;
    }

    public final void j(MMActivity mMActivity) {
        k vVar = new v(this.username, this.xTJ, 0, "", "", "", 0, "", false, true);
        ar.CG().a(vVar, 0);
        a aVar = this.xTK;
        mMActivity.getString(R.l.dGO);
        aVar.b(h.a(mMActivity, mMActivity.getString(R.l.etF), true, new 1(this, vVar)));
    }

    public final void a(MMActivity mMActivity, int i, int i2, String str, k kVar) {
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            ar.CG().a(new bd(new 2(this)), 0);
            int i3 = 1;
        } else {
            boolean z = false;
        }
        if (kVar instanceof v) {
            this.fIG = ((v) kVar).RY();
        }
        if (i3 != 0 || (i == 0 && i2 == 0)) {
            ar.unhold();
            d.bq(mMActivity);
            m.or(this.hNv);
            m.a(mMActivity, new 3(this, mMActivity), false, 2);
            if (this.xPI) {
                String string = ac.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                g.pQN.h(11930, new Object[]{string, Integer.valueOf(4)});
            }
        } else if (i2 == -106) {
            m.b(mMActivity, str, 0);
        } else if (i2 == -217) {
            m.a(mMActivity, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
        } else {
            int i4;
            if (com.tencent.mm.plugin.c.a.ift.a((Context) mMActivity, i, i2, str)) {
                i4 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -140:
                            if (!bh.ov(this.fIG)) {
                                m.j(mMActivity, str, this.fIG);
                            }
                            i4 = 1;
                            break;
                        case -100:
                            ar.hold();
                            h.a(mMActivity, TextUtils.isEmpty(ar.Ci()) ? com.tencent.mm.bv.a.ac(mMActivity, R.l.euu) : ar.Ci(), mMActivity.getString(R.l.dGO), new 4(this), new 5(this));
                            i4 = 1;
                            break;
                        case -75:
                            h.h(mMActivity, R.l.dDF, R.l.dGO);
                            i4 = 1;
                            break;
                        case -72:
                            h.h(mMActivity, R.l.eEb, R.l.dGO);
                            i4 = 1;
                            break;
                        case -9:
                            h.h(mMActivity, R.l.etv, R.l.etw);
                            i4 = 1;
                            break;
                        case -1:
                            if (ar.CG().Km() == 5) {
                                h.h(mMActivity, R.l.exG, R.l.exF);
                                i4 = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            h.h(mMActivity, R.l.ecj, R.l.etw);
                            i4 = 1;
                            break;
                    }
                }
                boolean z2 = false;
            }
            if (i4 == 0) {
                Toast.makeText(mMActivity, mMActivity.getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
