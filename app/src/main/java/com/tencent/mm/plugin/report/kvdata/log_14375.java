package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public class log_14375 extends a {
    public int clientVersion_;
    public BDStatusInfo dbStatusInfo_;
    public int device_;
    public int ds_;
    public HeavyDetailInfo heavyDetailInfo_;
    public int import_ds_;
    public SDStatusInfo sdStatusInfo_;
    public long time_stamp_;
    public int type_;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.import_ds_);
            aVar.fU(2, this.ds_);
            aVar.S(3, this.uin_);
            aVar.fU(4, this.device_);
            aVar.fU(5, this.clientVersion_);
            aVar.S(6, this.time_stamp_);
            aVar.fU(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                aVar.fW(8, this.dbStatusInfo_.bke());
                this.dbStatusInfo_.a(aVar);
            }
            if (this.sdStatusInfo_ != null) {
                aVar.fW(9, this.sdStatusInfo_.bke());
                this.sdStatusInfo_.a(aVar);
            }
            if (this.heavyDetailInfo_ != null) {
                aVar.fW(10, this.heavyDetailInfo_.bke());
                this.heavyDetailInfo_.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((((((e.a.a.a.fR(1, this.import_ds_) + 0) + e.a.a.a.fR(2, this.ds_)) + e.a.a.a.R(3, this.uin_)) + e.a.a.a.fR(4, this.device_)) + e.a.a.a.fR(5, this.clientVersion_)) + e.a.a.a.R(6, this.time_stamp_)) + e.a.a.a.fR(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                r0 += e.a.a.a.fT(8, this.dbStatusInfo_.bke());
            }
            if (this.sdStatusInfo_ != null) {
                r0 += e.a.a.a.fT(9, this.sdStatusInfo_.bke());
            }
            if (this.heavyDetailInfo_ != null) {
                return r0 + e.a.a.a.fT(10, this.heavyDetailInfo_.bke());
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
            log_14375 com_tencent_mm_plugin_report_kvdata_log_14375 = (log_14375) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a bDStatusInfo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_plugin_report_kvdata_log_14375.import_ds_ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_plugin_report_kvdata_log_14375.ds_ = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_plugin_report_kvdata_log_14375.uin_ = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_plugin_report_kvdata_log_14375.device_ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_plugin_report_kvdata_log_14375.clientVersion_ = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_plugin_report_kvdata_log_14375.time_stamp_ = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_plugin_report_kvdata_log_14375.type_ = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        bDStatusInfo = new BDStatusInfo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.a(aVar4, bDStatusInfo, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_14375.dbStatusInfo_ = bDStatusInfo;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        bDStatusInfo = new SDStatusInfo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.a(aVar4, bDStatusInfo, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_14375.sdStatusInfo_ = bDStatusInfo;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        bDStatusInfo = new HeavyDetailInfo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.a(aVar4, bDStatusInfo, a.a(aVar4))) {
                        }
                        com_tencent_mm_plugin_report_kvdata_log_14375.heavyDetailInfo_ = bDStatusInfo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
