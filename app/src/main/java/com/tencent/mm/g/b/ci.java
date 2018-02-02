package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class ci extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNn = "startTime".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int gkN = "musicId".hashCode();
    private static final int gkO = "originMusicId".hashCode();
    private static final int gkP = "musicType".hashCode();
    private static final int gkQ = "downloadedLength".hashCode();
    private static final int gkR = "wifiDownloadedLength".hashCode();
    private static final int gkS = "endFlag".hashCode();
    private static final int gkT = "wifiEndFlag".hashCode();
    private static final int gkU = "songId".hashCode();
    private static final int gkV = "songName".hashCode();
    private static final int gkW = "songSinger".hashCode();
    private static final int gkX = "songAlbum".hashCode();
    private static final int gkY = "songAlbumType".hashCode();
    private static final int gkZ = "songAlbumUrl".hashCode();
    private static final int gla = "songHAlbumUrl".hashCode();
    private static final int glb = "songAlbumLocalPath".hashCode();
    private static final int glc = "songWifiUrl".hashCode();
    private static final int gld = "songWapLinkUrl".hashCode();
    private static final int gle = "songWebUrl".hashCode();
    private static final int glf = "songMediaId".hashCode();
    private static final int glg = "songSnsAlbumUser".hashCode();
    private static final int glh = "songSnsShareUser".hashCode();
    private static final int gli = "songLyric".hashCode();
    private static final int glj = "songBgColor".hashCode();
    private static final int glk = "songLyricColor".hashCode();
    private static final int gll = "songFileLength".hashCode();
    private static final int glm = "songWifiFileLength".hashCode();
    private static final int gln = "hideBanner".hashCode();
    private static final int glo = "jsWebUrlDomain".hashCode();
    private static final int glp = "isBlock".hashCode();
    private static final int glq = "mimetype".hashCode();
    private static final int glr = "protocol".hashCode();
    private static final int gls = "barBackToWebView".hashCode();
    private static final int glt = "musicbar_url".hashCode();
    private boolean fNf = true;
    private boolean fOu = true;
    private boolean fPn = true;
    public String field_appId;
    public boolean field_barBackToWebView;
    public long field_downloadedLength;
    public int field_endFlag;
    public boolean field_hideBanner;
    public int field_isBlock;
    public String field_jsWebUrlDomain;
    public String field_mimetype;
    public String field_musicId;
    public int field_musicType;
    public String field_musicbar_url;
    public String field_originMusicId;
    public String field_protocol;
    public String field_songAlbum;
    public String field_songAlbumLocalPath;
    public int field_songAlbumType;
    public String field_songAlbumUrl;
    public int field_songBgColor;
    public long field_songFileLength;
    public String field_songHAlbumUrl;
    public int field_songId;
    public String field_songLyric;
    public int field_songLyricColor;
    public String field_songMediaId;
    public String field_songName;
    public String field_songSinger;
    public String field_songSnsAlbumUser;
    public String field_songSnsShareUser;
    public String field_songWapLinkUrl;
    public String field_songWebUrl;
    public long field_songWifiFileLength;
    public String field_songWifiUrl;
    public int field_startTime;
    public long field_updateTime;
    public long field_wifiDownloadedLength;
    public int field_wifiEndFlag;
    private boolean gkA = true;
    private boolean gkB = true;
    private boolean gkC = true;
    private boolean gkD = true;
    private boolean gkE = true;
    private boolean gkF = true;
    private boolean gkG = true;
    private boolean gkH = true;
    private boolean gkI = true;
    private boolean gkJ = true;
    private boolean gkK = true;
    private boolean gkL = true;
    private boolean gkM = true;
    private boolean gkg = true;
    private boolean gkh = true;
    private boolean gki = true;
    private boolean gkj = true;
    private boolean gkk = true;
    private boolean gkl = true;
    private boolean gkm = true;
    private boolean gkn = true;
    private boolean gko = true;
    private boolean gkp = true;
    private boolean gkq = true;
    private boolean gkr = true;
    private boolean gks = true;
    private boolean gkt = true;
    private boolean gku = true;
    private boolean gkv = true;
    private boolean gkw = true;
    private boolean gkx = true;
    private boolean gky = true;
    private boolean gkz = true;

    public static a vJ() {
        a aVar = new a();
        aVar.hSY = new Field[36];
        aVar.columns = new String[37];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.xjA.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "musicId";
        aVar.columns[1] = "originMusicId";
        aVar.xjA.put("originMusicId", "TEXT");
        stringBuilder.append(" originMusicId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "musicType";
        aVar.xjA.put("musicType", "INTEGER");
        stringBuilder.append(" musicType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "downloadedLength";
        aVar.xjA.put("downloadedLength", "LONG");
        stringBuilder.append(" downloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "wifiDownloadedLength";
        aVar.xjA.put("wifiDownloadedLength", "LONG");
        stringBuilder.append(" wifiDownloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "endFlag";
        aVar.xjA.put("endFlag", "INTEGER");
        stringBuilder.append(" endFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiEndFlag";
        aVar.xjA.put("wifiEndFlag", "INTEGER");
        stringBuilder.append(" wifiEndFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateTime";
        aVar.xjA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "songId";
        aVar.xjA.put("songId", "INTEGER");
        stringBuilder.append(" songId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "songName";
        aVar.xjA.put("songName", "TEXT");
        stringBuilder.append(" songName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "songSinger";
        aVar.xjA.put("songSinger", "TEXT");
        stringBuilder.append(" songSinger TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "songAlbum";
        aVar.xjA.put("songAlbum", "TEXT");
        stringBuilder.append(" songAlbum TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "songAlbumType";
        aVar.xjA.put("songAlbumType", "INTEGER");
        stringBuilder.append(" songAlbumType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "songAlbumUrl";
        aVar.xjA.put("songAlbumUrl", "TEXT");
        stringBuilder.append(" songAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "songHAlbumUrl";
        aVar.xjA.put("songHAlbumUrl", "TEXT");
        stringBuilder.append(" songHAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "songAlbumLocalPath";
        aVar.xjA.put("songAlbumLocalPath", "TEXT");
        stringBuilder.append(" songAlbumLocalPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "songWifiUrl";
        aVar.xjA.put("songWifiUrl", "TEXT");
        stringBuilder.append(" songWifiUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "songWapLinkUrl";
        aVar.xjA.put("songWapLinkUrl", "TEXT");
        stringBuilder.append(" songWapLinkUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "songWebUrl";
        aVar.xjA.put("songWebUrl", "TEXT");
        stringBuilder.append(" songWebUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "songMediaId";
        aVar.xjA.put("songMediaId", "TEXT");
        stringBuilder.append(" songMediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "songSnsAlbumUser";
        aVar.xjA.put("songSnsAlbumUser", "TEXT");
        stringBuilder.append(" songSnsAlbumUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "songSnsShareUser";
        aVar.xjA.put("songSnsShareUser", "TEXT");
        stringBuilder.append(" songSnsShareUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "songLyric";
        aVar.xjA.put("songLyric", "TEXT");
        stringBuilder.append(" songLyric TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "songBgColor";
        aVar.xjA.put("songBgColor", "INTEGER");
        stringBuilder.append(" songBgColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[25] = "songLyricColor";
        aVar.xjA.put("songLyricColor", "INTEGER");
        stringBuilder.append(" songLyricColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "songFileLength";
        aVar.xjA.put("songFileLength", "LONG");
        stringBuilder.append(" songFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[27] = "songWifiFileLength";
        aVar.xjA.put("songWifiFileLength", "LONG");
        stringBuilder.append(" songWifiFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[28] = "hideBanner";
        aVar.xjA.put("hideBanner", "INTEGER");
        stringBuilder.append(" hideBanner INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "jsWebUrlDomain";
        aVar.xjA.put("jsWebUrlDomain", "TEXT");
        stringBuilder.append(" jsWebUrlDomain TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "isBlock";
        aVar.xjA.put("isBlock", "INTEGER");
        stringBuilder.append(" isBlock INTEGER");
        stringBuilder.append(", ");
        aVar.columns[31] = "startTime";
        aVar.xjA.put("startTime", "INTEGER");
        stringBuilder.append(" startTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[32] = "mimetype";
        aVar.xjA.put("mimetype", "TEXT");
        stringBuilder.append(" mimetype TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "protocol";
        aVar.xjA.put("protocol", "TEXT");
        stringBuilder.append(" protocol TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "barBackToWebView";
        aVar.xjA.put("barBackToWebView", "INTEGER");
        stringBuilder.append(" barBackToWebView INTEGER");
        stringBuilder.append(", ");
        aVar.columns[35] = "musicbar_url";
        aVar.xjA.put("musicbar_url", "TEXT");
        stringBuilder.append(" musicbar_url TEXT");
        aVar.columns[36] = "rowid";
        aVar.xjB = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gkN == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.gkg = true;
                } else if (gkO == hashCode) {
                    this.field_originMusicId = cursor.getString(i);
                } else if (gkP == hashCode) {
                    this.field_musicType = cursor.getInt(i);
                } else if (gkQ == hashCode) {
                    this.field_downloadedLength = cursor.getLong(i);
                } else if (gkR == hashCode) {
                    this.field_wifiDownloadedLength = cursor.getLong(i);
                } else if (gkS == hashCode) {
                    this.field_endFlag = cursor.getInt(i);
                } else if (gkT == hashCode) {
                    this.field_wifiEndFlag = cursor.getInt(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gkU == hashCode) {
                    this.field_songId = cursor.getInt(i);
                } else if (gkV == hashCode) {
                    this.field_songName = cursor.getString(i);
                } else if (gkW == hashCode) {
                    this.field_songSinger = cursor.getString(i);
                } else if (gkX == hashCode) {
                    this.field_songAlbum = cursor.getString(i);
                } else if (gkY == hashCode) {
                    this.field_songAlbumType = cursor.getInt(i);
                } else if (gkZ == hashCode) {
                    this.field_songAlbumUrl = cursor.getString(i);
                } else if (gla == hashCode) {
                    this.field_songHAlbumUrl = cursor.getString(i);
                } else if (glb == hashCode) {
                    this.field_songAlbumLocalPath = cursor.getString(i);
                } else if (glc == hashCode) {
                    this.field_songWifiUrl = cursor.getString(i);
                } else if (gld == hashCode) {
                    this.field_songWapLinkUrl = cursor.getString(i);
                } else if (gle == hashCode) {
                    this.field_songWebUrl = cursor.getString(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (glf == hashCode) {
                    this.field_songMediaId = cursor.getString(i);
                } else if (glg == hashCode) {
                    this.field_songSnsAlbumUser = cursor.getString(i);
                } else if (glh == hashCode) {
                    this.field_songSnsShareUser = cursor.getString(i);
                } else if (gli == hashCode) {
                    this.field_songLyric = cursor.getString(i);
                } else if (glj == hashCode) {
                    this.field_songBgColor = cursor.getInt(i);
                } else if (glk == hashCode) {
                    this.field_songLyricColor = cursor.getInt(i);
                } else if (gll == hashCode) {
                    this.field_songFileLength = cursor.getLong(i);
                } else if (glm == hashCode) {
                    this.field_songWifiFileLength = cursor.getLong(i);
                } else if (gln == hashCode) {
                    this.field_hideBanner = cursor.getInt(i) != 0;
                } else if (glo == hashCode) {
                    this.field_jsWebUrlDomain = cursor.getString(i);
                } else if (glp == hashCode) {
                    this.field_isBlock = cursor.getInt(i);
                } else if (fNn == hashCode) {
                    this.field_startTime = cursor.getInt(i);
                } else if (glq == hashCode) {
                    this.field_mimetype = cursor.getString(i);
                } else if (glr == hashCode) {
                    this.field_protocol = cursor.getString(i);
                } else if (gls == hashCode) {
                    this.field_barBackToWebView = cursor.getInt(i) != 0;
                } else if (glt == hashCode) {
                    this.field_musicbar_url = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gkg) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.gkh) {
            contentValues.put("originMusicId", this.field_originMusicId);
        }
        if (this.gki) {
            contentValues.put("musicType", Integer.valueOf(this.field_musicType));
        }
        if (this.gkj) {
            contentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
        }
        if (this.gkk) {
            contentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
        }
        if (this.gkl) {
            contentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
        }
        if (this.gkm) {
            contentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gkn) {
            contentValues.put("songId", Integer.valueOf(this.field_songId));
        }
        if (this.gko) {
            contentValues.put("songName", this.field_songName);
        }
        if (this.gkp) {
            contentValues.put("songSinger", this.field_songSinger);
        }
        if (this.gkq) {
            contentValues.put("songAlbum", this.field_songAlbum);
        }
        if (this.gkr) {
            contentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
        }
        if (this.gks) {
            contentValues.put("songAlbumUrl", this.field_songAlbumUrl);
        }
        if (this.gkt) {
            contentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
        }
        if (this.gku) {
            contentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
        }
        if (this.gkv) {
            contentValues.put("songWifiUrl", this.field_songWifiUrl);
        }
        if (this.gkw) {
            contentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
        }
        if (this.gkx) {
            contentValues.put("songWebUrl", this.field_songWebUrl);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gky) {
            contentValues.put("songMediaId", this.field_songMediaId);
        }
        if (this.gkz) {
            contentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
        }
        if (this.gkA) {
            contentValues.put("songSnsShareUser", this.field_songSnsShareUser);
        }
        if (this.gkB) {
            contentValues.put("songLyric", this.field_songLyric);
        }
        if (this.gkC) {
            contentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
        }
        if (this.gkD) {
            contentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
        }
        if (this.gkE) {
            contentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
        }
        if (this.gkF) {
            contentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
        }
        if (this.gkG) {
            contentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
        }
        if (this.gkH) {
            contentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
        }
        if (this.gkI) {
            contentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
        }
        if (this.fNf) {
            contentValues.put("startTime", Integer.valueOf(this.field_startTime));
        }
        if (this.gkJ) {
            contentValues.put("mimetype", this.field_mimetype);
        }
        if (this.gkK) {
            contentValues.put("protocol", this.field_protocol);
        }
        if (this.gkL) {
            contentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
        }
        if (this.gkM) {
            contentValues.put("musicbar_url", this.field_musicbar_url);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
