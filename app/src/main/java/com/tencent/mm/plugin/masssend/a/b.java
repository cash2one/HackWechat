package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import org.xwalk.core.R$styleable;

public final class b extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public h hhp;

    public b(h hVar) {
        this.hhp = hVar;
    }

    public static Bitmap a(String str, float f) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        Bitmap b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(stringBuilder.append(c.Fi()).append(trim).toString(), f);
        if (b != null) {
            return Bitmap.createScaledBitmap(b, (int) (((float) b.getWidth()) * f), (int) (((float) b.getHeight()) * f), true);
        }
        return b;
    }

    public static Bitmap Ed(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return com.tencent.mm.platformtools.j.op(stringBuilder.append(c.Fi()).append(trim).toString());
    }

    public static a i(String str, String str2, int i, int i2) {
        if (!e.bO(str)) {
            return null;
        }
        ar.Hg();
        String Fi = c.Fi();
        int UJ = ExifHelper.UJ(str);
        String s = g.s((str + System.currentTimeMillis()).getBytes());
        x.d("MicroMsg.MasSendInfoStorage", "insert : original img path = " + str);
        Options UL = d.UL(str);
        if (i2 != 0 || (e.bN(str) <= 204800 && (UL == null || (UL.outHeight <= 960 && UL.outWidth <= 960)))) {
            e.a(Fi, s, ".jpg", e.d(str, 0, e.bN(str)));
        } else {
            if (!d.a(str, 960, 960, CompressFormat.JPEG, 70, Fi, s)) {
                return null;
            }
            e.g(Fi, s, s + ".jpg");
        }
        String str3 = s + ".jpg";
        x.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = " + str3);
        if (i2 == 0 && UJ != 0 && !d.a(Fi + str3, UJ, CompressFormat.JPEG, Fi, s + ".jpg")) {
            return null;
        }
        s = g.s((str3 + System.currentTimeMillis()).getBytes());
        if (!d.a(Fi + str3, 120, 120, CompressFormat.JPEG, 90, Fi, s)) {
            return null;
        }
        x.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = " + s);
        a aVar = new a();
        aVar.msgType = 3;
        aVar.omN = str2;
        aVar.omO = i;
        aVar.omM = s;
        aVar.filename = str3;
        return aVar;
    }

    public static String a(a aVar) {
        switch (aVar.msgType) {
            case 1:
                return aVar.aYw();
            case 3:
                return ac.getContext().getResources().getString(R.l.dGj);
            case 34:
                return ac.getContext().getResources().getString(R.l.dGY);
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                return ac.getContext().getResources().getString(R.l.dGX);
            default:
                return ac.getContext().getResources().getString(R.l.dVA);
        }
    }

    public final a Ee(String str) {
        a aVar = null;
        Cursor a = this.hhp.a("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bh.ot(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.b(a);
            }
            a.close();
        }
        return aVar;
    }
}
