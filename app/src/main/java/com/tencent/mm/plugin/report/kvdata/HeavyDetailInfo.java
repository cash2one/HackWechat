package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;

public class HeavyDetailInfo extends a {
    public long chatroom_;
    public long contact_;
    public long conversation_;
    public long dbSize_;
    public long favDbSize_;
    public long flag_;
    public long message_;
    public long sdFileRatio_;
    public long sdFileSize_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.flag_);
            aVar.S(2, this.sdFileSize_);
            aVar.S(3, this.sdFileRatio_);
            aVar.S(4, this.dbSize_);
            aVar.S(5, this.message_);
            aVar.S(6, this.conversation_);
            aVar.S(7, this.contact_);
            aVar.S(8, this.chatroom_);
            aVar.S(9, this.favDbSize_);
            return 0;
        } else if (i == 1) {
            return ((((((((e.a.a.a.R(1, this.flag_) + 0) + e.a.a.a.R(2, this.sdFileSize_)) + e.a.a.a.R(3, this.sdFileRatio_)) + e.a.a.a.R(4, this.dbSize_)) + e.a.a.a.R(5, this.message_)) + e.a.a.a.R(6, this.conversation_)) + e.a.a.a.R(7, this.contact_)) + e.a.a.a.R(8, this.chatroom_)) + e.a.a.a.R(9, this.favDbSize_);
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
                HeavyDetailInfo heavyDetailInfo = (HeavyDetailInfo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        heavyDetailInfo.flag_ = aVar3.Avy.rz();
                        return 0;
                    case 2:
                        heavyDetailInfo.sdFileSize_ = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        heavyDetailInfo.sdFileRatio_ = aVar3.Avy.rz();
                        return 0;
                    case 4:
                        heavyDetailInfo.dbSize_ = aVar3.Avy.rz();
                        return 0;
                    case 5:
                        heavyDetailInfo.message_ = aVar3.Avy.rz();
                        return 0;
                    case 6:
                        heavyDetailInfo.conversation_ = aVar3.Avy.rz();
                        return 0;
                    case 7:
                        heavyDetailInfo.contact_ = aVar3.Avy.rz();
                        return 0;
                    case 8:
                        heavyDetailInfo.chatroom_ = aVar3.Avy.rz();
                        return 0;
                    case 9:
                        heavyDetailInfo.favDbSize_ = aVar3.Avy.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
