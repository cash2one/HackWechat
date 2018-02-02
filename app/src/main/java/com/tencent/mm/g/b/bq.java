package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public abstract class bq extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fUp = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gdv = "mac".hashCode();
    private static final int gfA = "connProto".hashCode();
    private static final int gfB = "connStrategy".hashCode();
    private static final int gfC = "closeStrategy".hashCode();
    private static final int gfD = "md5Str".hashCode();
    private static final int gfE = "authKey".hashCode();
    private static final int gfF = "sessionKey".hashCode();
    private static final int gfG = "sessionBuf".hashCode();
    private static final int gfH = "authBuf".hashCode();
    private static final int gfI = "lvbuffer".hashCode();
    private static final int gfx = "deviceID".hashCode();
    private static final int gfy = "brandName".hashCode();
    private static final int gfz = "deviceType".hashCode();
    public String category;
    private boolean fTW = true;
    public byte[] field_authBuf;
    public String field_authKey;
    public String field_brandName;
    public int field_closeStrategy;
    public String field_connProto;
    public int field_connStrategy;
    public String field_deviceID;
    public String field_deviceType;
    public byte[] field_lvbuffer;
    public long field_mac;
    public String field_md5Str;
    public byte[] field_sessionBuf;
    public byte[] field_sessionKey;
    public String field_url;
    private boolean gdi = true;
    public int gfJ;
    public int gfK;
    public long gfL;
    private long gfM;
    public String gfN;
    public String gfO;
    public String gfP;
    private int gfQ;
    public int gfR;
    public long gfS;
    public String gfT;
    public String gfU;
    private String gfV;
    public String gfW;
    private boolean gfl = true;
    private boolean gfm = true;
    private boolean gfn = true;
    private boolean gfo = true;
    private boolean gfp = true;
    private boolean gfq = true;
    private boolean gfr = true;
    private boolean gfs = true;
    private boolean gft = true;
    private boolean gfu = true;
    private boolean gfv = true;
    public boolean gfw = true;
    public String iconUrl;
    public String jumpUrl;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfx == hashCode) {
                    this.field_deviceID = cursor.getString(i);
                    this.gfl = true;
                } else if (gfy == hashCode) {
                    this.field_brandName = cursor.getString(i);
                } else if (gdv == hashCode) {
                    this.field_mac = cursor.getLong(i);
                } else if (gfz == hashCode) {
                    this.field_deviceType = cursor.getString(i);
                } else if (gfA == hashCode) {
                    this.field_connProto = cursor.getString(i);
                } else if (gfB == hashCode) {
                    this.field_connStrategy = cursor.getInt(i);
                } else if (gfC == hashCode) {
                    this.field_closeStrategy = cursor.getInt(i);
                } else if (gfD == hashCode) {
                    this.field_md5Str = cursor.getString(i);
                } else if (gfE == hashCode) {
                    this.field_authKey = cursor.getString(i);
                } else if (fUp == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gfF == hashCode) {
                    this.field_sessionKey = cursor.getBlob(i);
                } else if (gfG == hashCode) {
                    this.field_sessionBuf = cursor.getBlob(i);
                } else if (gfH == hashCode) {
                    this.field_authBuf = cursor.getBlob(i);
                } else if (gfI == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    u uVar = new u();
                    int br = uVar.br(this.field_lvbuffer);
                    if (br != 0) {
                        x.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:" + br);
                        return;
                    }
                    if (!uVar.ceW()) {
                        this.gfJ = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gfK = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gfL = uVar.getLong();
                    }
                    if (!uVar.ceW()) {
                        this.gfM = uVar.getLong();
                    }
                    if (!uVar.ceW()) {
                        this.gfN = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.iconUrl = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.jumpUrl = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gfO = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gfP = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.category = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gfQ = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gfR = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.gfS = uVar.getLong();
                    }
                    if (!uVar.ceW()) {
                        this.gfT = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gfU = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gfV = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.gfW = uVar.getString();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    public final ContentValues vI() {
        try {
            if (this.gfw) {
                u uVar = new u();
                uVar.ceX();
                uVar.Dd(this.gfJ);
                uVar.Dd(this.gfK);
                uVar.fF(this.gfL);
                uVar.fF(this.gfM);
                uVar.UV(this.gfN);
                uVar.UV(this.iconUrl);
                uVar.UV(this.jumpUrl);
                uVar.UV(this.gfO);
                uVar.UV(this.gfP);
                uVar.UV(this.category);
                uVar.Dd(this.gfQ);
                uVar.Dd(this.gfR);
                uVar.fF(this.gfS);
                uVar.UV(this.gfT);
                uVar.UV(this.gfU);
                uVar.UV(this.gfV);
                uVar.UV(this.gfW);
                this.field_lvbuffer = uVar.ceY();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[]{e.getMessage()});
        }
        ContentValues contentValues = new ContentValues();
        if (this.gfl) {
            contentValues.put("deviceID", this.field_deviceID);
        }
        if (this.gfm) {
            contentValues.put("brandName", this.field_brandName);
        }
        if (this.gdi) {
            contentValues.put("mac", Long.valueOf(this.field_mac));
        }
        if (this.gfn) {
            contentValues.put("deviceType", this.field_deviceType);
        }
        if (this.gfo) {
            contentValues.put("connProto", this.field_connProto);
        }
        if (this.gfp) {
            contentValues.put("connStrategy", Integer.valueOf(this.field_connStrategy));
        }
        if (this.gfq) {
            contentValues.put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
        }
        if (this.gfr) {
            contentValues.put("md5Str", this.field_md5Str);
        }
        if (this.gfs) {
            contentValues.put("authKey", this.field_authKey);
        }
        if (this.fTW) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gft) {
            contentValues.put("sessionKey", this.field_sessionKey);
        }
        if (this.gfu) {
            contentValues.put("sessionBuf", this.field_sessionBuf);
        }
        if (this.gfv) {
            contentValues.put("authBuf", this.field_authBuf);
        }
        if (this.gfw) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }

    public final void cZ(String str) {
        this.gfN = str;
        this.gfw = true;
    }

    public final void dJ(String str) {
        this.iconUrl = str;
        this.gfw = true;
    }

    public final void dK(String str) {
        this.jumpUrl = str;
        this.gfw = true;
    }

    public final void dL(String str) {
        this.gfO = str;
        this.gfw = true;
    }

    public final void dM(String str) {
        this.gfP = str;
        this.gfw = true;
    }

    public final void dN(String str) {
        this.category = str;
        this.gfw = true;
    }

    public final void eY(int i) {
        this.gfQ = i;
        this.gfw = true;
    }

    public final void eZ(int i) {
        this.gfR = i;
        this.gfw = true;
    }

    public final void an(long j) {
        this.gfS = j;
        this.gfw = true;
    }

    public final void dO(String str) {
        this.gfT = str;
        this.gfw = true;
    }

    public final void dP(String str) {
        this.gfU = str;
        this.gfw = true;
    }

    public final void dQ(String str) {
        this.gfV = str;
        this.gfw = true;
    }

    public final void dR(String str) {
        this.gfW = str;
        this.gfw = true;
    }
}
