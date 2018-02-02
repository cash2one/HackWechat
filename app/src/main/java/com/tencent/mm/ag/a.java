package com.tencent.mm.ag;

import android.graphics.Bitmap;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.hi;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    static boolean b(d dVar) {
        if (dVar == null) {
            x.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            return false;
        } else if (!KV()) {
            return false;
        } else {
            int i = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("MMBizAttrSyncFreq", -1);
            if (i == -1) {
                x.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = dVar.field_incrementUpdateTime;
            String str = dVar.field_attrSyncVersion;
            x.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(j), Integer.valueOf(i), str});
            return currentTimeMillis - j >= ((long) i) * 1000;
        }
    }

    public static boolean KV() {
        int i;
        Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.xoV, null);
        if (obj == null || !(obj instanceof Integer)) {
            x.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i = 1;
        } else {
            i = ((Integer) obj).intValue();
        }
        x.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            return true;
        }
        return false;
    }

    public final boolean jw(String str) {
        if (bh.ov(str)) {
            x.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
            return false;
        }
        x.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
        d jK = y.Mf().jK(str);
        if (b(jK)) {
            g.Di().gPJ.a(new p(str, jK.field_attrSyncVersion, new 1(this, new WeakReference(null), str)), 0);
            return true;
        }
        x.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
        return false;
    }

    public static boolean a(com.tencent.mm.storage.x xVar, d dVar, List<hi> list) {
        if (xVar == null || list == null || list.size() == 0) {
            x.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
            return false;
        }
        String str = xVar.field_username;
        if (xVar.cia()) {
            if (dVar == null) {
                dVar = y.Mf().jK(str);
            }
            if (dVar == null) {
                x.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[]{str});
                return false;
            }
            JSONObject jSONObject;
            h jm = n.JQ().jm(str);
            try {
                if (bh.ov(dVar.field_extInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(dVar.field_extInfo);
                }
            } catch (Exception e) {
                x.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[]{e});
                jSONObject = new JSONObject();
            }
            long j = -1;
            long j2 = (long) xVar.field_type;
            int i = 0;
            Object obj = null;
            for (hi hiVar : list) {
                if (hiVar == null) {
                    x.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
                } else {
                    Object obj2;
                    int i2;
                    String str2 = hiVar.vNj;
                    x.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[]{str2, hiVar.pQt});
                    String str3 = hiVar.pQt;
                    if (!"UserName".equals(str2)) {
                        if ("NickName".equals(str2)) {
                            xVar.dc(str3);
                        } else if ("Alias".equals(str2)) {
                            xVar.cZ(str3);
                        } else if ("PYInitial".equals(str2)) {
                            xVar.dd(str3);
                        } else if ("QuanPin".equals(str2)) {
                            xVar.de(str3);
                        } else if ("VerifyFlag".equals(str2)) {
                            xVar.ez(bh.getInt(str3, xVar.field_verifyFlag));
                        } else if ("VerifyInfo".equals(str2)) {
                            xVar.du(str3);
                        } else if ("Signature".equals(str2)) {
                            xVar.dp(str3);
                        } else {
                            obj2 = null;
                            if (obj2 == null && !b(jSONObject, str2, hiVar.pQt)) {
                                str3 = hiVar.pQt;
                                if ("BrandInfo".equals(str2)) {
                                    dVar.field_brandInfo = str3;
                                } else if ("BrandIconURL".equals(str2)) {
                                    dVar.field_brandIconURL = str3;
                                } else if ("BrandFlag".equals(str2)) {
                                    if ("Appid".equals(str2)) {
                                        obj2 = null;
                                    } else if (str3.equals(dVar.field_appId)) {
                                        dVar.field_appId = str3;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 == null) {
                                        str3 = hiVar.pQt;
                                        if ("BigHeadImgUrl".equals(str2)) {
                                            if (!"SmallHeadImgUrl".equals(str2)) {
                                                obj2 = null;
                                                if (obj2 == null) {
                                                    i++;
                                                    obj = 1;
                                                } else if ("BitMask".equals(str2)) {
                                                    if ("BitVal".equals(str2)) {
                                                        i2 = i;
                                                    } else {
                                                        j2 = bh.getLong(hiVar.pQt, j2);
                                                        i2 = i + 1;
                                                    }
                                                    i = i2;
                                                } else {
                                                    j = bh.getLong(hiVar.pQt, j);
                                                    i++;
                                                }
                                            } else if (jm != null) {
                                                jm.hlx = str3;
                                            }
                                        } else if (jm != null) {
                                            jm.hly = str3;
                                        }
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            i++;
                                            obj = 1;
                                        } else if ("BitMask".equals(str2)) {
                                            if ("BitVal".equals(str2)) {
                                                i2 = i;
                                            } else {
                                                j2 = bh.getLong(hiVar.pQt, j2);
                                                i2 = i + 1;
                                            }
                                            i = i2;
                                        } else {
                                            j = bh.getLong(hiVar.pQt, j);
                                            i++;
                                        }
                                    }
                                } else {
                                    dVar.field_brandFlag = bh.getInt(str3, dVar.field_brandFlag);
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                    str3 = hiVar.pQt;
                                    if ("BigHeadImgUrl".equals(str2)) {
                                        if (!"SmallHeadImgUrl".equals(str2)) {
                                            obj2 = null;
                                            if (obj2 == null) {
                                                i++;
                                                obj = 1;
                                            } else if ("BitMask".equals(str2)) {
                                                j = bh.getLong(hiVar.pQt, j);
                                                i++;
                                            } else {
                                                if ("BitVal".equals(str2)) {
                                                    j2 = bh.getLong(hiVar.pQt, j2);
                                                    i2 = i + 1;
                                                } else {
                                                    i2 = i;
                                                }
                                                i = i2;
                                            }
                                        } else if (jm != null) {
                                            jm.hlx = str3;
                                        }
                                    } else if (jm != null) {
                                        jm.hly = str3;
                                    }
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        i++;
                                        obj = 1;
                                    } else if ("BitMask".equals(str2)) {
                                        if ("BitVal".equals(str2)) {
                                            i2 = i;
                                        } else {
                                            j2 = bh.getLong(hiVar.pQt, j2);
                                            i2 = i + 1;
                                        }
                                        i = i2;
                                    } else {
                                        j = bh.getLong(hiVar.pQt, j);
                                        i++;
                                    }
                                }
                            }
                            i++;
                        }
                    }
                    obj2 = 1;
                    str3 = hiVar.pQt;
                    if ("BrandInfo".equals(str2)) {
                        dVar.field_brandInfo = str3;
                    } else if ("BrandIconURL".equals(str2)) {
                        dVar.field_brandIconURL = str3;
                    } else if ("BrandFlag".equals(str2)) {
                        if ("Appid".equals(str2)) {
                            obj2 = null;
                        } else if (str3.equals(dVar.field_appId)) {
                            dVar.field_appId = str3;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            str3 = hiVar.pQt;
                            if ("BigHeadImgUrl".equals(str2)) {
                                if (jm != null) {
                                    jm.hly = str3;
                                }
                            } else if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = bh.getLong(hiVar.pQt, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = bh.getLong(hiVar.pQt, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (jm != null) {
                                jm.hlx = str3;
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                i++;
                                obj = 1;
                            } else if ("BitMask".equals(str2)) {
                                if ("BitVal".equals(str2)) {
                                    i2 = i;
                                } else {
                                    j2 = bh.getLong(hiVar.pQt, j2);
                                    i2 = i + 1;
                                }
                                i = i2;
                            } else {
                                j = bh.getLong(hiVar.pQt, j);
                                i++;
                            }
                        }
                        i++;
                    } else {
                        dVar.field_brandFlag = bh.getInt(str3, dVar.field_brandFlag);
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                        str3 = hiVar.pQt;
                        if ("BigHeadImgUrl".equals(str2)) {
                            if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = bh.getLong(hiVar.pQt, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = bh.getLong(hiVar.pQt, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (jm != null) {
                                jm.hlx = str3;
                            }
                        } else if (jm != null) {
                            jm.hly = str3;
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            i++;
                            obj = 1;
                        } else if ("BitMask".equals(str2)) {
                            if ("BitVal".equals(str2)) {
                                i2 = i;
                            } else {
                                j2 = bh.getLong(hiVar.pQt, j2);
                                i2 = i + 1;
                            }
                            i = i2;
                        } else {
                            j = bh.getLong(hiVar.pQt, j);
                            i++;
                        }
                    }
                    i++;
                }
            }
            if (i == 0) {
                x.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
                return false;
            }
            dVar.field_extInfo = jSONObject.toString();
            if (!(jm == null || r4 == null)) {
                n.JQ().a(jm);
                n.Jz();
                d.y(str, false);
                n.Jz();
                d.y(str, true);
                n.JS().iY(str);
                m$a Mn = y.Mn();
                if (!bh.ov(str)) {
                    x.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[]{str});
                    WeakReference weakReference = (WeakReference) Mn.hqb.remove(str);
                    if (weakReference != null) {
                        Bitmap bitmap = (Bitmap) weakReference.get();
                        if (bitmap != null) {
                            bitmap.isRecycled();
                        }
                    }
                }
            }
            xVar.setType(xVar.field_type | ((int) (j & j2)));
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().a(str, xVar);
            y.Mf().e(dVar);
            x.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
            return true;
        }
        x.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[]{str});
        return false;
    }

    private static boolean b(JSONObject jSONObject, String str, String str2) {
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, bh.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, bh.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, bh.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, bh.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, bh.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, bh.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, bh.getInt(str2, jSONObject.optInt(str)));
                            } else if ("NotifyManage".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("ServicePhone".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("IsTrademarkProtection".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if (!"CanReceiveLongVideo".equals(str)) {
                                if ("TrademarkUrl".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("TrademarkName".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("MMBizMenu".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("VerifySource".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if (!"MMBizTabbar".equals(str)) {
                                    if ("PayShowInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("HardwareBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("EnterpriseBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if (!"MainPage".equals(str)) {
                                        if ("RegisterSource".equals(str)) {
                                            jSONObject.put(str, str2);
                                        } else if (!"IBeaconBizInfo".equals(str)) {
                                            if ("WxaAppInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WxaAppVersionInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WXAppType".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("BindWxaInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if (!"AcctTransferInfo".equals(str)) {
                                                return false;
                                            } else {
                                                jSONObject.put(str, str2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            x.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[]{str, str2, e});
        }
        return true;
    }
}
