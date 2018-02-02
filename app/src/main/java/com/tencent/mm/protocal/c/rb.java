package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class rb extends a {
    public String deviceBrand;
    public String deviceModel;
    public String osName;
    public String osVersion;
    public String vZe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.deviceModel != null) {
                aVar.g(1, this.deviceModel);
            }
            if (this.deviceBrand != null) {
                aVar.g(2, this.deviceBrand);
            }
            if (this.osName != null) {
                aVar.g(3, this.osName);
            }
            if (this.osVersion != null) {
                aVar.g(4, this.osVersion);
            }
            if (this.vZe == null) {
                return 0;
            }
            aVar.g(5, this.vZe);
            return 0;
        } else if (i == 1) {
            if (this.deviceModel != null) {
                r0 = e.a.a.b.b.a.h(1, this.deviceModel) + 0;
            } else {
                r0 = 0;
            }
            if (this.deviceBrand != null) {
                r0 += e.a.a.b.b.a.h(2, this.deviceBrand);
            }
            if (this.osName != null) {
                r0 += e.a.a.b.b.a.h(3, this.osName);
            }
            if (this.osVersion != null) {
                r0 += e.a.a.b.b.a.h(4, this.osVersion);
            }
            if (this.vZe != null) {
                r0 += e.a.a.b.b.a.h(5, this.vZe);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rb rbVar = (rb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rbVar.deviceModel = aVar3.Avy.readString();
                    return 0;
                case 2:
                    rbVar.deviceBrand = aVar3.Avy.readString();
                    return 0;
                case 3:
                    rbVar.osName = aVar3.Avy.readString();
                    return 0;
                case 4:
                    rbVar.osVersion = aVar3.Avy.readString();
                    return 0;
                case 5:
                    rbVar.vZe = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
