package com.tencent.mm.ui.chatting.b;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.d.a;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.a.v;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.b;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.m$a$a;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class c implements n {
    public p fhr;
    public d kEC;
    public j piK;
    public i piT = null;
    public boolean vnK = false;
    public a ynH = new 11(this);
    public com.tencent.mm.ag.a.c ync;
    protected final ChatFooter.d ypT = new 10(this);
    public n ywe;
    public long ywz = -1;
    public com.tencent.mm.app.plugin.a.a yyI;
    public long yyJ = 0;
    public boolean yyK = false;
    RelativeLayout yyL;
    TextView yyM;
    public m$a$a yyN = new 1(this);
    protected final a yyO = new 9(this);
    public e.a yyP = new 12(this);

    public c(p pVar) {
        this.fhr = pVar;
    }

    public final void a(int i, k kVar) {
        if (kVar.getType() == 1357) {
            this.fhr.dismissDialog();
            if (i != 0) {
                Toast.makeText(ac.getContext(), this.fhr.csq().getMMString(R.l.eET), 0).show();
            }
        }
    }

    public final long cti() {
        return this.ync == null ? -1 : this.ync.field_bizChatLocalId;
    }

    public final void ctj() {
        ar.Dm().g(new 2(this), 500);
    }

    public final String Zh(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (com.tencent.mm.l.a.fZ(this.fhr.csi().field_type) && this.fhr.csi().cia() && this.kEC != null) {
                b bI = this.kEC.bI(false);
                if (!(bI == null || TextUtils.isEmpty(bI.LD()) || !substring.contains(bI.LD()))) {
                    return substring;
                }
            }
        }
        return null;
    }

    final String ay(LinkedList<String> linkedList) {
        if (linkedList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(this.ync.gu((String) linkedList.get(0)));
        for (int i = 1; i < linkedList.size(); i++) {
            stringBuilder.append(this.fhr.csq().getContext().getString(R.l.dQz)).append(this.ync.gu((String) linkedList.get(i)));
        }
        return stringBuilder.toString();
    }

    public final void ctk() {
        if (this.vnK) {
            y.Ml();
            g.Di().gPJ.a(new v(this.fhr.crz(), this.ync.field_bizChatServId, (int) (System.currentTimeMillis() / 1000)), 0);
        }
    }
}
