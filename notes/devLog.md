#2.23
    开发至 dailyCard
    要实现动态切换，就必须将tag和trend 或者只有 trend 利用fragment替换。
    另一个点子
    不需要fragment，只需要将trend的adapter写好，类似mainAdapter，根据viewType来判定
    所以还需要将 temp humidity, ... 做成viewType
    还要写相应的ViewHolder
        TempTrendViewHolder
        HumidityTrendViewHolder

