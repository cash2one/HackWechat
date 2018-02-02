package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public class log_13905 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public long uin_;
    public VoiceInputBehavior viOp_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.viOp_ == null) {
                throw new b("Not all required fields were included: viOp_");
            }
            aVar.fU(1, this.import_ds_);
            aVar.fU(2, this.ds_);
            aVar.S(3, this.uin_);
            aVar.fU(4, this.device_);
            aVar.fU(5, this.clientVersion_);
            aVar.S(6, this.time_stamp_);
            if (this.viOp_ != null) {
                aVar.fW(7, this.viOp_.bke());
                this.viOp_.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((e.a.a.a.fR(1, this.import_ds_) + 0) + e.a.a.a.fR(2, this.ds_)) + e.a.a.a.R(3, this.uin_)) + e.a.a.a.fR(4, this.device_)) + e.a.a.a.fR(5, this.clientVersion_)) + e.a.a.a.R(6, this.time_stamp_);
            if (this.viOp_ != null) {
                return r0 + e.a.a.a.fT(7, this.viOp_.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.viOp_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: viOp_");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            log_13905 com_tencent_mm_plugin_report_kvdata_log_13905 = (log_13905) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_plugin_report_kvdata_log_13905.import_ds_ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_plugin_report_kvdata_log_13905.ds_ = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_plugin_report_kvdata_log_13905.uin_ = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_plugin_report_kvdata_log_13905.device_ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_plugin_report_kvdata_log_13905.clientVersion_ = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_plugin_report_kvdata_log_13905.time_stamp_ = aVar3.Avy.rz();
                    return 0;
                case 7:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a voiceInputBehavior = new VoiceInputBehavior();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = voiceInputBehavior.a(aVar4, voiceInputBehavior, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
