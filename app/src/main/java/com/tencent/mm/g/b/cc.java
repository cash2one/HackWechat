package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.any;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.cau;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cc extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int giK = "appIdHash".hashCode();
    private static final int giL = "launchAction".hashCode();
    private static final int giM = "jsapiInfo".hashCode();
    private static final int giN = "hostInfo".hashCode();
    private static final int giO = "actionsheetInfo".hashCode();
    private boolean fOu = true;
    public aw field_actionsheetInfo;
    public String field_appId;
    public int field_appIdHash;
    public cau field_hostInfo;
    public nc field_jsapiInfo;
    public any field_launchAction;
    private boolean giF = true;
    private boolean giG = true;
    private boolean giH = true;
    private boolean giI = true;
    private boolean giJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (giK == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.giF = true;
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (giL == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_launchAction = (any) new any().aF(r0);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
                    }
                } else if (giM == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_jsapiInfo = (nc) new nc().aF(r0);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
                    }
                } else if (giN == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_hostInfo = (cau) new cau().aF(r0);
                        }
                    } catch (IOException e22) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
                    }
                } else if (giO == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_actionsheetInfo = (aw) new aw().aF(r0);
                        }
                    } catch (IOException e222) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
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
        if (this.giG && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
            }
        }
        if (this.giH && this.field_jsapiInfo != null) {
            try {
                contentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
            }
        }
        if (this.giI && this.field_hostInfo != null) {
            try {
                contentValues.put("hostInfo", this.field_hostInfo.toByteArray());
            } catch (IOException e22) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
            }
        }
        if (this.giJ && this.field_actionsheetInfo != null) {
            try {
                contentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            } catch (IOException e222) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
            }
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
