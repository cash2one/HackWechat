package com.tinkerboots.sdk.a;

import com.tinkerboots.sdk.a.a.b;

public final class a {
    private static volatile a Auk;
    public b Auj;
    public long Aul = 10800000;
    public final com.tinkerboots.sdk.a.b.a Aum = com.tinkerboots.sdk.a.b.a.cJo();
    public boolean Aun;

    private a(b bVar) {
        this.Auj = bVar;
    }

    public static a a(b bVar) {
        if (Auk != null) {
            throw new RuntimeException("tinker server client is already init");
        }
        if (Auk == null) {
            synchronized (com.tinkerboots.sdk.a.b.a.class) {
                if (Auk == null) {
                    Auk = new a(bVar);
                }
            }
        }
        return Auk;
    }
}
