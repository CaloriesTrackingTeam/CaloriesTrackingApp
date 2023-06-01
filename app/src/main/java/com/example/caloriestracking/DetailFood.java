package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailFood extends AppCompatActivity {
    ImageView ArrowBack, tymFood, FoodPicture;
    TextView calory_minute_food, gramCarbsFood, gramProteinFood, gramFatFood, foodDesciption,
            food_How_to_cook, TvHowToBurnOut;
    BottomNavigationView btv;
    Button buttonFavorite;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    List<Food> list;
    Food foodDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        list = getListFood();

        findById_Ele();

        setupNavBottom();

        //intent get id of food --> find  food by id
        //map all dta in screen
        Intent intent = getIntent();
        if(intent != null){
            String idFoodClick = intent.getStringExtra("ID_FOOD_CLICK");
            int id = Integer.parseInt(idFoodClick);
            Food food = getFoodById(id);
            if(food != null){
                foodDetail = food;
                mapDataToscreen();
            }
        }

        //click ArrowBack
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailFood.this, Find_Food.class));
            }
        });

        //tymFood
        tymFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save id food to share reference
                saveFoodIdToListFoodFavourite();
                //startActivity(new Intent(DetailFood.this, Home.class));
            }
        });

        //click button favourite
        buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailFood.this, Home.class);
                saveFoodIdToListFoodFavourite();
                startActivity(intent);
            }
        });
    }

    private void saveFoodIdToListFoodFavourite() {
        String listFavo = sharedPreferences.getString("LIST_FOOD_FAVORITE", "");

        if(listFavo != null){
            if(listFavo.trim().length() > 0){
                if(listFavo.charAt(0) == ' '){
                    listFavo = listFavo.substring(1);
                }
                //list có data r
                String[] listId = listFavo.split(" ");
                boolean same = false;
                for (String id: listId) {
                    if(id.equals(foodDetail.getFoodID() + "")){
                        same = true;
                    }
                }

                if(same == false){
                    listFavo += " " + foodDetail.getFoodID();
                    editor.putString("LIST_FOOD_FAVORITE", listFavo);
                    editor.commit();
                    Toast.makeText(this, "Save "+foodDetail.getFoodName()+" to favourite Food success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Food "+foodDetail.getFoodName()+" already in favourite Food", Toast.LENGTH_SHORT).show();
                }
            }else{
                //list chua có gì
                listFavo += " " + foodDetail.getFoodID();
                editor.putString("LIST_FOOD_FAVORITE", listFavo);
                editor.commit();
                Toast.makeText(this, "Save "+foodDetail.getFoodName()+" to favourite Food success", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void mapDataToscreen() {
        calory_minute_food.setText(foodDetail.getFoodCalories() + " calo/ " + foodDetail.getFoodWeight() + " gram");
        Picasso.get().load(foodDetail.getFoodAvatar()).into(FoodPicture);
        gramCarbsFood.setText(foodDetail.getFoodCarbs() + "");
        gramProteinFood.setText(foodDetail.getFoodProtein() + "");
        gramFatFood.setText(foodDetail.getFoodFat() + "");
        foodDesciption.setText(foodDetail.getFoodDescription());
        food_How_to_cook.setText(foodDetail.getRecipe());

    }

    public Food getFoodById(int id){
        for (Food item: list) {
            if(item.getFoodID() == id)
                return item;
        }
        return null;
    }

    private void findById_Ele() {
        ArrowBack = findViewById(R.id.ArrowBack);
        tymFood = findViewById(R.id.tymFood);
        FoodPicture = findViewById(R.id.FoodPicture);

        calory_minute_food = findViewById(R.id.calory_minute_food);
        gramCarbsFood = findViewById(R.id.gramCarbsFood);
        gramProteinFood = findViewById(R.id.gramProteinFood);
        gramFatFood = findViewById(R.id.gramFatFood);
        foodDesciption = findViewById(R.id.foodDesciption);
        food_How_to_cook = findViewById(R.id.food_How_to_cook);
        TvHowToBurnOut = findViewById(R.id.TvHowToBurnOut);

        buttonFavorite = findViewById(R.id.buttonFavorite);

        sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        editor = sharedPreferences.edit();
    }

    private List<Food> getListFood() {
        list = new ArrayList<>();
        list.add(new Food(1,
                "Cơm trắng",
                "https://tiki.vn/blog/wp-content/uploads/2023/03/1-chem-com-bao-nhieu-calo-2.jpg",
                200,
                "Cơm trắng là thức ăn gần như hàng ngày của người Đông Nam Á và Đông Á, chỉ có nguyên liệu là gạo tẻ và không có thêm gia vị. ",
                "Bước 1: Đong gạo chính xác.\n" +
                        "    Bước 2: Vo gạo sạch với nước.\n" +
                        "    Bước 3: Ngâm gạo trong 30 phút để cơm chín đều hơn.\n" +
                        "    Bước 4: Đong nước phù hợp với lượng gạo.\n" +
                        "    Bước 5: Thêm một ít muối, bơ hoặc dầu ăn.\n" +
                        "    Bước 6: Nấu cơm đúng quy trình.\n" +
                        "    Bước 7: Ủ cơm trong vòng từ 5 đến 10 phút.",
                100, 44.2, 4.6, 0.6, null));

        list.add(new Food(2,
                "Cơm tấm bì",
                "https://comtamtuonghan.vn/wp-content/uploads/2022/02/com-tam-suon-bi-ba-chi.png",
                627,
                "Bì ăn với cơm tấm được làm từ da heo rửa sạch, luộc vừa chín tới, thái sợi, vắt cho ráo nước rồi trộn thêm thính và một số gia vị vừa ăn. Nhai miếng bì thấy thơm thơm, dai dai, sần sật là chuẩn vị. Đồ chua ăn kèm có củ cải, cà rốt xắt sợi; dưa leo, cà chua cắt lát tròn",
                "Bước 1: Nấu cơm tấm\n" +
                        "Bước 2: Làm sườn nướng\n" +
                        "Bước 3: Làm chả\n" +
                        "Bước 4: Làm bì\n" +
                        "Bước 5: Làm nước mắm\n" +
                        "Bước 5: Làm đồ chua\n" +
                        "Bước 6: Làm mỡ hành",
                250, 87.6, 26, 19.3, null));

        list.add(new Food(3,
                "Phở bò",
                "https://tapchigiambeo.com/wp-content/uploads/2020/01/pho-bo-bao-nhieu-calo-1.jpg",
                456,
                "Phở được dùng riêng như là một món ăn sáng, trưa hoặc tối",
                "Bước 1: Sơ chế xương bò, bắp bò, gù bò\n" +
                        "Bước 2: Hầm xương bò\n" +
                        "Bước 3: Sơ chế các nguyên liệu khác và nấu nước dùng\n" +
                        "Bước 4: Chuẩn bị bánh phở và các loại rau ăn kèm\n",
                280, 59.3, 20.9, 	12.2, null));

        list.add(new Food(4,
                "Nho Mỹ",
                "https://media.loveitopcdn.com/1254/nho-den-khong-hat-my-nhobonmuacom-2.jpg",
                68,
                "Vị ngọt thanh mát chạy từ đầu lưỡi đến tận cổ, tác dụng ngăn chặn hình thành cục máu đông có hiệu quả hơn Aspirin, giảm cholesterol trong mau, giảm ngưng tụ tiểu cầu.",
                "...",
                100, 0, 0, 	0.4, null));

        list.add(new Food(5,
                "Sơ ri",
                "https://giongcayanqua.edu.vn/upload/images/bai-viet/qua-so-ri.jpg",
                14,
                "Sơ ri hay còn gọi là kim đồng nam, acelora, sơ ri Barbados, sơ ri Tây Ấn hay xơ ri vuông, là một loài cây bụi hay cây thân gỗ nhỏ có quả nằm trong họ Sơ ri, có nguồn gốc ở Tây Ấn và miền bắc Nam Mỹ",
                "...",
                100, 0, 0, 	0.4, null));

        list.add(new Food(6,
                "Chuối sấy",
                "https://cdn.shopify.com/s/files/1/0363/6317/4024/products/Chu_iS_y1_1024x.jpg?v=1639646361",
                250,
                "Vị ngọt thanh mát chạy từ đầu lưỡi đến tận cổ, tác dụng ngăn chặn hình thành cục máu đông có hiệu quả hơn Aspirin, giảm cholesterol trong mau, giảm ngưng tụ tiểu cầu.",
                "...",
                100, 	10.7, 0, 1.8, null));


        list.add(new Food(7,
                "Măng cụt",
                "https://danviet.mediacdn.vn/296231569849192448/2022/5/21/art-rachen-vylv4xay3a-unsplash-16531292270011934654578.jpg",
                73,
                "Măng cụt hay còn được gọi là quả tỏi ngọt, là một loài cây thuộc họ Bứa. Nó cũng là loại cây nhiệt đới thường xanh cho quả ăn được, có nguồn gốc từ các đảo quốc Đông Nam ",
                "...",
                100, 0, 0, 0, null));


        list.add(new Food(8,
                "Sữa chua",
                "https://suckhoedoisong.qltns.mediacdn.vn/Images/duylinh/2020/06/30/20190927_183203_144360_tac-dung-sua-chua.max-800x800_resize.jpg",
                58,
                "Sữa chua hay Yogurt là một chế phẩm sữa được sản xuất bằng cách cho vi khuẩn lên men sữa. Mọi loại sữa có thể dùng để làm sữa chua nhà làm, nhưng trong cách chế tạo hiện đại, sữa bò được dùng nhiều nhất",
                "...",
                100, 4, 3.7, 3.8, null));


        list.add(new Food(9,
                "Bún mắm",
                "https://beptruong.edu.vn/wp-content/uploads/2018/11/bun-mam-co-them-thit-heo-quay.jpg",
                480,
                "Bún mắm là một trong số các món ăn đặc sản của miền tây Nam bộ Việt Nam. Bún mắm được nấu bằng mắm cá linh hay cá sặc, đây là các loại cá có nhiều tại miền Tây, đặc biệt là các tỉnh Trà Vinh và Sóc Trăng",
                "...",
                200, 56.8, 28.2, 15.5, null));

        list.add(new Food(10,
                "Sườn nướng",
                "https://ttol.vietnamnetjsc.vn/images/2022/05/02/15/06/suon-nuong-mat-ong-2.jpg",
                111,
                "Sườn lợn hay sườn heo là phần dẻ sườn của con lợn, được lóc từ phần xương sườn của con lợn và có dắt thịt ở trên đó. Đây là một trong những phần thịt từ khúc thịt lợn. Đây là nguyên liệu phổ biến trong ẩm thực các nước châu Á và ẩm thực phương Tây.",
                "Bạn ướp sườn với phần tỏi băm, hành tím băm, 1 muỗng cà phê hạt nêm, 1 muỗng cà phê muối, 2 muỗng canh mật ong, 2 muỗng canh tương cà, 1.5gr bột ngũ vị hương (khoảng 1/4 muỗng cà phê) và 3 muỗng canh dầu sa tế rồi trộn đều. Để thịt sườn thấm đậm đà, bạn ướp sườn với gia vị ít nhất 4 tiếng",
                100, 	1, 10.3, 7.3, null));

        //---------------LOOP
        list.add(new Food(1,
                "Cơm trắng",
                "https://tiki.vn/blog/wp-content/uploads/2023/03/1-chem-com-bao-nhieu-calo-2.jpg",
                200,
                "Cơm trắng là thức ăn gần như hàng ngày của người Đông Nam Á và Đông Á, chỉ có nguyên liệu là gạo tẻ và không có thêm gia vị. ",
                "Bước 1: Đong gạo chính xác.\n" +
                        "    Bước 2: Vo gạo sạch với nước.\n" +
                        "    Bước 3: Ngâm gạo trong 30 phút để cơm chín đều hơn.\n" +
                        "    Bước 4: Đong nước phù hợp với lượng gạo.\n" +
                        "    Bước 5: Thêm một ít muối, bơ hoặc dầu ăn.\n" +
                        "    Bước 6: Nấu cơm đúng quy trình.\n" +
                        "    Bước 7: Ủ cơm trong vòng từ 5 đến 10 phút.",
                100, 44.2, 4.6, 0.6, null));

        list.add(new Food(2,
                "Cơm tấm bì",
                "https://comtamtuonghan.vn/wp-content/uploads/2022/02/com-tam-suon-bi-ba-chi.png",
                627,
                "Bì ăn với cơm tấm được làm từ da heo rửa sạch, luộc vừa chín tới, thái sợi, vắt cho ráo nước rồi trộn thêm thính và một số gia vị vừa ăn. Nhai miếng bì thấy thơm thơm, dai dai, sần sật là chuẩn vị. Đồ chua ăn kèm có củ cải, cà rốt xắt sợi; dưa leo, cà chua cắt lát tròn",
                "Bước 1: Nấu cơm tấm\n" +
                        "Bước 2: Làm sườn nướng\n" +
                        "Bước 3: Làm chả\n" +
                        "Bước 4: Làm bì\n" +
                        "Bước 5: Làm nước mắm\n" +
                        "Bước 5: Làm đồ chua\n" +
                        "Bước 6: Làm mỡ hành",
                250, 87.6, 26, 19.3, null));

        list.add(new Food(3,
                "Phở bò",
                "https://tapchigiambeo.com/wp-content/uploads/2020/01/pho-bo-bao-nhieu-calo-1.jpg",
                456,
                "Phở được dùng riêng như là một món ăn sáng, trưa hoặc tối",
                "Bước 1: Sơ chế xương bò, bắp bò, gù bò\n" +
                        "Bước 2: Hầm xương bò\n" +
                        "Bước 3: Sơ chế các nguyên liệu khác và nấu nước dùng\n" +
                        "Bước 4: Chuẩn bị bánh phở và các loại rau ăn kèm\n",
                280, 59.3, 20.9, 	12.2, null));

        list.add(new Food(4,
                "Nho Mỹ",
                "https://media.loveitopcdn.com/1254/nho-den-khong-hat-my-nhobonmuacom-2.jpg",
                68,
                "Vị ngọt thanh mát chạy từ đầu lưỡi đến tận cổ, tác dụng ngăn chặn hình thành cục máu đông có hiệu quả hơn Aspirin, giảm cholesterol trong mau, giảm ngưng tụ tiểu cầu.",
                "...",
                100, 0, 0, 	0.4, null));

        list.add(new Food(5,
                "Sơ ri",
                "https://giongcayanqua.edu.vn/upload/images/bai-viet/qua-so-ri.jpg",
                14,
                "Sơ ri hay còn gọi là kim đồng nam, acelora, sơ ri Barbados, sơ ri Tây Ấn hay xơ ri vuông, là một loài cây bụi hay cây thân gỗ nhỏ có quả nằm trong họ Sơ ri, có nguồn gốc ở Tây Ấn và miền bắc Nam Mỹ",
                "...",
                100, 0, 0, 	0.4, null));

        list.add(new Food(6,
                "Chuối sấy",
                "https://cdn.shopify.com/s/files/1/0363/6317/4024/products/Chu_iS_y1_1024x.jpg?v=1639646361",
                250,
                "Vị ngọt thanh mát chạy từ đầu lưỡi đến tận cổ, tác dụng ngăn chặn hình thành cục máu đông có hiệu quả hơn Aspirin, giảm cholesterol trong mau, giảm ngưng tụ tiểu cầu.",
                "...",
                100, 	10.7, 0, 1.8, null));


        list.add(new Food(7,
                "Măng cụt",
                "https://danviet.mediacdn.vn/296231569849192448/2022/5/21/art-rachen-vylv4xay3a-unsplash-16531292270011934654578.jpg",
                73,
                "Măng cụt hay còn được gọi là quả tỏi ngọt, là một loài cây thuộc họ Bứa. Nó cũng là loại cây nhiệt đới thường xanh cho quả ăn được, có nguồn gốc từ các đảo quốc Đông Nam ",
                "...",
                100, 0, 0, 0, null));


        list.add(new Food(8,
                "Sữa chua",
                "https://suckhoedoisong.qltns.mediacdn.vn/Images/duylinh/2020/06/30/20190927_183203_144360_tac-dung-sua-chua.max-800x800_resize.jpg",
                58,
                "Sữa chua hay Yogurt là một chế phẩm sữa được sản xuất bằng cách cho vi khuẩn lên men sữa. Mọi loại sữa có thể dùng để làm sữa chua nhà làm, nhưng trong cách chế tạo hiện đại, sữa bò được dùng nhiều nhất",
                "...",
                100, 4, 3.7, 3.8, null));


        list.add(new Food(9,
                "Bún mắm",
                "https://beptruong.edu.vn/wp-content/uploads/2018/11/bun-mam-co-them-thit-heo-quay.jpg",
                480,
                "Bún mắm là một trong số các món ăn đặc sản của miền tây Nam bộ Việt Nam. Bún mắm được nấu bằng mắm cá linh hay cá sặc, đây là các loại cá có nhiều tại miền Tây, đặc biệt là các tỉnh Trà Vinh và Sóc Trăng",
                "...",
                200, 56.8, 28.2, 15.5, null));

        list.add(new Food(10,
                "Sườn nướng",
                "https://ttol.vietnamnetjsc.vn/images/2022/05/02/15/06/suon-nuong-mat-ong-2.jpg",
                111,
                "Sườn lợn hay sườn heo là phần dẻ sườn của con lợn, được lóc từ phần xương sườn của con lợn và có dắt thịt ở trên đó. Đây là một trong những phần thịt từ khúc thịt lợn. Đây là nguyên liệu phổ biến trong ẩm thực các nước châu Á và ẩm thực phương Tây.",
                "Bạn ướp sườn với phần tỏi băm, hành tím băm, 1 muỗng cà phê hạt nêm, 1 muỗng cà phê muối, 2 muỗng canh mật ong, 2 muỗng canh tương cà, 1.5gr bột ngũ vị hương (khoảng 1/4 muỗng cà phê) và 3 muỗng canh dầu sa tế rồi trộn đều. Để thịt sườn thấm đậm đà, bạn ướp sườn với gia vị ít nhất 4 tiếng",
                100, 	1, 10.3, 7.3, null));

        return list;
    }
    private void setupNavBottom() {
        btv = findViewById(R.id.bottom_nav);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(DetailFood.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    //startActivity(new Intent(Home.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }
                return true;
            }
        });
    }
}