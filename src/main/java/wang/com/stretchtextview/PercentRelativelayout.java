package wang.com.stretchtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by wanghao on 16/6/8.
 */
public class PercentRelativelayout extends RelativeLayout {
    private static final String TAG = "PercentRelativelayout";

    public PercentRelativelayout(Context context) {
        super(context);
    }

    public PercentRelativelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentRelativelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    //绘制子控件的布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    //测量容器宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

//        测量出子空间的宽高进行比较

        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = this.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
//            解析自定义的,进行替换
            float widthPercent = 0;
            float heightPercent = 0;
            if (layoutParams instanceof PercentRelativelayout.LayoutParams) {
                heightPercent = ((LayoutParams) layoutParams).getHeightPercent();
                widthPercent = ((LayoutParams) layoutParams).getWidthPercent();
            }
            if (widthPercent != 0) {
                layoutParams.width = (int) (width * widthPercent);
            }

            if (heightPercent != 0) {
                layoutParams.height = (int) (height * heightPercent);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams {

        private float widthPercent;
        private float heightPercent;

        public float getWidthPercent() {
            return widthPercent;
        }

        public void setWidthPercent(float widthPercent) {
            this.widthPercent = widthPercent;
        }

        public float getHeightPercent() {
            return heightPercent;
        }

        public void setHeightPercent(float heightPercent) {
            this.heightPercent = heightPercent;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray array = c.obtainStyledAttributes(attrs,
                    R.styleable.PercentRelativelayout);
            widthPercent = array.getFloat(R.styleable.PercentRelativelayout_layout_widthPercent, 0);
            heightPercent = array.getFloat(R.styleable.PercentRelativelayout_layout_heightPercent, 0);

        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }
    }
}
