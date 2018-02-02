package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ay.n;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Timer;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    Context context;
    private f ilB;
    private x jLe;
    private boolean phD;

    static class AnonymousClass7 extends af {
        final /* synthetic */ boolean kCv;
        final /* synthetic */ o kCw = null;

        AnonymousClass7(boolean z, o oVar) {
            this.kCv = z;
        }

        public final void handleMessage(Message message) {
            int i;
            b.d(64, this.kCv, 5);
            b.d(8192, this.kCv, 12);
            int Gd = q.Gd();
            if (this.kCv) {
                i = Gd & -33;
            } else {
                i = Gd | 32;
            }
            ar.Hg();
            c.CU().set(34, Integer.valueOf(i));
            ar.Hg();
            c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kCv) {
                g.bka();
            }
            if (this.kCw != null) {
                this.kCw.a(null, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.phD) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN(str);
            if (checkBoxPreference.isChecked()) {
                d(64, true, 5);
            } else if (uX(8192)) {
                h.a(this.context, R.l.dVP, R.l.dGO, new 1(this), new 2(this, checkBoxPreference));
            } else {
                d(64, false, 5);
                return true;
            }
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            d(8192, ((CheckBoxPreference) this.ilB.YN(str)).isChecked(), 12);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUG), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 3(this), null);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            ar.Hg();
            if (bh.e((Integer) c.CU().get(9, null)) == 0) {
                h.b(this.context, R.l.eNU, R.l.dGO, new 4(this), new 5(this));
                return true;
            }
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 6(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new Timer().schedule(new 8(h.a(context, string, true, null), new AnonymousClass7(z, null)), 5000);
    }

    private static boolean uX(int i) {
        return (q.FW() & i) != 0;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(s.gM(xVar.field_username));
        if (fVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.phD = z;
        this.ilB = fVar;
        arR();
        return true;
    }

    final void arR() {
        int i = 1;
        int i2 = (q.Gd() & 32) == 0 ? 1 : 0;
        boolean uX = uX(64);
        uX(8192);
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fby);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dVQ));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.nx(i);
        if (i2 == 0) {
            this.ilB.YO("contact_info_view_message");
            this.ilB.YO("contact_info_qmessage_recv_offline_msg");
            this.ilB.YO("contact_info_qmessage_uninstall");
            this.ilB.YO("contact_info_qmessage_clear_data");
            return;
        }
        this.ilB.YO("contact_info_qmessage_install");
        ((CheckBoxPreference) this.ilB.YN("contact_info_qmessage_recv_offline_msg")).tSw = uX;
    }

    static void d(int i, boolean z, int i2) {
        int FW = q.FW();
        if (z) {
            FW |= i;
        } else {
            FW &= i ^ -1;
        }
        ar.Hg();
        c.CU().set(7, Integer.valueOf(FW));
        FW = z ? 1 : 2;
        ar.Hg();
        c.EX().b(new com.tencent.mm.ay.g(i2, FW));
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        com.tencent.mm.plugin.qmessage.a.pnq.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        ar.Hg();
        if (mVar == c.CU()) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
