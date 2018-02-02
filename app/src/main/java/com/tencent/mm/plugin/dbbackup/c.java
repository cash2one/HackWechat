package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.dbbackup.d.5;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.br;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.R$styleable;

public final class c implements a {
    private d lph;

    c(d dVar) {
        this.lph = dVar;
    }

    private boolean cr(Context context) {
        if (g.Dj().CQ() == null) {
            h.h(context, R.l.eCN, R.l.dGO);
        } else {
            context.getString(R.l.dGO);
            ProgressDialog a = h.a(context, context.getString(R.l.eCM), false, null);
            br bXT = ((b) g.h(b.class)).bXT();
            bXT.HX();
            d dVar = this.lph;
            b 1 = new 1(this, bXT, a, context);
            File file = new File(ac.getContext().getFilesDir(), "DBRecoverStarted");
            WakerLock wakerLock = new WakerLock(ac.getContext());
            b 5 = new 5(dVar, file, 1, wakerLock);
            x.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
            wakerLock.lock();
            com.tencent.mm.plugin.report.service.g.pQN.a(181, 28, 1, true);
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
            5.ou(-1);
        }
        return true;
    }

    private boolean b(Context context, String[] strArr) {
        int i = -1;
        int i2 = 0;
        String str = g.Dj().cachePath;
        final String str2 = str + "ctest/";
        final String str3 = str + "EnMicroMsg.db";
        final String str4 = str2 + "EnMicroMsg.db";
        final String[] strArr2 = new String[]{"", "-journal", "-wal", ".sm", ".bak"};
        if (strArr.length > 1) {
            String str5 = strArr[1];
            switch (str5.hashCode()) {
                case -778987502:
                    if (str5.equals("clear-test")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1220142353:
                    if (str5.equals("make-test")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1933703003:
                    if (str5.equals("recover-test")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (FileOp.bO(str2)) {
                        Toast.makeText(context, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
                        return true;
                    }
                    ar.Hg();
                    com.tencent.mm.z.c.EV().ckV().close();
                    FileOp.mh(str2);
                    while (i2 < 5) {
                        String str6 = strArr2[i2];
                        FileOp.at(str3 + str6, str4 + str6);
                        i2++;
                    }
                    d.ct(context);
                    return true;
                case 1:
                    if (FileOp.bO(str2)) {
                        final Context context2 = context;
                        h.a(context, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new OnClickListener(this) {
                            final /* synthetic */ c lpk;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ar.Hg();
                                com.tencent.mm.z.c.EV().ckV().close();
                                for (String str : strArr2) {
                                    FileOp.deleteFile(str3 + str);
                                    FileOp.at(str4 + str, str3 + str);
                                }
                                FileOp.G(str2, false);
                                d.ct(context2);
                            }
                        }, null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                case 2:
                    if (FileOp.bO(str2)) {
                        h.a(context, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new 6(this, str2, context), null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                default:
                    return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.TITLE_LENGTH_LIMIT);
        str3 = g.Dj().CQ();
        stringBuilder.append("Corrupted DB: ");
        if (str3 == null) {
            stringBuilder.append("not exist");
        } else {
            stringBuilder.append(str3.contains("/ctest/") ? "test" : "exists");
            stringBuilder.append("\nCorrupted DB size: ").append(FileOp.me(str3));
            stringBuilder.append("\nSaved master exists: ").append(FileOp.bO(str3 + ".sm"));
            stringBuilder.append("\nContent backup exists: ").append(FileOp.bO(str3 + ".bak"));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(8388627);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16744704);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setMovementMethod(new ScrollingMovementMethod());
        i = context.getResources().getDimensionPixelSize(R.f.bvv);
        textView.setPadding(i, i, i, i);
        h.a(context, null, textView, null);
        return true;
    }

    private static boolean cs(Context context) {
        int lastErrorLine = SQLiteDebug.getLastErrorLine();
        ArrayList lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
        if (!(lastIOTraceStats == null || lastIOTraceStats.isEmpty())) {
            Object encodeToString;
            IOTraceStats iOTraceStats = (IOTraceStats) lastIOTraceStats.get(0);
            String str = "";
            try {
                ar.Hg();
                str = com.tencent.mm.a.g.s((q.yE() + com.tencent.mm.z.c.Cg()).getBytes()).substring(0, 7);
            } catch (Exception e) {
            }
            CharSequence format = String.format("DB corrupted (line: %d, hash: %s) => %s", new Object[]{Integer.valueOf(lastErrorLine), str, iOTraceStats.toString()});
            Object obj = "";
            if (iOTraceStats.lastReadPage != null) {
                obj = Base64.encodeToString(iOTraceStats.lastReadPage, 0);
            }
            String str2 = "";
            if (iOTraceStats.lastJournalReadPage != null) {
                encodeToString = Base64.encodeToString(iOTraceStats.lastJournalReadPage, 0);
            } else {
                String str3 = str2;
            }
            Map hashMap = new HashMap();
            hashMap.put("lastReadPage", obj);
            hashMap.put("lastJournalReadPage", encodeToString);
            com.tencent.mm.plugin.report.service.g.pQN.c("DBCorrupt", format, hashMap);
            View textView = new TextView(context);
            textView.setText(format);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16744704);
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvv);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            h.a(context, null, textView, null);
        }
        return true;
    }

    private static boolean c(Context context, String[] strArr) {
        CharSequence charSequence;
        t CU = g.Dj().CU();
        if (strArr.length > 1) {
            try {
                int intValue = Integer.decode(strArr[1]).intValue();
                if (intValue > 2 || intValue < 0) {
                    throw new NumberFormatException();
                }
                CU.set(89, Integer.valueOf(intValue));
                CU.lH(true);
                charSequence = "Recovery status set to " + intValue;
            } catch (NumberFormatException e) {
                charSequence = "Recovery status must be 0, 1 or 2";
            }
        } else {
            charSequence = "Recovery status is " + CU.getInt(89, 0);
        }
        Toast.makeText(context, charSequence, 0).show();
        return true;
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        boolean z = true;
        switch (str.hashCode()) {
            case -1955673212:
                if (str.equals("//recover")) {
                    z = true;
                    break;
                }
                break;
            case -1870250080:
                if (str.equals("//backupdb")) {
                    z = true;
                    break;
                }
                break;
            case -1832373669:
                if (str.equals("//recover-status")) {
                    z = true;
                    break;
                }
                break;
            case -1648083177:
                if (str.equals("//post-recover")) {
                    z = true;
                    break;
                }
                break;
            case -896707907:
                if (str.equals("//iotracedb")) {
                    z = true;
                    break;
                }
                break;
            case -398050965:
                if (str.equals("//corruptdb")) {
                    z = true;
                    break;
                }
                break;
            case -137452885:
                if (str.equals("//repairdb")) {
                    z = true;
                    break;
                }
                break;
            case 1483443294:
                if (str.equals("//recover-old")) {
                    z = false;
                    break;
                }
                break;
            case 1793722114:
                if (str.equals("//recoverdb")) {
                    z = true;
                    break;
                }
                break;
        }
        final long nanoTime;
        String str2;
        switch (z) {
            case false:
                return cr(context);
            case true:
                Intent intent = new Intent(context, DBRecoveryUI.class);
                intent.putExtra("scene", 2);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
                return true;
            case true:
                ar.Hg();
                d.azF();
                Toast.makeText(context, "Post recovery cleanup done.", 0).show();
                return true;
            case true:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    nanoTime = System.nanoTime();
                    final ProgressDialog a = h.a(context, "Backing database up. Please wait...", false, null);
                    final Context context2 = context;
                    if (this.lph.a(z2, new b(this) {
                        final /* synthetic */ c lpk;

                        public final void ou(int i) {
                            ag.y(new 1(this, i));
                        }
                    })) {
                        return true;
                    }
                    if (a != null) {
                        a.dismiss();
                    }
                    Toast.makeText(context, "Database is busy.", 0).show();
                    return true;
                }
                ar.Hg();
                t CU = com.tencent.mm.z.c.CU();
                if (strArr.length > 2) {
                    str = strArr[2];
                    z = true;
                    switch (str.hashCode()) {
                        case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (str.equals("0")) {
                                z = true;
                                break;
                            }
                            break;
                        case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3521:
                            if (str.equals("no")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3551:
                            if (str.equals("on")) {
                                z = true;
                                break;
                            }
                            break;
                        case 109935:
                            if (str.equals("off")) {
                                z = true;
                                break;
                            }
                            break;
                        case 119527:
                            if (str.equals("yes")) {
                                z = false;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                        case true:
                        case true:
                            CU.setInt(237571, 0);
                            CU.lH(true);
                            break;
                        case true:
                        case true:
                        case true:
                            CU.setInt(237571, 1);
                            CU.lH(true);
                            break;
                    }
                }
                Toast.makeText(context, "Database backup with cipher: " + (CU.getInt(237571, 0) == 0), 0).show();
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.dGO);
                this.lph.a(str2, new 3(this, h.a(context, context.getString(R.l.eCM), false, null), nanoTime, context));
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.dGO);
                ProgressDialog a2 = h.a(context, context.getString(R.l.eCM), false, null);
                int b = this.lph.b(str2, new 4(this, a2, nanoTime, context));
                if (b == 0) {
                    return true;
                }
                if (a2 != null) {
                    a2.dismiss();
                }
                switch (b) {
                    case -3:
                        b = R.l.eCN;
                        break;
                    case -2:
                        b = R.l.eCO;
                        break;
                    default:
                        b = R.l.eCL;
                        break;
                }
                Toast.makeText(context, b, 1).show();
                return true;
            case true:
                return b(context, strArr);
            case true:
                return cs(context);
            case true:
                return c(context, strArr);
            default:
                return false;
        }
    }
}
