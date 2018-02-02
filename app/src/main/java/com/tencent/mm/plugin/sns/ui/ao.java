package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ao {
    private Activity fAF;
    private List<aqr> list = new ArrayList();

    public ao(Activity activity) {
        this.fAF = activity;
    }

    public final void a(View view, int i, at atVar) {
        if (view == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[]{Integer.valueOf(i)});
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof ap) {
            ap apVar = (ap) tag;
            String str = apVar.fus;
            int i2 = apVar.index;
            int i3 = apVar.position;
            if (cj(str, i2)) {
                g.Dk();
                if (g.Dj().isSDCardAvailable()) {
                    m Lm = h.Lm(str);
                    if (cj(str, i2)) {
                        Intent intent = new Intent();
                        if (Lm != null) {
                            b iu;
                            if (atVar != null) {
                                atVar.qWT.v(Lm);
                            }
                            bnp bxV = Lm.bxV();
                            aqr com_tencent_mm_protocal_c_aqr = apVar.index < bxV.wQo.vYd.size() ? (aqr) bxV.wQo.vYd.get(apVar.index) : new aqr();
                            if (i == 1) {
                                iu = b.iu(716);
                            } else {
                                iu = b.iv(716);
                            }
                            iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB(com_tencent_mm_protocal_c_aqr.nGJ).ix(apVar.index).ix(bxV.wQo.vYd.size());
                            iu.Sx();
                            if (i == 1) {
                                iu = b.iu(744);
                            } else {
                                iu = b.iv(744);
                            }
                            iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA());
                            iu.b(intent, "intent_key_StatisticsOplog");
                            Bundle bundle = new Bundle();
                            bundle.putInt("stat_scene", 3);
                            bundle.putString("stat_msg_id", "sns_" + i.eq(Lm.field_snsId));
                            bundle.putString("stat_send_msg_user", Lm.field_userName);
                            intent.putExtra("_stat_obj", bundle);
                        } else {
                            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (i == -1) {
                            intent.putExtra("k_is_from_sns_msg_ui", true);
                        }
                        intent.putExtra("sns_gallery_localId", str);
                        intent.putExtra("sns_gallery_position", i2);
                        intent.putExtra("sns_position", i3);
                        intent.putExtra("sns_gallery_showtype", 1);
                        intent.putExtra("K_ad_scene", i);
                        intent.putExtra("k_is_from_sns_main_timeline", apVar.rzb);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.setClass(this.fAF, SnsBrowseUI.class);
                        this.fAF.startActivity(intent);
                        this.fAF.overridePendingTransition(0, 0);
                        return;
                    }
                    x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[]{str, Integer.valueOf(i2)});
                    return;
                }
                x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
                return;
            }
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[]{str, Integer.valueOf(i2)});
        }
    }

    private boolean cj(String str, int i) {
        m Lm = h.Lm(str);
        if (Lm == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        bnp bxV = Lm.bxV();
        if (bxV.wQo == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
            return false;
        } else if (bxV.wQo.vYd.size() == 0) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
            return false;
        } else {
            this.list.clear();
            Iterator it = bxV.wQo.vYd.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
                this.list.add(com_tencent_mm_protocal_c_aqr);
                if (i != i2 || ae.bvs().B(com_tencent_mm_protocal_c_aqr)) {
                    i2++;
                } else {
                    x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
                    return false;
                }
            }
            return true;
        }
    }
}
