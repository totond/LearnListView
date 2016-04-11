package scut.learnlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private ListView listView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        listView = (ListView) findViewById(R.id.listView1);
//        final List<String> adapterData = new ArrayList<String>();
//        for (int i = 0; i < 20; i++) {
//            adapterData.add("ListItem" + i);
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, adapterData);
//        listView.setAdapter(adapter);
//    }
//}


    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView1);
        /*定义一个以HashMap为内容的动态数组*/
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.ic_launcher);//加入图片
            map.put("ItemTitle", "第" + i + "行");
            map.put("ItemText", "这是第" + i + "行");
            listItem.add(map);
        }
        MyAdapter adapter = new MyAdapter(this, listItem);
        lv.setAdapter(adapter);


//        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,//需要绑定的数据
//                R.layout.item,//每一行的布局
//                new String[] {"ItemImage","ItemTitle", "ItemText"},//动态数组中的数据源的键对应到定义布局的View中
//                new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.ItemText});
//
//        lv.setAdapter(mSimpleAdapter);//为ListView绑定适配器
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                System.out.println("你点击了第" + arg2 + "行");//设置标题栏显示点击的行
            }
        });

}
}