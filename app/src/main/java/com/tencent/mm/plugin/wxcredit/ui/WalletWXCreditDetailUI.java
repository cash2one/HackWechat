package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private boolean hasInit = false;
    private f ilB;
    private Bankcard sDc;
    private OnClickListener tZZ = new OnClickListener(this) {
        final /* synthetic */ WalletWXCreditDetailUI uad;

        {
            this.uad = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == com.tencent.mm.plugin.wxpay.a.f.uAx) {
                if (this.uad.uac != null) {
                    e.T(this.uad, this.uad.uac.tZt.username);
                }
            } else if (view.getId() == com.tencent.mm.plugin.wxpay.a.f.uAv && this.uad.uac != null) {
                e.l(this.uad, this.uad.uac.tZs, false);
            }
        }
    };
    private c uab;
    private k uac;

    static /* synthetic */ void bXS() {
    }

    static /* synthetic */ void c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        Bundle bundle = walletWXCreditDetailUI.uab.msB;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        com.tencent.mm.wallet_core.a.a(walletWXCreditDetailUI, com.tencent.mm.plugin.wxcredit.f.class, bundle);
    }

    public final int XB() {
        return l.vaw;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cCh().ji(621);
        cCh().ji(600);
        uD(4);
        this.uab = com.tencent.mm.wallet_core.a.ag(this);
        if (this.sDc == null) {
            this.sDc = (Bankcard) this.uab.msB.getParcelable("key_bankcard");
        }
        if (bXR()) {
            if (this.zIZ == null) {
                if (this.zIX == null) {
                    this.zIX = com.tencent.mm.wallet_core.a.ag(this);
                }
                this.zIZ = this.zIX.a((MMActivity) this, this.zIY);
            }
            if (!this.zIZ.p(new Object[]{this.sDc})) {
                uD(0);
                initView();
            }
        }
    }

    private boolean bXR() {
        if (this.sDc == null) {
            return false;
        }
        if (this.sDc.field_bankcardState == 0) {
            return true;
        }
        int i = this.sDc.field_wxcreditState;
        if (this.uac != null) {
            i = this.uac.tZe;
        }
        switch (i) {
            case 1:
                long by = bh.by(o.bLq().sQi);
                x.d("MicroMsg.WalletUserInfoManger", "pass time " + by);
                if (by > 300) {
                    i = 1;
                } else {
                    boolean z = false;
                }
                if (i != 0) {
                    return true;
                }
                return false;
            case 3:
                h.a(this, i.uXV, -1, false, new 1(this));
                return false;
            case 4:
                break;
            case 5:
                this.uab.msB.putBoolean("key_can_unbind", false);
                break;
            default:
                return true;
        }
        if (this.uac == null) {
            return true;
        }
        this.uab.msB.putString("key_repayment_url", this.uac.tZm);
        this.uab.a((Activity) this, 1, this.uab.msB);
        return false;
    }

    protected void onDestroy() {
        cCh().jj(621);
        cCh().jj(600);
        super.onDestroy();
    }

    protected final void initView() {
        this.hasInit = true;
        setMMTitle(i.uXW);
        this.ilB = this.yjd;
        setBackBtn(new 2(this));
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDI, new 4(this));
    }

    private void au() {
        if (!this.hasInit) {
            initView();
        }
        if (this.uac != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.ilB.YN("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.ihU.setText(e.u(this.uac.tZf));
            String str = this.sDc.field_bankName;
            String str2 = this.uac.tZr;
            walletWXCreditDetailHeaderPreference.uaa.setText(walletWXCreditDetailHeaderPreference.mContext.getString(i.uAD, new Object[]{str2, str}));
        }
        if (this.uac != null) {
            boolean z;
            this.ilB.YN("wallet_wxcredit_total_amount").setTitle(getString(i.uXX, new Object[]{e.u(this.uac.tYZ)}));
            f fVar = this.ilB;
            str2 = "wallet_wxcredit_change_amount";
            if (this.uac.tZk) {
                z = false;
            } else {
                z = true;
            }
            fVar.bk(str2, z);
            Preference YN = this.ilB.YN("wallet_wxcredit_bill");
            if (this.uac.tZg != 0.0d) {
                YN.setSummary(e.u(this.uac.tZg));
            }
            YN = this.ilB.YN("wallet_wxcredit_repayment");
            Preference YN2 = this.ilB.YN("wallet_wxcredit_repayment_tips");
            if (this.uac.tZi > 0.0d) {
                YN.setSummary(e.u(this.uac.tZi));
                YN2.setTitle(getString(i.uYj, new Object[]{this.uac.tZn}));
                this.ilB.bk("wallet_wxcredit_repayment_tips", false);
            } else {
                this.ilB.bk("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.sDc != null) {
            this.ilB.YN("wallet_wxcredit_bank_name").setTitle(this.sDc.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.ilB.YN("wallet_wxcredit_footer")).tZZ = this.tZZ;
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_bankcard", this.sDc);
            com.tencent.mm.wallet_core.a.a(this, b.class, bundle);
            return true;
        } else if ("wallet_wxcredit_bill".equals(str)) {
            if (this.uac == null) {
                return false;
            }
            r1 = new Bundle();
            r1.putString("key_url", this.uac.tZq);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, r1);
            return false;
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.uac == null) {
                return false;
            }
            r1 = new Bundle();
            r1.putString("key_url", this.uac.tZo);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, r1);
            return false;
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.uac == null) {
                return false;
            }
            e.l(this, this.uac.tZp, false);
            return false;
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.uac == null) {
                return false;
            }
            e.l(this, this.uac.tZm, false);
            return false;
        } else if (!"wallet_wxcredit_bank_name".equals(str) || this.uac == null) {
            return false;
        } else {
            e.S(this, this.uac.tZt.username);
            return false;
        }
    }

    public final boolean g(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof d) {
                o.bLq().sQi = System.currentTimeMillis() / 1000;
                this.uac = ((d) kVar).tZa;
                if (this.uac != null && this.uac.tZe == 2) {
                    g.Dk();
                    if (((Boolean) g.Dj().CU().get(196658, Boolean.valueOf(false))).booleanValue()) {
                        c ag = com.tencent.mm.wallet_core.a.ag(this);
                        Bundle bundle = ag.msB;
                        bundle.putDouble("key_total_amount", this.uac.tYZ);
                        bundle.putBoolean("key_can_upgrade_amount", this.uac.tZk);
                        ag.a((Activity) this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        return true;
                    }
                }
                if (bXR()) {
                    uD(0);
                    au();
                }
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.i) {
                cCh().a(new com.tencent.mm.plugin.wallet_core.c.x(), true, 1);
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
                finish();
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        uD(0);
        au();
        super.onActivityResult(i, i2, intent);
    }
}
