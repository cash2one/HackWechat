package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;

class b$1 extends c<sh> {
    final /* synthetic */ b lvv;

    b$1(b bVar) {
        this.lvv = bVar;
        this.xen = sh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cf cfVar = ((sh) bVar).fKb.fnB;
        EmojiInfo XU = i.aBE().lwL.XU(cfVar.field_imgPath);
        if (XU != null) {
            if (XU.field_type == EmojiInfo.xAl) {
                Cursor cursor = null;
                if (EmojiInfo.Du(XU.field_catalog)) {
                    cursor = i.aBE().lwL.Dy(XU.field_catalog);
                } else if (XU.field_catalog == EmojiInfo.xAg && XU.we().length() > 0 && EmojiInfo.Du(bh.getInt(XU.we(), 0))) {
                    cursor = i.aBE().lwL.Dy(bh.getInt(XU.we(), 0));
                }
                if (cursor != null) {
                    int eF = bh.eF(cursor.getCount() - 1, 0);
                    XU = new EmojiInfo();
                    cursor.moveToPosition(eF);
                    XU.b(cursor);
                    cursor.close();
                }
                cfVar.dT(XU.Nr());
                cfVar.fb(0);
                aj Xp = aj.Xp(cfVar.field_content);
                Xp.hVA = false;
                cfVar.eQ(1);
                cfVar.setContent(Xp.ciN());
                ar.Hg();
                com.tencent.mm.z.c.Fa().a(cfVar.field_msgId, cfVar);
            }
            i.aBA().a(cfVar.field_talker, XU, cfVar);
        }
        return false;
    }
}
