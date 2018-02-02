package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aw extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fZo = "state".hashCode();
    private static final int gaA = "lastModifiedTime".hashCode();
    private static final int gaB = "isNew".hashCode();
    private static final int gaC = "addScene".hashCode();
    private static final int gaD = "fmsgSysRowId".hashCode();
    private static final int gaE = "fmsgIsSend".hashCode();
    private static final int gaF = "fmsgType".hashCode();
    private static final int gaG = "fmsgContent".hashCode();
    private static final int gaH = "recvFmsgType".hashCode();
    private static final int gaI = "contentFromUsername".hashCode();
    private static final int gaJ = "contentNickname".hashCode();
    private static final int gaK = "contentPhoneNumMD5".hashCode();
    private static final int gaL = "contentFullPhoneNumMD5".hashCode();
    private static final int gaM = "contentVerifyContent".hashCode();
    private static final int gax = "talker".hashCode();
    private static final int gay = "encryptTalker".hashCode();
    private static final int gaz = "displayName".hashCode();
    private boolean fYP = true;
    public int field_addScene;
    public String field_contentFromUsername;
    public String field_contentFullPhoneNumMD5;
    public String field_contentNickname;
    public String field_contentPhoneNumMD5;
    public String field_contentVerifyContent;
    public String field_displayName;
    public String field_encryptTalker;
    public String field_fmsgContent;
    public int field_fmsgIsSend;
    public long field_fmsgSysRowId;
    public int field_fmsgType;
    public int field_isNew;
    public long field_lastModifiedTime;
    public int field_recvFmsgType;
    public int field_state;
    public String field_talker;
    private boolean gah = true;
    private boolean gai = true;
    private boolean gaj = true;
    private boolean gak = true;
    private boolean gal = true;
    private boolean gam = true;
    private boolean gan = true;
    private boolean gao = true;
    private boolean gap = true;
    private boolean gaq = true;
    private boolean gar = true;
    private boolean gas = true;
    private boolean gat = true;
    private boolean gau = true;
    private boolean gav = true;
    private boolean gaw = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gax == hashCode) {
                    this.field_talker = cursor.getString(i);
                    this.gah = true;
                } else if (gay == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (gaz == hashCode) {
                    this.field_displayName = cursor.getString(i);
                } else if (fZo == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (gaA == hashCode) {
                    this.field_lastModifiedTime = cursor.getLong(i);
                } else if (gaB == hashCode) {
                    this.field_isNew = cursor.getInt(i);
                } else if (gaC == hashCode) {
                    this.field_addScene = cursor.getInt(i);
                } else if (gaD == hashCode) {
                    this.field_fmsgSysRowId = cursor.getLong(i);
                } else if (gaE == hashCode) {
                    this.field_fmsgIsSend = cursor.getInt(i);
                } else if (gaF == hashCode) {
                    this.field_fmsgType = cursor.getInt(i);
                } else if (gaG == hashCode) {
                    this.field_fmsgContent = cursor.getString(i);
                } else if (gaH == hashCode) {
                    this.field_recvFmsgType = cursor.getInt(i);
                } else if (gaI == hashCode) {
                    this.field_contentFromUsername = cursor.getString(i);
                } else if (gaJ == hashCode) {
                    this.field_contentNickname = cursor.getString(i);
                } else if (gaK == hashCode) {
                    this.field_contentPhoneNumMD5 = cursor.getString(i);
                } else if (gaL == hashCode) {
                    this.field_contentFullPhoneNumMD5 = cursor.getString(i);
                } else if (gaM == hashCode) {
                    this.field_contentVerifyContent = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_talker == null) {
            this.field_talker = "0";
        }
        if (this.gah) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.gai) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.field_displayName == null) {
            this.field_displayName = "";
        }
        if (this.gaj) {
            contentValues.put("displayName", this.field_displayName);
        }
        if (this.fYP) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.gak) {
            contentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
        }
        if (this.gal) {
            contentValues.put("isNew", Integer.valueOf(this.field_isNew));
        }
        if (this.gam) {
            contentValues.put("addScene", Integer.valueOf(this.field_addScene));
        }
        if (this.gan) {
            contentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
        }
        if (this.gao) {
            contentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
        }
        if (this.gap) {
            contentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
        }
        if (this.field_fmsgContent == null) {
            this.field_fmsgContent = "";
        }
        if (this.gaq) {
            contentValues.put("fmsgContent", this.field_fmsgContent);
        }
        if (this.gar) {
            contentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
        }
        if (this.field_contentFromUsername == null) {
            this.field_contentFromUsername = "";
        }
        if (this.gas) {
            contentValues.put("contentFromUsername", this.field_contentFromUsername);
        }
        if (this.field_contentNickname == null) {
            this.field_contentNickname = "";
        }
        if (this.gat) {
            contentValues.put("contentNickname", this.field_contentNickname);
        }
        if (this.field_contentPhoneNumMD5 == null) {
            this.field_contentPhoneNumMD5 = "";
        }
        if (this.gau) {
            contentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
        }
        if (this.field_contentFullPhoneNumMD5 == null) {
            this.field_contentFullPhoneNumMD5 = "";
        }
        if (this.gav) {
            contentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
        }
        if (this.field_contentVerifyContent == null) {
            this.field_contentVerifyContent = "";
        }
        if (this.gaw) {
            contentValues.put("contentVerifyContent", this.field_contentVerifyContent);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
