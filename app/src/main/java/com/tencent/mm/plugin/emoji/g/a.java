package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.bq.b;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a implements com.tencent.mm.z.bs.a {
    public final void a(com.tencent.mm.ae.d.a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar.ngq == 10002) {
            String a = n.a(bwVar.vGZ);
            if (bh.ov(a)) {
                x.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            if (y != null && y.size() > 0) {
                String str = (String) y.get(".sysmsg.$type");
                String by = bh.by(b.bc(q.yF().getBytes()).CD(16).oz);
                int intValue;
                if (!bh.ov(str) && str.equalsIgnoreCase("EmojiBackup")) {
                    intValue = Integer.valueOf((String) y.get(".sysmsg.EmojiBackup.OpCode")).intValue();
                    str = (String) y.get(".sysmsg.EmojiBackup.DeviceID");
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", by, str);
                    if (bh.ov(str) || !str.equalsIgnoreCase(by)) {
                        ArrayList yz = b.yz(a);
                        if (intValue == 1) {
                            if (yz == null || yz.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", Integer.valueOf(yz.size()));
                            ArrayList arrayList = new ArrayList();
                            int size = yz.size();
                            for (int i = 0; i < size; i++) {
                                rw rwVar = (rw) yz.get(i);
                                if (rwVar != null) {
                                    EmojiInfo XU = i.aBE().lwL.XU(rwVar.vZL);
                                    if (XU != null && XU.cks() && XU.field_catalog == EmojiInfo.xAk) {
                                        x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "md5:%s not need to download", rwVar.vZL);
                                    } else {
                                        arrayList.add(new com.tencent.mm.plugin.emoji.sync.a.a(rwVar.vZL, rwVar.nfX, rwVar.pbP, rwVar.vZM, rwVar.vZN, rwVar.vZO, rwVar.vIR, rwVar.vZR));
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                i.aBB().s(arrayList);
                                i.aBB().lzq.aBZ();
                            }
                        } else if (intValue == 2) {
                            if (yz == null || yz.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            List arrayList2 = new ArrayList();
                            if (yz != null && yz.size() > 0) {
                                Iterator it = yz.iterator();
                                while (it.hasNext()) {
                                    rw rwVar2 = (rw) it.next();
                                    if (rwVar2 != null) {
                                        arrayList2.add(rwVar2.vZL);
                                    }
                                }
                            }
                            i.aBE().lwL.cU(arrayList2);
                            ar.Hg();
                            c.CU().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.valueOf(false));
                        } else if (intValue == 3) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                            ar.Hg();
                            c.CU().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_LAST_BATCH_EMOJI_DOWNLOAD_TIME_2_LONG, Long.valueOf(0));
                        }
                        ar.Hg();
                        c.CU().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.valueOf(true));
                        return;
                    }
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                } else if (bh.ov(str) || !str.equalsIgnoreCase("EmotionBackup")) {
                    x.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                } else {
                    intValue = Integer.valueOf((String) y.get(".sysmsg.EmotionBackup.OpCode")).intValue();
                    str = (String) y.get(".sysmsg.EmotionBackup.DeviceID");
                    if (bh.ov(str) || !str.equalsIgnoreCase(by)) {
                        ArrayList yA = b.yA(a);
                        if (yA == null || yA.size() <= 0) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            return;
                        } else if (intValue == 1) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", Integer.valueOf(yA.size()));
                            ArrayList arrayList3 = new ArrayList();
                            intValue = yA.size();
                            for (int i2 = 0; i2 < intValue; i2++) {
                                arrayList3.add(new com.tencent.mm.plugin.emoji.sync.a.b((String) yA.get(i2)));
                            }
                            i.aBB().t(arrayList3);
                            i.aBB().lzq.aBZ();
                            return;
                        } else if (intValue == 2) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", Integer.valueOf(yA.size()));
                            i.aBE().lwM.af(yA);
                            return;
                        } else {
                            return;
                        }
                    }
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(bwVar.ngq));
    }
}
