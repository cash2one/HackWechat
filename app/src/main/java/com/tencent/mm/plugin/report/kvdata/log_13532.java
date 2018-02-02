package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;

public class log_13532 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public int type;
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
            aVar.fU(7, this.type);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fR(1, this.import_ds_) + 0) + e.a.a.a.fR(2, this.ds_)) + e.a.a.a.R(3, this.uin_)) + e.a.a.a.fR(4, this.device_)) + e.a.a.a.fR(5, this.clientVersion_)) + e.a.a.a.R(6, this.time_stamp_)) + e.a.a.a.fR(7, this.type);
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
                log_13532 com_tencent_mm_plugin_report_kvdata_log_13532 = (log_13532) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_plugin_report_kvdata_log_13532.import_ds_ = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_plugin_report_kvdata_log_13532.ds_ = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_plugin_report_kvdata_log_13532.uin_ = aVar3.Avy.rz();
                        return 0;
                    case 4:
                        com_tencent_mm_plugin_report_kvdata_log_13532.device_ = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_plugin_report_kvdata_log_13532.clientVersion_ = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        com_tencent_mm_plugin_report_kvdata_log_13532.time_stamp_ = aVar3.Avy.rz();
                        return 0;
                    case 7:
                        com_tencent_mm_plugin_report_kvdata_log_13532.type = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
