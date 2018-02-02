package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.l$a;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import java.util.List;

public class CardNewMsgUI extends MMActivity implements l$a {
    private ListView Fv;
    OnClickListener inN = new 9(this);
    private View jMa;
    private a kUD;
    private View kUE = null;
    private boolean kUF = false;
    private View kgl;

    class a extends o<g> {
        private int hKb = this.kUH;
        final /* synthetic */ CardNewMsgUI kUG;
        private int kUH = 10;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (g) obj;
            if (obj == null) {
                obj = new g();
            }
            obj.b(cursor);
            return obj;
        }

        public a(CardNewMsgUI cardNewMsgUI) {
            this.kUG = cardNewMsgUI;
            super(cardNewMsgUI, new g());
            lU(true);
        }

        public final void Xy() {
            if (am.auC().Tq() > 0) {
                setCursor(am.auC().gJP.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.hKb = am.auC().getCount();
                h auC = am.auC();
                setCursor(auC.gJP.rawQuery("select * from CardMsgInfo order by time desc LIMIT " + this.kUH, null));
            }
            notifyDataSetChanged();
        }

        protected final void Xz() {
            aUn();
            Xy();
        }

        public final boolean awe() {
            return this.kUH >= this.hKb;
        }

        public final int awf() {
            if (awe()) {
                if (this.kUG.kUE.getParent() != null) {
                    this.kUG.Fv.removeFooterView(this.kUG.kUE);
                }
                return 0;
            }
            this.kUH += 10;
            if (this.kUH <= this.hKb) {
                return 10;
            }
            this.kUH = this.hKb;
            return this.hKb % 10;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            g gVar = (g) getItem(i);
            if (view == null) {
                view = View.inflate(this.kUG.mController.xIM, R.i.dcs, null);
                b bVar2 = new b(this.kUG, (byte) 0);
                bVar2.kUM = (ImageView) view.findViewById(R.h.logo);
                bVar2.kUN = view.findViewById(R.h.bSr);
                bVar2.kUO = (ImageView) view.findViewById(R.h.bSq);
                bVar2.kUP = (TextView) view.findViewById(R.h.cSu);
                bVar2.kUQ = (TextView) view.findViewById(R.h.cRs);
                bVar2.kUR = (TextView) view.findViewById(R.h.caT);
                bVar2.kUS = (TextView) view.findViewById(R.h.cfL);
                bVar2.kUT = (TextView) view.findViewById(R.h.cPd);
                bVar2.kUU = view.findViewById(R.h.cBK);
                bVar2.kUV = (TextView) view.findViewById(R.h.cBL);
                bVar2.kUW = (LinearLayout) view.findViewById(R.h.bIg);
                bVar2.kUX = (LinearLayout) view.findViewById(R.h.bIh);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.kUP.setText(gVar.field_title);
            bVar.kUQ.setText(n.c(this.kUG, ((long) gVar.field_time) * 1000, true));
            bVar.kUR.setText(gVar.field_description);
            int dimensionPixelSize = this.kUG.getResources().getDimensionPixelSize(R.f.bwB);
            x.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " logo_url :  " + gVar.field_logo_url);
            if (TextUtils.isEmpty(gVar.field_logo_color)) {
                bVar.kUN.setVisibility(8);
                bVar.kUM.setVisibility(0);
                bVar.kUM.setImageResource(R.g.bDT);
                m.a(bVar.kUM, gVar.field_logo_url, dimensionPixelSize, R.g.bDT, true);
            } else {
                x.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " field_logo_color :  " + gVar.field_logo_color);
                bVar.kUN.setVisibility(0);
                bVar.kUM.setVisibility(8);
                if (TextUtils.isEmpty(gVar.field_logo_url)) {
                    m.a(bVar.kUO, R.g.bAv, l.wO(gVar.field_logo_color));
                } else {
                    m.a(this.kUG, bVar.kUO, gVar.field_logo_url, dimensionPixelSize, R.g.bAv, l.wO(gVar.field_logo_color));
                }
            }
            ke auq = gVar.auq();
            if (auq == null || TextUtils.isEmpty(auq.text)) {
                bVar.kUS.setVisibility(8);
            } else {
                bVar.kUS.setText(auq.text);
                bVar.kUS.setTag(gVar);
                bVar.kUS.setVisibility(0);
                bVar.kUS.setOnClickListener(this.kUG.inN);
            }
            ki aur = gVar.aur();
            if (aur == null || TextUtils.isEmpty(aur.text)) {
                bVar.kUU.setVisibility(8);
                bVar.kUT.setVisibility(8);
            } else {
                bVar.kUV.setText(aur.text);
                bVar.kUU.setVisibility(0);
                bVar.kUU.setOnClickListener(this.kUG.inN);
                bVar.kUU.setTag(gVar);
                bVar.kUT.setVisibility(0);
            }
            gVar.aus();
            gVar.aut();
            a(gVar.kLp, gVar.kLq, bVar, gVar);
            return view;
        }

