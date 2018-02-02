package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.q;

@a(3)
public class FaceTransparentStubUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
        Bundle bundleExtra = getIntent().getBundleExtra("KEY_EXTRAS");
        if (!bundleExtra.containsKey("k_user_name")) {
            g.Dh();
            if (com.tencent.mm.kernel.a.Cx()) {
                bundleExtra.putString("k_user_name", q.FV());
            }
        }
        b nmVar = new nm();
        nmVar.fFA.context = this;
        nmVar.fFA.fFC = intExtra;
        nmVar.fFA.extras = bundleExtra;
        com.tencent.mm.sdk.b.a.xef.m(nmVar);
        x.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", new Object[]{Boolean.valueOf(nmVar.fFB.fFD)});
        if (!nmVar.fFB.fFD) {
            if (nmVar.fFB.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(nmVar.fFB.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
        setResult(i2, intent);
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
