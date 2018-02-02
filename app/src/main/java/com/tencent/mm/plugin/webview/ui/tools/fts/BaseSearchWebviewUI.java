package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.webview.fts.a.1;
import com.tencent.mm.plugin.webview.fts.a.2;
import com.tencent.mm.plugin.webview.fts.a.3;
import com.tencent.mm.plugin.webview.fts.a.4;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.fts.c.e;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.32;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.36;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class BaseSearchWebviewUI extends LoadDataWebviewUI implements b {
    protected String fDj;
    protected String iRN;
    private View jCL;
    protected int scene;
    protected int tCA;
    protected String tCB;
    protected List<Runnable> tCC;
    protected boolean tCw;
    private com.tencent.mm.plugin.webview.fts.c.b tCx;
    private Set<a> tCy = new HashSet();
    protected int tCz;
    protected int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.tCw = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
        }
        this.tCx = new com.tencent.mm.plugin.webview.fts.c.b(this.mController.xIM, this.ptK, this);
        this.scene = getIntent().getIntExtra("ftsbizscene", 3);
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.fDj = getIntent().getStringExtra("ftsQuery");
        this.tCB = getIntent().getStringExtra("tabId");
        this.iRN = getIntent().getStringExtra("searchId");
        this.tCA = this.type;
        int i = this.scene;
        String str = this.fqu;
        String str2 = this.tjs;
        boolean z = this.type == 0;
        f.a(1, i, str, str2, this.iRN, 0, z, "", true, this.fDj, this.tCB, this.type, this.tEd);
        if (com.tencent.mm.bc.b.c(this, this.scene)) {
            x.i("BaseSearchWebviewUI", "has location permission");
        } else {
            x.i("BaseSearchWebviewUI", "request for grant location permission");
        }
    }

    protected final void bTH() {
        boolean z;
        super.bTH();
        int i = this.scene;
        String str = this.fqu;
        String str2 = this.tjs;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        String str3 = "";
        String str4 = "";
        f.a(12, i, str, str2, str3, 0, z, str4, true, this.fDj, this.tCB, this.type, this.tEd);
    }

    public void akN() {
        super.akN();
        this.tCx.tlx = this.tlx;
        if (this.tlx == null || this.tlx.tGQ) {
            bTI();
            x.d("BaseSearchWebviewUI", "jsapi ready");
        } else {
            this.tlx.a(new 1(this));
        }
        if (this.juQ != null) {
            try {
                this.juQ.e(51, null);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("BaseSearchWebviewUI", e, "", new Object[0]);
                return;
            }
        }
        x.i("BaseSearchWebviewUI", "invoker is null, fail to invoke get geo");
    }

    private void bTI() {
        if (this.tCC != null && !this.tCC.isEmpty()) {
            x.i("BaseSearchWebviewUI", "jsapi ready callback, running jsapi count %d", new Object[]{Integer.valueOf(new ArrayList(this.tCC).size())});
            this.tCC.clear();
            for (Runnable runnable : r0) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public final void a(a aVar) {
        this.tCy.add(aVar);
    }

    protected void b(int i, String str, Map<String, Object> map) {
    }

    public void h(int i, Bundle bundle) {
        e eVar;
        switch (i) {
            case d.CTRL_INDEX /*133*/:
                X(bundle);
                return;
            case c.CTRL_INDEX /*134*/:
                g gVar = (g) com.tencent.mm.plugin.webview.fts.a.bPd().tln.remove(Integer.valueOf(bundle.getInt("actionSheetId")));
                if (gVar != null) {
                    gVar.bxh();
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX /*135*/:
                b(bundle.getInt("FTS_KEY_onStartWebSearch_type", 0), bundle.getString("FTS_KEY_onStartWebSearch_query"), (Map) bundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                return;
            case 137:
                String string = bundle.getString("fts_key_json_data");
                if (this.tlx != null) {
                    try {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tlx;
                        ag.y(new 32(dVar, i.a.a("onGetMatchContactList", new JSONObject(string), dVar.tGS, dVar.tGT)));
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("BaseSearchWebviewUI", e, "", new Object[0]);
                        return;
                    }
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = this.tlx;
                if (dVar2.tGQ) {
                    x.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
                    Map hashMap = new HashMap();
                    hashMap.put("json", bundle.getString("json"));
                    hashMap.put("searchId", bundle.getString("searchId"));
                    hashMap.put("poiId", bundle.getString("poiId"));
                    ag.y(new 36(dVar2, i.a.a("onGetPoiInfoReturn", hashMap, dVar2.tGS, dVar2.tGT)));
                    return;
                }
                x.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
                return;
            case 100002:
                com.tencent.mm.plugin.webview.fts.b bTB = bTB();
                if (bTB != null) {
                    int i2 = bundle.getInt("x", -1);
                    int i3 = bundle.getInt("y", -1);
                    String string2 = bundle.getString("widgetId");
                    String string3 = bundle.getString("eventId");
                    x.v("FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), string2, string3});
                    View view = (View) bTB.tls.get(string2);
                    if (view != null) {
                        boolean z;
                        j bB = bTB.tlw.bB(view);
                        com.tencent.mm.plugin.webview.fts.b.a.a bVar = new com.tencent.mm.plugin.webview.fts.b.a.b(i2, i3, string3);
                        if (bB == null) {
                            x.e("BaseJsapiEvent", "null JSBridgeAccessible ");
                            z = false;
                        } else {
                            z = bB.X(bVar.getName(), bVar.bPm());
                        }
                        if (!z) {
                            x.i("FTSSearchWidgetMgr", "onTap fail: exec js event %s ", new Object[]{string2});
                            bTB.tlx.a(string3, false, "onTap fail: exec js event  " + string2, string2);
                            return;
                        }
                        return;
                    }
                    x.i("FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", new Object[]{string2});
                    bTB.tlx.a(string3, false, "onTap fail: can not find Widget by widgetId " + string2, string2);
                    return;
                }
                x.e("BaseSearchWebviewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
                this.tlx.a(bundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", bundle.getString("widgetId"));
                return;
            case 200000:
                eVar = this.tCx;
                if (eVar != null) {
                    eVar.v(W(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200001:
                eVar = this.tCx;
                if (eVar != null) {
                    eVar.w(W(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200002:
                eVar = this.tCx;
                if (eVar != null) {
                    eVar.Ah(W(bundle));
                    return;
                }
                return;
            case 200003:
                eVar = this.tCx;
                if (eVar != null) {
                    eVar.aM(W(bundle), bundle.getString(DownloadSettingTable$Columns.TYPE));
                    return;
                }
                return;
            default:
                super.h(i, bundle);
                return;
        }
    }

    protected com.tencent.mm.plugin.webview.fts.b bTB() {
        return null;
    }

    private static int W(Bundle bundle) {
        return bh.VI(bundle.getString("playerId"));
    }

    private void X(Bundle bundle) {
        List arrayList = new ArrayList();
        CharSequence string = bundle.getString("title");
        CharSequence string2 = bundle.getString("desc");
        try {
            JSONArray jSONArray = new JSONArray(bundle.getString("items"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    boolean z;
                    z zVar = new z();
                    zVar.iconUrl = optJSONObject.optString("icon");
                    zVar.title = optJSONObject.optString("title");
                    if (optJSONObject.optInt("selected") == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zVar.nuE = z;
                    zVar.desc = optJSONObject.optString("desc");
                    arrayList.add(zVar);
                }
            }
        } catch (Throwable e) {
            x.e("BaseSearchWebviewUI", bh.i(e));
        }
        x.v("BaseSearchWebviewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[]{string, string2, r7});
        if (!arrayList.isEmpty()) {
            com.tencent.mm.plugin.webview.fts.a bPd = com.tencent.mm.plugin.webview.fts.a.bPd();
            com.tencent.mm.plugin.webview.fts.a.a 2 = new 2(this);
            g gVar = new g(this, g.ztq, true);
            int hashCode = gVar.hashCode();
            gVar.zlt = new 1(bPd, arrayList);
            gVar.rKC = new 2(bPd, arrayList, gVar);
            gVar.rKD = new 3(bPd, 2, hashCode);
            gVar.ztB = new 4(bPd, 2, hashCode);
            View inflate = View.inflate(this, R.i.drp, null);
            if (TextUtils.isEmpty(string)) {
                inflate.findViewById(R.h.title).setVisibility(8);
            } else {
                ((TextView) inflate.findViewById(R.h.title)).setText(string);
            }
            if (TextUtils.isEmpty(string2)) {
                inflate.findViewById(R.h.cPA).setVisibility(8);
            } else {
                ((TextView) inflate.findViewById(R.h.cPA)).setText(string2);
            }
            gVar.ztx = true;
            gVar.dO(inflate);
            gVar.bUk();
            bPd.tln.put(Integer.valueOf(hashCode), gVar);
            bundle.putInt("actionSheetId", hashCode);
        }
    }

    protected void onResume() {
        super.onResume();
        for (a aga : this.tCy) {
            aga.aga();
        }
    }

    protected void onPause() {
        super.onPause();
        for (a afA : this.tCy) {
            afA.afA();
        }
    }

    public void onDestroy() {
        boolean z;
        super.onDestroy();
        for (a onDestroy : this.tCy) {
            onDestroy.onDestroy();
        }
        this.tCy.clear();
        int i = this.scene;
        String str = this.fqu;
        String str2 = this.tjs;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        f.a(14, i, str, str2, "", 0, z, "", true, this.fDj, "", this.type, this.tEd);
        x.d("BaseSearchWebviewUI", "onDestroy");
    }

    public final void j(View view, boolean z) {
        bQx();
        this.jCL = view;
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.addView(view, new LayoutParams(-1, -1));
        view.setX(0.0f);
        view.setY(0.0f);
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4098);
        }
        getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (z) {
            setRequestedOrientation(0);
        }
    }

    public final void bQx() {
        if (this.jCL != null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            viewGroup.setSystemUiVisibility(0);
            viewGroup.removeView(this.jCL);
            getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (getRequestedOrientation() == 0) {
                setRequestedOrientation(1);
            }
            this.jCL = null;
            for (a agt : this.tCy) {
                agt.agt();
            }
        }
    }

    public void onBackPressed() {
        int i = 0;
        for (a aeG : this.tCy) {
            i = aeG.aeG() | i;
        }
        if (i == 0) {
            super.onBackPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            for (a bPX : this.tCy) {
                bPX.bPX();
            }
        } else if (i == 24) {
            for (a bPX2 : this.tCy) {
                bPX2.bQw();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected final void G(Runnable runnable) {
        if (this.tlx == null || !this.tlx.tGQ) {
            x.i("BaseSearchWebviewUI", "jsapi not ready, waiting");
            if (this.tCC == null) {
                this.tCC = new ArrayList();
            }
            this.tCC.add(runnable);
            return;
        }
        runnable.run();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("BaseSearchWebviewUI", "onRequestPermissionsResult, granted ? %d", new Object[]{Integer.valueOf(iArr[0])});
    }
}
