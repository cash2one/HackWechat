package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bc.l;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.webview.fts.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.FTSEditTextView$a;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.mm.ui.fts.widget.a;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSOSWebViewUI extends BaseSearchWebviewUI implements FTSEditTextView$a {
    protected ImageButton oNG;
    protected View qgW;
    private boolean tBI;
    View tCf;
    protected SOSEditTextView tCg;
    private List<c> tCh;
    protected int tCi = 0;
    private b tCj;
    boolean tCk;
    boolean tCl;

    protected class c {
        List<a.b> rGZ;
        final /* synthetic */ BaseSOSWebViewUI tCm;
        String tCt = "";
        String tCu = "";
        Map<String, Object> tCv = new HashMap();
        int type;

        protected c(BaseSOSWebViewUI baseSOSWebViewUI) {
            this.tCm = baseSOSWebViewUI;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.type == this.type && cVar.tCu.equals(this.tCu)) {
                return true;
            }
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        this.tCj = new b(this.mController.xIM, this.ptK);
    }

    protected final int bSA() {
        return this.jNd;
    }

    protected void akN() {
        super.akN();
        this.tBI = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.tCf = findViewById(R.h.cJJ);
        this.tCg = (SOSEditTextView) findViewById(R.h.cOW);
        this.tCg.zdX = this;
        this.tCg.LW(getHint());
        this.qgW = findViewById(R.h.bPo);
        this.qgW.setOnClickListener(new 1(this));
        this.oNG = (ImageButton) findViewById(R.h.bLT);
        this.oNG.setOnClickListener(new 10(this));
        this.ptK.setWebViewClient(new b(this, (byte) 0));
        this.ptK.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ BaseSOSWebViewUI tCm;

            {
                this.tCm = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.tCm.bTy().yig.clearFocus();
                this.tCm.aWs();
                return false;
            }
        });
        if (this.tAe != null) {
            this.tAe.kr(true);
        }
        this.ptK.setOnLongClickListener(new 12(this));
        this.tCj.tlx = this.tlx;
    }

    protected void onResume() {
        super.onResume();
        this.tCj.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.tCj.onPause();
    }

    public final String bPL() {
        return this.fqu;
    }

    protected final void bTr() {
        aWs();
        if (this.tCh != null && this.tCh.size() > 1) {
            this.tCh.remove(0);
            c cVar = (c) this.tCh.get(0);
            this.tCg.t(cVar.tCu, cVar.rGZ);
            this.handler.post(new 13(this, cVar));
        } else if (this.tCk) {
            bTu();
        } else {
            finish();
        }
    }

    protected void bTs() {
    }

    protected void bTt() {
    }

    protected void bTu() {
        this.tCg.t("", null);
        aWs();
        this.handler.post(new 14(this));
        this.tCh = null;
        this.tCk = false;
        this.tCj.onDestroy();
    }

    protected final boolean bSV() {
        return true;
    }

    public final void bqa() {
        if (!this.tCg.yig.hasFocus()) {
            this.tCg.cxa();
            showVKB();
        }
    }

    protected final boolean bSK() {
        return false;
    }

    protected final int getType() {
        return this.type;
    }

    protected final int aRr() {
        return this.scene;
    }

    public void a(String str, String str2, List<a.b> list, FTSEditTextView.b bVar) {
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[]{str, str2, bVar});
        if (bVar == FTSEditTextView.b.zea || bVar == FTSEditTextView.b.zeb) {
            this.handler.post(new 15(this));
        }
    }

    public void hL(boolean z) {
        if (z && !bh.ov(this.tCg.bTC())) {
            this.handler.post(new 16(this));
        }
    }

    public final void cs(View view) {
        if (this.tCg != null) {
            if (!this.tCg.yig.hasFocus()) {
                this.tCg.cxa();
                showVKB();
            }
            this.tCg.LW(getHint());
        }
    }

    protected String getHint() {
        return null;
    }

    public boolean akL() {
        this.tCg.yig.clearFocus();
        aWs();
        if (this.tCg.bTC().length() > 0) {
            this.handler.post(new 17(this));
            aWs();
            this.tCk = true;
        }
        return true;
    }

    protected void bTv() {
    }

    protected String bTw() {
        return "";
    }

    protected int bTx() {
        return 0;
    }

    public final SOSEditTextView bTy() {
        return this.tCg;
    }

    protected static boolean bTz() {
        return true;
    }

    protected static boolean bTA() {
        return true;
    }

    protected final boolean bTa() {
        return false;
    }

    protected final void bSG() {
        bTr();
    }

    public void onDestroy() {
        try {
            if (this.juQ != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.juQ.h(1, bundle);
            }
            this.tCj.onDestroy();
        } catch (RemoteException e) {
        }
        aWs();
        super.onDestroy();
    }

    protected void h(int i, Bundle bundle) {
        int i2 = 0;
        String string;
        switch (i) {
            case 60:
                b.bPe();
                l.lW("");
                if (bTG()) {
                    this.tCj.a(bundle, this.scene);
                    return;
                } else {
                    x.w("MicroMsg.FTS.BaseSOSWebViewUI", "current state is not search");
                    return;
                }
            case 61:
                this.tCj.M(bundle);
                return;
            case 62:
                this.tCj.N(bundle);
                return;
            case 119:
                String string2 = bundle.getString("fts_key_json_data");
                String string3 = bundle.getString("fts_key_req_id");
                boolean z = bundle.getBoolean("fts_key_new_query", true);
                this.handler.post(new 3(this, bundle.getBundle("fts_key_data"), string2, z, string3));
                return;
            case 120:
                this.handler.post(new 5(this, bundle.getInt("fts_key_ret", 0), bundle.getString("fts_key_data")));
                return;
            case 121:
                string = bundle.getString("fts_key_json_data");
                this.handler.post(new 6(this, bundle.getInt("fts_key_teach_request_type", 0), string, bundle.getInt("fts_key_is_cache_data", 0)));
                return;
            case 122:
                string = bundle.getString("fts_key_new_query");
                String string4 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string5 = bundle.getString("fts_key_tag_list");
                x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[]{string, Boolean.valueOf(z2)});
                List arrayList = new ArrayList();
                try {
                    if (!bh.ov(string5)) {
                        JSONArray jSONArray = new JSONArray(string5);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            a aVar = new a(this);
                            aVar.tCr = jSONObject.getString("tagName");
                            aVar.tCs = jSONObject.getInt("tagType");
                            aVar.userName = jSONObject.getString("userName");
                            arrayList.add(aVar);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.tCg != null) {
                    if (arrayList.size() > 0) {
                        this.tCg.t(string4, arrayList);
                    } else {
                        this.tCg.t(string, arrayList);
                        this.tCg.cxd();
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ BaseSOSWebViewUI tCm;

                        {
                            this.tCm = r1;
                        }

                        public final void run() {
                            if (this.tCm.tlx != null) {
                                this.tCm.tlx.b(this.tCm.bTC(), this.tCm.bTE(), this.tCm.bTF());
                            }
                        }
                    });
                    if (this.tCg != null) {
                        this.tCg.cxa();
                    }
                    bTc();
                    return;
                } else if (this.tCg != null) {
                    this.tCg.yig.clearFocus();
                    return;
                } else {
                    return;
                }
            case 124:
                this.handler.post(new 8(this, bundle.getString("fts_key_json_data")));
                return;
            case 125:
                this.handler.post(new 9(this, bundle.getString("fts_key_sns_id"), bundle.getInt("fts_key_status", 0)));
                return;
            case FileUtils.S_IWUSR /*128*/:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                Map hashMap = new HashMap();
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                this.handler.post(new 2(this, hashMap));
                return;
            case 138:
                string = bundle.getString("fts_key_data");
                if (bh.ov(string)) {
                    this.tCi = 0;
                    return;
                } else if ("index".equals(string)) {
                    this.tCi = 1;
                    return;
                } else if ("result".equals(string)) {
                    this.tCi = 2;
                    return;
                } else if ("suggestion".equals(string)) {
                    this.tCi = 3;
                    return;
                } else if ("teach".equals(string)) {
                    this.tCi = 4;
                    return;
                } else if ("local".equals(string)) {
                    this.tCi = 5;
                    return;
                } else {
                    this.tCi = 0;
                    return;
                }
            case 143:
                this.handler.post(new 4(this, bundle.getString(SlookAirButtonFrequentContactAdapter.DATA)));
                return;
            case e.CTRL_INDEX /*144*/:
                b.bPe();
                l.lV(bundle.getString("appid"));
                return;
            case 100001:
                this.tCj.L(bundle);
                return;
            default:
                super.h(i, bundle);
                return;
        }
    }

    protected final b bTB() {
        return this.tCj;
    }

    protected final String bTC() {
        return this.tCg.bTC();
    }

    protected final int bTD() {
        return this.tCA;
    }

    protected final String bTE() {
        return this.tCg.bTE();
    }

    public final JSONArray bTF() {
        List<a.b> list = this.tCg.rGZ;
        JSONArray jSONArray = new JSONArray();
        for (a.b bVar : list) {
            a aVar = (a) bVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", aVar.tCr);
                jSONObject.put("tagType", aVar.tCs);
                jSONObject.put("userName", aVar.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        return jSONArray;
    }

    public void onBackPressed() {
        bTr();
    }

    protected final void b(int i, String str, Map<String, Object> map) {
        c cVar;
        x.v("MicroMsg.FTS.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", new Object[]{Integer.valueOf(i), str, map});
        if (this.tCh == null) {
            this.tCh = new ArrayList();
        }
        if (bTC().length() > 0) {
            cVar = new c(this);
            cVar.type = this.tCA;
            cVar.rGZ = new ArrayList(this.tCg.rGZ);
            cVar.tCu = this.tCg.bTE();
            cVar.tCt = this.tCg.bTC();
            if (this.tCh.size() == 0) {
                this.tCh.add(cVar);
            } else if (!cVar.equals((c) this.tCh.get(0))) {
                this.tCh.add(0, cVar);
            }
        }
        if (this.tCh != null && !this.tCh.isEmpty()) {
            c cVar2 = (c) this.tCh.get(0);
            cVar = new c(this);
            cVar.type = i;
            cVar.tCt = str;
            cVar.tCv = map;
            if (cVar2 != null) {
                int i2;
                if (cVar2 == cVar) {
                    i2 = 1;
                } else {
                    cVar = cVar;
                    i2 = (cVar.type == cVar2.type && cVar.tCt.trim().equals(cVar2.tCt.trim())) ? 1 : 0;
                }
                if (i2 != 0) {
                    cVar2.tCv = map;
                }
            }
        }
    }

    protected boolean bTG() {
        return true;
    }

    public final String AP(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle o = this.juQ.o(2, bundle);
            String string = o.getString("result");
            String string2 = o.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            JSONArray optJSONArray = new JSONObject(string).optJSONArray("items");
            if (optJSONArray == null) {
                return "";
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject.optInt("businessType") == i) {
                    return optJSONObject.optString("hotword");
                }
            }
            return "";
        } catch (Exception e) {
        }
    }
}
