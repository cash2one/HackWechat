package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.by.h;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

public final class s {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
    private static long hVS = 0;
    public h hhp;
    k<a, s$a$a> hkZ = new 1(this);

    public final void a(a aVar, Looper looper) {
        this.hkZ.a(aVar, looper);
    }

    public final void a(a aVar) {
        this.hkZ.remove(aVar);
    }

    public s(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(r rVar) {
        if (rVar == null) {
            return false;
        }
        rVar.fDt = -1;
        if (((int) this.hhp.insert("videoinfo2", FFmpegMetadataRetriever.METADATA_KEY_FILENAME, rVar.vI())) == -1) {
            return false;
        }
        this.hkZ.ca(new s$a$a(rVar.getFileName(), b.hVZ, s$a$c.NORMAL, rVar.hVO, rVar.hUa));
        this.hkZ.doNotify();
        return true;
    }

    public final r nr(String str) {
        r rVar = null;
        Cursor a = this.hhp.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.filename = \"" + bh.ot(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                rVar = new r();
                rVar.b(a);
            }
            a.close();
        }
        return rVar;
    }

    public final List<r> bt(long j) {
        List<r> list = null;
        Cursor a = this.hhp.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.masssendid = " + j, null, 2);
        if (a != null) {
            list = new ArrayList();
            while (a.moveToNext()) {
                r rVar = new r();
                rVar.b(a);
                list.add(rVar);
            }
            a.close();
        }
        return list;
    }

