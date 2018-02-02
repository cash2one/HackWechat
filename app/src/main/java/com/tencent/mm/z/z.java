package com.tencent.mm.z;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.x;

public final class z {
    private c hfI;

    public z(c cVar) {
        this.hfI = cVar;
    }

    static int a(boolean z, String str, boolean z2) {
        int i = 3;
        a WO = c.EY().WO(str);
        if (WO == null) {
            WO = new x();
        }
        if (((int) WO.gJd) == 0) {
            WO.setUsername(str);
            WO.Ag();
            x(WO);
            if (z2) {
                i = 4;
            }
            WO.eC(i);
            WO.Ap();
            c.EY().R(WO);
            return 1;
        } else if (!z) {
            return 3;
        } else {
            WO.Ap();
            c.EY().a(str, WO);
            return 2;
        }
    }

    public static void w(x xVar) {
        if (xVar == null) {
            xVar = new x();
        }
        if (((int) xVar.gJd) == 0) {
            xVar.setUsername("filehelper");
            ar.Hg();
            if (c.Fd().WY(xVar.field_username) == null) {
                xVar.Ah();
            } else {
                xVar.Ag();
            }
            xVar.eC(3);
            ar.Hg();
            c.EY().Q(xVar);
        }
    }

    static void x(x xVar) {
        String str = xVar.field_username;
        Context context = ac.getContext();
        if (str.equals("qqsync")) {
            xVar.dc(context.getString(R.l.eoF));
            xVar.dd(context.getString(R.l.eoG));
            xVar.de(context.getString(R.l.eoH));
        }
        if (str.equals("floatbottle")) {
            xVar.dc(context.getString(R.l.enN));
            xVar.dd(context.getString(R.l.enO));
            xVar.de(context.getString(R.l.enP));
        }
        if (str.equals("shakeapp")) {
            xVar.dc(context.getString(R.l.eoM));
            xVar.dd(context.getString(R.l.eoN));
            xVar.de(context.getString(R.l.eoO));
        }
        if (str.equals("lbsapp")) {
            xVar.dc(context.getString(R.l.eog));
            xVar.dd(context.getString(R.l.eoh));
            xVar.de(context.getString(R.l.eoi));
        }
        if (str.equals("medianote")) {
            xVar.dc(context.getString(R.l.eop));
            xVar.dd(context.getString(R.l.eoq));
            xVar.de(context.getString(R.l.eor));
        }
        if (str.equals("newsapp")) {
            xVar.dc(context.getString(R.l.eoI));
            xVar.dd(context.getString(R.l.eoJ));
            xVar.de(context.getString(R.l.eoK));
        }
        if (str.equals("facebookapp")) {
            xVar.dc(context.getString(R.l.enT));
            xVar.dd(context.getString(R.l.enU));
            xVar.de(context.getString(R.l.enV));
        }
        if (str.equals("qqfriend")) {
            xVar.dc(context.getString(R.l.eoz));
            xVar.dd(context.getString(R.l.eoA));
            xVar.de(context.getString(R.l.eoB));
        }
        if (str.equals("masssendapp")) {
            xVar.dc(context.getString(R.l.eom));
            xVar.dd(context.getString(R.l.eon));
            xVar.de(context.getString(R.l.eoo));
        }
        if (str.equals("feedsapp")) {
            xVar.dc(context.getString(R.l.enW));
            xVar.dd(context.getString(R.l.enX));
            xVar.de(context.getString(R.l.enY));
        }
        if (str.equals("fmessage")) {
            xVar.dc(context.getString(R.l.enZ));
            xVar.dd(context.getString(R.l.eoa));
            xVar.de(context.getString(R.l.eob));
        }
        if (str.equals("voipapp")) {
            xVar.dc(context.getString(R.l.eoT));
            xVar.dd(context.getString(R.l.eoU));
            xVar.de(context.getString(R.l.eoV));
        }
        if (str.equals("officialaccounts")) {
            xVar.dc(context.getString(R.l.eow));
            xVar.dd(context.getString(R.l.eox));
            xVar.de(context.getString(R.l.eoy));
        }
        if (str.equals("helper_entry")) {
            xVar.dc(context.getString(R.l.eoc));
            xVar.dd(context.getString(R.l.eod));
            xVar.de(context.getString(R.l.eoe));
        }
        if (str.equals("cardpackage")) {
            xVar.dc(context.getString(R.l.enQ));
            xVar.dd(context.getString(R.l.enR));
            xVar.de(context.getString(R.l.enS));
        }
        if (str.equals("voicevoipapp")) {
            xVar.dc(context.getString(R.l.eoW));
            xVar.dd(context.getString(R.l.eoX));
            xVar.de(context.getString(R.l.eoY));
        }
        if (str.equals("voiceinputapp")) {
            xVar.dc(context.getString(R.l.eoQ));
            xVar.dd(context.getString(R.l.eoR));
            xVar.de(context.getString(R.l.eoS));
        }
        if (str.equals("qqmail")) {
            xVar.dc(context.getString(R.l.eoC));
            xVar.dd(context.getString(R.l.eoD));
            xVar.de(context.getString(R.l.eoE));
        }
        if (str.equals("linkedinplugin")) {
            xVar.dc(context.getString(R.l.eoj));
            xVar.dd(context.getString(R.l.eok));
            xVar.de(context.getString(R.l.eol));
        }
        if (str.equals("notifymessage")) {
            xVar.dc(context.getString(R.l.eot));
            xVar.dd(context.getString(R.l.eou));
            xVar.de(context.getString(R.l.eov));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            xVar.dc(context.getString(R.l.enK));
            xVar.dd(context.getString(R.l.enL));
            xVar.de(context.getString(R.l.enM));
        }
    }
}
