package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class us extends a {
    public String appId;
    public String fDJ;
    public String fIR;
    public String fnl;
    public int fqd;
    public String fzO;
    public boolean hAj = false;
    public String hOf;
    public long hVE;
    public String toUser;
    public boolean weA = false;
    public boolean weB = false;
    public boolean weo = false;
    public boolean wep = false;
    public boolean weq = false;
    public String wer;
    public boolean wes = false;
    public String wet;
    public boolean weu = false;
    public boolean wev = false;
    public boolean wew = false;
    public boolean wex = false;
    public boolean wey = false;
    public String wez;

    public final us CN(int i) {
        this.fqd = i;
        this.weo = true;
        return this;
    }

    public final us TR(String str) {
        this.fzO = str;
        this.wep = true;
        return this;
    }

    public final us TS(String str) {
        this.toUser = str;
        this.weq = true;
        return this;
    }

    public final us TT(String str) {
        this.wer = str;
        this.wes = true;
        return this;
    }

    public final us TU(String str) {
        this.wet = str;
        this.weu = true;
        return this;
    }

    public final us fz(long j) {
        this.hVE = j;
        this.hAj = true;
        return this;
    }

    public final us TV(String str) {
        this.fDJ = str;
        this.wev = true;
        return this;
    }

    public final us TW(String str) {
        this.appId = str;
        this.wex = true;
        return this;
    }

    public final us TX(String str) {
        this.hOf = str;
        this.wey = true;
        return this;
    }

    public final us TY(String str) {
        this.fnl = str;
        this.weB = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weo) {
                if (this.weo) {
                    aVar.fU(1, this.fqd);
                }
                if (this.fzO != null) {
                    aVar.g(2, this.fzO);
                }
                if (this.toUser != null) {
                    aVar.g(3, this.toUser);
                }
                if (this.wer != null) {
                    aVar.g(4, this.wer);
                }
                if (this.wet != null) {
                    aVar.g(5, this.wet);
                }
                if (this.hAj) {
                    aVar.S(6, this.hVE);
                }
                if (this.fDJ != null) {
                    aVar.g(7, this.fDJ);
                }
                if (this.fIR != null) {
                    aVar.g(8, this.fIR);
                }
                if (this.appId != null) {
                    aVar.g(9, this.appId);
                }
                if (this.hOf != null) {
                    aVar.g(10, this.hOf);
                }
                if (this.wez != null) {
                    aVar.g(11, this.wez);
                }
                if (this.fnl == null) {
                    return 0;
                }
                aVar.g(12, this.fnl);
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i == 1) {
            if (this.weo) {
                r0 = e.a.a.a.fR(1, this.fqd) + 0;
            } else {
                r0 = 0;
            }
            if (this.fzO != null) {
                r0 += e.a.a.b.b.a.h(2, this.fzO);
            }
            if (this.toUser != null) {
                r0 += e.a.a.b.b.a.h(3, this.toUser);
            }
            if (this.wer != null) {
                r0 += e.a.a.b.b.a.h(4, this.wer);
            }
            if (this.wet != null) {
                r0 += e.a.a.b.b.a.h(5, this.wet);
            }
            if (this.hAj) {
                r0 += e.a.a.a.R(6, this.hVE);
            }
            if (this.fDJ != null) {
                r0 += e.a.a.b.b.a.h(7, this.fDJ);
            }
            if (this.fIR != null) {
                r0 += e.a.a.b.b.a.h(8, this.fIR);
            }
            if (this.appId != null) {
                r0 += e.a.a.b.b.a.h(9, this.appId);
            }
            if (this.hOf != null) {
                r0 += e.a.a.b.b.a.h(10, this.hOf);
            }
            if (this.wez != null) {
                r0 += e.a.a.b.b.a.h(11, this.wez);
            }
            if (this.fnl != null) {
                r0 += e.a.a.b.b.a.h(12, this.fnl);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.weo) {
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            us usVar = (us) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    usVar.fqd = aVar3.Avy.ry();
                    usVar.weo = true;
                    return 0;
                case 2:
                    usVar.fzO = aVar3.Avy.readString();
                    usVar.wep = true;
                    return 0;
                case 3:
                    usVar.toUser = aVar3.Avy.readString();
                    usVar.weq = true;
                    return 0;
                case 4:
                    usVar.wer = aVar3.Avy.readString();
                    usVar.wes = true;
                    return 0;
                case 5:
                    usVar.wet = aVar3.Avy.readString();
                    usVar.weu = true;
                    return 0;
                case 6:
                    usVar.hVE = aVar3.Avy.rz();
                    usVar.hAj = true;
                    return 0;
                case 7:
                    usVar.fDJ = aVar3.Avy.readString();
                    usVar.wev = true;
                    return 0;
                case 8:
                    usVar.fIR = aVar3.Avy.readString();
                    usVar.wew = true;
                    return 0;
                case 9:
                    usVar.appId = aVar3.Avy.readString();
                    usVar.wex = true;
                    return 0;
                case 10:
                    usVar.hOf = aVar3.Avy.readString();
                    usVar.wey = true;
                    return 0;
                case 11:
                    usVar.wez = aVar3.Avy.readString();
                    usVar.weA = true;
                    return 0;
                case 12:
                    usVar.fnl = aVar3.Avy.readString();
                    usVar.weB = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
