#2.23
    开发至 dailyCard
    要实现动态切换，就必须将tag和trend 或者只有 trend 利用fragment替换。
    另一个点子

    不需要fragment，只需要将trend的adapter写好，类似mainAdapter，根据viewType来判定
    所以还需要将 temp humidity, ... 做成viewType
    还要写相应的ViewHolder
        TempTrendViewHolder
        HumidityTrendViewHolder


#2.24 dailyCard 切换，湿度，空气质量item还没做，切换功能已经完成。

    完成湿度，空气质量item布局
    湿度怎么更直观的显示降水量，查看官方api文档。
    空气质量同。
    完成后就继续做 hourlyCard。
    喝点小酒，吃点夜宵，在来。

#2.25 凌晨3:12 完成 dailyCard, hourlyCard,并且完成 状态栏&小白条的适配。
    下一步：
        1.dailyItem里面的tagButton 换成 TextView吧，背景色才不会那么奇怪
    
        2.toolbar上面的图标颜色太深，深背景下不容易看清，需解决。
        
        3.查找页面（读入那个文档，才能匹配地方经纬度）

        4.设置页面

        5.美化: header上面的icon可以更换为颜色更加丰富的icon