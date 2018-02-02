package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bc.l;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.webview.fts.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.FTSEditTextView.a;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSBaseWebViewUI extends BaseSearchWebviewUI implements a, com.tencent.mm.ui.fts.widget.a.a {
    public com.tencent.mm.ui.fts.widget.a qca;
    int scene;
    private boolean tBI;
    private boolean tCE;
    private b tCj;
    int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tCj = new b(this.mController.xIM, this.ptK);
    }

    public void akN() {
        super.akN();
        String trim = bh.az(getIntent().getStringExtra("ftsQuery"), "").trim();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 3);
        this.tBI = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.tCE = getIntent().getBooleanExtra("ftscaneditable", true);
        this.ptK.setWebViewClient(new b(this, (byte) 0));
        this.ptK.setOnTouchListener(new 1(this));
        if (this.tCE) {
            this.qca = new com.tencent.mm.ui.fts.widget.a(this);
            this.qca.zeu = this;
            this.qca.zet.LW(getHint());
            this.qca.zet.zdX = this;
            getSupportActionBar().setCustomView(this.qca);
            if (!bh.ov(trim)) {
                this.qca.zet.t(trim, null);
            }
            if (this.tBI) {
                this.qca.zet.cxa();
                this.qca.zet.cwZ();
            }
        }
        showOptionMenu(false);
        if (this.tAe != null) {
            this.tAe.kr(true);
        }
        this.ptK.setOnLongClickListener(new 5(this));
        this.tCj.tlx = this.tlx;
    }

    private void bTr() {
        aWs();
        finish();
    }

    protected final int bSJ() {
        return R.g.byy;
    }

    protected final boolean bSV() {
        return true;
    }

    protected final String bTC() {
        return this.qca.zet.bTC();
    }

    protected final String bTE() {
        return this.qca.zet.bTE();
    }

    protected final boolean bSK() {
        return false;
    }

    public final void bpZ() {
        bTr();
    }

    public final void bqa() {
        if (!this.qca.zet.yig.hasFocus()) {
            this.qca.zet.cxa();
            showVKB();
        }
    }

    protected void onResume() {
        super.onResume();
        this.tCj.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.tCj.onPause();
    }

    public void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
        x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[]{str, str2, bVar});
        if (bVar == FTSEditTextView.b.zea || bVar == FTSEditTextView.b.zeb) {
            this.handler.post(new 6(this));
        }
    }

    public final void hL(boolean z) {
        if (z) {
            this.handler.post(new 7(this));
        }
    }

    public final void cs(View view) {
        if (this.qca != null) {
            if (!this.qca.zet.yig.hasFocus()) {
                this.qca.zet.cxa();
                showVKB();
            }
            this.qca.zet.LW(getHint());
        }
    }

    public boolean akL() {
        x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onSearchKeyDown");
        if (bTC().length() > 0) {
            this.handler.post(new 8(this));
            aWs();
        }
        return false;
    }

    public final JSONArray bTF() {
        List<com.tencent.mm.ui.fts.widget.a.b> list = this.qca.zet.rGZ;
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.ui.fts.widget.a.b bVar : list) {
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

    public void h(int i, Bundle bundle) {
        int i2 = 0;
        String string;
        String string2;
        switch (i) {
            case 60:
                b.bPe();
                l.lW("");
                this.tCj.a(bundle, this.scene);
                return;
            case 61:
                this.tCj.M(bundle);
                return;
            case 62:
                this.tCj.N(bundle);
                return;
            case 119:
                string = bundle.getString("fts_key_json_data");
                string2 = bundle.getString("fts_key_req_id");
                this.handler.post(new 10(this, string, bundle.getBoolean("fts_key_new_query", true), string2));
                return;
            case 120:
                this.handler.post(new 11(this, bundle.getInt("fts_key_ret", 0), bundle.getString("fts_key_data")));
                return;
            case 121:
                string2 = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI tCF;

                    public final void run() {
                        if (this.tCF.tlx != null) {
                            this.tCF.tlx.g(i3, string2, i2);
                        }
                    }
                });
                return;
            case 122:
                string2 = bundle.getString("fts_key_new_query");
                String string3 = bundle.getString("fts_key_custom_query");
                boolean z = bundle.getBoolean("fts_key_need_keyboard", false);
                String string4 = bundle.getString("fts_key_tag_list");
                x.i("MicroMsg.FTS.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[]{string2, Boolean.valueOf(z)});
                List arrayList = new ArrayList();
                try {
                    if (!bh.ov(string4)) {
                        JSONArray jSONArray = new JSONArray(string4);
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
                if (this.qca != null) {
                    if (arrayList.size() > 0) {
                        this.qca.zet.t(string3, arrayList);
                    } else {
                        this.qca.zet.t(string2, arrayList);
                    }
                }
                if (z) {
                    this.handler.post(new 2(this));
                    if (this.qca != null) {
                        this.qca.zet.cxa();
                    }
                    bTc();
                    return;
                } else if (this.qca != null) {
                    this.qca.zet.yig.clearFocus();
                    return;
                } else {
                    return;
                }
            case 124:
                this.handler.post(new 3(this, bundle.getString("fts_key_json_data")));
                return;
            case 125:
                this.handler.post(new 4(this, bundle.getString("fts_key_sns_id"), bundle.getInt("fts_key_status", 0)));
                return;
            case FileUtils.S_IWUSR /*128*/:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                Map hashMap = new HashMap();
                for (String string5 : bundle.keySet()) {
                    hashMap.put(string5, bundle.get(string5));
                }
                this.handler.post(new 9(this, hashMap));
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

    protected String getHint() {
        return null;
    }

    protected final int getLayoutId() {
        return R.i.djn;
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
}
