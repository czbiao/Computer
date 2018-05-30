package com.biao.computer.commun.circledemo.utils;

import android.os.Build;

import com.biao.computer.commun.circledemo.bean.CircleItem;
import com.biao.computer.commun.circledemo.bean.CommentItem;
import com.biao.computer.commun.circledemo.bean.FavortItem;
import com.biao.computer.commun.circledemo.bean.PhotoInfo;
import com.biao.computer.commun.circledemo.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.biao.computer.user.UserFragment.login_username;

/**
 * 
* @ClassName: DatasUtil 
* @Description: TODO(这里用一句话描述这个类的作用)
*
 */
public class DatasUtil {
	public static final String[] CONTENTS = { "欢迎拨打电话13245678900",
			"哈哈，http://search.chongbuluo.com  一个很不错的网站。",
			"今天是个好日子",
			//"呵呵，http://www.ChinaAr.com;一个不错的VR网站,18123456789,",
			//"只有http|https|ftp|svn://开头的网址才能识别为网址，正则表达式写的不太好，如果你又更好的正则表达式请评论告诉我，谢谢！",
			"VR（Virtual Reality，即虚拟现实，简称VR），是由美国VPL公司创建人拉尼尔（Jaron Lanier）在20世纪80年代初提出的。其具体内涵是：综合利用计算机图形系统和各种现实及控制等接口设备，在计算机上生成的、可交互的三维环境中提供沉浸感觉的技术。其中，计算机生成的、可交互的三维环境称为虚拟环境（即Virtual Environment，简称VE）。虚拟现实技术是一种可以创建和体验虚拟世界的计算机仿真系统的技术。它利用计算机生成一种模拟环境，利用多源信息融合的交互式三维动态视景和实体行为的系统仿真使用户沉浸到该环境中。",
			//"哈哈哈哈",
			"C语言好难，我该怎么去学",
			"今天给大家分享一个自学的好网站 http://www.51zxw.net/",
			"增强现实技术（Augmented Reality，简称 AR），是一种实时地计算摄影机影像的位置及角度并加上相应图像、视频、3D模型的技术，这种技术的目标是在屏幕上把虚拟世界套在现实世界并进行互动。这种技术1990年提出。随着随身电子产品CPU运算能力的提升，预期增强现实的用途将会越来越广。\n",
			"网络上有哪些免费的教育资源————来自知乎的回答：https://www.zhihu.com/question/19942068",
			"Python 英国发音：/ˈpaɪθən/ 美国发音：/ˈpaɪθɑːn/）, 是一种面向对象的解释型计算机程序设计语言，由荷兰人Guido van Rossum于1989年发明，第一个公开发行版发行于1991年。\n" +
					"Python是纯粹的自由软件， 源代码和解释器CPython遵循 GPL(GNU General Public License)协议。\n" +
					"Python语法简洁清晰，特色之一是强制用空白符(white space)作为语句缩进。\n" +
					"Python具有丰富和强大的库。它常被昵称为胶水语言，能够把用其他语言制作的各种模块（尤其是C/C++）很轻松地联结在一起。常见的一种应用情形是，使用Python快速生成程序的原型（有时甚至是程序的最终界面），然后对其中有特别要求的部分，用更合适的语言改写，比如3D游戏中的图形渲染模块，性能要求特别高，就可以用C/C++重写，而后封装为Python可以调用的扩展类库。需要注意的是在您使用扩展类库时可能需要考虑平台问题，某些可能不提供跨平台的实现。",
			"有哪些网上自学课程的好网站https://www.zhihu.com/question/31044894",
			"Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程。\n" +
					"Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点。Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等。",
			"Unity3D是由Unity Technologies开发的一个让玩家轻松创建诸如三维视频游戏、建筑可视化、实时三维动画等类型互动内容的多平台的综合型游戏开发工具，是一个全面整合的专业游戏引擎。Unity类似于Director,Blender game engine, Virtools 或 Torque Game Builder等利用交互的图型化开发环境为首要方式的软件。其编辑器运行在Windows 和Mac OS X下，可发布游戏至Windows、Mac、Wii、iPhone、WebGL（需要HTML5）、Windows phone 8和Android平台。也可以利用Unity web player插件发布网页游戏，支持Mac和Windows的网页浏览。它的网页播放器也被Mac widgets所支持。",
			"PHP（外文名:PHP: Hypertext Preprocessor，中文名：“超文本预处理器”）是一种通用开源脚本语言。语法吸收了C语言、Java和Perl的特点，利于学习，使用广泛，主要适用于Web开发领域。PHP 独特的语法混合了C、Java、Perl以及PHP自创的语法。它可以比CGI或者Perl更快速地执行动态网页。用PHP做出的动态页面与其他的编程语言相比，PHP是将程序嵌入到HTML（标准通用标记语言下的一个应用）文档中去执行，执行效率比完全生成HTML标记的CGI要高许多；PHP还可以执行编译后代码，编译可以达到加密和优化代码运行，使代码运行更快。",
			"大一刚学C语言，第二次上机课，当我发现我照着书抄写的程序在运行之后的黑框里跳出一排烫烫烫烫烫，当时就震惊了。你们能想象一个来自小城，在大学之前没怎么接触过电脑更不懂代码的孩子当时内心的恐惧吗？我真的以为这是电脑过热发出的警告，于是我弯下腰把插头拔了。\n",
			"A：嘿 //是什么意思啊？\n" +
					"B：嘿.\n" +
					"A：呃 我问你//是什么意思？\n" +
					"B：问吧.\n" +
					"A：我刚才不是问了么？\n" +
					"B：啊？\n" +
					"A：你再看看记录...\n" +
					"B：看完了.\n" +
					"A：......所以//是啥？\n" +
					"B：所以什么？\n" +
					"A：你存心耍我呢吧？\n" +
					"B：没有啊 你想问什么？\n" +
					"……\n" +
					"\n" +
					"不断循环之后，A一气之下和B绝交，自己苦学程序。\n" +
					"N年之后，A终于修成正果，回想起B，又把聊天记录翻出来看，这时，他突然发现B没有耍他……\n" +
					"而他自己也不知道当年他问B的究竟是什么问题……\n",
			"JavaScript一种直译式脚本语言，是一种动态类型、弱类型、基于原型的语言，内置支持类型。它的解释器被称为JavaScript引擎，为浏览器的一部分，广泛用于客户端的脚本语言，最早是在HTML（标准通用标记语言下的一个应用）网页上使用，用来给HTML网页增加动态功能。",
			"Java Web，是用Java技术来解决相关web互联网领域的技术总和。web包括：web服务器和web客户端两部分。Java在客户端的应用有java applet，不过使用得很少，Java在服务器端的应用非常的丰富，比如Servlet，JSP和第三方框架等等。Java技术对Web领域的发展注入了强大的动力。",
			"我今天去面试，面试官问：“你毕业才两年，这三年工作经验是怎么来的？！”\n" +
					"我回答：“加班。” ",
			"Linux是一套免费使用和自由传播的类Unix操作系统，是一个基于POSIX和UNIX的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。\n",
			"移动端Web App和WAP有什么不同？最直接的区别就是功能层面。WAP更侧重使用网页技术在移动端做展示，包括文字、媒体文件等。而Web App更侧重“功能”，是使用网页技术实现的App。总的来说，Web App就是运行于网络和标准浏览器上，基于网页技术开发实现特定功能的应用。",
			"响应式网站设计(Responsive Web design)的理念是：集中创建页面的图片排版大小，可以智能地根据用户行为以及使用的设备环境（系统平台、屏幕尺寸、屏幕定向等）进行相对应的布局。",
			"MySQL是一个关系型数据库管理系统，由瑞典MySQL AB 公司开发，目前属于 Oracle 旗下产品。MySQL 是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL是最好的 RDBMS (Relational Database Management System，关系数据库管理系统) 应用软件。\n" +
					"MySQL是一种关系数据库管理系统，关系数据库将数据保存在不同的表中，而不是将所有数据放在一个大仓库内，这样就增加了速度并提高了灵活性。\n" +
					"MySQL所使用的 SQL 语言是用于访问数据库的最常用标准化语言。MySQL 软件采用了双授权政策，分为社区版和商业版，由于其体积小、速度快、总体拥有成本低，尤其是开放源码这一特点，一般中小型网站的开发都选择 MySQL 作为网站数据库。"};
	/*public static final String[] PHOTOS = {
			"http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg",
			"http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg",
			"http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg",
			"http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg",
			"http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg",
			"http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg",
			"http://f.hiphotos.baidu.com/image/pic/item/f11f3a292df5e0fecc3e83ef586034a85edf723d.jpg",
			"http://cdn.duitang.com/uploads/item/201309/17/20130917111400_CNmTr.thumb.224_0.png",
			"http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg",
			"http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg",
			"http://pic4.nipic.com/20091203/1295091_123813163959_2.jpg",
			"http://pic31.nipic.com/20130624/8821914_104949466000_2.jpg",
			"http://pic6.nipic.com/20100330/4592428_113348099353_2.jpg",
			"http://pic9.nipic.com/20100917/5653289_174356436608_2.jpg",
			"http://img10.3lian.com/sc6/show02/38/65/386515.jpg",
			"http://pic1.nipic.com/2008-12-09/200812910493588_2.jpg",
			"http://pic2.ooopic.com/11/79/98/31bOOOPICb1_1024.jpg" };*/
	public static final String[] HEADIMG = {
			"http://biaohstc.cn:8080/download/hanshi.jpg",
			"http://biaohstc.cn/images/headimg/c.jpg",
			"http://biaohstc.cn/images/headimg/mayun.jpg",
			"http://biaohstc.cn/images/headimg/mahuateng.jpg",
			"http://biaohstc.cn/images/headimg/huawei.jpg",
			"http://biaohstc.cn/images/headimg/meizu.jpg",
			"http://biaohstc.cn/images/headimg/luoyonghao.jpg",
			"http://biaohstc.cn/images/headimg/leijun.jpg",
			"http://biaohstc.cn/images/headimg/baidu.jpg",
			"http://biaohstc.cn/images/headimg/jd.jpg",
			"http://biaohstc.cn/images/headimg/taobao.jpg",
			"http://biaohstc.cn/images/headimg/xijinping.jpg",};

