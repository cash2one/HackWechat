package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.c;

class d$b implements h<Bundle, Bundle> {
    private d$b() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("Token");
        c.Bz().b(bundle.getString("Event"), new 1(this, string));
    }
}
