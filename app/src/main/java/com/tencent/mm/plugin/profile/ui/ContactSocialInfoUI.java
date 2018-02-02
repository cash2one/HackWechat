package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.n;
import com.tencent.mm.k.g;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONObject;

public class ContactSocialInfoUI extends MMPreference {
    private String fDC;
    private f jKn;
    private x lFr;
    private String piA;
    private String piB;
    private String piC;
    private String piD;
    private String piE;
    private String piF;
    private JSONObject piG;
    private long pip;
    private String piq;
    private b piy;
    private String piz;

    static /* synthetic */ void a(ContactSocialInfoUI contactSocialInfoUI, final String str, final String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            Toast.makeText(contactSocialInfoUI.mController.xIM, contactSocialInfoUI.mController.xIM.getString(R.l.dWk), 0).show();
            return;
        }
        n.Jz();
        Bitmap je = d.je(str);
        if (je == null) {
            Toast.makeText(contactSocialInfoUI.mController.xIM, contactSocialInfoUI.mController.xIM.getString(R.l.dWl), 0).show();
            final e eVar = new e();
            eVar.a(str, new e.b(contactSocialInfoUI) {
                final /* synthetic */ ContactSocialInfoUI piH;

                public final int ba(int i, int i2) {
                    eVar.JD();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactSocialInfoUI", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        n.Jz();
                        if (this.piH.q(str2, d.je(str))) {
                            Toast.makeText(this.piH.mController.xIM, this.piH.mController.xIM.getString(R.l.dWm), 0).show();
                            return 0;
                        }
                    }
                    Toast.makeText(this.piH.mController.xIM, this.piH.mController.xIM.getString(R.l.dWk), 0).show();
                    return 0;
                }
            });
        } else if (contactSocialInfoUI.q(str2, je)) {
            Toast.makeText(contactSocialInfoUI.mController.xIM, contactSocialInfoUI.mController.xIM.getString(R.l.dWm), 0).show();
        } else {
            Toast.makeText(contactSocialInfoUI.mController.xIM, contactSocialInfoUI.mController.xIM.getString(R.l.dWk), 0).show();
        }
    }

    public final int XB() {
        return R.o.fbG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fDC = bh.ou(getIntent().getStringExtra("Contact_User"));
        ar.Hg();
        this.lFr = c.EY().WO(this.fDC);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.dWy);
        setBackBtn(new 1(this));
        this.jKn = this.yjd;
        String stringExtra = getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if (bh.ov(stringExtra) && bh.ov(stringExtra2)) {
            if (bh.ov(this.lFr.field_username)) {
                this.piy = af.OD().kR(this.fDC);
            } else {
                this.piy = af.OD().kR(this.lFr.field_username);
            }
        } else if ((stringExtra != null && stringExtra.length() > 0) || (stringExtra2 != null && stringExtra2.length() > 0)) {
            this.piy = af.OD().kS(stringExtra);
            if (this.piy == null || this.piy.Nr() == null || this.piy.Nr().length() <= 0) {
                this.piy = af.OD().kS(stringExtra2);
                if (!(this.piy == null || this.piy.Nr() == null)) {
                    this.piy.Nr().length();
                }
            }
        }
        if (this.piy == null || this.piy.Nr() == null || this.piy.Nr().length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.piz);
        } else {
            this.piA = bh.ou(this.piy.Nt()) + " " + bh.ou(this.piy.Nz()).replace(" ", "");
        }
        l("contact_info_social_mobile", this.piA, true);
        ar.Hg();
        int e = bh.e((Integer) c.CU().get(9, null));
        this.pip = getIntent().getLongExtra("Contact_Uin", 0);
        this.piq = getIntent().getStringExtra("Contact_QQNick");
        if (!(this.pip == 0 || e == 0)) {
            if (this.piq == null || this.piq.length() == 0) {
                ad be = af.OI().be(this.pip);
                if (be == null) {
                    be = null;
                }
                if (be != null) {
                    this.piq = be.getDisplayName();
                }
            }
            this.piB = bh.ou(this.piq);
            this.piB += " " + new o(this.pip).longValue();
        }
        l("contact_info_social_qq", this.piB, true);
        stringExtra = g.zY().getValue("LinkedinPluginClose");
        boolean z = bh.ov(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0;
        if (!z || bh.ov(this.lFr.fWA)) {
            this.piC = "";
        } else {
            this.piC = this.lFr.fWB;
        }
        l("contact_info_social_linkedin", this.piC, true);
        l("contact_info_social_facebook", this.piD, false);
        this.piF = bh.az(getIntent().getStringExtra("verify_gmail"), "");
        this.piE = bh.az(getIntent().getStringExtra("profileName"), bh.VS(this.piF));
        if (bh.ov(this.piF) || bh.ov(this.piE)) {
            l("contact_info_social_googlecontacts", "", false);
        } else {
            l("contact_info_social_googlecontacts", this.piE + '\n' + this.piF, false);
        }
        if (q.FS().equals(this.lFr.field_username)) {
            ar.Hg();
            stringExtra = (String) c.CU().get(a.xpK, null);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[]{stringExtra});
        } else {
            stringExtra = this.lFr.fWD;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[]{stringExtra});
        }
        if (!bh.ov(stringExtra)) {
            try {
                this.piG = new JSONObject(stringExtra);
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ContactSocialInfoUI", e2, "", new Object[0]);
                this.piG = null;
            }
        }
        if (this.piG != null) {
            l("contact_info_social_weishop", this.piG.optString("ShopName"), true);
        } else {
            l("contact_info_social_weishop", "", false);
        }
    }

    private void l(String str, String str2, boolean z) {
        if (bh.ov(str2) || bh.ov(str)) {
            this.jKn.YO(str);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.jKn.YN(str);
        if (keyValuePreference != null) {
            keyValuePreference.yiW = true;
            keyValuePreference.yiY = 5;
            if (z) {
                keyValuePreference.kXT = getResources().getColor(R.e.btd);
            }
            keyValuePreference.setSummary(str2);
            keyValuePreference.mx(false);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactSocialInfoUI", str + " item has been clicked!");
        if (str.equals("contact_info_social_mobile")) {
            if (!(this.piy == null || this.lFr == null)) {
                ar.Hg();
                if (c.EY().WK(this.piy.getUsername())) {
                    String[] stringArray = (this.piy == null || bh.ov(this.piy.hls)) ? getResources().getStringArray(R.c.bqY) : getResources().getStringArray(R.c.bqX);
                    if (com.tencent.mm.plugin.profile.a.ift.ur()) {
                        List F = bh.F(stringArray);
                        F.add(getResources().getString(R.l.dSt));
                        stringArray = (String[]) F.toArray(new String[F.size()]);
                        com.tencent.mm.plugin.report.service.g.pQN.h(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
                    }
                    h.a((Context) this, null, stringArray, null, new h.c(this) {
                        final /* synthetic */ ContactSocialInfoUI piH;

                        public final void jl(int i) {
                            switch (i) {
                                case 0:
                                    if (this.piH.piA != null && this.piH.piA.length() != 0) {
                                        int lastIndexOf = this.piH.piA.lastIndexOf(32) + 1;
                                        if (lastIndexOf > 0) {
                                            this.piH.Hw(this.piH.piA.substring(lastIndexOf));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 1:
                                    if (this.piH.piA != null && this.piH.piA.length() != 0) {
                                        String substring = this.piH.piA.substring(0, this.piH.piA.lastIndexOf(32));
                                        if (substring != null && substring.length() != 0) {
                                            s.b(this.piH.lFr, substring.trim());
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 2:
                                    if (stringArray != null && stringArray.length > 2 && this.piH.piy != null && this.piH.lFr != null) {
                                        if (!(this.piH.piy == null || bh.ov(this.piH.piy.hls))) {
                                            ContactSocialInfoUI.a(this.piH, this.piH.lFr.field_username, this.piH.piy.hls);
                                            return;
                                        }
                                    }
                                    return;
                                    break;
                                case 3:
                                    break;
                                default:
                                    return;
                            }
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putInt("fromScene", 2);
                            intent.putExtra("reportArgs", bundle);
                            com.tencent.mm.plugin.profile.a.ifs.k(intent, this.piH);
                        }
                    });
                } else if (!(this.piA == null || this.piA.length() == 0)) {
                    int lastIndexOf = this.piA.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        Hw(this.piA.substring(lastIndexOf));
                    }
                }
            }
        } else if (!str.equals("contact_info_social_qq")) {
            if (str.equals("contact_info_social_linkedin")) {
                str = this.lFr.fWC;
                if (bh.ov(str)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", q.FS());
                    com.tencent.mm.bm.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (!(str.equals("contact_info_social_facebook") || str.equals("contact_info_social_googlecontacts") || !str.equals("contact_info_social_weishop") || this.piG == null)) {
                ar.Hg();
                if (c.CU().get(a.xql, null) == null) {
                    h.a((Context) this, R.l.dWz, R.l.dGO, new OnClickListener(this) {
                        final /* synthetic */ ContactSocialInfoUI piH;

                        {
                            this.piH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.piH.bjt();
                            ar.Hg();
                            c.CU().a(a.xql, Integer.valueOf(1));
                        }
                    }, null);
                } else {
                    bjt();
                }
            }
        }
        return false;
    }

    private boolean q(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return m.a(str, this.mController.xIM, byteArrayOutputStream.toByteArray());
    }

    private void Hw(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
        startActivity(intent);
    }

    private void bjt() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.piG.optString("ShopUrl"));
        intent.putExtra("geta8key_username", q.FS());
        com.tencent.mm.bm.d.b(this.mController.xIM, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
