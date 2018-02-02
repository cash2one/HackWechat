package com.tencent.mm.modelmulti;

public class c$b {
    long fileLenInvalidCount;
    long fwg;
    final String hEQ;
    long hER;
    long hES;
    boolean hEW = false;
    final int tag;

    c$b(String str, int i) {
        this.hEQ = str;
        this.tag = i;
    }

    public final String toString() {
        return String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.hEQ, Boolean.valueOf(this.hEW), Long.valueOf(this.hER), Long.valueOf(this.hES), Long.valueOf(this.fwg), Long.valueOf(this.fileLenInvalidCount)});
    }
}
