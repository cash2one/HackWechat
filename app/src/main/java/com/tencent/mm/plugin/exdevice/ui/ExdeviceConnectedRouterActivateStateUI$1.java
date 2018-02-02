package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectedRouterActivateStateUI$1 implements b<a> {
    final /* synthetic */ ExdeviceConnectedRouterActivateStateUI lUd;

    ExdeviceConnectedRouterActivateStateUI$1(ExdeviceConnectedRouterActivateStateUI exdeviceConnectedRouterActivateStateUI) {
        this.lUd = exdeviceConnectedRouterActivateStateUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        try {
            x.d("MicroMsg.ConnectedRouterActivateStateUi", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (this.lUd.isFinishing()) {
                x.i("MicroMsg.ConnectedRouterActivateStateUi", "ExdeviceConnectedRouter destroyed.");
            } else {
                this.lUd.runOnUiThread(new 1(this, i2, i));
            }
        } catch (Exception e) {
            x.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
    }
}
