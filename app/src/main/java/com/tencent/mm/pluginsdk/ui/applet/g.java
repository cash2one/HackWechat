package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashMap;

public final class g {
    private Context context;
    f ilB;
    private View oim;
    private View oml;
    public OnClickListener pGO;
    a rUx;
    String username;
    private OnClickListener vnA;
    private OnClickListener vnB;
    private i$b vnC;
    private i$a vnD;
    private h.a vnE;
    String vnt;
    private HashMap<String, Preference> vnu = new HashMap();
    boolean vnv = false;
    boolean vnw;
    public h vnx;
    i$b vny;
    private OnClickListener vnz;

    public g(Context context) {
        boolean z = false;
        if (this.vnv) {
            z = true;
        }
        this.vnw = z;
        this.vny = null;
        this.pGO = null;
        this.rUx = null;
        this.vnB = new 1(this);
        this.vnC = new 2(this);
        this.vnD = new 3(this);
        this.vnE = new 4(this);
        this.context = context;
        this.vnx = new h(this.context);
        this.vnx.vnI = this.vnE;
    }

    final void DP(String str) {
        h hVar = this.vnx;
        hVar.username = str;
        hVar.fzz = s.eV(str);
        if (!(hVar.fzz || n.a.vos == null)) {
            hVar.vnK = n.a.vos.Sm(str);
        }
        if (!hVar.vnK) {
            hVar.kZS = ((b) com.tencent.mm.kernel.g.h(b.class)).Fh().hD(str);
        }
        if (hVar.vnK && n.a.vos != null) {
            hVar.lcT = n.a.vos.So(hVar.username);
        }
        this.vnx.vnX = this.vnw;
        this.vnx.notifyChanged();
        blx();
    }

