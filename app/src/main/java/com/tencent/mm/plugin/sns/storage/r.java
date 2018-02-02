package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.by.h;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.n.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.aqo;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public final class r extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )"};
    private static int qOZ = 0;
    private static int qOh = 0;
    private static Point qWe = new Point();
    public h hhp;

    public r(h hVar) {
        this.hhp = hVar;
    }

    public static void dB(int i, int i2) {
        qOZ = i;
        qOh = i2;
        x.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static String LA(String str) {
        if (str == null) {
            return "";
        }
        String s = g.s(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (s.length() > 0) {
            str2 = s.charAt(0) + "/";
        }
        if (s.length() >= 2) {
            str3 = s.charAt(1) + "/";
        }
        return ae.getAccSnsPath() + str2 + str3;
    }

    public final boolean a(String str, q qVar) {
        x.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList " + str);
        Cursor a = this.hhp.a("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            a.close();
            x.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
            if (qVar != null) {
                if (((int) this.hhp.insert("SnsMedia", "local_id", qVar.byL())) != -1) {
                    return true;
                }
            }
            return false;
        }
        a.close();
        return this.hhp.update("SnsMedia", qVar.byL(), "StrId=?", new String[]{str}) > 0;
    }

    public final int a(int i, q qVar) {
        return this.hhp.update("SnsMedia", qVar.byL(), "local_id=?", new String[]{String.valueOf(i)});
    }

    public final q LB(String str) {
        q qVar = new q();
        Cursor a = this.hhp.a("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            qVar.b(a);
            a.close();
            return qVar;
        }
        a.close();
        return null;
    }

    public final q eS(long j) {
        q qVar = new q();
        Cursor a = this.hhp.a("SnsMedia", null, "local_id=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            qVar.b(a);
            a.close();
            return qVar;
        }
        a.close();
        return null;
    }

    public final List<com.tencent.mm.plugin.sns.data.h> bR(List<com.tencent.mm.plugin.sns.data.h> list) {
        List<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (com.tencent.mm.plugin.sns.data.h hVar : list) {
            int a = a(hVar);
            if (a == -1) {
                return null;
            }
            com.tencent.mm.plugin.sns.data.h hVar2 = new com.tencent.mm.plugin.sns.data.h(a, hVar.type);
            hVar2.height = hVar.height;
            hVar2.width = hVar.width;
            hVar2.fileSize = hVar.fileSize;
            linkedList.add(hVar2);
        }
        return linkedList;
    }

    private static com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h hVar, String str) {
        InputStream jVar;
        Throwable th;
        Throwable e;
        int i;
        int i2;
        InputStream inputStream = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream = FileOp.openRead(str);
            try {
                if (inputStream instanceof FileInputStream) {
                    jVar = new com.tencent.mm.sdk.platformtools.j((FileInputStream) inputStream);
                } else {
                    jVar = inputStream;
                }
            } catch (Throwable e2) {
                jVar = inputStream;
                th = e2;
                i = 0;
                try {
                    x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                    if (jVar == null) {
                        i2 = 0;
                    } else {
                        try {
                            jVar.close();
                            i2 = 0;
                        } catch (IOException e3) {
                            i2 = 0;
                        }
                    }
                    hVar.width = i2;
                    hVar.height = i;
                    hVar.fileSize = (int) FileOp.me(str);
                    return hVar;
                } catch (Throwable th2) {
                    e2 = th2;
                    if (jVar != null) {
                        try {
                            jVar.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e2;
                }
            } catch (Throwable th3) {
                e2 = th3;
                jVar = inputStream;
                if (jVar != null) {
                    jVar.close();
                }
                throw e2;
            }
            try {
                jVar.mark(1048576);
                BitmapFactory.decodeStream(jVar, null, options);
                jVar.reset();
                Exif exif = new Exif();
                exif.parseFromStream(jVar);
                i = exif.getOrientationInDegree();
                int i3;
                if (i == 90 || i == 270) {
                    try {
                        i3 = options.outWidth;
                        i2 = options.outHeight;
                        i = i3;
                    } catch (Throwable e22) {
                        Throwable th4 = e22;
                        i = i2;
                        th = th4;
                        x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                        if (jVar == null) {
                            jVar.close();
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                        hVar.width = i2;
                        hVar.height = i;
                        hVar.fileSize = (int) FileOp.me(str);
                        return hVar;
                    }
                }
                i3 = options.outHeight;
                i2 = options.outWidth;
                i = i3;
                if (jVar != null) {
                    try {
                        jVar.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable e222) {
                th = e222;
                i = 0;
                x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                if (jVar == null) {
                    i2 = 0;
                } else {
                    jVar.close();
                    i2 = 0;
                }
                hVar.width = i2;
                hVar.height = i;
                hVar.fileSize = (int) FileOp.me(str);
                return hVar;
            }
        } catch (Throwable e2222) {
            jVar = inputStream;
            th = e2222;
            i = 0;
            x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
            if (jVar == null) {
                jVar.close();
                i2 = 0;
            } else {
                i2 = 0;
            }
            hVar.width = i2;
            hVar.height = i;
            hVar.fileSize = (int) FileOp.me(str);
            return hVar;
        } catch (Throwable th5) {
            e2222 = th5;
            jVar = inputStream;
            if (jVar != null) {
                jVar.close();
            }
            throw e2222;
        }
        hVar.width = i2;
        hVar.height = i;
        hVar.fileSize = (int) FileOp.me(str);
        return hVar;
    }

    private int a(com.tencent.mm.plugin.sns.data.h hVar) {
        String accSnsPath = ae.getAccSnsPath();
        String accSnsTmpPath = ae.getAccSnsTmpPath();
        x.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[]{accSnsPath, accSnsTmpPath});
        long currentTimeMillis = System.currentTimeMillis();
        String str = hVar.path;
        int i = hVar.type;
        if (!FileOp.bO(str)) {
            return -1;
        }
        String s = g.s((str + System.currentTimeMillis()).getBytes());
        String JH = i.JH(s);
        x.d("MicroMsg.snsMediaStorage", "insert : original img path = " + str);
        if (!FileOp.bO(accSnsTmpPath)) {
            x.i("MicroMsg.snsMediaStorage", "create snstmp path " + accSnsTmpPath);
            FileOp.mh(accSnsTmpPath);
        }
        if (!FileOp.bO(accSnsPath)) {
            x.i("MicroMsg.snsMediaStorage", "create snsPath " + accSnsPath);
            FileOp.mh(accSnsPath);
        }
        a aVar = new a();
        com.tencent.mm.plugin.sns.data.h a = a(hVar, str);
        int i2 = a.width;
        int i3 = a.height;
        int i4 = a.fileSize;
        aVar.nBx = str;
        aVar.nBz = i2;
        aVar.nBA = i3;
        aVar.nBB = i4;
        if (!c(accSnsTmpPath, str, JH, true)) {
            return -1;
        }
        x.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - currentTimeMillis));
        x.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = " + JH);
        i2 = (int) FileOp.me(accSnsTmpPath + JH);
        if (str.toLowerCase().contains("jpg") || str.toLowerCase().contains("jpeg")) {
            accSnsPath = d.bn(FileOp.d(str, 0, i2));
            if (accSnsPath != null) {
                x.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[]{accSnsPath});
                try {
                    ExifInterface exifInterface = new ExifInterface(accSnsTmpPath + JH);
                    exifInterface.setAttribute(android.support.b.a.TAG_USER_COMMENT, accSnsPath);
                    exifInterface.saveAttributes();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
                }
            }
        }
        i2 = (int) FileOp.me(accSnsTmpPath + JH);
        com.tencent.mm.plugin.sns.data.h a2 = a(a, accSnsTmpPath + JH);
        int i5 = a2.width;
        i3 = a2.height;
        aVar.nBC = i5;
        aVar.nBD = i3;
        aVar.nBE = i2;
        q qVar = new q();
        qVar.rpp = s;
        qVar.hVE = (long) ((int) bh.Wo());
        qVar.type = i;
        aqu com_tencent_mm_protocal_c_aqu = new aqu();
        com_tencent_mm_protocal_c_aqu.wxG = a2.qQX;
        com_tencent_mm_protocal_c_aqu.wyb = a2.qQW;
        com_tencent_mm_protocal_c_aqu.token = a2.qQZ;
        com_tencent_mm_protocal_c_aqu.wyk = a2.qRa;
        com_tencent_mm_protocal_c_aqu.wyy = 0;
        com_tencent_mm_protocal_c_aqu.wyx = new aqo();
        com_tencent_mm_protocal_c_aqu.hkU = 0;
        com_tencent_mm_protocal_c_aqu.nfe = a2.desc;
        x.d("MicroMsg.snsMediaStorage", "upload.filterId " + a2.qQV);
        com_tencent_mm_protocal_c_aqu.wya = a2.qQV;
        com_tencent_mm_protocal_c_aqu.wyA = 2;
        com_tencent_mm_protocal_c_aqu.fqR = g.bV(accSnsTmpPath + JH);
        try {
            qVar.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
        } catch (Exception e2) {
            x.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar.byM();
        qVar.rpo = i2;
        x.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + i2 + " filepath: " + accSnsTmpPath + JH);
        int insert = (int) this.hhp.insert("SnsMedia", "local_id", qVar.byL());
        x.d("MicroMsg.snsMediaStorage", "insert localId " + insert);
        String str2 = "Locall_path" + insert;
        aVar.nBy = String.valueOf(insert);
        Exif fromFile = Exif.fromFile(aVar.nBx);
        i2 = 0;
        if (aVar.nBx.indexOf("png") >= 0) {
            i2 = 1;
        } else if (aVar.nBx.indexOf("jpg") >= 0 || aVar.nBx.indexOf("jpeg") >= 0) {
            i2 = 2;
        } else if (aVar.nBx.indexOf("mp3") >= 0) {
            i2 = 3;
        }
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20 localID", aVar.nBy + ",");
        dVar.q("21 MediaType", i2 + ",");
        dVar.q("22 OriginWidth", aVar.nBz + ",");
        dVar.q("23 OriginHeight", aVar.nBA + ",");
        dVar.q("24 CompressedWidth", aVar.nBC + ",");
        dVar.q("25 CompressedHeight", aVar.nBD + ",");
        dVar.q("26 OriginSize", aVar.nBB + ",");
        dVar.q("27 CompressedSize", aVar.nBE + ",");
        dVar.q("28 FNumber", fromFile.fNumber + ",");
        dVar.q("29 ExposureTime", fromFile.exposureTime + ",");
        dVar.q("30 ISO", fromFile.isoSpeedRatings + ",");
        dVar.q("31 Flash", fromFile.flash + ",");
        dVar.q("32 LensModel", a.Cy(fromFile.model) + ",");
        dVar.q("33 CreatTime", a.Cy(fromFile.dateTimeOriginal) + ",");
        dVar.q("34 IsFromWeChat", "0,");
        dVar.q("35 Scene", ",");
        dVar.q("36 sceneType", fromFile.sceneType + ",");
        dVar.q("37 fileSource", fromFile.fileSource + ",");
        dVar.q("38 make", fromFile.make + ",");
        dVar.q("39 software", fromFile.software + ",");
        dVar.q("40 fileExt", a.bQ(aVar.nBx) + ",");
        x.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[]{dVar.Sz(), aVar.nBx});
        com.tencent.mm.plugin.report.service.g.pQN.h(14525, new Object[]{dVar});
        accSnsPath = i.JH(str2);
        s = LA(str2);
        FileOp.mh(s);
        x.i("MicroMsg.snsMediaStorage", "checkcntpath " + s);
        FileOp.x(accSnsTmpPath + JH, s + accSnsPath);
        accSnsTmpPath = s + i.JD(str2);
        JH = s + i.JE(str2);
        FileOp.deleteFile(accSnsTmpPath);
        FileOp.deleteFile(JH);
        x.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - currentTimeMillis) + " targetPath : " + s + accSnsPath + " totalLen:" + FileOp.me(s + accSnsPath) + "  now delete...:" + accSnsTmpPath + " & " + JH);
        qVar.rpp = str2;
        a(insert, qVar);
        return insert;
    }

    public final com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h hVar, String str, String str2, String str3, String str4) {
        q qVar = new q();
        qVar.hVE = (long) ((int) bh.Wo());
        qVar.type = hVar.type;
        aqu com_tencent_mm_protocal_c_aqu = new aqu();
        com_tencent_mm_protocal_c_aqu.wxG = hVar.qQX;
        com_tencent_mm_protocal_c_aqu.wyb = hVar.qQW;
        com_tencent_mm_protocal_c_aqu.token = hVar.qQZ;
        com_tencent_mm_protocal_c_aqu.wyk = hVar.qRa;
        com_tencent_mm_protocal_c_aqu.wyy = 0;
        com_tencent_mm_protocal_c_aqu.wyx = new aqo();
        com_tencent_mm_protocal_c_aqu.hkU = 0;
        com_tencent_mm_protocal_c_aqu.nfe = hVar.desc;
        x.d("MicroMsg.snsMediaStorage", "upload.filterId " + hVar.qQV);
        com_tencent_mm_protocal_c_aqu.wya = hVar.qQV;
        com_tencent_mm_protocal_c_aqu.wyA = 2;
        com_tencent_mm_protocal_c_aqu.videoPath = str;
        com_tencent_mm_protocal_c_aqu.wyC = str2;
        com_tencent_mm_protocal_c_aqu.fqR = hVar.qRb;
        try {
            qVar.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar.byM();
        int insert = (int) this.hhp.insert("SnsMedia", "local_id", qVar.byL());
        String str5 = "Locall_path" + insert;
        x.d("MicroMsg.snsMediaStorage", "insert localId " + insert);
        String JH = i.JH(str5);
        String JI = i.JI(str5);
        String JG = i.JG(str5);
        String JJ = i.JJ(str5);
        String LA = LA(str5);
        FileOp.mh(LA);
        FileOp.x(str2, LA + JH);
        FileOp.x(str2, LA + JI);
        FileOp.x(str2, LA + JG);
        FileOp.x(str, LA + JJ);
        com_tencent_mm_protocal_c_aqu.videoPath = LA + JJ;
        com_tencent_mm_protocal_c_aqu.wyC = LA + JI;
        com_tencent_mm_protocal_c_aqu.fqR = hVar.qRb;
        try {
            qVar.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
        } catch (Exception e2) {
            x.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar.rpp = str5;
        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            aqo com_tencent_mm_protocal_c_aqo = new aqo();
            com_tencent_mm_protocal_c_aqo.ktN = 1;
            com_tencent_mm_protocal_c_aqo.nfX = str3;
            com_tencent_mm_protocal_c_aqu.wyx = com_tencent_mm_protocal_c_aqo;
            com_tencent_mm_protocal_c_aqu.wyA = 0;
            com.tencent.mm.modelcdntran.g.MK();
            com_tencent_mm_protocal_c_aqu.wxZ = b.kD(str);
            if (!bh.ov(str4)) {
                com_tencent_mm_protocal_c_aqo = new aqo();
                com_tencent_mm_protocal_c_aqo.ktN = 1;
                com_tencent_mm_protocal_c_aqo.nfX = str4;
                com_tencent_mm_protocal_c_aqu.wyz.add(com_tencent_mm_protocal_c_aqo);
            }
            try {
                qVar.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.snsMediaStorage", e3, "", new Object[0]);
            }
            qVar.byN();
        }
        a(insert, qVar);
        com.tencent.mm.plugin.sns.data.h a = a(hVar, com_tencent_mm_protocal_c_aqu.wyC);
        a.qQY = insert;
        return a;
    }

    public static boolean byO() {
        if ("hevc".equals(com.tencent.mm.platformtools.r.ieg)) {
            return true;
        }
        return ae.bvF();
    }

    public static boolean byP() {
        if ("wxpc".equals(com.tencent.mm.platformtools.r.ieg)) {
            return true;
        }
        return ae.bvG();
    }

    public static boolean X(String str, String str2, String str3) {
        return c(str, str2, str3, true);
    }

    public static boolean byQ() {
        return qOh >= 1080 && qOZ >= 1080;
    }

    public static boolean c(String str, String str2, String str3, boolean z) {
        String str4;
        boolean z2;
        Object obj;
        int i;
        int i2;
        int i3;
        int me;
        int i4;
        int detectFaceCnt;
        String value;
        int i5;
        int i6;
        int i7;
        Exif fromFile;
        int i8;
        Options options;
        InputStream inputStream;
        InputStream jVar;
        DecodeResultLogger decodeResultLogger;
        Bitmap decodeStream;
        boolean z3;
        Throwable th;
        Throwable th2;
        Options UL = d.UL(str2);
        if (UL != null) {
            str4 = UL.outMimeType;
            x.d("MicroMsg.snsMediaStorage", "mimetype: " + str4);
            if (str4 != null) {
                str4 = str4.toLowerCase();
                if (str4.indexOf("jpg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("jpeg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("png") >= 0) {
                    z2 = true;
                }
                if (UL != null) {
                    str4 = UL.outMimeType;
                    if (str4 != null) {
                        str4 = str4.toLowerCase();
                        if (str4.indexOf("jpg") >= 0) {
                            obj = 1;
                        } else if (str4.indexOf("jpeg") >= 0) {
                            int i9 = 1;
                        }
                        i = 100;
                        if (z) {
                            i2 = 100;
                            i = -1;
                        } else {
                            try {
                                com.tencent.mm.modelcdntran.g.MJ();
                                if (!c.hu(64) || byO() || byP()) {
                                    if (!an.isWifi(ac.getContext())) {
                                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                                    } else if (!an.is2G(ac.getContext())) {
                                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                                    } else if (an.is3G(ac.getContext())) {
                                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                                    } else {
                                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                                    }
                                } else if (an.isWifi(ac.getContext())) {
                                    i = Integer.valueOf(com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelForWifi")).intValue();
                                } else if (an.is2G(ac.getContext())) {
                                    i = Integer.valueOf(com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor2G")).intValue();
                                } else {
                                    i = Integer.valueOf(com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor3G")).intValue();
                                }
                                x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor3G")});
                            } catch (Exception e) {
                            }
                            x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                            if (i > 10 || i > 100) {
                                i3 = 60;
                            } else {
                                i3 = i;
                            }
                            if (obj == null) {
                                i = MMNativeJpeg.queryQuality(str2);
                                i2 = (i < i3 || i <= 25) ? i3 : i;
                            } else {
                                i2 = i3;
                                i = -1;
                            }
                        }
                        me = (int) FileOp.me(str2);
                        i4 = 0;
                        i3 = 1080;
                        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                        x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
                        if (detectFaceCnt >= 5) {
                            i4 = 0;
                            i3 = 1440;
                        }
                        if (detectFaceCnt < 5) {
                            try {
                                value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForMultiHead");
                                i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                            } catch (Exception e2) {
                            }
                        } else if (!an.isWifi(ac.getContext())) {
                            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForWifi");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (!an.is2G(ac.getContext())) {
                            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor2G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (an.is3G(ac.getContext())) {
                            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor4G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else {
                            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor3G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        }
                        x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qOh), Integer.valueOf(qOZ), Integer.valueOf(i2), Boolean.valueOf(z)});
                        if (i4 > 0 && i3 <= 0) {
                            i4 = 0;
                            detectFaceCnt = 1080;
                        } else if (i3 < 2160) {
                            i4 = 0;
                            detectFaceCnt = 1080;
                        } else if (i3 <= 0 || i4 <= 3240) {
                            detectFaceCnt = i3;
                        } else {
                            i4 = 1620;
                            detectFaceCnt = 0;
                        }
                        i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                        if (i3 <= 0) {
                            i3 = 100;
                        }
                        i5 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                        if (i3 <= 0) {
                            i3 = 200;
                        }
                        i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                        if (i3 > 0 || i3 >= 100) {
                            i7 = 10;
                        } else {
                            i7 = i3;
                        }
                        i3 = 0;
                        if (obj != null) {
                            try {
                                fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i3 = fromFile.getOrientationInDegree() % 360;
                                }
                                i8 = i3;
                            } catch (Exception e3) {
                                x.e("MicroMsg.snsMediaStorage", "get degree error " + e3.getMessage());
                            }
                            x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
                            bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
                            if (UL.outWidth < UL.outHeight * 2 || UL.outHeight >= UL.outWidth * 2) {
                                if (UL.outWidth * UL.outHeight <= 10240000) {
                                    x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
                                    if (UL.outHeight <= 0) {
                                        UL.outHeight = 1;
                                    }
                                    if (UL.outWidth <= 0) {
                                        UL.outWidth = 1;
                                    }
                                    if (UL.outWidth <= UL.outHeight) {
                                        i = UL.outWidth / UL.outHeight;
                                    } else {
                                        i = UL.outHeight / UL.outWidth;
                                    }
                                    if (i == 0) {
                                        i = 1;
                                    }
                                    i3 = (int) Math.sqrt((double) (10240000 / i));
                                    if (UL.outWidth <= UL.outHeight) {
                                        i4 = i3 * i;
                                    } else {
                                        i4 = i3;
                                        i3 *= i;
                                    }
                                    x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
                                    return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
                                } else if (me >= i6 && z2 && i8 == 0) {
                                    x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                                    if (FileOp.x(str2, str + str3) >= 0) {
                                        return true;
                                    }
                                    return false;
                                } else {
                                    options = new Options();
                                    d.c(options);
                                    inputStream = null;
                                    try {
                                        inputStream = FileOp.openRead(str2);
                                        if (inputStream.markSupported() && (inputStream instanceof FileInputStream)) {
                                            jVar = new com.tencent.mm.sdk.platformtools.j((FileInputStream) inputStream);
                                        } else {
                                            jVar = inputStream;
                                        }
                                        try {
                                            jVar.mark(1048576);
                                            decodeResultLogger = new DecodeResultLogger();
                                            decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
                                            jVar.reset();
                                            if (decodeStream != null) {
                                                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                                                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                                }
                                                if (jVar != null) {
                                                    try {
                                                        jVar.close();
                                                    } catch (IOException e4) {
                                                    }
                                                }
                                                return false;
                                            }
                                            d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                                            if (z2 || i8 != 0) {
                                                if (jVar != null) {
                                                    try {
                                                        jVar.close();
                                                    } catch (IOException e5) {
                                                    }
                                                }
                                                return true;
                                            }
                                            x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(me), Long.valueOf(FileOp.me(str + str3)), Integer.valueOf(i7)});
                                            if ((((long) me) - FileOp.me(str + str3)) * 100 < ((long) (i7 * me))) {
                                                FileOp.deleteFile(str + str3);
                                                z3 = FileOp.x(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                                if (jVar == null) {
                                                    return z3;
                                                }
                                                try {
                                                    jVar.close();
                                                    return z3;
                                                } catch (IOException e6) {
                                                    return z3;
                                                }
                                            }
                                            if (jVar != null) {
                                                try {
                                                    jVar.close();
                                                } catch (IOException e7) {
                                                }
                                            }
                                            return true;
                                        } catch (Throwable e8) {
                                            th = e8;
                                            inputStream = jVar;
                                            th2 = th;
                                            try {
                                                x.printErrStackTrace("MicroMsg.snsMediaStorage", th2, "Decode bitmap failed: " + str2, new Object[0]);
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e9) {
                                                    }
                                                }
                                                return false;
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e10) {
                                                    }
                                                }
                                                throw th2;
                                            }
                                        } catch (Throwable e82) {
                                            th = e82;
                                            inputStream = jVar;
                                            th2 = th;
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th2;
                                        }
                                    } catch (IOException e11) {
                                        th2 = e11;
                                        x.printErrStackTrace("MicroMsg.snsMediaStorage", th2, "Decode bitmap failed: " + str2, new Object[0]);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        return false;
                                    }
                                }
                            } else if (me < i5 && z2 && i8 == 0) {
                                x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal " + i5);
                                return FileOp.x(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                            } else {
                                i = UL.outWidth > UL.outHeight ? UL.outWidth : UL.outHeight;
                                i3 = UL.outWidth < UL.outHeight ? UL.outWidth : UL.outHeight;
                                if ((detectFaceCnt <= 0 || i3 > detectFaceCnt) && (detectFaceCnt > 0 || i > i4)) {
                                    if (detectFaceCnt > 0) {
                                        z3 = a(str2, UL.outWidth, UL.outHeight, detectFaceCnt, CompressFormat.JPEG, i2, str, str3);
                                    } else {
                                        double d = (((double) i) * 1.0d) / ((double) i4);
                                        z3 = a(str2, (int) (((double) UL.outHeight) / d), (int) (((double) UL.outWidth) / d), CompressFormat.JPEG, i2, str, str3, z);
                                    }
                                    if (!z2 || i8 != 0) {
                                        return z3;
                                    }
                                    x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(me), Long.valueOf(FileOp.me(str + str3)), Integer.valueOf(i7)});
                                    if ((((long) me) - FileOp.me(str + str3)) * 100 >= ((long) (i7 * me))) {
                                        return z3;
                                    }
                                    FileOp.deleteFile(str + str3);
                                    if (FileOp.x(str2, str + str3) >= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                x.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(me), Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight)});
                                if (FileOp.me(str2) < 71680) {
                                    if (z2) {
                                        x.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", new Object[]{str2});
                                        if (FileOp.x(str2, str + str3) >= 0) {
                                            return true;
                                        }
                                        return false;
                                    } else if (UL.outWidth < 150 && UL.outHeight < 150) {
                                        return a(str2, UL.outHeight, UL.outWidth, CompressFormat.PNG, i2, str, str3, z);
                                    }
                                }
                                z3 = a(str2, UL.outHeight, UL.outWidth, CompressFormat.JPEG, i2, str, str3, z);
                                if (!z2 || i8 != 0) {
                                    return z3;
                                }
                                x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(me), Long.valueOf(FileOp.me(str + str3)), Integer.valueOf(i7)});
                                if ((((long) me) - FileOp.me(str + str3)) * 100 >= ((long) (i7 * me))) {
                                    return z3;
                                }
                                FileOp.deleteFile(str + str3);
                                return FileOp.x(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                            }
                        }
                        i8 = 0;
                        x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
                        bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
                        if (UL.outWidth < UL.outHeight * 2) {
                        }
                        if (UL.outWidth * UL.outHeight <= 10240000) {
                            x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
                            if (UL.outHeight <= 0) {
                                UL.outHeight = 1;
                            }
                            if (UL.outWidth <= 0) {
                                UL.outWidth = 1;
                            }
                            if (UL.outWidth <= UL.outHeight) {
                                i = UL.outHeight / UL.outWidth;
                            } else {
                                i = UL.outWidth / UL.outHeight;
                            }
                            if (i == 0) {
                                i = 1;
                            }
                            i3 = (int) Math.sqrt((double) (10240000 / i));
                            if (UL.outWidth <= UL.outHeight) {
                                i4 = i3;
                                i3 *= i;
                            } else {
                                i4 = i3 * i;
                            }
                            x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
                            return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
                        }
                        if (me >= i6) {
                        }
                        options = new Options();
                        d.c(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        jVar = inputStream;
                        jVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
                        jVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                            if (z2) {
                            }
                            if (jVar != null) {
                                jVar.close();
                            }
                            return true;
                        }
                        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (jVar != null) {
                            jVar.close();
                        }
                        return false;
                    }
                }
                obj = null;
                i = 100;
                if (z) {
                    i2 = 100;
                    i = -1;
                } else {
                    com.tencent.mm.modelcdntran.g.MJ();
                    if (c.hu(64)) {
                    }
                    if (!an.isWifi(ac.getContext())) {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                    } else if (!an.is2G(ac.getContext())) {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                    } else if (an.is3G(ac.getContext())) {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                    } else {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                    }
                    x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor3G")});
                    x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                    if (i > 10) {
                    }
                    i3 = 60;
                    if (obj == null) {
                        i2 = i3;
                        i = -1;
                    } else {
                        i = MMNativeJpeg.queryQuality(str2);
                        if (i < i3) {
                        }
                    }
                }
                me = (int) FileOp.me(str2);
                i4 = 0;
                i3 = 1080;
                detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
                if (detectFaceCnt >= 5) {
                    i4 = 0;
                    i3 = 1440;
                }
                if (detectFaceCnt < 5) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForMultiHead");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (!an.isWifi(ac.getContext())) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForWifi");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (!an.is2G(ac.getContext())) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor2G");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (an.is3G(ac.getContext())) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor4G");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor3G");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                }
                x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qOh), Integer.valueOf(qOZ), Integer.valueOf(i2), Boolean.valueOf(z)});
                if (i4 > 0) {
                }
                if (i3 < 2160) {
                    if (i3 <= 0) {
                    }
                    detectFaceCnt = i3;
                } else {
                    i4 = 0;
                    detectFaceCnt = 1080;
                }
                i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i3 <= 0) {
                    i3 = 100;
                }
                i5 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                if (i3 <= 0) {
                    i3 = 200;
                }
                i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i3 > 0) {
                }
                i7 = 10;
                i3 = 0;
                if (obj != null) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i3 = fromFile.getOrientationInDegree() % 360;
                    }
                    i8 = i3;
                    x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
                    bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
                    if (UL.outWidth < UL.outHeight * 2) {
                    }
                    if (UL.outWidth * UL.outHeight <= 10240000) {
                        if (me >= i6) {
                        }
                        options = new Options();
                        d.c(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        jVar = inputStream;
                        jVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
                        jVar.reset();
                        if (decodeStream != null) {
                            if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                                com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (jVar != null) {
                                jVar.close();
                            }
                            return false;
                        }
                        d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                        if (z2) {
                        }
                        if (jVar != null) {
                            jVar.close();
                        }
                        return true;
                    }
                    x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
                    if (UL.outHeight <= 0) {
                        UL.outHeight = 1;
                    }
                    if (UL.outWidth <= 0) {
                        UL.outWidth = 1;
                    }
                    if (UL.outWidth <= UL.outHeight) {
                        i = UL.outWidth / UL.outHeight;
                    } else {
                        i = UL.outHeight / UL.outWidth;
                    }
                    if (i == 0) {
                        i = 1;
                    }
                    i3 = (int) Math.sqrt((double) (10240000 / i));
                    if (UL.outWidth <= UL.outHeight) {
                        i4 = i3 * i;
                    } else {
                        i4 = i3;
                        i3 *= i;
                    }
                    x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
                    return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
                }
                i8 = 0;
                x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
                bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
                if (UL.outWidth < UL.outHeight * 2) {
                }
                if (UL.outWidth * UL.outHeight <= 10240000) {
                    x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
                    if (UL.outHeight <= 0) {
                        UL.outHeight = 1;
                    }
                    if (UL.outWidth <= 0) {
                        UL.outWidth = 1;
                    }
                    if (UL.outWidth <= UL.outHeight) {
                        i = UL.outHeight / UL.outWidth;
                    } else {
                        i = UL.outWidth / UL.outHeight;
                    }
                    if (i == 0) {
                        i = 1;
                    }
                    i3 = (int) Math.sqrt((double) (10240000 / i));
                    if (UL.outWidth <= UL.outHeight) {
                        i4 = i3;
                        i3 *= i;
                    } else {
                        i4 = i3 * i;
                    }
                    x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
                    return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
                }
                if (me >= i6) {
                }
                options = new Options();
                d.c(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                jVar = inputStream;
                jVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
                jVar.reset();
                if (decodeStream != null) {
                    d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                    if (z2) {
                    }
                    if (jVar != null) {
                        jVar.close();
                    }
                    return true;
                }
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                }
                if (jVar != null) {
                    jVar.close();
                }
                return false;
            }
        }
        z2 = false;
        if (UL != null) {
            str4 = UL.outMimeType;
            if (str4 != null) {
                str4 = str4.toLowerCase();
                if (str4.indexOf("jpg") >= 0) {
                    obj = 1;
                } else if (str4.indexOf("jpeg") >= 0) {
                    int i92 = 1;
                }
                i = 100;
                if (z) {
                    com.tencent.mm.modelcdntran.g.MJ();
                    if (c.hu(64)) {
                    }
                    if (!an.isWifi(ac.getContext())) {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                    } else if (!an.is2G(ac.getContext())) {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                    } else if (an.is3G(ac.getContext())) {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                    } else {
                        i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                    }
                    x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor3G")});
                    x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                    if (i > 10) {
                    }
                    i3 = 60;
                    if (obj == null) {
                        i = MMNativeJpeg.queryQuality(str2);
                        if (i < i3) {
                        }
                    } else {
                        i2 = i3;
                        i = -1;
                    }
                } else {
                    i2 = 100;
                    i = -1;
                }
                me = (int) FileOp.me(str2);
                i4 = 0;
                i3 = 1080;
                detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
                if (detectFaceCnt >= 5) {
                    i4 = 0;
                    i3 = 1440;
                }
                if (detectFaceCnt < 5) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForMultiHead");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (!an.isWifi(ac.getContext())) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForWifi");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (!an.is2G(ac.getContext())) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor2G");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (an.is3G(ac.getContext())) {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor3G");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else {
                    value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor4G");
                    i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                }
                x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qOh), Integer.valueOf(qOZ), Integer.valueOf(i2), Boolean.valueOf(z)});
                if (i4 > 0) {
                }
                if (i3 < 2160) {
                    i4 = 0;
                    detectFaceCnt = 1080;
                } else {
                    if (i3 <= 0) {
                    }
                    detectFaceCnt = i3;
                }
                i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i3 <= 0) {
                    i3 = 100;
                }
                i5 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                if (i3 <= 0) {
                    i3 = 200;
                }
                i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i3 > 0) {
                }
                i7 = 10;
                i3 = 0;
                if (obj != null) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i3 = fromFile.getOrientationInDegree() % 360;
                    }
                    i8 = i3;
                    x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
                    bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
                    if (UL.outWidth < UL.outHeight * 2) {
                    }
                    if (UL.outWidth * UL.outHeight <= 10240000) {
                        if (me >= i6) {
                        }
                        options = new Options();
                        d.c(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        jVar = inputStream;
                        jVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
                        jVar.reset();
                        if (decodeStream != null) {
                            if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                                com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (jVar != null) {
                                jVar.close();
                            }
                            return false;
                        }
                        d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                        if (z2) {
                        }
                        if (jVar != null) {
                            jVar.close();
                        }
                        return true;
                    }
                    x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
                    if (UL.outHeight <= 0) {
                        UL.outHeight = 1;
                    }
                    if (UL.outWidth <= 0) {
                        UL.outWidth = 1;
                    }
                    if (UL.outWidth <= UL.outHeight) {
                        i = UL.outWidth / UL.outHeight;
                    } else {
                        i = UL.outHeight / UL.outWidth;
                    }
                    if (i == 0) {
                        i = 1;
                    }
                    i3 = (int) Math.sqrt((double) (10240000 / i));
                    if (UL.outWidth <= UL.outHeight) {
                        i4 = i3 * i;
                    } else {
                        i4 = i3;
                        i3 *= i;
                    }
                    x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
                    return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
                }
                i8 = 0;
                x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
                bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
                if (UL.outWidth < UL.outHeight * 2) {
                }
                if (UL.outWidth * UL.outHeight <= 10240000) {
                    x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
                    if (UL.outHeight <= 0) {
                        UL.outHeight = 1;
                    }
                    if (UL.outWidth <= 0) {
                        UL.outWidth = 1;
                    }
                    if (UL.outWidth <= UL.outHeight) {
                        i = UL.outHeight / UL.outWidth;
                    } else {
                        i = UL.outWidth / UL.outHeight;
                    }
                    if (i == 0) {
                        i = 1;
                    }
                    i3 = (int) Math.sqrt((double) (10240000 / i));
                    if (UL.outWidth <= UL.outHeight) {
                        i4 = i3;
                        i3 *= i;
                    } else {
                        i4 = i3 * i;
                    }
                    x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
                    return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
                }
                if (me >= i6) {
                }
                options = new Options();
                d.c(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                jVar = inputStream;
                jVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
                jVar.reset();
                if (decodeStream != null) {
                    d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                    if (z2) {
                    }
                    if (jVar != null) {
                        jVar.close();
                    }
                    return true;
                }
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                }
                if (jVar != null) {
                    jVar.close();
                }
                return false;
            }
        }
        obj = null;
        i = 100;
        if (z) {
            i2 = 100;
            i = -1;
        } else {
            com.tencent.mm.modelcdntran.g.MJ();
            if (c.hu(64)) {
            }
            if (!an.isWifi(ac.getContext())) {
                i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), 70);
            } else if (!an.is2G(ac.getContext())) {
                i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), 70);
            } else if (an.is3G(ac.getContext())) {
                i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), 60);
            } else {
                i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), 60);
            }
            x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.zY().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.zY().getValue("SnsCompressPicLevelFor3G")});
            x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            if (i > 10) {
            }
            i3 = 60;
            if (obj == null) {
                i2 = i3;
                i = -1;
            } else {
                i = MMNativeJpeg.queryQuality(str2);
                if (i < i3) {
                }
            }
        }
        me = (int) FileOp.me(str2);
        i4 = 0;
        i3 = 1080;
        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
        x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
        if (detectFaceCnt >= 5) {
            i4 = 0;
            i3 = 1440;
        }
        if (detectFaceCnt < 5) {
            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForMultiHead");
            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
        } else if (!an.isWifi(ac.getContext())) {
            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionForWifi");
            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
        } else if (!an.is2G(ac.getContext())) {
            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor2G");
            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
        } else if (an.is3G(ac.getContext())) {
            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor4G");
            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
        } else {
            value = com.tencent.mm.k.g.zY().getValue("SnsCompressResolutionFor3G");
            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
        }
        x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qOh), Integer.valueOf(qOZ), Integer.valueOf(i2), Boolean.valueOf(z)});
        if (i4 > 0) {
        }
        if (i3 < 2160) {
            if (i3 <= 0) {
            }
            detectFaceCnt = i3;
        } else {
            i4 = 0;
            detectFaceCnt = 1080;
        }
        i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i3 <= 0) {
            i3 = 100;
        }
        i5 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
        if (i3 <= 0) {
            i3 = 200;
        }
        i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i3 > 0) {
        }
        i7 = 10;
        i3 = 0;
        if (obj != null) {
            fromFile = Exif.fromFile(str2);
            if (fromFile != null) {
                i3 = fromFile.getOrientationInDegree() % 360;
            }
            i8 = i3;
            x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
            bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
            if (UL.outWidth < UL.outHeight * 2) {
            }
            if (UL.outWidth * UL.outHeight <= 10240000) {
                if (me >= i6) {
                }
                options = new Options();
                d.c(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                jVar = inputStream;
                jVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
                jVar.reset();
                if (decodeStream != null) {
                    if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                    }
                    if (jVar != null) {
                        jVar.close();
                    }
                    return false;
                }
                d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                if (z2) {
                }
                if (jVar != null) {
                    jVar.close();
                }
                return true;
            }
            x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
            if (UL.outHeight <= 0) {
                UL.outHeight = 1;
            }
            if (UL.outWidth <= 0) {
                UL.outWidth = 1;
            }
            if (UL.outWidth <= UL.outHeight) {
                i = UL.outWidth / UL.outHeight;
            } else {
                i = UL.outHeight / UL.outWidth;
            }
            if (i == 0) {
                i = 1;
            }
            i3 = (int) Math.sqrt((double) (10240000 / i));
            if (UL.outWidth <= UL.outHeight) {
                i4 = i3 * i;
            } else {
                i4 = i3;
                i3 *= i;
            }
            x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
            return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
        }
        i8 = 0;
        x.i("MicroMsg.snsMediaStorage", "option info " + UL.outWidth + " " + UL.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + me + " target " + i4 + " " + detectFaceCnt);
        bh.getInt(com.tencent.mm.k.g.zY().getValue("CompressLongImageRatio"), 10);
        if (UL.outWidth < UL.outHeight * 2) {
        }
        if (UL.outWidth * UL.outHeight <= 10240000) {
            x.i("MicroMsg.snsMediaStorage", "too max pic " + UL.outWidth + " " + UL.outHeight);
            if (UL.outHeight <= 0) {
                UL.outHeight = 1;
            }
            if (UL.outWidth <= 0) {
                UL.outWidth = 1;
            }
            if (UL.outWidth <= UL.outHeight) {
                i = UL.outHeight / UL.outWidth;
            } else {
                i = UL.outWidth / UL.outHeight;
            }
            if (i == 0) {
                i = 1;
            }
            i3 = (int) Math.sqrt((double) (10240000 / i));
            if (UL.outWidth <= UL.outHeight) {
                i4 = i3;
                i3 *= i;
            } else {
                i4 = i3 * i;
            }
            x.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
            return a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
        }
        if (me >= i6) {
        }
        options = new Options();
        d.c(options);
        inputStream = null;
        inputStream = FileOp.openRead(str2);
        if (inputStream.markSupported()) {
        }
        jVar = inputStream;
        jVar.mark(1048576);
        decodeResultLogger = new DecodeResultLogger();
        decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, decodeResultLogger, 0, new int[0]);
        jVar.reset();
        if (decodeStream != null) {
            d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
            if (z2) {
            }
            if (jVar != null) {
                jVar.close();
            }
            return true;
        }
        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
        }
        if (jVar != null) {
            jVar.close();
        }
        return false;
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3, boolean z) {
        Options UL = d.UL(str);
        if (UL == null || UL.outWidth <= 0 || UL.outHeight <= 0) {
            return false;
        }
        return a(str, UL.outWidth, UL.outHeight, i, i2, compressFormat, i3, str2, str3, z);
    }

    private static boolean a(String str, int i, int i2, int i3, CompressFormat compressFormat, int i4, String str2, String str3) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            int i5 = i2 > i ? i : i2;
            if (i5 == i3) {
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i5 > i3) {
                    options.inSampleSize = i5 / i3;
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 5529600) {
                    options.inSampleSize++;
                }
                x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                }
                return false;
            }
            int i6 = (i * i3) / i5;
            int i7 = (i2 * i3) / i5;
            int UJ = ExifHelper.UJ(str);
            if (UJ == 90 || UJ == 270) {
                int i8 = i7;
                i7 = i6;
                i6 = i8;
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(UJ)});
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, i7, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                l.EA().h(b);
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", new Object[]{Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i4)});
            outputStream = FileOp.iE(str2 + str3);
            d.a(createScaledBitmap, i4, compressFormat, outputStream, false);
            l.EA().h(createScaledBitmap);
            outputStream.close();
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", new Object[]{str2 + str3, Long.valueOf(FileOp.me(str2 + str3))});
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", new Object[]{str3});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean LC(String str) {
        InputStream inputStream = null;
        try {
            inputStream = FileOp.openRead(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options, null, 0, new int[0]);
            String str2 = options.outMimeType;
            x.d("MicroMsg.snsMediaStorage", "mineType " + str2);
            if (str2.toLowerCase().indexOf("webp") >= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                return true;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        } catch (Exception e3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            InputStream inputStream2 = inputStream;
            Throwable th3 = th2;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th3;
        }
    }

    public static boolean a(String str, String str2, String str3, float f) {
        InputStream inputStream;
        double d;
        double d2;
        int i;
        double d3;
        double d4;
        double d5;
        Object obj;
        Object obj2;
        String str4;
        int i2;
        int i3;
        int i4;
        int i5;
        CompressFormat compressFormat;
        InputStream inputStream2 = null;
        try {
            Options options;
            inputStream2 = FileOp.openRead(str + str2);
            try {
                options = new Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeStream(inputStream2, null, options, null, 0, new int[0]);
                inputStream2.close();
            } catch (Exception e) {
                inputStream = inputStream2;
                d = 0.0d;
                d2 = 0.0d;
                i = 1;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        d3 = 240.0d;
                        d4 = 240.0d;
                        d5 = d2;
                        obj = obj2;
                    } catch (IOException e2) {
                        d3 = 240.0d;
                        d4 = 240.0d;
                        d5 = d2;
                        obj = obj2;
                        str4 = str + str2;
                        i2 = (int) d5;
                        i3 = (int) d;
                        i4 = (int) d4;
                        i5 = (int) d3;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                    }
                    str4 = str + str2;
                    i2 = (int) d5;
                    i3 = (int) d;
                    i4 = (int) d4;
                    i5 = (int) d3;
                    if (obj != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                }
                d3 = 240.0d;
                d4 = 240.0d;
                d5 = d2;
                obj = obj2;
                str4 = str + str2;
                i2 = (int) d5;
                i3 = (int) d;
                i4 = (int) d4;
                i5 = (int) d3;
                if (obj != null) {
                    compressFormat = CompressFormat.JPEG;
                } else {
                    compressFormat = CompressFormat.PNG;
                }
                return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
            }
            try {
                Object obj3;
                d4 = (double) options.outWidth;
                d5 = (double) options.outHeight;
                if (d4 > 120.0d || d5 > 120.0d) {
                    obj3 = null;
                } else {
                    i5 = 1;
                }
                try {
                    double d6;
                    str4 = options.outMimeType;
                    if (d4 < 0.0d || d5 < 0.0d) {
                        d6 = 240.0d;
                        d3 = 240.0d;
                    } else {
                        d6 = d5;
                        d3 = d4;
                    }
                    double d7 = (double) f;
                    double d8 = (double) ((f / 200.0f) * 44.0f);
                    d = (double) ((f / 200.0f) * 160.0f);
                    if (d3 <= 0.0d || d6 <= 0.0d) {
                        obj = obj3;
                        d3 = d;
                        double d9 = d4;
                        d4 = d;
                        d = d5;
                        d5 = d9;
                        str4 = str + str2;
                        i2 = (int) d5;
                        i3 = (int) d;
                        i4 = (int) d4;
                        i5 = (int) d3;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                    }
                    d = Math.min(d7 / d3, d7 / d6);
                    d3 *= d;
                    d *= d6;
                    if (d3 < d8) {
                        d6 = (1.0d * d8) / d3;
                        d3 *= d6;
                        d *= d6;
                    }
                    if (d < d8) {
                        d6 = (1.0d * d8) / d;
                        d3 *= d6;
                        d *= d6;
                    }
                    if (d3 > d7) {
                        d3 = d7;
                    }
                    if (d <= d7) {
                        d7 = d;
                    }
                    obj = obj3;
                    d = d5;
                    d5 = d4;
                    d4 = d7;
                    str4 = str + str2;
                    i2 = (int) d5;
                    i3 = (int) d;
                    i4 = (int) d4;
                    i5 = (int) d3;
                    if (obj != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                } catch (Exception e3) {
                    inputStream = null;
                    obj2 = obj3;
                    d = d5;
                    d2 = d4;
                    if (inputStream != null) {
                        inputStream.close();
                        d3 = 240.0d;
                        d4 = 240.0d;
                        d5 = d2;
                        obj = obj2;
                        str4 = str + str2;
                        i2 = (int) d5;
                        i3 = (int) d;
                        i4 = (int) d4;
                        i5 = (int) d3;
                        if (obj != null) {
                            compressFormat = CompressFormat.JPEG;
                        } else {
                            compressFormat = CompressFormat.PNG;
                        }
                        return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                    }
                    d3 = 240.0d;
                    d4 = 240.0d;
                    d5 = d2;
                    obj = obj2;
                    str4 = str + str2;
                    i2 = (int) d5;
                    i3 = (int) d;
                    i4 = (int) d4;
                    i5 = (int) d3;
                    if (obj != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                }
            } catch (Exception e4) {
                inputStream = null;
                i = 1;
                d = 0.0d;
                d2 = 0.0d;
                if (inputStream != null) {
                    inputStream.close();
                    d3 = 240.0d;
                    d4 = 240.0d;
                    d5 = d2;
                    obj = obj2;
                    str4 = str + str2;
                    i2 = (int) d5;
                    i3 = (int) d;
                    i4 = (int) d4;
                    i5 = (int) d3;
                    if (obj != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                }
                d3 = 240.0d;
                d4 = 240.0d;
                d5 = d2;
                obj = obj2;
                str4 = str + str2;
                i2 = (int) d5;
                i3 = (int) d;
                i4 = (int) d4;
                i5 = (int) d3;
                if (obj != null) {
                    compressFormat = CompressFormat.JPEG;
                } else {
                    compressFormat = CompressFormat.PNG;
                }
                return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
            }
        } catch (Exception e5) {
            inputStream = inputStream2;
            d = 0.0d;
            d2 = 0.0d;
            obj2 = 1;
            if (inputStream != null) {
                inputStream.close();
                d3 = 240.0d;
                d4 = 240.0d;
                d5 = d2;
                obj = obj2;
                str4 = str + str2;
                i2 = (int) d5;
                i3 = (int) d;
                i4 = (int) d4;
                i5 = (int) d3;
                if (obj != null) {
                    compressFormat = CompressFormat.PNG;
                } else {
                    compressFormat = CompressFormat.JPEG;
                }
                return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
            }
            d3 = 240.0d;
            d4 = 240.0d;
            d5 = d2;
            obj = obj2;
            str4 = str + str2;
            i2 = (int) d5;
            i3 = (int) d;
            i4 = (int) d4;
            i5 = (int) d3;
            if (obj != null) {
                compressFormat = CompressFormat.JPEG;
            } else {
                compressFormat = CompressFormat.PNG;
            }
            return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2, String str3, boolean z) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                }
                return false;
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            if (z) {
                int ceil;
                int i6;
                if (d < d2) {
                    ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                    i6 = i4;
                } else {
                    i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                    ceil = i3;
                }
                int UJ = ExifHelper.UJ(str);
                if (UJ == 90 || UJ == 270) {
                    int i7 = ceil;
                    ceil = i6;
                    i6 = i7;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, ceil, true);
                if (createScaledBitmap != null) {
                    if (b != createScaledBitmap) {
                        l.EA().h(b);
                    }
                    b = createScaledBitmap;
                }
                x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            }
            outputStream = FileOp.iE(str2 + str3);
            d.a(b, i5, compressFormat, outputStream, false);
            l.EA().h(b);
            outputStream.close();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", new Object[]{str3});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean b(String str, String str2, String str3, float f) {
        try {
            FileOp.deleteFile(str + str3);
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Options UL = d.UL(str + str2);
            if (UL == null) {
                x.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
                return false;
            }
            Bitmap b;
            if (UL.outMimeType == null || !(UL.outMimeType.toLowerCase().endsWith("png") || UL.outMimeType.toLowerCase().endsWith("vcodec"))) {
                int i = UL.outWidth;
                int i2 = UL.outHeight;
                int i3 = (int) f;
                int i4 = (int) f;
                UL.inJustDecodeBounds = false;
                x.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                if (i == i3 && i2 == i4) {
                    b = com.tencent.mm.plugin.sns.d.a.b(str + str2, UL, decodeResultLogger);
                } else {
                    int i5;
                    int ceil;
                    if ((((double) i2) * 1.0d) / ((double) i4) > (((double) i) * 1.0d) / ((double) i3)) {
                        i5 = i3;
                        ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i2)) / ((double) i));
                    } else {
                        i5 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i)) / ((double) i2));
                        ceil = i4;
                    }
                    x.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(ceil)});
                    UL.inSampleSize = 1;
                    if (i2 > ceil || i > i5) {
                        UL.inSampleSize = 1;
                        if (i2 > ceil || i > i5) {
                            double d = (((double) i2) * 1.0d) / ((double) ceil);
                            double d2 = (((double) i) * 1.0d) / ((double) i5);
                            if (d >= d2) {
                                d2 = d;
                            }
                            UL.inSampleSize = (int) d2;
                            if (UL.inSampleSize <= 1) {
                                UL.inSampleSize = 1;
                            }
                        }
                        while (((i2 * i) / UL.inSampleSize) / UL.inSampleSize > 2764800) {
                            UL.inSampleSize++;
                        }
                    }
                    x.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[]{Integer.valueOf(UL.inSampleSize)});
                    Bitmap b2;
                    if (((float) i2) / ((float) i) == ((float) i4) / ((float) i3)) {
                        b2 = com.tencent.mm.plugin.sns.d.a.b(str + str2, UL, decodeResultLogger);
                        x.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
                        b = b2;
                    } else {
                        float max = Math.max(((float) i5) / ((float) i), ((float) ceil) / ((float) i2));
                        int i6 = (int) (((float) i4) / max);
                        int min = Math.min(i, (int) (((float) i3) / max));
                        i6 = Math.min(i2, i6);
                        i5 = (i2 - i6) >> 1;
                        i3 = Math.max(0, (i - min) >> 1);
                        i5 = Math.max(0, i5);
                        Rect rect = new Rect();
                        rect.left = i3;
                        rect.right = i3 + min;
                        rect.top = i5;
                        rect.bottom = i5 + i6;
                        String str4 = str + str2;
                        long currentTimeMillis = System.currentTimeMillis();
                        b2 = l.EA().a(str4, rect, UL, decodeResultLogger);
                        if (b2 != null) {
                            b2 = i.s(str4, b2);
                        }
                        x.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        x.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[]{Integer.valueOf(min), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Float.valueOf(max)});
                        b = b2;
                    }
                }
            } else {
                b = d.a(str + str2, (int) f, (int) f, true, decodeResultLogger, 0);
            }
            if (b == null) {
                x.i("MicroMsg.snsMediaStorage", "bitmap error " + str + str2);
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str + str2, 10, decodeResultLogger));
                }
                FileOp.deleteFile(str + str2);
                return false;
            }
            x.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            Object obj = 1;
            if (b.getHeight() > 120 || b.getWidth() > 120) {
                obj = null;
            }
            d.a(b, 100, obj != null ? CompressFormat.PNG : CompressFormat.JPEG, str + str3, false);
            l.EA().h(b);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
        }
    }

    public static Bitmap LD(String str) {
        int i = 640;
        Options UL = d.UL(str);
        int i2 = UL.outWidth >= UL.outHeight ? 960 : 640;
        if (UL.outWidth < UL.outHeight) {
            i = 960;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        Bitmap a = d.a(str, i, i2, false, decodeResultLogger, 0);
        if (a == null) {
            if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
            }
            return null;
        }
        try {
            Exif exif = new Exif();
            exif.parseFromFile(str);
            return d.b(a, (float) exif.getOrientationInDegree());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "parse exif failed: " + str, new Object[0]);
            return a;
        }
    }
}
