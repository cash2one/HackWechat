package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.bjk;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public ConcurrentHashMap<String, CharSequence> qQQ = new ConcurrentHashMap();

    public final void a(bjk com_tencent_mm_protocal_c_bjk, CharSequence charSequence) {
        this.qQQ.put(com_tencent_mm_protocal_c_bjk.wMw + "-" + com_tencent_mm_protocal_c_bjk.wMz + "-" + com_tencent_mm_protocal_c_bjk.nje, charSequence);
    }
}
