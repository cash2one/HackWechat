package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.chatting.viewitems.n.d;
import com.tencent.mm.ui.chatting.viewitems.n.e;
import com.tencent.mm.ui.chatting.viewitems.n.f;
import com.tencent.mm.ui.chatting.viewitems.n.g;
import com.tencent.mm.ui.chatting.viewitems.n.i;
import java.util.ArrayList;
import java.util.List;

class n$c extends a {
    List<n$a> pBs = new ArrayList();
    TextView yIW;
    LinearLayout yKM;
    f yKN = new f();
    n$h yKO = new n$h();
    e yKP = new e();
    i yKQ = new i();
    d yKR = new d();
    g yKS = new g();

    n$c() {
    }

    public final a dA(View view) {
        ViewGroup viewGroup = this.yKM;
        n$a com_tencent_mm_ui_chatting_viewitems_n_a = new n$a();
        com_tencent_mm_ui_chatting_viewitems_n_a.pBg = view;
        com_tencent_mm_ui_chatting_viewitems_n_a.yKI = view.findViewById(R.h.cSD);
        com_tencent_mm_ui_chatting_viewitems_n_a.lWw = view.findViewById(R.h.bYQ);
        com_tencent_mm_ui_chatting_viewitems_n_a.jpW = (TextView) view.findViewById(R.h.title);
        com_tencent_mm_ui_chatting_viewitems_n_a.yKJ = (TextView) view.findViewById(R.h.summary);
        com_tencent_mm_ui_chatting_viewitems_n_a.pBh = view.findViewById(R.h.bZm);
        com_tencent_mm_ui_chatting_viewitems_n_a.pBi = (ImageView) view.findViewById(R.h.bZl);
        com_tencent_mm_ui_chatting_viewitems_n_a.yKK = (ImageView) view.findViewById(R.h.cCF);
        viewGroup.addView(view, viewGroup.getChildCount());
        this.pBs.add(com_tencent_mm_ui_chatting_viewitems_n_a);
        return this;
    }
}
