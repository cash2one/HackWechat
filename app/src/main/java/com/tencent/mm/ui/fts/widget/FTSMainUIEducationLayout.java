package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.bc.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.m.f.a;
import com.tencent.mm.plugin.appbrand.m.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayout extends LinearLayout {
    private float iQK;
    private float iQL;
    private float jux = ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
    protected OnClickListener qdi;
    protected List<LinearLayout> zee;
    protected Map<Integer, TextView> zef = new HashMap();
    public String zeg = "";
    private long zeh;
    public boolean zei = true;
    private TextView zej;
    protected boolean zek = true;
    public boolean zel;
    public OnClickListener zem;
    public OnClickListener zen;

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.zee = new ArrayList();
    }

    public final void cxe() {
        this.zek = false;
    }

    public final void au() {
        cxf();
        try {
            if (!ai(h.NT("educationTab"))) {
                cxg();
            }
        } catch (Exception e) {
            cxg();
        }
        try {
            if (this.zek) {
                CharSequence optString = h.NT("educationHotword").optJSONArray("items").optJSONObject(0).optString("hotword");
                if (!bh.ov(optString)) {
                    LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.dje, null);
                    ((TextView) linearLayout.findViewById(R.h.coH)).setText(optString);
                    linearLayout.setOnClickListener(this.zem);
                    linearLayout.setTag(optString);
                    addView(linearLayout);
                    this.zee.add(linearLayout);
                }
            }
        } catch (Exception e2) {
        }
        if (this.zel) {
            a abg = ((f) g.h(f.class)).abg();
            if (abg.hiv != null && abg.hiv.size() > 0) {
                linearLayout = (LinearLayout) inflate(getContext(), R.i.djf, null);
                ((TextView) linearLayout.findViewById(R.h.cSu)).setText(abg.fyY);
                ImageView[] imageViewArr = new ImageView[]{(ImageView) linearLayout.findViewById(R.h.bKk), (ImageView) linearLayout.findViewById(R.h.bKl), (ImageView) linearLayout.findViewById(R.h.bKm), (ImageView) linearLayout.findViewById(R.h.bKn)};
                ImageView imageView = (ImageView) linearLayout.findViewById(R.h.cxq);
                int i = 0;
                while (i < abg.hiv.size() && i < 4) {
                    b bVar = (b) abg.hiv.get(i);
                    c.a aVar = new c.a();
                    aVar.hDP = R.k.bBB;
                    aVar.hDY = true;
                    o.PA().a(bVar.iKm, imageViewArr[i], aVar.PK());
                    imageViewArr[i].setVisibility(0);
                    imageViewArr[i].setTag(bVar);
                    if (this.zen != null) {
                        imageViewArr[i].setOnClickListener(this.zen);
                    }
                    i++;
                }
                if (abg.hiv.size() > 0) {
                    imageView.setVisibility(0);
                    imageView.setTag("more-click");
                    imageView.setOnClickListener(this.zen);
                }
                addView(linearLayout);
                this.zee.add(linearLayout);
                String str = "";
                for (b bVar2 : abg.hiv) {
                    str = str + bVar2.username + ";";
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(14630, new Object[]{e.hKF, abg.fyY, str, Integer.valueOf(abg.jJf), Long.valueOf(System.currentTimeMillis() / 1000)});
            }
        }
    }

    public final void ah(JSONObject jSONObject) {
        cxf();
        try {
            if (!ai(jSONObject)) {
                cxg();
            }
        } catch (Exception e) {
            cxg();
        }
    }

    private void cxf() {
        for (LinearLayout removeView : this.zee) {
            removeView(removeView);
        }
        this.zee.clear();
        this.zef.clear();
        this.zeg = "";
    }

    protected boolean ai(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        jSONObject.optString("title");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            return false;
        }
        int aa;
        if (w.eL(ac.getContext()).equalsIgnoreCase("en")) {
            aa = com.tencent.mm.bv.a.aa(getContext(), R.f.but);
        } else {
            aa = com.tencent.mm.bv.a.aa(getContext(), R.f.bvK);
        }
        int i = 0;
        Object obj = null;
        JSONObject jSONObject2 = null;
        String str = null;
        String str2 = null;
        while (i < Math.min(optJSONArray.length(), 9)) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject jSONObject3 = optJSONObject;
                optJSONObject = jSONObject2;
            } else {
                a(str2, jSONObject2, str, obj, optJSONObject.optString("hotword"), optJSONObject, aa);
                obj = null;
                optJSONObject = null;
                str = null;
                str2 = null;
            }
            i++;
            jSONObject2 = optJSONObject;
        }
        if (!(str2 == null || jSONObject2 == null)) {
            a(str2, jSONObject2, str, obj, null, null, aa);
        }
        return true;
    }

    private void cxg() {
        a(getContext().getString(R.l.eIR), null, getContext().getString(R.l.eIP), null, getContext().getString(R.l.eIQ), null, com.tencent.mm.bv.a.aa(getContext(), R.f.bvK));
        cxh();
    }

    protected void cxh() {
    }

    protected final void a(String str, Object obj, String str2, Object obj2, String str3, Object obj3, int i) {
        x.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", new Object[]{str, str2, str3});
        if (!bh.ov(str)) {
            LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.djc, null);
            TextView textView = (TextView) linearLayout.findViewById(R.h.cQG);
            textView.setText(str);
            textView.setTag(obj);
            textView.setVisibility(0);
            textView.setOnClickListener(this.qdi);
            textView.setClickable(this.zei);
            this.zef.put(Integer.valueOf(com.tencent.mm.bc.b.a((JSONObject) obj, str, getContext())), textView);
            ci(obj);
            if (!bh.ov(str2)) {
                textView = (TextView) linearLayout.findViewById(R.h.cQH);
                textView.setText(str2);
                textView.setTag(obj2);
                textView.setVisibility(0);
                textView.setOnClickListener(this.qdi);
                textView.setClickable(this.zei);
                View findViewById = linearLayout.findViewById(R.h.ccj);
                findViewById.getLayoutParams().height = i;
                findViewById.setVisibility(0);
                this.zef.put(Integer.valueOf(com.tencent.mm.bc.b.a((JSONObject) obj2, str2, getContext())), textView);
                ci(obj2);
                if (!bh.ov(str3)) {
                    textView = (TextView) linearLayout.findViewById(R.h.cQI);
                    textView.setText(str3);
                    textView.setTag(obj3);
                    textView.setVisibility(0);
                    textView.setOnClickListener(this.qdi);
                    textView.setClickable(this.zei);
                    findViewById = linearLayout.findViewById(R.h.cck);
                    findViewById.getLayoutParams().height = i;
                    findViewById.setVisibility(0);
                    this.zef.put(Integer.valueOf(com.tencent.mm.bc.b.a((JSONObject) obj3, str3, getContext())), textView);
                    ci(obj3);
                }
            }
            this.zee.add(linearLayout);
            addView(linearLayout);
        }
    }

    private void ci(Object obj) {
        if (obj != null && (obj instanceof JSONObject)) {
            String optString = ((JSONObject) obj).optString("businessType");
            if (!bh.ov(optString)) {
                this.zeg = this.zeg == null ? "" : this.zeg;
                if (this.zeg.length() > 0) {
                    this.zeg += "|";
                }
                this.zeg += optString;
            }
        }
    }

    public final void q(OnClickListener onClickListener) {
        this.qdi = onClickListener;
    }

    public final void Gw(int i) {
        for (Entry entry : this.zef.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == i) {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
            } else {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#45C01A"));
            }
        }
    }

    public final String Gx(int i) {
        TextView textView = (TextView) this.zef.get(Integer.valueOf(i));
        return textView == null ? "" : textView.getText().toString();
    }

    public final void M(MotionEvent motionEvent) {
        x.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action %d", new Object[]{Integer.valueOf(motionEvent.getAction())});
        switch (motionEvent.getAction()) {
            case 0:
                for (TextView textView : this.zef.values()) {
                    int[] iArr = new int[2];
                    textView.getLocationOnScreen(iArr);
                    if (new Rect(iArr[0], iArr[1], iArr[0] + textView.getWidth(), iArr[1] + textView.getHeight()).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        if (textView != null) {
                            this.zej = textView;
                            this.iQK = motionEvent.getRawX();
                            this.iQL = motionEvent.getRawY();
                            this.zeh = System.currentTimeMillis();
                            return;
                        }
                        return;
                    }
                }
                TextView textView2 = null;
                if (textView2 != null) {
                    this.zej = textView2;
                    this.iQK = motionEvent.getRawX();
                    this.iQL = motionEvent.getRawY();
                    this.zeh = System.currentTimeMillis();
                    return;
                }
                return;
            case 1:
            case 9:
                if (this.zej != null) {
                    x.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action up deltaX %f, deltaY %f, time interval %d", new Object[]{Float.valueOf(motionEvent.getRawX() - this.iQK), Float.valueOf(motionEvent.getRawY() - this.iQL), Long.valueOf(System.currentTimeMillis() - this.zeh)});
                    if (Math.abs(motionEvent.getRawX() - this.iQK) <= this.jux && Math.abs(r2) <= this.jux && System.currentTimeMillis() - this.zeh < 200 && this.qdi != null) {
                        this.qdi.onClick(this.zej);
                    }
                    this.zej = null;
                    return;
                }
                return;
            case 3:
                this.zej = null;
                return;
            default:
                return;
        }
    }
}
