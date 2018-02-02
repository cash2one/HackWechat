package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import java.util.List;

public final class p extends b {
    private a qeQ = new a(this);

    public p(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, a aVar, Object... objArr) {
        this.username = this.iVU.mLs;
        ar.Hg();
        this.jLe = c.EY().WO(this.username);
        CharSequence gu = r.gu(this.username);
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        Object obj;
        Object string;
        boolean z4;
        int i2;
        String substring;
        CharSequence charSequence;
        switch (this.iVU.mLr) {
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
                z3 = false;
                i = 1;
                obj = this.jLe.fWy;
                string = context.getString(R.l.eIG);
                z4 = false;
                i2 = 0;
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
                List<String> AZ = ((m) g.k(m.class)).getFTSMainDB().AZ(this.jLe.field_contactLabelIds);
                StringBuffer stringBuffer = new StringBuffer();
                for (CharSequence charSequence2 : this.mMb.mLC) {
                    for (String substring2 : AZ) {
                        if (d.Bd(substring2).contains(charSequence2)) {
                            stringBuffer.append(substring2);
                            stringBuffer.append(",");
                        }
                    }
                }
                stringBuffer.trimToSize();
                substring2 = stringBuffer.length() == 0 ? "" : stringBuffer.substring(0, stringBuffer.length() - 1);
                z3 = false;
                i = 1;
                obj = substring2;
                string = context.getString(R.l.eIL);
                z4 = false;
                i2 = 0;
                break;
            case 15:
                substring2 = this.jLe.vN();
                if (bh.ov(substring2)) {
                    substring2 = this.jLe.field_username;
                }
                z3 = false;
                i = 1;
                obj = substring2;
                string = context.getString(R.l.eIM);
                z4 = false;
                i2 = 0;
                break;
            case 16:
                String str = this.iVU.content;
                if (!bh.ov(str)) {
                    for (String substring22 : str.split("​")) {
                        if (substring22.startsWith(this.mMb.mLA)) {
                            z3 = false;
                            i = 1;
                            obj = substring22;
                            string = context.getString(R.l.eII);
                            z4 = false;
                            i2 = 0;
                            break;
                        }
                    }
                }
                substring22 = str;
                z3 = false;
                i = 1;
                obj = substring22;
                string = context.getString(R.l.eII);
                z4 = false;
                i2 = 0;
            case 17:
                z3 = false;
                i = 1;
                obj = this.iVU.content;
                string = context.getString(R.l.eIF);
                z4 = false;
                i2 = 0;
                break;
            case 18:
                z3 = false;
                i = 1;
                obj = this.iVU.content;
                string = context.getString(R.l.eIK);
                z4 = false;
                i2 = 0;
                break;
            default:
                z3 = false;
                i = 0;
                i2 = 0;
                charSequence2 = null;
                CharSequence charSequence3 = null;
                z4 = false;
                break;
        }
    }

    public final b adp() {
        return this.qeQ;
    }
}