	public static List<User> users = new ArrayList<User>();
	public static List<PhotoInfo> PHOTOS = new ArrayList<>();
	/**
	 * 动态id自增长
	 */
	public static int circleId = 0;
	/**
	 * 点赞id自增长
	 */
	private static int favortId = 0;
	/**
	 * 评论id自增长
	 */
	private static int commentId = 0;
	public static final User curUser = new User("0", login_username.getText().toString(), HEADIMG[0]);
	static {
		User user1 = new User("1", "冯诺依曼", HEADIMG[1]);
		User user2 = new User("2", "马云", HEADIMG[2]);
		User user3 = new User("3", "马化腾", HEADIMG[3]);
		User user4 = new User("4", "用户", HEADIMG[4]);
		User user5 = new User("5", "魅族", HEADIMG[5]);
		User user6 = new User("6", "Tom", HEADIMG[6]);
		User user7 = new User("7", "雷军", HEADIMG[7]);
		User user8 = new User("8", "小明", HEADIMG[8]);
		User user9 = new User("9", "小红", HEADIMG[9]);
		User user10 = new User("10", "淘宝", HEADIMG[10]);
		User user11 = new User("11", "测试", HEADIMG[11]);

		users.add(curUser);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		users.add(user8);
		users.add(user9);
		users.add(user10);
		users.add(user11);

		PhotoInfo p1 = new PhotoInfo();
		p1.url = "http://biaohstc.cn/images/1.jpg";
		p1.w = 477;
		p1.h = 250;

		PhotoInfo p2 = new PhotoInfo();
		p2.url = "http://biaohstc.cn/images/2.jpg";
		p2.w = 593;
		p2.h = 381;

		PhotoInfo p3 = new PhotoInfo();
		p3.url = "http://biaohstc.cn/images/3.jpg";
		p3.w = 548;
		p3.h = 342;

		PhotoInfo p4 = new PhotoInfo();
		p4.url = "http://biaohstc.cn/images/4.jpg";
		p4.w = 619;
		p4.h = 444;

		PhotoInfo p5 = new PhotoInfo();
		p5.url = "http://biaohstc.cn/images/5.jpg";
		p5.w = 546;
		p5.h = 313;

		PhotoInfo p6 = new PhotoInfo();
		p6.url = "http://biaohstc.cn/images/6.jpg";
		p6.w = 353;
		p6.h = 373;

		PhotoInfo p7 = new PhotoInfo();
		p7.url = "http://biaohstc.cn/images/7.jpg";
		p7.w = 568;
		p7.h = 315;

		PhotoInfo p8 = new PhotoInfo();
		p8.url = "http://biaohstc.cn/images/8.jpg";
		p8.w = 1066;
		p8.h = 600;

		PhotoInfo p9 = new PhotoInfo();
		p9.url = "http://biaohstc.cn/images/9.jpg";
		p9.w = 1024;
		p9.h = 768;

		PhotoInfo p10 = new PhotoInfo();
		p10.url = "http://biaohstc.cn/images/10.jpg";
		p10.w = 550;
		p10.h = 428;

		PhotoInfo p11 = new PhotoInfo();
		p11.url = "http://biaohstc.cn/images/11.jpg";
		p11.w = 828;
		p11.h = 1407;

		PhotoInfo p12 = new PhotoInfo();
		p12.url = "http://biaohstc.cn/images/12.jpg";
		p12.w = 556;
		p12.h = 371;
		PHOTOS.add(p1);
		PHOTOS.add(p2);
		PHOTOS.add(p3);
		PHOTOS.add(p4);
		PHOTOS.add(p5);
		PHOTOS.add(p6);
		PHOTOS.add(p7);
		PHOTOS.add(p8);
		PHOTOS.add(p9);
		PHOTOS.add(p10);
		PHOTOS.add(p11);
		PHOTOS.add(p12);
	}

