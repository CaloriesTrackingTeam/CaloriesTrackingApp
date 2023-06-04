package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.caloriestracking.adapter.ActivityAdapter;
import com.example.caloriestracking.adapter.FoodAdapter;
import com.example.caloriestracking.model.Activity;
import com.example.caloriestracking.model.Exercisek;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Find_Activity extends AppCompatActivity {

    RecyclerView rcv;

    List<Activity> list;
    Button FoodButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        BottomNavigationView btv = findViewById(R.id.bottom_nav);
        FoodButton = findViewById(R.id.FoodButton);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Find_Activity.this, User_Profile_Activity.class));
                }
                return true;
            }
        });

        //set up reccyle view
        rcv = findViewById(R.id.rcv_Activity);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);   //dạng cột và có 2 cột
        rcv.setLayoutManager(gridLayoutManager);

        ActivityAdapter activityAdapter = new ActivityAdapter(getActivityList(), this);
        rcv.setAdapter(activityAdapter);

        //set up search icon click
        ImageView iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterByName();
            }
        });

        FoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_Activity.this, Find_Food.class));
            }
        });
    }

    private void filterByName() {
        EditText edValueSearch = findViewById(R.id.searchValue);
        String value = edValueSearch.getText().toString();
        List<Activity> listSearch = new ArrayList<>();
        for (Activity item: list) {
            if(item.getActivityName().toLowerCase().contains(value.toLowerCase())){
                listSearch.add(item);
            }
        }

        ActivityAdapter activityAdapter = new ActivityAdapter(listSearch, this);
        rcv.setAdapter(activityAdapter);
    }

