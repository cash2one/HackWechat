package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;

public class EmojiPaidUI extends BaseEmojiStoreUI {
    private g[] lCw;

    protected final int aCs() {
        return 2;
    }

    protected final int aCq() {
        return 2;
    }

    protected final void initView() {
        setMMTitle(R.l.dZX);
        if (q.Ge()) {
            addIconOptionMenu(0, R.g.bDI, new 1(this));
        }
        super.initView();
        this.kgl.setVisibility(8);
        this.Fv.setVisibility(8);
    }

    protected final void aCl() {
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lCw != null && this.lCw.length > 0) {
            for (k c : this.lCw) {
                ar.CG().c(c);
            }
        }
    }

    protected final void a(g gVar) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        aCx();
        String str = "";
        int intExtra;
        if (intent != null) {
            intExtra = intent.getIntExtra("key_err_code", 0);
            x.w("MicroMsg.emoji.EmojiPaidUI", "errCode:" + intExtra);
            CharSequence stringExtra = intent.getStringExtra("key_err_msg");
            x.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:" + stringExtra);
        } else {
            Object obj = str;
            intExtra = 0;
        }
        if (i2 != -1) {
            Toast.makeText(this, R.l.eab, 0).show();
        } else if (intent == null || r0 != 0) {
            Toast.makeText(this, stringExtra, 0).show();
        } else {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, stringExtra, 0).show();
                return;
            }
            this.lAz = null;
            this.lAw = -1;
            s(false, false);
            ar.Hg();
            c.CU().set(208900, Boolean.valueOf(true));
            Toast.makeText(this, R.l.eac, 0).show();
        }
    }

    protected final void a(boolean z, f fVar, boolean z2, boolean z3) {
        if (!(fVar == null || !z || this.lxL == null)) {
            this.lxL.b(fVar);
        }
        if (this.lxL == null || fVar == null || fVar.lxB <= 0) {
            this.kgl.setVisibility(0);
            this.lAu.setText(R.l.dZW);
            this.Fv.setVisibility(8);
            return;
        }
        this.kgl.setVisibility(8);
        this.Fv.setVisibility(0);
    }

    protected final boolean aCn() {
        return false;
    }

    protected final a aCj() {
        return new d(this.mController.xIM);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group")) {
            aCI();
            cp(131074, 50);
        }
    }

    protected final int aCh() {
        return 10;
    }

    protected final int aCi() {
        return 6;
    }
}
