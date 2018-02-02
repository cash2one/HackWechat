package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.n;
import com.tencent.mm.bf.l;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.c.a, b {
    private static boolean oOs = true;
    private Context context;
    private f ilB;
    private x jLe;
    private c oOp;
    private View oOq;
    private CheckBox oOr;
    private i oOt = null;
    private r tipDialog;

    static class AnonymousClass6 extends af {
        final /* synthetic */ boolean kCv;
        final /* synthetic */ o kCw = null;

        AnonymousClass6(boolean z, o oVar) {
            this.kCv = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int Gd = q.Gd();
            if (this.kCv) {
                i = Gd & -513;
            } else {
                i = Gd | WXMediaMessage.TITLE_LENGTH_LIMIT;
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().set(34, Integer.valueOf(i));
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kCv) {
                l.Ty().Tt();
                ar.CG().a(new c(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
            }
            if (this.kCw != null) {
                this.kCw.a(null, null);
            }
        }
    }

    public a(Context context) {
        this.context = context;
        this.oOq = View.inflate(context, R.i.dmB, null);
        this.oOr = (CheckBox) this.oOq.findViewById(R.h.csH);
        this.oOr.setChecked(false);
        ar.CG().a(JsApiScanCode.CTRL_INDEX, this);
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_lbs_go_lbs")) {
            ar.Hg();
            Boolean bool = (Boolean) com.tencent.mm.z.c.CU().get(4103, null);
            if (bool == null || !bool.booleanValue()) {
                d.y(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                bi HR = bi.HR();
                if (HR == null) {
                    d.y(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String ou = bh.ou(HR.getProvince());
                    String ou2 = bh.ou(HR.getCity());
                    int i = HR.fWf;
                    if (ou.equals("") || ou2.equals("") || i == 0) {
                        d.y(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        ar.Hg();
                        bool = (Boolean) com.tencent.mm.z.c.CU().get(4104, null);
                        if (bool == null || !bool.booleanValue()) {
                            com.tencent.mm.bk.a.dV(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.oOt == null) {
                            this.oOt = h.a(this.context, this.context.getString(R.l.dGO), this.oOq, new OnClickListener(this) {
                                final /* synthetic */ a oOu;

                                {
                                    this.oOu = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ar.Hg();
                                    com.tencent.mm.z.c.CU().set(4104, Boolean.valueOf(!this.oOu.oOr.isChecked()));
                                    com.tencent.mm.bk.a.dV(this.oOu.context);
                                    ((Activity) this.oOu.context).finish();
                                }
                            }, new 3(this));
                        } else {
                            this.oOt.show();
                        }
                    }
                }
            }
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            h.a(this.context, R.l.ewZ, R.l.ewY, new OnClickListener(this) {
                final /* synthetic */ a oOu;

                {
                    this.oOu = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oOu.oOp = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    ar.CG().a(this.oOu.oOp, 0);
                    a aVar = this.oOu;
                    Context a = this.oOu.context;
                    this.oOu.context.getString(R.l.dGO);
                    aVar.tipDialog = h.a(a, this.oOu.context.getString(R.l.exc), true, new 1(this));
                }
            }, new 5(this));
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gS(xVar.field_username));
        ar.Hg();
        com.tencent.mm.z.c.CU().a(this);
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ContactWidgetLBS", "listener added");
        this.jLe = xVar;
        this.ilB = fVar;
        oOs = true;
        fVar.addPreferencesFromResource(R.o.fbs);
        arR();
        return true;
    }

    private void arR() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.Gd() & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dVk));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nx(i);
        this.ilB.bk("contact_info_lbs_install", z3);
        f fVar = this.ilB;
        String str = "contact_info_lbs_go_lbs";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        fVar = this.ilB;
        str = "contact_info_lbs_clear_info";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bk(str, z);
        f fVar2 = this.ilB;
        String str2 = "contact_info_lbs_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bk(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        oOs = z;
        context.getString(R.l.dGO);
        final r a = h.a(context, string, true, null);
        final af anonymousClass6 = new AnonymousClass6(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass6.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean arS() {
        ar.Hg();
        com.tencent.mm.z.c.CU().b(this);
        ar.CG().b(JsApiScanCode.CTRL_INDEX, this);
        com.tencent.mm.plugin.nearby.a.ift.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != com.tencent.mm.z.c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 7) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.oOp != null || ((c) kVar).IS() != 2) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
            if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
                int i3;
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i == 0 && i2 == 0) {
                    i3 = R.l.exb;
                } else {
                    i3 = R.l.exa;
                }
                if (((c) kVar).IS() == 2 && oOs) {
                    h.a(this.context, i3, R.l.dGO, new 8(this));
                    this.oOp = null;
                }
            }
        }
    }
}
