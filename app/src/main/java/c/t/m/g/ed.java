package c.t.m.g;

import java.util.Iterator;

public final class ed {
    private final String a;

    ed(String str) {
        this.a = str;
    }

    final StringBuilder a(StringBuilder stringBuilder, Iterator<?> it) {
        Object next;
        if (it.hasNext()) {
            next = it.next();
            if (next != null) {
                stringBuilder.append(next.toString());
            }
        }
        while (it.hasNext()) {
            next = it.next();
            if (next != null) {
                stringBuilder.append(this.a);
                stringBuilder.append(next.toString());
            }
        }
        return stringBuilder;
    }
}
