package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.json.JSONObject;

public class WalletSecuritySettingUI extends MMPreference implements e {
    private f ilB;
    private boolean sHB = true;
    private WalletSecuritySettingHeaderPref sHC;
    private IconPreference sHD;
    private IconPreference sHE;
    private IconPreference sHF;
    private IconPreference sHG;
    private Preference sHH;
    private a sHI;
    private d sHJ;
    private c sHK;
    private b sHL;
    private ProgressDialog sHM;

    private class b {
        String desc;
        String oPH;
        final /* synthetic */ WalletSecuritySettingUI sHN;
        String sHP;
        String sHS;
        String sHT;
        String sHU;
        int status;
        String title;

        b(WalletSecuritySettingUI walletSecuritySettingUI, Context context) {
            this.sHN = walletSecuritySettingUI;
            if (!p.m(context, "com.tencent.qqpimsecure")) {
                this.status = 0;
            } else if (bh.bi(context, "com.tencent.server.back.BackEngine")) {
                this.status = 2;
            } else {
                this.status = 1;
            }
        }

        public final String getUrl() {
            if (this.status == 0) {
                return eB("qqpimsecurestatus", "not_installed");
            }
            if (this.status == 1) {
                return eB("qqpimsecurestatus", "not_run");
            }
            return eB("qqpimsecurestatus", "runing");
        }

        private String eB(String str, String str2) {
            return Uri.parse(this.sHP).buildUpon().appendQueryParameter(str, str2).build().toString();
        }
    }

    private class d {
        String desc;
        String oPH;
        final /* synthetic */ WalletSecuritySettingUI sHN;
        String sHX;
        boolean sHY;
        int status;
        String title;

        private d(WalletSecuritySettingUI walletSecuritySettingUI) {
            this.sHN = walletSecuritySettingUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new 1(this));
    }

    public final int XB() {
        return -1;
    }

    protected final void initView() {
        super.initView();
        this.ilB = this.yjd;
        if (this.ilB != null) {
            this.ilB.addPreferencesFromResource(l.vav);
        }
        g.Dk();
        String str = (String) g.Dj().CU().get(a.xwI, "");
        if (!bh.ov(str)) {
            try {
                T(new JSONObject(str));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            }
        }
    }

