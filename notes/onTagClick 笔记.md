# OnTagClickListener 接口
    onTagClick(int tagType)

# 作用
    当tagView的item被点击之后，相应的trendView里面的Item会发生变化。
    例如，“空气质量”被点击后，下面的RecyclerView内容会变成空气质量（趋势图/柱状图...）
# 实现
    对tagItemViewHolder (其包含一个按钮) 中的该按钮实现点击功能，
    由于实在DailyViewHolder里面定义这两个tagView, trendView 所以最后也由DailyViewHolder将点击的tagItem的ViewType传给
    trendView,然后trendView再进行刷新，完成类似卡片的动态切换。

    tagViewHolder点击
    DailyTrendAdapter，内含mItemViewType属性，进行点击后的更改，提供get/set此属性的方法。
    DailyViewHolder 实现OnTagClickListener接口，并记录tagViewType，传给trendView
    对 trendView.setmTagItemViewType(),该方法里面再进行刷新。