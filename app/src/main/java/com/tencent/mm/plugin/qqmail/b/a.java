package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import e.a.a.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    String pnW;
    private boolean pnX;
    LinkedList<i> pnY = new LinkedList();
    private boolean pnZ;

    public final /* synthetic */ com.tencent.mm.bq.a aF(byte[] bArr) {
        return aE(bArr);
    }

    protected final /* synthetic */ com.tencent.mm.bq.a bkf() {
        return bkd();
    }

    public final a HE(String str) {
        this.pnW = str;
        this.pnX = true;
        return this;
    }

    public final a uY(int i) {
        boolean z = false;
        if (i >= 0 && i < this.pnY.size()) {
            if (i >= 10) {
                this.pnY.remove(i);
            } else {
                this.pnY.remove(i);
                Iterator it = this.pnY.iterator();
                int i2 = -1;
                int i3 = Integer.MIN_VALUE;
                int i4 = 0;
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    int i5 = i4 + 1;
                    if (i4 >= 10) {
                        int i6;
                        if (i3 < iVar.poB) {
                            i2 = iVar.poB;
                            i6 = i5;
                        } else {
                            i6 = i2;
                            i2 = i3;
                        }
                        i3 = i2;
                        i4 = i5;
                        i2 = i6;
                    } else {
                        i4 = i5;
                    }
                }
                if (i2 != -1 && i2 < this.pnY.size()) {
                    try {
                        a((i) this.pnY.remove(i2));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AddrBook", e, "size:%d, idx:%d", new Object[]{Integer.valueOf(this.pnY.size()), Integer.valueOf(i2)});
                    }
                }
            }
            if (this.pnY.size() > 0) {
                z = true;
            }
            this.pnZ = z;
        }
        return this;
    }

    public final a a(i iVar) {
        int i = 0;
        if (!this.pnZ) {
            this.pnZ = true;
        }
        Iterator it = this.pnY.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i iVar2 = (i) it.next();
            if (i2 >= 10) {
                if (a(iVar, iVar2)) {
                    break;
                }
            } else if (iVar.poB > iVar2.poB) {
                break;
            }
            i2++;
        }
        if (i2 >= this.pnY.size()) {
            this.pnY.add(iVar);
        } else {
            this.pnY.add(i2, iVar);
            if (i2 < 10 && this.pnY.size() > 10) {
                iVar2 = (i) this.pnY.remove(10);
                it = this.pnY.iterator();
                while (it.hasNext()) {
                    i iVar3 = (i) it.next();
                    if (i >= 10 && a(iVar2, iVar3)) {
                        break;
                    }
                    i++;
                }
                if (i >= this.pnY.size()) {
                    this.pnY.add(iVar2);
                } else {
                    this.pnY.add(i, iVar2);
                }
            }
        }
        return this;
    }

    private static boolean a(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return false;
        }
        int compareTo = b(iVar).compareTo(b(iVar2));
        if (compareTo == 0) {
            if (iVar.nQt.compareTo(iVar2.nQt) > 0) {
                return false;
            }
            return true;
        } else if (compareTo >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String b(i iVar) {
        String str = iVar.poC;
        if (str == null || "".equals(str)) {
            str = HF(c.ol(iVar.name.trim()).toLowerCase());
        } else {
            str = HF(str);
        }
        iVar.poC = str;
        return str;
    }

    public static String HF(String str) {
        if (str == null || str.length() <= 0) {
            x.d("MicroMsg.getAdjustFullSpell", "%s", new Object[]{"srcName is null or empty, adjust full spell = ~"});
            return "~";
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            char c = toCharArray[i];
            if (c >= '0' && c <= '9') {
                return String.format("{%c%s", new Object[]{Character.valueOf(c), str});
            } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (c == '{' && i == 0 && toCharArray.length > 1 && toCharArray[i + 1] >= '0' && toCharArray[i + 1] <= '9') {
                    return str;
                }
                i++;
            } else if (i == 0) {
                return str;
            } else {
                return String.format("%c%s", new Object[]{Character.valueOf(c), str});
            }
        }
        x.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[]{str});
        return "~";
    }

    public final String toString() {
        return ((("" + getClass().getName() + "(") + "syncInfo = " + this.pnW + "   ") + "addrs = " + this.pnY + "   ") + ")";
    }

    private a bkd() {
        if (this.pnX) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.pnX);
    }

    public final int bke() {
        return (e.a.a.b.b.a.h(1, this.pnW) + 0) + (e.a.a.a.c(2, 8, this.pnY) + 0);
    }

    public final byte[] toByteArray() {
        bkd();
        return super.toByteArray();
    }

    public final void a(e.a.a.c.a aVar) {
        aVar.g(1, this.pnW);
        aVar.d(2, 8, this.pnY);
    }

    public final a aE(byte[] bArr) {
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a(aVar); a > 0; a = a(aVar)) {
            boolean z;
            switch (a) {
                case 1:
                    HE(aVar.Avy.readString());
                    z = true;
                    break;
                case 2:
                    int i;
                    LinkedList Jl = aVar.Jl(2);
                    for (i = 0; i < Jl.size(); i++) {
                        byte[] bArr2 = (byte[]) Jl.get(i);
                        com.tencent.mm.bq.a iVar = new i();
                        e.a.a.a.a aVar2 = new e.a.a.a.a(bArr2, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar2, iVar, a(aVar2))) {
                        }
                        if (!this.pnZ) {
                            this.pnZ = true;
                        }
                        this.pnY.add(iVar);
                    }
                    i[] iVarArr = (i[]) this.pnY.toArray(new i[1]);
                    Arrays.sort(iVarArr, new 1(this));
                    if (10 <= iVarArr.length) {
                        Arrays.sort(iVarArr, 10, iVarArr.length, new 2(this));
                    }
                    this.pnY.clear();
                    for (Object add : iVarArr) {
                        this.pnY.add(add);
                    }
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                aVar.cJE();
            }
        }
        return bkd();
    }
}