    protected void onResume() {
        String string;
        String str = null;
        super.onResume();
        this.sHC = (WalletSecuritySettingHeaderPref) this.ilB.YN("wallet_security_basic_info");
        if (this.sHC != null) {
            boolean z;
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.sHC;
            OnClickListener anonymousClass2 = new OnClickListener(this) {
                final /* synthetic */ WalletSecuritySettingUI sHN;

                {
                    this.sHN = r1;
                }

                public final void onClick(View view) {
                    if (this.sHN.sHI != null && bh.ov(this.sHN.sHI.sHP)) {
                        x.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
                    } else if (this.sHN.sHI != null && this.sHN.sHI.jumpType == 1 && !bh.ov(this.sHN.sHI.sHP)) {
                        Intent intent = new Intent();
                        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[]{this.sHN.sHI.sHP});
                        intent.putExtra("rawUrl", this.sHN.sHI.sHP);
                        com.tencent.mm.bm.d.b(this.sHN, "webview", ".ui.tools.WebViewUI", intent);
                    } else if (this.sHN.sHI != null && this.sHN.sHI.jumpType == 2) {
                        bh.ov(this.sHN.sHI.sHQ);
                    }
                }
            };
            String str2 = "MicroMsg.WalletSecuritySettingHeaderPref";
            String str3 = "alvinluo details == null: %b";
            Object[] objArr = new Object[1];
            if (walletSecuritySettingHeaderPref.sHw == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.v(str2, str3, objArr);
            walletSecuritySettingHeaderPref.sHz = anonymousClass2;
            if (walletSecuritySettingHeaderPref.sHw != null) {
                walletSecuritySettingHeaderPref.sHw.setOnClickListener(anonymousClass2);
            }
            walletSecuritySettingHeaderPref = this.sHC;
            anonymousClass2 = new 3(this);
            str2 = "MicroMsg.WalletSecuritySettingHeaderPref";
            str3 = "alvinluo closeBtn == null: %b";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.kmC == null);
            x.v(str2, str3, objArr);
            walletSecuritySettingHeaderPref.sHA = anonymousClass2;
            if (walletSecuritySettingHeaderPref.kmC != null) {
                walletSecuritySettingHeaderPref.kmC.setOnClickListener(anonymousClass2);
            }
        }
        g.Dk();
        g.Di().gPJ.a(385, this);
        if (this.sHB) {
            this.sHM = h.a(this, getString(i.dHc), false, null);
            this.sHB = false;
        }
        boolean aJW = ((com.tencent.mm.pluginsdk.l) g.h(com.tencent.mm.pluginsdk.l.class)).aJW();
        SharedPreferences cft = ac.cft();
        if (cft != null) {
            String string2 = cft.getString("cpu_id", null);
            string = cft.getString("uid", null);
            str = string2;
        } else {
            string = null;
        }
        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[]{Boolean.valueOf(aJW)});
        g.CG().a(new com.tencent.mm.plugin.wallet.pwd.a.d(aJW, str, string), 0);
    }

    protected void onPause() {
        super.onPause();
        g.Dk();
        g.Di().gPJ.b(385, this);
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_security_digital_certificate".equals(preference.ibD)) {
            com.tencent.mm.bm.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
            return true;
        } else if ("wallet_security_pay_guard".equals(preference.ibD)) {
            if (this.sHL == null) {
                return true;
            }
            x.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", new Object[]{this.sHL.getUrl()});
            com.tencent.mm.wallet_core.ui.e.bz(this, this.sHL.getUrl());
            return true;
        } else if ("wallet_security_wallet_lock".equals(preference.ibD)) {
            ((com.tencent.mm.plugin.walletlock.a.b) g.h(com.tencent.mm.plugin.walletlock.a.b.class)).c(this, new Intent());
            return true;
        } else if (!"wallet_security_safety_insurance".equals(preference.ibD)) {
            return false;
        } else {
            if (this.sHK == null) {
                return true;
            }
            if (this.sHK.jumpType == 2) {
                com.tencent.mm.sdk.b.b qpVar = new qp();
                qpVar.fIi.fIm = 0;
                qpVar.fIi.userName = this.sHK.sHW;
                qpVar.fIi.fIk = this.sHK.sHQ;
                com.tencent.mm.sdk.b.a.xef.m(qpVar);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.sHK.sHP);
                x.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
                com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d) {
            x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", new Object[]{((com.tencent.mm.plugin.wallet.pwd.a.d) kVar).sGz});
            T(r0);
        }
    }

    private void onError(String str) {
        if (this.sHM != null && this.sHM.isShowing()) {
            this.sHM.dismiss();
        }
        h.a(this, str, "", false, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletSecuritySettingUI sHN;

            {
                this.sHN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.sHN.finish();
            }
        });
    }

    private void T(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
            onError(getString(i.uWn));
            return;
        }
        try {
            JSONObject jSONObject2;
            this.ilB = this.yjd;
            CharSequence string = jSONObject.getString("more_security_title");
            this.sHH = this.ilB.YN("wallet_security_more_title");
            this.sHH.setTitle(string);
            if (jSONObject.has("basic_security_item")) {
                jSONObject2 = jSONObject.getJSONObject("basic_security_item");
                this.sHI = new a(this, (byte) 0);
                this.sHI.title = jSONObject2.optString("title");
                this.sHI.desc = jSONObject2.optString("desc");
                this.sHI.oPH = jSONObject2.optString("logo_url");
            }
            if (jSONObject.has("wallet_lock_info")) {
                jSONObject2 = jSONObject.getJSONObject("wallet_lock_info");
                this.sHJ = new d();
                this.sHJ.title = jSONObject2.optString("wallet_lock_title");
                this.sHJ.desc = jSONObject2.optString("wallet_lock_desc");
                this.sHJ.oPH = jSONObject2.getString("wallet_lock_logo_url");
                this.sHJ.status = jSONObject2.optInt("wallet_lock_status");
                this.sHJ.sHX = jSONObject2.optString("wallet_lock_status_name");
                this.sHJ.sHY = jSONObject2.optBoolean("is_open_touch_pay", false);
            }
            if (jSONObject.has("property_security_info")) {
                jSONObject2 = jSONObject.getJSONObject("property_security_info");
                this.sHK = new c(this, (byte) 0);
                this.sHK.title = jSONObject2.optString("title", "");
                this.sHK.desc = jSONObject2.optString("desc", "");
                this.sHK.oPH = jSONObject2.optString("logo_url", "");
                this.sHK.status = jSONObject2.optInt(DownloadInfo.STATUS, 0);
                this.sHK.sHV = jSONObject2.optString("status_name");
                this.sHK.jumpType = jSONObject2.optInt("jump_type");
                this.sHK.sHP = jSONObject2.optString("jump_h5_url");
                this.sHK.sHW = jSONObject2.optString("tinyapp_username");
                this.sHK.sHQ = jSONObject2.optString("tinyapp_path");
            }
            if (jSONObject.has("safe_manager_info")) {
                jSONObject2 = jSONObject.getJSONObject("safe_manager_info");
                this.sHL = new b(this, this);
                this.sHL.title = jSONObject2.optString("title", "");
                this.sHL.desc = jSONObject2.optString("desc", "");
                this.sHL.oPH = jSONObject2.optString("logo_url", "");
                this.sHL.sHT = jSONObject2.optString("installed_status_name");
                this.sHL.sHS = jSONObject2.optString("uninstall_status_name");
                this.sHL.sHU = jSONObject2.optString("protected_mode_name");
                this.sHL.sHP = jSONObject2.optString("jump_h5_url");
            }
            r.cBz().aj(jSONObject);
            g.Dk();
            g.Dj().CU().a(a.xwI, jSONObject.toString());
            this.sHC = (WalletSecuritySettingHeaderPref) this.ilB.YN("wallet_security_basic_info");
            if (this.sHI != null) {
                WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.sHC;
                String str = this.sHI.title;
                String str2 = this.sHI.desc;
                String str3 = this.sHI.sHR;
                walletSecuritySettingHeaderPref.mkE = str;
                walletSecuritySettingHeaderPref.sHx = str2;
                walletSecuritySettingHeaderPref.sHy = str3;
                walletSecuritySettingHeaderPref.au();
                if (bh.ov(this.sHI.sHR)) {
                    walletSecuritySettingHeaderPref = this.sHC;
                    if (walletSecuritySettingHeaderPref.sHw != null) {
                        walletSecuritySettingHeaderPref.sHw.setVisibility(8);
                    }
                }
            }
            if (this.sHJ == null) {
                this.ilB.bk("wallet_security_wallet_lock", true);
            } else {
                this.ilB.bk("wallet_security_wallet_lock", false);
                this.sHF = (IconPreference) this.ilB.YN("wallet_security_wallet_lock");
                a(this.sHJ.oPH, this.sHF);
                this.sHF.setTitle(this.sHJ.title);
                this.sHF.setSummary(this.sHJ.sHX);
                this.sHF.YQ(this.sHJ.desc);
                this.sHF.cqn();
            }
            this.ilB.bk("wallet_security_digital_certificate", false);
            this.sHD = (IconPreference) this.ilB.YN("wallet_security_digital_certificate");
            r.cBz();
            g.Dk();
            if ((((Integer) g.Dj().CU().get(a.xsu, Integer.valueOf(0))).intValue() > 0 ? 1 : 0) == 0) {
                this.ilB.bk("wallet_security_digital_certificate", true);
            } else {
                if (r.cBz().cBA()) {
                    if (this.sHD != null) {
                        this.sHD.setSummary(i.uWo);
                    }
                } else if (this.sHD != null) {
                    this.sHD.setSummary(i.uWp);
                }
                a(r.cBz().zHN, this.sHD);
                this.sHD.setTitle(r.cBz().zHL);
                this.sHD.setSummary(r.cBz().zHM);
                this.sHD.YQ(r.cBz().zHK);
                this.sHD.cqn();
            }
            this.ilB.bk("wallet_security_pay_guard", false);
            this.sHE = (IconPreference) this.ilB.YN("wallet_security_pay_guard");
            if (this.sHE != null) {
                this.sHE.setSummary(i.uWp);
            }
            if (this.sHL == null) {
                this.ilB.bk("wallet_security_pay_guard", true);
            } else {
                a(this.sHL.oPH, this.sHE);
                this.sHE.setTitle(this.sHL.title);
                IconPreference iconPreference = this.sHE;
                b bVar = this.sHL;
                string = bVar.status == 0 ? bVar.sHS : bVar.status == 1 ? bVar.sHT : bVar.sHU;
                iconPreference.setSummary(string);
                this.sHE.YQ(this.sHL.desc);
                this.sHE.cqn();
            }
            this.ilB = this.yjd;
            this.ilB.bk("wallet_security_safety_insurance", false);
            this.sHG = (IconPreference) this.ilB.YN("wallet_security_safety_insurance");
            if (this.sHG != null) {
                this.sHG.setSummary(i.uWq);
            }
            if (this.sHK == null) {
                this.ilB.bk("wallet_security_safety_insurance", true);
            } else {
                a(this.sHK.oPH, this.sHG);
                this.sHG.setTitle(this.sHK.title);
                this.sHG.setSummary(this.sHK.sHV);
                this.sHG.YQ(this.sHK.desc);
                this.sHG.cqn();
            }
            this.ilB.notifyDataSetChanged();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            onError(getString(i.uWn));
        }
        if (this.sHM != null && this.sHM.isShowing()) {
            this.sHM.dismiss();
        }
    }

    private void a(String str, IconPreference iconPreference) {
        if (iconPreference != null) {
            o.Pv();
            Bitmap iG = c.iG(str);
            if (iG != null) {
                iconPreference.drawable = new BitmapDrawable(this.mController.xIM.getResources(), iG);
            } else if (!bh.ov(str)) {
                o.Pz().a(str, new 5(this, iconPreference));
            }
        }
    }
}