	public static List<CircleItem> createCircleDatas() {
		List<CircleItem> circleDatas = new ArrayList<CircleItem>();
		for (int i = 0; i < 15; i++) {
			CircleItem item = new CircleItem();
			User user = getUser();
			item.setId(String.valueOf(circleId++));
			item.setUser(user);
			item.setContent(getContent());
			item.setCreateTime("5月5日");

			item.setFavorters(createFavortItemList());
			item.setComments(createCommentItemList());
			int type = getRandomNum(10) % 3;
			if (type == 0) {
				item.setType("1");// 链接
				item.setLinkImg("http://pics.sc.chinaz.com/Files/pic/icons128/2264/%E8%85%BE%E8%AE%AFQQ%E5%9B%BE%E6%A0%87%E4%B8%8B%E8%BD%BD1.png");
				item.setLinkTitle("百度一下，你就知道");
			} else if(type == 1){
				item.setType("2");// 图片
				item.setPhotos(createPhotos());
			}else {
				/*item.setType("3");// 视频
				String videoUrl = "http://wscdn.miaopai.com/static20131031/miaopai20140729/pc-static/video_01/topvideo2.mp4";
                String videoImgUrl = "http://biaohstc.cn:8080/download/miaopai.jpg";
				item.setVideoUrl(videoUrl);
                item.setVideoImgUrl(videoImgUrl);*/

				/*获取当前系统的android版本号*/
				int currentapiVersion=android.os.Build.VERSION.SDK_INT;
				if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
					item.setType("2");// 图片
					item.setPhotos(createPhotos());
				}else{
					item.setType("3");// 视频
					String videoUrl = "http://wscdn.miaopai.com/static20131031/miaopai20140729/pc-static/video_01/topvideo2.mp4";
					String videoImgUrl = "http://biaohstc.cn:8080/download/miaopai.jpg";
					item.setVideoUrl(videoUrl);
					item.setVideoImgUrl(videoImgUrl);
				}
			}
			circleDatas.add(item);
		}

