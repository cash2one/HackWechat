package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final String[] lZI = new String[]{"retCode"};
    private static final UriMatcher mal;
    private static final String[] mcl = new String[]{SlookAirButtonFrequentContactAdapter.ID, "count"};
    private Context context;
    private String[] lZV;
    private int mcm = -1;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mal = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        mal.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        mal.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    }

    public ExtControlProviderQLauncher(String[] strArr, int i, Context context) {
        this.lZV = strArr;
        this.mcm = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlProviderQLauncher", "query()");
        a(uri, this.context, this.mcm, this.lZV);
        if (uri == null) {
            pp(3);
            return null;
        } else if (bh.ov(this.maf) || bh.ov(aFM())) {
            pp(3);
            return null;
        } else if (!aqY()) {
            pp(1);
            return this.kuZ;
        } else if (cz(this.context)) {
            Cursor matrixCursor;
            switch (this.mcm) {
                case 18:
                    x.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        pp(4);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    matrixCursor = new MatrixCursor(lZI);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    pp(0);
                    return matrixCursor;
                case 19:
                    x.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        pp(4);
                        return null;
                    }
                    d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    matrixCursor = new MatrixCursor(lZI);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    pp(0);
                    return matrixCursor;
                case 20:
                    return t(strArr2);
                default:
                    pp(3);
                    return null;
            }
        } else {
            x.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            pp(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor t(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            pp(4);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            pp(3);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(mcl);
            int i = 0;
            while (i < strArr.length && i < 10) {
                try {
                    if (!bh.ov(strArr[i])) {
                        if (strArr[i].equals("0")) {
                            Object[] objArr = new Object[2];
                            objArr[0] = strArr[i];
                            b.aGb();
                            objArr[1] = Integer.valueOf(b.aGc());
                            matrixCursor.addRow(objArr);
                        } else {
                            String vD = com.tencent.mm.plugin.base.model.b.vD(strArr[i]);
                            if (bh.ov(vD)) {
                                continue;
                            } else {
                                ar.Hg();
                                if (c.Fd().WY(vD) != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(c.Fd().WY(vD).field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(0)});
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    x.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[]{e.getMessage()});
                    pp(4);
                    matrixCursor.close();
                    return null;
                }
            }
            pp(0);
            return matrixCursor;
        }
    }
}
