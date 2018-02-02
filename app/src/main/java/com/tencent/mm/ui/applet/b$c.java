package com.tencent.mm.ui.applet;

import java.util.LinkedList;

class b$c {
    private LinkedList<String> gBH;
    private int maxSize;
    final /* synthetic */ b xWc;

    public b$c(b bVar, int i) {
        this.xWc = bVar;
        this.gBH = null;
        this.maxSize = 40;
        this.gBH = new LinkedList();
    }

    final void OI(String str) {
        if (!this.gBH.contains(str)) {
            this.gBH.add(str);
            if (this.gBH.size() >= this.maxSize) {
                this.gBH.removeFirst();
            }
        }
    }

    final boolean contains(String str) {
        return this.gBH.contains(str);
    }
}
