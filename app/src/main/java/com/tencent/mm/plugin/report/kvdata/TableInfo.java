package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;
import e.a.a.b;

public class TableInfo extends a {
    public long count_;
    public String name_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name_ == null) {
                throw new b("Not all required fields were included: name_");
            }
            if (this.name_ != null) {
                aVar.g(1, this.name_);
            }
            aVar.S(2, this.count_);
            return 0;
        } else if (i == 1) {
            if (this.name_ != null) {
                r0 = e.a.a.b.b.a.h(1, this.name_) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.R(2, this.count_);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.name_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: name_");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            TableInfo tableInfo = (TableInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tableInfo.name_ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    tableInfo.count_ = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
