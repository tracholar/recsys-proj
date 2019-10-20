# 推荐系统框架结构设计图

框架所在包名 `com.tracholar.recommend`，各子模块说明如下。

- data 基础数据结构接口的定义
    - `IUser` 定义用户结构，至少要有用户id，具体实现子类需实现这个接口
    - `IItem` 定义推荐的item
    - `IContext` 定义上下文
    - `RecallResult` 定义召回的结果
    - `RankResult` 定义排序和重排序后的结果
- engine 推荐引擎的定义和实现
    - 基础模块的定义
        1. `Recall` 定义召回子模块的接口: (user, ctx) -> list<recall-result>
        2. `Filter` 定义召回后过滤子模块的接口： list<recall-result> -> list<recall-result>
        3. `Merge` 定义多路召回后的合并模块 map<recall, recall-result> -> list<recall-result>
        4. `Ranker` 定义排序模块 (user, ctx, list<recall-result>) -> list<rank-result>
        5. `ReRanker` 定义重排序模块  (user, ctx, list<rank-result>) -> list<rank-result>
        6. `DetailFetcher` 定义取详情模块 list<rank-result> -> list<item> 这里取详情模块设计得更通用
    - 引擎的定义
        - `RecEngine` 定义推荐引擎 (user, ctx) -> list<item>
        - `SimpleRecEngine` 定义了6阶段推荐引擎，如何符合这6阶段的推荐系统，可以继承这个类，如果不符合请参考这个类实现 `RecEngine` 接口
        - `ConfigurableSimpleRecEngine` 定义了可配置的6阶段推荐引擎，可以直接使用，请通过`init`方法来初始化推荐引擎。如果不想通过配置来初始化，可以继承  `SimpleRecEngine` 自己实现一套初始化方法
            - `RecEngineConfig` 是引擎的配置结构
            - `ComponentConfig` 是每个子模块的配置结构
        - `JsonConfigRecEngine` 定义了通过JSON配置文件来初始化推荐引擎，通过 `JsonConfigRecEngine.load(<args>)` 创建一个推荐引擎。如果想通过其他类型配置文件初始化推荐系统，请参考 `ConfigurableSimpleRecEngine` 自己实现一个配置文件解析来初始化推荐引擎
- 模型和排序的定义
    - 特征的设计
        - `Feature`
        