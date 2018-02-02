package com.tencent.mm.aq;

import com.tencent.mm.aq.d.a;

class d$c {
    a hzN;
    Object hzO;

    public d$c(a aVar, Object obj) {
        this.hzN = aVar;
        this.hzO = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d$c)) {
            return false;
        }
        if (this.hzN == ((d$c) obj).hzN) {
            return true;
        }
        return false;
    }
}
