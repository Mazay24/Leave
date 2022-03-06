package com.example.leave;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.util.Log;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String TAG = "StartActivity";

    private Integer count = 5;

    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализация Активности
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
    }

    // Вызывается после завершения метода onCreate
    // Используется для восстановления состояния UI
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("count")) {
            count = savedInstanceState.getInt("count");
        }
        Log.d(TAG, "onRestoreInstanceState");
        // Восстановление состояние UI из объекта savedInstanceState.
        // Данный объект также был передан методу onCreate.
    }
    // Вызывается перед тем, как Активность снова становится видимой
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
        // Восстановить состояние UI с учетом того,
        // что данная Активность уже была видимой.
    }
    // Вызывается, когда Активность стала видимой
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
        resetUI();
        // Проделать необходимые действия для
        // Активности, видимой на экране
    }
    // Должен вызываться в начале видимого состояния.
    // На самом деле Android вызывает данный обработчик только
    // для Активностей, восстановленных из неактивного состояния
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
        // Восстановить приостановленные обновления UI,
        // потоки и процессы, замороженные, когда
        // Активность была в неактивном состоянии
    }
    // Вызывается перед выходом из активного состояния,
    // позволяя сохранить состояние в объекте savedInstanceState
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Объект savedInstanceState будет в последующем
        // передан методам onCreate и onRestoreInstanceState
        super.onSaveInstanceState(savedInstanceState);
        outState.putInt("count", count);
        Log.d(TAG, "onSaveInstanceState");
    }
    // Вызывается перед выходом из активного состояния
    @Override
    public void onPause(){
        // «Заморозить» обновления UI, потоки или
        // «трудоемкие» процессы, не нужные, когда Активность
        // не на переднем плане
        super.onPause();
        Log.d(TAG, "onPause");
    }
    // Вызывается перед выходом из видимого состояния
    @Override
    public void onStop(){
        // «Заморозить» обновления UI, потоки или
        // «трудоемкие» процессы, ненужные, когда Активность
        // не на переднем плане.
        // Сохранить все данные и изменения в UI, так как
        // процесс может быть в любой момент убит системой
        super.onStop();
        Log.d(TAG, "onStop");
    }
    // Вызывается перед уничтожением активности
    @Override
    public void onDestroy(){
        // Освободить все ресурсы, включая работающие потоки,
        // соединения с БД и т. д.
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.txt_counter)).setText(count.toString());
        Log.d(TAG, "resetUI");
    }
}