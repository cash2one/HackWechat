package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.g.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class g implements p {
    public final void a(ol olVar, byte[] bArr, boolean z, r rVar) {
        switch (olVar.vXp) {
            case 1:
                x xVar;
                asj com_tencent_mm_protocal_c_asj = (asj) new asj().aF(bArr);
                int i = com_tencent_mm_protocal_c_asj.wzS;
                com.tencent.mm.kernel.g.Dj().CU().get(2, null);
                t CU = com.tencent.mm.kernel.g.Dj().CU();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asj.wzS), Integer.valueOf(com_tencent_mm_protocal_c_asj.ktm), Integer.valueOf(com_tencent_mm_protocal_c_asj.vFu), Integer.valueOf(com_tencent_mm_protocal_c_asj.wzZ)});
                String a = n.a(com_tencent_mm_protocal_c_asj.vYI);
                String a2 = n.a(com_tencent_mm_protocal_c_asj.wsB);
                String a3 = n.a(com_tencent_mm_protocal_c_asj.wzT);
                String a4 = n.a(com_tencent_mm_protocal_c_asj.wzU);
                int i2 = com_tencent_mm_protocal_c_asj.vFr;
                af WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(a);
                if (WO == null || WO.field_username == null || !WO.field_username.equals(a)) {
                    xVar = new x(a);
                } else {
                    af afVar = WO;
                }
                xVar.cZ(com_tencent_mm_protocal_c_asj.hvy);
                xVar.dc(a2);
                xVar.dv(RegionCodeDecoder.ah(com_tencent_mm_protocal_c_asj.hvC, com_tencent_mm_protocal_c_asj.hvu, com_tencent_mm_protocal_c_asj.hvv));
                xVar.eD(com_tencent_mm_protocal_c_asj.hvt);
                xVar.dp(com_tencent_mm_protocal_c_asj.hvw);
                xVar.ey(com_tencent_mm_protocal_c_asj.wvj);
                xVar.dt(com_tencent_mm_protocal_c_asj.wvh);
                xVar.df(com_tencent_mm_protocal_c_asj.wvi);
                xVar.eE(i2);
                ((h) com.tencent.mm.kernel.g.h(h.class)).EY().Q(xVar);
                CU.set(2, a);
                CU.set(4, a2);
                CU.set(5, a3);
                CU.set(6, a4);
                CU.set(9, Integer.valueOf(i2));
                String str = "MicroMsg.UserInfoSyncExtension";
                StringBuilder stringBuilder = new StringBuilder("doCmd : status ");
                int i3 = com_tencent_mm_protocal_c_asj.ktm;
                String str2 = "code=" + Integer.toHexString(i3) + ", status = " + i3;
                if ((i3 & 1) != 0) {
                    str2 = str2 + ", open";
                }
                if ((i3 & 2) != 0) {
                    str2 = str2 + ", email-verified";
                }
                if ((i3 & 4) != 0) {
                    str2 = str2 + ", mobile-verified";
                }
                if ((i3 & 8) != 0) {
                    str2 = str2 + ", hide-qq-search";
                }
                if ((i3 & 16) != 0) {
                    str2 = str2 + ", hide-qq-promote";
                }
                if ((i3 & 32) != 0) {
                    str2 = str2 + ", need-verify";
                }
                if ((i3 & 64) != 0) {
                    str2 = str2 + ", has-qq-msg";
                }
                if ((i3 & FileUtils.S_IWUSR) != 0) {
                    str2 = str2 + ", no-qq-promote";
                }
                if ((i3 & 256) != 0) {
                    str2 = str2 + ", no-mobile-promote";
                }
                if ((i3 & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                    str2 = str2 + ", hide-mobile_search";
                }
                if ((i3 & Downloads.RECV_BUFFER_SIZE) != 0) {
                    str2 = str2 + ", open-float-bottle";
                }
                if ((i3 & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    str2 = str2 + ", bind but not upload";
                }
                com.tencent.mm.sdk.platformtools.x.d(str, stringBuilder.append(str2).toString());
                CU.set(7, Integer.valueOf(com_tencent_mm_protocal_c_asj.ktm));
                if (com_tencent_mm_protocal_c_asj.hvx != 0) {
                    bi biVar = new bi();
                    biVar.fWo = 1;
                    biVar.fWf = com_tencent_mm_protocal_c_asj.hvt;
                    biVar.signature = com_tencent_mm_protocal_c_asj.hvw;
                    biVar.countryCode = com_tencent_mm_protocal_c_asj.hvC;
                    biVar.hhx = com_tencent_mm_protocal_c_asj.hvu;
                    biVar.hhw = com_tencent_mm_protocal_c_asj.hvv;
                    biVar.fWt = com_tencent_mm_protocal_c_asj.wvh;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + biVar.fWt + " nickName :" + com_tencent_mm_protocal_c_asj.wvi);
                    bi.a(biVar);
                }
                str = "MicroMsg.UserInfoSyncExtension";
                stringBuilder = new StringBuilder("userinfo Plugstate: ");
                i3 = com_tencent_mm_protocal_c_asj.vFu;
                str2 = "code=" + Integer.toHexString(i3) + ", pluginFlag = " + i3;
                str2 = (i3 & 1) != 0 ? str2 + ", QQMAIL_UNINSTALL" : str2 + ", QQMAIL_INSTALL";
                str2 = (i3 & 2) != 0 ? str2 + ", PM_UNINSTALL" : str2 + ", PM_INSTALL";
                str2 = (i3 & 4) != 0 ? str2 + ", FM_UNINSTALL" : str2 + ", FM_INSTALL";
                str2 = (i3 & 8) != 0 ? str2 + ", WEIBO_UNINSTALL" : str2 + ", WEIBO_INSTALL";
                str2 = (i3 & 16) != 0 ? str2 + ", MEDIANOTE_UNINSTALL" : str2 + ", MEDIANOTE_INSTALL";
                str2 = (i3 & 32) != 0 ? str2 + ", QMSG_UNINSTALL" : str2 + ", QMSG_INSTALL";
                str2 = (i3 & 64) != 0 ? str2 + ", BOTTLE_UNINSTALL" : str2 + ", BOTTLE_INSTALL";
                str2 = (i3 & FileUtils.S_IWUSR) != 0 ? str2 + ", QSYNC_UNISTALL" : str2 + ", QSYNC_INSTALL";
                str2 = (i3 & 256) != 0 ? str2 + ", SHAKE_UNISTALL" : str2 + ", SHAKE_INSTALL";
                str2 = (i3 & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 ? str2 + ", LBS_UNISTALL" : str2 + ", LBS_INSTALL";
                str2 = (i3 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? str2 + ", BOTTLE_CHART_INSTALL" : str2 + ", BOTTLE_CHART_INSTALL";
                str2 = (i3 & Downloads.RECV_BUFFER_SIZE) != 0 ? str2 + ",CHECKQQF_UNINSTALL" : str2 + ",CHECKQQF_INSTALL";
                com.tencent.mm.sdk.platformtools.x.i(str, stringBuilder.append((i3 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? str2 + ",MM_FEEDSAPP_UNINSTALL" : str2 + ",MM_FEEDSAPP_INSTALL").toString());
                CU.set(34, Integer.valueOf(com_tencent_mm_protocal_c_asj.vFu));
                CU.set(8200, Boolean.valueOf(bh.a(Boolean.valueOf(1 == com_tencent_mm_protocal_c_asj.wzy.vZf), false)));
                CU.set(8201, Integer.valueOf(bh.a(Integer.valueOf(com_tencent_mm_protocal_c_asj.wzy.vZg.vZj), 22)));
                CU.set(8208, Integer.valueOf(bh.a(Integer.valueOf(com_tencent_mm_protocal_c_asj.wzy.vZg.vZk), 8)));
                CU.set(66049, Integer.valueOf(com_tencent_mm_protocal_c_asj.wvf));
                CU.set(66050, com_tencent_mm_protocal_c_asj.wvg);
                CU.set(40, Integer.valueOf(com_tencent_mm_protocal_c_asj.wzZ));
                aq.hfP.S("last_login_use_voice", com_tencent_mm_protocal_c_asj.wzZ);
                CU.set(41, Integer.valueOf(com_tencent_mm_protocal_c_asj.wvj));
                CU.set(43, com_tencent_mm_protocal_c_asj.wvi);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + com_tencent_mm_protocal_c_asj.wzZ + " WeiboFlag:" + com_tencent_mm_protocal_c_asj.wvj);
                CU.set(868518889, Integer.valueOf(com_tencent_mm_protocal_c_asj.wzK));
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + com_tencent_mm_protocal_c_asj.wzK);
                CU.set(42, com_tencent_mm_protocal_c_asj.hvy);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "userid:" + com_tencent_mm_protocal_c_asj.wcd + " username:" + com_tencent_mm_protocal_c_asj.wce);
                CU.set(65825, com_tencent_mm_protocal_c_asj.wcd);
                CU.set(65826, com_tencent_mm_protocal_c_asj.wce);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + com_tencent_mm_protocal_c_asj.hvz);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + com_tencent_mm_protocal_c_asj.hvA);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + com_tencent_mm_protocal_c_asj.hvB);
                str2 = bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(65830, null));
                if (str2 == null || str2.length() == 0) {
                    str2 = com_tencent_mm_protocal_c_asj.wAc;
                    if (str2 != null && str2.length() > 0) {
                        com.tencent.mm.kernel.g.Dj().CU().set(65830, str2);
                    }
                }
                s.b(1, com_tencent_mm_protocal_c_asj);
                return;
            default:
                return;
        }
    }
}
