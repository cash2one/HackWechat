package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class t extends i<s> implements a {
    public static final String[] gJN = new String[]{i.a(s.gJc, "SmileyPanelConfigInfo")};
    private static final String[] xAI = new String[]{"position", "key"};
    public e gJP;

    public t(e eVar) {
        this(eVar, s.gJc, "SmileyPanelConfigInfo");
    }

    private t(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final ArrayList<s> aAX() {
        Cursor a;
        Throwable e;
        ArrayList<s> arrayList = new ArrayList();
        try {
            a = this.gJP.a("SmileyPanelConfigInfo", xAI, null, null, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            s sVar = new s();
                            sVar.b(a);
                            arrayList.add(sVar);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", bh.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", bh.i(e));
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }
}
