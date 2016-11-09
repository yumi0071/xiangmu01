package xiangmu01.xiangmu01;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import adapter.SearchListAdapter;
import adapter.SearchMorePagerAdapter;
import bean.HotSearchBean;
import bean.SearchMoreBean;

/**
 * Created by Administrator on 2016/11/8.
 */

public class SearchFragment extends Fragment  {
    private Button button;
    private LinearLayout hotsearch_layout;
    private ViewPager viewpager;
    private RadioGroup radiogroup;
    private ListView lv;
    private ScrollView scrollView;
    private Context context;
    private RequestQueue queue;
    private ImageLoader loader;

    //准备一个用于存储所有热门搜索数据的集合
    private ArrayList<HotSearchBean.DataBean> hotList = new ArrayList<>();

    //用于存储查看更多下方列表中的数据源
    private ArrayList<HotSearchBean.DataBean> searchList = new ArrayList<>();

    private SearchListAdapter adapter;

    //用于处理ViewPager的数据源
    private ArrayList<View> pagerDatas = new ArrayList<>();
    private ArrayList<SearchMoreBean.DataBean.TopicBean> moreList = new ArrayList<>();
    private SearchMorePagerAdapter searchMorePagerAdapter;

    private Handler handler = new Handler();
    private Runnable r;
    private boolean flag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.search,container,false);


    }
    private void initView(View inflate) {
        button = (Button)inflate.findViewById(R.id.button);
        hotsearch_layout = (LinearLayout) inflate.findViewById(R.id.hotsearch_layout);
        viewpager = (ViewPager) inflate.findViewById(R.id.viewpager);
        radiogroup = (RadioGroup) inflate.findViewById(R.id.radiogroup);
        lv = (ListView) inflate.findViewById(R.id.lv);
//        scrollView = (ScrollView) inflate.findViewById(R.id.scr);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context=getActivity();

        initView(view);

        queue= Volley.newRequestQueue(context);

//        initImageLoader();
//
//        //加载热门搜索部分的数据
//        initHotSearchData();
//        //获取查看更多下方列表中的数据
//        initSearchListDara();
//        //初始化设置列表适配器
//        initListViewAdapter();
//

        r=new Runnable() {
            @Override
            public void run() {
                viewpager.setCurrentItem(viewpager.getCurrentItem()+1);
                handler.postDelayed(r,2000);
            }
        };
//        initPagerData();
//        initViewPager();

//        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                radiogroup.check(position%pagerDatas.size());
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        }

    }
}
