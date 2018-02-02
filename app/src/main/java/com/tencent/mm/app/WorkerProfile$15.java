package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import com.tencent.wcdb.database.SQLiteDatabase;

class WorkerProfile$15 extends c<oe> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$15(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = oe.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oe oeVar = (oe) bVar;
        Context context = oeVar.fGa.context;
        if (context == null) {
            x.e("MicroMsg.WorkerProfile", "context is null");
        } else {
            String[] strArr = oeVar.fGa.fmW;
            String str = null;
            String str2 = null;
            if (strArr != null && strArr.length > 0) {
                str = strArr[0];
                str2 = g.s(p.aX(oeVar.fGa.context, strArr[0])[0].toByteArray());
            }
            String[] strArr2 = oeVar.fGa.selectionArgs;
            if (strArr2 == null || strArr2.length <= 0) {
                x.e("MicroMsg.WorkerProfile", "args is null");
            } else {
                x.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle event, withType = %b", new Object[]{Boolean.valueOf(oeVar.fGa.fGb)});
                String str3;
                String str4;
                Intent intent;
                u.b t;
                if (!oeVar.fGa.fGb) {
                    str3 = null;
                    str4 = null;
                    if (strArr2 != null && strArr2.length > 1) {
                        str3 = strArr2[0];
                        str4 = strArr2[1];
                    }
                    x.i("MicroMsg.WorkerProfile", "open webview, appid = %s, url = %s", new Object[]{str3, str4});
                    if (!(bh.ov(str3) || bh.ov(str4))) {
                        x.i("MicroMsg.WorkerProfile", "url format = %s", new Object[]{String.format("weixin://dl/businessWebview/link?appid=%s&url=%s", new Object[]{str3, str4})});
                        intent = new Intent(context, WXBizEntryActivity.class);
                        intent.setData(Uri.parse(str4));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        intent.putExtra("key_package_name", str);
                        intent.putExtra("translate_link_scene", 1);
                        intent.putExtra("key_package_signature", str2);
                        intent.putExtra("key_command_id", 12);
                        t = u.GK().t("key_data_center_session_id", true);
                        t.o("key_package_name", str);
                        t.o("key_package_signature", str2);
                        x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str, str2});
                        context.startActivity(intent);
                        return true;
                    }
                } else if (strArr2 == null || strArr2.length <= 0) {
                    x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle fail, selectionArgs length invalid");
                } else {
                    str4 = strArr2[0];
                    x.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent, typeStr = %s, appid = %s", new Object[]{strArr2[1], str4});
                    String str5;
                    switch (bh.VI(str3)) {
                        case 1:
                            if (strArr2.length < 5) {
                                x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", new Object[]{Integer.valueOf(strArr2.length)});
                            }
                            String str6 = strArr2[2];
                            String str7 = strArr2[3];
                            str5 = strArr2[4];
                            x.i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, scene = %s, templateID = %s, reserved = %s", new Object[]{str4, Integer.valueOf(r3), str6, str7, str5});
                            if (bh.ov(str4)) {
                                x.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                break;
                            }
                            str5 = Uri.encode(String.format("scene=%s&template_id=%s&reserved=%s", new Object[]{str6, str7, str5}));
                            x.i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", new Object[]{String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5})});
                            intent = new Intent(context, WXBizEntryActivity.class);
                            intent.setData(Uri.parse(str4));
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.putExtra("key_package_name", str);
                            intent.putExtra("translate_link_scene", 1);
                            intent.putExtra("key_package_signature", str2);
                            intent.putExtra("key_command_id", 12);
                            t = u.GK().t("key_data_center_session_id", true);
                            t.o("key_package_name", str);
                            t.o("key_package_signature", str2);
                            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str, str2});
                            context.startActivity(intent);
                            return true;
                        default:
                            if (strArr2.length < 3) {
                                x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent fail, unknown type = %d", new Object[]{Integer.valueOf(r3)});
                                break;
                            }
                            str5 = strArr2[2];
                            x.i("MicroMsg.WorkerProfile", "default url format = %s", new Object[]{String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5})});
                            intent = new Intent(context, WXBizEntryActivity.class);
                            intent.setData(Uri.parse(str4));
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.putExtra("key_package_name", str);
                            intent.putExtra("translate_link_scene", 1);
                            intent.putExtra("key_package_signature", str2);
                            intent.putExtra("key_command_id", 12);
                            t = u.GK().t("key_data_center_session_id", true);
                            t.o("key_package_name", str);
                            t.o("key_package_signature", str2);
                            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str, str2});
                            context.startActivity(intent);
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
