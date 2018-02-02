package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class b extends a {
    static /* synthetic */ int e(b bVar) {
        return !bVar.bMX() ? o.bLq().bLM() ? 2 : 1 : o.bLq().bLM() ? 5 : 4;
    }

    public c a(Activity activity, Bundle bundle) {
        w(new Object[]{"start", activity, bundle});
        x.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            p.ft(6, bundle.getInt("key_bind_scene"));
            com.tencent.mm.wallet_core.c.o.Hz(bundle.getInt("key_bind_scene"));
        } else {
            p.ft(6, 0);
            com.tencent.mm.wallet_core.c.o.Hz(0);
        }
        if (o.bLq().bLM()) {
            c(activity, WalletCheckPwdUI.class, bundle);
            return this;
        }
        if (bundle != null) {
            com.tencent.mm.plugin.wallet_core.e.c.ea(bundle.getInt("key_bind_scene", 0), 1);
        }
        if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
            return super.a(activity, bundle);
        }
        c(activity, WalletCardImportUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        w(new Object[]{"forward", activity, Integer.valueOf(i), bundle});
        x.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                c(activity, WalletCardImportUI.class, bundle);
            } else {
                c(activity, WalletBankcardIdUI.class, bundle);
            }
        } else if ((activity instanceof WalletCardElementUI) || (activity instanceof WalletCardImportUI)) {
            if (!bMX()) {
                x.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
                c(activity, WalletVerifyCodeUI.class, bundle);
            } else if (o.bLq().bLM()) {
                x.i("MicroMsg.BindCardProcess", "bind bank card success!!");
                bundle.putBoolean("intent_bind_end", true);
                h.bu(activity, activity.getString(i.uPE));
                b(activity, bundle);
            } else {
                x.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if ((activity instanceof WalletVerifyCodeUI) && o.bLq().bLM()) {
            x.i("MicroMsg.BindCardProcess", "end process after verify!");
            r1 = this.msB.getInt("key_bind_scene", -1);
            r0 = (BindCardOrder) this.msB.getParcelable("key_bindcard_value_result");
            if (r0 == null || r1 != 15) {
                b(activity, bundle);
                return;
            }
            r1 = this.msB.getString("key_bind_card_type");
            r2 = this.msB.getString("key_bind_card_show1");
            r3 = this.msB.getString("key_bind_card_show2");
            x.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[]{r1, r2, Integer.valueOf(this.msB.getInt("key_bind_scene")), Integer.valueOf(this.msB.getInt("realname_scene"))});
            r0.oZz = r1;
            r0.sLN = r2;
            r0.sLO = r3;
            r0.sLQ = r4;
            r0.sLR = r5;
            c(activity, WalletBindCardResultUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            x.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
            com.tencent.mm.plugin.wallet_core.e.c.ea(this.msB.getInt("key_bind_scene", 0), 7);
            bundle.putBoolean("intent_bind_end", true);
            h.bu(activity, activity.getString(i.uPE));
            r0 = (BindCardOrder) this.msB.getParcelable("key_bindcard_value_result");
            r1 = this.msB.getInt("key_bind_scene", -1);
            if (r0 == null || r1 != 15) {
                b(activity, bundle);
                return;
            }
            r1 = this.msB.getString("key_bind_card_type");
            r2 = this.msB.getString("key_bind_card_show1");
            r3 = this.msB.getString("key_bind_card_show2");
            x.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[]{r1, r2, Integer.valueOf(this.msB.getInt("key_bind_scene")), Integer.valueOf(this.msB.getInt("realname_scene"))});
            r0.oZz = r1;
            r0.sLN = r2;
            r0.sLO = r3;
            r0.sLQ = r4;
            r0.sLR = r5;
            c(activity, WalletBindCardResultUI.class, bundle);
        } else if (activity instanceof WalletBindCardResultUI) {
            b(activity, bundle);
        } else {
            x.i("MicroMsg.BindCardProcess", "super forward!");
            super.a(activity, 0, bundle);
        }
    }

    public e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, gVar);
        }
        if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            return new 2(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new e(this, mMActivity, gVar) {
                final /* synthetic */ b sIf;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof a) {
                            x.i("MicroMsg.BindCardProcess", "verify code success!");
                            this.sIf.msB.putString("kreq_token", ((a) kVar).token);
                            return true;
                        } else if (kVar instanceof q) {
                            this.sIf.a(this.zHV);
                            if (((q) kVar).sIg != null) {
                                this.sIf.msB.putParcelable("key_bindcard_value_result", ((q) kVar).sIg);
                            }
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h) {
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    this.sIf.w(new Object[]{"WalletVerifyCodeUI onNext", objArr});
                    x.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
                    com.tencent.mm.plugin.wallet_core.model.p pVar = (com.tencent.mm.plugin.wallet_core.model.p) objArr[1];
                    if (o.bLq().bLM()) {
                        pVar.flag = "2";
                    } else {
                        pVar.flag = "1";
                    }
                    if ("realname_verify_process".equals(this.sIf.aKG())) {
                        this.zHV.a(new q(pVar, this.sIf.msB.getInt("entry_scene", -1)), true, 1);
                    } else {
                        this.zHV.a(new q(pVar), true, 1);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 4(this, mMActivity, gVar) : super.a(mMActivity, gVar);
    }

    public final void a(g gVar) {
        x.d("MicroMsg.BindCardProcess", "do set user exinfo");
        gVar.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.h(this.msB.getString("key_country_code", ""), this.msB.getString("key_province_code", ""), this.msB.getString("key_city_code", ""), (Profession) this.msB.getParcelable("key_profession")), false, 1);
    }

    public void b(Activity activity, Bundle bundle) {
        w(new Object[]{"end", activity, bundle});
        x.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
        com.tencent.mm.wallet_core.c.o.cBv();
        cBm();
        if (bundle == null || !bundle.getBoolean("key_need_bind_response", false)) {
            d(activity, "mall", ".ui.MallIndexUI");
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".bind.ui.WalletBindUI", -1, intent, false);
    }

    public boolean c(Activity activity, Bundle bundle) {
        if (!o.bLq().bLM()) {
            return activity instanceof WalletPwdConfirmUI;
        }
        if (((activity instanceof WalletCardElementUI) && bMX()) || (activity instanceof WalletVerifyCodeUI)) {
            return true;
        }
        return false;
    }

    public String aKG() {
        return "BindCardProcess";
    }
}
