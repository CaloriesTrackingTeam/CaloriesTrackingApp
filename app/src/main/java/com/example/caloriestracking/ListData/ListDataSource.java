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
                        "Bước 5: Làm đồ chua\n" +
                        "Bước 6: Làm mỡ hành",
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

        activityList.add(new Activity(3, "Bơi lội"
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

    }

    private void getListExercise() {
        exercisekList = new ArrayList<>();
        //(int exerciseID, String exerciseName, String exerciseAvatar, double exerciseCalories,
        // double minutes, String exerciseDescription, String guide)
        exercisekList.add(new Exercisek(1, "Plank"
                ,"https://www.thethaothientruong.vn/uploads/2021/Plank-cai-thien-tu-the-khoe-dep.jpg"
                , 35, 1
                , "Plank là một bài tập giúp đốt mỡ và làm săn cơ bụng hàng đầu cực kỳ hiệu quả dành cho cả nam và nữ. Chỉ với động tác đơn giản, dễ nhớ, dễ làm theo mà không cần thêm bất cứ dụng cụ gì. "
                , "Bước 1: Chuẩn bị dụng cụ, Bạn nên chuẩn bị cho mình 1 thảm tập yoga để không bị đau tay khi bạn chống tay lúc plank.\n" +
                "Bước 2: Vào tư thế bò, Bạn đặt 2 tay dưới vai rồi để đầu gối dưới hông, bạn có thể đặt phẳng chân hoặc uốn ngón chân lại cho tư thế này. Nhớ duy trì nhịp thở đều.\n" +
                "Bước 3: Đưa người về tư thế em bé, chuyển ngay về tư thế em bé bằng cách đẩy mông về phía bàn chân, đùi bạn mở rộng bằng vai rồi từ từ đưa ngực hạ xuống sàn\n" +
                "Bước 4: Vào tư thế plank,  bạn phải tạo thành một đường thẳng từ đầu đến gót chân. Tay bạn để dưới 2 vai thẳng đứng, mũi chân chống xuống sàn. Bạn phải dùng lực để giữ cho cột sống và mông thẳng."));

        exercisekList.add(new Exercisek(2, "Chống đẩy"
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

        exercisekList.add(new Exercisek(3, "Plank"
                ,"https://cdn.thehinh.com/2019/06/64339804_6140715877001_2673110258309660672_n-1.png"
                , 11, 1
                , "Bơi lội là môn thể thao dưới nước, nhờ vào lực đẩy của nước và sự vận động của toàn thân, đặc biệt là chân và tay mà người bơi có thể di chuyển cơ thể dưới nước với một tốc độ nhất định. Bơi lội là môn thể thao dành cho mọi người ở mọi lứa tuổi và không quá tốn kém, giúp bạn cải thiện được sức khỏe, thậm chí là tinh thần."
                , "Bước 1: Nín thở dưới nước – Một trong những hướng dẫn đầu tiên khi bạn học bơi\n" +
                "Bước 2: Hít thở dưới nước – Yếu tố quan trọng thứ hai cần lưu ý trong hướng dẫn học bơi\n" +
                "Bước 3: Khi tập bơi đừng quên kỹ năng nổi dưới nước và lướt nước\n" +
                "Bước 4: Hướng dẫn học bơi an toàn - Chọn nơi dạy bơi lội uy tín, học phí hợp lý cho người mới bắt đầu"));

        exercisekList.add(new Exercisek(4, "Đạp xe"
                ,"https://cdn.tgdd.vn/Files/2022/05/10/1431463/moi-ngay-nen-dap-xe-bao-nhieu-km-dap-bao-lau-.jpg"
                , 5, 1
                , "Đi xe đạp là môn thể thao tốt cho sức khỏe giúp rèn luyện thể chất, cải thiện tim phổi. Tuy nhiên nhiều người thường xuyên đi xe đạp chưa hẳn đã biết đạp xe đạp đúng cách."
                , "Bước 1: Ăn uống trước khi đạp xe đạp là một điều cần thiết, bởi khi đạp xe cơ thể bạn tiêu hao khá nhiều năng lượng và mất sức,\n" +
                "Bước 2: Tất cả các thời gian trong ngày đều có thể đạp xe, nhưng thời gian lý tưởng để đạp xe là vào buổi sáng sớm trước khi ăn bữa đầu tiên trong ngày.\n" +
                "Bước 3: Tư thế đạp xe vừa thoải mái vừa đúng cách, là tư thế ngồi hơi nghiêng về phía trước, giữ tay hơi cong cong trong lúc đạp xe, vì khi tay hơi cong nó cho phép các cơ phần trên và khớp lưng cảm nhận độ rung, phân tán lực, ít gây ảnh hưởng đến cột sống. Khi đạp xe giữ chân ở góc 90 độ, nó tốt cho phần hông của bạn tránh các trường hợp đau cơ.\n" +
                "Bước 4: đạp xe đúng cách, chính xác đảm bảo sức khỏe gồm 4 bước: đạp, kéo, nâng, đẩy. Chân đạp nhẹ nhàng xuống dưới, dùng lực bàn chân kéo lên trên rồi nâng bàn đạp, rồi nhẹ nhàng đẩy xuống, những động tác được lặp đi lặp lại, đúng nhịp với tần suất đạp đều nhau, giúp đẩy nhanh tốc độ."));


        //-------------LOOP
        exercisekList.add(new Exercisek(1, "Plank"
                ,"https://www.thethaothientruong.vn/uploads/2021/Plank-cai-thien-tu-the-khoe-dep.jpg"
                , 35, 1
                , "Plank là một bài tập giúp đốt mỡ và làm săn cơ bụng hàng đầu cực kỳ hiệu quả dành cho cả nam và nữ. Chỉ với động tác đơn giản, dễ nhớ, dễ làm theo mà không cần thêm bất cứ dụng cụ gì. "
                , "Bước 1: Chuẩn bị dụng cụ, Bạn nên chuẩn bị cho mình 1 thảm tập yoga để không bị đau tay khi bạn chống tay lúc plank.\n" +
                "Bước 2: Vào tư thế bò, Bạn đặt 2 tay dưới vai rồi để đầu gối dưới hông, bạn có thể đặt phẳng chân hoặc uốn ngón chân lại cho tư thế này. Nhớ duy trì nhịp thở đều.\n" +
                "Bước 3: Đưa người về tư thế em bé, chuyển ngay về tư thế em bé bằng cách đẩy mông về phía bàn chân, đùi bạn mở rộng bằng vai rồi từ từ đưa ngực hạ xuống sàn\n" +
                "Bước 4: Vào tư thế plank,  bạn phải tạo thành một đường thẳng từ đầu đến gót chân. Tay bạn để dưới 2 vai thẳng đứng, mũi chân chống xuống sàn. Bạn phải dùng lực để giữ cho cột sống và mông thẳng."));

        exercisekList.add(new Exercisek(2, "Chống đẩy"
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

        exercisekList.add(new Exercisek(3, "Plank"
                ,"https://cdn.thehinh.com/2019/06/64339804_6140715877001_2673110258309660672_n-1.png"
                , 11, 1
                , "Bơi lội là môn thể thao dưới nước, nhờ vào lực đẩy của nước và sự vận động của toàn thân, đặc biệt là chân và tay mà người bơi có thể di chuyển cơ thể dưới nước với một tốc độ nhất định. Bơi lội là môn thể thao dành cho mọi người ở mọi lứa tuổi và không quá tốn kém, giúp bạn cải thiện được sức khỏe, thậm chí là tinh thần."
                , "Bước 1: Nín thở dưới nước – Một trong những hướng dẫn đầu tiên khi bạn học bơi\n" +
                "Bước 2: Hít thở dưới nước – Yếu tố quan trọng thứ hai cần lưu ý trong hướng dẫn học bơi\n" +
                "Bước 3: Khi tập bơi đừng quên kỹ năng nổi dưới nước và lướt nước\n" +
                "Bước 4: Hướng dẫn học bơi an toàn - Chọn nơi dạy bơi lội uy tín, học phí hợp lý cho người mới bắt đầu"));

        exercisekList.add(new Exercisek(4, "Đạp xe"
                ,"https://cdn.tgdd.vn/Files/2022/05/10/1431463/moi-ngay-nen-dap-xe-bao-nhieu-km-dap-bao-lau-.jpg"
                , 5, 1
                , "Đi xe đạp là môn thể thao tốt cho sức khỏe giúp rèn luyện thể chất, cải thiện tim phổi. Tuy nhiên nhiều người thường xuyên đi xe đạp chưa hẳn đã biết đạp xe đạp đúng cách."
                , "Bước 1: Ăn uống trước khi đạp xe đạp là một điều cần thiết, bởi khi đạp xe cơ thể bạn tiêu hao khá nhiều năng lượng và mất sức,\n" +
                "Bước 2: Tất cả các thời gian trong ngày đều có thể đạp xe, nhưng thời gian lý tưởng để đạp xe là vào buổi sáng sớm trước khi ăn bữa đầu tiên trong ngày.\n" +
                "Bước 3: Tư thế đạp xe vừa thoải mái vừa đúng cách, là tư thế ngồi hơi nghiêng về phía trước, giữ tay hơi cong cong trong lúc đạp xe, vì khi tay hơi cong nó cho phép các cơ phần trên và khớp lưng cảm nhận độ rung, phân tán lực, ít gây ảnh hưởng đến cột sống. Khi đạp xe giữ chân ở góc 90 độ, nó tốt cho phần hông của bạn tránh các trường hợp đau cơ.\n" +
                "Bước 4: đạp xe đúng cách, chính xác đảm bảo sức khỏe gồm 4 bước: đạp, kéo, nâng, đẩy. Chân đạp nhẹ nhàng xuống dưới, dùng lực bàn chân kéo lên trên rồi nâng bàn đạp, rồi nhẹ nhàng đẩy xuống, những động tác được lặp đi lặp lại, đúng nhịp với tần suất đạp đều nhau, giúp đẩy nhanh tốc độ."));


        exercisekList.add(new Exercisek(1, "Plank"
                ,"https://www.thethaothientruong.vn/uploads/2021/Plank-cai-thien-tu-the-khoe-dep.jpg"
                , 35, 1
                , "Plank là một bài tập giúp đốt mỡ và làm săn cơ bụng hàng đầu cực kỳ hiệu quả dành cho cả nam và nữ. Chỉ với động tác đơn giản, dễ nhớ, dễ làm theo mà không cần thêm bất cứ dụng cụ gì. "
                , "Bước 1: Chuẩn bị dụng cụ, Bạn nên chuẩn bị cho mình 1 thảm tập yoga để không bị đau tay khi bạn chống tay lúc plank.\n" +
                "Bước 2: Vào tư thế bò, Bạn đặt 2 tay dưới vai rồi để đầu gối dưới hông, bạn có thể đặt phẳng chân hoặc uốn ngón chân lại cho tư thế này. Nhớ duy trì nhịp thở đều.\n" +
                "Bước 3: Đưa người về tư thế em bé, chuyển ngay về tư thế em bé bằng cách đẩy mông về phía bàn chân, đùi bạn mở rộng bằng vai rồi từ từ đưa ngực hạ xuống sàn\n" +
                "Bước 4: Vào tư thế plank,  bạn phải tạo thành một đường thẳng từ đầu đến gót chân. Tay bạn để dưới 2 vai thẳng đứng, mũi chân chống xuống sàn. Bạn phải dùng lực để giữ cho cột sống và mông thẳng."));

        exercisekList.add(new Exercisek(2, "Chống đẩy"
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

        exercisekList.add(new Exercisek(3, "Plank"
                ,"https://cdn.thehinh.com/2019/06/64339804_6140715877001_2673110258309660672_n-1.png"
                , 11, 1
                , "Bơi lội là môn thể thao dưới nước, nhờ vào lực đẩy của nước và sự vận động của toàn thân, đặc biệt là chân và tay mà người bơi có thể di chuyển cơ thể dưới nước với một tốc độ nhất định. Bơi lội là môn thể thao dành cho mọi người ở mọi lứa tuổi và không quá tốn kém, giúp bạn cải thiện được sức khỏe, thậm chí là tinh thần."
                , "Bước 1: Nín thở dưới nước – Một trong những hướng dẫn đầu tiên khi bạn học bơi\n" +
                "Bước 2: Hít thở dưới nước – Yếu tố quan trọng thứ hai cần lưu ý trong hướng dẫn học bơi\n" +
                "Bước 3: Khi tập bơi đừng quên kỹ năng nổi dưới nước và lướt nước\n" +
                "Bước 4: Hướng dẫn học bơi an toàn - Chọn nơi dạy bơi lội uy tín, học phí hợp lý cho người mới bắt đầu"));

        exercisekList.add(new Exercisek(4, "Đạp xe"
                ,"https://cdn.tgdd.vn/Files/2022/05/10/1431463/moi-ngay-nen-dap-xe-bao-nhieu-km-dap-bao-lau-.jpg"
                , 5, 1
                , "Đi xe đạp là môn thể thao tốt cho sức khỏe giúp rèn luyện thể chất, cải thiện tim phổi. Tuy nhiên nhiều người thường xuyên đi xe đạp chưa hẳn đã biết đạp xe đạp đúng cách."
                , "Bước 1: Ăn uống trước khi đạp xe đạp là một điều cần thiết, bởi khi đạp xe cơ thể bạn tiêu hao khá nhiều năng lượng và mất sức,\n" +
                "Bước 2: Tất cả các thời gian trong ngày đều có thể đạp xe, nhưng thời gian lý tưởng để đạp xe là vào buổi sáng sớm trước khi ăn bữa đầu tiên trong ngày.\n" +
                "Bước 3: Tư thế đạp xe vừa thoải mái vừa đúng cách, là tư thế ngồi hơi nghiêng về phía trước, giữ tay hơi cong cong trong lúc đạp xe, vì khi tay hơi cong nó cho phép các cơ phần trên và khớp lưng cảm nhận độ rung, phân tán lực, ít gây ảnh hưởng đến cột sống. Khi đạp xe giữ chân ở góc 90 độ, nó tốt cho phần hông của bạn tránh các trường hợp đau cơ.\n" +
                "Bước 4: đạp xe đúng cách, chính xác đảm bảo sức khỏe gồm 4 bước: đạp, kéo, nâng, đẩy. Chân đạp nhẹ nhàng xuống dưới, dùng lực bàn chân kéo lên trên rồi nâng bàn đạp, rồi nhẹ nhàng đẩy xuống, những động tác được lặp đi lặp lại, đúng nhịp với tần suất đạp đều nhau, giúp đẩy nhanh tốc độ."));


        exercisekList.add(new Exercisek(1, "Plank"
                ,"https://www.thethaothientruong.vn/uploads/2021/Plank-cai-thien-tu-the-khoe-dep.jpg"
                , 35, 1
                , "Plank là một bài tập giúp đốt mỡ và làm săn cơ bụng hàng đầu cực kỳ hiệu quả dành cho cả nam và nữ. Chỉ với động tác đơn giản, dễ nhớ, dễ làm theo mà không cần thêm bất cứ dụng cụ gì. "
                , "Bước 1: Chuẩn bị dụng cụ, Bạn nên chuẩn bị cho mình 1 thảm tập yoga để không bị đau tay khi bạn chống tay lúc plank.\n" +
                "Bước 2: Vào tư thế bò, Bạn đặt 2 tay dưới vai rồi để đầu gối dưới hông, bạn có thể đặt phẳng chân hoặc uốn ngón chân lại cho tư thế này. Nhớ duy trì nhịp thở đều.\n" +
                "Bước 3: Đưa người về tư thế em bé, chuyển ngay về tư thế em bé bằng cách đẩy mông về phía bàn chân, đùi bạn mở rộng bằng vai rồi từ từ đưa ngực hạ xuống sàn\n" +
                "Bước 4: Vào tư thế plank,  bạn phải tạo thành một đường thẳng từ đầu đến gót chân. Tay bạn để dưới 2 vai thẳng đứng, mũi chân chống xuống sàn. Bạn phải dùng lực để giữ cho cột sống và mông thẳng."));

        exercisekList.add(new Exercisek(2, "Chống đẩy"
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

        exercisekList.add(new Exercisek(3, "Plank"
                ,"https://cdn.thehinh.com/2019/06/64339804_6140715877001_2673110258309660672_n-1.png"
                , 11, 1
                , "Bơi lội là môn thể thao dưới nước, nhờ vào lực đẩy của nước và sự vận động của toàn thân, đặc biệt là chân và tay mà người bơi có thể di chuyển cơ thể dưới nước với một tốc độ nhất định. Bơi lội là môn thể thao dành cho mọi người ở mọi lứa tuổi và không quá tốn kém, giúp bạn cải thiện được sức khỏe, thậm chí là tinh thần."
                , "Bước 1: Nín thở dưới nước – Một trong những hướng dẫn đầu tiên khi bạn học bơi\n" +
                "Bước 2: Hít thở dưới nước – Yếu tố quan trọng thứ hai cần lưu ý trong hướng dẫn học bơi\n" +
                "Bước 3: Khi tập bơi đừng quên kỹ năng nổi dưới nước và lướt nước\n" +
                "Bước 4: Hướng dẫn học bơi an toàn - Chọn nơi dạy bơi lội uy tín, học phí hợp lý cho người mới bắt đầu"));

        exercisekList.add(new Exercisek(4, "Đạp xe"
                ,"https://cdn.tgdd.vn/Files/2022/05/10/1431463/moi-ngay-nen-dap-xe-bao-nhieu-km-dap-bao-lau-.jpg"
                , 5, 1
                , "Đi xe đạp là môn thể thao tốt cho sức khỏe giúp rèn luyện thể chất, cải thiện tim phổi. Tuy nhiên nhiều người thường xuyên đi xe đạp chưa hẳn đã biết đạp xe đạp đúng cách."
                , "Bước 1: Ăn uống trước khi đạp xe đạp là một điều cần thiết, bởi khi đạp xe cơ thể bạn tiêu hao khá nhiều năng lượng và mất sức,\n" +
                "Bước 2: Tất cả các thời gian trong ngày đều có thể đạp xe, nhưng thời gian lý tưởng để đạp xe là vào buổi sáng sớm trước khi ăn bữa đầu tiên trong ngày.\n" +
                "Bước 3: Tư thế đạp xe vừa thoải mái vừa đúng cách, là tư thế ngồi hơi nghiêng về phía trước, giữ tay hơi cong cong trong lúc đạp xe, vì khi tay hơi cong nó cho phép các cơ phần trên và khớp lưng cảm nhận độ rung, phân tán lực, ít gây ảnh hưởng đến cột sống. Khi đạp xe giữ chân ở góc 90 độ, nó tốt cho phần hông của bạn tránh các trường hợp đau cơ.\n" +
                "Bước 4: đạp xe đúng cách, chính xác đảm bảo sức khỏe gồm 4 bước: đạp, kéo, nâng, đẩy. Chân đạp nhẹ nhàng xuống dưới, dùng lực bàn chân kéo lên trên rồi nâng bàn đạp, rồi nhẹ nhàng đẩy xuống, những động tác được lặp đi lặp lại, đúng nhịp với tần suất đạp đều nhau, giúp đẩy nhanh tốc độ."));


    }
}
