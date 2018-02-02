package com.tencent.mm.plugin.soter_mp.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.plugin.soter_mp.a.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

@a(7)
public class SoterAuthenticationUI extends MMActivity {
    public static a rTq = null;
    private String appId = null;
    private int fromScene = -1;
    private r jmO = null;
    private c rTp = null;

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.jmO == null || !soterAuthenticationUI.jmO.isShowing()) {
            soterAuthenticationUI.jmO = h.a((Context) soterAuthenticationUI, soterAuthenticationUI.getString(R.l.dHc), false, null);
        }
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI, e eVar) {
        soterAuthenticationUI.setResult(-1, b(eVar));
        soterAuthenticationUI.c(eVar);
        soterAuthenticationUI.finish();
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.jmO != null && soterAuthenticationUI.jmO.isShowing()) {
            soterAuthenticationUI.jmO.dismiss();
        }
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI, e eVar) {
        eVar.errCode = 90008;
        eVar.fnL = "user cancelled the authentication process";
        soterAuthenticationUI.setResult(0, b(eVar));
        soterAuthenticationUI.c(eVar);
        soterAuthenticationUI.finish();
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        if (rTq != null) {
            a.a(rTq);
        }
        rTq = new a(this, (byte) 0);
        d dVar = new d();
        e eVar = new e();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (bh.ov(stringExtra)) {
            x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            eVar.errCode = 90003;
            eVar.fnL = "authen mode is null";
        } else {
            try {
                dVar.rTm = Byte.parseByte(bh.az(stringExtra.substring(2), "00"), 16);
                dVar.mzI = getIntent().getStringExtra("challenge");
                dVar.content = getIntent().getStringExtra("auth_content");
                if (!com.tencent.mm.plugin.soter.c.h.bCT()) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    eVar.errCode = 90001;
                    eVar.fnL = "not support soter";
                } else if (dVar.rTm <= (byte) 0) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    eVar.errCode = 90003;
                    eVar.fnL = "resp model error";
                } else if (bh.ov(dVar.mzI)) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    eVar.errCode = 90004;
                    eVar.fnL = "challenge is null";
                } else if (dVar.mzI.length() >= WXMediaMessage.TITLE_LENGTH_LIMIT) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    eVar.errCode = 90004;
                    eVar.fnL = "challenge is too long. 512 chars at most";
                } else if (bh.ov(dVar.content)) {
                    dVar.content = getString(R.l.ePY);
                } else if (dVar.content.length() > 42) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    dVar.content = getString(R.l.ePY);
                }
            } catch (NumberFormatException e) {
                x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                eVar.errCode = 90003;
                eVar.fnL = "authen mode is illegal: number format error. found: " + stringExtra;
                if (eVar.errCode != 0) {
                    i = com.tencent.mm.plugin.soter_mp.a.a.rSU;
                    this.rTp = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
                    if (this.rTp == null) {
                        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                        this.appId = getIntent().getStringExtra("key_app_id");
                        this.rTp.cR();
                    }
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    eVar.errCode = 90003;
                    eVar.fnL = "no corresponding mode";
                    a(eVar);
                    return;
                }
                a(eVar);
                return;
            } catch (IndexOutOfBoundsException e2) {
                x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                eVar.errCode = 90003;
                eVar.fnL = "authen mode is illegal: number format error. found: " + stringExtra;
                if (eVar.errCode != 0) {
                    a(eVar);
                    return;
                }
                i = com.tencent.mm.plugin.soter_mp.a.a.rSU;
                this.rTp = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
                if (this.rTp == null) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    eVar.errCode = 90003;
                    eVar.fnL = "no corresponding mode";
                    a(eVar);
                    return;
                }
                this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                this.appId = getIntent().getStringExtra("key_app_id");
                this.rTp.cR();
            }
        }
        if (eVar.errCode != 0) {
            a(eVar);
            return;
        }
        i = com.tencent.mm.plugin.soter_mp.a.a.rSU;
        this.rTp = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
        if (this.rTp == null) {
            x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            eVar.errCode = 90003;
            eVar.fnL = "no corresponding mode";
            a(eVar);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        this.appId = getIntent().getStringExtra("key_app_id");
        this.rTp.cR();
    }

    protected void onResume() {
        super.onResume();
        if (this.rTp != null) {
            this.rTp.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.rTp != null) {
            this.rTp.onPause();
        }
    }

    private void a(e eVar) {
        setResult(1, b(eVar));
        c(eVar);
        finish();
    }

    private static Intent b(e eVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", eVar.errCode);
        bundle.putString("err_msg", eVar.fnL);
        bundle.putByte("use_mode", eVar.rTn);
        bundle.putString("result_json", eVar.fGm);
        bundle.putString("result_json_signature", eVar.rTo);
        x.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[]{bundle.toString()});
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    private void c(e eVar) {
        if (eVar != null && this.fromScene == 0) {
            int i = -1;
            switch (eVar.errCode) {
                case 0:
                    i = 0;
                    break;
                case 90001:
                case 90002:
                case 90003:
                case 90004:
                case 90006:
                case 90007:
                case 90011:
                    i = 2;
                    break;
                case 90008:
                case 90009:
                case 90010:
                    i = 3;
                    break;
            }
            g gVar = g.rSo;
            g.n("requireSoterBiometricAuthentication", this.appId, i, eVar.errCode);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.rTp != null) {
            this.rTp.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        a.a(rTq);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
