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
