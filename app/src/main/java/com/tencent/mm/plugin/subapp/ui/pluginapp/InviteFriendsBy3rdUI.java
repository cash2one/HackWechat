package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.k.g;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.io.RandomAccessFile;

public class InviteFriendsBy3rdUI extends MMPreference implements e, a, b {
    private static int rYA = 4;
    private static int rYB = 5;
    private static int rYC = 0;
    private static int rYD = 1;
    private static int rYx = 1;
    private static int rYy = 2;
    private static int rYz = 3;
    private int fromScene;
    private ProgressDialog iln = null;
    private ProgressBar mvE = null;
    private ProgressDialog nMb = null;
    private com.tencent.mm.ui.i.a rLC = new com.tencent.mm.ui.i.a();
    private int rYE = 0;
    private Bitmap rYF = null;
    private View rYG;
    private ImageView rYH = null;
    private EditText rYI = null;
    private boolean rYJ = false;
    private boolean rYK = false;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] nMz = new int[c.values().length];

        static {
            try {
                nMz[c.zqe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nMz[c.zqg.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nMz[c.zqf.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static /* synthetic */ void a(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, int i, String str) {
        k iVar = new i(i, str);
        inviteFriendsBy3rdUI.getString(R.l.dGO);
        inviteFriendsBy3rdUI.iln = h.a(inviteFriendsBy3rdUI, inviteFriendsBy3rdUI.getString(R.l.dGB), true, new 9(inviteFriendsBy3rdUI, iVar));
        ar.CG().a(iVar, 0);
    }

    public final int XB() {
        return R.o.fbN;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehr);
        this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
        int i = bh.getInt(g.zY().getValue("InviteFriendsInviteFlags"), 0);
        f fVar = this.yjd;
        if ((i & 2) <= 0) {
            fVar.YO("invite_friends_by_message");
        }
        if ((i & 1) <= 0) {
            fVar.YO("invite_friends_by_mail");
        }
        if ((i & 4) <= 0 || !aj(this.mController.xIM, "com.whatsapp")) {
            fVar.YO("invite_friends_by_whatsapp");
        }
        if ((i & 8) <= 0 || !q.Gr()) {
            fVar.YO("invite_friends_by_facebook");
        }
        if ((i & 16) <= 0) {
            fVar.YO("invite_friends_by_twitter");
        }
        fVar.notifyDataSetChanged();
        ar.CG().a(1803, this);
        ar.CG().a(1804, this);
        ar.CG().a(JsApiSetClipboardData.CTRL_INDEX, this);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFriendsBy3rdUI rYL;

            {
                this.rYL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rYL.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        ar.CG().b(1803, this);
        ar.CG().b(1804, this);
        ar.CG().b(JsApiSetClipboardData.CTRL_INDEX, this);
        if (this.rYE == 0) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14035, new Object[]{Integer.valueOf(this.rYE), Integer.valueOf(rYC), Integer.valueOf(this.fromScene)});
        }
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        if ("invite_friends_by_message".equals(preference.ibD)) {
            this.rYE = rYy;
            yi(2);
            return true;
        } else if ("invite_friends_by_mail".equals(preference.ibD)) {
            this.rYE = rYx;
            yi(1);
            return true;
        } else if ("invite_friends_by_whatsapp".equals(preference.ibD)) {
            this.rYE = rYz;
            yi(4);
            return true;
        } else if ("invite_friends_by_facebook".equals(preference.ibD)) {
            this.rYE = rYA;
            if (q.Gt()) {
                this.rYK = true;
                yi(8);
                return true;
            }
            h.a(this.mController.xIM, R.l.eLp, R.l.dGO, new 4(this), new 5(this));
            return true;
        } else if (!"invite_friends_by_twitter".equals(preference.ibD)) {
            return false;
        } else {
            this.rYE = rYB;
            if (this.rLC.cyv()) {
                this.rYJ = true;
                yi(16);
                return true;
            }
            h.a(this.mController.xIM, R.l.eNE, R.l.dGO, new 6(this), new 7(this));
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14035, new Object[]{Integer.valueOf(this.rYE), Integer.valueOf(rYC), Integer.valueOf(this.fromScene)});
        }
        if (kVar.getType() == 1803) {
            if (i == 0 && i2 == 0) {
                Intent intent;
                com.tencent.mm.modelmulti.f fVar = (com.tencent.mm.modelmulti.f) kVar;
                String str2 = bh.ov(fVar.title) ? null : fVar.title;
                fVar = (com.tencent.mm.modelmulti.f) kVar;
                String str3 = bh.ov(fVar.content) ? null : fVar.content;
                String FT = q.FT();
                ar.Hg();
                String str4 = (String) com.tencent.mm.z.c.CU().get(6, null);
                if (bh.ov(FT)) {
                    FT = str4;
                }
                int i3 = ((com.tencent.mm.modelmulti.f) kVar).hFj;
                if ((i3 & 1) > 0) {
                    if (bh.ov(str2)) {
                        str2 = String.format(getString(R.l.epO), new Object[]{q.FU()});
                    }
                    if (bh.ov(str3)) {
                        str3 = String.format(getString(R.l.epN), new Object[]{FT});
                    }
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.putExtra("android.intent.extra.SUBJECT", str2);
                    intent2.putExtra("android.intent.extra.TEXT", str3);
                    intent2.setType("plain/text");
                    startActivity(Intent.createChooser(intent2, getString(R.l.epJ)));
                    com.tencent.mm.plugin.report.service.g.pQN.h(14035, new Object[]{Integer.valueOf(this.rYE), Integer.valueOf(rYD), Integer.valueOf(this.fromScene)});
                }
                str4 = str3;
                if ((i3 & 2) > 0) {
                    if (bh.ov(str4)) {
                        str4 = String.format(getString(R.l.epP), new Object[]{FT});
                    }
                    intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("sms_body", str4);
                    intent.setType("vnd.android-dir/mms-sms");
                    if (bh.k(this, intent)) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, R.l.eJv, 1).show();
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(14035, new Object[]{Integer.valueOf(this.rYE), Integer.valueOf(rYD), Integer.valueOf(this.fromScene)});
                }
                if ((i3 & 4) > 0) {
                    if (bh.ov(str4)) {
                        str4 = String.format(getString(R.l.epP), new Object[]{FT});
                    }
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str4);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pQN.h(14035, new Object[]{Integer.valueOf(this.rYE), Integer.valueOf(rYD), Integer.valueOf(this.fromScene)});
                }
                if ((i3 & 8) > 0) {
                    if (bh.ov(str4)) {
                        if (bh.ov(q.FT())) {
                            str4 = getString(R.l.epM);
                        } else {
                            str4 = String.format(getString(R.l.epL), new Object[]{q.FT()});
                        }
                    }
                    str2 = getString(R.l.epI);
                    if (this.rYK) {
                        l(i3, str4, str2);
                        this.rYK = false;
                    }
                }
                if ((i3 & 16) > 0) {
                    this.rLC.a(this);
                    if (bh.ov(str4)) {
                        if (bh.ov(q.FT())) {
                            str4 = getString(R.l.epM);
                        } else {
                            str4 = String.format(getString(R.l.epL), new Object[]{q.FT()});
                        }
                    }
                    str2 = getString(R.l.epK);
                    if (this.rYJ) {
                        l(i3, str4, str2);
                        this.rYJ = false;
                    }
                }
            } else {
                h.h(this.mController.xIM, R.l.esW, R.l.dGO);
                return;
            }
        }
        if (kVar.getType() == 1804) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getResources().getString(R.l.dUd));
                com.tencent.mm.plugin.report.service.g.pQN.h(14035, new Object[]{Integer.valueOf(this.rYE), Integer.valueOf(rYD), Integer.valueOf(this.fromScene)});
            } else {
                h.h(this.mController.xIM, R.l.eKc, R.l.dGO);
                return;
            }
        }
        if (kVar.getType() == JsApiSetClipboardData.CTRL_INDEX && i == 0 && i2 == 0 && this.rYH != null) {
            if (this.mvE != null) {
                this.mvE.setVisibility(8);
            }
            this.rYH.setImageBitmap(aUC());
        }
    }

    private void yi(int i) {
        k fVar = new com.tencent.mm.modelmulti.f(i);
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.ctB), true, new 8(this, fVar));
        ar.CG().a(fVar, 0);
    }

    private static boolean aj(Context context, String str) {
        if (bh.ov(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void rF(int i) {
        h.a(this.mController.xIM, i, R.l.dGO, new OnClickListener(this) {
            final /* synthetic */ InviteFriendsBy3rdUI rYL;

            {
                this.rYL = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new 11(this));
    }

    public final void a(c cVar) {
        if (this.nMb != null) {
            this.nMb.cancel();
        }
        switch (AnonymousClass3.nMz[cVar.ordinal()]) {
            case 1:
                rF(R.l.eRB);
                return;
            case 3:
                rF(R.l.eRA);
                return;
            default:
                return;
        }
    }

    public final void b(c cVar) {
    }

    private void l(int i, String str, String str2) {
        this.rYG = View.inflate(this.mController.xIM, R.i.deB, null);
        this.rYI = (EditText) this.rYG.findViewById(R.h.bWU);
        this.rYH = (ImageView) this.rYG.findViewById(R.h.bWS);
        this.mvE = (ProgressBar) this.rYG.findViewById(R.h.ctw);
        ((View) this.rYH.getParent()).setVisibility(8);
        this.rYI.setText(str);
        this.rYF = aUC();
        if (this.rYF == null) {
            String FS = q.FS();
            ar.Hg();
            ar.CG().a(new com.tencent.mm.ba.a(FS, bh.e((Integer) com.tencent.mm.z.c.CU().get(66561, null))), 0);
            ((ProgressBar) this.rYG.findViewById(R.h.ctw)).setVisibility(0);
        } else if (this.rYH != null) {
            this.rYH.setImageBitmap(this.rYF);
        }
        com.tencent.mm.pluginsdk.ui.applet.e.a(this.mController, str2, this.rYG, getResources().getString(R.l.dGA), new 2(this, str, i));
    }

    private static Bitmap aUC() {
        byte[] CV = CV(q.FS());
        if (CV == null) {
            return null;
        }
        return d.bl(CV);
    }

    private static byte[] CV(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        ar.Hg();
        String Fi = com.tencent.mm.z.c.Fi();
        ar.Hg();
        try {
            randomAccessFile = new RandomAccessFile(com.tencent.mm.sdk.platformtools.i.e(Fi, com.tencent.mm.z.c.Fj(), "qr_", com.tencent.mm.a.g.s(str.getBytes()), ".png"), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Exception e2) {
                    return bArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            x.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }
}
