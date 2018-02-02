package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
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
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.selectcontact.a$e;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern hKC = Pattern.compile(";");
    public j iVU;
    public CharSequence iil;
    public CharSequence iim;
    public String username;
    public CharSequence yVf;
    private b yVg = new b(this);
    a yVh = new a(this);

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ c yVi;

        public b(c cVar) {
            this.yVi = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (a.ey(context)) {
                inflate = LayoutInflater.from(context).inflate(f.qfz, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(f.qfy, viewGroup, false);
            }
            a aVar = this.yVi.yVh;
            aVar.iip = (ImageView) inflate.findViewById(a$e.bLL);
            aVar.iiq = (TextView) inflate.findViewById(a$e.cSu);
            aVar.iiq.setMaxWidth(a.fromDPToPix(context, 200));
            aVar.iir = (TextView) inflate.findViewById(a$e.caS);
            aVar.mPU = (TextView) inflate.findViewById(a$e.cRV);
            aVar.contentView = inflate.findViewById(a$e.cKR);
            aVar.iis = (CheckBox) inflate.findViewById(a$e.cKI);
            if (this.yVi.kFO) {
                aVar.contentView.setBackgroundResource(d.bBy);
            }
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.iip.setImageResource(d.bBB);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.iip, cVar.username);
            }
            e.a(cVar.iil, aVar3.iiq);
            e.a(cVar.iim, aVar3.iir);
            e.a(cVar.yVf, aVar3.mPU);
            if (this.yVi.ySW) {
                if (z) {
                    aVar3.iis.setChecked(true);
                    aVar3.iis.setEnabled(false);
                } else {
                    aVar3.iis.setChecked(z2);
                    aVar3.iis.setEnabled(true);
                }
                aVar3.iis.setVisibility(0);
                return;
            }
            aVar3.iis.setVisibility(8);
        }

        public final boolean WS() {
            if (this.yVi.iVU != null) {
                ((m) g.k(m.class)).updateTopHitsRank(this.yVi.fDj, this.yVi.iVU, 1);
            }
            return false;
        }
    }

    public c(int i) {
        super(3, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bH(Context context) {
        int i;
        CharSequence charSequence = null;
        int i2 = 1;
        boolean z = false;
        if (this.iVU != null) {
            if (this.jLe == null) {
                g.Dk();
                this.jLe = ((h) g.h(h.class)).EY().WJ(this.iVU.mLs);
                if (this.jLe == null) {
                    g.Dk();
                    this.jLe = ((h) g.h(h.class)).EY().WN(this.iVU.mLs);
                    i = 1;
                }
            }
            i = 1;
        } else {
            boolean z2 = false;
        }
        if (this.jLe == null) {
            x.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[]{Integer.valueOf(this.position)});
            return;
        }
        this.username = this.jLe.field_username;
        if (i != 0) {
            j jVar = this.iVU;
            af afVar = this.jLe;
            Resources resources = context.getResources();
            CharSequence a = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).a(afVar, afVar.field_username);
            switch (jVar.mLr) {
                case 1:
                case 5:
                    z2 = false;
                    break;
                case 2:
                case 6:
                    break;
                case 3:
                case 7:
                    z = true;
                    break;
                case 38:
                    String[] split;
                    g.Dk();
                    Cursor a2 = g.Dj().gQj.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{afVar.field_username}, 2);
                    if (a2.moveToFirst()) {
                        CharSequence string = a2.getString(0);
                        a2.close();
                        split = string == null ? null : hKC.split(string);
                    } else {
                        a2.close();
                        split = null;
                    }
                    if (split != null && split.length > 0) {
                        this.yVf = "(" + split.length + ")";
                    }
                    if (!(split == null || jVar.mMm == null)) {
                        CharSequence a3 = e.a(context, jVar.mMm, split, this.mMb, com.tencent.mm.plugin.fts.d.d.b.mOJ);
                        charSequence = TextUtils.concat(new CharSequence[]{resources.getString(com.tencent.mm.plugin.selectcontact.a.h.eIH), a3});
                        z2 = false;
                        i2 = 0;
                        break;
                    }
                default:
                    z2 = false;
                    i2 = 0;
                    break;
            }
        }
        this.iil = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).a(this.jLe, this.jLe.field_username);
        if (this.iVU != null) {
            this.yVf = "(" + this.iVU.mMf + ")";
        }
    }

    public final com.tencent.mm.ui.contact.a.a.b WQ() {
        return this.yVg;
    }

    protected final a.a WR() {
        return this.yVh;
    }

    public final boolean aNz() {
        return this.iVU.mMp;
    }
}
