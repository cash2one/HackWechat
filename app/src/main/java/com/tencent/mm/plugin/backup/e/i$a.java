package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.er;
import java.util.LinkedList;

public class i$a {
    String filePath;
    int ftE;
    u knb;
    er kne;
    LinkedList<u> knf;
    boolean kng = true;
    String knh;
    boolean kni;

    public i$a(String str, er erVar, LinkedList<u> linkedList, int i, boolean z, boolean z2, u uVar) {
        this.filePath = str;
        this.kne = erVar;
        this.knf = linkedList;
        this.ftE = i;
        this.kng = z;
        this.kni = z2;
        this.knb = uVar;
    }

    public i$a(String str, er erVar, LinkedList<u> linkedList, int i, boolean z, String str2, boolean z2) {
        this.filePath = str;
        this.kne = erVar;
        this.knf = linkedList;
        this.ftE = i;
        this.kng = z;
        this.knh = str2;
        this.kni = z2;
        this.knb = null;
    }
}
