package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.q;

@a(19)
public class WalletPasswordSettingUI extends MMPreference implements e {
    private boolean gLX;
    private af handler = new af(new 1(this));
    private f ilB;
    private Dialog ilS;
    c sCQ = new 2(this);
    CheckBoxPreference sHh;
    private IconPreference sHi;
    private Preference sHj;
    private String sHk;
    private String sHl;
    private String sHm;
    private z sHn;
    private boolean sHo = false;
    private int sHp = 0;

    static /* synthetic */ void b(WalletPasswordSettingUI walletPasswordSettingUI) {
        walletPasswordSettingUI.jG(false);
        l lVar = (l) g.h(l.class);
        h.a(walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(i.uUn), "", walletPasswordSettingUI.getResources().getString(lVar.aKh() ? i.uUm : i.dFU), walletPasswordSettingUI.getString(i.dEn), true, new 7(walletPasswordSettingUI, lVar), new 8(walletPasswordSettingUI));
    }

    static /* synthetic */ void e(WalletPasswordSettingUI walletPasswordSettingUI) {
        l lVar = (l) g.h(l.class);
        if (walletPasswordSettingUI.sHh.isChecked() != lVar.aJW()) {
            walletPasswordSettingUI.jG(lVar.aJW());
        }
    }

    public final int XB() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dk();
        g.Di().gPJ.a(385, this);
        com.tencent.mm.sdk.b.a.xef.b(this.sCQ);
        this.gLX = getIntent().getBooleanExtra("key_is_from_system", false);
        if (this.gLX) {
            x.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
            ((b) g.h(b.class)).a(this, null);
        }
        initView();
        if (com.tencent.mm.plugin.wallet.pwd.a.c.bDH()) {
            jH(false);
        } else {
            z zVar;
            g.Dk();
            this.sHl = (String) g.Dj().CU().get(w.a.xrr, "");
            com.tencent.mm.plugin.wallet_core.d.h bLp = o.bLp();
            if (!bh.ov("wallet_open_auto_pay")) {
                Cursor a = bLp.gJP.a("select * from WalletPrefInfo where pref_key=?", new String[]{r2}, 2);
                if (a != null) {
                    if (a.moveToFirst()) {
                        zVar = new z();
                        zVar.b(a);
                    } else {
                        zVar = null;
                    }
                    a.close();
                    this.sHn = zVar;
                    if (this.sHn == null && this.sHn.field_is_show == 1 && !bh.ov(this.sHn.field_pref_url)) {
                        x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
                        this.sHk = this.sHn.field_pref_url;
                        eA(this.sHn.field_pref_title, this.sHn.field_pref_url);
                    } else if (this.sHn != null) {
                        x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
                    } else {
                        x.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.sHn.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bh.ov(this.sHn.field_pref_url));
                    }
                }
            }
            zVar = null;
            this.sHn = zVar;
            if (this.sHn == null) {
            }
            if (this.sHn != null) {
                x.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.sHn.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bh.ov(this.sHn.field_pref_url));
            } else {
                x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
            }
        }
        g.Dk();
        this.sHp = ((Integer) g.Dj().CU().get(w.a.xtt, Integer.valueOf(0))).intValue();
        g.Dk();
        this.sHm = (String) g.Dj().CU().get(w.a.xto, "");
        if (bh.ov(this.sHm)) {
            ad.a(true, null);
        } else {
            this.sHj.setTitle(this.sHm);
            ad.a(false, null);
        }
        if (this.sHp == 0) {
            this.ilB.bk("wallet_delay_transfer_date", true);
        }
    }

    private void eA(String str, String str2) {
        this.sHi.setTitle(str);
        if (bh.ov(str2)) {
            this.ilB.bk("wallet_open_auto_pay", true);
            x.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
            return;
        }
        this.ilB.bk("wallet_open_auto_pay", false);
    }

    private void bKA() {
        g.Dk();
        String str = (String) g.Dj().CU().get(w.a.xwJ, "");
        g.Dk();
        x.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[]{str, (String) g.Dj().CU().get(w.a.xwK, "")});
        if (bh.ov(str) || bh.ov(r1)) {
            this.ilB.bk("wallet_password_setting_un_reg", true);
        } else {
            this.ilB.bk("wallet_password_setting_un_reg", false);
        }
    }

    protected void onResume() {
        super.onResume();
        if (((b) g.h(b.class)).bNz()) {
            finish();
        } else {
            bKE();
        }
    }

    protected final void initView() {
        setMMTitle(q.Gf() ? getString(i.uUp) : getString(i.uUo));
        com.tencent.mm.wallet_core.ui.e.cCf();
        this.ilB = this.yjd;
        this.ilB.addPreferencesFromResource(bKB());
        this.sHi = (IconPreference) this.ilB.YN("wallet_open_auto_pay");
        this.sHj = this.ilB.YN("wallet_delay_transfer_date");
        g.Dk();
        if (!((Boolean) g.Dj().CU().get(w.a.xri, Boolean.valueOf(false))).booleanValue()) {
            this.sHi.di("new", com.tencent.mm.plugin.wxpay.a.e.bHd);
            this.sHi.EY(0);
            g.Dk();
            g.Dj().CU().a(w.a.xri, Boolean.valueOf(true));
        }
        this.sHh = (CheckBoxPreference) this.ilB.YN("wallet_fingerprint_switch");
        bKE();
        this.ilB.bk("nfc_idpay", true);
        this.ilB.bk("wallet_open_auto_pay", true);
        bKA();
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletPasswordSettingUI sHq;

            {
                this.sHq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sHq.finish();
                return true;
            }
        });
    }

    public int bKB() {
        return com.tencent.mm.plugin.wxpay.a.l.vat;
    }

    public void bKC() {
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    }

    public void bKD() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_paymanager", true);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pwd.a.class, bundle, null);
    }

    private void jG(boolean z) {
        this.gZO.edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.sHh.tSw = z;
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_modify_password".equals(preference.ibD)) {
            bKC();
            com.tencent.mm.wallet_core.ui.e.HF(24);
            return true;
        } else if ("wallet_forget_password".equals(preference.ibD)) {
            bKD();
            com.tencent.mm.wallet_core.ui.e.HF(25);
            return true;
        } else if ("wallet_realname_verify".equals(preference.ibD)) {
            if (!o.bLq().bLM()) {
                x.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
                r0 = new Bundle();
                r0.putInt("real_name_verify_mode", 0);
                r0.putString("realname_verify_process_jump_plugin", "wallet");
                r0.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, r0, new 4(this));
            } else if (bh.ov(this.sHl)) {
                x.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
            } else {
                x.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
                r0 = new Intent();
                r0.putExtra("rawUrl", this.sHl);
                r0.putExtra("showShare", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", r0);
            }
            return true;
        } else if ("wallet_fingerprint_switch".equals(preference.ibD)) {
            g.Dk();
            g.Dj().CU().a(w.a.xoE, Boolean.valueOf(true));
            if (this.sHh.isChecked()) {
                if (this.gLX) {
                    com.tencent.mm.plugin.soter.c.a.xZ(2);
                } else {
                    com.tencent.mm.plugin.soter.c.a.xZ(1);
                }
                l lVar = (l) g.h(l.class);
                if (lVar == null || !lVar.aJX()) {
                    this.handler.obtainMessage(2).sendToTarget();
                } else {
                    r0 = new Bundle();
                    r0.putInt("open_scene", 1);
                    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", r0);
                }
            } else {
                this.handler.obtainMessage(1).sendToTarget();
            }
            return true;
        } else {
            if ("wallet_open_auto_pay".equals(preference.ibD)) {
                if (bh.ov(this.sHk)) {
                    x.e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
                } else {
                    x.i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
                    r0 = new Intent();
                    r0.putExtra("rawUrl", this.sHk);
                    r0.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", r0);
                    this.sHi.EY(8);
                    return true;
                }
            }
            if ("wallet_digitalcert".equals(preference.ibD)) {
                if (!this.sHo) {
                    k cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
                    g.Dk();
                    g.Di().gPJ.a(cVar, 0);
                }
                d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
                return true;
            } else if ("wallet_delay_transfer_date".equals(preference.ibD)) {
                startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
                return true;
            } else {
                if ("wallet_password_setting_un_reg".equals(preference.ibD)) {
                    g.Dk();
                    String str = (String) g.Dj().CU().get(w.a.xwK, "");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                }
                return false;
            }
        }
    }

    public void bKE() {
        if (o.bLq().bLJ() || o.bLq().bLN()) {
            this.ilB.bk("wallet_modify_password", true);
            this.ilB.bk("wallet_forget_password", true);
            this.ilB.bk("wallet_fingerprint_switch", true);
            this.ilB.bk("wallet_realname_verify", false);
            this.ilB.YN("wallet_realname_verify").setSummary(i.uUj);
        } else if (o.bLq().bLM()) {
            this.ilB.bk("wallet_modify_password", false);
            this.ilB.bk("wallet_forget_password", false);
            this.ilB.bk("wallet_fingerprint_switch", false);
            this.ilB.bk("wallet_realname_verify", false);
            this.ilB.YN("wallet_realname_verify").setSummary(i.uUl);
        } else {
            x.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
        }
        this.ilB.bk("wallet_digitalcert", true);
        if (!d.OQ("fingerprint")) {
            x.e("MicroMsg.WalletPasswordSettingUI", "plugin fingerprinthad not been installed");
            this.ilB.bk("wallet_fingerprint_switch", true);
        } else if (com.tencent.mm.plugin.wallet.b.a.bKF()) {
            boolean booleanValue;
            x.i("MicroMsg.WalletPasswordSettingUI", "isSupportFingeprint is true");
            p.bJN();
            if (p.bJO() == null || !((l) g.h(l.class)).aJW()) {
                this.sHh.tSw = false;
                this.sHh.yjI = false;
            } else {
                this.sHh.tSw = true;
                this.sHh.yjI = false;
            }
            this.sHh.setSummary(i.uUh);
            this.ilB.bk("wallet_fingerprint_switch", false);
            g.Dk();
            g.Dj().CU().a(w.a.xoC, Boolean.valueOf(true));
            g.Dk();
            g.Dj().CU().a(w.a.xoD, Boolean.valueOf(true));
            g.Dk();
            Object obj = g.Dj().CU().get(w.a.xoE, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            if (booleanValue) {
                this.sHh.zg(8);
            } else {
                this.sHh.cq(getString(i.dFP), com.tencent.mm.plugin.wxpay.a.e.bHd);
                this.sHh.zg(0);
            }
        } else {
            this.ilB.bk("wallet_fingerprint_switch", true);
        }
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(147457, Long.valueOf(0))).longValue();
        int i = i.uRp;
        if ((16 & longValue) != 0) {
            i = i.uRo;
        } else if ((longValue & 32) != 0) {
            i = i.uRn;
        }
        this.ilB.YN("wallet_delay_transfer_date").setSummary(i);
        this.ilB.notifyDataSetChanged();
    }

    private void jH(boolean z) {
        k cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
        g.Dk();
        g.Di().gPJ.a(cVar, 0);
        this.sHo = true;
        if (z) {
            this.ilS = com.tencent.mm.wallet_core.ui.g.a(this, false, new 9(this));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.c) {
                bKE();
                com.tencent.mm.plugin.wallet.pwd.a.c cVar = (com.tencent.mm.plugin.wallet.pwd.a.c) kVar;
                x.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + cVar.sGu);
                this.sHl = cVar.sGy;
                if (cVar.sGu == 1) {
                    this.sHk = cVar.sGv;
                    eA(bh.az(cVar.sGx, getString(i.uUL)), cVar.sGv);
                } else {
                    this.ilB.bk("wallet_open_auto_pay", true);
                }
                bKA();
                if (this.ilS != null) {
                    this.ilS.dismiss();
                }
            } else if (kVar instanceof ad) {
                this.sHm = ((ad) kVar).sIT;
                this.sHp = ((ad) kVar).sIY;
                if (this.sHp == 0) {
                    this.ilB.bk("wallet_delay_transfer_date", true);
                    return;
                }
                if (bh.ov(this.sHm)) {
                    x.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
                } else {
                    this.sHj.setTitle(this.sHm);
                }
                this.ilB.bk("wallet_delay_transfer_date", false);
            }
        } else if (kVar instanceof ad) {
            x.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.sCQ);
        g.Dk();
        g.Di().gPJ.b(385, this);
    }
}
