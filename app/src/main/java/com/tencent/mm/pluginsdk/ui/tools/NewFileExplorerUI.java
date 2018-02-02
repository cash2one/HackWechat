package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.ui.applet.e$a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.p.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@a(19)
public class NewFileExplorerUI extends MMActivity {
    private ListView kGl;
    private int mode = 0;
    private TextView prT;
    private String toUserName;
    private a vxL;
    private TextView vxM;
    private FileSelectorFolderView vxN;
    private e$a vxO;
    private FileSelectorFolderView.a vxP = new FileSelectorFolderView.a(this) {
        final /* synthetic */ NewFileExplorerUI vxQ;

        {
            this.vxQ = r1;
        }

        public final void CA(int i) {
            x.i("MicroMsg.FileExplorerUI", "position: %d", new Object[]{Integer.valueOf(i)});
            if (i == 0) {
                this.vxQ.setMMTitle(R.l.ehh);
                this.vxQ.setMMSubTitle(null);
                this.vxQ.vxM = (TextView) this.vxQ.findViewById(R.h.chE);
                this.vxQ.vxM.setText(R.l.ehh);
                this.vxQ.vxL.c(new File(e.gHs), true);
                this.vxQ.vxL.a(new File(e.gHs), null);
            } else {
                this.vxQ.vxL.c(new File(e.bnD), false);
                this.vxQ.vxL.a(new File(e.bnD), null);
                this.vxQ.setMMTitle(R.l.ehi);
                this.vxQ.vxM.setText(R.l.ehi);
            }
            this.vxQ.vxL.notifyDataSetChanged();
            this.vxQ.ccA();
        }
    };

    static /* synthetic */ void e(NewFileExplorerUI newFileExplorerUI) {
        newFileExplorerUI.vxO = new e$a(newFileExplorerUI.mController.xIM);
        newFileExplorerUI.vxO.bS(newFileExplorerUI.toUserName);
        newFileExplorerUI.vxO.f(Boolean.valueOf(true));
        newFileExplorerUI.vxO.Sp(newFileExplorerUI.getString(R.l.dFj) + newFileExplorerUI.getString(R.l.ehf, new Object[]{Integer.valueOf(a.a(newFileExplorerUI.vxL).size()), bh.bx((long) newFileExplorerUI.vxL.bkT())}));
        newFileExplorerUI.vxO.a(new 5(newFileExplorerUI));
        newFileExplorerUI.vxO.BW(R.l.dGA).a(new 6(newFileExplorerUI)).pyk.show();
    }

    protected final int getLayoutId() {
        return R.i.doX;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.toUserName = getIntent().getStringExtra("TO_USER");
        this.kGl = (ListView) findViewById(R.h.chF);
        this.vxL = new a(this);
        this.prT = (TextView) findViewById(R.h.cLi);
        this.mode = getIntent().getIntExtra("explorer_mode", 0);
        if (this.mode == 1) {
            setMMTitle(R.l.ehk);
            setMMSubTitle(null);
            this.vxL.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
        } else {
            setMMTitle(R.l.ehh);
            setMMSubTitle(null);
            this.vxM = (TextView) findViewById(R.h.chE);
            this.vxM.setText(R.l.ehh);
            this.vxL.c(new File(e.gHs), true);
            this.vxL.a(new File(e.gHs), null);
            if (this.vxL.getCount() == 0) {
                this.vxL.c(new File(e.bnD), false);
                this.vxL.a(new File(e.bnD), null);
                setMMTitle(R.l.ehi);
                this.vxM.setText(R.l.ehi);
            }
            findViewById(R.h.chC).setVisibility(0);
            findViewById(R.h.chC).setOnClickListener(new 1(this));
            this.vxN = (FileSelectorFolderView) findViewById(R.h.chD);
            this.vxN.vwR = this.vxP;
        }
        this.kGl.setAdapter(this.vxL);
        this.kGl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NewFileExplorerUI vxQ;

            {
                this.vxQ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                File file = this.vxQ.vxL.vwN[i];
                if (file.isDirectory()) {
                    this.vxQ.vxL.a(file, null);
                    this.vxQ.vxL.notifyDataSetChanged();
                    this.vxQ.ccA();
                    return;
                }
                a.b(this.vxQ, file.getPath(), com.tencent.mm.a.e.bQ(file.getPath()), 1);
            }
        });
        this.kGl.setEmptyView(findViewById(R.h.chB));
        setBackBtn(new 3(this), this.mode == 0 ? R.k.byB : 0);
        if (this.mode == 0) {
            a(1, getString(R.l.dGA), new 4(this), b.xJz);
        }
        bqU();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        lq(false);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            if (a.a(this.vxL).size() != stringArrayListExtra.size()) {
                this.vxO.pyk.dismiss();
                a.a(this.vxL).clear();
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    a.a(this.vxL).add(new File((String) it.next()));
                }
                this.vxL.notifyDataSetChanged();
                ccA();
                bqU();
            }
        } else if (i == 2) {
            a.a(this, i, i2, intent, true, R.l.dZc, R.l.dZd, 1);
        }
    }

    private void lq(boolean z) {
        if (this.mode != 0) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", this.vxL.ccB());
            intent.putStringArrayListExtra("key_select_video_list", this.vxL.ccD());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", this.vxL.ccC());
            intent.putExtra("GalleryUI_ToUser", this.toUserName);
            setResult(-1, intent);
            finish();
        } else if (z || this.vxL.ccE() == null) {
            setResult(0);
            finish();
        } else {
            this.vxL.a(this.vxL.ccE(), null);
            this.vxL.notifyDataSetChanged();
            ccA();
        }
    }

    private void bqU() {
        int size = a.a(this.vxL).size();
        if (size > 0) {
            if (this.mode == 0) {
                updateOptionMenuText(1, getString(R.l.dGA) + "(" + size + "/9)");
                enableOptionMenu(1, true);
            }
            this.prT.setText(getString(R.l.ehj, new Object[]{bh.bx((long) this.vxL.bkT())}));
            this.prT.setVisibility(0);
            return;
        }
        if (this.mode == 0) {
            updateOptionMenuText(1, getString(R.l.dGA));
            enableOptionMenu(1, false);
        }
        this.prT.setVisibility(8);
    }

    private void ccA() {
        if (a.b(this.vxL) != null && a.c(this.vxL) != null) {
            String replace = a.c(this.vxL).getPath().replace(a.b(this.vxL).getPath(), "");
            if (replace.startsWith("/")) {
                replace = replace.substring(1);
            }
            if (replace.length() == 0) {
                replace = null;
            }
            setMMSubTitle(replace);
        }
    }
}
