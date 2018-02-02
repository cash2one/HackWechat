package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GWalletQueryProvider extends ContentProvider {
    public static final String[] tv = new String[]{"_id", "product_id", "full_price", "product_state", "price_currency", "price_amount"};
    private final String TAG = "MicroMsg.GWalletQueryProvider";
    private Context mContext = null;
    private b nzC = null;
    private boolean nzD;
    private boolean nzE;
    private ArrayList<String> nzF;
    private ArrayList<String> nzG;
    private int nzH;

    static /* synthetic */ void d(GWalletQueryProvider gWalletQueryProvider) {
        if (gWalletQueryProvider.nzC != null) {
            gWalletQueryProvider.nzC.a(gWalletQueryProvider.nzG, new c(gWalletQueryProvider) {
                final /* synthetic */ GWalletQueryProvider nzI;

                {
                    this.nzI = r1;
                }

                public final void a(com.tencent.mm.plugin.gwallet.a.c cVar, Intent intent) {
                    x.d("MicroMsg.GWalletQueryProvider", "query detail done! Result " + cVar);
                    this.nzI.nzE = true;
                    this.nzI.nzF = intent.getStringArrayListExtra("RESPONSE_QUERY_DETAIL_INFO");
                    this.nzI.nzH = intent.getIntExtra("RESPONSE_CODE", 0);
                }
            });
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        x.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        int i2;
        JSONException jSONException;
        synchronized (GWalletQueryProvider.class) {
            x.d("MicroMsg.GWalletQueryProvider", "Creating IAB helper.");
            if (strArr2 == null || strArr2.length == 0) {
                x.d("MicroMsg.GWalletQueryProvider", "no product id selected or size is 0");
                throw new IllegalArgumentException("no product id selected or size is 0");
            }
            int i3;
            this.mContext = getContext();
            this.nzC = new b(this.mContext);
            this.nzD = true;
            this.nzE = false;
            this.nzG = new ArrayList();
            for (Object add : strArr2) {
                this.nzG.add(add);
            }
            x.d("MicroMsg.GWalletQueryProvider", "Starting setup.");
            this.nzC.a(new 1(this));
            long j = 0;
            while (j <= 30000 && this.nzD && !this.nzE) {
                try {
                    Thread.sleep(100);
                    j += 100;
                } catch (InterruptedException e) {
                    x.e("MicroMsg.GWalletQueryProvider", e.toString());
                }
            }
            MatrixCursor matrixCursor;
            Iterator it;
            String str3;
            if (!this.nzD) {
                x.d("MicroMsg.GWalletQueryProvider", "unable to setup");
                matrixCursor = new MatrixCursor(tv);
                it = this.nzG.iterator();
                while (it.hasNext()) {
                    str3 = (String) it.next();
                    matrixCursor.addRow(new Object[]{Integer.valueOf(0), str3, "", Integer.valueOf(10234), "", ""});
                }
                return matrixCursor;
            } else if (j > 30000) {
                x.d("MicroMsg.GWalletQueryProvider", "time's out");
                matrixCursor = new MatrixCursor(tv);
                it = this.nzG.iterator();
                while (it.hasNext()) {
                    str3 = (String) it.next();
                    matrixCursor.addRow(new Object[]{Integer.valueOf(0), str3, "", Integer.valueOf(10235), "", ""});
                }
                return matrixCursor;
            } else {
                x.d("MicroMsg.GWalletQueryProvider", "successfully queried!");
                MatrixCursor matrixCursor2 = new MatrixCursor(tv);
                if (this.nzH == 0) {
                    Iterator it2;
                    i = 0;
                    if (this.nzF != null) {
                        it2 = this.nzF.iterator();
                        i3 = 0;
                        while (it2.hasNext()) {
                            str3 = (String) it2.next();
                            if (bh.ov(str3)) {
                                i = i3;
                                i3 = i;
                            } else {
                                try {
                                    JSONObject jSONObject = new JSONObject(str3);
                                    str3 = jSONObject.getString("productId");
                                    String string = jSONObject.getString("price");
                                    String string2 = jSONObject.getString("price_currency_code");
                                    String string3 = jSONObject.getString("price_amount_micros");
                                    Integer valueOf = Integer.valueOf(10232);
                                    Object[] objArr = new Object[6];
                                    i2 = i3 + 1;
                                    try {
                                        objArr[0] = Integer.valueOf(i3);
                                        objArr[1] = str3;
                                        objArr[2] = string;
                                        objArr[3] = valueOf;
                                        objArr[4] = string2;
                                        objArr[5] = string3;
                                        matrixCursor2.addRow(objArr);
                                        this.nzG.remove(str3);
                                        i3 = i2;
                                    } catch (JSONException e2) {
                                        jSONException = e2;
                                        i = i2;
                                        x.d("MicroMsg.GWalletQueryProvider", jSONException.toString());
                                        i3 = i;
                                    }
                                } catch (JSONException e22) {
                                    JSONException jSONException2 = e22;
                                    i = i3;
                                    jSONException = jSONException2;
                                    x.d("MicroMsg.GWalletQueryProvider", jSONException.toString());
                                    i3 = i;
                                }
                            }
                        }
                        i = i3;
                    }
                    it2 = this.nzG.iterator();
                    i3 = i;
                    while (it2.hasNext()) {
                        str3 = (String) it2.next();
                        r8 = new Object[6];
                        i2 = i3 + 1;
                        r8[0] = Integer.valueOf(i3);
                        r8[1] = str3;
                        r8[2] = "";
                        r8[3] = Integer.valueOf(10233);
                        r8[4] = "";
                        r8[5] = "";
                        matrixCursor2.addRow(r8);
                        i3 = i2;
                    }
                } else {
                    Iterator it3 = this.nzG.iterator();
                    while (it3.hasNext()) {
                        str3 = (String) it3.next();
                        matrixCursor2.addRow(new Object[]{Integer.valueOf(0), str3, "", Integer.valueOf(10236), "", ""});
                    }
                }
            }
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
