package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.a;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.blz;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab extends c<gw> implements e {
    private ProgressDialog iln;
    gw lNr;

    public ab() {
        this.xen = gw.class.getName().hashCode();
    }

    private boolean a(gw gwVar) {
        if (gwVar instanceof gw) {
            this.lNr = gwVar;
            String str = this.lNr.fxb.result;
            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[]{Integer.valueOf(this.lNr.fxb.actionCode), str});
            if (!bh.ov(str)) {
                switch (this.lNr.fxb.actionCode) {
                    case 15:
                        if (this.lNr.fxb.context != null && (this.lNr.fxb.context instanceof Activity)) {
                            ar.CG().a(540, this);
                            final k uVar = new u(str);
                            ar.CG().a(uVar, 0);
                            Context context = this.lNr.fxb.context;
                            this.lNr.fxb.context.getString(R.l.dGO);
                            this.iln = h.a(context, this.lNr.fxb.context.getString(R.l.eHP), new OnCancelListener(this) {
                                final /* synthetic */ ab lNt;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ar.CG().c(uVar);
                                    if (this.lNt.lNr.fqI != null) {
                                        this.lNt.lNr.fxc.ret = 1;
                                        this.lNt.lNr.fqI.run();
                                    }
                                }
                            });
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (kVar == null) {
            aEi();
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 540) {
                ar.CG().b(540, this);
                u uVar = (u) kVar;
                beu com_tencent_mm_protocal_c_beu = (uVar.gJQ == null || uVar.gJQ.hmh.hmo == null) ? null : (beu) uVar.gJQ.hmh.hmo;
                if (com_tencent_mm_protocal_c_beu == null) {
                    x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
                    aEi();
                    return;
                }
                String str2;
                String str3;
                LinkedList linkedList;
                String str4;
                ArrayList arrayList;
                int i3;
                blz com_tencent_mm_protocal_c_blz;
                Intent intent;
                Object obj;
                boolean contains;
                arp com_tencent_mm_protocal_c_arp;
                String ou;
                af WO;
                af xVar;
                bla com_tencent_mm_protocal_c_bla;
                d jK;
                pq pqVar;
                ajr com_tencent_mm_protocal_c_ajr = com_tencent_mm_protocal_c_beu.vLR;
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[]{com_tencent_mm_protocal_c_ajr.ksX, com_tencent_mm_protocal_c_ajr.vJA});
                ajs com_tencent_mm_protocal_c_ajs = com_tencent_mm_protocal_c_beu.vLS;
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[]{com_tencent_mm_protocal_c_ajs.vJh, com_tencent_mm_protocal_c_ajs.wqJ, Integer.valueOf(com_tencent_mm_protocal_c_ajs.wqM), com_tencent_mm_protocal_c_ajs.wqK, Integer.valueOf(com_tencent_mm_protocal_c_ajs.wqL), com_tencent_mm_protocal_c_ajs.vLs});
                String str5 = "";
                String str6 = "";
                LinkedList linkedList2 = new LinkedList();
                if (com_tencent_mm_protocal_c_beu.wKg != null) {
                    if (com_tencent_mm_protocal_c_beu.wKg.vHw != null) {
                        str5 = com_tencent_mm_protocal_c_beu.wKg.vHw;
                    }
                    if (com_tencent_mm_protocal_c_beu.wKg.title != null) {
                        str6 = com_tencent_mm_protocal_c_beu.wKg.title;
                    }
                    if (com_tencent_mm_protocal_c_beu.wKg.vHx != null) {
                        str2 = str5;
                        str3 = str6;
                        linkedList = com_tencent_mm_protocal_c_beu.wKg.vHx;
                        str4 = str3;
                        arrayList = new ArrayList();
                        if (linkedList != null && linkedList.size() > 0) {
                            for (i3 = 0; i3 < linkedList.size(); i3++) {
                                com_tencent_mm_protocal_c_blz = (blz) linkedList.get(i3);
                                if (com_tencent_mm_protocal_c_blz.type.contains("text")) {
                                    arrayList.add(com_tencent_mm_protocal_c_blz.content);
                                }
                            }
                        }
                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{com_tencent_mm_protocal_c_beu.vLx});
                        if (com_tencent_mm_protocal_c_beu.wKf != 1) {
                            intent = new Intent();
                            intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                            obj = (com_tencent_mm_protocal_c_ajs.wqK.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || com_tencent_mm_protocal_c_ajs.wqK.contains("1")) ? 1 : null;
                            contains = com_tencent_mm_protocal_c_ajs.wqK.contains("4");
                            if (obj == null && contains) {
                                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
                                return;
                            }
                            if (obj != null) {
                                intent.putExtra("device_scan_conn_proto", "blue");
                            } else if (contains) {
                                intent.putExtra("device_scan_conn_proto", "wifi");
                            }
                            intent.putExtra("device_id", com_tencent_mm_protocal_c_ajr.ksX);
                            intent.putExtra("device_type", com_tencent_mm_protocal_c_ajr.vJA);
                            intent.putExtra("device_title", com_tencent_mm_protocal_c_ajs.wqQ);
                            intent.putExtra("device_desc", com_tencent_mm_protocal_c_ajs.wqR);
                            intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_ajs.nfT);
                            intent.putExtra("device_category_id", com_tencent_mm_protocal_c_ajs.wqS);
                            intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_ajs.wqJ);
                            intent.putExtra("bind_ticket", com_tencent_mm_protocal_c_beu.vLx);
                            intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_ajs.gfS);
                            intent.putExtra("device_airkiss_key", str2);
                            intent.putExtra("device_airkiss_title", str4);
                            intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                            com.tencent.mm.bm.d.b(this.lNr.fxb.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                            arf();
                        }
                        com_tencent_mm_protocal_c_arp = com_tencent_mm_protocal_c_beu.vLy;
                        if (com_tencent_mm_protocal_c_arp != null) {
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                            aEi();
                            return;
                        }
                        arf();
                        if (com_tencent_mm_protocal_c_arp != null) {
                            x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        } else {
                            str2 = n.a(com_tencent_mm_protocal_c_arp.vYI);
                            ou = bh.ou(com_tencent_mm_protocal_c_arp.wzi);
                            if (bh.ov(str2) || !bh.ov(ou)) {
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                                ar.Hg();
                                WO = com.tencent.mm.z.c.EY().WO(str2);
                                if (WO == null && str2.equals(WO.field_encryptUsername)) {
                                    x.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                                } else {
                                    xVar = new com.tencent.mm.storage.x(str2);
                                    xVar.cZ(com_tencent_mm_protocal_c_arp.hvy);
                                    xVar.setType(com_tencent_mm_protocal_c_arp.vXM & com_tencent_mm_protocal_c_arp.vXN);
                                    if (bh.ov(ou)) {
                                        xVar.di(ou);
                                    } else if (WO != null && ((int) WO.gJd) > 0) {
                                        xVar.di(WO.field_encryptUsername);
                                    }
                                    xVar.gJd = WO != null ? 0 : (long) ((int) WO.gJd);
                                    xVar.dc(n.a(com_tencent_mm_protocal_c_arp.wsB));
                                    xVar.dd(n.a(com_tencent_mm_protocal_c_arp.vYw));
                                    xVar.de(n.a(com_tencent_mm_protocal_c_arp.vYx));
                                    xVar.eD(com_tencent_mm_protocal_c_arp.hvt);
                                    xVar.eG(com_tencent_mm_protocal_c_arp.vXS);
                                    xVar.db(n.a(com_tencent_mm_protocal_c_arp.wzc));
                                    xVar.eH(com_tencent_mm_protocal_c_arp.vXW);
                                    xVar.eI(com_tencent_mm_protocal_c_arp.hvx);
                                    xVar.dv(RegionCodeDecoder.ah(com_tencent_mm_protocal_c_arp.hvC, com_tencent_mm_protocal_c_arp.hvu, com_tencent_mm_protocal_c_arp.hvv));
                                    xVar.dp(com_tencent_mm_protocal_c_arp.hvw);
                                    xVar.ez(com_tencent_mm_protocal_c_arp.wvf);
                                    xVar.du(com_tencent_mm_protocal_c_arp.wvg);
                                    xVar.setSource(com_tencent_mm_protocal_c_arp.vHW);
                                    xVar.ey(com_tencent_mm_protocal_c_arp.wvj);
                                    xVar.df(com_tencent_mm_protocal_c_arp.wvi);
                                    if (s.ht(com_tencent_mm_protocal_c_arp.wvh)) {
                                        xVar.dt(com_tencent_mm_protocal_c_arp.wvh);
                                    }
                                    xVar.eK((int) bh.Wo());
                                    xVar.da(n.a(com_tencent_mm_protocal_c_arp.wyH));
                                    xVar.dg(n.a(com_tencent_mm_protocal_c_arp.wyJ));
                                    xVar.dh(n.a(com_tencent_mm_protocal_c_arp.wyI));
                                    xVar.dw(com_tencent_mm_protocal_c_arp.vIO);
                                    xVar.dx(com_tencent_mm_protocal_c_arp.wzs);
                                    if (!(WO == null || bh.ou(WO.fWz).equals(bh.ou(com_tencent_mm_protocal_c_arp.wzs)))) {
                                        com.tencent.mm.bb.c.QL();
                                        com.tencent.mm.bb.c.lQ(str2);
                                    }
                                    ar.Hg();
                                    com.tencent.mm.z.c.EY().WT(str2);
                                    if (bh.ov(xVar.field_username)) {
                                        str5 = xVar.field_username;
                                        com.tencent.mm.ad.n.JQ().a(b.a(str5, com_tencent_mm_protocal_c_arp));
                                        com_tencent_mm_protocal_c_bla = com_tencent_mm_protocal_c_arp.wvl;
                                        if (!(xVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_bla == null)) {
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bla.hvE + " " + com_tencent_mm_protocal_c_arp.vYI);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + com_tencent_mm_protocal_c_bla.hvF);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.hvG);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.wOs);
                                            if (com.tencent.mm.plugin.sns.b.n.qQz != null) {
                                                com.tencent.mm.plugin.sns.b.n.qQz.a(xVar.field_username, com_tencent_mm_protocal_c_bla);
                                            }
                                        }
                                        str6 = q.FS();
                                        if (!(str6 == null || str6.equals(str5))) {
                                            jK = y.Mf().jK(str5);
                                            jK.field_username = str5;
                                            jK.field_brandList = com_tencent_mm_protocal_c_arp.hvD;
                                            pqVar = com_tencent_mm_protocal_c_arp.wvm;
                                            if (pqVar != null) {
                                                jK.field_brandFlag = pqVar.hvH;
                                                jK.field_brandInfo = pqVar.hvJ;
                                                jK.field_brandIconURL = pqVar.hvK;
                                                jK.field_extInfo = pqVar.hvI;
                                                jK.field_attrSyncVersion = null;
                                                jK.field_incrementUpdateTime = 0;
                                            }
                                            if (!y.Mf().e(jK)) {
                                                y.Mf().d(jK);
                                            }
                                            xVar.eL(jK.field_type);
                                        }
                                    } else {
                                        x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                    }
                                    xVar.eB(com_tencent_mm_protocal_c_arp.wzr);
                                    if (!(com_tencent_mm_protocal_c_arp.wzn == null || com_tencent_mm_protocal_c_arp.wzn.vHl == null)) {
                                        xVar.dy(com_tencent_mm_protocal_c_arp.wzn.vHl.vLU);
                                        xVar.dz(com_tencent_mm_protocal_c_arp.wzn.vHl.vLV);
                                        xVar.dA(com_tencent_mm_protocal_c_arp.wzn.vHl.vLW);
                                    }
                                    if (s.hn(str2)) {
                                        xVar.Ap();
                                    }
                                    if (xVar.cia()) {
                                        xVar.As();
                                    }
                                    if (bh.ov(ou)) {
                                        ar.Hg();
                                        com.tencent.mm.z.c.EY().b(ou, xVar);
                                    } else {
                                        ar.Hg();
                                        com.tencent.mm.z.c.EY().Q(xVar);
                                    }
                                    if (!(WO == null || (WO.field_type & 2048) == (xVar.field_type & 2048))) {
                                        if ((xVar.field_type & 2048) == 0) {
                                            ar.Hg();
                                            com.tencent.mm.z.c.Fd().Xd(xVar.field_username);
                                        } else {
                                            ar.Hg();
                                            com.tencent.mm.z.c.Fd().Xe(xVar.field_username);
                                        }
                                    }
                                }
                            } else {
                                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[]{str2, ou});
                            }
                        }
                        str5 = n.a(com_tencent_mm_protocal_c_arp.vYI);
                        if (this.lNr != null || this.lNr.fxb == null || this.lNr.fxb.context == null) {
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                            return;
                        }
                        ar.Hg();
                        af WO2 = com.tencent.mm.z.c.EY().WO(str5);
                        if (WO2 == null) {
                            return;
                        }
                        if (com_tencent_mm_protocal_c_ajs.gfR != 0) {
                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
                            Context context = this.lNr.fxb.context;
                            Intent intent2 = new Intent(context, ExdeviceDeviceProfileUI.class);
                            if (!(context instanceof Activity)) {
                                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            }
                            intent2.putExtra("device_id", com_tencent_mm_protocal_c_ajr.ksX);
                            intent2.putExtra("device_type", com_tencent_mm_protocal_c_ajr.vJA);
                            intent2.putExtra("device_mac", com_tencent_mm_protocal_c_ajs.vLs);
                            intent2.putExtra("device_brand_name", com_tencent_mm_protocal_c_ajs.wqJ);
                            intent2.putExtra("device_alias", com_tencent_mm_protocal_c_ajs.hvy);
                            intent2.putExtra("device_desc", com_tencent_mm_protocal_c_ajs.wqR);
                            intent2.putExtra("device_title", com_tencent_mm_protocal_c_ajs.wqQ);
                            intent2.putExtra("device_icon_url", com_tencent_mm_protocal_c_ajs.nfT);
                            intent2.putExtra("device_jump_url", com_tencent_mm_protocal_c_ajs.nfg);
                            intent2.putExtra("bind_ticket", com_tencent_mm_protocal_c_beu.vLx);
                            intent2.putExtra("device_has_bound", ad.aEk().cp(WO2.field_username, com_tencent_mm_protocal_c_ajr.ksX) != null);
                            context.startActivity(intent2);
                            return;
                        }
                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                        intent = new Intent();
                        intent.putExtra("Contact_User", str5);
                        intent.putExtra("KIsHardDevice", true);
                        intent.putExtra("KHardDeviceBindTicket", com_tencent_mm_protocal_c_beu.vLx);
                        intent.putExtra("device_id", com_tencent_mm_protocal_c_ajr.ksX);
                        intent.putExtra("device_type", com_tencent_mm_protocal_c_ajr.vJA);
                        a.lJS.d(intent, this.lNr.fxb.context);
                        return;
                    }
                }
                str2 = str5;
                str3 = str6;
                linkedList = linkedList2;
                str4 = str3;
                arrayList = new ArrayList();
                for (i3 = 0; i3 < linkedList.size(); i3++) {
                    com_tencent_mm_protocal_c_blz = (blz) linkedList.get(i3);
                    if (com_tencent_mm_protocal_c_blz.type.contains("text")) {
                        arrayList.add(com_tencent_mm_protocal_c_blz.content);
                    }
                }
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{com_tencent_mm_protocal_c_beu.vLx});
                if (com_tencent_mm_protocal_c_beu.wKf != 1) {
                    com_tencent_mm_protocal_c_arp = com_tencent_mm_protocal_c_beu.vLy;
                    if (com_tencent_mm_protocal_c_arp != null) {
                        arf();
                        if (com_tencent_mm_protocal_c_arp != null) {
                            str2 = n.a(com_tencent_mm_protocal_c_arp.vYI);
                            ou = bh.ou(com_tencent_mm_protocal_c_arp.wzi);
                            if (bh.ov(str2)) {
                            }
                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                            ar.Hg();
                            WO = com.tencent.mm.z.c.EY().WO(str2);
                            if (WO == null) {
                            }
                            xVar = new com.tencent.mm.storage.x(str2);
                            xVar.cZ(com_tencent_mm_protocal_c_arp.hvy);
                            xVar.setType(com_tencent_mm_protocal_c_arp.vXM & com_tencent_mm_protocal_c_arp.vXN);
                            if (bh.ov(ou)) {
                                xVar.di(WO.field_encryptUsername);
                            } else {
                                xVar.di(ou);
                            }
                            if (WO != null) {
                            }
                            xVar.gJd = WO != null ? 0 : (long) ((int) WO.gJd);
                            xVar.dc(n.a(com_tencent_mm_protocal_c_arp.wsB));
                            xVar.dd(n.a(com_tencent_mm_protocal_c_arp.vYw));
                            xVar.de(n.a(com_tencent_mm_protocal_c_arp.vYx));
                            xVar.eD(com_tencent_mm_protocal_c_arp.hvt);
                            xVar.eG(com_tencent_mm_protocal_c_arp.vXS);
                            xVar.db(n.a(com_tencent_mm_protocal_c_arp.wzc));
                            xVar.eH(com_tencent_mm_protocal_c_arp.vXW);
                            xVar.eI(com_tencent_mm_protocal_c_arp.hvx);
                            xVar.dv(RegionCodeDecoder.ah(com_tencent_mm_protocal_c_arp.hvC, com_tencent_mm_protocal_c_arp.hvu, com_tencent_mm_protocal_c_arp.hvv));
                            xVar.dp(com_tencent_mm_protocal_c_arp.hvw);
                            xVar.ez(com_tencent_mm_protocal_c_arp.wvf);
                            xVar.du(com_tencent_mm_protocal_c_arp.wvg);
                            xVar.setSource(com_tencent_mm_protocal_c_arp.vHW);
                            xVar.ey(com_tencent_mm_protocal_c_arp.wvj);
                            xVar.df(com_tencent_mm_protocal_c_arp.wvi);
                            if (s.ht(com_tencent_mm_protocal_c_arp.wvh)) {
                                xVar.dt(com_tencent_mm_protocal_c_arp.wvh);
                            }
                            xVar.eK((int) bh.Wo());
                            xVar.da(n.a(com_tencent_mm_protocal_c_arp.wyH));
                            xVar.dg(n.a(com_tencent_mm_protocal_c_arp.wyJ));
                            xVar.dh(n.a(com_tencent_mm_protocal_c_arp.wyI));
                            xVar.dw(com_tencent_mm_protocal_c_arp.vIO);
                            xVar.dx(com_tencent_mm_protocal_c_arp.wzs);
                            com.tencent.mm.bb.c.QL();
                            com.tencent.mm.bb.c.lQ(str2);
                            ar.Hg();
                            com.tencent.mm.z.c.EY().WT(str2);
                            if (bh.ov(xVar.field_username)) {
                                str5 = xVar.field_username;
                                com.tencent.mm.ad.n.JQ().a(b.a(str5, com_tencent_mm_protocal_c_arp));
                                com_tencent_mm_protocal_c_bla = com_tencent_mm_protocal_c_arp.wvl;
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bla.hvE + " " + com_tencent_mm_protocal_c_arp.vYI);
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + com_tencent_mm_protocal_c_bla.hvF);
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.hvG);
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.wOs);
                                if (com.tencent.mm.plugin.sns.b.n.qQz != null) {
                                    com.tencent.mm.plugin.sns.b.n.qQz.a(xVar.field_username, com_tencent_mm_protocal_c_bla);
                                }
                                str6 = q.FS();
                                jK = y.Mf().jK(str5);
                                jK.field_username = str5;
                                jK.field_brandList = com_tencent_mm_protocal_c_arp.hvD;
                                pqVar = com_tencent_mm_protocal_c_arp.wvm;
                                if (pqVar != null) {
                                    jK.field_brandFlag = pqVar.hvH;
                                    jK.field_brandInfo = pqVar.hvJ;
                                    jK.field_brandIconURL = pqVar.hvK;
                                    jK.field_extInfo = pqVar.hvI;
                                    jK.field_attrSyncVersion = null;
                                    jK.field_incrementUpdateTime = 0;
                                }
                                if (y.Mf().e(jK)) {
                                    y.Mf().d(jK);
                                }
                                xVar.eL(jK.field_type);
                            } else {
                                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                            }
                            xVar.eB(com_tencent_mm_protocal_c_arp.wzr);
                            xVar.dy(com_tencent_mm_protocal_c_arp.wzn.vHl.vLU);
                            xVar.dz(com_tencent_mm_protocal_c_arp.wzn.vHl.vLV);
                            xVar.dA(com_tencent_mm_protocal_c_arp.wzn.vHl.vLW);
                            if (s.hn(str2)) {
                                xVar.Ap();
                            }
                            if (xVar.cia()) {
                                xVar.As();
                            }
                            if (bh.ov(ou)) {
                                ar.Hg();
                                com.tencent.mm.z.c.EY().Q(xVar);
                            } else {
                                ar.Hg();
                                com.tencent.mm.z.c.EY().b(ou, xVar);
                            }
                            if ((xVar.field_type & 2048) == 0) {
                                ar.Hg();
                                com.tencent.mm.z.c.Fd().Xe(xVar.field_username);
                            } else {
                                ar.Hg();
                                com.tencent.mm.z.c.Fd().Xd(xVar.field_username);
                            }
                        } else {
                            x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        }
                        str5 = n.a(com_tencent_mm_protocal_c_arp.vYI);
                        if (this.lNr != null) {
                        }
                        x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                        return;
                    }
                    x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                    aEi();
                    return;
                }
                intent = new Intent();
                intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                if (!com_tencent_mm_protocal_c_ajs.wqK.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                }
                contains = com_tencent_mm_protocal_c_ajs.wqK.contains("4");
                if (obj == null) {
                }
                if (obj != null) {
                    intent.putExtra("device_scan_conn_proto", "blue");
                } else if (contains) {
                    intent.putExtra("device_scan_conn_proto", "wifi");
                }
                intent.putExtra("device_id", com_tencent_mm_protocal_c_ajr.ksX);
                intent.putExtra("device_type", com_tencent_mm_protocal_c_ajr.vJA);
                intent.putExtra("device_title", com_tencent_mm_protocal_c_ajs.wqQ);
                intent.putExtra("device_desc", com_tencent_mm_protocal_c_ajs.wqR);
                intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_ajs.nfT);
                intent.putExtra("device_category_id", com_tencent_mm_protocal_c_ajs.wqS);
                intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_ajs.wqJ);
                intent.putExtra("bind_ticket", com_tencent_mm_protocal_c_beu.vLx);
                intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_ajs.gfS);
                intent.putExtra("device_airkiss_key", str2);
                intent.putExtra("device_airkiss_title", str4);
                intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                com.tencent.mm.bm.d.b(this.lNr.fxb.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                arf();
            }
        } else {
            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            aEi();
        }
    }

    private void aEi() {
        if (this.lNr != null && this.lNr.fqI != null) {
            this.lNr.fxc.ret = 1;
            this.lNr.fqI.run();
        }
    }

    private void arf() {
        if (this.lNr != null && this.lNr.fqI != null) {
            this.lNr.fxc.ret = 2;
            this.lNr.fqI.run();
        }
    }
}
