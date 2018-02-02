package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.modelsfs.FileOp;

class c$6 implements OnClickListener {
    final /* synthetic */ c lpk;
    final /* synthetic */ String lpu;
    final /* synthetic */ Context val$context;

    c$6(c cVar, String str, Context context) {
        this.lpk = cVar;
        this.lpu = str;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FileOp.G(this.lpu, false);
        Toast.makeText(this.val$context, "Corruption test database cleared.", 0).show();
    }
}