        private void a(List<com.tencent.mm.plugin.card.model.g.a> list, List<b> list2, b bVar, g gVar) {
            bVar.kUW.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                bVar.kUX.setVisibility(8);
                return;
            }
            int i;
            View inflate;
            Button button;
            if (!bh.cA(list)) {
                for (i = 0; i < list.size(); i++) {
                    com.tencent.mm.plugin.card.model.g.a aVar = (com.tencent.mm.plugin.card.model.g.a) list.get(i);
                    inflate = View.inflate(this.kUG.mController.xIM, R.i.dbF, null);
                    if (i == 0) {
                        inflate.findViewById(R.h.bPr).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.h.bPt)).setText(aVar.title);
                    ((TextView) inflate.findViewById(R.h.bPs)).setText(aVar.kLv);
                    button = (Button) inflate.findViewById(R.h.bPq);
                    button.setOnClickListener(new 1(this, aVar, gVar));
                    if (aVar.kLy == 0) {
                        button.setText(R.l.bPt);
                    } else if (aVar.kLy == 1) {
                        button.setText(R.l.dNs);
                    }
                    bVar.kUW.addView(inflate);
                }
            }
            if (!bh.cA(list2)) {
                for (i = 0; i < list2.size(); i++) {
                    final b bVar2 = (b) list2.get(i);
                    inflate = View.inflate(this.kUG.mController.xIM, R.i.dbF, null);
                    if (i == 0 && bh.cA(list)) {
                        inflate.findViewById(R.h.bPr).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.h.bPt)).setText(bVar2.title);
                    ((TextView) inflate.findViewById(R.h.bPs)).setText(bVar2.description);
                    button = (Button) inflate.findViewById(R.h.bPq);
                    button.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a kUK;

                        public final void onClick(View view) {
                            if (TextUtils.isEmpty(bVar2.kLB)) {
                                x.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(this.kUK.kUG, bVar2.kLB, 2);
                            }
                        }
                    });
                    button.setText(bVar2.kLA);
                    bVar.kUW.addView(inflate);
                }
            }
            bVar.kUX.setVisibility(0);
        }
    }

    static /* synthetic */ void a(CardNewMsgUI cardNewMsgUI, int i) {
        g gVar = (g) cardNewMsgUI.kUD.getItem(i);
        if (gVar != null) {
            if (gVar.field_jump_type == 3) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.ab(gVar.field_card_id, false);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.ab(gVar.field_card_tp_id, false);
                }
            } else if (gVar.field_jump_type == 2) {
                if (TextUtils.isEmpty(gVar.field_url)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_url is null");
                } else {
                    com.tencent.mm.plugin.card.b.b.a(cardNewMsgUI, gVar.field_url, 4);
                }
            } else if (gVar.field_jump_type == 1) {
                x.i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (gVar.field_jump_type == 4) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.ab(gVar.field_card_id, true);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    x.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.ab(gVar.field_card_tp_id, true);
                }
            }
            int i2 = cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false) ? 7 : 1;
            com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(i2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
        }
    }

    protected final int getLayoutId() {
        return R.i.dcu;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        am.auE().a(this);
        am.auE().aun();
    }

    protected void onDestroy() {
        this.kUD.aUn();
        am.auE().b(this);
        if (am.auC().Tq() > 0) {
            am.auC().auv();
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.dON);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI kUG;

            {
                this.kUG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kUG.finish();
                return true;
            }
        });
        this.Fv = (ListView) findViewById(R.h.bRw);
        this.kUD = new a(this);
        this.Fv.setAdapter(this.kUD);
        this.Fv.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI kUG;

            {
                this.kUG = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == this.kUG.kUD.getCount()) {
                    int i2 = 1;
                    if (am.auC().Tq() > 0) {
                        am.auC().auv();
                    } else {
                        i2 = this.kUG.kUD.awf();
                    }
                    this.kUG.kUD.a(null, null);
                    if (!this.kUG.kUF) {
                        if (this.kUG.jMa.getParent() != null) {
                            x.d("MicroMsg.CardNewMsgUI", "remove footer");
                            this.kUG.Fv.removeFooterView(this.kUG.jMa);
                        }
                        if (!this.kUG.kUD.awe() && this.kUG.kUE.getParent() == null && r0 > 0) {
                            this.kUG.Fv.addFooterView(this.kUG.kUE);
                            x.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                        }
                    }
                    this.kUG.kUF = true;
                    this.kUG.jMa.setVisibility(8);
                    return;
                }
                CardNewMsgUI.a(this.kUG, i);
            }
        });
        this.Fv.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardNewMsgUI kUG;

            {
                this.kUG = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.ui.base.h.a(this.kUG, this.kUG.getResources().getString(R.l.dOO), null, this.kUG.getResources().getString(R.l.dEw), new 7(this.kUG, i));
                return true;
            }
        });
        this.Fv.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CardNewMsgUI kUG;

            {
                this.kUG = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (this.kUG.kUF && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (am.auC().Tq() > 0) {
                        am.auC().auv();
                    } else {
                        this.kUG.kUD.awf();
                    }
                    this.kUG.kUD.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.kUD.xIi = new 5(this);
        addTextOptionMenu(0, getString(R.l.dNM), new 6(this));
        this.kgl = findViewById(R.h.bYR);
        ava();
        this.jMa = v.fv(this).inflate(R.i.dcr, null);
        this.kUE = v.fv(this).inflate(R.i.dns, null);
        int Tq = am.auC().Tq();
        if (Tq > 0) {
            this.Fv.addFooterView(this.jMa);
        } else if (!this.kUD.awe() && Tq == 0 && am.auC().getCount() > 0) {
            this.Fv.addFooterView(this.kUE);
            this.kUF = true;
        } else if (this.kUD.awe() && Tq == 0) {
            am.auC().getCount();
        }
    }

    private void ava() {
        com.tencent.mm.plugin.card.a.l auE = am.auE();
        int size = (auE.kJF == null || auE.kJF.isEmpty()) ? 0 : auE.kJF.size();
        if (size > 0) {
            this.Fv.setVisibility(0);
            this.kgl.setVisibility(8);
            enableOptionMenu(true);
        } else {
            this.Fv.setVisibility(8);
            this.kgl.setVisibility(0);
            enableOptionMenu(false);
        }
        this.kUD.notifyDataSetChanged();
    }

    private void ab(String str, boolean z) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        startActivity(intent);
    }

    public final void a(g gVar) {
        if ((gVar.field_msg_type & 1) != 0 && (gVar.field_msg_type & 3) != 0) {
            ava();
            this.kUD.a(null, null);
        }
    }

    public final void asi() {
    }
}
