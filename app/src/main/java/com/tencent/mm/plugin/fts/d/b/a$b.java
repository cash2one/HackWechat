package com.tencent.mm.plugin.fts.d.b;

import com.tencent.mm.plugin.fts.a.a.e.c;

public class a$b implements Comparable<a$b> {
    public c mQh;
    public int mQi = -1;
    public int mQj = -1;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.mQi - ((a$b) obj).mQi;
    }

    public final boolean isAvailable() {
        return (this.mQi == -1 || this.mQj == -1) ? false : true;
    }

    public final String toString() {
        String str = "FTSQueryHLRequest.Item %s %d %d";
        Object[] objArr = new Object[3];
        objArr[0] = this.mQh == null ? "" : this.mQh.aMX().replaceAll("​", ",");
        objArr[1] = Integer.valueOf(this.mQi);
        objArr[2] = Integer.valueOf(this.mQj);
        return String.format(str, objArr);
    }
}
