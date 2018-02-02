package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class g {
    public static LinkedList<f> aPW() {
        x.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
        LinkedList<f> linkedList = new LinkedList();
        linkedList.addAll(SubCoreGameCenter.aRj().naO);
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int i;
            f fVar = (f) it.next();
            if (fVar != null) {
                x.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", new Object[]{fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag)});
                if ((fVar.field_appInfoFlag & 4) > 0) {
                    i = 1;
                    if (i == 0) {
                        x.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                        linkedList2.add(fVar);
                    }
                }
            }
            i = 0;
            if (i == 0) {
                x.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                linkedList2.add(fVar);
            }
        }
        if (linkedList2.size() > 0) {
            linkedList.removeAll(linkedList2);
        }
        return linkedList;
    }

    public static LinkedList<String> aPX() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(SubCoreGameCenter.aRj().naN);
        return linkedList;
    }

    public static void Y(Context context, final String str) {
        a(context, str, null, "WX_GameCenter", new a() {
            public final void cG(boolean z) {
                if (z) {
                    SubCoreGameCenter.aRg();
                    z.b(str, 0, 0, null, null);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, String str3, a aVar) {
        if (bh.ov(str)) {
            x.e("MicroMsg.GameCenterLogic", "null or nil appid");
            if (aVar != null) {
                aVar.cG(false);
            }
        }
        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
        if (aZ == null || bh.ov(aZ.field_appId)) {
            x.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            if (aVar != null) {
                aVar.cG(false);
            }
        } else if (p.b(context, aZ)) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = 620823552;
            wXMediaMessage.messageAction = str2;
            wXMediaMessage.messageExt = str3;
            x.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[]{aZ.field_appId, aZ.field_appName, aZ.field_openId});
            if (bh.ov(aZ.field_openId)) {
                x.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", new Object[]{aZ.field_appName});
                an.bip().OI(aZ.field_appId);
            }
            com.tencent.mm.bz.a.post(new 2(context, aZ, wXMediaMessage, aVar));
        } else {
            x.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", new Object[]{aZ.field_appName});
            Toast.makeText(context, context.getString(R.l.emo, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(context, aZ, null)}), 1).show();
            if (aVar != null) {
                aVar.cG(false);
            }
        }
    }

    public static String aPY() {
        String cgv = bh.cgv();
        if (bh.ov(cgv)) {
            cgv = "CN";
        }
        return cgv.toUpperCase();
    }

    public static GameRegionPreference.a cK(Context context) {
        Object cO = cO(context);
        if (bh.ov(cO)) {
            cO = aPY();
        }
        return (GameRegionPreference.a) com.tencent.mm.plugin.game.d.a.a.aRT().aRS().get(cO);
    }

    public static String a(GameRegionPreference.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            String ou = bh.ou(w.cfi());
            if ("zh_CN".equalsIgnoreCase(ou)) {
                stringBuffer.append(aVar.nuB);
            } else if ("zh_TW".equalsIgnoreCase(ou) || "zh_HK".equalsIgnoreCase(ou)) {
                stringBuffer.append(aVar.nuC);
            } else {
                stringBuffer.append(aVar.nuD);
            }
        }
        return stringBuffer.toString();
    }

    public static String BV(String str) {
        String str2;
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = ac.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bh.i(e)});
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bh.i(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = str3;
                } catch (Throwable e22) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bh.i(e22)});
                    str2 = str3;
                }
            } else {
                str2 = str3;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bh.i(e3)});
                }
            }
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            x.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", new Object[]{str2});
            return "";
        } else if ("zh_CN".equalsIgnoreCase(str)) {
            return split[0];
        } else {
            if ("zh_TW".equalsIgnoreCase(str) || "zh_HK".equalsIgnoreCase(str)) {
                return split[1];
            }
            return split[2];
        }
    }

    public static void aPZ() {
        ac.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", w.cfi()).commit();
    }

    public static void Z(Context context, String str) {
        int i = 0;
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (bh.ov(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
        } else if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                string = split[i];
                if (string.contains(str)) {
                    string = str + "-" + valueOf;
                }
                if (i == split.length - 1) {
                    str2 = str2 + string;
                } else {
                    str2 = str2 + string + ",";
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
        }
    }

    public static void cL(Context context) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (!bh.ov(string)) {
            String[] split = string.split(",");
            String str = new String();
            string = str;
            for (String str2 : split) {
                String[] split2 = str2.split("-");
                String str3 = split2[0];
                if (!(bh.ov(str3) || com.tencent.mm.pluginsdk.model.app.g.m(context, str3))) {
                    if (currentTimeMillis - bh.getLong(split2[1], 0) < 86400) {
                        string = string + str2 + ",";
                    } else {
                        FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str3);
                        x.i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", new Object[]{Integer.valueOf(xI.status), Long.valueOf(xI.id)});
                        if (xI.status == 2) {
                            com.tencent.mm.plugin.downloader.model.f.aAd().bX(xI.id);
                        } else if ((xI.status == 0 || xI.status == 4) && e.bO(xI.path)) {
                            b.deleteFile(xI.path);
                        }
                    }
                }
            }
            if (!bh.ov(string)) {
                if (string.charAt(string.length() - 1) == ',') {
                    string = string.substring(0, string.length() - 1);
                }
                sharedPreferences.edit().putString("download_app_id_time_map", string.toString()).apply();
            }
        }
    }

    public static Set<String> cM(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
    }

    public static ShapeDrawable ch(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static int cN(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
    }

    public static void D(Context context, int i) {
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", i).apply();
    }

    public static int aQa() {
        af aQc = i.aQb().aQc();
        return aQc != null ? aQc.ngD : 0;
    }

    public static String cO(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
    }
}
