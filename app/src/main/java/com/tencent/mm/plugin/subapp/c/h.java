package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import junit.framework.Assert;

public final class h {
    public static String aJ(String str, boolean z) {
        ar.Hg();
        String a = i.a(c.Fn(), "recbiz_", str, ".rec", 2);
        if (bh.ov(a)) {
            return null;
        }
        return (z || !new File(a).exists()) ? a : a;
    }

    public static boolean nY(String str) {
        if (str == null) {
            return false;
        }
        g Mk = Mk(str);
        if (Mk == null) {
            x.d("MicroMsg.VoiceRemindLogic", "cancel null record : " + str);
            return true;
        }
        x.d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + Mk.field_msglocalid);
        if (Mk.field_msglocalid != 0) {
            ar.Hg();
            c.Fa().dI((long) Mk.field_msglocalid);
        }
        if (str == null) {
            return false;
        }
        d.bEb().iF(str);
        nU(str);
        return new File(aJ(str, false)).delete();
    }

    static void nU(String str) {
        d.bEb().nU(aJ(str, false));
    }

    public static g Mk(String str) {
        k bEb = d.bEb();
        g gVar = null;
        String str2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
        Cursor a = bEb.gJP.a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            gVar = new g();
            gVar.b(a);
        }
        a.close();
        return gVar;
    }

    public static boolean ny(String str) {
        boolean z = false;
        if (str != null) {
            g Mk = Mk(str);
            if (Mk == null) {
                x.e("MicroMsg.VoiceRemindLogic", "Set error failed file:" + str);
            } else {
                Mk.field_status = 98;
                Mk.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Mk.fDt = 320;
                z = a(Mk);
                x.d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + Mk.field_msglocalid + " old stat:" + Mk.field_status);
                if (Mk.field_msglocalid == 0 || bh.ov(Mk.field_user)) {
                    x.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + Mk.field_msglocalid + " user:" + Mk.field_user);
                } else {
                    ar.Hg();
                    cf dH = c.Fa().dH((long) Mk.field_msglocalid);
                    dH.ao((long) Mk.field_msglocalid);
                    dH.eQ(5);
                    dH.dS(Mk.field_user);
                    dH.setContent(f.b(Mk.field_human, -1, true));
                    ar.Hg();
                    c.Fa().a(dH.field_msgId, dH);
                }
            }
        }
        return z;
    }

    static boolean a(g gVar) {
        if (gVar == null || gVar.fDt == -1) {
            return false;
        }
        k bEb = d.bEb();
        Assert.assertTrue(gVar.field_filename.length() > 0);
        Assert.assertTrue(gVar != null);
        ContentValues vI = gVar.vI();
        if (vI.size() <= 0) {
            x.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
            return false;
        }
        if (bEb.gJP.update("VoiceRemindInfo", vI, "filename= ?", new String[]{r4}) <= 0) {
            return false;
        }
        bEb.doNotify();
        return true;
    }

    public static c Ml(String str) {
        k bEb = d.bEb();
        String aJ = aJ(str, false);
        if (bEb.rWI.get(aJ) == null) {
            bEb.rWI.put(aJ, new c(aJ));
        }
        return (c) bEb.rWI.get(aJ);
    }
}