//    private List<Activity> getActivityList(){
//        list = new ArrayList<>();
//        list.add(new Activity("Walk"));
//        list.add(new Activity("Run"));
//        list.add(new Activity("Jump"));
//        list.add(new Activity("Fly"));
//        list.add(new Activity("Riding"));
//        list.add(new Activity("Push up"));
//        list.add(new Activity("Push out"));
//        list.add(new Activity("Push on"));
//        list.add(new Activity("Push Left"));
//        list.add(new Activity("Push Right"));
//        list.add(new Activity("Push Down"));
//        list.add(new Activity("Jumping Jack"));
//        list.add(new Activity("Jumping Tony"));
//        list.add(new Activity("Jumping Elsa"));
//        list.add(new Activity("Jumping Elizabeth"));
//        list.add(new Activity("Jumping John"));
//        list.add(new Activity("Plank"));
//        list.add(new Activity("Riding Horse"));
//        list.add(new Activity("Swimming"));
//        return list;
//    }

    private List<Activity> getActivityList() {
        list = new ArrayList<>();
        //(int exerciseID, String exerciseName, String exerciseAvatar, double exerciseCalories,
        // double minutes, String exerciseDescription, String guide)
        list.add(new Activity(1, "Plank"
                ,"https://www.thethaothientruong.vn/uploads/2021/Plank-cai-thien-tu-the-khoe-dep.jpg"
                , 35, 1
                , "Plank là một bài tập giúp đốt mỡ và làm săn cơ bụng hàng đầu cực kỳ hiệu quả dành cho cả nam và nữ. Chỉ với động tác đơn giản, dễ nhớ, dễ làm theo mà không cần thêm bất cứ dụng cụ gì. "
                , "Bước 1: Chuẩn bị dụng cụ, Bạn nên chuẩn bị cho mình 1 thảm tập yoga để không bị đau tay khi bạn chống tay lúc plank.\n" +
                "Bước 2: Vào tư thế bò, Bạn đặt 2 tay dưới vai rồi để đầu gối dưới hông, bạn có thể đặt phẳng chân hoặc uốn ngón chân lại cho tư thế này. Nhớ duy trì nhịp thở đều.\n" +
                "Bước 3: Đưa người về tư thế em bé, chuyển ngay về tư thế em bé bằng cách đẩy mông về phía bàn chân, đùi bạn mở rộng bằng vai rồi từ từ đưa ngực hạ xuống sàn\n" +
                "Bước 4: Vào tư thế plank,  bạn phải tạo thành một đường thẳng từ đầu đến gót chân. Tay bạn để dưới 2 vai thẳng đứng, mũi chân chống xuống sàn. Bạn phải dùng lực để giữ cho cột sống và mông thẳng."));

        list.add(new Activity(2, "Chống đẩy"
                ,"https://www.fitnesseducation.edu.au/wp-content/uploads/2020/10/Pushups.jpg"
                , 7, 1
                , "Chống đẩy hay hít đất - là một bài tập thể dục Calisthenics điển hình, vô cùng phổ biến. Được thực hiện bằng cách nâng cao và hạ thấp cơ thể trong tư thế nằm sấp bằng cách sử dụng cánh tay"
                ,
                "    - Bắt đầu quỳ trên thảm tập hoặc sàn nhà, đưa hai chân duỗi thẳng và khép lại gần nhau, mũi chân chống xuống sàn.\n" +
                        "    - Hai bàn tay rộng bằng vai, lòng bàn tay úp xuống và các ngón tay của bạn hướng về phía trước hoặc hơi chếch vào trong.\n" +
                        "    - Vai ở phía trên bàn tay, giữ cho lưng thẳng và hóp cơ bụng của bạn vào.\n" +
                        "    - Từ từ hạ thấp cơ thể xuống sàn. Giữ thân mình cứng và giữ đầu thẳng hàng với cột sống. Mắt luôn nhìn về phía trước và phần lưng dưới không bị chùng xuống hoặc phần hông của bạn không được hếch lên trên.\n" +
                        "    - Tiếp tục hạ người xuống cho đến khi ngực hoặc cằm chạm đất. Khuỷu tay của bạn có thể chìa ra trong quá trình di chuyển xuống.\n" +
                        "    - Đẩy lên trên cho đến khi cánh tay của bạn duỗi ra hoàn toàn và trở lại tư thế plank ban đầu.\n" +
                        "    - Lặp lại động tác và bắt đầu thực hiện theo số lần tập phù hợp.\n"));

        list.add(new Activity(3, "Bơi lội"
                ,"https://cdn.thehinh.com/2019/06/64339804_6140715877001_2673110258309660672_n-1.png"
                , 11, 1
                , "Bơi lội là môn thể thao dưới nước, nhờ vào lực đẩy của nước và sự vận động của toàn thân, đặc biệt là chân và tay mà người bơi có thể di chuyển cơ thể dưới nước với một tốc độ nhất định. Bơi lội là môn thể thao dành cho mọi người ở mọi lứa tuổi và không quá tốn kém, giúp bạn cải thiện được sức khỏe, thậm chí là tinh thần."
                , "Bước 1: Nín thở dưới nước – Một trong những hướng dẫn đầu tiên khi bạn học bơi\n" +
                "Bước 2: Hít thở dưới nước – Yếu tố quan trọng thứ hai cần lưu ý trong hướng dẫn học bơi\n" +
                "Bước 3: Khi tập bơi đừng quên kỹ năng nổi dưới nước và lướt nước\n" +
                "Bước 4: Hướng dẫn học bơi an toàn - Chọn nơi dạy bơi lội uy tín, học phí hợp lý cho người mới bắt đầu"));

        list.add(new Activity(4, "Đạp xe"
                ,"https://cdn.tgdd.vn/Files/2022/05/10/1431463/moi-ngay-nen-dap-xe-bao-nhieu-km-dap-bao-lau-.jpg"
                , 5, 1
                , "Đi xe đạp là môn thể thao tốt cho sức khỏe giúp rèn luyện thể chất, cải thiện tim phổi. Tuy nhiên nhiều người thường xuyên đi xe đạp chưa hẳn đã biết đạp xe đạp đúng cách."
                , "Bước 1: Ăn uống trước khi đạp xe đạp là một điều cần thiết, bởi khi đạp xe cơ thể bạn tiêu hao khá nhiều năng lượng và mất sức,\n" +
                "Bước 2: Tất cả các thời gian trong ngày đều có thể đạp xe, nhưng thời gian lý tưởng để đạp xe là vào buổi sáng sớm trước khi ăn bữa đầu tiên trong ngày.\n" +
                "Bước 3: Tư thế đạp xe vừa thoải mái vừa đúng cách, là tư thế ngồi hơi nghiêng về phía trước, giữ tay hơi cong cong trong lúc đạp xe, vì khi tay hơi cong nó cho phép các cơ phần trên và khớp lưng cảm nhận độ rung, phân tán lực, ít gây ảnh hưởng đến cột sống. Khi đạp xe giữ chân ở góc 90 độ, nó tốt cho phần hông của bạn tránh các trường hợp đau cơ.\n" +
                "Bước 4: đạp xe đúng cách, chính xác đảm bảo sức khỏe gồm 4 bước: đạp, kéo, nâng, đẩy. Chân đạp nhẹ nhàng xuống dưới, dùng lực bàn chân kéo lên trên rồi nâng bàn đạp, rồi nhẹ nhàng đẩy xuống, những động tác được lặp đi lặp lại, đúng nhịp với tần suất đạp đều nhau, giúp đẩy nhanh tốc độ."));

        return list;
    }

}