package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.g.b.cv;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends cv {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "uid";
        aVar.xjA.put("uid", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "uid";
        aVar.columns[1] = "name";
        aVar.xjA.put("name", "TEXT default '' ");
        stringBuilder.append(" name TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "devicetype";
        aVar.xjA.put("devicetype", "TEXT default '' ");
        stringBuilder.append(" devicetype TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createtime";
        aVar.xjA.put("createtime", "LONG default '0' ");
        stringBuilder.append(" createtime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public c() {
        this.field_uid = "0";
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public c(bdq com_tencent_mm_protocal_c_bdq) {
        this.field_createtime = (long) com_tencent_mm_protocal_c_bdq.pbl;
        this.field_devicetype = com_tencent_mm_protocal_c_bdq.vJA;
        this.field_name = com_tencent_mm_protocal_c_bdq.nfp;
        this.field_uid = com_tencent_mm_protocal_c_bdq.vYQ;
    }
}
