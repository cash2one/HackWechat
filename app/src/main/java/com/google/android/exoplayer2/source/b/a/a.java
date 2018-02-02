package com.google.android.exoplayer2.source.b.a;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

public final class a extends c {
    public final List<Format> atc;
    public final List<a> auC;
    public final List<a> auD;
    public final List<a> auE;
    public final Format auc;

    public a(String str, List<String> list, List<a> list2, List<a> list3, List<a> list4, Format format, List<Format> list5) {
        super(str, list);
        this.auC = Collections.unmodifiableList(list2);
        this.auD = Collections.unmodifiableList(list3);
        this.auE = Collections.unmodifiableList(list4);
        this.auc = format;
        this.atc = list5 != null ? Collections.unmodifiableList(list5) : null;
    }
}
