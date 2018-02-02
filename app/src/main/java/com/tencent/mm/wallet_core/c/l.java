package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;

public abstract class l extends k implements com.tencent.mm.network.k {
    public String gOs = "";
    public int irz = 0;
    private int lJX = 0;
    public long mgu = 0;
    private long tau;
    public Bundle vf;

    public abstract void e(int i, int i2, String str, q qVar);

    public int aXh() {
        return -1;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis() - this.tau;
        String str2 = "";
        String str3 = "";
        this.lJX = aXh();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.vf != null) {
            str2 = this.vf.getString("key_TransId");
            str3 = this.vf.getString("key_reqKey");
            if (this.mgu == 0) {
                this.mgu = this.vf.getLong("key_SessionId", 0);
            }
            if (this.irz == 0) {
                this.irz = this.vf.getInt("key_scene");
            }
        }
        g.pQN.h(11170, new Object[]{Integer.valueOf(getType()), Integer.valueOf(this.lJX), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(an.getNetType(ac.getContext())), this.gOs, str2, str3, Long.valueOf(this.mgu), Long.valueOf(currentTimeMillis2)});
        p.a(getType(), aXh(), i2, i3, currentTimeMillis, this.irz, this.gOs);
        e(i2, i3, str, qVar);
    }

    public final int a(e eVar, q qVar, com.tencent.mm.network.k kVar) {
        this.tau = System.currentTimeMillis();
        return super.a(eVar, qVar, kVar);
    }
}
