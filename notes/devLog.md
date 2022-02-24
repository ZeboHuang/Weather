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