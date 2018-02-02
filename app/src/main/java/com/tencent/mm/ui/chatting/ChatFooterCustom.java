package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d$b;
import com.tencent.mm.ag.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.c;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom extends LinearLayout implements OnClickListener, a {
    public x fAh;
    private String jKk;
    private d kEC;
    private Object kIX;
    private LinearLayout lHZ;
    public ChatFooter.d vqf;
    private u xJX;
    private ImageView yqL;
    public ImageView yqM;
    public g yqN;
    public c.a yqO;
    private int yqP;
    private bc yqQ;
    private a yqR;
    private b yqS;
    private List<String> yqT;
    private final String yqU;
    private final String yqV;
    private j yqW;

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lHZ = null;
        this.yqL = null;
        this.yqM = null;
        this.yqN = null;
        this.vqf = null;
        this.yqO = null;
        this.yqP = 0;
        this.yqT = new LinkedList();
        this.yqU = "qrcode";
        this.yqV = "barcode";
        this.kIX = new Object();
    }

    public final void a(u uVar, d dVar, String str) {
        d$b.c LE = dVar.bI(false).LE();
        if (LE == null || LE.hpe == null || str == null) {
            throw new IllegalArgumentException(" menuInfo or username is null ! ");
        }
        this.yqP = Math.min(LE.hpe.size(), 6);
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "setMenus, count:" + this.yqP);
        if (this.yqP <= 0) {
            throw new IllegalArgumentException(" mTabCount is invalid ! ");
        }
        if (this.yqP > 3) {
            this.yqL.setVisibility(0);
        } else {
            this.yqL.setVisibility(8);
        }
        this.lHZ.setWeightSum((float) Math.min(this.yqP, 3));
        for (int i = 0; i < 6; i++) {
            FrameLayout frameLayout = (FrameLayout) this.lHZ.getChildAt(i);
            TextView textView = (TextView) frameLayout.getChildAt(0).findViewById(R.h.bTZ);
            frameLayout.getChildAt(0).findViewById(R.h.bTY).setVisibility(8);
            ImageView imageView = (ImageView) frameLayout.getChildAt(1);
            imageView.setVisibility(8);
            if (i < this.yqP) {
                j jVar = (j) LE.hpe.get(i);
                frameLayout.setTag(jVar);
                textView.setText(i.a(getContext(), jVar.name));
                if (jVar.type == 0) {
                    imageView.setVisibility(0);
                }
                frameLayout.setOnClickListener(this);
                frameLayout.setVisibility(0);
            } else if (i < 3 || this.yqP <= 3) {
                frameLayout.setVisibility(8);
            } else {
                frameLayout.setTag(null);
                textView.setText("");
                imageView.setVisibility(8);
                frameLayout.setOnClickListener(null);
                frameLayout.setVisibility(0);
            }
        }
        this.xJX = uVar;
        this.jKk = str;
        this.kEC = dVar;
        if (this.yqR != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.yqR);
        }
        if (this.yqS != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.yqS);
        }
        this.yqR = new a(this, (byte) 0);
        this.yqS = new b(this, (byte) 0);
        com.tencent.mm.sdk.b.a.xef.b(this.yqR);
        com.tencent.mm.sdk.b.a.xef.b(this.yqS);
    }

    public final void bAY() {
        if (this.yqR != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.yqR);
        }
        if (this.yqS != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.yqS);
        }
    }

    private void crj() {
        if (this.xJX != null && this.fAh != null && !t.ov(this.jKk)) {
            k.b(this.xJX, 9, this.jKk, this.fAh.field_username);
        }
    }

    private void crk() {
        File file = new File(e.gHu);
        if (!file.exists() && !file.mkdir()) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.dTe), 1).show();
        } else if (this.xJX != null && !k.a(this.xJX, e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.eJu), 1).show();
        }
    }

    public final void crl() {
        if (this.yqN != null) {
            this.yqN.cro();
        }
    }

    public synchronized void onClick(View view) {
        String str = null;
        synchronized (this) {
            Object tag = view.getTag();
            if (tag instanceof j) {
                com.tencent.mm.pluginsdk.wallet.i.CB(8);
                j jVar = (j) tag;
                jVar.content = "";
                switch (jVar.type) {
                    case 0:
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth())});
                        g gVar = this.yqN;
                        int width = iArr[0] + (view.getWidth() / 2);
                        int i = iArr[1];
                        if (!gVar.isShowing()) {
                            gVar.a(jVar, width, i, false);
                            break;
                        }
                        gVar.cro();
                        if (!(jVar == null || (gVar.yre.id == jVar.id && gVar.yre.aAM.equals(jVar.aAM)))) {
                            gVar.a(jVar, width, i, false);
                            break;
                        }
                    case 1:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "get latest message");
                        crn();
                        this.yqN.cro();
                        jVar.state = j.hpI;
                        b(jVar);
                        d(jVar);
                        this.yqO.ctl();
                        break;
                    case 2:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "start webview url");
                        crn();
                        this.yqN.cro();
                        jVar.state = j.hpI;
                        b(jVar);
                        d(jVar);
                        if (!(q$a.vcy.b(getContext(), jVar.value, new Object[0]) || e.a(jVar.fLC, getContext(), this.xJX, this.jKk))) {
                            Intent intent = new Intent();
                            intent.putExtra("KPublisherId", "custom_menu");
                            intent.putExtra("pre_username", this.jKk);
                            intent.putExtra("prePublishId", "custom_menu");
                            intent.putExtra("preUsername", this.jKk);
                            intent.putExtra("preChatName", this.jKk);
                            intent.putExtra("preChatTYPE", com.tencent.mm.z.t.N(this.jKk, this.jKk));
                            intent.putExtra("rawUrl", jVar.value);
                            intent.putExtra("geta8key_username", this.jKk);
                            intent.putExtra("from_scence", 1);
                            com.tencent.mm.bm.d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            break;
                        }
                    case 3:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "switch to input");
                        this.yqN.cro();
                        crm();
                        jVar.state = j.hpI;
                        b(jVar);
                        d(jVar);
                        break;
                    case 4:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                        crn();
                        this.yqN.cro();
                        jVar.state = j.hpJ;
                        String str2 = jVar.id + jVar.aAM;
                        synchronized (this.kIX) {
                            this.yqT.add(str2);
                        }
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[]{str2, Integer.valueOf(this.yqT.size())});
                        g.pQN.h(10809, new Object[]{this.jKk, Integer.valueOf(jVar.id), jVar.aAM, j.hpJ, ""});
                        this.yqW = jVar;
                        Intent intent2;
                        b duVar;
                        switch (jVar.hpM) {
                            case 100:
                                intent2 = new Intent();
                                intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent2.putExtra("key_is_finish_on_scanned", true);
                                intent2.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.p.a.aV(getContext())) {
                                    getContext();
                                    if (!com.tencent.mm.au.a.Qj()) {
                                        com.tencent.mm.bm.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                        break;
                                    }
                                }
                                break;
                            case 101:
                                intent2 = new Intent();
                                intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent2.putExtra("key_is_finish_on_scanned", false);
                                intent2.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.p.a.aV(getContext())) {
                                    getContext();
                                    if (!com.tencent.mm.au.a.Qj()) {
                                        com.tencent.mm.bm.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                        break;
                                    }
                                }
                                break;
                            case 102:
                                crk();
                                break;
                            case 103:
                                ar.Hg();
                                if (!com.tencent.mm.z.c.isSDCardAvailable()) {
                                    com.tencent.mm.ui.base.u.fI(getContext());
                                    break;
                                } else {
                                    h.a(getContext(), null, new String[]{getContext().getString(R.l.dQJ), getContext().getString(R.l.dQI)}, null, new 1(this));
                                    break;
                                }
                            case 104:
                                crj();
                                break;
                            case 105:
                                Intent intent3 = new Intent();
                                intent3.putExtra("map_view_type", 0);
                                String str3 = "map_sender_name";
                                com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "getSender " + (this.yqQ == null) + " " + (this.yqQ == null ? q.FS() : this.yqQ.name));
                                intent3.putExtra(str3, this.yqQ == null ? q.FS() : this.yqQ.name);
                                intent3.putExtra("map_talker_name", this.fAh == null ? null : this.fAh.field_username);
                                intent3.putExtra("view_type_key", 1);
                                intent3.putExtra("key_get_location_type", 1);
                                com.tencent.mm.bm.d.b(getContext(), "location", ".ui.RedirectUI", intent3);
                                break;
                            case 106:
                                duVar = new du();
                                duVar.fss.op = 1;
                                duVar.fss.userName = this.fAh.field_username;
                                duVar.fss.context = getContext();
                                com.tencent.mm.sdk.b.a.xef.m(duVar);
                                break;
                            case 107:
                                duVar = new du();
                                duVar.fss.op = 2;
                                duVar.fss.userName = this.fAh.field_username;
                                duVar.fss.context = getContext();
                                com.tencent.mm.sdk.b.a.xef.m(duVar);
                                break;
                            default:
                                break;
                        }
                    case 5:
                        crn();
                        this.yqN.cro();
                        jVar.state = j.hpI;
                        b(jVar);
                        d(jVar);
                        if (!TextUtils.isEmpty(jVar.value)) {
                            try {
                                JSONObject jSONObject = new JSONObject(jVar.value);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = 1035;
                                appBrandStatObject.fnp = this.jKk;
                                com.tencent.mm.plugin.appbrand.m.c cVar = (com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class);
                                Context context = getContext();
                                String optString = jSONObject.optString("userName");
                                String optString2 = jSONObject.optString("pagePath");
                                if (this.kEC != null) {
                                    str = this.kEC.field_appId;
                                }
                                cVar.a(context, optString, null, 0, 0, optString2, appBrandStatObject, str);
                                break;
                            } catch (JSONException e) {
                                break;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        String str = jVar.id + jVar.aAM;
        synchronized (this.kIX) {
            int i;
            for (int i2 = 0; i2 < this.yqT.size(); i2++) {
                if (((String) this.yqT.get(i2)).equals(str)) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i >= 0) {
                this.yqT.remove(i);
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[]{str, Integer.valueOf(this.yqT.size())});
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[]{str, Integer.valueOf(this.yqT.size())});
            return false;
        }
    }

    private void b(j jVar) {
        g.pQN.h(10809, new Object[]{this.jKk, Integer.valueOf(jVar.id), jVar.aAM, j.hpI, ""});
    }

    private void c(j jVar) {
        g.pQN.h(10809, new Object[]{this.jKk, Integer.valueOf(jVar.id), jVar.aAM, j.hpK, jVar.content});
    }

    public final boolean j(int i, Object obj) {
        if (obj != null) {
            switch (i) {
                case 201:
                case 203:
                    i = 1001;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX /*217*/:
                    i = 1002;
                    break;
            }
            String stringExtra;
            ArrayList arrayList;
            switch (i) {
                case 1001:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "return from camera");
                    if (!(obj instanceof Intent)) {
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "type error");
                        break;
                    }
                    stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        File file = new File(stringExtra);
                        if (!file.exists() || !file.isFile()) {
                            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[]{stringExtra});
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "%s retrieved!", new Object[]{stringExtra});
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MD5 is %s", new Object[]{com.tencent.mm.a.g.i(file)});
                        if (this.yqW != null && (this.yqW.hpM == 102 || this.yqW.hpM == 103)) {
                            arrayList = new ArrayList();
                            arrayList.add(stringExtra);
                            this.yqW.state = j.hpK;
                            this.yqW.e(arrayList);
                            if (a(this.yqW)) {
                                d(this.yqW);
                                c(this.yqW);
                                break;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "return null path");
                    break;
                    break;
                case 1002:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "return from albumn");
                    if (!(obj instanceof Intent)) {
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "type error");
                        break;
                    }
                    ArrayList stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                    arrayList = new ArrayList();
                    if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            stringExtra = (String) it.next();
                            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[]{stringExtra});
                            if (stringExtra != null) {
                                File file2 = new File(stringExtra);
                                if (file2.exists() && file2.isFile()) {
                                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "%s retrieved!", new Object[]{stringExtra});
                                    arrayList.add(com.tencent.mm.a.g.i(file2));
                                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MD5 is %s", new Object[]{stringExtra});
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[]{stringExtra});
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "no file contained!");
                            }
                        }
                        if (this.yqW != null && (this.yqW.hpM == 104 || this.yqW.hpM == 103 || this.yqW.hpM == 102)) {
                            this.yqW.state = j.hpK;
                            this.yqW.e(arrayList);
                            if (a(this.yqW)) {
                                d(this.yqW);
                                c(this.yqW);
                                break;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    break;
                case 1003:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send qrcode wait msg");
                    if (ch(obj)) {
                        this.yqO.ctl();
                        break;
                    }
                    break;
                case 1004:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send qrcode direct");
                    ch(obj);
                    break;
                case 1005:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send current");
                    cg(obj);
                    break;
                case 1006:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send selected");
                    cg(obj);
                    break;
                default:
                    break;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
        return true;
    }

    private boolean cg(Object obj) {
        if (obj instanceof lx) {
            lx lxVar = (lx) obj;
            double d = lxVar.fDr.lat;
            double d2 = lxVar.fDr.lng;
            int i = lxVar.fDr.fzv;
            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), lxVar.fDr.label, lxVar.fDr.fDu});
            if (this.yqW == null || this.yqW.hpM != 105) {
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "cache lost or location type is not correct");
            } else {
                this.yqW.state = j.hpK;
                j jVar = this.yqW;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", String.valueOf(d));
                    jSONObject.put("y", String.valueOf(d2));
                    jSONObject.put("scale", i);
                    jSONObject.put("label", r5);
                    jSONObject.put("poiname", r6);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("location", jSONObject);
                    jVar.content = jSONObject2.toString();
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", jVar.content);
                } catch (JSONException e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizMenuItem", e.toString());
                }
                if (a(this.yqW)) {
                    d(this.yqW);
                    c(this.yqW);
                }
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "send current location data type error!");
        }
        return true;
    }

    private boolean ch(Object obj) {
        if (obj instanceof ly) {
            ly lyVar = (ly) obj;
            if (this.yqW == null || !(this.yqW.hpM == 100 || this.yqW.hpM == 101)) {
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "null pointer in cache or type error");
                return false;
            }
            Object obj2;
            switch (lyVar.fDv.fDx) {
                case 0:
                    obj2 = "qrcode";
                    break;
                case 1:
                    obj2 = "barcode";
                    break;
                default:
                    obj2 = "";
                    break;
            }
            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[]{obj2, lyVar.fDv.scanResult});
            this.yqW.state = j.hpK;
            j jVar = this.yqW;
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", "type is %s , result is %s", new Object[]{obj2, r3});
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scan_type", obj2);
                jSONObject.put("scan_result", r3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scan_code", jSONObject);
                jVar.content = jSONObject2.toString();
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", "content: %s", new Object[]{jVar.content});
            } catch (JSONException e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizMenuItem", e.toString());
            }
            if (a(this.yqW)) {
                d(this.yqW);
                c(this.yqW);
            }
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "send current location data type error!");
        return false;
    }

    private void d(j jVar) {
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", jVar.getInfo());
        ar.CG().a(new com.tencent.mm.ag.q(this.jKk, 1, jVar.getInfo(), null), 0);
    }

    public final void k(ViewGroup viewGroup) {
        this.lHZ = (LinearLayout) findViewById(R.h.bTX);
        this.yqM = (ImageView) findViewById(R.h.bUb);
        this.yqM.setVisibility(0);
        this.yqM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChatFooterCustom yqX;

            {
                this.yqX = r1;
            }

            public final void onClick(View view) {
                this.yqX.crm();
            }
        });
        this.yqL = (ImageView) findViewById(R.h.bTW);
        this.yqL.setOnClickListener(new 3(this));
        this.yqN = new g(getContext(), viewGroup);
        this.yqN.yqY = new OnItemClickListener(this) {
            final /* synthetic */ ChatFooterCustom yqX;

            {
                this.yqX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.yqX.onClick(view);
            }
        };
    }

    public final void a(com.tencent.mm.ae.d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "SysCmdMsgExtension:" + a);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(a));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                    case 2:
                        a = newPullParser.getName();
                        if (!"sysmsg".equals(a)) {
                            if (!"username".equals(a)) {
                                if (!SlookAirButtonFrequentContactAdapter.DATA.equals(a)) {
                                    break;
                                }
                                newPullParser.nextText();
                                break;
                            }
                            newPullParser.nextText();
                            break;
                        } else if (!DownloadSettingTable$Columns.TYPE.equals(newPullParser.getAttributeName(0))) {
                            break;
                        } else {
                            newPullParser.getAttributeValue(0);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("ChatCustomFooter", e, "", new Object[0]);
        }
    }

    private void crm() {
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "switch footer");
        if (this.vqf != null) {
            this.yqN.cro();
            this.vqf.ln(true);
        }
    }

    private void crn() {
        if (this.fAh != null && this.fAh.fWx == 1) {
            ar.Hg();
            com.tencent.mm.z.c.Fd().Xc(this.fAh.field_username);
        }
    }
}
