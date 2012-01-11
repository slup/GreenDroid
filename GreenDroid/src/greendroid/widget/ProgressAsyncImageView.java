package greendroid.widget;

import greendroid.image.ImageRequest;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.cyrilmottier.android.greendroid.R;

public class ProgressAsyncImageView extends AsyncImageView {
	
    public ProgressAsyncImageView(Context context) {
        this(context, null);
    }

    public ProgressAsyncImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressAsyncImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
	public void setDefaultImageBitmap(Bitmap bitmap) {
		//super.setDefaultImageBitmap(bitmap);
	}

	@Override
	public void setDefaultImageDrawable(Drawable drawable) {
		//super.setDefaultImageDrawable(drawable);
	}

	@Override
	public void setDefaultImageResource(int resId) {
		//super.setDefaultImageResource(resId);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		
		if (!isLoaded()) {
            super.setDefaultImageResource(R.drawable.gd_progress_async_image_view);
            
	        RotateAnimation animation = new RotateAnimation(0f, 359f, 
	        		(getWidth() / 2.0f), (getHeight() / 2.0f));
	        animation.setInterpolator(new LinearInterpolator());
	        animation.setRepeatCount(Animation.INFINITE);
	        animation.setDuration(700);
	        setAnimation(animation);
		}
	}

	@Override
	public void onImageRequestEnded(ImageRequest request, Bitmap image) {
		setAnimation(null);
		
		super.onImageRequestEnded(request, image);
	}
}
