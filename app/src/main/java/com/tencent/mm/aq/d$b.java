package com.tencent.mm.aq;

import com.tencent.mm.aq.d.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class d$b {
    private int aen = 0;
    public long hzI;
    public long hzJ;
    public int hzK;
    public int hzL;
    public List<d$c> hzM;

    public d$b(long j, long j2, int i) {
        this.hzI = j;
        this.hzJ = j2;
        this.hzK = i;
        this.hzL = 0;
    }

    public final boolean a(a aVar, Object obj) {
        if (this.hzM == null) {
            this.hzM = new LinkedList();
        }
        d$c com_tencent_mm_aq_d_c = new d$c(aVar, obj);
        if (this.hzM.contains(com_tencent_mm_aq_d_c)) {
            x.d("ModelImage.DownloadImgService.Task", "task item already exists");
            return false;
        }
        this.hzM.add(com_tencent_mm_aq_d_c);
        return true;
    }

    public final boolean b(a aVar) {
        d$c com_tencent_mm_aq_d_c = new d$c(aVar, null);
        if (!this.hzM.contains(com_tencent_mm_aq_d_c)) {
            return false;
        }
        this.hzM.remove(com_tencent_mm_aq_d_c);
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d$b)) {
            return false;
        }
        d$b com_tencent_mm_aq_d_b = (d$b) obj;
        if (com_tencent_mm_aq_d_b.hzI == this.hzI && com_tencent_mm_aq_d_b.hzJ == this.hzJ && com_tencent_mm_aq_d_b.hzK == this.hzK) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.aen == 0) {
            this.aen = (this.hzI + "_" + this.hzJ + "_" + this.hzK).hashCode();
        }
        return this.aen;
    }
}
