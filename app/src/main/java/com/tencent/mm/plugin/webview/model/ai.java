package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ai {
    public static String Op(String str) {
        File file = new File(e.gHu);
        if (!file.mkdirs()) {
            x.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + file.exists());
        }
        if (!file.exists()) {
            x.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[]{e.gHu});
        }
        x.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[]{str, file.getAbsolutePath() + File.separator + str + ".jpg"});
        return file.getAbsolutePath() + File.separator + str + ".jpg";
    }

    public static Intent Oq(String str) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(Op(str))));
        return intent;
    }

    public static Intent bQS() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    public static Intent bQT() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public static String Or(String str) {
        x.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[]{str});
        if (bh.ov(str)) {
            return null;
        }
        x.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[]{str, "weixin://resourceid/" + ab.UZ(str)});
        return "weixin://resourceid/" + ab.UZ(str);
    }

    public static String Os(String str) {
        WebViewJSSDKFileItem Oo = f.bRB().Oo(str);
        if (Oo != null) {
            x.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[]{Oo.jip});
            return Oo.jip;
        }
        x.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[]{str});
        return null;
    }

    public static String X(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put((String) arrayList.get(i));
        }
        return jSONArray.toString();
    }

    public static String Y(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                jSONStringer.key("localId");
                jSONStringer.value(str);
            }
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String b(String str, String str2, int i, int i2, int i3, int i4) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key("localId");
            jSONStringer.value(str);
            jSONStringer.key("thumbLocalId");
            jSONStringer.value(str2);
            jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
            jSONStringer.value(String.valueOf(i));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    private static InputStream Ot(String str) {
        x.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", new Object[]{str});
        if (bh.ov(str) || bh.ov(str) || !com.tencent.mm.a.e.bO(str)) {
            return null;
        }
        try {
            return new FileInputStream(str);
        } catch (Exception e) {
            x.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static InputStream Ou(String str) {
        if (!bh.ov(str)) {
            return Ot(str);
        }
        x.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
        return null;
    }

    public static String Ov(String str) {
        return "_USER_FOR_WEBVIEW_JSAPI" + o.k(str, bh.Wp());
    }
}