    private static String BX(int i) {
        if (i >= 0) {
            return "pref_contact_list_row_" + i;
        }
        String str = "unkown";
        if (i == -1) {
            str = "header";
        } else if (i == -2) {
            str = "footer";
        }
        return "pref_contact_list_row_" + str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void blx() {
        if (this.ilB != null && this.vnt != null) {
            String str;
            Object obj;
            Preference contactListCustomPreference;
            i$b com_tencent_mm_pluginsdk_ui_applet_i_b;
            OnClickListener onClickListener;
            boolean caV;
            boolean z;
            boolean z2;
            int i;
            int i2;
            int i3;
            h hVar;
            Context context;
            Display defaultDisplay;
            int width;
            int i4;
            Preference contactListExpandPreference;
            i iVar;
            for (String str2 : this.vnu.keySet()) {
                this.ilB.YO(str2);
            }
            this.vnu.clear();
            int indexOf = this.ilB.indexOf(this.vnt);
            Object obj2 = null;
            if (this.oim != null) {
                obj2 = 1;
            }
            if (this.oml != null) {
                if (this.vnv) {
                    h hVar2 = this.vnx;
                }
                obj = 1;
                if (obj2 != null) {
                    contactListCustomPreference = new ContactListCustomPreference(this.context);
                    contactListCustomPreference.setKey(BX(-1));
                    contactListCustomPreference.setCustomView(this.oim);
                    contactListCustomPreference.background = d.bBx;
                    contactListCustomPreference.pGO = this.vnz;
                    this.ilB.a(contactListCustomPreference, indexOf);
                    this.vnu.put(contactListCustomPreference.ibD, contactListCustomPreference);
                    indexOf++;
                }
                com_tencent_mm_pluginsdk_ui_applet_i_b = this.vny == null ? this.vny : this.vnC;
                onClickListener = this.pGO == null ? this.pGO : this.vnB;
                str2 = this.vnx.vnZ;
                caV = this.vnx.caV();
                z = bh.ov(str2) && (str2 == null || str2.equals(q.FS()));
                z2 = this.vnx.vnK ? this.vnx.vnL : z;
                i = this.vnx.vnR;
                i2 = (caV || z2) ? 2 : 1;
                i3 = i + i2;
                i = 0;
                hVar = this.vnx;
                context = this.context;
                if (context != null) {
                    i2 = 0;
                } else {
                    defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    width = defaultDisplay.getWidth();
                    i2 = defaultDisplay.getHeight();
                    if (((float) width) / (context.getResources().getDimension(c.bvF) + (context.getResources().getDimension(c.bvB) * 2.0f)) >= 5.0f || i2 <= width) {
                        hVar.vof = false;
                    } else {
                        hVar.vof = true;
                    }
                    i2 = width / ((int) ((hVar.vof ? context.getResources().getDimension(c.bvF) : context.getResources().getDimension(c.bvD)) + (2.0f * context.getResources().getDimension(c.bvB))));
                    x.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", Integer.valueOf(i2));
                    h.vnH = i2;
                    if (i2 == 4) {
                        h.vnG = 43;
                    }
                }
                i4 = 0;
                while (i4 < this.vnx.getCount() && i4 < i3) {
                    contactListExpandPreference = new ContactListExpandPreference(this.context, 1);
                    contactListExpandPreference.setKey(BX(i));
                    iVar = contactListExpandPreference.vom;
                    iVar.vnx = this.vnx;
                    iVar.row = i;
                    iVar.index = i4;
                    contactListExpandPreference.vom.von = i2;
                    contactListExpandPreference.vom.kZP = z2;
                    contactListExpandPreference.vom.pGO = onClickListener;
                    contactListExpandPreference.vom.vnD = this.vnD;
                    contactListExpandPreference.vom.voo = com_tencent_mm_pluginsdk_ui_applet_i_b;
                    this.ilB.a(contactListExpandPreference, indexOf + i);
                    this.vnu.put(contactListExpandPreference.ibD, contactListExpandPreference);
                    i4 += i2;
                    i++;
                }
                if (obj != null) {
                    contactListCustomPreference = new ContactListCustomPreference(this.context);
                    contactListCustomPreference.setKey(BX(-2));
                    contactListCustomPreference.setCustomView(this.oml);
                    contactListCustomPreference.pGO = this.vnA;
                    this.ilB.a(contactListCustomPreference, indexOf + i);
                    this.vnu.put(contactListCustomPreference.ibD, contactListCustomPreference);
                }
            }
            obj = null;
            if (obj2 != null) {
                contactListCustomPreference = new ContactListCustomPreference(this.context);
                contactListCustomPreference.setKey(BX(-1));
                contactListCustomPreference.setCustomView(this.oim);
                contactListCustomPreference.background = d.bBx;
                contactListCustomPreference.pGO = this.vnz;
                this.ilB.a(contactListCustomPreference, indexOf);
                this.vnu.put(contactListCustomPreference.ibD, contactListCustomPreference);
                indexOf++;
            }
            if (this.vny == null) {
            }
            if (this.pGO == null) {
            }
            str2 = this.vnx.vnZ;
            caV = this.vnx.caV();
            if (bh.ov(str2)) {
            }
            if (this.vnx.vnK) {
            }
            i = this.vnx.vnR;
            if (caV) {
            }
            i3 = i + i2;
            i = 0;
            hVar = this.vnx;
            context = this.context;
            if (context != null) {
                defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                width = defaultDisplay.getWidth();
                i2 = defaultDisplay.getHeight();
                if (((float) width) / (context.getResources().getDimension(c.bvF) + (context.getResources().getDimension(c.bvB) * 2.0f)) >= 5.0f) {
                }
                hVar.vof = false;
                if (hVar.vof) {
                }
                i2 = width / ((int) ((hVar.vof ? context.getResources().getDimension(c.bvF) : context.getResources().getDimension(c.bvD)) + (2.0f * context.getResources().getDimension(c.bvB))));
                x.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", Integer.valueOf(i2));
                h.vnH = i2;
                if (i2 == 4) {
                    h.vnG = 43;
                }
            } else {
                i2 = 0;
            }
            i4 = 0;
            while (i4 < this.vnx.getCount()) {
                contactListExpandPreference = new ContactListExpandPreference(this.context, 1);
                contactListExpandPreference.setKey(BX(i));
                iVar = contactListExpandPreference.vom;
                iVar.vnx = this.vnx;
                iVar.row = i;
                iVar.index = i4;
                contactListExpandPreference.vom.von = i2;
                contactListExpandPreference.vom.kZP = z2;
                contactListExpandPreference.vom.pGO = onClickListener;
                contactListExpandPreference.vom.vnD = this.vnD;
                contactListExpandPreference.vom.voo = com_tencent_mm_pluginsdk_ui_applet_i_b;
                this.ilB.a(contactListExpandPreference, indexOf + i);
                this.vnu.put(contactListExpandPreference.ibD, contactListExpandPreference);
                i4 += i2;
                i++;
            }
            if (obj != null) {
                contactListCustomPreference = new ContactListCustomPreference(this.context);
                contactListCustomPreference.setKey(BX(-2));
                contactListCustomPreference.setCustomView(this.oml);
                contactListCustomPreference.pGO = this.vnA;
                this.ilB.a(contactListCustomPreference, indexOf + i);
                this.vnu.put(contactListCustomPreference.ibD, contactListCustomPreference);
            }
        }
    }
}
