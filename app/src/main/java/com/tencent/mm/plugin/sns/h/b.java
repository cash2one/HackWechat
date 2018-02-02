package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    c gyH;
    int gzm;
    public int kGm;
    public int rbA;
    int rbB;
    public int rbC;
    public int rbD;
    int rbE;
    public int rbF;
    public int rbG;
    public String rbH;
    public String rbI;
    String rbJ;
    int rbK;
    public int rbL;
    public int rbM;
    public int rbN;
    public int rbO;
    public int rbP;
    public int rbQ;
    public int rbR;
    public int rbS;
    int rbT;
    int rbU;
    int rbV;
    int rbW;
    int rbX;
    int rbY;
    public int rbZ;
    public boolean rbs;
    public long rbt;
    public long rbu;
    public int rbv;
    int rbw;
    int rbx;
    int rby;
    public int rbz;
    long rcA;
    long rcB;
    long rcC;
    long rcD;
    long rcE;
    long rcF;
    long rcG;
    String rcH;
    int rcI;
    long rcJ;
    private long rcK;
    long rcL;
    private long rcM;
    private HashSet<String> rcN;
    HashSet<String> rcO;
    public HashSet<String> rcP;
    HashSet<String> rcQ;
    public HashSet<String> rcR;
    HashSet<String> rcS;
    HashSet<String> rcT;
    public HashSet<String> rcU;
    public HashSet<String> rcV;
    HashSet<String> rcW;
    public HashSet<String> rcX;
    private HashSet<String> rcY;
    public HashSet<String> rcZ;
    public int rca;
    int rcb;
    int rcc;
    public long rcd;
    public long rce;
    long rcf;
    long rcg;
    long rch;
    long rci;
    long rcj;
    long rck;
    long rcl;
    long rcm;
    long rcn;
    long rco;
    long rcp;
    long rcq;
    long rcr;
    long rcs;
    long rct;
    long rcu;
    long rcv;
    long rcw;
    long rcx;
    long rcy;
    long rcz;
    public HashSet<String> rda;
    public int rdb;
    public int rdc;
    public HashSet<String> rdd;
    public HashSet<String> rde;
    public HashSet<String> rdf;
    public HashSet<String> rdg;
    public HashSet<String> rdh;
    public HashSet<String> rdi;
    public HashSet<String> rdj;
    public HashSet<String> rdk;
    public HashSet<String> rdl;
    public HashSet<String> rdm;
    public HashSet<String> rdn;
    public HashSet<String> rdo;
    public long rdp;

    public final void u(m mVar) {
        if (mVar != null) {
            this.rcN.add(mVar.byq());
            this.rbw = this.rcN.size();
        }
    }

    public final void v(m mVar) {
        if (mVar != null) {
            String byq = mVar.byq();
            String g = i.g(mVar);
            if (!this.rcO.contains(g)) {
                x.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[]{byq, g});
                this.rbx++;
                this.rcO.add(g);
                if (mVar.xl(32)) {
                    this.rcc++;
                }
                switch (mVar.field_type) {
                    case 1:
                        this.rbV++;
                        break;
                    case 3:
                        if (!bh.ov(mVar.bxV().wQp)) {
                            this.rbT++;
                            break;
                        } else {
                            this.rbU++;
                            break;
                        }
                    case 4:
                        this.rbX++;
                        break;
                    case 5:
                        this.rbY++;
                        break;
                    case 15:
                        this.rbW++;
                        break;
                    case 18:
                        this.rcb++;
                        break;
                }
                if (mVar.xl(32)) {
                    if (mVar.bxR() != null && mVar.bxR().bwt()) {
                        ir(true);
                    } else if (mVar.field_type == 1) {
                        iw(true);
                    } else if (mVar.field_type == 15) {
                        ix(true);
                    }
                } else if (mVar.bxV() == null || bh.ov(mVar.bxV().rLO)) {
                    switch (mVar.field_type) {
                        case 1:
                            iq(true);
                            return;
                        case 3:
                            if (bh.ov(mVar.bxV().wQp)) {
                                iv(true);
                                return;
                            } else {
                                iu(true);
                                return;
                            }
                        case 4:
                            iv(true);
                            return;
                        case 5:
                            iv(true);
                            return;
                        case 15:
                            it(true);
                            return;
                        case 18:
                            iz(true);
                            return;
                        default:
                            return;
                    }
                } else {
                    is(true);
                }
            }
        }
    }

    public final void a(m mVar, boolean z) {
        if (mVar != null) {
            if (z) {
                this.rcS.add(i.g(mVar));
            } else {
                this.rcT.add(i.g(mVar));
            }
            this.rcW.add(mVar.field_userName);
            this.rby = this.rcW.size();
            if (ae.bvb().equals(mVar.field_userName)) {
                im(true);
            } else {
                in(true);
            }
        }
    }

    public final void ef(String str, String str2) {
        this.rcQ.add(str2);
        this.rcY.add(str);
        this.rbB = this.rcY.size();
    }

    public final void il(boolean z) {
        if (z) {
            this.rcg = System.currentTimeMillis();
        } else if (this.rcg > 0) {
            this.rcf += System.currentTimeMillis() - this.rcg;
            this.rcg = 0;
        }
    }

    public final void im(boolean z) {
        if (z) {
            this.rci = System.currentTimeMillis();
        } else if (this.rci > 0) {
            this.rch += System.currentTimeMillis() - this.rci;
            this.rci = 0;
        }
    }

    public final void in(boolean z) {
        if (z) {
            this.rck = System.currentTimeMillis();
        } else if (this.rck > 0) {
            this.rcj += System.currentTimeMillis() - this.rck;
            this.rck = 0;
        }
    }

    public final void io(boolean z) {
        if (z) {
            this.rcm = System.currentTimeMillis();
        } else if (this.rcm > 0) {
            this.rcl += System.currentTimeMillis() - this.rcm;
            this.rcm = 0;
        }
    }

    public final void ip(boolean z) {
        if (z) {
            this.rco = System.currentTimeMillis();
        } else if (this.rco > 0) {
            this.rcn += System.currentTimeMillis() - this.rco;
            this.rco = 0;
        }
    }

    public final void iq(boolean z) {
        if (z) {
            this.rcq = System.currentTimeMillis();
        } else if (this.rcq > 0) {
            this.rcp += System.currentTimeMillis() - this.rcq;
            this.rcq = 0;
        }
    }

    public final void ir(boolean z) {
        if (z) {
            this.rcK = System.currentTimeMillis();
        } else if (this.rcK > 0) {
            this.rcJ += System.currentTimeMillis() - this.rcK;
            this.rcK = 0;
        }
    }

    public final void is(boolean z) {
        if (z) {
            this.rcM = System.currentTimeMillis();
        } else if (this.rcM > 0) {
            this.rcL += System.currentTimeMillis() - this.rcM;
            this.rcM = 0;
        }
    }

    public final void it(boolean z) {
        if (z) {
            this.rcs = System.currentTimeMillis();
        } else if (this.rcs > 0) {
            this.rcr += System.currentTimeMillis() - this.rcs;
            this.rcs = 0;
        }
    }

    public final void iu(boolean z) {
        if (z) {
            this.rcu = System.currentTimeMillis();
        } else if (this.rcu > 0) {
            this.rct += System.currentTimeMillis() - this.rcu;
            this.rcu = 0;
        }
    }

    public final void iv(boolean z) {
        if (z) {
            this.rcw = System.currentTimeMillis();
        } else if (this.rcw > 0) {
            this.rcv += System.currentTimeMillis() - this.rcw;
            this.rcw = 0;
        }
    }

    public final void iw(boolean z) {
        if (z) {
            this.rcy = System.currentTimeMillis();
        } else if (this.rcy > 0) {
            this.rcx += System.currentTimeMillis() - this.rcy;
            this.rcy = 0;
        }
    }

    public final void ix(boolean z) {
        if (z) {
            this.rcC = System.currentTimeMillis();
        } else if (this.rcC > 0) {
            this.rcB += System.currentTimeMillis() - this.rcC;
            this.rcC = 0;
        }
    }

    public final void iy(boolean z) {
        if (z) {
            this.rcE = System.currentTimeMillis();
        } else if (this.rcE > 0) {
            this.rcD += System.currentTimeMillis() - this.rcE;
            this.rcE = 0;
        }
    }

    public final void iz(boolean z) {
        if (z) {
            this.rcG = System.currentTimeMillis();
        } else if (this.rcG > 0) {
            this.rcF += System.currentTimeMillis() - this.rcG;
            this.rcG = 0;
        }
    }

    public final void iA(boolean z) {
        this.rbK = z ? 1 : 0;
    }

    public b() {
        this.rbs = false;
        this.rbt = -1;
        this.rbu = 0;
        this.rbv = 0;
        this.rbw = 0;
        this.rbx = 0;
        this.rby = 0;
        this.rbz = 0;
        this.rbA = 0;
        this.rbB = 0;
        this.rbC = 0;
        this.rbD = 0;
        this.rbE = 0;
        this.rbF = 0;
        this.rbG = 0;
        this.rbH = "";
        this.rbI = "";
        this.rbJ = "";
        this.rbL = 0;
        this.rbM = 0;
        this.rbN = 0;
        this.rbO = 0;
        this.rbP = 0;
        this.rbQ = 0;
        this.rbR = 0;
        this.kGm = 0;
        this.rbS = 0;
        this.rbT = 0;
        this.rbU = 0;
        this.rbV = 0;
        this.rbW = 0;
        this.rbX = 0;
        this.rbY = 0;
        this.rbZ = 0;
        this.rca = 0;
        this.rcb = 0;
        this.rcc = 0;
        this.rcd = 0;
        this.rce = 0;
        this.rcf = 0;
        this.rcg = 0;
        this.rch = 0;
        this.rci = 0;
        this.rcj = 0;
        this.rck = 0;
        this.rcl = 0;
        this.rcm = 0;
        this.rcn = 0;
        this.rco = 0;
        this.rcp = 0;
        this.rcq = 0;
        this.rcr = 0;
        this.rcs = 0;
        this.rct = 0;
        this.rcu = 0;
        this.rcv = 0;
        this.rcw = 0;
        this.rcx = 0;
        this.rcy = 0;
        this.rcz = 0;
        this.rcA = 0;
        this.rcB = 0;
        this.rcC = 0;
        this.rcD = 0;
        this.rcE = 0;
        this.rcF = 0;
        this.rcG = 0;
        this.rcJ = 0;
        this.rcK = 0;
        this.rcL = 0;
        this.rcM = 0;
        this.rcN = new HashSet();
        this.rcO = new HashSet();
        this.rcP = new HashSet();
        this.rcQ = new HashSet();
        this.rcR = new HashSet();
        this.rcS = new HashSet();
        this.rcT = new HashSet();
        this.rcU = new HashSet();
        this.rcV = new HashSet();
        this.rcW = new HashSet();
        this.rcX = new HashSet();
        this.rcY = new HashSet();
        this.rcZ = new HashSet();
        this.rda = new HashSet();
        this.rdb = Integer.MAX_VALUE;
        this.rdc = 0;
        this.rdd = new HashSet();
        this.rde = new HashSet();
        this.rdf = new HashSet();
        this.rdg = new HashSet();
        this.rdh = new HashSet();
        this.rdi = new HashSet();
        this.rdj = new HashSet();
        this.rdk = new HashSet();
        this.rdl = new HashSet();
        this.rdm = new HashSet();
        this.rdn = new HashSet();
        this.rdo = new HashSet();
        this.gyH = new 1(this);
        this.rdp = 0;
        a.xef.b(this.gyH);
    }

    public b(int i, String str, int i2) {
        this();
        this.gzm = i;
        this.rcH = str;
        this.rcI = i2;
    }

    static String f(HashSet<String> hashSet) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = hashSet.iterator();
        Object obj = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (obj != null) {
                stringBuffer.append(str);
                obj = null;
            } else {
                stringBuffer.append("|" + str);
            }
        }
        return stringBuffer.toString();
    }
}
