package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.m.d;
import com.google.android.gms.common.api.m.i;
import java.util.Map;

class m$e extends i {
    final /* synthetic */ m aLb;
    private final Map<b, d> aLk;

    public m$e(m mVar, Map<b, d> map) {
        this.aLb = mVar;
        super(mVar, (byte) 0);
        this.aLk = map;
    }

    public final void oj() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        for (b bVar : this.aLk.keySet()) {
            if (!bVar.nW()) {
                i = 0;
                i4 = i5;
            } else if (((d) this.aLk.get(bVar)).aLj == 0) {
                i = 1;
                break;
            } else {
                i = i4;
                i4 = 1;
            }
            i5 = i4;
            i4 = i;
        }
        i2 = i5;
        i = 0;
        if (i2 != 0) {
            i3 = com.google.android.gms.common.b.C(this.aLb.mContext);
        }
        if (i3 == 0 || (r0 == 0 && i4 == 0)) {
            if (this.aLb.aKT) {
                this.aLb.aKR.connect();
            }
            for (b bVar2 : this.aLk.keySet()) {
                c$e com_google_android_gms_common_api_c_e = (c$e) this.aLk.get(bVar2);
                if (!bVar2.nW() || i3 == 0) {
                    bVar2.a(com_google_android_gms_common_api_c_e);
                } else {
                    this.aLb.aKH.a(new 2(this, this.aLb, com_google_android_gms_common_api_c_e));
                }
            }
            return;
        }
        this.aLb.aKH.a(new 1(this, this.aLb, new ConnectionResult(i3, null)));
    }
}
