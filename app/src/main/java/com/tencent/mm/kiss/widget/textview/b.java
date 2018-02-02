package com.tencent.mm.kiss.widget.textview;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public ConcurrentHashMap<String, LinkedList<f>> gTi = new ConcurrentHashMap();

    public final synchronized void a(f fVar) {
        if (fVar != null) {
            if (fVar.gTM != null) {
                LinkedList linkedList = (LinkedList) this.gTi.get(fVar.gTM.toString());
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(fVar);
                this.gTi.put(fVar.gTM.toString(), linkedList);
            }
        }
    }

    public final synchronized f n(CharSequence charSequence) {
        f fVar;
        LinkedList linkedList = (LinkedList) this.gTi.get(charSequence.toString());
        if (linkedList == null || linkedList.size() == 0) {
            fVar = null;
        } else {
            fVar = (f) linkedList.removeFirst();
        }
        return fVar;
    }
}
