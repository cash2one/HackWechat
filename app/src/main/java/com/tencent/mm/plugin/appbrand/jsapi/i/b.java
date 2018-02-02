package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    private static final class a extends BaseAdapter {
        private final ArrayList<String> jpU;
        private final int jpV;

        public final /* synthetic */ Object getItem(int i) {
            return kC(i);
        }

        public a(ArrayList<String> arrayList, int i) {
            this.jpU = arrayList;
            this.jpV = i;
        }

        public final int getCount() {
            return this.jpU.size();
        }

        private String kC(int i) {
            return (String) this.jpU.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), h.ixm, null);
                a aVar2 = new a((byte) 0);
                aVar2.jpW = (TextView) view.findViewById(g.title);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jpW.setText(kC(i));
            aVar.jpW.setTextColor(this.jpV);
            return view;
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        p b = b(jVar);
        if (b == null) {
            x.w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            jVar.E(i, e("fail", null));
            return;
        }
        m.o(b);
        String optString = jSONObject.optString("itemList");
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add((String) jSONArray.get(i2));
            }
            final j jVar2 = jVar;
            final JSONObject jSONObject2 = jSONObject;
            final int i3 = i;
            ag.y(new Runnable(this) {
                final /* synthetic */ b jpR;

                public final void run() {
                    if (jVar2.Vx) {
                        Context a = this.jpR.a(jVar2);
                        final com.tencent.mm.plugin.appbrand.widget.c.h bVar = new com.tencent.mm.plugin.appbrand.widget.c.b(a);
                        int aP = f.aP(jSONObject2.optString("itemColor", ""), Color.parseColor("#000000"));
                        ViewGroup viewGroup = (ViewGroup) View.inflate(a, h.gXA, null);
                        bVar.setContentView(viewGroup);
                        ListView listView = (ListView) viewGroup.findViewById(g.list);
                        listView.setAdapter(new a(arrayList, aP));
                        listView.setOnItemClickListener(new OnItemClickListener(this) {
                            final /* synthetic */ AnonymousClass1 jpT;

                            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                Map hashMap = new HashMap();
                                hashMap.put("tapIndex", Integer.valueOf(i));
                                jVar2.E(i3, this.jpT.jpR.e("ok", hashMap));
                                bVar.dismiss();
                            }
                        });
                        bVar.setOnCancelListener(new 2(this));
                        jVar2.irP.a(bVar);
                    }
                }
            });
        } catch (Exception e) {
            x.e("MicroMsg.JsApiShowActionSheet", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
