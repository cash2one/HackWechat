package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Map;

public final class r {
    String clientId = "";
    public String fDC = "";
    public int fDt = -1;
    public long fFo = 0;
    public String fGG = "";
    public String fHk = "";
    public String fileName = "";
    public int fzU = 0;
    public String hTp = "";
    public long hUa = 0;
    public int hUp = 0;
    public int hVB = 0;
    public int hVC = 0;
    public int hVD = 0;
    public long hVE = 0;
    public long hVF = 0;
    public long hVG = 0;
    public int hVH = 0;
    public int hVI = 0;
    public int hVJ = 0;
    public int hVK = 0;
    public int hVL = 0;
    public int hVM = 0;
    public String hVN = "";
    public int hVO = 0;
    public String hVP = "";
    public bmf hVQ = new bmf();
    public aqc hVR = new aqc();
    public String hVz = "";
    public int hlp = 0;
    public int htL = 0;
    public int status = 0;
    public int videoFormat = 0;

    public static String nq(String str) {
        try {
            Map y = bi.y(str, "msg");
            if (y != null) {
                return (String) y.get(".msg.videomsg.$cdnvideourl");
            }
        } catch (Exception e) {
        }
        return "";
    }

    public final void b(Cursor cursor) {
        this.fileName = cursor.getString(0);
        this.clientId = cursor.getString(1);
        this.fFo = cursor.getLong(2);
        this.hUp = cursor.getInt(3);
        this.hVB = cursor.getInt(4);
        this.hlp = cursor.getInt(5);
        this.hVC = cursor.getInt(6);
        this.hVD = cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.hVE = cursor.getLong(9);
        this.hVF = cursor.getLong(10);
        this.hVG = cursor.getLong(11);
        this.hVH = cursor.getInt(12);
        this.hVI = cursor.getInt(13);
        this.hVJ = cursor.getInt(14);
        this.hVK = cursor.getInt(15);
        this.fDC = cursor.getString(16);
        this.hVz = cursor.getString(17);
        this.hVL = cursor.getInt(18);
        this.hVM = cursor.getInt(19);
        this.hTp = cursor.getString(20);
        this.hVN = cursor.getString(21);
        this.hVO = cursor.getInt(22);
        this.hUa = cursor.getLong(23);
        this.hVP = cursor.getString(24);
        this.fHk = cursor.getString(25);
        byte[] blob = cursor.getBlob(26);
        this.hVQ = new bmf();
        try {
            this.hVQ.aF(blob);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
        }
        this.fGG = cursor.getString(27);
        this.htL = cursor.getInt(28);
        blob = cursor.getBlob(29);
        this.hVR = new aqc();
        try {
            this.hVR.aF(blob);
        } catch (Exception e2) {
        }
        this.fzU = cursor.getInt(30);
        this.videoFormat = cursor.getInt(31);
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, getFileName());
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("clientid", this.clientId == null ? "" : this.clientId);
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("msgsvrid", Long.valueOf(this.fFo));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("netoffset", Integer.valueOf(this.hUp));
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("filenowsize", Integer.valueOf(this.hVB));
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.hlp));
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("thumbnetoffset", Integer.valueOf(this.hVC));
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("thumblen", Integer.valueOf(this.hVD));
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("createtime", Long.valueOf(this.hVE));
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("lastmodifytime", Long.valueOf(this.hVF));
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put("downloadtime", Long.valueOf(this.hVG));
        }
        if ((this.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("videolength", Integer.valueOf(this.hVH));
        }
        if ((this.fDt & 8192) != 0) {
            contentValues.put("msglocalid", Integer.valueOf(this.hVI));
        }
        if ((this.fDt & 16384) != 0) {
            contentValues.put("nettimes", Integer.valueOf(this.hVJ));
        }
        if ((this.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("cameratype", Integer.valueOf(this.hVK));
        }
        if ((this.fDt & 65536) != 0) {
            contentValues.put("user", Ud());
        }
        if ((this.fDt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("human", Ue());
        }
        if ((this.fDt & 262144) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hVL));
        }
        if ((this.fDt & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.hVM));
        }
        if ((this.fDt & 1048576) != 0) {
            contentValues.put("reserved3", Uf());
        }
        if ((this.fDt & 2097152) != 0) {
            contentValues.put("reserved4", Ug());
        }
        if ((this.fDt & 4194304) != 0) {
            contentValues.put("videofuncflag", Integer.valueOf(this.hVO));
        }
        if ((this.fDt & 8388608) != 0) {
            contentValues.put("masssendid", Long.valueOf(this.hUa));
        }
        if ((this.fDt & 16777216) != 0) {
            contentValues.put("masssendlist", this.hVP);
        }
        if ((this.fDt & 33554432) != 0) {
            contentValues.put("videomd5", this.fHk);
        }
        if ((this.fDt & 67108864) != 0) {
            contentValues.put("streamvideo", Uc());
        }
        if ((this.fDt & 134217728) != 0) {
            contentValues.put("statextstr", this.fGG);
        }
        if ((this.fDt & SQLiteDatabase.CREATE_IF_NECESSARY) != 0) {
            contentValues.put("downloadscene", Integer.valueOf(this.htL));
        }
        if ((this.fDt & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            contentValues.put("mmsightextinfo", Uk());
        }
        if ((this.fDt & 1) != 0) {
            contentValues.put("preloadsize", Integer.valueOf(this.fzU));
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("videoformat", Integer.valueOf(this.videoFormat));
        }
        return contentValues;
    }

    private byte[] Uc() {
        byte[] bArr = new byte[0];
        try {
            bArr = this.hVQ.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
        }
        return bArr;
    }

    public final String getFileName() {
        return this.fileName == null ? "" : this.fileName;
    }

    public final String Ud() {
        return this.fDC == null ? "" : this.fDC;
    }

    public final String Ue() {
        return this.hVz == null ? "" : this.hVz;
    }

    public final String Uf() {
        return this.hTp == null ? "" : this.hTp;
    }

    public final String Ug() {
        return this.hVN == null ? "" : this.hVN;
    }

    public final boolean Uh() {
        if (this.status == b.CTRL_INDEX || this.status == j.CTRL_INDEX || this.status == 142) {
            return true;
        }
        return false;
    }

    public final boolean Ui() {
        if (this.status == 121 || this.status == 122 || this.status == 120 || this.status == 123) {
            return true;
        }
        return false;
    }

    public final boolean Uj() {
        if (this.status == 199 || this.status == 199) {
            return true;
        }
        return false;
    }

    private byte[] Uk() {
        byte[] bArr = new byte[0];
        try {
            bArr = this.hVR.toByteArray();
        } catch (Exception e) {
        }
        return bArr;
    }
}
