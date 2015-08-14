package com.example.bigfather.sortalgorithm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText dataInput;
    private TextView sortShow;
    private int[] datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContentView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initContentView(){
        dataInput = (EditText) findViewById(R.id.editText);
        dataInput.setText("12 14 6 7 9 11 8 7");
        sortShow = (TextView) findViewById(R.id.textView2);
        Button straightInsertionSort = (Button) findViewById(R.id.button);
        straightInsertionSort.setOnClickListener(this);
        Button shellSort = (Button) findViewById(R.id.button2);
        shellSort.setOnClickListener(this);
    }

    public void getDatas(){
        String dataStr = dataInput.getText().toString();
        String data[] = dataStr.split(" ");
        datas = new int[data.length];

        for(int i = 0; i <= data.length - 1; i++){
            datas[i] = Integer.parseInt(data[i]);
        }
    }

    public void showSort(){
        String sortStr = "";
        for(int i = 0; i<=datas.length - 1; i++){
            sortStr = sortStr + " " + datas[i];
        }
        sortShow.setText(sortStr);
    }

    @Override
    public void onClick(View v) {
        getDatas();
        switch (v.getId()){
            case R.id.button:
                SortAlgorithm.straightInsertionSort(datas);
                break;
            case R.id.button2:
                SortAlgorithm.shellSort(datas);
                break;
        }

        showSort();
    }


}
