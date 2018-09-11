package com.miguelcr.a03_restaurantlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewRestaurants);

        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Goiko Grill", "Avda. Respública Argentina, 20 Sevilla" ,5, "https://www.goikogrill.com/wp-content/uploads/2017/01/GOIKO_GRILL_WEB-2.jpg"));
        restaurantList.add(new Restaurant("100 Montaditos", "C/ Condes de Bustillo, 10 Sevilla" ,2, "https://www.franquiciashoy.es/assets/uploads/3095dc920c3d43e0f367dfa28cdee1b4fa54d10e94d832669f277069cf4f0fd4.png"));

        RestaurantAdapter adapter = new RestaurantAdapter(
            MainActivity.this,
                R.layout.restaurant_item,
                restaurantList
        );

        lista.setAdapter(adapter);


    }
}
