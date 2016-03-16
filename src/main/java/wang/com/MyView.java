package wang.com;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期: 16/3/15 下午10:35
 * 作者:wanghao
 * 描述:
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(200, widthMeasureSpec), measureHight(200, heightMeasureSpec));
    }

    private int measureWidth(int size, int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
            System.out.println("EXACTLY:" + result);
        } else {
            result = size;//最小值是200px ，自己设定
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);

            }
        }

        return result;
    }

    private int measureHight(int size, int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = size;//最小值是200px ，自己设定
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
