package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.r;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class c implements OnClickListener {
    private TextView kFb;
    private MultiTalkMainUI oIg;
    private View oIh;
    private TextView oIi;
    private ImageView oIj;
    private LinearLayout oIk;
    private ImageButton oIl;
    private ImageButton oIm;

    public c(MultiTalkMainUI multiTalkMainUI) {
        this.oIg = multiTalkMainUI;
        this.oIh = multiTalkMainUI.findViewById(R.h.cqi);
        this.oIi = (TextView) multiTalkMainUI.findViewById(R.h.cqk);
        this.oIj = (ImageView) multiTalkMainUI.findViewById(R.h.cqj);
        this.oIk = (LinearLayout) multiTalkMainUI.findViewById(R.h.cOE);
        this.kFb = (TextView) multiTalkMainUI.findViewById(R.h.cpT);
        this.oIl = (ImageButton) multiTalkMainUI.findViewById(R.h.cql);
        this.oIm = (ImageButton) multiTalkMainUI.findViewById(R.h.cqh);
        this.oIl.setOnClickListener(this);
        this.oIm.setOnClickListener(this);
    }

    public final void n(MultiTalkGroup multiTalkGroup) {
        int i;
        this.oIh.setVisibility(0);
        String bcL = i.bcL();
        List arrayList = new ArrayList();
        if (!bh.ov(bcL)) {
            for (i = 0; i < multiTalkGroup.zQu.size(); i++) {
                if (!((MultiTalkGroupMember) multiTalkGroup.zQu.get(i)).zQv.equals(bcL)) {
                    arrayList.add(((MultiTalkGroupMember) multiTalkGroup.zQu.get(i)).zQv);
                }
            }
            this.oIi.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this.oIg, r.gu(bcL)));
            b.a(this.oIj, bcL, 0.1f, true);
        }
        if (arrayList.size() > 0) {
            this.kFb.setVisibility(0);
            this.kFb.setText(R.l.ewt);
            this.oIk.setVisibility(0);
            this.oIk.removeAllViews();
            for (i = 0; i < arrayList.size(); i++) {
                View imageView = new ImageView(this.oIg.mController.xIM);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(b.oHZ, b.oHZ);
                if (i != 0) {
                    layoutParams.leftMargin = b.oHX;
                }
                imageView.setLayoutParams(layoutParams);
                this.oIk.addView(imageView);
                b.a(imageView, (String) arrayList.get(i), 0.1f, false);
            }
            return;
        }
        this.kFb.setVisibility(8);
        this.oIk.setVisibility(8);
    }

    public final void bdb() {
        this.oIh.setVisibility(8);
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cqh) {
            o.bcV().c(true, false, false);
        } else if (view.getId() == R.h.cql) {
            e bcV = o.bcV();
            if (bcV.bct()) {
                x.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", new Object[]{i.h(bcV.oGi)});
                o.bcU().oFQ.dE(bcV.oGi.zQq, bcV.oGi.zMg);
                return;
            }
            x.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
    }
}
