package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$a;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import java.util.List;

public final class o extends b {
    public j iVU;
    public x jLe;
    public CharSequence kHu;
    public CharSequence kHv;
    public CharSequence qeM;
    private b qeN = new b(this);
    a qeO = new a(this);
    public String username;

    public class a extends b$a {
        public View contentView;
        public ImageView iip;
        public TextView iiq;
        public TextView iir;
        final /* synthetic */ o qeP;

        public a(o oVar) {
            this.qeP = oVar;
            super(oVar);
        }
    }

    public o(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, b$a com_tencent_mm_plugin_fts_d_a_b_a, Object... objArr) {
        this.username = this.iVU.mLs;
        ar.Hg();
        this.jLe = c.EY().WO(this.username);
        Resources resources = context.getResources();
        af afVar = this.jLe;
        CharSequence a = r.a(afVar, afVar.field_username);
        boolean z;
        boolean z2;
        int i;
        CharSequence concat;
        boolean z3;
        switch (this.iVU.mLr) {
            case 1:
            case 5:
                z = false;
                z2 = false;
                break;
            case 2:
            case 6:
                z = false;
                break;
            case 3:
            case 7:
                z = true;
                break;
            case 38:
                CharSequence string;
                String[] split;
                ar.Hg();
                Cursor a2 = c.EV().a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{afVar.field_username}, 2);
                if (a2.moveToFirst()) {
                    string = a2.getString(0);
                    split = string == null ? null : com.tencent.mm.plugin.fts.a.c.a.mKw.split(string);
                } else {
                    split = null;
                }
                a2.close();
                if (split != null && split.length > 0) {
                    this.qeM = "(" + split.length + ")";
                }
                if (!(split == null || this.iVU.mMm == null)) {
                    string = e.a(context, this.iVU.mMm, split, this.mMb, d.b.mOJ);
                    String string2 = resources.getString(R.l.eIH);
                    CharSequence[] charSequenceArr = new CharSequence[]{string2, string};
                    z2 = false;
                    i = 0;
                    concat = TextUtils.concat(charSequenceArr);
                    z3 = false;
                    break;
                }
            default:
                z2 = false;
                i = 0;
                concat = null;
                z3 = false;
                break;
        }
    }

    public final b.b adp() {
        return this.qeN;
    }

    protected final b$a adq() {
        return this.qeO;
    }

    public final int ads() {
        return this.iVU.mMo;
    }

    public final int aNy() {
        if (this.iVU.mLr == 38) {
            List list = this.iVU.mMm;
            if (list != null && list.size() > 0) {
                return ((com.tencent.mm.plugin.fts.a.a.d) list.get(0)).mLr;
            }
        }
        return super.aNy();
    }

    public final boolean aNz() {
        return this.iVU.mMp;
    }
}
