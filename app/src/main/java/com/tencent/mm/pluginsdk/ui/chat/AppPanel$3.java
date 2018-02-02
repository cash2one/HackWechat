package com.tencent.mm.pluginsdk.ui.chat;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.chat.AppGrid.b;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AppPanel$3 implements b {
    final /* synthetic */ AppPanel vpq;

    AppPanel$3(AppPanel appPanel) {
        this.vpq = appPanel;
    }

    public final int Ce(int i) {
        int i2 = 0;
        if (i < AppPanel.f(this.vpq)) {
            int length = AppPanel.g(this.vpq).length;
            int i3 = 0;
            while (i2 < length) {
                if (AppPanel.g(this.vpq)[i2]) {
                    if (i3 == i) {
                        return i2;
                    }
                    i3++;
                }
                i2++;
            }
        } else if (i >= AppPanel.f(this.vpq) && i < AppPanel.h(this.vpq)) {
            return Integer.MIN_VALUE;
        }
        return Integer.MAX_VALUE;
    }

    public final void Cf(int i) {
        if (i != 0) {
            return;
        }
        if (this.vpq.voY.vpu.value) {
            AppPanel.a(this.vpq, true);
        } else {
            Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
        }
    }

    public final void a(int i, f fVar) {
        int i2 = 0;
        String str = "MicroMsg.AppPanel";
        String str2 = "pos=%d, has appInfo = %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(fVar != null);
        x.d(str, str2, objArr);
        if (fVar != null && g.j(fVar)) {
            Map hashMap = new HashMap();
            q.b(327682, hashMap);
            hashMap.put(fVar.field_appId, "1");
            q.a(327682, hashMap);
        }
        com.tencent.mm.sdk.b.b riVar;
        String str3;
        f fVar2;
        int intValue;
        List F;
        switch (i) {
            case Integer.MIN_VALUE:
                if (!this.vpq.voY.vpB.value) {
                    Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                    return;
                } else if (fVar == null) {
                    x.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
                    return;
                } else {
                    if (fVar.bYD() || fVar.bYF()) {
                        if (AppPanel.m(this.vpq) == null) {
                            AppPanel.a(this.vpq, AppPanel.i(this.vpq).getSharedPreferences(ac.cfs(), 0));
                        }
                        if (AppPanel.m(this.vpq).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                            AppPanel.m(this.vpq).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, false).commit();
                        }
                        if (fVar.bYF()) {
                            com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(16), fVar.field_appId, Integer.valueOf(0)});
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(13), fVar.field_appId, Integer.valueOf(0)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(11), fVar.field_appId});
                    }
                    AppPanel.k(this.vpq).b(fVar);
                    return;
                }
            case 0:
                if (this.vpq.voY.vpu.value) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(1)});
                    AppPanel.a(this.vpq, false);
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(14)});
                a k = AppPanel.k(this.vpq);
                if (!this.vpq.voY.vpK.value) {
                    i2 = 2;
                }
                k.sr(i2);
                return;
            case 2:
                if (this.vpq.voY.vpx.value) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(8)});
                    ar.Hg();
                    c.CU().set(54, Boolean.valueOf(false));
                    if (AppPanel.k(this.vpq) != null) {
                        riVar = new ri();
                        riVar.fJc.fJe = true;
                        com.tencent.mm.sdk.b.a.xef.m(riVar);
                        str3 = riVar.fJd.fJg;
                        if (bh.ov(str3)) {
                            AppPanel.k(this.vpq).aYN();
                            return;
                        }
                        x.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                        h.a(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.eQx), "", AppPanel.i(this.vpq).getString(R.l.dFU), AppPanel.i(this.vpq).getString(R.l.dEn), new 1(this), new 2(this));
                        return;
                    }
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 3:
                if (AppPanel.k(this.vpq) != null) {
                    AppPanel.k(this.vpq).aYX();
                    return;
                }
                return;
            case 4:
                if (this.vpq.voY.vpD.value) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(7)});
                    ar.Hg();
                    c.CU().set(62, Boolean.valueOf(false));
                    riVar = new ri();
                    riVar.fJc.fJe = true;
                    com.tencent.mm.sdk.b.a.xef.m(riVar);
                    str3 = riVar.fJd.fJg;
                    if (bh.ov(str3)) {
                        AppPanel.k(this.vpq).aYO();
                        return;
                    }
                    x.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                    h.a(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.eQx), "", AppPanel.i(this.vpq).getString(R.l.dFU), AppPanel.i(this.vpq).getString(R.l.dEn), new 3(this), new 4(this));
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 5:
                if (AppPanel.k(this.vpq) != null) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(6)});
                    ar.Hg();
                    c.CU().set(67, Boolean.valueOf(false));
                    AppPanel.k(this.vpq).aYP();
                    return;
                }
                return;
            case 6:
                if (this.vpq.voY.vpH.value && this.vpq.voY.vpI.value) {
                    ar.Hg();
                    if (((Boolean) c.CU().get(290817, Boolean.valueOf(true))).booleanValue()) {
                        ar.Hg();
                        c.CU().set(290817, Boolean.valueOf(false));
                        this.vpq.refresh();
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(3)});
                    AppPanel.k(this.vpq).aYQ();
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 7:
                if (this.vpq.voY.vpL.value) {
                    if (fVar == null) {
                        fVar2 = (f) AppPanel.l(this.vpq).get(f.veh);
                        if (fVar2 == null) {
                            return;
                        }
                    }
                    fVar2 = fVar;
                    if (fVar2.bYD() || fVar2.bYF()) {
                        if (AppPanel.m(this.vpq) == null) {
                            AppPanel.a(this.vpq, AppPanel.i(this.vpq).getSharedPreferences(ac.cfs(), 0));
                        }
                        if (AppPanel.m(this.vpq).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                            AppPanel.m(this.vpq).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(13), fVar2.field_appId, Integer.valueOf(0)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(11), fVar2.field_appId});
                    }
                    ar.Hg();
                    intValue = ((Integer) c.CU().get(w.a.xrD, Integer.valueOf(0))).intValue();
                    ar.Hg();
                    F = bh.F(((String) c.CU().get(w.a.xtz, "")).split(";"));
                    if (!F.contains(String.valueOf(intValue))) {
                        F.add(String.valueOf(intValue));
                        ar.Hg();
                        c.CU().a(w.a.xtz, bh.d(F, ";"));
                        this.vpq.refresh();
                    }
                    AppPanel.k(this.vpq).aYW();
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 8:
                if (fVar == null) {
                    fVar = (f) AppPanel.l(this.vpq).get(f.vef);
                }
                ar.Hg();
                intValue = ((Integer) c.CU().get(w.a.xrD, Integer.valueOf(0))).intValue();
                ar.Hg();
                F = bh.F(((String) c.CU().get(w.a.xty, "")).split(";"));
                if (!F.contains(String.valueOf(intValue))) {
                    F.add(String.valueOf(intValue));
                    ar.Hg();
                    c.CU().a(w.a.xty, bh.d(F, ";"));
                    this.vpq.refresh();
                }
                ar.Hg();
                c.CU().set(80, Boolean.valueOf(false));
                AppPanel.k(this.vpq).b(fVar);
                return;
            case 9:
                if (AppPanel.k(this.vpq) != null) {
                    if (fVar == null) {
                        fVar2 = (f) AppPanel.l(this.vpq).get(f.vei);
                        if (fVar2 == null) {
                            x.i("MicroMsg.AppPanel", "empty info");
                            return;
                        }
                    }
                    fVar2 = fVar;
                    if (fVar2.bYD() || fVar2.bYF()) {
                        if (AppPanel.m(this.vpq) == null) {
                            AppPanel.a(this.vpq, AppPanel.i(this.vpq).getSharedPreferences(ac.cfs(), 0));
                        }
                        if (AppPanel.m(this.vpq).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                            AppPanel.m(this.vpq).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                        }
                    }
                    AppPanel.k(this.vpq).aYZ();
                    return;
                }
                return;
            case 10:
                com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(9)});
                ar.Hg();
                c.CU().set(73, Boolean.valueOf(false));
                AppPanel.n(this.vpq).cbl();
                return;
            case 11:
                if (this.vpq.voY.vpv.value) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(4)});
                    AppPanel.k(this.vpq).aYR();
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 12:
                if (this.vpq.voY.vpw.value) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(5)});
                    if (AppPanel.k(this.vpq) != null) {
                        AppPanel.k(this.vpq).aYT();
                        return;
                    }
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 13:
                if (this.vpq.voY.vpJ.value) {
                    if (AppPanel.k(this.vpq) != null) {
                        AppPanel.k(this.vpq).aYV();
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(15)});
                    ar.Hg();
                    boolean booleanValue = ((Boolean) c.CU().get(208899, Boolean.valueOf(false))).booleanValue();
                    ar.Hg();
                    boolean booleanValue2 = ((Boolean) c.CU().get(208913, Boolean.valueOf(false))).booleanValue();
                    if (booleanValue) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(11594, new Object[]{Integer.valueOf(3)});
                        return;
                    } else if (booleanValue2) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(11594, new Object[]{Integer.valueOf(4)});
                        return;
                    } else {
                        return;
                    }
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 14:
                if (this.vpq.voY.vpz.value) {
                    ar.Hg();
                    if (((Boolean) c.CU().get(327744, Boolean.valueOf(true))).booleanValue()) {
                        ar.Hg();
                        c.CU().set(327744, Boolean.valueOf(false));
                        this.vpq.refresh();
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(12)});
                    AppPanel.k(this.vpq).aYU();
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case 15:
                if (this.vpq.voY.vpN.value) {
                    AppPanel.k(this.vpq).aYY();
                    return;
                } else {
                    Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                    return;
                }
            case 16:
                if (this.vpq.voY.vpP.value) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(17)});
                    if (AppPanel.k(this.vpq) != null) {
                        AppPanel.k(this.vpq).aZa();
                        return;
                    }
                    return;
                }
                Toast.makeText(AppPanel.i(this.vpq), AppPanel.i(this.vpq).getString(R.l.dSi), 0).show();
                return;
            case Integer.MAX_VALUE:
                if (AppPanel.j(this.vpq) == null) {
                    x.e("MicroMsg.AppPanel", "infoList == null");
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pQN.k(10305, String.valueOf(AppPanel.j(this.vpq).size()));
                com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(10)});
                com.tencent.mm.kernel.g.Dj().CU().set(69121, "");
                AppPanel.k(this.vpq).aYS();
                return;
            default:
                return;
        }
    }
}
