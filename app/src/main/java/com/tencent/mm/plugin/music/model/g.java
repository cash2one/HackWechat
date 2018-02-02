package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.av.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class g {
    private static final Pattern mXS = Pattern.compile("songid=([0-9]+)");
    private static final String[] oJS = new String[]{"#", "?", "&"};
    private static String oJT = null;
    private static String oJU = null;

    public static String dh(Context context) {
        Throwable th;
        String str = "";
        String packageName = ac.getPackageName();
        if (packageName != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    packageName = str + packageInfo.versionName;
                    try {
                        str = packageName + "." + packageInfo.versionCode;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        str = packageName;
                        th = th2;
                        x.printErrStackTrace("MicroMsg.Music.MusicUtil", th, "", new Object[0]);
                        return str;
                    }
                }
            } catch (NameNotFoundException e2) {
                th = e2;
                x.printErrStackTrace("MicroMsg.Music.MusicUtil", th, "", new Object[0]);
                return str;
            }
        }
        return str;
    }

    public static String b(a aVar, boolean z) {
        ar.Hg();
        File file = new File(c.FC(), "music");
        if (!file.exists()) {
            x.i("MicroMsg.Music.MusicUtil", "create file folder:%b for path:%s", new Object[]{Boolean.valueOf(file.mkdirs()), file.getAbsolutePath()});
        }
        x.d("MicroMsg.Music.MusicUtil", "music name %s path %s", new Object[]{z ? ab.UZ(aVar.field_musicId + "temp") + "-wifi" : ab.UZ(aVar.field_musicId + "temp"), new File(file, z ? ab.UZ(aVar.field_musicId + "temp") + "-wifi" : ab.UZ(aVar.field_musicId + "temp")).getAbsoluteFile()});
        return new File(file, z ? ab.UZ(aVar.field_musicId + "temp") + "-wifi" : ab.UZ(aVar.field_musicId + "temp")).getAbsolutePath();
    }

    public static String FL(String str) {
        ar.Hg();
        File file = new File(c.FC(), "music");
        if (!file.exists()) {
            file.mkdirs();
        }
        x.d("MicroMsg.Music.MusicUtil", "getMusicPieceFilePath music name %s path %s", new Object[]{FQ(str), new File(file, FQ(str)).getAbsoluteFile()});
        return new File(file, FQ(str)).getAbsolutePath();
    }

    public static String c(a aVar, boolean z) {
        return b(aVar, false) + "-thumb-" + z;
    }

    public static boolean FM(String str) {
        if (bh.ov(str)) {
            return false;
        }
        boolean contains;
        Uri parse = Uri.parse(str);
        String str2 = "";
        if (parse != null) {
            str2 = parse.getHost();
        }
        if (str2 != null) {
            contains = parse.getHost().contains(".qq.com");
            x.w("MicroMsg.Music.MusicUtil", "url %s match ? %B", new Object[]{str, Boolean.valueOf(contains)});
        } else {
            x.i("MicroMsg.Music.MusicUtil", "host is null, url is not match .qq.com");
            contains = false;
        }
        return contains;
    }

    public static boolean d(a aVar) {
        x.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[]{aVar.field_songWapLinkUrl, aVar.field_songWebUrl, aVar.field_songWifiUrl});
        if (bh.ov(aVar.field_songWapLinkUrl) && bh.ov(aVar.field_songWebUrl) && bh.ov(aVar.field_songWifiUrl)) {
            return false;
        }
        return true;
    }

    public static String a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        if (z || bh.ov(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (bh.ov(str3)) {
            return str3;
        }
        PString pString = new PString();
        x.i("MicroMsg.Music.MusicUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[]{str, str2, Boolean.valueOf(z)});
        String FN = FN(str3);
        if (FN != null) {
            if (a(FN, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        return pString.value;
    }

    private static String FN(String str) {
        if (bh.ov(str)) {
            return null;
        }
        if (oJT != null && str.equals(oJT)) {
            return oJU;
        }
        int indexOf;
        String str2 = "";
        String str3 = null;
        for (String str22 : oJS) {
            str22 = str22 + "p=";
            if (str.contains(str22)) {
                str3 = str;
            }
            if (str3 != null) {
                break;
            }
        }
        if (str3 == null) {
            return null;
        }
        indexOf = str3.indexOf(str22);
        if (indexOf < 0) {
            x.w("MicroMsg.Music.MusicUtil", "pIndex is %d, return", new Object[]{Integer.valueOf(indexOf)});
            return null;
        }
        String substring = str3.substring(str22.length() + indexOf);
        for (String indexOf2 : oJS) {
            int indexOf3 = substring.indexOf(indexOf2);
            if (indexOf3 > 0) {
                substring = substring.substring(0, indexOf3);
            }
        }
        if (substring == null) {
            return substring;
        }
        oJT = str;
        oJU = substring;
        return substring;
    }

    private static boolean a(String str, boolean z, PString pString) {
        String str2 = new String(FO(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            str2 = jSONObject.getString("song_WifiURL");
            x.d("MicroMsg.Music.MusicUtil", "waplive: " + string + "  wifi:" + str2);
            if (!z) {
                str2 = string;
            }
            pString.value = str2;
            return true;
        } catch (Throwable e) {
            pString.value = str;
            x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "decodeJson", new Object[0]);
            return false;
        }
    }

    private static byte[] FO(String str) {
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            try {
                int i3 = i + 1;
                int m = m(str.charAt(i));
                if (i3 < str.length()) {
                    i = i3 + 1;
                    i3 = m(str.charAt(i3));
                } else {
                    i = i3;
                    i3 = 0;
                }
                int i4 = i2 + 1;
                bArr[i2] = (byte) (i3 | (m << 4));
                i2 = i4;
            } catch (Exception e) {
                return null;
            }
        }
        return bArr;
    }

    private static int FP(String str) {
        int i = 0;
        if (!bh.ov(str)) {
            Matcher matcher = mXS.matcher(str);
            if (matcher.find()) {
                try {
                    i = Integer.valueOf(matcher.group(1)).intValue();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getSongId", new Object[i]);
                }
            }
        }
        return i;
    }

    private static int m(char c) {
        if (c >= '1' && c <= '9') {
            return c - 48;
        }
        if (c < 'A' || c > 'F') {
            return 0;
        }
        return (c - 65) + 10;
    }

    private static String g(asv com_tencent_mm_protocal_c_asv) {
        String str;
        String FN;
        if (com_tencent_mm_protocal_c_asv != null) {
            if (!bh.ov(com_tencent_mm_protocal_c_asv.wAo)) {
                str = com_tencent_mm_protocal_c_asv.wAo;
            } else if (!bh.ov(com_tencent_mm_protocal_c_asv.wAq)) {
                str = com_tencent_mm_protocal_c_asv.wAq;
            } else if (!bh.ov(com_tencent_mm_protocal_c_asv.wAp)) {
                str = com_tencent_mm_protocal_c_asv.wAp;
            }
            if (str == null) {
                return null;
            }
            FN = FN(com_tencent_mm_protocal_c_asv.wAo);
            if (FN == null) {
                return FN;
            }
            FN = FN(com_tencent_mm_protocal_c_asv.wAq);
            if (FN != null) {
                return FN(com_tencent_mm_protocal_c_asv.wAp);
            }
            return FN;
        }
        str = null;
        if (str == null) {
            return null;
        }
        FN = FN(com_tencent_mm_protocal_c_asv.wAo);
        if (FN == null) {
            return FN;
        }
        FN = FN(com_tencent_mm_protocal_c_asv.wAq);
        if (FN != null) {
            return FN;
        }
        return FN(com_tencent_mm_protocal_c_asv.wAp);
    }

    public static asv h(asv com_tencent_mm_protocal_c_asv) {
        if (com_tencent_mm_protocal_c_asv != null) {
            com_tencent_mm_protocal_c_asv.wmR = FP(com_tencent_mm_protocal_c_asv.wAo);
            if (com_tencent_mm_protocal_c_asv.wmR <= 0) {
                com_tencent_mm_protocal_c_asv.wmR = FP(com_tencent_mm_protocal_c_asv.wAq);
                if (com_tencent_mm_protocal_c_asv.wmR <= 0) {
                    com_tencent_mm_protocal_c_asv.wmR = FP(com_tencent_mm_protocal_c_asv.wAp);
                    int i = com_tencent_mm_protocal_c_asv.wmR;
                }
            }
        }
        if (!(com_tencent_mm_protocal_c_asv == null || g(com_tencent_mm_protocal_c_asv) == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            String g = g(com_tencent_mm_protocal_c_asv);
            if (g != null) {
                x.d("MicroMsg.Music.MusicUtil", "bcdUrl: %s", new Object[]{g});
                String str = new String(FO(g));
                int indexOf = str.indexOf("{");
                if (indexOf != -1) {
                    str = str.substring(indexOf);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    com_tencent_mm_protocal_c_asv.wmR = jSONObject.optInt("song_ID");
                    if (bh.ov(com_tencent_mm_protocal_c_asv.wAk)) {
                        com_tencent_mm_protocal_c_asv.wAk = jSONObject.optString("song_Name");
                    }
                    if (bh.ov(com_tencent_mm_protocal_c_asv.wAp)) {
                        com_tencent_mm_protocal_c_asv.wAp = jSONObject.optString("song_WapLiveURL");
                    }
                    if (bh.ov(com_tencent_mm_protocal_c_asv.wAo)) {
                        com_tencent_mm_protocal_c_asv.wAo = jSONObject.optString("song_WifiURL");
                    }
                    if (bh.ov(com_tencent_mm_protocal_c_asv.wAm)) {
                        com_tencent_mm_protocal_c_asv.wAm = jSONObject.optString("song_Album");
                    }
                    if (bh.ov(com_tencent_mm_protocal_c_asv.wAl)) {
                        com_tencent_mm_protocal_c_asv.wAl = jSONObject.optString("song_Singer");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "", new Object[0]);
                }
                if (com_tencent_mm_protocal_c_asv.wmR == 0) {
                    com_tencent_mm_protocal_c_asv.wmR = FP(oJT);
                }
                x.i("MicroMsg.Music.MusicUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[]{com_tencent_mm_protocal_c_asv.vVZ, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(com_tencent_mm_protocal_c_asv.wmR)});
            }
        }
        return com_tencent_mm_protocal_c_asv;
    }

    public static String i(asv com_tencent_mm_protocal_c_asv) {
        if (com_tencent_mm_protocal_c_asv.wAi == 6) {
            return "6_" + ab.UZ(com_tencent_mm_protocal_c_asv.vVZ);
        }
        return "0_" + ab.UZ(com_tencent_mm_protocal_c_asv.vVZ);
    }

    public static String FQ(String str) {
        return "piece" + ab.UZ(str.hashCode());
    }

    public static void a(asv com_tencent_mm_protocal_c_asv, Activity activity) {
        com.tencent.mm.plugin.report.service.g.pQN.k(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        b cfVar = new cf();
        ve veVar = new ve();
        vk vkVar = new vk();
        uq uqVar = new uq();
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(5);
        vkVar.fC(bh.Wp());
        vkVar.Uo(k(com_tencent_mm_protocal_c_asv));
        uqVar.Tx(com_tencent_mm_protocal_c_asv.wAo);
        uqVar.Ty(com_tencent_mm_protocal_c_asv.wAp);
        uqVar.Tw(com_tencent_mm_protocal_c_asv.wAq);
        a Gx = h.bdA().Gx(i(com_tencent_mm_protocal_c_asv));
        if (Gx.Qm()) {
            uqVar.Tz(Gx.field_songHAlbumUrl);
        } else {
            uqVar.Tz(Gx.field_songAlbumUrl);
        }
        uqVar.ls(true);
        String j = j(com_tencent_mm_protocal_c_asv);
        if (FileOp.bO(j)) {
            uqVar.TF(j);
        } else {
            uqVar.lt(true);
        }
        uqVar.Tq(com_tencent_mm_protocal_c_asv.wAk);
        uqVar.Tr(com_tencent_mm_protocal_c_asv.wAl);
        uqVar.CJ(7);
        cfVar.fqp.title = com_tencent_mm_protocal_c_asv.wAk;
        cfVar.fqp.desc = com_tencent_mm_protocal_c_asv.wAl;
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 7;
        veVar.a(vkVar);
        veVar.weU.add(uqVar);
        cfVar.fqp.activity = activity;
        cfVar.fqp.fqw = 3;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
    }

    public static boolean b(asv com_tencent_mm_protocal_c_asv, Activity activity) {
        com.tencent.mm.plugin.report.service.g.pQN.k(10910, "4");
        if (com_tencent_mm_protocal_c_asv == null) {
            return false;
        }
        String str;
        String str2 = com_tencent_mm_protocal_c_asv.wAq;
        int indexOf = str2 == null ? -1 : str2.indexOf("#p=");
        if ((indexOf < 0 ? null : str2.substring(indexOf + 3)) == null) {
            x.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[]{str2});
            str = "androidqqmusic://";
        } else {
            x.i("MicroMsg.Music.MusicUtil", "get qq music data %s", new Object[]{indexOf < 0 ? null : str2.substring(indexOf + 3)});
            str = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[]{str});
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            x.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[]{str});
            return false;
        }
        com.tencent.mm.av.b.Qo();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bh.k(activity, intent)) {
            activity.startActivity(intent);
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", str2);
        b.ifs.j(intent, activity);
        return false;
    }

    public static void A(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("scene_from", 6);
        d.a(activity, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    public static void a(asv com_tencent_mm_protocal_c_asv, Intent intent, MMActivity mMActivity) {
        String stringExtra = intent.getStringExtra("Select_Conv_User");
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = com_tencent_mm_protocal_c_asv.wAq;
        wXMusicObject.musicDataUrl = com_tencent_mm_protocal_c_asv.wAo;
        wXMusicObject.musicLowBandUrl = com_tencent_mm_protocal_c_asv.wAp;
        wXMusicObject.musicLowBandDataUrl = com_tencent_mm_protocal_c_asv.wAp;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = com_tencent_mm_protocal_c_asv.wAk;
        wXMediaMessage.description = com_tencent_mm_protocal_c_asv.wAl;
        Bitmap bitmap = null;
        String j = j(com_tencent_mm_protocal_c_asv);
        if (j != null && FileOp.bO(j)) {
            int dimension = (int) mMActivity.getResources().getDimension(R.f.bvD);
            bitmap = com.tencent.mm.sdk.platformtools.d.Y(j, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bh.U(bitmap);
        } else {
            wXMediaMessage.thumbData = bh.U(com.tencent.mm.sdk.platformtools.d.CZ(R.g.bBD));
        }
        b.ifs.a(mMActivity, k(com_tencent_mm_protocal_c_asv), wXMediaMessage, stringExtra, l(com_tencent_mm_protocal_c_asv));
        x.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[]{stringExtra});
    }

    public static void c(asv com_tencent_mm_protocal_c_asv, Activity activity) {
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = com_tencent_mm_protocal_c_asv.wAq;
        wXMusicObject.musicDataUrl = com_tencent_mm_protocal_c_asv.wAo;
        wXMusicObject.musicLowBandUrl = com_tencent_mm_protocal_c_asv.wAp;
        wXMusicObject.musicLowBandDataUrl = com_tencent_mm_protocal_c_asv.wAp;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = com_tencent_mm_protocal_c_asv.wAk;
        wXMediaMessage.description = com_tencent_mm_protocal_c_asv.wAl;
        Bitmap bitmap = null;
        String j = j(com_tencent_mm_protocal_c_asv);
        if (j != null && FileOp.bO(j)) {
            int dimension = (int) activity.getResources().getDimension(R.f.bvD);
            bitmap = com.tencent.mm.sdk.platformtools.d.Y(j, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bh.U(bitmap);
        } else {
            wXMediaMessage.thumbData = bh.U(com.tencent.mm.sdk.platformtools.d.CZ(R.g.bBD));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", com_tencent_mm_protocal_c_asv.vVZ);
        intent.putExtra("Ksnsupload_appid", k(com_tencent_mm_protocal_c_asv));
        intent.putExtra("Ksnsupload_appname", l(com_tencent_mm_protocal_c_asv));
        String hz = u.hz("music_player");
        u.GK().t(hz, true).o("prePublishId", "music_player");
        intent.putExtra("reportSessionId", hz);
        b.ifs.n(intent, activity);
    }

    private static String j(asv com_tencent_mm_protocal_c_asv) {
        String str = "";
        a Gx = h.bdA().Gx(i(com_tencent_mm_protocal_c_asv));
        if (Gx != null) {
            str = c(Gx, true);
            if (!FileOp.bO(str)) {
                switch (com_tencent_mm_protocal_c_asv.wAi) {
                    case 0:
                        str = o.Pw().B(com_tencent_mm_protocal_c_asv.wAs, true);
                        break;
                    case 4:
                        str = com.tencent.mm.pluginsdk.q.a.bXY().Jf(com_tencent_mm_protocal_c_asv.wAn);
                        if (bh.ov(str)) {
                            str = com_tencent_mm_protocal_c_asv.wAs;
                            break;
                        }
                        break;
                    case 5:
                        if (com_tencent_mm_protocal_c_asv.wAs != null) {
                            str = com_tencent_mm_protocal_c_asv.wAs;
                            break;
                        }
                        str = "";
                        break;
                    case 6:
                        if (com_tencent_mm_protocal_c_asv.wAs != null) {
                            str = com_tencent_mm_protocal_c_asv.wAs;
                            break;
                        }
                        str = "";
                        break;
                    case 7:
                    case 10:
                    case 11:
                        if (com_tencent_mm_protocal_c_asv.wAs != null) {
                            str = com_tencent_mm_protocal_c_asv.wAs;
                            break;
                        }
                        str = "";
                        break;
                    default:
                        if (n.qQz != null) {
                            aqr com_tencent_mm_protocal_c_aqr = new aqr();
                            com_tencent_mm_protocal_c_aqr.nGJ = com_tencent_mm_protocal_c_asv.vZq;
                            com_tencent_mm_protocal_c_aqr.wxE = com_tencent_mm_protocal_c_asv.wAn;
                            com_tencent_mm_protocal_c_aqr.wxF = com_tencent_mm_protocal_c_asv.wAu;
                            com_tencent_mm_protocal_c_aqr.nfX = com_tencent_mm_protocal_c_aqr.wxE;
                            str = n.qQy.a(com_tencent_mm_protocal_c_aqr);
                            break;
                        }
                        break;
                }
            }
            x.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[]{str});
        }
        return str;
    }

    public static String k(asv com_tencent_mm_protocal_c_asv) {
        String str = com_tencent_mm_protocal_c_asv.ngo;
        if (!bh.ov(str)) {
            return str;
        }
        switch (com_tencent_mm_protocal_c_asv.wAi) {
            case 4:
                return "wx485a97c844086dc9";
            case 5:
                return "wx482a4001c37e2b74";
            default:
                return str;
        }
    }

    private static String l(asv com_tencent_mm_protocal_c_asv) {
        switch (com_tencent_mm_protocal_c_asv.wAi) {
            case 0:
            case 1:
            case 8:
                return ac.getContext().getString(R.l.ePV);
            case 4:
                return ac.getContext().getString(R.l.eOG);
            case 5:
                return ac.getContext().getString(R.l.eHR);
            default:
                return ac.getContext().getString(R.l.dYi);
        }
    }

    public static void B(Activity activity) {
        ar.Hg();
        if (((Boolean) c.CU().get(82, Boolean.valueOf(true))).booleanValue()) {
            ar.Hg();
            c.CU().set(82, Boolean.valueOf(false));
            switch (h.bdz().bdo().field_musicType) {
                case 0:
                    I(activity, R.l.eOg);
                    return;
                case 1:
                case 8:
                    I(activity, R.l.eOj);
                    return;
                case 4:
                    I(activity, R.l.eOi);
                    return;
                case 6:
                    I(activity, R.l.eOh);
                    return;
                default:
                    return;
            }
        } else if (h.bdz().mode == 2) {
            Toast.makeText(ac.getContext(), R.l.eQq, 0).show();
        } else {
            Toast.makeText(ac.getContext(), R.l.eQr, 0).show();
        }
    }

    public static boolean tr(int i) {
        switch (i) {
            case 10:
            case 11:
                return true;
            default:
                return com.tencent.mm.plugin.music.model.g.g.tG(i);
        }
    }

    public static boolean m(asv com_tencent_mm_protocal_c_asv) {
        if (com_tencent_mm_protocal_c_asv == null || TextUtils.isEmpty(com_tencent_mm_protocal_c_asv.protocol)) {
            return false;
        }
        x.d("MicroMsg.Music.MusicUtil", "protocol:%s", new Object[]{com_tencent_mm_protocal_c_asv.protocol});
        if ("hls".equalsIgnoreCase(com_tencent_mm_protocal_c_asv.protocol)) {
            return true;
        }
        return false;
    }

    public static boolean e(a aVar) {
        if (aVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.field_songWifiUrl) && TextUtils.isEmpty(aVar.field_songWapLinkUrl) && TextUtils.isEmpty(aVar.field_songWebUrl)) {
            return false;
        }
        return true;
    }

    public static void C(String str, String str2, int i) {
        x.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[]{str, str2, Integer.valueOf(i)});
        b qpVar = new qp();
        qpVar.fIi.appId = str;
        qpVar.fIi.fIm = -1;
        qpVar.fIi.fIl = i;
        qpVar.fIi.userName = str2;
        qpVar.fIi.scene = 1056;
        if (i == 1) {
            qpVar.fIi.fIo = true;
        }
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
    }

    private static i I(Context context, int i) {
        i.a aVar = new i.a(context);
        aVar.Ez(R.l.dGO);
        aVar.EA(i);
        aVar.EC(R.l.ewp).a(null);
        aVar.mi(true);
        i akx = aVar.akx();
        akx.show();
        return akx;
    }

    public static int ck(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.valueOf(str).intValue();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getInt", new Object[0]);
            }
        }
        return i;
    }
}
