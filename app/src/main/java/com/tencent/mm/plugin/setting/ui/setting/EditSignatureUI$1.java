package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.g.a.lj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class EditSignatureUI$1 extends c<lj> {
    final /* synthetic */ EditSignatureUI qgS;

    EditSignatureUI$1(EditSignatureUI editSignatureUI) {
        this.qgS = editSignatureUI;
        this.xen = lj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lj ljVar = (lj) bVar;
        String str = ljVar.fCK.fCL;
        String str2 = ljVar.fCK.fCM;
        int i = ljVar.fCK.ret;
        if (i != 0 && EditSignatureUI.a(this.qgS) != null) {
            h.b(this.qgS, str2, str, true);
            if (EditSignatureUI.b(this.qgS) != null) {
                ar.Hg();
                com.tencent.mm.z.c.EX().c(EditSignatureUI.b(this.qgS));
            }
        } else if (i == 0 && EditSignatureUI.c(this.qgS)) {
            str = EditSignatureUI.a(this.qgS).getText().toString().trim();
            ar.Hg();
            com.tencent.mm.z.c.CU().set(12291, str);
            this.qgS.finish();
        }
        if (EditSignatureUI.d(this.qgS) != null) {
            EditSignatureUI.d(this.qgS).dismiss();
        }
        return true;
    }
}
