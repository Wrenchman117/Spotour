package com.wrstech.spotour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    TextView t1, t2;
    Intent intent;
    PlaceAdapter places;
    ListView listview;

    String place_str, type_str;

    String[] place_historical_SJ = {"Old San Juan", "Castillo San Cristobal", "Balneario El Escambron"};
    String[] place_historical_P = {"Paseo Tablado La Guancha", "Museo de Arte de Ponce", "Cruceta del Vigia"};

    String[] place_restaurant_SJ = {"Casa Cortés ChocoBar", "Santaella", "Cocina Abierta"};
    String[] place_restaurant_P = {"La Casa del Chef", "Campioni", "Longhorn Steakhouse"};

    String[] info_historical_SJ = {"Old San Juan is located on a small and narrow island which lies along the north coast, about 35 miles (56 km) from the east end of Puerto Rico, and is united to the mainland of Puerto Rico by three bridges. It is bounded by the Atlantic Ocean to the north and to the south by San Juan Bay (or \"Bahia de San Juan\")—which lies between the city and the mainland. On a bluff about 100 feet (30 m) high at the west end of the island and commanding the entrance to the harbor, rise the battlements of Fort San Felipe del Morro, in which there is a lighthouse.\n" +
            "\n" +
            "The \"Caño de San Antonio\" lies to the southeast, where the island of Old San Juan connects to the mainland through Santurce, by three bridges, \"Puente Dos Hermanos\" (Ashford Avenue), \"Puente G. Esteves\" (Ponce de León Avenue) and \"Puente San Antonio\" (Fernández Juncos Avenue).\n" +
            "\n" +
            "The city is characterized by its narrow, blue cobblestone streets, and flat roofed brick and stone buildings which date back to the 16th and 17th century—when Puerto Rico was a Spanish possession. Near Fort San Felipe del Morro, is the Casa Blanca, a palace built on land which belonged to the family of Ponce de Leon.",
            "Castillo San Cristóbal is the largest fortification built by the Spanish in the New World. When it was finished in 1783, it covered about 27 acres of land and basically wrapped around the city of San Juan. Entry to the city was sealed by San Cristóbal's double gates. After close to one hundred years of relative peace in the area, part of the fortification (about a third) was demolished in 1897 to help ease the flow of traffic in and out of the walled city",
            "Balneario El Escambron is a little beach, just to the east of Old San Juan. It is a family-friendly beach, with a small crescent of clean sand and usually calm waters, thanks to the coral reef a short distance from the beach."};
    String[] info_historical_P = {"The Paseo Tablado La Guancha is located in the town's sea shore. It has kiosks which sell food and alcoholic beverages. There is also a marina where you can rent pedal boats and kayaks to explore the bay,an open-space stage for social and other similar activities. It also has an observation tower from which the Cardona Island Lighthouse can be seen. A 45-minute boat ride is also available to Caja de Muertos, a small island that features the Caja de Muertos Lighthouse which was built in 1887 and several beaches.",
                        "It was founded in 1959 by industrialist and philanthropist Luis A. Ferré at a location in the Ponce Historic Zone. The museum moved to its current building location on Avenida Las Americas in 1965. In 2010, the museum increased its size significantly after a $30M expansion.",
                        "Cruceta del Vigía (English: The Watchman Cross) is a 100 feet (30 m) tall cross located atop Vigia Hill in Ponce, Puerto Rico, across from Museo Castillo Serrallés. It houses a tourist center at its base, a ten-story vertical tower, and a horizontal sky bridge that has panoramic views of the city of Ponce and the Caribbean Sea. Visitors can reach the skybridge via glass elevators or a staircase. Made of reinforced concrete, the cross has withstood various natural disasters, including three major hurricanes. The arms of the cross measure 70 feet. It was inaugurated in 1984."};

    String[] info_restaurant_SJ = {"In 1929, as the Great Depression was starting, a man with vision and determination, Don Pedro Cortés Forteza was motivated by the great potential of Caribbean Cocoa founded Cortés Hermanos in the Dominican Republic. As a reflection of his dedication and commitment to quality, he named the product after his family's last name, thus making the birth of Chocolate Cortés. ",
                                    "Rooted firmly in authentic dishes and local ingredients, Santaella creates an elegant evolution of the flavours that showcase the vibrant energy of the island's cocina criolla. Previously his catering workshop, Chef Santaella has transformed this historic building into an architecturally acclaimed space. The menu sits firmly in the traditions of the island, sourcing ingredients from a farmer’s market only feet away. The flavours harness the tropical, rustic heritage while also showcasing the chef's international experience and capitalising on the finest cuisine trends.",
                                    "Cocina Abierta is an interactive culinary environment. At our restaurant we create and interpret the culinary ideas inspired from different cultures, products, and techniques."};
    String[] info_restaurant_P = {"Los mejores platos a la carta y show en vivo, los pueden disfrutar en la Casa del Chef Av. Eduardo de Habich N° 393",
                                    "¡La leña está que arde! Pizza artesanal hecha en leña. Únicos es Ponce.",
                                    "In 1981, one man set out on a mission to bring legendary steak to the people of Atlanta, Georgia. And while his passion for grilling was great, business wasn't quite booming. Then in 1982, a freak snowstorm hit the city, stranding motorists and driving them into the hospitable comforts of a joint called LongHorn Steaks Restaurant & Saloon. Tales of the expertly grilled steaks spread, and the legend of LongHorn® was born."};

    int[] pictures_historical_SJ = {R.drawable.old_san_juan, R.drawable.castillo_s_critobal, R.drawable.escambron};
    int[] pictures_historical_P = {R.drawable.guancha, R.drawable.museo, R.drawable.el_vigia};

    int[] pictures_restaurant_SJ = {R.drawable.chococortez, R.drawable.santaella, R.drawable.salonfondo};
    int[] pictures_restaurant_P = {R.drawable.casaschef, R.drawable.campioni, R.drawable.longhornponce};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        place_str = intent.getStringExtra("town");
        type_str = intent.getStringExtra("place");

        ArrayList<Place> places_SJ = new ArrayList<>();
        ArrayList<Place> places_P = new ArrayList<>();

        if(place_str.equals("Ponce")){
            if(type_str.equals("Historical")){
                for(int c = 0; c < place_historical_P.length; c++){
                    places_P.add(new Place(place_historical_P[c], info_historical_P[c], pictures_historical_P[c]));
                    places = new PlaceAdapter(this, places_P, place_str, type_str);
                    listview = (ListView)findViewById(R.id.word_list);
                    listview.setAdapter(places);
                }
            }
            else if(type_str.equals("Restaurants")){
                for(int c = 0; c < place_restaurant_P.length; c++){
                    places_P.add(new Place(place_restaurant_P[c], info_restaurant_P[c], pictures_restaurant_P[c]));
                    places = new PlaceAdapter(this, places_P, place_str, type_str);
                    listview = (ListView)findViewById(R.id.word_list);
                    listview.setAdapter(places);
                }
            }


        }
        else if(place_str.equals("San Juan")){
            if(type_str.equals("Historical")){
                for(int c = 0; c < place_historical_SJ.length; c++){
                    places_SJ.add(new Place(place_historical_SJ[c], info_historical_SJ[c], pictures_historical_SJ[c]));
                    places = new PlaceAdapter(this, places_SJ, place_str, type_str);
                    listview = (ListView)findViewById(R.id.word_list);
                    listview.setAdapter(places);
                }
            }
            else if(type_str.equals("Restaurants")){
                for(int c = 0; c < place_restaurant_SJ.length; c++){
                    places_SJ.add(new Place(place_restaurant_SJ[c], info_restaurant_SJ[c], pictures_restaurant_SJ[c]));
                    places = new PlaceAdapter(this, places_SJ, place_str, type_str);
                    listview = (ListView)findViewById(R.id.word_list);
                    listview.setAdapter(places);
                }
            }


        }




    }


}
