package com.google.android.exoplayer2.c.c;

import java.util.Collections;
import java.util.List;

public final class u$b {
    public final String ael;
    public final List<u$a> apg;
    public final byte[] aph;
    public final int streamType;

    public u$b(int i, String str, List<u$a> list, byte[] bArr) {
        List emptyList;
        this.streamType = i;
        this.ael = str;
        if (list == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = Collections.unmodifiableList(list);
        }
        this.apg = emptyList;
        this.aph = bArr;
    }
}
