package com.example.katya.recipes;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends Activity  {

    private ArrayList<ItemDetails> recipes = new ArrayList<>();
    public static String LOG_TAG = "my_log";

    public static final String[] name = new String[] { "Американские блинчики","Ананасовая шарлотка","Английский кекс",
            "Бананово-шоколадный кекс","Банановое печенье","Баница","Бельгийские пивные оладьи","Блины заварные на кефире",
            "Вафли","Домашнее мороженое","Имбирное печенье","Кекс в чашке","Клюквенный крисп"};

    public static final String[] description = new String[] {
            "Мука — 200 гр.\n" +
                    "Сахар — 2 ст.л.\n" +
                    "Сода — 1,5 ч.л.\n" +
                    "Лимонная кислота — 0,25 ч.л.\n" +
                    "Соль — 0,5 ч.л.\n" +
                    "Яйцо — 1 шт.\n" +
                    "Молоко — 200 мл.\n" +
                    "Масло оливковое — 3 ст.л.\n",
            "Пшеничная мука - 1 стакан\n" +
                    "Сахар - 1 стакан\n" +
                    "Консервированный ананас - 1 банка\n" +
                    "Яблоко - 2 штуки\n" +
                    "Яйцо куриное - 3 штуки\n",
            "Сахар — 1 стак.\n" +
                    "Маргарин — 100 г\n" +
                    "Яйцо куриное — 2 шт\n" +
                    "Кефир — 0,5 стак.\n" +
                    "Сода — 0,5 ч. л.\n" +
                    "Мука пшеничная — 1,5 стак.\n" +
                    "Орехи — 2 ст. л.\n" +
                    "Изюм — 2 ст. л.\n",
            "Пшеничная мука - 250 г\n" +
                    "Разрыхлитель - 2,5 чайные ложки\n" +
                    "Соль - щепотка\n" +
                    "Темный шоколад - 125 г\n" +
                    "Ванилин - по вкусу\n" +
                    "Сахар - 240 г\n" +
                    "Яйцо куриное - 2 штуки\n" +
                    "Бананы - 4 штуки\n",
            "Банан — 1 шт. \n" +
                    "Масло сливочное — 100 г \n" +
                    "Сахар — 2 ст. л. \n" +
                    "Мёд — 1 ст. л. \n" +
                    "Яйцо — 1 шт. \n" +
                    "Сода — 0.5 ч.л. \n" +
                    "Мука пшеничная — 320-340 г\n",
            "Мука — 3 стакана (250 мл один стакан);\n" +
                    "Яйцо — 1 шт;\n" +
                    "Вода — 300 мл;\n" +
                    "Соль — одна щепотка;\n" +
                    "Винный уксус или лимонный уксус — 1 ст. ложка;\n" +
                    "Растительное масло — 2 ст. ложки.\n",
            "Пшеничная мука — 200 г\n" +
                    "Яйцо куриное — 4 штуки\n" +
                    "Светлое пиво — 200 мл\n" +
                    "Сухие дрожжи — 5 г\n" +
                    "Сливочное масло — 60 г\n" +
                    "Соль — по вкусу\n" +
                    "Сливки 35%-ные — 100 г\n" +
                    "Сахар — 130 г\n" +
                    "Брусничный соус — 3 столовые ложки\n",
            "Кефир 2,5% — 1 стакан\n" +
                    "Вода — 1 стакан\n" +
                    "Мука — 150 г\n" +
                    "Яйцо — 2 шт.\n" +
                    "Сахар — 3 ст. л.\n" +
                    "Соль — 1 щепотка\n" +
                    "Растительное масло рафинированное — 5 ст. л.\n" +
                    "Сода — ½ г\n",
            "Мука — 1 стакан\n" +
                    "Сахар — 1 стакан\n" +
                    "Маргарин сливочный — 200 г\n" +
                    "Ванилин — 1 г\n" +
                    "Яйца куриные крупные — 4 шт.\n",
            "Молоко — 250 мл,\n" +
                    "Сливки (33-35%) — 250 мл,\n" +
                    "Яичные желтки — 4-6 шт,\n" +
                    "Сахар — 80-90 г,\n" +
                    "Ванильный экстракт или ванильный сахар — 1 чайная ложка\n",
            "Мука — 200 г\n" +
                    "Сода — 1 ½ ч. л.\n" +
                    "Яйцо — 1 шт.\n" +
                    "Имбирь молотый — 2 ч. л.\n" +
                    "Корица — 1 ч. л.\n" +
                    "Кардамон — 1 ч. л.\n" +
                    "Гвоздика — ½ ч. л.\n" +
                    "Масло сливочное — 100 г\n" +
                    "Сахар —  100 г\n" +
                    "Мед — 3 ч. л.\n",
            "Мука — 70 гр.\n" +
                    "Какао — 15 гр.\n" +
                    "Растительное масло — 30 гр.\n" +
                    "Соль — 0,25 ч.л.\n" +
                    "Разрыхлитель — 2 гр.\n" +
                    "Сахар — 60 гр.\n" +
                    "Яйцо — 1 шт.\n" +
                    "Молоко — 30 мл.\n",
            "Клюква — 4 стакана\n" +
                    "Яблочный сок с мякотью — ¾ стакана\n" +
                    "Яблоко — 1 штука\n" +
                    "Пшеничная мука — 1 стакан\n" +
                    "Сахар — 1 стакан\n" +
                    "Коричневый сахар — 1,5 стакана\n" +
                    "Сливочное масло — 200 г\n" +
                    "Соль — ½ чайной ложки\n" +
                    "Овсяная крупа — 2 стакана" };

    public static final Integer[] images = { R.drawable.bb1,R.drawable.bb2,R.drawable.bb3, R.drawable.bb4,R.drawable.bb5, R.drawable.bb6,
            R.drawable.bb7,R.drawable.bb8,R.drawable.v1,R.drawable.d1,R.drawable.pp1,R.drawable.k1,R.drawable.k2 };

    public ListView lview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new ParseTask().execute();


        for (int i = 0; i < name.length; i++) {
            ItemDetails item = new ItemDetails(images[i], name[i], description[i]);
            recipes.add(item);
        }
        lview = (ListView) findViewById(R.id.lview);
        final DataAdapter adapter = new DataAdapter(this, recipes);
        lview.setAdapter(adapter);

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            ArrayList<ItemDetails> items = new ArrayList<>();
            items.add(recipes.get(position));

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("description", recipes);
            startActivity(intent);
        }

    });
    }
    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        @Override
        protected String doInBackground(Void... params) {
            // получаем данные с внешнего ресурса
            try {
                URL url = new URL("http://androiddocs.ru/api/friends.json");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                resultJson = buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            // выводим целиком полученную json-строку
            Log.d(LOG_TAG, strJson);

            JSONObject dataJsonObj = null;
            String secondName = "";

            try {
                dataJsonObj = new JSONObject(strJson);
                JSONArray friends = dataJsonObj.getJSONArray("friends");

                // 1. достаем инфо о втором друге - индекс 1
                JSONObject secondFriend = friends.getJSONObject(1);
                secondName = secondFriend.getString("name");
                Log.d(LOG_TAG, "Второе имя: " + secondName);

                // 2. перебираем и выводим контакты каждого друга
                for (int i = 0; i < friends.length(); i++) {
                    JSONObject friend = friends.getJSONObject(i);

                    JSONObject contacts = friend.getJSONObject("contacts");

                    String phone = contacts.getString("mobile");
                    String email = contacts.getString("email");
                    String skype = contacts.getString("skype");

                    Log.d(LOG_TAG, "phone: " + phone);
                    Log.d(LOG_TAG, "email: " + email);
                    Log.d(LOG_TAG, "skype: " + skype);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
