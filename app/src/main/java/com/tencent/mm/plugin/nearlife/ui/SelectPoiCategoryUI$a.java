package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class SelectPoiCategoryUI$a extends c<ls> {
    final /* synthetic */ SelectPoiCategoryUI oRn;
    SelectPoiCategoryUI oRo;

    public SelectPoiCategoryUI$a(SelectPoiCategoryUI selectPoiCategoryUI) {
        this.oRn = selectPoiCategoryUI;
        super(0);
        this.xen = ls.class.getName().hashCode();
    }

    private boolean a(ls lsVar) {
        if (lsVar instanceof ls) {
            SelectPoiCategoryUI selectPoiCategoryUI = this.oRo;
            byte[] bArr = lsVar.fDf.content;
            File file = new File(SelectPoiCategoryUI.oRi);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                String str = SelectPoiCategoryUI.oRi + "/lastest_poi_categories.dat";
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                e.b(str, bArr, bArr.length);
            } catch (Exception e) {
                x.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e.getMessage());
            }
            selectPoiCategoryUI.aC(bArr);
            selectPoiCategoryUI.bfk();
        }
        return false;
    }
}
