package com.google.android.exoplayer2.source.b.a;

import java.util.Collections;
import java.util.List;

public abstract class c {
    public final String auW;
    public final List<String> auX;

    protected c(String str, List<String> list) {
        this.auW = str;
        this.auX = Collections.unmodifiableList(list);
    }
}
