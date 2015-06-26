collegeAry = ["哲学类","经济学类","管理科学与工程类","工商管理类","行政管理,公共管理类","图书档案学类",
	"语言文学类","新闻传播学类","艺术类","电气信息类","计算机科学与技术类","机械类","土建类","材料类","仪器仪表类",
	"能源动力类","水利类","测绘类","制药工程类","交通运输类","船舶与海洋工程类","航空航天类","轻工纺织食品类","武器类"
	,"公安技术类","生物医学工程类","法学类","历史学类","数学类","地理学类","化学类及化学工程学类","生物科学及生物技术类",
	"天文地质地理类","力学类","电子信息科学类","系统科学类","环境科学与安全类","教育学类","医学类","心理学类","农业类"];
subjectAry = [
    ["哲学(含伦理学)","逻辑学","宗教学"],
    ["经济学","国际经济与贸易","财政学","金融学","经济管理","经济信息管理","贸易经济","国际金融","投资学","统计学","经济与金融","金融工程","保险","税务","信用管理","网络经济学","技术经济"],
    ["管理科学","信息管理与信息系统","工业工程","工程管理","产品质量工程","项目管理"],
    ["工商管理","市场营销","商品学","会计学","审计学","涉外会计","会计信息系统","财务管理","财政金融","资产评估","企业管理","商务策划管理","国际商务","电子商务","房地产经营管理","物业管理","物流管理","旅游管理","酒店管理","连锁经营管理","人力资源管理"],
	["行政管理","公共关系学","文秘","公共事业管理","公共政策学","国防教育与管理","劳动关系","劳动与社会保障","城市规划与管理","土地资源管理","农业经济管理","食品经济管理","会展经济与管理","文化产业管理","体育产业管理","航运管理"],
	["图书馆学与档案学","信息资源管理"],
	["汉语言文学","对外汉语","英语","商务英语","外贸英语","俄语","德语","法语","西班牙语","阿拉伯语","日语","朝鲜语","其它外语"],
	["新闻学","广播电视新闻","广告学","编辑出版学","传播学","媒体创意"],
	["音乐,作品","艺术设计","戏剧,表演","导演,广播电视编导","戏剧影视文学","戏剧影视美术设计","摄影,动画","播音,主持,录音","服装设计","舞蹈","美术学","绘画","雕塑","影视学"],
	["电气工程及其自动化","电气信息工程","通信工程","自动化","电子信息工程","电子科学与技术","集成电路设计与集成系统","影视艺术设计","广播电视工程"],
	["计算机科学与技术","计算机科学","计算机工程","计算机网络","计算机应用","软件工程","计算机信息管理"],
	["机械设计制造及其自动化","机械电子工程/机电一体化","机械工程及自动化","机械制造工艺与设备","制造工程","制造自动化与测控技术","材料成型及控制工程","工业设计","过程装备与控制工程","模具设计与制造","微机电系统工程","车辆工程","汽车服务工程"],
	["土木工程","道路与桥梁","建筑学","建筑工程","工业与民用建筑","工程造价管理","建筑环境与设备工程","给排水科学与工程","供热通风与空调工程","室内装潢设计","城市规划","历史建筑保护工程","景观学"],
	["冶金工程","金属材料工程","无机非金属材料工程","高分子材料与工程","材料物理","材料化学","材料科学与工程","电子封装技术"],
	["测控技术与仪表"],
	["能源与动力工程","核工程与核技术","电力系统及自动化","制冷与低温技术"],
	["水利水电工程","水文与水资源工程","港口航道与海岸工程"],
	["测绘工程","遥感科学与技术","空间信息与数字技术"],
	["制药工程"],
	["交通运输","交通工程","油气储运工程","飞行技术","航海技术","轮机工程","物流工程","海事管理"],
	["船舶与海洋工程"],
	["飞行器设计与工程","飞行器动力工程","飞行器制造工程","飞行器环境与生命保障工程"],
	["食品科学与工程","轻化工程","包装工程","印刷工程","纺织工程","服装设计与工程"],
	["武器系统与发射工程","探测制导与控制技术","弹药工程与爆炸技术","特种能源工程与烟火技术","地面武器机动工程","信息对抗技术"],
	["公安技术"],
	["生物医学工程"],
	["法学","马克思主义理论","政治学与行政学","思想政治教育","国际政治","国际经济法","经济法","社会学","外交学","公安学"],
	["历史学","考古学","博物馆学"],
	["数学与应用数学","信用与计算科学"],
	["物理学","应用物理学","声学"],
	["化学","应用化学","化学工程与工艺","精细化工","化工设备与机械","生物化工"],
	["生物工程","生物科学技术","生物信息学"],
	["天文学","地质学","地理科学","地球物理学","大气科学","海洋科学","地矿","宝石鉴定与加工","石油工程","地球化学","地球与空间科学","地理信息系统","地理信息科学与技术"],
	["力学","应用力学"],
	["电子信息科学与技术","光信息科学与技术","光电子技术科学","微电子学","信息科学技术","信息安全","科技防卫"],
	["系统理论","系统科学与工程"],
	["环境科学","环境工程","安全工程","生态学"],
	["教育学","体育教育","学前教育","职业技术教育","特殊教育","教育技术学"],
	["基础医学","预防医学","临床医学与医学技术","口腔医学","中医学","法医学","护理学","药学","医学检验","营养学","麻醉学","放射医学","眼视光学","针灸推拿学","中药学"],
	["心理学","应用心理学"],
	["农学","园艺","植物保护学","茶学","草业医学","森林资源","环境生态","动物科学","动物医学","水产科学","农业工程","林业工程","植物生产","园林"]
];