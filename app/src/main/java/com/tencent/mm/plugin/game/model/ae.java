package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.c.bx;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.d.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae extends ad {
    private int mType = 0;
    public bx ndq;
    public LinkedList<d> ndr;
    private int nds = 0;

    public ae(a aVar, int i, int i2) {
        if (aVar == null) {
            this.ndq = new bx();
            return;
        }
        this.ndq = (bx) aVar;
        this.mType = i;
        this.nds = i2;
        LinkedList linkedList = new LinkedList();
        if (this.ndq.niN != null) {
            int i3 = this.nds + 1;
            Iterator it = this.ndq.niN.iterator();
            int i4 = i3;
            while (it.hasNext()) {
                d a = a((e) it.next());
                if (a != null) {
                    switch (this.mType) {
                        case 1:
                            a.scene = 16;
                            a.fFj = 1601;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        case 2:
                            a.scene = 15;
                            a.fFj = 1501;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        default:
                            i3 = i4;
                            break;
                    }
                    linkedList.add(a);
                    i4 = i3;
                }
            }
        }
        this.ndr = linkedList;
        d.U(this.ndr);
    }
}
