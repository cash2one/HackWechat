package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.z.ar;

public final class ReportUtil {
    public static void a(Context context, ReportArgs reportArgs) {
        if (reportArgs.pK == 1) {
            Resp resp = new Resp();
            resp.transaction = reportArgs.transaction;
            resp.errCode = reportArgs.errCode;
            resp.openId = reportArgs.openId;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            Args args = new Args();
            args.targetPkgName = reportArgs.uC;
            args.bundle = bundle;
            MMessageActV2.send(context, args);
            return;
        }
        SendMessageToWX.Resp resp2 = new SendMessageToWX.Resp();
        resp2.errCode = reportArgs.errCode;
        resp2.transaction = reportArgs.transaction;
        resp2.openId = reportArgs.openId;
        bundle = new Bundle();
        resp2.toBundle(bundle);
        p.ae(bundle);
        args = new Args();
        args.targetPkgName = reportArgs.uC;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
    }

    public static ReportArgs b(Bundle bundle, int i) {
        String string = bundle.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            String string2 = bundle.getString(ConstantsAPI.CONTENT);
            if (string2 != null) {
                string = Uri.parse(string2).getQueryParameter("appid");
            }
        }
        if (string == null) {
            string = t.i(bundle, "_wxapi_payreq_appid");
            if (string == null) {
                return null;
            }
        }
        c fVar = new f();
        fVar.field_appId = string;
        if (ar.Hi() && ar.Hj()) {
            an.bin().b(fVar, new String[0]);
        } else {
            fVar.field_packageName = bundle.getString(ConstantsAPI.APP_PACKAGE);
        }
        ReportArgs reportArgs = new ReportArgs();
        reportArgs.uC = fVar.field_packageName;
        reportArgs.errCode = i;
        Req req = new Req();
        req.fromBundle(bundle);
        reportArgs.transaction = req.transaction;
        reportArgs.openId = fVar.field_openId;
        reportArgs.pK = bundle.getInt("_wxapi_command_type");
        return reportArgs;
    }
}
