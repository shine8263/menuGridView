package com.example.menugridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SimpleAdapter;

//����GridViewʵ�ְ�׿����˵���ʾ
public class MainActivity extends Activity {

	 private GridView gview;
	 private List<Map<String, Object>> data_list;
	 private SimpleAdapter sim_adapter;
	 private int[] icon = { R.drawable.fk, R.drawable.flashplayer,
	            R.drawable.flvshow, R.drawable.ftp, R.drawable.guitar,
	            R.drawable.hotfield, R.drawable.icon, R.drawable.itimesync,
	            R.drawable.kingreader, R.drawable.lbe, R.drawable.lightsoff,
	            R.drawable.m8calendar };
	 private String[] iconName = { "ͨѶ¼", "����", "�����", "ʱ��", "��Ϸ", "����", "����",
	            "����", "����", "����", "�����", "��Ƶ" };

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        gview = (GridView) findViewById(R.id.gview);
        //�½�List
        data_list = new ArrayList<Map<String, Object>>();
        //��ȡ����
        getData();
        //�½�������
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item, from, to);
        //����������
        gview.setAdapter(sim_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public List<Map<String, Object>> getData(){        
        //cion��iconName�ĳ�������ͬ�ģ�������ѡ��һ������
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
            
        return data_list;
    }

}
