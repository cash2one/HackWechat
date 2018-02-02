package com.tencent.mm.plugin.favorite.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.m;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.base.FavCapacityPanel;
import com.tencent.mm.plugin.favorite.ui.base.FavSearchActionView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@a(19)
public class FavSearchUI extends MMActivity {
    private String flw;
    private int hYh;
    private ListView kFD;
    private af mHandler;
    private h mrY;
    private b mrZ;
    private String msH;
    private Set<Integer> msI;
    private n msJ;
    private c msK;
    private FavSearchActionView msL;
    private View msM;
    private ListView msN;
    private View msO;
    private FavCapacityPanel msP;
    private Animation msQ;
    private Animation msR;
    private List<Integer> msS;
    private List<String> msT;
    private List<String> msU;
    private Set<String> msV = new HashSet();
    private View msW;
    private ImageButton msX;
    private MenuItem msY;
    private List<Long> msZ = new ArrayList();
    private TextView mta;
    private TextView mtb;
    private TextView mtc;
    private TextView mtd;
    private TextView mte;
    private TextView mtf;
    private OnClickListener mtg = new 4(this);

    static /* synthetic */ void a(FavSearchUI favSearchUI, List list, List list2, List list3) {
        if ((list == null || list.isEmpty()) && ((list2 == null || list2.isEmpty()) && (list3 == null || list3.isEmpty()))) {
            favSearchUI.msX.setVisibility(8);
        } else {
            favSearchUI.msX.setVisibility(0);
        }
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, boolean z) {
        favSearchUI.mrZ.notifyDataSetChanged();
        if (8 != favSearchUI.msN.getVisibility()) {
            favSearchUI.msN.setVisibility(8);
            favSearchUI.msN.startAnimation(favSearchUI.msR);
        }
        if (favSearchUI.mrZ.isEmpty()) {
            if (favSearchUI.msO.getVisibility() != 0) {
                favSearchUI.msO.setVisibility(0);
                favSearchUI.msO.startAnimation(favSearchUI.msQ);
            }
            if (8 != favSearchUI.kFD.getVisibility()) {
                favSearchUI.kFD.setVisibility(8);
                favSearchUI.kFD.startAnimation(favSearchUI.msR);
            }
        } else {
            if (8 != favSearchUI.msO.getVisibility()) {
                favSearchUI.msO.setVisibility(8);
                favSearchUI.msO.startAnimation(favSearchUI.msR);
            }
            if (favSearchUI.kFD.getVisibility() != 0) {
                favSearchUI.kFD.setVisibility(0);
                favSearchUI.kFD.startAnimation(favSearchUI.msQ);
            }
        }
        if (favSearchUI.mrZ.isEmpty() && ((favSearchUI.msT == null || favSearchUI.msT.isEmpty()) && ((favSearchUI.msS == null || favSearchUI.msS.isEmpty()) && favSearchUI.msU != null && favSearchUI.msU.size() == 1))) {
            x.w("MicroMsg.FavSearchUI", "need del tag %s", new Object[]{(String) favSearchUI.msU.get(0)});
            favSearchUI.msV.add(r0);
        }
        if (z) {
            favSearchUI.aWs();
        }
    }

    static /* synthetic */ void c(FavSearchUI favSearchUI) {
        favSearchUI.msK.notifyDataSetChanged();
        if (favSearchUI.msN.getVisibility() != 0) {
            favSearchUI.msN.setVisibility(0);
            favSearchUI.msN.startAnimation(favSearchUI.msQ);
        }
        if (8 != favSearchUI.kFD.getVisibility()) {
            favSearchUI.kFD.setVisibility(8);
            favSearchUI.kFD.startAnimation(favSearchUI.msR);
        }
        if (8 != favSearchUI.msO.getVisibility()) {
            favSearchUI.msO.setVisibility(8);
            favSearchUI.msO.startAnimation(favSearchUI.msR);
        }
    }

