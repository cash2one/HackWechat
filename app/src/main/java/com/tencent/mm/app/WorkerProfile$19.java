package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.od;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

class WorkerProfile$19 extends c<od> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$19(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        super(0);
        this.xen = od.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = null;
        od odVar = (od) bVar;
        Context context = odVar.fFZ.context;
        if (context == null) {
            x.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
        } else {
            String str2;
            String[] strArr = odVar.fFZ.fmW;
            if (strArr == null || strArr.length <= 0) {
                str2 = null;
            } else {
                str2 = strArr[0];
                str = g.s(p.aX(odVar.fFZ.context, strArr[0])[0].toByteArray());
            }
            strArr = odVar.fFZ.selectionArgs;
            if (strArr != null && strArr.length >= 6) {
                Intent intent = new Intent(context, WXBizEntryActivity.class);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                intent.putExtra("key_way", 4);
                intent.putExtra("appId", strArr[0]);
                intent.putExtra("timeStamp", strArr[1]);
                intent.putExtra("nonceStr", strArr[2]);
                intent.putExtra("packageExt", strArr[5]);
                intent.putExtra("signtype", strArr[3]);
                intent.putExtra("paySignature", strArr[4]);
                intent.putExtra("key_wxapi_package_name", str2);
                intent.putExtra("key_wxapi_sign", str);
                intent.putExtra("key_command_id", 13);
                context.startActivity(intent);
            }
        }
        return false;
    }
}
