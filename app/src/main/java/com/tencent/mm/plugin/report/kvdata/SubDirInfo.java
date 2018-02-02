package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;

public class SubDirInfo extends a {
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount;
    public int tag_;
    public long totalSize_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.tag_);
            aVar.S(2, this.totalSize_);
            aVar.S(3, this.dirCount_);
            aVar.S(4, this.fileCount_);
            aVar.S(5, this.fileLenInvalidCount);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.tag_) + 0) + e.a.a.a.R(2, this.totalSize_)) + e.a.a.a.R(3, this.dirCount_)) + e.a.a.a.R(4, this.fileCount_)) + e.a.a.a.R(5, this.fileLenInvalidCount);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                SubDirInfo subDirInfo = (SubDirInfo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        subDirInfo.tag_ = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        subDirInfo.totalSize_ = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        subDirInfo.dirCount_ = aVar3.Avy.rz();
                        return 0;
                    case 4:
                        subDirInfo.fileCount_ = aVar3.Avy.rz();
                        return 0;
                    case 5:
                        subDirInfo.fileLenInvalidCount = aVar3.Avy.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
