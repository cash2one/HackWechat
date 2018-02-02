package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ak;

public final class f {
    public int luM;
    public so luN;
    public sf luO;
    public int luP;
    public String luQ;
    public boolean luR;
    public boolean luS = true;
    public boolean luT = false;
    public int mStatus;
    public int sm;

    public f(so soVar) {
        this.luN = soVar;
        this.luM = a.luU;
    }

    public f(sf sfVar) {
        this.luO = sfVar;
        this.luM = a.luV;
    }

    public final void eQ(int i) {
        if (i == 7 && this.mStatus == 6 && this.luS) {
            this.luR = true;
        }
        this.mStatus = i;
    }

    public final void a(boolean z, ak akVar, boolean z2) {
        so soVar = this.luN;
        if (soVar != null) {
            if (z2) {
                eQ(7);
                return;
            }
            boolean a = e.a(soVar);
            boolean b = e.b(soVar);
            boolean co = soVar == null ? false : e.co(soVar.waw, 8);
            boolean isEmpty = TextUtils.isEmpty(soVar.wau);
            if (!co || !b) {
                if (!a) {
                    if (!b && (z || !isEmpty)) {
                        this.luP = 1;
                        if (z && akVar != null) {
                            switch (akVar.xyD) {
                                case 11:
                                    eQ(11);
                                    break;
                                case 12:
                                    eQ(4);
                                    break;
                                default:
                                    if (!(akVar.xyB == 7 || akVar.xyB == 6 || akVar.xyB == 3)) {
                                        eQ(10);
                                        break;
                                    }
                            }
                        } else if (z) {
                            eQ(11);
                        } else {
                            eQ(4);
                        }
                    } else {
                        eQ(3);
                        this.luP = 0;
                    }
                } else {
                    eQ(3);
                    if (b || (!z && isEmpty)) {
                        this.luP = 0;
                    } else {
                        this.luP = 1;
                    }
                }
            } else {
                eQ(8);
            }
            if (z && akVar != null && !bh.ov(akVar.xyF)) {
                this.luN.wau = akVar.xyF;
            }
        }
    }
}
