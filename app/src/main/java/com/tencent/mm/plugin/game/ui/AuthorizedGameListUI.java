package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public class AuthorizedGameListUI extends MMActivity implements OnItemClickListener, t {
    public static int nkO = 1;
    public static int nkP = 2;
    public static int nkQ = 4;
    public static int nkR = 5;
    public static int nkS = 6;
    private ProgressDialog iln = null;
    private int ndn = 0;
    private ListView nkK;
    private a nkL;
    private View nkM;
    private int nkN = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
        SubCoreGameCenter.aRi().a(3, (t) this);
        initView();
        k xVar = new x(3, new aw(w.d(getSharedPreferences(ac.cfs(), 0))));
        ar.CG().a(xVar, 0);
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dHc), true, new 3(this, xVar));
    }

    protected void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.cmH;
    }

    protected final void initView() {
        this.nkK = (ListView) findViewById(R.h.cmI);
        this.nkM = findViewById(R.h.cej);
        this.nkL = new a(this);
        this.nkL.nkV = new 1(this);
        this.nkK.setVerticalScrollBarEnabled(false);
        this.nkK.setOnItemClickListener(this);
        this.nkK.setAdapter(this.nkL);
        setMMTitle(R.l.emz);
        setBackBtn(new 2(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        SubCoreGameCenter.aRi().b(3, this);
        if (this.nkL != null) {
            this.nkL.clear();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this, GameSettingsUI.class);
        this.nkN = i;
        intent.putExtra("game_app_id", ((dt) this.nkL.getItem(i)).nfn);
        intent.putExtra("game_report_from_scene", this.ndn);
        startActivityForResult(intent, 0);
        ap.a(this, 10, 1008, nkP, 6, this.ndn, null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AuthorizedGameListUI", "invaild requestcode" + i);
            return;
        }
        if (i2 == -1) {
            this.nkL.remove(this.nkN);
            ap.a(this.mController.xIM, 10, 1008, nkQ, 21, 1, intent.getStringExtra("game_app_id"), this.ndn, 0, null, null, null);
        }
        if (this.nkL != null) {
            this.nkL.notifyDataSetChanged();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.w wVar) {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (i == 0 && i2 == 0) {
            LinkedList linkedList = ((yg) ((aw) wVar).lMW.hmh.hmo).wiA;
            if (linkedList == null || linkedList.size() == 0) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AuthorizedGameListUI", "no authapp");
            }
            this.nkL.O(linkedList);
            return;
        }
        Toast.makeText(this, getString(R.l.emx, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
