package com.tencent.mm.plugin.nfc.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.plugin.nfc.HCEService;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class HceTestUI extends MMActivity {
    private Button oSa;
    private Button oSb;
    private Intent oSc;

    static /* synthetic */ void a(HceTestUI hceTestUI) {
        if (b.aSs()) {
            Intent intent = new Intent("android.settings.NFC_SETTINGS");
            List queryIntentActivities = hceTestUI.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                Toast.makeText(hceTestUI, "Cannot jump to NFC setting", 0).show();
                return;
            } else {
                hceTestUI.startActivityForResult(intent, 0);
                return;
            }
        }
        Toast.makeText(hceTestUI, "not support nfc", 0).show();
    }

    static /* synthetic */ void b(HceTestUI hceTestUI) {
        if (!b.aSs()) {
            Toast.makeText(hceTestUI, "not support nfc", 0).show();
        } else if (b.aSr()) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(hceTestUI);
            if (defaultAdapter != null) {
                CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
                Parcelable componentName = new ComponentName(hceTestUI, HCEService.class.getCanonicalName());
                new StringBuilder("alvinluo component name: ").append(componentName);
                if (!instance.isDefaultServiceForCategory(componentName, "payment")) {
                    Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
                    intent.putExtra("category", "payment");
                    intent.putExtra("component", componentName);
                    hceTestUI.startActivityForResult(intent, 1);
                }
            }
        } else {
            Toast.makeText(hceTestUI, "not support nfc", 0).show();
        }
    }

    protected final int getLayoutId() {
        return R.i.dlB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b.aSr()) {
            this.oSc = new Intent(this, HCEService.class);
            startService(this.oSc);
        }
        this.oSa = (Button) findViewById(R.h.cPg);
        this.oSb = (Button) findViewById(R.h.cLG);
        this.oSa.setOnClickListener(new 1(this));
        this.oSb.setOnClickListener(new 2(this));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ HceTestUI oSd;

            {
                this.oSd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oSd.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oSc != null) {
            stopService(this.oSc);
        }
    }
}
