package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import org.xwalk.core.R$styleable;

public class k extends b {
    public j iVU;
    public CharSequence iil;
    public CharSequence iim;
    public CharSequence qeA;
    private b qeB = new b(this);
    a qeC = new a(this);
    public int qez;
    public String username;

    public k(int i) {
        super(6, i);
    }

    public void a(Context context, a aVar, Object... objArr) {
        a aVar2 = (a) aVar;
        this.username = this.iVU.mLs;
        this.iil = i.d(context, r.gu(this.username), aVar2.kBH.getTextSize());
        if (this.iVU.userData instanceof Integer) {
            this.qez = ((Integer) this.iVU.userData).intValue();
        }
        if (this.qez < 2) {
            CharSequence charSequence = "";
            String str = "";
            ar.Hg();
            cf dH = c.Fa().dH(this.iVU.mMf);
            g.a fT;
            g.a fT2;
            switch (this.iVU.mLr) {
                case 41:
                    str = dH.field_content;
                    if (s.eV(this.username)) {
                        str = ba.hQ(str);
                        break;
                    }
                    break;
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    fT = g.a.fT(dH.field_content);
                    if (fT != null) {
                        str = fT.title;
                    }
                    charSequence = context.getString(R.l.ekD);
                    break;
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    fT = g.a.fT(dH.field_content);
                    if (fT != null) {
                        str = fT.title;
                    }
                    charSequence = context.getString(R.l.ekE);
                    break;
                case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    fT2 = g.a.fT(dH.field_content);
                    if (fT2 != null) {
                        charSequence = fT2.title + ": ";
                        str = fT2.description;
                        break;
                    }
                    break;
                case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                    fT2 = g.a.fT(dH.field_content);
                    if (fT2 != null) {
                        str = bh.az(fT2.title, "") + ": " + bh.az(fT2.description, "");
                        break;
                    }
                    break;
                case 46:
                case 47:
                    g.a fT3 = g.a.fT(dH.field_content);
                    if (dH.field_isSend != 1) {
                        str = bh.az(fT3.hcE, "") + ": " + bh.az(fT3.hcA, "");
                        break;
                    } else {
                        str = bh.az(fT3.hcE, "") + ": " + bh.az(fT3.hcB, "");
                        break;
                    }
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    fT = g.a.fT(dH.field_content);
                    if (fT != null) {
                        str = fT.title;
                    }
                    charSequence = context.getString(R.l.ekC);
                    break;
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    fT = g.a.fT(dH.field_content);
                    if (fT != null) {
                        str = fT.description;
                    }
                    charSequence = context.getString(R.l.ekG);
                    break;
                case 50:
                    String hQ;
                    str = dH.field_content;
                    if (s.eV(this.username)) {
                        hQ = ba.hQ(str);
                    } else {
                        hQ = str;
                    }
                    au.b EL = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().EL(hQ);
                    if (EL.cjH()) {
                        hQ = EL.nTe;
                    }
                    String str2 = hQ;
                    Object string = context.getString(R.l.ekF);
                    str = str2;
                    break;
            }
            this.iim = i.d(context, bh.az(str, "").replace('\n', ' '), (float) d.b.mOI);
            if (bh.M(charSequence)) {
                this.iim = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.iim, this.mMb, (float) f.a.mON, d.b.mOJ)).mQk;
            } else {
                this.iim = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.iim, this.mMb, ((float) f.a.mON) - d.b.mOJ.measureText(charSequence.toString()), d.b.mOJ)).mQk;
                this.iim = TextUtils.concat(new CharSequence[]{charSequence, this.iim});
            }
            this.qeA = n.c(context, this.iVU.timestamp, true);
            return;
        }
        this.iim = context.getResources().getString(R.l.eIU, new Object[]{Integer.valueOf(this.qez)});
    }

    public b$b adp() {
        return this.qeB;
    }

    protected final a adq() {
        return this.qeC;
    }

    public final int ads() {
        return this.iVU.mMo;
    }

    public int aNA() {
        if (this.qez < 2) {
            return 0;
        }
        return 1;
    }
}
