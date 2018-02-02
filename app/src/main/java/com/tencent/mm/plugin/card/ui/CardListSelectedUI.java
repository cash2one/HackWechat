package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.a.j$a;
import com.tencent.mm.plugin.card.a.j$b;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

public class CardListSelectedUI extends MMActivity implements e, j$a {
    private ListView Fv;
    private r jmO = null;
    private int kFm = 0;
    private String kJN;
    private String kJT;
    com.tencent.mm.bq.b kMm = null;
    boolean kMn = true;
    private boolean kOW = false;
    private BaseAdapter kPo;
    private String kQj = "";
    private String kQk;
    private TextView kTS;
    private RelativeLayout kTT;
    private TextView kTU;
    private TextView kTV;
    boolean kTW = false;
    LinkedList<a> kTX = new LinkedList();
    HashMap<Integer, Boolean> kTY = new HashMap();
    private boolean kTZ;
    private boolean kUa;
    private boolean kUb;
    private int kUc;
    private String kUd;
    private String kUe;
    private String kUf;
    private String kUg;
    private int kUh;
    public String kUi;
    private boolean kUj = false;
    private a kUk;
    private View kgl;
    private int time_stamp;

    class b extends BaseAdapter {
        final /* synthetic */ CardListSelectedUI kUl;

        b(CardListSelectedUI cardListSelectedUI) {
            this.kUl = cardListSelectedUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return nV(i);
        }

        public final int getCount() {
            return this.kUl.kTX.size();
        }

