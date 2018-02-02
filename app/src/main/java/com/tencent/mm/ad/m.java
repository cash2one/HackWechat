package com.tencent.mm.ad;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class m {
    private static List<String> hlK = null;
    private static int hlL = 0;
    private static a hlM = new a(new b());

    static class b implements com.tencent.mm.sdk.platformtools.ak.a {
        Runnable hlO;

        b() {
        }

        public final boolean uF() {
            int size = m.hlK.size();
            x.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:" + size);
            if (size <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || m.hlL >= 300) {
                if (this.hlO != null) {
                    this.hlO.run();
                }
                m.hlL = 0;
                return false;
            }
            long dz = g.Dj().gQj.dz(Thread.currentThread().getId());
            for (int i = size - 1; i >= size - 30; i--) {
                m.JO();
                String str = (String) m.hlK.get(i);
                m.hlK.remove(i);
                n.Jz();
                d.y(str, false);
                n.Jz();
                d.y(str, true);
                n.JQ().jn(str);
            }
            g.Dj().gQj.fS(dz);
            return true;
        }
    }

    static class a extends ak {
        final b hlN;

        public a(b bVar) {
            super(bVar, true);
            this.hlN = bVar;
        }
    }

    static /* synthetic */ int JO() {
        int i = hlL;
        hlL = i + 1;
        return i;
    }

    public static void j(Runnable runnable) {
        if (g.Dh().Cy()) {
            i JQ = n.JQ();
            List arrayList = new ArrayList();
            Cursor a = JQ.hhp.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            hlK = arrayList;
            if (arrayList.size() > 0) {
                hlM.hlN.hlO = runnable;
                hlM.J(10, 10);
            }
        }
    }

    public static void JK() {
        hlL = 0;
        hlM.TG();
    }
}
