package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.cag;
import com.tencent.mm.protocal.c.cah;
import com.tencent.mm.protocal.c.cbu;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cd extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int giK = "appIdHash".hashCode();
    private static final int giL = "launchAction".hashCode();
    private static final int giU = "pkgType".hashCode();
    private static final int giV = "widgetType".hashCode();
    private static final int giW = "jsApiInfo".hashCode();
    private static final int giX = "versionInfo".hashCode();
    private static final int giY = "widgetSetting".hashCode();
    private boolean fOu = true;
    public String field_appId;
    public int field_appIdHash;
    public nc field_jsApiInfo;
    public cag field_launchAction;
    public int field_pkgType;
    public cah field_versionInfo;
    public cbu field_widgetSetting;
    public int field_widgetType;
    private boolean giF = true;
    private boolean giG = true;
    private boolean giP = true;
    private boolean giQ = true;
    private boolean giR = true;
    private boolean giS = true;
    private boolean giT = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (giK == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (giU == hashCode) {
                    this.field_pkgType = cursor.getInt(i);
                } else if (giV == hashCode) {
                    this.field_widgetType = cursor.getInt(i);
                } else if (giL == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_launchAction = (cag) new cag().aF(r0);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
                    }
                } else if (giW == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_jsApiInfo = (nc) new nc().aF(r0);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
                    }
                } else if (giX == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_versionInfo = (cah) new cah().aF(r0);
                        }
                    } catch (IOException e22) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
                    }
                } else if (giY == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_widgetSetting = (cbu) new cbu().aF(r0);
                        }
                    } catch (IOException e222) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
                    }
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.giF) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.giP) {
            contentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
        }
        if (this.giQ) {
            contentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
        }
        if (this.giG && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
            }
        }
        if (this.giR && this.field_jsApiInfo != null) {
            try {
                contentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
            }
        }
        if (this.giS && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e22) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
            }
        }
        if (this.giT && this.field_widgetSetting != null) {
            try {
                contentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
            } catch (IOException e222) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
            }
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
