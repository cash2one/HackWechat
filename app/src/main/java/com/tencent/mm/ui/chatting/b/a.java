package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI$Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Locale;

public final class a {
    public p fhr;
    public com.tencent.mm.plugin.wallet.a pLQ = null;
    public am yyA = null;
    public final com.tencent.mm.sdk.e.j.a yyB = new 1(this);
    public final com.tencent.mm.sdk.e.j.a yyC = new 2(this);

    public a(p pVar) {
        this.fhr = pVar;
    }

    public final void n(f fVar) {
        if (fVar == null || bh.ov(fVar.field_appId)) {
            x.e("MicroMsg.ChattingUI.AppImp", "jumpServiceH5 error args");
        } else if (bh.ov(fVar.fQY)) {
            x.e("MicroMsg.ChattingUI.AppImp", "ForwardUrl is null");
        } else {
            int size;
            Intent intent;
            Bundle bundle;
            SharedPreferences sharedPreferences = this.fhr.csq().getSharedPreferences(ac.cfs(), 0);
            this.fhr.csq().getContext();
            String d = w.d(sharedPreferences);
            if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                d = Locale.getDefault().toString();
            }
            if (s.eV(this.fhr.crz())) {
                ar.Hg();
                q hD = c.Fh().hD(this.fhr.crz());
                if (hD != null) {
                    size = hD.Ms().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", fVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    intent.putExtra("forceHideShare", true);
                    bundle.putString("sendAppMsgToUserName", this.fhr.csi().field_username);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.fQY, Integer.valueOf(size), d}));
                    d.b(this.fhr.csq().getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fVar.field_appId);
            bundle.putBoolean("isFromService", true);
            intent.putExtra("forceHideShare", true);
            bundle.putString("sendAppMsgToUserName", this.fhr.csi().field_username);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.fQY, Integer.valueOf(size), d}));
            d.b(this.fhr.csq().getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public final void aM(au auVar) {
        String str = auVar.field_content;
        if (auVar.field_isSend == 0) {
            p pVar = this.fhr;
            int i = auVar.field_isSend;
            if (!pVar.csg() && pVar.csd() && str != null && i == 0) {
                str = ba.hQ(str);
            }
        }
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str);
        f aZ = g.aZ(fT.appId, true);
        if (aZ == null || !p.m(this.fhr.csq().getContext(), aZ.field_packageName)) {
            str = p.w(this.fhr.csq().getContext(), fT.appId, "message");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(this.fhr.csq().getContext(), "webview", ".ui.tools.WebViewUI", intent);
        } else if (aZ.field_status == 3) {
            x.e("MicroMsg.ChattingUI.AppImp", "requestAppShow fail, app is in blacklist, packageName = " + aZ.field_packageName);
        } else if (!p.b(this.fhr.csq().getContext(), aZ)) {
            x.e("MicroMsg.ChattingUI.AppImp", "The app %s signature is incorrect.", new Object[]{aZ.field_appName});
            Toast.makeText(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.emo, new Object[]{g.a(this.fhr.csq().getContext(), aZ, null)}), 1).show();
        } else if (!a(auVar, aZ)) {
            IMediaObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = fT.extInfo;
            if (fT.fny != null && fT.fny.length() > 0) {
                b Rz = an.aqd().Rz(fT.fny);
                wXAppExtendObject.filePath = Rz == null ? null : Rz.field_fileFullPath;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = 620823552;
            wXMediaMessage.mediaObject = wXAppExtendObject;
            wXMediaMessage.title = fT.title;
            wXMediaMessage.description = fT.description;
            wXMediaMessage.messageAction = fT.messageAction;
            wXMediaMessage.messageExt = fT.messageExt;
            wXMediaMessage.thumbData = e.d(o.Pw().lm(auVar.field_imgPath), 0, -1);
            new com.tencent.mm.ui.chatting.an(this.fhr.csq().getContext()).a(aZ.field_packageName, wXMediaMessage, aZ.field_appId, aZ.field_openId);
        }
    }

    private boolean a(au auVar, f fVar) {
        if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.ChattingUI.AppImp", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", av(this.fhr.csq().getContext(), "com.tencent.mobileqq"));
        intent.putExtra(ConstantsAPI$Token.WX_TOKEN_PLATFORMID_KEY, ConstantsAPI$Token.WX_TOKEN_PLATFORMID_VALUE);
        ar.Hg();
        Object obj = c.CU().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingUI.AppImp", e, "", new Object[0]);
            }
        }
        try {
            this.fhr.csq().startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String av(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingUI.AppImp", e, "", new Object[0]);
        }
        return null;
    }

    public final void a(l lVar) {
        bo.HS().c(38, Integer.valueOf(1));
        String str = lVar.filePath;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
        wXMediaMessage.title = new File(str).getName();
        wXMediaMessage.description = bh.bx((long) e.bN(str));
        com.tencent.mm.sdk.e.c fVar = new f();
        fVar.field_appId = "wx4310bbd51be7d979";
        an.bin().b(fVar, new String[0]);
        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.fhr.crz(), 2, null);
    }
}
