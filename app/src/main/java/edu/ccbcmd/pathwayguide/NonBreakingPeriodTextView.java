package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



        import android.text.TextPaint;
        import android.text.Editable;
        import android.util.Log;

        import android.graphics.Paint;

        import android.util.AttributeSet;

        import android.content.Context;

        import android.widget.TextView;

        import fd.IncrementalChange;

public class NonBreakingPeriodTextView extends TextView
{
   // public static volatile /* synthetic */ IncrementalChange $change;
    private static final String TAG = "NonBreakingPeriodTextView";

    public NonBreakingPeriodTextView(Context context) {

        super(context);

        /*
        final IncrementalChange $change = NonBreakingPeriodTextView.$change;
        if ($change != null) {
            final Object[] array = new Object[2];
            (array[0] = array)[1] = context;
            final Object[] array2 = (Object[])$change.access$dispatch("init$args.([Ljava/lang/Object;Landroid/content/Context;)Ljava/lang/Object;", array);
            context = (Context)array[1];
            this(array2, null);
        }
        else {

        }
        if ($change != null) {
            $change.access$dispatch("init$body.(Lcom/example/nicholas/buttontest/NonBreakingPeriodTextView;Landroid/content/Context;)V", new Object[] { this, context });
        }
        */
    }

    public NonBreakingPeriodTextView(Context context, AttributeSet set) {

            super(context, set);


    }
/*
    NonBreakingPeriodTextView(final Object[] array, final InstantReloadException ex) {
        final String s = (String)array[0];
        switch (s.hashCode()) {
            default: {
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", s, s.hashCode(), "com/example/nicholas/buttontest/NonBreakingPeriodTextView"));
            }
            case -1595407246: {
                this((Context)array[1], (AttributeSet)array[2]);
            }
            case -1377109095: {
                super((Context)array[1], (AttributeSet)array[2], ((Number)array[3]).intValue());
            }
            case 255810076: {
                this((Context)array[1]);
            }
            case 259320458: {
                super((Context)array[1], (AttributeSet)array[2], ((Number)array[3]).intValue(), ((Number)array[4]).intValue());
            }
            case 1589761252: {
                super((Context)array[1]);
            }
            case 1895238826: {
                super((Context)array[1], (AttributeSet)array[2]);
            }
        }
    }
*/
    public void onSizeChanged(int i, int n, int n2, int n3) {

            final Editable editableText = this.getEditableText();
            if (editableText == null) {
            //    Log.d("NonBreakingPeriodTextView", "non-editable text");
                return;
            }
            final int n4 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            if (n4 == 0) {
          //      Log.d("NonBreakingPeriodTextView", "zero-length text");
                return;
            }
            final TextPaint paint = this.getPaint();
            final float[] array = new float[editableText.length()];
            (paint).getTextWidths(editableText.toString(), array);
            float n5 = 0.0f;
            n2 = -1;
            i = 0;
            int n6 = 0;
            int n7 = 0;
            while (i < editableText.length()) {
                n5 += array[i];
                final char char1 = editableText.charAt(i);
                int n8;
                int n9;
                if (char1 == '\n') {
                    n = 1;
                    n8 = i;
                    n3 = n2;
                    n9 = n7;
                }
                else if (Character.isWhitespace(char1)) {
                    n3 = i;
                    n9 = n7;
                    n = n6;
                    n8 = i;
                }
                else {
                    n9 = n7;
                    n3 = n2;
                    n = n6;
                    n8 = i;
                    if (n5 > n4) {
                        n9 = n7;
                        n3 = n2;
                        n = n6;
                        n8 = i;
                        if (n2 >= 0) {
                            editableText.replace(n2, n2 + 1, "\n");
                            n9 = n7 + 1;
                            n3 = -1;
                            n = 1;
                            n8 = n2;
                        }
                    }
                }
                if ((n6 = n) != 0) {
                    n5 = 0.0f;
                    n6 = 0;
                }
                i = n8 + 1;
                n7 = n9;
                n2 = n3;
            }
            if (n7 != 0) {
                this.setText(editableText);
            }

    }
}
