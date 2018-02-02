package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

public final class f implements a {
    static {
        b.a(new f(), new String[]{"//disablesfs", "//exportsfs", "//sfsstat"});
    }

    public static void init() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr) {
        int i;
        String str = strArr[0];
        switch (str.hashCode()) {
            case -1024646924:
                if (str.equals("//sfsstat")) {
                    i = 2;
                    break;
                }
            case 1218851436:
                if (str.equals("//exportsfs")) {
                    boolean z = true;
                    break;
                }
            case 1595670136:
                if (str.equals("//disablesfs")) {
                    i = 0;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs");
                try {
                    StringBuilder stringBuilder;
                    if (strArr.length <= 0 || strArr[1].equals("0")) {
                        file.delete();
                        stringBuilder = new StringBuilder("Use SFS: ");
                        if (file.exists()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Toast.makeText(context, stringBuilder.append(Boolean.toString(z)).toString(), 0).show();
                        return true;
                    }
                    file.createNewFile();
                    stringBuilder = new StringBuilder("Use SFS: ");
                    if (file.exists()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Toast.makeText(context, stringBuilder.append(Boolean.toString(z)).toString(), 0).show();
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SFSCommand", e, "Failed to operate flag file.", new Object[0]);
                }
                break;
            case 1:
                if (strArr.length <= 1) {
                    return false;
                }
                CharSequence charSequence = strArr[1];
                FileOp.md(charSequence);
                Toast.makeText(context, charSequence, 0).show();
                return true;
            case 2:
                long currentTimeMillis = System.currentTimeMillis();
                Map Rw = FileOp.Rw();
                CharSequence stringBuilder2 = new StringBuilder(8192);
                for (Entry entry : Rw.entrySet()) {
                    stringBuilder2.append("===== ").append((String) entry.getKey()).append(" =====\n").append(((Statistics) entry.getValue()).toString()).append("\n\n");
                }
                stringBuilder2.append("elapsed: ").append(System.currentTimeMillis() - currentTimeMillis).append(" ms");
                View textView = new TextView(context);
                textView.setText(stringBuilder2);
                textView.setGravity(8388627);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(-16744704);
                textView.setTypeface(Typeface.MONOSPACE);
                textView.setMovementMethod(new ScrollingMovementMethod());
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvv);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                h.a(context, null, textView, null);
                return true;
            default:
                return false;
        }
    }
}
