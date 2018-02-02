package com.tencent.mm.modelmulti;

import com.tencent.mm.modelmulti.c.b;
import com.tencent.mm.modelmulti.c.c;
import java.util.ArrayList;

public class c$a {
    int axZ;
    long fileLenInvalidCount;
    long fwg;
    final String hEQ;
    long hER;
    long hES;
    long hET;
    ArrayList<b> hEU = new ArrayList(20);
    ArrayList<c> hEV = new ArrayList(20);
    boolean hEW = false;

    c$a(String str) {
        this.hEQ = str;
    }

    public final String toString() {
        return String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[]{Integer.valueOf(hashCode()), this.hEQ, Boolean.valueOf(this.hEW), Long.valueOf(this.hER), Long.valueOf(this.hES), Long.valueOf(this.fwg), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.hEU.size()), Integer.valueOf(this.hEV.size()), Long.valueOf(this.hET), Integer.valueOf(this.axZ)});
    }
}
