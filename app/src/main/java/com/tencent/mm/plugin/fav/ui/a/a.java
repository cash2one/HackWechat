package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.a.e;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.d$b;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.s;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class a extends b {
    private static final af handler = new af(Looper.getMainLooper());
    private static final String moN = ac.getContext().getString(e.ekF);
    private static final Pattern moO = Pattern.compile("['\r\n' | '\n']+");
    public j iVU;
    public String jiK;
    public CharSequence moP;
    public CharSequence moQ;
    public CharSequence moR;
    public String moS;
    public int moT;
    private b moU = new b(this);
    a moV = new a(this);

    public static void a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        if (com.tencent.mm.plugin.fts.d.e.a(charSequence, textView)) {
            if (com.tencent.mm.plugin.fts.d.e.a(charSequence2, textView2)) {
                textView.setMaxLines(1);
                textView2.setMaxLines(1);
                return;
            }
            textView.setMaxLines(2);
        } else if (com.tencent.mm.plugin.fts.d.e.a(charSequence2, textView2)) {
            textView2.setMaxLines(2);
        }
    }

    public a(int i) {
        super(7, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        ux uxVar;
        String a;
        int i;
        long j = this.iVU.mMf;
        com.tencent.mm.sdk.b.b fvVar = new fv();
        fvVar.fvq.type = 9;
        fvVar.fvq.fqk = j;
        com.tencent.mm.sdk.b.a.xef.m(fvVar);
        uv uvVar = fvVar.fvr.fvD;
        j = this.iVU.mMf;
        fvVar = new fv();
        fvVar.fvq.type = 11;
        fvVar.fvq.fqk = j;
        fvVar.fvq.handler = handler;
        com.tencent.mm.sdk.b.a.xef.m(fvVar);
        this.moS = bh.az(fvVar.fvr.fvC, "");
        this.jiK = bh.az(fvVar.fvr.thumbUrl, "");
        j jVar = this.iVU;
        float f = (float) (com.tencent.mm.plugin.fts.d.f.a.mON * 2);
        ve veVar = uvVar.fEH;
        CharSequence charSequence = "";
        switch (uvVar.type) {
            case 1:
                charSequence = moO.matcher(uvVar.desc).replaceAll(" ");
                break;
            case 2:
                charSequence = context.getResources().getString(e.moD);
                break;
            case 3:
                charSequence = context.getResources().getString(e.moI);
                break;
            case 4:
                charSequence = context.getResources().getString(e.moH);
                break;
            case 6:
                uxVar = uvVar.fEH.wdZ;
                if (!moN.equals(uxVar.fDu) && !bh.ov(uxVar.fDu)) {
                    charSequence = uxVar.fDu;
                    break;
                } else {
                    charSequence = uxVar.label;
                    break;
                }
            case 7:
                charSequence = uvVar.title;
                if (!bh.ov(uvVar.desc)) {
                    charSequence = charSequence + "-" + uvVar.desc;
                    break;
                }
                break;
            case 10:
            case 11:
                if (veVar.wed != null) {
                    charSequence = veVar.wed.title;
                    break;
                }
                break;
            case 14:
                StringBuffer stringBuffer = new StringBuffer();
                Iterator it = veVar.weU.iterator();
                while (it.hasNext()) {
                    a = com.tencent.mm.plugin.fav.a.b.a((uq) it.next());
                    if (!bh.ov(a)) {
                        stringBuffer.append(a);
                        stringBuffer.append(" ");
                    }
                }
                charSequence = moO.matcher(stringBuffer.toString()).replaceAll(" ");
                if (bh.ov(charSequence)) {
                    charSequence = context.getResources().getString(e.moF);
                    break;
                }
                break;
            case 16:
                charSequence = context.getResources().getString(e.moG);
                break;
            default:
                charSequence = uvVar.title;
                break;
        }
        switch (jVar.mLr) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                charSequence = f.a(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, this.mMb, f, d$b.mOJ)).mQk;
                break;
        }
        this.moP = charSequence;
        j jVar2 = this.iVU;
        veVar = uvVar.fEH;
        charSequence = "";
        int i2 = -1;
        switch (uvVar.type) {
            case 2:
                charSequence = uvVar.title;
                break;
            case 5:
            case 7:
            case 12:
            case 15:
                if (!bh.ov(uvVar.appId)) {
                    charSequence = com.tencent.mm.z.ab.a.hfJ.l(context, uvVar.appId);
                    break;
                }
                break;
            case 6:
                uxVar = uvVar.fEH.wdZ;
                if (!moN.equals(uxVar.fDu) && !bh.ov(uxVar.fDu)) {
                    charSequence = uxVar.fDu;
                    break;
                } else {
                    charSequence = uxVar.label;
                    break;
                }
                break;
            case 10:
            case 11:
                if (veVar.wed != null) {
                    charSequence = veVar.wed.desc;
                    break;
                }
                break;
            case 14:
                charSequence = "";
                break;
            default:
                charSequence = "";
                break;
        }
        CharSequence charSequence2;
        CharSequence charSequence3;
        switch (jVar2.mLr) {
            case 6:
                charSequence2 = charSequence;
                charSequence = f.a(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, this.mMb)).mQk;
                charSequence3 = charSequence2;
                break;
            case 7:
            case 8:
                i = e.moE;
                CharSequence aH = aH(uvVar.weF);
                int i3 = i;
                charSequence = f.a(com.tencent.mm.plugin.fts.d.b.a.a(aH, this.mMb)).mQk;
                charSequence3 = aH;
                i2 = i3;
                break;
            case 23:
                i2 = e.moC;
                charSequence2 = charSequence;
                charSequence = f.a(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, this.mMb)).mQk;
                charSequence3 = charSequence2;
                break;
            default:
                charSequence2 = charSequence;
                charSequence = "";
                String str = charSequence2;
                break;
        }
        if (!(i2 == -1 || bh.ov(r2))) {
            charSequence = TextUtils.concat(new CharSequence[]{context.getResources().getString(i2), charSequence});
        }
        this.moQ = charSequence;
        j jVar3 = this.iVU;
        a = uvVar.fzO;
        String str2 = uvVar.weE;
        if (bh.ov(a)) {
            str = str2;
            str2 = null;
        } else {
            str = a;
        }
        if (!bh.ov(str)) {
            com.tencent.mm.g.b.af WO = ((h) g.h(h.class)).EY().WO(str);
            WO.setUsername(str);
            x xVar = null;
            if (s.eV(str) && !bh.ov(str2)) {
                xVar = ((h) g.h(h.class)).EY().WO(str2);
                xVar.setUsername(str2);
            }
            Object obj = null;
            boolean z = false;
            boolean z2 = false;
            switch (jVar3.mLr) {
                case 9:
                case 16:
                    z2 = false;
                    z = false;
                    break;
                case 10:
                case 17:
                    break;
                case 11:
                case 18:
                    z = true;
                    break;
                case 12:
                    z2 = false;
                    z = false;
                    break;
                case 13:
                    break;
                case 14:
                    z = true;
                    break;
                case 20:
                    boolean z3 = false;
                    break;
                case 21:
                    break;
                case 22:
                    z = true;
                    break;
                default:
                    z2 = false;
                    z = false;
                    break;
            }
        }
        charSequence = new SpannableString("");
        this.moR = charSequence;
        switch (uvVar.type) {
            case 3:
                i = d.dvC;
                break;
            case 4:
                i = d.dvA;
                break;
            case 5:
                i = d.dvD;
                break;
            case 6:
                i = d.dvm;
                break;
            case 8:
                if (uvVar.fEH.weU != null && uvVar.fEH.weU.size() > 0) {
                    i = c.Rd(((uq) uvVar.fEH.weU.get(0)).wcY);
                    break;
                }
            default:
                i = d.dyF;
                break;
        }
        this.moT = i;
    }

    public final b.b adp() {
        return this.moU;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adq() {
        return this.moV;
    }

    private static String a(x xVar, boolean z) {
        String str;
        if (!z || bh.ov(xVar.field_conRemark)) {
            str = xVar.field_nickname;
        } else {
            str = xVar.field_conRemark;
        }
        if (bh.ov(str)) {
            return xVar.field_username;
        }
        return str;
    }

    private static String c(Context context, x xVar) {
        String str = xVar.field_conRemark;
        if (bh.ov(str)) {
            str = xVar.field_nickname;
        }
        if (bh.ov(str)) {
            return context.getString(e.moA);
        }
        return str;
    }

    private String aH(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (CharSequence charSequence : this.mMb.mLC) {
            for (String str : list) {
                if (com.tencent.mm.plugin.fts.a.d.Bd(str).contains(charSequence)) {
                    stringBuffer.append(str);
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.trimToSize();
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    public final int ads() {
        return this.iVU.mMo;
    }
}
