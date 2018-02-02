package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.ag.d.b.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI extends MMActivity {
    private static af haq = new af(Looper.getMainLooper());
    private LinkedList<bek> hdX = new LinkedList();
    private ListView rYn;
    private b rYo;
    private Map<String, c> rYp;

    private class b extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ ContactSearchResultUI rYq;

        public final /* synthetic */ Object getItem(int i) {
            return yh(i);
        }

        public b(ContactSearchResultUI contactSearchResultUI, Context context) {
            this.rYq = contactSearchResultUI;
            this.mContext = context;
        }

        public final int getCount() {
            return this.rYq.hdX == null ? 0 : this.rYq.hdX.size();
        }

        private bek yh(int i) {
            return this.rYq.hdX == null ? null : (bek) this.rYq.hdX.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            int i2 = 8;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.drs, null);
                dVar = new d();
                dVar.iip = (ImageView) view.findViewById(R.h.bLD);
                dVar.kEZ = (TextView) view.findViewById(R.h.cAm);
                dVar.kFa = view.findViewById(R.h.cUy);
                dVar.kFb = (TextView) view.findViewById(R.h.cpS);
                d.a(dVar, view.findViewById(R.h.bNN));
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            bek yh = yh(i);
            if (yh == null) {
                x.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
            } else {
                dVar.username = yh.vYI.wJF;
                dVar.iconUrl = yh.vUV;
                dVar.iip.setTag(dVar.username);
                dVar.asF();
                String str = yh.vYI.wJF;
                c cVar = (c) this.rYq.rYp.get(str);
                if (cVar == null) {
                    c cVar2 = new c((byte) 0);
                    this.rYq.rYp.put(str, cVar2);
                    pq pqVar = yh.wvm;
                    if (pqVar != null) {
                        d Lz;
                        com.tencent.mm.ag.d dVar2 = new com.tencent.mm.ag.d();
                        dVar2.field_username = str;
                        dVar2.field_brandFlag = pqVar.hvH;
                        dVar2.field_brandIconURL = pqVar.hvK;
                        dVar2.field_brandInfo = pqVar.hvJ;
                        dVar2.field_extInfo = pqVar.hvI;
                        if (dVar2.bI(false) != null) {
                            Lz = dVar2.bI(false).Lz();
                        } else {
                            Lz = null;
                        }
                        if (Lz != null) {
                            boolean z = dVar2.bI(false).LB() && !bh.ov(Lz.hpl);
                            cVar2.kEX = z;
                            cVar2.kEW = yh.wvf != 0;
                        }
                    }
                    cVar = cVar2;
                }
                dVar.kFa.setVisibility(cVar.kEW ? 0 : 8);
                View a = d.a(dVar);
                if (cVar.kEX) {
                    i2 = 0;
                }
                a.setVisibility(i2);
                x.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[]{Integer.valueOf(yh.wvf)});
                try {
                    dVar.kFb.setText(i.b(this.mContext, bh.ou(yh.hvw), dVar.kFb.getTextSize()));
                } catch (Exception e) {
                    dVar.kFb.setText("");
                }
                try {
                    TextView textView = dVar.kEZ;
                    Context context = this.mContext;
                    CharSequence ou = !bh.ov(yh.wsB.wJF) ? yh.wsB.wJF : !bh.ov(yh.hvy) ? yh.hvy : bh.ou(yh.vYI.wJF);
                    textView.setText(i.b(context, ou, dVar.kEZ.getTextSize()));
                } catch (Exception e2) {
                    dVar.kEZ.setText("");
                }
            }
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.dfa);
        setBackBtn(new 1(this));
        this.rYp = new HashMap();
        this.rYn = (ListView) findViewById(R.h.cHN);
        this.rYn.setEmptyView((TextView) findViewById(R.h.empty));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("result");
        int intExtra = getIntent().getIntExtra("add_more_friend_search_scene", 0);
        if (byteArrayExtra != null) {
            try {
                bem com_tencent_mm_protocal_c_bem = (bem) new bem().aF(byteArrayExtra);
                if (com_tencent_mm_protocal_c_bem != null) {
                    this.hdX = com_tencent_mm_protocal_c_bem.wkl;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
            }
        }
        if (this.hdX != null && this.hdX.size() != 0) {
            this.rYo = new b(this, this);
            this.rYn.setAdapter(this.rYo);
            this.rYn.setOnItemClickListener(new 2(this, intExtra));
            this.rYn.setOnScrollListener(new a());
        }
    }

    protected final int getLayoutId() {
        return R.i.dfa;
    }

    protected void onDestroy() {
        n.JS().cancel();
        if (this.rYp != null) {
            this.rYp.clear();
        }
        super.onDestroy();
    }
}
