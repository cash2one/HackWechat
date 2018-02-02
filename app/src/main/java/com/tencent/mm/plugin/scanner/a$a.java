package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.l;
import java.util.Iterator;
import java.util.Set;

class a$a implements l {
    private a$a() {
    }

    public final Bundle j(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Set boz = a.boz();
        StringBuilder stringBuilder = new StringBuilder();
        if (!(boz == null || boz.isEmpty())) {
            Iterator it = boz.iterator();
            stringBuilder.append((String) it.next());
            while (it.hasNext()) {
                stringBuilder.append("|");
                stringBuilder.append((String) it.next());
            }
            bundle2.putString("wxCodePrefix", stringBuilder.toString());
        }
        return bundle2;
    }
}
