package cn.studyjams.s2.sj0147.huangkai.bean;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class Festivaldatas {
    private static Festivaldatas mInstance;
    private List<Msg> mMsgdatas = new ArrayList<Msg>();
    private List<Festival> mFestvaldatas = new ArrayList<Festival>();
    private Festivaldatas() {
        mFestvaldatas.add(new Festival(1, "生日"));
        mFestvaldatas.add(new Festival(2, "新婚"));
        mFestvaldatas.add(new Festival(3, "元旦"));
        mFestvaldatas.add(new Festival(4, "光棍节"));
        mFestvaldatas.add(new Festival(5, "情人节"));
        mFestvaldatas.add(new Festival(6, "母亲节"));
        mFestvaldatas.add(new Festival(7, "父亲节"));
        mFestvaldatas.add(new Festival(8, "圣诞节"));
        mFestvaldatas.add(new Festival(9, "春节"));

        mMsgdatas.add(new Msg(1,1,"热腾腾的茶水可以让身体温暖，情切切的故事可以让心灵感动，一声声的祝福可以传送我的情怀。今天是你的生日，祝你被快乐缠绕幸福相伴！"));
        mMsgdatas.add(new Msg(2,1,"在牵挂中，让友情更暖！在关爱中，让友情更深！在自然中，让容颜更美！在诚实中，让心底更静！在简单中，让生活更艳！在祝福中！让你阳光美丽！生日快乐！"));
        mMsgdatas.add(new Msg(3,1,"虽然不能陪你度过这特别的日子，但我的祝福依旧准时送上：在你缤纷的人生之旅中，心想事成！生日快乐！原所有的快乐，所有的幸福，所有的温馨，所有的好运永远围绕在你身边！生日快乐！"));
        mMsgdatas.add(new Msg(4,1,"想过许多创意，让你过个特殊的生日；逛过很多商店，只为找寻你喜欢的礼物；我的付出你是否知道；但美好的祝福你一定能收到，祝你生日快乐！"));
        mMsgdatas.add(new Msg(5,1,"今天你生日，送你金送金银送你一颗十克拉的钻石璀璨你的人生，今天你生日，送你梦送你花送你梦想的沿途开着幸福的花儿，生日快乐。"));
        mMsgdatas.add(new Msg(6,1,"你是我心中的信仰，你是我天空的繁星，你是我思绪的灵感，你是我生命的图腾，你是我春天的祈祷，你是我冬天的珍藏，亲爱的，生日快乐。"));
        mMsgdatas.add(new Msg(7,1,"我把春风织成一块温暖的毯子送给你，将幸福包住。我把春雨编成一条梦幻的丝带送给你，把快乐缠住。我把春天挂满祝福送给你，让美好留住！"));
        mMsgdatas.add(new Msg(8,1,"面胜荷花三分娇，赛过桂花是奶香。你的爱好虽是糖，国语外语都很棒。就算偶尔摔一跤，也是为了快快长。生日快乐你为王，开启智慧现宝藏。"));
        mMsgdatas.add(new Msg(9,1,"今天你又长了一岁，我奉上帝之命，特地为你送来了一份魅力，一份成熟，一份智慧。我还不惜违抗天命，为你偷偷地准备了一份儿祝福，祝你生日快乐，天天幸福。"));


        mMsgdatas.add(new Msg(1,2,"十年修得同船渡，百年修得共枕眠。于茫茫人海中找到他/她，分明是千年前的一段缘；无数个偶然堆积而成的必然，怎能不是三生石上精心镌刻的结果呢？用真心呵护这份缘吧，真爱的你们。"));
        mMsgdatas.add(new Msg(2,2,"喝下这杯交杯酒，人生路上一起走，结婚礼堂真敞亮，父母宾朋喜洋洋，敬过父母敬来宾，喝完一杯又一杯，人生得意须尽欢，莫使金樽空对月。"));
        mMsgdatas.add(new Msg(3,2,"新床新被新房子，迎接新人新样子。满屋喜气满堂彩，新郎新娘乐开怀。亲朋好友闹洞房，热热闹闹语喧天。红枣莲子和花生，预示来年宝宝添。祝愿你们白头到老，早生贵子！"));
        mMsgdatas.add(new Msg(4,2,"春窗绣出鸳鸯谱，夜月斟满琥珀杯，塘中开出并蒂莲，真心挽成同心结，一对新人手相连，一生爱恋情相随，自此幸福常相伴，温馨甜蜜红艳艳。恭祝新婚快乐，白头偕老。"));
        mMsgdatas.add(new Msg(5,2,"愿你俩用爱去缠著对方，彼此互相体谅和关怀，共同分享今后的苦与乐。敬祝百年好合永结同心，视你们永远相爰，携手共度美丽人生！"));
        mMsgdatas.add(new Msg(6,2,"一片红霞映窗来，一对新人堂下站，粉面桃花交相映，临风玉树心正欢，相知相守拜天地，满面春风谢宾客，一番深情挽同心，两厢情愿入锦帐。恭祝你新婚快乐，恩爱绵绵。"));
        mMsgdatas.add(new Msg(7,2,"十年修得同船渡，百年修得共枕眠。于茫茫人海中找到她，分明是千年前的一段缘；用真心呵护这份缘吧，祝你新婚幸福美满！"));
        mMsgdatas.add(new Msg(8,2,"相爱没那么简单，但是你们做到了！结婚没那么简单，但是你们做到了！生活没那么简单，所以希望你的未来简约而不简单！哥们，新婚快乐！"));
        mMsgdatas.add(new Msg(9,2,"从此后，天更蓝，月更圆，你对未来有了更多期盼；从此后，笑有人陪，哭有人伴，你再不会感到孤单。生活开始幸福美满。朋友，新婚快乐！"));


        mMsgdatas.add(new Msg(1,3,"元旦了，我送了一串礼物。快乐送给开心的人，幸福送给有情的人，希望送给等待的人，成功送给奋斗的人，祝福送给正看短信的人"));
        mMsgdatas.add(new Msg(2,3,"一斤花生二斤枣，愿你跟着好运跑；三斤橘子四斤蕉，财源滚进你腰包；五斤葡萄六斤橙，愿你心想事就成；八斤芒果十斤瓜，身体健康顶刮刮！祝你：元旦快乐！"));
        mMsgdatas.add(new Msg(3,3,"元旦到，许心愿：愿你事业高升金钱花不完，万事如意一生永平安。爱神也会把你恋，生活美满心也甜；喜神陪伴你身边，祝你天天展笑颜！"));
        mMsgdatas.add(new Msg(4,3,"房子，车子，票子，不如开心过日子；微信，彩信，飞信，不如问候小短信；金蛋，银蛋，彩蛋，不如快乐过元旦。愿你龙年元旦，幸福翻天。"));
        mMsgdatas.add(new Msg(5,3,"寒冷的冬天悄然流逝，多变的是天气，不变的是心情！愿淡淡的寒气轻拂你一生的疲惫，飒飒的北风传递我衷心的挂念。元旦快乐"));
        mMsgdatas.add(new Msg(6,3,"元旦到，祝福送。祝愿你：飞黄腾达，不缺钞票；平步青云，快乐围绕；前程似锦，吉星高照；财运亨通，合家欢乐；万事圆圆，好运连连！"));
        mMsgdatas.add(new Msg(7,3,"跟昨日的烦恼说再见，和今日的快乐相拥抱，与明日的幸福来约会，元旦，又是一个展新的开始，愿你创下新业绩，开辟人生更大的辉煌，元旦快乐！"));
        mMsgdatas.add(new Msg(8,3,"元旦已来到，信息不能迟到，好友前来报到，祝福提前送到：爱情浪漫美好，友情温暖笼罩，亲情时刻围绕，工作业绩攀高，生活幸福欢笑，来年更美好！"));
        mMsgdatas.add(new Msg(9,3,"一缕温馨，让烛光摇曳；一丝关怀，让星光照耀；一点思念，让雪花飘远；一声问候，让信息传递；一份祝福，让元旦凝聚。朋友，愿在二零一三年里，你是快乐的，我是幸福的。"));


        mMsgdatas.add(new Msg(1,4,"光棍节，没有爱情但有友情，有爱的人，约会去了，没爱的人，自己庆祝去了，我祈祷，来年的光棍节，有个人爱着，未来的你，光棍节快乐！"));
        mMsgdatas.add(new Msg(2,4,"我是清白的光棍。竹签：我是宁折不弯的光棍。面条：我是遇水就软的光棍。油条：我是备受煎熬的光棍。11路：我是最受欢迎的光棍。光棍节快乐！"));
        mMsgdatas.add(new Msg(3,4,"光棍节到了，祝成婚的“双截棍”们幸福甜蜜；恋爱中的“相思棍”们爱情甜蜜；单身的“独根棍”们早日变成双截棍；无论男光棍、女光棍。光棍节快乐！"));
        mMsgdatas.add(new Msg(4,4,"一年一度的光棍节又如期而至了，希望光棍们务必保持谦虚谨慎，不骄不躁的作风，找对象要做到有的找就找，找不到就不找的务实作风，开创光棍工作的新局面。光棍节快乐！"));
        mMsgdatas.add(new Msg(5,4,"穿光棍衣，走光棍路，光棍不用戴“绿帽”；吃光棍饭，喝光混水，光棍不用吃酸“醋”；睡光棍觉，过光棍日，光棍的生活真不赖。提前祝你光棍节快乐！"));
        mMsgdatas.add(new Msg(6,4,"光棍节来到，短信祝福送，愿望都美好，祈祷全变真！祝愿所有单身朋友找到另一半，祝愿所有爱恋中朋友幸福甜蜜蜜，祝愿所有成年朋友与光棍节挥手来告别，祝愿所有男女朋友拥有美满好家园！"));
        mMsgdatas.add(new Msg(7,4,"光棍平时不着急，着急没有好伴侣。光棍假期不休息，休息伤心伤身体。光棍节日不送礼，送礼只送短消息。彼此安慰莫忘记，愿你光棍佳节开心不孤寂！"));
        mMsgdatas.add(new Msg(8,4,"光棍节，愿你把烦恼抛光光，把忧愁赶光光，把痛苦抹光光，把悲伤忘光光，把霉运去光光，然后再趁机出去逛逛，换回满面春光。祝你光棍节快乐！"));
        mMsgdatas.add(new Msg(9,4,"病毒预警：本世纪威力最强的病毒将在10天后的大光棍节全面爆发，病毒名称：终极骚扰，受感染人群：光棍，解决方案：升级单身模式为成双成对模式。"));


        mMsgdatas.add(new Msg(1,5,"世上有一种姻缘，唯爱是尊，唯情是本，无数长风斜过时，握一缕在手心里却让人心动！上天又给我一个约你的借口，亲爱的，与你共渡，天天都是情人节。"));
        mMsgdatas.add(new Msg(2,5,"小心我用心跳把你吵闹，小心我用热情把你烤焦，小心我用文字把你轰炸，小心我用温存把你绊倒，小心我用浪漫把你铸造，小心我用真诚把你掠夺，小心我用执着把你围剿。2.14情人节，我爱你，天荒地老。"));
        mMsgdatas.add(new Msg(3,5,"上辈子，我和你一起快乐，用鲜花在情人节为我们的爱情见证；这辈子，我和你情定此生，用短信传递我对你的思念。宝贝，这是属于我们两个人的短信，要珍藏哦。"));
        mMsgdatas.add(new Msg(4,5,"天会老，地会老，但我决意爱你的心情永远不会老；我会老，你会老，可是我说给你的情话永远不会老。情人节到了，我也想说：我有一颗陪你到老的心！"));
        mMsgdatas.add(new Msg(5,5,"春风阵阵入心怀，玫瑰花开情人来。深情厚谊爱永在，矢志不渝金石开。牵手连心到永远，海枯石烂也不变。祝情人节快乐无限!"));
        mMsgdatas.add(new Msg(6,5,"又至情人节，GGMM心切切。单身男女欲出猎，管它王八还是鳖。热恋钱包大出血，情人节成情人劫。已婚人士寻浪漫，就去饭店吃大餐。情人节开心就好！"));
        mMsgdatas.add(new Msg(7,5,"真情比玫瑰更可贵，真爱比玫瑰更娇媚，真心比玫瑰更芬芳，真话比玫瑰更漂亮。真爱你的我将真情真心全给你，情人节里一句真话送给你：我是真的爱你！"));
        mMsgdatas.add(new Msg(8,5,"情人节没有人陪，愚人节被耍几回，清明节心情沉闷，劳动节又觉得太累，儿童节严重超岁。还是过母亲节吧，让爱化作短信纷飞，祝亲爱的父母节日幸福！"));
        mMsgdatas.add(new Msg(9,5,"喜欢看你迷人的眼神，喜欢听你温柔的歌声，喜欢挽着你的胳膊散步，喜欢在你的臂弯入眠，喜欢和你在一起的吵吵闹闹，更喜欢和你在一起的幸福无边！"));


        mMsgdatas.add(new Msg(1,6,"您把青春给了灶台，您把时间给了劳累，您把欢乐给了家庭，您把汗水留给自己，您的爱是写不完的爱，您的爱是还不尽的爱。妈妈，您辛苦了！祝母亲节快乐。"));
        mMsgdatas.add(new Msg(2,6,"您甘甜的乳汁滋润了我的人生，您谆谆的教诲指明了我的道路，您殷切的盼望铸就了我的辉煌，您满心的期待成就了我的未来。母亲，我的生命因你而精彩。"));
        mMsgdatas.add(new Msg(3,6,"母亲是伞，我们是伞下的孩子；母亲是豆荚，我们是荚里的豆子；母亲是大地，我们是地里的种子生根，发芽，长大深爱的母亲节日快乐！"));
        mMsgdatas.add(new Msg(4,6,"身在异乡为异客，最深思念是母亲。马上就是母亲节了，身在异乡的我不能亲手为您送上康乃馨，唯有以短信表心意：妈妈，我爱你。"));
        mMsgdatas.add(new Msg(5,6,"母亲节我要用心灵之纸折枝三色康乃馨-健康长寿的红色，纯洁之爱的白色，美丽年轻的粉色，送给你的母亲，祝她健康快乐平安！"));
        mMsgdatas.add(new Msg(6,6,"苦了，您从来不言；累了，您从不埋怨；痛了，您从不哭喊；穷了，你从不说难；你的胸怀，如海；你的坚强，如山；母亲节，愿我亲爱的妈妈一生幸福平安！"));
        mMsgdatas.add(new Msg(7,6,"不养儿不知父母恩，不做母亲不知母爱深。儿的冷暖记心间，儿的喜怒在眉间，儿的举手投足难离视线，儿的点滴永远挂心间。敬爱的母亲，母亲节来临之间，祝您永远健康快乐！"));
        mMsgdatas.add(new Msg(8,6,"您的白发又增多了，您的皱纹又加深了，我已长大您放心了，以后生活该安心了，母亲节到，愿您开心如意，一切顺利，祝您节日快乐。"));
        mMsgdatas.add(new Msg(9,6,"世界上最动听的是母亲的呼唤，割舍不断的是母亲的惦念，镌刻在心的是母亲的容颜。无论失意得意、雨天雪天，母爱时刻散发温暖。母亲节祝母亲健康百年！"));


        mMsgdatas.add(new Msg(1,7,"爸爸，妈妈，祝你们身体永远健康，天天快乐。爸爸，献上我的谢意，为了这么多年来您对我付出的耐心和爱心。父亲节快乐，子孝父心宽。"));
        mMsgdatas.add(new Msg(2,7,"一个人不可能一直坚强，也有脆弱的时候；一个人不可能一直满足，也有失落的时候。今天父亲节，多点关怀多点爱，愿你的父亲最幸福！父亲节快乐！"));
        mMsgdatas.add(new Msg(3,7,"老爸很帅气，走路很神气，天生有才气，浑身扬正气，工作很锐气，头顶有紫气，周围有祥气，做事有运气，人缘很旺气，处处是喜气，终生有福气，父亲节祝亲爱的爸爸，永远年轻，喜气洋洋。"));
        mMsgdatas.add(new Msg(4,7,"忘不掉言辞教导，帮助我成长；忘不了无声关怀，感动我心扉；忘不去鼓励心智，支撑我成材。每一天感受你爱，满载我胸怀。亲爱的父亲，你的情，你的爱，此生珍藏，永放心怀。"));
        mMsgdatas.add(new Msg(5,7,"父爱如山，历历在目，犹如和煦的阳光，仿佛宽广的大海，把儿女包围其中，无论是儿时的欢笑，年少时的生长，还是踏入社会，以至到为人母人父，您的关爱和祝福与儿女同在！父亲节快乐！"));
        mMsgdatas.add(new Msg(6,7,"家人和睦，人似仙，潇洒走人间；酒当歌，曲轻弹，霓霞舞翩翩；花儿美，碧水涟，日月彩云间；梦成真，福禄全，祝愿开心每一天；祝父亲节快乐！"));
        mMsgdatas.add(new Msg(7,7,"有阳光普照的地方就有我的祝福，有月亮照耀的地方就有我的思念，当流星划过的刹那我许了个愿：希望正在看短信息的你一生幸福快乐，祝父亲节开心！"));
        mMsgdatas.add(new Msg(8,7,"父亲的眼神是无声的语言，对我充满期待;父亲的眼神是燃烧的火焰，给我巨大的热力;它将久久的，久久的印在我的心里。祝您节日快乐！"));
        mMsgdatas.add(new Msg(9,7,"爸爸，父亲节快到了，这二十多年来，您为我付出的太多太多，我这辈子都是报答不完的，希望您每天都开开心心，健康平安。"));


        mMsgdatas.add(new Msg(1,8,"可爱的你偷走了我的情，盗走了我的心。我决定告上法庭，该判你什么罪？法官翻遍了所有的纪录和案例后，陪审团一致通过：判你终身伴我！并要祝我圣诞节快乐！"));
        mMsgdatas.add(new Msg(2,8,"生蛋熟蛋，只要是剩下的蛋，就是剩蛋；黑夜白夜，只要是月日，就是平安夜。据说平安夜把剩蛋吃个精光，能换来年快乐时光。等啥，快吃剩蛋呀。"));
        mMsgdatas.add(new Msg(3,8,"圣诞来临，提“钱”祝你圣诞快乐，愿你生活无忧很有钱，事业成功会挣钱，顿顿大餐不花钱，悠闲娱乐不差钱。总之，就是生活美好一路向“钱”！"));
        mMsgdatas.add(new Msg(4,8,"友之初，本离散。有幸遇，是情缘。常联系，金不换。能聚会，天天盼。浪漫日，过圣诞。送祝福，说思念。祝福你，好运连。家温馨，体康健！"));
        mMsgdatas.add(new Msg(5,8,"送你满天雪花，愿你天天笑哈哈；送你湛蓝晴空，愿你事事都成功；送你灿烂星光，愿你生活更辉煌；送你温暖问候，愿你幸福无尽头。提前祝圣诞快乐！"));
        mMsgdatas.add(new Msg(6,8,"一抹夕阳染霞光，夜幕降，华灯上，白雪镶青松，欢声嵌盛装，西洋为中用，时尚已平常，圣诞老人揭皇榜，也曾高中状元郎，谨祝诸君圣诞乐！"));
        mMsgdatas.add(new Msg(7,8,"风飘着醉人的钟声，每一声都是我对你的祝福，愿我的祝福化成点点星光，在这个圣诞夜里陪伴你，过一个美好的圣诞夜，祝你圣诞快乐！"));
        mMsgdatas.add(new Msg(8,8,"装扮成圣诞老人，戴上红帽子白胡须披红挂绿，悄悄的将圣诞礼物压在妻子的枕边，孩子的袜中，让幸福美好停留永驻家中。祝你圣诞节，吉祥开心快乐！"));
        mMsgdatas.add(new Msg(9,8,"佛说：在圣诞时给一个你认为很幸福的人发短信，你的一生也会快乐幸福，我想到了你。佛说：你真有眼光，这个人最有福气了！祝天天快乐！"));


        mMsgdatas.add(new Msg(1,9,"瑞雪迎春到，新年已来临。鞭炮震天响，喜气满街巷。春联贴门上，祈祷送吉祥。大红灯笼挂，好运照四方。开门迎百福，新年新气象。祝春节快乐，幸福满堂！"));
        mMsgdatas.add(new Msg(2,9,"在新的一年里，祝您：事业正当午，身体壮如虎，金钱不胜数，干活不辛苦，浪漫似乐谱，快乐莫你属。春节快乐！"));
        mMsgdatas.add(new Msg(3,9,"安顺驰骋春联中，给你新春万事如意，福乐藏于年画里，送你“龙福”阵阵，开心交汇年宴上，让你团聚声声，祝福融在短信里，要你佳节春风得意，万福同至！祝福新春快乐！"));
        mMsgdatas.add(new Msg(4,9,"山乡村镇好热闹，狮子秧歌锣鼓敲。人山人海半山坡，自演自导乡邻瞧。小孩嘻戏人堆里跑，耄耋老人乐头摇。小伙姑娘欢情跳，麻婆懒汉惹人笑。祝你春节全家乐，一起观看喜乐汇。愿你家财千万金，日进斗金钞票赚！"));
        mMsgdatas.add(new Msg(5,9,"装一车幸福，让平安开道，抛弃一切烦恼，让快乐与您环绕，存储所有温暖，将寒冷赶跑，释放一生真情，让幸福永远对您微笑！大年三十吃饺子！春节快乐。"));
        mMsgdatas.add(new Msg(6,9,"春节要精神放松，悠闲快乐时常在胸，就像盆儿里一棵葱，对烦恼无动于衷，苦闷不在你心中，来年运程一通百通！朋友之情可要常在心头哟！"));
        mMsgdatas.add(new Msg(7,9,"春节假期，已经过去；节后复工，稳定情绪；调整状态，打理自己；认认真真，加足马力；投入工作，创造业绩；老板赏识，给你鼓励；愿你不久，就能加薪！"));
        mMsgdatas.add(new Msg(8,9,"锣鼓喧天鞭炮鸣，举国欢庆迎新年。男女老少穿新衣，欢欢喜喜过大年。春联喜庆耀门庭，灯笼高照幸福临。人寿年丰又一春，生活美满笑颜开。祝春节快乐！"));
        mMsgdatas.add(new Msg(9,9,"新年临近百花香，一条信息带六香，一香送你摇钱树，二香送你贵人扶，三香送你工作好，四香送你没烦恼，五香送你钱满箱，六香送你永安康！祝春节快乐！"));






    }

    //通过传回来的节日的id 来得到listview短信的内容
    public  List<Msg> getMsgsByFestivalId(int fesId) {
        List<Msg> msgs = new ArrayList<Msg>();
        for (Msg msg : mMsgdatas) {
            if (msg.getFestvaId() == fesId) {
                msgs.add(msg);
            }
        }
        return msgs;
    }
    public Msg getMsgByMsId(int id){

        for (Msg msg : mMsgdatas){
            if (msg.getId() == id){
                return msg;}
            }
            return  null;
        }


    public List<Festival> getFestivaldatas() {
        return new ArrayList<Festival>(mFestvaldatas);

    }

    public Festival getFestivalByid(int fesid) {
        for (Festival festival : mFestvaldatas) {
            if (festival.getId() == fesid) {
                return festival;
            }

        }
        return null;
    }

    public static Festivaldatas getInstance() {
        if (mInstance == null) {
            synchronized (Festivaldatas.class) {
                if (mInstance==null){
                mInstance = new Festivaldatas();}
            }


        }
        return  mInstance;
    }
}
