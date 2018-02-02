package com.google.android.gms.c;

import com.google.android.gms.c.b.a;

public final class at {
    public static a a(a aVar) {
        a aVar2 = new a();
        aVar2.type = aVar.type;
        aVar2.aWk = (int[]) aVar.aWk.clone();
        if (aVar.aWl) {
            aVar2.aWl = aVar.aWl;
        }
        return aVar2;
    }
}
