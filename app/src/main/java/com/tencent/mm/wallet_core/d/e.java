package com.tencent.mm.wallet_core.d;

import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.ui.MMActivity;

public abstract class e {
    public MMActivity zHU;
    public g zHV;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public abstract boolean k(Object... objArr);

    public e(MMActivity mMActivity, g gVar) {
        this.zHU = mMActivity;
        this.zHV = gVar;
    }

    public CharSequence um(int i) {
        return null;
    }

    public boolean p(Object... objArr) {
        return false;
    }

    public boolean q(Object... objArr) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
