package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class q extends a {
    public String ksZ;
    public String ktA;
    public b ktB;
    public b ktC;
    public String ktt;
    public String ktu;
    public String ktv;
    public String ktw;
    public long ktx;
    public long kty;
    public String ktz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ktt == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.ktu == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.ktv == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.ktw == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.ktz == null) {
                throw new e.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.ksZ == null) {
                throw new e.a.a.b("Not all required fields were included: Model");
            } else if (this.ktA == null) {
                throw new e.a.a.b("Not all required fields were included: Version");
            } else {
                if (this.ktt != null) {
                    aVar.g(1, this.ktt);
                }
                if (this.ktu != null) {
                    aVar.g(2, this.ktu);
                }
                if (this.ktv != null) {
                    aVar.g(3, this.ktv);
                }
                if (this.ktw != null) {
                    aVar.g(4, this.ktw);
                }
                aVar.S(5, this.ktx);
                aVar.S(6, this.kty);
                if (this.ktz != null) {
                    aVar.g(7, this.ktz);
                }
                if (this.ksZ != null) {
                    aVar.g(8, this.ksZ);
                }
                if (this.ktA != null) {
                    aVar.g(9, this.ktA);
                }
                if (this.ktB != null) {
                    aVar.b(10, this.ktB);
                }
                if (this.ktC == null) {
                    return 0;
                }
                aVar.b(11, this.ktC);
                return 0;
            }
        } else if (i == 1) {
            if (this.ktt != null) {
                r0 = e.a.a.b.b.a.h(1, this.ktt) + 0;
            } else {
                r0 = 0;
            }
            if (this.ktu != null) {
                r0 += e.a.a.b.b.a.h(2, this.ktu);
            }
            if (this.ktv != null) {
                r0 += e.a.a.b.b.a.h(3, this.ktv);
            }
            if (this.ktw != null) {
                r0 += e.a.a.b.b.a.h(4, this.ktw);
            }
            r0 = (r0 + e.a.a.a.R(5, this.ktx)) + e.a.a.a.R(6, this.kty);
            if (this.ktz != null) {
                r0 += e.a.a.b.b.a.h(7, this.ktz);
            }
            if (this.ksZ != null) {
                r0 += e.a.a.b.b.a.h(8, this.ksZ);
            }
            if (this.ktA != null) {
                r0 += e.a.a.b.b.a.h(9, this.ktA);
            }
            if (this.ktB != null) {
                r0 += e.a.a.a.a(10, this.ktB);
            }
            if (this.ktC != null) {
                r0 += e.a.a.a.a(11, this.ktC);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ktt == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.ktu == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.ktv == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.ktw == null) {
                throw new e.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.ktz == null) {
                throw new e.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.ksZ == null) {
                throw new e.a.a.b("Not all required fields were included: Model");
            } else if (this.ktA != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Version");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.ktt = aVar3.Avy.readString();
                    return 0;
                case 2:
                    qVar.ktu = aVar3.Avy.readString();
                    return 0;
                case 3:
                    qVar.ktv = aVar3.Avy.readString();
                    return 0;
                case 4:
                    qVar.ktw = aVar3.Avy.readString();
                    return 0;
                case 5:
                    qVar.ktx = aVar3.Avy.rz();
                    return 0;
                case 6:
                    qVar.kty = aVar3.Avy.rz();
                    return 0;
                case 7:
                    qVar.ktz = aVar3.Avy.readString();
                    return 0;
                case 8:
                    qVar.ksZ = aVar3.Avy.readString();
                    return 0;
                case 9:
                    qVar.ktA = aVar3.Avy.readString();
                    return 0;
                case 10:
                    qVar.ktB = aVar3.cJD();
                    return 0;
                case 11:
                    qVar.ktC = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
