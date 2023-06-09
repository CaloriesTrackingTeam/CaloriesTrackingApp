package com.example.caloriestracking.ListData;

import com.example.caloriestracking.model.Activity;
import com.example.caloriestracking.model.Exercisek;
import com.example.caloriestracking.model.Food;

import java.util.ArrayList;
import java.util.List;

public class ListDataSource {
    public List<Exercisek> exercisekList;
    public List<Activity> activityList;
    public List<Food> foodList;

    public List<Exercisek> getExercisekList() {
        return exercisekList;
    }

    public void setExercisekList(List<Exercisek> exercisekList) {
        this.exercisekList = exercisekList;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public ListDataSource() {
        getListFood();
        getActivityListData();
        getListExercise();
    }

    private void getListFood() {
        foodList = new ArrayList<>();
        foodList.add(new Food(1,
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

        foodList.add(new Food(2,
                "Cơm tấm bì",
                "https://comtamtuonghan.vn/wp-content/uploads/2022/02/com-tam-suon-bi-ba-chi.png",
                627,
                "Bì ăn với cơm tấm được làm từ da heo rửa sạch, luộc vừa chín tới, thái sợi, vắt cho ráo nước rồi trộn thêm thính và một số gia vị vừa ăn. Nhai miếng bì thấy thơm thơm, dai dai, sần sật là chuẩn vị. Đồ chua ăn kèm có củ cải, cà rốt xắt sợi; dưa leo, cà chua cắt lát tròn",
                "Bước 1: Nấu cơm tấm\n" +
                        "Bước 2: Làm sườn nướng\n" +
                        "Bước 3: Làm chả\n" +
                        "Bước 4: Làm bì\n" +
                        "Bước 5: Làm nước mắm\n" +
                        "Bước 6: Làm đồ chua\n" +
                        "Bước 7 : Làm mỡ hành",
                250, 87.6, 26, 19.3, null));

        foodList.add(new Food(3,
                "Phở bò",
                "https://tapchigiambeo.com/wp-content/uploads/2020/01/pho-bo-bao-nhieu-calo-1.jpg",
                456,
                "Phở được dùng riêng như là một món ăn sáng, trưa hoặc tối",
                "Bước 1: Sơ chế xương bò, bắp bò, gù bò\n" +
                        "Bước 2: Hầm xương bò\n" +
                        "Bước 3: Sơ chế các nguyên liệu khác và nấu nước dùng\n" +
                        "Bước 4: Chuẩn bị bánh phở và các loại rau ăn kèm\n",
                280, 59.3, 20.9, 	12.2, null));

        foodList.add(new Food(4,
                "Nho Mỹ",
                "https://media.loveitopcdn.com/1254/nho-den-khong-hat-my-nhobonmuacom-2.jpg",
                68,
                "Vị ngọt thanh mát chạy từ đầu lưỡi đến tận cổ, tác dụng ngăn chặn hình thành cục máu đông có hiệu quả hơn Aspirin, giảm cholesterol trong mau, giảm ngưng tụ tiểu cầu.",
                "...",
                100, 0, 0, 	0.4, null));

        foodList.add(new Food(5,
                "Sơ ri",
                "https://giongcayanqua.edu.vn/upload/images/bai-viet/qua-so-ri.jpg",
                14,
                "Sơ ri hay còn gọi là kim đồng nam, acelora, sơ ri Barbados, sơ ri Tây Ấn hay xơ ri vuông, là một loài cây bụi hay cây thân gỗ nhỏ có quả nằm trong họ Sơ ri, có nguồn gốc ở Tây Ấn và miền bắc Nam Mỹ",
                "...",
                100, 0, 0, 	0.4, null));

        foodList.add(new Food(6,
                "Chuối sấy",
                "https://cdn.shopify.com/s/files/1/0363/6317/4024/products/Chu_iS_y1_1024x.jpg?v=1639646361",
                250,
                "Vị ngọt thanh mát chạy từ đầu lưỡi đến tận cổ, tác dụng ngăn chặn hình thành cục máu đông có hiệu quả hơn Aspirin, giảm cholesterol trong mau, giảm ngưng tụ tiểu cầu.",
                "...",
                100, 	10.7, 0, 1.8, null));


        foodList.add(new Food(7,
                "Măng cụt",
                "https://danviet.mediacdn.vn/296231569849192448/2022/5/21/art-rachen-vylv4xay3a-unsplash-16531292270011934654578.jpg",
                73,
                "Măng cụt hay còn được gọi là quả tỏi ngọt, là một loài cây thuộc họ Bứa. Nó cũng là loại cây nhiệt đới thường xanh cho quả ăn được, có nguồn gốc từ các đảo quốc Đông Nam ",
                "...",
                100, 0, 0, 0, null));


        foodList.add(new Food(8,
                "Sữa chua",
                "https://suckhoedoisong.qltns.mediacdn.vn/Images/duylinh/2020/06/30/20190927_183203_144360_tac-dung-sua-chua.max-800x800_resize.jpg",
                58,
                "Sữa chua hay Yogurt là một chế phẩm sữa được sản xuất bằng cách cho vi khuẩn lên men sữa. Mọi loại sữa có thể dùng để làm sữa chua nhà làm, nhưng trong cách chế tạo hiện đại, sữa bò được dùng nhiều nhất",
                "...",
                100, 4, 3.7, 3.8, null));


        foodList.add(new Food(9,
                "Bún mắm",
                "https://beptruong.edu.vn/wp-content/uploads/2018/11/bun-mam-co-them-thit-heo-quay.jpg",
                480,
                "Bún mắm là một trong số các món ăn đặc sản của miền tây Nam bộ Việt Nam. Bún mắm được nấu bằng mắm cá linh hay cá sặc, đây là các loại cá có nhiều tại miền Tây, đặc biệt là các tỉnh Trà Vinh và Sóc Trăng",
                "...",
                200, 56.8, 28.2, 15.5, null));

        foodList.add(new Food(10,
                "Sườn nướng",
                "https://ttol.vietnamnetjsc.vn/images/2022/05/02/15/06/suon-nuong-mat-ong-2.jpg",
                111,
                "Sườn lợn hay sườn heo là phần dẻ sườn của con lợn, được lóc từ phần xương sườn của con lợn và có dắt thịt ở trên đó. Đây là một trong những phần thịt từ khúc thịt lợn. Đây là nguyên liệu phổ biến trong ẩm thực các nước châu Á và ẩm thực phương Tây.",
                "Bạn ướp sườn với phần tỏi băm, hành tím băm, 1 muỗng cà phê hạt nêm, 1 muỗng cà phê muối, 2 muỗng canh mật ong, 2 muỗng canh tương cà, 1.5gr bột ngũ vị hương (khoảng 1/4 muỗng cà phê) và 3 muỗng canh dầu sa tế rồi trộn đều. Để thịt sườn thấm đậm đà, bạn ướp sườn với gia vị ít nhất 4 tiếng",
                100, 	1, 10.3, 7.3, null));

        foodList.add(new Food(11,
                "Thịt ức gà",
                "https://cdn.tgdd.vn/2020/12/content/3-800x500-6.jpg",
                165,
                "Với mục đích tăng cơ bắp thì thịt ức gà một loại thực phẩm không thể thiếu trong thực đơn.Đây không chỉ là thực phẩm giúp tăng cơ bắp mà còn rất tốt cho sức khỏe. Bởi thịt gà chứa lượng chất béo cực thấp, lại còn có thêm vitamin B niacin và B6.",
                "...",
                100, 0, 31, 3.6, null));

        foodList.add(new Food(12,
                "Thịt lợn nạc",
                "https://imgs.vietnamnet.vn/Images/2016/04/19/09/20160419090651-luoc-thit.jpg",
                143,
                "Là thành phần quan trọng giúp tăng cơ nhanh và an toàn, tốt cho sức khỏe. Thịt lợn nạc cũng chứa rất ít chất béo, tốt hơn nhiều so với việc sử dụng phần thịt lợn có chứa mỡ.",
                "...",
                100, 0, 19, 7, null));

        foodList.add(new Food(13,
                "Cá hồi",
                "https://cdn.tgdd.vn/Files/2021/01/19/1321272/tong-hop-nhung-cach-che-bien-ca-hoi-ngon-bo-duong-202112282310178876.jpg",
                208,
                "Cá hồi chứa nhiều protein và nhất là axit béo omega-3 và một số vitamin B quan trọng. Đây là thực phẩm mà người bình thường cũng nên sử dụng nhiều, thay thế cho thịt. Đối với các gymer thì đây là thực phẩm giúp tăng cơ bắp và tăng cường sức khỏe không thể thiếu trong thực đơn hàng ngày.",
                "...",
                100, 0, 20, 13, null));

        foodList.add(new Food(14,
                "Cá ngừ",
                "https://vfa.gov.vn/data/PHUNGHA_VFA/ca%20ngu%203.jpg",
                130,
                "Cá hồi chứa nhiều protein và nhất là axit béo omega-3 và một số vitamin B quan trọng. Đây là thực phẩm mà người bình thường cũng nên sử dụng nhiều, thay thế cho thịt. Đối với các gymer thì đây là thực phẩm giúp tăng cơ bắp và tăng cường sức khỏe không thể thiếu trong thực đơn hàng ngày.",
                "...",
                100, 0, 29, 0.6, null));

        foodList.add(new Food(15,
                "Súp cải bó xôi",
                "https://fado.vn/blog/wp-content/uploads/2022/04/sup-cai-bo-xoi-1.jpeg",
                115,
                "Cải bó xôi là một trong những loại rau củ quả chứa rất nhiều chất dinh dưỡng, chất khoáng cũng nhiều vitamin. Từ đó mà cải bó xôi được chế biến thành các món ăn khác nhau được mọi người yêu thích. Súp cải bó xôi thì mang hương vị thơm ngon, dễ ăn.",
                "...",
                120, 6, 15, 5, null));

        foodList.add(new Food(16,
                "Bánh chuối yến mạch",
                "https://cdn.shopify.com/s/files/1/2105/8233/files/banh-chuoi-yen-mach-oc-cho_1024x1024.jpg?v=1640145151",
                320,
                "Bánh chuối yến mạch là một loại bánh được làm từ bột yến mạch, chuối, trứng, đường, bơ, sữa và các loại gia vị. Bánh chuối yến mạch thường được xem là một thức ăn khá lành mạnh và giàu dinh dưỡng, vì chúng có chứa nhiều chất xơ, protein, kali, magiê và vitamin B.",
                "Bước 1 : Chuẩn bị 1 bát yến mạch, 1 quả trứng gà, 1 quả chuối, 20ml sữa tươi không đường, 20ml nước, mật ong\n" +
                        "Bước 2 : Chuối bóc vỏ, thái thành từng miếng nhỏ.\n" +
                        "Bước 3 : Đập trứng ra bát rồi đánh đều trứng lên.\n" +
                        "Bước 4 : Trộn đều trứng, sữa, nước và bột yến mạch.\n" +
                        "Bước 5 : Áp chảo thành những miếng bánh nhỏ vừa ăn bằng chảo chống dính.\n" +
                        "Bước 6 : Để nhỏ lửa, khi thấy trên bề mặt bánh xuất hiện nhiều lỗ nhỏ li ti thì lật bánh.\n" +
                        "Bước 7 : Để thêm khoảng 30 – 45 giây nữa rồi tắt bếp, cho bánh ra đĩa.\n" +
                        "Bước 8 : Thêm một ít mật ong vào để làm tăng thêm độ ngọt cho món ăn.",
                284, 38, 20, 15, null));

        foodList.add(new Food(17,
                "Khoai lang",
                "https://thucphamsachgreenhouse.com/upload/images/T%E1%BA%A1i%20sao%20trong%20kh%E1%BA%A9u%20ph%E1%BA%A7n%20%C4%83n%20c%E1%BB%A7a%20c%C3%A1c%20gymer%20th%C6%B0%E1%BB%9Dng%20c%C3%B3%20khoai%20lang-1.jpg",
                85.8,
                "Khoai lang chứa carbohydrate “sức mạnh” với hàm lượng calorie thấp, có thể duy trì năng lượng của bạn ở mức cao ngay cả sau một buổi tập luyện nặng. Nó cũng được xem là một “kho” chất xơ cần thiết cho việc đốt cháy chất béo, kiểm soát sự thèm ăn cũng như thúc đẩy tăng cơ bắp",
                "...",
                100, 20, 1.6, 0.1, null));

        foodList.add(new Food(18,
                "Bún mắm",
                "https://beptruong.edu.vn/wp-content/uploads/2018/11/bun-mam-co-them-thit-heo-quay.jpg",
                480,
                "Bún mắm là một trong số các món ăn đặc sản của miền tây Nam bộ Việt Nam. Bún mắm được nấu bằng mắm cá linh hay cá sặc, đây là các loại cá có nhiều tại miền Tây, đặc biệt là các tỉnh Trà Vinh và Sóc Trăng",
                "...",
                200, 56.8, 28.2, 15.5, null));

        foodList.add(new Food(19,
                "Bánh mì thịt",
                "data:image/jpeg;base64,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",
                500,
                "Bánh mì thịt: là loại bánh mì phổ biến nhất ở Sài Gòn, người bán bánh mì xẻ dọc ổ bánh mì và nhét thịt, chả, bơ, pa tê, giò thủ, thịt nguội, một ít hành ngò, rau, đồ chua và ớt.",
                "...",
                100, 25.47, 14.87, 6.9, null));

        foodList.add(new Food(20,
                "Bún chả",
                "https://thammyviennevada.com/wp-content/uploads/2020/10/an-bun-cha-co-beo-khong-1.jpg",
                390,
                "Bún mắm là một trong số các món ăn đặc sản của miền tây Nam bộ Việt Nam. Bún mắm được nấu bằng mắm cá linh hay cá sặc, đây là các loại cá có nhiều tại miền Tây, đặc biệt là các tỉnh Trà Vinh và Sóc Trăng",
                "...",
                120, 56.8, 28.2, 15.5, null));

        foodList.add(new Food(21,
                "Ái tình",
                "https://tfipost.com/wp-content/uploads/2021/12/close_up_advertisement_sushant_singh_rajput-750x375.jpg",
                850,
                "Trung bình, ái tình đốt cháy 150 đến 250 calo mỗi nửa giờ. Và nó rất nhiều niềm vui, tôi thấy ái tình là cỗ máy tập thể dục tuyệt vời nhất",
                "...",
                60, 0, 0, 0, null));

        foodList.add(new Food(22,
                "Tôm biển",
                "https://cdn.tgdd.vn/2021/09/CookProduct/61-1200x676.jpg",
                99,
                "Tôm chứa nguồn protein chất lượng cao, đặc biệt là ít chất béo và chứa lượng lớn axit amin leucine. Đây là những chất rất cần thiết cho sự tăng trưởng cơ bắp mà không quá nhiều calo. Tôm không chỉ ngon mà còn giàu dinh dưỡng, rất ít chất béo. Đây cũng là thực phẩm ăn kiêng được nhiều người lựa chọn.",
                "...",
                100, 0.2, 17.9, 0.3, null));

        foodList.add(new Food(23,
                "Đậu phộng",
                "https://songsachfood.com/wp-content/uploads/picture1_0.png",
                567.4,
                "Đậu phộng cũng là thực phẩm giúp tăng cơ bắp nhờ nguồn protein dồi dào và chất béo lành mạnh, tốt cho sức khỏe. Đậu phộng dễ ăn và chế kết hợp với các món ăn hàng ngày. Bạn cũng có thể dùng dầu dầu lạc thay thế các loại dầu mỡ khi chế biến thực phẩm hàng ngày. ",
                "...",
                100, 16, 26, 49, null));

        foodList.add(new Food(24,
                "Súp lơ xanh",
                "https://danviet.mediacdn.vn/296231569849192448/2022/12/28/rau-sup-lo-16722086832861423906513-1672271171847-1672271172876169805302.jpg",
                480,
                "Bông cải xanh (hoặc súp lơ xanh, cải bông xanh, Broccoli) là một loại cây thuộc loài Cải bắp dại, có hoa lớn ở đầu, thường được dùng như rau. Bông cải xanh thường được chế biến bằng cách luộc hoặc hấp, nhưng cũng có thể được ăn sống như là rau sống trong những đĩa đồ nguội khai vị.",
                "...",
                100, 7, 2.8, 0.4, null));

        foodList.add(new Food(25,
                "Qủa bơ",
                "https://images.baodantoc.vn/uploads/2023/Th%C3%A1ng%202/Ng%C3%A0y%208/Thanh/an-bo-da-tot-nhung-an-dung-thoi-diem-se-tot-hon-van-lan-202107131644096368.jpg",
                240,
                "Quả bơ được biết đến với thành phần dinh dưỡng cao, giàu vitamin và vi khoáng, hỗ trợ giảm cân. Hạt của nó được y học bản địa các nước như Peru, Nigeria sử dụng hỗ trợ sức khỏe phụ nữ.",
                "...",
                150, 13.5, 3, 22.5, null));

    }

    private void getActivityListData() {
        activityList = new ArrayList<>();
        //(int exerciseID, String exerciseName, String exerciseAvatar, double exerciseCalories,
        // double minutes, String exerciseDescription, String guide)
        activityList.add(new Activity(1, "Plank"
                ,"https://www.thethaothientruong.vn/uploads/2021/Plank-cai-thien-tu-the-khoe-dep.jpg"
                , 35, 1
                , "Plank là một bài tập giúp đốt mỡ và làm săn cơ bụng hàng đầu cực kỳ hiệu quả dành cho cả nam và nữ. Chỉ với động tác đơn giản, dễ nhớ, dễ làm theo mà không cần thêm bất cứ dụng cụ gì. "
                , "Bước 1: Chuẩn bị dụng cụ, Bạn nên chuẩn bị cho mình 1 thảm tập yoga để không bị đau tay khi bạn chống tay lúc plank.\n" +
                "Bước 2: Vào tư thế bò, Bạn đặt 2 tay dưới vai rồi để đầu gối dưới hông, bạn có thể đặt phẳng chân hoặc uốn ngón chân lại cho tư thế này. Nhớ duy trì nhịp thở đều.\n" +
                "Bước 3: Đưa người về tư thế em bé, chuyển ngay về tư thế em bé bằng cách đẩy mông về phía bàn chân, đùi bạn mở rộng bằng vai rồi từ từ đưa ngực hạ xuống sàn\n" +
                "Bước 4: Vào tư thế plank,  bạn phải tạo thành một đường thẳng từ đầu đến gót chân. Tay bạn để dưới 2 vai thẳng đứng, mũi chân chống xuống sàn. Bạn phải dùng lực để giữ cho cột sống và mông thẳng."));

        activityList.add(new Activity(2, "Chống đẩy"
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

        activityList.add(new Activity(3, "Plank"
                ,"https://cdn.thehinh.com/2019/06/64339804_6140715877001_2673110258309660672_n-1.png"
                , 11, 1
                , "Bơi lội là môn thể thao dưới nước, nhờ vào lực đẩy của nước và sự vận động của toàn thân, đặc biệt là chân và tay mà người bơi có thể di chuyển cơ thể dưới nước với một tốc độ nhất định. Bơi lội là môn thể thao dành cho mọi người ở mọi lứa tuổi và không quá tốn kém, giúp bạn cải thiện được sức khỏe, thậm chí là tinh thần."
                , "Bước 1: Nín thở dưới nước – Một trong những hướng dẫn đầu tiên khi bạn học bơi\n" +
                "Bước 2: Hít thở dưới nước – Yếu tố quan trọng thứ hai cần lưu ý trong hướng dẫn học bơi\n" +
                "Bước 3: Khi tập bơi đừng quên kỹ năng nổi dưới nước và lướt nước\n" +
                "Bước 4: Hướng dẫn học bơi an toàn - Chọn nơi dạy bơi lội uy tín, học phí hợp lý cho người mới bắt đầu"));

        activityList.add(new Activity(4, "Đạp xe"
                ,"https://cdn.tgdd.vn/Files/2022/05/10/1431463/moi-ngay-nen-dap-xe-bao-nhieu-km-dap-bao-lau-.jpg"
                , 5, 1
                , "Đi xe đạp là môn thể thao tốt cho sức khỏe giúp rèn luyện thể chất, cải thiện tim phổi. Tuy nhiên nhiều người thường xuyên đi xe đạp chưa hẳn đã biết đạp xe đạp đúng cách."
                , "Bước 1: Ăn uống trước khi đạp xe đạp là một điều cần thiết, bởi khi đạp xe cơ thể bạn tiêu hao khá nhiều năng lượng và mất sức,\n" +
                "Bước 2: Tất cả các thời gian trong ngày đều có thể đạp xe, nhưng thời gian lý tưởng để đạp xe là vào buổi sáng sớm trước khi ăn bữa đầu tiên trong ngày.\n" +
                "Bước 3: Tư thế đạp xe vừa thoải mái vừa đúng cách, là tư thế ngồi hơi nghiêng về phía trước, giữ tay hơi cong cong trong lúc đạp xe, vì khi tay hơi cong nó cho phép các cơ phần trên và khớp lưng cảm nhận độ rung, phân tán lực, ít gây ảnh hưởng đến cột sống. Khi đạp xe giữ chân ở góc 90 độ, nó tốt cho phần hông của bạn tránh các trường hợp đau cơ.\n" +
                "Bước 4: đạp xe đúng cách, chính xác đảm bảo sức khỏe gồm 4 bước: đạp, kéo, nâng, đẩy. Chân đạp nhẹ nhàng xuống dưới, dùng lực bàn chân kéo lên trên rồi nâng bàn đạp, rồi nhẹ nhàng đẩy xuống, những động tác được lặp đi lặp lại, đúng nhịp với tần suất đạp đều nhau, giúp đẩy nhanh tốc độ."));


        activityList.add(new Activity(5, "Side Plank"
                ,"https://hips.hearstapps.com/hmg-prod/images/side-plank-1549646915.jpg"
                , 7, 1
                , "Side Plank à một cách tuyệt vời để đốt cháy nhiều calo và làm săn chắc cơ bụng của bạn cùng một lúc "
                , "Bước 1 : Nằm nghiêng với đầu gối cong và chống phần trên cơ thể lên trên khuỷu tay.\n" +
                "Bước 2: Nâng hông lên khỏi sàn và giữ trong 1 phút\n" +
                "Bước 3: Nghỉ ngơi trong 10 giây.\n" +
                "Bước 4: Chuyển sang phía bên kia của bạn và lặp lại."));

        activityList.add(new Activity(6, "Mountain Climbers"
                ,"https://static.toiimg.com/photo/76379955.cms"
                , 10, 1
                , "Mountain Climbers hay Running Plank - là một bài tập thể dục rất tốt để xây dựng sức bền tim mạch, sức mạnh cốt lõi và sự nhanh nhẹn. Bạn tập luyện nhiều nhóm cơ khác nhau với vận động viên leo núi—nó gần giống như tập luyện toàn thân chỉ với một bài tập."
                ,
                "Bước 1 : Chống cả hai tay và đầu gối xuống sàn.\n" +
                        "Bước 2: Đặt chân phải của bạn gần bàn tay phải của bạn và mở rộng chân trái của bạn phía sau bạn.\n" +
                        "Bước 3 : Trong một chuyển động trơn tru, đổi chân của bạn, giữ cánh tay của bạn ở cùng một vị trí"));

        activityList.add(new Activity(7, "Bridge"
                ,"https://i0.wp.com/post.greatist.com/wp-content/uploads/sites/2/2020/06/GRT_Bridge_Pose_Yoga-1296x728-HEader.jpg?w=1155&h=1528"
                , 15, 2
                , "Bridge giúp tăng cường sức mạnh cho cơ mông (mông) và gân kheo (mặt sau của đùi) đồng thời tăng cường sự ổn định của lõi."
                , "Bước 1 : Nằm ngửa với đầu gối cong. Thắt chặt các cơ trong dạ dày của bạn. \n" +
                "Bước 2 : Nâng hông lên khỏi sàn cho đến khi chúng thẳng hàng với đầu gối và vai của bạn. Giữ trong ba nhịp thở sâu."));

        activityList.add(new Activity(8, "Burpees"
                ,"https://www.ericfavre.com/lifestyle/uk/wp-content/uploads/sites/15/2021/09/burpees-1024x437-1.jpg"
                , 10, 1
                , "Burpees cực kỳ hiệu quả như một công cụ tập luyện, kết hợp tập luyện tim mạch và rèn luyện sức mạnh thành một gói cường độ cực cao. Trong bảy động tác đơn giản, bài tập vận động cơ thể bạn từ trên xuống dưới."
                , "Bước 1 : Bắt đầu ở tư thế đứng. Đặt hai bàn chân của bạn rộng bằng vai. Giữ lưng thẳng, ngực ưỡn ra và hai cánh tay ở hai bên.\n" +
                "Bước 2 : Ngồi xổm. Cong đầu gối của bạn, đẩy chúng ra ngoài một chút so với ngón chân của bạn, đồng thời hạ mông xuống. Giữ cho bàn chân của bạn bằng phẳng trên sàn nhà. Đặt hai bàn tay của bạn trên sàn (lòng bàn tay hướng xuống) trước bàn chân của bạn.\n" +
                "Bước 3 : Đá chân trở lại tư thế plank cao. Cơ thể của bạn phải nằm trên một đường thẳng từ vai đến gót chân. Khóa cánh tay của bạn tại chỗ. Giữ đầu thẳng, mắt hơi nhìn về phía trước.\n" +
                "Bước 4 : Thấp dần về phía mặt đất. Cong khuỷu tay của bạn và đưa cơ thể của bạn về phía sàn nhà. (Về cơ bản, phần dưới cùng của động tác chống đẩy.) Giữ cơ thể thẳng và căng cơ.\n" +
                "Bước 5 : Trở lại tư thế plank cao. Tập trung vào việc giữ cho cơ thể của bạn thẳng.\n" +
                "Bước 6 : Trở lại tư thế ngồi xổm. Nhảy hai chân về phía trước. Khi bạn hạ cánh, hãy chắc chắn rằng bàn chân của bạn bằng phẳng trên sàn nhà. (Vị trí của bạn ở cuối nước đi này phải giống như ở Bước 2.)\n" +
                "Bước 7 : Nhảy! Giơ hai tay lên khi bạn phóng lên trần nhà. “Đó phải là một cú nhảy bùng nổ,” Nykor nói. Hạ cánh ở vị trí đứng ban đầu rồi quay lại Bước 1 và bắt đầu lại quá trình."));


        activityList.add(new Activity(9, "Crunches"
                ,"https://hips.hearstapps.com/hmg-prod/images/bicycle-crunch-1548880579.jpg"
                , 6, 1
                , "Crunches là một bài tập cốt lõi cổ điển. Nó đặc biệt rèn luyện cơ bụng của bạn, là một phần cốt lõi của bạn."
                , "Bước 1 : Nằm ngửa. Đặt hai chân trên sàn, rộng bằng hông. Cong đầu gối của bạn và đặt cánh tay của bạn trên ngực của bạn. Hợp đồng cơ bụng của bạn và hít vào.\n" +
                "Bước 2 : Thở ra và nâng phần thân trên lên, giữ cho đầu và cổ thư giãn.\n" +
                "Bước 3 : Hít vào và trở lại vị trí bắt đầu."));

        activityList.add(new Activity(10, "Jumping Jack"
                ,"https://media.istockphoto.com/id/1264250327/video/woman-exercising-at-home-woman-doing-fitness-legs-training-at-home-woman-doing-jumping-jacks.jpg?s=640x640&k=20&c=EVoJYCqE4GoO95O453gM6kGAL02mgpX77_mzh9NqI6Y="
                , 9, 1
                , "Jumping Jack hay là hãy nhảy đi Jack,được biết đến là một bài tập cardio giảm cân cường độ cao giúp tăng nhịp tim và đốt cháy calo nhanh chóng"
                ,
                "Bước 1 : Đứng thẳng, hai chân chụm lại, hai tay để dọc hai bên người.\n" +
                        "Bước 2 : Khuỵu nhẹ đầu gối và nhảy lên không trung.\n" +
                        "Bước 3 : Khi nhảy, dang rộng hai chân rộng bằng vai. Duỗi hai tay ra và qua đầu.\n" +
                        "Bước 4 : Nhảy trở lại vị trí bắt đầu.\n" +
                        "Bước 5 : Lặp lại."));

        activityList.add(new Activity(11, "Lunges"
                ,"https://cdn.thehinh.com/2019/06/64339804_6140715877001_2673110258309660672_n-1.png"
                , 5, 1
                , "Lunches là một trong những bài tập thân dưới hiệu quả nhất mà bạn có thể thực hiện. Chúng giúp làm săn chắc, tăng cường sức mạnh và định hình đôi chân cũng như cơ mông của bạn, đồng thời cải thiện tính linh hoạt của hông. Lunge hoạt động đồng thời nhiều nhóm cơ, tăng tốc độ trao đổi chất và giúp giảm cân"
                , "Bước 1 : Đứng hai chân rộng bằng hông, giữ thẳng lưng, vai hướng về phía sau và siết cơ bụng.\n" +
                "Bước 2 : Bước một bước về phía trước và từ từ uốn cong cả hai đầu gối, cho đến khi đầu gối sau của bạn ở ngay trên sàn.\n" +
                "Bước 3 : Đứng lên và lặp lại động tác.\n" +
                "Bước 4 : Đổi chân cho đến khi hoàn thành bộ."));

        activityList.add(new Activity(12, "Squat"
                ,"https://www.stylecraze.com/wp-content/uploads/2017/11/1.Pulse-Squat.jpg"
                , 7, 1
                , "Squats được coi là một bài tập quan trọng để tăng sức mạnh và kích thước của cơ bắp phần dưới cơ thể cũng như phát triển sức mạnh cốt lõi"
                , "Bước 1: Đứng thẳng, hai chân rộng bằng hông. \n" +
                "Bước 2: Siết cơ bụng. \n" +
                "Bước 3: Hạ người xuống, giống như đang ngồi trên một chiếc ghế vô hình. \n" +
                "Bước 4: Duỗi thẳng chân để nâng người lên.\n" +
                "Bước 5: Lặp lại động tác."));
        
        activityList.add(new Activity(13, "Tai Chi"
                ,"https://justbreathetaichi.com/wp-content/uploads/2021/12/tai-chi-classes.jpg"
                , 121, 30
                , "Tai Chi hay Thái Cực Quyền, là bài tập liên quan đến dòng chảy chuyển động chậm - và cùng với đó là một loạt các lợi ích về sức khỏe, bao gồm khả năng giữ thăng bằng, khả năng vận động và khả năng phối hợp tốt hơn. Tai chi (còn được gọi là tai chi chuan hoặc tai ji quan) là một bài tập thể chất kết hợp các động tác, thiền định và hít thở sâu"
                , "Bước 1: Ngồi khép 2 chân vào nhau.\n" +
                "Bước 2: Đặt 2 tay lên 2 gối và xòe bàn tay ra\n" +
                "Bước 3: Hít 1 hơi sâu rồi thở đều\n" +
                "Bước 4: Nghe tôi này, thở đi. Thở. Cảm nhận không khí. Cảm nhận gió đó trên khuôn mặt của bạn. Cảm nhận mặt đất, bàn chân nâng bạn lên, đẩy bạn về phía trước và tia sét - cảm nhận tia sét. Cảm nhận sức mạnh của nó. Đó là dòng điện chạy qua huyết quản của bạn, chạy róc rách trong người bạn, truyền đến mọi dây thần kinh trong cơ thể bạn, giống như một cú sốc. Bây giờ bạn không còn là bạn nữa. Bạn là một phần của một cái gì đó lớn hơn. Bạn là một phần của lực lượng tốc độ. Bạn có thể làm được việc này. Nó là của bạn"));

        activityList.add(new Activity(14, "Reverse Crunches"
                ,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQU2EBFaeEsusut9p8VRzWEKDzaWul3sdU_1A&usqp=CAU"
                , 4, 1
                , "Reverse Crunches (gập bụng ngược) giúp tăng sức mạnh và độ nét của cơ bụng, đồng thời cải thiện độ ổn định của lõi và lưng dưới. Bài tập này tác động đến các lớp dưới của cơ bụng, cơ ngang bụng, còn được gọi là cơ corset, giúp bạn có bụng phẳng và hỗ trợ lưng tuyệt vời "
                ,
                "Bước 1 : Nằm ngửa với hai tay để dọc hai bên.\n" +
                        "Bước 2 : Nâng hông và đưa đầu gối về phía ngực càng xa càng tốt.\n" +
                        "Bước 3 : Giữ và sau đó từ từ trở lại vị trí bắt đầu.\n" +
                        "Bước 4 : Lặp lại."));

        activityList.add(new Activity(15, "Heel Touch"
                ,"https://homeworkouts.org/wp-content/uploads/hero-alternate-heel-touches2.jpg"
                , 10, 1
                , "Heel touch (Chạm gót chân), là một bài tập cô lập đặc trưng nhắm vào cơ xiên và cơ bụng trực tràng (cơ bụng)"
                , "Bước 1 : Nằm xuống sàn hoặc thảm. Hai chân của bạn co lại, bàn chân đặt trên mặt sàn, hai chân dang rộng hơn vai. Hai tay đặt dọc theo thân người. Đầu, cổ và vai hơi nâng lên khỏi mặt sàn, thả lỏng và tập trung vào vùng bụng.\n" +
                "Bước 2 : Ngã người sang bên phải, tay phải cố gắng chạm vào gót chân phải.\n" +
                "Bước 3 : Ngã người về phía bên còn lại và tay trái cố gắng chạm vào gót chân trái.\n" +
                "Bước 4 : Lặp lại đều 2 bên"));

        activityList.add(new Activity(16, "Russian Twist"
                ,"https://hips.hearstapps.com/hmg-prod/images/russian-twist-sharpened-1548270008.jpg?crop=1.00xw:1.00xh;0,0&resize=1200:*"
                , 4, 1
                , "Russian Twist (vặn người kiểu Nga) là một bài tập tuyệt vời để xây dựng sức mạnh cơ vai và cơ vai"
                , "Bước 1 : Ngồi trên thảm, nhấc cả hai chân lên, giữ cho đầu gối gập và ngả người về phía sau một chút. 10 ngón tay đan nhẹ hoặc chụm vào nhau và đặt phía trước mặt để giữ thăng bằng cơ thể của bạn.\n" +
                "Bước 2 : Vặn phần vai và hông của bạn sang trái, sau đó vặn sang phải."));

        activityList.add(new Activity(17, "Single Leg Hopping"
                ,"https://s3assets.skimble.com/assets/2791/skimble-workout-trainer-exercise-side-to-side-single-leg-hops-2_iphone.jpg"
                , 20, 10
                , "Single Leg Hopping hay nhảy lò cò 1 chân, là một trong những bài tập tốt nhất để tăng chiều cao mà còn thực sự thú vị. Bài tập tăng chiều cao này đóng vai trò rất lớn trong việc tăng cường cơ bụng và hứa hẹn một bài tập toàn diện cho phần thân dưới của bạn."
                , "Bước 1 : Nhảy lên chân trái của bạn mười lần.\n" +
                "Bước 2 : Đặt tay thẳng lên hướng lên trời.\n" +
                "Bước 3 : Lặp lại tương tự với chân phải"));

        activityList.add(new Activity(18, "Child Pose"
                ,"https://media.istockphoto.com/id/1189331308/photo/lets-get-loose.jpg?s=612x612&w=0&k=20&c=WL4LSB79Tmsv6hHlZ3mrE3-iLt3OZou_pANeV8vjiqI="
                , 5, 10
                , "Child Pose (giản cơ tư tế đứa trẻ), là một bài tập rất tuyệt vời trong việc kéo giãn nhẹ nhàng các bộ phận khác nhau trên cơ thể bạn, từ đó giúp giảm đau lưng và tăng chiều cao. Bài tập tăng chiều cao này nhẹ nhàng kéo giãn cột sống của bạn, cải thiện lưu thông máu trong cơ thể và giảm căng cơ ở lưng dưới."
                , "Bước 1 : Quỳ trên sàn với mông ép vào gót chân.\n" +
                "Bước 2 : Đặt hai tay lên đùi, hạ người xuống đùi và cúi người về phía trước với hai cánh tay duỗi thẳng trên sàn.\n" +
                "Bước 3: Tựa trán xuống sàn, thả lỏng cơ thể và tập trung vào hơi thở."));

        activityList.add(new Activity(19, "Puppy Pose"
                ,"https://yogajala.com/wp-content/uploads/2022/09/yogajala-pose-photos-mary-2-2.jpg"
                , 5, 10
                , "Puppy Pose - bài tập tăng chiều cao này giúp uốn cong cột sống, cơ chân và làm cho xương của bạn dài ra."
                , "Bước 1 : Bắt đầu với việc định vị tất cả bốn chân của bạn - bàn tay và đầu gối - trên thảm.\n" +
                "Bước 2 : Đặt đầu gối thẳng hàng với hông và hai tay ngang vai.\n" +
                "Bước 3 : Quấn ngón chân của bạn và di chuyển bàn tay của bạn về phía trước một vài inch.\n" +
                "Bước 4 : Duỗi hông về phía sau nửa bàn chân và cảm thấy phần dưới cơ thể được kéo căng tốt.\n" +
                "Bước 5 : Giữ tư thế này trong 60 giây và thư giãn.\u200D"));

        activityList.add(new Activity(20, "Lying Down Body Twist"
                ,"https://www.doyou.com/wp-content/uploads/2021/01/How-To-Do-Reclined-Spinal-Twist-Pose.jpg"
                , 5, 10
                , "Đây là một bài tập tăng chiều cao hiệu quả khác giúp kéo giãn cột sống và săn chắc cơ cổ và bụng. Bài tập tăng chiều cao này còn kéo dài và tăng cường sự săn chắc của cơ vùng lưng dưới và hông, từ đó giúp tăng chiều cao."
                , "Bước 1 : Nằm ngửa, hai tay duỗi thẳng trước mặt, song song với vai.\n" +
                "Bước 2 : Cong đầu gối của bạn cho đến khi chúng gần bằng hông của bạn, sau đó đung đưa chúng cho đến khi chúng chạm đất.\n" +
                "Bước 3 : Quay đầu sang phải và nhìn vào lòng bàn tay phải nếu đầu gối trái của bạn đặt trên sàn.\n" +
                "Bước 4 : Kéo căng cơ thể và tập trung vào hơi thở của bạn."));

        activityList.add(new Activity(21, "Camel Pose"
                ,"https://global-uploads.webflow.com/5ca5fe687e34be0992df1fbe/62a4f8a84f744998ac9cfccc_CompressJPEG.Online_1_100kb_32.jpg"
                , 5, 10
                , "Camel Pose (tư thế lạc đà) là một trong những bài tập hiệu quả nhất để tăng chiều cao nhanh chóng. Tư thế liên quan đến việc uốn cong cổ của bạn về phía sau và kéo căng bụng và ngực của bạn. Tư thế này có hiệu quả cao trong việc kéo căng cơ gấp hông sâu, nâng cao tư thế và tăng cường cơ lưng."
                , "Bước 1 : Quỳ trên sàn và đưa xương cụt của bạn về phía quán rượu bằng cách đứng trên đầu gối của bạn.\n" +
                "Bước 2 : Giữ lưng cong và cánh tay thẳng trong khi trượt lòng bàn tay qua bàn chân.\n" +
                "Bước 3 : Giữ nguyên tư thế trong vài giây và dần dần trở lại tư thế ban đầu."));

        activityList.add(new Activity(22, "Alternate Leg Kick"
                ,"https://global-uploads.webflow.com/5ca5fe687e34be0992df1fbe/6296071ab92ea029fb30ca3a_9WYArYa6PL_mV7-XA-5iJeK-L5cA4HpOyJR5yRcrbHS6hYvw9iFRVGvAU6p9h-o0NGGRYlbUhrjYQ4UAPhIW1iziHEkc3cBH9qPEz8VnWzN6fkJPI6tTaGZGuOzad2abLTFTKWii8Gr9AaDWGw.jpeg"
                , 18, 5
                , "Alternate Leg Kick (đá chân luân phiên) - Bài tập này bắt nguồn từ “Tae Kwon Do” - môn võ thuật của Hàn Quốc, đặc trưng bởi những cú đá chân. Mặc dù bài tập là một động tác phòng thủ nhưng nó giúp tăng chiều cao của bạn. Nó giúp kéo dài các cơ trên cơ thể bạn, đặc biệt là ở chân."
                , "Bước 1 : Bắt đầu bằng cách đứng thẳng trên thảm trong tư thế thẳng.\n" +
                "Bước 2 : Duỗi cơ thể tối đa đồng thời duỗi thẳng chân phải lên.\n" +
                "Bước 3 : Giữ hai bàn tay của bạn gần ngực với nắm đấm của bạn.\n" +
                "Bước 4 : Bắt đầu đá lên trời trong khoảng 30 giây và lặp lại quá trình này với chân trái của bạn."));

        activityList.add(new Activity(23, "Jump Squats"
                ,"https://global-uploads.webflow.com/5ca5fe687e34be0992df1fbe/6296071aeb11a8c95bb3121f_Rx08NKoMR_k-e6sRmqPxX6g6EANbijiSpZffVDozZ4C7vSTdLqu1GV-wqYfC5HdulF1I_TyYtCcf7-6yWjHqTzYTzeR8vRUe7zE5H4DdrvJ2kfRGqnv2MCVKOm7dr1iuAcYF8_1vJiIRGFovmg.jpeg"
                , 100, 1
                , "Các bài tập nhảy, như nhảy squats, là một trong những cách tốt nhất để tăng chiều cao. Nó hỗ trợ điều hòa các cơ và khớp của phần dưới cơ thể và cải thiện chiều cao của cơ thể."
                , "Bước 1 : Bắt đầu với tư thế đứng bình thường, với cơ thể hướng về phía trước.\n" +
                "Bước 2 : Hạ người xuống tư thế ngồi xổm bằng cách hạ hông xuống trong khi uốn cong đầu gối.\n" +
                "Bước 3 : Đẩy mạnh bằng chân khi bạn đứng dậy khỏi tư thế ngồi xổm trong khi bắt đầu nhảy."));

        activityList.add(new Activity(24, "Seated Forward Bend"
                ,"https://global-uploads.webflow.com/5ca5fe687e34be0992df1fbe/62a50a8e2ff260eff569823a_CompressJPEG.Online_1_100kb_8489.jpg"
                , 5, 10
                , "Bài tập này tạo áp lực lên cơ đùi sau và cổ, từ đó giúp tăng chiều cao cho bạn. Tuy nhiên, nên tránh tư thế này nếu bạn có vấn đề về đau lưng hoặc đang bị trượt đĩa đệm hoặc đau thần kinh tọa."
                , "Bước 1 : Ngồi trên sàn, duỗi thẳng chân, cúi người về phía trước và cố gắng dùng tay giữ các ngón chân.\n" +
                "Bước 2 : Bây giờ, giữ thẳng lưng và cố gắng tựa đầu lên đầu gối."));

        activityList.add(new Activity(25, "Downward Facing Dog"
                ,"https://global-uploads.webflow.com/5ca5fe687e34be0992df1fbe/5d95d686b9756bfd80d61ffe_downward%2520facing%2520dog.jpeg"
                , 5, 1
                , "Bài tập này là là một trong những cách kéo dài tốt nhất để phát triển chiều cao. Bài tập này giúp tăng cường sức mạnh cho toàn bộ lưng và kéo dài cơ lưng của bạn."
                , "Bước 1 : Đứng lên và uốn cong cơ thể sao cho hai tay rộng bằng vai và hai bàn chân rộng bằng hông.\n" +
                "Bước 2 : Đẩy sàn ra xa và thu hút vai và thân trên đồng thời kéo dài xương cụt về phía trần nhà\n" +
                "Bước 3 : Cảm nhận sự kéo giãn nhẹ nhàng ở cánh tay, vai, xô và cột sống."));

    }

    private void getListExercise() {
        exercisekList = new ArrayList<>();
        Exercisek k;
        for (Activity item: activityList) {
            k = new Exercisek();
            k.setExerciseID(item.getActivityID());
            k.setExerciseName(item.getActivityName());
            k.setExerciseAvatar(item.getActivityAvatar());
            k.setExerciseDescription(item.getActivityDescription());
            k.setExerciseCalories(item.getActivityCalories());
            k.setGuide(item.getGuide());
            k.setMinutes(item.getMinutes());
            exercisekList.add(k);
        }
    }
}
