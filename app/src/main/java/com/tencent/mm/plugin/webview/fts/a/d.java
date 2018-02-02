package com.tencent.mm.plugin.webview.fts.a;

import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a<j> {
    public boolean foh;
    private List<j> mMc;
    private List<String> tnk;

    public d(String str, List<String> list) {
        super(str, Integer.MAX_VALUE);
        this.tnk = list;
    }

    public final void ck(List<j> list) {
        this.mMc = list;
        if (this.mMc != null) {
            List arrayList = new ArrayList(this.tnk.size());
            Iterator it = this.mMc.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                ar.Hg();
                int indexOf = this.tnk.indexOf(c.EY().WO(jVar.mLs).field_username);
                if (indexOf >= 0) {
                    if (indexOf < arrayList.size()) {
                        arrayList.add(indexOf, jVar);
                    } else {
                        arrayList.add(jVar);
                    }
                    it.remove();
                }
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mMc.add(0, arrayList.get(size));
            }
        }
        this.foh = true;
    }

    public final JSONObject eh(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        if (!this.foh) {
            return jSONObject;
        }
        if (i < 0 || i2 <= 0) {
            return jSONObject;
        }
        int size;
        int i3 = (i + i2) - 1;
        if (i3 > this.mMc.size() - 1) {
            size = this.mMc.size() - 1;
        } else {
            size = i3;
        }
        if (size < i) {
            return jSONObject;
        }
        jSONObject.put("continueFlag", size == this.mMc.size() + -1 ? 0 : 1);
        jSONObject.put("offset", size + 1);
        jSONObject.put("query", this.fDj);
        jSONObject.put("ret", 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("count", (size - i) + 1);
        jSONObject2.put("totalCount", s.GJ());
        JSONArray jSONArray = new JSONArray();
        while (i <= size) {
            Object obj;
            j jVar = (j) this.mMc.get(i);
            JSONObject jSONObject3 = new JSONObject();
            ar.Hg();
            af WO = c.EY().WO(jVar.mLs);
            jSONObject3.put("userName", WO.field_username);
            jSONObject3.put("nickName", WO.field_nickname);
            String str = jVar.content;
            Context context = ac.getContext();
            String str2 = "";
            str = str.replaceFirst(this.fDj, "<em class=\\\"highlight\\\">" + this.fDj + "</em>");
            switch (jVar.mLr) {
                case 1:
                case 4:
                case 5:
                    String str3 = str;
                    break;
                case 15:
                    obj = context.getString(R.l.eIM) + str;
                    break;
                default:
                    obj = str2;
                    break;
            }
            try {
                jSONObject3.put("displayText", obj);
            } catch (Throwable e) {
                x.printErrStackTrace("JsapiFtsMatchContact", e, "", new Object[0]);
            }
            try {
                obj = "";
                h jm = n.JQ().jm(WO.field_username);
                if (jm != null) {
                    obj = jm.JH();
                    if (bh.ov(obj)) {
                        obj = jm.JG();
                    }
                }
                jSONObject3.put("thumbUrl", obj);
                jSONArray.put(jSONObject3);
                i++;
            } catch (Throwable e2) {
                x.printErrStackTrace("JsapiFtsMatchContact", e2, "", new Object[0]);
            }
        }
        jSONObject2.put("items", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject2);
        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray2);
        return jSONObject;
    }
}
