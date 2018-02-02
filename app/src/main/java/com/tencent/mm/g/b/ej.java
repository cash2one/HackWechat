package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOZ = "signature".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fTI = "nickname".hashCode();
    private static final int fTu = "brandIconURL".hashCode();
    private static final int giX = "versionInfo".hashCode();
    private static final int gjx = "reserved".hashCode();
    private static final int gwA = "registerSource".hashCode();
    private static final int gwB = "appInfo".hashCode();
    private static final int gwC = "bindWxaInfo".hashCode();
    private static final int gwD = "dynamicInfo".hashCode();
    private static final int gwE = "syncTimeSecond".hashCode();
    private static final int gwF = "syncVersion".hashCode();
    private static final int gwG = "bizMenu".hashCode();
    private static final int gwv = "usernameHash".hashCode();
    private static final int gww = "roundedSquareIconURL".hashCode();
    private static final int gwx = "bigHeadURL".hashCode();
    private static final int gwy = "smallHeadURL".hashCode();
    private static final int gwz = "appOpt".hashCode();
    private boolean fOI = true;
    private boolean fOu = true;
    private boolean fPs = true;
    private boolean fTE = true;
    private boolean fTg = true;
    public String field_appId;
    public String field_appInfo;
    public int field_appOpt;
    public String field_bigHeadURL;
    public String field_bindWxaInfo;
    public String field_bizMenu;
    public String field_brandIconURL;
    public String field_dynamicInfo;
    public String field_nickname;
    public String field_registerSource;
    public String field_reserved;
    public String field_roundedSquareIconURL;
    public String field_signature;
    public String field_smallHeadURL;
    public long field_syncTimeSecond;
    public String field_syncVersion;
    public String field_username;
    public int field_usernameHash;
    public String field_versionInfo;
    private boolean giS = true;
    private boolean gjo = true;
    private boolean gwj = true;
    private boolean gwk = true;
    private boolean gwl = true;
    private boolean gwm = true;
    private boolean gwn = true;
    private boolean gwo = true;
    private boolean gwp = true;
    private boolean gwq = true;
    private boolean gwr = true;
    private boolean gws = true;
    private boolean gwt = true;
    private boolean gwu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gwv == hashCode) {
                    this.field_usernameHash = cursor.getInt(i);
                    this.gwj = true;
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fTI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (fTu == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (gww == hashCode) {
                    this.field_roundedSquareIconURL = cursor.getString(i);
                } else if (gwx == hashCode) {
                    this.field_bigHeadURL = cursor.getString(i);
                } else if (gwy == hashCode) {
                    this.field_smallHeadURL = cursor.getString(i);
                } else if (fOZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (gwz == hashCode) {
                    this.field_appOpt = cursor.getInt(i);
                } else if (gwA == hashCode) {
                    this.field_registerSource = cursor.getString(i);
                } else if (gwB == hashCode) {
                    this.field_appInfo = cursor.getString(i);
                } else if (giX == hashCode) {
                    this.field_versionInfo = cursor.getString(i);
                } else if (gwC == hashCode) {
                    this.field_bindWxaInfo = cursor.getString(i);
                } else if (gwD == hashCode) {
                    this.field_dynamicInfo = cursor.getString(i);
                } else if (gjx == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (gwE == hashCode) {
                    this.field_syncTimeSecond = cursor.getLong(i);
                } else if (gwF == hashCode) {
                    this.field_syncVersion = cursor.getString(i);
                } else if (gwG == hashCode) {
                    this.field_bizMenu = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gwj) {
            contentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fTE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fTg) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.gwk) {
            contentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
        }
        if (this.gwl) {
            contentValues.put("bigHeadURL", this.field_bigHeadURL);
        }
        if (this.gwm) {
            contentValues.put("smallHeadURL", this.field_smallHeadURL);
        }
        if (this.fOI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.gwn) {
            contentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
        }
        if (this.gwo) {
            contentValues.put("registerSource", this.field_registerSource);
        }
        if (this.gwp) {
            contentValues.put("appInfo", this.field_appInfo);
        }
        if (this.giS) {
            contentValues.put("versionInfo", this.field_versionInfo);
        }
        if (this.gwq) {
            contentValues.put("bindWxaInfo", this.field_bindWxaInfo);
        }
        if (this.gwr) {
            contentValues.put("dynamicInfo", this.field_dynamicInfo);
        }
        if (this.gjo) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.gws) {
            contentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
        }
        if (this.gwt) {
            contentValues.put("syncVersion", this.field_syncVersion);
        }
        if (this.gwu) {
            contentValues.put("bizMenu", this.field_bizMenu);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
