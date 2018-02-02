package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class a {
    String luY;
    int luZ = 2;
    int lva = 32;
    HashMap<String, String> lvb = new HashMap();
    HashMap<String, ArrayList<String>> lvc = new HashMap();
    HashMap<String, String> lvd = new HashMap();
    HashMap<String, ArrayList<a>> lve = new HashMap();
    Comparator lvf = new Comparator<a>(this) {
        final /* synthetic */ a lvg;

        {
            this.lvg = r1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    return 1;
                }
                if (aVar.index == aVar2.index) {
                    return 0;
                }
                if (aVar.index > aVar2.index) {
                    return 1;
                }
            }
            return -1;
        }
    };
    boolean mInit = false;

    public final void clear() {
        if (this.lvb != null) {
            this.lvb.clear();
        }
        if (this.lvc != null) {
            this.lvc.clear();
        }
        if (this.lvd != null) {
            this.lvd.clear();
        }
        if (this.lve != null) {
            this.lve.clear();
        }
    }

    public final void aAN() {
        ar.Dm().F(new 2(this));
    }

    public final String xZ(String str) {
        if (this.lvb != null && this.lvb.containsKey(str)) {
            return (String) this.lvb.get(str);
        }
        c cVar = i.aBE().lwN;
        String str2 = null;
        String format = String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "md5_lang"});
        Cursor a = cVar.gJP.a(format, new String[]{str + w.cfi().toLowerCase()}, 2);
        if (a.moveToFirst()) {
            str2 = a.getString(a.getColumnIndex("desc"));
        }
        a.close();
        if (!bh.ov(str2)) {
            return str2;
        }
        Cursor a2 = cVar.gJP.a(format, new String[]{str + "default"}, 2);
        if (a2.moveToFirst()) {
            str2 = a2.getString(a2.getColumnIndex("desc"));
        }
        a2.close();
        return str2;
    }
}
