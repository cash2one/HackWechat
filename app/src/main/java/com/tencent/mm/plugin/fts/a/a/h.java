package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public final class h {
    public int bjW;
    public g mJc;
    public a mMa;
    public e mMb;
    public List<j> mMc = new ArrayList();

    public h(g gVar) {
        this.mJc = gVar;
    }

    public final String toString() {
        int i = 0;
        String str = "{resultCode: %d, resultSize: %d}";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.bjW);
        if (this.mMc != null) {
            i = this.mMc.size();
        }
        objArr[1] = Integer.valueOf(i);
        return String.format(str, objArr);
    }
}
