package xiangmu01.xiangmu01;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ImageView imageView;
    private RadioButton tuijian;
    private RadioButton fenlei;
    private RadioButton sousuo;
    private RadioButton gengduo;
    private RadioGroup rg;
    private ArrayList<Fragment> frags = new ArrayList<Fragment>();

    private FragmentManager manager;
    private Fragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        manager=getFragmentManager();

        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.fl,frags.get(0));
        ft.commit();
        lastFragment=frags.get(0);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton) rg.findViewById(checkedId);
                int tag = Integer.parseInt(rb.getTag().toString());
                FragmentTransaction ft = manager.beginTransaction();

                if(!frags.get(tag).isAdded()){
                    ft.add(R.id.fl,frags.get(tag));
                }else{
                    ft.show(frags.get(tag));
                }
                ft.hide(lastFragment);
                ft.commit();

                lastFragment=frags.get(tag);
            }
        });
    }

    private void initFragment() {
        frags.add(new recommendFragment());
        frags.add(new categoryFragment());
        frags.add(new searchFragment());
        frags.add(new moreFragment());
    }

    private void initView() {
        tuijian = (RadioButton) findViewById(R.id.tuijian);

        fenlei = (RadioButton) findViewById(R.id.fenlei);

        sousuo = (RadioButton) findViewById(R.id.sousuo);

        gengduo = (RadioButton) findViewById(R.id.gengduo);
        rg = (RadioGroup)findViewById(R.id.radiogroup);

    }
    public void click(View v){

    }
}
