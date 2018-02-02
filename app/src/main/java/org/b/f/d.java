package org.b.f;

import java.util.Random;

public final class d implements c {
    private a AyQ = new a();

    public final String getNonce() {
        return String.valueOf(cKq().longValue() + ((long) Integer.valueOf(new Random().nextInt()).intValue()));
    }

    public final String cKp() {
        return String.valueOf(cKq());
    }

    private static Long cKq() {
        return Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() / 1000);
    }
}
