package com.tencent.mm.plugin.sns.model;

import java.util.Comparator;
import java.util.Map.Entry;

class ak$1 implements Comparator<Entry<K, ak$b<O>>> {
    final /* synthetic */ ak qXb;

    ak$1(ak akVar) {
        this.qXb = akVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((ak$b) ((Entry) obj).getValue()).qXc.compareTo(((ak$b) ((Entry) obj2).getValue()).qXc);
    }
}
