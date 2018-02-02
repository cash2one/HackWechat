package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ee extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS WebViewResourceCacheAppIdIndex ON WebViewResourceCache(appId)", "CREATE INDEX IF NOT EXISTS WebViewResourceCacheDomainIndex ON WebViewResourceCache(domain)", "CREATE INDEX IF NOT EXISTS WebViewResourceCachePackageIdIndex ON WebViewResourceCache(packageId)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPB = "version".hashCode();
    private static final int fUp = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gbg = "configId".hashCode();
    private static final int gek = "expireTime".hashCode();
    private static final int glr = "protocol".hashCode();
    private static final int gnH = "packageId".hashCode();
    private static final int gno = "contentLength".hashCode();
    private static final int gnp = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int gvk = "urlMd5Hashcode".hashCode();
    private static final int gvl = "domain".hashCode();
    private static final int gvm = "localPath".hashCode();
    private static final int gvn = "isLatestVersion".hashCode();
    private static final int gvo = "accessTime".hashCode();
    private static final int gvp = "cacheType".hashCode();
    private static final int gvq = "contentMd5".hashCode();
    private boolean fNB = true;
    private boolean fOu = true;
    private boolean fPu = true;
    private boolean fTW = true;
    public long field_accessTime;
    public String field_appId;
    public int field_cacheType;
    public String field_configId;
    public long field_contentLength;
    public String field_contentMd5;
    public String field_contentType;
    public long field_createTime;
    public String field_domain;
    public long field_expireTime;
    public boolean field_isLatestVersion;
    public String field_localPath;
    public String field_packageId;
    public int field_protocol;
    public String field_url;
    public int field_urlMd5Hashcode;
    public String field_version;
    private boolean gbf = true;
    private boolean geb = true;
    private boolean gkK = true;
    private boolean gmO = true;
    private boolean gmP = true;
    private boolean gnh = true;
    private boolean gvd = true;
    private boolean gve = true;
    private boolean gvf = true;
    private boolean gvg = true;
    private boolean gvh = true;
    private boolean gvi = true;
    private boolean gvj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gvk == hashCode) {
                    this.field_urlMd5Hashcode = cursor.getInt(i);
                } else if (fUp == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gvl == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (fPB == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (gvm == hashCode) {
                    this.field_localPath = cursor.getString(i);
                } else if (gnp == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (gno == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (gvn == hashCode) {
                    this.field_isLatestVersion = cursor.getInt(i) != 0;
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gvo == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (gek == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gvp == hashCode) {
                    this.field_cacheType = cursor.getInt(i);
                } else if (gbg == hashCode) {
                    this.field_configId = cursor.getString(i);
                } else if (glr == hashCode) {
                    this.field_protocol = cursor.getInt(i);
                } else if (gnH == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (gvq == hashCode) {
                    this.field_contentMd5 = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gvd) {
            contentValues.put("urlMd5Hashcode", Integer.valueOf(this.field_urlMd5Hashcode));
        }
        if (this.fTW) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gve) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.fPu) {
            contentValues.put("version", this.field_version);
        }
        if (this.gvf) {
            contentValues.put("localPath", this.field_localPath);
        }
        if (this.gmP) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.gmO) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.gvg) {
            contentValues.put("isLatestVersion", Boolean.valueOf(this.field_isLatestVersion));
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gvh) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.geb) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.gvi) {
            contentValues.put("cacheType", Integer.valueOf(this.field_cacheType));
        }
        if (this.gbf) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.gkK) {
            contentValues.put("protocol", Integer.valueOf(this.field_protocol));
        }
        if (this.gnh) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.gvj) {
            contentValues.put("contentMd5", this.field_contentMd5);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
