package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

class c$f {
    String content;
    long fqm;
    long hVE;
    final /* synthetic */ c mNG;
    int mNN;
    int mNO;
    String mNP;
    String mNQ;
    int msgType;
    String talker;

    private c$f(c cVar) {
        this.mNG = cVar;
    }

    public final boolean aNc() {
        return (this.msgType & 65535) == 49;
    }

    public final boolean aNd() {
        return this.msgType == 1;
    }

    public final boolean aNe() {
        return this.msgType == 48;
    }

    public final void aNf() {
        if (aNd()) {
            this.mNN = 41;
            if (s.eV(this.talker)) {
                this.mNP = ba.hQ(this.content);
            } else {
                this.mNP = this.content;
            }
        } else if (aNc()) {
            a fT = a.fT(this.content);
            if (fT != null) {
                switch (fT.type) {
                    case 3:
                    case 4:
                    case 5:
                    case 8:
                    case 10:
                    case 13:
                    case 15:
                    case 16:
                    case 20:
                    case 25:
                        this.mNP = bh.az(fT.getTitle(), "");
                        this.mNN = 43;
                        break;
                    case 6:
                        this.mNP = bh.az(fT.getTitle(), "");
                        this.mNN = 42;
                        break;
                    case 19:
                        this.mNP = bh.az(fT.getDescription(), "");
                        if (this.mNP != null) {
                            this.mNP = this.mNP.replace(":", "​");
                        }
                        this.mNN = 44;
                        break;
                    case 24:
                        this.mNP = bh.az(fT.getDescription(), "");
                        if (this.mNP != null) {
                            this.mNP = this.mNP.replace(":", "​");
                        }
                        this.mNN = 49;
                        break;
                    case 33:
                        this.mNP = bh.az(fT.getTitle(), "");
                        this.mNN = 48;
                        break;
                    case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                        this.mNP = bh.az(fT.title, "") + "​" + bh.az(fT.description, "");
                        this.mNN = 45;
                        break;
                    case 2001:
                        if (!"1001".equals(fT.hcG)) {
                            if ("1002".equals(fT.hcG)) {
                                this.mNN = 46;
                                if (this.mNO != 1) {
                                    this.mNP = bh.az(fT.hcE, "") + "​" + bh.az(fT.hcA, "");
                                    break;
                                } else {
                                    this.mNP = bh.az(fT.hcE, "") + "​" + bh.az(fT.hcB, "");
                                    break;
                                }
                            }
                        }
                        this.mNN = 47;
                        if (this.mNO != 1) {
                            this.mNP = bh.az(fT.hcE, "") + "​" + bh.az(fT.hcA, "");
                            break;
                        } else {
                            this.mNP = bh.az(fT.hcE, "") + "​" + bh.az(fT.hcB, "");
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } else if (aNe()) {
            String hQ;
            this.mNN = 50;
            if (s.eV(this.talker)) {
                hQ = ba.hQ(this.content);
            } else {
                hQ = this.content;
            }
            b EL = ((h) g.h(h.class)).aZi().EL(hQ);
            if (EL.cjH()) {
                this.mNP = EL.nTe + "​" + EL.label;
            } else {
                this.mNP = EL.label;
            }
        }
        if (!bh.ov(this.mNP)) {
            this.mNP = d.Bc(this.mNP);
        }
        if (this.mNO == 1) {
            this.mNQ = q.FS();
        } else if (s.eV(this.talker)) {
            this.mNQ = bh.az(ba.hP(this.content), this.talker);
        } else {
            this.mNQ = this.talker;
        }
    }

    public final boolean isAvailable() {
        return !bh.ov(this.mNP);
    }
}
