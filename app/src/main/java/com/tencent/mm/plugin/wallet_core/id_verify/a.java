package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class a extends b {
    private int bjW = 0;
    private boolean kMn = false;
    private int mMode;
    private String sJc = null;
    private String sJd = null;
    private boolean sJe = false;
    private int sJf = -1;

    public final c a(Activity activity, Bundle bundle) {
        boolean z;
        w(new Object[]{"start", activity, bundle});
        if (this.msB == null) {
            this.msB = new Bundle();
        }
        if (bundle == null) {
            bundle = this.msB;
        }
        if (bundle != null) {
            this.mMode = bundle.getInt("real_name_verify_mode", 0);
        } else {
            this.mMode = 0;
        }
        this.sJf = this.mMode;
        bundle.putBoolean("key_is_realname_verify_process", true);
        this.sJc = bundle.getString("realname_verify_process_jump_plugin", "");
        this.sJd = bundle.getString("realname_verify_process_jump_activity", "");
        if (bundle.getInt("realname_verify_process_allow_idverify", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.sJe = z;
        x.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[]{Boolean.valueOf(this.sJe), this.sJc, this.sJd});
        switch (this.mMode) {
            case 0:
                o.Hz(10);
                c(activity, SwitchRealnameVerifyModeUI.class, bundle);
                break;
            case 1:
                bundle.putBoolean("key_need_bind_response", true);
                o.Hz(10);
                super.a(activity, bundle);
                break;
            case 2:
                c(activity, WalletRealNameVerifyUI.class, bundle);
                break;
        }
        return this;
    }

    public final void d(Activity activity, int i) {
        w(new Object[]{"back", activity, Integer.valueOf(i)});
        o.cBv();
        if (activity instanceof SwitchRealnameVerifyModeUI) {
            if (i == 0) {
                b(activity, this.msB);
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.sJf != 0) {
                b(activity, this.msB);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, this.msB);
        }
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        w(new Object[]{"forward", activity, "actionCode:" + i, bundle});
        int i2 = this.msB.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i2) {
            this.mMode = i2;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                c(activity, WalletSetPasswordUI.class, bundle);
            } else if (activity instanceof WalletSetPasswordUI) {
                c(activity, WalletPwdConfirmUI.class, bundle);
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                c(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (com.tencent.mm.plugin.wallet_core.model.o.bLq().bLM()) {
                    c(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    c(activity, WalletBankcardIdUI.class, bundle);
                }
            } else if (activity instanceof WalletCheckPwdUI) {
                c(activity, WalletBankcardIdUI.class, bundle);
            } else {
                super.a(activity, i, bundle);
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            c(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        Bundle bundle2;
        w(new Object[]{"end", activity, bundle});
        o.cBv();
        if (bundle == null) {
            bundle2 = this.msB;
        } else {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (this.mMode == 1) {
            cBm();
            if (bundle2.getBoolean("intent_bind_end", false)) {
                this.bjW = -1;
            } else {
                this.bjW = 0;
            }
        } else if (bundle2.containsKey("realname_verify_process_ret")) {
            this.bjW = bundle2.getInt("realname_verify_process_ret", -1);
        } else {
            this.bjW = 0;
        }
        if (bundle2.containsKey("intent_bind_end")) {
            bundle2.remove("intent_bind_end");
        }
        if (bundle2.containsKey("key_is_bind_reg_process")) {
            bundle2.remove("key_is_bind_reg_process");
        }
        bundle2.putInt("realname_verify_process_ret", this.bjW);
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        if (this.bjW == -1) {
            Toast.makeText(activity, activity.getString(a$i.uMP), 0).show();
        }
        su suVar = new su();
        if (this.bjW == -1) {
            suVar.fKE.scene = 17;
        } else if (this.bjW == 0) {
            suVar.fKE.scene = 18;
        } else {
            suVar.fKE.scene = 0;
        }
        suVar.fqI = new 1(this, suVar, intent, activity);
        suVar.fqI.run();
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (!(mMActivity instanceof WalletPwdConfirmUI)) {
            return mMActivity instanceof WalletRealNameVerifyUI ? new 3(this, mMActivity, gVar) : super.a(mMActivity, gVar);
        } else {
            if (this.mMode == 2) {
                return new 2(this, mMActivity, gVar);
            }
            return super.a(mMActivity, gVar);
        }
    }

    public final String aKG() {
        return "realname_verify_process";
    }

    public final int b(MMActivity mMActivity, int i) {
        return a$i.uSk;
    }
}
