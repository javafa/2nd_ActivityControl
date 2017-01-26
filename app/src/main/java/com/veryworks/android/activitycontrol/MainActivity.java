package com.veryworks.android.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 1. Activity 라이프 사이클 관리
 * 2. 액티비티 간에 값 주고 받기
 *
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = "MainActivity";

    Button btnCom,btnTrans1,btnTrans2;
    EditText et;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCom = (Button) findViewById(R.id.btnCommon);
        et = (EditText) findViewById(R.id.editText);

        btnTrans1 = (Button) findViewById(R.id.btnTrans1);
        btnTrans2 = (Button) findViewById(R.id.btnTrans2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        btnCom.setOnClickListener(this);
        btnTrans1.setOnClickListener(this);
        btnTrans2.setOnClickListener(this);
    }

    public static final int ONE = 1;
    public static final int TWO = 2;

    @Override
    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnCommon:
                // # 액티비티로 값 넘기기
                // 1. 인텐트 생성
                intent = new Intent(this, CommonActivity.class);
                // 2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", et.getText().toString());
                intent.putExtra("var2", "aaaa");
                intent.putExtra("var3", 33333);
                // 3. Extra 에 담긴 값을 intent로 전달한다.
                startActivity(intent);
                break;

            case R.id.btnTrans1:
                // # 호출한 액티비티로 부터 값을 돌려 받을 때
                // 1. 인텐트 생성
                intent = new Intent(this, TransActivity.class);
                // 2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", et.getText().toString());
                intent.putExtra("varNum", 33333);
                // 3.
                startActivityForResult(intent, ONE);
                break;

            case R.id.btnTrans2:
                // # 호출한 액티비티로 부터 값을 돌려 받을 때
                // 1. 인텐트 생성
                intent = new Intent(this, TransActivity.class);
                // 2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", et.getText().toString());
                intent.putExtra("varNum", 33333);
                // 3. 액티비티를 호출
                startActivityForResult(intent, TWO);
                break;
        }
    }

    /** startActivityForResult( ) 함수로 호출된 액티비티가 종료되면서 호출
     *
     * @param requestCode 호출시에 메인 액티비티에서 넘긴 구분값
     * @param resultCode  호출된 액티비티의 처리 상태 코드
     * @param intent        호출된 액티비티가 돌려주는 데이터
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // 처리 상태 코드 체크
        if(resultCode == 1) {
            // 1. 돌려받은 intent 를 꺼내고
            Bundle bundle = intent.getExtras();
            String result = bundle.getString("result");

            // 2. 호출한 측 코드를 매칭후 값을 처리
            switch (requestCode) {
                case ONE:
                    tv1.setText(result);
                    break;
                case TWO:
                    tv2.setText(result);
                    break;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.print("onStart 시작",TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.print("onResume 시작",TAG);
    }
    // Running
    @Override
    protected void onPause() {
        super.onPause();
        Logger.print("onPause 시작",TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.print("onStop 시작",TAG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.print("onRestart 시작",TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.print("onDestroy 시작",TAG);
    }
}
