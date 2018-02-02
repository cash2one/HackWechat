package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.aqr;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public String hKZ;
    public List<aqr> list = new LinkedList();
    public int qQR;

    public e(aqr com_tencent_mm_protocal_c_aqr) {
        this.list.add(com_tencent_mm_protocal_c_aqr);
    }

    public e(List<aqr> list) {
        this.list = list;
    }
}
