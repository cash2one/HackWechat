package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class SeeAccessVerifyInfoUI$b extends BaseAdapter {
    List<SeeAccessVerifyInfoUI$a> kFz = new ArrayList();
    final /* synthetic */ SeeAccessVerifyInfoUI lcQ;
    private c lcT = null;
    Context mContext;

    public SeeAccessVerifyInfoUI$b(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, Context context) {
        this.lcQ = seeAccessVerifyInfoUI;
        this.mContext = context;
        axU();
        c$a com_tencent_mm_aq_a_a_c_a = new c$a();
        com_tencent_mm_aq_a_a_c_a.hDA = true;
        com_tencent_mm_aq_a_a_c_a.hDX = true;
        com_tencent_mm_aq_a_a_c_a.hDP = R.k.bBB;
        this.lcT = com_tencent_mm_aq_a_a_c_a.PK();
    }

    private void axU() {
        String[] strArr = null;
        if (bh.ov(SeeAccessVerifyInfoUI.l(this.lcQ))) {
            x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
            return;
        }
        String[] split = SeeAccessVerifyInfoUI.l(this.lcQ).split(",");
        if (bh.ov(SeeAccessVerifyInfoUI.m(this.lcQ))) {
            x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
            return;
        }
        String[] split2 = SeeAccessVerifyInfoUI.m(this.lcQ).split(",");
        if (bh.ov(SeeAccessVerifyInfoUI.n(this.lcQ))) {
            x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
        } else {
            strArr = SeeAccessVerifyInfoUI.n(this.lcQ).split(",");
        }
        this.kFz.clear();
        int i = 0;
        while (i < split.length) {
            List list = this.kFz;
            SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.lcQ;
            String str = split[i];
            String str2 = (split2.length <= i || bh.ov(split2[i])) ? split[i] : split2[i];
            String str3 = (strArr == null || strArr.length <= i || bh.ov(strArr[i])) ? "" : strArr[i];
            list.add(new SeeAccessVerifyInfoUI$a(seeAccessVerifyInfoUI, str, str2, str3));
            i++;
        }
    }

    public final int getCount() {
        return this.kFz.size();
    }

    public final Object getItem(int i) {
        return this.kFz.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SeeAccessVerifyInfoUI$c ck;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dqQ, null);
            ck = this.lcQ.ck(view);
        } else {
            SeeAccessVerifyInfoUI$c seeAccessVerifyInfoUI$c = (SeeAccessVerifyInfoUI$c) view.getTag();
            ck = seeAccessVerifyInfoUI$c == null ? this.lcQ.ck(view) : seeAccessVerifyInfoUI$c;
        }
        ck.iip.setVisibility(0);
        ck.lcV.setVisibility(0);
        o.PA().a(((SeeAccessVerifyInfoUI$a) this.kFz.get(i)).lcS, ck.iip, this.lcT);
        ck.lcV.setText(i.b(this.mContext, bh.ou(((SeeAccessVerifyInfoUI$a) this.kFz.get(i)).fpL), ck.lcV.getTextSize()));
        view.setOnClickListener(new 1(this, i));
        return view;
    }
}
