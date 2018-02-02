package com.tencent.mm.plugin.favorite.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.b;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.h;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteTextDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVoiceDetailUI;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.i$a$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e {
    private static int[] mxW = new int[]{R.h.bUJ, R.h.bUK, R.h.bUL, R.h.bUM, R.h.bUN};

    public static void a(Context context, f fVar, vg vgVar) {
        if (context == null) {
            x.w("MicroMsg.FavItemLogic", "Context is null");
        } else if (fVar == null) {
            x.w("MicroMsg.FavItemLogic", "Fav item is null");
        } else {
            x.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[]{Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_type)});
            Intent intent;
            long j;
            String str;
            Intent intent2;
            switch (fVar.field_type) {
                case -2:
                    Toast.makeText(context, R.l.egQ, 0).show();
                    return;
                case 1:
                    Intent intent3 = new Intent(context, FavoriteTextDetailUI.class);
                    intent3.putExtra("key_detail_text", fVar.field_favProto.desc);
                    intent3.putExtra("key_detail_info_id", fVar.field_localId);
                    intent3.putExtra("key_detail_can_share_to_friend", fVar.aHJ());
                    intent3.putExtra("key_detail_time", fVar.field_updateTime);
                    intent3.putExtra("key_detail_create_time", fVar.field_sourceCreateTime <= 0 ? fVar.field_updateTime : fVar.field_sourceCreateTime);
                    intent3.putExtra("key_detail_fav_scene", vgVar.scene);
                    intent3.putExtra("key_detail_fav_sub_scene", vgVar.moj);
                    intent3.putExtra("key_detail_fav_index", vgVar.index);
                    context.startActivity(intent3);
                    return;
                case 2:
                    d(context, fVar, vgVar);
                    return;
                case 3:
                    intent = new Intent(context, FavoriteVoiceDetailUI.class);
                    intent.putExtra("key_detail_fav_scene", vgVar.scene);
                    intent.putExtra("key_detail_fav_sub_scene", vgVar.moj);
                    intent.putExtra("key_detail_fav_index", vgVar.index);
                    intent.putExtra("key_detail_info_id", fVar.field_localId);
                    intent.putExtra("key_detail_create_time", fVar.field_favProto.weS.hVE);
                    context.startActivity(intent);
                    return;
                case 4:
                    c(context, fVar, vgVar);
                    return;
                case 5:
                    d(context, fVar, true, vgVar);
                    return;
                case 6:
                    ux uxVar = fVar.field_favProto.wdZ;
                    String str2 = fVar.field_favProto.iIj;
                    vk vkVar = fVar.field_favProto.weS;
                    String gu = (vkVar == null || bh.ov(vkVar.wet)) ? r.gu(fVar.field_fromUser) : r.gu(vkVar.wet);
                    ArrayList arrayList = new ArrayList();
                    if (fVar.field_tagProto.wfj != null) {
                        arrayList.addAll(fVar.field_tagProto.wfj);
                    }
                    d.a(fVar.field_localId, uxVar, gu, str2, arrayList, context);
                    return;
                case 7:
                    String absolutePath;
                    vk vkVar2 = fVar.field_favProto.weS;
                    uq p = j.p(fVar);
                    File file = new File(j.i(p));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (p.fqf == null) {
                        absolutePath = "";
                    } else {
                        file = new File(j.aIE() + g.s(p.fqf.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    b.b(((a) com.tencent.mm.kernel.g.h(a.class)).a(6, null, p.title, p.desc, p.wcQ, p.wcU, p.wcS, p.mvG, j.aIG(), absolutePath, "", vkVar2.appId));
                    intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    com.tencent.mm.bm.d.b(context, "music", ".ui.MusicMainUI", intent);
                    return;
                case 8:
                    c(context, fVar, true, vgVar);
                    return;
                case 10:
                    x.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                    j = fVar.field_localId;
                    str = fVar.field_favProto.wed.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_Product_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    com.tencent.mm.bm.d.b(context, "scanner", ".ui.ProductUI", intent2);
                    return;
                case 11:
                    x.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("key_product_scene", 4);
                    intent.putExtra("key_product_info", fVar.field_favProto.wed.info);
                    com.tencent.mm.bm.d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                case 15:
                    x.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                    j = fVar.field_localId;
                    str = fVar.field_favProto.wef.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_TV_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    com.tencent.mm.bm.d.b(context, "shake", ".ui.TVInfoUI", intent2);
                    return;
                case 14:
                    a(context, fVar, true, vgVar);
                    return;
                case 16:
                    uq p2 = j.p(fVar);
                    if (p2 == null || p2.wdJ == null || (bh.ov(p2.wdJ.hdo) && bh.ov(p2.wdJ.hds))) {
                        c(context, fVar, vgVar);
                        return;
                    }
                    x.i("MicroMsg.FavItemLogic", "it is ad sight.");
                    b(context, fVar, vgVar);
                    return;
                case 17:
                    String str3 = j.p(fVar).desc;
                    ar.Hg();
                    au.a EK = c.Fa().EK(str3);
                    if (EK != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("Contact_User", EK.rYX);
                        intent4.putExtra("Contact_Alias", EK.gfN);
                        intent4.putExtra("Contact_Nick", EK.fpL);
                        intent4.putExtra("Contact_QuanPin", EK.hwV);
                        intent4.putExtra("Contact_PyInitial", EK.hwU);
                        intent4.putExtra("Contact_Uin", EK.pjS);
                        intent4.putExtra("Contact_Mobile_MD5", EK.xzj);
                        intent4.putExtra("Contact_full_Mobile_MD5", EK.xzk);
                        intent4.putExtra("Contact_QQNick", EK.cjG());
                        intent4.putExtra("User_From_Fmessage", false);
                        intent4.putExtra("Contact_Scene", EK.scene);
                        intent4.putExtra("Contact_FMessageCard", true);
                        intent4.putExtra("Contact_RemarkName", EK.hwZ);
                        intent4.putExtra("Contact_VUser_Info_Flag", EK.tmE);
                        intent4.putExtra("Contact_VUser_Info", EK.fWu);
                        intent4.putExtra("Contact_BrandIconURL", EK.phJ);
                        intent4.putExtra("Contact_Province", EK.getProvince());
                        intent4.putExtra("Contact_City", EK.getCity());
                        intent4.putExtra("Contact_Sex", EK.fWf);
                        intent4.putExtra("Contact_Signature", EK.signature);
                        intent4.putExtra("Contact_ShowUserName", false);
                        intent4.putExtra("Contact_KSnsIFlag", 0);
                        com.tencent.mm.bm.d.b(context, "profile", ".ui.ContactInfoUI", intent4);
                        com.tencent.mm.bn.a.CC(EK.scene);
                        return;
                    }
                    return;
                case 18:
                    b(context, fVar, true, vgVar);
                    return;
                default:
                    x.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[]{Integer.valueOf(fVar.field_type)});
                    return;
            }
        }
    }

    private static void a(Context context, f fVar, boolean z, vg vgVar) {
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        intent.putExtra("show_share", z);
        intent.putExtra("key_detail_fav_scene", vgVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vgVar.moj);
        intent.putExtra("key_detail_fav_index", vgVar.index);
        com.tencent.mm.bm.d.b(context, "record", ".ui.FavRecordDetailUI", intent);
    }

    public static boolean l(uq uqVar) {
        asv Qs = b.Qs();
        return Qs != null && Qs.wAi == 6 && bh.az(uqVar.mvG, "").equals(Qs.vVZ) && b.Qq();
    }

    private static void b(Context context, f fVar, boolean z, vg vgVar) {
        x.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
        com.tencent.mm.sdk.b.b koVar = new ko();
        koVar.fBM.field_localId = fVar.field_localId;
        if (fVar.field_localId == -1) {
            koVar.fBM.fBT = 4;
        } else {
            koVar.fBM.fBO = fVar.field_xml;
        }
        koVar.fBM.context = context;
        Bundle bundle = new Bundle();
        uy uyVar = fVar.field_favProto.vCU;
        if (uyVar != null) {
            bundle.putString("noteauthor", uyVar.weL);
            bundle.putString("noteeditor", uyVar.weM);
        }
        bundle.putLong("edittime", fVar.field_updateTime);
        koVar.fBM.fBR = bundle;
        koVar.fBM.field_favProto = fVar.field_favProto;
        koVar.fBM.type = 2;
        koVar.fBM.fBV = z;
        koVar.fBM.fBW = vgVar;
        com.tencent.mm.sdk.b.a.xef.m(koVar);
    }

    private static void c(Context context, f fVar, boolean z, vg vgVar) {
        uq p = j.p(fVar);
        if (j.e(p)) {
            if (j.f(p)) {
                d(context, fVar, vgVar);
                return;
            } else if (!com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, j.h(p), p.wcY, 2)) {
                return;
            }
        }
        Intent intent = new Intent(context, FavoriteFileDetailUI.class);
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        intent.putExtra("show_share", z);
        intent.putExtra("key_detail_fav_scene", vgVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vgVar.moj);
        intent.putExtra("key_detail_fav_index", vgVar.index);
        context.startActivity(intent);
    }

    private static String G(f fVar) {
        if (fVar.field_favProto == null) {
            return null;
        }
        if (fVar.field_favProto.web != null && !bh.ov(fVar.field_favProto.web.canvasPageXml)) {
            return fVar.field_favProto.web.thumbUrl;
        }
        List list = fVar.field_favProto.weU;
        if (list == null || list.size() != 1) {
            return null;
        }
        return ((uq) list.get(0)).hbj;
    }

    private static void d(Context context, f fVar, boolean z, vg vgVar) {
        String str;
        vk vkVar;
        String str2;
        String str3;
        vt vtVar;
        uq p;
        Intent intent;
        String str4;
        Bundle bundle;
        Bundle bundle2;
        String str5;
        Bundle mO;
        String str6;
        Intent intent2;
        if (fVar.field_favProto != null) {
            if (fVar.field_favProto.web == null || bh.ov(fVar.field_favProto.web.canvasPageXml)) {
                List list = fVar.field_favProto.weU;
                if (list != null && list.size() == 1) {
                    str = ((uq) list.get(0)).canvasPageXml;
                    if (bh.ov(str)) {
                        vkVar = fVar.field_favProto.weS;
                        str = "";
                        str2 = "";
                        str3 = "";
                        if (fVar.field_favProto.web != null) {
                            vtVar = fVar.field_favProto.web;
                            str = vtVar.wfz;
                            str2 = vtVar.title;
                            str3 = vtVar.desc;
                        }
                        if (vkVar != null && bh.ov(r2)) {
                            str = vkVar.hOf;
                        }
                        if (bh.ov(str)) {
                            p = j.p(fVar);
                            if (p != null) {
                                if (bh.ov(str2)) {
                                    str2 = p.title;
                                }
                                if (bh.ov(str3)) {
                                    str3 = str2;
                                    str2 = p.desc;
                                    x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", str);
                                    intent.putExtra("showShare", z);
                                    intent.putExtra("is_favorite_item", true);
                                    intent.putExtra("fav_local_id", fVar.field_localId);
                                    str4 = "favorite_control_argument";
                                    bundle = new Bundle();
                                    bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aHJ());
                                    bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aHK());
                                    bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wek & 4) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wek & 8) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wek & 16) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wek & 32) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wek & 64) == 0);
                                    x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                                    intent.putExtra(str4, bundle);
                                    intent.putExtra("sentUsername", fVar.field_fromUser);
                                    if (!(vkVar == null || bh.ov(vkVar.fnl))) {
                                        intent.putExtra("srcDisplayname", r.gu(vkVar.fnl));
                                    }
                                    intent.putExtra("mode", 1);
                                    intent.putExtra("geta8key_scene", 14);
                                    bundle2 = new Bundle();
                                    bundle2.putString("key_snsad_statextstr", j.p(fVar).fGG);
                                    intent.putExtra("jsapiargs", bundle2);
                                    intent.putExtra("from_scence", 4);
                                    str5 = "fav_" + q.FS() + "_" + fVar.field_id;
                                    intent.putExtra("KPublisherId", str5);
                                    intent.putExtra("pre_username", fVar.field_fromUser);
                                    intent.putExtra("prePublishId", str5);
                                    intent.putExtra("preUsername", fVar.field_fromUser);
                                    intent.putExtra("share_report_pre_msg_url", str);
                                    intent.putExtra("share_report_pre_msg_title", str3);
                                    intent.putExtra("share_report_pre_msg_desc", str2);
                                    intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                                    intent.putExtra("share_report_pre_msg_appid", "");
                                    intent.putExtra("share_report_from_scene", 4);
                                    mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                                    mO.putInt("mm_rpt_fav_id", fVar.field_id);
                                    mO.putInt("key_detail_fav_scene", vgVar.scene);
                                    mO.putInt("key_detail_fav_sub_scene", vgVar.moj);
                                    mO.putInt("key_detail_fav_index", vgVar.index);
                                    intent.putExtra("mm_report_bundle", mO);
                                    d.j(intent, context);
                                }
                            }
                            str6 = str3;
                            str3 = str2;
                            str2 = str6;
                            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                            intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", z);
                            intent.putExtra("is_favorite_item", true);
                            intent.putExtra("fav_local_id", fVar.field_localId);
                            str4 = "favorite_control_argument";
                            bundle = new Bundle();
                            bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aHJ());
                            bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aHK());
                            if ((fVar.field_favProto.wek & 4) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wek & 4) == 0);
                            if ((fVar.field_favProto.wek & 8) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wek & 8) == 0);
                            if ((fVar.field_favProto.wek & 16) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wek & 16) == 0);
                            if ((fVar.field_favProto.wek & 32) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wek & 32) == 0);
                            if ((fVar.field_favProto.wek & 64) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wek & 64) == 0);
                            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                            intent.putExtra(str4, bundle);
                            intent.putExtra("sentUsername", fVar.field_fromUser);
                            intent.putExtra("srcDisplayname", r.gu(vkVar.fnl));
                            intent.putExtra("mode", 1);
                            intent.putExtra("geta8key_scene", 14);
                            bundle2 = new Bundle();
                            bundle2.putString("key_snsad_statextstr", j.p(fVar).fGG);
                            intent.putExtra("jsapiargs", bundle2);
                            intent.putExtra("from_scence", 4);
                            str5 = "fav_" + q.FS() + "_" + fVar.field_id;
                            intent.putExtra("KPublisherId", str5);
                            intent.putExtra("pre_username", fVar.field_fromUser);
                            intent.putExtra("prePublishId", str5);
                            intent.putExtra("preUsername", fVar.field_fromUser);
                            intent.putExtra("share_report_pre_msg_url", str);
                            intent.putExtra("share_report_pre_msg_title", str3);
                            intent.putExtra("share_report_pre_msg_desc", str2);
                            intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                            intent.putExtra("share_report_pre_msg_appid", "");
                            intent.putExtra("share_report_from_scene", 4);
                            mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                            mO.putInt("mm_rpt_fav_id", fVar.field_id);
                            mO.putInt("key_detail_fav_scene", vgVar.scene);
                            mO.putInt("key_detail_fav_sub_scene", vgVar.moj);
                            mO.putInt("key_detail_fav_index", vgVar.index);
                            intent.putExtra("mm_report_bundle", mO);
                            d.j(intent, context);
                        }
                    }
                    intent2 = new Intent();
                    intent2.putExtra("sns_landing_pages_xml", str);
                    intent2.putExtra("sns_landig_pages_from_source", 7);
                    intent2.putExtra("sns_landing_pages_share_thumb_url", G(fVar));
                    intent2.putExtra("sns_landing_favid", q.FS() + "_" + fVar.field_id);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    com.tencent.mm.bm.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
                    return;
                }
            }
            str = fVar.field_favProto.web.canvasPageXml;
            if (bh.ov(str)) {
                vkVar = fVar.field_favProto.weS;
                str = "";
                str2 = "";
                str3 = "";
                if (fVar.field_favProto.web != null) {
                    vtVar = fVar.field_favProto.web;
                    str = vtVar.wfz;
                    str2 = vtVar.title;
                    str3 = vtVar.desc;
                }
                str = vkVar.hOf;
                if (bh.ov(str)) {
                    p = j.p(fVar);
                    if (p != null) {
                        if (bh.ov(str2)) {
                            str2 = p.title;
                        }
                        if (bh.ov(str3)) {
                            str3 = str2;
                            str2 = p.desc;
                            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                            intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", z);
                            intent.putExtra("is_favorite_item", true);
                            intent.putExtra("fav_local_id", fVar.field_localId);
                            str4 = "favorite_control_argument";
                            bundle = new Bundle();
                            bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aHJ());
                            bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aHK());
                            if ((fVar.field_favProto.wek & 4) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wek & 4) == 0);
                            if ((fVar.field_favProto.wek & 8) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wek & 8) == 0);
                            if ((fVar.field_favProto.wek & 16) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wek & 16) == 0);
                            if ((fVar.field_favProto.wek & 32) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wek & 32) == 0);
                            if ((fVar.field_favProto.wek & 64) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wek & 64) == 0);
                            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                            intent.putExtra(str4, bundle);
                            intent.putExtra("sentUsername", fVar.field_fromUser);
                            intent.putExtra("srcDisplayname", r.gu(vkVar.fnl));
                            intent.putExtra("mode", 1);
                            intent.putExtra("geta8key_scene", 14);
                            bundle2 = new Bundle();
                            bundle2.putString("key_snsad_statextstr", j.p(fVar).fGG);
                            intent.putExtra("jsapiargs", bundle2);
                            intent.putExtra("from_scence", 4);
                            str5 = "fav_" + q.FS() + "_" + fVar.field_id;
                            intent.putExtra("KPublisherId", str5);
                            intent.putExtra("pre_username", fVar.field_fromUser);
                            intent.putExtra("prePublishId", str5);
                            intent.putExtra("preUsername", fVar.field_fromUser);
                            intent.putExtra("share_report_pre_msg_url", str);
                            intent.putExtra("share_report_pre_msg_title", str3);
                            intent.putExtra("share_report_pre_msg_desc", str2);
                            intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                            intent.putExtra("share_report_pre_msg_appid", "");
                            intent.putExtra("share_report_from_scene", 4);
                            mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                            mO.putInt("mm_rpt_fav_id", fVar.field_id);
                            mO.putInt("key_detail_fav_scene", vgVar.scene);
                            mO.putInt("key_detail_fav_sub_scene", vgVar.moj);
                            mO.putInt("key_detail_fav_index", vgVar.index);
                            intent.putExtra("mm_report_bundle", mO);
                            d.j(intent, context);
                        }
                    }
                    str6 = str3;
                    str3 = str2;
                    str2 = str6;
                    x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", z);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", fVar.field_localId);
                    str4 = "favorite_control_argument";
                    bundle = new Bundle();
                    bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aHJ());
                    bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aHK());
                    if ((fVar.field_favProto.wek & 4) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wek & 4) == 0);
                    if ((fVar.field_favProto.wek & 8) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wek & 8) == 0);
                    if ((fVar.field_favProto.wek & 16) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wek & 16) == 0);
                    if ((fVar.field_favProto.wek & 32) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wek & 32) == 0);
                    if ((fVar.field_favProto.wek & 64) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wek & 64) == 0);
                    x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                    intent.putExtra(str4, bundle);
                    intent.putExtra("sentUsername", fVar.field_fromUser);
                    intent.putExtra("srcDisplayname", r.gu(vkVar.fnl));
                    intent.putExtra("mode", 1);
                    intent.putExtra("geta8key_scene", 14);
                    bundle2 = new Bundle();
                    bundle2.putString("key_snsad_statextstr", j.p(fVar).fGG);
                    intent.putExtra("jsapiargs", bundle2);
                    intent.putExtra("from_scence", 4);
                    str5 = "fav_" + q.FS() + "_" + fVar.field_id;
                    intent.putExtra("KPublisherId", str5);
                    intent.putExtra("pre_username", fVar.field_fromUser);
                    intent.putExtra("prePublishId", str5);
                    intent.putExtra("preUsername", fVar.field_fromUser);
                    intent.putExtra("share_report_pre_msg_url", str);
                    intent.putExtra("share_report_pre_msg_title", str3);
                    intent.putExtra("share_report_pre_msg_desc", str2);
                    intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                    intent.putExtra("share_report_pre_msg_appid", "");
                    intent.putExtra("share_report_from_scene", 4);
                    mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                    mO.putInt("mm_rpt_fav_id", fVar.field_id);
                    mO.putInt("key_detail_fav_scene", vgVar.scene);
                    mO.putInt("key_detail_fav_sub_scene", vgVar.moj);
                    mO.putInt("key_detail_fav_index", vgVar.index);
                    intent.putExtra("mm_report_bundle", mO);
                    d.j(intent, context);
                }
            }
            intent2 = new Intent();
            intent2.putExtra("sns_landing_pages_xml", str);
            intent2.putExtra("sns_landig_pages_from_source", 7);
            intent2.putExtra("sns_landing_pages_share_thumb_url", G(fVar));
            intent2.putExtra("sns_landing_favid", q.FS() + "_" + fVar.field_id);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bm.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
            return;
        }
        str = null;
        if (bh.ov(str)) {
            intent2 = new Intent();
            intent2.putExtra("sns_landing_pages_xml", str);
            intent2.putExtra("sns_landig_pages_from_source", 7);
            intent2.putExtra("sns_landing_pages_share_thumb_url", G(fVar));
            intent2.putExtra("sns_landing_favid", q.FS() + "_" + fVar.field_id);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bm.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
            return;
        }
        vkVar = fVar.field_favProto.weS;
        str = "";
        str2 = "";
        str3 = "";
        if (fVar.field_favProto.web != null) {
            vtVar = fVar.field_favProto.web;
            str = vtVar.wfz;
            str2 = vtVar.title;
            str3 = vtVar.desc;
        }
        str = vkVar.hOf;
        if (bh.ov(str)) {
            p = j.p(fVar);
            if (p != null) {
                if (bh.ov(str2)) {
                    str2 = p.title;
                }
                if (bh.ov(str3)) {
                    str3 = str2;
                    str2 = p.desc;
                    x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", z);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", fVar.field_localId);
                    str4 = "favorite_control_argument";
                    bundle = new Bundle();
                    bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aHJ());
                    bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aHK());
                    if ((fVar.field_favProto.wek & 4) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wek & 4) == 0);
                    if ((fVar.field_favProto.wek & 8) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wek & 8) == 0);
                    if ((fVar.field_favProto.wek & 16) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wek & 16) == 0);
                    if ((fVar.field_favProto.wek & 32) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wek & 32) == 0);
                    if ((fVar.field_favProto.wek & 64) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wek & 64) == 0);
                    x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                    intent.putExtra(str4, bundle);
                    intent.putExtra("sentUsername", fVar.field_fromUser);
                    intent.putExtra("srcDisplayname", r.gu(vkVar.fnl));
                    intent.putExtra("mode", 1);
                    intent.putExtra("geta8key_scene", 14);
                    bundle2 = new Bundle();
                    bundle2.putString("key_snsad_statextstr", j.p(fVar).fGG);
                    intent.putExtra("jsapiargs", bundle2);
                    intent.putExtra("from_scence", 4);
                    str5 = "fav_" + q.FS() + "_" + fVar.field_id;
                    intent.putExtra("KPublisherId", str5);
                    intent.putExtra("pre_username", fVar.field_fromUser);
                    intent.putExtra("prePublishId", str5);
                    intent.putExtra("preUsername", fVar.field_fromUser);
                    intent.putExtra("share_report_pre_msg_url", str);
                    intent.putExtra("share_report_pre_msg_title", str3);
                    intent.putExtra("share_report_pre_msg_desc", str2);
                    intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                    intent.putExtra("share_report_pre_msg_appid", "");
                    intent.putExtra("share_report_from_scene", 4);
                    mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
                    mO.putInt("mm_rpt_fav_id", fVar.field_id);
                    mO.putInt("key_detail_fav_scene", vgVar.scene);
                    mO.putInt("key_detail_fav_sub_scene", vgVar.moj);
                    mO.putInt("key_detail_fav_index", vgVar.index);
                    intent.putExtra("mm_report_bundle", mO);
                    d.j(intent, context);
                }
            }
            str6 = str3;
            str3 = str2;
            str2 = str6;
            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", z);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", fVar.field_localId);
            str4 = "favorite_control_argument";
            bundle = new Bundle();
            bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aHJ());
            bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aHK());
            if ((fVar.field_favProto.wek & 4) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wek & 4) == 0);
            if ((fVar.field_favProto.wek & 8) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wek & 8) == 0);
            if ((fVar.field_favProto.wek & 16) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wek & 16) == 0);
            if ((fVar.field_favProto.wek & 32) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wek & 32) == 0);
            if ((fVar.field_favProto.wek & 64) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wek & 64) == 0);
            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
            intent.putExtra(str4, bundle);
            intent.putExtra("sentUsername", fVar.field_fromUser);
            intent.putExtra("srcDisplayname", r.gu(vkVar.fnl));
            intent.putExtra("mode", 1);
            intent.putExtra("geta8key_scene", 14);
            bundle2 = new Bundle();
            bundle2.putString("key_snsad_statextstr", j.p(fVar).fGG);
            intent.putExtra("jsapiargs", bundle2);
            intent.putExtra("from_scence", 4);
            str5 = "fav_" + q.FS() + "_" + fVar.field_id;
            intent.putExtra("KPublisherId", str5);
            intent.putExtra("pre_username", fVar.field_fromUser);
            intent.putExtra("prePublishId", str5);
            intent.putExtra("preUsername", fVar.field_fromUser);
            intent.putExtra("share_report_pre_msg_url", str);
            intent.putExtra("share_report_pre_msg_title", str3);
            intent.putExtra("share_report_pre_msg_desc", str2);
            intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
            intent.putExtra("share_report_pre_msg_appid", "");
            intent.putExtra("share_report_from_scene", 4);
            mO = com.tencent.mm.modelstat.a.b.mO(com.tencent.mm.pluginsdk.model.e.class.getName());
            mO.putInt("mm_rpt_fav_id", fVar.field_id);
            mO.putInt("key_detail_fav_scene", vgVar.scene);
            mO.putInt("key_detail_fav_sub_scene", vgVar.moj);
            mO.putInt("key_detail_fav_index", vgVar.index);
            intent.putExtra("mm_report_bundle", mO);
            d.j(intent, context);
        }
    }

    private static void b(Context context, f fVar, vg vgVar) {
        h.a(h.a.mpP, fVar);
        Intent intent = new Intent(context, FavoriteSightDetailUI.class);
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        intent.putExtra("key_detail_fav_scene", vgVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vgVar.moj);
        intent.putExtra("key_detail_fav_index", vgVar.index);
        context.startActivity(intent);
    }

    private static void c(Context context, f fVar, vg vgVar) {
        boolean z;
        uq p = j.p(fVar);
        ut utVar = p.wdJ;
        if (utVar == null || bh.ov(utVar.hdo)) {
            z = false;
        } else {
            h.a(h.a.mpR, fVar);
            String i = j.i(p);
            Intent intent = new Intent();
            intent.putExtra("IsAd", false);
            intent.putExtra("KStremVideoUrl", utVar.hdo);
            intent.putExtra("StreamWording", utVar.hdr);
            intent.putExtra("StremWebUrl", utVar.hds);
            intent.putExtra("KThumUrl", utVar.hdt);
            intent.putExtra("KSta_StremVideoAduxInfo", utVar.hdu);
            intent.putExtra("KSta_StremVideoPublishId", utVar.hdv);
            intent.putExtra("KSta_SourceType", 2);
            intent.putExtra("KSta_Scene", h.b.mqb.value);
            intent.putExtra("KSta_FromUserName", fVar.field_fromUser);
            intent.putExtra("KSta_FavID", fVar.field_id);
            intent.putExtra("KSta_SnsStatExtStr", p.fGG);
            intent.putExtra("KBlockFav", true);
            intent.putExtra("KMediaId", "fakeid_" + fVar.field_id);
            intent.putExtra("KThumbPath", i);
            intent.putExtra("KMediaVideoTime", utVar.weC);
            intent.putExtra("KMediaTitle", utVar.hdq);
            com.tencent.mm.bm.d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
            z = true;
        }
        if (!z) {
            if (bh.ov(p.wda) || p.wde <= 0) {
                x.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[]{p.wda, Long.valueOf(p.wde)});
                String str = j.p(fVar).wcQ;
                if (bh.ov(str)) {
                    str = j.p(fVar).wcU;
                }
                if (bh.ov(str)) {
                    x.w("MicroMsg.FavItemLogic", "onClick video url null, return");
                    b(context, fVar, vgVar);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("is_favorite_item", true);
                intent2.putExtra("fav_local_id", fVar.field_localId);
                intent2.putExtra("geta8key_scene", 14);
                x.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId)});
                d.j(intent2, context);
                return;
            }
            Intent intent3 = new Intent(context, FavoriteSightDetailUI.class);
            intent3.putExtra("key_detail_fav_scene", vgVar.scene);
            intent3.putExtra("key_detail_fav_sub_scene", vgVar.moj);
            intent3.putExtra("key_detail_fav_index", vgVar.index);
            intent3.putExtra("key_detail_info_id", fVar.field_localId);
            context.startActivity(intent3);
        }
    }

    public static void d(Context context, f fVar, vg vgVar) {
        Intent intent = new Intent(context, FavoriteImgDetailUI.class);
        intent.putExtra("key_detail_fav_scene", vgVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vgVar.moj);
        intent.putExtra("key_detail_fav_index", vgVar.index);
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        context.startActivity(intent);
    }

    public static String[] a(f fVar, af afVar) {
        String str = null;
        if (fVar == null) {
            x.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            return null;
        }
        uq p = j.p(fVar);
        String[] strArr = new String[2];
        Runnable 1 = new 1(fVar, p);
        vd vdVar;
        switch (fVar.field_type) {
            case 5:
                vt vtVar = fVar.field_favProto.web;
                if (p == null) {
                    if (vtVar != null) {
                        strArr[1] = vtVar.thumbUrl;
                        break;
                    }
                }
                String str2 = vtVar == null ? null : vtVar.thumbUrl;
                if (bh.ov(str2)) {
                    str2 = p.fqf;
                }
                strArr[0] = j.i(p);
                strArr[1] = str2;
                afVar.post(1);
                break;
                break;
            case 10:
                vdVar = fVar.field_favProto.wed;
                if (vdVar != null) {
                    strArr[1] = vdVar.thumbUrl;
                    break;
                }
                break;
            case 11:
                vdVar = fVar.field_favProto.wed;
                if (vdVar != null) {
                    strArr[1] = vdVar.thumbUrl;
                    break;
                }
                break;
            case 14:
            case 18:
                if (fVar.field_favProto.weU != null) {
                    Iterator it = fVar.field_favProto.weU.iterator();
                    while (it.hasNext()) {
                        uq uqVar = (uq) it.next();
                        if (uqVar.bjS == 2) {
                            str = j.h(uqVar);
                            afVar.post(1);
                        } else if (uqVar.bjS == 15) {
                            str = j.i(uqVar);
                            afVar.post(1);
                        }
                        strArr[0] = str;
                    }
                    strArr[0] = str;
                }
                strArr[1] = p.fqf;
                break;
            case 15:
                vn vnVar = fVar.field_favProto.wef;
                if (vnVar != null) {
                    strArr[1] = vnVar.thumbUrl;
                    break;
                }
                break;
            default:
                if (p != null) {
                    strArr[0] = j.i(p);
                    strArr[1] = p.fqf;
                    afVar.post(1);
                    break;
                }
                break;
        }
        x.d("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[]{strArr[0], strArr[1], Integer.valueOf(fVar.field_type)});
        return strArr;
    }

    public static void a(com.tencent.mm.pluginsdk.ui.applet.e.a aVar, final Context context, final f fVar) {
        String str = null;
        if (fVar == null || context == null) {
            x.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        String absolutePath;
        vt vtVar;
        uq p = j.p(fVar);
        if (fVar == null) {
            x.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
        } else {
            uq p2 = j.p(fVar);
            File file;
            if (5 == fVar.field_type) {
                file = new File(j.i(p2));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else {
                    vt vtVar2 = fVar.field_favProto.web;
                    absolutePath = vtVar2 == null ? null : vtVar2.thumbUrl;
                    if (bh.ov(absolutePath)) {
                        absolutePath = p2.fqf;
                    }
                    absolutePath = j.Aa(absolutePath);
                    if (bh.ov(absolutePath)) {
                        absolutePath = Integer.valueOf(R.k.dvD);
                    }
                }
            } else {
                if (11 == fVar.field_type || 10 == fVar.field_type) {
                    vd vdVar = fVar.field_favProto.wed;
                    if (vdVar != null) {
                        absolutePath = j.Aa(vdVar.thumbUrl);
                        if (bh.ov(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.dvx);
                        }
                    }
                }
                if (15 == fVar.field_type || 12 == fVar.field_type) {
                    vn vnVar = fVar.field_favProto.wef;
                    if (vnVar != null) {
                        absolutePath = j.Aa(vnVar.thumbUrl);
                        if (bh.ov(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.dvx);
                        }
                    }
                }
                if (2 == fVar.field_type || 7 == fVar.field_type || 16 == fVar.field_type || 4 == fVar.field_type) {
                    file = new File(j.i(p2));
                    if (!file.exists()) {
                        absolutePath = j.Aa(p2.fqf);
                        if (bh.ov(absolutePath)) {
                            j.b(fVar, p2, true);
                            absolutePath = j.i(p2);
                        }
                        if (bh.ov(absolutePath)) {
                            switch (fVar.field_type) {
                                case 2:
                                    absolutePath = Integer.valueOf(R.g.byV);
                                    break;
                                case 7:
                                    absolutePath = Integer.valueOf(R.k.dvn);
                                    break;
                                default:
                                    absolutePath = Integer.valueOf(R.k.dvA);
                                    break;
                            }
                        }
                    }
                    absolutePath = file.getAbsolutePath();
                } else if (!(3 == fVar.field_type || 6 == fVar.field_type)) {
                    if (8 == fVar.field_type) {
                        absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.Rd(p2.wcY));
                    } else if (17 == fVar.field_type) {
                        ar.Hg();
                        r2 = c.Fa().EK(p2.desc);
                        absolutePath = (r2.rYX == null || r2.rYX.length() == 0) ? Integer.valueOf(R.g.bBB) : new SpannableString(r2.rYX);
                    } else if (14 == fVar.field_type && fVar.field_favProto.weU != null) {
                        Iterator it = fVar.field_favProto.weU.iterator();
                        while (it.hasNext()) {
                            uq uqVar = (uq) it.next();
                            if (uqVar.bjS != 1) {
                                if (uqVar.bjS == 3) {
                                    absolutePath = Integer.valueOf(R.k.dvC);
                                    break;
                                } else if (uqVar.bjS == 6) {
                                    absolutePath = Integer.valueOf(R.k.dvm);
                                    break;
                                } else if (uqVar.bjS == 8) {
                                    absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.Rd(uqVar.wcY));
                                    break;
                                } else if (uqVar.bjS == 2 || uqVar.bjS == 7 || uqVar.bjS == 15 || uqVar.bjS == 4) {
                                    file = new File(j.i(uqVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        r2 = j.Aa(uqVar.fqf);
                                        if (bh.ov(r2)) {
                                            switch (uqVar.bjS) {
                                                case 2:
                                                    absolutePath = Integer.valueOf(R.g.byV);
                                                    break;
                                                case 7:
                                                    absolutePath = Integer.valueOf(R.k.dvn);
                                                    break;
                                                default:
                                                    absolutePath = Integer.valueOf(R.k.dvA);
                                                    break;
                                            }
                                        }
                                        absolutePath = r2;
                                    }
                                } else if (uqVar.bjS == 5) {
                                    file = new File(j.i(uqVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        vtVar = uqVar.wdD.web;
                                        r2 = vtVar == null ? null : vtVar.thumbUrl;
                                        if (bh.ov(r2)) {
                                            r2 = uqVar.fqf;
                                        }
                                        absolutePath = j.Aa(r2);
                                        if (bh.ov(absolutePath)) {
                                            absolutePath = Integer.valueOf(R.k.dvD);
                                        }
                                    }
                                } else {
                                    if (uqVar.bjS == 10 || uqVar.bjS == 11) {
                                        vd vdVar2 = uqVar.wdD.wed;
                                        if (vdVar2 != null) {
                                            absolutePath = j.Aa(vdVar2.thumbUrl);
                                            if (bh.ov(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.dvx);
                                            }
                                        }
                                    }
                                    if (uqVar.bjS == 12 || uqVar.bjS == 14) {
                                        vn vnVar2 = uqVar.wdD.wef;
                                        if (vnVar2 != null) {
                                            absolutePath = j.Aa(vnVar2.thumbUrl);
                                            if (bh.ov(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.dvx);
                                            }
                                        }
                                    }
                                    if (uqVar.bjS == 16) {
                                        ar.Hg();
                                        r2 = c.Fa().EK(uqVar.desc);
                                        absolutePath = (r2.rYX == null || r2.rYX.length() == 0) ? Integer.valueOf(R.g.bBB) : new SpannableString(r2.rYX);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (absolutePath instanceof String) {
                if (absolutePath instanceof Integer) {
                    ((Integer) absolutePath).intValue();
                }
                absolutePath = null;
            } else {
                absolutePath = absolutePath;
            }
            vtVar = fVar.field_favProto.web;
            switch (fVar.field_type) {
                case 1:
                    aVar.Sp(fVar.field_favProto.desc);
                    aVar.caS();
                    aVar.a(new i$a$a() {
                        public final void aJL() {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", fVar.field_favProto.desc);
                            com.tencent.mm.bm.d.a(context, ".ui.transmit.RetransmitPreviewUI", intent);
                            com.tencent.mm.ui.base.b.fF(context);
                        }
                    });
                    return;
                case 2:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.UN(absolutePath), 3);
                    return;
                case 4:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.UN(absolutePath), 2);
                    return;
                case 5:
                    if (vtVar != null || bh.ov(vtVar.title)) {
                        absolutePath = null;
                    } else {
                        absolutePath = vtVar.title;
                        str = vtVar.desc;
                    }
                    if (bh.ov(absolutePath)) {
                        absolutePath = p.title;
                    }
                    if (bh.ov(str)) {
                        str = p.desc;
                    }
                    aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dGU)).append(absolutePath).toString());
                    return;
                case 6:
                    aVar.Sp(context.getString(R.l.dFz) + fVar.field_favProto.wdZ.label);
                    return;
                case 7:
                    if (!(vtVar == null || bh.ov(vtVar.title))) {
                        str = vtVar.title;
                    }
                    if (bh.ov(str)) {
                        str = p.title;
                    }
                    aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dFJ)).append(str).toString());
                    return;
                case 8:
                    absolutePath = fVar.field_favProto.title;
                    if (bh.ov(absolutePath)) {
                        absolutePath = p.title;
                    }
                    aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dFj)).append(absolutePath).toString());
                    return;
                case 14:
                    aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dGs)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).title).toString());
                    return;
                case 16:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.UN(absolutePath), 2);
                    return;
                case 18:
                    aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dFT)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).desc.replaceAll("\n", " ")).toString());
                    return;
                default:
                    if (!(vtVar == null || bh.ov(vtVar.title))) {
                        str = vtVar.title;
                    }
                    if (bh.ov(str)) {
                        str = p.title;
                    }
                    aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dDN)).append(str).toString());
                    return;
            }
        }
        absolutePath = null;
        if (absolutePath instanceof String) {
            if (absolutePath instanceof Integer) {
                ((Integer) absolutePath).intValue();
            }
            absolutePath = null;
        } else {
            absolutePath = absolutePath;
        }
        vtVar = fVar.field_favProto.web;
        switch (fVar.field_type) {
            case 1:
                aVar.Sp(fVar.field_favProto.desc);
                aVar.caS();
                aVar.a(/* anonymous class already generated */);
                return;
            case 2:
                aVar.a(com.tencent.mm.sdk.platformtools.d.UN(absolutePath), 3);
                return;
            case 4:
                aVar.a(com.tencent.mm.sdk.platformtools.d.UN(absolutePath), 2);
                return;
            case 5:
                if (vtVar != null) {
                    break;
                }
                absolutePath = null;
                if (bh.ov(absolutePath)) {
                    absolutePath = p.title;
                }
                if (bh.ov(str)) {
                    str = p.desc;
                }
                aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dGU)).append(absolutePath).toString());
                return;
            case 6:
                aVar.Sp(context.getString(R.l.dFz) + fVar.field_favProto.wdZ.label);
                return;
            case 7:
                str = vtVar.title;
                if (bh.ov(str)) {
                    str = p.title;
                }
                aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dFJ)).append(str).toString());
                return;
            case 8:
                absolutePath = fVar.field_favProto.title;
                if (bh.ov(absolutePath)) {
                    absolutePath = p.title;
                }
                aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dFj)).append(absolutePath).toString());
                return;
            case 14:
                aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dGs)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).title).toString());
                return;
            case 16:
                aVar.a(com.tencent.mm.sdk.platformtools.d.UN(absolutePath), 2);
                return;
            case 18:
                aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dFT)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).desc.replaceAll("\n", " ")).toString());
                return;
            default:
                str = vtVar.title;
                if (bh.ov(str)) {
                    str = p.title;
                }
                aVar.Sp(new StringBuffer(context.getResources().getString(R.l.dDN)).append(str).toString());
                return;
        }
    }

    public static void b(com.tencent.mm.pluginsdk.ui.applet.e.a aVar, final Context context, final f fVar) {
        if (fVar == null || context == null) {
            x.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        final uq p = j.p(fVar);
        switch (fVar.field_type) {
            case 1:
                aVar.a(new 5(fVar, context));
                return;
            case 2:
                aVar.a(new i$a$a() {
                    public final void aJL() {
                        Intent intent = new Intent(context, FavImgGalleryUI.class);
                        intent.putExtra("key_detail_info_id", fVar.field_localId);
                        intent.putExtra("key_detail_data_id", p.mvG);
                        intent.putExtra("show_share", false);
                        context.startActivity(intent);
                    }
                });
                return;
            case 4:
            case 16:
                aVar.a(new 10(fVar, context));
                return;
            case 5:
                aVar.a(new 7(context, fVar));
                return;
            case 6:
                aVar.a(new 6(fVar.field_favProto.wdZ, context));
                return;
            case 8:
                aVar.a(new 4(context, fVar));
                return;
            case 14:
                aVar.a(new 8(context, fVar));
                return;
            case 18:
                aVar.a(new i$a$a() {
                    public final void aJL() {
                        e.b(context, fVar, false, new vg());
                    }
                });
                return;
            default:
                return;
        }
    }
}