		return circleDatas;
	}

	public static User getUser() {
		return users.get(getRandomNum(users.size()));
	}

	public static String getContent() {
		return CONTENTS[getRandomNum(CONTENTS.length)];
	}

	public static int getRandomNum(int max) {
		Random random = new Random();
		int result = random.nextInt(max);
		return result;
	}

	public static List<PhotoInfo> createPhotos() {
		List<PhotoInfo> photos = new ArrayList<PhotoInfo>();
		int size = getRandomNum(10);
		if (size > 0) {
			if (size > 9) {
				size = 9;
			}
			for (int i = 0; i < size; i++) {
				PhotoInfo photo = PHOTOS.get(getRandomNum(PHOTOS.size()));
				if (!photos.contains(photo)) {
					photos.add(photo);
				} else {
					i--;
				}
			}
		}
		return photos;
	}

	public static List<FavortItem> createFavortItemList() {
		int size = getRandomNum(users.size());
		List<FavortItem> items = new ArrayList<FavortItem>();
		List<String> history = new ArrayList<String>();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				FavortItem newItem = createFavortItem();
				String userid = newItem.getUser().getId();
				if (!history.contains(userid)) {
					items.add(newItem);
					history.add(userid);
				} else {
					i--;
				}
			}
		}
		return items;
	}

	public static FavortItem createFavortItem() {
		FavortItem item = new FavortItem();
		item.setId(String.valueOf(favortId++));
		item.setUser(getUser());
		return item;
	}
	
	public static FavortItem createCurUserFavortItem() {
		FavortItem item = new FavortItem();
		item.setId(String.valueOf(favortId++));
		item.setUser(curUser);
		return item;
	}

	public static List<CommentItem> createCommentItemList() {
		List<CommentItem> items = new ArrayList<CommentItem>();
		int size = getRandomNum(10);
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				items.add(createComment());
			}
		}
		return items;
	}

	public static CommentItem createComment() {
		CommentItem item = new CommentItem();
		item.setId(String.valueOf(commentId++));
		String comment[] = {"是呀","没错","你好呀","哈哈,我是一个评论","这个图不错","哇好美好帅",
				"我喜欢你","你不乖了","我也是这么觉得的","你说得对","对呀就是这样",
				"怎么这么机智","今天确实不错","哎呀日常表白你","每天幸福哦","在这都有你","在这学到了很多","挺好的我觉得"};
		item.setContent(comment[getRandomNum(comment.length)]);
		User user = getUser();
		item.setUser(user);
		if (getRandomNum(10) % 3 == 0) {
			while (true) {
				User replyUser = getUser();
				if (!user.getId().equals(replyUser.getId())) {
					item.setToReplyUser(replyUser);
					break;
				}
			}
		}
		return item;
	}
	
	/**
	 * 创建发布评论
	 * @return
	 */
	public static CommentItem createPublicComment(String content){
		CommentItem item = new CommentItem();
		item.setId(String.valueOf(commentId++));
		item.setContent(content);
		item.setUser(curUser);
		return item;
	}
	
	/**
	 * 创建回复评论
	 * @return
	 */
	public static CommentItem createReplyComment(User replyUser, String content){
		CommentItem item = new CommentItem();
		item.setId(String.valueOf(commentId++));
		item.setContent(content);
		item.setUser(curUser);
		item.setToReplyUser(replyUser);
		return item;
	}
	
	
	public static CircleItem createVideoItem(String videoUrl, String imgUrl){
		CircleItem item = new CircleItem();
		item.setId(String.valueOf(circleId++));
		item.setUser(curUser);
		//item.setContent(getContent());
		item.setCreateTime("5月5日");

		//item.setFavorters(createFavortItemList());
		//item.setComments(createCommentItemList());
        item.setType("3");// 图片
        item.setVideoUrl(videoUrl);
        item.setVideoImgUrl(imgUrl);
		return item;
	}
}