    static /* synthetic */ int i(FavSearchUI favSearchUI) {
        int size = favSearchUI.msS.size();
        int size2 = favSearchUI.msT.size();
        int size3 = favSearchUI.msU.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            return 2;
        }
        if (size == 0 && size2 > 0 && size3 == 0) {
            return 3;
        }
        return (size > 0 && size2 == 0 && size3 == 0) ? 1 : 4;
    }

    protected final int getLayoutId() {
        return R.i.dhK;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new af();
        setMMTitle("");
        this.hYh = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.hYh) {
            this.flw = getIntent().getStringExtra("key_to_user");
            this.msH = getIntent().getStringExtra("key_fav_item_id");
        }
        this.msN = (ListView) findViewById(R.h.cQe);
        this.kFD = (ListView) findViewById(R.h.cJZ);
        this.msO = findViewById(R.h.cJF);
        this.msQ = AnimationUtils.loadAnimation(this.mController.xIM, R.a.bqi);
        this.msR = AnimationUtils.loadAnimation(this.mController.xIM, R.a.bqj);
        aJj();
        this.msM = View.inflate(this.mController.xIM, R.i.dhQ, null);
        this.mta = (TextView) this.msM.findViewById(R.h.chd);
        this.mtb = (TextView) this.msM.findViewById(R.h.cha);
        this.mtc = (TextView) this.msM.findViewById(R.h.chf);
        this.mtd = (TextView) this.msM.findViewById(R.h.chc);
        this.mte = (TextView) this.msM.findViewById(R.h.che);
        this.mtf = (TextView) this.msM.findViewById(R.h.chb);
        this.mta.setOnClickListener(this.mtg);
        this.mta.setTag(Integer.valueOf(5));
        this.mtb.setOnClickListener(this.mtg);
        this.mtb.setTag(Integer.valueOf(2));
        this.mtc.setOnClickListener(this.mtg);
        this.mtc.setTag(Integer.valueOf(3));
        this.mtd.setOnClickListener(this.mtg);
        this.mtd.setTag(Integer.valueOf(7));
        this.mte.setOnClickListener(this.mtg);
        this.mte.setTag(Integer.valueOf(4));
        this.mtf.setOnClickListener(this.mtg);
        this.mtf.setTag(Integer.valueOf(6));
        this.msP = (FavCapacityPanel) View.inflate(this.mController.xIM, R.i.dhr, null);
        this.msP.muL = getIntent().getIntExtra("key_enter_fav_search_from", 0);
        this.msK = new 11(this, this.mController.xIM);
        this.msN.addHeaderView(this.msM);
        if (com.tencent.mm.plugin.favorite.h.aIq().aIx() > 0) {
            this.msN.addHeaderView((TextView) View.inflate(this.mController.xIM, R.i.dhN, null));
        }
        this.msN.addFooterView(this.msP);
        this.msN.setAdapter(this.msK);
        this.msN.setOnTouchListener(new 12(this));
        this.mrY = new h(this.mController.xIM, 16);
        ActionBarActivity actionBarActivity = this.mController.xIM;
        this.mrZ = new b(this.mrY, false);
        this.mrZ.scene = 2;
        this.mrZ.muz = this.kFD;
        if (1 == this.hYh) {
            this.msI = new HashSet();
            this.msJ = new d();
            if (!bh.ov(this.msH)) {
                for (String str : this.msH.split(",")) {
                    int i = bh.getInt(str, Integer.MAX_VALUE);
                    if (Integer.MAX_VALUE != i) {
                        this.msI.add(Integer.valueOf(i));
                    }
                }
            }
            this.mrZ.e(this.msI);
            this.mrZ.a(this.msJ);
        }
        this.kFD.setAdapter(this.mrZ);
        this.kFD.setOnItemClickListener(new 2(this));
        this.kFD.setOnTouchListener(new 3(this));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavSearchUI mth;

            {
                this.mth = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mth.finish();
                return true;
            }
        });
        com.tencent.mm.plugin.favorite.h.aIq().a(this.msK);
        ar.Dm().g(new 5(this), 1000);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mrY.destory();
        this.mrY = null;
        com.tencent.mm.plugin.favorite.h.aIq().a(this.msK);
        com.tencent.mm.plugin.favorite.h.aIq().c(this.msV);
        if (this.mrZ != null) {
            this.mrZ.finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.FavSearchUI", "on create options menu");
        aJj();
        this.msY = menu.add(0, R.h.cvP, 0, R.l.dEJ);
        m.a(this.msY, this.msL);
        m.a(this.msY, 9);
        this.msL.post(new Runnable(this) {
            final /* synthetic */ FavSearchUI mth;

            {
                this.mth = r1;
            }

            public final void run() {
                FavSearchActionView a = this.mth.msL;
                if (a.mtA != null) {
                    a.mtA.cpF();
                }
                this.mth.showVKB();
            }
        });
        m.a(this.msY, new 7(this));
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ FavSearchUI mth;

            {
                this.mth = r1;
            }

            public final void run() {
                if (this.mth.msY != null) {
                    m.b(this.mth.msY);
                    LayoutParams layoutParams = (LayoutParams) this.mth.msL.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                        layoutParams.width = -1;
                    }
                    this.mth.msL.setLayoutParams(layoutParams);
                }
            }
        });
        return true;
    }

    private void aJj() {
        if (this.msL == null) {
            this.msL = (FavSearchActionView) View.inflate(this.mController.xIM, R.i.dhJ, null);
            this.msW = this.msL.findViewById(R.h.bIb);
            this.msW.setOnClickListener(new 9(this));
            this.msX = (ImageButton) this.msL.findViewById(R.h.cJt);
            this.msX.setVisibility(8);
            this.msL.mvj = new FavSearchActionView.a(this) {
                final /* synthetic */ FavSearchUI mth;

                {
                    this.mth = r1;
                }

                public final void Xs() {
                    x.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
                    FavSearchUI.c(this.mth);
                }

                public final void a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
                    x.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[]{list, list2, list3});
                    this.mth.msT = list2;
                    this.mth.msU = list3;
                    this.mth.msS = list;
                    this.mth.msK.aM(list3);
                    if (z) {
                        FavSearchUI.c(this.mth);
                        FavSearchUI.a(this.mth, list, list2, list3);
                        return;
                    }
                    this.mth.mrZ.c(list, list2, list3);
                    FavSearchUI.a(this.mth, true);
                    FavSearchUI.a(this.mth, list, list2, list3);
                }

                public final void b(final List<Integer> list, final List<String> list2, final List<String> list3) {
                    this.mth.msL.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass10 mtp;

                        public final void run() {
                            FavSearchUI.a(this.mtp.mth, list, list2, list3);
                            x.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[]{list, list2, list3});
                            this.mtp.mth.msT = list2;
                            this.mtp.mth.msU = list3;
                            this.mtp.mth.msS = list;
                            this.mtp.mth.msK.aM(list3);
                            this.mtp.mth.mrZ.c(list, list2, list3);
                            FavSearchUI.a(this.mtp.mth, false);
                        }
                    });
                }
            };
        }
    }

    protected void onResume() {
        long j = 0;
        this.mrZ.aJu();
        this.mrZ.notifyDataSetChanged();
        FavCapacityPanel favCapacityPanel = this.msP;
        if (favCapacityPanel.muJ != j.aIK() / 1048576) {
            favCapacityPanel.muJ = j.aIK() / 1048576;
            TextView textView = favCapacityPanel.muK;
            Context context = favCapacityPanel.muK.getContext();
            int i = R.l.eex;
            Object[] objArr = new Object[2];
            if (favCapacityPanel.muM - favCapacityPanel.muJ > 0) {
                j = favCapacityPanel.muM - favCapacityPanel.muJ;
            }
            objArr[0] = Long.valueOf(j);
            objArr[1] = Long.valueOf(favCapacityPanel.muJ);
            textView.setText(context.getString(i, objArr));
        }
        super.onResume();
    }
}
