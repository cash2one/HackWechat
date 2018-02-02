package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class a implements e {
    private String chatroomName = "";
    private Context context;
    public String mOi = "";
    private LinkedList<String> pwD;
    private LinkedList<Integer> pwE;
    private r tipDialog;
    private a vmN;
    public b vmO;
    private LinkedList<String> vmP;
    public String vmQ;
    String vmR = "";
    public String vmS;
    public String vmT;
    public boolean vmU = true;
    public boolean vmV = true;
    public String vmW = "";
    public boolean vmX = false;

    public a(Context context, a aVar) {
        this.context = context;
        this.vmN = aVar;
        this.pwD = new LinkedList();
        this.vmP = new LinkedList();
        this.tipDialog = null;
    }

    public final void b(String str, String str2, LinkedList<Integer> linkedList) {
        this.chatroomName = str2;
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void c(String str, LinkedList<Integer> linkedList) {
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void a(String str, LinkedList<Integer> linkedList, String str2) {
        a(str, (LinkedList) linkedList, false, str2);
    }

    public final void Sk(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.vmP.add(str);
        }
    }

    public final void b(String str, LinkedList<Integer> linkedList, boolean z) {
        a(str, (LinkedList) linkedList, z, "");
    }

    private void a(String str, LinkedList<Integer> linkedList, boolean z, String str2) {
        boolean z2 = str != null && str.length() > 0;
        Assert.assertTrue(z2);
        if (linkedList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.vmU = z;
        g.Di().gPJ.a(30, this);
        if (this.vmV) {
            Context context = this.context;
            this.context.getString(h.dGO);
            this.tipDialog = com.tencent.mm.ui.base.h.a(context, this.context.getString(h.lov), true, new 1(this));
        }
        this.pwE = linkedList;
        this.pwD.add(str);
        this.vmR = str;
        k oVar = new o(1, this.pwD, linkedList, this.vmP, "", this.mOi, null, this.chatroomName, str2);
        if (!bh.ov(this.vmS)) {
            oVar.fc(this.vmS, this.vmT);
        }
        g.Di().gPJ.a(oVar, 0);
    }

    private void c(boolean z, boolean z2, String str, String str2) {
        if (this.vmN != null) {
            this.vmN.a(z, z2, str, str2);
        }
        if (z) {
            b jmVar = new jm();
            jmVar.fAe.username = str;
            com.tencent.mm.sdk.b.a.xef.m(jmVar);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.AddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2 + "," + str);
        if (kVar.getType() != 30) {
            x.w("MicroMsg.AddContact", "not expected scene,  type = " + kVar.getType());
            return;
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        g.Di().gPJ.b(30, this);
        if (i == 0 && i2 == 0) {
            this.vmR = ((o) kVar).bYs();
            c(true, false, this.vmR, this.vmW);
        } else if (i2 == -44) {
            String str2 = this.vmW;
            if (this.vmO != null) {
                this.vmO.aUF();
                c(false, false, this.vmR, str2);
                return;
            }
            q qVar = new q(this.context, new 4(this));
            if (this.vmQ != null) {
                qVar.vmQ = this.vmQ;
            }
            if (this.vmU) {
                List list = this.pwD;
                List list2 = this.pwE;
                qVar.vov = false;
                qVar.onStart();
                g.Di().gPJ.a(new o(2, list, list2, "", ""), 0);
                return;
            }
            qVar.g(this.pwD, this.pwE);
        } else if (i2 == -87) {
            com.tencent.mm.ui.base.h.b(this.context, this.context.getString(h.dUz), "", true);
        } else if (i2 == XWalkUpdater.ERROR_SET_VERNUM && !bh.ov(str)) {
            x.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[]{Integer.valueOf(i2), str});
            com.tencent.mm.ui.base.h.a(this.context, str, "", false, new 2(this));
        } else if (i2 == -302) {
            x.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", new Object[]{Integer.valueOf(((o) kVar).fuL)});
            if (((o) kVar).fuL == 3) {
                com.tencent.mm.ui.base.h.a(this.context, this.context.getString(h.dXf), this.context.getString(h.dGO), this.context.getString(h.dDK), this.context.getString(h.dEn), new 3(this, kVar), null);
            }
        } else if (i2 != -2) {
            r(i, i2, str);
        } else if (bh.ov(str)) {
            r(i, i2, null);
        } else {
            com.tencent.mm.ui.base.h.a(this.context, str, this.context.getString(h.dGO), this.context.getString(h.dFU), null);
        }
    }

    private void r(int i, int i2, String str) {
        if (this.vmX && !bh.ov(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else if (i == 4 && i2 == -22) {
            Toast.makeText(this.context, this.context.getString(h.lor), 1).show();
        } else if (i == 4 && i2 == -24 && !bh.ov(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(h.loq), 1).show();
        }
        c(false, false, this.vmR, this.vmW);
    }
}
