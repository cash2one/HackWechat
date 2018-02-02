package com.tencent.mm.modelsns;

public final class d {
    StringBuffer hOS = new StringBuffer();
    StringBuffer hOT = new StringBuffer();
    private int index = 0;

    public final void p(String str, Object obj) {
        this.hOS.append(this.index + " " + str + "->" + obj + "\n");
        this.hOT.append(obj);
        this.index++;
    }

    public final void q(String str, Object obj) {
        this.hOS.append(str + "->" + obj + "\n");
        this.hOT.append(obj);
    }

    public final String toString() {
        return this.hOT.toString();
    }

    public final String Sz() {
        this.index = 0;
        this.hOS.append("--end--\n\n");
        return this.hOS.toString();
    }
}
