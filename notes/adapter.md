# 主页面里使用MainAdapter
# 一个RecyclerView 里面实现多个ViewHolder
    数据绑定在各自的ViewHolder类的onBindView，为了方便拓展，这些ViewHolder都继承自同意抽象类AbstractViewHolder
    视图绑定时也是在各自的ViewHolder里，inflate填充各自的xml布局文件。

    对《几何天气》源码中学到的一点：ViewHolder中定义两种属性。
        一是，数据类型的属性。int型的温度等
        二是，试图类型的属性。最终的视图控件TextView等
        再将数据绑定到视图控件上。