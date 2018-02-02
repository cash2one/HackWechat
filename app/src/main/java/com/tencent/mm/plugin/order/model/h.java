package com.tencent.mm.plugin.order.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends i {
    public MallOrderDetailObject pbg;
    private int pbh;

    public h(String str) {
        this(str, null, -1);
    }

    public h(String str, String str2) {
        this(str, str2, -1);
    }

    public h(String str, String str2, int i) {
        this.pbg = null;
        this.pbh = -1;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        if (!bh.ov(str2)) {
            hashMap.put("bill_id", str2);
        }
        if (this.pbh >= 0) {
            this.pbh = i;
        }
        D(hashMap);
    }

    public final int ayQ() {
        return 108;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pbg = new MallOrderDetailObject();
            MallOrderDetailObject mallOrderDetailObject = this.pbg;
            if (jSONObject != null) {
                try {
                    mallOrderDetailObject.oZV = MallTransactionObject.P(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
                }
                try {
                    b bVar;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status_section");
                    if (jSONObject2 != null) {
                        bVar = new b();
                        bVar.pae = jSONObject2.optString("last_status_name");
                        bVar.time = jSONObject2.optInt("time");
                        bVar.thumbUrl = jSONObject2.optString("thumb_url");
                        bVar.nfg = jSONObject2.optString("jump_url");
                        bVar.paf = jSONObject2.optString("last_status_desc");
                    } else {
                        bVar = null;
                    }
                    mallOrderDetailObject.oZW = bVar;
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22, "", new Object[0]);
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222, "", new Object[0]);
                }
                try {
                    mallOrderDetailObject.oZX = MallOrderDetailObject.N(jSONObject);
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222, "", new Object[0]);
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22222, "", new Object[0]);
                }
                try {
                    List list;
                    int i2;
                    JSONArray jSONArray = jSONObject.getJSONArray("normal_sections");
                    if (jSONArray == null || jSONArray.length() == 0) {
                        list = null;
                    } else {
                        List arrayList = new ArrayList();
                        i2 = 0;
                        boolean z = false;
                        while (i2 < jSONArray.length()) {
                            boolean z2;
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            a aVar = new a();
                            aVar.kKb = jSONObject3.optInt("is_bar") != 0;
                            aVar.name = jSONObject3.optString("name");
                            if (TextUtils.isEmpty(aVar.name)) {
                                z2 = aVar.kKb;
                            } else {
                                if (z) {
                                    aVar.kKb = z;
                                }
                                z2 = aVar.kKb;
                                aVar.value = jSONObject3.optString(DownloadSettingTable$Columns.VALUE);
                                aVar.jumpUrl = jSONObject3.optString("jump_url");
                                aVar.jumpType = jSONObject3.optInt("jump_type");
                                arrayList.add(aVar);
                            }
                            i2++;
                            z = z2;
                        }
                        list = arrayList;
                    }
                    mallOrderDetailObject.oZY = list;
                    list = mallOrderDetailObject.oZY;
                    JSONObject optJSONObject = jSONObject.optJSONObject("evaluate_section");
                    if (optJSONObject != null) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        a aVar2 = new a();
                        if (optJSONObject.has(DownloadSettingTable$Columns.VALUE)) {
                            aVar2.value = optJSONObject.optString(DownloadSettingTable$Columns.VALUE);
                            aVar2.type = 2;
                        } else {
                            aVar2.type = 1;
                        }
                        i2 = optJSONObject.optInt("order", 0);
                        if (i2 >= 0 && i2 <= optJSONObject.length() + 1) {
                            list.add(i2, aVar2);
                        }
                    }
                } catch (Throwable e222222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222222, "", new Object[0]);
                } catch (Throwable e2222222) {
                    x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222222, "", new Object[0]);
                }
                mallOrderDetailObject.pab = jSONObject.optString("safeguard_url");
                mallOrderDetailObject.lVH = jSONObject.optString("share_url");
                mallOrderDetailObject.pad = jSONObject.optInt("modifyTimeStamp");
                if (mallOrderDetailObject.oZW != null && mallOrderDetailObject.pad <= 0) {
                    mallOrderDetailObject.pad = mallOrderDetailObject.oZW.time;
                }
                if (mallOrderDetailObject.oZV != null) {
                    mallOrderDetailObject.pac = mallOrderDetailObject.oZV.pac;
                    mallOrderDetailObject.fvL = mallOrderDetailObject.oZV.paA;
                    mallOrderDetailObject.paa = mallOrderDetailObject.oZV.paa;
                    mallOrderDetailObject.oZZ = mallOrderDetailObject.oZV.oZZ;
                }
            }
        }
    }
}