    public final List<r> Ul() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=200 order by masssendid desc";
        List<r> arrayList = new ArrayList();
        Cursor a = this.hhp.a(str, null, 2);
        int i = 0;
        while (a.moveToNext()) {
            r rVar = new r();
            rVar.b(a);
            arrayList.add(rVar);
            i++;
        }
        a.close();
        x.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:" + i);
        return arrayList;
    }

    public final List<r> Um() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
        List<r> arrayList = new ArrayList();
        Cursor a = this.hhp.a(str, null, 2);
        while (a.moveToNext()) {
            r rVar = new r();
            rVar.b(a);
            arrayList.add(rVar);
        }
        a.close();
        return arrayList;
    }

    public final boolean b(r rVar) {
        boolean z;
        Assert.assertTrue(rVar != null);
        if (rVar.getFileName().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues vI = rVar.vI();
        if (vI.size() <= 0) {
            x.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
        } else {
            if (this.hhp.update("videoinfo2", vI, "filename= ?", new String[]{rVar.getFileName()}) > 0) {
                s$a$c com_tencent_mm_modelvideo_s_a_c = s$a$c.NORMAL;
                if (rVar.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                    com_tencent_mm_modelvideo_s_a_c = s$a$c.DOWNLOAD;
                } else if (rVar.status == 103 || rVar.status == 104) {
                    com_tencent_mm_modelvideo_s_a_c = s$a$c.UPLOAD;
                }
                this.hkZ.ca(new s$a$a(rVar.getFileName(), b.hWb, com_tencent_mm_modelvideo_s_a_c, rVar.hVO, rVar.hUa));
                this.hkZ.doNotify();
                return true;
            }
        }
        return false;
    }

    public final List<String> Un() {
        Throwable th;
        List<String> list = null;
        Cursor a;
        try {
            a = this.hhp.a("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + new StringBuilder(" LIMIT 10").toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<String> Uo() {
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10" + " )";
        Cursor a;
        try {
            a = this.hhp.a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<String> Up() {
        Throwable th;
        List<String> list = null;
        Cursor a;
        try {
            a = this.hhp.a("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE (status=199 OR status=123) AND videoformat=2 ORDER BY downloadtime DESC " + new StringBuilder(" LIMIT 10").toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<r> a(int i, int i2, long j) {
        Throwable th;
        List<r> list = null;
        Cursor a;
        try {
            a = this.hhp.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where status=" + i + " AND preloadsize > 0 AND lastmodifytime" + " <= " + j + " ORDER BY createtime LIMIT " + i2, null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        r rVar = new r();
                        rVar.b(a);
                        list.add(rVar);
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<String> Uq() {
        Cursor a;
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10" + " )";
        try {
            a = this.hhp.a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public static String ns(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("HHmmssddMMyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.s(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = hVS;
        hVS = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    private static String Ur() {
        return com.tencent.mm.kernel.g.Dj().gQi + "video/";
    }

    public static String nt(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String str2 = Ur() + str;
        return !e.bO(str2) ? str2 + ".mp4" : str2;
    }

    public static String nu(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return Ur() + str + ".jpg";
    }

    public static int a(String str, int i, byte[] bArr) {
        RandomAccessFile randomAccessFile;
        int filePointer;
        Exception e;
        Throwable th;
        if (bh.ov(str)) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " invalid fileName");
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (i < 0) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "]  invalid startOffset:" + i);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (bh.bw(bArr)) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "]  invalid writeBuf");
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            a aVar = new a();
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    long zi = aVar.zi();
                    randomAccessFile.seek((long) i);
                    long zi2 = aVar.zi();
                    randomAccessFile.write(bArr, 0, bArr.length);
                    long zi3 = aVar.zi();
                    filePointer = (int) randomAccessFile.getFilePointer();
                    long zi4 = aVar.zi();
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "]  Offset:" + i + " buf:" + bArr.length);
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "] open:" + zi + " seek:" + zi2 + " write:" + zi3 + " close:" + zi4);
                    return filePointer;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                        filePointer = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (randomAccessFile != null) {
                            return filePointer;
                        }
                        try {
                            randomAccessFile.close();
                            return filePointer;
                        } catch (Exception e4) {
                            return filePointer;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                filePointer = 0 - com.tencent.mm.compatible.util.g.getLine();
                if (randomAccessFile != null) {
                    return filePointer;
                }
                randomAccessFile.close();
                return filePointer;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }
    }

    public static b i(String str, int i, int i2) {
        Exception e;
        Throwable th;
        int i3 = 0;
        b bVar = new b();
        if (bh.ov(str)) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " invalid fileName");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (i < 0) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "]  invalid readOffset:" + i);
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (i2 <= 0) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "]  invalid readLen");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            a aVar = new a();
            bVar.buf = new byte[i2];
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    long zi = aVar.zi();
                    randomAccessFile.seek((long) i);
                    long zi2 = aVar.zi();
                    int read = randomAccessFile.read(bVar.buf, 0, i2);
                    long zi3 = aVar.zi();
                    long zi4 = aVar.zi();
                    if (read >= 0) {
                        i3 = read;
                    }
                    bVar.flp = i3;
                    bVar.hWh = i3 + i;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "]  Offset:" + i + " readlen:" + i2);
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "] open:" + zi + " seek:" + zi2 + " write:" + zi3 + " close:" + zi4);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "] \t\tOffset:" + bVar.hWh + " failed:[" + e.getMessage() + "]");
                        bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.zh() + "[" + str + "] \t\tOffset:" + bVar.hWh + " failed:[" + e.getMessage() + "]");
                bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return bVar;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }
        return bVar;
    }

    public static int nv(String str) {
        if (bh.ov(str)) {
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
    }

    public final boolean p(String str, String str2, String str3) {
        return aw(str, str2 + "##" + str3);
    }

    static int[] nw(String str) {
        Throwable e;
        int i = 0;
        int[] iArr = new int[33];
        long Wp = bh.Wp();
        int bN = e.bN(str);
        if (bN < 102400 || bN >= JceStruct.JCE_MAX_STRING_LENGTH) {
            int i2;
            x.e("MicroMsg.VideoInfoStorage", "genVideoHash file size :%d , give up. :%s ", new Object[]{Integer.valueOf(bN), str});
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[2];
            if (bN < 102400) {
                i2 = 10;
            } else {
                i2 = 20;
            }
            objArr[0] = Integer.valueOf(i2 + 101);
            objArr[1] = Integer.valueOf(bN);
            gVar.h(12696, objArr);
            return null;
        }
        iArr[32] = bN;
        int i3 = (bN - 20480) / 32;
        byte[] bArr = new byte[WXMediaMessage.TITLE_LENGTH_LIMIT];
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            while (i < 32) {
                try {
                    randomAccessFile.seek((long) ((i * i3) + 10240));
                    randomAccessFile.readFully(bArr);
                    iArr[i] = (com.tencent.mm.a.h.n(bArr, WXMediaMessage.TITLE_LENGTH_LIMIT) % Integer.MIN_VALUE) | Integer.MIN_VALUE;
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            randomAccessFile.close();
            x.i("MicroMsg.VideoInfoStorage", "genVideoHash finish time:%d size:%d path:%s", new Object[]{Long.valueOf(bh.bz(Wp)), Integer.valueOf(bN), str});
            try {
                randomAccessFile.close();
                return iArr;
            } catch (Exception e3) {
                return iArr;
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            try {
                x.e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", new Object[]{str, bh.i(e)});
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }

    private boolean aw(String str, String str2) {
        x.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", new Object[]{str, str2, bh.cgy()});
        long Wp = bh.Wp();
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", new Object[]{str, str2});
            return false;
        }
        int[] nw = nw(str);
        if (nw == null || nw.length < 33) {
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", new Object[]{str});
            return false;
        }
        int i = nw[32];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 32; i2++) {
            stringBuffer.append(Integer.toHexString(nw[i2]));
        }
        Cursor a = this.hhp.a("select cdnxml from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"", null, 2);
        Vector vector = new Vector();
        while (a.moveToNext()) {
            vector.add(a.getString(0));
            x.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", new Object[]{Integer.valueOf(vector.size()), vector.get(vector.size() - 1)});
        }
        a.close();
        if (vector.size() == 1 && str2.equals(vector.get(0))) {
            x.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", new Object[]{Long.valueOf(bh.bz(Wp)), str, str2});
            return true;
        }
        if (vector.size() > 0) {
            com.tencent.mm.plugin.report.service.g.pQN.h(12696, new Object[]{Integer.valueOf(102), Integer.valueOf(i), "", "", Integer.valueOf(vector.size())});
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", new Object[]{Integer.valueOf(vector.size()), Integer.valueOf(i)});
            this.hhp.fx("VideoHash", "delete from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("CreateTime", Long.valueOf(bh.Wo()));
        contentValues.put("hash", stringBuffer.toString());
        contentValues.put("cdnxml", str2);
        contentValues.put("orgpath", str);
        x.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", new Object[]{Long.valueOf(bh.bz(Wp)), Long.valueOf(this.hhp.insert("VideoHash", "", contentValues)), str, stringBuffer, str2});
        if (this.hhp.insert("VideoHash", "", contentValues) < 0) {
            com.tencent.mm.plugin.report.service.g.pQN.h(12696, new Object[]{Integer.valueOf(103), Integer.valueOf(i)});
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", new Object[]{Long.valueOf(r0), str});
        }
        return true;
    }
}
