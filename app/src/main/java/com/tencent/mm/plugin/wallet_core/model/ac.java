package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.g.b.dx;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.awc;
import com.tencent.mm.protocal.c.bwx;
import com.tencent.mm.protocal.c.bxa;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class ac extends dx {
    public static a gJc;
    public String odh = "";
    private awc sPM = new awc();
    public bwx sPN = null;
    public bxa sPO = null;
    public boolean sPP = false;
    public String sPQ = "";
    public String sPR = "";
    public String sPS = "";
    public String sPT = "";

    static {
        a aVar = new a();
        aVar.hSY = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.xjA.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "wallet_region";
        aVar.columns[1] = "wallet_grey_item_buf";
        aVar.xjA.put("wallet_grey_item_buf", "BLOB");
        stringBuilder.append(" wallet_grey_item_buf BLOB");
        aVar.columns[2] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public ac() {
        if (this.sPN == null) {
            this.sPN = new bwx();
        }
        if (this.sPO == null) {
            this.sPO = new bxa();
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.sPM = new awc();
        try {
            this.sPM = (awc) this.sPM.aF(this.field_wallet_grey_item_buf);
            this.sPN = this.sPM.wDG;
            this.sPO = this.sPM.wDH;
            this.sPP = this.sPM.wDI;
            this.sPT = "";
            Iterator it = this.sPM.wDJ.iterator();
            while (it.hasNext()) {
                this.sPT += ((String) it.next()) + "\n";
            }
            if (this.sPM.wDE != null) {
                this.sPQ = n.a(this.sPM.wDE.wXR);
                this.sPR = n.a(this.sPM.wDE.wXS);
            }
            if (this.sPM.wDF != null) {
                this.sPS = n.a(this.sPM.wDF.wXP);
                this.odh = n.a(this.sPM.wDF.wXQ);
            }
            x.v("WalletRegionGreyItem", "noticeContent %s", new Object[]{this.sPS});
        } catch (Exception e) {
            x.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.sPN == null) {
            this.sPN = new bwx();
        }
        if (this.sPO == null) {
            this.sPO = new bxa();
        }
    }
}
