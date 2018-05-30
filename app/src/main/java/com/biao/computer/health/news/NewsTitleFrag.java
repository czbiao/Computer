package com.biao.computer.health.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.biao.computer.BottomNvgViewPageAct;
import com.biao.computer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenz on 2016/12/30.
 */

public class NewsTitleFrag extends Fragment {

    private RecyclerView recyclerView;
    private boolean isTwoPane;

    //判断是否为平板
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.news_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        recyclerView.setAdapter(adapter);
        return view;
    }


    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            News new1 = new News();
            new1.setTitle("互联网思维到底是什么？");
            new1.setContent("1、互联网思维是相对于工业化思维而言的。\n" +
                "\n" +
                "一种技术从工具属性、从应用层面到社会生活，往往需要经历很长的过程。珍妮纺纱机从一项新技术到改变纺织行业，再到后来被定义为工业革命的肇始，影响东、西方经济格局，其跨度至少需要几十年。互联网也同样。\n" +
                "\n" +
                "但因为这种影响是滞后的，所以，我们就难免会处于身份的尴尬之中：旧制度和新时代在我们身上会形成观念的错位。越是以前成功的企业，转型越是艰难，这就是“创新者的窘境”——一个技术领先的企业在面临突破性技术时，会因为对原有生态系统的过度适应而面临失败。\n" +
                "\n" +
                "现在很多传统行业的企业，面临的就是这种状况。\n" +
                "\n" +
                "2、互联网思维是一种商业民主化的思维。\n" +
                "\n" +
                "工业化时代的标准思维模式是：大规模生产、大规模销售和大规模传播，这三个大可以称为工业化时代企业经营的“圣三位一体”。\n" +
                "\n" +
                "1)但是互联网时代，这三个基础被解构了。工业化时代稀缺的是资源和产品，资源和生产能力被当作企业的竞争力，现在不是了；\n" +
                "\n" +
                "2)产品更多地是以信息的方式呈现的，渠道垄断很难实现；\n" +
                "\n" +
                "3)最重要一点，媒介垄断被打破了，消费者同时成为媒介信息和内容的生产者和传播者，你再希望通过买通媒体单向度、广播式制造热门商品诱导消费行为的模式不成立了。\n" +
                "\n" +
                "这三个基础被解构以后，生产者和消费者的权力发生了转变，消费者主权形成。\n" +
                "\n" +
                "3、互联网思维是一种用户至上的思维\n" +
                "\n" +
                "以前的企业也会讲用户至上、产品为王，但这种口号要么是自我标榜，要么真的是出于企业主的道德自律。但是在现在这个数字时代，在消费者主权的时代，用户至上是你不得不这样的行为，你得真心讨好用户。淘宝卖家“见面就是亲，有心就有爱”是真实的情绪，因为好评变成了有价值的资产。民主和专制的区别就在于，前者是不得不对人民好，后者是出于道德自律。所以判断民主社会和专制社会的一大标准，就是两方是怎么对待道德这个事情的。");
            News new2 = new News();
            new2.setTitle("抄也是一门学问：教给你做产品调研的正确姿势");
            new2.setContent("在工作中，我们通过做产品分析调研，来了解产品功能模块的设计逻辑，分析竞品的情况，提升自己的产品感觉。一般我们所说的产品分析调研，分为两大块，一块是针对产品功能的调研，一块是针对产品的调研。\n" +
                    "\n" +
                    "　　针对产品功能的调研，在我们的工作中，比较常见的场景主要是竞品上了新的功能，我们需要对该功能做调研，得出结论是否有必要推出相似的功能。另一种是我们的产品需要上新功能，看看别的产品是怎么做的，从而有效缩短产品的设计流程。\n" +
                    "\n" +
                    "　　1.针对功能点的调研分析\n" +
                    "\n" +
                    "　　场景1：竞品上了新的功能\n" +
                    "\n" +
                    "　　目的：分析竞品新的功能需不需要抄?能不能抄?\n" +
                    "\n" +
                    "　　调研过程：\n" +
                    "\n" +
                    "　　分析有谁用这个功能?参与的关键角色有谁?\n" +
                    "\n" +
                    "　　用户用这个功能有什么好处?操作的流程是怎么样的?\n" +
                    "\n" +
                    "　　数据表现如何?\n" +
                    "\n" +
                    "　　和自己产品的用户群体是否符合?\n" +
                    "\n" +
                    "　　实现起来是否有技术壁垒?\n" +
                    "\n" +
                    "　　得出结论是否做?\n" +
                    "\n" +
                    "　　场景2：产品要做新功能，看看别的产品，怎么抄?抄哪个?\n" +
                    "\n" +
                    "　　目的：缩短产品设计流程\n" +
                    "\n" +
                    "　　调研过程：\n" +
                    "\n" +
                    "　　先思考清楚自己产品的目标用户是谁?\n" +
                    "\n" +
                    "　　产品目前的功能情况是什么样子的?处于哪个阶段?\n" +
                    "\n" +
                    "　　调研的目标产品该选择哪些?\n" +
                    "\n" +
                    "　　目标产品的功能核心关键点是什么?逻辑是什么样子的?\n" +
                    "\n" +
                    "　　根据“相同的都是关键点，不同的都是亮点”的原则，做出符合自己产品的决策。\n" +
                    "\n" +
                    "　　针对功能点的调研，切忌没有一个明确的目标，调研做了一大堆，却得不到一个明确的具有指导性的结论。同时也忌多，明明是针对功能点的调研，结果从交互到体验分析了一大堆，却没有重点。其实，一个好的功能调研，一定是建立在能够清晰地梳理出功能的核心业务逻辑的基础上的。\n" +
                    "\n" +
                    "　　2.针对独立产品的调研分析\n" +
                    "\n" +
                    "　　产品形态一般只有一个，但是产品的核心业务逻辑却往往有多条，产品的业务流程，就是产品的功能模块。一个产品，是由一个个相互看似独立却有交织的逻辑关系的功能模块架构而成的。\n" +
                    "\n" +
                    "　　一流的产品经理，通过一个产品，可以看透一个行业。二流的产品经理，通过产品的迭代，看透产品的业务逻辑。三流的产品经理，通过产品的功能，看产品的表现。\n" +
                    "\n" +
                    "　　3. 完整的产品调研流程\n" +
                    "\n" +
                    "　　产品调研不等同于行业调研，更不是什么产品体验。一份完整的产品调研主要包括以下几个方面：\n" +
                    "\n" +
                    "　　调研背景\n" +
                    "\n" +
                    "　　所谓调研背景，就是我们为什么要进行调研?是因为产品设计需要我们去了解同类型产品，还是出于自我兴趣能力提升。\n" +
                    "\n" +
                    "　　调研目的\n" +
                    "\n" +
                    "　　调研目的，即希望通过调研得到的结果是什么?从而可以根据调研得出的结果，对产品策略下一步的制定给出指导意义。很多时候，产品经理提到调研，结果往往变成了针对一个行业的调研，调研的问题大而全，这样的产品调研并没有什么意义。针对行业的调研是付费公司干的事情，好的产品调研一定是聚焦的，能够得出明确结果的。比如调研“淘宝和亚马逊的区别”就远不如调研“淘宝和亚马逊支付流程差异对比”来得有意义。\n" +
                    "\n" +
                    "　　选择产品\n" +
                    "\n" +
                    "　　选择产品，一般有三到四款产品就足够了。根据要调研的问题，选择和问题契合的核心流程做得出色的产品。一款该行业的龙头产品，两到三款黑马产品。\n" +
                    "\n" +
                    "　　体验产品\n" +
                    "\n" +
                    "　　产品体验，最重要的还是产品设计的三要素：用户、场景、需求。分析目标用户是谁?使用场景是什么?满足了用户哪些需求?\n" +
                    "\n" +
                    "　　在这一步，从用户的视角出发，去解读产品很有必要。特别是从用户的视角出发，去找产品实现逻辑，而不是从产品的角度出发。\n" +
                    "\n" +
                    "　　还原产品\n" +
                    "\n" +
                    "　　很多产品经理在还原产品时，把焦点放在产品的界面交互或者功能实现上，这个方向本身就是错误的。真正的还原产品，是重点关注如何满足用户需求的。换句话说，还原产品的核心流程才是最重要的。\n" +
                    "\n" +
                    "　　从核心流程出发，找核心的页面，从而窥到产品的整体结构，这才是最重要的。切记还原产品就是在还原产品实现的逻辑，就是在还原流程。\n" +
                    "\n" +
                    "　　分析产品\n" +
                    "\n" +
                    "　　分析产品有五个维度。即产品信息架构、产品业务逻辑、产品迭代过程、产品的数据表现、产品的运营动作。\n" +
                    "\n" +
                    "　　从产品迭代可以分析一款产品的发展轨迹，从而有效避免自己产品一些错误的做法。从运营动作，可以发现产品的表现和重要程度。从产品的信息架构可以了解产品的整体构建思路，从产品的数据表现，可以了解产品的版本与用户数量之间的关系。\n" +
                    "\n" +
                    "　　得出结论\n" +
                    "\n" +
                    "　　通过上述一系列的分析，得出产品调研分析的结论。从而指导下一步产品的设计决策。\n" +
                    "\n" +
                    "　　撰写报告\n" +
                    "\n" +
                    "　　产品调研报告，要不带个人的感情色彩，也无须一定要给出改进建议。重点是得出明确的结论，并给出结论和分析过程之间的联系。\n" +
                    "\n" +
                    "　　用户为什么要用你的产品呢?这本身就是一个真实而具体的问题。作为产品经理，不论是做产品功能的调研也好，独立产品的调研也罢，不要为了调研而调研，更不要去做一些没有任何焦点的无意义的事情。目标明确，结论明确，本身才是最重要的。");

            News new3 = new News();
            new3.setTitle("百度外卖“卖身”顺丰?据说双方已经接触一年多");
            new3.setContent("5月7日消息，继去年8月初，有消息称百度外卖连同糯米将打包卖给美团之后，现又传出百度外卖要卖身顺丰，据说双方已经接触一年多时间。\n" +
                    "\n" +
                    "百度外卖“卖身”顺丰?据说双方已经接触一年多\n" +
                    "　　百度外卖“卖身”顺丰?据说双方已经接触一年多\n" +
                    "\n" +
                    "　　另据报道，虽然双方接触时间比较长，但一直没有进入实质性阶段。直到两个月之前，双方洽谈的都是融资而非“卖身”，融资金额在2亿美元上下，此外还包含顺丰和百度集团签署的一揽子协议。\n" +
                    "\n" +
                    "　　对于烧钱的O2O行业来说，百度外卖在融资方面进行的也不顺利。A轮2.5亿美元融资之后，百度的B轮融资一拖再拖，虽然最终成功完成了融资，但其背后的主要投资方却是百度公司。所谓羊毛出在羊身上，大抵就是如此吧。\n" +
                    "\n" +
                    "　　自掏腰包的百度虽然暂时拯救了自家的外卖事业，但彼时百度外卖的估值已经被下调至24亿美元。有业内人士认为，百度外卖和糯米的估值打包起来都不可能超过50亿美元，其中百度外卖的估值可能已经降到了15亿美元。\n" +
                    "\n" +
                    "　　根据比达咨询最新发布的统计数据显示，百度外卖在外卖O2O领域已经开始掉队，从2016年全年来看，饿了么占整体外卖市场份额的34.6%，美团外卖、百度外卖则分别以33.6%、 18.5%的份额位居第二和第三。\n" +
                    "\n" +
                    "　　另外，艾媒咨询发布的2016年第四季度数据则显示，美团外卖、饿了么、百度外卖共占据市场份额为94.1%，其中，美团外卖 市场份额为40.7%，饿了么为35%，百度外卖为18.4%。\n" +
                    "\n" +
                    "　　而百度外卖近日屡次传出的离职风波也再次印证了其内部的经营没有那么容易。5月4日，百度外卖副总裁陈锦晖通过微信朋友圈宣布离职，而在此之前，百度外卖内部裁员的消息就已经屡次传出。\n" +
                    "\n" +
                    "　　据悉，百度外卖在北上广等一线城市采取自营方式，在三四线城市的地推策略是把多个城市的线下地推工作分派给各地代理商。2月份传出，百度外卖渠道部计划要裁员40%左右，北京的市场部门裁员30%左右。\n" +
                    "\n" +
                    "　　事实上，关于百度外卖的风波从去年8月就已开始，当时有传言称，百度外卖和百度糯米将与美团点评合并，当时百度予以否认。随后，又有传言称，此次百度外卖和糯米注入美团后，会由美团接管其团队，百度控制部分股权。\n" +
                    "\n" +
                    "　　最终，百度外卖CEO巩振兵发出内部邮件，否认出售、合并传闻，称将坚持独立运营。\n" +
                    "\n" +
                    "　　此前，李彦宏在接受媒体采访时曾表示，对于O2O业务的成绩“不能说完全满意”，“如果真的做不过，就不做，该做的决断也要做。”\n" +
                    "\n" +
                    "　　此外，李彦宏已经在公开场合多次强调，百度未来的业务重心是人工智能。在百度最新的财报中，百度季度营收为人民币168.91亿元，同比增长6.8%，百度大力发展的人工智能将会给百度未来的业务发展提供新的增长动力。");

            News new4 = new News();
            new4.setTitle("“互联网+”背后的本质到底是什么？");
            new4.setContent("如今的互联网已经对传统行业产生了强烈的冲击，这一点，是显而易见的。首先被冲击的就是传统零售行业。传统零售行业尚不成熟，传统企业规模也不够强大，因此被 网购冲击得连连受挫，溃不成军。接踵而至的余额宝对银行也产生了 一定的影响，滴滴打车不断冲击出租车行业、更改用户习惯。其他的传统行业紧张了，警惕了，介入了，愿意接纳互联网了。各行各业都在思考如何添加上互联网元 素，找到企业发展的出路。\n" +
                    "\n" +
                    "那么，互联网为何有如此威力呢？它仅仅是一个工具吗？“互联网+”背后的本质又是什么呢？\n" +
                    "\n" +
                    "技术并没有本质革新，但数据化的世界让“互联网+”产生革命性的影响\n" +
                    "\n" +
                    "从 IT技术层面上看，我还未在互联网里看到历史性的创新技术，TCP/IP/HTTP与通信行业的协议及技术相比，简直弱爆了。TCP/IP/HTTP连服 务品质的保证都难以做到，而传统通信的服务质量（QOS）要求非常高，即使停电地震也要保证通讯质量。但是，互联网就是风起云涌，势不可挡。\n" +
                    "\n" +
                    "笔者认为，“互联网+”背后的本质是“数据的流动”。互联网让数据流动了起来，在企业，人，设备三者之间产生了自由流动，换言之，互联网通过数据把世界连接了起来。这是互联网带来的革命性变化！\n" +
                    "\n" +
                    "世界被数字化了， 企业，人和设备都开始生产数据并传播数据，互联网则让数字化的世界流动了起来。这些流动的数据孕育着巨大的商业价值，它们描述了这个世界，同时也影响和改 变这个世界。移动设备位置数据的产生，催生了LBS相关移动产品的创新，比如滴滴打车。人产生并传播数据，催生了自媒体，那些拥有众多铁杆粉丝的大号则具 有了极大的商业价值，比如罗辑思维，张德芬等大V。\n" +
                    "\n" +
                    "流动的数据，会产生什么影响呢？\n" +
                    "\n" +
                    "让我们再看看，流动的数据所带来的影响。\n" +
                    "\n" +
                    "首先，流动的数据消除了信息不对称。世 界被紧密地对接了起来，中间环节不再被需要，“中介”成了被革命的对象，靠信息垄断赚钱的时代即将过去。比如，网购成了人们重要的生活内容，阿里巴巴，京 东及唯品会等电商公司如日中天，正是因为电子商务使得品牌制造商与用户直接联系在了一起，砍去物流多次流转的层层环节，信息完全透明化了。\n" +
                    "\n" +
                    "其次，流动的数据破除了时间的限制。数据的流动在线化，数据可以7*24小时流动，而且信息是实时的。有着丰富夜生活的年轻人们有福了，下半夜“逛街购物”不是梦想而是唾手可得了。这些大大创造了新的商业需求。\n" +
                    "\n" +
                    "再次，流动的数据破除了空间的限制。互 联网天然具备面向线上所有的用户的特点，没有国家和地域的限制，不再像普通门店那样只服务一个区域。马路两侧的国美和苏宁都可以存活，因为过马路是有成本 的，顾客选择一家店，进去逛了，选中了，就付钱了。但是互联网上，网站间的转换成本非常低，只需要动一下鼠标，各种信息都可以看一遍，相互比较。这使得互 联网具有了一家独大的特性。\n" +
                    "\n" +
                    "最后，流动的数据也催生了时间的碎片化。人们在任何闲暇都可以上网，尤其是移动设备带来的便利性，这产生了“注意力经济”，哪个产品获取了更多的注意力，哪个产品就会受到青睐。\n" +
                    "\n" +
                    "流动的数据聚合需求，未来数据就是能源\n" +
                    "\n" +
                    "流动的数据对世界产生了深远的影响，那么它带来了什么样的商业价值？那就是“聚合”价值，流动的数据聚合了需求！中国有5亿多网民，各种看似不大的需求，乘 以庞大的网民数量，都是一个巨大的需求。例如特卖需求，在二三四线网民的热捧下，成就了千亿市值的互联网公司-唯品会。\n" +
                    "\n" +
                    "在此互联网大潮中，“互联网+”应运而生。 但是“+”这个提法会让人产生简单叠加的误解，我认为“互联网X”更能体现互联网的影响力，尤其对于传统企业来说，互联网带来的倍增或倍减的效应，而不是 简单叠加；互联网带来的是改革或革命，而不仅仅是改良，然后延续旧的生产模式；互联网带来的是撬动，是通过解决一个行业痛点来撬动整个行业，甚至挟君子 （用户）以令诸侯，而不仅仅是推动行业的进步；互联网带来的是组织结构的变革，人才变成了最重要的，吸引人才并打造一个商业模式的孵化器，这是企业做大做 强的保障，而不仅仅是强化和传承原来企业的成功。\n" +
                    "\n" +
                    "在互联网领域，BAT是三大巨头，也是三种模式的代表。百度主动收集了海量数据，为用户提供某种需求的“数据聚合”搜索；马化腾多次强调，腾讯致力于做数据 流动的“连接器”；阿里则是使用了零售领域的流动数据颠覆了传统零售，重构了整个行业，打造了一个零售商业帝国。未来，在各个规模较大的传统行业，如医 疗、农业、汽车等行业都有机会诞生阿里或者京东体量的公司。\n" +
                    "\n" +
                    "总之，互联网世界，三个月一小变，六个月一大变，我们要做的，就是拥抱变化。数据就是能源，拥有了数据就可以影响甚至改变一个产业的整个生态体系，甚至跨界颠覆多个产业，因为互联网是无边界的。");

            newsList.add(new1);
            newsList.add(new2);
            newsList.add(new3);
            newsList.add(new4);
        }
        return newsList;
    }

    private String randomName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

    /**
     * 以下为Adapter的代码
     */
    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private List<News> mNewsList;

        public NewsAdapter(List<News> NewsList) {
            this.mNewsList = NewsList;
        }

        //得到子项布局组件
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView title;

            public ViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.tv_news_title);
            }
        }

        //获取子项布局
        @Override
        public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_title_item, parent, false);
            final ViewHolder viewHolder = new ViewHolder(view);
            //子项点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(viewHolder.getAdapterPosition());
                    //如果为平板
                    if (isTwoPane) {
                        FragmentManager fragmentManager = getFragmentManager();
                        NewsContentFrag frag = (NewsContentFrag) fragmentManager.findFragmentById(R.id.news_content_layout);
                        frag.refreshContent(news.getTitle(),news.getContent());
                    } else {
                        //如果不为平板
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(getContext(),"da",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            return viewHolder;
        }

        //绑定数据
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.title.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }
}
