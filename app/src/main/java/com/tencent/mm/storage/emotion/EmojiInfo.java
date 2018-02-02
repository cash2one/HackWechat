package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.api.i;
import com.tencent.mm.g.b.ap;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public class EmojiInfo extends ap implements Parcelable, i {
    public static final Creator<EmojiInfo> CREATOR = new 1();
    public static int TYPE_TEXT = 4;
    protected static a gJc;
    public static final String lxr = File.separator;
    public static int xAa = -1;
    public static int xAe = 65;
    public static String xAf = ".gif";
    public static int xAg = 17;
    public static int xAh = 32;
    public static int xAi = 49;
    public static int xAj = 50;
    public static int xAk = 81;
    public static int xAl = 1;
    public static int xAm = 2;
    public static int xAn = 3;
    public static int xAo = 10;
    public static int xAp = 11;
    public static int xAq = 0;
    public static int xAr = 1;
    public static int xAs = 3;
    public static int xAt = 4;
    public static int xAu = 8;
    public static int xAv = 0;
    public static int xAw = 1;
    public static int xAx = 0;
    public static int xAy = 1;
    public static int xAz = 1;
    public final String pol;
    public String talker;

    static {
        a aVar = new a();
        aVar.hSY = new Field[31];
        aVar.columns = new String[32];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5";
        aVar.xjA.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xjz = "md5";
        aVar.columns[1] = "svrid";
        aVar.xjA.put("svrid", "TEXT");
        stringBuilder.append(" svrid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "catalog";
        aVar.xjA.put("catalog", "INTEGER");
        stringBuilder.append(" catalog INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "size";
        aVar.xjA.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "start";
        aVar.xjA.put("start", "INTEGER");
        stringBuilder.append(" start INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "state";
        aVar.xjA.put("state", "INTEGER");
        stringBuilder.append(" state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "name";
        aVar.xjA.put("name", "TEXT");
        stringBuilder.append(" name TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "content";
        aVar.xjA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.xjA.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.xjA.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.xjA.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.xjA.put("reserved4", "INTEGER");
        stringBuilder.append(" reserved4 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "app_id";
        aVar.xjA.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId";
        aVar.xjA.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastUseTime";
        aVar.xjA.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "framesInfo";
        aVar.xjA.put("framesInfo", "TEXT default '' ");
        stringBuilder.append(" framesInfo TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "idx";
        aVar.xjA.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "temp";
        aVar.xjA.put("temp", "INTEGER default '0' ");
        stringBuilder.append(" temp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "source";
        aVar.xjA.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "needupload";
        aVar.xjA.put("needupload", "INTEGER default '0' ");
        stringBuilder.append(" needupload INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "designerID";
        aVar.xjA.put("designerID", "TEXT");
        stringBuilder.append(" designerID TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "thumbUrl";
        aVar.xjA.put("thumbUrl", "TEXT");
        stringBuilder.append(" thumbUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "cdnUrl";
        aVar.xjA.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "encrypturl";
        aVar.xjA.put("encrypturl", "TEXT");
        stringBuilder.append(" encrypturl TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "aeskey";
        aVar.xjA.put("aeskey", "TEXT");
        stringBuilder.append(" aeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[26] = "width";
        aVar.xjA.put("width", "INTEGER default '0' ");
        stringBuilder.append(" width INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[27] = "height";
        aVar.xjA.put("height", "INTEGER default '0' ");
        stringBuilder.append(" height INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "externUrl";
        aVar.xjA.put("externUrl", "TEXT");
        stringBuilder.append(" externUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "externMd5";
        aVar.xjA.put("externMd5", "TEXT");
        stringBuilder.append(" externMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "activityid";
        aVar.xjA.put("activityid", "TEXT");
        stringBuilder.append(" activityid TEXT");
        aVar.columns[31] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public EmojiInfo() {
        if (((h) g.Dg().CN()).DS()) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Dk();
            this.pol = stringBuilder.append(g.Dj().gQi).append("emoji/").toString();
        } else {
            this.pol = ((c) g.k(c.class)).getProvider().FC() + "emoji/";
        }
        reset();
    }

    public EmojiInfo(String str) {
        this.pol = str;
        reset();
    }

    public final void reset() {
        this.field_md5 = "";
        this.field_svrid = "";
        this.field_catalog = xAg;
        this.field_type = xAl;
        this.field_size = 0;
        this.field_start = 0;
        this.field_state = xAq;
        this.field_name = "";
        this.field_content = "";
        this.field_reserved1 = "";
        this.field_reserved2 = "";
        this.field_reserved3 = 0;
        this.field_reserved4 = 0;
        this.field_app_id = "";
        this.field_temp = 0;
    }

    public final byte[] eI(int i, int i2) {
        Throwable e;
        Throwable th;
        if (i < 0 || i2 < 0) {
            return null;
        }
        String str;
        if (this.field_catalog == xAg || this.field_catalog == xAj || this.field_catalog == xAi) {
            InputStream bk;
            try {
                x.d("MicroMsg.emoji.EmojiInfo", "get name %s", new Object[]{getName()});
                bk = bk(ac.getContext(), getName());
                try {
                    bk.skip((long) i);
                    byte[] bArr = new byte[i2];
                    bk.read(bArr, 0, i2);
                    if (bk == null) {
                        return bArr;
                    }
                    try {
                        bk.close();
                        return bArr;
                    } catch (Throwable e2) {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bh.i(e2)});
                        return bArr;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bh.i(e)});
                        if (bk != null) {
                            try {
                                bk.close();
                            } catch (Throwable e4) {
                                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bh.i(e4)});
                            }
                        }
                        str = this.pol + Nr();
                        if (ckx()) {
                            str = this.pol + this.field_groupId + File.separator + Nr();
                        }
                        return e.d(str, this.field_start, i2);
                    } catch (Throwable th2) {
                        e4 = th2;
                        if (bk != null) {
                            try {
                                bk.close();
                            } catch (Throwable e22) {
                                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bh.i(e22)});
                            }
                        }
                        throw e4;
                    }
                }
            } catch (Throwable e222) {
                th = e222;
                bk = null;
                e4 = th;
                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bh.i(e4)});
                if (bk != null) {
                    bk.close();
                }
                str = this.pol + Nr();
                if (ckx()) {
                    str = this.pol + this.field_groupId + File.separator + Nr();
                }
                return e.d(str, this.field_start, i2);
            } catch (Throwable e2222) {
                th = e2222;
                bk = null;
                e4 = th;
                if (bk != null) {
                    bk.close();
                }
                throw e4;
            }
        }
        str = this.pol + Nr();
        if (ckx()) {
            str = this.pol + this.field_groupId + File.separator + Nr();
        }
        return e.d(str, this.field_start, i2);
    }

    public final boolean cks() {
        if (this.field_catalog == xAg || this.field_catalog == xAj || this.field_catalog == xAi) {
            return true;
        }
        File file;
        if (bh.ov(this.field_groupId)) {
            file = new File(this.pol + Nr());
        } else {
            file = new File(this.pol + this.field_groupId + File.separator + Nr());
        }
        return file.exists() && file.length() > 0;
    }

    public final void ckt() {
        if (this.field_catalog != xAg && this.field_catalog != xAj && this.field_catalog != xAi) {
            File file;
            if (bh.ov(this.field_groupId)) {
                file = new File(this.pol + Nr());
            } else {
                file = new File(this.pol + this.field_groupId + File.separator + Nr());
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final boolean cku() {
        if (this.field_catalog == xAg || this.field_catalog == xAj || this.field_catalog == xAi) {
            return true;
        }
        return new File(this.pol + this.field_groupId + File.separator + Nr()).exists();
    }

    public static InputStream bk(Context context, String str) {
        InputStream inputStream = null;
        if (!(context == null || bh.ov(str))) {
            try {
                x.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", new Object[]{str.split("\\.")[0]});
                inputStream = context.getResources().openRawResource(context.getResources().getIdentifier(r1, "drawable", context.getPackageName()));
            } catch (Exception e) {
                x.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", new Object[]{e.getMessage()});
            }
        }
        return inputStream;
    }

    public final synchronized Bitmap fn(Context context) {
        return fo(context);
    }

    public final synchronized Bitmap aj(Context context) {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            String name;
            if (this.field_catalog == EmojiGroupInfo.xAc || this.field_catalog == xAj || this.field_catalog == xAi) {
                name = getName();
                if (bh.ov(name)) {
                    x.i("MicroMsg.emoji.EmojiInfo", "name is null");
                    x.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[]{this});
                    bitmap = null;
                } else {
                    if (name.startsWith("jsb")) {
                        name = "jsb";
                    } else if (name.startsWith("dice")) {
                        name = "dice";
                    } else {
                        name = name.replaceAll(".png", "");
                    }
                    bitmap = d.u(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", ac.getPackageName())));
                    x.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[]{Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                }
            } else if (this.field_catalog == EmojiGroupInfo.xAb) {
                name = getName();
                if (bh.ov(name)) {
                    x.i("MicroMsg.emoji.EmojiInfo", "name is null");
                } else {
                    name = (bh.ov(we()) ? getName() : we()).replaceAll(".png", "");
                }
                x.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", new Object[]{name});
                bitmap = d.u(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", ac.getPackageName())));
                x.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[]{Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            } else {
                name = ckB() + "_cover";
                x.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", new Object[]{name, Boolean.valueOf(e.bO(name))});
                if (e.bO(name)) {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(name, options);
                    if (options.outHeight >= 480 || options.outWidth >= 480) {
                        bitmap = d.X(name, 480, 480);
                    } else {
                        bitmap = d.X(name, options.outHeight, options.outWidth);
                    }
                    String str = "MicroMsg.emoji.EmojiInfo";
                    String str2 = "id:%s width:%s height:%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(this.field_catalog);
                    objArr[1] = Integer.valueOf(bitmap == null ? 0 : bitmap.getWidth());
                    if (bitmap != null) {
                        i = bitmap.getHeight();
                    }
                    objArr[2] = Integer.valueOf(i);
                    x.i(str, str2, objArr);
                } else {
                    if (e.bO(ckB())) {
                        byte[] a = ((c) g.k(c.class)).getProvider().a(this);
                        if (a == null) {
                            x.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
                            bitmap = null;
                        } else {
                            x.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", new Object[]{Integer.valueOf(a.length)});
                            if (p.bq(a)) {
                                bitmap = com.tencent.mm.plugin.gif.g.ay(a);
                            } else {
                                bitmap = d.decodeByteArray(a, 480, 480);
                            }
                            if (bitmap != null) {
                                x.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", new Object[]{this, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                            }
                        }
                    } else {
                        x.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", new Object[]{ckB(), Boolean.valueOf(e.bO(ckB()))});
                        x.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[]{this});
                        bitmap = null;
                    }
                }
            }
        }
        return bitmap;
    }

    public final synchronized android.graphics.Bitmap fo(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.storage.emotion.EmojiInfo.fo(android.content.Context):android.graphics.Bitmap. bs: [B:70:0x00fc, B:102:0x01b3]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r5 = 19;
        r1 = 0;
        monitor-enter(r9);
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        com.tencent.mm.bv.a.fromDPToPix(r10, r0);	 Catch:{ all -> 0x0062 }
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = xAg;	 Catch:{ all -> 0x0062 }
        if (r0 == r2) goto L_0x0021;	 Catch:{ all -> 0x0062 }
    L_0x000f:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = com.tencent.mm.storage.emotion.EmojiGroupInfo.xAc;	 Catch:{ all -> 0x0062 }
        if (r0 == r2) goto L_0x0021;	 Catch:{ all -> 0x0062 }
    L_0x0015:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = xAj;	 Catch:{ all -> 0x0062 }
        if (r0 == r2) goto L_0x0021;	 Catch:{ all -> 0x0062 }
    L_0x001b:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = xAi;	 Catch:{ all -> 0x0062 }
        if (r0 != r2) goto L_0x00b5;
    L_0x0021:
        r0 = r9.getName();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r2 = r9.field_type;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r3 = xAm;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        if (r2 != r3) goto L_0x0039;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
    L_0x002b:
        r0 = r9.we();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r0 = com.tencent.mm.sdk.platformtools.bh.ov(r0);	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        if (r0 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
    L_0x0035:
        r0 = r9.getName();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
    L_0x0039:
        r2 = bk(r10, r0);	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r0 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ Exception -> 0x0308 }
        if (r2 == 0) goto L_0x0046;
    L_0x0043:
        r2.close();	 Catch:{ IOException -> 0x004d }
    L_0x0046:
        monitor-exit(r9);
        return r0;
    L_0x0048:
        r0 = r9.we();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        goto L_0x0039;
    L_0x004d:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x0062:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0065:
        r0 = move-exception;
        r2 = r1;
    L_0x0067:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0304 }
        r4 = "exception:%s";	 Catch:{ all -> 0x0304 }
        r5 = 1;	 Catch:{ all -> 0x0304 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0304 }
        r6 = 0;	 Catch:{ all -> 0x0304 }
        r0 = com.tencent.mm.sdk.platformtools.bh.i(r0);	 Catch:{ all -> 0x0304 }
        r5[r6] = r0;	 Catch:{ all -> 0x0304 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x0304 }
        if (r2 == 0) goto L_0x00b3;
    L_0x007c:
        r2.close();	 Catch:{ IOException -> 0x0081 }
        r0 = r1;
        goto L_0x0046;
    L_0x0081:
        r0 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r0 = com.tencent.mm.sdk.platformtools.bh.i(r0);	 Catch:{ all -> 0x0062 }
        r4[r5] = r0;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        r0 = r1;
        goto L_0x0046;
    L_0x0097:
        r0 = move-exception;
    L_0x0098:
        if (r1 == 0) goto L_0x009d;
    L_0x009a:
        r1.close();	 Catch:{ IOException -> 0x009e }
    L_0x009d:
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x009e:
        r1 = move-exception;	 Catch:{ all -> 0x0062 }
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x009d;
    L_0x00b3:
        r0 = r1;
        goto L_0x0046;
    L_0x00b5:
        r0 = r9.ckx();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        if (r0 == 0) goto L_0x011e;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
    L_0x00bb:
        r0 = r9.ckB();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        if (r0 != 0) goto L_0x030e;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
    L_0x00c1:
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r9.pol;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r9.Nr();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = "_0";	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r0;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
    L_0x00ec:
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
    L_0x00f1:
        r2 = r0.exists();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        if (r2 == 0) goto L_0x0181;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
    L_0x00f7:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ FileNotFoundException -> 0x02f7, Exception -> 0x02ec, all -> 0x02e0 }
        r1 = r2;
    L_0x0101:
        if (r1 == 0) goto L_0x0046;
    L_0x0103:
        r1.close();	 Catch:{ IOException -> 0x0108 }
        goto L_0x0046;
    L_0x0108:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x011e:
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = r9.pol;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = r9.Nr();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = "_thumb";	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        goto L_0x00f1;
    L_0x0142:
        r0 = move-exception;
        r2 = r1;
        r8 = r0;
        r0 = r1;
        r1 = r8;
    L_0x0147:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02e9 }
        r4 = "exception:%s";	 Catch:{ all -> 0x02e9 }
        r5 = 1;	 Catch:{ all -> 0x02e9 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02e9 }
        r6 = 0;	 Catch:{ all -> 0x02e9 }
        r7 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x02e9 }
        r5[r6] = r7;	 Catch:{ all -> 0x02e9 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x02e9 }
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02e9 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02e9 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r1);	 Catch:{ all -> 0x02e9 }
        if (r2 == 0) goto L_0x0046;
    L_0x0166:
        r2.close();	 Catch:{ IOException -> 0x016b }
        goto L_0x0046;
    L_0x016b:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x0181:
        r0 = r9.ckx();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        if (r0 == 0) goto L_0x0237;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
    L_0x0187:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        if (r0 >= r5) goto L_0x030b;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
    L_0x018b:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = r9.pol;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = r9.Nr();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r1 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ FileNotFoundException -> 0x02f7, Exception -> 0x02ec, all -> 0x02e3 }
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x01ba:
        r0 = r9.ckx();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        if (r0 == 0) goto L_0x025c;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
    L_0x01c0:
        r0 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = "cpan emojiinfo save cover.";	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r3);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r9.pol;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r9.Nr();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = "_cover";	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r0 = r0.exists();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        if (r0 != 0) goto L_0x0234;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
    L_0x01fe:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        if (r0 >= r5) goto L_0x0234;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
    L_0x0202:
        r0 = 100;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r3 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = r9.pol;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = r9.Nr();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = "_cover";	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = 0;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        com.tencent.mm.sdk.platformtools.d.a(r2, r0, r3, r4, r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
    L_0x0234:
        r0 = r2;
        goto L_0x0101;
    L_0x0237:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = r9.pol;	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r3 = r9.Nr();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0142, Exception -> 0x0285, all -> 0x02c4 }
        r1 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ FileNotFoundException -> 0x02f7, Exception -> 0x02ec, all -> 0x02e6 }
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x01ba;
    L_0x025c:
        r0 = 100;
        r3 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = r9.pol;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = r9.Nr();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = "_thumb";	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r5 = 0;	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        com.tencent.mm.sdk.platformtools.d.a(r2, r0, r3, r4, r5);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f1, all -> 0x02c4 }
        r0 = r2;
        goto L_0x0101;
    L_0x0285:
        r0 = move-exception;
        r2 = r1;
        r8 = r0;
        r0 = r1;
        r1 = r8;
    L_0x028a:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02e9 }
        r4 = "exception:%s";	 Catch:{ all -> 0x02e9 }
        r5 = 1;	 Catch:{ all -> 0x02e9 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02e9 }
        r6 = 0;	 Catch:{ all -> 0x02e9 }
        r7 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x02e9 }
        r5[r6] = r7;	 Catch:{ all -> 0x02e9 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x02e9 }
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02e9 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02e9 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r1);	 Catch:{ all -> 0x02e9 }
        if (r2 == 0) goto L_0x0046;
    L_0x02a9:
        r2.close();	 Catch:{ IOException -> 0x02ae }
        goto L_0x0046;
    L_0x02ae:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x02c4:
        r0 = move-exception;
    L_0x02c5:
        if (r1 == 0) goto L_0x02ca;
    L_0x02c7:
        r1.close();	 Catch:{ IOException -> 0x02cb }
    L_0x02ca:
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x02cb:
        r1 = move-exception;	 Catch:{ all -> 0x0062 }
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bh.i(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x02ca;
    L_0x02e0:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02c5;
    L_0x02e3:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02c5;
    L_0x02e6:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02c5;
    L_0x02e9:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02c5;
    L_0x02ec:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x028a;
    L_0x02f1:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x028a;
    L_0x02f7:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x0147;
    L_0x02fd:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0147;
    L_0x0304:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0098;
    L_0x0308:
        r0 = move-exception;
        goto L_0x0067;
    L_0x030b:
        r2 = r1;
        goto L_0x01ba;
    L_0x030e:
        r2 = r0;
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.EmojiInfo.fo(android.content.Context):android.graphics.Bitmap");
    }

    public final boolean Yz() {
        return this.field_catalog == xAj || this.field_catalog == xAi;
    }

    public final boolean ckv() {
        return this.field_catalog == xAg || this.field_catalog == xAj || this.field_catalog == xAi;
    }

    public final boolean ckw() {
        return this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
    }

    public final boolean isGif() {
        return this.field_type == xAm || this.field_type == xAo;
    }

    public static boolean Du(int i) {
        return i == xAj || i == xAi;
    }

    public final boolean ckx() {
        if (!bh.ov(this.field_app_id) || bh.ov(this.field_groupId) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.xAc)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.xAb)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.xAd)) || this.field_groupId.equals(String.valueOf(xAe))) {
            return false;
        }
        return true;
    }

    public final void kQ(String str) {
        this.field_md5 = str;
    }

    public final String Nr() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    public final boolean cky() {
        return Nr().length() == 32;
    }

    public final String ckz() {
        return this.field_svrid == null ? "" : this.field_svrid;
    }

    public final void Dv(int i) {
        this.field_catalog = i;
    }

    public final void setType(int i) {
        this.field_type = i;
    }

    public final void setSize(int i) {
        this.field_size = i;
    }

    public final String getName() {
        return this.field_name == null ? "" : this.field_name;
    }

    public final String we() {
        return this.field_content == null ? "" : this.field_content;
    }

    public final void Dw(int i) {
        this.field_temp = 1;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean ckA() {
        if (this.field_catalog == xAg || this.field_catalog == EmojiGroupInfo.xAc || this.field_catalog == xAj || this.field_catalog == xAi) {
            return true;
        }
        File file;
        if (ckx()) {
            String ckB = ckB();
            if (ckB == null) {
                ckB = this.pol + this.field_groupId + File.separator + Nr();
            }
            file = new File(ckB);
        } else {
            file = new File(this.pol + Nr());
        }
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public final String ckB() {
        if (bh.ov(this.field_groupId) && bh.ov(this.field_md5)) {
            x.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
            return null;
        } else if (bh.ov(this.field_md5)) {
            return null;
        } else {
            if (bh.ov(this.field_groupId)) {
                return this.pol + this.field_md5;
            }
            return this.pol + this.field_groupId + lxr + this.field_md5;
        }
    }

    public boolean equals(Object obj) {
        return cc(obj);
    }

    public final boolean cc(Object obj) {
        if (obj != null && (obj instanceof EmojiInfo) && ((EmojiInfo) obj).Nr().equalsIgnoreCase(this.field_md5)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field_md5:").append(this.field_md5).append("\n");
        stringBuilder.append("field_svrid:").append(this.field_svrid).append("\n");
        stringBuilder.append("field_catalog:").append(this.field_catalog).append("\n");
        stringBuilder.append("field_type:").append(this.field_type).append("\n");
        stringBuilder.append("field_size:").append(this.field_size).append("\n");
        stringBuilder.append("field_start:").append(this.field_start).append("\n");
        stringBuilder.append("field_state:").append(this.field_state).append("\n");
        stringBuilder.append("field_name:").append(this.field_name).append("\n");
        stringBuilder.append("field_content:").append(this.field_content).append("\n");
        stringBuilder.append("field_reserved1:").append(this.field_reserved1).append("\n");
        stringBuilder.append("field_reserved2:").append(this.field_reserved2).append("\n");
        stringBuilder.append("field_reserved3:").append(this.field_reserved3).append("\n");
        stringBuilder.append("field_reserved4:").append(this.field_reserved4).append("\n");
        stringBuilder.append("field_app_id:").append(this.field_app_id).append("\n");
        stringBuilder.append("field_groupId:").append(this.field_groupId).append("\n");
        stringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
        stringBuilder.append("field_framesInfo:").append(this.field_framesInfo).append("\n");
        stringBuilder.append("field_idx:").append(this.field_idx).append("\n");
        stringBuilder.append("field_temp:").append(this.field_temp).append("\n");
        stringBuilder.append("field_source:").append(this.field_source).append("\n");
        stringBuilder.append("field_needupload:").append(this.field_needupload).append("\n");
        stringBuilder.append("field_designerID:").append(this.field_designerID).append("\n");
        stringBuilder.append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pol);
        parcel.writeString(this.field_md5);
        parcel.writeString(this.field_svrid);
        parcel.writeInt(this.field_catalog);
        parcel.writeInt(this.field_type);
        parcel.writeInt(this.field_size);
        parcel.writeInt(this.field_start);
        parcel.writeInt(this.field_state);
        parcel.writeString(this.field_name);
        parcel.writeString(this.field_content);
        parcel.writeString(this.field_reserved1);
        parcel.writeString(this.field_reserved2);
        parcel.writeInt(this.field_reserved3);
        parcel.writeInt(this.field_reserved4);
        parcel.writeString(this.field_app_id);
        parcel.writeString(this.field_groupId);
        parcel.writeLong(this.field_lastUseTime);
        parcel.writeString(this.field_framesInfo);
        parcel.writeInt(this.field_idx);
        parcel.writeInt(this.field_temp);
        parcel.writeInt(this.field_source);
        parcel.writeInt(this.field_needupload);
        parcel.writeString(this.field_designerID);
        parcel.writeString(this.field_thumbUrl);
        parcel.writeString(this.field_cdnUrl);
        parcel.writeString(this.field_encrypturl);
        parcel.writeString(this.field_aeskey);
        parcel.writeInt(this.field_width);
        parcel.writeInt(this.field_height);
        parcel.writeString(this.field_activityid);
        parcel.writeLong(this.xjy);
    }

    protected EmojiInfo(Parcel parcel) {
        this.pol = parcel.readString();
        this.field_md5 = parcel.readString();
        this.field_svrid = parcel.readString();
        this.field_catalog = parcel.readInt();
        this.field_type = parcel.readInt();
        this.field_size = parcel.readInt();
        this.field_start = parcel.readInt();
        this.field_state = parcel.readInt();
        this.field_name = parcel.readString();
        this.field_content = parcel.readString();
        this.field_reserved1 = parcel.readString();
        this.field_reserved2 = parcel.readString();
        this.field_reserved3 = parcel.readInt();
        this.field_reserved4 = parcel.readInt();
        this.field_app_id = parcel.readString();
        this.field_groupId = parcel.readString();
        this.field_lastUseTime = parcel.readLong();
        this.field_framesInfo = parcel.readString();
        this.field_idx = parcel.readInt();
        this.field_temp = parcel.readInt();
        this.field_source = parcel.readInt();
        this.field_needupload = parcel.readInt();
        this.field_designerID = parcel.readString();
        this.field_thumbUrl = parcel.readString();
        this.field_cdnUrl = parcel.readString();
        this.field_encrypturl = parcel.readString();
        this.field_aeskey = parcel.readString();
        this.field_width = parcel.readInt();
        this.field_height = parcel.readInt();
        this.field_activityid = parcel.readString();
        this.xjy = parcel.readLong();
    }
}
