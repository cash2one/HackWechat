package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;

public class SoterPayTestUI extends MMActivity implements e {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        findViewById(f.uwy).setOnClickListener(new 1(this));
        findViewById(f.uvn).setOnClickListener(new 2(this));
        findViewById(f.uvo).setOnClickListener(new 3(this));
    }

    protected final int getLayoutId() {
        return g.uBY;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        u.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(kVar.getType(), this);
    }
}
