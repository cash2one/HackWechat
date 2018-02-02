package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;

class j$1 extends m {
    final /* synthetic */ j nGP;

    j$1(j jVar) {
        this.nGP = jVar;
    }

    protected final boolean NE() {
        if (j.a(this.nGP) != null && !j.a(this.nGP).cgM()) {
            return true;
        }
        String str = "MicroMsg.IPCallPopularCountryStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = j.a(this.nGP) == null ? "null" : Boolean.valueOf(j.a(this.nGP).cgM());
        x.w(str, str2, objArr);
        return false;
    }
}
