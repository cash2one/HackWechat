package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.bkl;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.d.i;

public final class ah extends a {
    private String appId;
    private String appName;
    MMActivity fmM;
    private String iKB;
    private int rsj;
    private b rsp = null;
    private boolean rtD = false;
    private boolean rtE = false;
    private WXMediaMessage rtF = null;
    private boolean ruz = false;
    b rvD = new b(this);
    private w rvE;
    Map<String, com.tencent.mm.compatible.util.Exif.a> rvF = new HashMap();
    private Map<String, bkl> rvG = new HashMap();
    private int rvH = 0;
    private boolean rvI = false;
    aoy rvJ;

    class a extends h<String, Integer, Boolean> {
        private ProgressDialog iln = null;
        private aw ruB;
        final /* synthetic */ ah rvK;
        private List<com.tencent.mm.plugin.sns.data.h> rvL;

        public final /* synthetic */ Object buP() {
            long currentTimeMillis = System.currentTimeMillis();
            aw awVar = this.ruB;
            awVar.bN(this.rvL);
            this.ruB = awVar;
            x.d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            this.iln.dismiss();
            this.rvK.a(this.ruB);
        }

        public a(ah ahVar, aw awVar, List<com.tencent.mm.plugin.sns.data.h> list) {
            this.rvK = ahVar;
            this.ruB = awVar;
            this.rvL = list;
            Context context = ahVar.fmM;
            ahVar.fmM.getString(j.dGO);
            this.iln = com.tencent.mm.ui.base.h.a(context, ahVar.fmM.getString(j.dFy), false, new 1(this, ahVar));
        }

        public final af buO() {
            return ae.bvi();
        }
    }

    public ah(MMActivity mMActivity) {
        this.fmM = mMActivity;
    }

