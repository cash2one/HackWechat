package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class v$a {
    private final List<String> aOM;
    private final Object aON;

    private v$a(Object obj) {
        this.aON = w.ag(obj);
        this.aOM = new ArrayList();
    }

    public final v$a g(String str, Object obj) {
        this.aOM.add(((String) w.ag(str)) + "=" + String.valueOf(obj));
        return this;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(100).append(this.aON.getClass().getSimpleName()).append('{');
        int size = this.aOM.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.aOM.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
