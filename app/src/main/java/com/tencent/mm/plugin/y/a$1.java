package com.tencent.mm.plugin.y;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.y.a.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class a$1 implements a {
    final /* synthetic */ a oZM;

    a$1(a aVar) {
        this.oZM = aVar;
    }

    public final f Hg(String str) {
        return a.bin().RF(str);
    }

    public final Cursor uv(int i) {
        Cursor rawQuery = a.bin().rawQuery("select * from AppInfo where status = 5" + " order by modifyTime asc", new String[0]);
        if (rawQuery != null) {
            return rawQuery;
        }
        x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
        return null;
    }

    public final Cursor k(int[] iArr) {
        i bin = a.bin();
        String str = "select * from AppInfo where ";
        for (int i = 0; i <= 0; i++) {
            str = str + " status = " + iArr[0];
        }
        Cursor rawQuery = bin.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
        if (rawQuery != null) {
            return rawQuery;
        }
        x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
        return null;
    }

    public final Bitmap a(String str, int i, float f) {
        a.bin();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
            return null;
        } else if (str.equals("wx7fa037cc7dfabad5")) {
            return BitmapFactory.decodeResource(ac.getContext().getResources(), d.bKy);
        } else {
            String cR = i.cR(str, i);
            if (e.bO(cR)) {
                return b.b(cR, f);
            }
            x.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + cR + ", iconType = " + i);
            return null;
        }
    }

    public final void bR(String str, int i) {
        a.bil().cP(str, i);
    }

    public final void Hh(String str) {
        a.bim().RD(str);
    }

    public final void c(f fVar) {
        i bin = a.bin();
        if (fVar != null && fVar.field_status != 5) {
            fVar.field_status = 3;
            x.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[]{fVar.field_packageName});
            bin.a(fVar, new String[0]);
        }
    }

    public final void d(f fVar) {
        i bin = a.bin();
        if (fVar != null && fVar.field_status == 3) {
            fVar.field_status = 4;
            bin.a(fVar, new String[0]);
        }
    }

    public final void e(f fVar) {
        a.bin().a(fVar, new String[0]);
    }

    public final i biq() {
        return a.bin();
    }

    public final void Z(LinkedList<String> linkedList) {
        a.bim().at(linkedList);
    }

    public final Cursor df(int i, int i2) {
        return a.bin().df(i, i2);
    }

    public final Cursor bir() {
        i bin = a.bin();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        stringBuilder.append("serviceAppType > 0");
        Cursor rawQuery = bin.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
            return null;
        }
        x.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[]{Integer.valueOf(rawQuery.getCount())});
        return rawQuery;
    }
}
