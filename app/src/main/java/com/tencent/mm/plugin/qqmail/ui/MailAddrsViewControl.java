package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class MailAddrsViewControl extends RelativeLayout {
    private static final Pattern pta = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    private af handler = new af();
    private boolean imW = false;
    LinkedList<i> psU = new LinkedList();
    AutoCompleteTextView psV;
    private b psW;
    c psX;
    private View psY;
    a psZ = null;
    private GestureDetector psc;
    private SimpleOnGestureListener ptb = new 8(this);

    public final boolean bkV() {
        Editable text = this.psV.getText();
        if (text == null || text.toString().length() <= 0) {
            return true;
        }
        return false;
    }

    public MailAddrsViewControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.psc = new GestureDetector(context, this.ptb);
    }

    public final void bkW() {
        this.imW = true;
        if (this.psV == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (!(childAt instanceof AutoCompleteTextView)) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            if (childAt2 instanceof AutoCompleteTextView) {
                                this.psV = (AutoCompleteTextView) childAt2;
                            }
                        }
                    }
                    if (this.psV != null) {
                        break;
                    }
                    i++;
                } else {
                    this.psV = (AutoCompleteTextView) childAt;
                    break;
                }
            }
            if (this.psV != null) {
                this.psV.setDropDownBackgroundResource(R.g.bEU);
                setOnClickListener(new 1(this));
                this.psV.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ MailAddrsViewControl ptc;

                    {
                        this.ptc = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.ptc.e(this.ptc.psW.vd(i));
                        this.ptc.psV.setText("");
                    }
                });
                this.psV.setOnEditorActionListener(new 4(this));
                this.psV.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ MailAddrsViewControl ptc;

                    {
                        this.ptc = r1;
                    }

                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        String obj;
                        if (i == 67 && keyEvent.getAction() == 0) {
                            obj = this.ptc.psV.getEditableText().toString();
                            if (obj.length() == 0 && this.ptc.psY != null && this.ptc.psY.isSelected()) {
                                this.ptc.f((i) this.ptc.psY.getTag());
                                this.ptc.psY = null;
                                this.ptc.bla();
                            } else if (obj.length() == 0 && this.ptc.psU.size() > 0) {
                                int size = this.ptc.psU.size() - 1;
                                View childAt = this.ptc.getChildAt(size);
                                if (childAt.isSelected()) {
                                    this.ptc.f((i) this.ptc.psU.get(size));
                                    this.ptc.bla();
                                } else {
                                    childAt.setSelected(true);
                                }
                            }
                        } else if (i == 66 && keyEvent.getAction() == 0) {
                            obj = this.ptc.psV.getEditableText().toString();
                            if (obj != null && obj.length() > 0) {
                                this.ptc.av(obj, true);
                                this.ptc.bla();
                            }
                        }
                        return false;
                    }
                });
                this.psV.addTextChangedListener(new 6(this));
                this.psV.setOnFocusChangeListener(new 7(this));
            }
        }
    }

    public final void a(b bVar) {
        if (this.psV != null) {
            this.psW = bVar;
            this.psV.setAdapter(bVar);
        }
    }

    public final String[] a(boolean z, d dVar) {
        int i = 0;
        String userBindEmail;
        if (dVar == null || !dVar.isConnected()) {
            userBindEmail = q.getUserBindEmail();
        } else {
            try {
                userBindEmail = (String) new ReadMailProxy(dVar, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
            } catch (Exception e) {
                x.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        String[] strArr = new String[this.psU.size()];
        while (i < this.psU.size()) {
            i iVar = (i) this.psU.get(i);
            if (z && iVar.nQt.equalsIgnoreCase(r1)) {
                strArr[i] = "";
            } else {
                strArr[i] = iVar.name + " " + iVar.nQt;
            }
            i++;
        }
        return strArr;
    }

    public final boolean bkX() {
        String trim = this.psV.getEditableText().toString().trim();
        return !bh.ov(trim) && HT(trim);
    }

    public final String bkY() {
        if (bkX()) {
            av(this.psV.getEditableText().toString(), false);
        }
        String str = "";
        for (int i = 0; i < this.psU.size(); i++) {
            i iVar = (i) this.psU.get(i);
            if (i != 0) {
                str = str + ",";
            }
            str = str + iVar.nQt;
        }
        return str;
    }

    public final void e(i iVar) {
        if (iVar != null) {
            Object obj;
            Iterator it = this.psU.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).nQt.equalsIgnoreCase(iVar.nQt)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.i.dpS, null);
                Button button = (Button) viewGroup.findViewById(R.h.cEZ);
                viewGroup.removeView((View) button.getParent());
                button.setText(iVar.name);
                if (this.imW) {
                    button.setCompoundDrawables(null, null, null, null);
                }
                button.setTag(this.psU.size());
                View view = (View) button.getParent();
                button.setTag(iVar);
                view.setVisibility(4);
                view.setTag(iVar);
                addView(view, this.psU.size());
                this.psU.add(iVar);
                this.handler.postDelayed(new 2(this, button), 100);
            }
        }
    }

    public final void a(String[] strArr, boolean z) {
        if (z) {
            removeAllViews();
            this.psU.clear();
            bla();
            invalidate();
        }
        if (strArr != null && strArr.length != 0) {
            for (String HK : strArr) {
                i HK2 = j.HK(HK);
                if (HK2 != null) {
                    e(HK2);
                }
            }
        }
    }

    public final void bs(List<i> list) {
        if (list != null) {
            for (i e : list) {
                e(e);
            }
        }
    }

    public final void f(i iVar) {
        for (int i = 0; i < this.psU.size(); i++) {
            if (iVar.nQt.equalsIgnoreCase(((i) this.psU.get(i)).nQt)) {
                removeViewAt(i);
                this.psU.remove(i);
                bla();
                invalidate();
                return;
            }
        }
    }

    private static boolean HT(String str) {
        return pta.matcher(str).matches();
    }

    public final boolean bkZ() {
        Iterator it = this.psU.iterator();
        while (it.hasNext()) {
            if (!HT(((i) it.next()).nQt)) {
                return false;
            }
        }
        return true;
    }

    final void bla() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 || (childAt instanceof AutoCompleteTextView)) {
                int i4;
                int width = childAt.getWidth();
                int height = childAt.getHeight();
                if (width == 0) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
                    width = childAt.getMeasuredWidth();
                }
                if (this.psV == null || i != childCount - 1 || this.psV.isFocused()) {
                    i4 = width;
                } else {
                    i4 = 0;
                }
                if (i3 + i4 > measuredWidth) {
                    i2 += height;
                    i3 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.setMargins(i3, i2, layoutParams.rightMargin, layoutParams.bottomMargin);
                childAt.setLayoutParams(layoutParams);
                i3 += i4;
                childAt.setVisibility(0);
            }
            i++;
        }
    }

    private void av(String str, boolean z) {
        Object trim = str.trim();
        if (trim.length() != 0) {
            List HJ = w.bks().poY.HJ(trim);
            if (HJ.size() > 0) {
                e((i) HJ.get(0));
                this.psV.setText("");
            } else if (HT(trim)) {
                i iVar = new i();
                iVar.name = trim;
                iVar.nQt = trim;
                iVar.poB = 0;
                e(iVar);
                this.psV.setText("");
            } else if (z) {
                if (this.psZ != null) {
                    this.psZ.bkJ();
                } else {
                    Toast.makeText(getContext(), R.l.eAE, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
                }
                this.psV.setText(trim);
                this.psV.setSelection(trim.length());
            } else if (this.psZ != null) {
                this.psZ.b(this);
            }
        }
    }
}
