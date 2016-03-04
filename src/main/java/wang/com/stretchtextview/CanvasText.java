package wang.com.stretchtextview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;


/**
 * 创建日期: 16/3/3 下午10:24
 * 作者:wanghao
 * 描述:
 */
public class CanvasText extends stretchtextview {

    private static final String TAG = "CanvasText";
    Context context;
    String text = "1Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!1231111";


    public CanvasText(Context context) {
        this(context, null);
    }

    public CanvasText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        TextPaint tp = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        tp.setColor(getResources().getColor(R.color.colorAccent));
        tp.setTextSize(50);
        //以后写text都这么写
        setStretchTextView(text, dip2px(180f), dip2px(80f), tp, Layout.Alignment.ALIGN_CENTER, canvas);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public int px2dip(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
