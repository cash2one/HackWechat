package com.tencent.mm.plugin.hce.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.plugin.nfc.HCEService;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@a(7)
public class HCETransparentUI extends MMActivity {
    private boolean nAm = false;
    private boolean nAn = false;
    private i nAo = null;
    private ProgressDialog nAp = null;
    private boolean nAq = false;
    private int nAr = 0;
    private Timer nAs;
    private TimerTask nAt;

    static /* synthetic */ void c(HCETransparentUI hCETransparentUI) {
        hCETransparentUI.dismissDialog();
        if (hCETransparentUI.nAs != null) {
            hCETransparentUI.nAs.cancel();
        }
    }

    protected final int getLayoutId() {
        return R.i.dlC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
        if (this.nAq) {
            this.nAt = new 1(this);
            this.nAs = new Timer();
            this.nAs.scheduleAtFixedRate(this.nAt, 0, 300);
            this.nAp = h.a(this, getString(R.l.dHc), false, null);
            return;
        }
        aSu();
    }

    private void aSu() {
        if (!b.aSs()) {
            ao(13000, "not support NFC");
        } else if (!b.aSr()) {
            ao(13002, "not support HCE");
        } else if (b.aSt()) {
            fL(true);
        } else if (this.nAm) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo has shown open NFC dialog");
            k(13001, "system NFC switch not opened", getString(R.l.epc));
        } else {
            boolean z;
            i.a aVar = new i.a(this);
            aVar.EA(R.l.epe).EC(R.l.est).a(new 2(this));
            List queryIntentActivities = getPackageManager().queryIntentActivities(new Intent("android.settings.NFC_SETTINGS"), 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                x.e("MicroMsg.HCETransparentUI", "alvinluo Cannot jump to NFC setting");
                z = false;
            } else {
                x.i("MicroMsg.HCETransparentUI", "alvinluo NFC activity not null, activities size: " + queryIntentActivities.size());
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    x.i("MicroMsg.HCETransparentUI", "alvinluo NFC activity: %s", new Object[]{((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name});
                }
                z = true;
            }
            if (z) {
                aVar.ED(R.l.dEn).b(new OnClickListener(this) {
                    final /* synthetic */ HCETransparentUI nAu;

                    {
                        this.nAu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.HCETransparentUI", "alvinluo user click cancel button of NFC tips dialog.");
                        this.nAu.ap(13001, "system NFC switch not opened");
                    }
                });
            } else {
                aVar.EC(R.l.dFU);
            }
            aVar.d(new 4(this));
            this.nAo = aVar.akx();
            this.nAo.setCanceledOnTouchOutside(false);
            this.nAo.show();
            this.nAm = true;
        }
    }

    private void k(int i, String str, String str2) {
        dismissDialog();
        this.nAo = h.a(this, str2, "", getString(R.l.dFU), new 5(this, i, str));
    }

    private void dismissDialog() {
        if (this.nAo != null && this.nAo.isShowing()) {
            this.nAo.dismiss();
            this.nAo = null;
        }
        if (this.nAp != null) {
            this.nAp.dismiss();
            this.nAp = null;
        }
    }

    private void ao(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("errCode", i);
        intent.putExtra("errMsg", str);
        setResult(1, intent);
    }

    @TargetApi(19)
    private void fL(boolean z) {
        CardEmulation instance = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this));
        ComponentName componentName = new ComponentName(this, HCEService.class.getCanonicalName());
        x.i("MicroMsg.HCETransparentUI", "alvinluo component name: " + componentName);
        if (instance.isDefaultServiceForCategory(componentName, "payment")) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo now is NFC Default Application");
            ap(0, "NFC switch has opened and now is NFC default application");
            return;
        }
        x.i("MicroMsg.HCETransparentUI", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[]{Boolean.valueOf(true)});
        x.i("MicroMsg.HCETransparentUI", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[]{Boolean.valueOf(this.nAn)});
        if (this.nAn) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo has request set default NFC application");
            k(13004, "not set default NFC application", getString(R.l.epd));
            return;
        }
        ag.h(new 6(this, componentName), 200);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
            this.nAq = true;
        } else if (i == 2) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
        }
    }

    private void ap(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("errCode", i);
        intent.putExtra("errMsg", str);
        setResult(-1, intent);
        finish();
    }

    protected void onPause() {
        super.onPause();
        dismissDialog();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
