package com.tencent.mm.plugin.fts.a.b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public final class b {
    private HashSet<String> mMu = new HashSet();
    public c mMv = new c(' ');

    public final void Bi(String str) {
        if (this.mMu.add(str)) {
            c cVar = this.mMv;
            char[] toCharArray = str.toLowerCase().toCharArray();
            for (int i = 0; i < toCharArray.length; i++) {
                int i2 = toCharArray[i] - 97;
                if (cVar.mMw[i2] == null) {
                    cVar.mMw[i2] = new c(toCharArray[i]);
                }
                cVar = cVar.mMw[i2];
            }
            cVar.mMt = true;
        }
    }

    public final List<List<String>> Bj(String str) {
        Queue arrayDeque = new ArrayDeque();
        arrayDeque.offer(new a(0, 0, null));
        char[] toCharArray = str.toLowerCase().toCharArray();
        List<List<String>> arrayList = new ArrayList();
        while (!arrayDeque.isEmpty()) {
            a aVar = (a) arrayDeque.poll();
            if (aVar == null) {
                break;
            }
            int i = aVar.end;
            c cVar = this.mMv;
            while (i < toCharArray.length) {
                int i2 = toCharArray[i] - 97;
                if (cVar.mMw[i2] == null) {
                    break;
                }
                cVar = cVar.mMw[i2];
                if (cVar.mMt || i == toCharArray.length - 1) {
                    if (aVar.ayR == null) {
                        aVar.ayR = new ArrayList();
                    }
                    a aVar2 = new a(aVar.end, i + 1, aVar);
                    aVar.ayR.add(aVar2);
                    if (aVar2.end == toCharArray.length) {
                        aVar2.mMt = true;
                    }
                    arrayDeque.offer(aVar2);
                }
                i++;
            }
            if (aVar.mMt) {
                List arrayList2 = new ArrayList();
                while (aVar != null) {
                    if (aVar.end > aVar.start) {
                        arrayList2.add(str.substring(aVar.start, aVar.end));
                    }
                    aVar = aVar.mMs;
                }
                Collections.reverse(arrayList2);
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }
}
