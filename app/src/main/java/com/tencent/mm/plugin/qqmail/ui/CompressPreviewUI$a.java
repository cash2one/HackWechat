package com.tencent.mm.plugin.qqmail.ui;

class CompressPreviewUI$a {
    String id;
    String name;
    final /* synthetic */ CompressPreviewUI prM;
    String prO;
    String prP;
    boolean prQ;
    int type;

    public CompressPreviewUI$a(CompressPreviewUI compressPreviewUI, String str, String str2, String str3, int i, String str4, boolean z) {
        this.prM = compressPreviewUI;
        this.id = str;
        this.name = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.prO = str3;
        this.type = i;
        this.prP = str4;
        this.prQ = z;
    }

    public final boolean bkL() {
        return this.type == 1;
    }
}
