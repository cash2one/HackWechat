package com.tencent.mm.plugin.ae;

import android.util.SparseArray;

public enum c {
    ;
    
    public final SparseArray<b> qsR;

    private c(String str) {
        this.qsR = new SparseArray();
    }

    public final boolean a(b bVar) {
        this.qsR.put(bVar.getType(), bVar);
        return true;
    }
}
