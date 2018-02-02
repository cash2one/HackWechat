package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class bg extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fUp = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gdk = "ssidmd5".hashCode();
    private static final int gdl = "ssid".hashCode();
    private static final int gdm = "mid".hashCode();
    private static final int gdn = "connectState".hashCode();
    private static final int gdo = "expiredTime".hashCode();
    private static final int gdp = "wifiType".hashCode();
    private static final int gdq = "action".hashCode();
    private static final int gdr = "showUrl".hashCode();
    private static final int gds = "showWordEn".hashCode();
    private static final int gdt = "showWordCn".hashCode();
    private static final int gdu = "showWordTw".hashCode();
    private static final int gdv = "mac".hashCode();
    private static final int gdw = "verifyResult".hashCode();
    private boolean fTW = true;
    public int field_action;
    public int field_connectState;
    public long field_expiredTime;
    public String field_mac;
    public String field_mid;
    public String field_showUrl;
    public String field_showWordCn;
    public String field_showWordEn;
    public String field_showWordTw;
    public String field_ssid;
    public String field_ssidmd5;
    public String field_url;
    public int field_verifyResult;
    public int field_wifiType;
    private boolean gcX = true;
    private boolean gcY = true;
    private boolean gcZ = true;
    private boolean gda = true;
    private boolean gdb = true;
    private boolean gdc = true;
    private boolean gdd = true;
    private boolean gde = true;
    private boolean gdf = true;
    private boolean gdg = true;
    private boolean gdh = true;
    private boolean gdi = true;
    private boolean gdj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdk == hashCode) {
                    this.field_ssidmd5 = cursor.getString(i);
                    this.gcX = true;
                } else if (gdl == hashCode) {
                    this.field_ssid = cursor.getString(i);
                } else if (gdm == hashCode) {
                    this.field_mid = cursor.getString(i);
                } else if (fUp == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gdn == hashCode) {
                    this.field_connectState = cursor.getInt(i);
                } else if (gdo == hashCode) {
                    this.field_expiredTime = cursor.getLong(i);
                } else if (gdp == hashCode) {
                    this.field_wifiType = cursor.getInt(i);
                } else if (gdq == hashCode) {
                    this.field_action = cursor.getInt(i);
                } else if (gdr == hashCode) {
                    this.field_showUrl = cursor.getString(i);
                } else if (gds == hashCode) {
                    this.field_showWordEn = cursor.getString(i);
                } else if (gdt == hashCode) {
                    this.field_showWordCn = cursor.getString(i);
                } else if (gdu == hashCode) {
                    this.field_showWordTw = cursor.getString(i);
                } else if (gdv == hashCode) {
                    this.field_mac = cursor.getString(i);
                } else if (gdw == hashCode) {
                    this.field_verifyResult = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gcX) {
            contentValues.put("ssidmd5", this.field_ssidmd5);
        }
        if (this.gcY) {
            contentValues.put("ssid", this.field_ssid);
        }
        if (this.gcZ) {
            contentValues.put("mid", this.field_mid);
        }
        if (this.fTW) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gda) {
            contentValues.put("connectState", Integer.valueOf(this.field_connectState));
        }
        if (this.gdb) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.gdc) {
            contentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
        }
        if (this.gdd) {
            contentValues.put("action", Integer.valueOf(this.field_action));
        }
        if (this.gde) {
            contentValues.put("showUrl", this.field_showUrl);
        }
        if (this.gdf) {
            contentValues.put("showWordEn", this.field_showWordEn);
        }
        if (this.gdg) {
            contentValues.put("showWordCn", this.field_showWordCn);
        }
        if (this.gdh) {
            contentValues.put("showWordTw", this.field_showWordTw);
        }
        if (this.gdi) {
            contentValues.put("mac", this.field_mac);
        }
        if (this.gdj) {
            contentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
