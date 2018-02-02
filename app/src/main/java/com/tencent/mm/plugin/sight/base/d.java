package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class d {
    private static int oqt = 0;
    private static int oqu = 0;

    public static boolean bsB() {
        if (q.gFW.gGF == 0) {
            return false;
        }
        return com.tencent.mm.compatible.util.d.fM(14);
    }

    public static String Jp(String str) {
        return bh.az(str, "") + ".thumb";
    }

    public static String Jq(String str) {
        return bh.az(str, "") + ".soundmp4";
    }

    public static Bitmap R(String str, int i, int i2) {
        if (bh.ov(str)) {
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail != null) {
            return com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, i2, i, true, true);
        }
        x.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", new Object[]{str});
        return createVideoThumbnail;
    }

    public static boolean Jr(String str) {
        if (bh.ov(str) || !e.bO(str)) {
            return false;
        }
        long Wq = bh.Wq();
        c cVar = new c();
        int isSightOk = SightVideoJNI.isSightOk(str, cVar.qte, cVar.qtf, cVar.qtg, cVar.qti, cVar.qth, cVar.qth.length);
        x.d("MicroMsg.SightUtil", "ashu::check sight use %dms", new Object[]{Long.valueOf(bh.bA(Wq))});
        return isSightOk == 0;
    }

    public static String bsC() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.TITLE_LENGTH_LIMIT);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ac.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fdS);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.xdY);
        stringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.vAs);
        stringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.vAt);
        stringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.vAu);
        stringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.vAv);
        stringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.vAw);
        stringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.vAx);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.bnD, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.SightUtil", "check data size failed :%s", new Object[]{e.getMessage()});
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public static String Ff(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extInfo: \n" + a(str, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()));
        stringBuffer.append("size: " + bh.bx(FileOp.me(str)) + ":" + str + "\n");
        String mp4RecordInfo = SightVideoJNI.getMp4RecordInfo(str);
        if (!bh.ov(mp4RecordInfo)) {
            stringBuffer.append(mp4RecordInfo);
        }
        stringBuffer.append("isH265:").append(com.tencent.mm.modelvideo.q.no(str));
        return stringBuffer.toString();
    }

    public static String a(String str, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            x.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[]{SightVideoJNI.getSimpleMp4Info(str)});
            JSONObject jSONObject = new JSONObject(r0);
            pInt.value = (int) jSONObject.getDouble("videoDuration");
            pInt2.value = jSONObject.getInt("videoWidth");
            pInt3.value = jSONObject.getInt("videoHeight");
            pInt4.value = (int) jSONObject.getDouble("videoFPS");
            pInt5.value = jSONObject.getInt("videoBitrate");
            stringBuffer.append("videoBitrate: ").append(pInt5.value).append("\n");
            stringBuffer.append("videoWidth,videoHeight: ").append(pInt2.value).append("*").append(pInt3.value);
            stringBuffer.append(" ").append(String.format("%.4f", new Object[]{Double.valueOf((((double) pInt2.value) * 1.0d) / ((double) pInt3.value))})).append("\n");
            stringBuffer.append("videoDuration: ").append(pInt.value).append("\n");
            stringBuffer.append("videoFPS: ").append(pInt4.value).append("\n");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightUtil", e, "get media info error", new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static a Js(String str) {
        a aVar = null;
        if (!bh.ov(str) && e.bO(str)) {
            aVar = new a();
            try {
                x.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[]{SightVideoJNI.getSimpleMp4Info(str)});
                JSONObject jSONObject = new JSONObject(r1);
                aVar.mxs = (int) jSONObject.getDouble("videoDuration");
                aVar.width = jSONObject.getInt("videoWidth");
                aVar.height = jSONObject.getInt("videoHeight");
                aVar.owg = (int) jSONObject.getDouble("videoFPS");
                aVar.videoBitrate = jSONObject.getInt("videoBitrate");
                aVar.huc = jSONObject.getInt("audioBitrate");
                aVar.qsT = jSONObject.getInt("audioChannel");
            } catch (Exception e) {
                x.e("MicroMsg.SightUtil", "get media info error %s", new Object[]{e.toString()});
            }
            x.i("MicroMsg.SightUtil", "get media %s", new Object[]{aVar});
        }
        return aVar;
    }
}
