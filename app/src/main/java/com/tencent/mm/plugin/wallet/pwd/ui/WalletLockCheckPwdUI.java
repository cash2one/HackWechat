package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class WalletLockCheckPwdUI extends WalletBaseUI {
    private r sBH;
    private EditHintPasswdView sHe;
    private int sHf = -1;
    private TextView shX;
    private String vz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uQX);
        this.sHf = getIntent().getIntExtra("key_wallet_lock_type", -1);
        this.vz = getIntent().getStringExtra("action");
        x.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", Integer.valueOf(this.sHf), this.vz);
        this.sHe = (EditHintPasswdView) findViewById(a$f.ukY);
        this.shX = (TextView) findViewById(a$f.ula);
        this.shX.setText(i.uQW);
        CharSequence stringExtra = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
        if (this.sHf == 2) {
            setMMTitle(i.uXQ);
            if (this.vz.equals("action.touchlock_need_verify_paypwd") && !bh.ov(stringExtra)) {
                this.shX.setText(stringExtra);
            }
        } else if (this.sHf == 1) {
            setMMTitle(i.uXR);
        }
        this.sHe.zJC = new 2(this);
        e(this.sHe, 0, false);
        setBackBtn(new 1(this));
    }

    public void onResume() {
        super.onResume();
        if (this.sHe != null) {
            this.sHe.bmK();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
        dX(-1, 4);
    }

    protected final int getLayoutId() {
        return g.uEO;
    }

    public final void uw(int i) {
        super.uw(i);
        this.sHe.bmK();
    }

    private void dX(int i, int i2) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        setResult(-1, intent);
        finish();
    }

    private void u(int i, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof r) {
            r rVar = (r) kVar;
            if (i == 0 && i2 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
                    Intent intent = new Intent();
                    intent.putExtra("action", "action.switch_on_pattern");
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", rVar.token);
                    intent.putExtra(DownloadSettingTable$Columns.TYPE, rVar.sIC);
                    intent.putExtra("key_wallet_lock_type", this.sHf);
                    intent.setPackage(ac.getPackageName());
                    if (this.sHf == 2) {
                        intent.putExtra("key_pay_passwd", this.sHe.getText());
                    }
                    b quVar = new qu();
                    quVar.fIC.fIE = intent;
                    quVar.fIC.fAF = this;
                    quVar.fIC.fyV = 1;
                    a.xef.m(quVar);
                    return true;
                }
                u(0, rVar.token, rVar.sIC);
                return true;
            } else if (i == 1000 && i2 == 3) {
                u(-1, null, null);
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.i) {
            if (i == 0 && i2 == 0) {
                dX(-1, 0);
                return true;
            }
            dX(-1, -1);
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.a) {
            if (i == 0 && i2 == 0) {
                dX(-1, 0);
            } else {
                dX(-1, -1);
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        String str = "MicroMsg.WalletLockCheckPwdUI";
        String str2 = "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        setResult(i2, intent);
        finish();
    }
}
