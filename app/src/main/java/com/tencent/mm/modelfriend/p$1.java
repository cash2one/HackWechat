package com.tencent.mm.modelfriend;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;

class p$1 extends m {
    final /* synthetic */ p hwm;

    p$1(p pVar) {
        this.hwm = pVar;
    }

    protected final boolean NE() {
        if (p.a(this.hwm) != null && !p.a(this.hwm).cgM()) {
            return true;
        }
        String str = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = p.a(this.hwm) == null ? "null" : Boolean.valueOf(p.a(this.hwm).cgM());
        x.w(str, str2, objArr);
        return false;
    }
}
