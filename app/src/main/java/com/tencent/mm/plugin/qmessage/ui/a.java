package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.c.a {
    Context context;
    private f ilB;
    private ProgressDialog iln;
    private x jLe;

    public a(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        return true;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(x.Wz(xVar.field_username));
        ar.CG().a(b.CTRL_INDEX, this);
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbx);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.YN("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.vtX = "ContactWidgetQContact";
            normalUserHeaderPreference.a(xVar, 0, null);
        }
        arR();
        d HD = g.bjY().HD(this.jLe.field_username);
        if (HD == null || bh.ou(HD.getUsername()).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
            HD = new d();
            HD.username = this.jLe.field_username;
            HD.fDt = -1;
            g.bjY().a(HD);
        }
        if (HD.pnt == 1) {
            String str = this.jLe.field_username;
            z2 = bh.ou(HD.bjW()).length() <= 0;
            if (bh.ou(str).length() > 0) {
                z3 = true;
            }
            Assert.assertTrue(z3);
            Set hashSet = new HashSet();
            hashSet.add(str);
            final com.tencent.mm.plugin.qmessage.a.b bVar = new com.tencent.mm.plugin.qmessage.a.b(hashSet);
            new af().post(new Runnable(this) {
                final /* synthetic */ a pnF;

                public final void run() {
                    ar.CG().a(bVar, 0);
                }
            });
            if (z2) {
                Context context = this.context;
                this.context.getString(R.l.dGO);
                this.iln = h.a(context, this.context.getString(R.l.dFy), true, new 2(this, bVar));
            }
        }
        return true;
    }

    private void arR() {
        d HD = g.bjY().HD(this.jLe.field_username);
        if (HD == null || bh.ou(HD.getUsername()).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
            return;
        }
        if (bh.ou(HD.bjW()).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
        }
        Preference YN = this.ilB.YN("contact_info_qcontact_sex");
        Preference YN2 = this.ilB.YN("contact_info_qcontact_age");
        Preference YN3 = this.ilB.YN("contact_info_qcontact_birthday");
        Preference YN4 = this.ilB.YN("contact_info_qcontact_address");
        a aVar = new a(this, (byte) 0);
        String bjW = HD.bjW();
        if (bh.ou(bjW).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        } else {
            Map y = bi.y(bjW, "extinfo");
            if (y != null) {
                aVar.pnG = (String) y.get(".extinfo.sex");
                aVar.pnH = (String) y.get(".extinfo.age");
                aVar.pnI = (String) y.get(".extinfo.bd");
                aVar.country = (String) y.get(".extinfo.country");
                aVar.fWp = (String) y.get(".extinfo.province");
                aVar.fWq = (String) y.get(".extinfo.city");
            }
            if (aVar.pnG == null || !aVar.pnG.equals("1")) {
                aVar.pnG = aVar.pnF.context.getString(R.l.eNW);
            } else {
                aVar.pnG = aVar.pnF.context.getString(R.l.eNX);
            }
            if (aVar.country != null) {
                aVar.hxu += aVar.country + " ";
            }
            if (aVar.fWp != null) {
                aVar.hxu += aVar.fWp + " ";
            }
            if (aVar.fWq != null) {
                aVar.hxu += aVar.fWq;
            }
        }
        if (YN != null) {
            YN.setSummary(aVar.pnG == null ? "" : aVar.pnG);
        }
        if (YN2 != null) {
            YN2.setSummary(aVar.pnH == null ? "" : aVar.pnH);
        }
        if (YN3 != null) {
            YN3.setSummary(aVar.pnI == null ? "" : aVar.pnI);
        }
        if (YN4 != null) {
            YN4.setSummary(aVar.hxu == null ? "" : aVar.hxu);
        }
        this.ilB.notifyDataSetChanged();
    }

    public final boolean arS() {
        ar.CG().b(b.CTRL_INDEX, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ilB.YN("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 1;
        if (kVar.getType() == b.CTRL_INDEX) {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
                switch (i) {
                    case 1:
                        if (r.icH) {
                            Toast.makeText(this.context, this.context.getString(R.l.eiD, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 3000).show();
                            break;
                        }
                    case 2:
                        if (r.icH) {
                            Toast.makeText(this.context, this.context.getString(R.l.eiE, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 3000).show();
                            break;
                        }
                    default:
                        i3 = 0;
                        break;
                }
                if (i3 != 0) {
                    return;
                }
            }
            if (i == 0 && i2 == 0) {
                d HD = g.bjY().HD(this.jLe.field_username);
                if (HD == null || bh.ou(HD.getUsername()).length() <= 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.jLe.field_username);
                } else {
                    HD.fDt = 8;
                    HD.pnt = 0;
                    if (!g.bjY().a(this.jLe.field_username, HD)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.jLe.field_username);
                    }
                }
                arR();
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
