package com.tencent.mm.ad;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import junit.framework.Assert;

public final class i extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    h hhp;
    final f<String, h> hlB = new f(800);

    public i(h hVar) {
        this.hhp = hVar;
    }

    public final h jm(String str) {
        h hVar = (h) this.hlB.get(str);
        if (hVar != null && hVar.getUsername().equals(str)) {
            return hVar;
        }
        Cursor a = this.hhp.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + bh.ot(str) + "\"", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            hVar = new h();
            hVar.b(a);
        } else {
            hVar = null;
        }
        a.close();
        this.hlB.l(str, hVar);
        return hVar;
    }

    public final boolean a(h hVar) {
        boolean z;
        x.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", hVar.JH(), hVar.JG());
        if (jm(hVar.getUsername()) == null) {
            this.hlB.l(hVar.getUsername(), hVar);
            if (hVar == null || hVar.getUsername() == null) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(z);
            hVar.hlw = (int) (System.currentTimeMillis() / 1000);
            hVar.JI();
            hVar.fDt = -1;
            z = ((int) this.hhp.insert("img_flag", "username", hVar.JF())) >= 0;
            if (z) {
                b(hVar.getUsername(), 2, hVar.getUsername());
            }
        } else {
            x.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", jm(hVar.getUsername()).JH(), jm(hVar.getUsername()).JG());
            this.hlB.remove(hVar.getUsername());
            z = (hVar == null || hVar.getUsername() == null) ? false : true;
            Assert.assertTrue(z);
            hVar.hlw = (int) (System.currentTimeMillis() / 1000);
            hVar.fDt |= 4;
            z = this.hhp.update("img_flag", hVar.JF(), "username=?", new String[]{new StringBuilder().append(hVar.getUsername()).toString()}) > 0;
            if (z) {
                b(hVar.getUsername(), 3, hVar.getUsername());
            }
        }
        return z;
    }

    public final boolean H(List<h> list) {
        if (list.size() == 0) {
            return false;
        }
        boolean z;
        long dz = this.hhp.dz(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                a((h) list.get(i));
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.ImgFlagStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.hhp.fS(dz);
        return z;
    }

    public final void jn(String str) {
        if (!bh.ov(str)) {
            this.hlB.remove(str);
            this.hhp.delete("img_flag", "username=?", new String[]{str});
        }
    }
}
