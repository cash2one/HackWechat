package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class SnsCommentFooter$2 implements TextWatcher {
    final /* synthetic */ SnsCommentFooter rBl;
    final /* synthetic */ List rBm;

    SnsCommentFooter$2(SnsCommentFooter snsCommentFooter, List list) {
        this.rBl = snsCommentFooter;
        this.rBm = list;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (SnsCommentFooter.a(this.rBl).getText() != null) {
            l lVar;
            boolean z;
            x.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.b(this.rBl));
            for (l lVar2 : this.rBm) {
                if (SnsCommentFooter.b(this.rBl).equals(lVar2.aAM)) {
                    x.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                    lVar2.text = SnsCommentFooter.a(this.rBl).getText().toString();
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                x.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                lVar2 = new l();
                lVar2.aAM = SnsCommentFooter.b(this.rBl);
                lVar2.text = SnsCommentFooter.a(this.rBl).getText().toString();
                if (lVar2.text != null && lVar2.text.length() > 0) {
                    this.rBm.add(lVar2);
                }
            }
            if (this.rBm.size() > 5) {
                x.d("MicroMsg.SnsCommentFooter", "comments remove");
                this.rBm.remove(0);
            }
            SnsCommentFooter.a(this.rBl).requestFocus();
            z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && this.rBl.okB) {
                SnsCommentFooter.a(this.rBl, z);
                this.rBl.okB = false;
            }
            if (!z) {
                SnsCommentFooter.a(this.rBl, z);
                this.rBl.okB = true;
            }
        }
    }
}
