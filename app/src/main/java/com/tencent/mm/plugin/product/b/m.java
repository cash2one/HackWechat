package com.tencent.mm.plugin.product.b;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m {
    public String pek;
    public int pel;
    public int pem = Integer.MAX_VALUE;
    public int pen = Integer.MAX_VALUE;
    public c peo;
    public n pep;
    public LinkedList<l> peq = new LinkedList();
    public f per;
    public String pes;
    public String pet;
    public String peu;
    public int status = 6;

    public static m a(m mVar, String str) {
        m mVar2;
        if (mVar == null) {
            mVar2 = new m();
        } else {
            mVar2 = mVar;
        }
        try {
            int length;
            int i;
            int i2;
            JSONArray optJSONArray;
            JSONObject jSONObject = new JSONObject(str);
            mVar2.pek = jSONObject.getString("product_id");
            mVar2.pel = jSONObject.getInt("product_type");
            mVar2.pem = jSONObject.optInt("quantity", Integer.MAX_VALUE);
            mVar2.pen = jSONObject.optInt("left_buy_quantity", Integer.MAX_VALUE);
            mVar2.status = jSONObject.optInt(DownloadInfo.STATUS, 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                mVar2.per = new f();
                optJSONObject = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject != null) {
                    f fVar = mVar2.per;
                    j jVar = new j();
                    jVar.fDt = optJSONObject.getInt("flag");
                    fVar.peN = jVar;
                } else {
                    mVar2.per.peO = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject2 != null) {
                JSONObject jSONObject2;
                mVar2.peo = new c();
                mVar2.peo.name = optJSONObject2.getString("name");
                mVar2.peo.pez = optJSONObject2.getInt("ori_price");
                mVar2.peo.peA = optJSONObject2.getInt("up_price");
                mVar2.peo.peB = optJSONObject2.getInt("low_price");
                mVar2.peo.peC = new LinkedList();
                JSONArray jSONArray = optJSONObject2.getJSONArray("img_info");
                length = jSONArray.length();
                for (i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (!bh.ov(string)) {
                        mVar2.peo.peC.add(string);
                    }
                }
                mVar2.peo.hef = optJSONObject2.getString("digest");
                mVar2.peo.paz = optJSONObject2.getString("fee_type");
                mVar2.peo.peD = optJSONObject2.getString("detail");
                optJSONObject = optJSONObject2.optJSONObject("share_info");
                if (optJSONObject != null) {
                    mVar2.peo.peL = new k();
                    mVar2.peo.peL.oZC = optJSONObject.optString("icon_url");
                    mVar2.peo.peL.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sku_table");
                if (optJSONArray2 != null) {
                    mVar2.peo.peJ = new LinkedList();
                    int length2 = optJSONArray2.length();
                    for (i = 0; i < length2; i++) {
                        jSONObject2 = optJSONArray2.getJSONObject(i);
                        com.tencent.mm.plugin.product.c.m mVar3 = new com.tencent.mm.plugin.product.c.m();
                        mVar3.peV = jSONObject2.getString(SlookAirButtonFrequentContactAdapter.ID);
                        mVar3.peW = jSONObject2.getString("name");
                        mVar3.peX = new LinkedList();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (i2 = 0; i2 < length3; i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            h hVar = new h();
                            hVar.id = jSONObject3.getString(SlookAirButtonFrequentContactAdapter.ID);
                            hVar.name = jSONObject3.getString("name");
                            hVar.peP = true;
                            mVar3.peX.add(hVar);
                        }
                        mVar2.peo.peJ.add(mVar3);
                    }
                }
                optJSONArray = optJSONObject2.optJSONArray("actiongroup_attr");
                if (optJSONArray != null) {
                    mVar2.peo.peK = new LinkedList();
                    length = optJSONArray.length();
                    for (i = 0; i < length; i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.nfp = jSONObject2.getString("name");
                        aVar.ktN = 0;
                        if (!bh.ov(aVar.nfp)) {
                            mVar2.peo.peK.add(aVar);
                        }
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("action_list");
                        int length4 = jSONArray3.length();
                        for (i2 = 0; i2 < length4; i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            a aVar2 = new a();
                            aVar2.nfp = jSONObject4.getString("name");
                            aVar2.pew = jSONObject4.getString("tips");
                            aVar2.ktN = jSONObject4.getInt(DownloadSettingTable$Columns.TYPE);
                            aVar2.nje = jSONObject4.getString("content");
                            aVar2.nfT = jSONObject4.getString("icon_url");
                            mVar2.peo.peK.add(aVar2);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray != null) {
                length = optJSONArray.length();
                mVar2.peq = new LinkedList();
                for (i2 = 0; i2 < length; i2++) {
                    optJSONObject = optJSONArray.getJSONObject(i2);
                    l lVar = new l();
                    lVar.peS = optJSONObject.getString("id_info");
                    lVar.peT = optJSONObject.getInt("price");
                    lVar.pem = optJSONObject.getInt("quantity");
                    lVar.url = optJSONObject.getString("icon_url");
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("express_fee");
                    int length5 = jSONArray4.length();
                    lVar.peU = new LinkedList();
                    for (i = 0; i < length5; i++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i);
                        e eVar = new e();
                        eVar.id = jSONObject5.getInt(SlookAirButtonFrequentContactAdapter.ID);
                        eVar.name = jSONObject5.getString("name");
                        eVar.value = jSONObject5.getInt("price");
                        lVar.peU.add(eVar);
                    }
                    mVar2.peq.add(lVar);
                }
            }
            optJSONObject = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject != null) {
                mVar2.pep = new n();
                mVar2.pep.fFm = optJSONObject.getString("appid");
                mVar2.pep.name = optJSONObject.getString("name");
                mVar2.pep.username = optJSONObject.getString("username");
                mVar2.pep.peY = optJSONObject.optString("logo");
                mVar2.pep.fDt = optJSONObject.optInt("flag", 0);
            }
            optJSONObject = jSONObject.optJSONObject("oss_info");
            if (optJSONObject != null) {
                mVar2.pet = optJSONObject.optString("self_buy_button_word");
                mVar2.peu = optJSONObject.optString("product_mixed_h5_html");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ProductInfo", e, "", new Object[0]);
        }
        return mVar2;
    }

    public static m b(m mVar, String str) {
        int i = 0;
        if (mVar == null) {
            mVar = new m();
        }
        Map y = bi.y(str, "mallProductInfo");
        if (y == null) {
            return null;
        }
        mVar.pek = bh.ou((String) y.get(".mallProductInfo.id"));
        mVar.pel = bh.getInt((String) y.get(".mallProductInfo.type"), 0);
        mVar.peo = new c();
        mVar.peo.name = bh.ou((String) y.get(".mallProductInfo.name"));
        mVar.peo.hef = bh.ou((String) y.get(".mallProductInfo.digest"));
        mVar.peo.peA = bh.getInt((String) y.get(".mallProductInfo.highPrice"), 0);
        mVar.peo.peB = bh.getInt((String) y.get(".mallProductInfo.lowPrice"), 0);
        mVar.peo.pez = bh.getInt((String) y.get(".mallProductInfo.originPrice"), 0);
        mVar.pes = bh.ou((String) y.get(".mallProductInfo.sourceUrl"));
        int i2 = bh.getInt((String) y.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            mVar.peo.peC = new LinkedList();
            while (i < i2) {
                String ou;
                if (i == 0) {
                    ou = bh.ou((String) y.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    ou = bh.ou((String) y.get(".mallProductInfo.imgList.imgUrl" + i));
                }
                if (!bh.ov(ou)) {
                    mVar.peo.peC.add(ou);
                }
                i++;
            }
        }
        mVar.peo.peL = new k();
        mVar.peo.peL.url = bh.ou((String) y.get(".mallProductInfo.shareInfo.shareUrl"));
        mVar.peo.peL.oZC = bh.ou((String) y.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        mVar.pep = new n();
        mVar.pep.fFm = bh.ou((String) y.get(".mallProductInfo.sellerInfo.appID"));
        mVar.pep.name = bh.ou((String) y.get(".mallProductInfo.sellerInfo.appName"));
        mVar.pep.username = bh.ou((String) y.get(".mallProductInfo.sellerInfo.usrName"));
        return mVar;
    }

    public final String bji() {
        if (this.peo != null && this.peo.peL != null && !bh.ov(this.peo.peL.oZC)) {
            return this.peo.peL.oZC;
        }
        if (this.peo == null || this.peo.peC == null || this.peo.peC.size() <= 0) {
            return null;
        }
        return (String) this.peo.peC.get(0);
    }
}
