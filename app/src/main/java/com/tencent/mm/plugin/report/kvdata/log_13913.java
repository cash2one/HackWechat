package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;

public class log_13913 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public String error_;
    public int import_ds_;
    public int scene_;
    public long time_stamp_;
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
            aVar.fU(7, this.scene_);
            if (this.error_ != null) {
                aVar.g(8, this.error_);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((((((e.a.a.a.fR(1, this.import_ds_) + 0) + e.a.a.a.fR(2, this.ds_)) + e.a.a.a.R(3, this.uin_)) + e.a.a.a.fR(4, this.device_)) + e.a.a.a.fR(5, this.clientVersion_)) + e.a.a.a.R(6, this.time_stamp_)) + e.a.a.a.fR(7, this.scene_);
            if (this.error_ != null) {
                return r0 + e.a.a.b.b.a.h(8, this.error_);
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
            log_13913 com_tencent_mm_plugin_report_kvdata_log_13913 = (log_13913) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_plugin_report_kvdata_log_13913.import_ds_ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_plugin_report_kvdata_log_13913.ds_ = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_plugin_report_kvdata_log_13913.uin_ = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_plugin_report_kvdata_log_13913.device_ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_plugin_report_kvdata_log_13913.clientVersion_ = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_plugin_report_kvdata_log_13913.time_stamp_ = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_plugin_report_kvdata_log_13913.scene_ = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_plugin_report_kvdata_log_13913.error_ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
