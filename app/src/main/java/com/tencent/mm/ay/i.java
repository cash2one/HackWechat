package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.anq;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i extends b {
    private anq hIW;

    public i(List<a> list) {
        super(36);
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.hIX);
        }
        this.hIW = new anq();
        this.hIW.ksO = list.size();
        this.hIW.ksP = linkedList;
        this.ope = this.hIW;
    }
}
