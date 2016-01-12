package co.jlabs.viewpagerwithsidepages;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.jlabs.viewpagerwithsidepages.PageTransformer.MyCubeOutTransformer;

public class MainActivity extends Activity {

    TextView tv_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int position=getIntent().getIntExtra("position",1);
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        tv_position = (TextView) findViewById(R.id.position);
        vpPager.setClipToPadding(false);
        vpPager.setPageMargin(-20);
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        vpPager.setAdapter(adapter);
        vpPager.setCurrentItem(position - 1);
        tv_position.setText("" + position + " of 50 offers");
        vpPager.setPageTransformer(true, new MyCubeOutTransformer());
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_position.setText("" + (position + 1) + " of 50 offers");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = LayoutInflater.from(mContext);
        }

        @Override
        public float getPageWidth(int position) {
            return 0.93f;
        }

        // Returns the number of pages to be displayed in the ViewPager.
        @Override
        public int getCount() {
            return 50;
        }

        // Returns true if a particular object (page) is from a particular page
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        // This method should create the page for the given position passed to it as an argument.
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // Inflate the layout for the page
            View itemView = mLayoutInflater.inflate(R.layout.adapter, container, false);
            String s="";
            if(position%10==0)
            {
                s= "20% off on Fortune Oil";
            }
            else if(position%10==1)
            {
                s= "40% off on M.D.H";
            }
            else if(position%10==2)
            {
                s= "10% off on Curd Farm";
            }
            else if(position%10==3)
            {
                s= "25% off on Colgate";
            }
            else if(position%10==4)
            {
                s= "29% off on Lifebuoy";
            }
            else if(position%10==5)
            {
                s= "20% off on MatchBox";
            }
            else if(position%10==6)
            {
                s= "99% off on Scrubber";
            }
            else if(position%10==7)
            {
                s= "20% off on Nescafe";
            }
            else if(position%10==8)
            {
                s= "20% off on Parachute Oil";
            }
            else
            {
                s= "20% off on Maggi";
            }

            ((TextView)itemView.findViewById(R.id.title)).setText(s);
            container.addView(itemView);
            return itemView;
        }

        // Removes the page from the container for the given position.
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }


}
