package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public class WeChatSDInfo extends a {
    public int depth_;
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount_;
    public LinkedList<SubDirInfo> subDirList_ = new LinkedList();
    public int subDirResultsSize_;
    public long tempAccDirCount_;
    public int tempAccDirResultsSize_;
    public long tempAccFileCount_;
    public long tempAccFileLenInvalidCount_;
    public long tempAccTotalSize_;
    public long totalSize_;
    public long totalTime_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.totalSize_);
            aVar.S(2, this.dirCount_);
            aVar.S(3, this.fileCount_);
            aVar.S(4, this.fileLenInvalidCount_);
            aVar.fU(5, this.subDirResultsSize_);
            aVar.S(6, this.totalTime_);
            aVar.fU(7, this.depth_);
            aVar.S(8, this.tempAccTotalSize_);
            aVar.fU(9, this.tempAccDirResultsSize_);
            aVar.S(10, this.tempAccDirCount_);
            aVar.S(11, this.tempAccFileCount_);
            aVar.S(12, this.tempAccFileLenInvalidCount_);
            aVar.d(13, 8, this.subDirList_);
            return 0;
        } else if (i == 1) {
            return ((((((((((((e.a.a.a.R(1, this.totalSize_) + 0) + e.a.a.a.R(2, this.dirCount_)) + e.a.a.a.R(3, this.fileCount_)) + e.a.a.a.R(4, this.fileLenInvalidCount_)) + e.a.a.a.fR(5, this.subDirResultsSize_)) + e.a.a.a.R(6, this.totalTime_)) + e.a.a.a.fR(7, this.depth_)) + e.a.a.a.R(8, this.tempAccTotalSize_)) + e.a.a.a.fR(9, this.tempAccDirResultsSize_)) + e.a.a.a.R(10, this.tempAccDirCount_)) + e.a.a.a.R(11, this.tempAccFileCount_)) + e.a.a.a.R(12, this.tempAccFileLenInvalidCount_)) + e.a.a.a.c(13, 8, this.subDirList_);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.subDirList_.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
                WeChatSDInfo weChatSDInfo = (WeChatSDInfo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        weChatSDInfo.totalSize_ = aVar3.Avy.rz();
                        return 0;
                    case 2:
                        weChatSDInfo.dirCount_ = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        weChatSDInfo.fileCount_ = aVar3.Avy.rz();
                        return 0;
                    case 4:
                        weChatSDInfo.fileLenInvalidCount_ = aVar3.Avy.rz();
                        return 0;
                    case 5:
                        weChatSDInfo.subDirResultsSize_ = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        weChatSDInfo.totalTime_ = aVar3.Avy.rz();
                        return 0;
                    case 7:
                        weChatSDInfo.depth_ = aVar3.Avy.ry();
                        return 0;
                    case 8:
                        weChatSDInfo.tempAccTotalSize_ = aVar3.Avy.rz();
                        return 0;
                    case 9:
                        weChatSDInfo.tempAccDirResultsSize_ = aVar3.Avy.ry();
                        return 0;
                    case 10:
                        weChatSDInfo.tempAccDirCount_ = aVar3.Avy.rz();
                        return 0;
                    case 11:
                        weChatSDInfo.tempAccFileCount_ = aVar3.Avy.rz();
                        return 0;
                    case 12:
                        weChatSDInfo.tempAccFileLenInvalidCount_ = aVar3.Avy.rz();
                        return 0;
                    case 13:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a subDirInfo = new SubDirInfo();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = subDirInfo.a(aVar4, subDirInfo, a.a(aVar4))) {
                            }
                            weChatSDInfo.subDirList_.add(subDirInfo);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
