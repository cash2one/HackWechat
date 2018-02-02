package com.tencent.mm.plugin.gms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.e;

public class MMGoogleAuthUtil extends Activity {
    private String hzj;
    private String jgk;
    private String nzw;
    public int nzx = 0;

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        Intent intent2 = new Intent();
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equals("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT")) {
                    String[] strArr = new String[]{"com.google"};
                    intent = new Intent();
                    intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
                    intent.setPackage("com.google.android.gms");
                    intent.putExtra("allowableAccounts", null);
                    intent.putExtra("allowableAccountTypes", strArr);
                    intent.putExtra("addAccountOptions", null);
                    intent.putExtra("selectedAccount", null);
                    intent.putExtra("alwaysPromptForAccount", false);
                    intent.putExtra("descriptionTextOverride", null);
                    intent.putExtra("authTokenType", null);
                    intent.putExtra("addAccountRequiredFeatures", null);
                    intent.putExtra("setGmsCoreAccount", false);
                    intent.putExtra("overrideTheme", 0);
                    intent.putExtra("overrideCustomTheme", 0);
                    startActivityForResult(intent, 2001);
                    return;
                } else if (action.equals("com.tencent.mm.gms.ACTION_GET_TOKEN")) {
                    this.nzw = intent.getStringExtra("gmail");
                    this.jgk = intent.getStringExtra("scope");
                    cS(this.nzw, this.jgk);
                    return;
                } else if (action.equals("com.tencent.mm.gms.CHECK_GP_SERVICES")) {
                    int C = e.C(this);
                    new StringBuilder().append(C);
                    action = "gpservices";
                    if (C != 0) {
                        z = false;
                    }
                    intent2.putExtra(action, z);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
        intent2.putExtra("error_msg", "null intent or action.");
        setResult(-1, intent2);
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    String stringExtra = intent.getStringExtra("authAccount");
                    Intent intent2 = new Intent();
                    intent2.putExtra("error_code", 0);
                    intent2.putExtra("account", stringExtra);
                    setResult(-1, intent2);
                    finish();
                    return;
                case 2002:
                    cS(this.nzw, this.jgk);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 2001:
            case 2002:
                Intent intent3 = new Intent();
                intent3.putExtra("error_code", -1);
                intent3.putExtra("error_msg", "User Cancel.");
                setResult(i2, intent3);
                finish();
                return;
            default:
                return;
        }
    }

    private void cS(String str, String str2) {
        new a(this, this, str, str2).execute(new Void[0]);
    }
}
