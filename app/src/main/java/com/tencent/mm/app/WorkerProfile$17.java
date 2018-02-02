package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.id;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

class WorkerProfile$17 extends c<id> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$17(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = id.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = null;
        id idVar = (id) bVar;
        Context context = idVar.fyB.context;
        if (context == null) {
            x.e("MicroMsg.WorkerProfile", "context is null");
        } else {
            String str2;
            String str3;
            String[] strArr = idVar.fyB.fmW;
            if (strArr == null || strArr.length <= 0) {
                str2 = null;
                str3 = null;
            } else {
                str3 = strArr[0];
                str2 = g.s(p.aX(idVar.fyB.context, strArr[0])[0].toByteArray());
            }
            String[] strArr2 = idVar.fyB.selectionArgs;
            if (strArr2 == null || strArr2.length <= 0) {
                x.e("MicroMsg.WorkerProfile", "args is null");
            } else {
                String str4;
                if (strArr2 == null || strArr2.length <= 1) {
                    str4 = null;
                } else {
                    str4 = strArr2[0];
                    str = strArr2[1];
                }
                x.i("MicroMsg.WorkerProfile", "handleScanResult, appid = %s, scanResult = %s", new Object[]{str4, str});
                if (!(bh.ov(str4) || bh.ov(str))) {
                    str = String.format("weixin://dl/handleScanResult?appid=%s&result=%s", new Object[]{str4, str});
                    Intent intent = new Intent(context, WXBizEntryActivity.class);
                    intent.setData(Uri.parse(str));
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                    intent.putExtra("key_command_id", 17);
                    intent.putExtra("key_package_name", str3);
                    intent.putExtra("translate_link_scene", 1);
                    intent.putExtra("key_package_signature", str2);
                    context.startActivity(intent);
                    return true;
                }
            }
        }
        return false;
    }
}
