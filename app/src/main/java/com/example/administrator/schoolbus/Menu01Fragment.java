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


public class Menu01Fragment extends Fragment implements OnItemClickListener {
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
    private String[] menuItems = { "基本设置", "车辆信息","系统信息","日志管理","配置管理","传感器（指纹采集）","传感器（RFID）" ,"传感器（轮胎设置）","传感器（轮胎状态）","传感器（GPS）","传感器（G-Sensor）"};
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
            View view = inflater.inflate(R.layout.menu01_fragment, container, false);
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
                fragment=new BasicFragment();
            } else if (index == 1) {
                fragment = new VehicleFragement();
            }else if(index==2){
                fragment=new SysinfoFragment();
            }else if(index==3){
                fragment=new LogFragment();
            }else if(index==4){
                fragment=new SysconfigFragment();
            }else if(index==5){
                fragment=new FigerFragment();
            }else  if(index==6){
                fragment=new RfidFragment();
            }else if(index==7){
                fragment=new TyresettingFragment();
            }else if(index==8){
                fragment=new TyrestateFragment();
            }else if(index==9){
                fragment=new GpsFragment();
            }else if(index==10){
                fragment=new GsensorFragment();
            }
            getFragmentManager().beginTransaction().replace(R.id.details_layout, fragment).commit();
        } else {
            Intent intent = null;
            if (index == 0) {
                intent = new Intent(getActivity(), BasicActivity.class);
            } else if (index == 1) {
                intent = new Intent(getActivity(), VehicleActivity.class);
            }else if(index==2) {
                intent = new Intent(getActivity(), SysinfoActivity.class);
            }else if(index==3){
                intent=new Intent(getActivity(),LogActivity.class);
            }else if(index==4) {
                intent = new Intent(getActivity(), SysconfigActivity.class);
            }else if(index==5){
//                intent=new Intent(getActivity(),SystemActivity.class);
            }
            startActivity(intent);
        }
    }

}
