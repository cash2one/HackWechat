package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.a.d;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.b;
import java.util.List;

public class FavTagEditUI extends MMActivity {
    private FavTagPanel mtA;
    private ListView mtB;
    private ListView mtC;
    private TextView mtD;
    private c mtE;
    private d mtF;
    private boolean mtG;
    private f mtx;
    private List<String> mty;
    private FavTagPanel mtz;

    protected final int getLayoutId() {
        return R.i.dhL;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra("key_fav_item_id", -1);
        if (-1 != longExtra) {
            this.mtx = h.getFavItemInfoStorage().db(longExtra);
        }
        this.mty = getIntent().getStringArrayListExtra("key_fav_result_list");
        this.mtA = (FavTagPanel) findViewById(R.h.chj);
        this.mtB = (ListView) findViewById(R.h.cQe);
        this.mtC = (ListView) findViewById(R.h.cKb);
        this.mtD = (TextView) findViewById(R.h.cvu);
        this.mtA.ms(true);
        this.mtA.EP(R.g.bGB);
        this.mtA.ydP = true;
        this.mtA.ydL = new 5(this);
        this.mtA.postDelayed(new 6(this), 100);
        if (this.mtx != null) {
            this.mtA.a(this.mtx.field_tagProto.wfj, this.mtx.field_tagProto.wfj);
        } else if (this.mty != null) {
            this.mtA.a(this.mty, this.mty);
        }
        this.mtE = new 7(this, this.mController.xIM);
        this.mtE.aM(this.mtx == null ? null : this.mtx.field_tagProto.wfj);
        if (!(this.mtx == null || this.mtx.field_tagProto.wfi.isEmpty())) {
            View inflate = View.inflate(this.mController.xIM, R.i.dhO, null);
            TextView textView = (TextView) inflate.findViewById(R.h.cgS);
            textView.setText(getString(R.l.egf));
            textView.setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bva);
            this.mtz = (FavTagPanel) inflate.findViewById(R.h.chl);
            this.mtz.setVisibility(0);
            this.mtz.a(this.mtx.field_tagProto.wfj, this.mtx.field_tagProto.wfi);
            this.mtz.setBackgroundResource(R.g.bDq);
            this.mtz.setPadding(0, 0, 0, dimensionPixelSize);
            this.mtz.ydL = new 8(this);
            this.mtB.addHeaderView(inflate);
        }
        if (h.aIq().aIx() > 0) {
            this.mtB.addHeaderView(View.inflate(this.mController.xIM, R.i.dhN, null));
        }
        this.mtB.setAdapter(this.mtE);
        this.mtB.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavTagEditUI mtH;

            {
                this.mtH = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.mtH.mtA.cpG();
                return false;
            }
        });
        this.mtF = new 10(this, this.mController.xIM);
        this.mtC.setAdapter(this.mtF);
        this.mtC.setOnTouchListener(new 2(this));
        setMMTitle(R.l.eeY);
        setBackBtn(new 1(this));
        a(0, getString(R.l.dFl), new 3(this, longExtra), b.xJz);
        aJk();
        h.aIq().a(this.mtE);
    }

    private void aJk() {
        if (this.mtG) {
            x.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
            if (cmT()) {
                enableOptionMenu(0, false);
            }
        } else if (this.mtx == null) {
            if (this.mtA.wfh.size() > 0 || this.mtA.cpC().length() > 0) {
                if (!cmT()) {
                    enableOptionMenu(0, true);
                }
            } else if (cmT()) {
                enableOptionMenu(0, false);
            }
        } else if (this.mtx.field_tagProto.wfj.size() == this.mtA.wfh.size() && this.mtA.cpC().length() <= 0) {
            List cpH = this.mtA.cpH();
            int i = 0;
            while (i < cpH.size()) {
                if (((String) cpH.get(i)).equals(this.mtx.field_tagProto.wfj.get(i))) {
                    i++;
                } else if (!cmT()) {
                    enableOptionMenu(0, true);
                    return;
                } else {
                    return;
                }
            }
            if (cmT()) {
                enableOptionMenu(0, false);
            }
        } else if (!cmT()) {
            enableOptionMenu(0, true);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.favorite.a.f aIq = h.aIq();
        c cVar = this.mtE;
        if (cVar != null) {
            aIq.hxK.remove(cVar.toString());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aJl();
        return true;
    }

    private void aJl() {
        com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.ege), "", getString(R.l.dDM), getString(R.l.dEn), new 4(this), null);
    }
}
