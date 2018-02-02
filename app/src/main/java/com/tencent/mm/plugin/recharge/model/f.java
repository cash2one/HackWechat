package com.tencent.mm.plugin.recharge.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.avo;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends k implements com.tencent.mm.network.k {
    public String appId;
    public int cmdId;
    public String desc;
    public int errCode;
    public String fnL;
    private b gJQ;
    private e gJT;
    public boolean pCc;
    public ArrayList<n> pCd;
    public ArrayList<n> pCe;
    public d pCf;
    public d pCg;
    public d pCh;
    public d pCi;
    public d pCj;
    public m pCk;
    public List<a> pCl;
    public boolean pCm;
    public String phQ;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        this.phQ = "";
        this.appId = "";
        this.pCc = false;
        this.desc = "";
        this.errCode = 0;
        this.fnL = "";
        this.pCm = false;
        this.phQ = str;
        a aVar = new a();
        aVar.hmj = new avo();
        aVar.hmk = new avp();
        aVar.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        aVar.hmi = 1571;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        avo com_tencent_mm_protocal_c_avo = (avo) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_avo.vXp = i;
        this.cmdId = i;
        x.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[]{Integer.valueOf(i)});
        if (!bh.ov(this.phQ)) {
            x.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[]{this.phQ});
            com_tencent_mm_protocal_c_avo.wDm = String.format("phone=%s", new Object[]{this.phQ});
        }
    }

    public final int getType() {
        return 1571;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            try {
                int i4;
                String optString;
                String optString2;
                JSONArray optJSONArray;
                JSONObject optJSONObject;
                String optString3;
                JSONObject jSONObject = new JSONObject(((avp) ((b) qVar).hmh.hmo).wDn);
                x.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[]{jSONObject.toString()});
                this.appId = jSONObject.optString("appId");
                this.errCode = jSONObject.optInt("errCode", -1);
                this.fnL = jSONObject.optString("errMsg", ac.getContext().getString(i.uSl));
                if (this.errCode < 0) {
                    this.pCc = true;
                } else {
                    this.pCc = false;
                }
                this.desc = jSONObject.optString("desc");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("productList");
                if (optJSONArray2 != null) {
                    this.pCd = new ArrayList();
                    this.pCe = new ArrayList();
                    for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                        n nVar = new n();
                        nVar.desc = jSONObject2.optString("desc", "");
                        nVar.id = jSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID, "");
                        nVar.name = jSONObject2.optString("name", "");
                        nVar.status = jSONObject2.optInt(DownloadInfo.STATUS, 0);
                        nVar.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
                        nVar.type = jSONObject2.optInt(DownloadSettingTable$Columns.TYPE);
                        nVar.sDM = jSONObject2.optString("typeName");
                        nVar.sDO = jSONObject2.optString("isColor", "0");
                        nVar.sDP = jSONObject2.optString("colorCode", "0");
                        nVar.sDQ = jSONObject2.optInt("isReConfirm", 0);
                        if (nVar.type == 1) {
                            this.pCd.add(nVar);
                        } else {
                            nVar.sDN = jSONObject2.optString("productAttr");
                            this.pCe.add(nVar);
                        }
                    }
                } else {
                    this.pCd = null;
                    this.pCe = null;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("weSim");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bh.ov(optString) || bh.ov(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
                        this.pCi = null;
                    } else {
                        this.pCi = new d();
                        this.pCi.url = optString;
                        this.pCi.name = optString2;
                    }
                }
                optJSONObject2 = jSONObject.optJSONObject("wxRemind");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bh.ov(optString) || bh.ov(optString2)) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
                    } else {
                        this.pCf = new d();
                        this.pCf.url = optString;
                        this.pCf.name = optString2;
                        optJSONObject2 = jSONObject.optJSONObject("wxCard");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject2.optString("name");
                            if (!bh.ov(optString) || bh.ov(optString2)) {
                                x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                            } else {
                                this.pCg = new d();
                                this.pCg.url = optString;
                                this.pCg.name = optString2;
                                optJSONObject2 = jSONObject.optJSONObject("wxWt");
                                if (optJSONObject2 != null) {
                                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    optString2 = optJSONObject2.optString("name");
                                    if (!bh.ov(optString) || bh.ov(optString2)) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                                    } else {
                                        this.pCh = new d();
                                        this.pCh.url = optString;
                                        this.pCh.name = optString2;
                                        optJSONObject2 = jSONObject.optJSONObject("banner");
                                        if (optJSONObject2 == null) {
                                            this.pCk = new m();
                                            this.pCk.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                            this.pCk.name = optJSONObject2.optString("name");
                                            this.pCk.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                        } else {
                                            this.pCk = null;
                                        }
                                        optJSONObject2 = jSONObject.optJSONObject("headEnter");
                                        if (optJSONObject2 != null) {
                                            optString = optJSONObject2.optString("name");
                                            optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                            if (!bh.ov(optString) || bh.ov(optString2)) {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                            } else {
                                                this.pCj = new d();
                                                this.pCj.name = optString;
                                                this.pCj.url = optString2;
                                                optJSONArray = jSONObject.optJSONArray("numberList");
                                                if (optJSONArray != null) {
                                                    if (bh.ov(this.phQ)) {
                                                        this.pCm = true;
                                                    }
                                                    if (optJSONArray.length() <= 0) {
                                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                        this.pCl = null;
                                                    } else {
                                                        this.pCl = new ArrayList();
                                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                            optJSONObject = optJSONArray.optJSONObject(i4);
                                                            if (optJSONObject != null) {
                                                                optString3 = optJSONObject.optString("number");
                                                                optString = optJSONObject.optString("desc");
                                                                if (!bh.ov(optString3)) {
                                                                    this.pCl.add(new a(optString3, "", optString, 2));
                                                                }
                                                            }
                                                        }
                                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.pCl.size())});
                                                    }
                                                } else {
                                                    this.pCl = null;
                                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                                }
                                            }
                                        }
                                        this.pCj = null;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                            this.pCl = null;
                                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                        } else {
                                            if (bh.ov(this.phQ)) {
                                                this.pCm = true;
                                            }
                                            if (optJSONArray.length() <= 0) {
                                                this.pCl = new ArrayList();
                                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                    optJSONObject = optJSONArray.optJSONObject(i4);
                                                    if (optJSONObject != null) {
                                                        optString3 = optJSONObject.optString("number");
                                                        optString = optJSONObject.optString("desc");
                                                        if (!bh.ov(optString3)) {
                                                            this.pCl.add(new a(optString3, "", optString, 2));
                                                        }
                                                    }
                                                }
                                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.pCl.size())});
                                            } else {
                                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                this.pCl = null;
                                            }
                                        }
                                    }
                                }
                                this.pCh = null;
                                optJSONObject2 = jSONObject.optJSONObject("banner");
                                if (optJSONObject2 == null) {
                                    this.pCk = null;
                                } else {
                                    this.pCk = new m();
                                    this.pCk.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                    this.pCk.name = optJSONObject2.optString("name");
                                    this.pCk.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                }
                                optJSONObject2 = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject2 != null) {
                                    optString = optJSONObject2.optString("name");
                                    optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    if (bh.ov(optString)) {
                                    }
                                    x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                }
                                this.pCj = null;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    if (bh.ov(this.phQ)) {
                                        this.pCm = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.pCl = null;
                                    } else {
                                        this.pCl = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            optJSONObject = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject != null) {
                                                optString3 = optJSONObject.optString("number");
                                                optString = optJSONObject.optString("desc");
                                                if (!bh.ov(optString3)) {
                                                    this.pCl.add(new a(optString3, "", optString, 2));
                                                }
                                            }
                                        }
                                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.pCl.size())});
                                    }
                                } else {
                                    this.pCl = null;
                                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                }
                            }
                        }
                        this.pCg = null;
                        optJSONObject2 = jSONObject.optJSONObject("wxWt");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject2.optString("name");
                            if (bh.ov(optString)) {
                            }
                            x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                        }
                        this.pCh = null;
                        optJSONObject2 = jSONObject.optJSONObject("banner");
                        if (optJSONObject2 == null) {
                            this.pCk = new m();
                            this.pCk.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                            this.pCk.name = optJSONObject2.optString("name");
                            this.pCk.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        } else {
                            this.pCk = null;
                        }
                        optJSONObject2 = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString("name");
                            optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            if (bh.ov(optString)) {
                            }
                            x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                        }
                        this.pCj = null;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                            this.pCl = null;
                            x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                        } else {
                            if (bh.ov(this.phQ)) {
                                this.pCm = true;
                            }
                            if (optJSONArray.length() <= 0) {
                                this.pCl = new ArrayList();
                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    optJSONObject = optJSONArray.optJSONObject(i4);
                                    if (optJSONObject != null) {
                                        optString3 = optJSONObject.optString("number");
                                        optString = optJSONObject.optString("desc");
                                        if (!bh.ov(optString3)) {
                                            this.pCl.add(new a(optString3, "", optString, 2));
                                        }
                                    }
                                }
                                x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.pCl.size())});
                            } else {
                                x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                this.pCl = null;
                            }
                        }
                    }
                }
                this.pCf = null;
                optJSONObject2 = jSONObject.optJSONObject("wxCard");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bh.ov(optString)) {
                    }
                    x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                }
                this.pCg = null;
                optJSONObject2 = jSONObject.optJSONObject("wxWt");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bh.ov(optString)) {
                    }
                    x.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                }
                this.pCh = null;
                optJSONObject2 = jSONObject.optJSONObject("banner");
                if (optJSONObject2 == null) {
                    this.pCk = null;
                } else {
                    this.pCk = new m();
                    this.pCk.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                    this.pCk.name = optJSONObject2.optString("name");
                    this.pCk.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                }
                optJSONObject2 = jSONObject.optJSONObject("headEnter");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString("name");
                    optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    if (bh.ov(optString)) {
                    }
                    x.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                }
                this.pCj = null;
                optJSONArray = jSONObject.optJSONArray("numberList");
                if (optJSONArray != null) {
                    if (bh.ov(this.phQ)) {
                        this.pCm = true;
                    }
                    if (optJSONArray.length() <= 0) {
                        x.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                        this.pCl = null;
                    } else {
                        this.pCl = new ArrayList();
                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                            optJSONObject = optJSONArray.optJSONObject(i4);
                            if (optJSONObject != null) {
                                optString3 = optJSONObject.optString("number");
                                optString = optJSONObject.optString("desc");
                                if (!bh.ov(optString3)) {
                                    this.pCl.add(new a(optString3, "", optString, 2));
                                }
                            }
                        }
                        x.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.pCl.size())});
                    }
                } else {
                    this.pCl = null;
                    x.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                }
            } catch (Exception e) {
                x.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[]{e.toString()});
                this.pCc = true;
                this.fnL = ac.getContext().getString(i.uSl);
            }
        } else {
            this.pCc = true;
            if (bh.ov(str)) {
                str = ac.getContext().getString(i.uRf);
            }
            this.fnL = str;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
