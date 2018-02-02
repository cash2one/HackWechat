package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.z.ab;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class b implements com.tencent.mm.plugin.record.ui.h.b {
    af handler;
    private c jeX = new 3(this);
    private int mxU = 0;
    private OnClickListener myb = new 2(this);
    boolean pGN = false;
    OnClickListener pGO = new OnClickListener(this) {
        final /* synthetic */ b pGP;

        {
            this.pGP = r1;
        }

        public final void onClick(View view) {
            String str = null;
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            Intent intent2;
            String str2;
            Intent intent3;
            Bundle mO;
            Context context;
            Context context2;
            switch (bVar.fve.bjS) {
                case 4:
                case 15:
                    Context context3 = view.getContext();
                    if (bh.ov(bVar.fve.wcJ) || bVar.fve.wde <= 0) {
                        x.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[]{bVar.fve.wda, Long.valueOf(bVar.fve.wde)});
                        str = bVar.fve.wcQ;
                        if (bh.ov(str)) {
                            str = bVar.fve.wcU;
                        }
                        if (bh.ov(str)) {
                            x.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[]{bVar.fve.mvG});
                            if (bVar.bjS == 1 && bVar.pFG.field_itemStatus != 10 && bVar.fve.wdR == 0) {
                                intent = new Intent();
                                intent.putExtra("key_detail_info_id", bVar.pFG.field_localId);
                                intent.putExtra("key_detail_data_id", bVar.fve.mvG);
                                if (com.tencent.mm.plugin.record.b.b.c(bVar)) {
                                    b.a(intent, bVar, context3, com.tencent.mm.plugin.record.b.b.a(bVar), com.tencent.mm.plugin.record.b.b.b(bVar));
                                    return;
                                } else {
                                    d.b(context3, "favorite", ".ui.detail.FavoriteFileDetailUI", intent, 1);
                                    return;
                                }
                            }
                            intent2 = new Intent();
                            str2 = "";
                            str = "";
                            if (bVar.bjS == 0) {
                                str = h.f(bVar.fve, bVar.fqm);
                                if (bh.ov(str) || !e.bO(str)) {
                                    com.tencent.mm.ui.base.h.bu(context3, context3.getString(R.l.egp));
                                    return;
                                }
                                str2 = h.c(bVar.fve, bVar.fqm);
                                if (bh.ov(str2) || !e.bO(str2)) {
                                    intent2.putExtra("key_detail_data_valid", false);
                                }
                            } else if (bVar.bjS == 1) {
                                str = com.tencent.mm.plugin.record.b.b.b(bVar);
                                if (bh.ov(str) || !e.bO(str)) {
                                    com.tencent.mm.ui.base.h.bu(context3, context3.getString(R.l.egp));
                                    return;
                                }
                                str2 = com.tencent.mm.plugin.record.b.b.a(bVar);
                                if (bh.ov(str2) || !e.bO(str2)) {
                                    intent2.putExtra("key_detail_data_valid", false);
                                }
                            }
                            b.a(intent2, bVar, context3, str2, str);
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        if (bVar.bjS == 1) {
                            intent3.putExtra("is_favorite_item", true);
                            intent3.putExtra("fav_local_id", bVar.pFG.field_localId);
                            intent3.putExtra("key_detail_can_delete", false);
                            intent3.putExtra("geta8key_scene", 14);
                            mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                            mO.putInt("mm_rpt_fav_id", bVar.pFG.field_id);
                            intent3.putExtra("mm_report_bundle", mO);
                            x.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.pFG.field_id), Long.valueOf(bVar.pFG.field_localId), bVar.fve.mvG});
                        }
                        d.b(context3, "webview", ".ui.tools.WebViewUI", intent3, 1);
                        return;
                    } else if (bVar.bjS == 0) {
                        intent = new Intent();
                        intent.putExtra("message_id", bVar.fqm);
                        intent.putExtra("record_xml", bVar.fEG);
                        intent.putExtra("record_data_id", bVar.fve.mvG);
                        intent.putExtra("key_detail_fav_video_scene_from", 1);
                        if (h.d(bVar.fve, bVar.fqm)) {
                            b.a(intent, bVar, context3, h.c(bVar.fve, bVar.fqm), h.f(bVar.fve, bVar.fqm));
                            return;
                        } else {
                            d.b(context3, "record", ".ui.RecordMsgFileUI", intent, 1);
                            return;
                        }
                    } else if (bVar.bjS == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.pFG.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.fve.mvG);
                        if (com.tencent.mm.plugin.record.b.b.c(bVar)) {
                            b.a(intent, bVar, context3, com.tencent.mm.plugin.record.b.b.a(bVar), com.tencent.mm.plugin.record.b.b.b(bVar));
                            return;
                        } else {
                            d.b(context3, "favorite", ".ui.detail.FavoriteFileDetailUI", intent, 1);
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    context = view.getContext();
                    if (bVar.fve.wdD == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[]{bVar.fve.mvG});
                        com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.ego));
                        return;
                    }
                    uq uqVar = bVar.fve;
                    if (uqVar != null) {
                        if (uqVar.wdO) {
                            str = uqVar.canvasPageXml;
                        } else if (!(uqVar.wdD == null || uqVar.wdD.web == null || !uqVar.wdD.web.wdO)) {
                            str = uqVar.wdD.web.canvasPageXml;
                        }
                    }
                    if (bh.ov(str)) {
                        us usVar = bVar.fve.wdD.wdX;
                        str = "";
                        if (bVar.fve.wdD.web != null) {
                            str = bVar.fve.wdD.web.wfz;
                        }
                        if (usVar != null && bh.ov(r1)) {
                            str = usVar.hOf;
                        }
                        if (bh.ov(str)) {
                            str = bVar.fve.wcQ;
                        }
                        if (bh.ov(str)) {
                            x.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[]{bVar.fve.mvG});
                            com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.ego));
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        if (!(usVar == null || bh.ov(usVar.fnl))) {
                            intent2.putExtra("srcDisplayname", r.gu(usVar.fnl));
                        }
                        intent2.putExtra("mode", 1);
                        if (bVar.bjS == 1) {
                            intent2.putExtra("is_favorite_item", true);
                            intent2.putExtra("fav_local_id", bVar.pFG.field_localId);
                            intent2.putExtra("key_detail_can_delete", false);
                            intent2.putExtra("geta8key_scene", 14);
                            intent2.putExtra("from_scence", 4);
                            mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                            mO.putInt("mm_rpt_fav_id", bVar.pFG.field_id);
                            intent2.putExtra("mm_report_bundle", mO);
                        }
                        mO = new Bundle();
                        mO.putString("key_snsad_statextstr", bVar.fve.fGG);
                        intent2.putExtra("jsapiargs", mO);
                        d.b(context, "webview", ".ui.tools.WebViewUI", intent2, 1);
                        return;
                    }
                    Intent intent4 = new Intent();
                    intent4.putExtra("sns_landing_pages_xml", str);
                    intent4.putExtra("sns_landig_pages_from_source", 5);
                    intent4.putExtra("sns_landing_pages_share_thumb_url", bVar.fve.hbj);
                    intent4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent4.putExtra("msg_id", bVar.fqm);
                    d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent4, 1);
                    return;
                case 6:
                    Context context4 = view.getContext();
                    if (context4 != null) {
                        ux uxVar;
                        us usVar2;
                        if (bVar.fve.wdD != null) {
                            uxVar = bVar.fve.wdD.wdZ;
                            usVar2 = bVar.fve.wdD.wdX;
                        } else {
                            usVar2 = null;
                            uxVar = null;
                        }
                        if (usVar2 != null) {
                            str = !bh.ov(usVar2.wet) ? r.gu(usVar2.wet) : r.gu(usVar2.fzO);
                        }
                        if (usVar2 == null && bVar.bjS == 1) {
                            str = r.gu(bVar.pFG.field_fromUser);
                        }
                        if (uxVar == null) {
                            x.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[]{bVar.fve.mvG});
                            com.tencent.mm.ui.base.h.bu(context4, context4.getString(R.l.egm));
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("kwebmap_slat", uxVar.lat);
                        intent3.putExtra("kwebmap_lng", uxVar.lng);
                        intent3.putExtra("kPoiName", uxVar.fDu);
                        intent3.putExtra("Kwebmap_locaion", uxVar.label);
                        if (uxVar.fzv >= 0) {
                            intent3.putExtra("kwebmap_scale", uxVar.fzv);
                        }
                        intent3.putExtra("kisUsername", str);
                        intent3.putExtra("kwebmap_from_to", true);
                        if (bVar.bjS == 1) {
                            intent3.putExtra("KFavLocSigleView", true);
                            intent3.putExtra("map_view_type", 2);
                            intent3.putExtra("kFavInfoLocalId", bVar.pFG.field_localId);
                            intent3.putExtra("kFavCanDel", false);
                            intent3.putExtra("kFavCanRemark", false);
                            d.b(context4, "location", ".ui.RedirectUI", intent3, 1);
                            return;
                        } else if (bVar.bjS == 0) {
                            intent3.putExtra("map_view_type", 1);
                            d.b(context4, "location", ".ui.RedirectUI", intent3, 1002);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 7:
                    context2 = view.getContext();
                    intent3 = new Intent();
                    if (bh.ov(bVar.fve.wcQ)) {
                        x.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", new Object[]{bVar.fve.mvG});
                        intent3.putExtra("rawUrl", bVar.fve.wcS);
                    } else {
                        intent3.putExtra("rawUrl", bVar.fve.wcQ);
                    }
                    if (bVar.bjS == 1) {
                        intent3.putExtra("is_favorite_item", true);
                        intent3.putExtra("fav_local_id", bVar.pFG.field_localId);
                        intent3.putExtra("key_detail_can_delete", false);
                        Bundle mO2 = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                        mO2.putInt("mm_rpt_fav_id", bVar.pFG.field_id);
                        intent3.putExtra("mm_report_bundle", mO2);
                        x.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.pFG.field_id), Long.valueOf(bVar.pFG.field_localId), bVar.fve.mvG});
                    }
                    d.b(context2, "webview", ".ui.tools.WebViewUI", intent3, 1);
                    return;
                case 8:
                    boolean z;
                    context = view.getContext();
                    if (bVar.bjS == 0) {
                        if (h.d(bVar.fve, bVar.fqm) && !a.a((Activity) context, h.c(bVar.fve, bVar.fqm), bVar.fve.wcY, 2)) {
                            z = false;
                        }
                        z = true;
                    } else {
                        if (bVar.bjS == 1 && com.tencent.mm.plugin.record.b.b.c(bVar) && !a.a((Activity) context, com.tencent.mm.plugin.record.b.b.a(bVar), bVar.fve.wcY, 2)) {
                            z = false;
                        }
                        z = true;
                    }
                    if (!z) {
                        return;
                    }
                    if (bVar.bjS == 0) {
                        intent = new Intent(context, RecordMsgFileUI.class);
                        intent.putExtra("message_id", bVar.fqm);
                        intent.putExtra("record_xml", bVar.fEG);
                        intent.putExtra("record_data_id", bVar.fve.mvG);
                        context.startActivity(intent);
                        return;
                    } else if (bVar.bjS != 1) {
                        return;
                    } else {
                        if (h.h(bVar.fve, bVar.fqm)) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", bVar.pFG.field_localId);
                            d.b(context, "favorite", ".ui.detail.FavoriteImgDetailUI", intent, 1);
                            return;
                        }
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.pFG.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.fve.mvG);
                        intent.putExtra("key_detail_can_delete", false);
                        d.b(context, "favorite", ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        return;
                    }
                case 10:
                    context2 = view.getContext();
                    if (bVar.fve.wdD == null || bVar.fve.wdD.wed == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[]{bVar.fve.mvG});
                        com.tencent.mm.ui.base.h.bu(context2, context2.getString(R.l.egl));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_Product_xml", bVar.fve.wdD.wed.info);
                    if (bVar.bjS == 1) {
                        intent3.putExtra("key_is_favorite_item", true);
                        intent3.putExtra("key_favorite_local_id", bVar.pFG.field_localId);
                        intent3.putExtra("key_can_delete_favorite_item", false);
                        intent3.putExtra("key_ProductUI_getProductInfoScene", 3);
                    }
                    d.b(context2, "scanner", ".ui.ProductUI", intent3, 1);
                    return;
                case 11:
                    context2 = view.getContext();
                    if (bVar.fve.wdD == null || bVar.fve.wdD.wed == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[]{bVar.fve.mvG});
                        com.tencent.mm.ui.base.h.bu(context2, context2.getString(R.l.egl));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_product_info", bVar.fve.wdD.wed.info);
                    if (bVar.bjS == 1) {
                        intent3.putExtra("key_product_scene", 4);
                    }
                    d.b(context2, "product", ".ui.MallProductUI", intent3, 1);
                    return;
                case 14:
                    context2 = view.getContext();
                    if (bVar.fve.wdD == null || bVar.fve.wdD.wef == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[]{bVar.fve.mvG});
                        com.tencent.mm.ui.base.h.bu(context2, context2.getString(R.l.egl));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_TV_getProductInfoScene", 3);
                    intent3.putExtra("key_TV_xml", bVar.fve.wdD.wef.info);
                    if (bVar.bjS == 1) {
                        intent3.putExtra("key_is_favorite_item", true);
                        intent3.putExtra("key_favorite_local_id", bVar.pFG.field_localId);
                        intent3.putExtra("key_can_delete_favorite_item", false);
                    }
                    d.b(context2, "shake", ".ui.TVInfoUI", intent3, 1);
                    return;
                case 16:
                    context2 = view.getContext();
                    if (bVar.fve.wdD == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[]{bVar.fve.mvG});
                        com.tencent.mm.ui.base.h.bu(context2, context2.getString(R.l.egl));
                        return;
                    }
                    str2 = bVar.fve.desc;
                    ar.Hg();
                    au.a EK = com.tencent.mm.z.c.Fa().EK(str2);
                    if (EK == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[]{str2, bVar.fve.mvG});
                        com.tencent.mm.ui.base.h.bu(context2, context2.getString(R.l.egl));
                        return;
                    }
                    Intent intent5 = new Intent();
                    intent5.putExtra("Contact_User", EK.rYX);
                    intent5.putExtra("Contact_Alias", EK.gfN);
                    intent5.putExtra("Contact_Nick", EK.fpL);
                    intent5.putExtra("Contact_QuanPin", EK.hwV);
                    intent5.putExtra("Contact_PyInitial", EK.hwU);
                    intent5.putExtra("Contact_Uin", EK.pjS);
                    intent5.putExtra("Contact_Mobile_MD5", EK.xzj);
                    intent5.putExtra("Contact_full_Mobile_MD5", EK.xzk);
                    intent5.putExtra("Contact_QQNick", EK.cjG());
                    intent5.putExtra("User_From_Fmessage", false);
                    intent5.putExtra("Contact_Scene", EK.scene);
                    intent5.putExtra("Contact_FMessageCard", true);
                    intent5.putExtra("Contact_RemarkName", EK.hwZ);
                    intent5.putExtra("Contact_VUser_Info_Flag", EK.tmE);
                    intent5.putExtra("Contact_VUser_Info", EK.fWu);
                    intent5.putExtra("Contact_BrandIconURL", EK.phJ);
                    intent5.putExtra("Contact_Province", EK.getProvince());
                    intent5.putExtra("Contact_City", EK.getCity());
                    intent5.putExtra("Contact_Sex", EK.fWf);
                    intent5.putExtra("Contact_Signature", EK.signature);
                    intent5.putExtra("Contact_ShowUserName", false);
                    intent5.putExtra("Contact_KSnsIFlag", 0);
                    d.b(context2, "profile", ".ui.ContactInfoUI", intent5, 1);
                    com.tencent.mm.bn.a.CC(EK.scene);
                    return;
                case 17:
                    context2 = view.getContext();
                    if (context2 != null && bVar.bjS == 0 && bVar.fve.wdT != null) {
                        intent3 = new Intent(context2, RecordMsgDetailUI.class);
                        intent3.putExtra("message_id", bVar.fqm);
                        intent3.putExtra("record_xml", bVar.fve.wdT);
                        context2.startActivity(intent3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private com.tencent.mm.plugin.record.ui.h.a pGb;

    public b(com.tencent.mm.plugin.record.ui.h.a aVar, af afVar) {
        this.pGb = aVar;
        this.handler = afVar;
    }

    public final View dp(Context context) {
        View inflate = View.inflate(context, R.i.dqu, null);
        this.mxU = com.tencent.mm.bv.a.fromDPToPix(context, 75);
        com.tencent.mm.sdk.b.a.xef.b(this.jeX);
        return inflate;
    }

    private static String getAppName(Context context, String str) {
        com.tencent.mm.z.ab.b bVar = ab.a.hfJ;
        if (bVar != null) {
            return bVar.l(context, str);
        }
        return "";
    }

    public static boolean l(uq uqVar) {
        asv Qs = com.tencent.mm.av.b.Qs();
        return Qs != null && Qs.wAi == 6 && bh.az(uqVar.mvG, "").equals(Qs.vVZ) && com.tencent.mm.av.b.Qq();
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(R.h.title);
        TextView textView2 = (TextView) view.findViewById(R.h.caP);
        TextView textView3 = (TextView) view.findViewById(R.h.cOY);
        MMImageView mMImageView = (MMImageView) view.findViewById(R.h.icon);
        mMImageView.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(R.h.coP);
        imageView.setVisibility(8);
        View findViewById = view.findViewById(R.h.cGV);
        findViewById.setVisibility(0);
        findViewById.setTag(bVar);
        findViewById.setOnClickListener(this.pGO);
        View findViewById2 = view.findViewById(R.h.cTO);
        findViewById2.setVisibility(8);
        com.tencent.mm.plugin.record.ui.h.a.a aVar = new com.tencent.mm.plugin.record.ui.h.a.a();
        if (bVar.bjS == 0) {
            aVar.pGd = bVar.fqm;
        } else if (bVar.bjS == 1) {
            aVar.pGd = bVar.pFG.field_localId;
        }
        aVar.fvf = mMImageView;
        aVar.fve = bVar.fve;
        aVar.height = this.mxU;
        aVar.width = this.mxU;
        uq uqVar;
        CharSequence string;
        uq uqVar2;
        switch (bVar.fve.bjS) {
            case 4:
            case 15:
                uqVar = bVar.fve;
                if (bh.ov(uqVar.title)) {
                    textView.setText(R.l.egS);
                } else {
                    textView.setText(uqVar.title);
                }
                if (uqVar.duration <= 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    Context context = textView2.getContext();
                    int i2 = uqVar.duration;
                    if (i2 <= 0) {
                        string = context.getString(R.l.egU, new Object[]{Integer.valueOf(0)});
                    } else {
                        int i3 = i2 / 60;
                        i2 %= 60;
                        string = i3 == 0 ? context.getString(R.l.egU, new Object[]{Integer.valueOf(i2)}) : context.getString(R.l.egT, new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                    }
                    textView2.setText(string);
                }
                if (uqVar.wdD == null) {
                    x.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", new Object[]{uqVar.mvG});
                    textView3.setVisibility(8);
                } else {
                    us usVar = uqVar.wdD.wdX;
                    if (!bh.ov(usVar.appId)) {
                        string = getAppName(textView3.getContext(), usVar.appId);
                        if (bh.ov(string)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText(string);
                        }
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageResource(R.g.bHg);
                aVar.fvg = R.k.dvA;
                this.pGb.a(aVar);
                break;
            case 5:
                uq uqVar3 = bVar.fve;
                CharSequence charSequence = "";
                vt vtVar = null;
                if (!(uqVar3 == null || uqVar3.wdD == null)) {
                    vtVar = uqVar3.wdD.web;
                }
                if (vtVar != null) {
                    charSequence = vtVar.title;
                }
                if (bh.ov(charSequence) && uqVar3 != null) {
                    charSequence = uqVar3.title;
                }
                if (bh.ov(charSequence)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                }
                textView2.setVisibility(8);
                string = "";
                if (vtVar != null) {
                    string = bh.VF(vtVar.wfz);
                }
                us usVar2 = null;
                if (!(uqVar3 == null || uqVar3.wdD == null)) {
                    usVar2 = uqVar3.wdD.wdX;
                }
                if (usVar2 != null) {
                    if (!bh.ov(usVar2.appId)) {
                        string = bh.az(getAppName(textView3.getContext(), usVar2.appId), "");
                    } else if (!bh.ov(usVar2.fnl)) {
                        ar.Hg();
                        com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(usVar2.fnl);
                        if (WO == null || !WO.field_username.equals(usVar2.fnl)) {
                            ak.a.hfL.a(usVar2.fnl, "", null);
                        } else {
                            string = WO.AQ();
                        }
                    }
                    if (bh.ov(string) || string.equals(usVar2.fnl)) {
                        string = bh.VF(usVar2.hOf);
                    }
                }
                if (bh.ov(string)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(string);
                    textView3.setVisibility(0);
                }
                aVar.fvg = R.g.byV;
                this.pGb.a(aVar);
                break;
            case 6:
                uqVar2 = bVar.fve;
                if (uqVar2.wdD == null) {
                    x.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", new Object[]{uqVar2.mvG});
                    textView.setText(R.l.efM);
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    ux uxVar = uqVar2.wdD.wdZ;
                    if (bh.ov(uxVar.fDu)) {
                        textView.setText(uxVar.label);
                        textView2.setText(R.l.efM);
                        textView3.setText("");
                    } else {
                        textView.setText(uxVar.fDu);
                        textView2.setText(uxVar.label);
                        textView3.setText(R.l.efM);
                    }
                }
                mMImageView.setImageResource(R.k.dvm);
                break;
            case 7:
                textView.setText(bVar.fve.title);
                textView2.setText(bVar.fve.desc);
                imageView.setTag(bVar);
                imageView.setOnClickListener(this.myb);
                imageView.setImageResource(R.g.bDS);
                imageView.setVisibility(0);
                if (l(bVar.fve)) {
                    imageView.setImageResource(R.g.bDR);
                }
                textView3.setVisibility(8);
                aVar.fvg = R.k.dvn;
                this.pGb.a(aVar);
                break;
            case 8:
                uqVar2 = bVar.fve;
                textView.setText(uqVar2.title);
                textView2.setVisibility(0);
                textView2.setText(bh.ah((float) uqVar2.wde));
                textView3.setVisibility(8);
                if (uqVar2.wdR == 2) {
                    textView2.setText(">25MB");
                }
                mMImageView.setImageResource(com.tencent.mm.pluginsdk.c.Rd(bVar.fve.wcY));
                break;
            case 10:
                uqVar = bVar.fve;
                if (uqVar.wdD == null) {
                    x.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", new Object[]{uqVar.mvG});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    vd vdVar = uqVar.wdD.wed;
                    textView.setText(vdVar.title);
                    textView2.setText(vdVar.desc);
                    textView3.setText(bh.az(getAppName(textView3.getContext(), uqVar.wdD.wdX.appId), textView3.getContext().getString(R.l.egd)));
                }
                aVar.fvg = R.k.dvx;
                this.pGb.a(aVar);
                break;
            case 11:
                uqVar = bVar.fve;
                if (uqVar.wdD == null) {
                    x.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", new Object[]{uqVar.mvG});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    vd vdVar2 = uqVar.wdD.wed;
                    textView.setText(vdVar2.title);
                    textView2.setText(vdVar2.desc);
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                    textView3.setVisibility(8);
                }
                aVar.fvg = R.k.dvx;
                aVar.fve = null;
                this.pGb.a(aVar);
                break;
            case 14:
                uqVar = bVar.fve;
                if (uqVar.wdD == null || uqVar.wdD.wef == null) {
                    x.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", new Object[]{uqVar.mvG});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    vn vnVar = uqVar.wdD.wef;
                    textView.setText(vnVar.title);
                    textView2.setText(vnVar.desc);
                    textView3.setText(bh.az(getAppName(textView3.getContext(), uqVar.wdD.wdX.appId), textView3.getContext().getString(R.l.egP)));
                }
                aVar.fvg = R.k.dvx;
                aVar.fve = null;
                this.pGb.a(aVar);
                break;
            case 16:
                uqVar2 = bVar.fve;
                ar.Hg();
                au.a EK = com.tencent.mm.z.c.Fa().EK(uqVar2.desc);
                if (EK == null) {
                    x.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
                }
                textView.setText(i.b(textView.getContext(), EK != null ? EK.fpL : "", textView.getTextSize()));
                textView2.setVisibility(8);
                textView3.setText(R.l.efA);
                textView3.setVisibility(0);
                String str = EK.rYX;
                if (!bh.ov(str)) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(mMImageView, str);
                    break;
                } else {
                    mMImageView.setImageResource(R.g.bBB);
                    break;
                }
            case 17:
                uqVar2 = bVar.fve;
                textView.setText(uqVar2.title);
                textView2.setVisibility(0);
                textView2.setText(uqVar2.desc);
                mMImageView.setVisibility(8);
                break;
            default:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                return;
        }
        textView3.setVisibility(8);
    }

    public final void destroy() {
        x.d("MicroMsg.OtherViewWrapper", "do destroy");
        this.pGb = null;
        this.handler = null;
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
        this.pGN = false;
    }

    public final void pause() {
    }

    static void a(Intent intent, com.tencent.mm.plugin.record.ui.a.b bVar, Context context, String str, String str2) {
        intent.putExtra("key_detail_fav_path", str);
        intent.putExtra("key_detail_fav_thumb_path", str2);
        intent.putExtra("key_detail_fav_video_duration", bVar.fve.duration);
        intent.putExtra("key_detail_statExtStr", bVar.fve.fGG);
        d.b(context, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent, 1);
    }
}
