package com.bawei.listview_checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> list;
    boolean tag = false;

    public int mfirstVisibleItem;
    public int mvisibleItemCount;
    public int mtotalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        init();
        ListView listview = (ListView) findViewById(R.id.listview);

        final MyAdapter adapter = new MyAdapter(this, list);
        listview.setAdapter(adapter);


        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //成功
                if (mtotalItemCount - mfirstVisibleItem - mvisibleItemCount <= 20) {
                    for (int i = 51; i < 100; i++) {
                        list.add(new Bean("条目" + i, false));
                        adapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //开始
                mfirstVisibleItem = firstVisibleItem;
                mvisibleItemCount = visibleItemCount;
                mtotalItemCount = totalItemCount;
            }
        });


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("list_new  点击了全选/反选");
                //反选
                if (!tag) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setBoo(true);
                        adapter.notifyDataSetChanged();
                    }
                    tag = true;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setBoo(false);
                        adapter.notifyDataSetChanged();
                    }
                    tag = false;
                }

            }
        });
    }

    public void init() {
        for (int i = 0; i < 50; i++) {
            list.add(new Bean("条目" + i, false));
        }
    }
}
