package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class y extends a {
    public String name;
    public String path;
    public long ppZ;
    public String pqa;
    public long size;
    public int state;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.path == null) {
                throw new b("Not all required fields were included: path");
            } else if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else {
                if (this.path != null) {
                    aVar.g(1, this.path);
                }
                if (this.name != null) {
                    aVar.g(2, this.name);
                }
                aVar.S(3, this.size);
                aVar.fU(4, this.state);
                aVar.S(5, this.ppZ);
                if (this.pqa == null) {
                    return 0;
                }
                aVar.g(6, this.pqa);
                return 0;
            }
        } else if (i == 1) {
            if (this.path != null) {
                r0 = e.a.a.b.b.a.h(1, this.path) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            r0 = ((r0 + e.a.a.a.R(3, this.size)) + e.a.a.a.fR(4, this.state)) + e.a.a.a.R(5, this.ppZ);
            if (this.pqa != null) {
                r0 += e.a.a.b.b.a.h(6, this.pqa);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.path == null) {
                throw new b("Not all required fields were included: path");
            } else if (this.name != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.path = aVar3.Avy.readString();
                    return 0;
                case 2:
                    yVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    yVar.size = aVar3.Avy.rz();
                    return 0;
                case 4:
                    yVar.state = aVar3.Avy.ry();
                    return 0;
                case 5:
                    yVar.ppZ = aVar3.Avy.rz();
                    return 0;
                case 6:
                    yVar.pqa = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
