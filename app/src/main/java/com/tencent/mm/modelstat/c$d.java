package com.tencent.mm.modelstat;

import java.io.Serializable;
import java.util.Locale;

class c$d implements Serializable, Comparable<c$d> {
    String hQy = null;
    int left;
    long time = 0;
    int top;
    int type = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return (int) (this.time - ((c$d) obj).time);
    }

    c$d() {
    }

    public final String toString() {
        return String.format(Locale.getDefault(), "[%s,%s]", new Object[]{this.hQy, c.bq(this.time)});
    }
}
