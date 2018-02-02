package com.tencent.mm.plugin.aa.ui;

import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LaunchAAByPersonAmountSelectUI$a extends BaseAdapter {
    List<LaunchAAByPersonAmountSelectUI$b> dataList;
    final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;

    public final /* synthetic */ Object getItem(int i) {
        return jc(i);
    }

    public LaunchAAByPersonAmountSelectUI$a(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, List<String> list, Map<String, Double> map) {
        this.ijj = launchAAByPersonAmountSelectUI;
        this.dataList = null;
        this.dataList = new ArrayList();
        for (String str : list) {
            LaunchAAByPersonAmountSelectUI$b launchAAByPersonAmountSelectUI$b = new LaunchAAByPersonAmountSelectUI$b(launchAAByPersonAmountSelectUI);
            launchAAByPersonAmountSelectUI$b.username = str;
            if (map == null || !map.containsKey(str)) {
                launchAAByPersonAmountSelectUI$b.ijq = "";
            } else {
                launchAAByPersonAmountSelectUI$b.ijq = launchAAByPersonAmountSelectUI.getString(i.uGM, new Object[]{map.get(str)});
            }
            this.dataList.add(launchAAByPersonAmountSelectUI$b);
        }
    }

    public final int getCount() {
        return this.dataList.size();
    }

    private LaunchAAByPersonAmountSelectUI$b jc(int i) {
        return (LaunchAAByPersonAmountSelectUI$b) this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        LaunchAAByPersonAmountSelectUI$b jc = jc(i);
        if (!(jc == null || bh.ov(jc.username))) {
            if (view == null) {
                view = v.fv(this.ijj).inflate(g.uCc, viewGroup, false);
                a aVar = new a(this, (byte) 0);
                aVar.ihQ = (ImageView) view.findViewById(a$f.bLC);
                aVar.iiQ = (TextView) view.findViewById(a$f.cUp);
                aVar.iiR = (WalletFormView) view.findViewById(a$f.urE);
                aVar.ijp = new LaunchAAByPersonAmountSelectUI$c(this.ijj, jc.username);
                aVar.iiR.a(aVar.ijp);
                aVar.ihQ.setOnTouchListener(new 1(this, aVar));
                aVar.iiQ.setOnTouchListener(new 2(this, aVar));
                view.setTag(aVar);
                this.ijj.a(aVar.iiR, 2, false, true);
            }
            a aVar2 = (a) view.getTag();
            if (!bh.ov(jc.username)) {
                aVar2.ijp.username = jc.username;
                b.a(aVar2.ihQ, jc.username);
                aVar2.iiQ.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.ijj.mController.xIM, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.a.b.class)).L(jc.username, LaunchAAByPersonAmountSelectUI.n(this.ijj)), aVar2.iiQ.getTextSize()));
            }
            if (!(jc.ijq == null || aVar2.iiR.getText() == null || jc.ijq.equals(aVar2.iiR.getText().toLowerCase()))) {
                WalletFormView walletFormView = aVar2.iiR;
                TextWatcher textWatcher = aVar2.ijp;
                if (walletFormView.zJG != null) {
                    walletFormView.zJG.removeTextChangedListener(textWatcher);
                }
                aVar2.iiR.setText(jc.ijq);
                aVar2.iiR.a(aVar2.ijp);
            }
        }
        return view;
    }
}