        private a nV(int i) {
            return (a) this.kUl.kTX.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            a nV = nV(i);
            if (view == null) {
                view = View.inflate(this.kUl, R.i.dcz, null);
                cVar = new c(this.kUl);
                cVar.kUm = (ImageView) view.findViewById(R.h.bRX);
                cVar.kUn = (TextView) view.findViewById(R.h.cqF);
                cVar.jpW = (TextView) view.findViewById(R.h.title);
                cVar.kUo = (TextView) view.findViewById(R.h.cPA);
                cVar.kUp = view.findViewById(R.h.cUr);
                cVar.kUq = (TextView) view.findViewById(R.h.cqJ);
                cVar.kUr = (TextView) view.findViewById(R.h.cqx);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (l.nG(nV.kJO)) {
                if (TextUtils.isEmpty(nV.title)) {
                    cVar.jpW.setVisibility(8);
                } else {
                    cVar.jpW.setVisibility(0);
                    cVar.jpW.setText(nV.title);
                }
                if (TextUtils.isEmpty(nV.kJQ)) {
                    cVar.kUo.setVisibility(8);
                } else {
                    cVar.kUo.setVisibility(0);
                    cVar.kUo.setText(nV.kJQ);
                }
                if (nV.kJV == 0) {
                    view.setAlpha(1.0f);
                    cVar.kUm.setVisibility(0);
                    cVar.kUn.setVisibility(8);
                    Boolean bool = (Boolean) this.kUl.kTY.get(Integer.valueOf(i));
                    if (bool == null || !bool.booleanValue()) {
                        cVar.kUm.setImageResource(R.g.bAm);
                    } else {
                        cVar.kUm.setImageResource(R.g.bAl);
                    }
                } else if (nV.kJV == 1) {
                    view.setAlpha(0.2f);
                    cVar.kUm.setVisibility(8);
                    if (bh.ov(nV.kJY)) {
                        cVar.kUn.setVisibility(8);
                    } else {
                        cVar.kUn.setVisibility(0);
                        cVar.kUn.setText(nV.kJY);
                    }
                } else {
                    cVar.kUm.setVisibility(8);
                    cVar.kUn.setVisibility(8);
                }
                if (bh.ov(nV.kJW)) {
                    cVar.kUq.setVisibility(8);
                } else {
                    cVar.kUq.setVisibility(0);
                    cVar.kUq.setText(nV.kJW);
                }
                if (bh.ov(nV.kJX)) {
                    cVar.kUr.setVisibility(8);
                } else {
                    cVar.kUr.setVisibility(0);
                    cVar.kUr.setText(nV.kJX);
                }
                if (bh.ov(nV.kJW) && bh.ov(nV.kJX)) {
                    cVar.kUp.setVisibility(8);
                } else {
                    cVar.kUp.setVisibility(0);
                }
            } else {
                x.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            return view;
        }
    }

    static /* synthetic */ void d(CardListSelectedUI cardListSelectedUI) {
        for (int i = 0; i < cardListSelectedUI.kTX.size(); i++) {
            Boolean bool = (Boolean) cardListSelectedUI.kTY.get(Integer.valueOf(i));
            if (bool != null && bool.booleanValue()) {
                cardListSelectedUI.enableOptionMenu(true);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dcp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        am.auM().a(this);
        Intent intent = getIntent();
        x.i("MicroMsg.CardListSelectedUI", "initData()");
        if (intent == null) {
            x.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
            setResult(1);
            T(1, "");
            finish();
        } else {
            this.kFm = intent.getIntExtra("key_from_scene", 0);
            x.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.kFm);
            this.kJT = intent.getStringExtra("app_id");
            this.kUc = intent.getIntExtra("shop_id", 0);
            this.kUd = intent.getStringExtra("sign_type");
            this.kUe = intent.getStringExtra("card_sign");
            this.time_stamp = intent.getIntExtra("time_stamp", 0);
            this.kUf = intent.getStringExtra("nonce_str");
            this.kJN = intent.getStringExtra("card_tp_id");
            this.kUg = intent.getStringExtra("card_type");
            this.kUh = intent.getIntExtra("can_multi_select", 0);
            this.kQj = intent.getStringExtra("key_package_name");
            this.kQk = intent.getStringExtra("key_transaction");
            x.i("MicroMsg.CardListSelectedUI", "app_id:" + this.kJT + " shop_id:" + this.kUc + " sign_type:" + this.kUd + " time_stamp:" + this.time_stamp);
            x.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.kUf + " card_tp_id:" + this.kJN + " card_type:" + this.kUg + " canMultiSelect:" + this.kUh + " packateName:" + this.kQj);
            if ("INVOICE".equalsIgnoreCase(this.kUg)) {
                this.kUj = true;
            }
            if (TextUtils.isEmpty(this.kJT) || TextUtils.isEmpty(this.kUe)) {
                x.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
                setResult(1);
                T(1, "app_id  or card_sign is empty!");
                finish();
            }
        }
        awb();
        initView();
    }

    private void awb() {
        if (this.kOW) {
            x.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
            return;
        }
        if (this.kMm == null) {
            this.kTZ = false;
            this.kUa = false;
            this.kUb = false;
        }
        ar.CG().a(664, this);
        ar.CG().a(new aj(this.kJT, this.kUc, this.kUd, this.kUe, this.time_stamp, this.kUf, this.kJN, this.kUg, this.kMm), 0);
        dY(true);
        this.kOW = true;
        if (this.kUh == 1) {
            this.kTW = true;
        }
    }

    protected final void initView() {
        if (this.kUj) {
            setMMTitle(R.l.dOy);
        } else {
            setMMTitle(R.l.dOx);
        }
        setBackBtn(new 1(this));
        if (!this.kUj) {
            addTextOptionMenu(0, getString(R.l.dFl), new 2(this));
            enableOptionMenu(false);
        }
        this.Fv = (ListView) findViewById(R.h.bRf);
        if (this.kUj) {
            this.kPo = new b(this);
        } else {
            this.kPo = new a(this);
        }
        this.Fv.setAdapter(this.kPo);
        this.Fv.setOnItemClickListener(new 3(this));
        this.Fv.setOnScrollListener(new 4(this));
        this.kgl = findViewById(R.h.bYR);
        this.kTS = (TextView) findViewById(R.h.cAr);
        if (this.kUj) {
            this.kTS.setText(getString(R.l.dOY));
        }
        this.kTT = (RelativeLayout) findViewById(R.h.cqu);
        this.kTU = (TextView) findViewById(R.h.cqL);
        this.kTV = (TextView) findViewById(R.h.cqG);
        if (this.kUj) {
            this.kTT.setVisibility(0);
            this.kTU.setOnClickListener(new 5(this));
            this.kTV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardListSelectedUI kUl;

                {
                    this.kUl = r1;
                }

                public final void onClick(View view) {
                    this.kUl.avF();
                }
            });
            return;
        }
        this.kTT.setVisibility(8);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof aj) {
            ar.CG().b(664, this);
            dY(false);
            if (i == 0 && i2 == 0) {
                int size;
                String str2 = ((aj) kVar).kLN;
                x.d("MicroMsg.CardListSelectedUI", str2);
                Collection wd = a.wd(str2);
                Collection we = a.we(str2);
                this.kUi = wD(str2);
                if (this.kMm == null && !(wd == null && we == null)) {
                    this.kTY.clear();
                    this.kTX.clear();
                }
                if (wd != null) {
                    if (wd.size() > 0 && !this.kTZ) {
                        this.kTZ = true;
                        if (this.kUj) {
                            ((a) wd.get(0)).kFg = getString(R.l.dPe);
                        } else {
                            ((a) wd.get(0)).kFg = getString(R.l.dPd);
                        }
                    }
                    this.kTX.addAll(wd);
                    for (size = this.kTX.size(); size < this.kTX.size(); size++) {
                        this.kTY.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                if (we != null) {
                    if (we.size() > 0 && !this.kUa) {
                        this.kUa = true;
                        ((a) we.get(0)).kFg = getString(R.l.dbT);
                    }
                    this.kTX.addAll(we);
                    for (size = this.kTX.size(); size < this.kTX.size(); size++) {
                        this.kTY.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                this.kMn = ((aj) kVar).kMn;
                this.kMm = ((aj) kVar).kMm;
                this.kPo.notifyDataSetChanged();
            } else {
                d.b(this, str, i2);
            }
            if (this.kTX.size() != 0) {
                this.kgl.setVisibility(8);
                this.Fv.setVisibility(0);
            } else {
                this.kgl.setVisibility(0);
                this.Fv.setVisibility(8);
            }
            this.kOW = false;
        }
    }

    private static String wD(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = new JSONObject(str).optString("rule_url");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CardListSelectedUI", e, "", new Object[0]);
            }
        }
        return str2;
    }

    public final void b(String str, j$b com_tencent_mm_plugin_card_a_j_b) {
        dY(false);
        if (TextUtils.isEmpty(str) || str.equals(this.kUk.kJU)) {
            x.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
            x.i("MicroMsg.CardListSelectedUI", "markSucc:" + com_tencent_mm_plugin_card_a_j_b.kJB + " markCardId: " + com_tencent_mm_plugin_card_a_j_b.kJC);
            if (com_tencent_mm_plugin_card_a_j_b.kJB == 1) {
                if (TextUtils.isEmpty(com_tencent_mm_plugin_card_a_j_b.kJC) || str.equals(com_tencent_mm_plugin_card_a_j_b.kJC)) {
                    x.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
                } else {
                    x.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
                    int i = 0;
                    while (i < this.kTX.size()) {
                        if (((a) this.kTX.get(i)).kJU == com_tencent_mm_plugin_card_a_j_b.kJC) {
                            for (int i2 = 0; i2 < this.kTX.size(); i2++) {
                                this.kTY.put(Integer.valueOf(i2), Boolean.valueOf(false));
                            }
                            this.kTY.put(Integer.valueOf(i), Boolean.valueOf(true));
                        } else {
                            i++;
                        }
                    }
                }
                avF();
                return;
            }
            d.b(this, getString(R.l.dOD));
            return;
        }
        x.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void bO(String str, String str2) {
        dY(false);
        if (TextUtils.isEmpty(str) || str.equals(this.kUk.kJU)) {
            x.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dOC);
            }
            d.b(this, str2);
            return;
        }
        x.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void wa(String str) {
    }

    protected void onDestroy() {
        am.auM().b(this);
        super.onDestroy();
    }

    protected final void dY(boolean z) {
        if (z) {
            this.jmO = r.b(this, getString(R.l.ctB), false, 0, null);
        } else if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }

    private void avF() {
        Intent intent = new Intent();
        String awc = awc();
        if (this.kUj) {
            intent.putExtra("choose_invoice_info", awc);
        } else {
            intent.putExtra("choose_card_info", awc);
        }
        setResult(-1, intent);
        T(-1, awc);
        finish();
    }

    private String awc() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.kTX.size(); i2++) {
            Boolean bool = (Boolean) this.kTY.get(Integer.valueOf(i2));
            if (bool != null && bool.booleanValue()) {
                arrayList.add(this.kTX.get(i2));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (i < arrayList.size()) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            a aVar = (a) arrayList.get(i);
            stringBuilder.append("{");
            stringBuilder.append("\"card_id\":");
            stringBuilder.append("\"" + aVar.kJN + "\"");
            stringBuilder.append(",");
            stringBuilder.append("\"encrypt_code\":");
            stringBuilder.append("\"" + aVar.kJS + "\"");
            if (this.kUj) {
                stringBuilder.append(",");
                stringBuilder.append("\"app_id\":");
                stringBuilder.append("\"" + aVar.kJT + "\"");
            }
            stringBuilder.append("}");
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            T(0, "");
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void T(int i, String str) {
        if (this.kFm != 8) {
            x.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.kFm);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_choose_card_from_wx_card_list", str);
        f aZ = g.aZ(this.kJT, true);
        Resp resp = new Resp(bundle);
        if (aZ != null) {
            resp.openId = aZ.field_openId;
        }
        resp.transaction = this.kQk;
        String str2 = "MicroMsg.CardListSelectedUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.kJT;
        objArr[1] = aZ == null ? "null appinfo" : aZ.field_appName;
        objArr[2] = aZ == null ? "null appinfo" : aZ.field_openId;
        objArr[3] = this.kQk;
        x.i(str2, str3, objArr);
        resp.toBundle(bundle);
        x.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:" + i);
        x.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:" + str);
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kQj;
        args.bundle = bundle;
        p.ae(bundle);
        p.af(bundle);
        MMessageActV2.send(ac.getContext(), args);
    }
}
