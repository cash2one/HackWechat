package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ad.n;
import com.tencent.mm.by.e;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> kiU = new ArrayList();
    private static final String[] maP = new String[]{"userId", "nickname", "avatar", "content", "msgId", "msgType"};
    private Cursor maT = null;

    static {
        int i = 0;
        String[] strArr = s.hfr;
        int length = strArr.length;
        while (i < length) {
            kiU.add(strArr[i]);
            i++;
        }
        kiU.add("officialaccounts");
        kiU.add("helper_entry");
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlProviderSearchContact", "query()");
        a(uri, getContext(), 16);
        if (uri == null) {
            pp(3);
            return null;
        } else if (bh.ov(this.maf) || bh.ov(aFM())) {
            pp(3);
            return null;
        } else if (!aqY()) {
            pp(1);
            return this.kuZ;
        } else if (!cz(getContext())) {
            x.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            pp(2);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            x.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            pp(3);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (bh.ov(trim)) {
                x.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                pp(3);
                return null;
            }
            Cursor a = ar.Hg().heA.a(trim, "@micromsg.no.verify.biz.qq.com", null, kiU, false, false, false, 1, null);
            if (a == null) {
                x.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                pp(3);
                return null;
            }
            b bVar = new b();
            bVar.b(4000, new 1(this, a, bVar));
            if (this.maT != null) {
                pp(0);
            } else {
                pp(4);
            }
            return this.maT;
        }
    }

    public static Cursor e(Cursor cursor) {
        Object eVar = new e(maP, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    af xVar = new com.tencent.mm.storage.x();
                    xVar.b(cursor);
                    if (!s.eV(xVar.field_username)) {
                        ByteArrayOutputStream byteArrayOutputStream;
                        Bitmap b = n.JS().b(xVar.field_username, true, 0);
                        if (b != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            x.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        ar.Hg();
                        au[] bF = c.Fa().bF(xVar.field_username, 1);
                        byte[] bArr;
                        if (bF == null || bF.length != 1) {
                            x.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = a.cO((long) ((int) xVar.gJd));
                            objArr[1] = xVar.AQ();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = bArr;
                            objArr[3] = "";
                            objArr[4] = "0";
                            objArr[5] = Integer.valueOf(0);
                            eVar.addRow(objArr);
                        } else {
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = a.cO((long) ((int) xVar.gJd));
                            objArr2[1] = xVar.AQ();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr2[2] = bArr;
                            objArr2[3] = bF[0].getType() == 1 ? bF[0].field_content : "";
                            objArr2[4] = a.cO(bF[0].field_msgId);
                            objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.ext.b.b.M(bF[0]));
                            eVar.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i2 >= 15) {
                        break;
                    }
                    i = i2;
                }
            }
            cursor.close();
            return eVar;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderSearchContact", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            eVar.close();
            return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
