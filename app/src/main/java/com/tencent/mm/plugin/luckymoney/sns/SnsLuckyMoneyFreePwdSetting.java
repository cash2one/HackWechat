package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.py;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected f jKn;
    protected CheckBoxPreference ofn;

    private static void sb(int i) {
        b pyVar = new py();
        pyVar.fHF.key = i;
        pyVar.fHF.value = 1;
        pyVar.fHF.fHG = true;
        a.xef.m(pyVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        sb(116);
    }

    protected final void initView() {
        this.jKn = this.yjd;
        setBackBtn(new 1(this));
        setMMTitle(i.uKf);
        this.ofn = (CheckBoxPreference) this.jKn.YN("open_sns_pay_pref");
        aXp();
    }

    protected void onResume() {
        aXp();
        super.onResume();
    }

    private void aXp() {
        boolean z = true;
        if (com.tencent.mm.plugin.luckymoney.sns.b.a.aXs() != 1) {
            z = false;
        }
        this.ofn.tSw = z;
        this.gZO.edit().putBoolean("open_sns_pay_pref", z).commit();
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.aXt())) {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
            this.ofn.setTitle(i.uKe);
        } else {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.aXt());
            this.ofn.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.aXt());
        }
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.aXu())) {
            x.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
            this.ofn.setSummary(i.uKd);
        } else {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.aXu());
            this.ofn.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.aXu());
        }
        this.jKn.notifyDataSetChanged();
    }

    private void gt(boolean z) {
        this.gZO.edit().putBoolean("open_sns_pay_pref", z).commit();
        this.ofn.tSw = z;
        this.jKn.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final boolean g(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a) {
            x.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (i != 0 || i2 != 0) {
                sb(119);
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                aXp();
            } else if (((com.tencent.mm.plugin.luckymoney.sns.a.a) kVar).ofN == 1) {
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                sb(119);
                gt(true);
            } else {
                gt(false);
                sb(118);
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        return false;
    }

    public final int XB() {
        return l.var;
    }

    public final boolean a(f fVar, Preference preference) {
        if ("open_sns_pay_pref".equals(preference.ibD)) {
            if (this.ofn.isChecked() || com.tencent.mm.plugin.luckymoney.sns.b.a.aXs() != 1) {
                sb(120);
                com.tencent.mm.wallet_core.a.a((Activity) this, a.class, null, null);
            } else {
                cCh().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
                sb(117);
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
