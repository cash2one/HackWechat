package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bi.a;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class h {
    public static String tQS = (a.Vg() + "/fav_fileicon_video.png");
    public static String tQT = (a.Vg() + "/fav_fileicon_music.png");
    public static String tQU = (a.Vg() + "/fav_list_img_default.png");
    public static String tQV = (a.Vg() + "/fav_fileicon_zip.png");
    public static String tQW = (a.Vg() + "/fav_fileicon_word.png");
    public static String tQX = (a.Vg() + "/fav_fileicon_ppt.png");
    public static String tQY = (a.Vg() + "/fav_fileicon_xls.png");
    public static String tQZ = (a.Vg() + "/fav_fileicon_txt.png");
    public static String tRa = (a.Vg() + "/fav_fileicon_pdf.png");
    public static String tRb = (a.Vg() + "/fav_fileicon_unknow.png");
    private static Map<String, String> tRc;
    private static String[] tRd = new String[]{"<div>", "<div/>", "<object", "<br", "</"};
    private static String[] tRe = new String[]{"＜div>", "＜div/>", "＜object", "＜br", "＜/"};
    private static LinkedList<vc> tRf = null;
    private static String tRg = "";

    private static void ag(JSONObject jSONObject) {
        b kpVar = new kp();
        kpVar.fBX.type = 6;
        kpVar.fBX.fBZ = jSONObject.toString();
        kpVar.fBX.fBO = "";
        com.tencent.mm.sdk.b.a.xef.m(kpVar);
    }

    public static void l(Context context, String str, int i) {
        if (!bh.ov(str) && new File(str).exists()) {
            JSONObject jSONObject = new JSONObject();
            try {
                int bv = (int) f.bv((long) i);
                jSONObject.put(DownloadSettingTable$Columns.TYPE, 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", bv);
                jSONObject.put("lengthStr", f.s(context, bv));
                jSONObject.put("iconPath", a.Vg() + "/fav_fileicon_recording.png");
                ag(jSONObject);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void QK(String str) {
        if (!bh.ov(str)) {
            File file = new File(str);
            if (file.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DownloadSettingTable$Columns.TYPE, 5);
                    jSONObject.put("downloaded", true);
                    jSONObject.put("title", file.getName());
                    jSONObject.put("content", f.ah((float) e.bN(str)));
                    jSONObject.put("iconPath", QM(e.bQ(str)));
                    jSONObject.put("localPath", str);
                    ag(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void QL(String str) {
        x.i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        x.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        Object obj = a.Vi() + "/" + g.s((new com.tencent.mm.pluginsdk.location.b(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt("scale"), 1).toString()).getBytes()) + ".png";
        x.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[]{obj});
        if (FileOp.bO(obj)) {
            x.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (e.bO(obj)) {
            x.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            x.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[]{obj});
            obj = d.tQE;
        }
        jSONObject.put("localPath", obj);
        ag(jSONObject);
    }

    public static void aa(ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jSONObject.put(DownloadSettingTable$Columns.TYPE, 2);
                jSONObject.put("downloaded", true);
                String fa = c.fa(str, "");
                str = c.fb(str, "");
                if (!bh.ov(fa) && !bh.ov(str)) {
                    jSONObject.put("bigImagePath", fa);
                    jSONObject.put("localPath", str);
                    ag(jSONObject);
                } else {
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void aQ(Context context, String str) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (!bh.ov(str)) {
            i = (int) k.bVQ().duration;
            int bv = (int) f.bv((long) i);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i);
                jSONObject.put("lengthStr", f.s(context, bv));
                jSONObject.put("iconPath", a.Vg() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        try {
            jSONObject.put(DownloadSettingTable$Columns.TYPE, 4);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
        }
        i = k.bVQ().tRo;
        b kpVar = new kp();
        kpVar.fBX.type = 6;
        kpVar.fBX.fBZ = jSONObject.toString();
        kpVar.fBX.fBO = Integer.toString(i);
        com.tencent.mm.sdk.b.a.xef.m(kpVar);
    }

    static {
        tRc = new HashMap();
        Map hashMap = new HashMap();
        tRc = hashMap;
        hashMap.put("avi", tQS);
        tRc.put("m4v", tQS);
        tRc.put("vob", tQS);
        tRc.put("mpeg", tQS);
        tRc.put("mpe", tQS);
        tRc.put("asx", tQS);
        tRc.put("asf", tQS);
        tRc.put("f4v", tQS);
        tRc.put("flv", tQS);
        tRc.put("mkv", tQS);
        tRc.put("wmv", tQS);
        tRc.put("wm", tQS);
        tRc.put("3gp", tQS);
        tRc.put("mp4", tQS);
        tRc.put("rmvb", tQS);
        tRc.put("rm", tQS);
        tRc.put("ra", tQS);
        tRc.put("ram", tQS);
        tRc.put("mp3pro", tQT);
        tRc.put("vqf", tQT);
        tRc.put("cd", tQT);
        tRc.put("md", tQT);
        tRc.put("mod", tQT);
        tRc.put("vorbis", tQT);
        tRc.put("au", tQT);
        tRc.put("amr", tQT);
        tRc.put("silk", tQT);
        tRc.put("wma", tQT);
        tRc.put("mmf", tQT);
        tRc.put("mid", tQT);
        tRc.put("midi", tQT);
        tRc.put("mp3", tQT);
        tRc.put("aac", tQT);
        tRc.put("ape", tQT);
        tRc.put("aiff", tQT);
        tRc.put("aif", tQT);
        tRc.put("jfif", tQU);
        tRc.put("tiff", tQU);
        tRc.put("tif", tQU);
        tRc.put("jpe", tQU);
        tRc.put("dib", tQU);
        tRc.put("jpeg", tQU);
        tRc.put("jpg", tQU);
        tRc.put("png", tQU);
        tRc.put("bmp", tQU);
        tRc.put("gif", tQU);
        tRc.put("rar", tQV);
        tRc.put("zip", tQV);
        tRc.put("7z", tQV);
        tRc.put("iso", tQV);
        tRc.put("cab", tQV);
        tRc.put("doc", tQW);
        tRc.put("docx", tQW);
        tRc.put("ppt", tQX);
        tRc.put("pptx", tQX);
        tRc.put("xls", tQY);
        tRc.put("xlsx", tQY);
        tRc.put("txt", tQZ);
        tRc.put("rtf", tQZ);
        tRc.put("pdf", tRa);
        tRc.put("unknown", tRb);
    }

    public static String QM(String str) {
        String str2 = (String) tRc.get(str);
        if (str2 == null) {
            return (String) tRc.get("unknown");
        }
        return str2;
    }

    public static ArrayList<com.tencent.mm.plugin.wenote.model.a.b> a(Object obj, List<String> list, boolean z) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        Collection arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) it.next();
            if (bVar.getType() != 1) {
                arrayList2.add(bVar);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            if (str.trim().equals("<ThisisNoteNodeHrObj>")) {
                com.tencent.mm.plugin.wenote.model.a.g gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                gVar.tRt = false;
                gVar.tRz = false;
                arrayList2.add(i, gVar);
            } else if (!str.trim().equals("<ThisisNoteNodeObj>")) {
                com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                hVar.content = str;
                hVar.tRt = false;
                hVar.tRz = false;
                hVar.mvG = f.QI(hVar.toString());
                if (i < arrayList2.size()) {
                    arrayList2.add(i, hVar);
                } else {
                    arrayList2.add(hVar);
                }
            }
        }
        if (z) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        return arrayList2;
    }

    public static void Bl(int i) {
        LinkedList linkedList;
        tRf = null;
        tRg = "";
        String bWw = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWw();
        tRg = bWw;
        LinkedList linkedList2 = new LinkedList();
        ve QP = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().QP(bWw);
        if (QP == null || QP.weU.size() <= 1) {
            linkedList = null;
        } else {
            Iterator it = QP.weU.iterator();
            while (it.hasNext()) {
                uq uqVar = (uq) it.next();
                String o = f.o(uqVar);
                if (!bh.ov(o) && uqVar.bjS == 2 && e.bO(o)) {
                    vc vcVar = new vc();
                    vcVar.vZL = uqVar.wda;
                    vcVar.vZO = uqVar.wcL;
                    vcVar.weO = uqVar.wcJ;
                    linkedList2.add(vcVar);
                }
            }
            linkedList = linkedList2;
        }
        tRf = linkedList;
        ar.CG().a(new b(i, 1, tRg, tRf, null), 0);
    }

    public static void a(Context context, Bitmap bitmap, boolean z) {
        com.tencent.mm.plugin.report.service.g gVar;
        Object[] objArr;
        String on = d.on("jpg");
        if (bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, on, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                x.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(0);
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(3);
                objArr[4] = Integer.valueOf(z ? 1 : 0);
                gVar.h(14811, objArr);
                on = "";
            }
        } else {
            x.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
            gVar = com.tencent.mm.plugin.report.service.g.pQN;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            gVar.h(14811, objArr);
            on = "";
        }
        if (!bh.ov(on)) {
            d.b(on, context);
        }
        File file = new File(on);
        if (file.exists()) {
            long length = file.length() / 1024;
            int i = 0;
            int i2 = 0;
            if (bitmap != null) {
                i = bitmap.getWidth();
                i2 = bitmap.getHeight();
                bitmap.recycle();
            }
            int i3 = i2;
            int i4 = i;
            vc vcVar = new vc();
            vcVar.vZL = g.bV(on);
            ar.CG().a(new b(0, 2, tRg, tRf, vcVar), 0);
            gVar = com.tencent.mm.plugin.report.service.g.pQN;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(i4);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Long.valueOf(length);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            gVar.h(14811, objArr);
        }
    }

    public static void aR(Context context, String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
            return;
        }
        b cfVar = new cf();
        b qnVar = new qn();
        qnVar.fIc.fIf = str;
        qnVar.fIc.fIg = cfVar;
        qnVar.fIc.url = "";
        com.tencent.mm.sdk.b.a.xef.m(qnVar);
        if (qnVar.fId.fpW) {
            cfVar.fqp.activity = (Activity) context;
            cfVar.fqp.fqw = 28;
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
            return;
        }
        if (cfVar.fqp.fqv == 0) {
            cfVar.fqp.fqv = R.l.efp;
        }
        com.tencent.mm.ui.base.h.h(context, cfVar.fqp.fqv, 0);
    }
}
