package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.selectcontact.a$d;
import com.tencent.mm.plugin.selectcontact.a$f;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Pattern;

public class d extends a {
    private static final Pattern iik = Pattern.compile(",");
    public j iVU;
    public CharSequence iil;
    public CharSequence iim;
    public String username;
    private b yVj = new b(this);
    private a yVk = new a(this);

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ d yVm;

        public b(d dVar) {
            this.yVm = dVar;
            super(dVar);
        }

        public View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (a.ey(context)) {
                inflate = LayoutInflater.from(context).inflate(a$f.qfz, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(a$f.qfy, viewGroup, false);
            }
            a aVar = (a) this.yVm.WR();
            aVar.iip = (ImageView) inflate.findViewById(e.bLL);
            aVar.iiq = (TextView) inflate.findViewById(e.cSu);
            aVar.iir = (TextView) inflate.findViewById(e.caS);
            aVar.contentView = inflate.findViewById(e.cKR);
            aVar.iis = (CheckBox) inflate.findViewById(e.cKI);
            aVar.yVl = (CheckBox) inflate.findViewById(e.qft);
            inflate.setTag(aVar);
            return inflate;
        }

        public void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            d dVar = (d) aVar2;
            if (dVar.username == null || dVar.username.length() <= 0) {
                aVar3.iip.setImageResource(a$d.bBB);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.iip, dVar.username);
            }
            com.tencent.mm.plugin.fts.d.e.a(dVar.iil, aVar3.iiq);
            com.tencent.mm.plugin.fts.d.e.a(dVar.iim, aVar3.iir);
            if (this.yVm.ySW) {
                aVar3.iis.setBackgroundResource(a$d.qfl);
                if (z) {
                    aVar3.iis.setChecked(true);
                    aVar3.iis.setEnabled(false);
                } else {
                    aVar3.iis.setChecked(z2);
                    aVar3.iis.setEnabled(true);
                }
                aVar3.iis.setVisibility(0);
            } else if (this.yVm.yVb) {
                aVar3.iis.setBackgroundResource(a$d.bFs);
                if (z) {
                    aVar3.iis.setChecked(true);
                    aVar3.iis.setEnabled(false);
                } else {
                    aVar3.iis.setChecked(z2);
                    aVar3.iis.setEnabled(true);
                }
                aVar3.iis.setVisibility(0);
            } else if (this.yVm.ySX) {
                aVar3.iis.setVisibility(8);
                aVar3.yVl.setChecked(z2);
                aVar3.yVl.setEnabled(true);
                aVar3.yVl.setVisibility(0);
            } else {
                aVar3.iis.setVisibility(8);
            }
            if (this.yVm.kFO) {
                aVar3.contentView.setBackgroundResource(a$d.bBy);
            } else {
                aVar3.contentView.setBackgroundResource(a$d.bBx);
            }
            if (dVar.jLe.field_deleteFlag == 1) {
                aVar3.iir.setVisibility(0);
                aVar3.iir.setText(context.getString(h.qfI));
            }
        }

        public final boolean WS() {
            if (this.yVm.iVU != null) {
                ((m) g.k(m.class)).updateTopHitsRank(this.yVm.fDj, this.yVm.iVU, 1);
            }
            return false;
        }
    }

    public d(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bH(Context context) {
        int i;
        if (this.iVU != null) {
            if (this.jLe == null) {
                g.Dk();
                this.jLe = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WJ(this.iVU.mLs);
                if (this.jLe == null) {
                    g.Dk();
                    this.jLe = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WN(this.iVU.mLs);
                    i = 1;
                }
            }
            i = 1;
        } else {
            i = 0;
        }
        if (this.jLe == null) {
            x.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[]{Integer.valueOf(this.position)});
            return;
        }
        this.username = this.jLe.field_username;
        if (i != 0) {
            boolean z;
            boolean z2;
            int i2;
            String string;
            int i3;
            CharSequence charSequence;
            CharSequence charSequence2;
            j jVar = this.iVU;
            af afVar = this.jLe;
            Resources resources = context.getResources();
            if (afVar != null) {
                String a = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).a(afVar, afVar.field_username);
                String str;
                Object obj;
                Object obj2;
                switch (jVar.mLr) {
                    case 1:
                        z = false;
                        z2 = false;
                        break;
                    case 2:
                        z = false;
                        break;
                    case 3:
                        z = true;
                        break;
                    case 4:
                        str = afVar.fWy;
                        z2 = false;
                        i2 = 0;
                        string = resources.getString(h.eIG);
                        obj = a;
                        obj2 = str;
                        i3 = 1;
                        z = false;
                        break;
                    case 5:
                        z = false;
                        z2 = false;
                        break;
                    case 6:
                        z = false;
                        break;
                    case 7:
                        z = true;
                        break;
                    case 11:
                        str = jVar.mMj;
                        z2 = false;
                        i2 = 0;
                        string = resources.getString(h.eIL);
                        obj = a;
                        obj2 = str;
                        i3 = 1;
                        z = false;
                        break;
                    case 15:
                        str = afVar.vN();
                        if (bh.ov(str)) {
                            str = afVar.field_username;
                        }
                        z2 = false;
                        i2 = 0;
                        string = resources.getString(h.eIM);
                        obj = a;
                        obj2 = str;
                        i3 = 1;
                        z = false;
                        break;
                    case 16:
                        String str2 = jVar.content;
                        if (!bh.ov(str2)) {
                            for (String str3 : str2.split("​")) {
                                if (str3.startsWith(this.fDj)) {
                                    z2 = false;
                                    i2 = 0;
                                    string = resources.getString(h.eII);
                                    obj = a;
                                    obj2 = str3;
                                    i3 = 1;
                                    z = false;
                                    break;
                                }
                            }
                        }
                        str3 = str2;
                        z2 = false;
                        i2 = 0;
                        string = resources.getString(h.eII);
                        obj = a;
                        obj2 = str3;
                        i3 = 1;
                        z = false;
                    case 17:
                    case 18:
                        str3 = jVar.content;
                        z2 = false;
                        i2 = 0;
                        string = resources.getString(h.qfH);
                        obj = a;
                        obj2 = str3;
                        i3 = 1;
                        z = false;
                        break;
                    default:
                        z = false;
                        z2 = false;
                        i2 = 0;
                        string = null;
                        charSequence = a;
                        charSequence2 = null;
                        i3 = 0;
                        break;
                }
            }
            z = false;
            z2 = false;
            i2 = 0;
            charSequence2 = null;
            string = null;
            charSequence = null;
            i3 = 0;
            if (i2 != 0) {
                x.d("MicroMsg.ContactDataItem", "highlight first line");
                this.iil = i.c(context, charSequence, a.aa(context, c.bvK));
                this.iil = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.iil, this.mMb, z2, z)).mQk;
            } else {
                this.iil = i.c(context, charSequence, a.aa(context, c.bvK));
            }
            if (i3 != 0) {
                x.d("MicroMsg.ContactDataItem", "highlight second line");
                this.iim = i.c(context, charSequence2, a.aa(context, c.bvs));
                this.iim = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.iim, this.mMb, z2, z)).mQk;
            } else {
                this.iim = i.c(context, charSequence2, a.aa(context, c.bvs));
            }
            if (!bh.ov(string) && this.iim != null) {
                this.iim = TextUtils.concat(new CharSequence[]{string, this.iim});
                return;
            }
            return;
        }
        CharSequence c;
        if (bh.ov(this.fpF)) {
            c = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).c(this.jLe);
        } else {
            c = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).L(this.jLe.field_username, this.fpF);
        }
        this.iil = i.c(context, c, a.aa(context, c.bvK));
    }

    public com.tencent.mm.ui.contact.a.a.b WQ() {
        return this.yVj;
    }

    public a.a WR() {
        return this.yVk;
    }
}
