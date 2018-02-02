package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class f$b$1 implements a {
    final /* synthetic */ i gMv;
    final /* synthetic */ b iJi;

    f$b$1(b bVar, i iVar) {
        this.iJi = bVar;
        this.gMv = iVar;
    }

    public final void a(String str, l lVar) {
        if (this.gMv != null) {
            Parcel obtain = Parcel.obtain();
            obtain.writeString(str);
            obtain.writeInt(lVar.iYZ);
            obtain.writeString(lVar.obj == null ? null : lVar.obj.toString());
            this.gMv.as(obtain);
        }
    }
}
