package com.tencent.mm.plugin.collect.b;

import java.util.LinkedList;
import java.util.List;

public enum d {
    ;
    
    public List<a> kIv;

    private d(String str) {
        this.kIv = new LinkedList();
    }

    public final void a(t tVar) {
        for (a aVar : this.kIv) {
            if (aVar != null) {
                aVar.b(tVar);
            }
        }
    }
}
