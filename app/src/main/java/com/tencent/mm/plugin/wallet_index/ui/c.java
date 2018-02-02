package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.alc;
import java.util.ArrayList;
import java.util.List;

public final class c {
    String lyH = null;
    public int mCount = 1;
    int pcE;
    public String taG = null;
    public ArrayList<String> taJ = new ArrayList();
    public ArrayList<String> taK = new ArrayList();
    public String taL = null;
    public int taM = 0;
    List<String> taN = new ArrayList();
    boolean taO = false;
    public String taP;
    public String taQ;
    public String taj = null;
    public String tak = null;
    public alb tao;
    public alc tap;

    public final boolean bNn() {
        return this.pcE == 2;
    }

    public final k a(com.tencent.mm.plugin.wallet_index.b.a.c cVar, boolean z) {
        int i = z ? 2 : 1;
        if (!this.taO) {
            return new com.tencent.mm.wallet_core.c.k(cVar.lyH, i, this.pcE, this.mCount, cVar.tah, cVar.tai, cVar.rLk, cVar.taj, cVar.tak);
        }
        if (!bNn()) {
            this.tao.wsm = cVar.rLk;
            this.tao.wsj = cVar.tah;
            this.tao.pbN = cVar.tak;
            this.tao.wil = cVar.taj;
            this.tao.pek = cVar.lyH;
            this.tao.wsl = cVar.tai;
        }
        return new g(this.pcE, i, cVar.lyH, this.tap, this.tao);
    }
}
