package com.example.administrator.schoolbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.schoolbus.ChannelconfigActivity;
import com.example.administrator.schoolbus.CodeActivity;
import com.example.administrator.schoolbus.R;
import com.example.administrator.schoolbus.VideoplanActivity;import com.example.administrator.schoolbus.fragment.ChannelconfigFragment;import com.example.administrator.schoolbus.fragment.CodeFragment;import com.example.administrator.schoolbus.fragment.VideoplanFragment;


public class Menu03Fragment extends Fragment implements OnItemClickListener {
    /**
     * 菜单界面中只包含了一个ListView。
     */
     private ListView menuList;
    /**
     * ListView的适配器。
     */
      private ArrayAdapter<String> adapter;
    /**
     * 用于填充ListView的数据，这里就简单只用了两条数据。
     */
    private String[] menuItems = { "编码设置", "通道管理","录像计划" };
    /**
     * 是否是双页模式。如果一个Activity中包含了两个Fragment，就是双页模式。
     */
    private boolean isTwoPane;

    /**
     * 当Activity和Fragment建立关联时，初始化适配器中的数据。
     */
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, menuItems);
    }

    /**
     * 加载menu_fragment布局文件，为ListView绑定了适配器，并设置了监听事件。
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.menu03_fragment, container, false);
            menuList = (ListView) view.findViewById(R.id.menu_list);
            menuList.setAdapter(adapter);
            menuList.setOnItemClickListener(this);
            return view;
    }
    /**
     * 当Activity创建完毕后，尝试获取一下布局文件中是否有details_layout这个元素，如果有说明当前
     * 是双页模式，如果没有说明当前是单页模式。
     */
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        if (getActivity().findViewById(R.id.details_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }
    /**
     * 处理ListView的点击事件，会根据当前是否是双页模式进行判断。如果是双页模式，则会动态添加Fragment。
     * 如果不是双页模式，则会打开新的Activity。
     */
    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {
        if (isTwoPane) {
            Fragment fragment = null;
            if (index == 0) {
                fragment=new CodeFragment();
            } else if (index == 1) {
                fragment = new ChannelconfigFragment();
            }else if(index==2){
                fragment=new VideoplanFragment();
            }
            getFragmentManager().beginTransaction().replace(R.id.details_layout, fragment).commit();
        } else {
            Intent intent = null;
            if (index == 0) {
                intent = new Intent(getActivity(), CodeActivity.class);
            } else if (index == 1) {
                intent = new Intent(getActivity(), ChannelconfigActivity.class);
            }else if(index==2) {
                intent = new Intent(getActivity(), VideoplanActivity.class);
            }
            startActivity(intent);
        }
    }

}
