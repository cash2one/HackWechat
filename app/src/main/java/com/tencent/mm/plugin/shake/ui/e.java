package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.widget.ImageView;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static void a(ImageView imageView, String str, int i, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bh.ov(str)) {
                c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                com_tencent_mm_aq_a_a_c_a.hDC = m.lu(str);
                com_tencent_mm_aq_a_a_c_a.hDA = true;
                com_tencent_mm_aq_a_a_c_a.hDX = true;
                com_tencent_mm_aq_a_a_c_a.hDY = z;
                if (i != 0) {
                    com_tencent_mm_aq_a_a_c_a.hDT = i;
                }
                o.PA().a(str, imageView, com_tencent_mm_aq_a_a_c_a.PK());
            }
        }
    }

    public static String bsz() {
        g brD = m.brD();
        List<f> arrayList = new ArrayList();
        Cursor a = brD.gJP.a("SELECT * FROM " + brD.getTableName() + " where status != 1", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                f fVar = new f();
                fVar.b(a);
                arrayList.add(fVar);
            }
            a.close();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar2 : arrayList) {
            stringBuilder.append(fVar2.field_reserved1);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
