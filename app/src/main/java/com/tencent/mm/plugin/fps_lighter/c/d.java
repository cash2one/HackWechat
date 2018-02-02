package com.tencent.mm.plugin.fps_lighter.c;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public final class d {
    public int axZ;
    public int hTi;
    public List<String> mBA;
    public long mBB;
    public a mBC;
    public Stack<Long> mBD = new Stack();
    public long mBs;
    public boolean mBt;
    public long mBu;
    public long mBv;
    public List<String> mBz;

    public d(a aVar, c cVar) {
        this.mBz = cVar.mBz;
        this.mBA = cVar.mBA;
        this.mBu = cVar.mBu;
        this.mBv = cVar.mBv;
        this.mBB = cVar.mBB;
        this.axZ = cVar.axZ;
        this.hTi = cVar.hTi;
        this.mBC = aVar;
        this.mBs = aVar.mBs;
        this.mBt = aVar.mBt;
    }

    public final void dt(long j) {
        this.mBD.push(Long.valueOf(j));
    }

    public final void a(Stack<Long> stack) {
        this.mBD.clear();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            this.mBD.push(Long.valueOf(((Long) it.next()).longValue()));
        }
    }

    public final String aKR() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mBv);
        stringBuilder.append(" > ");
        ListIterator listIterator = this.mBD.listIterator(this.mBD.size());
        while (listIterator.hasPrevious()) {
            stringBuilder.append(listIterator.previous());
            stringBuilder.append(" > ");
        }
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        return stringBuilder.toString();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("\t");
        stringBuilder.append("scene:");
        stringBuilder.append(this.mBC.scene);
        stringBuilder.append(" ");
        stringBuilder.append("preMs:");
        stringBuilder.append(this.mBC.mBn);
        stringBuilder.append(" ");
        stringBuilder.append("dropCount:");
        stringBuilder.append(this.mBC.mBp);
        stringBuilder.append(" ");
        stringBuilder.append("dropTime:");
        stringBuilder.append(this.mBC.aKP());
        stringBuilder.append(" ");
        stringBuilder.append("cpu:");
        stringBuilder.append(this.mBC.mBq + "%");
        stringBuilder.append(" ");
        stringBuilder.append("isOnCreate:");
        stringBuilder.append(this.mBC.mBo);
        stringBuilder.append(" ");
        stringBuilder.append("methodId:");
        stringBuilder.append(this.mBv);
        stringBuilder.append(" ");
        stringBuilder.append("costTime:");
        stringBuilder.append(this.mBB);
        stringBuilder.append(" ");
        stringBuilder.append("percent:");
        stringBuilder.append(Math.round(((((double) this.mBB) * 1.0d) / ((double) this.mBC.aKP())) * 100.0d) + "%");
        stringBuilder.append(" ");
        stringBuilder.append("exec num:");
        stringBuilder.append(this.hTi);
        stringBuilder.append(" ");
        stringBuilder.append("inputHandlingTime:");
        stringBuilder.append(this.mBs);
        stringBuilder.append(" ");
        stringBuilder.append("isInputHandling:");
        stringBuilder.append(this.mBt);
        stringBuilder.append(" ");
        stringBuilder.append("stack:");
        stringBuilder.append(aKR());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.mBv == this.mBv && this.mBD.size() == dVar.mBD.size()) {
                int i = 0;
                while (i < this.mBD.size() && this.mBD.elementAt(i) == dVar.mBD.elementAt(i)) {
                    i++;
                }
            }
        }
        return false;
    }
}
