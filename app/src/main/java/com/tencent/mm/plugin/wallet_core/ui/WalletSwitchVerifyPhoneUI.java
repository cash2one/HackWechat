package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.List;

@a(19)
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView sWs;
    private List<ew> sWt;
    public boolean sWu = false;

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        walletSwitchVerifyPhoneUI.vf.putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.vf.putInt("key_pay_flag", 2);
        com.tencent.mm.wallet_core.a.j(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.vf);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, ew ewVar) {
        Object bankcard = new Bankcard();
        bankcard.field_bindSerial = ewVar.oZA;
        bankcard.field_mobile = ewVar.sIF;
        bankcard.field_bankcardType = ewVar.oZz;
        bankcard.field_desc = ewVar.nBM;
        x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", new Object[]{bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName});
        walletSwitchVerifyPhoneUI.vf.putParcelable("key_bankcard", bankcard);
        if (o.bLy().MT(bankcard.field_bankcardType) != null) {
            x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.bJR();
            return;
        }
        walletSwitchVerifyPhoneUI.b(new t("", "", null), true);
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqo, com.tencent.mm.plugin.wxpay.a.a.bpQ);
        super.onCreate(bundle);
        setMMTitle(getString(i.uWW));
        initView();
        this.sWu = this.vf.getBoolean("key_block_bind_new_card", false);
        if (!this.sWu) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.xIM);
            switchPhoneItemView.setTag(Integer.valueOf(-1));
            switchPhoneItemView.a(getString(i.uWS), null);
            this.sWs.a(switchPhoneItemView, -1);
        }
        if (cCc() != null && cCc().aKG() == "PayProcess" && this.vf.getInt("key_can_verify_tail", 0) == 1) {
            x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
            CharSequence string = getString(i.uRQ);
            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.xIM, g.uFT);
            switchPhoneItemView2.setTag(Integer.valueOf(-2));
            switchPhoneItemView2.a(string, null);
            this.sWs.a(switchPhoneItemView2, -1);
        }
        ji(1667);
        ji(461);
        ji(1505);
        l(new e(bJQ()));
    }

    protected final void initView() {
        this.sWs = (SwitchPhoneItemGroupView) findViewById(f.utx);
        this.sWs.sXs = new 1(this);
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1667);
        jj(461);
        jj(1505);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                e eVar = (e) kVar;
                this.sWt = ((e) kVar).sIj.wiJ;
                Collections.sort(this.sWt, new 2(this));
                if (eVar.sIj.wiK != null) {
                    pj pjVar = eVar.sIj.wiK;
                    this.vf.putString("key_true_name", pjVar.sKt);
                    this.vf.putString("key_cre_name", pjVar.vYs);
                    this.vf.putString("key_cre_type", pjVar.sPn);
                }
                if (this.sWt == null || this.sWt.isEmpty()) {
                    x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.sWt.size() - 1; size >= 0; size--) {
                        ew ewVar = (ew) this.sWt.get(size);
                        if (ewVar.vKD.equals("cft")) {
                            CharSequence spannableString;
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.xIM);
                            String string = ewVar.vKE.equals("1") ? getString(i.uWV) : getString(i.uWU);
                            Object string2 = getString(i.uWT, new Object[]{ewVar.nBM, string, ewVar.vKF});
                            if (this.sWu) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(i.uWX);
                                g gVar = new g(this);
                                String str2 = string2 + "，";
                                gVar.su = getResources().getColor(c.brA);
                                spannableString = new SpannableString(str2 + string3);
                                spannableString.setSpan(gVar, str2.length(), str2.length() + string3.length(), 33);
                                gVar.sTw = new 3(this, ewVar);
                            }
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.a(ewVar.sIF, spannableString);
                            this.sWs.a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.xIM);
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.a(ewVar.sIF, getString(i.uWY));
                            this.sWs.a(switchPhoneItemView2, 0);
                        }
                    }
                }
                return true;
            } else if (kVar instanceof t) {
                bJR();
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uFV;
    }

    protected final boolean bKa() {
        return true;
    }

    private void bJR() {
        x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) this.vf.getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
        Object MT = o.bLy().MT(bankcard.field_bankcardType);
        this.vf.putParcelable("elemt_query", MT);
        authen.oZz = bankcard.field_bankcardType;
        authen.oZA = bankcard.field_bindSerial;
        bankcard.field_bankPhone = MT.sMC;
        this.vf.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        this.vf.putBoolean("key_is_changing_balance_phone_num", true);
        this.vf.putInt("key_err_code", 418);
        com.tencent.mm.wallet_core.a.j(this, this.vf);
    }
}
