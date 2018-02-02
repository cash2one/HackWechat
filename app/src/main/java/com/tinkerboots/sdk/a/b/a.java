package com.tinkerboots.sdk.a.b;

public class a {
    public final com.tinkerboots.sdk.a.c.a Auo;

    static class a {
        com.tinkerboots.sdk.a.c.a Auo;

        a() {
        }
    }

    private a(com.tinkerboots.sdk.a.c.a aVar) {
        this.Auo = aVar;
    }

    public static a cJo() {
        a aVar = new a();
        aVar.Auo = new com.tinkerboots.sdk.a.c.a();
        if (aVar.Auo != null) {
            return new a(aVar.Auo);
        }
        throw new RuntimeException("You need init conditions property");
    }
}
