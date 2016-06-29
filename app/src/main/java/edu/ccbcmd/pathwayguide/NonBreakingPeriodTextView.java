package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import fd.IncrementalChange;
import fd.InstantReloadException;

public class NonBreakingPeriodTextView
        extends TextView
{
    private static final String TAG = "NonBreakingPeriodTextView";

    public NonBreakingPeriodTextView(){super(null);}

    public NonBreakingPeriodTextView(Context paramContext) {this();}

    public NonBreakingPeriodTextView(Context paramContext, AttributeSet paramAttributeSet) {this();}

    NonBreakingPeriodTextView(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        super((Context)paramArrayOfObject[1], (AttributeSet)paramArrayOfObject[2]);
    }

    public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null) {
            ((IncrementalChange)localObject).access$dispatch("onSizeChanged.(IIII)V", new Object[] { this, new Integer(paramInt1), new Integer(paramInt2), new Integer(paramInt3), new Integer(paramInt4) });
        }
        int k;
        do
        {
            return;
            localObject = getEditableText();
            if (localObject == null)
            {
                Log.d("NonBreakin", "non-editable text");
                return;
            }
            int n = getWidth() - getPaddingLeft() - getPaddingRight();
            if (n == 0)
            {
                Log.d("NonBreakin", "zero-length text");
                return;
            }
            TextPaint localTextPaint = getPaint();
            float[] arrayOfFloat = new float[((Editable)localObject).length()];
            localTextPaint.getTextWidths(localObject.toString(), arrayOfFloat);
            float f = 0.0F;
            paramInt3 = -1;
            paramInt1 = 0;
            int i = 0;
            k = 0;
            if (paramInt1 < ((Editable)localObject).length())
            {
                f += arrayOfFloat[paramInt1];
                char c = ((Editable)localObject).charAt(paramInt1);
                int m;
                int j;
                if (c == '\n')
                {
                    paramInt2 = 1;
                    m = paramInt1;
                    paramInt4 = paramInt3;
                    j = k;
                }
                for (;;)
                {
                    i = paramInt2;
                    if (paramInt2 != 0)
                    {
                        f = 0.0F;
                        i = 0;
                    }
                    paramInt1 = m + 1;
                    k = j;
                    paramInt3 = paramInt4;
                    break;
                    if (Character.isWhitespace(c))
                    {
                        paramInt4 = paramInt1;
                        j = k;
                        paramInt2 = i;
                        m = paramInt1;
                    }
                    else
                    {
                        j = k;
                        paramInt4 = paramInt3;
                        paramInt2 = i;
                        m = paramInt1;
                        if (f > n)
                        {
                            j = k;
                            paramInt4 = paramInt3;
                            paramInt2 = i;
                            m = paramInt1;
                            if (paramInt3 >= 0)
                            {
                                ((Editable)localObject).replace(paramInt3, paramInt3 + 1, "\n");
                                j = k + 1;
                                paramInt4 = -1;
                                paramInt2 = 1;
                                m = paramInt3;
                            }
                        }
                    }
                }
            }
        } while (k == 0);
        setText((CharSequence)localObject);
    }
}