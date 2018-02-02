package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a$c;
import com.tencent.mm.pluginsdk.ui.d.i;

public class e extends a {
    public CharSequence iil;
    public String username;
    public CharSequence yVn;
    public int yVo = 0;
    private b yVp = new b(this);
    a yVq = new a(this);

    public class a extends a$a {
        public ImageView iip;
        public TextView iir;
        public CheckBox iis;
        public TextView kBH;
        final /* synthetic */ e yVr;

        public a(e eVar) {
            this.yVr = eVar;
            super(eVar);
        }
    }

    public e(int i) {
        super(4, i);
    }

    public void bH(Context context) {
        if (this.yVo != 0 && this.yVn != null) {
            return;
        }
        if (this.jLe == null) {
            this.iil = "";
            this.username = "";
            return;
        }
        this.iil = i.c(context, ((b) g.h(b.class)).c(this.jLe), com.tencent.mm.bv.a.aa(context, a$c.bvK));
        this.username = this.jLe.field_username;
    }

    public final a.b WQ() {
        return this.yVp;
    }

    protected final a$a WR() {
        return this.yVq;
    }
}
