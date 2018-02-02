package com.tencent.mm.z;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class t {
    private static final List<a> hfs = new ArrayList();

    public static int hv(String str) {
        return a(str, null);
    }

    public static int a(String str, List<String> list) {
        if (g.Dh().Cy()) {
            int i;
            long Wq = bh.Wq();
            Cursor r = ((h) g.h(h.class)).Fd().r(str, list);
            long Wq2 = bh.Wq();
            if (r == null || r.getCount() <= 0) {
                i = 0;
            } else {
                r.moveToFirst();
                i = r.getInt(0);
            }
            if (r != null) {
                r.close();
            }
            x.d("MicroMsg.ConversationLogic", "unreadcheck unRead getTotalUnread %d", new Object[]{Integer.valueOf(i)});
            if (i <= 0) {
                i = 0;
            } else {
                Cursor Xh = ((h) g.h(h.class)).Fd().Xh(str);
                if (Xh == null) {
                    x.w("MicroMsg.ConversationLogic", "cursor is null, return");
                    x.i("MicroMsg.ConversationLogic", "get count use %d ms", new Object[]{Long.valueOf(bh.bA(Wq2))});
                } else {
                    Xh.moveToFirst();
                    while (!Xh.isAfterLast()) {
                        int i2;
                        af WO = ((h) g.h(h.class)).EY().WO(Xh.getString(0));
                        if (WO == null || WO.fWn != 0) {
                            i2 = i;
                        } else {
                            i2 = i - Xh.getInt(1);
                            x.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", new Object[]{WO.field_username, Integer.valueOf(i2)});
                        }
                        Xh.moveToNext();
                        i = i2;
                    }
                    x.i("MicroMsg.ConversationLogic", "unreadcheck  result talker count is %d", new Object[]{Integer.valueOf(i)});
                    Xh.close();
                    x.i("MicroMsg.ConversationLogic", "unreadcheck get count use %d ms", new Object[]{Long.valueOf(bh.bA(Wq2))});
                    i = Math.max(0, i);
                }
            }
            r.close();
            x.i("MicroMsg.ConversationLogic", "get count with black list use %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
            return i;
        }
        x.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
        return 0;
    }

    public static int M(String str, String str2) {
        if (g.Dh().Cy()) {
            int i;
            Cursor fD = ((h) g.h(h.class)).Fd().fD(str, str2);
            if (fD == null || fD.getCount() <= 0) {
                i = 0;
            } else {
                fD.moveToFirst();
                i = fD.getInt(0);
            }
            if (fD == null) {
                return i;
            }
            fD.close();
            return i;
        }
        x.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
        return 0;
    }

    public static int hw(String str) {
        if (g.Dh().Cy()) {
            int i;
            long Wq = bh.Wq();
            Cursor s = ((h) g.h(h.class)).Fd().s(str, null);
            if (s.getCount() > 0) {
                s.moveToFirst();
                i = s.getInt(0);
            } else {
                i = 0;
            }
            s.close();
            if (i <= 0) {
                return 0;
            }
            s = ((h) g.h(h.class)).Fd().Xh(str);
            if (s == null) {
                x.w("MicroMsg.ConversationLogic", "cursor is null, return");
                x.i("MicroMsg.ConversationLogic", "get count use %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
                return i;
            }
            s.moveToFirst();
            while (!s.isAfterLast()) {
                af WO = ((h) g.h(h.class)).EY().WO(s.getString(0));
                int i2 = (WO == null || WO.fWn != 0) ? i : i - 1;
                s.moveToNext();
                i = i2;
            }
            x.i("MicroMsg.ConversationLogic", "result talker count is %d", new Object[]{Integer.valueOf(i)});
            s.close();
            x.i("MicroMsg.ConversationLogic", "get count use %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
            return Math.max(0, i);
        }
        x.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
        return 0;
    }

    public static List<String> G(String str, int i) {
        List<String> list = null;
        if (g.Dh().Cy()) {
            Cursor db = ((h) g.h(h.class)).Fd().db(str, -1);
            if (db.moveToNext()) {
                ArrayList arrayList = new ArrayList();
                do {
                    x.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", new Object[]{db.getString(0)});
                    arrayList.add(db.getString(0));
                } while (db.moveToNext());
                list = arrayList;
            }
            db.close();
            if (list != null) {
                db = ((h) g.h(h.class)).Fd().Xh(str);
                if (db != null) {
                    db.moveToFirst();
                    while (!db.isAfterLast()) {
                        af WO = ((h) g.h(h.class)).EY().WO(db.getString(0));
                        if (WO != null && WO.fWn == 0) {
                            x.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", new Object[]{WO.AP()});
                            list.remove(WO.AP());
                        }
                        db.moveToNext();
                    }
                    db.close();
                }
            }
        } else {
            x.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
        }
        return list;
    }

    public static int N(String str, String str2) {
        if (bh.ov(str)) {
            return 0;
        }
        if ("notification_messages".equals(str)) {
            return 8;
        }
        if (str2 != null && str2.endsWith("@chatroom")) {
            return 2;
        }
        int i;
        PInt pInt = new PInt();
        synchronized (hfs) {
            int i2 = 0;
            boolean z = false;
            while (i2 < hfs.size()) {
                boolean a;
                a aVar = (a) hfs.get(i2);
                if (aVar != null) {
                    a = aVar.a(str, str2, pInt);
                    if (a) {
                        z = a;
                        i = pInt.value;
                        break;
                    }
                } else {
                    a = z;
                }
                i2++;
                z = a;
            }
            i = 0;
        }
        if (z) {
            return i;
        }
        return 1;
    }

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        synchronized (hfs) {
            hfs.add(aVar);
        }
    }
}