    public final void F(Bundle bundle) {
        String str;
        int i = 1;
        this.rsp = b.q(this.fmM.getIntent());
        this.ruz = this.fmM.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rtD = this.fmM.getIntent().getBooleanExtra("KThrid_app", false);
        this.rvI = this.fmM.getIntent().getBooleanExtra("KBlockAdd", false);
        this.rtE = this.fmM.getIntent().getBooleanExtra("KSnsAction", false);
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.iKB = bh.az(this.fmM.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.fmM.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rtF = new Req(bundleExtra).message;
        }
        String stringExtra = this.fmM.getIntent().getStringExtra("sns_kemdia_path");
        byte[] byteArrayExtra = this.fmM.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (byteArrayExtra == null && this.rtF != null && this.rtF.mediaObject != null && (this.rtF.mediaObject instanceof WXImageObject)) {
            byteArrayExtra = ((WXImageObject) this.rtF.mediaObject).imageData;
        }
        if (!bh.ov(stringExtra) || bh.bw(byteArrayExtra)) {
            str = stringExtra;
        } else {
            stringExtra = ae.getAccSnsTmpPath() + g.s((" " + System.currentTimeMillis()).getBytes());
            FileOp.deleteFile(stringExtra);
            FileOp.b(stringExtra, byteArrayExtra, byteArrayExtra.length);
            str = stringExtra;
        }
        int intExtra = this.fmM.getIntent().getIntExtra("KFilterId", 0);
        if (bundle == null) {
            stringExtra = null;
        } else {
            stringExtra = bundle.getString("sns_kemdia_path_list");
        }
        H(bundle);
        boolean H = H(this.fmM.getIntent().getExtras());
        this.rvH = 0;
        if (!bh.ov(stringExtra)) {
            this.rvD.LV(stringExtra);
        } else if (bh.ov(str)) {
            ArrayList stringArrayListExtra = this.fmM.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    x.d("MicroMsg.PicWidget", "newPath " + str);
                    this.rvD.m(str, intExtra, false);
                    if (!H) {
                        r1 = Exif.fromFile(str).getLocation();
                        if (r1 != null) {
                            this.rvF.put(str, r1);
                        }
                    }
                    try {
                        File file = new File(str);
                        bkl com_tencent_mm_protocal_c_bkl = new bkl();
                        com_tencent_mm_protocal_c_bkl.wNY = this.ruz ? 1 : 2;
                        com_tencent_mm_protocal_c_bkl.wOa = file.lastModified() / 1000;
                        com_tencent_mm_protocal_c_bkl.wNZ = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rvG.put(str, com_tencent_mm_protocal_c_bkl);
                    } catch (Exception e) {
                        x.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                }
            }
        } else {
            int i2;
            String str2 = ae.getAccSnsTmpPath() + "pre_temp_sns_pic" + g.s(str.getBytes());
            File file2 = new File(str2);
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileOp.x(str, str2);
            if (intExtra == -1) {
                i2 = 0;
            } else {
                i2 = intExtra;
            }
            this.rvD.m(str2, i2, this.ruz);
            if (!H) {
                r1 = Exif.fromFile(str).getLocation();
                if (r1 != null) {
                    this.rvF.put(str2, r1);
                }
            }
            try {
                file2 = new File(str);
                bkl com_tencent_mm_protocal_c_bkl2 = new bkl();
                if (!this.ruz) {
                    i = 2;
                }
                com_tencent_mm_protocal_c_bkl2.wNY = i;
                com_tencent_mm_protocal_c_bkl2.wOa = file2.lastModified() / 1000;
                com_tencent_mm_protocal_c_bkl2.wNZ = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                this.rvG.put(str2, com_tencent_mm_protocal_c_bkl2);
            } catch (Exception e2) {
                x.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
            }
        }
    }

    private boolean H(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            return false;
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (3 != split.length) {
                x.e("MicroMsg.PicWidget", "invalid params");
                return true;
            }
            try {
                this.rvF.put(split[0].trim(), new com.tencent.mm.compatible.util.Exif.a(bh.getDouble(split[1], 0.0d), bh.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e) {
                x.e("MicroMsg.PicWidget", e.toString());
            }
        }
        return true;
    }

    public final void G(Bundle bundle) {
        bundle.putString("sns_kemdia_path_list", this.rvD.toString());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.rvF.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", new Object[]{entry.getKey(), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).latitude), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).longitude)}));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
    }

    public final boolean bzj() {
        if (this.rvD != null) {
            b bVar = this.rvD;
            boolean z = bVar.rvO != null && bVar.rvO.size() > 0;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final View a(View view, View view2, DynamicGridView dynamicGridView, View view3) {
        boolean z;
        Context context = this.fmM;
        List list = this.rvD.rvO;
        com.tencent.mm.plugin.sns.ui.w.a anonymousClass1 = new com.tencent.mm.plugin.sns.ui.w.a(this) {
            final /* synthetic */ ah rvK;

            {
                this.rvK = r1;
            }

            public final void xs(int i) {
                x.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    this.rvK.bzY();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(this.rvK.fmM, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", this.rvK.rvD.rvO);
                this.rvK.fmM.startActivityForResult(intent, 7);
            }
        };
        com.tencent.mm.plugin.sns.ui.previewimageview.c.a anonymousClass2 = new com.tencent.mm.plugin.sns.ui.previewimageview.c.a(this) {
            final /* synthetic */ ah rvK;

            {
                this.rvK = r1;
            }

            public final void dD(int i, int i2) {
                b bVar = this.rvK.rvD;
                if (i != i2 && bVar.rvO.size() > i) {
                    String str = (String) bVar.rvO.remove(i);
                    if (i2 < bVar.rvO.size()) {
                        bVar.rvO.add(i2, str);
                    } else {
                        bVar.rvO.add(str);
                    }
                }
            }

            public final void removeItem(int i) {
                b bVar = this.rvK.rvD;
                if (bVar.rvO.size() > i) {
                    bVar.rvO.remove(i);
                }
                if (this.rvK.fmM instanceof SnsUploadUI) {
                    ((SnsUploadUI) this.rvK.fmM).bCg();
                }
            }
        };
        if (this.rvI) {
            z = false;
        } else {
            z = true;
        }
        this.rvE = new e(view, view2, view3, context, list, dynamicGridView, anonymousClass1, anonymousClass2, z);
        return this.rvE.getView();
    }

    public final View bzk() {
        this.rvE = new PreviewImageView(this.fmM);
        if (this.rvI) {
            this.rvE.bzs();
        }
        this.rvE.a(new 3(this));
        this.rvE.bU(this.rvD.rvO);
        return this.rvE.getView();
    }

    private static aw a(aw awVar, List<com.tencent.mm.plugin.sns.data.h> list) {
        awVar.bN(list);
        return awVar;
    }

    final void a(aw awVar) {
        int commit = awVar.commit();
        if (this.rsp != null) {
            this.rsp.iw(commit);
            com.tencent.mm.plugin.sns.h.e.rdF.c(this.rsp);
        }
        if (!(this.rvD == null || this.rvD.rvO == null || !r.byQ())) {
            com.tencent.mm.plugin.report.service.g.pQN.h(12834, new Object[]{Integer.valueOf(this.rvD.rvO.size())});
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.fmM.setResult(-1, intent);
        this.fmM.finish();
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        List<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        Iterator it = this.rvD.rvO.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            com.tencent.mm.plugin.sns.data.h hVar = new com.tencent.mm.plugin.sns.data.h(str3, 2);
            hVar.type = 2;
            hVar.qQX = i;
            if (i6 == 0) {
                hVar.qQW = i2;
                if (iVar != null) {
                    hVar.qQZ = iVar.token;
                    hVar.qRa = iVar.wyk;
                }
            } else {
                hVar.qQW = 0;
            }
            int i7 = i6 + 1;
            b bVar = this.rvD;
            hVar.qQV = bVar.rvQ.containsKey(str3) ? ((Integer) bVar.rvQ.get(str3)).intValue() : 0;
            hVar.desc = str;
            bVar = this.rvD;
            boolean booleanValue = (bh.ov(str3) || !bVar.rvP.containsKey(str3)) ? false : ((Boolean) bVar.rvP.get(str3)).booleanValue();
            hVar.qRc = booleanValue;
            linkedList.add(hVar);
            i6 = i7;
        }
        LinkedList linkedList2 = new LinkedList();
        if (list != null) {
            LinkedList linkedList3 = new LinkedList();
            List GI = s.GI();
            for (String str32 : list) {
                if (!GI.contains(str32)) {
                    bld com_tencent_mm_protocal_c_bld = new bld();
                    com_tencent_mm_protocal_c_bld.ksU = str32;
                    linkedList2.add(com_tencent_mm_protocal_c_bld);
                }
            }
        }
        aw awVar = new aw(1);
        pInt.value = awVar.afu;
        if (iVar != null) {
            awVar.ed(iVar.token, iVar.wyk);
        }
        if (i3 > com.tencent.mm.plugin.sns.c.a.qQF) {
            awVar.wM(3);
        }
        awVar.Kz(str).a(com_tencent_mm_protocal_c_aoy).ai(linkedList2).wO(i).wP(i2);
        if (z) {
            awVar.wR(1);
        } else {
            awVar.wR(0);
        }
        if (!bh.ov(this.appId)) {
            awVar.KF(this.appId);
        }
        if (!bh.ov(this.appName)) {
            awVar.KG(bh.az(this.appName, ""));
        }
        awVar.wQ(this.rsj);
        if (this.rtD) {
            awVar.wQ(5);
        }
        if (this.rtE && this.rtF != null) {
            awVar.KA(this.rtF.mediaTagName);
            awVar.U(this.appId, this.rtF.messageExt, this.rtF.messageAction);
        }
        awVar.e(null, null, null, i4, i5);
        awVar.bM(list2);
        awVar.qf(this.iKB);
        if (!(com_tencent_mm_protocal_c_aoy == null || com_tencent_mm_protocal_c_aoy.score == 0)) {
            i6 = com_tencent_mm_protocal_c_aoy.score;
            String str4 = com_tencent_mm_protocal_c_aoy.wvH;
            awVar.qYr.wyt = new bjg();
            awVar.qYr.wyt.wMI = i6;
            awVar.qYr.wyt.wMF = str4;
        }
        x.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.rvH)});
        com.tencent.mm.plugin.report.service.g.pQN.h(11602, new Object[]{Integer.valueOf(this.rvH), Integer.valueOf(linkedList.size())});
        for (com.tencent.mm.plugin.sns.data.h hVar2 : linkedList) {
            x.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[]{hVar2.path, Long.valueOf(FileOp.me(hVar2.path))});
        }
        for (com.tencent.mm.plugin.sns.data.h hVar22 : linkedList) {
            bkl com_tencent_mm_protocal_c_bkl;
            String str5 = hVar22.path;
            bkl com_tencent_mm_protocal_c_bkl2 = (bkl) this.rvG.get(str5);
            if (com_tencent_mm_protocal_c_bkl2 == null) {
                com_tencent_mm_protocal_c_bkl = new bkl();
            } else {
                com_tencent_mm_protocal_c_bkl = com_tencent_mm_protocal_c_bkl2;
            }
            if (this.rvJ == null || (this.rvJ.vQu == 0.0f && this.rvJ.vQt == 0.0f)) {
                com_tencent_mm_protocal_c_bkl.wNW = -1000.0f;
                com_tencent_mm_protocal_c_bkl.wNX = -1000.0f;
            } else {
                com_tencent_mm_protocal_c_bkl.wNW = this.rvJ.vQu;
                com_tencent_mm_protocal_c_bkl.wNX = this.rvJ.vQt;
                com_tencent_mm_protocal_c_bkl.rui = this.rvJ.rui;
                com_tencent_mm_protocal_c_bkl.biF = this.rvJ.biF;
            }
            com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) this.rvF.get(str5);
            if (aVar == null || (aVar.latitude == 0.0d && aVar.longitude == 0.0d)) {
                com_tencent_mm_protocal_c_bkl.wNU = -1000.0f;
                com_tencent_mm_protocal_c_bkl.wNV = -1000.0f;
            } else {
                com_tencent_mm_protocal_c_bkl.wNU = (float) aVar.latitude;
                com_tencent_mm_protocal_c_bkl.wNV = (float) aVar.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + awVar.qYr.wyo.size());
            stringBuffer.append("||item poi lat " + com_tencent_mm_protocal_c_bkl.wNW + " " + com_tencent_mm_protocal_c_bkl.wNX);
            stringBuffer.append("||item pic lat " + com_tencent_mm_protocal_c_bkl.wNU + " " + com_tencent_mm_protocal_c_bkl.wNV);
            stringBuffer.append("||item exitime:" + com_tencent_mm_protocal_c_bkl.wNZ + " filetime: " + com_tencent_mm_protocal_c_bkl.wOa);
            stringBuffer.append("||item source: " + com_tencent_mm_protocal_c_bkl.wNY);
            x.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            awVar.qYr.wyo.add(com_tencent_mm_protocal_c_bkl);
        }
        if (linkedList.size() <= 1) {
            a(awVar, (List) linkedList);
            a(awVar);
        } else {
            new a(this, awVar, linkedList).m(new String[]{""});
        }
        return true;
    }

    protected final boolean bzY() {
        com.tencent.mm.kernel.g.Dk();
        if (!com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
            u.fI(this.fmM);
            return false;
        } else if (this.rvD.rvO.size() >= 9) {
            com.tencent.mm.ui.base.h.h(this.fmM, j.qMG, j.dGO);
            return false;
        } else {
            try {
                ba baVar = new ba(this.fmM);
                baVar.rKC = new 4(this);
                baVar.rKD = new 5(this);
                baVar.bBX();
            } catch (Exception e) {
            }
            return true;
        }
    }

    public final boolean c(List<String> list, int i, boolean z) {
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.PicWidget", "no image selected");
        } else if (this.rvD.rvO.size() < 9) {
            for (String str : list) {
                if (FileOp.bO(str)) {
                    String str2 = "pre_temp_sns_pic" + g.s((str + System.currentTimeMillis()).getBytes());
                    r.X(ae.getAccSnsTmpPath(), str, str2);
                    x.d("MicroMsg.PicWidget", "newPath " + ae.getAccSnsTmpPath() + str2);
                    this.rvD.m(ae.getAccSnsTmpPath() + str2, i, z);
                    this.rvE.bU(this.rvD.rvO);
                    try {
                        File file = new File(str);
                        bkl com_tencent_mm_protocal_c_bkl = new bkl();
                        com_tencent_mm_protocal_c_bkl.wNY = z ? 1 : 2;
                        com_tencent_mm_protocal_c_bkl.wOa = file.lastModified() / 1000;
                        com_tencent_mm_protocal_c_bkl.wNZ = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rvG.put(ae.getAccSnsTmpPath() + str2, com_tencent_mm_protocal_c_bkl);
                    } catch (Exception e) {
                        x.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                    com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.rvF.put(ae.getAccSnsTmpPath() + str2, location);
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(int i, Intent intent) {
        String b;
        String s;
        switch (i) {
            case 2:
                x.d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    return false;
                }
                x.d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                com.tencent.mm.plugin.sns.c.a.ifs.a(this.fmM, intent, intent2, ae.getAccSnsTmpPath(), 4, new 6(this));
                return true;
            case 3:
                x.d("MicroMsg.PicWidget", "onActivityResult 2");
                b = k.b(this.fmM.getApplicationContext(), intent, ae.getAccSnsTmpPath());
                if (b == null) {
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", b);
                s = g.s((b + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", ae.getAccSnsTmpPath() + s);
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(b).getLocation();
                if (location != null) {
                    this.rvF.put(ae.getAccSnsTmpPath() + s, location);
                    x.d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", new Object[]{Double.valueOf(location.latitude), Double.valueOf(location.longitude)});
                }
                bkl com_tencent_mm_protocal_c_bkl = new bkl();
                com_tencent_mm_protocal_c_bkl.wNY = 1;
                com_tencent_mm_protocal_c_bkl.wOa = System.currentTimeMillis();
                com_tencent_mm_protocal_c_bkl.wNZ = bh.VJ(Exif.fromFile(b).dateTime);
                this.rvG.put(ae.getAccSnsTmpPath() + s, com_tencent_mm_protocal_c_bkl);
                com.tencent.mm.plugin.sns.c.a.ifs.a(this.fmM, intent3, 4);
                this.ruz = true;
                return true;
            case 4:
                x.d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    return true;
                }
                b = intent.getStringExtra("CropImage_OutputPath");
                x.d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath " + b);
                if (b == null) {
                    return true;
                }
                if (!FileOp.bO(b)) {
                    return true;
                }
                if (this.rvD.rvO.size() >= 9) {
                    return true;
                }
                int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                s = "pre_temp_sns_pic" + g.s((b + System.currentTimeMillis()).getBytes());
                x.i("MicroMsg.PicWidget", "onactivity result " + FileOp.me(b) + " " + b);
                FileOp.x(b, ae.getAccSnsTmpPath() + s);
                if (this.rvF.containsKey(b)) {
                    this.rvF.put(ae.getAccSnsTmpPath() + s, this.rvF.get(b));
                }
                b = ae.getAccSnsTmpPath() + s;
                x.d("MicroMsg.PicWidget", "newPath " + b);
                this.rvD.m(b, intExtra, false);
                this.rvE.bU(this.rvD.rvO);
                return true;
            case 7:
                if (intent == null) {
                    return true;
                }
                this.rvD.P(intent.getStringArrayListExtra("sns_gallery_temp_paths"));
                this.rvE.bU(this.rvD.rvO);
                this.rvH = intent.getIntExtra("sns_update_preview_image_count", 0);
                return true;
            case 9:
                return c(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_filterId", 0), intent.getBooleanExtra("isTakePhoto", false));
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    b = sightCaptureResult.oqH;
                    if (!bh.ov(b)) {
                        return c(Collections.singletonList(b), 0, true);
                    }
                }
                break;
        }
        return false;
    }

    public final boolean bzl() {
        if (this.rvE != null) {
            this.rvE.clean();
        }
        return false;
    }
}
