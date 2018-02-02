package com.tencent.mm.ui.contact;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.a;
import com.tencent.mm.z.l;
import java.util.LinkedList;
import java.util.List;

class SelectContactUI$6 extends b {
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$6(SelectContactUI selectContactUI) {
        this.yUy = selectContactUI;
        super(0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        if (bVar instanceof jv) {
            jv jvVar = (jv) bVar;
            if (SelectContactUI.f(this.yUy) != null) {
                if (SelectContactUI.e(this.yUy) != null) {
                    SelectContactUI.e(this.yUy).dismiss();
                    SelectContactUI.g(this.yUy);
                }
                SelectContactUI.h(this.yUy);
                SelectContactUI.d(this.yUy, false);
                SelectContactUI.a(this.yUy, jvVar.fAL.fAP);
                if (!a.a(this.yUy, i, i2, str, 4)) {
                    int i3;
                    if (i == 0 && i2 == 0 && !bh.ov(SelectContactUI.i(this.yUy))) {
                        l.a(SelectContactUI.i(this.yUy), jvVar.fAL.fAU, this.yUy.getString(R.l.dQx), false, "");
                        List list = jvVar.fAL.fAT;
                        if (list != null && list.size() > 0) {
                            List linkedList = new LinkedList();
                            for (i3 = 0; i3 < list.size(); i3++) {
                                linkedList.add(list.get(i3));
                            }
                            l.a(SelectContactUI.i(this.yUy), linkedList, this.yUy.getString(R.l.dQy), true, "weixin://findfriend/verifycontact/" + SelectContactUI.i(this.yUy) + "/");
                        }
                        SelectContactUI.b(this.yUy, bh.F(new String[]{SelectContactUI.i(this.yUy)}));
                        return;
                    }
                    String str2 = "";
                    String str3 = "";
                    String string = ac.getContext().getString(R.l.dQz);
                    if (i2 == -23) {
                        str2 = this.yUy.getString(R.l.eFK);
                        str3 = this.yUy.getString(R.l.eFJ);
                    }
                    List list2 = jvVar.fAL.fAT;
                    List list3 = jvVar.fAL.fAR;
                    if (list2 == null || list2.size() <= 0 || (list2.size() != jvVar.fAL.fAO && (list3 == null || list3.size() <= 0 || jvVar.fAL.fAO != list2.size() + list3.size()))) {
                        list2 = jvVar.fAL.fAR;
                        if (list2 != null && list2.size() > 0 && jvVar.fAL.fAO == list2.size()) {
                            str2 = this.yUy.getString(R.l.esI);
                            str3 = str3 + this.yUy.getString(R.l.eiF, new Object[]{bh.d(SelectContactUI.dw(list2), string)});
                        }
                        list2 = jvVar.fAL.fAQ;
                        if (list2 != null && list2.size() > 0) {
                            str2 = this.yUy.getString(R.l.esI);
                            str3 = str3 + this.yUy.getString(R.l.eiI, new Object[]{bh.d(SelectContactUI.dw(list2), string)});
                        }
                        if (str2 == null || str2.length() <= 0) {
                            Toast.makeText(this.yUy, this.yUy.getString(R.l.eiv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                        h.b(this.yUy, str3, str2, true);
                        return;
                    }
                    LinkedList linkedList2 = new LinkedList();
                    for (i3 = 0; i3 < list2.size(); i3++) {
                        linkedList2.add(list2.get(i3));
                    }
                    SelectContactUI.a(this.yUy, linkedList2, list3);
                }
            }
        }
    }
}
