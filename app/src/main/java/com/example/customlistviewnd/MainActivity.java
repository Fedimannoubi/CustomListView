package com.example.customlistviewnd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    protected ListView maListeViewPerso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maListeViewPerso = findViewById(R.id.listviewperso);

        ArrayList <HashMap <String, String>>listIem = new ArrayList<>();

        HashMap <String, String> map;


        map= new HashMap<>();
        map.put("titre","Word");
        map.put("description","Editeur de text");
        map.put("img",String.valueOf(R.drawable.word));

        map= new HashMap<>();
        map.put("titre","Excel");
        map.put("description","Tableur");
        map.put("img",String.valueOf(R.drawable.excel));

        map= new HashMap<>();
        map.put("titre","Power Point");
        map.put("description","Logiciel de présentation");
        map.put("img",String.valueOf(R.drawable.powerpoint));

        map= new HashMap<>();
        map.put("titre","Outlook");
        map.put("description","Client de courir electronique");
        map.put("img",String.valueOf(R.drawable.outlook));

        final SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),listIem,
                R.layout.activity_list_item,
                new String[]{"titre","description","img"},
                new int[]{R.id.titre,R.id.description,R.id.img});

        maListeViewPerso.setAdapter(adapter);

        maListeViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String ,String> map= (HashMap<String, String>) maListeViewPerso.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get("titre"),Toast.LENGTH_SHORT).show();
            }
        });


        maListeViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String ,String> map= (HashMap<String, String>) maListeViewPerso.getItemAtPosition(position);

                final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Selection item");
                builder.setMessage("Votre choix:"+map.get("titre"));
                builder.setPositiveButton("OK",null);
                builder.show();
                return true;
            }
        });
    }
}
