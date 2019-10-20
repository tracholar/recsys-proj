# 推荐系统框架

参考执行 `com.tracholar.recommend.demo.DemoSimpleRecEngine`

# 教程
这个教程以 `com.tracholar.articlesys` 包为例，实现一个文章推荐系统。
1. 定义你的数据结构
    1. 需要定义的基础数据结构有 `IUser`, `IItem`, `IContext` 分别代表推荐系统中的用户、item和上下文。请参考 `Article` `User` `ReqContext` 的实现
    2. 需要定义的中间数据结构有 `RecallResult`, `RankerResult`，分别代表召回/过滤阶段的数据和排序/混排阶段的数据。这里全部实现为 `Article` 
    3. 一般情况下上述5个数据结构需要分开实现，在这个例子中将 `IItem` 、 `RecallResult` 和 `RankerResult` 都实现为一个类 `Article` 充分复用。
2. 定义必须的算子
    1. 召回，参考 `TimeRecall`
    2. 过滤，参考 `HistoryFilter`
    3. 排序，参考 `RandomRanker`。如果使用模型
    4. 混排，参考 `RandomRanker` 同上，将排序和混排实现为同一个类。这就是用接口抽象的好处，你甚至可以将这4
    个阶段都实现为同一个类，组成一个独立的策略！！当然，一般的推荐这几个阶段是完全独立的，不建议这么做，但某些特殊场景下，某几个阶段不是独立的，这么做就便于实际的策略开发！
3. 定义ab测试模块实现`ABTestProxy`接口，参考 `ABTest`， 实现用户和流量的匹配 
4. 定义详情获取模块，参考 `ArticleFetcher`，取详情
5. 组装一个推荐引擎，框架实现了一个基于json配置的引擎 `ConfigurableSimpleRecEngine`，配置参考 `resource/article-rec-sys/engin.json
`，只要在继承的类 `ArticleRecEngine`构造函数中，调用父类的 `init(is)`方法，用指定的配置文件初始化即可！

- 问题：召回、排序等策略如何做AB测试？
- 在实现这些策略的时候，请实现 `ABTestable` 接口，并在对应的策略配置文件中配置 `abtestLayerKey` 和 `abtestFlowKey` 这两个key会作为 `ABTestKey
` 对象传给 `ABTestProxy`，用于判断该用户在当前请求中是否匹配这个策略！



# 作业
- 注意事项：请在自己的包下开发

## 作业一：实现一个新闻推荐系统
- 新闻需要有：标题，作者，发布时间，页面的URL等信息
- 需要过滤掉用户已经看过的新闻列表


## 作业二：实现一个图片推荐系统
- 图片需要有：URL，尺寸，大小，标签等信息
