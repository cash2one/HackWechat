package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public class log_13835 extends a {
    public int clientVersion_;
    public String currChatName_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public LinkedList<IMBehavior> oplist_ = new LinkedList();
    public long time_stamp_;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.currChatName_ == null) {
                throw new b("Not all required fields were included: currChatName_");
            }
            aVar.fU(1, this.import_ds_);
            aVar.fU(2, this.ds_);
            aVar.S(3, this.uin_);
            aVar.fU(4, this.device_);
            aVar.fU(5, this.clientVersion_);
            aVar.S(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                aVar.g(7, this.currChatName_);
            }
            aVar.d(8, 8, this.oplist_);
            return 0;
        } else if (i == 1) {
            r0 = (((((e.a.a.a.fR(1, this.import_ds_) + 0) + e.a.a.a.fR(2, this.ds_)) + e.a.a.a.R(3, this.uin_)) + e.a.a.a.fR(4, this.device_)) + e.a.a.a.fR(5, this.clientVersion_)) + e.a.a.a.R(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                r0 += e.a.a.b.b.a.h(7, this.currChatName_);
            }
            return r0 + e.a.a.a.c(8, 8, this.oplist_);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.oplist_.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.currChatName_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: currChatName_");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            log_13835 com_tencent_mm_plugin_report_kvdata_log_13835 = (log_13835) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_plugin_report_kvdata_log_13835.import_ds_ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_plugin_report_kvdata_log_13835.ds_ = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_plugin_report_kvdata_log_13835.uin_ = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_plugin_report_kvdata_log_13835.device_ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_plugin_report_kvdata_log_13835.clientVersion_ = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_plugin_report_kvdata_log_13835.time_stamp_ = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_plugin_report_kvdata_log_13835.currChatName_ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a iMBehavior = new IMBehavior();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = iMBehavior.a(aVar4, iMBehavior, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_13835.oplist_.add(iMBehavior);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
