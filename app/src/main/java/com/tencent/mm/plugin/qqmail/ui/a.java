package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.c.a, b {
    private static boolean prX = false;
    private Context context;
    private boolean fqP;
    private f ilB;
    private ProgressDialog iln;
    private x jLe;
    private ProgressDialog kVi;
    private boolean phD;
    private boolean prW;

    public a(Context context) {
        Assert.assertTrue(context != null);
        this.context = context;
    }

    public final boolean vQ(String str) {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        Intent intent;
        if (str.equals("contact_info_qqmailhelper_view")) {
            intent = new Intent();
            if (this.phD) {
                intent.putExtra("Chat_User", this.jLe.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.jLe.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                com.tencent.mm.plugin.qqmail.a.a.ifs.e(intent, this.context);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            intent = new Intent(this.context, ComposeUI.class);
            if (this.phD) {
                intent.putExtra("Chat_User", this.jLe.field_username);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.jLe.field_username);
                intent.addFlags(67108864);
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            ar.Hg();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(bh.ou((String) c.CU().get(29, null))));
            intent2.putExtra("title", this.context.getString(R.l.dVU));
            intent2.putExtra("zoom", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            intent2.putExtra("vertical_scroll", false);
            com.tencent.mm.plugin.qqmail.a.a.ifs.j(intent2, this.context);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN(str);
            boolean isChecked = checkBoxPreference.isChecked();
            hq(isChecked);
            if (!isChecked) {
                z = true;
            }
            checkBoxPreference.tSw = z;
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUI), "", new OnClickListener(this) {
                final /* synthetic */ a prY;

                {
                    this.prY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.bku();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            ar.Hg();
            if (bh.e((Integer) c.CU().get(9, null)) == 0) {
                h.b(this.context, R.l.eNU, R.l.dGO, new OnClickListener(this) {
                    final /* synthetic */ a prY;

                    {
                        this.prY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.qqmail.a.a.ifs.h(null, this.prY.context);
                    }
                }, null);
                return true;
            }
            hp(true);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 3(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gI(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        ar.CG().a(24, (e) this);
        this.phD = z;
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbz);
        arR();
        return true;
    }

    private void arR() {
        boolean z;
        int i;
        boolean z2 = true;
        this.fqP = (q.Gd() & 1) == 0;
        ar.Hg();
        if (bh.e((Integer) c.CU().get(17, null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.prW = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dVV));
        if (this.fqP) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nx(i);
        this.ilB.bk("contact_info_qqmailhelper_install", this.fqP);
        f fVar = this.ilB;
        String str = "contact_info_qqmailhelper_view";
        if (this.fqP) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        fVar = this.ilB;
        str = "contact_info_qqmailhelper_compose";
        if (this.fqP) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.tSw = this.prW;
        }
        fVar = this.ilB;
        str = "contact_info_qqmailhelper_recv_remind";
        if (this.fqP) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        fVar = this.ilB;
        str = "contact_info_qqmailhelper_set_files_view";
        if ((this.fqP & this.prW) == 0) {
            z = true;
        } else {
            z = false;
        }
        fVar.bk(str, z);
        this.ilB.bk("contact_info_qqmailhelper_download_mgr_view", true);
        fVar = this.ilB;
        str = "contact_info_qqmailhelper_clear_data";
        if (this.fqP) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        f fVar2 = this.ilB;
        String str2 = "contact_info_qqmailhelper_uninstall";
        if (this.fqP) {
            z2 = false;
        }
        fVar2.bk(str2, z2);
    }

    private void hp(boolean z) {
        String string = z ? this.context.getString(R.l.eMA) : this.context.getString(R.l.eMH);
        Context context = this.context;
        this.context.getString(R.l.dGO);
        this.kVi = h.a(context, string, true, null);
        prX = true;
        hq(z);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        ar.CG().b(24, (e) this);
        if (this.kVi != null) {
            this.kVi.dismiss();
            this.kVi = null;
        }
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(o), mVar);
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(o), mVar);
        } else if (o == 17 || o == 34 || o == 7) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private boolean hq(boolean z) {
        k nVar = new n(z, "");
        if (!prX) {
            this.iln = h.a(this.context, this.context.getString(R.l.dHc), true, new 4(this, nVar));
        }
        ar.CG().a(nVar, 0);
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 24) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + kVar.getType());
            return;
        }
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (this.kVi != null) {
            this.kVi.dismiss();
            this.kVi = null;
        }
        if (i == 0 && i2 == 0) {
            boolean z = ((n) kVar).fJL;
            ar.Hg();
            c.CU().set(17, Integer.valueOf(z ? 1 : 2));
            if (prX && bh.bF(this.context)) {
                if (z) {
                    ar.Hg();
                    c.CU().set(17, Integer.valueOf(1));
                }
                int Gd = q.Gd();
                int i3 = z ? Gd & -2 : Gd | 1;
                ar.Hg();
                c.CU().set(34, Integer.valueOf(i3));
                ar.Hg();
                c.EX().b(new com.tencent.mm.ay.n("", "", "", "", "", "", "", "", i3, "", ""));
                com.tencent.mm.plugin.qqmail.a.a.ift.um();
                if (!z) {
                    w.bku();
                }
            }
            prX = false;
            return;
        }
        CharSequence string;
        boolean z2 = ((n) kVar).fJL;
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + i + ", errCode = " + i2);
        if (i == 4) {
            switch (i2) {
                case -31:
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetQQMail", "need second pass");
                    View inflate = View.inflate(this.context, R.i.drv, null);
                    h.a(this.context, this.context.getString(R.l.dVT), inflate, new 5(this, z2, (EditText) inflate.findViewById(R.h.cKr)));
                    return;
                case -1:
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
                    break;
                default:
                    return;
            }
        }
        if (prX) {
            string = this.context.getString(z2 ? R.l.eMx : R.l.eMC);
        } else {
            string = this.context.getString(R.l.dEO);
        }
        Toast.makeText(this.context, string, 1).show();
        prX = false;
    }
}
