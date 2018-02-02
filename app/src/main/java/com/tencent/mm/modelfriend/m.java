package com.tencent.mm.modelfriend;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.bf.e;
import com.tencent.mm.bf.f;
import com.tencent.mm.bf.l;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m {
    private static Map<String, String> hwf = null;

    public static void NK() {
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(true));
    }

    public static boolean NL() {
        if (ar.Hg() != null) {
            ar.Hg();
            if (c.CU() != null) {
                ar.Hg();
                return bh.a((Boolean) c.CU().get(12322, Boolean.valueOf(true)), true);
            }
        }
        x.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMCore.getAccStg() is null!!!");
        return false;
    }

    public static boolean NM() {
        x.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[]{NN().toString()});
        if (NN() != a.hwi) {
            return false;
        }
        ar.Hg();
        x.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", new Object[]{Boolean.valueOf(bh.a((Boolean) c.CU().get(12322, Boolean.valueOf(false)), false))});
        if (bh.a((Boolean) c.CU().get(12322, Boolean.valueOf(false)), false)) {
            return false;
        }
        return true;
    }

    public static a NN() {
        try {
            ar.Hg();
            String str = (String) c.CU().get(4097, "");
            ar.Hg();
            String str2 = (String) c.CU().get(6, "");
            boolean Gv = q.Gv();
            x.i("MicroMsg.FriendLogic", "isUpload " + Gv + " stat " + q.FW());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && r1 == null) {
                return a.hwg;
            }
            if (str != null && r1 == null) {
                return a.hwh;
            }
            if (Gv) {
                return a.hwi;
            }
            return a.hwj;
        } catch (Exception e) {
            return a.hwg;
        }
    }

    public static void NO() {
        ar.Hg();
        c.CU().set(4097, "");
        ar.Hg();
        c.CU().set(6, "");
    }

    public static String NP() {
        ar.Hg();
        return (String) c.CU().get(6, "");
    }

    public static boolean NQ() {
        if (ar.Hj()) {
            int i;
            if (NN() == a.hwi) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i == 0) {
                x.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[]{Boolean.valueOf(false)});
                return false;
            }
            if (NL()) {
                return true;
            }
            x.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[]{Boolean.valueOf(NL())});
            return false;
        }
        x.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[]{Boolean.valueOf(ar.Hj())});
        return false;
    }

    public static Bitmap a(String str, Context context) {
        return a.a(str, context, false);
    }

    public static boolean a(String str, Context context, byte[] bArr) {
        return a.b(str, context, bArr);
    }

    public static void NR() {
        com.tencent.mm.sdk.e.m OD = af.OD();
        int delete = OD.hhp.delete("addr_upload2", null, null);
        x.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            OD.b(5, OD, null);
        }
    }

    public static void NS() {
        HashSet hashSet = new HashSet();
        Iterator it = l.Tw().Tp().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            ar.Hg();
            au.a EK = c.Fa().EK(fVar.field_msgContent);
            if (EK != null && (EK.scene == 10 || EK.scene == 11)) {
                hashSet.add(fVar.field_talker);
            }
        }
        x.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            e.e(0, (String) it2.next());
        }
    }

    public static void K(List<String> list) {
        if (list.size() != 0) {
            HashSet hashSet = new HashSet();
            Iterator it = l.Tw().Tp().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ar.Hg();
                au.a EK = c.Fa().EK(fVar.field_msgContent);
                if (EK != null) {
                    String str = EK.xzk;
                    String str2 = EK.xzj;
                    if ((EK.scene == 10 || EK.scene == 11) && (list.contains(str) || list.contains(str2))) {
                        hashSet.add(fVar.field_talker);
                    }
                }
            }
            x.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                e.e(0, (String) it2.next());
            }
        }
    }

    public static String kY(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        c OD = af.OD();
        Cursor a = OD.hhp.a("select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + b.kP(str) + "\"", null, 2);
        if (a == null) {
            return "";
        }
        String str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(0);
        }
        a.close();
        return str2;
    }

    public static void L(List<b> list) {
        if (list == null) {
            x.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
        } else {
            af.OD().H(list);
        }
    }

    public static void M(List<String> list) {
        if (list == null) {
            x.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
        } else {
            af.OD().J(list);
        }
    }

    public static List<String> NT() {
        Cursor a = af.OD().hhp.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0));
        }
        a.close();
        return arrayList;
    }

    public static List<String> NU() {
        Cursor a = af.OD().hhp.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            String Id = a.Id(a.getString(0));
            if (a.Rb(Id)) {
                arrayList.add(Id);
            }
        }
        a.close();
        return arrayList;
    }

    public static boolean hD(int i) {
        ab hG = af.OG().hG(i);
        boolean hH = af.OI().hH(i);
        if (hG == null) {
            return false;
        }
        if (hG.hwO == 1 || hH) {
            return true;
        }
        return false;
    }
}
