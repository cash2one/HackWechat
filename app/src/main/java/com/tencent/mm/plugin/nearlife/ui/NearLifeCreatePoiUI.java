package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public class NearLifeCreatePoiUI extends MMActivity implements e {
    private TextWatcher XD = new 7(this);
    private String iRN;
    private r jmO;
    private aog oQN;
    private String oQO;
    private String oQP;
    private Addr oQQ;
    private String oQR;
    private EditText oQS;
    private EditText oQT;
    private TextView oQU;
    private TextView oQV;
    private b oQW;
    private com.tencent.mm.plugin.nearlife.b.b oQX;
    private OnClickListener oQY = new 1(this);
    private OnClickListener oQZ = new 2(this);
    private OnClickListener oRa = new 3(this);
    private OnMenuItemClickListener oRb = new 4(this);
    private a oRc = new 5(this);
    private OnMenuItemClickListener oRd = new 6(this);

    static /* synthetic */ LinkedList g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(R.h.cTq)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new bdo().UA(charSequence));
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(650, this);
        this.oQN = new aog();
        this.oQN.vQu = getIntent().getFloatExtra("get_lat", -85.0f);
        this.oQN.vQt = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.oQN.wcr = getIntent().getIntExtra("get_preci", 0);
        this.oQN.wct = "";
        this.oQN.wcu = 0;
        this.oQN.wcs = "";
        this.oQW = b.ON();
        if (this.oQW != null) {
            this.oQW.a((double) this.oQN.vQu, (double) this.oQN.vQt, this.oRc);
        }
        this.iRN = getIntent().getStringExtra("search_id");
        x.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[]{this.iRN});
        initView();
    }

    protected final int getLayoutId() {
        return R.i.doE;
    }

    protected final void initView() {
        setMMTitle(R.l.exW);
        ((ViewGroup) findViewById(R.h.cti)).setOnClickListener(this.oQY);
        ((ViewGroup) findViewById(R.h.cth)).setOnClickListener(this.oQZ);
        ((TextView) findViewById(R.h.cTn)).setOnClickListener(this.oRa);
        findViewById(R.h.cTn).setVisibility(8);
        findViewById(R.h.cth).setVisibility(0);
        findViewById(R.h.ctj).setVisibility(0);
        this.oQS = (EditText) findViewById(R.h.ceP);
        this.oQT = (EditText) findViewById(R.h.ceO);
        this.oQU = (TextView) findViewById(R.h.cTr);
        this.oQV = (TextView) findViewById(R.h.cTq);
        this.oQS.addTextChangedListener(this.XD);
        this.oQT.addTextChangedListener(this.XD);
        this.oQU.addTextChangedListener(this.XD);
        Object az = bh.az(getIntent().getStringExtra("get_poi_name"), "");
        if (az.length() != 0) {
            this.oQS.setText(az);
            this.oQS.setSelection(az.length());
        }
        c.d(this.oQS).GN(100).a(null);
        c.d(this.oQT).GN(400).a(null);
        c.d((EditText) findViewById(R.h.ceQ)).GN(100).a(null);
        a(0, getString(R.l.dFl), this.oRb, p.b.xJz);
        enableOptionMenu(0, false);
        setBackBtn(this.oRd);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!bh.ov(stringExtra)) {
                    ((TextView) findViewById(R.h.cTr)).setText(stringExtra.replace(" ", ""));
                    return;
                }
                return;
            case 2:
                if (-1 == i2 && intent != null) {
                    this.oQV.setText(bh.ou(intent.getStringExtra("poi_category")));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(650, this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != keyEvent.getKeyCode()) {
            return super.onKeyDown(i, keyEvent);
        }
        bfj();
        return true;
    }

    private void bfj() {
        h.a(this, R.l.exT, R.l.exW, new 8(this), null);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            this.jmO.dismiss();
            com.tencent.mm.plugin.nearlife.b.b bVar = (com.tencent.mm.plugin.nearlife.b.b) kVar;
            Intent intent = new Intent();
            if (this.oQN != null) {
                intent.putExtra("get_lat", this.oQN.vQu);
                intent.putExtra("get_lng", this.oQN.vQt);
            }
            if (this.oQQ != null) {
                intent.putExtra("get_city", this.oQQ.hxw);
            }
            intent.putExtra("get_poi_address", this.oQP);
            intent.putExtra("get_poi_classify_id", bVar.oPE);
            intent.putExtra("get_poi_name", this.oQO);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            return;
        }
        this.jmO.dismiss();
        Toast.makeText(this.mController.xIM, getString(R.l.exU), 1).show();
        this.oQX = null;
    }
}
